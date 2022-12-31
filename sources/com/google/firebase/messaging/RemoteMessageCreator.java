package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.a;
/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes2.dex */
public class RemoteMessageCreator implements Parcelable.Creator<RemoteMessage> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeToParcel(RemoteMessage remoteMessage, Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.e(parcel, 2, remoteMessage.bundle, false);
        a.b(parcel, a);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RemoteMessage createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            if (SafeParcelReader.v(D) != 2) {
                SafeParcelReader.M(parcel, D);
            } else {
                bundle = SafeParcelReader.f(parcel, D);
            }
        }
        SafeParcelReader.u(parcel, N);
        return new RemoteMessage(bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RemoteMessage[] newArray(int i2) {
        return new RemoteMessage[i2];
    }
}
