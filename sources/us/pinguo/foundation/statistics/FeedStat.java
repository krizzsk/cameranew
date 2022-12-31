package us.pinguo.foundation.statistics;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
public class FeedStat implements Parcelable {
    public static final Parcelable.Creator<FeedStat> CREATOR = new a();
    public String item;
    public String item1;

    /* loaded from: classes4.dex */
    class a implements Parcelable.Creator<FeedStat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FeedStat createFromParcel(Parcel parcel) {
            return new FeedStat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FeedStat[] newArray(int i2) {
            return new FeedStat[i2];
        }
    }

    public FeedStat() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.item);
        parcel.writeString(this.item1);
    }

    protected FeedStat(Parcel parcel) {
        this.item = parcel.readString();
        this.item1 = parcel.readString();
    }
}
