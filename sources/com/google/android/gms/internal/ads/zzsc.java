package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzsc extends zzrv {
    private MessageDigest zzbuj;
    private final int zzbuk;
    private final int zzbul;

    public zzsc(int i2) {
        int i3 = i2 / 8;
        this.zzbuk = i2 % 8 > 0 ? i3 + 1 : i3;
        this.zzbul = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzrv
    public final byte[] zzbq(String str) {
        synchronized (this.mLock) {
            MessageDigest zzms = zzms();
            this.zzbuj = zzms;
            if (zzms == null) {
                return new byte[0];
            }
            zzms.reset();
            this.zzbuj.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] digest = this.zzbuj.digest();
            int length = digest.length;
            int i2 = this.zzbuk;
            if (length <= i2) {
                i2 = digest.length;
            }
            byte[] bArr = new byte[i2];
            System.arraycopy(digest, 0, bArr, 0, i2);
            if (this.zzbul % 8 > 0) {
                long j2 = 0;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (i3 > 0) {
                        j2 <<= 8;
                    }
                    j2 += bArr[i3] & Draft_75.END_OF_FRAME;
                }
                long j3 = j2 >>> (8 - (this.zzbul % 8));
                for (int i4 = this.zzbuk - 1; i4 >= 0; i4--) {
                    bArr[i4] = (byte) (255 & j3);
                    j3 >>>= 8;
                }
            }
            return bArr;
        }
    }
}
