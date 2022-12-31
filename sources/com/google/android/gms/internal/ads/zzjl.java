package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzjl {
    public byte[] iv;
    private byte[] key;
    private int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    private int numSubSamples;
    private int zzanw;
    private int zzanx;
    private final MediaCodec.CryptoInfo zzany;
    private final zzjn zzanz;

    public zzjl() {
        int i2 = zzpt.SDK_INT;
        MediaCodec.CryptoInfo cryptoInfo = i2 >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzany = cryptoInfo;
        this.zzanz = i2 >= 24 ? new zzjn(cryptoInfo) : null;
    }

    public final void set(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3) {
        this.numSubSamples = i2;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i3;
        this.zzanw = 0;
        this.zzanx = 0;
        int i4 = zzpt.SDK_INT;
        if (i4 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.zzany;
            cryptoInfo.numSubSamples = i2;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = i3;
            if (i4 >= 24) {
                this.zzanz.set(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzgm() {
        return this.zzany;
    }
}
