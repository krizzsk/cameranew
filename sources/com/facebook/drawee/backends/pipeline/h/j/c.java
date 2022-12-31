package com.facebook.drawee.backends.pipeline.h.j;

import com.facebook.drawee.backends.pipeline.h.i;
import com.facebook.imagepipeline.request.ImageRequest;
/* compiled from: ImagePerfRequestListener.java */
/* loaded from: classes.dex */
public class c extends com.facebook.imagepipeline.e.a {
    private final com.facebook.common.time.b a;
    private final i b;

    public c(com.facebook.common.time.b bVar, i iVar) {
        this.a = bVar;
        this.b = iVar;
    }

    @Override // com.facebook.imagepipeline.e.a, com.facebook.imagepipeline.e.e
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        this.b.s(this.a.now());
        this.b.q(imageRequest);
        this.b.d(obj);
        this.b.x(str);
        this.b.w(z);
    }

    @Override // com.facebook.imagepipeline.e.a, com.facebook.imagepipeline.e.e
    public void c(ImageRequest imageRequest, String str, boolean z) {
        this.b.r(this.a.now());
        this.b.q(imageRequest);
        this.b.x(str);
        this.b.w(z);
    }

    @Override // com.facebook.imagepipeline.e.a, com.facebook.imagepipeline.e.e
    public void i(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        this.b.r(this.a.now());
        this.b.q(imageRequest);
        this.b.x(str);
        this.b.w(z);
    }

    @Override // com.facebook.imagepipeline.e.a, com.facebook.imagepipeline.e.e
    public void k(String str) {
        this.b.r(this.a.now());
        this.b.x(str);
    }
}
