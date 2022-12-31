package com.facebook.imagepipeline.producers;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
/* compiled from: DiskCacheReadProducer.java */
/* loaded from: classes.dex */
public class q implements n0<com.facebook.imagepipeline.image.e> {
    private final com.facebook.imagepipeline.cache.e a;
    private final com.facebook.imagepipeline.cache.e b;
    private final com.facebook.imagepipeline.cache.f c;

    /* renamed from: d  reason: collision with root package name */
    private final n0<com.facebook.imagepipeline.image.e> f2965d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskCacheReadProducer.java */
    /* loaded from: classes.dex */
    public class a implements bolts.d<com.facebook.imagepipeline.image.e, Void> {
        final /* synthetic */ q0 a;
        final /* synthetic */ o0 b;
        final /* synthetic */ l c;

        a(q0 q0Var, o0 o0Var, l lVar) {
            this.a = q0Var;
            this.b = o0Var;
            this.c = lVar;
        }

        @Override // bolts.d
        /* renamed from: b */
        public Void a(bolts.e<com.facebook.imagepipeline.image.e> eVar) throws Exception {
            if (q.f(eVar)) {
                this.a.c(this.b, "DiskCacheProducer", null);
                this.c.a();
            } else if (eVar.n()) {
                this.a.k(this.b, "DiskCacheProducer", eVar.i(), null);
                q.this.f2965d.b(this.c, this.b);
            } else {
                com.facebook.imagepipeline.image.e j2 = eVar.j();
                if (j2 != null) {
                    q0 q0Var = this.a;
                    o0 o0Var = this.b;
                    q0Var.j(o0Var, "DiskCacheProducer", q.e(q0Var, o0Var, true, j2.S()));
                    this.a.b(this.b, "DiskCacheProducer", true);
                    this.b.g("disk");
                    this.c.b(1.0f);
                    this.c.c(j2, 1);
                    j2.close();
                } else {
                    q0 q0Var2 = this.a;
                    o0 o0Var2 = this.b;
                    q0Var2.j(o0Var2, "DiskCacheProducer", q.e(q0Var2, o0Var2, false, 0));
                    q.this.f2965d.b(this.c, this.b);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskCacheReadProducer.java */
    /* loaded from: classes.dex */
    public class b extends e {
        final /* synthetic */ AtomicBoolean a;

        b(q qVar, AtomicBoolean atomicBoolean) {
            this.a = atomicBoolean;
        }

        @Override // com.facebook.imagepipeline.producers.p0
        public void b() {
            this.a.set(true);
        }
    }

    public q(com.facebook.imagepipeline.cache.e eVar, com.facebook.imagepipeline.cache.e eVar2, com.facebook.imagepipeline.cache.f fVar, n0<com.facebook.imagepipeline.image.e> n0Var) {
        this.a = eVar;
        this.b = eVar2;
        this.c = fVar;
        this.f2965d = n0Var;
    }

    @Nullable
    @VisibleForTesting
    static Map<String, String> e(q0 q0Var, o0 o0Var, boolean z, int i2) {
        if (q0Var.f(o0Var, "DiskCacheProducer")) {
            if (z) {
                return ImmutableMap.of("cached_value_found", String.valueOf(z), "encodedImageSize", String.valueOf(i2));
            }
            return ImmutableMap.of("cached_value_found", String.valueOf(z));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(bolts.e<?> eVar) {
        return eVar.l() || (eVar.n() && (eVar.i() instanceof CancellationException));
    }

    private void g(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        if (o0Var.o().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            o0Var.e("disk", "nil-result_read");
            lVar.c(null, 1);
            return;
        }
        this.f2965d.b(lVar, o0Var);
    }

    private bolts.d<com.facebook.imagepipeline.image.e, Void> h(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        return new a(o0Var.h(), o0Var, lVar);
    }

    private void i(AtomicBoolean atomicBoolean, o0 o0Var) {
        o0Var.c(new b(this, atomicBoolean));
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        ImageRequest j2 = o0Var.j();
        if (!j2.v()) {
            g(lVar, o0Var);
            return;
        }
        o0Var.h().d(o0Var, "DiskCacheProducer");
        com.facebook.cache.common.b d2 = this.c.d(j2, o0Var.a());
        com.facebook.imagepipeline.cache.e eVar = j2.d() == ImageRequest.CacheChoice.SMALL ? this.b : this.a;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        eVar.k(d2, atomicBoolean).e(h(lVar, o0Var));
        i(atomicBoolean, o0Var);
    }
}
