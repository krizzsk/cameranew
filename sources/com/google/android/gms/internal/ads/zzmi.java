package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzmi extends zzmo {
    public static final Parcelable.Creator<zzmi> CREATOR = new zzmk();
    private final String description;
    private final String mimeType;
    private final int zzbdi;
    private final byte[] zzbdj;

    public zzmi(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = null;
        this.zzbdi = 3;
        this.zzbdj = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmi.class == obj.getClass()) {
            zzmi zzmiVar = (zzmi) obj;
            if (this.zzbdi == zzmiVar.zzbdi && zzpt.zza(this.mimeType, zzmiVar.mimeType) && zzpt.zza(this.description, zzmiVar.description) && Arrays.equals(this.zzbdj, zzmiVar.zzbdj)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (this.zzbdi + 527) * 31;
        String str = this.mimeType;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.zzbdj);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzbdi);
        parcel.writeByteArray(this.zzbdj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmi(Parcel parcel) {
        super("APIC");
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzbdi = parcel.readInt();
        this.zzbdj = parcel.createByteArray();
    }
}
