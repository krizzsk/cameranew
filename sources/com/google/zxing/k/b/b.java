package com.google.zxing.k.b;

import com.growingio.android.sdk.collection.Constants;
/* compiled from: BinaryShiftToken.java */
/* loaded from: classes2.dex */
final class b extends g {
    private final short c;

    /* renamed from: d  reason: collision with root package name */
    private final short f5025d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(g gVar, int i2, int i3) {
        super(gVar);
        this.c = (short) i2;
        this.f5025d = (short) i3;
    }

    @Override // com.google.zxing.k.b.g
    public void c(com.google.zxing.common.a aVar, byte[] bArr) {
        int i2 = 0;
        while (true) {
            short s = this.f5025d;
            if (i2 >= s) {
                return;
            }
            if (i2 == 0 || (i2 == 31 && s <= 62)) {
                aVar.c(31, 5);
                short s2 = this.f5025d;
                if (s2 > 62) {
                    aVar.c(s2 - 31, 16);
                } else if (i2 == 0) {
                    aVar.c(Math.min((int) s2, 31), 5);
                } else {
                    aVar.c(s2 - 31, 5);
                }
            }
            aVar.c(bArr[this.c + i2], 8);
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.c);
        sb.append(Constants.WEB_PART_SEPARATOR);
        sb.append((this.c + this.f5025d) - 1);
        sb.append('>');
        return sb.toString();
    }
}
