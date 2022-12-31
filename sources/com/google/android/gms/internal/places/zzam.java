package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
final class zzam implements zzel {
    private final zzaj zzem;

    private zzam(zzaj zzajVar) {
        zzaj zzajVar2 = (zzaj) zzbd.zzb(zzajVar, "output");
        this.zzem = zzajVar2;
        zzajVar2.zzes = this;
    }

    public static zzam zzb(zzaj zzajVar) {
        zzam zzamVar = zzajVar.zzes;
        return zzamVar != null ? zzamVar : new zzam(zzajVar);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzaa(int i2) throws IOException {
        this.zzem.zzc(i2, 3);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzab(int i2) throws IOException {
        this.zzem.zzc(i2, 4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final int zzam() {
        return zzbc.zze.zziw;
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i2, boolean z) throws IOException {
        this.zzem.zzc(i2, z);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzd(int i2, int i3) throws IOException {
        this.zzem.zzd(i2, i3);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zze(int i2, int i3) throws IOException {
        this.zzem.zze(i2, i3);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzf(int i2, int i3) throws IOException {
        this.zzem.zzf(i2, i3);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzg(int i2, int i3) throws IOException {
        this.zzem.zzg(i2, i3);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzh(int i2, List<Double> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzc(list.get(i5).doubleValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzb(list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzb(i2, list.get(i3).doubleValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzi(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzx(list.get(i5).intValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzn(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzd(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzj(int i2, long j2) throws IOException {
        this.zzem.zzb(i2, j2);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzk(int i2, long j2) throws IOException {
        this.zzem.zzd(i2, j2);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzl(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzw(list.get(i5).intValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzq(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzg(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzm(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzj(list.get(i5).longValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zze(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzd(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzn(int i2, int i3) throws IOException {
        this.zzem.zzg(i2, i3);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzo(int i2, int i3) throws IOException {
        this.zzem.zzd(i2, i3);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i2, long j2) throws IOException {
        this.zzem.zzc(i2, j2);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzd(int i2, long j2) throws IOException {
        this.zzem.zzd(i2, j2);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zze(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzg(list.get(i5).longValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzc(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzb(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzf(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzi(list.get(i5).longValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zze(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzd(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzg(int i2, List<Float> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zze(list.get(i5).floatValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzd(list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzb(i2, list.get(i3).floatValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i2, float f2) throws IOException {
        this.zzem.zzb(i2, f2);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i2, Object obj, zzda zzdaVar) throws IOException {
        zzaj zzajVar = this.zzem;
        zzajVar.zzc(i2, 3);
        zzdaVar.zzb((zzck) obj, zzajVar.zzes);
        zzajVar.zzc(i2, 4);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzd(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzf(list.get(i5).longValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzc(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzb(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzj(int i2, List<Boolean> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzd(list.get(i5).booleanValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzc(list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzc(i2, list.get(i3).booleanValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzk(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzt(list.get(i5).intValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzo(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zze(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzn(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzu(list.get(i5).intValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzp(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzf(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzo(int i2, List<Long> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzh(list.get(i5).longValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzd(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzc(i2, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i2, double d2) throws IOException {
        this.zzem.zzb(i2, d2);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i2, long j2) throws IOException {
        this.zzem.zzb(i2, j2);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i2, String str) throws IOException {
        this.zzem.zzb(i2, str);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i2, zzw zzwVar) throws IOException {
        this.zzem.zzb(i2, zzwVar);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzv(list.get(i5).intValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzq(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzg(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i2, Object obj, zzda zzdaVar) throws IOException {
        this.zzem.zzb(i2, (zzck) obj, zzdaVar);
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i2, Object obj) throws IOException {
        if (obj instanceof zzw) {
            this.zzem.zzc(i2, (zzw) obj);
        } else {
            this.zzem.zzb(i2, (zzck) obj);
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i2, List<Integer> list, boolean z) throws IOException {
        int i3 = 0;
        if (z) {
            this.zzem.zzc(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                i4 += zzaj.zzs(list.get(i5).intValue());
            }
            this.zzem.zzo(i4);
            while (i3 < list.size()) {
                this.zzem.zzn(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzd(i2, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i2, List<zzw> list) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.zzem.zzb(i2, list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzc(int i2, List<?> list, zzda zzdaVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzc(i2, list.get(i3), zzdaVar);
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i2, List<String> list) throws IOException {
        int i3 = 0;
        if (list instanceof zzbr) {
            zzbr zzbrVar = (zzbr) list;
            while (i3 < list.size()) {
                Object zzae = zzbrVar.zzae(i3);
                if (zzae instanceof String) {
                    this.zzem.zzb(i2, (String) zzae);
                } else {
                    this.zzem.zzb(i2, (zzw) zzae);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zzem.zzb(i2, list.get(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final void zzb(int i2, List<?> list, zzda zzdaVar) throws IOException {
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzb(i2, list.get(i3), zzdaVar);
        }
    }

    @Override // com.google.android.gms.internal.places.zzel
    public final <K, V> void zzb(int i2, zzcb<K, V> zzcbVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzem.zzc(i2, 2);
            this.zzem.zzo(zzcc.zzb(zzcbVar, entry.getKey(), entry.getValue()));
            zzcc.zzb(this.zzem, zzcbVar, entry.getKey(), entry.getValue());
        }
    }
}
