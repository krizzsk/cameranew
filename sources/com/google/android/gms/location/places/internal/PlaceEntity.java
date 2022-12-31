package com.google.android.gms.location.places.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class PlaceEntity extends AbstractSafeParcelable implements ReflectedParcelable, com.google.android.gms.location.places.a {
    public static final Parcelable.Creator<PlaceEntity> CREATOR = new a();
    private final LatLng latLng;
    private Locale locale;
    private final String name;
    private final String zzbw;
    private final float zzbx;
    private final LatLngBounds zzby;
    private final String zzbz;
    private final boolean zzca;
    private final float zzcb;
    private final int zzcc;
    private final List<String> zzcd;
    private final zzal zzce;
    private final zzai zzcf;
    private final String zzcg;
    private final String zzf;
    private final List<Integer> zzg;
    private final String zzh;
    private final Uri zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceEntity(String str, List<Integer> list, String str2, String str3, String str4, List<String> list2, LatLng latLng, float f2, LatLngBounds latLngBounds, String str5, Uri uri, boolean z, float f3, int i2, zzal zzalVar, zzai zzaiVar, String str6) {
        this.zzbw = str;
        this.zzg = Collections.unmodifiableList(list);
        this.name = str2;
        this.zzf = str3;
        this.zzh = str4;
        this.zzcd = list2 != null ? list2 : Collections.emptyList();
        this.latLng = latLng;
        this.zzbx = f2;
        this.zzby = latLngBounds;
        this.zzbz = str5 != null ? str5 : "UTC";
        this.zzi = uri;
        this.zzca = z;
        this.zzcb = f3;
        this.zzcc = i2;
        this.locale = null;
        this.zzce = zzalVar;
        this.zzcf = zzaiVar;
        this.zzcg = str6;
    }

    public final /* synthetic */ CharSequence Q() {
        return this.zzf;
    }

    public final String R() {
        return this.zzbw;
    }

    public final /* synthetic */ CharSequence S() {
        return this.zzh;
    }

    public final List<Integer> T() {
        return this.zzg;
    }

    public final int U() {
        return this.zzcc;
    }

    public final float V() {
        return this.zzcb;
    }

    public final LatLngBounds W() {
        return this.zzby;
    }

    public final Uri X() {
        return this.zzi;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlaceEntity) {
            PlaceEntity placeEntity = (PlaceEntity) obj;
            return this.zzbw.equals(placeEntity.zzbw) && p.a(this.locale, placeEntity.locale);
        }
        return false;
    }

    @Override // com.google.android.gms.location.places.a
    public final /* synthetic */ CharSequence getName() {
        return this.name;
    }

    public final int hashCode() {
        return p.b(this.zzbw, this.locale);
    }

    @Override // com.google.android.gms.location.places.a
    public final LatLng t() {
        return this.latLng;
    }

    @SuppressLint({"DefaultLocale"})
    public final String toString() {
        p.a c = p.c(this);
        c.a(TapjoyAuctionFlags.AUCTION_ID, this.zzbw);
        c.a("placeTypes", this.zzg);
        c.a("locale", this.locale);
        c.a("name", this.name);
        c.a("address", this.zzf);
        c.a("phoneNumber", this.zzh);
        c.a("latlng", this.latLng);
        c.a("viewport", this.zzby);
        c.a("websiteUri", this.zzi);
        c.a("isPermanentlyClosed", Boolean.valueOf(this.zzca));
        c.a("priceLevel", Integer.valueOf(this.zzcc));
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 1, R(), false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 4, t(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 5, this.zzbx);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 6, W(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 7, this.zzbz, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 8, X(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.c(parcel, 9, this.zzca);
        com.google.android.gms.common.internal.safeparcel.a.j(parcel, 10, V());
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 11, U());
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 14, (String) Q(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 15, (String) S(), false);
        com.google.android.gms.common.internal.safeparcel.a.x(parcel, 17, this.zzcd, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 19, (String) getName(), false);
        com.google.android.gms.common.internal.safeparcel.a.n(parcel, 20, T(), false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 21, this.zzce, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 22, this.zzcf, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 23, this.zzcg, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
