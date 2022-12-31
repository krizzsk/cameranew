package us.pinguo.foundation.base;

import androidx.fragment.app.DialogFragment;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
/* loaded from: classes4.dex */
public class SubscriptionDialogFragment extends DialogFragment implements c {
    private CompositeSubscription mSubscriptions;

    @Override // us.pinguo.foundation.base.c
    public void addSubscription(Subscription subscription) {
        if (this.mSubscriptions == null) {
            this.mSubscriptions = new CompositeSubscription();
        }
        this.mSubscriptions.add(subscription);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        CompositeSubscription compositeSubscription = this.mSubscriptions;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            this.mSubscriptions = null;
        }
    }
}
