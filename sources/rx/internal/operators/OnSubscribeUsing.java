package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observers.Subscribers;
/* loaded from: classes3.dex */
public final class OnSubscribeUsing<T, Resource> implements Observable.OnSubscribe<T> {
    private final Action1<? super Resource> dispose;
    private final boolean disposeEagerly;
    private final Func1<? super Resource, ? extends Observable<? extends T>> observableFactory;
    private final Func0<Resource> resourceFactory;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class DisposeAction<Resource> extends AtomicBoolean implements Action0, Subscription {
        private static final long serialVersionUID = 4262875056400218316L;
        private Action1<? super Resource> dispose;
        private Resource resource;

        /* JADX WARN: Type inference failed for: r0v2, types: [Resource, rx.functions.Action1<? super Resource>] */
        @Override // rx.functions.Action0
        public void call() {
            if (compareAndSet(false, true)) {
                ?? r0 = (Resource) false;
                try {
                    this.dispose.call((Resource) this.resource);
                } finally {
                    this.resource = null;
                    this.dispose = null;
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            call();
        }

        private DisposeAction(Action1<? super Resource> action1, Resource resource) {
            this.dispose = action1;
            this.resource = resource;
            lazySet(false);
        }
    }

    public OnSubscribeUsing(Func0<Resource> func0, Func1<? super Resource, ? extends Observable<? extends T>> func1, Action1<? super Resource> action1, boolean z) {
        this.resourceFactory = func0;
        this.observableFactory = func1;
        this.dispose = action1;
        this.disposeEagerly = z;
    }

    private Throwable disposeEagerlyIfRequested(Action0 action0) {
        if (this.disposeEagerly) {
            try {
                action0.call();
                return null;
            } catch (Throwable th) {
                return th;
            }
        }
        return null;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        try {
            Resource call = this.resourceFactory.call();
            DisposeAction disposeAction = new DisposeAction(this.dispose, call);
            subscriber.add(disposeAction);
            Observable<? extends T> call2 = this.observableFactory.call(call);
            if (this.disposeEagerly) {
                call2 = call2.doOnTerminate(disposeAction);
            }
            call2.unsafeSubscribe(Subscribers.wrap(subscriber));
        } catch (Throwable th) {
            Exceptions.throwOrReport(th, subscriber);
        }
    }
}
