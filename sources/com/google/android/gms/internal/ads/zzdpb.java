package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.internal.ads.zzug;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdpb implements zzdpc {
    @GuardedBy("this")
    private final ConcurrentHashMap<zzdpl, zzdoz> zzhmy;
    private zzdpf zzhmz;
    private zzdpd zzhna = new zzdpd();

    public zzdpb(zzdpf zzdpfVar) {
        this.zzhmy = new ConcurrentHashMap<>(zzdpfVar.zzhno);
        this.zzhmz = zzdpfVar;
    }

    private final void dumpToLog() {
        if (zzdpf.zzawe()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzhmz.zzhnm);
            sb.append(" PoolCollection");
            sb.append(this.zzhna.zzawd());
            int i2 = 0;
            for (Map.Entry<zzdpl, zzdoz> entry : this.zzhmy.entrySet()) {
                i2++;
                sb.append(i2);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(entry.getKey().hashCode());
                sb.append("    ");
                for (int i3 = 0; i3 < entry.getValue().size(); i3++) {
                    sb.append("[O]");
                }
                for (int size = entry.getValue().size(); size < this.zzhmz.zzhno; size++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(entry.getValue().zzavs());
                sb.append("\n");
            }
            while (i2 < this.zzhmz.zzhnn) {
                i2++;
                sb.append(i2);
                sb.append(".\n");
            }
            zzazk.zzdy(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpc
    @Nullable
    public final synchronized zzdpm<?> zza(zzdpl zzdplVar) {
        zzdpm<?> zzdpmVar;
        zzdoz zzdozVar = this.zzhmy.get(zzdplVar);
        zzdpmVar = null;
        if (zzdozVar != null) {
            zzdpmVar = zzdozVar.zzavp();
            if (zzdpmVar == null) {
                this.zzhna.zzavy();
            }
            zza(zzdpmVar, zzdozVar.zzavt());
        } else {
            this.zzhna.zzavx();
            zza((zzdpm<?>) null, (zzdqb) null);
        }
        return zzdpmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdpc
    public final zzdpf zzavw() {
        return this.zzhmz;
    }

    @Override // com.google.android.gms.internal.ads.zzdpc
    public final synchronized boolean zzb(zzdpl zzdplVar) {
        zzdoz zzdozVar = this.zzhmy.get(zzdplVar);
        if (zzdozVar != null) {
            return zzdozVar.size() < this.zzhmz.zzhno;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdpc
    public final synchronized boolean zza(zzdpl zzdplVar, zzdpm<?> zzdpmVar) {
        boolean zzb;
        zzdoz zzdozVar = this.zzhmy.get(zzdplVar);
        zzdpmVar.zzhoj = com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis();
        if (zzdozVar == null) {
            zzdpf zzdpfVar = this.zzhmz;
            zzdozVar = new zzdoz(zzdpfVar.zzhno, zzdpfVar.zzhnp * 1000);
            int size = this.zzhmy.size();
            zzdpf zzdpfVar2 = this.zzhmz;
            if (size == zzdpfVar2.zzhnn) {
                int i2 = zzdpe.zzhnh[zzdpfVar2.zzhns - 1];
                long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
                zzdpl zzdplVar2 = null;
                if (i2 == 1) {
                    for (Map.Entry<zzdpl, zzdoz> entry : this.zzhmy.entrySet()) {
                        if (entry.getValue().getCreationTimeMillis() < j2) {
                            j2 = entry.getValue().getCreationTimeMillis();
                            zzdplVar2 = entry.getKey();
                        }
                    }
                    if (zzdplVar2 != null) {
                        this.zzhmy.remove(zzdplVar2);
                    }
                } else if (i2 == 2) {
                    for (Map.Entry<zzdpl, zzdoz> entry2 : this.zzhmy.entrySet()) {
                        if (entry2.getValue().zzavq() < j2) {
                            j2 = entry2.getValue().zzavq();
                            zzdplVar2 = entry2.getKey();
                        }
                    }
                    if (zzdplVar2 != null) {
                        this.zzhmy.remove(zzdplVar2);
                    }
                } else if (i2 == 3) {
                    int i3 = Integer.MAX_VALUE;
                    for (Map.Entry<zzdpl, zzdoz> entry3 : this.zzhmy.entrySet()) {
                        if (entry3.getValue().zzavr() < i3) {
                            i3 = entry3.getValue().zzavr();
                            zzdplVar2 = entry3.getKey();
                        }
                    }
                    if (zzdplVar2 != null) {
                        this.zzhmy.remove(zzdplVar2);
                    }
                }
                this.zzhna.zzawa();
            }
            this.zzhmy.put(zzdplVar, zzdozVar);
            this.zzhna.zzavz();
        }
        zzb = zzdozVar.zzb(zzdpmVar);
        this.zzhna.zzawb();
        zzdpg zzawc = this.zzhna.zzawc();
        zzdqb zzavt = zzdozVar.zzavt();
        if (zzdpmVar != null) {
            zzdpmVar.zzhoh.zzalc().zzd((zzug.zzb) ((zzelb) zzug.zzb.zznl().zza(zzug.zzb.zza.zznn().zza(zzug.zzb.EnumC0162zzb.IN_MEMORY).zza(zzug.zzb.zze.zznr().zzs(zzawc.zzhnv).zzt(zzawc.zzhnw).zzca(zzavt.zzhpe))).zzbiw()));
        }
        dumpToLog();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdpc
    @Deprecated
    public final zzdpl zza(zzvl zzvlVar, String str, zzvx zzvxVar) {
        return new zzdpo(zzvlVar, str, new zzaty(this.zzhmz.context).zzws().zzdyc, this.zzhmz.zzhnq, zzvxVar);
    }

    private final void zza(zzdpm<?> zzdpmVar, zzdqb zzdqbVar) {
        if (zzdpmVar != null) {
            zzdpmVar.zzhoh.zzalc().zzc((zzug.zzb) ((zzelb) zzug.zzb.zznl().zza(zzug.zzb.zza.zznn().zza(zzug.zzb.EnumC0162zzb.IN_MEMORY).zza(zzug.zzb.zzd.zznp().zzq(zzdqbVar.zzhpd).zzby(zzdqbVar.zzhpe))).zzbiw()));
        }
        dumpToLog();
    }
}
