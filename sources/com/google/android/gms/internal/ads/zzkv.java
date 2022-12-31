package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzkv extends zzkw {
    public final long zzasu;
    public final List<zzky> zzasv;
    public final List<zzkv> zzasw;

    public zzkv(int i2, long j2) {
        super(i2);
        this.zzasu = j2;
        this.zzasv = new ArrayList();
        this.zzasw = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final String toString() {
        String zzat = zzkw.zzat(this.type);
        String arrays = Arrays.toString(this.zzasv.toArray());
        String arrays2 = Arrays.toString(this.zzasw.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(zzat).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(zzat);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }

    public final void zza(zzky zzkyVar) {
        this.zzasv.add(zzkyVar);
    }

    public final zzky zzap(int i2) {
        int size = this.zzasv.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzky zzkyVar = this.zzasv.get(i3);
            if (zzkyVar.type == i2) {
                return zzkyVar;
            }
        }
        return null;
    }

    public final zzkv zzaq(int i2) {
        int size = this.zzasw.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzkv zzkvVar = this.zzasw.get(i3);
            if (zzkvVar.type == i2) {
                return zzkvVar;
            }
        }
        return null;
    }

    public final void zza(zzkv zzkvVar) {
        this.zzasw.add(zzkvVar);
    }
}
