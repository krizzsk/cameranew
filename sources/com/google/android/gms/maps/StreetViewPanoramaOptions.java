package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;
/* loaded from: classes2.dex */
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new l();
    private String panoId;
    private LatLng position;
    private Boolean zzak;
    private Boolean zzap;
    private StreetViewPanoramaCamera zzbx;
    private Integer zzby;
    private Boolean zzbz;
    private Boolean zzca;
    private Boolean zzcb;
    private StreetViewSource zzcc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5, StreetViewSource streetViewSource) {
        Boolean bool = Boolean.TRUE;
        this.zzbz = bool;
        this.zzap = bool;
        this.zzca = bool;
        this.zzcb = bool;
        this.zzcc = StreetViewSource.DEFAULT;
        this.zzbx = streetViewPanoramaCamera;
        this.position = latLng;
        this.zzby = num;
        this.panoId = str;
        this.zzbz = com.google.android.gms.maps.g.h.b(b);
        this.zzap = com.google.android.gms.maps.g.h.b(b2);
        this.zzca = com.google.android.gms.maps.g.h.b(b3);
        this.zzcb = com.google.android.gms.maps.g.h.b(b4);
        this.zzak = com.google.android.gms.maps.g.h.b(b5);
        this.zzcc = streetViewSource;
    }

    public final String Q() {
        return this.panoId;
    }

    public final LatLng R() {
        return this.position;
    }

    public final Integer S() {
        return this.zzby;
    }

    public final StreetViewSource T() {
        return this.zzcc;
    }

    public final StreetViewPanoramaCamera U() {
        return this.zzbx;
    }

    public final String toString() {
        p.a c = p.c(this);
        c.a("PanoramaId", this.panoId);
        c.a("Position", this.position);
        c.a("Radius", this.zzby);
        c.a("Source", this.zzcc);
        c.a("StreetViewPanoramaCamera", this.zzbx);
        c.a("UserNavigationEnabled", this.zzbz);
        c.a("ZoomGesturesEnabled", this.zzap);
        c.a("PanningGesturesEnabled", this.zzca);
        c.a("StreetNamesEnabled", this.zzcb);
        c.a("UseViewLifecycleInFragment", this.zzak);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, U(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, Q(), false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 4, R(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.o(parcel, 5, S(), false);
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 6, com.google.android.gms.maps.g.h.a(this.zzbz));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 7, com.google.android.gms.maps.g.h.a(this.zzap));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 8, com.google.android.gms.maps.g.h.a(this.zzca));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 9, com.google.android.gms.maps.g.h.a(this.zzcb));
        com.google.android.gms.common.internal.safeparcel.a.f(parcel, 10, com.google.android.gms.maps.g.h.a(this.zzak));
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 11, T(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    public StreetViewPanoramaOptions() {
        Boolean bool = Boolean.TRUE;
        this.zzbz = bool;
        this.zzap = bool;
        this.zzca = bool;
        this.zzcb = bool;
        this.zzcc = StreetViewSource.DEFAULT;
    }
}
