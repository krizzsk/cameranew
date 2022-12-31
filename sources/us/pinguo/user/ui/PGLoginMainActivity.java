package us.pinguo.user.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.mob.OperationCallback;
import java.lang.reflect.Method;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.permissionlib.b.a;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.event.LoginEvent$LoginResultEvent;
import us.pinguo.user.ui.AgreementDialogFragment;
import us.pinguo.user.util.BaseInfoResult;
import us.pinguo.user.v0;
/* loaded from: classes6.dex */
public class PGLoginMainActivity extends BaseActivity implements us.pinguo.user.util.g {
    private int a;
    private AgreementDialogFragment c;

    /* renamed from: d  reason: collision with root package name */
    ViewPager f12407d;
    private Boolean b = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12408e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a extends OperationCallback {
        final /* synthetic */ AgreementDialogFragment.b a;
        final /* synthetic */ AgreementDialogFragment b;

        a(AgreementDialogFragment.b bVar, AgreementDialogFragment agreementDialogFragment) {
            this.a = bVar;
            this.b = agreementDialogFragment;
        }

        @Override // com.mob.OperationCallback
        public void onComplete(Object obj) {
            AgreementDialogFragment.b bVar = this.a;
            if (bVar != null) {
                bVar.a();
            }
            PGLoginMainActivity.this.r0();
            us.pinguo.user.util.h.a.e(PGLoginMainActivity.this, false);
            this.b.dismiss();
        }

        @Override // com.mob.OperationCallback
        public void onFailure(Throwable th) {
            this.b.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0(AgreementDialogFragment.b bVar, AgreementDialogFragment agreementDialogFragment, View view) {
        VdsAgent.lambdaOnClick(view);
        us.pinguo.share.d.a.d(true, new a(bVar, agreementDialogFragment));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void D0(AgreementDialogFragment.b bVar, AgreementDialogFragment agreementDialogFragment, View view) {
        VdsAgent.lambdaOnClick(view);
        bVar.b();
        agreementDialogFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E0 */
    public /* synthetic */ void F0() {
        if (this.pgDistroy) {
            return;
        }
        us.pinguo.foundation.utils.k0.a.a(R.string.pg_login_network_exception);
    }

    private void H0() {
        v0.i(this.a, getIntent().getIntExtra(FastLoginDialog.KEY_REQ_CODE, 0));
        Intent intent = new Intent();
        intent.putExtra("context_data", this.a);
        setResult(-1, intent);
        finish();
    }

    private void J0() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: us.pinguo.user.ui.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PGLoginMainActivity.this.A0(view);
            }
        });
        if (this.f12408e) {
            getSupportActionBar().setTitle(R.string.login_c360_account);
        } else {
            getSupportActionBar().setTitle(R.string.login_main_title);
        }
        us.pinguo.user.ui.p0.b bVar = new us.pinguo.user.ui.p0.b(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.login_view_pager);
        this.f12407d = viewPager;
        viewPager.setAdapter(bVar);
        ((TabLayout) findViewById(R.id.tabLayout)).setupWithViewPager(this.f12407d);
    }

    private void L0() {
        runOnUiThread(new Runnable() { // from class: us.pinguo.user.ui.g0
            @Override // java.lang.Runnable
            public final void run() {
                PGLoginMainActivity.this.F0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        try {
            Method method = Class.forName("com.pinguo.camera360.DataCollectUtils").getMethod("enableDataCollect", new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void t0() {
        a.b bVar = new a.b(getString(R.string.login_cancel_desc));
        bVar.j(getString(R.string.login_go_on));
        bVar.l(R.color.light_colorAccent);
        bVar.i(getString(R.string.login_cancel));
        bVar.k(R.color.primary_gray_color);
        us.pinguo.permissionlib.a.a.c(bVar.h(), this, new DialogInterface.OnClickListener() { // from class: us.pinguo.user.ui.j0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                PGLoginMainActivity.this.w0(dialogInterface, i2);
            }
        });
    }

    private void u0() {
        v0.d(this);
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        CookieManager.getInstance().removeSessionCookie();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void w0(DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            dialogInterface.dismiss();
            return;
        }
        dialogInterface.dismiss();
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void y0(Runnable runnable) {
        if (this.pgDistroy) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void A0(View view) {
        VdsAgent.lambdaOnClick(view);
        if (getIntent().getBooleanExtra("from_pay", false)) {
            t0();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G0() {
        if (this.b == null) {
            L0();
        } else if (us.pinguo.user.util.n.m(User.d().h(), this.b.booleanValue())) {
            Intent intent = new Intent();
            intent.setClassName(this, "us.pinguo.inspire.PhoneBindActivity");
            startActivityForResult(intent, CloseFrame.NOCODE);
        } else {
            H0();
        }
    }

    public void I0(final Runnable runnable) {
        runOnUiThread(new Runnable() { // from class: us.pinguo.user.ui.h0
            @Override // java.lang.Runnable
            public final void run() {
                PGLoginMainActivity.this.y0(runnable);
            }
        });
    }

    public void K0(final AgreementDialogFragment.b bVar) {
        if (us.pinguo.user.util.h.a.c(this)) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            final AgreementDialogFragment s0 = s0();
            s0.setCancelable(false);
            s0.c0(new View.OnClickListener() { // from class: us.pinguo.user.ui.e0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PGLoginMainActivity.this.C0(bVar, s0, view);
                }
            });
            s0.b0(new View.OnClickListener() { // from class: us.pinguo.user.ui.i0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PGLoginMainActivity.D0(AgreementDialogFragment.b.this, s0, view);
                }
            });
            s0.show(supportFragmentManager, "agreement_dialog");
            VdsAgent.showDialogFragment(s0, supportFragmentManager, "agreement_dialog");
            return;
        }
        bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        if (i2 == 1005) {
            H0();
        } else {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f12408e) {
            t0();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12408e = getIntent().getBooleanExtra("from_pay", false);
        PGEventBus.getInstance().b(this);
        setContentView(R.layout.layout_login_main_activity);
        J0();
        u0();
        if (bundle == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.a = intent.getIntExtra("context_data", -999);
            }
        } else {
            this.a = bundle.getInt("context_data");
        }
        us.pinguo.user.util.n.a.h(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        us.pinguo.user.util.n.a.f();
        PGEventBus.getInstance().c(this);
    }

    public void onEvent(LoginEvent$LoginResultEvent loginEvent$LoginResultEvent) {
        if (loginEvent$LoginResultEvent != null) {
            if (loginEvent$LoginResultEvent.b() == 200) {
                G0();
                return;
            }
            String a2 = loginEvent$LoginResultEvent.a();
            if (TextUtils.isEmpty(a2)) {
                a2 = getString(R.string.pg_login_fail);
            }
            Snackbar.W(getWindow().getDecorView(), a2, -1).M();
        }
    }

    @Override // us.pinguo.user.util.g
    public void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
        if (baseInfoResult != null) {
            this.b = Boolean.valueOf(baseInfoResult.isChina());
        }
    }

    @Override // android.app.Activity
    @Instrumented
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        VdsAgent.onOptionsItemSelected(this, menuItem);
        if (menuItem.getItemId() == 16908332) {
            finish();
            VdsAgent.handleClickResult(new Boolean(true));
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        VdsAgent.handleClickResult(new Boolean(onOptionsItemSelected));
        return onOptionsItemSelected;
    }

    public AgreementDialogFragment s0() {
        AgreementDialogFragment agreementDialogFragment = new AgreementDialogFragment();
        this.c = agreementDialogFragment;
        return agreementDialogFragment;
    }
}
