package com.iab.omid.library.ironsrc.walking;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    private final HashMap<View, String> a = new HashMap<>();
    private final HashMap<View, C0203a> b = new HashMap<>();
    private final HashMap<String, View> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<View> f5328d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashSet<String> f5329e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashSet<String> f5330f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, String> f5331g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private boolean f5332h;

    /* renamed from: com.iab.omid.library.ironsrc.walking.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0203a {
        private final d.d.a.a.a.d.c a;
        private final ArrayList<String> b = new ArrayList<>();

        public C0203a(d.d.a.a.a.d.c cVar, String str) {
            this.a = cVar;
            b(str);
        }

        public d.d.a.a.a.d.c a() {
            return this.a;
        }

        public void b(String str) {
            this.b.add(str);
        }

        public ArrayList<String> c() {
            return this.b;
        }
    }

    /* loaded from: classes2.dex */
    public abstract class b extends c {
        protected final HashSet<String> c;

        /* renamed from: d  reason: collision with root package name */
        protected final JSONObject f5333d;

        /* renamed from: e  reason: collision with root package name */
        protected final long f5334e;

        public b(c.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
            super(bVar);
            this.c = new HashSet<>(hashSet);
            this.f5333d = jSONObject;
            this.f5334e = j2;
        }
    }

    /* loaded from: classes2.dex */
    public abstract class c extends AsyncTask<Object, Void, String> {
        private InterfaceC0204a a;
        protected final b b;

        /* renamed from: com.iab.omid.library.ironsrc.walking.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public interface InterfaceC0204a {
            void a(c cVar);
        }

        /* loaded from: classes2.dex */
        public interface b {
            void a(JSONObject jSONObject);

            JSONObject b();
        }

        public c(b bVar) {
            this.b = bVar;
        }

        public void a(InterfaceC0204a interfaceC0204a) {
            this.a = interfaceC0204a;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            InterfaceC0204a interfaceC0204a = this.a;
            if (interfaceC0204a != null) {
                interfaceC0204a.a(this);
            }
        }

        public void c(ThreadPoolExecutor threadPoolExecutor) {
            executeOnExecutor(threadPoolExecutor, new Object[0]);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.InterfaceC0204a {
        private final BlockingQueue<Runnable> a;
        private final ThreadPoolExecutor b;
        private final ArrayDeque<c> c = new ArrayDeque<>();

        /* renamed from: d  reason: collision with root package name */
        private c f5335d = null;

        public d() {
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            this.a = linkedBlockingQueue;
            this.b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
        }

        private void b() {
            c poll = this.c.poll();
            this.f5335d = poll;
            if (poll != null) {
                poll.c(this.b);
            }
        }

        @Override // com.iab.omid.library.ironsrc.walking.a.c.InterfaceC0204a
        public void a(c cVar) {
            this.f5335d = null;
            b();
        }

        public void c(c cVar) {
            cVar.a(this);
            this.c.add(cVar);
            if (this.f5335d == null) {
                b();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends c {
        public e(c.b bVar) {
            super(bVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public String doInBackground(Object... objArr) {
            this.b.a(null);
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public class f extends b {
        public f(c.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
            super(bVar, hashSet, jSONObject, j2);
        }

        private void e(String str) {
            d.d.a.a.a.d.a a = d.d.a.a.a.d.a.a();
            if (a != null) {
                for (com.iab.omid.library.ironsrc.adsession.g gVar : a.c()) {
                    if (this.c.contains(gVar.n())) {
                        gVar.o().k(str, this.f5334e);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.iab.omid.library.ironsrc.walking.a.c, android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            e(str);
            super.onPostExecute(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public String doInBackground(Object... objArr) {
            return this.f5333d.toString();
        }
    }

    /* loaded from: classes2.dex */
    public class g extends b {
        public g(c.b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j2) {
            super(bVar, hashSet, jSONObject, j2);
        }

        private void e(String str) {
            d.d.a.a.a.d.a a = d.d.a.a.a.d.a.a();
            if (a != null) {
                for (com.iab.omid.library.ironsrc.adsession.g gVar : a.c()) {
                    if (this.c.contains(gVar.n())) {
                        gVar.o().h(str, this.f5334e);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.iab.omid.library.ironsrc.walking.a.c, android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            if (!TextUtils.isEmpty(str)) {
                e(str);
            }
            super.onPostExecute(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public String doInBackground(Object... objArr) {
            if (d.d.a.a.a.g.b.l(this.f5333d, this.b.b())) {
                return null;
            }
            this.b.a(this.f5333d);
            return this.f5333d.toString();
        }
    }

    private void d(com.iab.omid.library.ironsrc.adsession.g gVar) {
        for (d.d.a.a.a.d.c cVar : gVar.e()) {
            e(cVar, gVar);
        }
    }

    private void e(d.d.a.a.a.d.c cVar, com.iab.omid.library.ironsrc.adsession.g gVar) {
        View view = cVar.a().get();
        if (view == null) {
            return;
        }
        C0203a c0203a = this.b.get(view);
        if (c0203a != null) {
            c0203a.b(gVar.n());
        } else {
            this.b.put(view, new C0203a(cVar, gVar.n()));
        }
    }

    private String k(View view) {
        if (view.hasWindowFocus()) {
            HashSet hashSet = new HashSet();
            while (view != null) {
                String e2 = d.d.a.a.a.g.f.e(view);
                if (e2 != null) {
                    return e2;
                }
                hashSet.add(view);
                ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            this.f5328d.addAll(hashSet);
            return null;
        }
        return "noWindowFocus";
    }

    public String a(View view) {
        if (this.a.size() == 0) {
            return null;
        }
        String str = this.a.get(view);
        if (str != null) {
            this.a.remove(view);
        }
        return str;
    }

    public String b(String str) {
        return this.f5331g.get(str);
    }

    public HashSet<String> c() {
        return this.f5329e;
    }

    public View f(String str) {
        return this.c.get(str);
    }

    public C0203a g(View view) {
        C0203a c0203a = this.b.get(view);
        if (c0203a != null) {
            this.b.remove(view);
        }
        return c0203a;
    }

    public HashSet<String> h() {
        return this.f5330f;
    }

    public com.iab.omid.library.ironsrc.walking.c i(View view) {
        return this.f5328d.contains(view) ? com.iab.omid.library.ironsrc.walking.c.PARENT_VIEW : this.f5332h ? com.iab.omid.library.ironsrc.walking.c.OBSTRUCTION_VIEW : com.iab.omid.library.ironsrc.walking.c.UNDERLYING_VIEW;
    }

    public void j() {
        d.d.a.a.a.d.a a = d.d.a.a.a.d.a.a();
        if (a != null) {
            for (com.iab.omid.library.ironsrc.adsession.g gVar : a.e()) {
                View i2 = gVar.i();
                if (gVar.k()) {
                    String n = gVar.n();
                    if (i2 != null) {
                        String k2 = k(i2);
                        if (k2 == null) {
                            this.f5329e.add(n);
                            this.a.put(i2, n);
                            d(gVar);
                        } else {
                            this.f5330f.add(n);
                            this.c.put(n, i2);
                            this.f5331g.put(n, k2);
                        }
                    } else {
                        this.f5330f.add(n);
                        this.f5331g.put(n, "noAdView");
                    }
                }
            }
        }
    }

    public void l() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.f5328d.clear();
        this.f5329e.clear();
        this.f5330f.clear();
        this.f5331g.clear();
        this.f5332h = false;
    }

    public void m() {
        this.f5332h = true;
    }
}
