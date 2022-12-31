package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    private final List<Location> zzbc;
    static final List<Location> a = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new j();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationResult(List<Location> list) {
        this.zzbc = list;
    }

    @NonNull
    public final List<Location> Q() {
        return this.zzbc;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationResult) {
            LocationResult locationResult = (LocationResult) obj;
            if (locationResult.zzbc.size() != this.zzbc.size()) {
                return false;
            }
            Iterator<Location> it = locationResult.zzbc.iterator();
            Iterator<Location> it2 = this.zzbc.iterator();
            while (it.hasNext()) {
                if (it2.next().getTime() != it.next().getTime()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 17;
        for (Location location : this.zzbc) {
            long time = location.getTime();
            i2 = (i2 * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzbc);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("LocationResult[locations: ");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 1, Q(), false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a2);
    }
}
