package us.pinguo.permissionlib.b;

import java.util.ArrayList;
/* compiled from: GuideInfo.java */
/* loaded from: classes5.dex */
public class a {
    protected String a;
    protected ArrayList<String> b;
    protected String c;

    /* renamed from: d  reason: collision with root package name */
    protected String f11621d;

    /* renamed from: e  reason: collision with root package name */
    protected int f11622e;

    /* renamed from: f  reason: collision with root package name */
    protected int f11623f;

    /* renamed from: g  reason: collision with root package name */
    protected int f11624g;

    public String a() {
        return this.f11621d;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.f11622e;
    }

    public String d() {
        return e(0);
    }

    public String e(int i2) {
        ArrayList<String> arrayList = this.b;
        return (arrayList == null || i2 < 0 || i2 >= arrayList.size()) ? "" : this.b.get(i2);
    }

    public int f() {
        return this.f11624g;
    }

    public int g() {
        return this.f11623f;
    }

    public String h() {
        return this.a;
    }

    private a(b bVar) {
        this.f11623f = 0;
        this.f11624g = 0;
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f11621d = bVar.f11625d;
        this.f11622e = bVar.f11626e;
        this.f11623f = bVar.f11627f;
        this.f11624g = bVar.f11628g;
    }

    /* compiled from: GuideInfo.java */
    /* loaded from: classes5.dex */
    public static class b {
        private String a;
        protected final ArrayList<String> b;
        private String c;

        /* renamed from: d  reason: collision with root package name */
        private String f11625d;

        /* renamed from: e  reason: collision with root package name */
        private int f11626e;

        /* renamed from: f  reason: collision with root package name */
        private int f11627f;

        /* renamed from: g  reason: collision with root package name */
        private int f11628g;

        public b(String str) {
            ArrayList<String> arrayList = new ArrayList<>(5);
            this.b = arrayList;
            this.f11627f = 0;
            this.f11628g = 0;
            arrayList.add(str);
        }

        public b g(String str) {
            this.b.add(str);
            return this;
        }

        public a h() {
            return new a(this);
        }

        public b i(String str) {
            this.f11625d = str;
            return this;
        }

        public b j(String str) {
            this.c = str;
            return this;
        }

        public b k(int i2) {
            this.f11628g = i2;
            return this;
        }

        public b l(int i2) {
            this.f11627f = i2;
            return this;
        }

        public b m(String str) {
            this.a = str;
            return this;
        }

        public b() {
            this.b = new ArrayList<>(5);
            this.f11627f = 0;
            this.f11628g = 0;
        }
    }
}
