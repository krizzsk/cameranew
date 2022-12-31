package us.pinguo.inspire.module.profile.entry;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes4.dex */
public class GeoProvince extends BaseGeoEntry implements Parcelable {
    public static final Parcelable.Creator<GeoProvince> CREATOR = new Parcelable.Creator<GeoProvince>() { // from class: us.pinguo.inspire.module.profile.entry.GeoProvince.1
        @Override // android.os.Parcelable.Creator
        public GeoProvince createFromParcel(Parcel parcel) {
            return new GeoProvince(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GeoProvince[] newArray(int i2) {
            return new GeoProvince[i2];
        }
    };
    public List<GeoCity> city;

    public GeoProvince() {
    }

    @Override // us.pinguo.inspire.module.profile.entry.BaseGeoEntry, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // us.pinguo.inspire.module.profile.entry.BaseGeoEntry, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeTypedList(this.city);
    }

    protected GeoProvince(Parcel parcel) {
        super(parcel);
        this.city = parcel.createTypedArrayList(GeoCity.CREATOR);
    }
}
