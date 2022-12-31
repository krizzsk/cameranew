package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zznf implements zzne {
    private final zzne[] zzbey;
    private final ArrayList<zzne> zzbez;
    private zznd zzbfa;
    private zzid zzbfb;
    private Object zzbfc;
    private zznh zzbfe;
    private final zzie zzaew = new zzie();
    private int zzbfd = -1;

    public zznf(zzne... zzneVarArr) {
        this.zzbey = zzneVarArr;
        this.zzbez = new ArrayList<>(Arrays.asList(zzneVarArr));
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zza(zzhh zzhhVar, boolean z, zznd zzndVar) {
        this.zzbfa = zzndVar;
        int i2 = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzbey;
            if (i2 >= zzneVarArr.length) {
                return;
            }
            zzneVarArr[i2].zza(zzhhVar, false, new zzni(this, i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zzb(zznc zzncVar) {
        zzng zzngVar = (zzng) zzncVar;
        int i2 = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzbey;
            if (i2 >= zzneVarArr.length) {
                return;
            }
            zzneVarArr[i2].zzb(zzngVar.zzbff[i2]);
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zzhz() throws IOException {
        zznh zznhVar = this.zzbfe;
        if (zznhVar == null) {
            for (zzne zzneVar : this.zzbey) {
                zzneVar.zzhz();
            }
            return;
        }
        throw zznhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final void zzia() {
        for (zzne zzneVar : this.zzbey) {
            zzneVar.zzia();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzne
    public final zznc zza(int i2, zzol zzolVar) {
        int length = this.zzbey.length;
        zznc[] zzncVarArr = new zznc[length];
        for (int i3 = 0; i3 < length; i3++) {
            zzncVarArr[i3] = this.zzbey[i3].zza(i2, zzolVar);
        }
        return new zzng(zzncVarArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(int i2, zzid zzidVar, Object obj) {
        zznh zznhVar;
        if (this.zzbfe == null) {
            int zzff = zzidVar.zzff();
            for (int i3 = 0; i3 < zzff; i3++) {
                zzidVar.zza(i3, this.zzaew, false);
            }
            if (this.zzbfd == -1) {
                this.zzbfd = zzidVar.zzfg();
            } else if (zzidVar.zzfg() != this.zzbfd) {
                zznhVar = new zznh(1);
                this.zzbfe = zznhVar;
            }
            zznhVar = null;
            this.zzbfe = zznhVar;
        }
        if (this.zzbfe != null) {
            return;
        }
        this.zzbez.remove(this.zzbey[i2]);
        if (i2 == 0) {
            this.zzbfb = zzidVar;
            this.zzbfc = obj;
        }
        if (this.zzbez.isEmpty()) {
            this.zzbfa.zzb(this.zzbfb, this.zzbfc);
        }
    }
}
