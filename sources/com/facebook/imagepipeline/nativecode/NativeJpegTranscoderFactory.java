package com.facebook.imagepipeline.nativecode;

import javax.annotation.Nullable;
@com.facebook.common.internal.d
/* loaded from: classes.dex */
public class NativeJpegTranscoderFactory implements com.facebook.imagepipeline.g.d {
    private final int a;
    private final boolean b;
    private final boolean c;

    @com.facebook.common.internal.d
    public NativeJpegTranscoderFactory(int i2, boolean z, boolean z2) {
        this.a = i2;
        this.b = z;
        this.c = z2;
    }

    @Override // com.facebook.imagepipeline.g.d
    @com.facebook.common.internal.d
    @Nullable
    public com.facebook.imagepipeline.g.c createImageTranscoder(com.facebook.imageformat.c cVar, boolean z) {
        if (cVar != com.facebook.imageformat.b.a) {
            return null;
        }
        return new NativeJpegTranscoder(z, this.a, this.b, this.c);
    }
}
