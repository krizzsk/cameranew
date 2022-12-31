package com.ironsource.mediationsdk;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AdapterRepository {

    /* renamed from: i  reason: collision with root package name */
    private static final AdapterRepository f5372i = new AdapterRepository();

    /* renamed from: j  reason: collision with root package name */
    private static final Object f5373j = new Object();
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f5374d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f5375e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f5376f;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicBoolean f5378h = new AtomicBoolean(false);
    private final ConcurrentHashMap<String, b> a = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, com.ironsource.mediationsdk.j0.a.c.b> b = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final ConcurrentHashMap<String, List<String>> f5377g = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            a = iArr;
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private AdapterRepository() {
    }

    private com.ironsource.mediationsdk.j0.a.c.d<?> b(com.ironsource.mediationsdk.model.l lVar, IronSource.AD_UNIT ad_unit) {
        String m;
        if (lVar.r() && TextUtils.isEmpty(lVar.e())) {
            IronLog.INTERNAL.error("missing package definition for " + lVar.m());
            return null;
        }
        String e2 = lVar.r() ? lVar.e() : "com.ironsource.adapters";
        String str = e2 + "." + com.ironsource.environment.j.a(m) + "." + lVar.m() + TypedValues.Custom.NAME + e(ad_unit);
        try {
            return (com.ironsource.mediationsdk.j0.a.c.d) Class.forName(str).getConstructor(com.ironsource.mediationsdk.model.l.class).newInstance(lVar);
        } catch (Exception unused) {
            if (lVar.r()) {
                String str2 = "failed to load " + str;
                IronLog.INTERNAL.error(str2);
                n(88001, str2);
            }
            return null;
        }
    }

    private void d(JSONObject jSONObject, b bVar, String str) {
        if ((str.equalsIgnoreCase("SupersonicAds") || str.equalsIgnoreCase("IronSource")) && this.f5378h.compareAndSet(false, true)) {
            m("SDK5 earlyInit  <" + str + ">");
            try {
                bVar.earlyInit(this.c, this.f5374d, jSONObject);
            } catch (Exception e2) {
                String str2 = "error while calling early init for " + bVar.getProviderName() + ": " + e2.getLocalizedMessage();
                n(88001, str2);
                IronLog.INTERNAL.error(str2);
            }
        }
    }

    private String e(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == null || TextUtils.isEmpty(ad_unit.toString())) {
            return "";
        }
        return ad_unit.toString().substring(0, 1).toUpperCase() + ad_unit.toString().substring(1);
    }

    private b g(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.ironsource.adapters." + com.ironsource.environment.j.a(str2) + "." + str2 + "Adapter");
            return (b) cls.getMethod("startAdapter", String.class).invoke(cls, str);
        } catch (Exception e2) {
            String str3 = "Error while loading adapter - exception = " + e2.getLocalizedMessage();
            n(88001, str3);
            l(str3);
            return null;
        }
    }

    public static AdapterRepository getInstance() {
        return f5372i;
    }

    private String h(com.ironsource.mediationsdk.model.l lVar) {
        return lVar.t() ? lVar.m() : lVar.l();
    }

    private com.ironsource.mediationsdk.j0.a.c.a k(String str, String str2, com.ironsource.mediationsdk.model.l lVar) {
        if (lVar.r() && TextUtils.isEmpty(lVar.e())) {
            IronLog.INTERNAL.error("missing package definition for " + str);
            return null;
        }
        String str3 = (lVar.r() ? lVar.e() : "com.ironsource.adapters") + "." + com.ironsource.environment.j.a(str2) + "." + str2 + "CustomAdapter";
        try {
            com.ironsource.mediationsdk.j0.a.b bVar = (com.ironsource.mediationsdk.j0.a.b) Class.forName(str3).newInstance();
            IronLog.INTERNAL.info(str3 + " was allocated (adapter version: " + bVar.i() + ", sdk version: " + bVar.b() + ")");
            o(bVar);
            this.b.put(str, new com.ironsource.mediationsdk.j0.a.c.b(bVar, lVar));
            return bVar;
        } catch (Exception unused) {
            if (lVar.r()) {
                String str4 = "failed to load " + str3;
                IronLog.INTERNAL.error(str4);
                n(88001, str4);
            }
            return null;
        }
    }

    private void l(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "AdapterRepository: " + str, 3);
    }

    private void m(String str) {
        com.ironsource.mediationsdk.logger.c i2 = com.ironsource.mediationsdk.logger.c.i();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        i2.d(ironSourceTag, "AdapterRepository: " + str, 0);
    }

    private void n(int i2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("reason", str);
            }
            InterstitialEventsManager.getInstance().P(new d.e.b.b(i2, jSONObject));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void o(com.ironsource.mediationsdk.j0.a.c.a aVar) {
        Boolean bool = this.f5376f;
        if (bool == null || !(aVar instanceof com.ironsource.mediationsdk.j0.a.a)) {
            return;
        }
        try {
            ((com.ironsource.mediationsdk.j0.a.a) aVar).d(bool.booleanValue());
        } catch (Exception e2) {
            String str = "error while setting adapterDebug of " + aVar.getClass().getSimpleName() + ": " + e2.getLocalizedMessage();
            n(88001, str);
            m(str);
            e2.printStackTrace();
        }
    }

    private void p(b bVar) {
        Boolean bool = this.f5376f;
        if (bool != null) {
            try {
                bVar.setAdapterDebug(bool);
            } catch (Throwable th) {
                String str = "error while setting adapterDebug of " + bVar.getProviderName() + ": " + th.getLocalizedMessage();
                n(88001, str);
                m(str);
                th.printStackTrace();
            }
        }
    }

    private void q(b bVar) {
        try {
            Boolean bool = this.f5375e;
            if (bool != null) {
                bVar.setConsent(bool.booleanValue());
            }
        } catch (Throwable th) {
            String str = "error while setting consent of " + bVar.getProviderName() + ": " + th.getLocalizedMessage();
            n(88001, str);
            m(str);
            th.printStackTrace();
        }
    }

    private void s(b bVar) {
        for (String str : this.f5377g.keySet()) {
            try {
                List<String> list = this.f5377g.get(str);
                IronSourceUtils.j0(bVar.getProviderName() + "Adapter setMetaData key = " + str + ", values = " + list);
                if (list != null) {
                    bVar.setMetaData(str, list);
                }
            } catch (Throwable th) {
                String str2 = "error while setting metadata of " + bVar.getProviderName() + ": " + th.getLocalizedMessage();
                n(88001, str2);
                m(str2);
                th.printStackTrace();
            }
        }
    }

    public com.ironsource.mediationsdk.j0.a.c.d<?> a(com.ironsource.mediationsdk.model.l lVar, IronSource.AD_UNIT ad_unit) {
        com.ironsource.mediationsdk.j0.a.c.d<?> b = b(lVar, ad_unit);
        if (b == null) {
            b c = c(lVar);
            if (c != null) {
                return new x(c, lVar, ad_unit);
            }
            String str = "error creating ad adapter " + lVar.l();
            n(88001, str);
            IronLog.INTERNAL.error(str);
            return null;
        }
        return b;
    }

    public b c(com.ironsource.mediationsdk.model.l lVar) {
        String h2 = h(lVar);
        if (lVar.m().equalsIgnoreCase("SupersonicAds")) {
            return this.a.get(h2);
        }
        return g(h2, lVar.m());
    }

    public b f(com.ironsource.mediationsdk.model.l lVar, JSONObject jSONObject, boolean z, boolean z2) {
        String str;
        String h2 = h(lVar);
        String m = z ? "IronSource" : lVar.m();
        synchronized (f5373j) {
            if (!z2) {
                if (this.a.containsKey(h2)) {
                    return this.a.get(h2);
                }
            }
            b g2 = g(h2, m);
            if (g2 == null) {
                l(h2 + " adapter was not loaded");
                return null;
            }
            try {
                str = g2.getCoreSDKVersion();
            } catch (Exception e2) {
                String str2 = "error while retrieving coreSDKVersion " + g2.getProviderName() + ": " + e2.getLocalizedMessage();
                n(88001, str2);
                IronLog.INTERNAL.error(str2);
                str = "Unknown";
            }
            m(h2 + " was allocated (adapter version: " + g2.getVersion() + ", sdk version: " + str + ")");
            g2.setLogListener(com.ironsource.mediationsdk.logger.c.i());
            s(g2);
            q(g2);
            p(g2);
            d(jSONObject, g2, m);
            if (!z2) {
                this.a.put(h2, g2);
            }
            return g2;
        }
    }

    public ConcurrentHashMap<String, List<String>> i() {
        return this.f5377g;
    }

    public com.ironsource.mediationsdk.j0.a.c.a j(com.ironsource.mediationsdk.model.l lVar, IronSource.AD_UNIT ad_unit) {
        JSONObject o;
        String h2 = h(lVar);
        if (this.b.containsKey(h2)) {
            return this.b.get(h2).a();
        }
        com.ironsource.mediationsdk.j0.a.c.a k2 = k(h2, lVar.m(), lVar);
        if (k2 == null) {
            int i2 = a.a[ad_unit.ordinal()];
            if (i2 == 1) {
                o = lVar.o();
            } else if (i2 != 2) {
                o = i2 != 3 ? null : lVar.d();
            } else {
                o = lVar.h();
            }
            b f2 = f(lVar, o, false, true);
            if (f2 != null) {
                x xVar = new x(f2, lVar, ad_unit);
                this.b.put(h2, new com.ironsource.mediationsdk.j0.a.c.b(xVar, lVar));
                return xVar;
            }
            String str = "error creating network adapter " + lVar.l();
            n(88001, str);
            IronLog.INTERNAL.error(str);
            return null;
        }
        return k2;
    }

    public void r(String str, String str2) {
        this.c = str;
        this.f5374d = str2;
    }
}
