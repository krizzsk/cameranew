package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.AdError;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ContextProvider;
import com.ironsource.mediationsdk.utils.GeneralPropertiesWorker;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.publish.InspirePublishFragment;
/* loaded from: classes2.dex */
public class IronSourceObject implements com.ironsource.mediationsdk.utils.j {
    private static boolean e0 = false;
    private boolean A;
    private v B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private Boolean H;
    private IronSourceBannerLayout I;
    private String J;
    private Boolean K;
    private p L;
    private ProgIsManager M;
    private ProgBannerManager N;
    private com.ironsource.mediationsdk.adunit.manager.d O;
    private com.ironsource.mediationsdk.n0.i P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private int V;
    private CopyOnWriteArraySet<String> W;
    private CopyOnWriteArraySet<String> X;
    private j Y;
    private l Z;
    private final String a;
    private com.ironsource.mediationsdk.b b;
    private d0 c;

    /* renamed from: d  reason: collision with root package name */
    private t f5413d;
    private com.ironsource.mediationsdk.l0.a d0;

    /* renamed from: e  reason: collision with root package name */
    private y f5414e;

    /* renamed from: f  reason: collision with root package name */
    private BannerManager f5415f;

    /* renamed from: g  reason: collision with root package name */
    private com.ironsource.mediationsdk.logger.c f5416g;

    /* renamed from: h  reason: collision with root package name */
    private com.ironsource.mediationsdk.n0.o f5417h;

    /* renamed from: i  reason: collision with root package name */
    private com.ironsource.mediationsdk.logger.e f5418i;

    /* renamed from: j  reason: collision with root package name */
    private AtomicBoolean f5419j;

    /* renamed from: k  reason: collision with root package name */
    private final Object f5420k;

    /* renamed from: l  reason: collision with root package name */
    private com.ironsource.mediationsdk.utils.k f5421l;
    private String m;
    private String n;
    private String o;
    private String p;
    private Map<String, String> q;
    private String r;
    private AtomicBoolean s;
    private boolean t;
    private List<IronSource.AD_UNIT> u;
    private String v;
    private Context w;
    private Boolean x;
    private Set<IronSource.AD_UNIT> y;
    private Set<IronSource.AD_UNIT> z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[CappingManager.ECappingStatus.values().length];
            b = iArr;
            try {
                iArr[CappingManager.ECappingStatus.CAPPED_PER_DELIVERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[CappingManager.ECappingStatus.CAPPED_PER_COUNT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[CappingManager.ECappingStatus.CAPPED_PER_PACE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[CappingManager.ECappingStatus.NOT_CAPPED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[IronSource.AD_UNIT.values().length];
            a = iArr2;
            try {
                iArr2[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[IronSource.AD_UNIT.OFFERWALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[IronSource.AD_UNIT.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        static volatile IronSourceObject a = new IronSourceObject(null);
    }

    /* synthetic */ IronSourceObject(a aVar) {
        this();
    }

    private void C() {
        if (this.H.booleanValue()) {
            this.H = Boolean.FALSE;
            P(this.I, this.J);
            this.I = null;
            this.J = null;
        }
    }

    private void E(com.ironsource.mediationsdk.utils.k kVar, Context context) {
        boolean j2 = O() ? kVar.b().e().k().j() : false;
        boolean j3 = L() ? kVar.b().c().i().j() : false;
        boolean j4 = J() ? kVar.b().b().e().j() : false;
        boolean j5 = N() ? kVar.b().d().c().j() : false;
        if (j2) {
            com.ironsource.mediationsdk.model.d k2 = kVar.b().e().k();
            RewardedVideoEventsManager.getInstance().Z(k2.b(), context);
            RewardedVideoEventsManager.getInstance().Y(k2.c(), context);
            RewardedVideoEventsManager.getInstance().d0(k2.e());
            RewardedVideoEventsManager.getInstance().c0(k2.d());
            RewardedVideoEventsManager.getInstance().T(k2.a());
            RewardedVideoEventsManager.getInstance().g0(k2.h(), context);
            RewardedVideoEventsManager.getInstance().f0(k2.g(), context);
            RewardedVideoEventsManager.getInstance().i0(k2.i(), context);
            RewardedVideoEventsManager.getInstance().e0(k2.f(), context);
            RewardedVideoEventsManager.getInstance().h0(kVar.b().a().f());
        } else if (j5) {
            com.ironsource.mediationsdk.model.d c2 = kVar.b().d().c();
            RewardedVideoEventsManager.getInstance().Z(c2.b(), context);
            RewardedVideoEventsManager.getInstance().Y(c2.c(), context);
            RewardedVideoEventsManager.getInstance().d0(c2.e());
            RewardedVideoEventsManager.getInstance().c0(c2.d());
            RewardedVideoEventsManager.getInstance().T(c2.a());
            RewardedVideoEventsManager.getInstance().g0(c2.h(), context);
            RewardedVideoEventsManager.getInstance().f0(c2.g(), context);
            RewardedVideoEventsManager.getInstance().i0(c2.i(), context);
            RewardedVideoEventsManager.getInstance().e0(c2.f(), context);
            RewardedVideoEventsManager.getInstance().h0(kVar.b().a().f());
        } else {
            RewardedVideoEventsManager.getInstance().b0(false);
        }
        if (j3) {
            com.ironsource.mediationsdk.model.d i2 = kVar.b().c().i();
            InterstitialEventsManager.getInstance().Z(i2.b(), context);
            InterstitialEventsManager.getInstance().Y(i2.c(), context);
            InterstitialEventsManager.getInstance().d0(i2.e());
            InterstitialEventsManager.getInstance().c0(i2.d());
            InterstitialEventsManager.getInstance().T(i2.a());
            InterstitialEventsManager.getInstance().g0(i2.h(), context);
            InterstitialEventsManager.getInstance().f0(i2.g(), context);
            InterstitialEventsManager.getInstance().i0(i2.i(), context);
            InterstitialEventsManager.getInstance().e0(i2.f(), context);
            InterstitialEventsManager.getInstance().h0(kVar.b().a().f());
        } else if (j4) {
            com.ironsource.mediationsdk.model.d e2 = kVar.b().b().e();
            InterstitialEventsManager.getInstance().Z(e2.b(), context);
            InterstitialEventsManager.getInstance().Y(e2.c(), context);
            InterstitialEventsManager.getInstance().d0(e2.e());
            InterstitialEventsManager.getInstance().c0(e2.d());
            InterstitialEventsManager.getInstance().T(e2.a());
            InterstitialEventsManager.getInstance().g0(e2.h(), context);
            InterstitialEventsManager.getInstance().f0(e2.g(), context);
            InterstitialEventsManager.getInstance().i0(e2.i(), context);
            InterstitialEventsManager.getInstance().e0(e2.f(), context);
            InterstitialEventsManager.getInstance().h0(kVar.b().a().f());
        } else {
            InterstitialEventsManager.getInstance().b0(false);
        }
    }

    private void F(com.ironsource.mediationsdk.utils.k kVar) {
        this.f5418i.f(kVar.b().a().e().b());
        this.f5416g.l("console", kVar.b().a().e().a());
    }

    private void G() {
        com.ironsource.mediationsdk.logger.c j2 = com.ironsource.mediationsdk.logger.c.j(0);
        this.f5416g = j2;
        com.ironsource.mediationsdk.logger.e eVar = new com.ironsource.mediationsdk.logger.e(null, 1);
        this.f5418i = eVar;
        j2.g(eVar);
        this.f5417h = new com.ironsource.mediationsdk.n0.o();
        d0 d0Var = new d0();
        this.c = d0Var;
        d0Var.e0(this.f5417h);
        t tVar = new t();
        this.f5413d = tVar;
        tVar.a0(this.f5417h);
        y yVar = new y();
        this.f5414e = yVar;
        yVar.e(this.f5417h);
    }

    private void H(com.ironsource.mediationsdk.utils.k kVar, Context context) {
        F(kVar);
        E(kVar, context);
    }

    private boolean J() {
        com.ironsource.mediationsdk.utils.k kVar = this.f5421l;
        return (kVar == null || kVar.b() == null || this.f5421l.b().b() == null) ? false : true;
    }

    private boolean L() {
        com.ironsource.mediationsdk.utils.k kVar = this.f5421l;
        return (kVar == null || kVar.b() == null || this.f5421l.b().c() == null) ? false : true;
    }

    private boolean N() {
        com.ironsource.mediationsdk.utils.k kVar = this.f5421l;
        return (kVar == null || kVar.b() == null || this.f5421l.b().d() == null) ? false : true;
    }

    private boolean O() {
        com.ironsource.mediationsdk.utils.k kVar = this.f5421l;
        return (kVar == null || kVar.b() == null || this.f5421l.b().e() == null) ? false : true;
    }

    private void R(IronSource.AD_UNIT ad_unit, boolean z) {
        int i2 = a.a[ad_unit.ordinal()];
        if (i2 == 1) {
            if (this.D) {
                Iterator<String> it = this.X.iterator();
                while (it.hasNext()) {
                    RVDemandOnlyListenerWrapper.getInstance().f(it.next(), com.ironsource.mediationsdk.utils.f.c("initISDemandOnly() had failed", "Rewarded Video"));
                }
                this.X.clear();
            } else if (z || O() || this.z.contains(ad_unit)) {
                this.f5417h.i(false);
            }
        } else if (i2 == 2) {
            if (this.E) {
                Iterator<String> it2 = this.W.iterator();
                while (it2.hasNext()) {
                    ISDemandOnlyListenerWrapper.getInstance().f(it2.next(), com.ironsource.mediationsdk.utils.f.c("initISDemandOnly() had failed", "Interstitial"));
                }
                this.W.clear();
            } else if (this.T) {
                this.T = false;
                CallbackThrottler.getInstance().f(com.ironsource.mediationsdk.utils.f.c("init() had failed", "Interstitial"));
            }
        } else if (i2 == 3) {
            if (z || N() || this.z.contains(ad_unit)) {
                this.f5417h.n(false);
            }
        } else if (i2 != 4) {
        } else {
            synchronized (this.H) {
                if (this.H.booleanValue()) {
                    this.H = Boolean.FALSE;
                    BannerCallbackThrottler.getInstance().d(this.I, new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, "Init had failed"));
                    this.I = null;
                    this.J = null;
                }
            }
        }
    }

    private void S(Context context) {
        AtomicBoolean atomicBoolean = this.f5419j;
        if (atomicBoolean == null || !atomicBoolean.compareAndSet(false, true)) {
            return;
        }
        com.ironsource.mediationsdk.events.f.a().b(new GeneralPropertiesWorker(context));
        InterstitialEventsManager.getInstance().q0(context, this.B);
        RewardedVideoEventsManager.getInstance().q0(context, this.B);
    }

    private void T(IronSource.AD_UNIT ad_unit) {
        String str = ad_unit + " ad unit has already been initialized";
        this.f5416g.d(IronSourceLogger.IronSourceTag.API, str, 3);
        IronSourceUtils.j0(str);
    }

    private void U() {
        if (e0) {
            return;
        }
        e0 = true;
        JSONObject D = IronSourceUtils.D(false);
        try {
            D.put("status", "false");
            D.put("errorCode", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(114, D));
    }

    private void W(int i2, JSONObject jSONObject) {
        InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, jSONObject));
    }

    private void X(int i2, JSONObject jSONObject) {
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(i2, jSONObject));
    }

    private void c(JSONObject jSONObject, Object[][] objArr) {
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObject.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "IronSourceObject addToDictionary: " + Log.getStackTraceString(e2), 3);
            }
        }
    }

    private void c0(String str) {
        String str2 = null;
        try {
            com.ironsource.mediationsdk.model.k s = s(str);
            if (s == null) {
                s = p();
            }
            if (s != null) {
                str2 = s.c();
            }
        } catch (Exception e2) {
            this.f5416g.e(IronSourceLogger.IronSourceTag.API, "showProgrammaticInterstitial()", e2);
        }
        if (this.S) {
            this.O.M(str2);
        } else {
            this.M.A0(str2);
        }
    }

    private synchronized void d(boolean z, IronSource.AD_UNIT... ad_unitArr) {
        int i2 = 0;
        for (IronSource.AD_UNIT ad_unit : ad_unitArr) {
            if (ad_unit.equals(IronSource.AD_UNIT.INTERSTITIAL)) {
                this.F = true;
            } else if (ad_unit.equals(IronSource.AD_UNIT.BANNER)) {
                this.G = true;
            } else {
                ad_unit.equals(IronSource.AD_UNIT.REWARDED_VIDEO);
            }
        }
        if (MediationInitializer.getInstance().D() == MediationInitializer.EInitStatus.INIT_FAILED) {
            try {
                if (this.f5417h != null) {
                    int length = ad_unitArr.length;
                    while (i2 < length) {
                        IronSource.AD_UNIT ad_unit2 = ad_unitArr[i2];
                        if (!this.y.contains(ad_unit2)) {
                            R(ad_unit2, true);
                        }
                        i2++;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return;
        } else if (!this.t) {
            JSONObject D = IronSourceUtils.D(z);
            int length2 = ad_unitArr.length;
            boolean z2 = false;
            while (i2 < length2) {
                IronSource.AD_UNIT ad_unit3 = ad_unitArr[i2];
                if (!this.y.contains(ad_unit3)) {
                    this.y.add(ad_unit3);
                    this.z.add(ad_unit3);
                    try {
                        D.put(ad_unit3.toString(), true);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    z2 = true;
                } else {
                    this.f5416g.d(IronSourceLogger.IronSourceTag.API, ad_unit3 + " ad unit has started initializing.", 3);
                }
                i2++;
            }
            if (z2) {
                try {
                    StringBuilder sb = new StringBuilder();
                    String str = ",androidx=" + IronSourceUtils.Q();
                    String str2 = ",Activity=" + I();
                    if (com.ironsource.mediationsdk.utils.i.a()) {
                        sb.append("appLanguage=Kotlin");
                        sb.append(com.ironsource.mediationsdk.utils.i.b());
                    } else {
                        sb.append("appLanguage=Java");
                    }
                    sb.append(str);
                    if (K()) {
                        sb.append(str2);
                    }
                    D.put("ext1", sb.toString());
                    int i3 = this.C + 1;
                    this.C = i3;
                    D.put("sessionDepth", i3);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                RewardedVideoEventsManager.getInstance().P(new d.e.b.b(14, D));
            }
            return;
        } else {
            MediationInitializer.getInstance().E(z);
            if (this.u == null) {
                return;
            }
            JSONObject D2 = IronSourceUtils.D(z);
            boolean z3 = false;
            for (IronSource.AD_UNIT ad_unit4 : ad_unitArr) {
                if (!this.y.contains(ad_unit4)) {
                    this.y.add(ad_unit4);
                    this.z.add(ad_unit4);
                    try {
                        D2.put(ad_unit4.toString(), true);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    List<IronSource.AD_UNIT> list = this.u;
                    if (list != null && list.contains(ad_unit4)) {
                        d0(ad_unit4);
                    } else {
                        R(ad_unit4, false);
                    }
                    z3 = true;
                } else {
                    T(ad_unit4);
                }
            }
            if (z3) {
                try {
                    StringBuilder sb2 = new StringBuilder();
                    String str3 = ",androidx=" + IronSourceUtils.Q();
                    String str4 = ",Activity=" + I();
                    if (com.ironsource.mediationsdk.utils.i.a()) {
                        sb2.append("appLanguage=Kotlin");
                        sb2.append(com.ironsource.mediationsdk.utils.i.b());
                    } else {
                        sb2.append("appLanguage=Java");
                    }
                    sb2.append(str3);
                    if (K()) {
                        sb2.append(str4);
                    }
                    D2.put("ext1", sb2.toString());
                    int i4 = this.C + 1;
                    this.C = i4;
                    D2.put("sessionDepth", i4);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                RewardedVideoEventsManager.getInstance().P(new d.e.b.b(14, D2));
            }
            return;
        }
    }

    private void d0(IronSource.AD_UNIT ad_unit) {
        int i2 = a.a[ad_unit.ordinal()];
        if (i2 == 1) {
            m0();
        } else if (i2 == 2) {
            h0();
        } else if (i2 == 3) {
            this.f5414e.b(u(), v());
        } else if (i2 != 4) {
        } else {
            e0();
        }
    }

    private void e() {
        Context a2 = ContextProvider.getInstance().a();
        boolean R = IronSourceUtils.R(a2);
        long x = IronSourceUtils.x(a2);
        if (R || x != -1) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("get first session timestamp = " + currentTimeMillis);
        IronSourceUtils.d0(a2, currentTimeMillis);
    }

    private void e0() {
        com.ironsource.mediationsdk.model.l d2;
        synchronized (this.H) {
            this.U = this.f5421l.b().b().c().g();
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("mIsBnProgrammatic = " + this.U);
            ironLog.verbose("mIsBnLoadBeforeInitCompleted = " + this.H);
            W(83000, IronSourceUtils.E(false, this.U, 1));
            ArrayList<com.ironsource.mediationsdk.model.l> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < this.f5421l.h().d().size(); i2++) {
                String str = this.f5421l.h().d().get(i2);
                if (!TextUtils.isEmpty(str) && (d2 = this.f5421l.i().d(str)) != null) {
                    arrayList.add(d2);
                }
            }
            if (arrayList.size() > 0) {
                if (this.U) {
                    j0(arrayList);
                } else {
                    this.f5415f = new BannerManager(arrayList, u(), IronSourceUtils.P(), this.f5421l.b().b().b(), this.f5421l.b().b().g(), this.f5421l.b().b().d());
                    C();
                }
            } else {
                JSONObject E = IronSourceUtils.E(false, this.U, 1);
                c(E, new Object[][]{new Object[]{"errorCode", 1010}});
                W(83314, E);
                R(IronSource.AD_UNIT.BANNER, false);
            }
        }
    }

    private com.ironsource.mediationsdk.utils.k f(Context context, String str, b bVar) {
        com.ironsource.mediationsdk.utils.k kVar = null;
        if (!IronSourceUtils.S(context)) {
            return null;
        }
        try {
            String h2 = h(context);
            if (TextUtils.isEmpty(h2)) {
                h2 = com.ironsource.environment.e.I(context);
                com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String str2 = h2;
            v vVar = this.B;
            if (vVar == null) {
                String a2 = com.ironsource.mediationsdk.o0.a.a(com.ironsource.mediationsdk.o0.b.c(context, u(), str, str2, x(), null), bVar);
                if (a2 == null) {
                    IronLog.INTERNAL.warning("serverResponseString is null");
                    return null;
                }
                if (IronSourceUtils.K() == 1) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("encrypt");
                    String optString = new JSONObject(a2).optString("response", null);
                    if (TextUtils.isEmpty(optString)) {
                        ironLog.warning("encryptedResponse is empty - return null");
                        return null;
                    }
                    a2 = com.ironsource.mediationsdk.utils.g.b("C38FB23A402222A0C17D34A92F971D1F", optString);
                    if (TextUtils.isEmpty(a2)) {
                        ironLog.warning("encoded response invalid - return null");
                        U();
                        return null;
                    }
                }
                com.ironsource.mediationsdk.utils.k kVar2 = new com.ironsource.mediationsdk.utils.k(context, u(), str, a2);
                try {
                    if (kVar2.n()) {
                        return kVar2;
                    }
                    IronLog.INTERNAL.warning("response invalid - return null");
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    kVar = kVar2;
                    IronLog ironLog2 = IronLog.INTERNAL;
                    ironLog2.warning("exception = " + e);
                    e.printStackTrace();
                    return kVar;
                }
            }
            vVar.b();
            throw null;
        } catch (Exception e3) {
            e = e3;
        }
    }

    private void f0() {
        this.f5416g.d(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f5421l.h().e().size(); i2++) {
            String str = this.f5421l.h().e().get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.f5421l.i().d(str));
            }
        }
        if (arrayList.size() > 0) {
            synchronized (this.W) {
                this.Y = new j(arrayList, this.f5421l.b().c(), u(), v());
            }
            Iterator<String> it = this.W.iterator();
            while (it.hasNext()) {
                this.Y.h(it.next(), null, false);
            }
            this.W.clear();
            return;
        }
        JSONObject E = IronSourceUtils.E(false, false, 1);
        c(E, new Object[][]{new Object[]{"errorCode", 1010}});
        W(82314, E);
        R(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private List<com.ironsource.mediationsdk.model.l> g() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f5421l.h().e().size(); i2++) {
            String str = this.f5421l.h().e().get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.f5421l.i().d(str));
            }
        }
        return arrayList;
    }

    private void g0() {
        this.f5416g.d(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in demand only mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f5421l.h().h().size(); i2++) {
            String str = this.f5421l.h().h().get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.f5421l.i().d(str));
            }
        }
        if (arrayList.size() > 0) {
            synchronized (this.X) {
                this.Z = new l(arrayList, this.f5421l.b().e(), u(), v());
            }
            if (ContextProvider.getInstance().b() == null) {
                R(IronSource.AD_UNIT.REWARDED_VIDEO, false);
                return;
            }
            Iterator<String> it = this.X.iterator();
            while (it.hasNext()) {
                this.Z.i(it.next(), null, false);
            }
            this.X.clear();
            return;
        }
        R(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    public static IronSourceObject getInstance() {
        return c.a;
    }

    private void h0() {
        if (this.E) {
            f0();
            return;
        }
        com.ironsource.mediationsdk.model.j c2 = this.f5421l.b().c();
        this.R = c2.h().g();
        this.S = c2.h().j();
        W(82000, IronSourceUtils.E(false, this.R, 1));
        if (this.R) {
            if (this.S) {
                i0();
                return;
            } else {
                k0();
                return;
            }
        }
        n0();
    }

    private com.ironsource.mediationsdk.model.h i(String str) {
        com.ironsource.mediationsdk.model.g b2 = this.f5421l.b().b();
        if (b2 == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return b2.h();
        }
        com.ironsource.mediationsdk.model.h f2 = b2.f(str);
        return f2 != null ? f2 : b2.h();
    }

    private void i0() {
        List<com.ironsource.mediationsdk.model.l> g2 = g();
        if (g2.size() > 0) {
            com.ironsource.mediationsdk.adunit.manager.d dVar = new com.ironsource.mediationsdk.adunit.manager.d(g2, this.f5421l.b().c(), u(), IronSourceUtils.P(), this.f5421l.b().c().d(), IronsourceObjectPublisherDataHolder.getInstance().a());
            this.O = dVar;
            Boolean bool = this.x;
            if (bool != null) {
                dVar.L(bool.booleanValue());
            }
            if (this.T) {
                this.T = false;
                this.O.C();
                return;
            }
            return;
        }
        JSONObject E = IronSourceUtils.E(false, true, 1);
        c(E, new Object[][]{new Object[]{"errorCode", 1010}});
        W(82314, E);
        R(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private com.ironsource.mediationsdk.utils.k j(Context context, String str) {
        if (IronSourceUtils.R(context)) {
            String g2 = IronSourceUtils.g(context, "appKey");
            String g3 = IronSourceUtils.g(context, GuestProfileFragment.USER_ID);
            String g4 = IronSourceUtils.g(context, "response");
            if (u() != null && g2.equals(u()) && g3.equals(str)) {
                com.ironsource.mediationsdk.utils.k kVar = new com.ironsource.mediationsdk.utils.k(context, g2, g3, g4);
                com.ironsource.mediationsdk.logger.b j2 = com.ironsource.mediationsdk.utils.f.j(g2, g3);
                com.ironsource.mediationsdk.logger.c cVar = this.f5416g;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                cVar.d(ironSourceTag, j2.toString(), 1);
                com.ironsource.mediationsdk.logger.c cVar2 = this.f5416g;
                cVar2.d(ironSourceTag, j2.toString() + ": " + kVar.toString(), 1);
                RewardedVideoEventsManager.getInstance().P(new d.e.b.b(InspirePublishFragment.MAX_DESC_COUNT, IronSourceUtils.D(false)));
                return kVar;
            }
        }
        return null;
    }

    private void j0(ArrayList<com.ironsource.mediationsdk.model.l> arrayList) {
        this.f5416g.d(IronSourceLogger.IronSourceTag.INTERNAL, "Banner started in programmatic mode", 0);
        this.N = new ProgBannerManager(arrayList, new g(u(), IronSourceUtils.P(), this.f5421l.b().b()), IronsourceObjectPublisherDataHolder.getInstance().a());
        C();
    }

    private void k0() {
        this.f5416g.d(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in programmatic mode", 0);
        List<com.ironsource.mediationsdk.model.l> g2 = g();
        if (g2.size() > 0) {
            ProgIsManager progIsManager = new ProgIsManager(g2, this.f5421l.b().c(), u(), IronSourceUtils.P(), this.f5421l.b().c().d(), IronsourceObjectPublisherDataHolder.getInstance().a());
            this.M = progIsManager;
            Boolean bool = this.x;
            if (bool != null) {
                progIsManager.L(this.w, bool.booleanValue());
                if (this.x.booleanValue()) {
                    this.f5413d.b0(this.w, false);
                }
            }
            if (this.T) {
                this.T = false;
                this.M.g0();
                return;
            }
            return;
        }
        JSONObject E = IronSourceUtils.E(false, true, 1);
        c(E, new Object[][]{new Object[]{"errorCode", 1010}});
        W(82314, E);
        R(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private void l0() {
        this.f5416g.d(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in programmatic mode", 0);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f5421l.h().h().size(); i2++) {
            String str = this.f5421l.h().h().get(i2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(this.f5421l.i().d(str));
            }
        }
        if (arrayList.size() > 0) {
            if (this.f5421l.b().e().j().f()) {
                this.L = new LWSProgRvManager(arrayList, this.f5421l.b().e(), u(), IronSourceUtils.P(), IronsourceObjectPublisherDataHolder.getInstance().a());
            } else {
                this.L = new ProgRvManager(arrayList, this.f5421l.b().e(), u(), IronSourceUtils.P(), IronsourceObjectPublisherDataHolder.getInstance().a());
            }
            Boolean bool = this.x;
            if (bool != null) {
                this.L.L(this.w, bool.booleanValue());
                if (this.x.booleanValue()) {
                    this.c.h0(this.w, false);
                    return;
                }
                return;
            }
            return;
        }
        JSONObject E = IronSourceUtils.E(false, true, this.V);
        c(E, new Object[][]{new Object[]{"errorCode", 1010}});
        X(81314, E);
        R(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private void m0() {
        com.ironsource.mediationsdk.model.l d2;
        com.ironsource.mediationsdk.model.l d3;
        com.ironsource.mediationsdk.model.l d4;
        if (this.D) {
            g0();
            return;
        }
        this.Q = this.f5421l.b().e().j().g();
        int i2 = this.f5421l.b().e().j().f() ? 2 : 1;
        this.V = i2;
        X(81000, IronSourceUtils.E(false, this.Q, i2));
        if (this.Q) {
            l0();
            return;
        }
        int h2 = this.f5421l.b().e().h();
        for (int i3 = 0; i3 < this.f5421l.h().h().size(); i3++) {
            String str = this.f5421l.h().h().get(i3);
            if (!TextUtils.isEmpty(str) && (d4 = this.f5421l.i().d(str)) != null) {
                e0 e0Var = new e0(d4, h2);
                if (r0(e0Var)) {
                    e0Var.d0(this.c);
                    e0Var.R(i3 + 1);
                    this.c.y(e0Var);
                }
            }
        }
        if (this.c.c.size() > 0) {
            this.c.c0(this.f5421l.b().e().k().k());
            this.c.G(this.f5421l.b().e().g());
            this.c.d0(this.f5421l.b().e().e());
            String j2 = this.f5421l.j();
            if (!TextUtils.isEmpty(j2) && (d3 = this.f5421l.i().d(j2)) != null) {
                e0 e0Var2 = new e0(d3, h2);
                if (r0(e0Var2)) {
                    e0Var2.d0(this.c);
                    this.c.D(e0Var2);
                }
            }
            String k2 = this.f5421l.k();
            if (!TextUtils.isEmpty(k2) && (d2 = this.f5421l.i().d(k2)) != null) {
                e0 e0Var3 = new e0(d2, h2);
                if (r0(e0Var3)) {
                    e0Var3.d0(this.c);
                    this.c.F(e0Var3);
                }
            }
            this.c.b0(this.f5421l.b().e().d());
            this.c.M(u(), IronSourceUtils.P());
            return;
        }
        JSONObject E = IronSourceUtils.E(false, false, this.V);
        c(E, new Object[][]{new Object[]{"errorCode", 1010}});
        X(81314, E);
        R(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    private void n0() {
        com.ironsource.mediationsdk.model.l d2;
        com.ironsource.mediationsdk.model.j c2 = this.f5421l.b().c();
        int f2 = c2.f();
        this.f5413d.Z(c2.d());
        for (int i2 = 0; i2 < this.f5421l.h().e().size(); i2++) {
            String str = this.f5421l.h().e().get(i2);
            if (!TextUtils.isEmpty(str) && (d2 = this.f5421l.i().d(str)) != null) {
                u uVar = new u(d2, f2);
                if (r0(uVar)) {
                    uVar.Z(this.f5413d);
                    uVar.R(i2 + 1);
                    this.f5413d.y(uVar);
                }
            }
        }
        if (this.f5413d.c.size() > 0) {
            this.f5413d.G(c2.e());
            this.f5413d.K(u(), IronSourceUtils.P());
            if (this.T) {
                this.T = false;
                this.f5413d.O();
                return;
            }
            return;
        }
        JSONObject E = IronSourceUtils.E(false, false, 1);
        c(E, new Object[][]{new Object[]{"errorCode", 1010}});
        W(82314, E);
        R(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private boolean o0(String str) {
        if (str == null) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]*$");
    }

    private com.ironsource.mediationsdk.model.k p() {
        com.ironsource.mediationsdk.model.j c2 = this.f5421l.b().c();
        if (c2 != null) {
            return c2.c();
        }
        return null;
    }

    private com.ironsource.mediationsdk.k0.b p0(String str) {
        com.ironsource.mediationsdk.k0.b bVar = new com.ironsource.mediationsdk.k0.b();
        if (str != null) {
            if (q0(str, 5, 10)) {
                if (!o0(str)) {
                    bVar.c(com.ironsource.mediationsdk.utils.f.d("appKey", str, "should contain only english characters and numbers"));
                }
            } else {
                bVar.c(com.ironsource.mediationsdk.utils.f.d("appKey", str, "length should be between 5-10 characters"));
            }
        } else {
            bVar.c(new com.ironsource.mediationsdk.logger.b(TypedValues.PositionType.TYPE_PERCENT_X, "Init Fail - appKey is missing"));
        }
        return bVar;
    }

    private boolean q0(String str, int i2, int i3) {
        return str != null && str.length() >= i2 && str.length() <= i3;
    }

    private CappingManager.ECappingStatus r(String str) {
        com.ironsource.mediationsdk.utils.k kVar = this.f5421l;
        if (kVar != null && kVar.b() != null && this.f5421l.b().c() != null) {
            com.ironsource.mediationsdk.model.k kVar2 = null;
            try {
                kVar2 = s(str);
                if (kVar2 == null && (kVar2 = p()) == null) {
                    this.f5416g.d(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (kVar2 == null) {
                return CappingManager.ECappingStatus.NOT_CAPPED;
            }
            return CappingManager.o(ContextProvider.getInstance().a(), kVar2);
        }
        return CappingManager.ECappingStatus.NOT_CAPPED;
    }

    private boolean r0(AbstractSmash abstractSmash) {
        return abstractSmash.B() >= 1 && abstractSmash.C() >= 1;
    }

    private com.ironsource.mediationsdk.model.k s(String str) {
        com.ironsource.mediationsdk.model.j c2 = this.f5421l.b().c();
        if (c2 != null) {
            return c2.j(str);
        }
        return null;
    }

    private com.ironsource.mediationsdk.model.k t(String str) {
        com.ironsource.mediationsdk.model.k s = s(str);
        if (s == null) {
            com.ironsource.mediationsdk.logger.c cVar = this.f5416g;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            cVar.d(ironSourceTag, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            s = p();
            if (s == null) {
                this.f5416g.d(ironSourceTag, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        String m = m(s.c(), r(s.c()));
        if (TextUtils.isEmpty(m)) {
            return s;
        }
        this.f5416g.d(IronSourceLogger.IronSourceTag.API, m, 1);
        this.f5417h.E(s);
        this.f5417h.e(com.ironsource.mediationsdk.utils.f.a(m));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.ironsource.mediationsdk.utils.k A(Context context, String str, b bVar) {
        synchronized (this.f5420k) {
            com.ironsource.mediationsdk.utils.k kVar = this.f5421l;
            if (kVar != null) {
                return new com.ironsource.mediationsdk.utils.k(kVar);
            }
            com.ironsource.mediationsdk.utils.k f2 = f(context, str, bVar);
            if (f2 == null || !f2.n()) {
                com.ironsource.mediationsdk.logger.c.i().d(IronSourceLogger.IronSourceTag.INTERNAL, "Null or invalid response. Trying to get cached response", 0);
                f2 = j(context, str);
            }
            if (f2 != null) {
                this.f5421l = f2;
                IronSourceUtils.g0(context, f2.toString());
                H(this.f5421l, context);
                InterstitialEventsManager.getInstance().a0(true);
                RewardedVideoEventsManager.getInstance().a0(true);
            }
            return f2;
        }
    }

    public String B() {
        return this.v;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0080 A[Catch: all -> 0x01c0, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000c, B:7:0x0014, B:9:0x0018, B:12:0x001c, B:14:0x0020, B:16:0x0034, B:17:0x0036, B:19:0x003e, B:20:0x0040, B:25:0x005f, B:27:0x0080, B:28:0x008a, B:30:0x00a6, B:31:0x00a8, B:33:0x00b2, B:35:0x00c3, B:36:0x00c8, B:38:0x00d2, B:39:0x00db, B:42:0x00ec, B:44:0x00f0, B:45:0x00f9, B:47:0x0129, B:49:0x013b, B:51:0x0144, B:52:0x0147, B:54:0x0152, B:56:0x0156, B:57:0x0162, B:61:0x0171, B:48:0x0136, B:60:0x016e, B:62:0x0181, B:64:0x018b, B:65:0x0194, B:21:0x0049, B:23:0x0051, B:24:0x005b, B:67:0x01b0, B:68:0x01b4), top: B:74:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a6 A[Catch: all -> 0x01c0, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000c, B:7:0x0014, B:9:0x0018, B:12:0x001c, B:14:0x0020, B:16:0x0034, B:17:0x0036, B:19:0x003e, B:20:0x0040, B:25:0x005f, B:27:0x0080, B:28:0x008a, B:30:0x00a6, B:31:0x00a8, B:33:0x00b2, B:35:0x00c3, B:36:0x00c8, B:38:0x00d2, B:39:0x00db, B:42:0x00ec, B:44:0x00f0, B:45:0x00f9, B:47:0x0129, B:49:0x013b, B:51:0x0144, B:52:0x0147, B:54:0x0152, B:56:0x0156, B:57:0x0162, B:61:0x0171, B:48:0x0136, B:60:0x016e, B:62:0x0181, B:64:0x018b, B:65:0x0194, B:21:0x0049, B:23:0x0051, B:24:0x005b, B:67:0x01b0, B:68:0x01b4), top: B:74:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b2 A[Catch: all -> 0x01c0, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000c, B:7:0x0014, B:9:0x0018, B:12:0x001c, B:14:0x0020, B:16:0x0034, B:17:0x0036, B:19:0x003e, B:20:0x0040, B:25:0x005f, B:27:0x0080, B:28:0x008a, B:30:0x00a6, B:31:0x00a8, B:33:0x00b2, B:35:0x00c3, B:36:0x00c8, B:38:0x00d2, B:39:0x00db, B:42:0x00ec, B:44:0x00f0, B:45:0x00f9, B:47:0x0129, B:49:0x013b, B:51:0x0144, B:52:0x0147, B:54:0x0152, B:56:0x0156, B:57:0x0162, B:61:0x0171, B:48:0x0136, B:60:0x016e, B:62:0x0181, B:64:0x018b, B:65:0x0194, B:21:0x0049, B:23:0x0051, B:24:0x005b, B:67:0x01b0, B:68:0x01b4), top: B:74:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec A[Catch: all -> 0x01c0, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000c, B:7:0x0014, B:9:0x0018, B:12:0x001c, B:14:0x0020, B:16:0x0034, B:17:0x0036, B:19:0x003e, B:20:0x0040, B:25:0x005f, B:27:0x0080, B:28:0x008a, B:30:0x00a6, B:31:0x00a8, B:33:0x00b2, B:35:0x00c3, B:36:0x00c8, B:38:0x00d2, B:39:0x00db, B:42:0x00ec, B:44:0x00f0, B:45:0x00f9, B:47:0x0129, B:49:0x013b, B:51:0x0144, B:52:0x0147, B:54:0x0152, B:56:0x0156, B:57:0x0162, B:61:0x0171, B:48:0x0136, B:60:0x016e, B:62:0x0181, B:64:0x018b, B:65:0x0194, B:21:0x0049, B:23:0x0051, B:24:0x005b, B:67:0x01b0, B:68:0x01b4), top: B:74:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void D(android.content.Context r7, java.lang.String r8, boolean r9, com.ironsource.mediationsdk.n0.i r10, com.ironsource.mediationsdk.IronSource.AD_UNIT... r11) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.IronSourceObject.D(android.content.Context, java.lang.String, boolean, com.ironsource.mediationsdk.n0.i, com.ironsource.mediationsdk.IronSource$AD_UNIT[]):void");
    }

    boolean I() {
        return ContextProvider.getInstance().b() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K() {
        return this.D || this.E;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
        if (r3.z() != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
        if (r3.L() != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean M() {
        /*
            r9 = this;
            java.lang.String r0 = "isInterstitialReady():"
            r1 = 1
            r2 = 0
            boolean r3 = r9.E     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L13
            com.ironsource.mediationsdk.logger.c r3 = r9.f5416g     // Catch: java.lang.Throwable -> L75
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r4 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch: java.lang.Throwable -> L75
            java.lang.String r5 = "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead"
            r6 = 3
            r3.d(r4, r5, r6)     // Catch: java.lang.Throwable -> L75
            return r2
        L13:
            boolean r3 = r9.R     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L34
            boolean r3 = r9.S     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L29
            com.ironsource.mediationsdk.adunit.manager.d r3 = r9.O     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L27
            boolean r3 = r3.z()     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L27
        L25:
            r3 = 1
            goto L3f
        L27:
            r3 = 0
            goto L3f
        L29:
            com.ironsource.mediationsdk.ProgIsManager r3 = r9.M     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L27
            boolean r3 = r3.f0()     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L27
            goto L25
        L34:
            com.ironsource.mediationsdk.t r3 = r9.f5413d     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L27
            boolean r3 = r3.L()     // Catch: java.lang.Throwable -> L75
            if (r3 == 0) goto L27
            goto L25
        L3f:
            boolean r4 = r9.R     // Catch: java.lang.Throwable -> L70
            org.json.JSONObject r4 = com.ironsource.mediationsdk.utils.IronSourceUtils.E(r2, r4, r1)     // Catch: java.lang.Throwable -> L70
            d.e.b.b r5 = new d.e.b.b     // Catch: java.lang.Throwable -> L70
            if (r3 == 0) goto L4c
            r6 = 2101(0x835, float:2.944E-42)
            goto L4e
        L4c:
            r6 = 2102(0x836, float:2.946E-42)
        L4e:
            r5.<init>(r6, r4)     // Catch: java.lang.Throwable -> L70
            com.ironsource.mediationsdk.events.InterstitialEventsManager r4 = com.ironsource.mediationsdk.events.InterstitialEventsManager.getInstance()     // Catch: java.lang.Throwable -> L70
            r4.P(r5)     // Catch: java.lang.Throwable -> L70
            com.ironsource.mediationsdk.logger.c r4 = r9.f5416g     // Catch: java.lang.Throwable -> L70
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r5 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API     // Catch: java.lang.Throwable -> L70
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
            r6.<init>()     // Catch: java.lang.Throwable -> L70
            r6.append(r0)     // Catch: java.lang.Throwable -> L70
            r6.append(r3)     // Catch: java.lang.Throwable -> L70
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L70
            r4.d(r5, r6, r1)     // Catch: java.lang.Throwable -> L70
            r2 = r3
            goto L94
        L70:
            r4 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
            goto L77
        L75:
            r3 = move-exception
            r4 = 0
        L77:
            com.ironsource.mediationsdk.logger.c r5 = r9.f5416g
            com.ironsource.mediationsdk.logger.IronSourceLogger$IronSourceTag r6 = com.ironsource.mediationsdk.logger.IronSourceLogger.IronSourceTag.API
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r0)
            r7.append(r4)
            java.lang.String r0 = r7.toString()
            r5.d(r6, r0, r1)
            com.ironsource.mediationsdk.logger.c r0 = r9.f5416g
            java.lang.String r1 = "isInterstitialReady()"
            r0.e(r6, r1, r3)
        L94:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.IronSourceObject.M():boolean");
    }

    public void P(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("placementName = " + str);
        if (ironSourceBannerLayout != null && !ironSourceBannerLayout.h()) {
            if (!this.G) {
                this.f5416g.d(IronSourceLogger.IronSourceTag.API, "init() must be called before loadBanner()", 3);
                BannerCallbackThrottler.getInstance().d(ironSourceBannerLayout, com.ironsource.mediationsdk.utils.f.e("init() must be called before loadBanner()"));
                return;
            } else if (ironSourceBannerLayout.g().a().equals("CUSTOM") && (ironSourceBannerLayout.g().c() <= 0 || ironSourceBannerLayout.g().b() <= 0)) {
                this.f5416g.d(IronSourceLogger.IronSourceTag.API, "loadBanner: Unsupported banner size. Height and width must be bigger than 0", 3);
                BannerCallbackThrottler.getInstance().d(ironSourceBannerLayout, com.ironsource.mediationsdk.utils.f.k(""));
                return;
            } else {
                MediationInitializer.EInitStatus D = MediationInitializer.getInstance().D();
                if (D == MediationInitializer.EInitStatus.INIT_FAILED) {
                    this.f5416g.d(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    BannerCallbackThrottler.getInstance().d(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(600, "Init() had failed"));
                    return;
                } else if (D == MediationInitializer.EInitStatus.INIT_IN_PROGRESS) {
                    if (MediationInitializer.getInstance().G()) {
                        this.f5416g.d(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                        BannerCallbackThrottler.getInstance().d(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(601, "Init had failed"));
                        return;
                    }
                    this.I = ironSourceBannerLayout;
                    this.H = Boolean.TRUE;
                    this.J = str;
                    return;
                } else {
                    synchronized (this.H) {
                        if (this.f5415f == null && this.N == null) {
                            this.I = ironSourceBannerLayout;
                            this.H = Boolean.TRUE;
                            this.J = str;
                            return;
                        }
                        com.ironsource.mediationsdk.utils.k kVar = this.f5421l;
                        if (kVar != null && kVar.b() != null && this.f5421l.b().b() != null) {
                            if (!this.U) {
                                this.f5415f.n(ironSourceBannerLayout, i(str));
                                return;
                            } else {
                                this.N.z0(ironSourceBannerLayout, i(str));
                                return;
                            }
                        }
                        this.f5416g.d(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
                        BannerCallbackThrottler.getInstance().d(ironSourceBannerLayout, new com.ironsource.mediationsdk.logger.b(615, "No banner configurations found"));
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("loadBanner can't be called - ");
        sb.append(ironSourceBannerLayout == null ? "banner layout is null " : "banner layout is destroyed");
        String sb2 = sb.toString();
        this.f5416g.d(IronSourceLogger.IronSourceTag.API, sb2, 3);
        BannerCallbackThrottler.getInstance().d(ironSourceBannerLayout, com.ironsource.mediationsdk.utils.f.e(sb2));
    }

    public void Q() {
        com.ironsource.mediationsdk.logger.c cVar = this.f5416g;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        cVar.d(ironSourceTag, "loadInterstitial()", 1);
        try {
            if (this.E) {
                this.f5416g.d(ironSourceTag, "Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", 3);
                CallbackThrottler.getInstance().f(com.ironsource.mediationsdk.utils.f.c("Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", "Interstitial"));
            } else if (!this.F) {
                this.f5416g.d(ironSourceTag, "init() must be called before loadInterstitial()", 3);
                CallbackThrottler.getInstance().f(com.ironsource.mediationsdk.utils.f.c("init() must be called before loadInterstitial()", "Interstitial"));
            } else {
                MediationInitializer.EInitStatus D = MediationInitializer.getInstance().D();
                if (D == MediationInitializer.EInitStatus.INIT_FAILED) {
                    this.f5416g.d(ironSourceTag, "init() had failed", 3);
                    CallbackThrottler.getInstance().f(com.ironsource.mediationsdk.utils.f.c("init() had failed", "Interstitial"));
                } else if (D == MediationInitializer.EInitStatus.INIT_IN_PROGRESS) {
                    if (MediationInitializer.getInstance().G()) {
                        this.f5416g.d(ironSourceTag, "init() had failed", 3);
                        CallbackThrottler.getInstance().f(com.ironsource.mediationsdk.utils.f.c("init() had failed", "Interstitial"));
                        return;
                    }
                    this.T = true;
                } else {
                    com.ironsource.mediationsdk.utils.k kVar = this.f5421l;
                    if (kVar != null && kVar.b() != null && this.f5421l.b().c() != null) {
                        if (!this.R) {
                            this.f5413d.O();
                            return;
                        } else if (this.S) {
                            com.ironsource.mediationsdk.adunit.manager.d dVar = this.O;
                            if (dVar == null) {
                                this.T = true;
                                return;
                            } else {
                                dVar.C();
                                return;
                            }
                        } else {
                            ProgIsManager progIsManager = this.M;
                            if (progIsManager == null) {
                                this.T = true;
                                return;
                            } else {
                                progIsManager.g0();
                                return;
                            }
                        }
                    }
                    this.f5416g.d(ironSourceTag, "No interstitial configurations found", 3);
                    CallbackThrottler.getInstance().f(com.ironsource.mediationsdk.utils.f.c("the server response does not contain interstitial data", "Interstitial"));
                }
            }
        } catch (Throwable th) {
            this.f5416g.e(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", th);
            CallbackThrottler.getInstance().f(new com.ironsource.mediationsdk.logger.b(TypedValues.PositionType.TYPE_POSITION_TYPE, th.getMessage()));
        }
    }

    public void V(long j2) {
        JSONObject D = IronSourceUtils.D(K());
        try {
            D.put(TypedValues.TransitionType.S_DURATION, j2);
            D.put("sessionDepth", this.C);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        RewardedVideoEventsManager.getInstance().P(new d.e.b.b(514, D));
    }

    public void Y(com.ironsource.mediationsdk.n0.l lVar) {
        if (lVar == null) {
            this.f5416g.d(IronSourceLogger.IronSourceTag.API, "setInterstitialListener(ISListener:null)", 1);
        } else {
            this.f5416g.d(IronSourceLogger.IronSourceTag.API, "setInterstitialListener(ISListener)", 1);
        }
        this.f5417h.D(lVar);
        ISListenerWrapper.getInstance().k(lVar);
        CallbackThrottler.getInstance().i(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Z(String str, boolean z) {
        IronLog ironLog = IronLog.API;
        ironLog.verbose("userId = " + str + ", isFromPublisher = " + z);
        this.n = str;
        if (z) {
            RewardedVideoEventsManager.getInstance().P(new d.e.b.b(52, IronSourceUtils.z(false)));
        }
    }

    @Override // com.ironsource.mediationsdk.utils.j
    public void a(String str) {
        try {
            com.ironsource.mediationsdk.logger.c cVar = this.f5416g;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            cVar.d(ironSourceTag, "onInitFailed(reason:" + str + ")", 1);
            IronSourceUtils.j0("Mediation init failed");
            if (this.f5417h != null) {
                for (IronSource.AD_UNIT ad_unit : this.y) {
                    R(ad_unit, true);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a0(String str) {
        try {
            com.ironsource.mediationsdk.logger.c cVar = this.f5416g;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar.d(ironSourceTag, this.a + ":setMediationType(mediationType:" + str + ")", 1);
            if (q0(str, 1, 64) && o0(str)) {
                this.r = str;
            } else {
                this.f5416g.d(ironSourceTag, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
            }
        } catch (Exception e2) {
            this.f5416g.e(IronSourceLogger.IronSourceTag.API, this.a + ":setMediationType(mediationType:" + str + ")", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(com.ironsource.mediationsdk.b bVar) {
        this.b = bVar;
    }

    public void b0(String str) {
        String str2 = "showInterstitial(" + str + ")";
        com.ironsource.mediationsdk.logger.c cVar = this.f5416g;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        cVar.d(ironSourceTag, str2, 1);
        try {
            if (this.E) {
                this.f5416g.d(ironSourceTag, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                this.f5417h.e(new com.ironsource.mediationsdk.logger.b(TypedValues.PositionType.TYPE_POSITION_TYPE, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead"));
            } else if (!L()) {
                this.f5417h.e(com.ironsource.mediationsdk.utils.f.c("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
            } else if (this.R) {
                c0(str);
            } else {
                com.ironsource.mediationsdk.model.k t = t(str);
                JSONObject D = IronSourceUtils.D(false);
                try {
                    if (t != null) {
                        D.put("placement", t.c());
                    } else if (!TextUtils.isEmpty(str)) {
                        D.put("placement", str);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                InterstitialEventsManager.getInstance().P(new d.e.b.b(AdError.BROKEN_MEDIA_ERROR_CODE, D));
                if (t != null) {
                    this.f5413d.Y(t);
                    this.f5413d.c0(t.c());
                }
            }
        } catch (Exception e3) {
            this.f5416g.e(IronSourceLogger.IronSourceTag.API, str2, e3);
            this.f5417h.e(new com.ironsource.mediationsdk.logger.b(TypedValues.PositionType.TYPE_POSITION_TYPE, e3.getMessage()));
        }
    }

    public String h(Context context) {
        try {
            String[] d2 = com.ironsource.environment.e.d(context);
            if (d2.length > 0 && d2[0] != null) {
                return d2[0];
            }
        } catch (Exception unused) {
        }
        return "";
    }

    @Override // com.ironsource.mediationsdk.utils.j
    public void k(List<IronSource.AD_UNIT> list, boolean z, com.ironsource.mediationsdk.model.i iVar) {
        IronSource.AD_UNIT[] values;
        IronLog.INTERNAL.verbose("");
        try {
            this.u = list;
            this.t = true;
            this.f5416g.d(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            IronSourceUtils.j0("init success");
            if (z) {
                JSONObject D = IronSourceUtils.D(false);
                try {
                    D.put("revived", true);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                RewardedVideoEventsManager.getInstance().P(new d.e.b.b(114, D));
            }
            InterstitialEventsManager.getInstance().r0();
            RewardedVideoEventsManager.getInstance().r0();
            AdapterRepository.getInstance().r(u(), v());
            for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
                if (this.y.contains(ad_unit)) {
                    if (list.contains(ad_unit)) {
                        d0(ad_unit);
                    } else {
                        R(ad_unit, false);
                    }
                }
            }
            if (this.P != null) {
                IronLog.CALLBACK.verbose("onInitializationCompleted");
                this.P.a();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.utils.j
    public void l() {
        synchronized (this.H) {
            if (this.H.booleanValue()) {
                this.H = Boolean.FALSE;
                BannerCallbackThrottler.getInstance().d(this.I, new com.ironsource.mediationsdk.logger.b(TypedValues.MotionType.TYPE_EASING, "init had failed"));
                this.I = null;
                this.J = null;
            }
        }
        if (this.T) {
            this.T = false;
            CallbackThrottler.getInstance().f(com.ironsource.mediationsdk.utils.f.c("init() had failed", "Interstitial"));
        }
        synchronized (this.W) {
            Iterator<String> it = this.W.iterator();
            while (it.hasNext()) {
                ISDemandOnlyListenerWrapper.getInstance().f(it.next(), com.ironsource.mediationsdk.utils.f.c("init() had failed", "Interstitial"));
            }
            this.W.clear();
        }
        synchronized (this.X) {
            Iterator<String> it2 = this.X.iterator();
            while (it2.hasNext()) {
                RVDemandOnlyListenerWrapper.getInstance().f(it2.next(), com.ironsource.mediationsdk.utils.f.c("init() had failed", "Rewarded Video"));
            }
            this.X.clear();
        }
    }

    String m(String str, CappingManager.ECappingStatus eCappingStatus) {
        if (eCappingStatus == null) {
            return null;
        }
        int i2 = a.b[eCappingStatus.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return "placement " + str + " is capped";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Boolean n() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.ironsource.mediationsdk.utils.k o() {
        return this.f5421l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String q() {
        return this.p;
    }

    public String u() {
        return this.m;
    }

    public String v() {
        return this.n;
    }

    public String w() {
        return this.o;
    }

    public String x() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized com.ironsource.mediationsdk.b y(String str) {
        try {
            com.ironsource.mediationsdk.b bVar = this.b;
            if (bVar != null && bVar.getProviderName().equals(str)) {
                return this.b;
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c cVar = this.f5416g;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar.d(ironSourceTag, "getOfferwallAdapter exception: " + e2, 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> z() {
        return this.q;
    }

    private IronSourceObject() {
        this.a = getClass().getName();
        this.f5420k = new Object();
        this.f5421l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.t = false;
        this.v = null;
        this.x = null;
        this.A = true;
        this.K = null;
        G();
        this.f5419j = new AtomicBoolean();
        this.y = new HashSet();
        this.z = new HashSet();
        this.E = false;
        this.D = false;
        this.s = new AtomicBoolean(true);
        this.C = 0;
        this.F = false;
        this.G = false;
        this.v = UUID.randomUUID().toString();
        this.H = Boolean.FALSE;
        this.T = false;
        this.J = null;
        this.L = null;
        this.M = null;
        this.P = null;
        this.N = null;
        this.Q = false;
        this.R = false;
        this.U = false;
        this.W = new CopyOnWriteArraySet<>();
        this.X = new CopyOnWriteArraySet<>();
        this.Y = null;
        this.Z = null;
        this.f5415f = null;
        this.V = 1;
        this.d0 = new com.ironsource.mediationsdk.l0.a();
    }
}
