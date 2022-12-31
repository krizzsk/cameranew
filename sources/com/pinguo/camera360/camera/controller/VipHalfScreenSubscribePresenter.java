package com.pinguo.camera360.camera.controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.vip.VipManager;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowTopic;
import us.pinguo.camera360.shop.manager.s0;
import us.pinguo.camera360.shop.manager.t0;
import us.pinguo.paylibcenter.bean.PayResult;
/* compiled from: VipHalfScreenController.kt */
/* loaded from: classes3.dex */
public final class VipHalfScreenSubscribePresenter implements t0 {
    private final Context a;
    private String b;
    private kotlin.jvm.b.l<? super Boolean, kotlin.u> c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6201d;

    public VipHalfScreenSubscribePresenter(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        this.a = context;
        VipManager vipManager = VipManager.a;
        this.f6201d = vipManager.H() ? "Huawei" : "Google";
        String j2 = us.pinguo.repository2020.utils.o.j(us.pinguo.repository2020.utils.o.a, "key_discount_product_id", null, null, 4, null);
        if (j2 == null) {
            return;
        }
        vipManager.Q(j2);
    }

    private final void b(boolean z, Activity activity) {
        String stringExtra;
        String stringExtra2;
        Intent intent = activity == null ? null : activity.getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("source_page")) == null || (stringExtra2 = intent.getStringExtra("source_extra")) == null) {
            return;
        }
        if (z) {
            us.pinguo.foundation.statistics.h.a.v0("vip_sub_success_action", "yearly_vip_2399_3dayfree", stringExtra, stringExtra2, "sub_success", "1");
        } else {
            us.pinguo.foundation.statistics.h.a.v0("vip_sub_success_action", "yearly_vip_2399_3dayfree", stringExtra, stringExtra2, "false", "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(VipHalfScreenSubscribePresenter this$0, DialogInterface dialogInterface, int i2) {
        VdsAgent.lambdaOnDialogClick(dialogInterface, i2);
        kotlin.jvm.internal.s.h(this$0, "this$0");
        if (i2 == -3) {
            us.pinguo.foundation.d.f10992k = true;
            PayResult payResult = new PayResult(15, "");
            payResult.setStatus(4);
            this$0.g(payResult);
        } else if (i2 != -1) {
            us.pinguo.foundation.d.f10992k = false;
            PayResult payResult2 = new PayResult(16, "");
            payResult2.setStatus(6);
            this$0.g(payResult2);
        } else {
            us.pinguo.foundation.d.f10992k = true;
            PayResult payResult3 = new PayResult(15, "");
            payResult3.setStatus(0);
            this$0.d(payResult3);
        }
        CameraBusinessSettingModel.v().E("key_vup_sub", us.pinguo.foundation.d.f10992k);
    }

    public final void c(kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar) {
        this.c = lVar;
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void d(PayResult payResult) {
        if (payResult != null) {
            VipManager.a.W(3);
            com.pinguo.camera360.adv.c.h();
        }
        Adjust.trackEvent(new AdjustEvent("lmwbzd"));
        String str = this.b;
        if (str != null) {
            VipManager vipManager = VipManager.a;
            if (kotlin.jvm.internal.s.c(str, vipManager.x())) {
                vipManager.j();
            }
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            String str2 = this.f6201d;
            String str3 = this.b;
            if (str3 != null) {
                cVar.t(FirebaseAnalytics.Param.SUCCESS, str2, str3, "feedback");
                com.pinguo.camera360.adv.d.a.c();
                kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.c;
                if (lVar != null) {
                    lVar.invoke(Boolean.TRUE);
                }
                b(true, (Activity) this.a);
                return;
            }
            kotlin.jvm.internal.s.z("productId");
            throw null;
        }
        kotlin.jvm.internal.s.z("productId");
        throw null;
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void e(PayResult payResult) {
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        String str = this.f6201d;
        String str2 = this.b;
        if (str2 != null) {
            cVar.t("user_cancel", str, str2, "feedback");
            kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.c;
            if (lVar != null) {
                lVar.invoke(Boolean.FALSE);
            }
            b(false, (Activity) this.a);
            return;
        }
        kotlin.jvm.internal.s.z("productId");
        throw null;
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void f(ShowTopic showTopic, ShowPkg showPkg) {
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void g(PayResult payResult) {
        if (payResult != null) {
            int resultCode = payResult.getResultCode();
            if (resultCode == 4) {
                us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                String str = this.f6201d;
                String str2 = this.b;
                if (str2 == null) {
                    kotlin.jvm.internal.s.z("productId");
                    throw null;
                }
                cVar.t("other_error", str, str2, "feedback");
            } else if (resultCode == 6) {
                us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
                String str3 = this.f6201d;
                String str4 = this.b;
                if (str4 == null) {
                    kotlin.jvm.internal.s.z("productId");
                    throw null;
                }
                cVar2.t("pay_fail", str3, str4, "feedback");
            } else if (resultCode != 9) {
                us.pinguo.foundation.statistics.c cVar3 = us.pinguo.foundation.statistics.h.a;
                String str5 = this.f6201d;
                String str6 = this.b;
                if (str6 == null) {
                    kotlin.jvm.internal.s.z("productId");
                    throw null;
                }
                cVar3.t("other_error", str5, str6, "feedback");
            } else {
                us.pinguo.foundation.statistics.c cVar4 = us.pinguo.foundation.statistics.h.a;
                String str7 = this.f6201d;
                String str8 = this.b;
                if (str8 == null) {
                    kotlin.jvm.internal.s.z("productId");
                    throw null;
                }
                cVar4.t("unbind_service", str7, str8, "feedback");
            }
        }
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.c;
        if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        b(false, (Activity) this.a);
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void h(ShowTopic showTopic, ShowPkg showPkg) {
    }

    public final void i(String productId) {
        kotlin.jvm.internal.s.h(productId, "productId");
        this.b = productId;
        VipManager.a.S("yearly_vip_2399_3dayfree");
        if (us.pinguo.foundation.d.f10991j) {
            us.pinguo.foundation.utils.w.m(this.a, "模拟Google支付", "支付成功", "支付超时", "支付失败", new DialogInterface.OnClickListener() { // from class: com.pinguo.camera360.camera.controller.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    VipHalfScreenSubscribePresenter.j(VipHalfScreenSubscribePresenter.this, dialogInterface, i2);
                }
            });
        } else {
            s0.getInstance().c((Activity) this.a, this, productId);
        }
    }
}
