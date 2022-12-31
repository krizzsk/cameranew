package com.google.zxing.k.b;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: State.java */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: e  reason: collision with root package name */
    static final f f5029e = new f(g.b, 0, 0, 0);
    private final int a;
    private final g b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5030d;

    private f(g gVar, int i2, int i3, int i4) {
        this.b = gVar;
        this.a = i2;
        this.c = i3;
        this.f5030d = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f a(int i2) {
        g gVar = this.b;
        int i3 = this.a;
        int i4 = this.f5030d;
        if (i3 == 4 || i3 == 2) {
            int i5 = d.c[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            gVar = gVar.a(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.c;
        f fVar = new f(gVar, i3, i8 + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
        return fVar.c == 2078 ? fVar.b(i2 + 1) : fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f b(int i2) {
        int i3 = this.c;
        return i3 == 0 ? this : new f(this.b.b(i2 - i3, i3), this.a, 0, this.f5030d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f5030d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(f fVar) {
        int i2;
        int i3 = this.f5030d + (d.c[this.a][fVar.a] >> 16);
        int i4 = fVar.c;
        if (i4 > 0 && ((i2 = this.c) == 0 || i2 > i4)) {
            i3 += 10;
        }
        return i3 <= fVar.f5030d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f g(int i2, int i3) {
        int i4 = this.f5030d;
        g gVar = this.b;
        int i5 = this.a;
        if (i2 != i5) {
            int i6 = d.c[i5][i2];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            gVar = gVar.a(i7, i8);
            i4 += i8;
        }
        int i9 = i2 == 2 ? 4 : 5;
        return new f(gVar.a(i3, i9), i2, 0, i4 + i9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f h(int i2, int i3) {
        g gVar = this.b;
        int i4 = this.a;
        int i5 = i4 == 2 ? 4 : 5;
        return new f(gVar.a(d.f5027e[i4][i2], i5).a(i3, 5), this.a, 0, this.f5030d + i5 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.zxing.common.a i(byte[] bArr) {
        LinkedList<g> linkedList = new LinkedList();
        for (g gVar = b(bArr.length).b; gVar != null; gVar = gVar.d()) {
            linkedList.addFirst(gVar);
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        for (g gVar2 : linkedList) {
            gVar2.c(aVar, bArr);
        }
        return aVar;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", d.b[this.a], Integer.valueOf(this.f5030d), Integer.valueOf(this.c));
    }
}
