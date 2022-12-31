package us.pinguo.librouter.b.c;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: PGLocation.java */
/* loaded from: classes5.dex */
public class f {
    private double a;
    private double b;
    private double c;

    /* renamed from: d  reason: collision with root package name */
    private String f11536d;

    /* renamed from: e  reason: collision with root package name */
    private long f11537e;

    public f() {
        this.a = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.b = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.c = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.f11536d = "";
        this.f11537e = 0L;
    }

    public static f a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 2) {
            return null;
        }
        try {
            return new f(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String e(f fVar) {
        if (fVar == null || !fVar.g()) {
            return null;
        }
        return fVar.b + "," + fVar.c;
    }

    public double b() {
        return this.a;
    }

    public double c() {
        return this.b;
    }

    public double d() {
        return this.c;
    }

    public long f() {
        return this.f11537e;
    }

    public boolean g() {
        return Math.abs(this.c) > 1.0E-8d && Math.abs(this.b) > 1.0E-8d;
    }

    public void h(double d2) {
        this.a = d2;
    }

    public void i(double d2) {
        this.b = d2;
    }

    public void j(double d2) {
        this.c = d2;
    }

    public void k(long j2) {
        this.f11537e = j2;
    }

    public String toString() {
        return "Altitude:" + this.a + "/Latitude:" + this.b + "/Longitude:" + this.c + "/Address:" + this.f11536d;
    }

    public f(double d2, double d3) {
        this.a = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.b = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.c = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.f11536d = "";
        this.f11537e = 0L;
        this.b = d2;
        this.c = d3;
    }
}
