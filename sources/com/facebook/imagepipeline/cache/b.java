package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
/* compiled from: BitmapMemoryCacheKey.java */
@Immutable
/* loaded from: classes.dex */
public class b implements com.facebook.cache.common.b {
    private final String a;
    @Nullable
    private final com.facebook.imagepipeline.common.d b;
    private final com.facebook.imagepipeline.common.e c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.b f2679d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.cache.common.b f2680e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f2681f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2682g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Object f2683h;

    public b(String str, @Nullable com.facebook.imagepipeline.common.d dVar, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.b bVar, @Nullable com.facebook.cache.common.b bVar2, @Nullable String str2, @Nullable Object obj) {
        com.facebook.common.internal.h.g(str);
        this.a = str;
        this.b = dVar;
        this.c = eVar;
        this.f2679d = bVar;
        this.f2680e = bVar2;
        this.f2681f = str2;
        this.f2682g = com.facebook.common.util.a.d(Integer.valueOf(str.hashCode()), Integer.valueOf(dVar != null ? dVar.hashCode() : 0), Integer.valueOf(eVar.hashCode()), bVar, bVar2, str2);
        this.f2683h = obj;
        RealtimeSinceBootClock.get().now();
    }

    @Override // com.facebook.cache.common.b
    public String a() {
        return this.a;
    }

    @Override // com.facebook.cache.common.b
    public boolean b(Uri uri) {
        return a().contains(uri.toString());
    }

    @Override // com.facebook.cache.common.b
    public boolean c() {
        return false;
    }

    @Override // com.facebook.cache.common.b
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f2682g == bVar.f2682g && this.a.equals(bVar.a) && com.facebook.common.internal.g.a(this.b, bVar.b) && com.facebook.common.internal.g.a(this.c, bVar.c) && com.facebook.common.internal.g.a(this.f2679d, bVar.f2679d) && com.facebook.common.internal.g.a(this.f2680e, bVar.f2680e) && com.facebook.common.internal.g.a(this.f2681f, bVar.f2681f);
        }
        return false;
    }

    @Override // com.facebook.cache.common.b
    public int hashCode() {
        return this.f2682g;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.a, this.b, this.c, this.f2679d, this.f2680e, this.f2681f, Integer.valueOf(this.f2682g));
    }
}
