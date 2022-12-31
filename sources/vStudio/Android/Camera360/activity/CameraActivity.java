package vStudio.Android.Camera360.activity;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.homepage.e0;
import com.pinguo.camera360.vip.VipManager;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import org.json.JSONObject;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.advsdk.a.b;
import us.pinguo.advsdk.manager.LaunchScreenManager;
import us.pinguo.advstrategy.PgAdvStrategyManager;
import us.pinguo.advstrategy.strategybean.StrategyItem;
import us.pinguo.bigalbum.BigAlbumConfig;
import us.pinguo.bigalbum.BigAlbumManager;
import us.pinguo.camera360.shop.data.install.v;
import us.pinguo.camera360.shop.download.RequestIntervalPref;
import us.pinguo.common.network.HttpStringRequest;
import us.pinguo.foundation.base.BaseActivity;
import us.pinguo.foundation.d;
import us.pinguo.foundation.j;
import us.pinguo.foundation.utils.AsyncTask;
import us.pinguo.foundation.utils.x;
import us.pinguo.inspire.Inspire;
import us.pinguo.interaction.h0;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.permissionlib.PermissionManager;
import us.pinguo.push.PushPreference;
import us.pinguo.repository2020.abtest.ABTestManager;
import us.pinguo.user.User;
import us.pinguo.user.u0;
import us.pinguo.user.util.n;
import us.pinguo.util.q;
import us.pinguo.widget.common.guide.GuideHandler;
import vStudio.Android.Camera360.Conditions;
import vStudio.Android.Camera360.R;
import vStudio.Android.Camera360.a;
import vStudio.Android.Camera360.activity.i;
import vStudio.Android.Camera360.guide.AgreementDialogFragment;
import vStudio.Android.Camera360.guide.GuideFragment;
import vStudio.Android.Camera360.guide.GuidePicFilmFragment;
import vStudio.Android.Camera360.guide.PrivacyFragment;
/* loaded from: classes7.dex */
public class CameraActivity extends BaseActivity implements a.InterfaceC0470a {
    private static boolean m = false;
    private GuideFragment a;
    private PrivacyFragment b;
    private AgreementDialogFragment c;

    /* renamed from: d  reason: collision with root package name */
    private vStudio.Android.Camera360.a f12583d;

    /* renamed from: j  reason: collision with root package name */
    private PermissionManager f12589j;

    /* renamed from: e  reason: collision with root package name */
    private int f12584e = 0;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f12585f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12586g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f12587h = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12588i = false;

    /* renamed from: k  reason: collision with root package name */
    private int f12590k = -1;

    /* renamed from: l  reason: collision with root package name */
    private boolean f12591l = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a implements b.InterfaceC0356b {
        a() {
        }

        @Override // us.pinguo.advsdk.a.b.InterfaceC0356b
        public void a() {
            CameraActivity.this.s0(false);
        }

        @Override // us.pinguo.advsdk.a.b.InterfaceC0356b
        public void b(String str) {
            us.pinguo.advsdk.utils.b.a("launchScreenError:" + str);
            CameraActivity.this.s0(false);
        }

        @Override // us.pinguo.advsdk.a.b.InterfaceC0356b
        public void c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class b extends HttpStringRequest {
        final /* synthetic */ boolean a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CameraActivity cameraActivity, int i2, String str, boolean z) {
            super(i2, str);
            this.a = z;
        }

        @Override // com.android.volley.Request
        protected Map<String, String> getParams() {
            HashMap hashMap = new HashMap();
            u0.e(BaseApplication.d(), hashMap);
            hashMap.put("actionType", this.a ? "1" : "0");
            us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
            return hashMap;
        }

        @Override // us.pinguo.common.network.HttpRequestBase
        protected void onErrorResponse(Exception exc) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // us.pinguo.common.network.HttpRequestBase
        public void onResponse(String str) {
            try {
                if (new JSONObject().optInt("status", 0) == 200) {
                    CameraBusinessSettingModel.v().E("need_update_count", false);
                    CameraBusinessSettingModel.v().a();
                }
                us.pinguo.common.log.a.g("Frisky", "updateCount:" + str, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class c extends BigAlbumConfig {
        c() {
        }

        @Override // us.pinguo.bigalbum.BigAlbumConfig
        public String getAppChannel() {
            return us.pinguo.foundation.utils.i.a();
        }

        @Override // us.pinguo.bigalbum.BigAlbumConfig
        public String getAppName() {
            return "camera360";
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends v {
        @Override // us.pinguo.camera360.shop.data.install.v
        protected boolean o(boolean z) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B0 */
    public /* synthetic */ void C0() {
        x.a.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D0 */
    public /* synthetic */ void E0(AdvItem advItem) {
        this.f12590k = this.f12583d.k();
        GuideFragment d2 = this.f12583d.d(false, 0);
        this.a = d2;
        if (d2 != null) {
            setContentView(R.layout.welcome);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            View findViewById = findViewById(R.id.guide_view);
            findViewById.setVisibility(0);
            VdsAgent.onSetViewVisibility(findViewById, 0);
            beginTransaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
            GuideFragment guideFragment = this.a;
            VdsAgent.onFragmentTransactionReplace(beginTransaction, R.id.guide_view, guideFragment, beginTransaction.replace(R.id.guide_view, guideFragment));
            beginTransaction.commitAllowingStateLoss();
            if (!(this.a instanceof GuidePicFilmFragment)) {
                y0();
            }
        } else {
            h0.a.a();
            if (vStudio.Android.Camera360.guide.f.a.a.c()) {
                M0();
            } else if (!LaunchScreenManager.getInstance().c() && advItem == null) {
                if (LaunchScreenManager.getInstance().g(IADStatisticBase.UNIT_ID_SPLASH)) {
                    LaunchScreenManager.getInstance().f(this, IADStatisticBase.UNIT_ID_SPLASH, new a());
                } else {
                    s0(false);
                }
            } else {
                Fragment i2 = this.f12583d.i();
                if (i2 != null) {
                    boolean j2 = this.f12583d.j();
                    FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
                    View findViewById2 = findViewById(R.id.welcome_ad_view);
                    findViewById2.setVisibility(0);
                    VdsAgent.onSetViewVisibility(findViewById2, 0);
                    beginTransaction2.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                    VdsAgent.onFragmentTransactionReplace(beginTransaction2, R.id.welcome_ad_view, i2, beginTransaction2.replace(R.id.welcome_ad_view, i2));
                    beginTransaction2.commitAllowingStateLoss();
                    if (!j2) {
                        y0();
                    }
                    z0();
                } else {
                    s0(false);
                }
            }
        }
        f.b(this.f12584e);
        if (!CameraBusinessSettingModel.v().m()) {
            t0();
        }
        us.pinguo.camera360.shop.data.install.x.a(true);
        us.pinguo.common.log.a.k("C360_STAT->CPU ABI:" + us.pinguo.foundation.n.b.a(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void G0() {
        try {
            String b2 = e0.b(getApplicationContext());
            String a2 = e0.a(getApplicationContext());
            us.pinguo.util.d.f12479d = b2;
            us.pinguo.util.d.f12480e = a2;
            if (b2.equals("F2:DD:CA:64:5E:22:EC:6B:E2:3E:93:F6:54:6D:73:8C:4C:6B:75:F1") && a2.equals("01:B6:CA:7F:4E:66:FC:2B:A4:28:67:C5:3E:C6:AC:DD:0C:80:E5:1C:66:E0:76:B8:27:E0:82:48:AE:95:9A:ED")) {
                us.pinguo.foundation.statistics.h.b.m("false");
            } else {
                us.pinguo.foundation.statistics.h.b.m("true");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public /* synthetic */ void I0(boolean z, long j2) {
        this.f12585f = true;
        P0();
    }

    private void J0(boolean z) {
        if (us.pinguo.util.v.j()) {
            BigAlbumManager.instance().init(BaseApplication.d(), new c());
        }
        if (z && this.f12583d != null) {
            HuaweiAgent.get().connectAndUpdate(this);
            AsyncTask f2 = this.f12583d.f(new i.c() { // from class: vStudio.Android.Camera360.activity.a
                @Override // vStudio.Android.Camera360.activity.i.c
                public final void a(boolean z2, long j2) {
                    CameraActivity.this.I0(z2, j2);
                }
            });
            if (f2 != null) {
                f2.executeOnExecutor(Executors.newSingleThreadExecutor(), new Object[0]);
                return;
            }
            this.f12585f = true;
            P0();
            return;
        }
        w0(2);
    }

    private void K0(boolean z) {
        int i2 = this.f12587h;
        if (i2 < d.a.f10995f && i2 > d.a.a && User.d().n()) {
            CameraBusinessSettingModel.v().E("key_disable_data_collect", false);
            u0.o = false;
        }
        z0();
        J0(z);
    }

    private void L0() {
        PushPreference pushPreference = new PushPreference(this);
        pushPreference.g("pref_first_use_time", System.currentTimeMillis());
        pushPreference.e("pref_first_use", true);
        pushPreference.a();
    }

    private void M0() {
        if (this.f12591l) {
            return;
        }
        CameraBusinessSettingModel.v().E("key_is_privace_dialog_shown", true);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        AgreementDialogFragment agreementDialogFragment = (AgreementDialogFragment) supportFragmentManager.findFragmentByTag("agreement_dialog");
        this.c = agreementDialogFragment;
        if (agreementDialogFragment == null) {
            AgreementDialogFragment agreementDialogFragment2 = new AgreementDialogFragment();
            this.c = agreementDialogFragment2;
            agreementDialogFragment2.setCancelable(false);
            this.c.setAllowEnterTransitionOverlap(false);
            this.c.setAllowReturnTransitionOverlap(false);
            this.c.show(supportFragmentManager, "agreement_dialog");
        }
    }

    private void N0() {
        if (!vStudio.Android.Camera360.guide.f.a.a.c()) {
            n.a.h(null);
            CameraBusinessSettingModel.v().E("key_disable_data_collect", false);
            u0.o = false;
            s0(true);
            return;
        }
        M0();
    }

    private void O0(boolean z) {
        if (!q.f(us.pinguo.util.v.a())) {
            CameraBusinessSettingModel.v().a();
        } else if (m) {
        } else {
            m = true;
            b bVar = new b(this, 1, u0.c + "/api/user/disagree-count", z);
            bVar.setRetryPolicy(u0.a());
            bVar.execute();
        }
    }

    private void P0() {
        GuideFragment guideFragment;
        if (this.f12585f && (guideFragment = this.a) != null) {
            if (this.f12586g) {
                w0(2);
                return;
            } else {
                guideFragment.b0();
                return;
            }
        }
        w0(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(boolean z) {
        if (us.pinguo.util.c.f12476j) {
            z0();
            J0(z);
            return;
        }
        K0(z);
    }

    private void t0() {
        if (CameraBusinessSettingModel.v().s()) {
            return;
        }
        us.pinguo.foundation.utils.f.b(vStudio.Android.Camera360.activity.d.a);
    }

    private void u0() {
        com.pinguo.camera360.d.a = true;
        CameraBusinessSettingModel.v().L(false);
        us.pinguo.librouter.b.b.b().getInterface().d(false);
        us.pinguo.bigdata.a.m(false);
        CameraBusinessSettingModel.v().E("key_disable_data_collect", true);
        try {
            u0.o = true;
            j.a.f.i iVar = j.a.f.i.a;
            iVar.d(false);
            iVar.c(false);
            com.pinguo.camera360.d.b();
        } catch (Throwable unused) {
        }
    }

    private void v0() {
        AgreementDialogFragment agreementDialogFragment = this.c;
        if (agreementDialogFragment != null) {
            agreementDialogFragment.dismissAllowingStateLoss();
        }
        this.c = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
        if (r4 == 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void w0(int r6) {
        /*
            r5 = this;
            com.pinguo.camera360.utils.StatisticSetupUtils.d()
            us.pinguo.repository2020.m r6 = us.pinguo.repository2020.m.a
            us.pinguo.repository2020.u r6 = r6.A()
            java.lang.Object r6 = r6.getValue()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            com.pinguo.camera360.k.b.a.b.d(r6)
            int r0 = r5.f12590k
            r1 = 0
            r2 = -1
            if (r6 == 0) goto L58
            r6 = 2131298714(0x7f09099a, float:1.8215409E38)
            android.view.View r6 = r5.findViewById(r6)
            r3 = 2131297210(0x7f0903ba, float:1.8212358E38)
            android.view.View r3 = r5.findViewById(r3)
            if (r6 == 0) goto L33
            int r4 = r6.getVisibility()
            if (r4 != 0) goto L33
            goto L3e
        L33:
            if (r3 == 0) goto L3d
            int r6 = r3.getVisibility()
            if (r6 != 0) goto L3d
            r6 = r3
            goto L3e
        L3d:
            r6 = r1
        L3e:
            if (r0 == r2) goto L51
            if (r6 == 0) goto L51
            java.lang.String r1 = "union_transition"
            r6.setTransitionName(r1)
            android.app.ActivityOptions r1 = android.app.ActivityOptions.makeSceneTransitionAnimation(r5, r6, r1)
            android.os.Bundle r1 = r1.toBundle()
            r5.f12590k = r2
        L51:
            int r3 = r5.f12584e
            vStudio.Android.Camera360.activity.g.b(r5, r3, r0, r1)
            r1 = r6
            goto L8c
        L58:
            com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel r6 = com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel.v()
            java.lang.String r3 = r6.i()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L79
            java.lang.String r4 = "bc833a31761642e78dc09c16e4366dd8"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L79
            java.lang.String r4 = "c205e3582b514d6fb5c21a953e1e901e"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L77
            goto L79
        L77:
            r3 = 0
            goto L7a
        L79:
            r3 = 1
        L7a:
            android.content.Intent r4 = us.pinguo.foundation.b.a(r5)
            if (r3 != 0) goto L89
            java.lang.String r6 = r6.p()
            java.lang.String r3 = "bundle_key_mode"
            r4.putExtra(r3, r6)
        L89:
            r5.startActivity(r4)
        L8c:
            us.pinguo.foundation.statistics.c r6 = us.pinguo.foundation.statistics.h.a
            boolean r3 = us.pinguo.foundation.f.d()
            if (r3 == 0) goto L97
            java.lang.String r3 = "arm64"
            goto L99
        L97:
            java.lang.String r3 = "armv7"
        L99:
            r6.V(r3)
            r5.finish()
            if (r0 == r2) goto La3
            if (r1 != 0) goto Lac
        La3:
            r6 = 2130772006(0x7f010026, float:1.7147118E38)
            r0 = 2130772007(0x7f010027, float:1.714712E38)
            r5.overridePendingTransition(r6, r0)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: vStudio.Android.Camera360.activity.CameraActivity.w0(int):void");
    }

    private void y0() {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.start_bg_color);
        }
    }

    private void z0() {
        if (this.f12588i) {
            return;
        }
        this.f12588i = true;
        ABTestManager.a.w();
        VipManager.a.A(BaseApplication.d());
    }

    @Override // vStudio.Android.Camera360.a.InterfaceC0470a
    public void n(int i2, String str) {
        if (i2 == 1) {
            w0(2);
        } else if (i2 == 2) {
            this.f12583d.a();
            w0(i2);
        } else if (i2 == 16) {
            if (this.f12584e == 1) {
                N0();
            } else {
                s0(true);
            }
        } else if (i2 != 64) {
        } else {
            if (TextUtils.isEmpty(str)) {
                w0(2);
            } else {
                us.pinguo.foundation.b.a = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.f12589j.r(i2, i3, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        j.e().q("hairCut", us.pinguo.util.h.b(getWindow().getDecorView()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        NotificationManager notificationManager;
        this.f12588i = false;
        this.mEnableBaseNotch = false;
        super.onCreate(bundle);
        if (bundle == null) {
            Window window = getWindow();
            window.requestFeature(12);
            window.requestFeature(13);
            window.setAllowEnterTransitionOverlap(false);
            window.setAllowReturnTransitionOverlap(false);
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(R.transition.union_ad_transition);
            window.setSharedElementExitTransition(inflateTransition);
            window.setSharedElementEnterTransition(inflateTransition);
        }
        setContentView(R.layout.welcome);
        View findViewById = findViewById(R.id.welcome_layout);
        if (findViewById != null) {
            us.pinguo.foundation.ui.c.b(findViewById, new Runnable() { // from class: vStudio.Android.Camera360.activity.e
                @Override // java.lang.Runnable
                public final void run() {
                    CameraActivity.this.C0();
                }
            });
        }
        this.f12589j = new PermissionManager(this, us.pinguo.foundation.d.f10987f);
        vStudio.Android.Camera360.a aVar = new vStudio.Android.Camera360.a();
        this.f12583d = aVar;
        this.f12584e = aVar.g();
        this.f12587h = this.f12583d.e();
        int z = CameraBusinessSettingModel.v().z();
        if (z == -1) {
            CameraBusinessSettingModel.v().F("key_new_user_flag", 0);
            CameraBusinessSettingModel.v().G("key_app_install_time", System.currentTimeMillis() / 1000);
        } else if (z == 0) {
            CameraBusinessSettingModel.v().F("key_new_user_flag", 1);
        }
        if (this.f12584e != 1) {
            z0();
            VipManager vipManager = VipManager.a;
            if (vipManager.g(true)) {
                com.pinguo.camera360.adv.c.h();
            }
            us.pinguo.foundation.statistics.h.a.o(vipManager.I() ? "vip" : Constants.NORMAL);
        } else if (Conditions.e()) {
            ABTestManager.a.w();
        }
        long j2 = 0;
        if (this.f12584e != 0) {
            h0.a.d();
            if (this.f12587h <= d.a.b && Build.VERSION.SDK_INT >= 24 && (notificationManager = (NotificationManager) getSystemService("notification")) != null && notificationManager.isNotificationPolicyAccessGranted()) {
                CameraBusinessSettingModel.v().T(true);
            }
            RequestIntervalPref.a.f(us.pinguo.camera360.shop.download.a.b, null);
            L0();
            us.pinguo.foundation.base.e.e(this, "key_pref_first_show_dialog_tips", true);
            i.h(this.f12587h, this.f12583d.c());
            CameraBusinessSettingModel v = CameraBusinessSettingModel.v();
            if (this.f12584e == 1) {
                v.H("key_watermark_new", "小米印度".equals(us.pinguo.foundation.utils.i.a()) ? "off" : TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON);
                CameraBusinessSettingModel.v().c();
                GuideHandler k2 = GuideHandler.k(this);
                k2.H("timing_stop_setting_guide", 1);
                k2.u("timing_stop_setting_guide", 1);
            } else if (this.f12587h <= d.a.c) {
                String t = v.t("key_watermark_new", null);
                String t2 = v.t("key_watermark_type", null);
                if (t == null && t2 == null) {
                    String t3 = v.t("pref_camera_timewatermake_key", "off");
                    String t4 = v.t("pref_camera_picture_watermark_key", "off");
                    if (TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON.equals(t3)) {
                        v.H("key_watermark_new", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON);
                        v.H("key_watermark_type", "2");
                    } else if (TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON.equals(t4)) {
                        v.H("key_watermark_new", TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON);
                        v.H("key_watermark_type", "0");
                    } else {
                        v.H("key_watermark_new", "off");
                        v.H("key_watermark_type", "0");
                    }
                }
            }
            if (this.f12584e == 2) {
                CameraBusinessSettingModel.v().G("key_app_update_time", System.currentTimeMillis() / 1000);
                if (this.f12587h <= d.a.f10994e) {
                    Inspire.c().edit().putLong("PhoneBindActivity_request_time", 0L).apply();
                }
            }
            v.G("key_last_upate_effect_sticker_time", 0L);
            v.G("key_last_upate_store_time", 0L);
        }
        u0.r = CameraBusinessSettingModel.v().q("key_app_install_time", 0L);
        u0.s = CameraBusinessSettingModel.v().q("key_app_update_time", 0L);
        StrategyItem strategyItem = PgAdvStrategyManager.getInstance().getStrategyKeeper(this).getStrategyItem(IADStatisticBase.UNIT_ID_SPLASH);
        final AdvItem item = AdvConfigManager.getInstance().getItem("83e8038d279dd0745afb5c0d6c727aa7");
        if (strategyItem != null && strategyItem.realTimeLoad == 1 && TJAdUnitConstants.String.SPLIT_VIEW_TRIGGER_ON.equals(strategyItem.on_off) && strategyItem.waterfall.size() > 0 && item == null) {
            new com.pinguo.camera360.adv.e.a(this, IADStatisticBase.UNIT_ID_SPLASH, null).d(null);
            j2 = strategyItem.waitTime;
        }
        new Handler().postDelayed(new Runnable() { // from class: vStudio.Android.Camera360.activity.c
            @Override // java.lang.Runnable
            public final void run() {
                CameraActivity.this.E0(item);
            }
        }, j2);
        us.pinguo.share.d.a.d(!CameraBusinessSettingModel.v().x() || us.pinguo.foundation.utils.i.c(), null);
        us.pinguo.share.d.a.c(true);
        us.pinguo.foundation.utils.f.b(new Runnable() { // from class: vStudio.Android.Camera360.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                CameraActivity.this.G0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AgreementDialogFragment agreementDialogFragment = this.c;
        if (agreementDialogFragment != null) {
            agreementDialogFragment.dismissAllowingStateLoss();
        }
        this.c = null;
        PermissionManager permissionManager = this.f12589j;
        if (permissionManager != null) {
            permissionManager.d();
            this.f12589j = null;
        }
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        PrivacyFragment privacyFragment = this.b;
        if (privacyFragment != null && privacyFragment.isVisible()) {
            x0(null);
        }
        if (this.f12585f || i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (CameraBusinessSettingModel.v().y()) {
            CameraBusinessSettingModel.v().O(false);
            us.pinguo.foundation.base.e.f(BaseApplication.d(), "pref_key_newshop_order_version", 0);
            RequestIntervalPref.a.f(u0.f12384f, null);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        this.f12589j.s(i2, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.foundation.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f12589j.v();
        requestCheckIsFullDisplay(-1);
        if (us.pinguo.foundation.b.a) {
            us.pinguo.foundation.b.a = false;
            this.f12590k = -1;
            w0(2);
        }
    }

    public void q0(boolean z) {
        this.f12591l = true;
        us.pinguo.share.d.a.d(z || us.pinguo.foundation.utils.i.c(), null);
        View findViewById = findViewById(R.id.welcome_privacy);
        findViewById.setVisibility(4);
        VdsAgent.onSetViewVisibility(findViewById, 4);
        if (z) {
            CameraBusinessSettingModel.v().E("key_disable_data_collect", false);
            CameraBusinessSettingModel.v().E("key_is_need_privace_dialog_init_sdk", true);
            long q = CameraBusinessSettingModel.v().q("pref_privacy_cur_update_date", 0L);
            if (q > 0) {
                CameraBusinessSettingModel.v().G("pref_privacy_update_date", q);
            }
            u0.o = false;
            v0();
            s0(true);
        } else {
            CameraBusinessSettingModel.v().E("key_is_need_privace_dialog_init_sdk", false);
            u0();
            v0();
            s0(true);
        }
        O0(z);
        n.a.h(null);
        new us.pinguo.camera360.App.e().e(BaseApplication.e());
    }

    public void x0(String str) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        if (str == null) {
            M0();
            View findViewById = findViewById(R.id.welcome_privacy);
            findViewById.setVisibility(4);
            VdsAgent.onSetViewVisibility(findViewById, 4);
            if (this.b != null) {
                supportFragmentManager.beginTransaction().hide(this.b).commitAllowingStateLoss();
                return;
            }
            return;
        }
        PrivacyFragment privacyFragment = (PrivacyFragment) supportFragmentManager.findFragmentByTag("agreement_url");
        this.b = privacyFragment;
        if (privacyFragment == null) {
            this.b = new PrivacyFragment();
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            this.b.setArguments(bundle);
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            PrivacyFragment privacyFragment2 = this.b;
            FragmentTransaction replace = beginTransaction.replace(R.id.welcome_privacy, privacyFragment2);
            VdsAgent.onFragmentTransactionReplace(beginTransaction, R.id.welcome_privacy, privacyFragment2, replace);
            replace.commitAllowingStateLoss();
        } else {
            privacyFragment.e0(str);
            FragmentTransaction beginTransaction2 = supportFragmentManager.beginTransaction();
            PrivacyFragment privacyFragment3 = this.b;
            FragmentTransaction show = beginTransaction2.show(privacyFragment3);
            VdsAgent.onFragmentShow(beginTransaction2, privacyFragment3, show);
            show.commitAllowingStateLoss();
        }
        View findViewById2 = findViewById(R.id.welcome_privacy);
        findViewById2.setVisibility(0);
        VdsAgent.onSetViewVisibility(findViewById2, 0);
        AgreementDialogFragment agreementDialogFragment = this.c;
        if (agreementDialogFragment != null) {
            agreementDialogFragment.dismissAllowingStateLoss();
            this.c = null;
        }
    }
}
