package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzqj {
    private final Handler handler;
    private final zzqk zzbmz;

    public zzqj(Handler handler, zzqk zzqkVar) {
        this.handler = zzqkVar != null ? (Handler) zzpg.checkNotNull(handler) : null;
        this.zzbmz = zzqkVar;
    }

    public final void zza(zzjm zzjmVar) {
        if (this.zzbmz != null) {
            this.handler.post(new zzqm(this, zzjmVar));
        }
    }

    public final void zzb(zzht zzhtVar) {
        if (this.zzbmz != null) {
            this.handler.post(new zzqo(this, zzhtVar));
        }
    }

    public final void zzf(int i2, long j2) {
        if (this.zzbmz != null) {
            this.handler.post(new zzqn(this, i2, j2));
        }
    }

    public final void zza(String str, long j2, long j3) {
        if (this.zzbmz != null) {
            this.handler.post(new zzql(this, str, j2, j3));
        }
    }

    public final void zzb(zzjm zzjmVar) {
        if (this.zzbmz != null) {
            this.handler.post(new zzqr(this, zzjmVar));
        }
    }

    public final void zza(int i2, int i3, int i4, float f2) {
        if (this.zzbmz != null) {
            this.handler.post(new zzqq(this, i2, i3, i4, f2));
        }
    }

    public final void zza(Surface surface) {
        if (this.zzbmz != null) {
            this.handler.post(new zzqp(this, surface));
        }
    }
}
