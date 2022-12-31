package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Am  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0731Am {
    public int A00;
    public long A01;
    public Object A02;
    public Object A03;
    public long A04;
    public C0856Fw A05;

    public final int A00() {
        return this.A05.A00;
    }

    public final int A01(int i2) {
        return this.A05.A04[i2].A00;
    }

    public final int A02(int i2) {
        return this.A05.A04[i2].A00();
    }

    public final int A03(int i2, int i3) {
        return this.A05.A04[i2].A01(i3);
    }

    public final int A04(long j2) {
        return this.A05.A00(j2);
    }

    public final int A05(long j2) {
        return this.A05.A01(j2);
    }

    public final long A06() {
        return this.A05.A01;
    }

    public final long A07() {
        return this.A01;
    }

    public final long A08() {
        return A3.A01(this.A04);
    }

    public final long A09(int i2) {
        return this.A05.A03[i2];
    }

    public final long A0A(int i2, int i3) {
        C0854Fu c0854Fu = this.A05.A04[i2];
        if (c0854Fu.A00 != -1) {
            return c0854Fu.A02[i3];
        }
        return -9223372036854775807L;
    }

    public final C0731Am A0B(Object obj, Object obj2, int i2, long j2, long j3) {
        return A0C(obj, obj2, i2, j2, j3, C0856Fw.A06);
    }

    public final C0731Am A0C(Object obj, Object obj2, int i2, long j2, long j3, C0856Fw c0856Fw) {
        this.A02 = obj;
        this.A03 = obj2;
        this.A00 = i2;
        this.A01 = j2;
        this.A04 = j3;
        this.A05 = c0856Fw;
        return this;
    }

    public final boolean A0D(int i2) {
        return !this.A05.A04[i2].A02();
    }

    public final boolean A0E(int i2, int i3) {
        C0854Fu c0854Fu = this.A05.A04[i2];
        return (c0854Fu.A00 == -1 || c0854Fu.A01[i3] == 0) ? false : true;
    }
}
