package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes9.dex */
public class DailyAward implements Parcelable {
    public static final Parcelable.Creator<DailyAward> CREATOR = new Parcelable.Creator<DailyAward>() { // from class: us.pinguo.inspire.model.DailyAward.1
        @Override // android.os.Parcelable.Creator
        public DailyAward createFromParcel(Parcel parcel) {
            DailyAward dailyAward = new DailyAward();
            dailyAward.award = parcel.readString();
            dailyAward.status = parcel.readInt();
            return dailyAward;
        }

        @Override // android.os.Parcelable.Creator
        public DailyAward[] newArray(int i2) {
            return new DailyAward[i2];
        }
    };
    public String award;
    public int status;

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
        DailyAward dailyAward = (DailyAward) obj;
        if (this.status != dailyAward.status) {
            return false;
        }
        String str = this.award;
        String str2 = dailyAward.award;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int hashCode() {
        String str = this.award;
        return ((str != null ? str.hashCode() : 0) * 31) + this.status;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.award);
        parcel.writeInt(this.status);
    }
}
