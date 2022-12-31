package com.pinguo.camera360.member;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel;
import com.pinguo.camera360.member.model.MemberExpireInfo;
import com.pinguo.camera360.member.model.MemberInfo;
import com.pinguo.camera360.member.model.RechargeGoodsInfo;
import com.pinguo.camera360.member.model.UnsubscribeResponse;
import com.pinguo.camera360.request.ApiGiftVipGet;
import com.pinguo.camera360.vip.VipManager;
import com.pinguo.camera360.vip.VipReemCodeInfo;
import com.pinguo.camera360.vip.VipRestoreInfo;
import com.pinguo.lib.GsonUtilKt;
import com.tencent.open.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.common.network.HttpGsonRequest;
import us.pinguo.common.network.RxVolley;
import us.pinguo.common.network.pgrequest.PGRequest;
import us.pinguo.foundation.eventbus.PGEventBus;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.paylibcenter.PayHelp;
import us.pinguo.repository2020.network.HttpBaseResponse;
import us.pinguo.user.User;
import us.pinguo.user.event.QueryUserVipInfoDoneEvent;
import us.pinguo.user.y0;
import vStudio.Android.Camera360.Conditions;
/* compiled from: C360MemberRepository.kt */
/* loaded from: classes3.dex */
public final class C360MemberRepository {
    public static final a c = new a(null);

    /* renamed from: d  reason: collision with root package name */
    private static final String f6874d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f6875e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f6876f;
    private SharedPreferences a;
    private String b;

    /* compiled from: C360MemberRepository.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final String a() {
            return C360MemberRepository.f6875e;
        }

        public final String b() {
            return C360MemberRepository.f6876f;
        }
    }

    /* compiled from: C360MemberRepository.kt */
    /* loaded from: classes3.dex */
    public static final class b extends j.a.c.b.d<HttpBaseResponse<VipRestoreInfo>> {
        b() {
        }

        @Override // j.a.c.b.d
        /* renamed from: a */
        public void onSuccess(HttpBaseResponse<VipRestoreInfo> vipRestoreResponse) {
            kotlin.jvm.internal.s.h(vipRestoreResponse, "vipRestoreResponse");
            boolean z = true;
            if (vipRestoreResponse.getStatus() == 200) {
                float expireTime = vipRestoreResponse.getData().getExpireTime();
                float purchaseTime = vipRestoreResponse.getData().getPurchaseTime();
                float serverTime = (float) vipRestoreResponse.getServerTime();
                VipManager vipManager = VipManager.a;
                if (vipManager.s() == null) {
                    vipManager.P(new VipReemCodeInfo((purchaseTime > serverTime || serverTime > expireTime) ? false : false, expireTime, purchaseTime));
                } else {
                    VipReemCodeInfo s = vipManager.s();
                    if (s != null) {
                        s.setGiftVip((purchaseTime > serverTime || serverTime > expireTime) ? false : false);
                    }
                }
                us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
                oVar.o("key_expire_time", expireTime, "c360_default_sp_filte");
                oVar.o("key_purchase_time", purchaseTime, "c360_default_sp_filte");
            } else {
                us.pinguo.repository2020.utils.o oVar2 = us.pinguo.repository2020.utils.o.a;
                float c = oVar2.c("key_expire_time", 0.0f, "c360_default_sp_filte");
                float c2 = oVar2.c("key_purchase_time", 0.0f, "c360_default_sp_filte");
                float currentTimeMillis = ((float) System.currentTimeMillis()) / 1000.0f;
                VipManager vipManager2 = VipManager.a;
                if (vipManager2.s() == null) {
                    vipManager2.P(new VipReemCodeInfo((c2 > currentTimeMillis || currentTimeMillis > c) ? false : false, c, c2));
                } else {
                    VipReemCodeInfo s2 = vipManager2.s();
                    if (s2 != null) {
                        s2.setGiftVip((c2 > currentTimeMillis || currentTimeMillis > c) ? false : false);
                    }
                }
            }
            if (VipManager.a.F()) {
                us.pinguo.foundation.statistics.h.b.x0("", "validity_period_active");
            }
        }

        @Override // j.a.c.b.d
        public void onError(Exception e2) {
            kotlin.jvm.internal.s.h(e2, "e");
            us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
            float c = oVar.c("key_expire_time", 0.0f, "c360_default_sp_filte");
            float c2 = oVar.c("key_purchase_time", 0.0f, "c360_default_sp_filte");
            float currentTimeMillis = ((float) System.currentTimeMillis()) / 1000.0f;
            VipManager vipManager = VipManager.a;
            boolean z = true;
            if (vipManager.s() == null) {
                vipManager.P(new VipReemCodeInfo((c2 > currentTimeMillis || currentTimeMillis > c) ? false : false, c, c2));
                return;
            }
            VipReemCodeInfo s = vipManager.s();
            if (s == null) {
                return;
            }
            s.setGiftVip((c2 > currentTimeMillis || currentTimeMillis > c) ? false : false);
        }
    }

    /* compiled from: C360MemberRepository.kt */
    /* loaded from: classes3.dex */
    public static final class c extends us.pinguo.paylibcenter.n.a<RechargeGoodsInfo> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f6877d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C360MemberRepository f6878e;

        /* compiled from: C360MemberRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a extends HttpGsonRequest<RechargeGoodsInfo> {
            final /* synthetic */ us.pinguo.paylibcenter.n.b<RechargeGoodsInfo> b;
            final /* synthetic */ C360MemberRepository c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(us.pinguo.paylibcenter.n.b<RechargeGoodsInfo> bVar, C360MemberRepository c360MemberRepository, String str) {
                super(1, str);
                this.b = bVar;
                this.c = c360MemberRepository;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            /* renamed from: a */
            public void onResponse(RechargeGoodsInfo s) {
                kotlin.jvm.internal.s.h(s, "s");
                c.this.d(this.b, s);
            }

            @Override // com.android.volley.Request
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap hashMap = new HashMap();
                us.pinguo.user.u0.e(BaseApplication.d(), hashMap);
                us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return hashMap;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception e2) {
                kotlin.jvm.internal.s.h(e2, "e");
                c.this.c(this.b, e2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpGsonRequest, us.pinguo.common.network.pgrequest.BaseRequest, com.android.volley.Request
            public Response<RechargeGoodsInfo> parseNetworkResponse(NetworkResponse networkResponse) {
                String str;
                SharedPreferences sharedPreferences;
                SharedPreferences.Editor edit;
                SharedPreferences.Editor putString;
                SharedPreferences.Editor putLong;
                try {
                    byte[] bArr = networkResponse == null ? null : networkResponse.data;
                    kotlin.jvm.internal.s.e(bArr);
                    Charset forName = Charset.forName(HttpHeaderParser.parseCharset(networkResponse.headers));
                    kotlin.jvm.internal.s.g(forName, "forName(HttpHeaderParser…harset(response.headers))");
                    str = new String(bArr, forName);
                } catch (UnsupportedEncodingException unused) {
                    byte[] bArr2 = networkResponse != null ? networkResponse.data : null;
                    kotlin.jvm.internal.s.e(bArr2);
                    str = new String(bArr2, kotlin.text.d.a);
                }
                if (!TextUtils.isEmpty(str)) {
                    boolean z = false;
                    if (networkResponse != null && networkResponse.statusCode == 200) {
                        z = true;
                    }
                    if (z && (sharedPreferences = this.c.a) != null && (edit = sharedPreferences.edit()) != null && (putString = edit.putString(this.c.b, str)) != null && (putLong = putString.putLong("save_time", System.currentTimeMillis())) != null) {
                        putLong.apply();
                    }
                }
                Response<RechargeGoodsInfo> parseNetworkResponse = super.parseNetworkResponse(networkResponse);
                kotlin.jvm.internal.s.g(parseNetworkResponse, "super.parseNetworkResponse(response)");
                return parseNetworkResponse;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, C360MemberRepository c360MemberRepository) {
            super(context);
            this.f6877d = context;
            this.f6878e = c360MemberRepository;
        }

        @Override // us.pinguo.paylibcenter.n.a
        public void b(us.pinguo.paylibcenter.n.b<RechargeGoodsInfo> result) {
            kotlin.jvm.internal.s.h(result, "result");
            a(new a(result, this.f6878e, C360MemberRepository.c.a()));
        }
    }

    /* compiled from: C360MemberRepository.kt */
    /* loaded from: classes3.dex */
    public static final class d extends us.pinguo.paylibcenter.n.b<MemberInfo> {
        final /* synthetic */ String a;

        d(String str) {
            this.a = str;
        }

        @Override // us.pinguo.paylibcenter.n.b
        public void a(Exception e2) {
            kotlin.jvm.internal.s.h(e2, "e");
        }

        @Override // us.pinguo.paylibcenter.n.b
        /* renamed from: c */
        public void b(MemberInfo memberInfo) {
            Integer isVip;
            if (memberInfo != null && memberInfo.getStatus() == 200) {
                QueryUserVipInfoDoneEvent queryUserVipInfoDoneEvent = new QueryUserVipInfoDoneEvent();
                queryUserVipInfoDoneEvent.e(this.a);
                MemberExpireInfo data = memberInfo.getData();
                queryUserVipInfoDoneEvent.f(Boolean.valueOf((data == null || (isVip = data.isVip()) == null || isVip.intValue() != 1) ? false : true));
                PGEventBus.getInstance().a(queryUserVipInfoDoneEvent);
                return;
            }
            if (us.pinguo.foundation.d.f10985d) {
                Log.e("C360MemberRepository", kotlin.jvm.internal.s.q("queryUserVipInfo exception  = ", memberInfo != null ? memberInfo.toString() : null));
                throw new Exception("queryUserVipInfo exception");
            } else {
                Log.e("C360MemberRepository", kotlin.jvm.internal.s.q("queryUserVipInfo error  status = ", memberInfo != null ? Integer.valueOf(memberInfo.getStatus()) : null));
            }
        }
    }

    /* compiled from: C360MemberRepository.kt */
    /* loaded from: classes3.dex */
    public static final class e extends us.pinguo.paylibcenter.n.b<MemberInfo> {
        final /* synthetic */ boolean a;
        final /* synthetic */ kotlin.jvm.b.p<Boolean, Exception, kotlin.u> b;
        final /* synthetic */ Context c;

        /* JADX WARN: Multi-variable type inference failed */
        e(boolean z, kotlin.jvm.b.p<? super Boolean, ? super Exception, kotlin.u> pVar, Context context) {
            this.a = z;
            this.b = pVar;
            this.c = context;
        }

        @Override // us.pinguo.paylibcenter.n.b
        public void a(Exception e2) {
            kotlin.jvm.internal.s.h(e2, "e");
            this.b.invoke(Boolean.FALSE, e2);
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x0081  */
        @Override // us.pinguo.paylibcenter.n.b
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(com.pinguo.camera360.member.model.MemberInfo r10) {
            /*
                Method dump skipped, instructions count: 269
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.member.C360MemberRepository.e.b(com.pinguo.camera360.member.model.MemberInfo):void");
        }
    }

    /* compiled from: C360MemberRepository.kt */
    /* loaded from: classes3.dex */
    public static final class f extends us.pinguo.paylibcenter.n.a<UnsubscribeResponse> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f6879d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ C360MemberRepository f6880e;

        /* compiled from: C360MemberRepository.kt */
        /* loaded from: classes3.dex */
        public static final class a extends HttpGsonRequest<UnsubscribeResponse> {
            final /* synthetic */ us.pinguo.paylibcenter.n.b<UnsubscribeResponse> b;
            final /* synthetic */ C360MemberRepository c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(us.pinguo.paylibcenter.n.b<UnsubscribeResponse> bVar, C360MemberRepository c360MemberRepository, String str) {
                super(1, str);
                this.b = bVar;
                this.c = c360MemberRepository;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpRequestBase
            /* renamed from: a */
            public void onResponse(UnsubscribeResponse unsubscribeResponse) {
                kotlin.jvm.internal.s.h(unsubscribeResponse, "unsubscribeResponse");
                f.this.d(this.b, unsubscribeResponse);
            }

            @Override // com.android.volley.Request
            protected Map<String, String> getParams() {
                HashMap hashMap = new HashMap();
                us.pinguo.user.u0.e(((us.pinguo.paylibcenter.n.a) f.this).a, hashMap);
                String str = PayHelp.PAYWAY.MMPay.value;
                kotlin.jvm.internal.s.g(str, "MMPay.value");
                hashMap.put("way", str);
                us.pinguo.foundation.m.d.c(hashMap, "Nh02nt\\\":;-9/-`^$3bf0Nhf893>,/{1|");
                return hashMap;
            }

            @Override // us.pinguo.common.network.HttpRequestBase
            protected void onErrorResponse(Exception exc) {
                f.this.c(this.b, exc);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // us.pinguo.common.network.HttpGsonRequest, us.pinguo.common.network.pgrequest.BaseRequest, com.android.volley.Request
            public Response<UnsubscribeResponse> parseNetworkResponse(NetworkResponse networkResponse) {
                Map<String, String> map;
                String str;
                SharedPreferences sharedPreferences;
                SharedPreferences.Editor edit;
                SharedPreferences.Editor putString;
                SharedPreferences.Editor putLong;
                byte[] bArr = networkResponse == null ? null : networkResponse.data;
                boolean z = false;
                if (bArr == null) {
                    bArr = new byte[0];
                }
                if (networkResponse == null) {
                    map = null;
                } else {
                    try {
                        map = networkResponse.headers;
                    } catch (UnsupportedEncodingException unused) {
                        byte[] bArr2 = networkResponse != null ? networkResponse.data : null;
                        kotlin.jvm.internal.s.e(bArr2);
                        str = new String(bArr2, kotlin.text.d.a);
                    }
                }
                Charset forName = Charset.forName(HttpHeaderParser.parseCharset(map));
                kotlin.jvm.internal.s.g(forName, "forName(HttpHeaderParser…arset(response?.headers))");
                str = new String(bArr, forName);
                if (!TextUtils.isEmpty(str)) {
                    if (networkResponse != null && networkResponse.statusCode == 200) {
                        z = true;
                    }
                    if (z && (sharedPreferences = this.c.a) != null && (edit = sharedPreferences.edit()) != null && (putString = edit.putString(this.c.b, str)) != null && (putLong = putString.putLong("save_time", 0L)) != null) {
                        putLong.apply();
                    }
                }
                Response<UnsubscribeResponse> parseNetworkResponse = super.parseNetworkResponse(networkResponse);
                kotlin.jvm.internal.s.g(parseNetworkResponse, "super.parseNetworkResponse(response)");
                return parseNetworkResponse;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Context context, C360MemberRepository c360MemberRepository) {
            super(context);
            this.f6879d = context;
            this.f6880e = c360MemberRepository;
        }

        @Override // us.pinguo.paylibcenter.n.a
        public void b(us.pinguo.paylibcenter.n.b<UnsubscribeResponse> bVar) {
            a(new a(bVar, this.f6880e, C360MemberRepository.c.b()));
        }
    }

    static {
        boolean z = us.pinguo.foundation.d.f10985d;
        String str = (z && us.pinguo.foundation.d.b) ? "https://bmall-qa.camera360.com" : z ? "https://bmall-dev.camera360.com" : "https://bmall.camera360.com";
        f6874d = str;
        f6875e = kotlin.jvm.internal.s.q(str, "/api/vip/getProductList");
        f6876f = kotlin.jvm.internal.s.q(str, "/api/vip/unsubscribe");
    }

    public C360MemberRepository(Context ctx) {
        kotlin.jvm.internal.s.h(ctx, "ctx");
        this.a = ctx.getSharedPreferences("member_price_file", 0);
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.s.g(locale, "getDefault()");
        this.b = kotlin.jvm.internal.s.q("price_info_", locale);
    }

    private final void e(final us.pinguo.paylibcenter.n.b<MemberInfo> bVar) {
        us.pinguo.foundation.statistics.h.b.n("", "/api/vip/checkVipInfo", SocialConstants.TYPE_REQUEST);
        final long currentTimeMillis = System.currentTimeMillis();
        PGRequest.Builder builder = new PGRequest.Builder(MemberInfo.class);
        builder.withMethod(1).withUriPath("/api/vip/checkVipInfo").withDomain(f6874d);
        us.pinguo.user.u0.d(builder);
        RxVolley.create(builder.build()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.pinguo.camera360.member.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                C360MemberRepository.f(currentTimeMillis, bVar, (MemberInfo) obj);
            }
        }, new Action1() { // from class: com.pinguo.camera360.member.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                C360MemberRepository.g(currentTimeMillis, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(long j2, us.pinguo.paylibcenter.n.b result, MemberInfo response) {
        kotlin.jvm.internal.s.h(result, "$result");
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/vip/checkVipInfo", FirebaseAnalytics.Param.SUCCESS);
        if (response.getStatus() == 200) {
            result.b(response);
            return;
        }
        kotlin.jvm.internal.s.g(response, "response");
        result.a(new Exception(kotlin.jvm.internal.s.q("asyncVipInfo error = ", response)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(long j2, Throwable th) {
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/vip/checkVipInfo", "failed");
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(long j2, d result, MemberInfo response) {
        kotlin.jvm.internal.s.h(result, "$result");
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/vip/checkVipInfo", FirebaseAnalytics.Param.SUCCESS);
        if (response.getStatus() == 200) {
            result.b(response);
            return;
        }
        kotlin.jvm.internal.s.g(response, "response");
        result.a(new Exception(kotlin.jvm.internal.s.q("asyncVipInfo error = ", response)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(long j2, Throwable th) {
        us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
        iVar.n((System.currentTimeMillis() - j2) + "", "/api/vip/checkVipInfo", "failed");
        us.pinguo.foundation.e.e(th);
        us.pinguo.common.log.a.f(th);
    }

    public final void h(Context ctx) {
        kotlin.jvm.internal.s.h(ctx, "ctx");
        new ApiGiftVipGet(ctx).get(new b());
    }

    public final boolean i() {
        if (Conditions.d()) {
            return false;
        }
        y0.c r = User.d().r(false);
        long q = CameraBusinessSettingModel.v().q("key_sync_vip_time", 0L);
        us.pinguo.repository2020.utils.o oVar = us.pinguo.repository2020.utils.o.a;
        float c2 = oVar.c("key_expire_time", 0.0f, "c360_default_sp_filte");
        float c3 = oVar.c("key_purchase_time", 0.0f, "c360_default_sp_filte");
        float currentTimeMillis = ((float) System.currentTimeMillis()) / 1000.0f;
        VipManager vipManager = VipManager.a;
        if (vipManager.s() == null) {
            vipManager.P(new VipReemCodeInfo(c3 <= currentTimeMillis && currentTimeMillis <= c2, c2, c3));
        } else {
            VipReemCodeInfo s = vipManager.s();
            if (s != null) {
                s.setGiftVip(c3 <= currentTimeMillis && currentTimeMillis <= c2);
            }
        }
        if (q != 0 && r.b != 0) {
            VipReemCodeInfo s2 = vipManager.s();
            if (!kotlin.jvm.internal.s.a(s2 == null ? null : Float.valueOf(s2.getExpireTime()), 0.0f)) {
                if (!r.d()) {
                    VipReemCodeInfo s3 = vipManager.s();
                    if ((s3 == null || s3.getGiftVip()) ? false : true) {
                        return false;
                    }
                }
                long j2 = 1000;
                if (System.currentTimeMillis() / j2 <= r.b) {
                    float currentTimeMillis2 = (float) (System.currentTimeMillis() / j2);
                    VipReemCodeInfo s4 = vipManager.s();
                    if (currentTimeMillis2 <= (s4 == null ? 0.0f : s4.getExpireTime()) && System.currentTimeMillis() / j2 >= q && r.b - (System.currentTimeMillis() / j2) >= 172800) {
                        VipReemCodeInfo s5 = vipManager.s();
                        if ((s5 != null ? s5.getExpireTime() : 0.0f) - ((float) (System.currentTimeMillis() / j2)) >= 172800.0f) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public final void n(Context ctx, us.pinguo.paylibcenter.n.b<RechargeGoodsInfo> asyncResult) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        SharedPreferences.Editor remove2;
        String string;
        kotlin.jvm.internal.s.h(ctx, "ctx");
        kotlin.jvm.internal.s.h(asyncResult, "asyncResult");
        SharedPreferences sharedPreferences = this.a;
        String str = "";
        if (sharedPreferences != null && (string = sharedPreferences.getString(this.b, "")) != null) {
            str = string;
        }
        SharedPreferences sharedPreferences2 = this.a;
        long j2 = sharedPreferences2 != null ? sharedPreferences2.getLong("save_time", 0L) : 0L;
        if (!TextUtils.isEmpty(str) && Math.abs(System.currentTimeMillis() - j2) < AdvTimeUtils.MILLIS_OF_A_DAY) {
            try {
                us.pinguo.common.log.a.c("loadMemberPriceList parse local data ", new Object[0]);
                asyncResult.b((RechargeGoodsInfo) GsonUtilKt.getCachedGson().j(str, RechargeGoodsInfo.class));
                return;
            } catch (Exception unused) {
                if (!us.pinguo.foundation.d.f10985d) {
                    us.pinguo.common.log.a.e("loadMemberPriceList parse local error ", new Object[0]);
                } else {
                    throw new Exception("loadMemberPriceList parse local error ");
                }
            }
        } else {
            SharedPreferences sharedPreferences3 = this.a;
            if (sharedPreferences3 != null && (edit = sharedPreferences3.edit()) != null && (remove = edit.remove(this.b)) != null && (remove2 = remove.remove("save_time")) != null) {
                remove2.apply();
            }
        }
        new c(ctx, this).b(asyncResult);
    }

    public final void o(Context ctx, String userId) {
        kotlin.jvm.internal.s.h(ctx, "ctx");
        kotlin.jvm.internal.s.h(userId, "userId");
        if (us.pinguo.util.q.f(ctx)) {
            final d dVar = new d(userId);
            us.pinguo.foundation.statistics.h.b.n("", "/api/vip/checkVipInfo", SocialConstants.TYPE_REQUEST);
            final long currentTimeMillis = System.currentTimeMillis();
            PGRequest.Builder builder = new PGRequest.Builder(MemberInfo.class);
            builder.withMethod(1).withUriPath("/api/vip/checkVipInfo").withDomain(f6874d);
            builder.addParam(GuestProfileFragment.USER_ID, us.pinguo.foundation.utils.p.a(userId));
            builder.addParam("eid", us.pinguo.bigdata.a.e());
            RxVolley.create(builder.build()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.pinguo.camera360.member.i
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    C360MemberRepository.p(currentTimeMillis, dVar, (MemberInfo) obj);
                }
            }, new Action1() { // from class: com.pinguo.camera360.member.h
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    C360MemberRepository.q(currentTimeMillis, (Throwable) obj);
                }
            });
        }
    }

    public final void r(Context ctx, boolean z) {
        kotlin.jvm.internal.s.h(ctx, "ctx");
        s(ctx, z, C360MemberRepository$syncVipExpireTimeFromServer$1.INSTANCE);
    }

    public final void s(Context ctx, boolean z, kotlin.jvm.b.p<? super Boolean, ? super Exception, kotlin.u> block) {
        kotlin.jvm.internal.s.h(ctx, "ctx");
        kotlin.jvm.internal.s.h(block, "block");
        if (!us.pinguo.util.q.f(ctx)) {
            block.invoke(Boolean.FALSE, new Exception("No Network"));
        }
        e(new e(z, block, ctx));
    }

    public final void t(Context context, us.pinguo.paylibcenter.n.b<UnsubscribeResponse> asyncResult) {
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(asyncResult, "asyncResult");
        new f(context, this).b(asyncResult);
    }
}
