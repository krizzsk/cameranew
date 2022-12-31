package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.request.ImageRequest;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: LocalFetchProducer.java */
/* loaded from: classes.dex */
public abstract class d0 implements n0<com.facebook.imagepipeline.image.e> {
    private final Executor a;
    private final com.facebook.common.memory.f b;

    /* compiled from: LocalFetchProducer.java */
    /* loaded from: classes.dex */
    class a extends v0<com.facebook.imagepipeline.image.e> {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ImageRequest f2893f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ q0 f2894g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ o0 f2895h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(l lVar, q0 q0Var, o0 o0Var, String str, ImageRequest imageRequest, q0 q0Var2, o0 o0Var2) {
            super(lVar, q0Var, o0Var, str);
            this.f2893f = imageRequest;
            this.f2894g = q0Var2;
            this.f2895h = o0Var2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.common.executors.f
        /* renamed from: j */
        public void b(com.facebook.imagepipeline.image.e eVar) {
            com.facebook.imagepipeline.image.e.h(eVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.common.executors.f
        @Nullable
        /* renamed from: k */
        public com.facebook.imagepipeline.image.e c() throws Exception {
            com.facebook.imagepipeline.image.e d2 = d0.this.d(this.f2893f);
            if (d2 == null) {
                this.f2894g.b(this.f2895h, d0.this.f(), false);
                this.f2895h.g("local");
                return null;
            }
            d2.a0();
            this.f2894g.b(this.f2895h, d0.this.f(), true);
            this.f2895h.g("local");
            return d2;
        }
    }

    /* compiled from: LocalFetchProducer.java */
    /* loaded from: classes.dex */
    class b extends e {
        final /* synthetic */ v0 a;

        b(d0 d0Var, v0 v0Var) {
            this.a = v0Var;
        }

        @Override // com.facebook.imagepipeline.producers.p0
        public void b() {
            this.a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d0(Executor executor, com.facebook.common.memory.f fVar) {
        this.a = executor;
        this.b = fVar;
    }

    @Override // com.facebook.imagepipeline.producers.n0
    public void b(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var) {
        q0 h2 = o0Var.h();
        ImageRequest j2 = o0Var.j();
        o0Var.e("local", RemoteConfigComponent.FETCH_FILE_NAME);
        a aVar = new a(lVar, h2, o0Var, f(), j2, h2, o0Var);
        o0Var.c(new b(this, aVar));
        this.a.execute(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.facebook.imagepipeline.image.e c(InputStream inputStream, int i2) throws IOException {
        com.facebook.common.references.a R;
        com.facebook.common.references.a aVar = null;
        try {
            if (i2 <= 0) {
                R = com.facebook.common.references.a.R(this.b.a(inputStream));
            } else {
                R = com.facebook.common.references.a.R(this.b.b(inputStream, i2));
            }
            aVar = R;
            return new com.facebook.imagepipeline.image.e(aVar);
        } finally {
            com.facebook.common.internal.b.b(inputStream);
            com.facebook.common.references.a.y(aVar);
        }
    }

    @Nullable
    protected abstract com.facebook.imagepipeline.image.e d(ImageRequest imageRequest) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public com.facebook.imagepipeline.image.e e(InputStream inputStream, int i2) throws IOException {
        return c(inputStream, i2);
    }

    protected abstract String f();
}
