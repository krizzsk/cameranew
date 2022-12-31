package com.facebook.appevents.codeless.internal;

import android.util.Log;
/* compiled from: UnityReflection.java */
/* loaded from: classes.dex */
public class c {
    private static final String a = "com.facebook.appevents.codeless.internal.c";
    private static Class<?> b;

    public static void a() {
        c("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    public static void b(String str) {
        c("UnityFacebookSDKPlugin", "OnReceiveMapping", str);
    }

    public static void c(String str, String str2, String str3) {
        try {
            if (b == null) {
                b = Class.forName("com.unity3d.player.UnityPlayer");
            }
            b.getMethod("UnitySendMessage", String.class, String.class, String.class).invoke(b, str, str2, str3);
        } catch (Exception e2) {
            Log.e(a, "Failed to send message to Unity", e2);
        }
    }
}
