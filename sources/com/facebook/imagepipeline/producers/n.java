package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.imagepipeline.producers.JobScheduler;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: DecodeProducer.java */
/* loaded from: classes.dex */
public class n implements n0<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
    private final com.facebook.common.memory.a a;
    private final Executor b;
    private final com.facebook.imagepipeline.decoder.b c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.imagepipeline.decoder.d f2948d;

    /* renamed from: e  reason: collision with root package name */
    private final n0<com.facebook.imagepipeline.image.e> f2949e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2950f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f2951g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f2952h;

    /* renamed from: i  reason: collision with root package name */
    private final int f2953i;

    /* renamed from: j  reason: collision with root package name */
    private final com.facebook.imagepipeline.core.a f2954j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f2955k;

    /* renamed from: l  reason: collision with root package name */
    private final com.facebook.common.internal.k<Boolean> f2956l;

    /* compiled from: DecodeProducer.java */
    /* loaded from: classes.dex */
    private class a extends c {
        public a(n nVar, l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var, boolean z, int i2) {
            super(lVar, o0Var, z, i2);
        }

        @Override // com.facebook.imagepipeline.producers.n.c
        protected synchronized boolean H(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            if (com.facebook.imagepipeline.producers.b.e(i2)) {
                return false;
            }
            return super.H(eVar, i2);
        }

        @Override // com.facebook.imagepipeline.producers.n.c
        protected int w(com.facebook.imagepipeline.image.e eVar) {
            return eVar.S();
        }

        @Override // com.facebook.imagepipeline.producers.n.c
        protected com.facebook.imagepipeline.image.i x() {
            return com.facebook.imagepipeline.image.h.d(0, false, false);
        }
    }

    /* compiled from: DecodeProducer.java */
    /* loaded from: classes.dex */
    private class b extends c {

        /* renamed from: i  reason: collision with root package name */
        private final com.facebook.imagepipeline.decoder.e f2957i;

        /* renamed from: j  reason: collision with root package name */
        private final com.facebook.imagepipeline.decoder.d f2958j;

        /* renamed from: k  reason: collision with root package name */
        private int f2959k;

        public b(n nVar, l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var, com.facebook.imagepipeline.decoder.e eVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, int i2) {
            super(lVar, o0Var, z, i2);
            com.facebook.common.internal.h.g(eVar);
            this.f2957i = eVar;
            com.facebook.common.internal.h.g(dVar);
            this.f2958j = dVar;
            this.f2959k = 0;
        }

        @Override // com.facebook.imagepipeline.producers.n.c
        protected synchronized boolean H(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            boolean H = super.H(eVar, i2);
            if ((com.facebook.imagepipeline.producers.b.e(i2) || com.facebook.imagepipeline.producers.b.m(i2, 8)) && !com.facebook.imagepipeline.producers.b.m(i2, 4) && com.facebook.imagepipeline.image.e.Z(eVar) && eVar.A() == com.facebook.imageformat.b.a) {
                if (!this.f2957i.g(eVar)) {
                    return false;
                }
                int d2 = this.f2957i.d();
                int i3 = this.f2959k;
                if (d2 <= i3) {
                    return false;
                }
                if (d2 < this.f2958j.a(i3) && !this.f2957i.e()) {
                    return false;
                }
                this.f2959k = d2;
            }
            return H;
        }

        @Override // com.facebook.imagepipeline.producers.n.c
        protected int w(com.facebook.imagepipeline.image.e eVar) {
            return this.f2957i.c();
        }

        @Override // com.facebook.imagepipeline.producers.n.c
        protected com.facebook.imagepipeline.image.i x() {
            return this.f2958j.b(this.f2957i.d());
        }
    }

    /* compiled from: DecodeProducer.java */
    /* loaded from: classes.dex */
    private abstract class c extends p<com.facebook.imagepipeline.image.e, com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> {
        private final o0 c;

        /* renamed from: d  reason: collision with root package name */
        private final q0 f2960d;

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.imagepipeline.common.b f2961e;
        @GuardedBy("this")

        /* renamed from: f  reason: collision with root package name */
        private boolean f2962f;

        /* renamed from: g  reason: collision with root package name */
        private final JobScheduler f2963g;

        /* compiled from: DecodeProducer.java */
        /* loaded from: classes.dex */
        class a implements JobScheduler.d {
            final /* synthetic */ o0 a;
            final /* synthetic */ int b;

            a(n nVar, o0 o0Var, int i2) {
                this.a = o0Var;
                this.b = i2;
            }

            @Override // com.facebook.imagepipeline.producers.JobScheduler.d
            public void a(com.facebook.imagepipeline.image.e eVar, int i2) {
                if (eVar != null) {
                    c.this.c.b("image_format", eVar.A().a());
                    if (n.this.f2950f || !com.facebook.imagepipeline.producers.b.m(i2, 16)) {
                        ImageRequest j2 = this.a.j();
                        if (n.this.f2951g || !com.facebook.common.util.d.m(j2.s())) {
                            eVar.j0(com.facebook.imagepipeline.g.a.b(j2.q(), j2.o(), eVar, this.b));
                        }
                    }
                    if (this.a.d().D().z()) {
                        c.this.E(eVar);
                    }
                    c.this.u(eVar, i2);
                }
            }
        }

        /* compiled from: DecodeProducer.java */
        /* loaded from: classes.dex */
        class b extends e {
            final /* synthetic */ boolean a;

            b(n nVar, boolean z) {
                this.a = z;
            }

            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.p0
            public void a() {
                if (c.this.c.i()) {
                    c.this.f2963g.h();
                }
            }

            @Override // com.facebook.imagepipeline.producers.p0
            public void b() {
                if (this.a) {
                    c.this.y();
                }
            }
        }

        public c(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var, boolean z, int i2) {
            super(lVar);
            this.c = o0Var;
            this.f2960d = o0Var.h();
            com.facebook.imagepipeline.common.b f2 = o0Var.j().f();
            this.f2961e = f2;
            this.f2962f = false;
            this.f2963g = new JobScheduler(n.this.b, new a(n.this, o0Var, i2), f2.a);
            o0Var.c(new b(n.this, z));
        }

        private void A(com.facebook.imagepipeline.image.c cVar, int i2) {
            com.facebook.common.references.a<com.facebook.imagepipeline.image.c> b2 = n.this.f2954j.b(cVar);
            try {
                D(com.facebook.imagepipeline.producers.b.d(i2));
                o().c(b2, i2);
            } finally {
                com.facebook.common.references.a.y(b2);
            }
        }

        private com.facebook.imagepipeline.image.c B(com.facebook.imagepipeline.image.e eVar, int i2, com.facebook.imagepipeline.image.i iVar) {
            boolean z = n.this.f2955k != null && ((Boolean) n.this.f2956l.get()).booleanValue();
            try {
                return n.this.c.a(eVar, i2, iVar, this.f2961e);
            } catch (OutOfMemoryError e2) {
                if (z) {
                    n.this.f2955k.run();
                    System.gc();
                    return n.this.c.a(eVar, i2, iVar, this.f2961e);
                }
                throw e2;
            }
        }

        private synchronized boolean C() {
            return this.f2962f;
        }

        private void D(boolean z) {
            synchronized (this) {
                if (z) {
                    if (!this.f2962f) {
                        o().b(1.0f);
                        this.f2962f = true;
                        this.f2963g.c();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E(com.facebook.imagepipeline.image.e eVar) {
            if (eVar.A() != com.facebook.imageformat.b.a) {
                return;
            }
            eVar.j0(com.facebook.imagepipeline.g.a.c(eVar, com.facebook.imageutils.a.c(this.f2961e.f2703g), 104857600));
        }

        private void G(com.facebook.imagepipeline.image.e eVar, com.facebook.imagepipeline.image.c cVar) {
            this.c.b("encoded_width", Integer.valueOf(eVar.T()));
            this.c.b("encoded_height", Integer.valueOf(eVar.z()));
            this.c.b("encoded_size", Integer.valueOf(eVar.S()));
            if (cVar instanceof com.facebook.imagepipeline.image.b) {
                Bitmap y = ((com.facebook.imagepipeline.image.b) cVar).y();
                this.c.b("bitmap_config", String.valueOf(y == null ? null : y.getConfig()));
            }
            if (cVar != null) {
                cVar.x(this.c.getExtras());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(8:22|23|(9:(13:27|(11:31|32|33|34|36|37|(1:39)|40|41|42|43)|58|32|33|34|36|37|(0)|40|41|42|43)|(11:31|32|33|34|36|37|(0)|40|41|42|43)|36|37|(0)|40|41|42|43)|59|58|32|33|34) */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00f6, code lost:
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00f7, code lost:
            r2 = null;
         */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00d6  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void u(com.facebook.imagepipeline.image.e r21, int r22) {
            /*
                Method dump skipped, instructions count: 324
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.producers.n.c.u(com.facebook.imagepipeline.image.e, int):void");
        }

        @Nullable
        private Map<String, String> v(@Nullable com.facebook.imagepipeline.image.c cVar, long j2, com.facebook.imagepipeline.image.i iVar, boolean z, String str, String str2, String str3, String str4) {
            Bitmap y;
            if (this.f2960d.f(this.c, "DecodeProducer")) {
                String valueOf = String.valueOf(j2);
                String valueOf2 = String.valueOf(iVar.b());
                String valueOf3 = String.valueOf(z);
                if (cVar instanceof com.facebook.imagepipeline.image.d) {
                    com.facebook.common.internal.h.g(((com.facebook.imagepipeline.image.d) cVar).y());
                    HashMap hashMap = new HashMap(8);
                    hashMap.put("bitmapSize", y.getWidth() + "x" + y.getHeight());
                    hashMap.put("queueTime", valueOf);
                    hashMap.put("hasGoodQuality", valueOf2);
                    hashMap.put("isFinal", valueOf3);
                    hashMap.put("encodedImageSize", str2);
                    hashMap.put("imageFormat", str);
                    hashMap.put("requestedImageSize", str3);
                    hashMap.put("sampleSize", str4);
                    if (Build.VERSION.SDK_INT >= 12) {
                        hashMap.put("byteCount", y.getByteCount() + "");
                    }
                    return ImmutableMap.copyOf((Map) hashMap);
                }
                HashMap hashMap2 = new HashMap(7);
                hashMap2.put("queueTime", valueOf);
                hashMap2.put("hasGoodQuality", valueOf2);
                hashMap2.put("isFinal", valueOf3);
                hashMap2.put("encodedImageSize", str2);
                hashMap2.put("imageFormat", str);
                hashMap2.put("requestedImageSize", str3);
                hashMap2.put("sampleSize", str4);
                return ImmutableMap.copyOf((Map) hashMap2);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y() {
            D(true);
            o().a();
        }

        private void z(Throwable th) {
            D(true);
            o().onFailure(th);
        }

        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: F */
        public void h(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            boolean d2;
            try {
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.a("DecodeProducer#onNewResultImpl");
                }
                boolean d3 = com.facebook.imagepipeline.producers.b.d(i2);
                if (d3) {
                    if (eVar == null) {
                        z(new ExceptionWithNoStacktrace("Encoded image is null."));
                        if (d2) {
                            return;
                        }
                        return;
                    } else if (!eVar.Y()) {
                        z(new ExceptionWithNoStacktrace("Encoded image is not valid."));
                        if (com.facebook.imagepipeline.f.b.d()) {
                            com.facebook.imagepipeline.f.b.b();
                            return;
                        }
                        return;
                    }
                }
                if (!H(eVar, i2)) {
                    if (com.facebook.imagepipeline.f.b.d()) {
                        com.facebook.imagepipeline.f.b.b();
                        return;
                    }
                    return;
                }
                boolean m = com.facebook.imagepipeline.producers.b.m(i2, 4);
                if (d3 || m || this.c.i()) {
                    this.f2963g.h();
                }
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
            } finally {
                if (com.facebook.imagepipeline.f.b.d()) {
                    com.facebook.imagepipeline.f.b.b();
                }
            }
        }

        protected boolean H(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            return this.f2963g.k(eVar, i2);
        }

        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        public void f() {
            y();
        }

        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        public void g(Throwable th) {
            z(th);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.imagepipeline.producers.p, com.facebook.imagepipeline.producers.b
        public void i(float f2) {
            super.i(f2 * 0.99f);
        }

        protected abstract int w(com.facebook.imagepipeline.image.e eVar);

        protected abstract com.facebook.imagepipeline.image.i x();
    }

    public n(com.facebook.common.memory.a aVar, Executor executor, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, n0<com.facebook.imagepipeline.image.e> n0Var, int i2, com.facebook.imagepipeline.core.a aVar2, @Nullable Runnable runnable, com.facebook.common.internal.k<Boolean> kVar) {
        com.facebook.common.internal.h.g(aVar);
        this.a = aVar;
        com.facebook.common.internal.h.g(executor);
        this.b = executor;
        com.facebook.common.internal.h.g(bVar);
        this.c = bVar;
        com.facebook.common.internal.h.g(dVar);
        this.f2948d = dVar;
        this.f2950f = z;
        this.f2951g = z2;
        com.facebook.common.internal.h.g(n0Var);
        this.f2949e = n0Var;
        this.f2952h = z3;
        this.f2953i = i2;
        this.f2954j = aVar2;
        this.f2955k = runnable;
        this.f2956l = kVar;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.common.references.a<com.facebook.imagepipeline.image.c>> lVar, o0 o0Var) {
        l<com.facebook.imagepipeline.image.e> bVar;
        try {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("DecodeProducer#produceResults");
            }
            if (!com.facebook.common.util.d.m(o0Var.j().s())) {
                bVar = new a(this, lVar, o0Var, this.f2952h, this.f2953i);
            } else {
                bVar = new b(this, lVar, o0Var, new com.facebook.imagepipeline.decoder.e(this.a), this.f2948d, this.f2952h, this.f2953i);
            }
            this.f2949e.b(bVar, o0Var);
        } finally {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }
    }
}
