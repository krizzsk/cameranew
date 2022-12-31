package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes3.dex */
public class StaticsItem implements Parcelable {
    public static final Parcelable.Creator<StaticsItem> CREATOR = new a();
    public List<StaticsBaseItem> items;
    public int max;
    public int min;
    public int percent;
    public String reportkey;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<StaticsItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StaticsItem createFromParcel(Parcel parcel) {
            return new StaticsItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public StaticsItem[] newArray(int i2) {
            return new StaticsItem[i2];
        }
    }

    public StaticsItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.percent);
        parcel.writeInt(this.min);
        parcel.writeInt(this.max);
        parcel.writeString(this.reportkey);
        parcel.writeTypedList(this.items);
    }

    protected StaticsItem(Parcel parcel) {
        this.percent = parcel.readInt();
        this.min = parcel.readInt();
        this.max = parcel.readInt();
        this.reportkey = parcel.readString();
        this.items = parcel.createTypedArrayList(StaticsBaseItem.CREATOR);
    }
}
