package us.pinguo.inspire.module.publish;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class InspireUploadItem implements Parcelable {
    public static final Parcelable.Creator<InspireUploadItem> CREATOR = new Parcelable.Creator<InspireUploadItem>() { // from class: us.pinguo.inspire.module.publish.InspireUploadItem.1
        @Override // android.os.Parcelable.Creator
        public InspireUploadItem createFromParcel(Parcel parcel) {
            return new InspireUploadItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireUploadItem[] newArray(int i2) {
            return new InspireUploadItem[i2];
        }
    };
    public String memId;
    public String memUrl;

    public InspireUploadItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.memId);
        parcel.writeString(this.memUrl);
    }

    protected InspireUploadItem(Parcel parcel) {
        this.memId = parcel.readString();
        this.memUrl = parcel.readString();
    }
}
