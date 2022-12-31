package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.operators.NotificationLite;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Timestamped;
import rx.subjects.SubjectSubscriptionManager;
/* loaded from: classes3.dex */
public final class ReplaySubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    final SubjectSubscriptionManager<T> ssm;
    final ReplayState<T, ?> state;

    /* loaded from: classes3.dex */
    static final class AddTimestamped implements Func1<Object, Object> {
        final Scheduler scheduler;

        public AddTimestamped(Scheduler scheduler) {
            this.scheduler = scheduler;
        }

        @Override // rx.functions.Func1
        public Object call(Object obj) {
            return new Timestamped(this.scheduler.now(), obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class BoundedState<T> implements ReplayState<T, NodeList.Node<Object>> {
        final Func1<Object, Object> enterTransform;
        final EvictionPolicy evictionPolicy;
        final Func1<Object, Object> leaveTransform;
        final NodeList<Object> list;
        final NotificationLite<T> nl = NotificationLite.instance();
        volatile NodeList.Node<Object> tail;
        volatile boolean terminated;

        public BoundedState(EvictionPolicy evictionPolicy, Func1<Object, Object> func1, Func1<Object, Object> func12) {
            NodeList<Object> nodeList = new NodeList<>();
            this.list = nodeList;
            this.tail = nodeList.tail;
            this.evictionPolicy = evictionPolicy;
            this.enterTransform = func1;
            this.leaveTransform = func12;
        }

        public void accept(Observer<? super T> observer, NodeList.Node<Object> node) {
            this.nl.accept(observer, this.leaveTransform.call(node.value));
        }

        public void acceptTest(Observer<? super T> observer, NodeList.Node<Object> node, long j2) {
            Object obj = node.value;
            if (this.evictionPolicy.test(obj, j2)) {
                return;
            }
            this.nl.accept(observer, this.leaveTransform.call(obj));
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public void complete() {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            this.list.addLast(this.enterTransform.call(this.nl.completed()));
            this.evictionPolicy.evictFinal(this.list);
            this.tail = this.list.tail;
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public void error(Throwable th) {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            this.list.addLast(this.enterTransform.call(this.nl.error(th)));
            this.evictionPolicy.evictFinal(this.list);
            this.tail = this.list.tail;
        }

        public NodeList.Node<Object> head() {
            return this.list.head;
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public boolean isEmpty() {
            NodeList.Node<Object> node = head().next;
            if (node == null) {
                return true;
            }
            Object call = this.leaveTransform.call(node.value);
            return this.nl.isError(call) || this.nl.isCompleted(call);
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public T latest() {
            NodeList.Node<Object> node = head().next;
            if (node == null) {
                return null;
            }
            NodeList.Node<Object> node2 = null;
            while (node != tail()) {
                node2 = node;
                node = node.next;
            }
            Object call = this.leaveTransform.call(node.value);
            if (this.nl.isError(call) || this.nl.isCompleted(call)) {
                if (node2 != null) {
                    return this.nl.getValue(this.leaveTransform.call(node2.value));
                }
                return null;
            }
            return this.nl.getValue(call);
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public void next(T t) {
            if (this.terminated) {
                return;
            }
            this.list.addLast(this.enterTransform.call(this.nl.next(t)));
            this.evictionPolicy.evict(this.list);
            this.tail = this.list.tail;
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver) {
            synchronized (subjectObserver) {
                subjectObserver.first = false;
                if (subjectObserver.emitting) {
                    return false;
                }
                subjectObserver.index(replayObserverFromIndex((NodeList.Node) subjectObserver.index(), (SubjectSubscriptionManager.SubjectObserver) subjectObserver));
                return true;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public int size() {
            NodeList.Node<Object> node;
            Object call;
            NodeList.Node<Object> head = head();
            NodeList.Node<Object> node2 = head.next;
            int i2 = 0;
            while (true) {
                NodeList.Node<Object> node3 = node2;
                node = head;
                head = node3;
                if (head == null) {
                    break;
                }
                i2++;
                node2 = head.next;
            }
            Object obj = node.value;
            return (obj == null || (call = this.leaveTransform.call(obj)) == null) ? i2 : (this.nl.isError(call) || this.nl.isCompleted(call)) ? i2 - 1 : i2;
        }

        public NodeList.Node<Object> tail() {
            return this.tail;
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public boolean terminated() {
            return this.terminated;
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (NodeList.Node node = head().next; node != null; node = node.next) {
                Object call = this.leaveTransform.call(node.value);
                if (node.next == null && (this.nl.isError(call) || this.nl.isCompleted(call))) {
                    break;
                }
                arrayList.add(call);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public NodeList.Node<Object> replayObserverFromIndex(NodeList.Node<Object> node, SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver) {
            while (node != tail()) {
                accept(subjectObserver, node.next);
                node = node.next;
            }
            return node;
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public NodeList.Node<Object> replayObserverFromIndexTest(NodeList.Node<Object> node, SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver, long j2) {
            while (node != tail()) {
                acceptTest(subjectObserver, node.next, j2);
                node = node.next;
            }
            return node;
        }
    }

    /* loaded from: classes3.dex */
    static final class DefaultOnAdd<T> implements Action1<SubjectSubscriptionManager.SubjectObserver<T>> {
        final BoundedState<T> state;

        public DefaultOnAdd(BoundedState<T> boundedState) {
            this.state = boundedState;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) obj));
        }

        public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
            BoundedState<T> boundedState = this.state;
            subjectObserver.index(boundedState.replayObserverFromIndex(boundedState.head(), (SubjectSubscriptionManager.SubjectObserver) subjectObserver));
        }
    }

    /* loaded from: classes3.dex */
    static final class EmptyEvictionPolicy implements EvictionPolicy {
        EmptyEvictionPolicy() {
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public void evict(NodeList<Object> nodeList) {
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public void evictFinal(NodeList<Object> nodeList) {
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public boolean test(Object obj, long j2) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface EvictionPolicy {
        void evict(NodeList<Object> nodeList);

        void evictFinal(NodeList<Object> nodeList);

        boolean test(Object obj, long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class NodeList<T> {
        final Node<T> head;
        int size;
        Node<T> tail;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class Node<T> {
            volatile Node<T> next;
            final T value;

            Node(T t) {
                this.value = t;
            }
        }

        NodeList() {
            Node<T> node = new Node<>(null);
            this.head = node;
            this.tail = node;
        }

        public void addLast(T t) {
            Node<T> node = this.tail;
            Node<T> node2 = new Node<>(t);
            node.next = node2;
            this.tail = node2;
            this.size++;
        }

        public void clear() {
            this.tail = this.head;
            this.size = 0;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public T removeFirst() {
            if (this.head.next != null) {
                Node<T> node = this.head.next;
                this.head.next = node.next;
                if (this.head.next == null) {
                    this.tail = this.head;
                }
                this.size--;
                return node.value;
            }
            throw new IllegalStateException("Empty!");
        }

        public int size() {
            return this.size;
        }
    }

    /* loaded from: classes3.dex */
    static final class PairEvictionPolicy implements EvictionPolicy {
        final EvictionPolicy first;
        final EvictionPolicy second;

        public PairEvictionPolicy(EvictionPolicy evictionPolicy, EvictionPolicy evictionPolicy2) {
            this.first = evictionPolicy;
            this.second = evictionPolicy2;
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public void evict(NodeList<Object> nodeList) {
            this.first.evict(nodeList);
            this.second.evict(nodeList);
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public void evictFinal(NodeList<Object> nodeList) {
            this.first.evictFinal(nodeList);
            this.second.evictFinal(nodeList);
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public boolean test(Object obj, long j2) {
            return this.first.test(obj, j2) || this.second.test(obj, j2);
        }
    }

    /* loaded from: classes3.dex */
    static final class RemoveTimestamped implements Func1<Object, Object> {
        RemoveTimestamped() {
        }

        @Override // rx.functions.Func1
        public Object call(Object obj) {
            return ((Timestamped) obj).getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface ReplayState<T, I> {
        void complete();

        void error(Throwable th);

        boolean isEmpty();

        T latest();

        void next(T t);

        boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver);

        I replayObserverFromIndex(I i2, SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver);

        I replayObserverFromIndexTest(I i2, SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver, long j2);

        int size();

        boolean terminated();

        T[] toArray(T[] tArr);
    }

    /* loaded from: classes3.dex */
    static final class SizeEvictionPolicy implements EvictionPolicy {
        final int maxSize;

        public SizeEvictionPolicy(int i2) {
            this.maxSize = i2;
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public void evict(NodeList<Object> nodeList) {
            while (nodeList.size() > this.maxSize) {
                nodeList.removeFirst();
            }
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public void evictFinal(NodeList<Object> nodeList) {
            while (nodeList.size() > this.maxSize + 1) {
                nodeList.removeFirst();
            }
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public boolean test(Object obj, long j2) {
            return false;
        }
    }

    /* loaded from: classes3.dex */
    static final class TimeEvictionPolicy implements EvictionPolicy {
        final long maxAgeMillis;
        final Scheduler scheduler;

        public TimeEvictionPolicy(long j2, Scheduler scheduler) {
            this.maxAgeMillis = j2;
            this.scheduler = scheduler;
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public void evict(NodeList<Object> nodeList) {
            long now = this.scheduler.now();
            while (!nodeList.isEmpty() && test(nodeList.head.next.value, now)) {
                nodeList.removeFirst();
            }
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public void evictFinal(NodeList<Object> nodeList) {
            long now = this.scheduler.now();
            while (nodeList.size > 1 && test(nodeList.head.next.value, now)) {
                nodeList.removeFirst();
            }
        }

        @Override // rx.subjects.ReplaySubject.EvictionPolicy
        public boolean test(Object obj, long j2) {
            return ((Timestamped) obj).getTimestampMillis() <= j2 - this.maxAgeMillis;
        }
    }

    /* loaded from: classes3.dex */
    static final class TimedOnAdd<T> implements Action1<SubjectSubscriptionManager.SubjectObserver<T>> {
        final Scheduler scheduler;
        final BoundedState<T> state;

        public TimedOnAdd(BoundedState<T> boundedState, Scheduler scheduler) {
            this.state = boundedState;
            this.scheduler = scheduler;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) obj));
        }

        public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
            NodeList.Node<Object> replayObserverFromIndex;
            if (!this.state.terminated) {
                BoundedState<T> boundedState = this.state;
                replayObserverFromIndex = boundedState.replayObserverFromIndexTest(boundedState.head(), (SubjectSubscriptionManager.SubjectObserver) subjectObserver, this.scheduler.now());
            } else {
                BoundedState<T> boundedState2 = this.state;
                replayObserverFromIndex = boundedState2.replayObserverFromIndex(boundedState2.head(), (SubjectSubscriptionManager.SubjectObserver) subjectObserver);
            }
            subjectObserver.index(replayObserverFromIndex);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class UnboundedReplayState<T> extends AtomicInteger implements ReplayState<T, Integer> {
        private final ArrayList<Object> list;
        private final NotificationLite<T> nl = NotificationLite.instance();
        private volatile boolean terminated;

        public UnboundedReplayState(int i2) {
            this.list = new ArrayList<>(i2);
        }

        public void accept(Observer<? super T> observer, int i2) {
            this.nl.accept(observer, this.list.get(i2));
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public void complete() {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            this.list.add(this.nl.completed());
            getAndIncrement();
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public void error(Throwable th) {
            if (this.terminated) {
                return;
            }
            this.terminated = true;
            this.list.add(this.nl.error(th));
            getAndIncrement();
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public T latest() {
            int i2 = get();
            if (i2 > 0) {
                Object obj = this.list.get(i2 - 1);
                if (!this.nl.isCompleted(obj) && !this.nl.isError(obj)) {
                    return this.nl.getValue(obj);
                }
                if (i2 > 1) {
                    return this.nl.getValue(this.list.get(i2 - 2));
                }
            }
            return null;
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public void next(T t) {
            if (this.terminated) {
                return;
            }
            this.list.add(this.nl.next(t));
            getAndIncrement();
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver) {
            synchronized (subjectObserver) {
                subjectObserver.first = false;
                if (subjectObserver.emitting) {
                    return false;
                }
                Integer num = (Integer) subjectObserver.index();
                if (num != null) {
                    subjectObserver.index(Integer.valueOf(replayObserverFromIndex(num, (SubjectSubscriptionManager.SubjectObserver) subjectObserver).intValue()));
                    return true;
                }
                throw new IllegalStateException("failed to find lastEmittedLink for: " + subjectObserver);
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public int size() {
            int i2 = get();
            if (i2 > 0) {
                int i3 = i2 - 1;
                Object obj = this.list.get(i3);
                if (this.nl.isCompleted(obj) || this.nl.isError(obj)) {
                    return i3;
                }
            }
            return i2;
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public boolean terminated() {
            return this.terminated;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.subjects.ReplaySubject.ReplayState
        public T[] toArray(T[] tArr) {
            int size = size();
            if (size > 0) {
                if (size > tArr.length) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i2 = 0; i2 < size; i2++) {
                    tArr[i2] = this.list.get(i2);
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public Integer replayObserverFromIndex(Integer num, SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver) {
            int intValue = num.intValue();
            while (intValue < get()) {
                accept(subjectObserver, intValue);
                intValue++;
            }
            return Integer.valueOf(intValue);
        }

        @Override // rx.subjects.ReplaySubject.ReplayState
        public Integer replayObserverFromIndexTest(Integer num, SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver, long j2) {
            return replayObserverFromIndex(num, (SubjectSubscriptionManager.SubjectObserver) subjectObserver);
        }
    }

    ReplaySubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager, ReplayState<T, ?> replayState) {
        super(onSubscribe);
        this.ssm = subjectSubscriptionManager;
        this.state = replayState;
    }

    private boolean caughtUp(SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver) {
        if (subjectObserver.caughtUp) {
            return true;
        }
        if (this.state.replayObserver(subjectObserver)) {
            subjectObserver.caughtUp = true;
            subjectObserver.index(null);
            return false;
        }
        return false;
    }

    public static <T> ReplaySubject<T> create() {
        return create(16);
    }

    static <T> ReplaySubject<T> createUnbounded() {
        BoundedState boundedState = new BoundedState(new EmptyEvictionPolicy(), UtilityFunctions.identity(), UtilityFunctions.identity());
        return createWithState(boundedState, new DefaultOnAdd(boundedState));
    }

    public static <T> ReplaySubject<T> createWithSize(int i2) {
        BoundedState boundedState = new BoundedState(new SizeEvictionPolicy(i2), UtilityFunctions.identity(), UtilityFunctions.identity());
        return createWithState(boundedState, new DefaultOnAdd(boundedState));
    }

    static final <T> ReplaySubject<T> createWithState(final BoundedState<T> boundedState, Action1<SubjectSubscriptionManager.SubjectObserver<T>> action1) {
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.onStart = action1;
        subjectSubscriptionManager.onAdded = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.ReplaySubject.4
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) obj));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                boolean z;
                synchronized (subjectObserver) {
                    if (subjectObserver.first && !subjectObserver.emitting) {
                        subjectObserver.first = false;
                        boolean z2 = true;
                        subjectObserver.emitting = true;
                        while (true) {
                            try {
                                NodeList.Node<Object> node = (NodeList.Node) subjectObserver.index();
                                NodeList.Node<Object> tail = BoundedState.this.tail();
                                if (node != tail) {
                                    subjectObserver.index(BoundedState.this.replayObserverFromIndex(node, (SubjectSubscriptionManager.SubjectObserver) subjectObserver));
                                }
                                try {
                                    synchronized (subjectObserver) {
                                        try {
                                            if (tail == BoundedState.this.tail()) {
                                                subjectObserver.emitting = false;
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            z2 = false;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                z = false;
                            }
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                z = z2;
                                th = th4;
                                if (!z) {
                                    synchronized (subjectObserver) {
                                        subjectObserver.emitting = false;
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                }
            }
        };
        subjectSubscriptionManager.onTerminated = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.ReplaySubject.5
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) obj));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                NodeList.Node<Object> node = (NodeList.Node) subjectObserver.index();
                if (node == null) {
                    node = BoundedState.this.head();
                }
                BoundedState.this.replayObserverFromIndex(node, (SubjectSubscriptionManager.SubjectObserver) subjectObserver);
            }
        };
        return new ReplaySubject<>(subjectSubscriptionManager, subjectSubscriptionManager, boundedState);
    }

    public static <T> ReplaySubject<T> createWithTime(long j2, TimeUnit timeUnit, Scheduler scheduler) {
        BoundedState boundedState = new BoundedState(new TimeEvictionPolicy(timeUnit.toMillis(j2), scheduler), new AddTimestamped(scheduler), new RemoveTimestamped());
        return createWithState(boundedState, new TimedOnAdd(boundedState, scheduler));
    }

    public static <T> ReplaySubject<T> createWithTimeAndSize(long j2, TimeUnit timeUnit, int i2, Scheduler scheduler) {
        BoundedState boundedState = new BoundedState(new PairEvictionPolicy(new SizeEvictionPolicy(i2), new TimeEvictionPolicy(timeUnit.toMillis(j2), scheduler)), new AddTimestamped(scheduler), new RemoveTimestamped());
        return createWithState(boundedState, new TimedOnAdd(boundedState, scheduler));
    }

    @Beta
    public Throwable getThrowable() {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.ssm;
        NotificationLite<T> notificationLite = subjectSubscriptionManager.nl;
        Object latest = subjectSubscriptionManager.getLatest();
        if (notificationLite.isError(latest)) {
            return notificationLite.getError(latest);
        }
        return null;
    }

    @Beta
    public T getValue() {
        return this.state.latest();
    }

    @Beta
    public T[] getValues(T[] tArr) {
        return this.state.toArray(tArr);
    }

    @Beta
    public boolean hasAnyValue() {
        return !this.state.isEmpty();
    }

    @Beta
    public boolean hasCompleted() {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.ssm;
        NotificationLite<T> notificationLite = subjectSubscriptionManager.nl;
        Object latest = subjectSubscriptionManager.getLatest();
        return (latest == null || notificationLite.isError(latest)) ? false : true;
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.ssm.observers().length > 0;
    }

    @Beta
    public boolean hasThrowable() {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.ssm;
        return subjectSubscriptionManager.nl.isError(subjectSubscriptionManager.getLatest());
    }

    @Beta
    public boolean hasValue() {
        return hasAnyValue();
    }

    @Override // rx.Observer
    public void onCompleted() {
        SubjectSubscriptionManager.SubjectObserver<T>[] terminate;
        if (this.ssm.active) {
            this.state.complete();
            for (SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver : this.ssm.terminate(NotificationLite.instance().completed())) {
                if (caughtUp(subjectObserver)) {
                    subjectObserver.onCompleted();
                }
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        SubjectSubscriptionManager.SubjectObserver<T>[] terminate;
        if (this.ssm.active) {
            this.state.error(th);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver : this.ssm.terminate(NotificationLite.instance().error(th))) {
                try {
                    if (caughtUp(subjectObserver)) {
                        subjectObserver.onError(th);
                    }
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.Observer
    public void onNext(T t) {
        SubjectSubscriptionManager.SubjectObserver<T>[] observers;
        if (this.ssm.active) {
            this.state.next(t);
            for (SubjectSubscriptionManager.SubjectObserver<? super T> subjectObserver : this.ssm.observers()) {
                if (caughtUp(subjectObserver)) {
                    subjectObserver.onNext(t);
                }
            }
        }
    }

    @Beta
    public int size() {
        return this.state.size();
    }

    int subscriberCount() {
        return this.ssm.get().observers.length;
    }

    public static <T> ReplaySubject<T> create(int i2) {
        final UnboundedReplayState unboundedReplayState = new UnboundedReplayState(i2);
        SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.onStart = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.ReplaySubject.1
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) obj));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                subjectObserver.index(Integer.valueOf(UnboundedReplayState.this.replayObserverFromIndex((Integer) 0, (SubjectSubscriptionManager.SubjectObserver) subjectObserver).intValue()));
            }
        };
        subjectSubscriptionManager.onAdded = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.ReplaySubject.2
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) obj));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                boolean z;
                synchronized (subjectObserver) {
                    if (subjectObserver.first && !subjectObserver.emitting) {
                        subjectObserver.first = false;
                        boolean z2 = true;
                        subjectObserver.emitting = true;
                        try {
                            UnboundedReplayState unboundedReplayState2 = UnboundedReplayState.this;
                            while (true) {
                                int intValue = ((Integer) subjectObserver.index()).intValue();
                                int i3 = unboundedReplayState2.get();
                                if (intValue != i3) {
                                    subjectObserver.index(unboundedReplayState2.replayObserverFromIndex(Integer.valueOf(intValue), (SubjectSubscriptionManager.SubjectObserver) subjectObserver));
                                }
                                try {
                                    synchronized (subjectObserver) {
                                        try {
                                            if (i3 == unboundedReplayState2.get()) {
                                                subjectObserver.emitting = false;
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            z2 = false;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    z = z2;
                                    th = th3;
                                    if (!z) {
                                        synchronized (subjectObserver) {
                                            subjectObserver.emitting = false;
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            z = false;
                        }
                    }
                }
            }
        };
        subjectSubscriptionManager.onTerminated = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.ReplaySubject.3
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((SubjectSubscriptionManager.SubjectObserver) ((SubjectSubscriptionManager.SubjectObserver) obj));
            }

            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                int i3 = (Integer) subjectObserver.index();
                if (i3 == null) {
                    i3 = 0;
                }
                UnboundedReplayState.this.replayObserverFromIndex(i3, (SubjectSubscriptionManager.SubjectObserver) subjectObserver);
            }
        };
        return new ReplaySubject<>(subjectSubscriptionManager, subjectSubscriptionManager, unboundedReplayState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }
}
