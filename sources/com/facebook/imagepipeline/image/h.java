package com.facebook.imagepipeline.image;

import javax.annotation.Nullable;
/* compiled from: ImmutableQualityInfo.java */
/* loaded from: classes.dex */
public class h implements i {

    /* renamed from: d  reason: collision with root package name */
    public static final i f2818d = d(Integer.MAX_VALUE, true, true);
    int a;
    boolean b;
    boolean c;

    private h(int i2, boolean z, boolean z2) {
        this.a = i2;
        this.b = z;
        this.c = z2;
    }

    public static i d(int i2, boolean z, boolean z2) {
        return new h(i2, z, z2);
    }

    @Override // com.facebook.imagepipeline.image.i
    public boolean a() {
        return this.c;
    }

    @Override // com.facebook.imagepipeline.image.i
    public boolean b() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.image.i
    public int c() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.a == hVar.a && this.b == hVar.b && this.c == hVar.c;
        }
        return false;
    }

    public int hashCode() {
        return (this.a ^ (this.b ? 4194304 : 0)) ^ (this.c ? 8388608 : 0);
    }
}
