package us.pinguo.picker.image;

import kotlin.jvm.internal.s;
import us.pinguo.picker.image.gallery.m;
import us.pinguo.picker.image.gallery.o;
/* compiled from: PickInfo.kt */
/* loaded from: classes5.dex */
public final class c {
    private o a;
    private m b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f11665d;

    public c(o mediaSet, m coverItem, int i2, int i3) {
        s.h(mediaSet, "mediaSet");
        s.h(coverItem, "coverItem");
        this.a = mediaSet;
        this.b = coverItem;
        this.c = i2;
        this.f11665d = i3;
    }

    public final int a() {
        return this.f11665d;
    }

    public final m b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final o d() {
        return this.a;
    }

    public final void e(int i2) {
        this.f11665d = i2;
    }

    public final void f(m mVar) {
        s.h(mVar, "<set-?>");
        this.b = mVar;
    }

    public final void g(o oVar) {
        s.h(oVar, "<set-?>");
        this.a = oVar;
    }
}
