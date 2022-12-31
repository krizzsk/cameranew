package com.ironsource.sdk.controller;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.ISNEnums$ControllerState;
import com.ironsource.sdk.data.ISNEnums$ControllerType;
import com.ironsource.sdk.data.ISNEnums$ProductType;
import com.ironsource.sdk.service.TokenService;
import d.e.d.a.f;
import java.util.Map;
import org.json.JSONObject;
/* compiled from: ControllerManager.java */
/* loaded from: classes2.dex */
public class f implements com.ironsource.sdk.controller.e, com.ironsource.sdk.controller.j {

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f5745g = new Handler(Looper.getMainLooper());
    private com.ironsource.sdk.controller.j b;

    /* renamed from: d  reason: collision with root package name */
    private CountDownTimer f5746d;
    private final String a = f.class.getSimpleName();
    private ISNEnums$ControllerState c = ISNEnums$ControllerState.None;

    /* renamed from: e  reason: collision with root package name */
    private final CommandExecutor f5747e = new CommandExecutor("NativeCommandExecutor");

    /* renamed from: f  reason: collision with root package name */
    private final CommandExecutor f5748f = new CommandExecutor("ControllerCommandsExecutor");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ com.ironsource.sdk.controller.c b;
        final /* synthetic */ TokenService c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.ironsource.sdk.controller.h f5749d;

        /* compiled from: ControllerManager.java */
        /* renamed from: com.ironsource.sdk.controller.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class CountDownTimerC0215a extends CountDownTimer {

            /* compiled from: ControllerManager.java */
            /* renamed from: com.ironsource.sdk.controller.f$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            class RunnableC0216a implements Runnable {
                RunnableC0216a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    f.this.I("controller html - download timeout");
                }
            }

            CountDownTimerC0215a(long j2, long j3) {
                super(j2, j3);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                com.ironsource.sdk.utils.d.d(f.this.a, "Global Controller Timer Finish");
                f.this.K();
                f.f5745g.post(new RunnableC0216a());
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                String str = f.this.a;
                com.ironsource.sdk.utils.d.d(str, "Global Controller Timer Tick " + j2);
            }
        }

        a(Context context, com.ironsource.sdk.controller.c cVar, TokenService tokenService, com.ironsource.sdk.controller.h hVar) {
            this.a = context;
            this.b = cVar;
            this.c = tokenService;
            this.f5749d = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f fVar = f.this;
                fVar.b = fVar.J(this.a, this.b, this.c, this.f5749d);
                f.this.f5746d = new CountDownTimerC0215a(200000L, 1000L).start();
                ((WebController) f.this.b).N1();
                f.this.f5747e.c();
                f.this.f5747e.b();
            } catch (Exception e2) {
                f.this.I(Log.getStackTraceString(e2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ d.e.d.n.h.c b;

        b(String str, d.e.d.n.h.c cVar) {
            this.a = str;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.c(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        final /* synthetic */ com.ironsource.sdk.data.b a;
        final /* synthetic */ Map b;
        final /* synthetic */ d.e.d.n.h.c c;

        c(com.ironsource.sdk.data.b bVar, Map map, d.e.d.n.h.c cVar) {
            this.a = bVar;
            this.b = map;
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.e.d.a.a aVar = new d.e.d.a.a();
            aVar.a("demandsourcename", this.a.d());
            aVar.a("producttype", d.e.d.a.e.e(this.a, ISNEnums$ProductType.Interstitial));
            aVar.a("isbiddinginstance", Boolean.valueOf(d.e.d.a.e.d(this.a)));
            aVar.a("custom_c", Long.valueOf(com.ironsource.sdk.service.a.b.c(this.a.f())));
            d.e.d.a.d.d(d.e.d.a.f.f8539i, aVar.b());
            f.this.b.t(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class d implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ d.e.d.n.h.c b;

        d(JSONObject jSONObject, d.e.d.n.h.c cVar) {
            this.a = jSONObject;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.r(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        final /* synthetic */ com.ironsource.sdk.data.b a;
        final /* synthetic */ Map b;
        final /* synthetic */ d.e.d.n.h.c c;

        e(com.ironsource.sdk.data.b bVar, Map map, d.e.d.n.h.c cVar) {
            this.a = bVar;
            this.b = map;
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.m(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* renamed from: com.ironsource.sdk.controller.f$f  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0217f implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ com.ironsource.sdk.data.b c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d.e.d.n.h.b f5753d;

        RunnableC0217f(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.b bVar2) {
            this.a = str;
            this.b = str2;
            this.c = bVar;
            this.f5753d = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.i(this.a, this.b, this.c, this.f5753d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class g implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ d.e.d.n.h.b b;

        g(JSONObject jSONObject, d.e.d.n.h.b bVar) {
            this.a = jSONObject;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.p(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class h implements Runnable {
        final /* synthetic */ Map a;
        final /* synthetic */ d.e.d.n.h.b b;

        h(Map map, d.e.d.n.h.b bVar) {
            this.a = map;
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.n(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class i implements Runnable {
        final /* synthetic */ JSONObject a;

        i(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.b(this.a);
        }
    }

    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.b != null) {
                f.this.b.destroy();
                f.this.b = null;
            }
        }
    }

    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    class k implements Runnable {
        final /* synthetic */ String a;

        k(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.I(this.a);
        }
    }

    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    class l implements Runnable {
        final /* synthetic */ String a;

        l(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.K();
            f.this.I(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class m implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d.e.d.n.e f5755d;

        m(String str, String str2, Map map, d.e.d.n.e eVar) {
            this.a = str;
            this.b = str2;
            this.c = map;
            this.f5755d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.d(this.a, this.b, this.c, this.f5755d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class n implements Runnable {
        final /* synthetic */ Map a;
        final /* synthetic */ d.e.d.n.e b;

        n(Map map, d.e.d.n.e eVar) {
            this.a = map;
            this.b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.q(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class o implements Runnable {
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
            f.this.b.e(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class p implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ com.ironsource.sdk.data.b c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d.e.d.n.h.d f5758d;

        p(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.d dVar) {
            this.a = str;
            this.b = str2;
            this.c = bVar;
            this.f5758d = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.x(this.a, this.b, this.c, this.f5758d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class q implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ d.e.d.n.h.d b;

        q(JSONObject jSONObject, d.e.d.n.h.d dVar) {
            this.a = jSONObject;
            this.b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.j(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ControllerManager.java */
    /* loaded from: classes2.dex */
    public class r implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ com.ironsource.sdk.data.b c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d.e.d.n.h.c f5760d;

        r(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.c cVar) {
            this.a = str;
            this.b = str2;
            this.c = bVar;
            this.f5760d = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.b.f(this.a, this.b, this.c, this.f5760d);
        }
    }

    public f(Context context, com.ironsource.sdk.controller.c cVar, TokenService tokenService, com.ironsource.sdk.controller.h hVar) {
        H(context, cVar, tokenService, hVar);
    }

    private void H(Context context, com.ironsource.sdk.controller.c cVar, TokenService tokenService, com.ironsource.sdk.controller.h hVar) {
        f5745g.post(new a(context, cVar, tokenService, hVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str) {
        f.a aVar = d.e.d.a.f.c;
        d.e.d.a.a aVar2 = new d.e.d.a.a();
        aVar2.a("callfailreason", str);
        d.e.d.a.d.d(aVar, aVar2.b());
        com.ironsource.sdk.controller.m mVar = new com.ironsource.sdk.controller.m(this);
        this.b = mVar;
        mVar.l(str);
        this.f5747e.c();
        this.f5747e.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebController J(Context context, com.ironsource.sdk.controller.c cVar, TokenService tokenService, com.ironsource.sdk.controller.h hVar) throws Exception {
        d.e.d.a.d.c(d.e.d.a.f.b);
        WebController webController = new WebController(context, hVar, cVar, this);
        com.ironsource.sdk.fileSystem.b bVar = new com.ironsource.sdk.fileSystem.b(context, webController.u1(), new com.ironsource.sdk.fileSystem.a(), new com.ironsource.sdk.fileSystem.c(webController.u1().f()));
        webController.T0(new com.ironsource.sdk.controller.p(context, tokenService));
        webController.R0(new OMIDJSAdapter(context));
        webController.S0(new PermissionsJSAdapter(context));
        webController.N0(new com.ironsource.sdk.controller.b());
        webController.O0(new DeviceDataJSAdapter(context));
        webController.M0(new com.ironsource.sdk.controller.a(cVar));
        webController.P0(new com.ironsource.sdk.controller.i(webController.u1().f(), bVar));
        return webController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        com.ironsource.sdk.controller.j jVar = this.b;
        if (jVar == null || !(jVar instanceof WebController)) {
            return;
        }
        jVar.destroy();
        this.b = null;
    }

    private void N() {
        this.c = ISNEnums$ControllerState.Ready;
        CountDownTimer countDownTimer = this.f5746d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f5748f.c();
        this.f5748f.b();
        this.b.u();
    }

    private boolean O() {
        return ISNEnums$ControllerState.Ready.equals(this.c);
    }

    private void P(String str) {
        d.e.d.n.d c2 = d.e.d.e.c();
        if (c2 != null) {
            c2.onFail(new com.ironsource.sdk.data.c(1001, str));
        }
    }

    private void Q() {
        d.e.d.n.d c2 = d.e.d.e.c();
        if (c2 != null) {
            c2.onSuccess();
        }
    }

    public void L(Runnable runnable) {
        this.f5747e.a(runnable);
    }

    public com.ironsource.sdk.controller.j M() {
        return this.b;
    }

    @Override // com.ironsource.sdk.controller.j
    public void a() {
        if (O()) {
            this.b.a();
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void b(JSONObject jSONObject) {
        this.f5748f.a(new i(jSONObject));
    }

    @Override // com.ironsource.sdk.controller.j
    public void c(String str, d.e.d.n.h.c cVar) {
        this.f5748f.a(new b(str, cVar));
    }

    @Override // com.ironsource.sdk.controller.j
    public void d(String str, String str2, Map<String, String> map, d.e.d.n.e eVar) {
        this.f5748f.a(new m(str, str2, map, eVar));
    }

    @Override // com.ironsource.sdk.controller.j
    public void destroy() {
        CountDownTimer countDownTimer = this.f5746d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f5746d = null;
        f5745g.post(new j());
    }

    @Override // com.ironsource.sdk.controller.j
    public void e(String str, String str2, d.e.d.n.e eVar) {
        this.f5748f.a(new o(str, str2, eVar));
    }

    @Override // com.ironsource.sdk.controller.j
    public void f(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.c cVar) {
        this.f5748f.a(new r(str, str2, bVar, cVar));
    }

    @Override // com.ironsource.sdk.controller.e
    public void g() {
        if (ISNEnums$ControllerType.Web.equals(getType())) {
            d.e.d.a.d.c(d.e.d.a.f.f8534d);
            Q();
        }
        N();
    }

    @Override // com.ironsource.sdk.controller.j
    public ISNEnums$ControllerType getType() {
        return this.b.getType();
    }

    @Override // com.ironsource.sdk.controller.j
    public boolean h(String str) {
        if (O()) {
            return this.b.h(str);
        }
        return false;
    }

    @Override // com.ironsource.sdk.controller.j
    public void i(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.b bVar2) {
        this.f5748f.a(new RunnableC0217f(str, str2, bVar, bVar2));
    }

    @Override // com.ironsource.sdk.controller.j
    public void j(JSONObject jSONObject, d.e.d.n.h.d dVar) {
        this.f5748f.a(new q(jSONObject, dVar));
    }

    @Override // com.ironsource.sdk.controller.j
    public void k(Context context) {
        if (O()) {
            this.b.k(context);
        }
    }

    @Override // com.ironsource.sdk.controller.e
    public void l(String str) {
        f.a aVar = d.e.d.a.f.f8542l;
        d.e.d.a.a aVar2 = new d.e.d.a.a();
        aVar2.a("callfailreason", str);
        d.e.d.a.d.d(aVar, aVar2.b());
        P(str);
        CountDownTimer countDownTimer = this.f5746d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        K();
        f5745g.post(new k(str));
    }

    @Override // com.ironsource.sdk.controller.j
    public void m(com.ironsource.sdk.data.b bVar, Map<String, String> map, d.e.d.n.h.c cVar) {
        this.f5748f.a(new e(bVar, map, cVar));
    }

    @Override // com.ironsource.sdk.controller.j
    public void n(Map<String, String> map, d.e.d.n.h.b bVar) {
        this.f5748f.a(new h(map, bVar));
    }

    @Override // com.ironsource.sdk.controller.j
    public void o(Context context) {
        if (O()) {
            this.b.o(context);
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void p(JSONObject jSONObject, d.e.d.n.h.b bVar) {
        this.f5748f.a(new g(jSONObject, bVar));
    }

    @Override // com.ironsource.sdk.controller.j
    public void q(Map<String, String> map, d.e.d.n.e eVar) {
        this.f5748f.a(new n(map, eVar));
    }

    @Override // com.ironsource.sdk.controller.j
    public void r(JSONObject jSONObject, d.e.d.n.h.c cVar) {
        this.f5748f.a(new d(jSONObject, cVar));
    }

    @Override // com.ironsource.sdk.controller.e
    public void s() {
        this.c = ISNEnums$ControllerState.Loaded;
    }

    @Override // com.ironsource.sdk.controller.j
    public void setCommunicationWithAdView(ISNAdView iSNAdView) {
        com.ironsource.sdk.controller.j jVar = this.b;
        if (jVar != null) {
            jVar.setCommunicationWithAdView(iSNAdView);
        }
    }

    @Override // com.ironsource.sdk.controller.j
    public void t(com.ironsource.sdk.data.b bVar, Map<String, String> map, d.e.d.n.h.c cVar) {
        this.f5748f.a(new c(bVar, map, cVar));
    }

    @Override // com.ironsource.sdk.controller.j
    @Deprecated
    public void u() {
    }

    @Override // com.ironsource.sdk.controller.j
    public void v() {
        if (O()) {
            this.b.v();
        }
    }

    @Override // com.ironsource.sdk.controller.e
    public void w(String str) {
        f.a aVar = d.e.d.a.f.x;
        d.e.d.a.a aVar2 = new d.e.d.a.a();
        aVar2.a("generalmessage", str);
        d.e.d.a.d.d(aVar, aVar2.b());
        CountDownTimer countDownTimer = this.f5746d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        f5745g.post(new l(str));
    }

    @Override // com.ironsource.sdk.controller.j
    public void x(String str, String str2, com.ironsource.sdk.data.b bVar, d.e.d.n.h.d dVar) {
        this.f5748f.a(new p(str, str2, bVar, dVar));
    }
}
