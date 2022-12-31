package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class AttachData implements Parcelable {
    public static final Parcelable.Creator<AttachData> CREATOR = new a();
    public boolean fpShowAdv;
    public boolean ptRpShowAdv;
    public boolean rpShowAdv;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AttachData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AttachData createFromParcel(Parcel parcel) {
            return new AttachData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AttachData[] newArray(int i2) {
            return new AttachData[i2];
        }
    }

    public AttachData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.rpShowAdv ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.fpShowAdv ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ptRpShowAdv ? (byte) 1 : (byte) 0);
    }

    protected AttachData(Parcel parcel) {
        this.rpShowAdv = parcel.readByte() != 0;
        this.fpShowAdv = parcel.readByte() != 0;
        this.ptRpShowAdv = parcel.readByte() != 0;
    }
}
