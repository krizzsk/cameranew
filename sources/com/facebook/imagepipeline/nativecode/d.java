package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* compiled from: NativeJpegTranscoderSoLoader.java */
/* loaded from: classes.dex */
public class d {
    private static boolean a;

    public static synchronized void a() {
        synchronized (d.class) {
            if (!a) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.soloader.n.a.e("fb_jpegturbo", 1);
                    } catch (UnsatisfiedLinkError unused) {
                    }
                }
                com.facebook.soloader.n.a.d("native-imagetranscoder");
                a = true;
            }
        }
    }
}
