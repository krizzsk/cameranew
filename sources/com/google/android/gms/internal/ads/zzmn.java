package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzmn extends zzmo {
    public static final Parcelable.Creator<zzmn> CREATOR = new zzmq();
    private final String description;
    private final String value;

    public zzmn(String str, String str2, String str3) {
        super(str);
        this.description = null;
        this.value = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmn.class == obj.getClass()) {
            zzmn zzmnVar = (zzmn) obj;
            if (this.id.equals(zzmnVar.id) && zzpt.zza(this.description, zzmnVar.description) && zzpt.zza(this.value, zzmnVar.value)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.id.hashCode() + 527) * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmn(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.value = parcel.readString();
    }
}
