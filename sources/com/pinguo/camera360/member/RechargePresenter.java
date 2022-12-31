package com.pinguo.camera360.member;

import android.content.Context;
import android.content.res.Resources;
import com.pinguo.camera360.member.model.DiscountData;
import com.pinguo.camera360.member.model.DiscountInfo;
import com.pinguo.camera360.member.model.DiscountResponse;
import com.pinguo.camera360.member.model.MemberPriceInfo;
import com.pinguo.camera360.member.model.RechargeGoodsDiscountInfo;
import com.pinguo.camera360.member.model.RechargeGoodsInfo;
import com.pinguo.camera360.member.model.UnsubscribeResponse;
import com.pinguo.lib.GsonUtilKt;
import java.util.ArrayList;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.user.User;
import us.pinguo.user.event.SyncVipInfoDoneEvent;
import us.pinguo.user.y0;
import vStudio.Android.Camera360.R;
/* compiled from: RechargePresenter.kt */
/* loaded from: classes3.dex */
public final class RechargePresenter implements v0 {
    private final w0<RechargePresenter> a;
    private us.pinguo.camera360.shop.manager.n0 b;
    private C360MemberRepository c;

    /* renamed from: d  reason: collision with root package name */
    private volatile String f6901d;

    /* compiled from: RechargePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends us.pinguo.paylibcenter.n.b<RechargeGoodsInfo> {
        a() {
        }

        @Override // us.pinguo.paylibcenter.n.b
        public void a(Exception e2) {
            kotlin.jvm.internal.s.h(e2, "e");
            RechargePresenter.this.a.A(new MemberPriceInfo(new ArrayList(0), 0, 0));
        }

        @Override // us.pinguo.paylibcenter.n.b
        /* renamed from: c */
        public void b(RechargeGoodsInfo rechargeGoodsInfo) {
            if (us.pinguo.foundation.d.f10987f) {
                MemberPriceInfo data = rechargeGoodsInfo == null ? null : rechargeGoodsInfo.getData();
                if (data != null) {
                    data.setMiguway(1);
                }
                MemberPriceInfo data2 = rechargeGoodsInfo != null ? rechargeGoodsInfo.getData() : null;
                if (data2 != null) {
                    data2.setMmgzway(1);
                }
            }
            w0 w0Var = RechargePresenter.this.a;
            kotlin.jvm.internal.s.e(rechargeGoodsInfo);
            w0Var.A(rechargeGoodsInfo.getData());
            us.pinguo.common.log.a.k(kotlin.jvm.internal.s.q("load member price list==>", new com.google.gson.e().s(rechargeGoodsInfo.getData())), new Object[0]);
        }
    }

    /* compiled from: RechargePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class b extends us.pinguo.paylibcenter.n.b<UnsubscribeResponse> {
        b() {
        }

        @Override // us.pinguo.paylibcenter.n.b
        public void a(Exception e2) {
            kotlin.jvm.internal.s.h(e2, "e");
            us.pinguo.common.log.a.k("unsubscribeMMMember:onError", new Object[0]);
            SyncVipInfoDoneEvent syncVipInfoDoneEvent = new SyncVipInfoDoneEvent();
            syncVipInfoDoneEvent.c("MMMemberRightsFragmentView");
            PGEventBus.getInstance().a(syncVipInfoDoneEvent);
        }

        @Override // us.pinguo.paylibcenter.n.b
        /* renamed from: c */
        public void b(UnsubscribeResponse unsubscribeResponse) {
            kotlin.jvm.internal.s.h(unsubscribeResponse, "unsubscribeResponse");
            y0.c r = User.d().r(false);
            if (r.b != 0) {
                r.b = 0L;
            }
            us.pinguo.user.y0.n(RechargePresenter.this.a.g(), 0L);
            SyncVipInfoDoneEvent syncVipInfoDoneEvent = new SyncVipInfoDoneEvent();
            syncVipInfoDoneEvent.c("MMMemberRightsFragmentView");
            PGEventBus.getInstance().a(syncVipInfoDoneEvent);
            us.pinguo.foundation.utils.j0.d(BaseApplication.d().getString(R.string.mm_subsc_success));
            us.pinguo.common.log.a.k("unsubscribeMMMember:onSuccess", new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RechargePresenter(w0<? super RechargePresenter> rechargeView) {
        kotlin.jvm.internal.s.h(rechargeView, "rechargeView");
        this.a = rechargeView;
        rechargeView.D(this);
        this.b = new us.pinguo.camera360.shop.manager.n0();
        this.c = new C360MemberRepository(rechargeView.g());
        this.f6901d = us.pinguo.repository2020.utils.o.j(us.pinguo.repository2020.utils.o.a, "key_discount_product_id", null, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(kotlin.jvm.b.p callback, RechargePresenter this$0, DiscountResponse discountResponse) {
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
        if (status != null && status.intValue() == 200 && data != null) {
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
                if (!((productId == null || productId.length() == 0) ? true : true)) {
                    if (kotlin.jvm.internal.s.c(this$0.a.b(), originProductId)) {
                        us.pinguo.repository2020.utils.o.v(us.pinguo.repository2020.utils.o.a, "key_discount_product_id", productId, null, 4, null);
                        this$0.f6901d = productId;
                        callback.invoke(Boolean.TRUE, productId);
                        return;
                    }
                    Boolean bool3 = Boolean.FALSE;
                    String string3 = resources.getString(R.string.hint_incorrect_discount_code);
                    kotlin.jvm.internal.s.g(string3, "resource.getString(R.str…_incorrect_discount_code)");
                    callback.invoke(bool3, string3);
                    return;
                }
            }
            Boolean bool4 = Boolean.FALSE;
            String string4 = resources.getString(R.string.network_error);
            kotlin.jvm.internal.s.g(string4, "resource.getString(R.string.network_error)");
            callback.invoke(bool4, string4);
        } else if (status != null && status.intValue() == 404) {
            us.pinguo.foundation.statistics.h.b.r("", "code_illegal");
            Boolean bool5 = Boolean.FALSE;
            String string5 = resources.getString(R.string.hint_incorrect_discount_code);
            kotlin.jvm.internal.s.g(string5, "resource.getString(R.str…_incorrect_discount_code)");
            callback.invoke(bool5, string5);
        } else {
            if ((status != null && status.intValue() == 409) || (status != null && status.intValue() == 411)) {
                z = true;
            }
            if (z) {
                Boolean bool6 = Boolean.FALSE;
                String string6 = resources.getString(R.string.hint_discount_code_used);
                kotlin.jvm.internal.s.g(string6, "resource.getString(R.str….hint_discount_code_used)");
                callback.invoke(bool6, string6);
            } else if (status != null && status.intValue() == 410) {
                us.pinguo.foundation.statistics.h.b.r("", "code_expired");
                Boolean bool7 = Boolean.FALSE;
                String string7 = resources.getString(R.string.hint_discount_code_expired);
                kotlin.jvm.internal.s.g(string7, "resource.getString(R.str…nt_discount_code_expired)");
                callback.invoke(bool7, string7);
            } else if (status != null && status.intValue() == 501) {
                Boolean bool8 = Boolean.FALSE;
                String string8 = resources.getString(R.string.hint_discount_code_user_id_invalid);
                kotlin.jvm.internal.s.g(string8, "resource.getString(R.str…unt_code_user_id_invalid)");
                callback.invoke(bool8, string8);
            } else {
                Boolean bool9 = Boolean.FALSE;
                if (message == null) {
                    message = resources.getString(R.string.network_error);
                    kotlin.jvm.internal.s.g(message, "resource.getString(R.string.network_error)");
                }
                callback.invoke(bool9, message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(kotlin.jvm.b.p callback, Throwable th) {
        kotlin.jvm.internal.s.h(callback, "$callback");
        th.printStackTrace();
        Boolean bool = Boolean.FALSE;
        String string = us.pinguo.foundation.e.b().getString(R.string.network_error);
        kotlin.jvm.internal.s.g(string, "getAppContext().getString(R.string.network_error)");
        callback.invoke(bool, string);
    }

    @Override // com.pinguo.camera360.member.v0
    public void a(String originalId, String code, final kotlin.jvm.b.p<? super Boolean, ? super String, kotlin.u> callback) {
        kotlin.jvm.internal.s.h(originalId, "originalId");
        kotlin.jvm.internal.s.h(code, "code");
        kotlin.jvm.internal.s.h(callback, "callback");
        PGRequest.Builder builder = new PGRequest.Builder(DiscountResponse.class);
        builder.withDomain(us.pinguo.user.u0.a).withMethod(1).withUriPath("/coupon/apply");
        builder.addParam("originProductId", originalId);
        builder.addParam("code", code);
        RxVolley.createSync(builder.build()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.pinguo.camera360.member.f0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                RechargePresenter.d(kotlin.jvm.b.p.this, this, (DiscountResponse) obj);
            }
        }, new Action1() { // from class: com.pinguo.camera360.member.g0
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                RechargePresenter.e(kotlin.jvm.b.p.this, (Throwable) obj);
            }
        });
    }

    public final void c(MemberPriceInfo info) {
        kotlin.jvm.internal.s.h(info, "info");
        us.pinguo.repository2020.utils.o.v(us.pinguo.repository2020.utils.o.a, "key_cache_price_info", GsonUtilKt.getCachedGson().s(info), null, 4, null);
    }

    public final void f() {
        this.f6901d = null;
        us.pinguo.repository2020.utils.o.l(us.pinguo.repository2020.utils.o.a, "key_discount_product_id", null, 2, null);
    }

    public final MemberPriceInfo g() {
        String j2 = us.pinguo.repository2020.utils.o.j(us.pinguo.repository2020.utils.o.a, "key_cache_price_info", "", null, 4, null);
        if (j2 == null) {
            return null;
        }
        return (MemberPriceInfo) GsonUtilKt.getCachedGson().j(j2, MemberPriceInfo.class);
    }

    public final String h() {
        return this.f6901d;
    }

    public final void k() {
        a aVar = new a();
        C360MemberRepository c360MemberRepository = this.c;
        if (c360MemberRepository == null) {
            return;
        }
        c360MemberRepository.n(this.a.g(), aVar);
    }

    public final void l() {
        us.pinguo.camera360.shop.manager.n0 n0Var = this.b;
        if (n0Var == null) {
            return;
        }
        n0Var.b();
    }

    public final void m(String str) {
        this.f6901d = str;
    }

    public void n(RechargeGoodsDiscountInfo rechargeGoodsDiscountInfo, us.pinguo.camera360.shop.manager.v0 v0Var) {
        us.pinguo.camera360.shop.manager.n0 n0Var = this.b;
        if (n0Var == null) {
            return;
        }
        n0Var.i0(this.a.g(), rechargeGoodsDiscountInfo, v0Var);
    }

    public final void o() {
        C360MemberRepository c360MemberRepository = this.c;
        if (c360MemberRepository == null) {
            return;
        }
        Context a2 = us.pinguo.util.v.a();
        kotlin.jvm.internal.s.g(a2, "getAppContext()");
        c360MemberRepository.s(a2, false, RechargePresenter$syncVipExpireTimeFromServer$1.INSTANCE);
    }

    public final void p(boolean z) {
        C360MemberRepository c360MemberRepository = this.c;
        if (c360MemberRepository == null) {
            return;
        }
        Context a2 = us.pinguo.util.v.a();
        kotlin.jvm.internal.s.g(a2, "getAppContext()");
        c360MemberRepository.r(a2, z);
    }

    public final void q() {
        b bVar = new b();
        C360MemberRepository c360MemberRepository = this.c;
        if (c360MemberRepository == null) {
            return;
        }
        c360MemberRepository.t(this.a.g(), bVar);
    }
}
