package com.airbnb.lottie.model;
/* compiled from: Marker.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: d  reason: collision with root package name */
    private static String f424d = "\r";
    private final String a;
    public final float b;
    public final float c;

    public f(String str, float f2, float f3) {
        this.a = str;
        this.c = f3;
        this.b = f2;
    }

    public boolean a(String str) {
        if (this.a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.a.endsWith(f424d)) {
            String str2 = this.a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
