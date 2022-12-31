package us.pinguo.inspire.module.profile.entry;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes4.dex */
public class GeoCountry extends BaseGeoEntry {
    public static final Parcelable.Creator<GeoCountry> CREATOR = new Parcelable.Creator<GeoCountry>() { // from class: us.pinguo.inspire.module.profile.entry.GeoCountry.1
        @Override // android.os.Parcelable.Creator
        public GeoCountry createFromParcel(Parcel parcel) {
            return new GeoCountry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GeoCountry[] newArray(int i2) {
            return new GeoCountry[i2];
        }
    };
    public List<GeoProvince> province;

    public GeoCountry() {
    }

    @Override // us.pinguo.inspire.module.profile.entry.BaseGeoEntry, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // us.pinguo.inspire.module.profile.entry.BaseGeoEntry, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeTypedList(this.province);
    }

    protected GeoCountry(Parcel parcel) {
        super(parcel);
        this.province = parcel.createTypedArrayList(GeoProvince.CREATOR);
    }
}
