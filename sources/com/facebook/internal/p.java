package com.facebook.internal;
/* compiled from: InternalSettings.java */
/* loaded from: classes.dex */
public class p {
    private static volatile String a;

    public static String a() {
        return a;
    }

    public static boolean b() {
        return a != null && a.startsWith("Unity.");
    }
}
