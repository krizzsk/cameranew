package com.facebook.drawee.backends.pipeline.g;

import javax.annotation.Nullable;
/* compiled from: DebugOverlayImageOriginListener.java */
/* loaded from: classes.dex */
public class b implements com.facebook.drawee.backends.pipeline.h.b {
    private int a = 1;

    @Override // com.facebook.drawee.backends.pipeline.h.b
    public void a(String str, int i2, boolean z, @Nullable String str2) {
        this.a = i2;
    }

    public int b() {
        return this.a;
    }
}
