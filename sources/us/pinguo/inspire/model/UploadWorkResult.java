package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
import us.pinguo.inspire.module.publish.InspireUploadItem;
import us.pinguo.inspire.module.publish.QiNiuImageInfo;
/* loaded from: classes9.dex */
public class UploadWorkResult implements Parcelable {
    public static final Parcelable.Creator<UploadWorkResult> CREATOR = new Parcelable.Creator<UploadWorkResult>() { // from class: us.pinguo.inspire.model.UploadWorkResult.1
        @Override // android.os.Parcelable.Creator
        public UploadWorkResult createFromParcel(Parcel parcel) {
            return new UploadWorkResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UploadWorkResult[] newArray(int i2) {
            return new UploadWorkResult[i2];
        }
    };
    public InspireUploadItem data;
    public String message;
    public QiNiuImageInfo qiNiuImageInfo;
    public int status;
    public long uploadedSize;

    public UploadWorkResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadWorkResult{data=" + this.data + ", status=" + this.status + ", message='" + this.message + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.data, i2);
        parcel.writeParcelable(this.qiNiuImageInfo, i2);
        parcel.writeInt(this.status);
        parcel.writeString(this.message);
        parcel.writeLong(this.uploadedSize);
    }

    protected UploadWorkResult(Parcel parcel) {
        this.data = (InspireUploadItem) parcel.readParcelable(InspireUploadItem.class.getClassLoader());
        this.qiNiuImageInfo = (QiNiuImageInfo) parcel.readParcelable(QiNiuImageInfo.class.getClassLoader());
        this.status = parcel.readInt();
        this.message = parcel.readString();
        this.uploadedSize = parcel.readLong();
    }
}
