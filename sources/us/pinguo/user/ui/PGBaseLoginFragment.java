package us.pinguo.user.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import com.adjust.sdk.Constants;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.d;
import com.facebook.login.LoginManager;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.huawei.HmsLoginCallBack;
import com.huawei.HuaweiAgent;
import com.huawei.hms.support.hwid.result.AuthHuaweiId;
import com.mob.OperationCallback;
import com.tapjoy.TapjoyConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import java.util.Locale;
import rx.functions.Action1;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import us.pinguo.foundation.base.SubscriptionFragment;
import us.pinguo.foundation.network.Fault;
import us.pinguo.foundation.utils.r0;
import us.pinguo.inspire.module.contact.cell.FindFriendHeaderCell;
import us.pinguo.share.core.ShareSite;
import us.pinguo.user.R;
import us.pinguo.user.User;
import us.pinguo.user.model.ThridSitePlatformFactory;
import us.pinguo.user.request.TwitterLogin;
import us.pinguo.user.t0;
import us.pinguo.user.ui.AgreementDialogFragment;
import us.pinguo.user.ui.PGBaseLoginFragment;
import us.pinguo.user.ui.view.EditTextWithPrompt;
import us.pinguo.user.util.BaseInfoResult;
import us.pinguo.user.v0;
import us.pinguo.user.w0;
/* loaded from: classes6.dex */
public class PGBaseLoginFragment extends SubscriptionFragment implements EditTextWithPrompt.c, EditTextWithPrompt.e, View.OnClickListener, us.pinguo.foundation.statistics.e {
    private static boolean t = false;
    TextView a;
    EditTextWithPrompt b;
    EditText c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f12395d;

    /* renamed from: e  reason: collision with root package name */
    TextView f12396e;

    /* renamed from: f  reason: collision with root package name */
    GridView f12397f;

    /* renamed from: g  reason: collision with root package name */
    TextView f12398g;
    private AlertDialog o;
    private AlertDialog p;
    private us.pinguo.user.ui.p0.c q;
    private com.facebook.d r;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f12399h = false;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f12400i = false;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f12401j = true;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f12402k = false;

    /* renamed from: l  reason: collision with root package name */
    protected int f12403l = 0;
    protected int m = 0;
    protected int n = -999;
    private String s = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {

        /* renamed from: us.pinguo.user.ui.PGBaseLoginFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0459a implements AgreementDialogFragment.b {
            final /* synthetic */ View a;

            C0459a(View view) {
                this.a = view;
            }

            @Override // us.pinguo.user.ui.AgreementDialogFragment.b
            public void a() {
                PGBaseLoginFragment pGBaseLoginFragment = PGBaseLoginFragment.this;
                pGBaseLoginFragment.I0(this.a, pGBaseLoginFragment.s);
            }

            @Override // us.pinguo.user.ui.AgreementDialogFragment.b
            public void b() {
            }
        }

        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        @Instrumented
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            VdsAgent.onItemClick(this, adapterView, view, i2, j2);
            if (!us.pinguo.user.util.n.i() && !us.pinguo.user.util.n.k()) {
                PGBaseLoginFragment pGBaseLoginFragment = PGBaseLoginFragment.this;
                pGBaseLoginFragment.I0(view, pGBaseLoginFragment.s);
            } else if (PGBaseLoginFragment.this.getActivity() instanceof PGLoginMainActivity) {
                ((PGLoginMainActivity) PGBaseLoginFragment.this.getActivity()).K0(new C0459a(view));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends OperationCallback {
        final /* synthetic */ View a;
        final /* synthetic */ String b;

        /* loaded from: classes6.dex */
        class a implements com.facebook.e<com.facebook.login.d> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: us.pinguo.user.ui.PGBaseLoginFragment$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class RunnableC0460a implements Runnable {
                final /* synthetic */ AccessToken a;

                RunnableC0460a(AccessToken accessToken) {
                    this.a = accessToken;
                }

                @Override // java.lang.Runnable
                public void run() {
                    PGBaseLoginFragment.this.z0(v0.b(this.a.u(), this.a.t(), null, this.a.n().getTime() - this.a.p().getTime()), "facebook");
                }
            }

            a() {
            }

            @Override // com.facebook.e
            /* renamed from: a */
            public void onSuccess(com.facebook.login.d dVar) {
                us.pinguo.common.log.a.e("onLoginSuccess:facebook", new Object[0]);
                PGBaseLoginFragment.this.getActivity().runOnUiThread(new RunnableC0460a(dVar.a()));
            }

            @Override // com.facebook.e
            public void onCancel() {
                us.pinguo.common.log.a.e("onLoginCancel:facebook", new Object[0]);
            }

            @Override // com.facebook.e
            public void onError(FacebookException facebookException) {
                us.pinguo.common.log.a.e("onLoginError:facebook:" + facebookException.toString(), new Object[0]);
            }
        }

        b(View view, String str) {
            this.a = view;
            this.b = str;
        }

        @Override // com.mob.OperationCallback
        public void onComplete(Object obj) {
            String str = (String) this.a.getTag();
            if (str.equals("sina")) {
                w0.h(1);
                PGBaseLoginFragment.this.A0("sina");
            } else if (str.equals("qq")) {
                w0.h(0);
                PGBaseLoginFragment.this.A0("qq");
            } else if (str.equals("facebook")) {
                w0.h(2);
                LoginManager.getInstance().m();
                LoginManager.getInstance().q(PGBaseLoginFragment.this.r, new a());
                LoginManager.getInstance().k(PGBaseLoginFragment.this, null);
            } else if (str.equals(FindFriendHeaderCell.TWITTER)) {
                w0.h(3);
                new TwitterLogin(PGBaseLoginFragment.this.getContext()).get(null);
            } else if (str.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
                w0.h(4);
                Context b = us.pinguo.foundation.e.b();
                if (us.pinguo.share.d.a.b(b, ShareSite.WECHAT_FRIENDS)) {
                    PGBaseLoginFragment.this.A0(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
                } else {
                    Toast makeText = Toast.makeText(b, R.string.share_not_install_app, 0);
                    makeText.show();
                    VdsAgent.showToast(makeText);
                }
            } else if (str.equals(Constants.REFERRER_API_HUAWEI)) {
                w0.h(5);
                PGBaseLoginFragment.this.A0(Constants.REFERRER_API_HUAWEI);
            }
            us.pinguo.foundation.statistics.h.a.U(str, this.b, "click");
        }

        @Override // com.mob.OperationCallback
        public void onFailure(Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements HmsLoginCallBack {
        final /* synthetic */ String a;

        c(String str) {
            this.a = str;
        }

        @Override // com.huawei.HmsLoginCallBack
        public void onLoginSuccess(AuthHuaweiId authHuaweiId) {
            us.pinguo.foundation.statistics.h.a.U(this.a, PGBaseLoginFragment.this.s, FirebaseAnalytics.Param.SUCCESS);
            if (authHuaweiId != null) {
                PGBaseLoginFragment.this.z0(v0.c(authHuaweiId.getOpenId(), authHuaweiId.getAccessToken(), authHuaweiId.getDisplayName(), authHuaweiId.getAvatarUriString()), Constants.REFERRER_API_HUAWEI);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements PlatformActionListener {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(Platform platform, String str) {
            PlatformDb db = platform.getDb();
            PGBaseLoginFragment.this.z0(v0.b(db.getUserId(), db.getToken(), null, db.getExpiresIn() != 0 ? db.getExpiresIn() : 36000000L), str);
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onCancel(Platform platform, int i2) {
            us.pinguo.foundation.statistics.h.a.U(this.a, PGBaseLoginFragment.this.s, "cancel");
            us.pinguo.common.log.a.c("onLoginCancel:" + platform.getName(), new Object[0]);
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onComplete(final Platform platform, int i2, HashMap<String, Object> hashMap) {
            us.pinguo.common.log.a.c("onLoginComplete:" + platform.getName(), new Object[0]);
            final String str = this.a;
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.user.ui.u
                @Override // java.lang.Runnable
                public final void run() {
                    PGBaseLoginFragment.d.this.b(platform, str);
                }
            });
        }

        @Override // cn.sharesdk.framework.PlatformActionListener
        public void onError(Platform platform, int i2, Throwable th) {
            us.pinguo.foundation.statistics.h.a.U(this.a, PGBaseLoginFragment.this.s, "failed");
            us.pinguo.common.log.a.e("onLoginError:" + platform.getName() + th.toString(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e extends us.pinguo.foundation.ui.g {
        e() {
        }

        @Override // us.pinguo.foundation.ui.g, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            PGBaseLoginFragment pGBaseLoginFragment = PGBaseLoginFragment.this;
            if (pGBaseLoginFragment.f12399h) {
                pGBaseLoginFragment.f12399h = false;
                return;
            }
            if (PGBaseLoginFragment.this.g0(pGBaseLoginFragment.b.getText().toString())) {
                PGBaseLoginFragment pGBaseLoginFragment2 = PGBaseLoginFragment.this;
                int i2 = pGBaseLoginFragment2.m;
                if (i2 == 2 || i2 == 3) {
                    pGBaseLoginFragment2.z(2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(String str) {
        Platform platform;
        if ("sina".equals(str)) {
            platform = ThridSitePlatformFactory.getSinaWeibo();
        } else if ("qq".equals(str)) {
            platform = ThridSitePlatformFactory.getQQ();
        } else if (ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE.equals(str)) {
            platform = ThridSitePlatformFactory.getWechat();
        } else {
            if (Constants.REFERRER_API_HUAWEI.equals(str)) {
                HuaweiAgent.get().signIn(getActivity(), new c(str));
            }
            platform = null;
        }
        if (platform != null) {
            v0.a(platform, new d(str));
        }
    }

    private void C0() {
        this.c.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: us.pinguo.user.ui.b0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PGBaseLoginFragment.this.x0(view, z);
            }
        });
        this.c.addTextChangedListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(View view, String str) {
        if (!us.pinguo.util.q.f(getActivity().getApplicationContext())) {
            F0(getString(R.string.pg_login_network_exception));
        } else {
            us.pinguo.share.d.a.d(true, new b(view, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g0(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            int i2 = this.f12403l;
            if (i2 == 0) {
                string = us.pinguo.foundation.e.b().getResources().getString(R.string.pg_login_phone_or_email_empty_hint);
            } else if (i2 == 1) {
                string = us.pinguo.foundation.e.b().getResources().getString(R.string.pg_login_email_empty);
            } else {
                string = us.pinguo.foundation.e.b().getResources().getString(R.string.pg_login_phone_number_empty);
            }
            X(string, 1);
            return false;
        }
        int i3 = this.f12403l;
        if (i3 == 0) {
            boolean a2 = us.pinguo.util.t.a(str);
            boolean b2 = us.pinguo.util.t.b(str);
            if (!a2 && !b2) {
                X(us.pinguo.foundation.e.b().getResources().getString(R.string.pg_login_phone_or_email_format_error), 1);
                return false;
            }
        } else if (i3 == 1) {
            if (!us.pinguo.util.t.a(str)) {
                X(us.pinguo.foundation.e.b().getResources().getString(R.string.pg_login_email_format_error), 1);
                return false;
            }
        } else if (!us.pinguo.util.t.b(str)) {
            X(us.pinguo.foundation.e.b().getResources().getString(R.string.pg_login_phone_number_format_error), 1);
            return false;
        }
        return true;
    }

    private void initView() {
        String j2 = User.j();
        String i2 = User.i();
        this.b.setHideErrorPromptListener(this);
        this.f12395d.setOnClickListener(this);
        if (this.f12401j) {
            this.f12403l = 0;
            this.b.setHint(getString(R.string.login_email_or_phone));
            if (HuaweiAgent.isHuaweiSupport() && HuaweiAgent.isHuaweiPhone()) {
                this.q = new us.pinguo.user.ui.p0.c(t0.f12374e, t0.c, t0.a);
            } else {
                this.q = new us.pinguo.user.ui.p0.c(t0.f12375f, t0.f12373d, t0.b);
            }
            if (!TextUtils.isEmpty(j2) && !NotificationCompat.CATEGORY_EMAIL.equals(j2) && !TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE.equals(j2)) {
                this.b.setHint("");
                if (j2.equals(Constants.REFERRER_API_HUAWEI)) {
                    j2 = getActivity().getString(R.string.site_name_huawei);
                } else if (j2.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
                    j2 = getActivity().getString(R.string.site_name_wechat);
                } else if (j2.equals("qq")) {
                    j2 = getActivity().getString(R.string.site_name_qq);
                } else if (j2.equals("sina")) {
                    j2 = getActivity().getString(R.string.site_name_sina);
                } else if (j2.equals("facebook")) {
                    j2 = getActivity().getString(R.string.site_name_facebook);
                } else if (j2.equals(FindFriendHeaderCell.TWITTER)) {
                    j2 = getActivity().getString(R.string.site_name_twitter);
                }
                TextView textView = this.f12398g;
                textView.setText(getString(R.string.login_use_third_part_hint) + j2);
            } else if (!TextUtils.isEmpty(i2)) {
                this.b.setText(i2);
                this.b.setSelection(i2.length());
            }
        } else {
            this.b.setHint(getString(R.string.login_email));
            this.f12403l = 1;
            if (HuaweiAgent.isHuaweiSupport() && HuaweiAgent.isHuaweiPhone()) {
                this.q = new us.pinguo.user.ui.p0.c(t0.f12380k, t0.f12378i, t0.f12376g);
            } else {
                this.q = new us.pinguo.user.ui.p0.c(t0.f12381l, t0.f12379j, t0.f12377h);
            }
            if (!TextUtils.isEmpty(j2) && !NotificationCompat.CATEGORY_EMAIL.equals(j2) && !TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE.equals(j2)) {
                this.b.setHint("");
                if (j2.equals(Constants.REFERRER_API_HUAWEI)) {
                    j2 = getActivity().getString(R.string.site_name_huawei);
                } else if (j2.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
                    j2 = getActivity().getString(R.string.site_name_wechat);
                } else if (j2.equals("qq")) {
                    j2 = getActivity().getString(R.string.site_name_qq);
                } else if (j2.equals("sina")) {
                    j2 = getActivity().getString(R.string.site_name_sina);
                } else if (j2.equals("facebook")) {
                    j2 = getActivity().getString(R.string.site_name_facebook);
                } else if (j2.equals(FindFriendHeaderCell.TWITTER)) {
                    j2 = getActivity().getString(R.string.site_name_twitter);
                }
                TextView textView2 = this.f12398g;
                textView2.setText(getString(R.string.login_use_third_part_hint) + j2);
            } else if (!TextUtils.isEmpty(i2)) {
                this.b.setText(i2);
                this.b.setSelection(i2.length());
            }
        }
        this.f12397f.setNumColumns(this.q.getCount());
        this.f12397f.setAdapter((ListAdapter) this.q);
        this.f12397f.setOnItemClickListener(new a());
        C0();
        i0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void l0(String str, Void r4) {
        h0();
        B0();
        us.pinguo.foundation.statistics.h.a.U(str, this.s, FirebaseAnalytics.Param.SUCCESS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void n0(String str, Throwable th) {
        us.pinguo.foundation.statistics.h.a.U(str, this.s, "failed");
        us.pinguo.common.log.a.f(th);
        us.pinguo.foundation.e.e(th);
        h0();
        String a2 = th instanceof Fault ? us.pinguo.user.api.f0.a(getActivity(), ((Fault) th).getStatus()) : null;
        if (TextUtils.isEmpty(a2)) {
            a2 = getString(R.string.pg_login_fail);
        }
        F0(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void p0(BaseInfoResult baseInfoResult, String str, final String str2) {
        if (baseInfoResult == null) {
            F0(getString(R.string.pg_login_network_exception));
            h0();
            return;
        }
        G0(getString(R.string.login_progress_logining));
        addSubscription(v0.k(str, str2, baseInfoResult.isChina()).subscribe(new Action1() { // from class: us.pinguo.user.ui.v
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PGBaseLoginFragment.this.l0(str2, (Void) obj);
            }
        }, new Action1() { // from class: us.pinguo.user.ui.z
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                PGBaseLoginFragment.this.n0(str2, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void r0(final String str, final String str2, final BaseInfoResult baseInfoResult, int i2) {
        D0(new Runnable() { // from class: us.pinguo.user.ui.a0
            @Override // java.lang.Runnable
            public final void run() {
                PGBaseLoginFragment.this.p0(baseInfoResult, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void t0() {
        this.b.setHint(getString(R.string.login_email_or_phone));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void v0(BaseInfoResult baseInfoResult, int i2) {
        if (baseInfoResult != null && baseInfoResult.isChina()) {
            this.f12401j = true;
            D0(new Runnable() { // from class: us.pinguo.user.ui.t
                @Override // java.lang.Runnable
                public final void run() {
                    PGBaseLoginFragment.this.t0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void x0(View view, boolean z) {
        if (!z || this.f12402k) {
            return;
        }
        this.f12402k = true;
        if (this.f12396e.getVisibility() != 0) {
            g0(this.b.getText().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void y0(DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(final String str, final String str2) {
        us.pinguo.user.util.n.a.h(new us.pinguo.user.util.g() { // from class: us.pinguo.user.ui.w
            @Override // us.pinguo.user.util.g
            public final void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
                PGBaseLoginFragment.this.r0(str, str2, baseInfoResult, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B0() {
        FragmentActivity activity = getActivity();
        if (activity instanceof PGLoginMainActivity) {
            ((PGLoginMainActivity) activity).G0();
        }
    }

    @Override // us.pinguo.foundation.statistics.e
    public String C() {
        return "login_page";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D0(Runnable runnable) {
        FragmentActivity activity = getActivity();
        if (activity instanceof PGLoginMainActivity) {
            ((PGLoginMainActivity) activity).I0(runnable);
        }
    }

    protected void E0(String str) {
        TextView textView = this.f12396e;
        if (textView != null) {
            textView.setVisibility(0);
            VdsAgent.onSetViewVisibility(textView, 0);
            this.f12396e.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F0(String str) {
        Snackbar.W(getView(), str, -1).M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G0(CharSequence charSequence) {
        if (this.o == null) {
            this.o = us.pinguo.foundation.utils.w.q(getContext(), charSequence);
        }
        AlertDialog alertDialog = this.o;
        alertDialog.show();
        VdsAgent.showDialog(alertDialog);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H0() {
        AlertDialog alertDialog = this.p;
        if (alertDialog == null || !alertDialog.isShowing()) {
            AlertDialog g2 = us.pinguo.foundation.utils.w.g(getContext(), -999, R.string.status_errorcode10540, R.string.share_ok, -999, x.a);
            this.p = g2;
            g2.setCancelable(false);
            this.p.setCanceledOnTouchOutside(false);
            AlertDialog alertDialog2 = this.p;
            alertDialog2.show();
            VdsAgent.showDialog(alertDialog2);
        }
    }

    @Override // us.pinguo.user.ui.view.EditTextWithPrompt.c
    public void R(int i2) {
    }

    @Override // us.pinguo.user.ui.view.EditTextWithPrompt.e
    public int V() {
        return this.f12403l;
    }

    @Override // us.pinguo.user.ui.view.EditTextWithPrompt.c
    public void X(String str, int i2) {
        this.m = i2;
        if (i2 == 1) {
            R(4);
        }
        E0(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h0() {
        AlertDialog alertDialog = this.o;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    protected void i0() {
        TextView textView = this.f12396e;
        if (textView != null) {
            textView.setVisibility(4);
            VdsAgent.onSetViewVisibility(textView, 4);
            this.f12396e.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j0(EditText editText) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.r.onActivityResult(i2, i3, intent);
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public void onClick(View view) {
        VdsAgent.onClick(this, view);
        if (view.getId() == R.id.register_password_eye) {
            view.setClickable(false);
            r0.d(view, true, 500);
            this.f12399h = true;
            boolean z = !this.f12400i;
            this.f12400i = z;
            this.f12395d.setSelected(z);
            Editable text = this.c.getText();
            this.c.setInputType(1 | (this.f12400i ? IjkMediaMeta.FF_PROFILE_H264_HIGH_444 : 128));
            this.c.setSelection(text.length());
            this.c.setTypeface(Typeface.DEFAULT);
        }
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!t) {
            com.facebook.f.d();
            t = true;
        }
        this.r = d.a.a();
        this.f12401j = us.pinguo.foundation.utils.z.b(Locale.getDefault());
        if (bundle == null) {
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.n = intent.getIntExtra("context_data", -999);
                this.s = intent.getStringExtra(FastLoginDialog.KEY_RESOURCE);
            }
        } else {
            this.n = bundle.getInt("context_data");
            this.s = bundle.getString(FastLoginDialog.KEY_RESOURCE);
        }
        if (TextUtils.isEmpty(this.s)) {
            this.s = us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_login_main_fragment, (ViewGroup) null);
        this.a = (TextView) inflate.findViewById(R.id.login_confirm_btn);
        this.b = (EditTextWithPrompt) inflate.findViewById(R.id.login_account);
        this.c = (EditText) inflate.findViewById(R.id.login_password);
        this.f12395d = (ImageView) inflate.findViewById(R.id.register_password_eye);
        this.f12396e = (TextView) inflate.findViewById(R.id.login_error_tips);
        this.f12397f = (GridView) inflate.findViewById(R.id.login_third_site_gridView);
        this.f12398g = (TextView) inflate.findViewById(R.id.third_part_login_hint);
        if (!this.f12401j) {
            us.pinguo.user.util.n.a.h(new us.pinguo.user.util.g() { // from class: us.pinguo.user.ui.y
                @Override // us.pinguo.user.util.g
                public final void onFetchBaseInfo(BaseInfoResult baseInfoResult, int i2) {
                    PGBaseLoginFragment.this.v0(baseInfoResult, i2);
                }
            });
        }
        initView();
        return inflate;
    }

    @Override // us.pinguo.foundation.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("context_data", this.n);
    }

    @Override // us.pinguo.user.ui.view.EditTextWithPrompt.c
    public void z(int i2) {
        int i3 = this.m;
        if (i3 == 1 && i2 == 2) {
            return;
        }
        if (i3 == 2 && i2 == 1) {
            return;
        }
        i0();
    }
}
