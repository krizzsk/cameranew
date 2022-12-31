package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzku {
    private final zzpn zzapt = new zzpn(8);
    private int zzast;

    private final long zzc(zzjz zzjzVar) throws IOException, InterruptedException {
        int i2 = 0;
        zzjzVar.zza(this.zzapt.data, 0, 1);
        int i3 = this.zzapt.data[0] & Draft_75.END_OF_FRAME;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while ((i3 & i4) == 0) {
            i4 >>= 1;
            i5++;
        }
        int i6 = i3 & (~i4);
        zzjzVar.zza(this.zzapt.data, 1, i5);
        while (i2 < i5) {
            i2++;
            i6 = (this.zzapt.data[i2] & Draft_75.END_OF_FRAME) + (i6 << 8);
        }
        this.zzast += i5 + 1;
        return i6;
    }

    public final boolean zza(zzjz zzjzVar) throws IOException, InterruptedException {
        long zzc;
        int i2;
        long length = zzjzVar.getLength();
        long j2 = 1024;
        int i3 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i3 != 0 && length <= 1024) {
            j2 = length;
        }
        int i4 = (int) j2;
        zzjzVar.zza(this.zzapt.data, 0, 4);
        long zzix = this.zzapt.zzix();
        this.zzast = 4;
        while (zzix != 440786851) {
            int i5 = this.zzast + 1;
            this.zzast = i5;
            if (i5 == i4) {
                return false;
            }
            zzjzVar.zza(this.zzapt.data, 0, 1);
            zzix = ((zzix << 8) & (-256)) | (this.zzapt.data[0] & Draft_75.END_OF_FRAME);
        }
        long zzc2 = zzc(zzjzVar);
        long j3 = this.zzast;
        if (zzc2 != Long.MIN_VALUE && (i3 == 0 || j3 + zzc2 < length)) {
            while (true) {
                int i6 = this.zzast;
                long j4 = j3 + zzc2;
                if (i6 < j4) {
                    if (zzc(zzjzVar) != Long.MIN_VALUE && (zzc(zzjzVar)) >= 0 && zzc <= 2147483647L) {
                        if (i2 != 0) {
                            zzjzVar.zzah((int) zzc);
                            this.zzast = (int) (this.zzast + zzc);
                        }
                    }
                } else if (i6 == j4) {
                    return true;
                }
            }
        }
        return false;
    }
}
