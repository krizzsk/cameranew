package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public final class b implements Parcelable.Creator<CloudMessage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CloudMessage createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 1) {
                SafeParcelReader.M(parcel, D);
            } else {
                intent = (Intent) SafeParcelReader.o(parcel, D, Intent.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new CloudMessage(intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CloudMessage[] newArray(int i2) {
        return new CloudMessage[i2];
    }
}
