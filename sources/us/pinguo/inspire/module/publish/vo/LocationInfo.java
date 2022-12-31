package us.pinguo.inspire.module.publish.vo;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class LocationInfo implements Parcelable {
    public static final Parcelable.Creator<LocationInfo> CREATOR = new Parcelable.Creator<LocationInfo>() { // from class: us.pinguo.inspire.module.publish.vo.LocationInfo.1
        @Override // android.os.Parcelable.Creator
        public LocationInfo createFromParcel(Parcel parcel) {
            return new LocationInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LocationInfo[] newArray(int i2) {
            return new LocationInfo[i2];
        }
    };
    public String address;
    public String lat;
    public String lon;
    public String placeId;
    public String poi;

    public LocationInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        String str = this.poi;
        return str == null ? "" : str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.placeId);
        parcel.writeString(this.lat);
        parcel.writeString(this.lon);
        parcel.writeString(this.poi);
        parcel.writeString(this.address);
    }

    public LocationInfo(String str, String str2, String str3) {
        this(null, str, str2, str3, null);
    }

    public LocationInfo(String str, String str2, String str3, String str4) {
        this(null, str, str2, str3, str4);
    }

    public LocationInfo(String str, String str2, String str3, String str4, String str5) {
        this.placeId = str;
        this.lat = str2;
        this.lon = str3;
        this.poi = str4;
        this.address = str5;
    }

    protected LocationInfo(Parcel parcel) {
        this.placeId = parcel.readString();
        this.lat = parcel.readString();
        this.lon = parcel.readString();
        this.poi = parcel.readString();
        this.address = parcel.readString();
    }
}
