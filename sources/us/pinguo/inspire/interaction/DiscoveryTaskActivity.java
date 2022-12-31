package us.pinguo.inspire.interaction;

import android.os.Bundle;
import us.pinguo.foundation.base.InspireContentActivity;
import us.pinguo.inspire.module.discovery.fragment.DiscoveryTaskFragment;
/* loaded from: classes9.dex */
public class DiscoveryTaskActivity extends InspireContentActivity {
    @Override // us.pinguo.foundation.base.InspireContentActivity
    protected String getFragmentClsName() {
        return DiscoveryTaskFragment.class.getName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.InspireContentActivity, us.pinguo.foundation.base.InspireBaseActivity, us.pinguo.foundation.base.InspireRedirectActivity, us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (getIntent().getAction().contains("hottask")) {
            getIntent().putExtra("type", 0);
        } else if (getIntent().getAction().contains("overtask")) {
            getIntent().putExtra("type", 1);
        }
        super.onCreate(bundle);
    }
}
