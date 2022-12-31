package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import com.tapjoy.internal.di;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class dv implements di.a {

    /* renamed from: e  reason: collision with root package name */
    private int f7378e;

    /* renamed from: i  reason: collision with root package name */
    private long f7382i;
    private static dv c = new dv();
    public static Handler a = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private static Handler f7375d = null;

    /* renamed from: j  reason: collision with root package name */
    private static final Runnable f7376j = new Runnable() { // from class: com.tapjoy.internal.dv.2
        @Override // java.lang.Runnable
        public final void run() {
            dv.b(dv.a());
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private static final Runnable f7377k = new Runnable() { // from class: com.tapjoy.internal.dv.3
        @Override // java.lang.Runnable
        public final void run() {
            if (dv.f7375d != null) {
                dv.f7375d.post(dv.f7376j);
                dv.f7375d.postDelayed(dv.f7377k, 200L);
            }
        }
    };
    public List b = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private dw f7380g = new dw();

    /* renamed from: f  reason: collision with root package name */
    private dj f7379f = new dj();

    /* renamed from: h  reason: collision with root package name */
    private ed f7381h = new ed(new dz());

    dv() {
    }

    public static dv a() {
        return c;
    }

    private void a(long j2) {
        if (this.b.size() > 0) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                it.next();
                TimeUnit.NANOSECONDS.toMillis(j2);
            }
        }
    }

    private void a(View view, di diVar, JSONObject jSONObject, int i2) {
        diVar.a(view, jSONObject, this, i2 == ee.a);
    }

    public static void b() {
        if (f7375d == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f7375d = handler;
            handler.post(f7376j);
            f7375d.postDelayed(f7377k, 200L);
        }
    }

    public static void c() {
        Handler handler = f7375d;
        if (handler != null) {
            handler.removeCallbacks(f7377k);
            f7375d = null;
        }
    }

    @Override // com.tapjoy.internal.di.a
    public final void a(View view, di diVar, JSONObject jSONObject) {
        String str;
        boolean z = false;
        if (dp.c(view) == null) {
            dw dwVar = this.f7380g;
            int i2 = dwVar.f7383d.contains(view) ? ee.a : dwVar.f7387h ? ee.b : ee.c;
            if (i2 == ee.c) {
                return;
            }
            JSONObject a2 = diVar.a(view);
            dm.a(jSONObject, a2);
            dw dwVar2 = this.f7380g;
            ArrayList arrayList = null;
            if (dwVar2.a.size() == 0) {
                str = null;
            } else {
                str = (String) dwVar2.a.get(view);
                if (str != null) {
                    dwVar2.a.remove(view);
                }
            }
            if (str != null) {
                dm.a(a2, str);
                this.f7380g.f7387h = true;
                z = true;
            }
            if (!z) {
                dw dwVar3 = this.f7380g;
                if (dwVar3.c.size() != 0 && (arrayList = (ArrayList) dwVar3.c.get(view)) != null) {
                    dwVar3.c.remove(view);
                    Collections.sort(arrayList);
                }
                if (arrayList != null) {
                    dm.a(a2, arrayList);
                }
                a(view, diVar, a2, i2);
            }
            this.f7378e++;
        }
    }

    static /* synthetic */ void b(dv dvVar) {
        String str;
        dvVar.f7378e = 0;
        dvVar.f7382i = System.nanoTime();
        dw dwVar = dvVar.f7380g;
        dd a2 = dd.a();
        if (a2 != null) {
            for (cz czVar : Collections.unmodifiableCollection(a2.b)) {
                View c2 = czVar.c();
                if (czVar.d()) {
                    String str2 = czVar.f7355f;
                    if (c2 != null) {
                        if (c2.hasWindowFocus()) {
                            HashSet hashSet = new HashSet();
                            View view = c2;
                            while (true) {
                                if (view == null) {
                                    dwVar.f7383d.addAll(hashSet);
                                    str = null;
                                    break;
                                }
                                String c3 = dp.c(view);
                                if (c3 != null) {
                                    str = c3;
                                    break;
                                }
                                hashSet.add(view);
                                ViewParent parent = view.getParent();
                                view = parent instanceof View ? (View) parent : null;
                            }
                        } else {
                            str = "noWindowFocus";
                        }
                        if (str == null) {
                            dwVar.f7384e.add(str2);
                            dwVar.a.put(c2, str2);
                            dwVar.a(czVar);
                        } else {
                            dwVar.f7385f.add(str2);
                            dwVar.b.put(str2, c2);
                            dwVar.f7386g.put(str2, str);
                        }
                    } else {
                        dwVar.f7385f.add(str2);
                        dwVar.f7386g.put(str2, "noAdView");
                    }
                }
            }
        }
        long nanoTime = System.nanoTime();
        dk dkVar = dvVar.f7379f.b;
        if (dvVar.f7380g.f7385f.size() > 0) {
            Iterator it = dvVar.f7380g.f7385f.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                JSONObject a3 = dkVar.a(null);
                View view2 = (View) dvVar.f7380g.b.get(str3);
                dl dlVar = dvVar.f7379f.a;
                String str4 = (String) dvVar.f7380g.f7386g.get(str3);
                if (str4 != null) {
                    JSONObject a4 = dlVar.a(view2);
                    dm.a(a4, str3);
                    dm.b(a4, str4);
                    dm.a(a3, a4);
                }
                dm.a(a3);
                HashSet hashSet2 = new HashSet();
                hashSet2.add(str3);
                ed edVar = dvVar.f7381h;
                edVar.a.a(new eb(edVar, hashSet2, a3, nanoTime));
            }
        }
        if (dvVar.f7380g.f7384e.size() > 0) {
            JSONObject a5 = dkVar.a(null);
            dvVar.a(null, dkVar, a5, ee.a);
            dm.a(a5);
            ed edVar2 = dvVar.f7381h;
            edVar2.a.a(new ec(edVar2, dvVar.f7380g.f7384e, a5, nanoTime));
        } else {
            dvVar.f7381h.b();
        }
        dw dwVar2 = dvVar.f7380g;
        dwVar2.a.clear();
        dwVar2.b.clear();
        dwVar2.c.clear();
        dwVar2.f7383d.clear();
        dwVar2.f7384e.clear();
        dwVar2.f7385f.clear();
        dwVar2.f7386g.clear();
        dwVar2.f7387h = false;
        dvVar.a(System.nanoTime() - dvVar.f7382i);
    }
}
