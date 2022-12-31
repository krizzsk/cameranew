package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdhj {
    private final zzatq zzgoq;
    private final int zzgqc;

    public zzdhj(zzatq zzatqVar, int i2) {
        this.zzgoq = zzatqVar;
        this.zzgqc = i2;
    }

    public final String zzatv() {
        return this.zzgoq.packageName;
    }

    public final String zzatw() {
        return this.zzgoq.zzdxi.getString("ms");
    }

    @Nullable
    public final PackageInfo zzatx() {
        return this.zzgoq.zzdue;
    }

    public final List<String> zzaty() {
        return this.zzgoq.zzduo;
    }

    public final String zzatz() {
        return this.zzgoq.zzdxj;
    }

    public final int zzaua() {
        return this.zzgqc;
    }
}
