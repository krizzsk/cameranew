package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzmj extends zzmo {
    public static final Parcelable.Creator<zzmj> CREATOR = new zzmm();
    public final String description;
    public final String text;
    private final String zzahv;

    public zzmj(String str, String str2, String str3) {
        super("COMM");
        this.zzahv = str;
        this.description = str2;
        this.text = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmj.class == obj.getClass()) {
            zzmj zzmjVar = (zzmj) obj;
            if (zzpt.zza(this.description, zzmjVar.description) && zzpt.zza(this.zzahv, zzmjVar.zzahv) && zzpt.zza(this.text, zzmjVar.text)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzahv;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.zzahv);
        parcel.writeString(this.text);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmj(Parcel parcel) {
        super("COMM");
        this.zzahv = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
    }
}
