package us.pinguo.camera360.shop.manager;

import android.app.Activity;
import cn.sharesdk.wechat.friends.Wechat;
import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.paylibcenter.C360MemberPayHelp;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.bean.PayCenterParm;
import us.pinguo.paylibcenter.bean.PayResult;
import us.pinguo.payssion.PayssionManager;
import us.pinguo.user.User;
import vStudio.Android.Camera360.R;
/* compiled from: C360MemberPayCenter.java */
/* loaded from: classes4.dex */
public class n0 extends s0 {

    /* renamed from: e  reason: collision with root package name */
    private RechargeGoodsDiscountInfo f9725e;

    /* renamed from: f  reason: collision with root package name */
    protected v0 f9726f = null;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f9727g = Boolean.TRUE;

    /* compiled from: C360MemberPayCenter.java */
    /* loaded from: classes4.dex */
    static /* synthetic */ class a {
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
            try {
                a[PayHelp.PAYWAY.PayssionPay.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c0 */
    public /* synthetic */ void d0() {
        U();
        v0 v0Var = this.f9726f;
        if (v0Var != null) {
            v0Var.i(false, this.f9725e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e0 */
    public /* synthetic */ void f0(PayResult payResult) {
        U();
        v0 v0Var = this.f9726f;
        if (v0Var != null) {
            v0Var.i(false, this.f9725e);
        }
        Z(payResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void h0() {
        U();
        v0 v0Var = this.f9726f;
        if (v0Var != null) {
            v0Var.i(true, this.f9725e);
        }
        us.pinguo.foundation.utils.j0.c(R.string.store_pay_success);
    }

    @Override // us.pinguo.camera360.shop.manager.s0, us.pinguo.paylibcenter.PayCallback
    public void H(final PayResult payResult) {
        us.pinguo.common.log.a.d("C360MemberPayCenter", "payFailed: " + payResult, new Object[0]);
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.d
            @Override // java.lang.Runnable
            public final void run() {
                n0.this.f0(payResult);
            }
        });
        if (payResult == null || payResult.getPayway() == null) {
            return;
        }
        switch (a.a[payResult.getPayway().ordinal()]) {
            case 1:
                us.pinguo.foundation.statistics.h.a.j(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "failed");
                return;
            case 2:
                us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                cVar.j("alipay", "failed");
                if (this.f9727g.booleanValue()) {
                    cVar.t("pay_fail", "Alipay", this.f9725e.getProductId(), "feedback");
                    return;
                }
                return;
            case 3:
                us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
                cVar2.j(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, "failed");
                if (this.f9727g.booleanValue()) {
                    cVar2.t("pay_fail", Wechat.NAME, this.f9725e.getProductId(), "feedback");
                    return;
                }
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
            case 10:
                us.pinguo.foundation.statistics.c cVar3 = us.pinguo.foundation.statistics.h.a;
                cVar3.j("payssion", "failed");
                if (this.f9727g.booleanValue()) {
                    cVar3.t("pay_fail", "Payssion", this.f9725e.getProductId() + PGTransHeader.CONNECTOR + PayssionManager.INSTANCE.getCurrentPmId(), "feedback");
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // us.pinguo.camera360.shop.manager.s0, us.pinguo.paylibcenter.PayCallback
    public void d(PayResult payResult) {
        us.pinguo.common.log.a.q("C360MemberPayCenter", "paySuccess");
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                n0.this.h0();
            }
        });
        if (payResult == null || payResult.getPayway() == null) {
            return;
        }
        switch (a.a[payResult.getPayway().ordinal()]) {
            case 1:
                us.pinguo.foundation.statistics.h.a.j(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, FirebaseAnalytics.Param.SUCCESS);
                return;
            case 2:
                us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                cVar.j("alipay", FirebaseAnalytics.Param.SUCCESS);
                if (this.f9727g.booleanValue()) {
                    cVar.t(FirebaseAnalytics.Param.SUCCESS, "Alipay", this.f9725e.getProductId(), "feedback");
                    return;
                }
                return;
            case 3:
                us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
                cVar2.j(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, FirebaseAnalytics.Param.SUCCESS);
                if (this.f9727g.booleanValue()) {
                    cVar2.t(FirebaseAnalytics.Param.SUCCESS, Wechat.NAME, this.f9725e.getProductId(), "feedback");
                    return;
                }
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
            case 10:
                us.pinguo.foundation.statistics.c cVar3 = us.pinguo.foundation.statistics.h.a;
                cVar3.j("payssion", FirebaseAnalytics.Param.SUCCESS);
                if (this.f9727g.booleanValue()) {
                    cVar3.t(FirebaseAnalytics.Param.SUCCESS, "Payssion", this.f9725e.getProductId() + PGTransHeader.CONNECTOR + PayssionManager.INSTANCE.getCurrentPmId(), "feedback");
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // us.pinguo.camera360.shop.manager.s0, us.pinguo.paylibcenter.PayCallback
    public void e(PayResult payResult) {
        us.pinguo.common.log.a.r("C360MemberPayCenter", "payCancel", new Object[0]);
        us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.c
            @Override // java.lang.Runnable
            public final void run() {
                n0.this.d0();
            }
        });
        if (payResult == null || payResult.getPayway() == null) {
            return;
        }
        switch (a.a[payResult.getPayway().ordinal()]) {
            case 1:
                us.pinguo.foundation.statistics.h.a.j(us.pinguo.inspire.cell.recycler.a.PAGE_TYPE_OTHER, "cancel");
                return;
            case 2:
                us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                cVar.j("alipay", "cancel");
                if (this.f9727g.booleanValue()) {
                    cVar.t("user_cancel", "Alipay", this.f9725e.getProductId(), "feedback");
                    return;
                }
                return;
            case 3:
                us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
                cVar2.j(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, "cancel");
                if (this.f9727g.booleanValue()) {
                    cVar2.t("user_cancel", Wechat.NAME, this.f9725e.getProductId(), "feedback");
                    return;
                }
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
            case 10:
                us.pinguo.foundation.statistics.c cVar3 = us.pinguo.foundation.statistics.h.a;
                cVar3.j("payssion", "cancel");
                if (this.f9727g.booleanValue()) {
                    cVar3.t("user_cancel", "Payssion", this.f9725e.getProductId() + PGTransHeader.CONNECTOR + PayssionManager.INSTANCE.getCurrentPmId(), "feedback");
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // us.pinguo.camera360.shop.manager.s0
    protected PayHelp i() {
        us.pinguo.common.log.a.k("C360MemberPayCenter getPayHelpInstance", new Object[0]);
        return C360MemberPayHelp.getInstance();
    }

    public void i0(Activity activity, RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo, v0 v0Var) {
        try {
            this.f9727g = Boolean.valueOf("vip_month_12".equals(rechargeGoodsDiscountInfo.getProductId()));
            PayCenterParm payCenterParm = new PayCenterParm();
            payCenterParm.setPurchaseTag("c360_vip");
            payCenterParm.setProductId(rechargeGoodsDiscountInfo.getProductId());
            if (User.d().n() && User.d().h() != null) {
                payCenterParm.setUserId(User.d().h().userId);
            }
            int i2 = 0;
            us.pinguo.common.log.a.m("C360MemberPayCenter", "price: " + rechargeGoodsDiscountInfo.getPrice() + " googleId = " + rechargeGoodsDiscountInfo.getProductId(), new Object[0]);
            payCenterParm.setGoogleId(rechargeGoodsDiscountInfo.getProductId());
            payCenterParm.setRequestCode(100);
            if (!us.pinguo.foundation.d.f10985d) {
                i2 = -1;
            } else if (us.pinguo.foundation.d.b) {
                i2 = 1;
            }
            i().Y(i2);
            i().v(us.pinguo.foundation.d.f10987f);
            if (k(activity)) {
                payCenterParm.setSupportHuawei(true);
                payCenterParm.setHuaweiAppId(HuaweiAgent.appId);
                payCenterParm.setHuaweiCpId(HuaweiAgent.cpId);
                payCenterParm.setHuaweiPublicKey(HuaweiAgent.publicKey);
            }
            Y(activity, payCenterParm, this, rechargeGoodsDiscountInfo.getTitle());
            this.f9725e = rechargeGoodsDiscountInfo;
            this.f9726f = v0Var;
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            us.pinguo.foundation.utils.f.c(b.a);
        }
    }
}
