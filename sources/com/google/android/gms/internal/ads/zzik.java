package com.google.android.gms.internal.ads;

import android.os.Handler;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzik {
    private final Handler handler;
    private final zzil zzajd;

    public zzik(Handler handler, zzil zzilVar) {
        this.handler = zzilVar != null ? (Handler) zzpg.checkNotNull(handler) : null;
        this.zzajd = zzilVar;
    }

    public final void zza(zzjm zzjmVar) {
        if (this.zzajd != null) {
            this.handler.post(new zzin(this, zzjmVar));
        }
    }

    public final void zzb(zzht zzhtVar) {
        if (this.zzajd != null) {
            this.handler.post(new zzip(this, zzhtVar));
        }
    }

    public final void zzw(int i2) {
        if (this.zzajd != null) {
            this.handler.post(new zziq(this, i2));
        }
    }

    public final void zza(String str, long j2, long j3) {
        if (this.zzajd != null) {
            this.handler.post(new zzim(this, str, j2, j3));
        }
    }

    public final void zzb(zzjm zzjmVar) {
        if (this.zzajd != null) {
            this.handler.post(new zzir(this, zzjmVar));
        }
    }

    public final void zza(int i2, long j2, long j3) {
        if (this.zzajd != null) {
            this.handler.post(new zzio(this, i2, j2, j3));
        }
    }
}
