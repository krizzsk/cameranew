package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzkt {
    private static final long[] zzass = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private int state;
    private final byte[] zzapa = new byte[8];

    public static int zzao(int i2) {
        int i3 = 0;
        while (true) {
            long[] jArr = zzass;
            if (i3 >= jArr.length) {
                return -1;
            }
            if ((jArr[i3] & i2) != 0) {
                return i3 + 1;
            }
            i3++;
        }
    }

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long zza(zzjz zzjzVar, boolean z, boolean z2, int i2) throws IOException, InterruptedException {
        if (this.state == 0) {
            if (!zzjzVar.zza(this.zzapa, 0, 1, z)) {
                return -1L;
            }
            int zzao = zzao(this.zzapa[0] & Draft_75.END_OF_FRAME);
            this.length = zzao;
            if (zzao != -1) {
                this.state = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i3 = this.length;
        if (i3 > i2) {
            this.state = 0;
            return -2L;
        }
        if (i3 != 1) {
            zzjzVar.readFully(this.zzapa, 1, i3 - 1);
        }
        this.state = 0;
        return zza(this.zzapa, this.length, z2);
    }

    public final int zzgw() {
        return this.length;
    }

    public static long zza(byte[] bArr, int i2, boolean z) {
        long j2 = bArr[0] & 255;
        if (z) {
            j2 &= ~zzass[i2 - 1];
        }
        for (int i3 = 1; i3 < i2; i3++) {
            j2 = (j2 << 8) | (bArr[i3] & 255);
        }
        return j2;
    }
}
