package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import us.pinguo.bigalbum.db.BigAlbumStore;
@Deprecated
/* loaded from: classes2.dex */
public class AutocompleteFilter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AutocompleteFilter> CREATOR = new g();
    public static final int TYPE_FILTER_ADDRESS = 2;
    public static final int TYPE_FILTER_CITIES = 5;
    public static final int TYPE_FILTER_ESTABLISHMENT = 34;
    public static final int TYPE_FILTER_GEOCODE = 1007;
    public static final int TYPE_FILTER_NONE = 0;
    public static final int TYPE_FILTER_REGIONS = 4;
    private final int versionCode;
    private final boolean zzj;
    private final List<Integer> zzk;
    private final String zzl;
    private final int zzm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutocompleteFilter(int i2, boolean z, List<Integer> list, String str) {
        this.versionCode = i2;
        this.zzk = list;
        this.zzm = (list == null || list.isEmpty()) ? 0 : list.iterator().next().intValue();
        this.zzl = str;
        if (i2 <= 0) {
            this.zzj = !z;
        } else {
            this.zzj = z;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AutocompleteFilter) {
            AutocompleteFilter autocompleteFilter = (AutocompleteFilter) obj;
            return this.zzm == autocompleteFilter.zzm && this.zzj == autocompleteFilter.zzj && this.zzl == autocompleteFilter.zzl;
        }
        return false;
    }

    public int hashCode() {
        return p.b(Boolean.valueOf(this.zzj), Integer.valueOf(this.zzm), this.zzl);
    }

    public String toString() {
        p.a c = p.c(this);
        c.a("includeQueryPredictions", Boolean.valueOf(this.zzj));
        c.a("typeFilter", Integer.valueOf(this.zzm));
        c.a(BigAlbumStore.PhotoAddressColumns.COUNTRY, this.zzl);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 1, this.zzj);
        com.google.android.gms.common.internal.safeparcel.a.n(parcel, 2, this.zzk, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, this.zzl, false);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1000, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
