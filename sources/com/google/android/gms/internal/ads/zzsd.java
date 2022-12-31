package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzsd {
    final long value;
    final int zzbuc;
    final String zzbum;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsd(long j2, String str, int i2) {
        this.value = j2;
        this.zzbum = str;
        this.zzbuc = i2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zzsd)) {
            zzsd zzsdVar = (zzsd) obj;
            if (zzsdVar.value == this.value && zzsdVar.zzbuc == this.zzbuc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.value;
    }
}
