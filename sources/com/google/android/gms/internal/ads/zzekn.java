package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzekn implements zzeoy {
    private final zzekl zzime;

    private zzekn(zzekl zzeklVar) {
        zzekl zzeklVar2 = (zzekl) zzeld.zza(zzeklVar, "output");
        this.zzime = zzeklVar2;
        zzeklVar2.zzind = this;
    }

    public static zzekn zza(zzekl zzeklVar) {
        zzekn zzeknVar = zzeklVar.zzind;
        return zzeknVar != null ? zzeknVar : new zzekn(zzeklVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzac(int i2, int i3) throws IOException {
        this.zzime.zzac(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzad(int i2, int i3) throws IOException {
        this.zzime.zzad(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzae(int i2, int i3) throws IOException {
        this.zzime.zzae(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzaf(int i2, int i3) throws IOException {
        this.zzime.zzaf(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzam(int i2, int i3) throws IOException {
        this.zzime.zzaf(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzan(int i2, int i3) throws IOException {
        this.zzime.zzac(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzb(int i2, double d2) throws IOException {
        this.zzime.zzb(i2, d2);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final int zzbhv() {
        return zzeox.zzixh;
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzc(int i2, Object obj) throws IOException {
        if (obj instanceof zzejr) {
            this.zzime.zzb(i2, (zzejr) obj);
        } else {
            this.zzime.zza(i2, (zzemo) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzd(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzfl(list.get(i5).longValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzfh(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzi(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zze(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzfn(list.get(i5).longValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzfj(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzk(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzf(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzg(list.get(i5).floatValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzf(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zza(i2, list.get(i3).floatValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzg(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzd(list.get(i5).doubleValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzc(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzb(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzh(int i2, boolean z) throws IOException {
        this.zzime.zzh(i2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzhe(int i2) throws IOException {
        this.zzime.writeTag(i2, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzhf(int i2) throws IOException {
        this.zzime.writeTag(i2, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzi(int i2, long j2) throws IOException {
        this.zzime.zzi(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzj(int i2, long j2) throws IOException {
        this.zzime.zzj(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzk(int i2, long j2) throws IOException {
        this.zzime.zzk(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzl(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzfo(list.get(i5).longValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzfj(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzk(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzm(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzgy(list.get(i5).intValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzgt(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzae(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzn(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzfm(list.get(i5).longValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzfi(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzj(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzq(int i2, long j2) throws IOException {
        this.zzime.zzi(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzr(int i2, long j2) throws IOException {
        this.zzime.zzk(i2, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzb(int i2, Object obj, zzenj zzenjVar) throws IOException {
        zzekl zzeklVar = this.zzime;
        zzeklVar.writeTag(i2, 3);
        zzenjVar.zza((zzemo) obj, zzeklVar.zzind);
        zzeklVar.writeTag(i2, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzh(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzhb(list.get(i5).intValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzgr(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzac(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzi(int i2, String str) throws IOException {
        this.zzime.zzi(i2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzj(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzgx(list.get(i5).intValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzgs(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzad(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzk(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzha(list.get(i5).intValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzgu(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzaf(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zza(int i2, float f2) throws IOException {
        this.zzime.zza(i2, f2);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzi(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzbs(list.get(i5).booleanValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzbr(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzh(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zza(int i2, zzejr zzejrVar) throws IOException {
        this.zzime.zza(i2, zzejrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzc(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzfk(list.get(i5).longValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzfh(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzi(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zza(int i2, Object obj, zzenj zzenjVar) throws IOException {
        this.zzime.zza(i2, (zzemo) obj, zzenjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zza(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzgw(list.get(i5).intValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzgr(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzac(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzb(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzime.writeTag(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzekl.zzgz(list.get(i5).intValue());
            }
            this.zzime.zzgs(i4);
            while (i3 < list.size()) {
                this.zzime.zzgu(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzaf(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zza(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof zzelv) {
            zzelv zzelvVar = (zzelv) list;
            while (i3 < list.size()) {
                Object zzhj = zzelvVar.zzhj(i3);
                if (zzhj instanceof String) {
                    this.zzime.zzi(i2, (String) zzhj);
                } else {
                    this.zzime.zza(i2, (zzejr) zzhj);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzime.zzi(i2, list.get(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzb(int i2, List<zzejr> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.zzime.zza(i2, list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zzb(int i2, List<?> list, zzenj zzenjVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzb(i2, list.get(i3), zzenjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final void zza(int i2, List<?> list, zzenj zzenjVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            zza(i2, list.get(i3), zzenjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeoy
    public final <K, V> void zza(int i2, zzemf<K, V> zzemfVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzime.writeTag(i2, 2);
            this.zzime.zzgs(zzemg.zza(zzemfVar, entry.getKey(), entry.getValue()));
            zzemg.zza(this.zzime, zzemfVar, entry.getKey(), entry.getValue());
        }
    }
}
