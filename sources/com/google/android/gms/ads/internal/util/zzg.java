package com.google.android.gms.ads.internal.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.ads.zzdvl;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzg extends zzdvl {
    public zzg(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzr.zzkv().zza(e2, "AdMobHandler.handleMessage");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzb(Message message) {
        try {
            super.zzb(message);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzr.zzkr();
            zzj.zza(com.google.android.gms.ads.internal.zzr.zzkv().getApplicationContext(), th);
            throw th;
        }
    }
}
