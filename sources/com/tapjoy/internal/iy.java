package com.tapjoy.internal;
/* loaded from: classes3.dex */
final class iy {
    final byte[] a;
    int b;
    int c;

    /* renamed from: d  reason: collision with root package name */
    boolean f7733d;

    /* renamed from: e  reason: collision with root package name */
    boolean f7734e;

    /* renamed from: f  reason: collision with root package name */
    iy f7735f;

    /* renamed from: g  reason: collision with root package name */
    iy f7736g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public iy() {
        this.a = new byte[8192];
        this.f7734e = true;
        this.f7733d = false;
    }

    public final iy a() {
        iy iyVar = this.f7735f;
        iy iyVar2 = iyVar != this ? iyVar : null;
        iy iyVar3 = this.f7736g;
        iyVar3.f7735f = iyVar;
        this.f7735f.f7736g = iyVar3;
        this.f7735f = null;
        this.f7736g = null;
        return iyVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public iy(iy iyVar) {
        this(iyVar.a, iyVar.b, iyVar.c);
        iyVar.f7733d = true;
    }

    public final iy a(iy iyVar) {
        iyVar.f7736g = this;
        iyVar.f7735f = this.f7735f;
        this.f7735f.f7736g = iyVar;
        this.f7735f = iyVar;
        return iyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public iy(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.b = i2;
        this.c = i3;
        this.f7734e = false;
        this.f7733d = true;
    }

    public final void a(iy iyVar, int i2) {
        if (iyVar.f7734e) {
            int i3 = iyVar.c;
            if (i3 + i2 > 8192) {
                if (!iyVar.f7733d) {
                    int i4 = iyVar.b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = iyVar.a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        iyVar.c -= iyVar.b;
                        iyVar.b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.a, this.b, iyVar.a, iyVar.c, i2);
            iyVar.c += i2;
            this.b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
