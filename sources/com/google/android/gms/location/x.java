package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class x implements Parcelable.Creator<ActivityTransitionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityTransitionResult createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 1) {
                SafeParcelReader.M(parcel, D);
            } else {
                arrayList = SafeParcelReader.t(parcel, D, ActivityTransitionEvent.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new ActivityTransitionResult(arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActivityTransitionResult[] newArray(int i2) {
        return new ActivityTransitionResult[i2];
    }
}
