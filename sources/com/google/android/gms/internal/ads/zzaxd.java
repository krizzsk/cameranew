package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaxd implements zzqw {
    private final Object lock;
    private String zzbut;
    private final Context zzcmf;
    private boolean zzebk;

    public zzaxd(Context context, String str) {
        this.zzcmf = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzbut = str;
        this.zzebk = false;
        this.lock = new Object();
    }

    public final String getAdUnitId() {
        return this.zzbut;
    }

    @Override // com.google.android.gms.internal.ads.zzqw
    public final void zza(zzqx zzqxVar) {
        zzan(zzqxVar.zzbrj);
    }

    public final void zzan(boolean z) {
        if (com.google.android.gms.ads.internal.zzr.zzlp().zzy(this.zzcmf)) {
            synchronized (this.lock) {
                if (this.zzebk == z) {
                    return;
                }
                this.zzebk = z;
                if (TextUtils.isEmpty(this.zzbut)) {
                    return;
                }
                if (this.zzebk) {
                    com.google.android.gms.ads.internal.zzr.zzlp().zzd(this.zzcmf, this.zzbut);
                } else {
                    com.google.android.gms.ads.internal.zzr.zzlp().zze(this.zzcmf, this.zzbut);
                }
            }
        }
    }
}
