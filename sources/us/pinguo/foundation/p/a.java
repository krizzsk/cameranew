package us.pinguo.foundation.p;

import androidx.annotation.CallSuper;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
/* compiled from: SubscriptionPresenter.java */
/* loaded from: classes4.dex */
public abstract class a {
    private CompositeSubscription mSubscriptions;

    public final void addSubscription(Subscription subscription) {
        if (this.mSubscriptions == null) {
            this.mSubscriptions = new CompositeSubscription();
        }
        this.mSubscriptions.add(subscription);
    }

    @CallSuper
    public void detachView() {
        CompositeSubscription compositeSubscription = this.mSubscriptions;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            this.mSubscriptions = null;
        }
    }
}
