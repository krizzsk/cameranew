package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzng implements zznb, zznc {
    private zznu zzafg;
    private zznb zzbdy;
    public final zznc[] zzbff;
    private final IdentityHashMap<zznn, Integer> zzbfg = new IdentityHashMap<>();
    private int zzbfh;
    private zznc[] zzbfi;
    private zznq zzbfj;

    public zzng(zznc... zzncVarArr) {
        this.zzbff = zzncVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zza(zznb zznbVar, long j2) {
        this.zzbdy = zznbVar;
        zznc[] zzncVarArr = this.zzbff;
        this.zzbfh = zzncVarArr.length;
        for (zznc zzncVar : zzncVarArr) {
            zzncVar.zza(this, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc, com.google.android.gms.internal.ads.zznq
    public final boolean zzee(long j2) {
        return this.zzbfj.zzee(j2);
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzef(long j2) {
        for (zznc zzncVar : this.zzbfi) {
            zzncVar.zzef(j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzeg(long j2) {
        long zzeg = this.zzbfi[0].zzeg(j2);
        int i2 = 1;
        while (true) {
            zznc[] zzncVarArr = this.zzbfi;
            if (i2 >= zzncVarArr.length) {
                return zzeg;
            }
            if (zzncVarArr[i2].zzeg(zzeg) != zzeg) {
                throw new IllegalStateException("Children seeked to different positions");
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc, com.google.android.gms.internal.ads.zznq
    public final long zzhn() {
        return this.zzbfj.zzhn();
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzho() throws IOException {
        for (zznc zzncVar : this.zzbff) {
            zzncVar.zzho();
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final zznu zzhp() {
        return this.zzafg;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzhq() {
        zznc[] zzncVarArr;
        long zzhq = this.zzbff[0].zzhq();
        int i2 = 1;
        while (true) {
            zznc[] zzncVarArr2 = this.zzbff;
            if (i2 >= zzncVarArr2.length) {
                if (zzhq != -9223372036854775807L) {
                    for (zznc zzncVar : this.zzbfi) {
                        if (zzncVar != this.zzbff[0] && zzncVar.zzeg(zzhq) != zzhq) {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzhq;
            } else if (zzncVarArr2[i2].zzhq() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            } else {
                i2++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zzhr() {
        long j2 = Long.MAX_VALUE;
        for (zznc zzncVar : this.zzbfi) {
            long zzhr = zzncVar.zzhr();
            if (zzhr != Long.MIN_VALUE) {
                j2 = Math.min(j2, zzhr);
            }
        }
        if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final long zza(zzog[] zzogVarArr, boolean[] zArr, zznn[] zznnVarArr, boolean[] zArr2, long j2) {
        zznn[] zznnVarArr2 = zznnVarArr;
        int[] iArr = new int[zzogVarArr.length];
        int[] iArr2 = new int[zzogVarArr.length];
        for (int i2 = 0; i2 < zzogVarArr.length; i2++) {
            iArr[i2] = zznnVarArr2[i2] == null ? -1 : this.zzbfg.get(zznnVarArr2[i2]).intValue();
            iArr2[i2] = -1;
            if (zzogVarArr[i2] != null) {
                zznr zzil = zzogVarArr[i2].zzil();
                int i3 = 0;
                while (true) {
                    zznc[] zzncVarArr = this.zzbff;
                    if (i3 >= zzncVarArr.length) {
                        break;
                    } else if (zzncVarArr[i3].zzhp().zza(zzil) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.zzbfg.clear();
        int length = zzogVarArr.length;
        zznn[] zznnVarArr3 = new zznn[length];
        zznn[] zznnVarArr4 = new zznn[zzogVarArr.length];
        zzog[] zzogVarArr2 = new zzog[zzogVarArr.length];
        ArrayList arrayList = new ArrayList(this.zzbff.length);
        long j3 = j2;
        int i4 = 0;
        while (i4 < this.zzbff.length) {
            for (int i5 = 0; i5 < zzogVarArr.length; i5++) {
                zzog zzogVar = null;
                zznnVarArr4[i5] = iArr[i5] == i4 ? zznnVarArr2[i5] : null;
                if (iArr2[i5] == i4) {
                    zzogVar = zzogVarArr[i5];
                }
                zzogVarArr2[i5] = zzogVar;
            }
            int i6 = i4;
            zzog[] zzogVarArr3 = zzogVarArr2;
            ArrayList arrayList2 = arrayList;
            long zza = this.zzbff[i4].zza(zzogVarArr2, zArr, zznnVarArr4, zArr2, j3);
            if (i6 == 0) {
                j3 = zza;
            } else if (zza != j3) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i7 = 0; i7 < zzogVarArr.length; i7++) {
                if (iArr2[i7] == i6) {
                    zzpg.checkState(zznnVarArr4[i7] != null);
                    zznnVarArr3[i7] = zznnVarArr4[i7];
                    this.zzbfg.put(zznnVarArr4[i7], Integer.valueOf(i6));
                    z = true;
                } else if (iArr[i7] == i6) {
                    zzpg.checkState(zznnVarArr4[i7] == null);
                }
            }
            if (z) {
                arrayList2.add(this.zzbff[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            zzogVarArr2 = zzogVarArr3;
            zznnVarArr2 = zznnVarArr;
        }
        zznn[] zznnVarArr5 = zznnVarArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zznnVarArr3, 0, zznnVarArr5, 0, length);
        zznc[] zzncVarArr2 = new zznc[arrayList3.size()];
        this.zzbfi = zzncVarArr2;
        arrayList3.toArray(zzncVarArr2);
        this.zzbfj = new zzmp(this.zzbfi);
        return j3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zznb
    public final void zza(zznc zzncVar) {
        int i2 = this.zzbfh - 1;
        this.zzbfh = i2;
        if (i2 > 0) {
            return;
        }
        int i3 = 0;
        for (zznc zzncVar2 : this.zzbff) {
            i3 += zzncVar2.zzhp().length;
        }
        zznr[] zznrVarArr = new zznr[i3];
        int i4 = 0;
        for (zznc zzncVar3 : this.zzbff) {
            zznu zzhp = zzncVar3.zzhp();
            int i5 = zzhp.length;
            int i6 = 0;
            while (i6 < i5) {
                zznrVarArr[i4] = zzhp.zzbc(i6);
                i6++;
                i4++;
            }
        }
        this.zzafg = new zznu(zznrVarArr);
        this.zzbdy.zza((zznc) this);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final /* synthetic */ void zza(zznc zzncVar) {
        if (this.zzafg != null) {
            this.zzbdy.zza((zznb) this);
        }
    }
}
