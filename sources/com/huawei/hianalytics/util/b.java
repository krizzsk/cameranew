package com.huawei.hianalytics.util;
/* loaded from: classes2.dex */
public class b {
    private byte[] a;
    private int b;
    private int c;

    public b() {
        this.a = null;
        this.b = 1024;
        this.c = 0;
        this.a = new byte[1024];
    }

    public b(int i2) {
        this.a = null;
        this.b = 1024;
        this.c = 0;
        this.b = i2;
        this.a = new byte[i2];
    }

    public int a() {
        return this.c;
    }

    public void a(byte[] bArr, int i2) {
        if (i2 <= 0) {
            return;
        }
        byte[] bArr2 = this.a;
        int length = bArr2.length;
        int i3 = this.c;
        if (length - i3 >= i2) {
            System.arraycopy(bArr, 0, bArr2, i3, i2);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i2) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i3);
            System.arraycopy(bArr, 0, bArr3, this.c, i2);
            this.a = bArr3;
        }
        this.c += i2;
    }

    public byte[] b() {
        int i2 = this.c;
        if (i2 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.a, 0, bArr, 0, i2);
        return bArr;
    }
}
