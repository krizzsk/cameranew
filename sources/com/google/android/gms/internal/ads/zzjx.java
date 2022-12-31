package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzjx implements zzjz {
    private static final byte[] zzaoo = new byte[4096];
    private long position;
    private final zzon zzaop;
    private final long zzaoq;
    private byte[] zzaor = new byte[65536];
    private int zzaos;
    private int zzaot;

    public zzjx(zzon zzonVar, long j2, long j3) {
        this.zzaop = zzonVar;
        this.position = j2;
        this.zzaoq = j3;
    }

    private final int zzai(int i2) {
        int min = Math.min(this.zzaot, i2);
        zzaj(min);
        return min;
    }

    private final void zzaj(int i2) {
        int i3 = this.zzaot - i2;
        this.zzaot = i3;
        this.zzaos = 0;
        byte[] bArr = this.zzaor;
        byte[] bArr2 = i3 < bArr.length - 524288 ? new byte[65536 + i3] : bArr;
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        this.zzaor = bArr2;
    }

    private final void zzak(int i2) {
        if (i2 != -1) {
            this.position += i2;
        }
    }

    private final int zzb(byte[] bArr, int i2, int i3) {
        int i4 = this.zzaot;
        if (i4 == 0) {
            return 0;
        }
        int min = Math.min(i4, i3);
        System.arraycopy(this.zzaor, 0, bArr, i2, min);
        zzaj(min);
        return min;
    }

    private final boolean zzd(int i2, boolean z) throws IOException, InterruptedException {
        int i3 = this.zzaos + i2;
        byte[] bArr = this.zzaor;
        if (i3 > bArr.length) {
            this.zzaor = Arrays.copyOf(this.zzaor, zzpt.zzd(bArr.length << 1, 65536 + i3, i3 + 524288));
        }
        int min = Math.min(this.zzaot - this.zzaos, i2);
        while (min < i2) {
            min = zza(this.zzaor, this.zzaos, i2, min, false);
            if (min == -1) {
                return false;
            }
        }
        int i4 = this.zzaos + i2;
        this.zzaos = i4;
        this.zzaot = Math.max(this.zzaot, i4);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final long getLength() {
        return this.zzaoq;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final long getPosition() {
        return this.position;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final int read(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        int zzb = zzb(bArr, i2, i3);
        if (zzb == 0) {
            zzb = zza(bArr, i2, i3, 0, true);
        }
        zzak(zzb);
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void readFully(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        zza(bArr, i2, i3, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final boolean zza(byte[] bArr, int i2, int i3, boolean z) throws IOException, InterruptedException {
        int zzb = zzb(bArr, i2, i3);
        while (zzb < i3 && zzb != -1) {
            zzb = zza(bArr, i2, i3, zzb, z);
        }
        zzak(zzb);
        return zzb != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final int zzaf(int i2) throws IOException, InterruptedException {
        int zzai = zzai(i2);
        if (zzai == 0) {
            byte[] bArr = zzaoo;
            zzai = zza(bArr, 0, Math.min(i2, bArr.length), 0, true);
        }
        zzak(zzai);
        return zzai;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void zzag(int i2) throws IOException, InterruptedException {
        int zzai = zzai(i2);
        while (zzai < i2 && zzai != -1) {
            byte[] bArr = zzaoo;
            zzai = zza(bArr, -zzai, Math.min(i2, bArr.length + zzai), zzai, false);
        }
        zzak(zzai);
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void zzah(int i2) throws IOException, InterruptedException {
        zzd(i2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void zzgq() {
        this.zzaos = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzjz
    public final void zza(byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        if (zzd(i3, false)) {
            System.arraycopy(this.zzaor, this.zzaos - i3, bArr, i2, i3);
        }
    }

    private final int zza(byte[] bArr, int i2, int i3, int i4, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.zzaop.read(bArr, i2 + i4, i3 - i4);
            if (read == -1) {
                if (i4 == 0 && z) {
                    return -1;
                }
                throw new EOFException();
            }
            return i4 + read;
        }
        throw new InterruptedException();
    }
}
