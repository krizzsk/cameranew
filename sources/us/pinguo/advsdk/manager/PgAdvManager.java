package us.pinguo.advsdk.manager;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import us.pinguo.advsdk.PgAdvConstants$Mode;
import us.pinguo.advsdk.a.n;
import us.pinguo.advsdk.a.o;
import us.pinguo.advsdk.a.s;
import us.pinguo.advsdk.a.u;
import us.pinguo.advsdk.statistic.StatisticNetWorkHelper;
import us.pinguo.advstrategy.PgAdvStrategyManager;
/* loaded from: classes3.dex */
public class PgAdvManager implements s {
    private static PgAdvManager o;
    private Application a;
    private PgAdvConstants$Mode b;
    private PgAdvConstants$Mode c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9050d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<u> f9051e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<s> f9052f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9053g;

    /* renamed from: h  reason: collision with root package name */
    private us.pinguo.advsdk.a.e f9054h;

    /* renamed from: i  reason: collision with root package name */
    private h f9055i;

    /* renamed from: j  reason: collision with root package name */
    private n f9056j;

    /* renamed from: k  reason: collision with root package name */
    private i f9057k;

    /* renamed from: l  reason: collision with root package name */
    private com.google.gson.e f9058l;
    private String m;
    private us.pinguo.advsdk.manager.a n;

    /* loaded from: classes3.dex */
    class a implements u {
        a() {
        }

        @Override // us.pinguo.advsdk.a.u
        public void a() {
            PgAdvManager.this.f9053g = false;
            PgAdvManager.this.d(false);
        }

        @Override // us.pinguo.advsdk.a.u
        public void b() {
            PgAdvManager.this.f9053g = true;
            PgAdvManager.this.d(true);
            PgAdvStrategyManager.getInstance().setVolleryInit(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i2 = 0; i2 < PgAdvManager.this.f9051e.size(); i2++) {
                if (this.a) {
                    ((u) PgAdvManager.this.f9051e.get(i2)).b();
                } else {
                    ((u) PgAdvManager.this.f9051e.get(i2)).a();
                }
            }
            PgAdvManager.this.f9051e.clear();
        }
    }

    private PgAdvManager() {
        PgAdvConstants$Mode pgAdvConstants$Mode = PgAdvConstants$Mode.MODE_RELEASE;
        this.b = pgAdvConstants$Mode;
        this.c = pgAdvConstants$Mode;
        this.f9050d = true;
        this.f9051e = new ArrayList<>();
        this.f9052f = new ArrayList<>();
        this.f9058l = new com.google.gson.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        ArrayList<u> arrayList = this.f9051e;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        try {
            new Handler(Looper.getMainLooper()).post(new b(z));
        } catch (Exception e2) {
            us.pinguo.advsdk.utils.b.a("looper failed:" + e2.getMessage());
        }
    }

    public static PgAdvManager getInstance() {
        if (o == null) {
            o = new PgAdvManager();
        }
        return o;
    }

    private void t(Application application) {
        this.a = application;
        q().e(new us.pinguo.advsdk.c.b(this.a, true));
        PgAdvStrategyManager.getInstance().init(application, this);
        StatisticNetWorkHelper.getInstance().d(application);
    }

    public void A(String str) {
        this.m = str;
    }

    public void B(String str) {
        us.pinguo.advsdk.network.g.k().y(str);
    }

    @Override // us.pinguo.advsdk.a.s
    public void a() {
        for (int i2 = 0; i2 < this.f9052f.size(); i2++) {
            this.f9052f.get(i2).a();
        }
        this.f9052f.clear();
    }

    @Override // us.pinguo.advsdk.a.s
    public void b(int i2, String str) {
    }

    public boolean c(Context context, String str) {
        if (new us.pinguo.advsdk.utils.f().a()) {
            return !PgAdvStrategyManager.getInstance().getStrategyKeeper(context).getGlobleOpenKey(str, "forceGdprClose");
        }
        return false;
    }

    public String h() {
        if (getInstance().j() != PgAdvConstants$Mode.MODE_RELEASE) {
            return "https://ad-dev.360in.com";
        }
        Boolean valueOf = Boolean.valueOf(Build.VERSION.SDK_INT >= 21);
        if (this.a == null) {
            return valueOf.booleanValue() ? "https://ad.360in.com" : "http://ad.360in.com";
        }
        String appHost = PgAdvStrategyManager.getInstance().getStrategyKeeper(this.a).getAppHost();
        return TextUtils.isEmpty(appHost) ? valueOf.booleanValue() ? "https://ad.360in.com" : "http://ad.360in.com" : appHost;
    }

    public synchronized us.pinguo.advsdk.a.e i() {
        if (this.f9054h == null) {
            this.f9054h = new e(this.a);
        }
        return this.f9054h;
    }

    public PgAdvConstants$Mode j() {
        return this.b;
    }

    public String k() {
        us.pinguo.advsdk.manager.a aVar = this.n;
        if (aVar != null) {
            return aVar.a();
        }
        return TextUtils.isEmpty(this.m) ? "unknown" : this.m;
    }

    public String l() {
        return getInstance().j() != PgAdvConstants$Mode.MODE_RELEASE ? "http://exp-dev.360in.com" : Build.VERSION.SDK_INT >= 21 ? "https://exp.360in.com" : "http://exp.360in.com";
    }

    public com.google.gson.e m() {
        return this.f9058l;
    }

    public us.pinguo.advsdk.a.i n() {
        if (this.f9057k == null) {
            this.f9057k = new i();
        }
        return this.f9057k;
    }

    public PgAdvConstants$Mode o() {
        return this.c;
    }

    public String p() {
        us.pinguo.advsdk.manager.a aVar = this.n;
        return aVar != null ? aVar.b() : "unknown";
    }

    public n q() {
        if (this.f9056j == null) {
            this.f9056j = new g();
        }
        return this.f9056j;
    }

    public synchronized o r() {
        if (this.f9055i == null) {
            this.f9055i = new h();
        }
        return this.f9055i;
    }

    public void s(Application application, long j2, us.pinguo.advsdk.a.i iVar, o oVar) {
        t(application);
        i().n(j2);
        n().c(iVar);
        r().g(oVar);
    }

    public int u(Application application, String str, String str2, String str3) {
        t(application);
        us.pinguo.advsdk.network.g.k().b(this.a, str, str2, str3, new a());
        return 0;
    }

    public boolean v() {
        return this.f9050d;
    }

    public boolean w(String str) {
        return (str.startsWith(h()) || str.startsWith(l()) || str.startsWith("https://ad-dev.360in.com") || str.startsWith("https://ad.360in.com") || str.startsWith("http://ad.360in.com") || str.startsWith("http://exp-dev.360in.com") || str.startsWith("https://exp.360in.com") || str.startsWith("http://exp.360in.com")) ? false : true;
    }

    public void x(us.pinguo.advsdk.manager.a aVar) {
        this.n = aVar;
    }

    public void y(boolean z) {
        this.f9050d = z;
    }

    public void z(PgAdvConstants$Mode pgAdvConstants$Mode) {
        this.b = pgAdvConstants$Mode;
    }
}
