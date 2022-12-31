package us.pinguo.ad;

import android.app.Activity;
import com.tapjoy.TJAdUnitConstants;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.ad.c;
import us.pinguo.common.widget.adv.AdRewardView;
import us.pinguo.foundation.statistics.h;
import us.pinguo.repository2020.abtest.i;
/* compiled from: RewardVipAdController.kt */
/* loaded from: classes3.dex */
public final class RewardVipAdController {
    private final AdRewardView a;
    private final Activity b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f8990d;

    /* renamed from: e  reason: collision with root package name */
    private final RewardVipAdController$adShowResultListener$1 f8991e;

    /* compiled from: RewardVipAdController.kt */
    /* loaded from: classes3.dex */
    public static final class a implements c.a {
        a() {
        }

        @Override // us.pinguo.ad.c.a
        public void a() {
            RewardVipAdController.this.a.l();
            if (RewardVipAdController.this.b.isFinishing()) {
                return;
            }
            c.a.h(RewardVipAdController.this.b, RewardVipAdController.this.f8991e);
        }

        @Override // us.pinguo.ad.c.a
        public void b() {
            RewardVipAdController.this.a.l();
            RewardVipAdController.this.a.B();
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [us.pinguo.ad.RewardVipAdController$adShowResultListener$1] */
    public RewardVipAdController(AdRewardView adView, Activity activity, boolean z) {
        s.h(adView, "adView");
        this.a = adView;
        this.b = activity;
        this.c = z;
        this.f8991e = new c.b() { // from class: us.pinguo.ad.RewardVipAdController$adShowResultListener$1
            @Override // us.pinguo.ad.c.b
            public void a(boolean z2) {
                boolean z3;
                boolean z4;
                String str = i.a.d() ? "rewarded_ads" : "inter_rewarded_ads";
                z3 = RewardVipAdController.this.c;
                String str2 = z3 ? "edit" : "camera";
                if (z2) {
                    kotlin.jvm.b.a<u> f2 = RewardVipAdController.this.f();
                    if (f2 != null) {
                        f2.invoke();
                    }
                    h.b.f0(str2, str, TJAdUnitConstants.String.VIDEO_COMPLETE);
                    return;
                }
                us.pinguo.foundation.statistics.i iVar = h.b;
                iVar.f0(str2, str, "exit");
                z4 = RewardVipAdController.this.c;
                String str3 = z4 ? "edit_save" : "preview_save";
                iVar.D0(str3, str, "show");
                RewardVipAdController.this.a.t(new RewardVipAdController$adShowResultListener$1$onUserEarned$1(RewardVipAdController.this, str3, str), new RewardVipAdController$adShowResultListener$1$onUserEarned$2(RewardVipAdController.this, str3, str));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        if (this.b == null) {
            return;
        }
        c cVar = c.a;
        if (cVar.e()) {
            cVar.h(this.b, this.f8991e);
            return;
        }
        this.a.A();
        this.a.setOnCloseClickListener(new RewardVipAdController$startAdProcess$1(this));
        cVar.f(new a());
    }

    public final kotlin.jvm.b.a<u> f() {
        return this.f8990d;
    }

    public final void g(kotlin.jvm.b.a<u> aVar) {
        this.f8990d = aVar;
    }

    public final void h() {
        String str = this.c ? "edit_save" : "preview_save ";
        i iVar = i.a;
        String str2 = iVar.d() ? "rewarded_ads" : "inter_rewarded_ads";
        h.b.A0(str, str2, "show");
        this.a.w(iVar.e(), R.drawable.icon_ad_reward_save_time, us.pinguo.c360.i18n.R.string.reward_dialog_content, new RewardVipAdController$showAdTip$1(this, str, str2), new RewardVipAdController$showAdTip$2(this, str, str2), new RewardVipAdController$showAdTip$3(this, str, str2));
    }
}
