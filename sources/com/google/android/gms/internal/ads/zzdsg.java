package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdsg {
    @NonNull
    public final String label;
    @NonNull
    public final String value;

    public zzdsg(@NonNull String str, @NonNull String str2) {
        this.label = str;
        this.value = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdsg) {
            zzdsg zzdsgVar = (zzdsg) obj;
            return this.label.equals(zzdsgVar.label) && this.value.equals(zzdsgVar.value);
        }
        return false;
    }

    public final int hashCode() {
        String valueOf = String.valueOf(this.label);
        String valueOf2 = String.valueOf(this.value);
        return (valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).hashCode();
    }
}
