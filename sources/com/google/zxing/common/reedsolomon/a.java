package com.google.zxing.common.reedsolomon;
/* compiled from: GenericGF.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: h  reason: collision with root package name */
    public static final a f4998h = new a(4201, 4096, 1);

    /* renamed from: i  reason: collision with root package name */
    public static final a f4999i = new a(1033, 1024, 1);

    /* renamed from: j  reason: collision with root package name */
    public static final a f5000j = new a(67, 64, 1);

    /* renamed from: k  reason: collision with root package name */
    public static final a f5001k = new a(19, 16, 1);

    /* renamed from: l  reason: collision with root package name */
    public static final a f5002l = new a(285, 256, 0);
    public static final a m = new a(301, 256, 1);
    private final int[] a;
    private final int[] b;
    private final b c;

    /* renamed from: d  reason: collision with root package name */
    private final b f5003d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5004e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5005f;

    /* renamed from: g  reason: collision with root package name */
    private final int f5006g;

    public a(int i2, int i3, int i4) {
        this.f5005f = i2;
        this.f5004e = i3;
        this.f5006g = i4;
        this.a = new int[i3];
        this.b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.a[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.b[this.a[i7]] = i7;
        }
        this.c = new b(this, new int[]{0});
        this.f5003d = new b(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 == 0) {
                return this.c;
            }
            int[] iArr = new int[i2 + 1];
            iArr[0] = i3;
            return new b(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i2) {
        return this.a[i2];
    }

    public int d() {
        return this.f5006g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e() {
        return this.f5003d;
    }

    public int f() {
        return this.f5004e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i2) {
        if (i2 != 0) {
            return this.a[(this.f5004e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i2) {
        if (i2 != 0) {
            return this.b[i2];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f5004e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f5005f) + ',' + this.f5004e + ')';
    }
}
