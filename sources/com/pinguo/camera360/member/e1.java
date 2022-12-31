package com.pinguo.camera360.member;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.huawei.HuaweiAgent;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.member.model.DiscountData;
import com.pinguo.camera360.member.model.DiscountInfo;
import com.pinguo.camera360.member.model.DiscountResponse;
import com.pinguo.camera360.vip.VipManager;
import com.pinguo.lib.GsonUtilKt;
import java.util.List;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.camera360.shop.data.show.ShowTopic;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.paylibcenter.bean.PayResult;
import vStudio.Android.Camera360.R;
/* compiled from: SubscribePresenter.kt */
/* loaded from: classes3.dex */
public final class e1 implements x0, us.pinguo.camera360.shop.manager.t0 {
    private String a;
    private final y0<e1> b;
    private kotlin.jvm.b.l<? super Boolean, kotlin.u> c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6924d;

    /* compiled from: SubscribePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class a implements PayHelp.j {
        final /* synthetic */ kotlin.jvm.b.p<Boolean, String, kotlin.u> a;

        /* JADX WARN: Multi-variable type inference failed */
        a(kotlin.jvm.b.p<? super Boolean, ? super String, kotlin.u> pVar, Resources resources, String str) {
            this.a = pVar;
        }
    }

    /* compiled from: SubscribePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        @Instrumented
        public void onClick(DialogInterface dialogInterface, int i2) {
            VdsAgent.onClick(this, dialogInterface, i2);
            if (i2 == -3) {
                us.pinguo.foundation.d.f10992k = true;
                PayResult payResult = new PayResult(15, "");
                payResult.setStatus(4);
                e1.this.g(payResult);
            } else if (i2 != -1) {
                us.pinguo.foundation.d.f10992k = false;
                PayResult payResult2 = new PayResult(16, "");
                payResult2.setStatus(6);
                e1.this.g(payResult2);
            } else {
                us.pinguo.foundation.d.f10992k = true;
                e1.this.b.g().setResult(-1);
                PayResult payResult3 = new PayResult(15, "");
                payResult3.setStatus(0);
                e1.this.d(payResult3);
            }
            CameraBusinessSettingModel.v().E("key_vup_sub", us.pinguo.foundation.d.f10992k);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e1(y0<? super e1> subscribeView) {
        kotlin.jvm.internal.s.h(subscribeView, "subscribeView");
        this.b = subscribeView;
        VipManager vipManager = VipManager.a;
        this.f6924d = vipManager.H() ? "Huawei" : "Google";
        subscribeView.D(this);
        String j2 = us.pinguo.repository2020.utils.o.j(us.pinguo.repository2020.utils.o.a, "key_discount_product_id", null, null, 4, null);
        if (j2 == null) {
            return;
        }
        vipManager.Q(j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(kotlin.jvm.b.p callback, e1 this$0, DiscountResponse discountResponse) {
        List<String> e2;
        kotlin.jvm.internal.s.h(callback, "$callback");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        boolean z = false;
        us.pinguo.common.log.a.c(GsonUtilKt.getCachedGson().s(discountResponse), new Object[0]);
        Resources resources = us.pinguo.foundation.e.b().getResources();
        if (discountResponse == null) {
            Boolean bool = Boolean.FALSE;
            String string = resources.getString(R.string.network_error);
            kotlin.jvm.internal.s.g(string, "resource.getString(R.string.network_error)");
            callback.invoke(bool, string);
            return;
        }
        String message = discountResponse.getMessage();
        Integer status = discountResponse.getStatus();
        DiscountData data = discountResponse.getData();
        if (data != null && status != null && status.intValue() == 200) {
            DiscountInfo product = data.getProduct();
            if (product == null) {
                Boolean bool2 = Boolean.FALSE;
                String string2 = resources.getString(R.string.network_error);
                kotlin.jvm.internal.s.g(string2, "resource.getString(R.string.network_error)");
                callback.invoke(bool2, string2);
                return;
            }
            String originProductId = product.getOriginProductId();
            String productId = product.getProductId();
            if (!(originProductId == null || originProductId.length() == 0)) {
                if (!(productId == null || productId.length() == 0)) {
                    if (kotlin.jvm.internal.s.c(originProductId, this$0.b.b())) {
                        if (!HuaweiAgent.isHuaweiPhone() && !HuaweiAgent.isHuaweiSupport()) {
                            String price = PayHelp.getInstance().A(productId, PayHelp.PAYWAY.GooglePay);
                            if ((price == null || price.length() == 0) ? true : true) {
                                Boolean bool3 = Boolean.FALSE;
                                String string3 = resources.getString(R.string.network_error);
                                kotlin.jvm.internal.s.g(string3, "resource.getString(R.string.network_error)");
                                callback.invoke(bool3, string3);
                                return;
                            }
                            us.pinguo.repository2020.utils.o.v(us.pinguo.repository2020.utils.o.a, "key_discount_product_id", productId, null, 4, null);
                            VipManager vipManager = VipManager.a;
                            vipManager.Q(productId);
                            kotlin.jvm.internal.s.g(price, "price");
                            vipManager.N(productId, price);
                            callback.invoke(Boolean.TRUE, productId);
                            return;
                        }
                        PayHelp payHelp = PayHelp.getInstance();
                        Activity g2 = this$0.b.g();
                        e2 = kotlin.collections.t.e(productId);
                        payHelp.x(g2, e2, new a(callback, resources, productId));
                        return;
                    }
                    Boolean bool4 = Boolean.FALSE;
                    String string4 = resources.getString(R.string.hint_incorrect_discount_code);
                    kotlin.jvm.internal.s.g(string4, "resource.getString(R.str…_incorrect_discount_code)");
                    callback.invoke(bool4, string4);
                    return;
                }
            }
            Boolean bool5 = Boolean.FALSE;
            String string5 = resources.getString(R.string.network_error);
            kotlin.jvm.internal.s.g(string5, "resource.getString(R.string.network_error)");
            callback.invoke(bool5, string5);
        } else if (status != null && status.intValue() == 404) {
            us.pinguo.foundation.statistics.h.b.r("", "code_illegal");
            Boolean bool6 = Boolean.FALSE;
            String string6 = resources.getString(R.string.hint_incorrect_discount_code);
            kotlin.jvm.internal.s.g(string6, "resource.getString(R.str…_incorrect_discount_code)");
            callback.invoke(bool6, string6);
        } else {
            if ((status != null && status.intValue() == 409) || (status != null && status.intValue() == 411)) {
                z = true;
            }
            if (z) {
                Boolean bool7 = Boolean.FALSE;
                String string7 = resources.getString(R.string.hint_discount_code_used);
                kotlin.jvm.internal.s.g(string7, "resource.getString(R.str….hint_discount_code_used)");
                callback.invoke(bool7, string7);
            } else if (status != null && status.intValue() == 410) {
                us.pinguo.foundation.statistics.h.b.r("", "code_expired");
                Boolean bool8 = Boolean.FALSE;
                String string8 = resources.getString(R.string.hint_discount_code_expired);
                kotlin.jvm.internal.s.g(string8, "resource.getString(R.str…nt_discount_code_expired)");
                callback.invoke(bool8, string8);
            } else if (status != null && status.intValue() == 501) {
                Boolean bool9 = Boolean.FALSE;
                String string9 = resources.getString(R.string.hint_discount_code_user_id_invalid);
                kotlin.jvm.internal.s.g(string9, "resource.getString(R.str…unt_code_user_id_invalid)");
                callback.invoke(bool9, string9);
            } else {
                Boolean bool10 = Boolean.FALSE;
                if (message == null) {
                    message = resources.getString(R.string.network_error);
                    kotlin.jvm.internal.s.g(message, "resource.getString(R.string.network_error)");
                }
                callback.invoke(bool10, message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(kotlin.jvm.b.p callback, Throwable th) {
        kotlin.jvm.internal.s.h(callback, "$callback");
        th.printStackTrace();
        Boolean bool = Boolean.FALSE;
        String string = us.pinguo.foundation.e.b().getString(R.string.network_error);
        kotlin.jvm.internal.s.g(string, "getAppContext().getString(R.string.network_error)");
        callback.invoke(bool, string);
    }

    @Override // com.pinguo.camera360.member.x0
    public void a(String originalId, String code, final kotlin.jvm.b.p<? super Boolean, ? super String, kotlin.u> callback) {
        kotlin.jvm.internal.s.h(originalId, "originalId");
        kotlin.jvm.internal.s.h(code, "code");
        kotlin.jvm.internal.s.h(callback, "callback");
        PGRequest.Builder builder = new PGRequest.Builder(DiscountResponse.class);
        builder.withDomain(us.pinguo.user.u0.a).withMethod(1).withUriPath("/coupon/apply");
        builder.addParam("originProductId", originalId);
        builder.addParam("code", code);
        RxVolley.createSync(builder.build()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.pinguo.camera360.member.i0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                e1.i(kotlin.jvm.b.p.this, this, (DiscountResponse) obj);
            }
        }, new Action1() { // from class: com.pinguo.camera360.member.h0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                e1.j(kotlin.jvm.b.p.this, (Throwable) obj);
            }
        });
    }

    @Override // com.pinguo.camera360.member.x0
    public void b(String productId) {
        kotlin.jvm.internal.s.h(productId, "productId");
        this.a = productId;
        VipManager.a.S("yearly_vip_2399_3dayfree");
        if (us.pinguo.foundation.d.f10991j) {
            us.pinguo.foundation.utils.w.m(this.b.g(), "模拟Google支付", "支付成功", "支付超时", "支付失败", new b());
        } else {
            us.pinguo.camera360.shop.manager.s0.getInstance().c(this.b.g(), this, productId);
        }
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void d(PayResult payResult) {
        if (payResult != null) {
            VipManager.a.W(3);
            com.pinguo.camera360.adv.c.h();
        }
        Adjust.trackEvent(new AdjustEvent("lmwbzd"));
        Intent intent = new Intent(this.b.g(), SubscriptionResultActivity.class);
        intent.putExtra("subscription_status", 101);
        this.b.g().setResult(-1);
        this.b.g().startActivityForResult(intent, 101);
        String str = this.a;
        if (str != null) {
            VipManager vipManager = VipManager.a;
            if (kotlin.jvm.internal.s.c(str, vipManager.x())) {
                vipManager.j();
            }
            this.b.Q();
            us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
            String str2 = this.f6924d;
            String str3 = this.a;
            if (str3 != null) {
                cVar.t(FirebaseAnalytics.Param.SUCCESS, str2, str3, "feedback");
                com.pinguo.camera360.adv.d.a.c();
                kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.c;
                if (lVar != null) {
                    lVar.invoke(Boolean.TRUE);
                }
                o(true, this.b.g());
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
        Intent intent = new Intent(this.b.g(), SubscriptionResultActivity.class);
        intent.putExtra("subscription_status", 102);
        this.b.g().setResult(0);
        this.b.g().startActivityForResult(intent, 102);
        us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
        String str = this.f6924d;
        String str2 = this.a;
        if (str2 != null) {
            cVar.t("user_cancel", str, str2, "feedback");
            o(false, this.b.g());
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
            if (payResult.getResultCode() == 4) {
                us.pinguo.foundation.statistics.c cVar = us.pinguo.foundation.statistics.h.a;
                String str = this.f6924d;
                String str2 = this.a;
                if (str2 == null) {
                    kotlin.jvm.internal.s.z("productId");
                    throw null;
                }
                cVar.t("other_error", str, str2, "feedback");
            } else if (payResult.getResultCode() == 6) {
                us.pinguo.foundation.statistics.c cVar2 = us.pinguo.foundation.statistics.h.a;
                String str3 = this.f6924d;
                String str4 = this.a;
                if (str4 == null) {
                    kotlin.jvm.internal.s.z("productId");
                    throw null;
                }
                cVar2.t("pay_fail", str3, str4, "feedback");
            } else if (payResult.getResultCode() == 9) {
                us.pinguo.foundation.statistics.c cVar3 = us.pinguo.foundation.statistics.h.a;
                String str5 = this.f6924d;
                String str6 = this.a;
                if (str6 == null) {
                    kotlin.jvm.internal.s.z("productId");
                    throw null;
                }
                cVar3.t("unbind_service", str5, str6, "feedback");
            } else {
                us.pinguo.foundation.statistics.c cVar4 = us.pinguo.foundation.statistics.h.a;
                String str7 = this.f6924d;
                String str8 = this.a;
                if (str8 == null) {
                    kotlin.jvm.internal.s.z("productId");
                    throw null;
                }
                cVar4.t("other_error", str7, str8, "feedback");
            }
        }
        kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar = this.c;
        if (lVar != null) {
            lVar.invoke(Boolean.FALSE);
        }
        Intent intent = new Intent(this.b.g(), SubscriptionResultActivity.class);
        intent.putExtra("subscription_status", 102);
        this.b.g().setResult(0);
        this.b.g().startActivityForResult(intent, 102);
        o(false, this.b.g());
    }

    @Override // us.pinguo.camera360.shop.manager.t0
    public void h(ShowTopic showTopic, ShowPkg showPkg) {
    }

    public final void k() {
        this.b.Q();
    }

    public final void n() {
        us.pinguo.camera360.shop.manager.s0.getInstance().b();
        try {
            PayHelp.getInstance().t();
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
        }
    }

    public final void o(boolean z, Activity activity) {
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

    public final void p(kotlin.jvm.b.l<? super Boolean, kotlin.u> lVar) {
        this.c = lVar;
    }
}
