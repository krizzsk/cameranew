package com.facebook.imagepipeline.nativecode;

import android.os.Build;
/* compiled from: StaticWebpNativeLoader.java */
/* loaded from: classes.dex */
public class e {
    private static boolean a;

    public static synchronized void a() {
        synchronized (e.class) {
            if (!a) {
                if (Build.VERSION.SDK_INT <= 16) {
                    try {
                        com.facebook.soloader.n.a.d("fb_jpegturbo");
                    } catch (UnsatisfiedLinkError unused) {
                    }
                }
                com.facebook.soloader.n.a.d("static-webp");
                a = true;
            }
        }
    }
}
