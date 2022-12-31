package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;
@Deprecated
/* loaded from: classes2.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    private final String placeId;
    private final String zzav;
    private final List<zzg> zzdd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(String str, String str2, List<zzg> list) {
        this.zzav = str;
        this.placeId = str2;
        this.zzdd = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzi) {
            zzi zziVar = (zzi) obj;
            return this.zzav.equals(zziVar.zzav) && this.placeId.equals(zziVar.placeId) && this.zzdd.equals(zziVar.zzdd);
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.zzav, this.placeId, this.zzdd);
    }

    public final String toString() {
        p.a c = p.c(this);
        c.a("accountName", this.zzav);
        c.a("placeId", this.placeId);
        c.a("placeAliases", this.zzdd);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 1, this.zzav, false);
        a.v(parcel, 2, this.placeId, false);
        a.z(parcel, 6, this.zzdd, false);
        a.b(parcel, a);
    }
}
