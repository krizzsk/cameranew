package us.pinguo.foundation.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.foundation.statistics.g;
import us.pinguo.foundation.statistics.k;
import us.pinguo.foundation.statistics.l;
import us.pinguo.foundation.utils.n0;
import us.pinguo.foundation.utils.x;
/* loaded from: classes4.dex */
public class BaseActivity extends AppCompatActivity {
    public static final int STATUSBAR_COLOR_DEFAULT = 0;
    public static final int STATUSBAR_GONE_NAVIGATIONBAR_VISIBLE = 1;
    public static final int STATUSBAR_VISIBILITY_GONE = -1;
    protected boolean mEnableBaseNotch = true;
    protected boolean pgDistroy = false;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0(Runnable runnable) {
        if (this.pgDistroy) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void p0(final Runnable runnable) {
        if (this.pgDistroy) {
            return;
        }
        new Handler().post(new Runnable() { // from class: us.pinguo.foundation.base.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.this.n0(runnable);
            }
        });
    }

    protected String getPageId() {
        return getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k.m(getIntent());
        String simpleName = getClass().getSimpleName();
        if ("IntentBufferActivity".equals(simpleName) || "CameraActivity".equals(simpleName)) {
            n0.p(us.pinguo.foundation.e.b());
        }
        this.pgDistroy = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.pgDistroy = true;
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @Instrumented
    public void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        super.onNewIntent(intent);
        k.m(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPageEnd() {
        g.e(getPageId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPageStart() {
        g.f(getPageId());
        l.d(this, getPageId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (useDefaultPageStatistic()) {
            onPageEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        if (this.mEnableBaseNotch) {
            requestCheckIsFullDisplay(0);
        }
        super.onResume();
        if (useDefaultPageStatistic()) {
            onPageStart();
        }
    }

    public void postAfterAllInited(final Runnable runnable) {
        getWindow().getDecorView().post(new Runnable() { // from class: us.pinguo.foundation.base.b
            @Override // java.lang.Runnable
            public final void run() {
                BaseActivity.this.p0(runnable);
            }
        });
    }

    public void requestCheckIsFullDisplay(int i2) {
        x.a.c(i2, this);
    }

    protected boolean useDefaultPageStatistic() {
        return true;
    }
}
