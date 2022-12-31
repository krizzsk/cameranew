package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.imagepipeline.producers.c1;
import com.facebook.imagepipeline.producers.j0;
import com.facebook.imagepipeline.producers.n0;
import com.facebook.imagepipeline.producers.q;
import com.facebook.imagepipeline.producers.r;
import com.facebook.imagepipeline.producers.t;
import com.facebook.imagepipeline.producers.y0;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ProducerSequenceFactory.java */
/* loaded from: classes.dex */
public class o {
    @Nullable
    @VisibleForTesting
    n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> A;
    @Nullable
    @VisibleForTesting
    n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> B;
    @VisibleForTesting
    Map<n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>>, n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>>> C = new HashMap();
    @VisibleForTesting
    Map<n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>>, n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>>> D;
    private final ContentResolver a;
    private final n b;
    private final j0 c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2786d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f2787e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2788f;

    /* renamed from: g  reason: collision with root package name */
    private final y0 f2789g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f2790h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f2791i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f2792j;

    /* renamed from: k  reason: collision with root package name */
    private final com.facebook.imagepipeline.g.d f2793k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f2794l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    @Nullable
    @VisibleForTesting
    n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> p;
    @Nullable
    @VisibleForTesting
    n0<com.facebook.imagepipeline.image.e> q;
    @Nullable
    @VisibleForTesting
    n0<com.facebook.imagepipeline.image.e> r;
    @Nullable
    @VisibleForTesting
    n0<Void> s;
    @Nullable
    @VisibleForTesting
    n0<Void> t;
    @Nullable
    private n0<com.facebook.imagepipeline.image.e> u;
    @Nullable
    @VisibleForTesting
    n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> v;
    @Nullable
    @VisibleForTesting
    n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> w;
    @Nullable
    @VisibleForTesting
    n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> x;
    @Nullable
    @VisibleForTesting
    n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> y;
    @Nullable
    @VisibleForTesting
    n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> z;

    public o(ContentResolver contentResolver, n nVar, j0 j0Var, boolean z, boolean z2, y0 y0Var, boolean z3, boolean z4, boolean z5, boolean z6, com.facebook.imagepipeline.g.d dVar, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.a = contentResolver;
        this.b = nVar;
        this.c = j0Var;
        this.f2786d = z;
        this.f2787e = z2;
        this.n = z9;
        new HashMap();
        this.D = new HashMap();
        this.f2789g = y0Var;
        this.f2790h = z3;
        this.f2791i = z4;
        this.f2788f = z5;
        this.f2792j = z6;
        this.f2793k = dVar;
        this.f2794l = z7;
        this.m = z8;
        this.o = z10;
    }

    private n0<com.facebook.imagepipeline.image.e> A(c1<com.facebook.imagepipeline.image.e>[] c1VarArr) {
        return this.b.D(this.b.G(c1VarArr), true, this.f2793k);
    }

    private n0<com.facebook.imagepipeline.image.e> B(n0<com.facebook.imagepipeline.image.e> n0Var, c1<com.facebook.imagepipeline.image.e>[] c1VarArr) {
        return n.h(A(c1VarArr), this.b.F(this.b.D(n.a(n0Var), true, this.f2793k)));
    }

    private static void C(ImageRequest imageRequest) {
        com.facebook.common.internal.h.g(imageRequest);
        com.facebook.common.internal.h.b(Boolean.valueOf(imageRequest.h().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()));
    }

    private synchronized n0<com.facebook.imagepipeline.image.e> a() {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence");
        }
        if (this.q == null) {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getBackgroundLocalFileFetchToEncodeMemorySequence:init");
            }
            this.q = this.b.b(z(this.b.v()), this.f2789g);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return this.q;
    }

    private synchronized n0<com.facebook.imagepipeline.image.e> b() {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence");
        }
        if (this.r == null) {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getBackgroundNetworkFetchToEncodedMemorySequence:init");
            }
            this.r = this.b.b(e(), this.f2789g);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return this.r;
    }

    private n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> c(ImageRequest imageRequest) {
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getBasicDecodedImageSequence");
            }
            com.facebook.common.internal.h.g(imageRequest);
            Uri s = imageRequest.s();
            com.facebook.common.internal.h.h(s, "Uri is null.");
            int t = imageRequest.t();
            if (t != 0) {
                switch (t) {
                    case 2:
                        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> o = o();
                        if (com.facebook.imagepipeline.f.b.d()) {
                            com.facebook.imagepipeline.f.b.b();
                        }
                        return o;
                    case 3:
                        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> m = m();
                        if (com.facebook.imagepipeline.f.b.d()) {
                            com.facebook.imagepipeline.f.b.b();
                        }
                        return m;
                    case 4:
                        if (com.facebook.common.a.a.c(this.a.getType(s))) {
                            n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> o2 = o();
                            if (com.facebook.imagepipeline.f.b.d()) {
                                com.facebook.imagepipeline.f.b.b();
                            }
                            return o2;
                        }
                        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> k2 = k();
                        if (com.facebook.imagepipeline.f.b.d()) {
                            com.facebook.imagepipeline.f.b.b();
                        }
                        return k2;
                    case 5:
                        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> j2 = j();
                        if (com.facebook.imagepipeline.f.b.d()) {
                            com.facebook.imagepipeline.f.b.b();
                        }
                        return j2;
                    case 6:
                        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n = n();
                        if (com.facebook.imagepipeline.f.b.d()) {
                            com.facebook.imagepipeline.f.b.b();
                        }
                        return n;
                    case 7:
                        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> f2 = f();
                        if (com.facebook.imagepipeline.f.b.d()) {
                            com.facebook.imagepipeline.f.b.b();
                        }
                        return f2;
                    case 8:
                        return s();
                    default:
                        throw new IllegalArgumentException("Unsupported uri scheme! Uri is: " + t(s));
                }
            }
            n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> p = p();
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
            return p;
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> d(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var2;
        n0Var2 = this.D.get(n0Var);
        if (n0Var2 == null) {
            n0Var2 = this.b.f(n0Var);
            this.D.put(n0Var, n0Var2);
        }
        return n0Var2;
    }

    private synchronized n0<com.facebook.imagepipeline.image.e> e() {
        n0<com.facebook.imagepipeline.image.e> z;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence");
        }
        if (this.u == null) {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getCommonNetworkFetchToEncodedMemorySequence:init");
            }
            if (this.n) {
                z = this.b.i(this.c);
            } else {
                z = z(this.b.y(this.c));
            }
            com.facebook.common.internal.h.g(z);
            com.facebook.imagepipeline.producers.a a = n.a(z);
            this.u = a;
            this.u = this.b.D(a, this.f2786d && !this.f2790h, this.f2793k);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return this.u;
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> f() {
        if (this.A == null) {
            n0<com.facebook.imagepipeline.image.e> j2 = this.b.j();
            if (com.facebook.common.c.c.a && (!this.f2787e || com.facebook.common.c.c.c == null)) {
                j2 = this.b.H(j2);
            }
            this.A = v(this.b.D(n.a(j2), true, this.f2793k));
        }
        return this.A;
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> h(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        return this.b.l(n0Var);
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> j() {
        if (this.z == null) {
            this.z = w(this.b.r());
        }
        return this.z;
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> k() {
        if (this.x == null) {
            this.x = x(this.b.s(), new c1[]{this.b.t(), this.b.u()});
        }
        return this.x;
    }

    private synchronized n0<Void> l() {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence");
        }
        if (this.s == null) {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getLocalFileFetchToEncodedMemoryPrefetchSequence:init");
            }
            this.s = this.b.E(a());
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return this.s;
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> m() {
        if (this.v == null) {
            this.v = w(this.b.v());
        }
        return this.v;
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n() {
        if (this.y == null) {
            this.y = w(this.b.w());
        }
        return this.y;
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> o() {
        if (this.w == null) {
            this.w = u(this.b.x());
        }
        return this.w;
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> p() {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getNetworkFetchSequence");
        }
        if (this.p == null) {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getNetworkFetchSequence:init");
            }
            this.p = v(e());
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return this.p;
    }

    private synchronized n0<Void> q() {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence");
        }
        if (this.t == null) {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getNetworkFetchToEncodedMemoryPrefetchSequence:init");
            }
            this.t = this.b.E(b());
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return this.t;
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> r(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var2;
        n0Var2 = this.C.get(n0Var);
        if (n0Var2 == null) {
            n0Var2 = this.b.A(this.b.B(n0Var));
            this.C.put(n0Var, n0Var2);
        }
        return n0Var2;
    }

    private synchronized n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> s() {
        if (this.B == null) {
            this.B = w(this.b.C());
        }
        return this.B;
    }

    private static String t(Uri uri) {
        String valueOf = String.valueOf(uri);
        if (valueOf.length() > 30) {
            return valueOf.substring(0, 30) + "...";
        }
        return valueOf;
    }

    private n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> u(n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> n0Var) {
        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> b = this.b.b(this.b.d(this.b.e(n0Var)), this.f2789g);
        if (!this.f2794l && !this.m) {
            return this.b.c(b);
        }
        return this.b.g(this.b.c(b));
    }

    private n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> v(n0<com.facebook.imagepipeline.image.e> n0Var) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#newBitmapCacheGetToDecodeSequence");
        }
        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> u = u(this.b.k(n0Var));
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return u;
    }

    private n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> w(n0<com.facebook.imagepipeline.image.e> n0Var) {
        return x(n0Var, new c1[]{this.b.u()});
    }

    private n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> x(n0<com.facebook.imagepipeline.image.e> n0Var, c1<com.facebook.imagepipeline.image.e>[] c1VarArr) {
        return v(B(z(n0Var), c1VarArr));
    }

    private n0<com.facebook.imagepipeline.image.e> y(n0<com.facebook.imagepipeline.image.e> n0Var) {
        r n;
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#newDiskCacheSequence");
        }
        if (this.f2788f) {
            n = this.b.n(this.b.z(n0Var));
        } else {
            n = this.b.n(n0Var);
        }
        q m = this.b.m(n);
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return m;
    }

    private n0<com.facebook.imagepipeline.image.e> z(n0<com.facebook.imagepipeline.image.e> n0Var) {
        if (com.facebook.common.c.c.a && (!this.f2787e || com.facebook.common.c.c.c == null)) {
            n0Var = this.b.H(n0Var);
        }
        if (this.f2792j) {
            n0Var = y(n0Var);
        }
        t p = this.b.p(n0Var);
        if (this.m) {
            return this.b.o(this.b.q(p));
        }
        return this.b.o(p);
    }

    public n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> g(ImageRequest imageRequest) {
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.a("ProducerSequenceFactory#getDecodedImageProducerSequence");
        }
        n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> c = c(imageRequest);
        if (imageRequest.i() != null) {
            c = r(c);
        }
        if (this.f2791i) {
            c = d(c);
        }
        if (this.o && imageRequest.e() > 0) {
            c = h(c);
        }
        if (com.facebook.imagepipeline.f.b.d()) {
            com.facebook.imagepipeline.f.b.b();
        }
        return c;
    }

    public n0<Void> i(ImageRequest imageRequest) {
        C(imageRequest);
        int t = imageRequest.t();
        if (t != 0) {
            if (t != 2 && t != 3) {
                Uri s = imageRequest.s();
                throw new IllegalArgumentException("Unsupported uri scheme for encoded image fetch! Uri is: " + t(s));
            }
            return l();
        }
        return q();
    }
}
