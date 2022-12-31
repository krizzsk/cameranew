package us.pinguo.foundation.base;

import android.os.Bundle;
import java.util.LinkedList;
import java.util.List;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
/* loaded from: classes4.dex */
public class InspireBaseActivity extends InspireRedirectActivity {
    private boolean mActivityDestroyed;
    private List<d> mInspireActivityLifeCycles = new LinkedList();
    private CompositeSubscription mSubscriptions;

    public void addActivityLifeCycle(d dVar) {
        if (dVar != null) {
            this.mInspireActivityLifeCycles.add(dVar);
        }
    }

    @Override // us.pinguo.foundation.base.SubscriptionActivity
    public void addSubscription(Subscription subscription) {
        if (this.mSubscriptions == null) {
            this.mSubscriptions = new CompositeSubscription();
        }
        this.mSubscriptions.add(subscription);
    }

    public boolean isActivityDestroyed() {
        return this.mActivityDestroyed;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mActivityDestroyed = false;
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.SubscriptionActivity, us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CompositeSubscription compositeSubscription = this.mSubscriptions;
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
        }
        this.mActivityDestroyed = true;
        this.mInspireActivityLifeCycles.clear();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        for (d dVar : this.mInspireActivityLifeCycles) {
            dVar.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        for (d dVar : this.mInspireActivityLifeCycles) {
            dVar.onResume();
        }
    }

    public void removeActivityLifeCycle(d dVar) {
        if (dVar != null) {
            this.mInspireActivityLifeCycles.remove(dVar);
        }
    }
}
