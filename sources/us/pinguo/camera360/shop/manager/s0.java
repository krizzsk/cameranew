package us.pinguo.camera360.shop.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.appcompat.app.AlertDialog;
import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.vip.VipManager;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowTopic;
import us.pinguo.camera360.shop.manager.ChoosePaywayDialog;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.foundation.utils.HWPayMessenger;
import us.pinguo.inspire.module.profile.FlowerLoader;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.paylibcenter.C360MemberPayHelp;
import us.pinguo.paylibcenter.OrderHelp;
import us.pinguo.paylibcenter.PayCallback;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.bean.PayCenterParm;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.user.User;
import us.pinguo.user.event.PayClickEvent;
import vStudio.Android.Camera360.R;
/* compiled from: PayCenter.java */
/* loaded from: classes4.dex */
public class s0 implements PayCallback, IPayCenter {
    private AlertDialog b;

    /* renamed from: d  reason: collision with root package name */
    private ShowPkg f9732d;
    protected t0 a = null;
    private ShowTopic c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PayCenter.java */
    /* loaded from: classes4.dex */
    public class a implements ChoosePaywayDialog.a {
        final /* synthetic */ Activity a;
        final /* synthetic */ PayCenterParm b;
        final /* synthetic */ PayCallback c;

        a(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback) {
            this.a = activity;
            this.b = payCenterParm;
            this.c = payCallback;
        }

        @Override // us.pinguo.camera360.shop.manager.ChoosePaywayDialog.a
        public void a() {
            s0.this.i().G(this.a, this.b, this.c);
        }

        @Override // us.pinguo.camera360.shop.manager.ChoosePaywayDialog.a
        public void b() {
            if (!us.pinguo.util.q.f(this.a)) {
                us.pinguo.foundation.utils.f.c(p.a);
            } else {
                C360MemberPayHelp.getInstance().D(this.a, PayHelp.PAYWAY.WOPay, this.b, this.c, "");
            }
        }

        @Override // us.pinguo.camera360.shop.manager.ChoosePaywayDialog.a
        public void c() {
            if (!us.pinguo.util.q.f(this.a)) {
                us.pinguo.foundation.utils.f.c(m.a);
            } else {
                s0.this.i().F(this.a, this.b, this.c);
            }
        }

        @Override // us.pinguo.camera360.shop.manager.ChoosePaywayDialog.a
        public void d() {
            if (!us.pinguo.util.q.f(this.a)) {
                us.pinguo.foundation.utils.f.c(n.a);
            } else {
                s0.this.i().H(this.a, this.b, this.c);
            }
        }

        @Override // us.pinguo.camera360.shop.manager.ChoosePaywayDialog.a
        public void e() {
            s0.this.i().E(this.a, this.b, this.c);
        }

        @Override // us.pinguo.camera360.shop.manager.ChoosePaywayDialog.a
        public void f() {
            if (!us.pinguo.util.q.f(this.a)) {
                us.pinguo.foundation.utils.f.c(o.a);
            } else {
                s0.this.i().B(this.a, this.b, this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PayCenter.java */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PayHelp.PAYWAY.values().length];
            a = iArr;
            try {
                iArr[PayHelp.PAYWAY.OtherPay.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PayHelp.PAYWAY.AliPay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PayHelp.PAYWAY.WxPay.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PayHelp.PAYWAY.GooglePay.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[PayHelp.PAYWAY.MolWebPay.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[PayHelp.PAYWAY.MiGuPay.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[PayHelp.PAYWAY.MMPay.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[PayHelp.PAYWAY.HuaweiIAP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[PayHelp.PAYWAY.WOPay.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* compiled from: PayCenter.java */
    /* loaded from: classes4.dex */
    private static class c {
        private static s0 a = new s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback) {
        a0(activity, payCenterParm, payCallback, !VipManager.a.G());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void E(Activity activity, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        if (i2 == -1) {
            PayResult obtain = PayResult.obtain(activity.getString(R.string.store_pay_success));
            obtain.setResultCode(0);
            obtain.setPayway(PayHelp.PAYWAY.OtherPay);
            d(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public /* synthetic */ void G(final Activity activity) {
        us.pinguo.foundation.utils.w.l(activity, "模拟Google支付", "支付成功", "支付失败", new DialogInterface.OnClickListener() { // from class: us.pinguo.camera360.shop.manager.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                s0.this.E(activity, dialogInterface, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public /* synthetic */ void J(PayResult payResult) {
        U();
        t0 t0Var = this.a;
        if (t0Var != null) {
            ShowTopic showTopic = this.c;
            if (showTopic != null) {
                t0Var.f(showTopic, this.f9732d);
                this.c = null;
                return;
            }
            ShowPkg showPkg = this.f9732d;
            if (showPkg != null) {
                t0Var.f(null, showPkg);
                this.f9732d = null;
                return;
            }
            t0Var.e(payResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public /* synthetic */ void L(PayResult payResult) {
        U();
        t0 t0Var = this.a;
        if (t0Var != null) {
            ShowTopic showTopic = this.c;
            if (showTopic != null) {
                t0Var.f(showTopic, this.f9732d);
                this.c = null;
            } else {
                ShowPkg showPkg = this.f9732d;
                if (showPkg != null) {
                    t0Var.f(null, showPkg);
                    this.f9732d = null;
                } else {
                    t0Var.g(payResult);
                }
            }
        }
        Z(payResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public /* synthetic */ void Q(PayResult payResult) {
        U();
        t0 t0Var = this.a;
        if (t0Var != null) {
            ShowTopic showTopic = this.c;
            if (showTopic != null) {
                t0Var.h(showTopic, this.f9732d);
                this.c = null;
            } else {
                ShowPkg showPkg = this.f9732d;
                if (showPkg != null) {
                    t0Var.h(null, showPkg);
                    this.f9732d = null;
                } else {
                    t0Var.d(payResult);
                }
            }
        }
        us.pinguo.foundation.utils.j0.c(R.string.store_pay_success);
    }

    private void a0(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback, boolean z) {
        if (g(activity)) {
            try {
                new ChoosePaywayDialog(activity, payCenterParm.isSupportHuawei(), payCenterParm.isSubscription, new a(activity, payCenterParm, payCallback)).g();
                PGEventBus.getInstance().a(new PayClickEvent());
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
                U();
                us.pinguo.foundation.utils.f.c(v.a);
            }
        }
    }

    private boolean g(Activity activity) {
        return (us.pinguo.util.c.f12470d && activity.isDestroyed()) ? false : true;
    }

    public static synchronized IPayCenter getInstance() {
        s0 s0Var;
        synchronized (s0.class) {
            s0Var = c.a;
        }
        return s0Var;
    }

    private void j() {
        if (HWPayMessenger.getInstance().b() == null) {
            return;
        }
        HWPayMessenger.getInstance().b().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: us.pinguo.camera360.shop.manager.b0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                s0.this.o((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m() {
        Activity ownerActivity;
        AlertDialog alertDialog = this.b;
        if (alertDialog == null || !alertDialog.isShowing() || (ownerActivity = this.b.getOwnerActivity()) == null || ownerActivity.isFinishing() || ownerActivity.isDestroyed()) {
            return;
        }
        this.b.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void o(Boolean bool) {
        if (bool.booleanValue()) {
            U();
            CrashReport.postCatchedException(new NullPointerException("caught NPE of HW payment"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void r(PayCenterParm payCenterParm, Activity activity, PayCallback payCallback, Object obj, String str) {
        if (!TextUtils.isEmpty(str) && OrderHelp.f(str, payCenterParm.getProductId())) {
            PayResult obtain = PayResult.obtain(activity.getString(R.string.store_pay_success));
            obtain.setResultCode(0);
            obtain.setPayway(PayHelp.PAYWAY.OtherPay);
            d(obtain);
            us.pinguo.common.log.a.c(obtain.getMessage(), new Object[0]);
            return;
        }
        Y(activity, payCenterParm, payCallback, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void v(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback) {
        if (g(activity)) {
            if (!payCenterParm.isSubscription) {
                this.b = us.pinguo.foundation.utils.w.p(activity, -999);
            }
            i().E(activity, payCenterParm, payCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ void y(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback) {
        if (g(activity)) {
            this.b = us.pinguo.foundation.utils.w.p(activity, -999);
            i().F(activity, payCenterParm, payCallback);
            PGEventBus.getInstance().a(new PayClickEvent());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(Activity activity, PayCenterParm payCenterParm, PayCallback payCallback) {
        a0(activity, payCenterParm, payCallback, false);
    }

    @Override // us.pinguo.paylibcenter.PayCallback
    public void H(final PayResult payResult) {
        us.pinguo.common.log.a.d("paycenter", "payFailed: " + payResult, new Object[0]);
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.j0
            @Override // java.lang.Runnable
            public final void run() {
                s0.this.L(payResult);
            }
        });
        if (payResult == null || payResult.getPayway() == null) {
            return;
        }
        switch (b.a[payResult.getPayway().ordinal()]) {
            case 1:
                us.pinguo.foundation.statistics.h.a.j(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "failed");
                return;
            case 2:
                CrashReport.postCatchedException(new RuntimeException("alipay failed:\ncode:" + payResult.getResultCode() + "\n" + payResult.getMessage()));
                us.pinguo.foundation.statistics.h.a.j("alipay", "failed");
                return;
            case 3:
                CrashReport.postCatchedException(new RuntimeException("wxpay failed:\ncode:" + payResult.getResultCode() + "\n" + payResult.getMessage()));
                us.pinguo.foundation.statistics.h.a.j(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, "failed");
                return;
            case 4:
                us.pinguo.foundation.statistics.h.a.j(Constants.REFERRER_API_GOOGLE, "failed");
                return;
            case 5:
                us.pinguo.foundation.statistics.h.a.j("molpay", "failed");
                return;
            case 6:
                us.pinguo.foundation.statistics.h.a.j("migupay", "failed");
                return;
            case 7:
                us.pinguo.foundation.statistics.h.a.j("mmpay", "failed");
                return;
            case 8:
                us.pinguo.foundation.statistics.h.a.j(Constants.REFERRER_API_HUAWEI, "failed");
                return;
            case 9:
                us.pinguo.foundation.statistics.h.a.j("wopay", "failed");
                return;
            default:
                return;
        }
    }

    @Override // us.pinguo.paylibcenter.PayCallback
    public void W() {
        us.pinguo.common.log.a.q("paycenter", "uploadOrderSuccess ");
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.t
            @Override // java.lang.Runnable
            public final void run() {
                s0.this.V();
            }
        });
    }

    protected void X(final Activity activity, final PayCenterParm payCenterParm, t0 t0Var, final Object obj) {
        try {
            if (!us.pinguo.util.q.f(activity)) {
                us.pinguo.foundation.utils.f.c(d0.a);
                return;
            }
            this.a = t0Var;
            OrderHelp.getInstance().e(activity, payCenterParm.getUserId(), 0, new OrderHelp.c() { // from class: us.pinguo.camera360.shop.manager.a0
                @Override // us.pinguo.paylibcenter.OrderHelp.c
                public final void a(String str) {
                    s0.this.r(payCenterParm, activity, this, obj, str);
                }
            }, null, "", new Object[0]);
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            us.pinguo.foundation.utils.f.c(h0.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y(final Activity activity, final PayCenterParm payCenterParm, final PayCallback payCallback, Object obj) {
        VipManager vipManager = VipManager.a;
        if (vipManager.G() && !vipManager.E()) {
            if (us.pinguo.foundation.d.f10991j) {
                activity.runOnUiThread(new Runnable() { // from class: us.pinguo.camera360.shop.manager.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        s0.this.G(activity);
                    }
                });
            } else if (i().y() != null) {
                us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        s0.this.v(activity, payCenterParm, payCallback);
                    }
                });
            } else {
                us.pinguo.foundation.utils.f.c(r.a);
            }
        } else if (HuaweiAgent.isHuaweiSupport()) {
            if (g(activity)) {
                if (k(activity)) {
                    us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            s0.this.y(activity, payCenterParm, payCallback);
                        }
                    });
                } else if (g(activity)) {
                    us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.c0
                        @Override // java.lang.Runnable
                        public final void run() {
                            s0.this.A(activity, payCenterParm, payCallback);
                        }
                    });
                }
            }
        } else {
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.u
                @Override // java.lang.Runnable
                public final void run() {
                    s0.this.C(activity, payCenterParm, payCallback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Z(PayResult payResult) {
        if (payResult != null) {
            int resultCode = payResult.getResultCode();
            if (resultCode != 3) {
                if (resultCode != 1000) {
                    if (resultCode != 2011) {
                        if (resultCode != 6002) {
                            switch (resultCode) {
                                case 9:
                                    break;
                                case 10:
                                    break;
                                case 11:
                                    us.pinguo.foundation.utils.j0.c(R.string.paylib_result_nosupport_wx);
                                    return;
                                default:
                                    int status = payResult.getStatus();
                                    if (us.pinguo.foundation.d.f10987f) {
                                        String str = BaseApplication.d().getResources().getString(R.string.store_pay_fail) + " status: " + status + " resultCode: " + payResult.getResultCode() + " " + payResult.getMessage();
                                        us.pinguo.common.log.a.d("paycenter", str, new Object[0]);
                                        us.pinguo.foundation.utils.j0.d(str);
                                    }
                                    if (status == 1000) {
                                        us.pinguo.foundation.utils.j0.c(R.string.pay_error_tips_currency_not_support);
                                        return;
                                    } else {
                                        us.pinguo.foundation.utils.j0.c(R.string.store_pay_fail);
                                        return;
                                    }
                            }
                        } else {
                            us.pinguo.foundation.utils.j0.c(R.string.network_not_available);
                            return;
                        }
                    }
                    us.pinguo.foundation.utils.j0.c(R.string.paylib_result_noinstall_wx);
                    return;
                }
                return;
            }
            us.pinguo.foundation.utils.j0.c(R.string.google_pay_unavailable);
        }
    }

    @Override // us.pinguo.camera360.shop.manager.IPayCenter
    public void a(Activity activity, ShowPkg showPkg, t0 t0Var) {
        CameraBusinessSettingModel.v().O(true);
        try {
            PayCenterParm payCenterParm = new PayCenterParm();
            payCenterParm.setProductId(showPkg.getId());
            payCenterParm.setPurchaseTag("c360");
            if (User.d().n() && User.d().h() != null) {
                payCenterParm.setUserId(User.d().h().userId);
            }
            us.pinguo.common.log.a.m("paycenter", "price: " + showPkg.getPayInfo().price, new Object[0]);
            payCenterParm.setGoogleId(showPkg.getPayInfo().pid);
            payCenterParm.setRequestCode(100);
            i().Y(us.pinguo.foundation.d.f10985d ? us.pinguo.foundation.d.b ? 1 : 0 : -1);
            i().v(us.pinguo.foundation.d.f10987f);
            String str = showPkg.getPayInfo().pid;
            us.pinguo.common.log.a.m("paycenter", "GoogleId: " + str, new Object[0]);
            this.f9732d = showPkg;
            if (k(activity)) {
                payCenterParm.setSupportHuawei(true);
                payCenterParm.setHuaweiAppId(HuaweiAgent.appId);
                payCenterParm.setHuaweiCpId(HuaweiAgent.cpId);
                payCenterParm.setHuaweiPublicKey(HuaweiAgent.publicKey);
            }
            X(activity, payCenterParm, t0Var, showPkg.getName());
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            us.pinguo.foundation.utils.f.c(i0.a);
        }
    }

    @Override // us.pinguo.camera360.shop.manager.IPayCenter
    public void b() {
        this.a = null;
        if (HWPayMessenger.getInstance() == null) {
            return;
        }
        HWPayMessenger.getInstance().a();
    }

    @Override // us.pinguo.camera360.shop.manager.IPayCenter
    public void c(Activity activity, t0 t0Var, String str) {
        try {
            this.c = null;
            this.f9732d = null;
            PayCenterParm payCenterParm = new PayCenterParm();
            payCenterParm.setProductId(str);
            int i2 = 1;
            payCenterParm.isSubscription = true;
            payCenterParm.setPurchaseTag("c360_iap");
            payCenterParm.setSupportGoogleOnly(true);
            if (User.d().n() && User.d().h() != null) {
                payCenterParm.setUserId(User.d().h().userId);
            }
            payCenterParm.setGoogleId(str);
            payCenterParm.setRequestCode(100);
            if (!us.pinguo.foundation.d.f10985d) {
                i2 = -1;
            } else if (!us.pinguo.foundation.d.b) {
                i2 = 0;
            }
            j();
            i().Y(i2);
            i().v(us.pinguo.foundation.d.f10987f);
            X(activity, payCenterParm, t0Var, "c360_member");
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            us.pinguo.foundation.utils.f.c(k0.a);
        }
    }

    @Override // us.pinguo.paylibcenter.PayCallback
    public void d(final PayResult payResult) {
        us.pinguo.common.log.a.q("paycenter", "paySuccess");
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.s
            @Override // java.lang.Runnable
            public final void run() {
                s0.this.Q(payResult);
            }
        });
        if (payResult == null || payResult.getPayway() == null) {
            return;
        }
        switch (b.a[payResult.getPayway().ordinal()]) {
            case 1:
                us.pinguo.foundation.statistics.h.a.j(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, FirebaseAnalytics.Param.SUCCESS);
                return;
            case 2:
                us.pinguo.foundation.statistics.h.a.j("alipay", FirebaseAnalytics.Param.SUCCESS);
                return;
            case 3:
                us.pinguo.foundation.statistics.h.a.j(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, FirebaseAnalytics.Param.SUCCESS);
                return;
            case 4:
                us.pinguo.foundation.statistics.h.a.j(Constants.REFERRER_API_GOOGLE, FirebaseAnalytics.Param.SUCCESS);
                return;
            case 5:
                us.pinguo.foundation.statistics.h.a.j("molpay", FirebaseAnalytics.Param.SUCCESS);
                return;
            case 6:
                us.pinguo.foundation.statistics.h.a.j("migupay", FirebaseAnalytics.Param.SUCCESS);
                return;
            case 7:
                us.pinguo.foundation.statistics.h.a.j("mmpay", FirebaseAnalytics.Param.SUCCESS);
                return;
            case 8:
                us.pinguo.foundation.statistics.h.a.j(Constants.REFERRER_API_HUAWEI, FirebaseAnalytics.Param.SUCCESS);
                return;
            case 9:
                us.pinguo.foundation.statistics.h.a.j("wopay", FirebaseAnalytics.Param.SUCCESS);
                return;
            default:
                return;
        }
    }

    @Override // us.pinguo.paylibcenter.PayCallback
    public void e(final PayResult payResult) {
        us.pinguo.common.log.a.r("paycenter", "payCancel", new Object[0]);
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.q
            @Override // java.lang.Runnable
            public final void run() {
                s0.this.J(payResult);
            }
        });
        if (payResult == null || payResult.getPayway() == null) {
            return;
        }
        switch (b.a[payResult.getPayway().ordinal()]) {
            case 1:
                us.pinguo.foundation.statistics.h.a.j(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "cancel");
                return;
            case 2:
                CrashReport.postCatchedException(new RuntimeException("alipay cancel:\n" + payResult.getMessage()));
                us.pinguo.foundation.statistics.h.a.j("alipay", "cancel");
                return;
            case 3:
                CrashReport.postCatchedException(new RuntimeException("wxpay cancel:\n" + payResult.getMessage()));
                us.pinguo.foundation.statistics.h.a.j(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, "cancel");
                return;
            case 4:
                us.pinguo.foundation.statistics.h.a.j(Constants.REFERRER_API_GOOGLE, "cancel");
                return;
            case 5:
                us.pinguo.foundation.statistics.h.a.j("molpay", "cancel");
                return;
            case 6:
                us.pinguo.foundation.statistics.h.a.j("migupay", "cancel");
                return;
            case 7:
                us.pinguo.foundation.statistics.h.a.j("mmpay", "cancel");
                return;
            case 8:
                us.pinguo.foundation.statistics.h.a.j(Constants.REFERRER_API_HUAWEI, "cancel");
                return;
            case 9:
                us.pinguo.foundation.statistics.h.a.j("wopay", "cancel");
                return;
            default:
                return;
        }
    }

    @Override // us.pinguo.camera360.shop.manager.IPayCenter
    public void f(Activity activity, t0 t0Var) {
        try {
            PayCenterParm payCenterParm = new PayCenterParm();
            payCenterParm.setPurchaseTag("challenge");
            payCenterParm.setProductId(FlowerLoader.INSTANCE.getGiftResp().getProductId());
            if (User.d().n() && User.d().h() != null) {
                payCenterParm.setUserId(User.d().h().userId);
            }
            payCenterParm.setGoogleId("challenge_gift_flowers");
            payCenterParm.setRequestCode(100);
            i().Y(us.pinguo.foundation.d.f10985d ? us.pinguo.foundation.d.b ? 1 : 0 : -1);
            i().v(us.pinguo.foundation.d.f10987f);
            if (k(activity)) {
                payCenterParm.setSupportHuawei(true);
                payCenterParm.setHuaweiAppId(HuaweiAgent.appId);
                payCenterParm.setHuaweiCpId(HuaweiAgent.cpId);
                payCenterParm.setHuaweiPublicKey(HuaweiAgent.publicKey);
            }
            X(activity, payCenterParm, t0Var, "flower");
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            us.pinguo.foundation.utils.f.c(g0.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void V() {
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.z
            @Override // java.lang.Runnable
            public final void run() {
                s0.this.m();
            }
        });
    }

    protected PayHelp i() {
        return PayHelp.getInstance();
    }

    public boolean k(Activity activity) {
        return HuaweiAgent.isHuaweiSupport();
    }

    @Override // us.pinguo.paylibcenter.PayCallback
    public void s() {
        us.pinguo.common.log.a.q("paycenter", "uploadOrderFail ");
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.e0
            @Override // java.lang.Runnable
            public final void run() {
                s0.this.T();
            }
        });
    }
}
