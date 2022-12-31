package rx.internal.operators;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;
/* loaded from: classes3.dex */
public final class OperatorWindowWithSize<T> implements Observable.Operator<Observable<T>, T> {
    final int size;
    final int skip;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class CountedSubject<T> {
        final Observer<T> consumer;
        int count;
        final Observable<T> producer;

        public CountedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = observer;
            this.producer = observable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class ExactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        int count;
        volatile boolean noWindow = true;
        UnicastSubject<T> window;

        public ExactSubscriber(Subscriber<? super Observable<T>> subscriber) {
            this.child = subscriber;
        }

        void init() {
            this.child.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorWindowWithSize.ExactSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    if (ExactSubscriber.this.noWindow) {
                        ExactSubscriber.this.unsubscribe();
                    }
                }
            }));
            this.child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorWindowWithSize.ExactSubscriber.2
                @Override // rx.Producer
                public void request(long j2) {
                    if (j2 > 0) {
                        ExactSubscriber exactSubscriber = ExactSubscriber.this;
                        int i2 = OperatorWindowWithSize.this.size;
                        long j3 = i2 * j2;
                        if ((j3 >>> 31) != 0 && j3 / j2 != i2) {
                            j3 = LocationRequestCompat.PASSIVE_INTERVAL;
                        }
                        exactSubscriber.requestMore(j3);
                    }
                }
            });
        }

        @Override // rx.Observer
        public void onCompleted() {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                unicastSubject.onCompleted();
            }
            this.child.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                unicastSubject.onError(th);
            }
            this.child.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (this.window == null) {
                this.noWindow = false;
                UnicastSubject<T> create = UnicastSubject.create();
                this.window = create;
                this.child.onNext(create);
            }
            this.window.onNext(t);
            int i2 = this.count + 1;
            this.count = i2;
            if (i2 % OperatorWindowWithSize.this.size == 0) {
                this.window.onCompleted();
                this.window = null;
                this.noWindow = true;
                if (this.child.isUnsubscribed()) {
                    unsubscribe();
                }
            }
        }

        void requestMore(long j2) {
            request(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public final class InexactSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        int count;
        final List<CountedSubject<T>> chunks = new LinkedList();
        volatile boolean noWindow = true;

        public InexactSubscriber(Subscriber<? super Observable<T>> subscriber) {
            this.child = subscriber;
        }

        CountedSubject<T> createCountedSubject() {
            UnicastSubject create = UnicastSubject.create();
            return new CountedSubject<>(create, create);
        }

        void init() {
            this.child.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorWindowWithSize.InexactSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    if (InexactSubscriber.this.noWindow) {
                        InexactSubscriber.this.unsubscribe();
                    }
                }
            }));
            this.child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorWindowWithSize.InexactSubscriber.2
                @Override // rx.Producer
                public void request(long j2) {
                    if (j2 > 0) {
                        InexactSubscriber inexactSubscriber = InexactSubscriber.this;
                        int i2 = OperatorWindowWithSize.this.size;
                        long j3 = i2 * j2;
                        if ((j3 >>> 31) != 0 && j3 / j2 != i2) {
                            j3 = LocationRequestCompat.PASSIVE_INTERVAL;
                        }
                        inexactSubscriber.requestMore(j3);
                    }
                }
            });
        }

        @Override // rx.Observer
        public void onCompleted() {
            ArrayList<CountedSubject> arrayList = new ArrayList(this.chunks);
            this.chunks.clear();
            this.noWindow = true;
            for (CountedSubject countedSubject : arrayList) {
                countedSubject.consumer.onCompleted();
            }
            this.child.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            ArrayList<CountedSubject> arrayList = new ArrayList(this.chunks);
            this.chunks.clear();
            this.noWindow = true;
            for (CountedSubject countedSubject : arrayList) {
                countedSubject.consumer.onError(th);
            }
            this.child.onError(th);
        }

        @Override // rx.Observer
        public void onNext(T t) {
            int i2 = this.count;
            this.count = i2 + 1;
            if (i2 % OperatorWindowWithSize.this.skip == 0 && !this.child.isUnsubscribed()) {
                if (this.chunks.isEmpty()) {
                    this.noWindow = false;
                }
                CountedSubject<T> createCountedSubject = createCountedSubject();
                this.chunks.add(createCountedSubject);
                this.child.onNext(createCountedSubject.producer);
            }
            Iterator<CountedSubject<T>> it = this.chunks.iterator();
            while (it.hasNext()) {
                CountedSubject<T> next = it.next();
                next.consumer.onNext(t);
                int i3 = next.count + 1;
                next.count = i3;
                if (i3 == OperatorWindowWithSize.this.size) {
                    it.remove();
                    next.consumer.onCompleted();
                }
            }
            if (this.chunks.isEmpty()) {
                this.noWindow = true;
                if (this.child.isUnsubscribed()) {
                    unsubscribe();
                }
            }
        }

        void requestMore(long j2) {
            request(j2);
        }
    }

    public OperatorWindowWithSize(int i2, int i3) {
        this.size = i2;
        this.skip = i3;
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        if (this.skip == this.size) {
            ExactSubscriber exactSubscriber = new ExactSubscriber(subscriber);
            exactSubscriber.init();
            return exactSubscriber;
        }
        InexactSubscriber inexactSubscriber = new InexactSubscriber(subscriber);
        inexactSubscriber.init();
        return inexactSubscriber;
    }
}
