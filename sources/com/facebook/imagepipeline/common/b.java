package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
/* compiled from: ImageDecodeOptions.java */
@Immutable
/* loaded from: classes.dex */
public class b {
    private static final b m = b().a();
    public final int a;
    public final int b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2700d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f2701e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f2702f;

    /* renamed from: g  reason: collision with root package name */
    public final Bitmap.Config f2703g;

    /* renamed from: h  reason: collision with root package name */
    public final Bitmap.Config f2704h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final com.facebook.imagepipeline.decoder.b f2705i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final com.facebook.imagepipeline.h.a f2706j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final ColorSpace f2707k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f2708l;

    public b(c cVar) {
        this.a = cVar.l();
        this.b = cVar.k();
        this.c = cVar.h();
        this.f2700d = cVar.m();
        this.f2701e = cVar.g();
        this.f2702f = cVar.j();
        this.f2703g = cVar.c();
        this.f2704h = cVar.b();
        this.f2705i = cVar.f();
        this.f2706j = cVar.d();
        this.f2707k = cVar.e();
        this.f2708l = cVar.i();
    }

    public static b a() {
        return m;
    }

    public static c b() {
        return new c();
    }

    protected g.b c() {
        g.b c = g.c(this);
        c.a("minDecodeIntervalMs", this.a);
        c.a("maxDimensionPx", this.b);
        c.c("decodePreviewFrame", this.c);
        c.c("useLastFrameForPreview", this.f2700d);
        c.c("decodeAllFrames", this.f2701e);
        c.c("forceStaticImage", this.f2702f);
        c.b("bitmapConfigName", this.f2703g.name());
        c.b("animatedBitmapConfigName", this.f2704h.name());
        c.b("customImageDecoder", this.f2705i);
        c.b("bitmapTransformation", this.f2706j);
        c.b("colorSpace", this.f2707k);
        return c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.a == bVar.a && this.b == bVar.b && this.c == bVar.c && this.f2700d == bVar.f2700d && this.f2701e == bVar.f2701e && this.f2702f == bVar.f2702f) {
            boolean z = this.f2708l;
            if (z || this.f2703g == bVar.f2703g) {
                return (z || this.f2704h == bVar.f2704h) && this.f2705i == bVar.f2705i && this.f2706j == bVar.f2706j && this.f2707k == bVar.f2707k;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i2 = (((((((((this.a * 31) + this.b) * 31) + (this.c ? 1 : 0)) * 31) + (this.f2700d ? 1 : 0)) * 31) + (this.f2701e ? 1 : 0)) * 31) + (this.f2702f ? 1 : 0);
        if (!this.f2708l) {
            i2 = (i2 * 31) + this.f2703g.ordinal();
        }
        if (!this.f2708l) {
            int i3 = i2 * 31;
            Bitmap.Config config = this.f2704h;
            i2 = i3 + (config != null ? config.ordinal() : 0);
        }
        int i4 = i2 * 31;
        com.facebook.imagepipeline.decoder.b bVar = this.f2705i;
        int hashCode = (i4 + (bVar != null ? bVar.hashCode() : 0)) * 31;
        com.facebook.imagepipeline.h.a aVar = this.f2706j;
        int hashCode2 = (hashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
        ColorSpace colorSpace = this.f2707k;
        return hashCode2 + (colorSpace != null ? colorSpace.hashCode() : 0);
    }

    public String toString() {
        return "ImageDecodeOptions{" + c().toString() + "}";
    }
}
