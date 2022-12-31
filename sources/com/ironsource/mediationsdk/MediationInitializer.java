package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.environment.CrashReporter;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class MediationInitializer implements com.ironsource.environment.i {
    private static MediationInitializer y;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f5437d;

    /* renamed from: e  reason: collision with root package name */
    private int f5438e;

    /* renamed from: f  reason: collision with root package name */
    private int f5439f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5440g;

    /* renamed from: i  reason: collision with root package name */
    private HandlerThread f5442i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f5443j;

    /* renamed from: l  reason: collision with root package name */
    private AtomicBoolean f5445l;
    private NetworkStateReceiver m;
    private CountDownTimer n;
    private String p;
    private String q;
    private com.ironsource.mediationsdk.utils.k r;
    private String t;
    private com.ironsource.mediationsdk.n0.v u;
    private boolean v;
    private long w;
    private final String a = getClass().getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    private boolean f5441h = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5444k = false;
    private List<com.ironsource.mediationsdk.utils.j> o = new ArrayList();
    private c x = new a();
    private EInitStatus s = EInitStatus.NOT_INIT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum EInitStatus {
        NOT_INIT,
        INIT_IN_PROGRESS,
        INIT_FAILED,
        INITIATED
    }

    /* loaded from: classes2.dex */
    class a extends c {
        a() {
            super(MediationInitializer.this);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ironsource.mediationsdk.model.t f2;
            try {
                IronSourceObject ironSourceObject = IronSourceObject.getInstance();
                TokenDataService.getInstance().d();
                MediationInitializer mediationInitializer = MediationInitializer.this;
                if (mediationInitializer.K(mediationInitializer.p).b()) {
                    MediationInitializer.this.t = "userGenerated";
                } else {
                    MediationInitializer.this.p = ironSourceObject.h(ContextProvider.getInstance().a());
                    if (!TextUtils.isEmpty(MediationInitializer.this.p)) {
                        MediationInitializer.this.t = "GAID";
                    } else {
                        MediationInitializer.this.p = com.ironsource.environment.e.I(ContextProvider.getInstance().a());
                        if (!TextUtils.isEmpty(MediationInitializer.this.p)) {
                            MediationInitializer.this.t = "UUID";
                        } else {
                            MediationInitializer.this.p = "";
                        }
                    }
                    ironSourceObject.Z(MediationInitializer.this.p, false);
                }
                com.ironsource.mediationsdk.n0.f.b().c("userIdType", MediationInitializer.this.t);
                if (!TextUtils.isEmpty(MediationInitializer.this.p)) {
                    com.ironsource.mediationsdk.n0.f.b().c(GuestProfileFragment.USER_ID, MediationInitializer.this.p);
                }
                if (!TextUtils.isEmpty(MediationInitializer.this.q)) {
                    com.ironsource.mediationsdk.n0.f.b().c("appKey", MediationInitializer.this.q);
                }
                MediationInitializer.this.w = new Date().getTime();
                MediationInitializer.this.r = ironSourceObject.A(ContextProvider.getInstance().a(), MediationInitializer.this.p, this.c);
                if (MediationInitializer.this.r != null) {
                    MediationInitializer.this.f5443j.removeCallbacks(this);
                    if (MediationInitializer.this.r.n()) {
                        MediationInitializer.this.H(EInitStatus.INITIATED);
                        MediationInitializer.this.E(ironSourceObject.K());
                        ironSourceObject.V(new Date().getTime() - MediationInitializer.this.w);
                        if (MediationInitializer.this.r.b().a().d() && ContextProvider.getInstance().b() != null) {
                            com.ironsource.mediationsdk.m0.a.i(ContextProvider.getInstance().b());
                        }
                        List<IronSource.AD_UNIT> d2 = MediationInitializer.this.r.d();
                        for (com.ironsource.mediationsdk.utils.j jVar : MediationInitializer.this.o) {
                            jVar.k(d2, MediationInitializer.this.L(), MediationInitializer.this.r.b());
                        }
                        if (MediationInitializer.this.u != null && (f2 = MediationInitializer.this.r.b().a().f()) != null && !TextUtils.isEmpty(f2.c())) {
                            MediationInitializer.this.u.b(f2.c());
                        }
                        com.ironsource.mediationsdk.model.c a = MediationInitializer.this.r.b().a().a();
                        if (a.g()) {
                            CrashReporter.getInstance().i(ContextProvider.getInstance().a(), a.c(), a.e(), a.d(), a.f(), IronSourceUtils.L(), a.b());
                            return;
                        }
                        return;
                    } else if (MediationInitializer.this.f5441h) {
                        return;
                    } else {
                        MediationInitializer.this.H(EInitStatus.INIT_FAILED);
                        MediationInitializer.this.f5441h = true;
                        for (com.ironsource.mediationsdk.utils.j jVar2 : MediationInitializer.this.o) {
                            jVar2.a("serverResponseIsNotValid");
                        }
                        return;
                    }
                }
                if (MediationInitializer.this.c == 3) {
                    MediationInitializer.this.v = true;
                    for (com.ironsource.mediationsdk.utils.j jVar3 : MediationInitializer.this.o) {
                        jVar3.l();
                    }
                }
                if (this.a && MediationInitializer.this.c < MediationInitializer.this.f5437d) {
                    MediationInitializer.this.f5440g = true;
                    MediationInitializer.this.f5443j.postDelayed(this, MediationInitializer.this.b * 1000);
                    if (MediationInitializer.this.c < MediationInitializer.this.f5438e) {
                        MediationInitializer.this.b *= 2;
                    }
                }
                if ((!this.a || MediationInitializer.this.c == MediationInitializer.this.f5439f) && !MediationInitializer.this.f5441h) {
                    MediationInitializer.this.f5441h = true;
                    if (TextUtils.isEmpty(this.b)) {
                        this.b = "noServerResponse";
                    }
                    for (com.ironsource.mediationsdk.utils.j jVar4 : MediationInitializer.this.o) {
                        jVar4.a(this.b);
                    }
                    MediationInitializer.this.H(EInitStatus.INIT_FAILED);
                    com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No server response", 1);
                }
                MediationInitializer.i(MediationInitializer.this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* loaded from: classes2.dex */
        class a extends CountDownTimer {
            a(long j2, long j3) {
                super(j2, j3);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (MediationInitializer.this.f5441h) {
                    return;
                }
                MediationInitializer.this.f5441h = true;
                for (com.ironsource.mediationsdk.utils.j jVar : MediationInitializer.this.o) {
                    jVar.a("noInternetConnection");
                }
                com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No internet connection", 1);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (j2 <= 45000) {
                    MediationInitializer.this.v = true;
                    for (com.ironsource.mediationsdk.utils.j jVar : MediationInitializer.this.o) {
                        jVar.l();
                    }
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MediationInitializer.this.n = new a(60000L, 15000L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public abstract class c implements Runnable {
        String b;
        boolean a = true;
        protected IronSourceObject.b c = new a();

        /* loaded from: classes2.dex */
        class a implements IronSourceObject.b {
            a() {
            }

            @Override // com.ironsource.mediationsdk.IronSourceObject.b
            public void a(String str) {
                c cVar = c.this;
                cVar.a = false;
                cVar.b = str;
            }
        }

        c(MediationInitializer mediationInitializer) {
        }
    }

    private MediationInitializer() {
        this.f5442i = null;
        HandlerThread handlerThread = new HandlerThread("IronSourceInitiatorHandler");
        this.f5442i = handlerThread;
        handlerThread.start();
        this.f5443j = new Handler(this.f5442i.getLooper());
        this.b = 1;
        this.c = 0;
        this.f5437d = 62;
        this.f5438e = 12;
        this.f5439f = 5;
        this.f5445l = new AtomicBoolean(true);
        this.f5440g = false;
        this.v = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void H(EInitStatus eInitStatus) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "setInitStatus(old status: " + this.s + ", new status: " + eInitStatus + ")", 0);
        this.s = eInitStatus;
    }

    private boolean J(String str, int i2, int i3) {
        return str != null && str.length() >= i2 && str.length() <= i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ironsource.mediationsdk.k0.b K(String str) {
        com.ironsource.mediationsdk.k0.b bVar = new com.ironsource.mediationsdk.k0.b();
        if (str != null) {
            if (!J(str, 1, 64)) {
                bVar.c(com.ironsource.mediationsdk.utils.f.d(GuestProfileFragment.USER_ID, str, null));
            }
        } else {
            bVar.c(com.ironsource.mediationsdk.utils.f.d(GuestProfileFragment.USER_ID, str, "it's missing"));
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L() {
        return this.f5440g;
    }

    public static synchronized MediationInitializer getInstance() {
        MediationInitializer mediationInitializer;
        synchronized (MediationInitializer.class) {
            if (y == null) {
                y = new MediationInitializer();
            }
            mediationInitializer = y;
        }
        return mediationInitializer;
    }

    static /* synthetic */ int i(MediationInitializer mediationInitializer) {
        int i2 = mediationInitializer.c;
        mediationInitializer.c = i2 + 1;
        return i2;
    }

    public void C(com.ironsource.mediationsdk.utils.j jVar) {
        if (jVar == null) {
            return;
        }
        this.o.add(jVar);
    }

    public synchronized EInitStatus D() {
        return this.s;
    }

    public void E(boolean z) {
        Map<String, String> a2;
        if (z && TextUtils.isEmpty(IronSourceObject.getInstance().x()) && (a2 = this.r.b().a().b().a()) != null && !a2.isEmpty()) {
            for (String str : a2.keySet()) {
                if (IronSourceUtils.c(str)) {
                    String str2 = a2.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        str = str2;
                    }
                    IronSourceObject.getInstance().a0(str);
                    return;
                }
            }
        }
    }

    public synchronized void F(Context context, String str, String str2, IronSource.AD_UNIT... ad_unitArr) {
        try {
            AtomicBoolean atomicBoolean = this.f5445l;
            if (atomicBoolean != null && atomicBoolean.compareAndSet(true, false)) {
                H(EInitStatus.INIT_IN_PROGRESS);
                this.p = str2;
                this.q = str;
                if (IronSourceUtils.S(context)) {
                    this.f5443j.post(this.x);
                } else {
                    this.f5444k = true;
                    if (this.m == null) {
                        this.m = new NetworkStateReceiver(context, this);
                    }
                    context.registerReceiver(this.m, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    new Handler(Looper.getMainLooper()).post(new b());
                }
            } else {
                com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                i2.d(ironSourceTag, this.a + ": Multiple calls to init are not allowed", 2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized boolean G() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        H(EInitStatus.INIT_FAILED);
    }

    @Override // com.ironsource.environment.i
    public void c(boolean z) {
        if (this.f5444k && z) {
            CountDownTimer countDownTimer = this.n;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f5444k = false;
            this.f5440g = true;
            this.f5443j.post(this.x);
        }
    }
}
