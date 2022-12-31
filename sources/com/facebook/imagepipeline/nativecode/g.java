package com.facebook.imagepipeline.nativecode;
/* compiled from: WebpTranscoderFactory.java */
/* loaded from: classes.dex */
public class g {
    private static f a;

    static {
        try {
            a = (f) Class.forName("com.facebook.imagepipeline.nativecode.WebpTranscoderImpl").newInstance();
        } catch (Throwable unused) {
        }
    }

    public static f a() {
        return a;
    }
}
