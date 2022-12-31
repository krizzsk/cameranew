package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.observables.GroupedObservable;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;
/* loaded from: classes3.dex */
public class OperatorGroupBy<T, K, R> implements Observable.Operator<GroupedObservable<K, R>, T> {
    private static final Func1<Object, Object> IDENTITY = new Func1<Object, Object>() { // from class: rx.internal.operators.OperatorGroupBy.1
        @Override // rx.functions.Func1
        public Object call(Object obj) {
            return obj;
        }
    };
    private static final Object NULL_KEY = new Object();
    final Func1<? super T, ? extends K> keySelector;
    final Func1<? super T, ? extends R> valueSelector;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class GroupBySubscriber<K, T, R> extends Subscriber<T> {
        private static final int MAX_QUEUE_SIZE = 1024;
        private static final int TERMINATED_WITH_COMPLETED = 1;
        private static final int TERMINATED_WITH_ERROR = 2;
        private static final int UNTERMINATED = 0;
        volatile long bufferedCount;
        final Subscriber<? super GroupedObservable<K, R>> child;
        volatile int completionEmitted;
        final Func1<? super T, ? extends R> elementSelector;
        final Func1<? super T, ? extends K> keySelector;
        volatile long requested;
        static final AtomicIntegerFieldUpdater<GroupBySubscriber> WIP_FOR_UNSUBSCRIBE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "wipForUnsubscribe");
        private static final NotificationLite<Object> nl = NotificationLite.instance();
        static final AtomicIntegerFieldUpdater<GroupBySubscriber> COMPLETION_EMITTED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "completionEmitted");
        static final AtomicIntegerFieldUpdater<GroupBySubscriber> TERMINATED_UPDATER = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "terminated");
        static final AtomicLongFieldUpdater<GroupBySubscriber> REQUESTED = AtomicLongFieldUpdater.newUpdater(GroupBySubscriber.class, "requested");
        static final AtomicLongFieldUpdater<GroupBySubscriber> BUFFERED_COUNT = AtomicLongFieldUpdater.newUpdater(GroupBySubscriber.class, "bufferedCount");
        final GroupBySubscriber<K, T, R> self = this;
        volatile int wipForUnsubscribe = 1;
        private final ConcurrentHashMap<Object, GroupState<K, T>> groups = new ConcurrentHashMap<>();
        volatile int terminated = 0;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static class GroupState<K, T> {
            private final Queue<Object> buffer;
            private final AtomicLong count;
            private final AtomicLong requested;
            private final Subject<T, T> s;

            private GroupState() {
                this.s = BufferUntilSubscriber.create();
                this.requested = new AtomicLong();
                this.count = new AtomicLong();
                this.buffer = new ConcurrentLinkedQueue();
            }

            public Observable<T> getObservable() {
                return this.s;
            }

            public Observer<T> getObserver() {
                return this.s;
            }
        }

        public GroupBySubscriber(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends R> func12, Subscriber<? super GroupedObservable<K, R>> subscriber) {
            this.keySelector = func1;
            this.elementSelector = func12;
            this.child = subscriber;
            subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorGroupBy.GroupBySubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    if (GroupBySubscriber.WIP_FOR_UNSUBSCRIBE_UPDATER.decrementAndGet(GroupBySubscriber.this.self) == 0) {
                        GroupBySubscriber.this.self.unsubscribe();
                    }
                }
            }));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanupGroup(Object obj) {
            GroupState<K, T> remove = this.groups.remove(obj);
            if (remove != null) {
                if (!((GroupState) remove).buffer.isEmpty()) {
                    BUFFERED_COUNT.addAndGet(this.self, -((GroupState) remove).buffer.size());
                }
                completeInner();
                requestMoreIfNecessary();
            }
        }

        private void completeInner() {
            if (WIP_FOR_UNSUBSCRIBE_UPDATER.decrementAndGet(this) == 0) {
                unsubscribe();
            } else if (this.groups.isEmpty() && this.terminated == 1 && COMPLETION_EMITTED_UPDATER.compareAndSet(this, 0, 1)) {
                this.child.onCompleted();
            }
        }

        private GroupState<K, T> createNewGroup(final Object obj) {
            int i2;
            final GroupState<K, T> groupState = new GroupState<>();
            GroupedObservable create = GroupedObservable.create(getKey(obj), new Observable.OnSubscribe<R>() { // from class: rx.internal.operators.OperatorGroupBy.GroupBySubscriber.2
                @Override // rx.functions.Action1
                public /* bridge */ /* synthetic */ void call(Object obj2) {
                    call((Subscriber) ((Subscriber) obj2));
                }

                public void call(final Subscriber<? super R> subscriber) {
                    subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorGroupBy.GroupBySubscriber.2.1
                        @Override // rx.Producer
                        public void request(long j2) {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            GroupBySubscriber.this.requestFromGroupedObservable(j2, groupState);
                        }
                    });
                    final AtomicBoolean atomicBoolean = new AtomicBoolean();
                    groupState.getObservable().doOnUnsubscribe(new Action0() { // from class: rx.internal.operators.OperatorGroupBy.GroupBySubscriber.2.3
                        @Override // rx.functions.Action0
                        public void call() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                GroupBySubscriber.this.cleanupGroup(obj);
                            }
                        }
                    }).unsafeSubscribe((Subscriber<T>) new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorGroupBy.GroupBySubscriber.2.2
                        @Override // rx.Observer
                        public void onCompleted() {
                            subscriber.onCompleted();
                            if (atomicBoolean.compareAndSet(false, true)) {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                GroupBySubscriber.this.cleanupGroup(obj);
                            }
                        }

                        @Override // rx.Observer
                        public void onError(Throwable th) {
                            subscriber.onError(th);
                            if (atomicBoolean.compareAndSet(false, true)) {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                GroupBySubscriber.this.cleanupGroup(obj);
                            }
                        }

                        @Override // rx.Observer
                        public void onNext(T t) {
                            try {
                                subscriber.onNext(GroupBySubscriber.this.elementSelector.call(t));
                            } catch (Throwable th) {
                                Exceptions.throwOrReport(th, this, t);
                            }
                        }
                    });
                }
            });
            do {
                i2 = this.wipForUnsubscribe;
                if (i2 <= 0) {
                    return null;
                }
            } while (!WIP_FOR_UNSUBSCRIBE_UPDATER.compareAndSet(this, i2, i2 + 1));
            if (this.groups.putIfAbsent(obj, groupState) == null) {
                this.child.onNext(create);
                return groupState;
            }
            throw new IllegalStateException("Group already existed while creating a new one");
        }

        private void drainIfPossible(GroupState<K, T> groupState) {
            Object poll;
            while (((GroupState) groupState).requested.get() > 0 && (poll = ((GroupState) groupState).buffer.poll()) != null) {
                nl.accept(groupState.getObserver(), poll);
                if (((GroupState) groupState).requested.get() != LocationRequestCompat.PASSIVE_INTERVAL) {
                    ((GroupState) groupState).requested.decrementAndGet();
                }
                BUFFERED_COUNT.decrementAndGet(this);
                requestMoreIfNecessary();
            }
        }

        private void emitItem(GroupState<K, T> groupState, Object obj) {
            Queue queue = ((GroupState) groupState).buffer;
            AtomicLong atomicLong = ((GroupState) groupState).requested;
            REQUESTED.decrementAndGet(this);
            if (atomicLong != null && atomicLong.get() > 0 && (queue == null || queue.isEmpty())) {
                nl.accept(groupState.getObserver(), obj);
                if (atomicLong.get() != LocationRequestCompat.PASSIVE_INTERVAL) {
                    atomicLong.decrementAndGet();
                }
            } else {
                queue.add(obj);
                BUFFERED_COUNT.incrementAndGet(this);
                if (((GroupState) groupState).count.getAndIncrement() == 0) {
                    pollQueue(groupState);
                }
            }
            requestMoreIfNecessary();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private K getKey(Object obj) {
            if (obj == OperatorGroupBy.NULL_KEY) {
                return null;
            }
            return obj;
        }

        private Object groupedKey(K k2) {
            return k2 == null ? OperatorGroupBy.NULL_KEY : k2;
        }

        private void pollQueue(GroupState<K, T> groupState) {
            do {
                drainIfPossible(groupState);
                if (((GroupState) groupState).count.decrementAndGet() > 1) {
                    ((GroupState) groupState).count.set(1L);
                }
            } while (((GroupState) groupState).count.get() > 0);
        }

        private void requestMoreIfNecessary() {
            AtomicLongFieldUpdater<GroupBySubscriber> atomicLongFieldUpdater = REQUESTED;
            if (atomicLongFieldUpdater.get(this) == 0 && this.terminated == 0) {
                long j2 = 1024 - BUFFERED_COUNT.get(this);
                if (j2 <= 0 || !atomicLongFieldUpdater.compareAndSet(this, 0L, j2)) {
                    return;
                }
                request(j2);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (TERMINATED_UPDATER.compareAndSet(this, 0, 1)) {
                for (GroupState<K, T> groupState : this.groups.values()) {
                    emitItem(groupState, nl.completed());
                }
                if (this.groups.isEmpty() && COMPLETION_EMITTED_UPDATER.compareAndSet(this, 0, 1)) {
                    this.child.onCompleted();
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (TERMINATED_UPDATER.compareAndSet(this, 0, 2)) {
                for (GroupState<K, T> groupState : this.groups.values()) {
                    emitItem(groupState, nl.error(th));
                }
                try {
                    this.child.onError(th);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            try {
                Object groupedKey = groupedKey(this.keySelector.call(t));
                GroupState<K, T> groupState = this.groups.get(groupedKey);
                if (groupState == null) {
                    if (this.child.isUnsubscribed()) {
                        return;
                    }
                    groupState = createNewGroup(groupedKey);
                }
                if (groupState != null) {
                    emitItem(groupState, nl.next(t));
                }
            } catch (Throwable th) {
                Exceptions.throwOrReport(th, this, t);
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            REQUESTED.set(this, 1024L);
            request(1024L);
        }

        void requestFromGroupedObservable(long j2, GroupState<K, T> groupState) {
            BackpressureUtils.getAndAddRequest(((GroupState) groupState).requested, j2);
            if (((GroupState) groupState).count.getAndIncrement() == 0) {
                pollQueue(groupState);
            }
        }
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1) {
        this(func1, IDENTITY);
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends R> func12) {
        this.keySelector = func1;
        this.valueSelector = func12;
    }

    public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, R>> subscriber) {
        return new GroupBySubscriber(this.keySelector, this.valueSelector, subscriber);
    }
}
