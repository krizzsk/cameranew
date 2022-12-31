package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.p;
import java.util.Collection;
import java.util.List;
import java.util.Set;
@Deprecated
/* loaded from: classes2.dex */
public final class PlaceFilter extends zzb {
    public static final Parcelable.Creator<PlaceFilter> CREATOR = new h();
    private static final PlaceFilter zzr = new PlaceFilter();
    @Nullable
    private final List<Integer> zzs;
    private final boolean zzt;
    @Nullable
    private final List<zzp> zzu;
    @Nullable
    private final List<String> zzv;
    @NonNull
    private final Set<Integer> zzw;
    @NonNull
    private final Set<zzp> zzx;
    @NonNull
    private final Set<String> zzy;

    public PlaceFilter() {
        this(false, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlaceFilter) {
            PlaceFilter placeFilter = (PlaceFilter) obj;
            return this.zzw.equals(placeFilter.zzw) && this.zzt == placeFilter.zzt && this.zzx.equals(placeFilter.zzx) && this.zzy.equals(placeFilter.zzy);
        }
        return false;
    }

    public final int hashCode() {
        return p.b(this.zzw, Boolean.valueOf(this.zzt), this.zzx, this.zzy);
    }

    public final String toString() {
        p.a c = p.c(this);
        if (!this.zzw.isEmpty()) {
            c.a("types", this.zzw);
        }
        c.a("requireOpenNow", Boolean.valueOf(this.zzt));
        if (!this.zzy.isEmpty()) {
            c.a("placeIds", this.zzy);
        }
        if (!this.zzx.isEmpty()) {
            c.a("requestedUserDataTypes", this.zzx);
        }
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.n(parcel, 1, this.zzs, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 3, this.zzt);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 4, this.zzu, false);
        com.google.android.gms.common.internal.safeparcel.a.x(parcel, 6, this.zzv, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public PlaceFilter(boolean z, @Nullable Collection<String> collection) {
        this((Collection<Integer>) null, z, collection, (Collection<zzp>) null);
    }

    private PlaceFilter(@Nullable Collection<Integer> collection, boolean z, @Nullable Collection<String> collection2, @Nullable Collection<zzp> collection3) {
        this((List<Integer>) zzb.h(null), z, (List<String>) zzb.h(collection2), (List<zzp>) zzb.h(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceFilter(@Nullable List<Integer> list, boolean z, @Nullable List<String> list2, @Nullable List<zzp> list3) {
        this.zzs = list;
        this.zzt = z;
        this.zzu = list3;
        this.zzv = list2;
        this.zzw = zzb.j(list);
        this.zzx = zzb.j(list3);
        this.zzy = zzb.j(list2);
    }
}
