package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;
/* loaded from: classes3.dex */
public final class OnSubscribeAmb<T> implements Observable.OnSubscribe<T> {
    final AtomicReference<AmbSubscriber<T>> choice;
    final Selection<T> selection;
    final Iterable<? extends Observable<? extends T>> sources;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class AmbSubscriber<T> extends Subscriber<T> {
        private boolean chosen;
        private final Selection<T> selection;
        private final Subscriber<? super T> subscriber;

        private boolean isSelected() {
            if (this.chosen) {
                return true;
            }
            if (this.selection.choice.get() == this) {
                this.chosen = true;
                return true;
            } else if (this.selection.choice.compareAndSet(null, this)) {
                this.selection.unsubscribeOthers(this);
                this.chosen = true;
                return true;
            } else {
                this.selection.unsubscribeLosers();
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void requestMore(long j2) {
            request(j2);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (isSelected()) {
                this.subscriber.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th) {
            if (isSelected()) {
                this.subscriber.onError(th);
            }
        }

        @Override // rx.Observer
        public void onNext(T t) {
            if (isSelected()) {
                this.subscriber.onNext(t);
            }
        }

        private AmbSubscriber(long j2, Subscriber<? super T> subscriber, Selection<T> selection) {
            this.subscriber = subscriber;
            this.selection = selection;
            request(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Selection<T> {
        final Collection<AmbSubscriber<T>> ambSubscribers;
        final AtomicReference<AmbSubscriber<T>> choice;

        private Selection() {
            this.choice = new AtomicReference<>();
            this.ambSubscribers = new ConcurrentLinkedQueue();
        }

        public void unsubscribeLosers() {
            AmbSubscriber<T> ambSubscriber = this.choice.get();
            if (ambSubscriber != null) {
                unsubscribeOthers(ambSubscriber);
            }
        }

        public void unsubscribeOthers(AmbSubscriber<T> ambSubscriber) {
            for (AmbSubscriber<T> ambSubscriber2 : this.ambSubscribers) {
                if (ambSubscriber2 != ambSubscriber) {
                    ambSubscriber2.unsubscribe();
                }
            }
            this.ambSubscribers.clear();
        }
    }

    private OnSubscribeAmb(Iterable<? extends Observable<? extends T>> iterable) {
        Selection<T> selection = new Selection<>();
        this.selection = selection;
        this.choice = selection.choice;
        this.sources = iterable;
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        return amb(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void unsubscribeAmbSubscribers(Collection<AmbSubscriber<T>> collection) {
        if (collection.isEmpty()) {
            return;
        }
        for (AmbSubscriber<T> ambSubscriber : collection) {
            ambSubscriber.unsubscribe();
        }
        collection.clear();
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OnSubscribeAmb.1
            @Override // rx.functions.Action0
            public void call() {
                AmbSubscriber<T> ambSubscriber = OnSubscribeAmb.this.choice.get();
                if (ambSubscriber != null) {
                    ambSubscriber.unsubscribe();
                }
                OnSubscribeAmb.unsubscribeAmbSubscribers(OnSubscribeAmb.this.selection.ambSubscribers);
            }
        }));
        for (Observable<? extends T> observable : this.sources) {
            if (subscriber.isUnsubscribed()) {
                break;
            }
            AmbSubscriber<T> ambSubscriber = new AmbSubscriber<>(0L, subscriber, this.selection);
            this.selection.ambSubscribers.add(ambSubscriber);
            AmbSubscriber<T> ambSubscriber2 = this.choice.get();
            if (ambSubscriber2 != null) {
                this.selection.unsubscribeOthers(ambSubscriber2);
                return;
            }
            observable.unsafeSubscribe(ambSubscriber);
        }
        if (subscriber.isUnsubscribed()) {
            unsubscribeAmbSubscribers(this.selection.ambSubscribers);
        }
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeAmb.2
            @Override // rx.Producer
            public void request(long j2) {
                AmbSubscriber<T> ambSubscriber3 = OnSubscribeAmb.this.choice.get();
                if (ambSubscriber3 != null) {
                    ambSubscriber3.requestMore(j2);
                    return;
                }
                for (AmbSubscriber<T> ambSubscriber4 : OnSubscribeAmb.this.selection.ambSubscribers) {
                    if (!ambSubscriber4.isUnsubscribed()) {
                        if (OnSubscribeAmb.this.choice.get() == ambSubscriber4) {
                            ambSubscriber4.requestMore(j2);
                            return;
                        }
                        ambSubscriber4.requestMore(j2);
                    }
                }
            }
        });
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        arrayList.add(observable8);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        arrayList.add(observable8);
        arrayList.add(observable9);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Iterable<? extends Observable<? extends T>> iterable) {
        return new OnSubscribeAmb(iterable);
    }
}
