package com.google.android.gms.internal.ads;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzene implements zzemm {
    private final int flags;
    private final String info;
    private final Object[] zziss;
    private final zzemo zzisv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzene(zzemo zzemoVar, String str, Object[] objArr) {
        this.zzisv = zzemoVar;
        this.info = str;
        this.zziss = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        int i2 = charAt & 8191;
        int i3 = 13;
        int i4 = 1;
        while (true) {
            int i5 = i4 + 1;
            char charAt2 = str.charAt(i4);
            if (charAt2 < 55296) {
                this.flags = i2 | (charAt2 << i3);
                return;
            }
            i2 |= (charAt2 & 8191) << i3;
            i3 += 13;
            i4 = i5;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemm
    public final int zzbjy() {
        return (this.flags & 1) == 1 ? zzemz.zzitk : zzemz.zzitl;
    }

    @Override // com.google.android.gms.internal.ads.zzemm
    public final boolean zzbjz() {
        return (this.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.ads.zzemm
    public final zzemo zzbka() {
        return this.zzisv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzbkg() {
        return this.info;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zzbkh() {
        return this.zziss;
    }
}
