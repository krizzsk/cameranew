package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzace extends zzacj {
    private final com.google.android.gms.ads.internal.zzg zzdbj;
    @Nullable
    private final String zzdbk;
    private final String zzdbl;

    public zzace(com.google.android.gms.ads.internal.zzg zzgVar, @Nullable String str, String str2) {
        this.zzdbj = zzgVar;
        this.zzdbk = str;
        this.zzdbl = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzacg
    public final String getContent() {
        return this.zzdbl;
    }

    @Override // com.google.android.gms.internal.ads.zzacg
    public final void recordClick() {
        this.zzdbj.zzkc();
    }

    @Override // com.google.android.gms.internal.ads.zzacg
    public final void recordImpression() {
        this.zzdbj.zzkd();
    }

    @Override // com.google.android.gms.internal.ads.zzacg
    public final void zzn(@Nullable b bVar) {
        if (bVar == null) {
            return;
        }
        this.zzdbj.zzh((View) d.y0(bVar));
    }

    @Override // com.google.android.gms.internal.ads.zzacg
    public final String zzsq() {
        return this.zzdbk;
    }
}
