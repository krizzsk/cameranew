package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class DocumentData {
    public final String a;
    public final String b;
    public final float c;

    /* renamed from: d  reason: collision with root package name */
    public final Justification f372d;

    /* renamed from: e  reason: collision with root package name */
    public final int f373e;

    /* renamed from: f  reason: collision with root package name */
    public final float f374f;

    /* renamed from: g  reason: collision with root package name */
    public final float f375g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f376h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    public final int f377i;

    /* renamed from: j  reason: collision with root package name */
    public final float f378j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f379k;

    /* loaded from: classes.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f2, Justification justification, int i2, float f3, float f4, @ColorInt int i3, @ColorInt int i4, float f5, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = f2;
        this.f372d = justification;
        this.f373e = i2;
        this.f374f = f3;
        this.f375g = f4;
        this.f376h = i3;
        this.f377i = i4;
        this.f378j = f5;
        this.f379k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c)) * 31) + this.f372d.ordinal()) * 31) + this.f373e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f374f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f376h;
    }
}
