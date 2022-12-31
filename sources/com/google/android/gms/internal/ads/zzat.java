package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzat {
    private static final Comparator<byte[]> zzcd = new zzaw();
    private final List<byte[]> zzbz = new ArrayList();
    private final List<byte[]> zzca = new ArrayList(64);
    private int zzcb = 0;
    private final int zzcc = 4096;

    public zzat(int i2) {
    }

    private final synchronized void zzn() {
        while (this.zzcb > this.zzcc) {
            byte[] remove = this.zzbz.remove(0);
            this.zzca.remove(remove);
            this.zzcb -= remove.length;
        }
    }

    public final synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.zzcc) {
                this.zzbz.add(bArr);
                int binarySearch = Collections.binarySearch(this.zzca, bArr, zzcd);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.zzca.add(binarySearch, bArr);
                this.zzcb += bArr.length;
                zzn();
            }
        }
    }

    public final synchronized byte[] zzf(int i2) {
        for (int i3 = 0; i3 < this.zzca.size(); i3++) {
            byte[] bArr = this.zzca.get(i3);
            if (bArr.length >= i2) {
                this.zzcb -= bArr.length;
                this.zzca.remove(i3);
                this.zzbz.remove(bArr);
                return bArr;
            }
        }
        return new byte[i2];
    }
}
