package d.e.d.k;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.controller.FeaturesManager;
import com.ironsource.sdk.data.ISNEnums$ProductType;
import com.ironsource.sdk.service.TokenService;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: IronSourceAdsPublisherAgent.java */
/* loaded from: classes2.dex */
public final class b implements d.e.d.j, d.e.d.n.h.d, d.e.d.n.h.c, d.e.d.n.h.a, d.e.d.n.h.b, d.e.d.f, d.e.d.k.c {

    /* renamed from: j  reason: collision with root package name */
    private static b f8549j;
    private com.ironsource.sdk.controller.f a;
    private d.e.d.n.e b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f8550d;

    /* renamed from: e  reason: collision with root package name */
    private long f8551e;

    /* renamed from: f  reason: collision with root package name */
    private com.ironsource.sdk.controller.h f8552f;

    /* renamed from: g  reason: collision with root package name */
    private TokenService f8553g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8554h = false;

    /* renamed from: i  reason: collision with root package name */
    private com.ironsource.sdk.controller.c f8555i;

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ JSONObject a;

        a(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.r(this.a, b.this);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* renamed from: d.e.d.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0298b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ com.ironsource.sdk.data.b c;

        RunnableC0298b(String str, String str2, com.ironsource.sdk.data.b bVar) {
            this.a = str;
            this.b = str2;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.i(this.a, this.b, this.c, b.this);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class c implements Runnable {
        final /* synthetic */ com.ironsource.sdk.data.b a;

        c(com.ironsource.sdk.data.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.i(b.this.c, b.this.f8550d, this.a, b.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        final /* synthetic */ Map a;

        d(Map map) {
            this.a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.n(this.a, b.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        final /* synthetic */ JSONObject a;

        e(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.p(this.a, b.this);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class f implements Runnable {
        final /* synthetic */ JSONObject a;

        f(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.b(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    public class g implements Runnable {
        final /* synthetic */ d.e.d.c a;
        final /* synthetic */ Map b;

        g(d.e.d.c cVar, Map map) {
            this.a = cVar;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.data.b d2 = b.this.f8552f.d(ISNEnums$ProductType.Interstitial, this.a.c());
            if (d2 != null) {
                b.this.a.t(d2, this.b, b.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    public class h implements Runnable {
        final /* synthetic */ d.e.d.c a;
        final /* synthetic */ Map b;

        h(d.e.d.c cVar, Map map) {
            this.a = cVar;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.sdk.controller.h hVar = b.this.f8552f;
            ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.Interstitial;
            com.ironsource.sdk.data.b b = hVar.b(iSNEnums$ProductType, this.a);
            d.e.d.a.a aVar = new d.e.d.a.a();
            aVar.a("isbiddinginstance", Boolean.valueOf(this.a.e()));
            aVar.a("demandsourcename", this.a.d());
            if (this.a.g()) {
                iSNEnums$ProductType = ISNEnums$ProductType.RewardedVideo;
            }
            aVar.a("producttype", iSNEnums$ProductType);
            aVar.a("custom_c", Long.valueOf(com.ironsource.sdk.service.a.b.c(this.a.c())));
            d.e.d.a.d.d(d.e.d.a.f.f8537g, aVar.b());
            b.this.a.f(b.this.c, b.this.f8550d, b, b.this);
            this.a.h(true);
            b.this.a.t(b, this.b, b.this);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class i implements Runnable {
        final /* synthetic */ com.ironsource.sdk.data.b a;
        final /* synthetic */ Map b;

        i(com.ironsource.sdk.data.b bVar, Map map) {
            this.a = bVar;
            this.b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.m(this.a, this.b, b.this);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class j implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ com.ironsource.sdk.data.b c;

        j(String str, String str2, com.ironsource.sdk.data.b bVar) {
            this.a = str;
            this.b = str2;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.x(this.a, this.b, this.c, b.this);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class k implements Runnable {
        final /* synthetic */ JSONObject a;

        k(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.j(this.a, b.this);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class l implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d.e.d.n.e f8558d;

        l(String str, String str2, Map map, d.e.d.n.e eVar) {
            this.a = str;
            this.b = str2;
            this.c = map;
            this.f8558d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.d(this.a, this.b, this.c, this.f8558d);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class m implements Runnable {
        final /* synthetic */ Map a;
        final /* synthetic */ d.e.d.n.e b;

        m(Map map, d.e.d.n.e eVar) {
            this.a = map;
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.d(b.this.c, b.this.f8550d, this.a, this.b);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class n implements Runnable {
        final /* synthetic */ Map a;

        n(Map map) {
            this.a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.q(this.a, b.this.b);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class o implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ d.e.d.n.e c;

        o(String str, String str2, d.e.d.n.e eVar) {
            this.a = str;
            this.b = str2;
            this.c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.e(this.a, this.b, this.c);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class p implements Runnable {
        final /* synthetic */ d.e.d.n.e a;

        p(d.e.d.n.e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.e(b.this.c, b.this.f8550d, this.a);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class q implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ com.ironsource.sdk.data.b c;

        q(String str, String str2, com.ironsource.sdk.data.b bVar) {
            this.a = str;
            this.b = str2;
            this.c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.f(this.a, this.b, this.c, b.this);
        }
    }

    /* compiled from: IronSourceAdsPublisherAgent.java */
    /* loaded from: classes2.dex */
    class r implements Runnable {
        final /* synthetic */ String a;

        r(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a.c(this.a, b.this);
        }
    }

    private b(Context context, int i2) {
        d0(context);
    }

    public static d.e.d.f R(Context context, String str, String str2) {
        return a0(str, str2, context);
    }

    private TokenService S(Context context) {
        TokenService tokenService = TokenService.getInstance();
        tokenService.k();
        tokenService.j(context, this.c, this.f8550d);
        return tokenService;
    }

    private Map<String, String> U(Map<String, String> map) {
        map.put("adm", com.ironsource.sdk.utils.f.a(map.get("adm")));
        return map;
    }

    private d.e.d.n.b V(com.ironsource.sdk.data.b bVar) {
        if (bVar == null) {
            return null;
        }
        return (d.e.d.n.b) bVar.g();
    }

    private d.e.d.n.c W(com.ironsource.sdk.data.b bVar) {
        if (bVar == null) {
            return null;
        }
        return (d.e.d.n.c) bVar.g();
    }

    private d.e.d.n.f X(com.ironsource.sdk.data.b bVar) {
        if (bVar == null) {
            return null;
        }
        return (d.e.d.n.f) bVar.g();
    }

    private com.ironsource.sdk.data.b Z(ISNEnums$ProductType iSNEnums$ProductType, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f8552f.d(iSNEnums$ProductType, str);
    }

    public static synchronized d.e.d.f a0(String str, String str2, Context context) {
        b bVar;
        synchronized (b.class) {
            if (f8549j == null) {
                d.e.d.a.d.c(d.e.d.a.f.a);
                f8549j = new b(str, str2, context);
            } else {
                TokenService.getInstance().b(str);
                TokenService.getInstance().c(str2);
            }
            bVar = f8549j;
        }
        return bVar;
    }

    public static synchronized b b0(Context context) throws Exception {
        b c0;
        synchronized (b.class) {
            c0 = c0(context, 0);
        }
        return c0;
    }

    public static synchronized b c0(Context context, int i2) throws Exception {
        b bVar;
        synchronized (b.class) {
            com.ironsource.sdk.utils.d.d("IronSourceAdsPublisherAgent", "getInstance()");
            if (f8549j == null) {
                f8549j = new b(context, i2);
            }
            bVar = f8549j;
        }
        return bVar;
    }

    private void d0(Context context) {
        try {
            com.ironsource.sdk.utils.b.f(context);
            com.ironsource.sdk.utils.c.s(context, new com.ironsource.sdk.fileSystem.d(com.ironsource.sdk.utils.f.q().optJSONObject("storage")));
            com.ironsource.sdk.utils.b.e().j(com.ironsource.sdk.utils.a.i());
            this.f8553g = S(context);
            this.f8552f = new com.ironsource.sdk.controller.h();
            com.ironsource.sdk.controller.c cVar = new com.ironsource.sdk.controller.c();
            this.f8555i = cVar;
            if (context instanceof Activity) {
                cVar.b((Activity) context);
            }
            this.a = new com.ironsource.sdk.controller.f(context, this.f8555i, this.f8553g, this.f8552f);
            com.ironsource.sdk.utils.d.c(FeaturesManager.getInstance().a());
            com.ironsource.sdk.utils.d.d("IronSourceAdsPublisherAgent", "C'tor");
            T(context, com.ironsource.sdk.utils.f.q());
            this.f8551e = 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g0(d.e.d.c cVar, Map<String, String> map) {
        try {
            U(map);
        } catch (Exception e2) {
            d.e.d.a.a aVar = new d.e.d.a.a();
            aVar.a("callfailreason", e2.getMessage());
            aVar.a("generalmessage", cVar.f() ? d.e.d.m.b.a : d.e.d.m.b.b);
            aVar.a("isbiddinginstance", Boolean.valueOf(cVar.e()));
            aVar.a("demandsourcename", cVar.d());
            aVar.a("producttype", cVar.g() ? ISNEnums$ProductType.RewardedVideo : ISNEnums$ProductType.Interstitial);
            com.ironsource.sdk.service.a aVar2 = com.ironsource.sdk.service.a.b;
            aVar.a("custom_c", Long.valueOf(aVar2.c(cVar.c())));
            aVar2.b(cVar.c());
            d.e.d.a.d.d(d.e.d.a.f.f8540j, aVar.b());
            e2.printStackTrace();
            com.ironsource.sdk.utils.d.a("IronSourceAdsPublisherAgent", "loadInAppBiddingAd failed decoding  ADM " + e2.getMessage());
        }
        i0(cVar, map);
    }

    private void h0(d.e.d.c cVar, Map<String, String> map) {
        com.ironsource.sdk.utils.d.a("IronSourceAdsPublisherAgent", "loadOnInitializedInstance " + cVar.c());
        this.a.L(new g(cVar, map));
    }

    private void i0(d.e.d.c cVar, Map<String, String> map) {
        if (cVar.f()) {
            h0(cVar, map);
        } else {
            j0(cVar, map);
        }
    }

    private void j0(d.e.d.c cVar, Map<String, String> map) {
        com.ironsource.sdk.utils.d.a("IronSourceAdsPublisherAgent", "loadOnNewInstance " + cVar.c());
        this.a.L(new h(cVar, map));
    }

    private void k0(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("gdprConsentStatus")) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("consent", Boolean.parseBoolean(jSONObject.getString("gdprConsentStatus")));
            this.f8553g.o(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.e.d.n.h.d
    public void A(String str, int i2) {
        d.e.d.n.f X;
        com.ironsource.sdk.data.b Z = Z(ISNEnums$ProductType.RewardedVideo, str);
        if (Z == null || (X = X(Z)) == null) {
            return;
        }
        X.onRVAdCredited(i2);
    }

    @Override // d.e.d.n.h.a
    public void B(ISNEnums$ProductType iSNEnums$ProductType, String str) {
        d.e.d.n.c W;
        com.ironsource.sdk.data.b Z = Z(iSNEnums$ProductType, str);
        if (Z != null) {
            if (iSNEnums$ProductType == ISNEnums$ProductType.RewardedVideo) {
                d.e.d.n.f X = X(Z);
                if (X != null) {
                    X.onRVAdClosed();
                }
            } else if (iSNEnums$ProductType != ISNEnums$ProductType.Interstitial || (W = W(Z)) == null) {
            } else {
                W.onInterstitialClose();
            }
        }
    }

    @Override // d.e.d.n.h.a
    public void C(ISNEnums$ProductType iSNEnums$ProductType, String str) {
        d.e.d.n.b V;
        com.ironsource.sdk.data.b Z = Z(iSNEnums$ProductType, str);
        if (Z != null) {
            if (iSNEnums$ProductType == ISNEnums$ProductType.RewardedVideo) {
                d.e.d.n.f X = X(Z);
                if (X != null) {
                    X.onRVAdClicked();
                }
            } else if (iSNEnums$ProductType == ISNEnums$ProductType.Interstitial) {
                d.e.d.n.c W = W(Z);
                if (W != null) {
                    W.onInterstitialClick();
                }
            } else if (iSNEnums$ProductType != ISNEnums$ProductType.Banner || (V = V(Z)) == null) {
            } else {
                V.onBannerClick();
            }
        }
    }

    @Override // d.e.d.n.h.c
    public void D(String str) {
        ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.Interstitial;
        com.ironsource.sdk.data.b Z = Z(iSNEnums$ProductType, str);
        d.e.d.a.a aVar = new d.e.d.a.a();
        aVar.a("demandsourcename", str);
        if (Z != null) {
            aVar.a("producttype", d.e.d.a.e.e(Z, iSNEnums$ProductType));
            aVar.a("isbiddinginstance", Boolean.valueOf(d.e.d.a.e.d(Z)));
            com.ironsource.sdk.service.a aVar2 = com.ironsource.sdk.service.a.b;
            aVar.a("custom_c", Long.valueOf(aVar2.c(Z.f())));
            aVar2.b(Z.f());
            d.e.d.n.c W = W(Z);
            if (W != null) {
                W.onInterstitialLoadSuccess();
            }
        }
        d.e.d.a.d.d(d.e.d.a.f.f8541k, aVar.b());
    }

    @Override // d.e.d.j
    public void E(String str, String str2, String str3, Map<String, String> map, d.e.d.n.c cVar) {
        this.c = str;
        this.f8550d = str2;
        this.a.L(new q(str, str2, this.f8552f.c(ISNEnums$ProductType.Interstitial, str3, map, cVar)));
    }

    @Override // d.e.d.n.h.c
    public void F(String str) {
        d.e.d.n.c W;
        com.ironsource.sdk.data.b Z = Z(ISNEnums$ProductType.Interstitial, str);
        if (Z == null || (W = W(Z)) == null) {
            return;
        }
        W.onInterstitialShowSuccess();
    }

    @Override // d.e.d.n.h.a
    public void G(ISNEnums$ProductType iSNEnums$ProductType, String str) {
        d.e.d.n.f X;
        com.ironsource.sdk.data.b Z = Z(iSNEnums$ProductType, str);
        if (Z != null) {
            if (iSNEnums$ProductType == ISNEnums$ProductType.Interstitial) {
                d.e.d.n.c W = W(Z);
                if (W != null) {
                    W.onInterstitialOpen();
                }
            } else if (iSNEnums$ProductType != ISNEnums$ProductType.RewardedVideo || (X = X(Z)) == null) {
            } else {
                X.onRVAdOpened();
            }
        }
    }

    @Override // d.e.d.j
    public void H(String str, String str2, int i2) {
        ISNEnums$ProductType s;
        com.ironsource.sdk.data.b d2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (s = com.ironsource.sdk.utils.f.s(str)) == null || (d2 = this.f8552f.d(s, str2)) == null) {
            return;
        }
        d2.m(i2);
    }

    @Override // d.e.d.n.h.a
    public void I(ISNEnums$ProductType iSNEnums$ProductType, String str, com.ironsource.sdk.data.a aVar) {
        d.e.d.n.b V;
        com.ironsource.sdk.data.b Z = Z(iSNEnums$ProductType, str);
        if (Z != null) {
            Z.l(2);
            if (iSNEnums$ProductType == ISNEnums$ProductType.RewardedVideo) {
                d.e.d.n.f X = X(Z);
                if (X != null) {
                    X.onRVInitSuccess(aVar);
                }
            } else if (iSNEnums$ProductType == ISNEnums$ProductType.Interstitial) {
                d.e.d.n.c W = W(Z);
                if (W != null) {
                    W.onInterstitialInitSuccess();
                }
            } else if (iSNEnums$ProductType != ISNEnums$ProductType.Banner || (V = V(Z)) == null) {
            } else {
                V.onBannerInitSuccess();
            }
        }
    }

    @Override // d.e.d.h
    public void J(Map<String, String> map, d.e.d.n.e eVar) {
        this.b = eVar;
        this.a.L(new m(map, eVar));
    }

    @Override // d.e.d.k.c
    public void K(Activity activity) {
        try {
            this.a.a();
            this.a.k(activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.e.d.n.h.d
    public void L(String str, String str2) {
        d.e.d.n.f X;
        com.ironsource.sdk.data.b Z = Z(ISNEnums$ProductType.RewardedVideo, str);
        if (Z == null || (X = X(Z)) == null) {
            return;
        }
        X.onRVShowFail(str2);
    }

    public void T(Context context, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("enableLifeCycleListeners", false);
        this.f8554h = optBoolean;
        if (optBoolean) {
            try {
                ((Application) context).registerActivityLifecycleCallbacks(new d.e.d.k.a(this));
            } catch (Throwable th) {
                d.e.d.a.a aVar = new d.e.d.a.a();
                aVar.a("generalmessage", th.getMessage());
                d.e.d.a.d.d(d.e.d.a.f.t, aVar.b());
            }
        }
    }

    public com.ironsource.sdk.controller.f Y() {
        return this.a;
    }

    @Override // d.e.d.j, d.e.d.f
    public void a(Activity activity) {
        if (this.f8554h) {
            return;
        }
        p(activity);
    }

    @Override // d.e.d.j, d.e.d.f
    public void b(JSONObject jSONObject) {
        k0(jSONObject);
        this.a.L(new f(jSONObject));
    }

    @Override // d.e.d.j, d.e.d.f
    public void c(Activity activity) {
        if (this.f8554h) {
            return;
        }
        K(activity);
    }

    @Override // d.e.d.j
    public void d(String str, String str2, Map<String, String> map, d.e.d.n.e eVar) {
        this.c = str;
        this.f8550d = str2;
        this.b = eVar;
        this.a.L(new l(str, str2, map, eVar));
    }

    @Override // d.e.d.j
    public void e(String str, String str2, d.e.d.n.e eVar) {
        this.c = str;
        this.f8550d = str2;
        this.a.L(new o(str, str2, eVar));
    }

    public void e0(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a.L(new e(jSONObject));
        }
    }

    @Override // d.e.d.j, d.e.d.h
    public void f(Activity activity, Map<String, String> map) {
        if (activity != null) {
            this.f8555i.b(activity);
        }
        this.a.L(new n(map));
    }

    public void f0(Map<String, String> map, Activity activity) {
        this.f8555i.b(activity);
        if (map != null) {
            U(map);
            this.a.L(new d(map));
        }
    }

    @Override // d.e.d.j, d.e.d.h
    public ISNAdView g(Activity activity, d.e.d.b bVar) {
        this.f8551e++;
        ISNAdView iSNAdView = new ISNAdView(activity, "SupersonicAds_" + this.f8551e, bVar);
        this.a.setCommunicationWithAdView(iSNAdView);
        return iSNAdView;
    }

    @Override // d.e.d.j
    public boolean h(String str) {
        return this.a.h(str);
    }

    @Override // d.e.d.h
    public void i(Activity activity, d.e.d.c cVar, Map<String, String> map) {
        this.f8555i.b(activity);
        long currentTimeMillis = System.currentTimeMillis();
        map.put("loadStartTime", String.valueOf(currentTimeMillis));
        com.ironsource.sdk.service.a.b.a(cVar.c(), currentTimeMillis);
        d.e.d.a.a aVar = new d.e.d.a.a();
        aVar.a("isbiddinginstance", Boolean.valueOf(cVar.e()));
        aVar.a("demandsourcename", cVar.d());
        aVar.a("producttype", cVar.g() ? ISNEnums$ProductType.RewardedVideo : ISNEnums$ProductType.Interstitial);
        aVar.a("custom_c", Long.valueOf(currentTimeMillis));
        d.e.d.a.d.d(d.e.d.a.f.f8535e, aVar.b());
        com.ironsource.sdk.utils.d.a("IronSourceAdsPublisherAgent", "loadAd " + cVar.c());
        if (cVar.e()) {
            g0(cVar, map);
        } else {
            i0(cVar, map);
        }
    }

    @Override // d.e.d.n.h.c
    public void j(String str, String str2) {
        d.e.d.n.c W;
        com.ironsource.sdk.data.b Z = Z(ISNEnums$ProductType.Interstitial, str);
        if (Z == null || (W = W(Z)) == null) {
            return;
        }
        W.onInterstitialShowFailed(str2);
    }

    @Override // d.e.d.h
    public void k(d.e.d.c cVar, Map<String, String> map) {
        com.ironsource.sdk.utils.d.d("IronSourceAdsPublisherAgent", "showAd " + cVar.c());
        com.ironsource.sdk.data.b d2 = this.f8552f.d(ISNEnums$ProductType.Interstitial, cVar.c());
        if (d2 == null) {
            return;
        }
        this.a.L(new i(d2, map));
    }

    @Override // d.e.d.n.h.a
    public void l(ISNEnums$ProductType iSNEnums$ProductType, String str, String str2, JSONObject jSONObject) {
        d.e.d.n.f X;
        com.ironsource.sdk.data.b Z = Z(iSNEnums$ProductType, str);
        if (Z != null) {
            try {
                if (iSNEnums$ProductType == ISNEnums$ProductType.Interstitial) {
                    d.e.d.n.c W = W(Z);
                    if (W != null) {
                        jSONObject.put("demandSourceName", str);
                        W.onInterstitialEventNotificationReceived(str2, jSONObject);
                    }
                } else if (iSNEnums$ProductType == ISNEnums$ProductType.RewardedVideo && (X = X(Z)) != null) {
                    jSONObject.put("demandSourceName", str);
                    X.onRVEventNotificationReceived(str2, jSONObject);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.e.d.n.h.c
    public void m(String str, String str2) {
        ISNEnums$ProductType iSNEnums$ProductType = ISNEnums$ProductType.Interstitial;
        com.ironsource.sdk.data.b Z = Z(iSNEnums$ProductType, str);
        d.e.d.a.a aVar = new d.e.d.a.a();
        aVar.a("callfailreason", str2);
        aVar.a("demandsourcename", str);
        if (Z != null) {
            aVar.a("producttype", d.e.d.a.e.e(Z, iSNEnums$ProductType));
            aVar.a("generalmessage", Z.c() == 2 ? d.e.d.m.b.a : d.e.d.m.b.b);
            aVar.a("isbiddinginstance", Boolean.valueOf(d.e.d.a.e.d(Z)));
            com.ironsource.sdk.service.a aVar2 = com.ironsource.sdk.service.a.b;
            aVar.a("custom_c", Long.valueOf(aVar2.c(Z.f())));
            aVar2.b(Z.f());
            d.e.d.n.c W = W(Z);
            if (W != null) {
                W.onInterstitialLoadFailed(str2);
            }
        }
        d.e.d.a.d.d(d.e.d.a.f.f8536f, aVar.b());
    }

    @Override // d.e.d.h
    public boolean n(d.e.d.c cVar) {
        com.ironsource.sdk.utils.d.a("IronSourceAdsPublisherAgent", "isAdAvailable " + cVar.c());
        com.ironsource.sdk.data.b d2 = this.f8552f.d(ISNEnums$ProductType.Interstitial, cVar.c());
        if (d2 == null) {
            return false;
        }
        return d2.b();
    }

    @Override // d.e.d.j
    public void o(JSONObject jSONObject) {
        this.a.L(new a(jSONObject));
    }

    @Override // d.e.d.n.h.c
    public void onInterstitialAdRewarded(String str, int i2) {
        com.ironsource.sdk.data.b Z = Z(ISNEnums$ProductType.Interstitial, str);
        d.e.d.n.c W = W(Z);
        if (Z == null || W == null) {
            return;
        }
        W.onInterstitialAdRewarded(str, i2);
    }

    @Override // d.e.d.k.c
    public void p(Activity activity) {
        this.f8555i.b(activity);
        this.a.v();
        this.a.o(activity);
    }

    @Override // d.e.d.j
    public void q(String str, String str2, String str3, Map<String, String> map, d.e.d.n.f fVar) {
        this.c = str;
        this.f8550d = str2;
        this.a.L(new j(str, str2, this.f8552f.c(ISNEnums$ProductType.RewardedVideo, str3, map, fVar)));
    }

    @Override // d.e.d.h
    public void r(d.e.d.n.e eVar) {
        this.a.L(new p(eVar));
    }

    @Override // d.e.d.n.h.b
    public void s(String str) {
        d.e.d.n.b V;
        com.ironsource.sdk.data.b Z = Z(ISNEnums$ProductType.Banner, str);
        if (Z == null || (V = V(Z)) == null) {
            return;
        }
        V.onBannerLoadSuccess();
    }

    @Override // d.e.d.j
    public void t(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("demandSourceName");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.a.L(new r(optString));
    }

    @Override // d.e.d.n.h.d
    public void u(String str) {
        d.e.d.n.f X;
        com.ironsource.sdk.data.b Z = Z(ISNEnums$ProductType.RewardedVideo, str);
        if (Z == null || (X = X(Z)) == null) {
            return;
        }
        X.onRVNoMoreOffers();
    }

    @Override // d.e.d.j
    public void v(String str, String str2, String str3, Map<String, String> map, d.e.d.n.b bVar) {
        this.c = str;
        this.f8550d = str2;
        this.a.L(new RunnableC0298b(str, str2, this.f8552f.c(ISNEnums$ProductType.Banner, str3, map, bVar)));
    }

    @Override // d.e.d.h
    public void w(String str, Map<String, String> map, d.e.d.n.b bVar) {
        this.a.L(new c(this.f8552f.c(ISNEnums$ProductType.Banner, str, map, bVar)));
    }

    @Override // d.e.d.j
    public void x(JSONObject jSONObject) {
        this.a.L(new k(jSONObject));
    }

    @Override // d.e.d.n.h.a
    public void y(ISNEnums$ProductType iSNEnums$ProductType, String str, String str2) {
        d.e.d.n.b V;
        com.ironsource.sdk.data.b Z = Z(iSNEnums$ProductType, str);
        d.e.d.a.a aVar = new d.e.d.a.a();
        aVar.a("demandsourcename", str);
        aVar.a("producttype", iSNEnums$ProductType);
        aVar.a("callfailreason", str2);
        com.ironsource.sdk.service.a aVar2 = com.ironsource.sdk.service.a.b;
        aVar.a("custom_c", Long.valueOf(aVar2.c(Z.f())));
        aVar2.b(Z.f());
        if (Z != null) {
            aVar.a("isbiddinginstance", Boolean.valueOf(d.e.d.a.e.d(Z)));
            Z.l(3);
            if (iSNEnums$ProductType == ISNEnums$ProductType.RewardedVideo) {
                d.e.d.n.f X = X(Z);
                if (X != null) {
                    X.onRVInitFail(str2);
                }
            } else if (iSNEnums$ProductType == ISNEnums$ProductType.Interstitial) {
                d.e.d.n.c W = W(Z);
                if (W != null) {
                    W.onInterstitialInitFailed(str2);
                }
            } else if (iSNEnums$ProductType == ISNEnums$ProductType.Banner && (V = V(Z)) != null) {
                V.onBannerInitFailed(str2);
            }
        }
        d.e.d.a.d.d(d.e.d.a.f.f8538h, aVar.b());
    }

    @Override // d.e.d.n.h.b
    public void z(String str, String str2) {
        d.e.d.n.b V;
        com.ironsource.sdk.data.b Z = Z(ISNEnums$ProductType.Banner, str);
        if (Z == null || (V = V(Z)) == null) {
            return;
        }
        V.onBannerLoadFail(str2);
    }

    b(String str, String str2, Context context) {
        this.c = str;
        this.f8550d = str2;
        d0(context);
    }
}
