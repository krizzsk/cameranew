package com.ironsource.mediationsdk.events;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.model.t;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: BaseEventsManager.java */
/* loaded from: classes2.dex */
public abstract class b {
    private com.ironsource.mediationsdk.logger.c A;
    private boolean a;
    private d.e.b.a c;

    /* renamed from: d  reason: collision with root package name */
    private com.ironsource.mediationsdk.events.a f5551d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<d.e.b.b> f5552e;

    /* renamed from: g  reason: collision with root package name */
    private int f5554g;

    /* renamed from: h  reason: collision with root package name */
    private String f5555h;

    /* renamed from: i  reason: collision with root package name */
    private Context f5556i;
    private int[] m;
    private int[] n;
    private int[] o;
    private int[] p;
    int t;
    String u;
    String v;
    Set<Integer> w;
    private d x;
    private v y;
    private t z;
    private boolean b = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5553f = true;

    /* renamed from: j  reason: collision with root package name */
    private int f5557j = 100;

    /* renamed from: k  reason: collision with root package name */
    private int f5558k = 5000;

    /* renamed from: l  reason: collision with root package name */
    private int f5559l = 1;
    private Map<String, String> q = new HashMap();
    private Map<String, String> r = new HashMap();
    private String s = "";
    private final Object B = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseEventsManager.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ d.e.b.b a;

        a(d.e.b.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean M;
            if (this.a == null || !b.this.f5553f) {
                return;
            }
            this.a.a("eventSessionId", b.this.f5555h);
            String h2 = IronSourceUtils.h(b.this.f5556i);
            if (b.this.j0(this.a)) {
                this.a.a("connectionType", h2);
            }
            if (b.this.L(h2, this.a)) {
                d.e.b.b bVar = this.a;
                bVar.f(b.this.A(bVar));
            }
            b.this.N(this.a, "reason");
            b.this.N(this.a, "ext1");
            if (!b.this.E().isEmpty()) {
                for (Map.Entry<String, String> entry : b.this.E().entrySet()) {
                    if (!this.a.c().has(entry.getKey()) && entry.getKey() != "eventId" && entry.getKey() != "timestamp") {
                        this.a.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            if (b.this.m0(this.a)) {
                if (b.this.k0(this.a) && !b.this.R(this.a)) {
                    this.a.a("sessionDepth", Integer.valueOf(b.this.F(this.a)));
                }
                if (b.this.n0(this.a)) {
                    b.this.V(this.a);
                } else if (!TextUtils.isEmpty(b.this.D(this.a.d())) && b.this.o0(this.a)) {
                    d.e.b.b bVar2 = this.a;
                    bVar2.a("placement", b.this.D(bVar2.d()));
                }
                long x = IronSourceUtils.x(b.this.f5556i);
                if (x != -1) {
                    this.a.a("firstSessionTimestamp", Long.valueOf(x));
                }
                try {
                    b.this.A.d(IronSourceLogger.IronSourceTag.EVENT, ("{\"eventId\":" + this.a.d() + ",\"timestamp\":" + this.a.e() + "," + this.a.b().substring(1)).replace(",", "\n"), 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                b.this.f5552e.add(this.a);
                b.f(b.this);
            }
            b bVar3 = b.this;
            if (bVar3.K(bVar3.o)) {
                M = b.this.J(this.a.d(), b.this.o);
            } else {
                M = b.this.M(this.a);
            }
            if (!b.this.b && M) {
                b.this.b = true;
            }
            if (b.this.c != null) {
                if (b.this.p0()) {
                    b.this.Q();
                    return;
                }
                b bVar4 = b.this;
                if (bVar4.l0(bVar4.f5552e) || M) {
                    b.this.z();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseEventsManager.java */
    /* renamed from: com.ironsource.mediationsdk.events.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0207b implements d.e.b.d {

        /* compiled from: BaseEventsManager.java */
        /* renamed from: com.ironsource.mediationsdk.events.b$b$a */
        /* loaded from: classes2.dex */
        class a implements Runnable {
            final /* synthetic */ boolean a;
            final /* synthetic */ ArrayList b;

            a(boolean z, ArrayList arrayList) {
                this.a = z;
                this.b = arrayList;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.a) {
                    ArrayList<d.e.b.b> i2 = b.this.c.i(b.this.v);
                    b.this.f5554g = i2.size() + b.this.f5552e.size();
                } else if (this.b != null) {
                    b.this.A.d(IronSourceLogger.IronSourceTag.INTERNAL, "Failed to send events", 0);
                    b.this.c.j(this.b, b.this.v);
                    ArrayList<d.e.b.b> i3 = b.this.c.i(b.this.v);
                    b.this.f5554g = i3.size() + b.this.f5552e.size();
                }
            }
        }

        C0207b() {
        }

        @Override // d.e.b.d
        public synchronized void a(ArrayList<d.e.b.b> arrayList, boolean z) {
            b.this.x.a(new a(z, arrayList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseEventsManager.java */
    /* loaded from: classes2.dex */
    public class c implements Comparator<d.e.b.b> {
        c(b bVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d.e.b.b bVar, d.e.b.b bVar2) {
            return bVar.e() >= bVar2.e() ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseEventsManager.java */
    /* loaded from: classes2.dex */
    public class d extends HandlerThread {
        private Handler a;

        d(b bVar, String str) {
            super(str);
        }

        void a(Runnable runnable) {
            this.a.post(runnable);
        }

        void b() {
            this.a = new Handler(getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int A(d.e.b.b bVar) {
        return bVar.d() + 90000;
    }

    private ArrayList<d.e.b.b> G(ArrayList<d.e.b.b> arrayList, ArrayList<d.e.b.b> arrayList2, int i2) {
        ArrayList<d.e.b.b> arrayList3 = new ArrayList<>();
        try {
            ArrayList arrayList4 = new ArrayList();
            arrayList4.addAll(arrayList);
            arrayList4.addAll(arrayList2);
            Collections.sort(arrayList4, new c(this));
            if (arrayList4.size() <= i2) {
                arrayList3.addAll(arrayList4);
            } else {
                arrayList3.addAll(arrayList4.subList(0, i2));
                this.c.j(arrayList4.subList(i2, arrayList4.size()), this.v);
            }
        } catch (Exception e2) {
            com.ironsource.mediationsdk.logger.c cVar = this.A;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            cVar.d(ironSourceTag, "CombinedEventList exception: " + e2.getMessage(), 3);
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J(int i2, int[] iArr) {
        if (K(iArr)) {
            for (int i3 : iArr) {
                if (i2 == i3) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean L(String str, d.e.b.b bVar) {
        boolean contains;
        if (str.equalsIgnoreCase(PortalFollowFeeds.TYPE_NONE)) {
            if (K(this.p)) {
                contains = J(bVar.d(), this.p);
            } else {
                contains = this.w.contains(Integer.valueOf(bVar.d()));
            }
            return contains;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(d.e.b.b bVar, String str) {
        O(bVar, str, 1024);
    }

    private void O(d.e.b.b bVar, String str, int i2) {
        JSONObject c2 = bVar.c();
        if (c2 == null || !c2.has(str)) {
            return;
        }
        try {
            String optString = c2.optString(str, null);
            if (optString != null) {
                bVar.a(str, optString.substring(0, Math.min(optString.length(), i2)));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        ArrayList<d.e.b.b> G;
        this.b = false;
        synchronized (this.B) {
            G = G(this.f5552e, this.c.i(this.v), this.f5558k);
            if (G.size() > 0) {
                this.f5552e.clear();
                this.c.a(this.v);
            }
        }
        if (G.size() > 0) {
            this.f5554g = 0;
            JSONObject e2 = com.ironsource.mediationsdk.n0.f.b().e();
            try {
                s0(e2);
                String B = B();
                if (!TextUtils.isEmpty(B)) {
                    e2.put("abt", B);
                }
                String x = IronSourceObject.getInstance().x();
                if (!TextUtils.isEmpty(x)) {
                    e2.put("mt", x);
                }
                Map<String, String> C = C();
                if (!C.isEmpty()) {
                    for (Map.Entry<String, String> entry : C.entrySet()) {
                        if (!e2.has(entry.getKey())) {
                            e2.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            new d.e.b.c(new C0207b()).execute(this.f5551d.c(G, e2), this.f5551d.f(), G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R(d.e.b.b bVar) {
        JSONObject c2 = bVar.c();
        if (c2 == null) {
            return false;
        }
        return c2.has("sessionDepth");
    }

    static /* synthetic */ int f(b bVar) {
        int i2 = bVar.f5554g;
        bVar.f5554g = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j0(d.e.b.b bVar) {
        return (bVar.d() == 40 || bVar.d() == 41 || bVar.d() == 50 || bVar.d() == 51 || bVar.d() == 52) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k0(d.e.b.b bVar) {
        return (bVar.d() == 14 || bVar.d() == 114 || bVar.d() == 514 || bVar.d() == 140 || bVar.d() == 40 || bVar.d() == 41 || bVar.d() == 50 || bVar.d() == 51 || bVar.d() == 52) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l0(ArrayList<d.e.b.b> arrayList) {
        return arrayList != null && arrayList.size() >= this.f5559l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m0(d.e.b.b bVar) {
        if (bVar != null) {
            if (K(this.m)) {
                return true ^ J(bVar.d(), this.m);
            }
            if (K(this.n)) {
                return J(bVar.d(), this.n);
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p0() {
        return (this.f5554g >= this.f5557j || this.b) && this.a;
    }

    private void s0(JSONObject jSONObject) {
        try {
            v vVar = this.y;
            if (vVar == null) {
                t tVar = this.z;
                if (tVar != null) {
                    String b = tVar.b();
                    if (!TextUtils.isEmpty(b)) {
                        jSONObject.put("segmentId", b);
                    }
                    JSONObject a2 = this.z.a();
                    Iterator<String> keys = a2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.put(next, a2.get(next));
                    }
                    return;
                }
                return;
            }
            vVar.a();
            throw null;
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void t0(String str) {
        com.ironsource.mediationsdk.events.a aVar = this.f5551d;
        if (aVar == null || !aVar.g().equals(str)) {
            this.f5551d = com.ironsource.mediationsdk.events.c.a(str, this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        synchronized (this.B) {
            this.c.j(this.f5552e, this.v);
            this.f5552e.clear();
        }
    }

    public String B() {
        return this.s;
    }

    public Map<String, String> C() {
        return this.q;
    }

    protected abstract String D(int i2);

    public Map<String, String> E() {
        return this.r;
    }

    protected abstract int F(d.e.b.b bVar);

    protected abstract void H();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        this.f5552e = new ArrayList<>();
        this.f5554g = 0;
        this.f5551d = com.ironsource.mediationsdk.events.c.a(this.u, this.t);
        d dVar = new d(this, this.v + "EventThread");
        this.x = dVar;
        dVar.start();
        this.x.b();
        this.A = com.ironsource.mediationsdk.logger.c.i();
        this.f5555h = IronSourceUtils.L();
        this.w = new HashSet();
        H();
    }

    protected abstract boolean M(d.e.b.b bVar);

    public synchronized void P(d.e.b.b bVar) {
        this.x.a(new a(bVar));
    }

    public void S(String str) {
        this.s = str;
    }

    public void T(int i2) {
        if (i2 > 0) {
            this.f5559l = i2;
        }
    }

    public void U(Map<String, String> map) {
        this.q.putAll(map);
    }

    protected abstract void V(d.e.b.b bVar);

    public void W(Map<String, Object> map, int i2, String str) {
        map.put("auctionTrials", Integer.valueOf(i2));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        map.put("auctionFallback", str);
    }

    public void X(Map<String, String> map) {
        this.r.putAll(map);
    }

    public void Y(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.ironsource.mediationsdk.events.a aVar = this.f5551d;
        if (aVar != null) {
            aVar.h(str);
        }
        IronSourceUtils.Y(context, this.v, str);
    }

    public void Z(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.u = str;
        IronSourceUtils.X(context, this.v, str);
        t0(str);
    }

    public void a0(boolean z) {
        this.a = z;
    }

    public void b0(boolean z) {
        this.f5553f = z;
    }

    public void c0(int i2) {
        if (i2 > 0) {
            this.f5558k = i2;
        }
    }

    public void d0(int i2) {
        if (i2 > 0) {
            this.f5557j = i2;
        }
    }

    public void e0(int[] iArr, Context context) {
        this.p = iArr;
        IronSourceUtils.Z(context, this.v, iArr);
    }

    public void f0(int[] iArr, Context context) {
        this.n = iArr;
        IronSourceUtils.a0(context, this.v, iArr);
    }

    public void g0(int[] iArr, Context context) {
        this.m = iArr;
        IronSourceUtils.b0(context, this.v, iArr);
    }

    public synchronized void h0(t tVar) {
        this.z = tVar;
    }

    public void i0(int[] iArr, Context context) {
        this.o = iArr;
        IronSourceUtils.c0(context, this.v, iArr);
    }

    protected abstract boolean n0(d.e.b.b bVar);

    protected abstract boolean o0(d.e.b.b bVar);

    public synchronized void q0(Context context, v vVar) {
        String j2 = IronSourceUtils.j(context, this.v, this.u);
        this.u = j2;
        t0(j2);
        this.f5551d.h(IronSourceUtils.k(context, this.v, null));
        this.c = d.e.b.a.h(context, "supersonic_sdk.db", 5);
        z();
        this.m = IronSourceUtils.r(context, this.v);
        this.n = IronSourceUtils.p(context, this.v);
        this.o = IronSourceUtils.t(context, this.v);
        this.p = IronSourceUtils.n(context, this.v);
        this.f5556i = context;
    }

    public void r0() {
        Q();
    }
}
