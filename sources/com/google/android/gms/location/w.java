package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class w implements Parcelable.Creator<ActivityTransitionRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityTransitionRequest createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList arrayList = null;
        String str = null;
        ArrayList arrayList2 = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            int v = SafeParcelReader.v(D);
            if (v == 1) {
                arrayList = SafeParcelReader.t(parcel, D, ActivityTransition.CREATOR);
            } else if (v == 2) {
                str = SafeParcelReader.p(parcel, D);
            } else if (v != 3) {
                SafeParcelReader.M(parcel, D);
            } else {
                arrayList2 = SafeParcelReader.t(parcel, D, ClientIdentity.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new ActivityTransitionRequest(arrayList, str, arrayList2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityTransitionRequest[] newArray(int i2) {
        return new ActivityTransitionRequest[i2];
    }
}
