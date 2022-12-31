package us.pinguo.user.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.d;
import com.facebook.login.LoginManager;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.huawei.HmsLoginCallBack;
import com.huawei.HuaweiAgent;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import rx.functions.Action1;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.foundation.network.Fault;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.share.core.ShareSite;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.event.LoginEvent$LoginResultEvent;
import us.pinguo.user.model.ThridSitePlatformFactory;
import us.pinguo.user.request.TwitterLogin;
import us.pinguo.user.ui.n0;
import us.pinguo.user.util.BaseInfoResult;
import us.pinguo.user.v0;
import us.pinguo.user.w0;
/* compiled from: FastLoginPresenter.java */
/* loaded from: classes6.dex */
public class n0 extends us.pinguo.foundation.p.a {
    private o0 a;
    private Activity b;
    private Fragment c;

    /* renamed from: d  reason: collision with root package name */
    private com.facebook.d f12440d;

    /* renamed from: e  reason: collision with root package name */
    private int f12441e;

    /* renamed from: f  reason: collision with root package name */
    private int f12442f;

    /* renamed from: g  reason: collision with root package name */
    private String f12443g;

    /* renamed from: h  reason: collision with root package name */
    private int f12444h;

    /* renamed from: i  reason: collision with root package name */
    private AlertDialog f12445i;

    /* compiled from: FastLoginPresenter.java */
    /* loaded from: classes6.dex */
    class a implements HmsLoginCallBack {
        a() {
        }

        @Override // com.huawei.HmsLoginCallBack
        public void onLoginSuccess(AuthHuaweiId authHuaweiId) {
            if (authHuaweiId != null) {
                us.pinguo.foundation.statistics.h.a.g(Constants.REFERRER_API_HUAWEI, n0.this.f12443g, FirebaseAnalytics.Param.SUCCESS);
                n0.this.j(v0.c(authHuaweiId.getOpenId(), authHuaweiId.getAccessToken(), authHuaweiId.getDisplayName(), authHuaweiId.getAvatarUriString()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FastLoginPresenter.java */
    /* loaded from: classes6.dex */
    public class b implements PlatformActionListener {
        final /* synthetic */ String a;
        final /* synthetic */ BaseInfoResult b;

        b(String str, BaseInfoResult baseInfoResult) {
            this.a = str;
            this.b = baseInfoResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(BaseInfoResult baseInfoResult, String str, Void r4) {
            if (us.pinguo.user.util.n.m(User.d().h(), baseInfoResult.isChina())) {
                n0.this.i();
                n0.this.a.phoneBind();
                return;
            }
            n0.this.i();
            n0.this.a.dismiss();
            us.pinguo.foundation.statistics.h.a.g(str, n0.this.f12443g, FirebaseAnalytics.Param.SUCCESS);
            Bundle bundle = new Bundle();
            bundle.putString("bind_mobile", User.d().h().mobile);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            n0.this.h(true, intent);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(String str, Throwable th) {
            us.pinguo.foundation.e.e(th);
            us.pinguo.common.log.a.f(th);
            if (th instanceof Fault) {
                Toast makeText = Toast.makeText(us.pinguo.foundation.e.b(), us.pinguo.user.api.f0.a(us.pinguo.foundation.e.b(), ((Fault) th).getStatus()), 0);
                makeText.show();
                VdsAgent.showToast(makeText);
            }
            n0.this.i();
            us.pinguo.foundation.statistics.h.a.g(str, n0.this.f12443g, "failed");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(Platform platform, final String str, final BaseInfoResult baseInfoResult) {
            n0 n0Var = n0.this;
            n0Var.I(n0Var.b.getString(R.string.login_progress_logining));
            n0.this.addSubscription(v0.j(platform, str, baseInfoResult.isChina()).subscribe(new Action1() { // from class: us.pinguo.user.ui.g
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    n0.b.this.b(baseInfoResult, str, (Void) obj);
                }
            }, new Action1() { // from class: us.pinguo.user.ui.f
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    n0.b.this.d(str, (Throwable) obj);
                }
            }));
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onCancel(Platform platform, int i2) {
            us.pinguo.foundation.statistics.h.a.g(this.a, n0.this.f12443g, "cancel");
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onComplete(final Platform platform, int i2, HashMap<String, Object> hashMap) {
            Activity activity = n0.this.b;
            final String str = this.a;
            final BaseInfoResult baseInfoResult = this.b;
            activity.runOnUiThread(new Runnable() { // from class: us.pinguo.user.ui.h
                @Override // java.lang.Runnable
                public final void run() {
                    n0.b.this.f(platform, str, baseInfoResult);
                }
            });
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onError(Platform platform, int i2, Throwable th) {
            us.pinguo.foundation.e.e(th);
            us.pinguo.foundation.statistics.h.a.g(this.a, n0.this.f12443g, "failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FastLoginPresenter.java */
    /* loaded from: classes6.dex */
    public class c implements com.facebook.e<com.facebook.login.d> {
        final /* synthetic */ BaseInfoResult a;

        c(BaseInfoResult baseInfoResult) {
            this.a = baseInfoResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(BaseInfoResult baseInfoResult, Void r4) {
            if (!us.pinguo.user.util.n.m(User.d().h(), baseInfoResult.isChina())) {
                v0.i(n0.this.f12442f, n0.this.f12444h);
                n0.this.i();
                n0.this.a.dismiss();
                us.pinguo.foundation.statistics.h.a.g("facebook", n0.this.f12443g, FirebaseAnalytics.Param.SUCCESS);
                return;
            }
            n0.this.i();
            n0.this.a.phoneBind();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d(Throwable th) {
            us.pinguo.foundation.e.e(th);
            us.pinguo.common.log.a.f(th);
            n0.this.i();
            us.pinguo.foundation.statistics.h.a.g("facebook", n0.this.f12443g, "failed");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f(AccessToken accessToken, final BaseInfoResult baseInfoResult) {
            String b = v0.b(accessToken.u(), accessToken.t(), null, accessToken.n().getTime() - accessToken.p().getTime());
            n0 n0Var = n0.this;
            n0Var.I(n0Var.b.getString(R.string.login_progress_logining));
            n0.this.addSubscription(v0.k(b, "facebook", baseInfoResult.isChina()).subscribe(new Action1() { // from class: us.pinguo.user.ui.i
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    n0.c.this.b(baseInfoResult, (Void) obj);
                }
            }, new Action1() { // from class: us.pinguo.user.ui.k
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    n0.c.this.d((Throwable) obj);
                }
            }));
        }

        @Override // com.facebook.e
        /* renamed from: g */
        public void onSuccess(com.facebook.login.d dVar) {
            us.pinguo.common.log.a.e("onLoginSuccess:facebook", new Object[0]);
            final AccessToken a = dVar.a();
            Activity activity = n0.this.b;
            final BaseInfoResult baseInfoResult = this.a;
            activity.runOnUiThread(new Runnable() { // from class: us.pinguo.user.ui.j
                @Override // java.lang.Runnable
                public final void run() {
                    n0.c.this.f(a, baseInfoResult);
                }
            });
        }

        @Override // com.facebook.e
        public void onCancel() {
            us.pinguo.common.log.a.e("onLoginCancel:facebook", new Object[0]);
            us.pinguo.foundation.statistics.h.a.g("facebook", n0.this.f12443g, "cancel");
        }

        @Override // com.facebook.e
        public void onError(FacebookException facebookException) {
            us.pinguo.common.log.a.e("onLoginError:facebook:" + facebookException.toString(), new Object[0]);
            us.pinguo.foundation.statistics.h.a.g("facebook", n0.this.f12443g, "failed");
        }
    }

    private void g(final Platform platform, final String str) {
        us.pinguo.user.util.n.a.h(new us.pinguo.user.util.g() { // from class: us.pinguo.user.ui.o
            @Override // us.pinguo.user.util.g
            public final void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
                n0.this.m(str, platform, baseInfoResult, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str) {
        us.pinguo.user.util.n.a.h(new us.pinguo.user.util.g() { // from class: us.pinguo.user.ui.n
            @Override // us.pinguo.user.util.g
            public final void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
                n0.this.v(str, baseInfoResult, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void k() {
        Context b2 = us.pinguo.foundation.e.b();
        Toast makeText = Toast.makeText(b2, b2.getResources().getString(R.string.status_errorcode500), 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(String str, Platform platform, BaseInfoResult baseInfoResult, int i2) {
        if (baseInfoResult == null) {
            this.b.runOnUiThread(p.a);
            return;
        }
        if (TextUtils.isEmpty(this.f12443g)) {
            this.f12443g = us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
        }
        us.pinguo.foundation.statistics.h.a.g(str, this.f12443g, "click");
        v0.a(platform, new b(str, baseInfoResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void n() {
        Context b2 = us.pinguo.foundation.e.b();
        Toast makeText = Toast.makeText(b2, b2.getResources().getString(R.string.status_errorcode500), 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(BaseInfoResult baseInfoResult, Void r2) {
        if (us.pinguo.user.util.n.m(User.d().h(), baseInfoResult.isChina())) {
            i();
            this.a.phoneBind();
            return;
        }
        v0.i(this.f12442f, this.f12444h);
        i();
        this.a.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void r(Throwable th) {
        String str;
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
        if (th instanceof Fault) {
            str = us.pinguo.user.api.f0.a(us.pinguo.foundation.e.b(), ((Fault) th).getStatus());
            Toast makeText = Toast.makeText(us.pinguo.foundation.e.b(), str, 0);
            makeText.show();
            VdsAgent.showToast(makeText);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = this.b.getString(R.string.pg_login_fail);
        }
        us.pinguo.foundation.utils.j0.d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void t(String str, final BaseInfoResult baseInfoResult) {
        I(this.b.getString(R.string.login_progress_logining));
        addSubscription(v0.k(str, Constants.REFERRER_API_HUAWEI, baseInfoResult.isChina()).subscribe(new Action1() { // from class: us.pinguo.user.ui.l
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                n0.this.p(baseInfoResult, (Void) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.ui.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                n0.this.r((Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(final String str, final BaseInfoResult baseInfoResult, int i2) {
        if (baseInfoResult == null) {
            this.b.runOnUiThread(s.a);
        } else {
            this.b.runOnUiThread(new Runnable() { // from class: us.pinguo.user.ui.r
                @Override // java.lang.Runnable
                public final void run() {
                    n0.this.t(str, baseInfoResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void w() {
        Context b2 = us.pinguo.foundation.e.b();
        Toast makeText = Toast.makeText(b2, b2.getResources().getString(R.string.status_errorcode500), 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(BaseInfoResult baseInfoResult, int i2) {
        if (baseInfoResult == null) {
            this.b.runOnUiThread(m.a);
        } else {
            z(baseInfoResult);
        }
    }

    private void z(BaseInfoResult baseInfoResult) {
        if (TextUtils.isEmpty(this.f12443g)) {
            this.f12443g = us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
        }
        us.pinguo.foundation.statistics.h.a.g("facebook", this.f12443g, "click");
        us.pinguo.foundation.statistics.l.onEvent(this.b, "fast_login_fb_click");
        LoginManager.getInstance().m();
        LoginManager.getInstance().q(this.f12440d, new c(baseInfoResult));
        try {
            if (this.c != null) {
                LoginManager.getInstance().k(this.c, null);
            } else {
                LoginManager.getInstance().j(this.b, null);
            }
        } catch (IllegalStateException e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    public void A(int i2, int i3, Intent intent) {
        this.f12440d.onActivityResult(i2, i3, intent);
        if (i2 == 1005) {
            i();
            if (i3 == -1) {
                this.a.dismiss();
                v0.i(this.f12442f, this.f12444h);
                return;
            }
            User.s();
        }
    }

    public void B() {
        if (TextUtils.isEmpty(this.f12443g)) {
            this.f12443g = us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
        }
        us.pinguo.foundation.statistics.h.a.g(FirebaseAnalytics.Event.LOGIN, this.f12443g, "click");
        us.pinguo.foundation.statistics.l.onEvent(this.b, "fast_login_c360_click");
        Intent intent = new Intent();
        Activity activity = this.b;
        intent.setClassName(activity, "us.pinguo.user.ui.PGLoginMainActivity");
        w0.j(3);
        if (activity.getClass().getName().equals("us.pinguo.inspire.module.vote.VoteActivity")) {
            intent.putExtra("key_login_from", "login_from_get_points");
        }
        intent.putExtra("context_data", this.f12442f);
        intent.putExtra(FastLoginDialog.KEY_RESOURCE, this.f12443g);
        intent.putExtra(FastLoginDialog.KEY_REQ_CODE, this.f12441e);
        activity.startActivityForResult(intent, this.f12441e);
        this.a.dismiss();
    }

    public void C() {
        us.pinguo.user.util.n.a.h(new us.pinguo.user.util.g() { // from class: us.pinguo.user.ui.q
            @Override // us.pinguo.user.util.g
            public final void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
                n0.this.y(baseInfoResult, i2);
            }
        });
    }

    public void D() {
        if (TextUtils.isEmpty(this.f12443g)) {
            this.f12443g = us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
        }
        us.pinguo.foundation.statistics.h.a.g(Constants.REFERRER_API_HUAWEI, this.f12443g, "click");
        us.pinguo.foundation.statistics.l.onEvent(this.b, "fast_login_huawei_click");
        HuaweiAgent.get().signIn(this.b, new a());
    }

    public void E() {
        if (TextUtils.isEmpty(this.f12443g)) {
            this.f12443g = us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
        }
        us.pinguo.foundation.statistics.h.a.g(FindFriendHeaderCell.TWITTER, this.f12443g, "click");
        us.pinguo.foundation.statistics.l.onEvent(this.b, "fast_login_tw_click");
        new TwitterLogin(this.b).get(null);
    }

    public void F() {
        us.pinguo.foundation.statistics.l.onEvent(this.b, "fast_login_wb_click");
        g(ThridSitePlatformFactory.getSinaWeibo(), "sina");
    }

    public void G() {
        us.pinguo.foundation.statistics.l.onEvent(this.b, "fast_login_wx_click");
        if (us.pinguo.share.d.a.b(this.b, ShareSite.WECHAT_FRIENDS)) {
            g(ThridSitePlatformFactory.getWechat(), ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
            return;
        }
        Toast makeText = Toast.makeText(this.b, R.string.share_not_install_app, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    public void H(String str) {
        this.f12443g = str;
    }

    protected void I(CharSequence charSequence) {
        if (this.f12445i == null) {
            this.f12445i = us.pinguo.foundation.utils.w.q(this.b, charSequence);
        }
        AlertDialog alertDialog = this.f12445i;
        alertDialog.show();
        VdsAgent.showDialog(alertDialog);
    }

    public void attachView(us.pinguo.foundation.p.b bVar) {
        o0 o0Var = (o0) bVar;
        this.a = o0Var;
        this.b = o0Var.getActivity();
        this.c = this.a.getFragment();
        this.f12440d = d.a.a();
        PGEventBus.getInstance().b(this);
        if (!us.pinguo.foundation.utils.z.b(Locale.getDefault()) && !com.facebook.f.z()) {
            com.facebook.f.F(us.pinguo.foundation.e.b());
        }
        if (this.a.getArguments() != null) {
            this.f12441e = this.a.getArguments().getInt(FastLoginDialog.KEY_REQ_CODE);
            this.f12444h = this.a.getArguments().getInt(FastLoginDialog.KEY_REQ_CODE);
            this.f12442f = this.a.getArguments().getInt(FastLoginDialog.KEY_POSITION, -999);
            this.f12443g = this.a.getArguments().getString(FastLoginDialog.KEY_RESOURCE);
        }
    }

    @Override // us.pinguo.foundation.p.a
    public void detachView() {
        super.detachView();
        PGEventBus.getInstance().c(this);
    }

    public void h(boolean z, Intent intent) {
        if (z) {
            i();
            v0.i(this.f12442f, this.f12444h);
            try {
                Activity activity = this.b;
                Class cls = Integer.TYPE;
                Method declaredMethod = Activity.class.getDeclaredMethod("onActivityResult", cls, cls, Intent.class);
                declaredMethod.setAccessible(true);
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf((int) CloseFrame.NOCODE);
                objArr[1] = Integer.valueOf(z ? -1 : 0);
                objArr[2] = intent;
                declaredMethod.invoke(activity, objArr);
                return;
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
                return;
            }
        }
        User.s();
    }

    protected void i() {
        AlertDialog alertDialog = this.f12445i;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void onEvent(LoginEvent$LoginResultEvent loginEvent$LoginResultEvent) {
        if (loginEvent$LoginResultEvent != null) {
            if (loginEvent$LoginResultEvent.b() == 200) {
                v0.i(this.f12442f, this.f12444h);
                this.a.dismiss();
                return;
            }
            String a2 = loginEvent$LoginResultEvent.a();
            if (TextUtils.isEmpty(a2)) {
                a2 = this.b.getString(R.string.pg_login_fail);
            }
            Snackbar.W(this.a.getDecorView(), a2, -1).M();
        }
    }
}
