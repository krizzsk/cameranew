package com.facebook.drawee.backends.pipeline.h.j;

import com.facebook.drawee.backends.pipeline.h.g;
import com.facebook.drawee.backends.pipeline.h.i;
import javax.annotation.Nullable;
/* compiled from: ImagePerfImageOriginListener.java */
/* loaded from: classes.dex */
public class b implements com.facebook.drawee.backends.pipeline.h.b {
    private final i a;
    private final g b;

    public b(i iVar, g gVar) {
        this.a = iVar;
        this.b = gVar;
    }

    @Override // com.facebook.drawee.backends.pipeline.h.b
    public void a(String str, int i2, boolean z, @Nullable String str2) {
        this.a.p(i2);
        this.a.y(str2);
        this.b.b(this.a, 1);
    }
}
