package us.pinguo.inspire.module.publish;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class QiNiuImageInfo implements Parcelable {
    public static final Parcelable.Creator<QiNiuImageInfo> CREATOR = new Parcelable.Creator<QiNiuImageInfo>() { // from class: us.pinguo.inspire.module.publish.QiNiuImageInfo.1
        @Override // android.os.Parcelable.Creator
        public QiNiuImageInfo createFromParcel(Parcel parcel) {
            return new QiNiuImageInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public QiNiuImageInfo[] newArray(int i2) {
            return new QiNiuImageInfo[i2];
        }
    };
    public String etag;
    public int height;
    public int width;

    public QiNiuImageInfo(String str, int i2, int i3) {
        this.etag = str;
        this.width = i2;
        this.height = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.etag);
        parcel.writeInt(this.height);
        parcel.writeInt(this.width);
    }

    protected QiNiuImageInfo(Parcel parcel) {
        this.etag = parcel.readString();
        this.height = parcel.readInt();
        this.width = parcel.readInt();
    }
}
