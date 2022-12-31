package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaaq> CREATOR = new zzaat();
    public final String zzbrb;

    public zzaaq(SearchAdRequest searchAdRequest) {
        this.zzbrb = searchAdRequest.getQuery();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.v(parcel, 15, this.zzbrb, false);
        a.b(parcel, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaaq(String str) {
        this.zzbrb = str;
    }
}
