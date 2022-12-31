package com.ironsource.mediationsdk.n0;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ListenersWrapper.java */
/* loaded from: classes2.dex */
public class o implements com.ironsource.mediationsdk.n0.s, com.ironsource.mediationsdk.n0.l, com.ironsource.mediationsdk.n0.j, com.ironsource.mediationsdk.n0.v {
    private com.ironsource.mediationsdk.n0.s a;
    private com.ironsource.mediationsdk.n0.l b;
    private com.ironsource.mediationsdk.n0.q c;

    /* renamed from: d  reason: collision with root package name */
    private com.ironsource.mediationsdk.n0.v f5640d;

    /* renamed from: e  reason: collision with root package name */
    private v f5641e;

    /* renamed from: f  reason: collision with root package name */
    private com.ironsource.mediationsdk.model.k f5642f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f5643g = null;

    /* renamed from: h  reason: collision with root package name */
    private long f5644h;

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.b.c();
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class b implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.logger.b a;

        b(com.ironsource.mediationsdk.logger.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.b.a(this.a);
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.b.h();
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.b.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.logger.b a;

        e(com.ironsource.mediationsdk.logger.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.b.e(this.a);
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.b.g();
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.b.f();
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.c.l();
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class i implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.logger.b a;

        i(com.ironsource.mediationsdk.logger.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.c.r(this.a);
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class j implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.logger.b a;

        j(com.ironsource.mediationsdk.logger.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.c.m(this.a);
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class k implements Runnable {
        final /* synthetic */ String a;

        k(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.a)) {
                return;
            }
            o.this.f5640d.b(this.a);
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.c.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    public class m implements Runnable {
        final /* synthetic */ boolean a;

        m(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.c.n(this.a);
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a.onRewardedVideoAdOpened();
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* renamed from: com.ironsource.mediationsdk.n0.o$o  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0209o implements Runnable {
        RunnableC0209o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a.onRewardedVideoAdClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    public class p implements Runnable {
        final /* synthetic */ boolean a;

        p(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a.i(this.a);
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a.o();
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class r implements Runnable {
        r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a.d();
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class s implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.model.o a;

        s(com.ironsource.mediationsdk.model.o oVar) {
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a.p(this.a);
        }
    }

    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    class t implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.model.o a;

        t(com.ironsource.mediationsdk.model.o oVar) {
            this.a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a.t(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    public class u implements Runnable {
        final /* synthetic */ com.ironsource.mediationsdk.logger.b a;

        u(com.ironsource.mediationsdk.logger.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a.k(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListenersWrapper.java */
    /* loaded from: classes2.dex */
    public class v extends Thread {
        private Handler a;

        private v(o oVar) {
        }

        public Handler a() {
            return this.a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.a = new Handler();
            Looper.loop();
        }

        /* synthetic */ v(o oVar, k kVar) {
            this(oVar);
        }
    }

    public o() {
        v vVar = new v(this, null);
        this.f5641e = vVar;
        vVar.start();
        this.f5644h = new Date().getTime();
    }

    private void C(Runnable runnable) {
        Handler a2;
        v vVar = this.f5641e;
        if (vVar == null || (a2 = vVar.a()) == null) {
            return;
        }
        a2.post(runnable);
    }

    private boolean z(Object obj) {
        return (obj == null || this.f5641e == null) ? false : true;
    }

    public void A(com.ironsource.mediationsdk.logger.b bVar, Map<String, Object> map) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "onRewardedVideoAdShowFailed(" + bVar.toString() + ")", 1);
        JSONObject D = IronSourceUtils.D(false);
        try {
            D.put("errorCode", bVar.a());
            D.put("reason", bVar.b());
            if (!TextUtils.isEmpty(this.f5643g)) {
                D.put("placement", this.f5643g);
            }
            if (map != null) {
                for (String str : map.keySet()) {
                    D.put(str, map.get(str));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(1113, D));
        if (z(this.a)) {
            C(new u(bVar));
        }
    }

    public void B(boolean z, Map<String, Object> map) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        i2.d(ironSourceTag, "onRewardedVideoAvailabilityChanged(available:" + z + ")", 1);
        long time = new Date().getTime() - this.f5644h;
        this.f5644h = new Date().getTime();
        JSONObject D = IronSourceUtils.D(false);
        try {
            D.put(TypedValues.TransitionType.S_DURATION, time);
            if (map != null) {
                for (String str : map.keySet()) {
                    D.put(str, map.get(str));
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(z ? 1111 : 1112, D));
        if (z(this.a)) {
            C(new p(z));
        }
    }

    public void D(com.ironsource.mediationsdk.n0.l lVar) {
        this.b = lVar;
    }

    public void E(com.ironsource.mediationsdk.model.k kVar) {
        this.f5642f = kVar;
    }

    public void F(String str) {
        this.f5643g = str;
    }

    @Override // com.ironsource.mediationsdk.n0.l
    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        i2.d(ironSourceTag, "onInterstitialAdLoadFailed(" + bVar + ")", 1);
        if (z(this.b)) {
            C(new b(bVar));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.v
    public void b(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        i2.d(ironSourceTag, "onSegmentReceived(" + str + ")", 1);
        if (z(this.f5640d)) {
            C(new k(str));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.l
    public void c() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdReady()", 1);
        if (z(this.b)) {
            C(new a());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.s
    public void d() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdEnded()", 1);
        if (z(this.a)) {
            C(new r());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.l
    public void e(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        i2.d(ironSourceTag, "onInterstitialAdShowFailed(" + bVar + ")", 1);
        JSONObject D = IronSourceUtils.D(false);
        try {
            D.put("errorCode", bVar.a());
            com.ironsource.mediationsdk.model.k kVar = this.f5642f;
            if (kVar != null && !TextUtils.isEmpty(kVar.c())) {
                D.put("placement", this.f5642f.c());
            }
            if (bVar.b() != null) {
                D.put("reason", bVar.b());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        InterstitialEventsManager.getInstance().P(new d.e.b.b(2111, D));
        if (z(this.b)) {
            C(new e(bVar));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.l
    public void f() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClosed()", 1);
        if (z(this.b)) {
            C(new g());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.l
    public void g() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClicked()", 1);
        if (z(this.b)) {
            C(new f());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.l
    public void h() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdOpened()", 1);
        if (z(this.b)) {
            C(new c());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.s
    public void i(boolean z) {
        B(z, null);
    }

    @Override // com.ironsource.mediationsdk.n0.l
    public void j() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowSucceeded()", 1);
        if (z(this.b)) {
            C(new d());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.s
    public void k(com.ironsource.mediationsdk.logger.b bVar) {
        A(bVar, null);
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public void l() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallOpened()", 1);
        if (z(this.c)) {
            C(new h());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public void m(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        i2.d(ironSourceTag, "onGetOfferwallCreditsFailed(" + bVar + ")", 1);
        if (z(this.c)) {
            C(new j(bVar));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public void n(boolean z) {
        q(z, null);
    }

    @Override // com.ironsource.mediationsdk.n0.s
    public void o() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdStarted()", 1);
        if (z(this.a)) {
            C(new q());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.s
    public void onRewardedVideoAdClosed() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClosed()", 1);
        if (z(this.a)) {
            C(new RunnableC0209o());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.s
    public void onRewardedVideoAdOpened() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdOpened()", 1);
        if (z(this.a)) {
            C(new n());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.s
    public void p(com.ironsource.mediationsdk.model.o oVar) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        i2.d(ironSourceTag, "onRewardedVideoAdRewarded(" + oVar.toString() + ")", 1);
        if (z(this.a)) {
            C(new s(oVar));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.j
    public void q(boolean z, com.ironsource.mediationsdk.logger.b bVar) {
        String str = "onOfferwallAvailable(isAvailable: " + z + ")";
        if (bVar != null) {
            str = str + ", error: " + bVar.b();
        }
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
        JSONObject D = IronSourceUtils.D(false);
        try {
            D.put("status", String.valueOf(z));
            if (bVar != null) {
                D.put("errorCode", bVar.a());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(302, D));
        if (z(this.c)) {
            C(new m(z));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public void r(com.ironsource.mediationsdk.logger.b bVar) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        i2.d(ironSourceTag, "onOfferwallShowFailed(" + bVar + ")", 1);
        if (z(this.c)) {
            C(new i(bVar));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public void s() {
        com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallClosed()", 1);
        if (z(this.c)) {
            C(new l());
        }
    }

    @Override // com.ironsource.mediationsdk.n0.s
    public void t(com.ironsource.mediationsdk.model.o oVar) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        i2.d(ironSourceTag, "onRewardedVideoAdClicked(" + oVar.c() + ")", 1);
        if (z(this.a)) {
            C(new t(oVar));
        }
    }

    @Override // com.ironsource.mediationsdk.n0.q
    public boolean u(int i2, int i3, boolean z) {
        com.ironsource.mediationsdk.n0.q qVar = this.c;
        boolean u2 = qVar != null ? qVar.u(i2, i3, z) : false;
        com.ironsource.mediationsdk.logger.c i4 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        i4.d(ironSourceTag, "onOfferwallAdCredited(credits:" + i2 + ", totalCredits:" + i3 + ", totalCreditsFlag:" + z + "):" + u2, 1);
        return u2;
    }
}
