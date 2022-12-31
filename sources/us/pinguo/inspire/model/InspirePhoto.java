package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class InspirePhoto implements Parcelable {
    public static final Parcelable.Creator<InspirePhoto> CREATOR = new Parcelable.Creator<InspirePhoto>() { // from class: us.pinguo.inspire.model.InspirePhoto.1
        @Override // android.os.Parcelable.Creator
        public InspirePhoto createFromParcel(Parcel parcel) {
            InspirePhoto inspirePhoto = new InspirePhoto();
            inspirePhoto.picUrl = parcel.readString();
            inspirePhoto.width = parcel.readInt();
            inspirePhoto.height = parcel.readInt();
            inspirePhoto.creator = parcel.readString();
            inspirePhoto.desc = parcel.readString();
            return inspirePhoto;
        }

        @Override // android.os.Parcelable.Creator
        public InspirePhoto[] newArray(int i2) {
            return new InspirePhoto[i2];
        }
    };
    @Deprecated
    public String creator;
    public String desc;
    public int height;
    public String picUrl;
    public int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InspirePhoto inspirePhoto = (InspirePhoto) obj;
        if (this.width == inspirePhoto.width && this.height == inspirePhoto.height) {
            String str = this.picUrl;
            if (str == null ? inspirePhoto.picUrl == null : str.equals(inspirePhoto.picUrl)) {
                String str2 = this.creator;
                if (str2 == null ? inspirePhoto.creator == null : str2.equals(inspirePhoto.creator)) {
                    String str3 = this.desc;
                    String str4 = inspirePhoto.desc;
                    return str3 != null ? str3.equals(str4) : str4 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.picUrl;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.width) * 31) + this.height) * 31;
        String str2 = this.creator;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.desc;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.picUrl);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.creator);
        parcel.writeString(this.desc);
    }
}
