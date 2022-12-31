package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new u();
    @Nullable
    private final String packageName;
    private final int uid;

    public ClientIdentity(int i2, @Nullable String str) {
        this.uid = i2;
        this.packageName = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof ClientIdentity)) {
            ClientIdentity clientIdentity = (ClientIdentity) obj;
            if (clientIdentity.uid == this.uid && p.a(clientIdentity.packageName, this.packageName)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.uid;
    }

    public String toString() {
        int i2 = this.uid;
        String str = this.packageName;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i2);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.uid);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, this.packageName, false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }
}
