package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzmh implements Parcelable {
    public static final Parcelable.Creator<zzmh> CREATOR = new zzmg();
    private final zza[] zzbdh;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public interface zza extends Parcelable {
    }

    public zzmh(List<? extends zza> list) {
        zza[] zzaVarArr = new zza[list.size()];
        this.zzbdh = zzaVarArr;
        list.toArray(zzaVarArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzmh.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbdh, ((zzmh) obj).zzbdh);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzbdh);
    }

    public final int length() {
        return this.zzbdh.length;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.zzbdh.length);
        for (zza zzaVar : this.zzbdh) {
            parcel.writeParcelable(zzaVar, 0);
        }
    }

    public final zza zzay(int i2) {
        return this.zzbdh[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmh(Parcel parcel) {
        this.zzbdh = new zza[parcel.readInt()];
        int i2 = 0;
        while (true) {
            zza[] zzaVarArr = this.zzbdh;
            if (i2 >= zzaVarArr.length) {
                return;
            }
            zzaVarArr[i2] = (zza) parcel.readParcelable(zza.class.getClassLoader());
            i2++;
        }
    }
}
