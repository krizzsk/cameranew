package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import us.pinguo.foundation.utils.u;
/* loaded from: classes4.dex */
public class InspireGeo implements Parcelable {
    public static final Parcelable.Creator<InspireGeo> CREATOR = new Parcelable.Creator<InspireGeo>() { // from class: us.pinguo.inspire.model.InspireGeo.1
        @Override // android.os.Parcelable.Creator
        public InspireGeo createFromParcel(Parcel parcel) {
            InspireGeo inspireGeo = new InspireGeo();
            inspireGeo.country = parcel.readString();
            inspireGeo.province = parcel.readString();
            inspireGeo.city = parcel.readString();
            return inspireGeo;
        }

        @Override // android.os.Parcelable.Creator
        public InspireGeo[] newArray(int i2) {
            return new InspireGeo[i2];
        }
    };
    public String city;
    public String country;
    public String province;

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
        InspireGeo inspireGeo = (InspireGeo) obj;
        String str = this.country;
        if (str == null ? inspireGeo.country == null : str.equals(inspireGeo.country)) {
            String str2 = this.province;
            if (str2 == null ? inspireGeo.province == null : str2.equals(inspireGeo.province)) {
                String str3 = this.city;
                String str4 = inspireGeo.city;
                return str3 != null ? str3.equals(str4) : str4 == null;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.country;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.province;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.city;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        if (TextUtils.isEmpty(this.country)) {
            return "";
        }
        String str = TextUtils.isEmpty(this.city) ? this.province : this.city;
        if (TextUtils.isEmpty(str)) {
            return this.country;
        }
        if (u.b()) {
            return this.country + "·" + str;
        }
        return str + "·" + this.country;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.country);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
    }
}
