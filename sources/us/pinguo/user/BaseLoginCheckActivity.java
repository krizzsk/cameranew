package us.pinguo.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import rx.functions.Action1;
import us.pinguo.foundation.base.BaseSplitActivity;
import us.pinguo.user.ui.PGLoginMainActivity;
/* loaded from: classes6.dex */
public abstract class BaseLoginCheckActivity extends BaseSplitActivity {
    private boolean isShowLoginDialog = false;

    private void launchLogin(int i2, int i3) {
        Intent intent = new Intent();
        intent.setClass(this, PGLoginMainActivity.class);
        startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(Bundle bundle, us.pinguo.foundation.r.b bVar) {
        if (User.d().n()) {
            onLoginCreate(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void s0(Throwable th) {
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    protected void onClosedIcon() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!User.d().n()) {
            this.isShowLoginDialog = true;
            registerLoginEvent(bundle);
            launchLogin(0, -999);
            return;
        }
        onLoginCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.isShowLoginDialog && i2 == 4) {
            onClosedIcon();
            return false;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    protected abstract void onLoginCreate(Bundle bundle);

    public void registerLoginEvent(final Bundle bundle) {
        addSubscription(us.pinguo.foundation.r.d.a().c(us.pinguo.foundation.r.b.class).subscribe(new Action1() { // from class: us.pinguo.user.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                BaseLoginCheckActivity.this.r0(bundle, (us.pinguo.foundation.r.b) obj);
            }
        }, f.a));
    }
}
