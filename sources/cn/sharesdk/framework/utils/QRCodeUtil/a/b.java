package cn.sharesdk.framework.utils.QRCodeUtil.a;

import java.lang.reflect.Array;
import java.util.Arrays;
/* compiled from: ByteMatrix.java */
/* loaded from: classes.dex */
public final class b {
    private final byte[][] a;
    private final int b;
    private final int c;

    public b(int i2, int i3) {
        this.a = (byte[][]) Array.newInstance(byte.class, i3, i2);
        this.b = i2;
        this.c = i3;
    }

    public int a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public byte[][] c() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.b * 2 * this.c) + 2);
        for (int i2 = 0; i2 < this.c; i2++) {
            byte[] bArr = this.a[i2];
            for (int i3 = 0; i3 < this.b; i3++) {
                byte b = bArr[i3];
                if (b == 0) {
                    sb.append(" 0");
                } else if (b != 1) {
                    sb.append("\t");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public byte a(int i2, int i3) {
        return this.a[i3][i2];
    }

    public void a(int i2, int i3, int i4) {
        this.a[i3][i2] = (byte) i4;
    }

    public void a(int i2, int i3, boolean z) {
        this.a[i3][i2] = z ? (byte) 1 : (byte) 0;
    }

    public void a(byte b) {
        for (byte[] bArr : this.a) {
            Arrays.fill(bArr, b);
        }
    }
}
