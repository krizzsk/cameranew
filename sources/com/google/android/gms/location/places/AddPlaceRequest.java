package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
@Deprecated
/* loaded from: classes2.dex */
public class AddPlaceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new f();
    private final LatLng latLng;
    private final String name;
    private final String zzf;
    private final List<Integer> zzg;
    private final String zzh;
    private final Uri zzi;

    public AddPlaceRequest(String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        q.f(str);
        this.name = str;
        q.j(latLng);
        this.latLng = latLng;
        q.f(str2);
        this.zzf = str2;
        q.j(list);
        ArrayList arrayList = new ArrayList(list);
        this.zzg = arrayList;
        boolean z = true;
        q.b(!arrayList.isEmpty(), "At least one place type should be provided.");
        if (TextUtils.isEmpty(str3) && uri == null) {
            z = false;
        }
        q.b(z, "One of phone number or URI should be provided.");
        this.zzh = str3;
        this.zzi = uri;
    }

    public String Q() {
        return this.zzf;
    }

    @Nullable
    public String R() {
        return this.zzh;
    }

    public List<Integer> S() {
        return this.zzg;
    }

    @Nullable
    public Uri T() {
        return this.zzi;
    }

    public String getName() {
        return this.name;
    }

    public LatLng t() {
        return this.latLng;
    }

    public String toString() {
        p.a c = p.c(this);
        c.a("name", this.name);
        c.a("latLng", this.latLng);
        c.a("address", this.zzf);
        c.a("placeTypes", this.zzg);
        c.a("phoneNumer", this.zzh);
        c.a("websiteUri", this.zzi);
        return c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 1, getName(), false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, t(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, Q(), false);
        com.google.android.gms.common.internal.safeparcel.a.n(parcel, 4, S(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 5, R(), false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 6, T(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
