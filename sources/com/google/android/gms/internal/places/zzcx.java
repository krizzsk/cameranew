package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzcx implements zzci {
    private final int flags;
    private final String info;
    private final Object[] zzkt;
    private final zzck zzkw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcx(zzck zzckVar, String str, Object[] objArr) {
        this.zzkw = zzckVar;
        this.info = str;
        this.zzkt = objArr;
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

    @Override // com.google.android.gms.internal.places.zzci
    public final int zzcj() {
        return (this.flags & 1) == 1 ? zzbc.zze.zzit : zzbc.zze.zziu;
    }

    @Override // com.google.android.gms.internal.places.zzci
    public final boolean zzck() {
        return (this.flags & 2) == 2;
    }

    @Override // com.google.android.gms.internal.places.zzci
    public final zzck zzcl() {
        return this.zzkw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzcr() {
        return this.info;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zzcs() {
        return this.zzkt;
    }
}
