package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzbyz {
    @Nullable
    private final zzbeb zzdjd;
    private final zzcag zzgbj;

    public zzbyz(zzcag zzcagVar) {
        this(zzcagVar, null);
    }

    @Nullable
    public final zzbeb zzaje() {
        return this.zzdjd;
    }

    public final zzcag zzamt() {
        return this.zzgbj;
    }

    @Nullable
    public final View zzamu() {
        zzbeb zzbebVar = this.zzdjd;
        if (zzbebVar != null) {
            return zzbebVar.getWebView();
        }
        return null;
    }

    @Nullable
    public final View zzamv() {
        zzbeb zzbebVar = this.zzdjd;
        if (zzbebVar == null) {
            return null;
        }
        return zzbebVar.getWebView();
    }

    public Set<zzbya<zzbrm>> zzb(zzbql zzbqlVar) {
        return Collections.singleton(zzbya.zzb(zzbqlVar, zzazp.zzeih));
    }

    public Set<zzbya<zzbxp>> zzc(zzbql zzbqlVar) {
        return Collections.singleton(zzbya.zzb(zzbqlVar, zzazp.zzeih));
    }

    public zzbyz(zzcag zzcagVar, @Nullable zzbeb zzbebVar) {
        this.zzgbj = zzcagVar;
        this.zzdjd = zzbebVar;
    }

    public final zzbya<zzbvn> zzb(Executor executor) {
        final zzbeb zzbebVar = this.zzdjd;
        return new zzbya<>(new zzbvn(zzbebVar) { // from class: com.google.android.gms.internal.ads.zzbzb
            private final zzbeb zzeuk;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeuk = zzbebVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbvn
            public final void zzakf() {
                zzbeb zzbebVar2 = this.zzeuk;
                if (zzbebVar2.zzact() != null) {
                    zzbebVar2.zzact().close();
                }
            }
        }, executor);
    }
}
