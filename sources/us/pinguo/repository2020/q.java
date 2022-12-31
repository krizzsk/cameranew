package us.pinguo.repository2020;

import us.pinguo.repository2020.entity.PackageItem;
/* compiled from: InstallListener.kt */
/* loaded from: classes6.dex */
public abstract class q {
    public static final a b = new a(null);
    private static final int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final int f11933d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final int f11934e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11935f = 5;

    /* renamed from: g  reason: collision with root package name */
    private static final int f11936g = 6;

    /* renamed from: h  reason: collision with root package name */
    private static final int f11937h = 18;

    /* renamed from: i  reason: collision with root package name */
    private static final int f11938i = 19;
    private final PackageItem a;

    /* compiled from: InstallListener.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        public final int a() {
            return q.f11935f;
        }

        public final int b() {
            return q.f11934e;
        }

        public final int c() {
            return q.f11933d;
        }

        public final int d() {
            return q.f11937h;
        }

        public final int e() {
            return q.f11936g;
        }

        public final int f() {
            return q.f11938i;
        }

        public final int g() {
            return q.c;
        }
    }

    public q(PackageItem item) {
        kotlin.jvm.internal.s.h(item, "item");
        this.a = item;
    }

    public final PackageItem h() {
        return this.a;
    }

    public abstract void i(int i2);

    public abstract void j(int i2);

    public abstract void k();
}
