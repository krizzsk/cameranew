package us.pinguo.inspire.module.discovery.entity;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class InspireFeedPhoto implements Parcelable {
    public static final Parcelable.Creator<InspireFeedPhoto> CREATOR = new Parcelable.Creator<InspireFeedPhoto>() { // from class: us.pinguo.inspire.module.discovery.entity.InspireFeedPhoto.1
        @Override // android.os.Parcelable.Creator
        public InspireFeedPhoto createFromParcel(Parcel parcel) {
            return new InspireFeedPhoto(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public InspireFeedPhoto[] newArray(int i2) {
            return new InspireFeedPhoto[i2];
        }
    };
    public int height;
    public String url;
    public String vid;
    public int width;

    public InspireFeedPhoto(String str, String str2, int i2, int i3) {
        this.vid = str;
        this.url = str2;
        this.width = i2;
        this.height = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.vid);
        parcel.writeString(this.url);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public InspireFeedPhoto() {
    }

    protected InspireFeedPhoto(Parcel parcel) {
        this.vid = parcel.readString();
        this.url = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
