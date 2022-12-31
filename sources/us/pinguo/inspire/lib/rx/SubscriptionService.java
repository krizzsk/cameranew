package us.pinguo.inspire.lib.rx;

import android.app.Service;
import rx.subscriptions.CompositeSubscription;
/* loaded from: classes9.dex */
public abstract class SubscriptionService extends Service {
    private CompositeSubscription a;

    @Override // android.app.Service
    public void onDestroy() {
        CompositeSubscription compositeSubscription = this.a;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            this.a = null;
        }
        super.onDestroy();
    }
}
