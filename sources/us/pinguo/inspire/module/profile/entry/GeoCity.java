package us.pinguo.inspire.module.profile.entry;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class GeoCity extends BaseGeoEntry {
    public static final Parcelable.Creator<GeoCity> CREATOR = new Parcelable.Creator<GeoCity>() { // from class: us.pinguo.inspire.module.profile.entry.GeoCity.1
        @Override // android.os.Parcelable.Creator
        public GeoCity createFromParcel(Parcel parcel) {
            return new GeoCity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GeoCity[] newArray(int i2) {
            return new GeoCity[i2];
        }
    };
    public String id;

    public GeoCity() {
    }

    @Override // us.pinguo.inspire.module.profile.entry.BaseGeoEntry, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // us.pinguo.inspire.module.profile.entry.BaseGeoEntry, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.id);
    }

    protected GeoCity(Parcel parcel) {
        super(parcel);
        this.id = parcel.readString();
    }
}
