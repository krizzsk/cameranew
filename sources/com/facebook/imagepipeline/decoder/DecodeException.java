package com.facebook.imagepipeline.decoder;
/* loaded from: classes.dex */
public class DecodeException extends RuntimeException {
    private final com.facebook.imagepipeline.image.e mEncodedImage;

    public DecodeException(String str, com.facebook.imagepipeline.image.e eVar) {
        super(str);
        this.mEncodedImage = eVar;
    }

    public com.facebook.imagepipeline.image.e getEncodedImage() {
        return this.mEncodedImage;
    }

    public DecodeException(String str, Throwable th, com.facebook.imagepipeline.image.e eVar) {
        super(str, th);
        this.mEncodedImage = eVar;
    }
}
