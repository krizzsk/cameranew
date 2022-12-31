package us.pinguo.picker.image;

import java.util.List;
import kotlin.jvm.internal.s;
import us.pinguo.picker.image.gallery.m;
import us.pinguo.picker.image.gallery.o;
/* compiled from: PickInfo.kt */
/* loaded from: classes5.dex */
public final class f {
    private final o a;
    private final List<m> b;
    private final m c;

    /* renamed from: d  reason: collision with root package name */
    private final int f11680d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f11681e;

    /* JADX WARN: Multi-variable type inference failed */
    public f(o mediaSet, List<? extends m> mediaItems, m mVar, int i2, Integer num) {
        s.h(mediaSet, "mediaSet");
        s.h(mediaItems, "mediaItems");
        this.a = mediaSet;
        this.b = mediaItems;
        this.c = mVar;
        this.f11680d = i2;
        this.f11681e = num;
    }

    public final Integer a() {
        return this.f11681e;
    }

    public final m b() {
        return this.c;
    }

    public final List<m> c() {
        return this.b;
    }

    public final o d() {
        return this.a;
    }

    public final int e() {
        return this.f11680d;
    }
}
