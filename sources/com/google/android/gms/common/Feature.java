package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new f();
    private final String zza;
    @Deprecated
    private final int zzb;
    private final long zzc;

    public Feature(String str, long j2) {
        this.zza = str;
        this.zzc = j2;
        this.zzb = -1;
    }

    public long Q() {
        long j2 = this.zzc;
        return j2 == -1 ? this.zzb : j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && Q() == feature.Q()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.zza;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.p.b(getName(), Long.valueOf(Q()));
    }

    public String toString() {
        p.a c = com.google.android.gms.common.internal.p.c(this);
        c.a("name", getName());
        c.a("version", Long.valueOf(Q()));
        return c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 1, getName(), false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 2, this.zzb);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 3, Q());
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public Feature(String str, int i2, long j2) {
        this.zza = str;
        this.zzb = i2;
        this.zzc = j2;
    }
}
