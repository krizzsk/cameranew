package us.pinguo.foundation.base;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.statistics.k;
import us.pinguo.foundation.utils.l0;
/* loaded from: classes4.dex */
public class InspireRedirectActivity extends BaseSplitActivity {
    private static final int REQUEST_CODE = 453;
    private us.pinguo.foundation.proxy.c mOnActivityResult;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        l0.d(this);
        us.pinguo.common.log.a.g("HHH", "onActivityResult", new Object[0]);
        us.pinguo.foundation.proxy.c cVar = this.mOnActivityResult;
        if (cVar == null || i2 != REQUEST_CODE) {
            return;
        }
        cVar.onActivityResult(i3, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k.m(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @Instrumented
    public void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        k.m(intent);
    }

    public void startActivityForResult(Intent intent, us.pinguo.foundation.proxy.c cVar) {
        startActivityForResult(intent, cVar, (Bundle) null);
    }

    public void startActivityForResult(Intent intent, us.pinguo.foundation.proxy.c cVar, Bundle bundle) {
        this.mOnActivityResult = cVar;
        try {
            ActivityCompat.startActivityForResult(this, intent, REQUEST_CODE, bundle);
        } catch (NullPointerException e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }
}
