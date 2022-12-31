package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.internal.zzk;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class e extends com.google.android.gms.ads.internal.util.zza {
    final /* synthetic */ zzc a;

    private e(zzc zzcVar) {
        this.a = zzcVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zza
    public final void zzwe() {
        Bitmap zza = com.google.android.gms.ads.internal.zzr.zzlk().zza(Integer.valueOf(this.a.b.zzdtc.zzbpj));
        if (zza != null) {
            com.google.android.gms.ads.internal.util.zzr zzkt = com.google.android.gms.ads.internal.zzr.zzkt();
            zzc zzcVar = this.a;
            Activity activity = zzcVar.a;
            zzk zzkVar = zzcVar.b.zzdtc;
            final Drawable zza2 = zzkt.zza(activity, zza, zzkVar.zzbph, zzkVar.zzbpi);
            com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this, zza2) { // from class: com.google.android.gms.ads.internal.overlay.d
                private final e a;
                private final Drawable b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.b = zza2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e eVar = this.a;
                    eVar.a.a.getWindow().setBackgroundDrawable(this.b);
                }
            });
        }
    }
}
