package us.pinguo.foundation.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
/* loaded from: classes4.dex */
public class SubscriptionActivity extends BaseActivity {
    private CompositeSubscription mSubscriptions;

    public void addSubscription(Subscription subscription) {
        if (this.mSubscriptions == null) {
            this.mSubscriptions = new CompositeSubscription();
        }
        this.mSubscriptions.add(subscription);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CompositeSubscription compositeSubscription = this.mSubscriptions;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            this.mSubscriptions = null;
        }
        super.onDestroy();
    }
}
