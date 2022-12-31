package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.a.b.f;
import com.bytedance.sdk.a.b.a.e.o;
import com.bytedance.sdk.a.b.ac;
import com.bytedance.sdk.a.b.j;
import com.bytedance.sdk.a.b.p;
import com.bytedance.sdk.a.b.t;
import com.bytedance.sdk.a.b.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
/* compiled from: StreamAllocation.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ boolean f900d = true;
    public final com.bytedance.sdk.a.b.a a;
    public final com.bytedance.sdk.a.b.e b;
    public final p c;

    /* renamed from: e  reason: collision with root package name */
    private f.a f901e;

    /* renamed from: f  reason: collision with root package name */
    private ac f902f;

    /* renamed from: g  reason: collision with root package name */
    private final j f903g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f904h;

    /* renamed from: i  reason: collision with root package name */
    private final f f905i;

    /* renamed from: j  reason: collision with root package name */
    private int f906j;

    /* renamed from: k  reason: collision with root package name */
    private c f907k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f908l;
    private boolean m;
    private boolean n;
    private com.bytedance.sdk.a.b.a.c.c o;

    /* compiled from: StreamAllocation.java */
    /* loaded from: classes.dex */
    public static final class a extends WeakReference<g> {
        public final Object a;

        a(g gVar, Object obj) {
            super(gVar);
            this.a = obj;
        }
    }

    public g(j jVar, com.bytedance.sdk.a.b.a aVar, com.bytedance.sdk.a.b.e eVar, p pVar, Object obj) {
        this.f903g = jVar;
        this.a = aVar;
        this.b = eVar;
        this.c = pVar;
        this.f905i = new f(aVar, g(), eVar, pVar);
        this.f904h = obj;
    }

    private Socket f() {
        if (f900d || Thread.holdsLock(this.f903g)) {
            c cVar = this.f907k;
            if (cVar == null || !cVar.a) {
                return null;
            }
            return a(false, false, true);
        }
        throw new AssertionError();
    }

    private d g() {
        return com.bytedance.sdk.a.b.a.a.a.a(this.f903g);
    }

    public com.bytedance.sdk.a.b.a.c.c a(v vVar, t.a aVar, boolean z) {
        try {
            com.bytedance.sdk.a.b.a.c.c a2 = a(aVar.b(), aVar.c(), aVar.d(), vVar.r(), z).a(vVar, aVar, this);
            synchronized (this.f903g) {
                this.o = a2;
            }
            return a2;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public synchronized c b() {
        return this.f907k;
    }

    public void c() {
        c cVar;
        Socket a2;
        synchronized (this.f903g) {
            cVar = this.f907k;
            a2 = a(false, true, false);
            if (this.f907k != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(a2);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
    }

    public void d() {
        c cVar;
        Socket a2;
        synchronized (this.f903g) {
            cVar = this.f907k;
            a2 = a(true, false, false);
            if (this.f907k != null) {
                cVar = null;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(a2);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
    }

    public boolean e() {
        f.a aVar;
        return this.f902f != null || ((aVar = this.f901e) != null && aVar.a()) || this.f905i.a();
    }

    public String toString() {
        c b = b();
        return b != null ? b.toString() : this.a.toString();
    }

    private void b(c cVar) {
        int size = cVar.f887d.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cVar.f887d.get(i2).get() == this) {
                cVar.f887d.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private c a(int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            c a2 = a(i2, i3, i4, z);
            synchronized (this.f903g) {
                if (a2.b == 0) {
                    return a2;
                }
                if (a2.a(z2)) {
                    return a2;
                }
                d();
            }
        }
    }

    private c a(int i2, int i3, int i4, boolean z) throws IOException {
        c cVar;
        Socket f2;
        c cVar2;
        Socket socket;
        ac acVar;
        boolean z2;
        boolean z3;
        f.a aVar;
        synchronized (this.f903g) {
            if (!this.m) {
                if (this.o == null) {
                    if (!this.n) {
                        cVar = this.f907k;
                        f2 = f();
                        cVar2 = this.f907k;
                        socket = null;
                        if (cVar2 != null) {
                            cVar = null;
                        } else {
                            cVar2 = null;
                        }
                        if (!this.f908l) {
                            cVar = null;
                        }
                        if (cVar2 == null) {
                            com.bytedance.sdk.a.b.a.a.a.a(this.f903g, this.a, this, null);
                            c cVar3 = this.f907k;
                            if (cVar3 != null) {
                                cVar2 = cVar3;
                                z2 = true;
                                acVar = null;
                            } else {
                                acVar = this.f902f;
                            }
                        } else {
                            acVar = null;
                        }
                        z2 = false;
                    } else {
                        throw new IOException("Canceled");
                    }
                } else {
                    throw new IllegalStateException("codec != null");
                }
            } else {
                throw new IllegalStateException("released");
            }
        }
        com.bytedance.sdk.a.b.a.c.a(f2);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
        if (z2) {
            this.c.a(this.b, cVar2);
        }
        if (cVar2 != null) {
            return cVar2;
        }
        if (acVar != null || ((aVar = this.f901e) != null && aVar.a())) {
            z3 = false;
        } else {
            this.f901e = this.f905i.b();
            z3 = true;
        }
        synchronized (this.f903g) {
            if (this.n) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<ac> c = this.f901e.c();
                int size = c.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    ac acVar2 = c.get(i5);
                    com.bytedance.sdk.a.b.a.a.a.a(this.f903g, this.a, this, acVar2);
                    c cVar4 = this.f907k;
                    if (cVar4 != null) {
                        this.f902f = acVar2;
                        cVar2 = cVar4;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (acVar == null) {
                    acVar = this.f901e.b();
                }
                this.f902f = acVar;
                this.f906j = 0;
                cVar2 = new c(this.f903g, acVar);
                a(cVar2, false);
            }
        }
        if (z2) {
            this.c.a(this.b, cVar2);
            return cVar2;
        }
        cVar2.a(i2, i3, i4, z, this.b, this.c);
        g().b(cVar2.a());
        synchronized (this.f903g) {
            this.f908l = true;
            com.bytedance.sdk.a.b.a.a.a.b(this.f903g, cVar2);
            if (cVar2.d()) {
                socket = com.bytedance.sdk.a.b.a.a.a.a(this.f903g, this.a, this);
                cVar2 = this.f907k;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(socket);
        this.c.a(this.b, cVar2);
        return cVar2;
    }

    public void a(boolean z, com.bytedance.sdk.a.b.a.c.c cVar, long j2, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        this.c.b(this.b, j2);
        synchronized (this.f903g) {
            if (cVar != null) {
                if (cVar == this.o) {
                    if (!z) {
                        this.f907k.b++;
                    }
                    cVar2 = this.f907k;
                    a2 = a(z, false, true);
                    if (this.f907k != null) {
                        cVar2 = null;
                    }
                    z2 = this.m;
                }
            }
            throw new IllegalStateException("expected " + this.o + " but was " + cVar);
        }
        com.bytedance.sdk.a.b.a.c.a(a2);
        if (cVar2 != null) {
            this.c.b(this.b, cVar2);
        }
        if (iOException != null) {
            this.c.a(this.b, iOException);
        } else if (z2) {
            this.c.g(this.b);
        }
    }

    public com.bytedance.sdk.a.b.a.c.c a() {
        com.bytedance.sdk.a.b.a.c.c cVar;
        synchronized (this.f903g) {
            cVar = this.o;
        }
        return cVar;
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (f900d || Thread.holdsLock(this.f903g)) {
            if (z3) {
                this.o = null;
            }
            if (z2) {
                this.m = true;
            }
            c cVar = this.f907k;
            if (cVar != null) {
                if (z) {
                    cVar.a = true;
                }
                if (this.o == null) {
                    if (this.m || cVar.a) {
                        b(cVar);
                        if (this.f907k.f887d.isEmpty()) {
                            this.f907k.f888e = System.nanoTime();
                            if (com.bytedance.sdk.a.b.a.a.a.a(this.f903g, this.f907k)) {
                                socket = this.f907k.b();
                                this.f907k = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.f907k = null;
                        return socket;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        throw new AssertionError();
    }

    public void a(IOException iOException) {
        c cVar;
        boolean z;
        Socket a2;
        synchronized (this.f903g) {
            cVar = null;
            if (iOException instanceof o) {
                com.bytedance.sdk.a.b.a.e.b bVar = ((o) iOException).a;
                com.bytedance.sdk.a.b.a.e.b bVar2 = com.bytedance.sdk.a.b.a.e.b.REFUSED_STREAM;
                if (bVar == bVar2) {
                    this.f906j++;
                }
                if (bVar != bVar2 || this.f906j > 1) {
                    this.f902f = null;
                    z = true;
                }
                z = false;
            } else {
                c cVar2 = this.f907k;
                if (cVar2 != null && (!cVar2.d() || (iOException instanceof com.bytedance.sdk.a.b.a.e.a))) {
                    if (this.f907k.b == 0) {
                        ac acVar = this.f902f;
                        if (acVar != null && iOException != null) {
                            this.f905i.a(acVar, iOException);
                        }
                        this.f902f = null;
                    }
                    z = true;
                }
                z = false;
            }
            c cVar3 = this.f907k;
            a2 = a(z, false, true);
            if (this.f907k == null && this.f908l) {
                cVar = cVar3;
            }
        }
        com.bytedance.sdk.a.b.a.c.a(a2);
        if (cVar != null) {
            this.c.b(this.b, cVar);
        }
    }

    public void a(c cVar, boolean z) {
        if (!f900d && !Thread.holdsLock(this.f903g)) {
            throw new AssertionError();
        }
        if (this.f907k == null) {
            this.f907k = cVar;
            this.f908l = z;
            cVar.f887d.add(new a(this, this.f904h));
            return;
        }
        throw new IllegalStateException();
    }

    public Socket a(c cVar) {
        if (f900d || Thread.holdsLock(this.f903g)) {
            if (this.o == null && this.f907k.f887d.size() == 1) {
                Socket a2 = a(true, false, false);
                this.f907k = cVar;
                cVar.f887d.add(this.f907k.f887d.get(0));
                return a2;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }
}
