package us.pinguo.foundation;

import us.pinguo.util.v;
/* compiled from: Debug.java */
/* loaded from: classes4.dex */
public final class d {
    private static boolean a = !c();
    public static boolean b = true;
    public static boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f10985d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f10986e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f10987f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f10988g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f10989h;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f10990i;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f10991j;

    /* renamed from: k  reason: collision with root package name */
    public static boolean f10992k;

    /* compiled from: Debug.java */
    /* loaded from: classes4.dex */
    public static class a {
        public static int a = 8830;
        public static int b = 90000;
        public static int c = 93090;

        /* renamed from: d  reason: collision with root package name */
        public static int f10993d = 96200;

        /* renamed from: e  reason: collision with root package name */
        public static int f10994e = 96600;

        /* renamed from: f  reason: collision with root package name */
        public static int f10995f = 97400;
    }

    static {
        boolean z = true;
        PackageMode packageMode = us.pinguo.foundation.a.a;
        PackageMode packageMode2 = PackageMode.PUBLISH;
        boolean z2 = packageMode != packageMode2 && a;
        f10985d = z2;
        f10986e = z2 ? "c893aff538416202d9a1" : "5dab06e7a53740ea9b78";
        f10987f = packageMode != packageMode2;
        f10988g = Conditions.a();
        f10989h = a.f10995f;
        Conditions.e();
        f10990i = b();
        f10991j = (packageMode == packageMode2 || !a()) ? false : false;
        f10992k = false;
    }

    private static boolean a() {
        return us.pinguo.foundation.base.e.a(v.a(), "google_vip", false);
    }

    private static boolean b() {
        return us.pinguo.foundation.base.e.a(v.a(), "new_user", false);
    }

    private static boolean c() {
        return us.pinguo.foundation.base.e.a(v.a(), "release_host", false);
    }
}
