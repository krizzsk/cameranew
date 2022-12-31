package com.google.android.gms.internal.ads;

import java.io.OutputStream;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeka extends OutputStream {
    private static final byte[] zzimf = new byte[0];
    private int zzimi;
    private int zzimj;
    private final int zzimg = 128;
    private final ArrayList<zzejr> zzimh = new ArrayList<>();
    private byte[] buffer = new byte[128];

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeka(int i2) {
    }

    private final synchronized int size() {
        return this.zzimi + this.zzimj;
    }

    private final void zzgc(int i2) {
        this.zzimh.add(new zzekb(this.buffer));
        int length = this.zzimi + this.buffer.length;
        this.zzimi = length;
        this.buffer = new byte[Math.max(this.zzimg, Math.max(i2, length >>> 1))];
        this.zzimj = 0;
    }

    public final String toString() {
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int i2) {
        if (this.zzimj == this.buffer.length) {
            zzgc(1);
        }
        byte[] bArr = this.buffer;
        int i3 = this.zzimj;
        this.zzimj = i3 + 1;
        bArr[i3] = (byte) i2;
    }

    public final synchronized zzejr zzbfz() {
        int i2 = this.zzimj;
        byte[] bArr = this.buffer;
        if (i2 >= bArr.length) {
            this.zzimh.add(new zzekb(this.buffer));
            this.buffer = zzimf;
        } else if (i2 > 0) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i2));
            this.zzimh.add(new zzekb(bArr2));
        }
        this.zzimi += this.zzimj;
        this.zzimj = 0;
        return zzejr.zzl(this.zzimh);
    }

    @Override // java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = this.buffer;
        int length = bArr2.length;
        int i4 = this.zzimj;
        if (i3 <= length - i4) {
            System.arraycopy(bArr, i2, bArr2, i4, i3);
            this.zzimj += i3;
            return;
        }
        int length2 = bArr2.length - i4;
        System.arraycopy(bArr, i2, bArr2, i4, length2);
        int i5 = i3 - length2;
        zzgc(i5);
        System.arraycopy(bArr, i2 + length2, this.buffer, 0, i5);
        this.zzimj = i5;
    }
}
