package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzpn {
    public byte[] data;
    private int limit;
    private int position;

    public zzpn() {
    }

    public final int capacity() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int limit() {
        return this.limit;
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = i3 + 1;
        this.position = i4;
        int i5 = ((bArr[i2] & Draft_75.END_OF_FRAME) << 24) | ((bArr[i3] & Draft_75.END_OF_FRAME) << 16);
        int i6 = i4 + 1;
        this.position = i6;
        int i7 = i5 | ((bArr[i4] & Draft_75.END_OF_FRAME) << 8);
        this.position = i6 + 1;
        return (bArr[i6] & Draft_75.END_OF_FRAME) | i7;
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = i3 + 1;
        this.position = i4;
        int i5 = i4 + 1;
        this.position = i5;
        int i6 = i5 + 1;
        this.position = i6;
        int i7 = i6 + 1;
        this.position = i7;
        int i8 = i7 + 1;
        this.position = i8;
        int i9 = i8 + 1;
        this.position = i9;
        this.position = i9 + 1;
        return ((bArr[i2] & 255) << 56) | ((bArr[i3] & 255) << 48) | ((bArr[i4] & 255) << 40) | ((bArr[i5] & 255) << 32) | ((bArr[i6] & 255) << 24) | ((bArr[i7] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
    }

    public final short readShort() {
        byte[] bArr = this.data;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        this.position = i3 + 1;
        return (short) ((bArr[i3] & Draft_75.END_OF_FRAME) | ((bArr[i2] & Draft_75.END_OF_FRAME) << 8));
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        return bArr[i2] & Draft_75.END_OF_FRAME;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        this.position = i3 + 1;
        return (bArr[i3] & Draft_75.END_OF_FRAME) | ((bArr[i2] & Draft_75.END_OF_FRAME) << 8);
    }

    public final void reset(int i2) {
        zzc(capacity() < i2 ? new byte[i2] : this.data, i2);
    }

    public final void zzbh(int i2) {
        zzpg.checkArgument(i2 >= 0 && i2 <= this.data.length);
        this.limit = i2;
    }

    public final void zzbi(int i2) {
        zzpg.checkArgument(i2 >= 0 && i2 <= this.limit);
        this.position = i2;
    }

    public final void zzbj(int i2) {
        zzbi(this.position + i2);
    }

    public final String zzbk(int i2) {
        if (i2 == 0) {
            return "";
        }
        int i3 = (this.position + i2) - 1;
        String str = new String(this.data, this.position, (i3 >= this.limit || this.data[i3] != 0) ? i2 : i2 - 1);
        this.position += i2;
        return str;
    }

    public final void zzc(byte[] bArr, int i2) {
        this.data = bArr;
        this.limit = i2;
        this.position = 0;
    }

    public final void zze(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.data, this.position, bArr, i2, i3);
        this.position += i3;
    }

    public final int zziv() {
        return this.limit - this.position;
    }

    public final int zziw() {
        byte[] bArr = this.data;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = bArr[i2] & Draft_75.END_OF_FRAME;
        this.position = i3 + 1;
        return ((bArr[i3] & Draft_75.END_OF_FRAME) << 8) | i4;
    }

    public final long zzix() {
        byte[] bArr = this.data;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = i3 + 1;
        this.position = i4;
        int i5 = i4 + 1;
        this.position = i5;
        this.position = i5 + 1;
        return ((bArr[i2] & 255) << 24) | ((bArr[i3] & 255) << 16) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
    }

    public final long zziy() {
        byte[] bArr = this.data;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = i3 + 1;
        this.position = i4;
        int i5 = i4 + 1;
        this.position = i5;
        this.position = i5 + 1;
        return (bArr[i2] & 255) | ((bArr[i3] & 255) << 8) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 24);
    }

    public final int zziz() {
        byte[] bArr = this.data;
        int i2 = this.position;
        int i3 = i2 + 1;
        this.position = i3;
        int i4 = i3 + 1;
        this.position = i4;
        int i5 = (bArr[i3] & Draft_75.END_OF_FRAME) | ((bArr[i2] & Draft_75.END_OF_FRAME) << 8);
        this.position = i4 + 2;
        return i5;
    }

    public final int zzja() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(readInt);
        throw new IllegalStateException(sb.toString());
    }

    public final long zzjb() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(readLong);
        throw new IllegalStateException(sb.toString());
    }

    public final String zzjc() {
        if (zziv() == 0) {
            return null;
        }
        int i2 = this.position;
        while (i2 < this.limit && this.data[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.data;
        int i3 = this.position;
        String str = new String(bArr, i3, i2 - i3);
        this.position = i2;
        if (i2 < this.limit) {
            this.position = i2 + 1;
        }
        return str;
    }

    public zzpn(int i2) {
        this.data = new byte[i2];
        this.limit = i2;
    }

    public final void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public zzpn(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }
}
