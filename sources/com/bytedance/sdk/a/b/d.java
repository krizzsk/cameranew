package com.bytedance.sdk.a.b;

import java.util.concurrent.TimeUnit;
/* compiled from: CacheControl.java */
/* loaded from: classes.dex */
public final class d {
    public static final d a = new a().a().c();
    public static final d b = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();
    String c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f1062d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1063e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1064f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1065g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f1066h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f1067i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f1068j;

    /* renamed from: k  reason: collision with root package name */
    private final int f1069k;

    /* renamed from: l  reason: collision with root package name */
    private final int f1070l;
    private final boolean m;
    private final boolean n;
    private final boolean o;

    /* compiled from: CacheControl.java */
    /* loaded from: classes.dex */
    public static final class a {
        boolean a;
        boolean b;
        int c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f1071d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f1072e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f1073f;

        /* renamed from: g  reason: collision with root package name */
        boolean f1074g;

        /* renamed from: h  reason: collision with root package name */
        boolean f1075h;

        public a a() {
            this.a = true;
            return this;
        }

        public a b() {
            this.f1073f = true;
            return this;
        }

        public d c() {
            return new d(this);
        }

        public a a(int i2, TimeUnit timeUnit) {
            if (i2 >= 0) {
                long seconds = timeUnit.toSeconds(i2);
                this.f1071d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i2);
        }
    }

    private d(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, String str) {
        this.f1062d = z;
        this.f1063e = z2;
        this.f1064f = i2;
        this.f1065g = i3;
        this.f1066h = z3;
        this.f1067i = z4;
        this.f1068j = z5;
        this.f1069k = i4;
        this.f1070l = i5;
        this.m = z6;
        this.n = z7;
        this.o = z8;
        this.c = str;
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (this.f1062d) {
            sb.append("no-cache, ");
        }
        if (this.f1063e) {
            sb.append("no-store, ");
        }
        if (this.f1064f != -1) {
            sb.append("max-age=");
            sb.append(this.f1064f);
            sb.append(", ");
        }
        if (this.f1065g != -1) {
            sb.append("s-maxage=");
            sb.append(this.f1065g);
            sb.append(", ");
        }
        if (this.f1066h) {
            sb.append("private, ");
        }
        if (this.f1067i) {
            sb.append("public, ");
        }
        if (this.f1068j) {
            sb.append("must-revalidate, ");
        }
        if (this.f1069k != -1) {
            sb.append("max-stale=");
            sb.append(this.f1069k);
            sb.append(", ");
        }
        if (this.f1070l != -1) {
            sb.append("min-fresh=");
            sb.append(this.f1070l);
            sb.append(", ");
        }
        if (this.m) {
            sb.append("only-if-cached, ");
        }
        if (this.n) {
            sb.append("no-transform, ");
        }
        if (this.o) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.f1062d;
    }

    public boolean b() {
        return this.f1063e;
    }

    public int c() {
        return this.f1064f;
    }

    public boolean d() {
        return this.f1066h;
    }

    public boolean e() {
        return this.f1067i;
    }

    public boolean f() {
        return this.f1068j;
    }

    public int g() {
        return this.f1069k;
    }

    public int h() {
        return this.f1070l;
    }

    public boolean i() {
        return this.m;
    }

    public boolean j() {
        return this.o;
    }

    public String toString() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        String k2 = k();
        this.c = k2;
        return k2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.bytedance.sdk.a.b.d a(com.bytedance.sdk.a.b.r r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.d.a(com.bytedance.sdk.a.b.r):com.bytedance.sdk.a.b.d");
    }

    d(a aVar) {
        this.f1062d = aVar.a;
        this.f1063e = aVar.b;
        this.f1064f = aVar.c;
        this.f1065g = -1;
        this.f1066h = false;
        this.f1067i = false;
        this.f1068j = false;
        this.f1069k = aVar.f1071d;
        this.f1070l = aVar.f1072e;
        this.m = aVar.f1073f;
        this.n = aVar.f1074g;
        this.o = aVar.f1075h;
    }
}
