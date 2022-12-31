package com.facebook.imagepipeline.g;
/* compiled from: SimpleImageTranscoderFactory.java */
/* loaded from: classes.dex */
public class h implements d {
    private final int a;

    public h(int i2) {
        this.a = i2;
    }

    @Override // com.facebook.imagepipeline.g.d
    public c createImageTranscoder(com.facebook.imageformat.c cVar, boolean z) {
        return new g(z, this.a);
    }
}
