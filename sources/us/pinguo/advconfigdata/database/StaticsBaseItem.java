package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class StaticsBaseItem implements Parcelable {
    public static final Parcelable.Creator<StaticsBaseItem> CREATOR = new a();
    public String area;
    public String duration;
    public String eventid;
    public String item1;
    public String item2;
    public int type;
    public String value1;
    public String value2;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<StaticsBaseItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StaticsBaseItem createFromParcel(Parcel parcel) {
            return new StaticsBaseItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public StaticsBaseItem[] newArray(int i2) {
            return new StaticsBaseItem[i2];
        }
    }

    public StaticsBaseItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.area);
        parcel.writeString(this.eventid);
        parcel.writeInt(this.type);
        parcel.writeString(this.value1);
        parcel.writeString(this.value2);
        parcel.writeString(this.item1);
        parcel.writeString(this.item2);
        parcel.writeString(this.duration);
    }

    protected StaticsBaseItem(Parcel parcel) {
        this.area = parcel.readString();
        this.eventid = parcel.readString();
        this.type = parcel.readInt();
        this.value1 = parcel.readString();
        this.value2 = parcel.readString();
        this.item1 = parcel.readString();
        this.item2 = parcel.readString();
        this.duration = parcel.readString();
    }
}
