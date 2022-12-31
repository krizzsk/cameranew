package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class q implements Parcelable.Creator<zzal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList<String> arrayList = null;
        String str = "";
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                arrayList = SafeParcelReader.r(parcel, D);
            } else if (v == 2) {
                pendingIntent = (PendingIntent) SafeParcelReader.o(parcel, D, PendingIntent.CREATOR);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                str = SafeParcelReader.p(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new zzal(arrayList, pendingIntent, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal[] newArray(int i2) {
        return new zzal[i2];
    }
}
