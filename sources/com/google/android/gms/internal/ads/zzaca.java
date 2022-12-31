package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes2.dex */
public final class zzaca {
    private final long time;
    @Nullable
    private final String zzdbb;
    @Nullable
    private final zzaca zzdbc;

    public zzaca(long j2, @Nullable String str, @Nullable zzaca zzacaVar) {
        this.time = j2;
        this.zzdbb = str;
        this.zzdbc = zzacaVar;
    }

    public final long getTime() {
        return this.time;
    }

    public final String zzsl() {
        return this.zzdbb;
    }

    @Nullable
    public final zzaca zzsm() {
        return this.zzdbc;
    }
}
