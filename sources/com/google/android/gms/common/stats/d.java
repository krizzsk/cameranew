package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int N = SafeParcelReader.N(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < N) {
            int D = SafeParcelReader.D(parcel);
            switch (SafeParcelReader.v(D)) {
                case 1:
                    i2 = SafeParcelReader.F(parcel, D);
                    break;
                case 2:
                    j2 = SafeParcelReader.I(parcel, D);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.M(parcel, D);
                    break;
                case 4:
                    str = SafeParcelReader.p(parcel, D);
                    break;
                case 5:
                    i4 = SafeParcelReader.F(parcel, D);
                    break;
                case 6:
                    arrayList = SafeParcelReader.r(parcel, D);
                    break;
                case 8:
                    j3 = SafeParcelReader.I(parcel, D);
                    break;
                case 10:
                    str3 = SafeParcelReader.p(parcel, D);
                    break;
                case 11:
                    i3 = SafeParcelReader.F(parcel, D);
                    break;
                case 12:
                    str2 = SafeParcelReader.p(parcel, D);
                    break;
                case 13:
                    str4 = SafeParcelReader.p(parcel, D);
                    break;
                case 14:
                    i5 = SafeParcelReader.F(parcel, D);
                    break;
                case 15:
                    f2 = SafeParcelReader.B(parcel, D);
                    break;
                case 16:
                    j4 = SafeParcelReader.I(parcel, D);
                    break;
                case 17:
                    str5 = SafeParcelReader.p(parcel, D);
                    break;
                case 18:
                    z = SafeParcelReader.w(parcel, D);
                    break;
            }
        }
        SafeParcelReader.u(parcel, N);
        return new WakeLockEvent(i2, j2, i3, str, i4, arrayList, str2, j3, i5, str3, str4, f2, j4, str5, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i2) {
        return new WakeLockEvent[i2];
    }
}
