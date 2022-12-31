package com.facebook.drawee.backends.pipeline.h;

import javax.annotation.Nullable;
/* compiled from: ImageOriginRequestListener.java */
/* loaded from: classes.dex */
public class c extends com.facebook.imagepipeline.e.a {
    private String a;
    @Nullable
    private final b b;

    public c(String str, @Nullable b bVar) {
        this.b = bVar;
        l(str);
    }

    @Override // com.facebook.imagepipeline.e.a, com.facebook.imagepipeline.producers.r0
    public void h(String str, String str2, boolean z) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(this.a, d.a(str2), z, str2);
        }
    }

    public void l(String str) {
        this.a = str;
    }
}
