package com.iab.omid.library.ironsrc.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.ironsrc.walking.a;
import d.d.a.a.a.f.a;
import d.d.a.a.a.g.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TreeWalker implements a.InterfaceC0294a {

    /* renamed from: g  reason: collision with root package name */
    private static TreeWalker f5320g = new TreeWalker();

    /* renamed from: h  reason: collision with root package name */
    private static Handler f5321h = new Handler(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    private static Handler f5322i = null;

    /* renamed from: j  reason: collision with root package name */
    private static final Runnable f5323j = new b();

    /* renamed from: k  reason: collision with root package name */
    private static final Runnable f5324k = new c();
    private int b;

    /* renamed from: f  reason: collision with root package name */
    private long f5327f;
    private List<e> a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private com.iab.omid.library.ironsrc.walking.a f5325d = new com.iab.omid.library.ironsrc.walking.a();
    private d.d.a.a.a.f.b c = new d.d.a.a.a.f.b();

    /* renamed from: e  reason: collision with root package name */
    private com.iab.omid.library.ironsrc.walking.b f5326e = new com.iab.omid.library.ironsrc.walking.b(new a.d());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.this.f5326e.a();
        }
    }

    /* loaded from: classes2.dex */
    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TreeWalker.getInstance().p();
        }
    }

    /* loaded from: classes2.dex */
    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TreeWalker.f5322i != null) {
                TreeWalker.f5322i.post(TreeWalker.f5323j);
                TreeWalker.f5322i.postDelayed(TreeWalker.f5324k, 200L);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface d extends e {
        void a(int i2, long j2);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void b(int i2, long j2);
    }

    TreeWalker() {
    }

    private void d(long j2) {
        if (this.a.size() > 0) {
            for (e eVar : this.a) {
                eVar.b(this.b, TimeUnit.NANOSECONDS.toMillis(j2));
                if (eVar instanceof d) {
                    ((d) eVar).a(this.b, j2);
                }
            }
        }
    }

    private void e(View view, d.d.a.a.a.f.a aVar, JSONObject jSONObject, com.iab.omid.library.ironsrc.walking.c cVar) {
        aVar.a(view, jSONObject, this, cVar == com.iab.omid.library.ironsrc.walking.c.PARENT_VIEW);
    }

    private void f(String str, View view, JSONObject jSONObject) {
        d.d.a.a.a.f.a b2 = this.c.b();
        String b3 = this.f5325d.b(str);
        if (b3 != null) {
            JSONObject a2 = b2.a(view);
            d.d.a.a.a.g.b.f(a2, str);
            d.d.a.a.a.g.b.k(a2, b3);
            d.d.a.a.a.g.b.h(jSONObject, a2);
        }
    }

    private boolean g(View view, JSONObject jSONObject) {
        String a2 = this.f5325d.a(view);
        if (a2 != null) {
            d.d.a.a.a.g.b.f(jSONObject, a2);
            this.f5325d.m();
            return true;
        }
        return false;
    }

    public static TreeWalker getInstance() {
        return f5320g;
    }

    private void i(View view, JSONObject jSONObject) {
        a.C0203a g2 = this.f5325d.g(view);
        if (g2 != null) {
            d.d.a.a.a.g.b.e(jSONObject, g2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        q();
        l();
        r();
    }

    private void q() {
        this.b = 0;
        this.f5327f = d.d.a.a.a.g.d.a();
    }

    private void r() {
        d(d.d.a.a.a.g.d.a() - this.f5327f);
    }

    private void s() {
        if (f5322i == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f5322i = handler;
            handler.post(f5323j);
            f5322i.postDelayed(f5324k, 200L);
        }
    }

    private void t() {
        Handler handler = f5322i;
        if (handler != null) {
            handler.removeCallbacks(f5324k);
            f5322i = null;
        }
    }

    @Override // d.d.a.a.a.f.a.InterfaceC0294a
    public void a(View view, d.d.a.a.a.f.a aVar, JSONObject jSONObject) {
        com.iab.omid.library.ironsrc.walking.c i2;
        if (f.d(view) && (i2 = this.f5325d.i(view)) != com.iab.omid.library.ironsrc.walking.c.UNDERLYING_VIEW) {
            JSONObject a2 = aVar.a(view);
            d.d.a.a.a.g.b.h(jSONObject, a2);
            if (!g(view, a2)) {
                i(view, a2);
                e(view, aVar, a2, i2);
            }
            this.b++;
        }
    }

    public void c() {
        s();
    }

    public void h() {
        k();
        this.a.clear();
        f5321h.post(new a());
    }

    public void k() {
        t();
    }

    @VisibleForTesting
    void l() {
        this.f5325d.j();
        long a2 = d.d.a.a.a.g.d.a();
        d.d.a.a.a.f.a a3 = this.c.a();
        if (this.f5325d.h().size() > 0) {
            Iterator<String> it = this.f5325d.h().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject a4 = a3.a(null);
                f(next, this.f5325d.f(next), a4);
                d.d.a.a.a.g.b.d(a4);
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(next);
                this.f5326e.c(a4, hashSet, a2);
            }
        }
        if (this.f5325d.c().size() > 0) {
            JSONObject a5 = a3.a(null);
            e(null, a3, a5, com.iab.omid.library.ironsrc.walking.c.PARENT_VIEW);
            d.d.a.a.a.g.b.d(a5);
            this.f5326e.b(a5, this.f5325d.c(), a2);
        } else {
            this.f5326e.a();
        }
        this.f5325d.l();
    }
}
