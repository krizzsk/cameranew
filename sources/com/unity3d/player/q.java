package com.unity3d.player;
/* loaded from: classes3.dex */
final class q {
    private static boolean a = false;
    private boolean b = false;
    private boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8421d = true;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8422e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        a = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        this.b = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(boolean z) {
        this.f8421d = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(boolean z) {
        this.f8422e = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(boolean z) {
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d() {
        return this.f8421d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e() {
        return this.f8422e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e(boolean z) {
        if (a) {
            return ((!z && !this.b) || this.f8421d || this.c) ? false : true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        return this.c;
    }

    public final String toString() {
        return super.toString();
    }
}
