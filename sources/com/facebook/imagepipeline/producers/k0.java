package com.facebook.imagepipeline.producers;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* compiled from: PartialDiskCacheProducer.java */
/* loaded from: classes.dex */
public class k0 implements n0<com.facebook.imagepipeline.image.e> {
    private final com.facebook.imagepipeline.cache.e a;
    private final com.facebook.imagepipeline.cache.f b;
    private final com.facebook.common.memory.f c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.common.memory.a f2928d;

    /* renamed from: e  reason: collision with root package name */
    private final n0<com.facebook.imagepipeline.image.e> f2929e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PartialDiskCacheProducer.java */
    /* loaded from: classes.dex */
    public class a implements bolts.d<com.facebook.imagepipeline.image.e, Void> {
        final /* synthetic */ q0 a;
        final /* synthetic */ o0 b;
        final /* synthetic */ l c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.facebook.cache.common.b f2930d;

        a(q0 q0Var, o0 o0Var, l lVar, com.facebook.cache.common.b bVar) {
            this.a = q0Var;
            this.b = o0Var;
            this.c = lVar;
            this.f2930d = bVar;
        }

        @Override // bolts.d
        /* renamed from: b */
        public Void a(bolts.e<com.facebook.imagepipeline.image.e> eVar) throws Exception {
            if (k0.g(eVar)) {
                this.a.c(this.b, "PartialDiskCacheProducer", null);
                this.c.a();
            } else if (eVar.n()) {
                this.a.k(this.b, "PartialDiskCacheProducer", eVar.i(), null);
                k0.this.i(this.c, this.b, this.f2930d, null);
            } else {
                com.facebook.imagepipeline.image.e j2 = eVar.j();
                if (j2 != null) {
                    q0 q0Var = this.a;
                    o0 o0Var = this.b;
                    q0Var.j(o0Var, "PartialDiskCacheProducer", k0.f(q0Var, o0Var, true, j2.S()));
                    com.facebook.imagepipeline.common.a c = com.facebook.imagepipeline.common.a.c(j2.S() - 1);
                    j2.e0(c);
                    int S = j2.S();
                    ImageRequest j3 = this.b.j();
                    if (c.a(j3.c())) {
                        this.b.e("disk", "partial");
                        this.a.b(this.b, "PartialDiskCacheProducer", true);
                        this.c.c(j2, 9);
                    } else {
                        this.c.c(j2, 8);
                        ImageRequestBuilder b = ImageRequestBuilder.b(j3);
                        b.t(com.facebook.imagepipeline.common.a.b(S - 1));
                        k0.this.i(this.c, new u0(b.a(), this.b), this.f2930d, j2);
                    }
                } else {
                    q0 q0Var2 = this.a;
                    o0 o0Var2 = this.b;
                    q0Var2.j(o0Var2, "PartialDiskCacheProducer", k0.f(q0Var2, o0Var2, false, 0));
                    k0.this.i(this.c, this.b, this.f2930d, j2);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PartialDiskCacheProducer.java */
    /* loaded from: classes.dex */
    public class b extends e {
        final /* synthetic */ AtomicBoolean a;

        b(k0 k0Var, AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // com.facebook.imagepipeline.producers.p0
        public void b() {
            this.a.set(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PartialDiskCacheProducer.java */
    /* loaded from: classes.dex */
    public static class c extends p<com.facebook.imagepipeline.image.e, com.facebook.imagepipeline.image.e> {
        private final com.facebook.imagepipeline.cache.e c;

        /* renamed from: d  reason: collision with root package name */
        private final com.facebook.cache.common.b f2932d;

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.common.memory.f f2933e;

        /* renamed from: f  reason: collision with root package name */
        private final com.facebook.common.memory.a f2934f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private final com.facebook.imagepipeline.image.e f2935g;

        /* synthetic */ c(l lVar, com.facebook.imagepipeline.cache.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.f fVar, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.image.e eVar2, a aVar2) {
            this(lVar, eVar, bVar, fVar, aVar, eVar2);
        }

        private void p(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
            byte[] bArr = this.f2934f.get(16384);
            int i3 = i2;
            while (i3 > 0) {
                try {
                    int read = inputStream.read(bArr, 0, Math.min(16384, i3));
                    if (read < 0) {
                        break;
                    } else if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        i3 -= read;
                    }
                } finally {
                    this.f2934f.release(bArr);
                }
            }
            if (i3 > 0) {
                throw new IOException(String.format(null, "Failed to read %d bytes - finished %d short", Integer.valueOf(i2), Integer.valueOf(i3)));
            }
        }

        private com.facebook.common.memory.h q(com.facebook.imagepipeline.image.e eVar, com.facebook.imagepipeline.image.e eVar2) throws IOException {
            com.facebook.imagepipeline.common.a v = eVar2.v();
            com.facebook.common.internal.h.g(v);
            int i2 = v.a;
            com.facebook.common.memory.h e2 = this.f2933e.e(eVar2.S() + i2);
            p(eVar.O(), e2, i2);
            p(eVar2.O(), e2, eVar2.S());
            return e2;
        }

        private void s(com.facebook.common.memory.h hVar) {
            com.facebook.imagepipeline.image.e eVar;
            Throwable th;
            com.facebook.common.references.a R = com.facebook.common.references.a.R(hVar.d());
            try {
                eVar = new com.facebook.imagepipeline.image.e(R);
                try {
                    eVar.a0();
                    o().c(eVar, 1);
                    com.facebook.imagepipeline.image.e.h(eVar);
                    com.facebook.common.references.a.y(R);
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.imagepipeline.image.e.h(eVar);
                    com.facebook.common.references.a.y(R);
                    throw th;
                }
            } catch (Throwable th3) {
                eVar = null;
                th = th3;
            }
        }

        @Override // com.facebook.imagepipeline.producers.b
        /* renamed from: r */
        public void h(@Nullable com.facebook.imagepipeline.image.e eVar, int i2) {
            if (com.facebook.imagepipeline.producers.b.e(i2)) {
                return;
            }
            if (this.f2935g != null && eVar != null && eVar.v() != null) {
                try {
                    try {
                        s(q(this.f2935g, eVar));
                    } catch (IOException e2) {
                        com.facebook.common.logging.a.i("PartialDiskCacheProducer", "Error while merging image data", e2);
                        o().onFailure(e2);
                    }
                    this.c.o(this.f2932d);
                } finally {
                    eVar.close();
                    this.f2935g.close();
                }
            } else if (com.facebook.imagepipeline.producers.b.m(i2, 8) && com.facebook.imagepipeline.producers.b.d(i2) && eVar != null && eVar.A() != com.facebook.imageformat.c.b) {
                this.c.m(this.f2932d, eVar);
                o().c(eVar, i2);
            } else {
                o().c(eVar, i2);
            }
        }

        private c(l<com.facebook.imagepipeline.image.e> lVar, com.facebook.imagepipeline.cache.e eVar, com.facebook.cache.common.b bVar, com.facebook.common.memory.f fVar, com.facebook.common.memory.a aVar, @Nullable com.facebook.imagepipeline.image.e eVar2) {
            super(lVar);
            this.c = eVar;
            this.f2932d = bVar;
            this.f2933e = fVar;
            this.f2934f = aVar;
            this.f2935g = eVar2;
        }
    }

    public k0(com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.f fVar, com.facebook.common.memory.f fVar2, com.facebook.common.memory.a aVar, n0<com.facebook.imagepipeline.image.e> n0Var) {
        this.a = eVar;
        this.b = fVar;
        this.c = fVar2;
        this.f2928d = aVar;
        this.f2929e = n0Var;
    }

    private static Uri e(ImageRequest imageRequest) {
        return imageRequest.s().buildUpon().appendQueryParameter("fresco_partial", "true").build();
    }

    @Nullable
    @VisibleForTesting
    static Map<String, String> f(q0 q0Var, o0 o0Var, boolean z, int i2) {
        if (q0Var.f(o0Var, "PartialDiskCacheProducer")) {
            if (z) {
                return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i2));
            }
            return ImmutableMap.of("cached_value_found", String.valueOf(z));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(bolts.e<?> eVar) {
        return eVar.l() || (eVar.n() && (eVar.i() instanceof CancellationException));
    }

    private bolts.d<com.facebook.imagepipeline.image.e, Void> h(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var, com.facebook.cache.common.b bVar) {
        return new a(o0Var.h(), o0Var, lVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var, com.facebook.cache.common.b bVar, @Nullable com.facebook.imagepipeline.image.e eVar) {
        this.f2929e.b(new c(lVar, this.a, bVar, this.c, this.f2928d, eVar, null), o0Var);
    }

    private void j(AtomicBoolean atomicBoolean, o0 o0Var) {
        o0Var.c(new b(this, atomicBoolean));
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        ImageRequest j2 = o0Var.j();
        if (!j2.v()) {
            this.f2929e.b(lVar, o0Var);
            return;
        }
        o0Var.h().d(o0Var, "PartialDiskCacheProducer");
        com.facebook.cache.common.b b2 = this.b.b(j2, e(j2), o0Var.a());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.a.k(b2, atomicBoolean).e(h(lVar, o0Var, b2));
        j(atomicBoolean, o0Var);
    }
}
