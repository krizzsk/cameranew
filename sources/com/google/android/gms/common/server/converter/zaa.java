package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new a();
    private final int zalk;
    private final StringToIntConverter zaqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaa(int i2, StringToIntConverter stringToIntConverter) {
        this.zalk = i2;
        this.zaqb = stringToIntConverter;
    }

    public static zaa h(FastJsonResponse.a<?, ?> aVar) {
        if (aVar instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) aVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final FastJsonResponse.a<?, ?> Q() {
        StringToIntConverter stringToIntConverter = this.zaqb;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.zalk);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 2, this.zaqb, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.zalk = 1;
        this.zaqb = stringToIntConverter;
    }
}
