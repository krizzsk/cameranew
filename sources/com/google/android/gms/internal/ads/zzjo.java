package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzjo implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzjo> CREATOR = new zzjq();
    private int zzahx;
    private final zza[] zzaoi;
    public final int zzaoj;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new zzjs();
        private final byte[] data;
        private final String mimeType;
        private final UUID uuid;
        private int zzahx;
        public final boolean zzaon;

        public zza(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof zza) {
                if (obj == this) {
                    return true;
                }
                zza zzaVar = (zza) obj;
                return this.mimeType.equals(zzaVar.mimeType) && zzpt.zza(this.uuid, zzaVar.uuid) && Arrays.equals(this.data, zzaVar.data);
            }
            return false;
        }

        public final int hashCode() {
            if (this.zzahx == 0) {
                this.zzahx = (((this.uuid.hashCode() * 31) + this.mimeType.hashCode()) * 31) + Arrays.hashCode(this.data);
            }
            return this.zzahx;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.zzaon ? (byte) 1 : (byte) 0);
        }

        private zza(UUID uuid, String str, byte[] bArr, boolean z) {
            this.uuid = (UUID) zzpg.checkNotNull(uuid);
            this.mimeType = (String) zzpg.checkNotNull(str);
            this.data = (byte[]) zzpg.checkNotNull(bArr);
            this.zzaon = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public zza(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.zzaon = parcel.readByte() != 0;
        }
    }

    public zzjo(List<zza> list) {
        this(false, (zza[]) list.toArray(new zza[list.size()]));
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zza zzaVar, zza zzaVar2) {
        zza zzaVar3 = zzaVar;
        zza zzaVar4 = zzaVar2;
        UUID uuid = zzhf.UUID_NIL;
        if (uuid.equals(zzaVar3.uuid)) {
            return uuid.equals(zzaVar4.uuid) ? 0 : 1;
        }
        return zzaVar3.uuid.compareTo(zzaVar4.uuid);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzjo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzaoi, ((zzjo) obj).zzaoi);
    }

    public final int hashCode() {
        if (this.zzahx == 0) {
            this.zzahx = Arrays.hashCode(this.zzaoi);
        }
        return this.zzahx;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedArray(this.zzaoi, 0);
    }

    public final zza zzac(int i2) {
        return this.zzaoi[i2];
    }

    public zzjo(zza... zzaVarArr) {
        this(true, zzaVarArr);
    }

    private zzjo(boolean z, zza... zzaVarArr) {
        zzaVarArr = z ? (zza[]) zzaVarArr.clone() : zzaVarArr;
        Arrays.sort(zzaVarArr, this);
        for (int i2 = 1; i2 < zzaVarArr.length; i2++) {
            if (zzaVarArr[i2 - 1].uuid.equals(zzaVarArr[i2].uuid)) {
                String valueOf = String.valueOf(zzaVarArr[i2].uuid);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.zzaoi = zzaVarArr;
        this.zzaoj = zzaVarArr.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjo(Parcel parcel) {
        zza[] zzaVarArr = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.zzaoi = zzaVarArr;
        this.zzaoj = zzaVarArr.length;
    }
}
