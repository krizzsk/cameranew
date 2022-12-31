package us.pinguo.foundation.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
/* loaded from: classes4.dex */
public abstract class SubscriptionDialog extends Dialog {
    private CompositeSubscription mSubscriptions;

    public SubscriptionDialog(Context context) {
        super(context);
    }

    public void addSubscription(Subscription subscription) {
        if (this.mSubscriptions == null) {
            this.mSubscriptions = new CompositeSubscription();
        }
        this.mSubscriptions.add(subscription);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        CompositeSubscription compositeSubscription = this.mSubscriptions;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            this.mSubscriptions = null;
        }
        super.onStop();
    }

    public SubscriptionDialog(Context context, int i2) {
        super(context, i2);
    }

    protected SubscriptionDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }
}
