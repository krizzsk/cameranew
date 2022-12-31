package us.pinguo.camera360.shop.manager;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.wechat.friends.Wechat;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.List;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.payssion.PayssionManager;
import us.pinguo.payssion.PayssionPayway;
import us.pinguo.user.util.BaseInfoResult;
import vStudio.Android.Camera360.R;
/* compiled from: ChoosePaywayDialog.kt */
/* loaded from: classes4.dex */
public final class ChoosePaywayDialog extends o0 {

    /* renamed from: d  reason: collision with root package name */
    private final Activity f9708d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f9709e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f9710f;

    /* renamed from: g  reason: collision with root package name */
    private final a f9711g;

    /* compiled from: ChoosePaywayDialog.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    /* compiled from: ChoosePaywayDialog.kt */
    /* loaded from: classes4.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PayHelp.PAYWAY.values().length];
            iArr[PayHelp.PAYWAY.WxPay.ordinal()] = 1;
            iArr[PayHelp.PAYWAY.AliPay.ordinal()] = 2;
            iArr[PayHelp.PAYWAY.GooglePay.ordinal()] = 3;
            iArr[PayHelp.PAYWAY.HuaweiIAP.ordinal()] = 4;
            iArr[PayHelp.PAYWAY.WOPay.ordinal()] = 5;
            iArr[PayHelp.PAYWAY.PayssionPay.ordinal()] = 6;
            a = iArr;
        }
    }

    /* compiled from: ChoosePaywayDialog.kt */
    /* loaded from: classes4.dex */
    public static final class c extends us.pinguo.foundation.ui.b {
        c() {
        }

        @Override // us.pinguo.foundation.ui.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.s.h(animation, "animation");
            ChoosePaywayDialog.super.a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChoosePaywayDialog(Activity activity, boolean z, boolean z2, a paywayCallback) {
        super(activity, R.layout.pay_choosepayway_dialog);
        kotlin.jvm.internal.s.h(activity, "activity");
        kotlin.jvm.internal.s.h(paywayCallback, "paywayCallback");
        this.f9708d = activity;
        this.f9709e = z;
        this.f9710f = z2;
        this.f9711g = paywayCallback;
        Window window = c().getWindow();
        if (window != null) {
            window.clearFlags(1024);
        }
        q();
        ((TextView) b().findViewById(R.id.cancelBt)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.camera360.shop.manager.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChoosePaywayDialog.h(ChoosePaywayDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ChoosePaywayDialog this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        this$0.k();
    }

    private final void k() {
        try {
            us.pinguo.foundation.utils.f.c(new Runnable() { // from class: us.pinguo.camera360.shop.manager.e
                @Override // java.lang.Runnable
                public final void run() {
                    ChoosePaywayDialog.l(ChoosePaywayDialog.this);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ChoosePaywayDialog this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (this$0.e()) {
            this$0.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(PayHelp.PAYWAY payway, String str) {
        switch (b.a[payway.ordinal()]) {
            case 1:
                this.f9711g.d();
                k();
                us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                cVar.j(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE, "click");
                if (this.f9710f) {
                    cVar.t("", Wechat.NAME, "vip_month_12", "click");
                    return;
                }
                return;
            case 2:
                this.f9711g.f();
                k();
                us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
                cVar2.j("alipay", "click");
                if (this.f9710f) {
                    cVar2.t("", "Alipay", "vip_month_12", "click");
                    return;
                }
                return;
            case 3:
                this.f9711g.e();
                k();
                us.pinguo.foundation.statistics.h.a.j(Constants.REFERRER_API_GOOGLE, "click");
                return;
            case 4:
                this.f9711g.c();
                k();
                us.pinguo.foundation.statistics.h.a.j(Constants.REFERRER_API_HUAWEI, "click");
                return;
            case 5:
                this.f9711g.b();
                k();
                us.pinguo.foundation.statistics.h.a.j("wopay", "click");
                return;
            case 6:
                PayssionManager.INSTANCE.setCurrentPmId(str);
                this.f9711g.a();
                k();
                us.pinguo.foundation.statistics.c cVar3 = us.pinguo.foundation.statistics.h.a;
                cVar3.j("payssion", "click");
                if (this.f9710f) {
                    cVar3.t("", "Payssion", kotlin.jvm.internal.s.q("vip_month_12-", str), "click");
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void n(String str, int i2, PayHelp.PAYWAY payway, String str2) {
        PaywayItem paywayItem = new PaywayItem(this.f9708d);
        paywayItem.setData(str, i2, payway, str2);
        paywayItem.setClickCallback(new ChoosePaywayDialog$creatPayItem$1(this));
        ((LinearLayout) b().findViewById(R.id.paywayContainer)).addView(paywayItem);
    }

    static /* synthetic */ void o(ChoosePaywayDialog choosePaywayDialog, String str, int i2, PayHelp.PAYWAY payway, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        choosePaywayDialog.n(str, i2, payway, str2);
    }

    private final void q() {
        if (PayHelp.getInstance().y() != null) {
            BaseInfoResult g2 = us.pinguo.user.util.n.a.g();
            boolean z = false;
            if (g2 != null && !g2.isMainlandChina()) {
                z = true;
            }
            if (z) {
                String string = p().getString(R.string.paylib_choose_google_str);
                kotlin.jvm.internal.s.g(string, "activity.getString(R.str…paylib_choose_google_str)");
                o(this, string, R.drawable.icon_google_logo, PayHelp.PAYWAY.GooglePay, null, 8, null);
            }
        }
        if (this.f9709e) {
            String string2 = this.f9708d.getString(R.string.paylib_choose_huawei_str);
            kotlin.jvm.internal.s.g(string2, "activity.getString(R.str…paylib_choose_huawei_str)");
            o(this, string2, R.drawable.icon_hms_logo, PayHelp.PAYWAY.HuaweiIAP, null, 8, null);
        }
        List<PayssionPayway> localPaywayByPayssion = PayssionManager.INSTANCE.getLocalPaywayByPayssion();
        if (localPaywayByPayssion != null) {
            for (PayssionPayway payssionPayway : localPaywayByPayssion) {
                n(payssionPayway.getName(), payssionPayway.getIconRes(), PayHelp.PAYWAY.PayssionPay, payssionPayway.getPayssionPayId());
            }
        }
        String string3 = this.f9708d.getString(R.string.alipay);
        kotlin.jvm.internal.s.g(string3, "activity.getString(R.string.alipay)");
        o(this, string3, R.drawable.icon_ali_logo, PayHelp.PAYWAY.AliPay, null, 8, null);
        String string4 = this.f9708d.getString(R.string.wechat_pay);
        kotlin.jvm.internal.s.g(string4, "activity.getString(R.string.wechat_pay)");
        o(this, string4, R.drawable.icon_wx_logo, PayHelp.PAYWAY.WxPay, null, 8, null);
    }

    @Override // us.pinguo.camera360.shop.manager.o0
    public void a() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.dialog_view_out_anim);
        loadAnimation.setAnimationListener(new c());
        ((LinearLayout) b().findViewById(R.id.whiteParentView)).startAnimation(loadAnimation);
    }

    @Override // us.pinguo.camera360.shop.manager.o0
    public void g() {
        super.g();
        ((LinearLayout) b().findViewById(R.id.whiteParentView)).setAnimation(AnimationUtils.loadAnimation(this.a, R.anim.dialog_view_in_anim));
        ((ImageView) b().findViewById(R.id.backgroundIv)).setAnimation(AnimationUtils.loadAnimation(this.a, R.anim.dialog_view_show_anim));
        us.pinguo.foundation.statistics.h.a.j("", "show");
    }

    public final Activity p() {
        return this.f9708d;
    }
}
