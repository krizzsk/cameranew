package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbks {
    private final View view;
    private final zzbeb zzdjd;
    private final zzdmz zzftn;
    private final int zzfto;
    private final boolean zzftp;
    private final boolean zzftq;

    public zzbks(View view, @Nullable zzbeb zzbebVar, zzdmz zzdmzVar, int i2, boolean z, boolean z2) {
        this.view = view;
        this.zzdjd = zzbebVar;
        this.zzftn = zzdmzVar;
        this.zzfto = i2;
        this.zzftp = z;
        this.zzftq = z2;
    }

    @Nullable
    public final zzbeb zzaje() {
        return this.zzdjd;
    }

    public final View zzajf() {
        return this.view;
    }

    public final zzdmz zzajg() {
        return this.zzftn;
    }

    public final int zzajh() {
        return this.zzfto;
    }

    public final boolean zzaji() {
        return this.zzftp;
    }

    public final boolean zzajj() {
        return this.zzftq;
    }
}
