package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.producers.j0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* compiled from: NetworkFetchProducer.java */
/* loaded from: classes.dex */
public class i0 implements n0<com.facebook.imagepipeline.image.e> {
    protected final com.facebook.common.memory.f a;
    private final com.facebook.common.memory.a b;
    private final j0 c;

    /* compiled from: NetworkFetchProducer.java */
    /* loaded from: classes.dex */
    class a implements j0.a {
        final /* synthetic */ w a;

        a(w wVar) {
            this.a = wVar;
        }

        @Override // com.facebook.imagepipeline.producers.j0.a
        public void a() {
            i0.this.k(this.a);
        }

        @Override // com.facebook.imagepipeline.producers.j0.a
        public void b(InputStream inputStream, int i2) throws IOException {
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.a("NetworkFetcher->onResponse");
            }
            i0.this.m(this.a, inputStream, i2);
            if (com.facebook.imagepipeline.f.b.d()) {
                com.facebook.imagepipeline.f.b.b();
            }
        }

        @Override // com.facebook.imagepipeline.producers.j0.a
        public void onFailure(Throwable th) {
            i0.this.l(this.a, th);
        }
    }

    public i0(com.facebook.common.memory.f fVar, com.facebook.common.memory.a aVar, j0 j0Var) {
        this.a = fVar;
        this.b = aVar;
        this.c = j0Var;
    }

    protected static float e(int i2, int i3) {
        return i3 > 0 ? i2 / i3 : 1.0f - ((float) Math.exp((-i2) / 50000.0d));
    }

    @Nullable
    private Map<String, String> f(w wVar, int i2) {
        if (wVar.d().f(wVar.b(), "NetworkFetchProducer")) {
            return this.c.d(wVar, i2);
        }
        return null;
    }

    protected static void j(com.facebook.common.memory.h hVar, int i2, @Nullable com.facebook.imagepipeline.common.a aVar, l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        com.facebook.common.references.a R = com.facebook.common.references.a.R(hVar.d());
        com.facebook.imagepipeline.image.e eVar = null;
        try {
            com.facebook.imagepipeline.image.e eVar2 = new com.facebook.imagepipeline.image.e(R);
            try {
                eVar2.e0(aVar);
                eVar2.a0();
                o0Var.k(EncodedImageOrigin.NETWORK);
                lVar.c(eVar2, i2);
                com.facebook.imagepipeline.image.e.h(eVar2);
                com.facebook.common.references.a.y(R);
            } catch (Throwable th) {
                th = th;
                eVar = eVar2;
                com.facebook.imagepipeline.image.e.h(eVar);
                com.facebook.common.references.a.y(R);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(w wVar) {
        wVar.d().c(wVar.b(), "NetworkFetchProducer", null);
        wVar.a().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(w wVar, Throwable th) {
        wVar.d().k(wVar.b(), "NetworkFetchProducer", th, null);
        wVar.d().b(wVar.b(), "NetworkFetchProducer", false);
        wVar.b().g("network");
        wVar.a().onFailure(th);
    }

    private boolean n(w wVar) {
        if (wVar.b().i()) {
            return this.c.c(wVar);
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        o0Var.h().d(o0Var, "NetworkFetchProducer");
        w e2 = this.c.e(lVar, o0Var);
        this.c.a(e2, new a(e2));
    }

    @VisibleForTesting
    protected long g() {
        return SystemClock.uptimeMillis();
    }

    protected void h(com.facebook.common.memory.h hVar, w wVar) {
        Map<String, String> f2 = f(wVar, hVar.size());
        q0 d2 = wVar.d();
        d2.j(wVar.b(), "NetworkFetchProducer", f2);
        d2.b(wVar.b(), "NetworkFetchProducer", true);
        wVar.b().g("network");
        j(hVar, wVar.e() | 1, wVar.f(), wVar.a(), wVar.b());
    }

    protected void i(com.facebook.common.memory.h hVar, w wVar) {
        long g2 = g();
        if (!n(wVar) || g2 - wVar.c() < 100) {
            return;
        }
        wVar.h(g2);
        wVar.d().h(wVar.b(), "NetworkFetchProducer", "intermediate_result");
        j(hVar, wVar.e(), wVar.f(), wVar.a(), wVar.b());
    }

    protected void m(w wVar, InputStream inputStream, int i2) throws IOException {
        com.facebook.common.memory.h c;
        if (i2 > 0) {
            c = this.a.e(i2);
        } else {
            c = this.a.c();
        }
        byte[] bArr = this.b.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    this.c.b(wVar, c.size());
                    h(c, wVar);
                    return;
                } else if (read > 0) {
                    c.write(bArr, 0, read);
                    i(c, wVar);
                    wVar.a().b(e(c.size(), i2));
                }
            } finally {
                this.b.release(bArr);
                c.close();
            }
        }
    }
}
