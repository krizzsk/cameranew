package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzkg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkg> CREATOR = new k9();
    public final int zza;
    public final String zzb;
    public final long zzc;
    @Nullable
    public final Long zzd;
    @Nullable
    public final String zze;
    @Nullable
    public final String zzf;
    @Nullable
    public final Double zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkg(int i2, String str, long j2, @Nullable Long l2, Float f2, @Nullable String str2, @Nullable String str3, @Nullable Double d2) {
        this.zza = i2;
        this.zzb = str;
        this.zzc = j2;
        this.zzd = l2;
        if (i2 == 1) {
            this.zzg = f2 != null ? Double.valueOf(f2.doubleValue()) : null;
        } else {
            this.zzg = d2;
        }
        this.zze = str2;
        this.zzf = str3;
    }

    @Nullable
    public final Object Q() {
        Long l2 = this.zzd;
        if (l2 != null) {
            return l2;
        }
        Double d2 = this.zzg;
        if (d2 != null) {
            return d2;
        }
        String str = this.zze;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        k9.a(this, parcel, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkg(l9 l9Var) {
        this(l9Var.c, l9Var.f3867d, l9Var.f3868e, l9Var.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkg(String str, long j2, @Nullable Object obj, @Nullable String str2) {
        com.google.android.gms.common.internal.q.f(str);
        this.zza = 2;
        this.zzb = str;
        this.zzc = j2;
        this.zzf = str2;
        if (obj == null) {
            this.zzd = null;
            this.zzg = null;
            this.zze = null;
        } else if (obj instanceof Long) {
            this.zzd = (Long) obj;
            this.zzg = null;
            this.zze = null;
        } else if (obj instanceof String) {
            this.zzd = null;
            this.zzg = null;
            this.zze = (String) obj;
        } else if (obj instanceof Double) {
            this.zzd = null;
            this.zzg = (Double) obj;
            this.zze = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
