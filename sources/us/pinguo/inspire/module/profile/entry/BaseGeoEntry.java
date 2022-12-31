package us.pinguo.inspire.module.profile.entry;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class BaseGeoEntry implements Parcelable {
    public static final Parcelable.Creator<BaseGeoEntry> CREATOR = new Parcelable.Creator<BaseGeoEntry>() { // from class: us.pinguo.inspire.module.profile.entry.BaseGeoEntry.1
        @Override // android.os.Parcelable.Creator
        public BaseGeoEntry createFromParcel(Parcel parcel) {
            return new BaseGeoEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BaseGeoEntry[] newArray(int i2) {
            return new BaseGeoEntry[i2];
        }
    };
    public String code;
    public String name;

    public BaseGeoEntry() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.code);
        parcel.writeString(this.name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseGeoEntry(Parcel parcel) {
        this.code = parcel.readString();
        this.name = parcel.readString();
    }
}
