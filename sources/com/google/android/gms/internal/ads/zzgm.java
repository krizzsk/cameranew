package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzgm extends zzgn {
    private final View zzaat;

    public zzgm(zzfc zzfcVar, String str, String str2, zzcf.zza.zzb zzbVar, int i2, int i3, View view) {
        super(zzfcVar, str, str2, zzbVar, i2, 57);
        this.zzaat = view;
    }

    @Override // com.google.android.gms.internal.ads.zzgn
    protected final void zzcw() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaat != null) {
            Boolean bool = (Boolean) zzwr.zzqr().zzd(zzabp.zzcsn);
            zzfk zzfkVar = new zzfk((String) this.zzabl.invoke(null, this.zzaat, this.zzwc.getContext().getResources().getDisplayMetrics(), bool));
            zzcf.zza.zzf.C0147zza zzaw = zzcf.zza.zzf.zzaw();
            zzaw.zzdc(zzfkVar.zzaan.longValue()).zzdd(zzfkVar.zzaao.longValue()).zzde(zzfkVar.zzaap.longValue());
            if (bool.booleanValue()) {
                zzaw.zzdf(zzfkVar.zzaaq.longValue());
            }
            this.zzabb.zzb((zzcf.zza.zzf) ((zzelb) zzaw.zzbiw()));
        }
    }
}
