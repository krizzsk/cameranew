package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdbx implements zzdfi<zzdbu> {
    private final Context context;
    private final zzdzv zzghl;

    public zzdbx(zzdzv zzdzvVar, Context context) {
        this.zzghl = zzdzvVar;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdbu> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdbw
            private final zzdbx zzhbh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhbh = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhbh.zzatc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdbu zzatc() throws Exception {
        AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
        return new zzdbu(audioManager.getMode(), audioManager.isMusicActive(), audioManager.isSpeakerphoneOn(), audioManager.getStreamVolume(3), audioManager.getRingerMode(), audioManager.getStreamVolume(2), com.google.android.gms.ads.internal.zzr.zzkw().zzra(), com.google.android.gms.ads.internal.zzr.zzkw().zzrb());
    }
}
