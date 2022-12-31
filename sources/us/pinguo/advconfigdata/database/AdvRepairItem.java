package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class AdvRepairItem implements Parcelable {
    public static final Parcelable.Creator<AdvRepairItem> CREATOR = new a();
    public AdvRepairInfoItem info;
    public int type;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AdvRepairItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdvRepairItem createFromParcel(Parcel parcel) {
            return new AdvRepairItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdvRepairItem[] newArray(int i2) {
            return new AdvRepairItem[i2];
        }
    }

    public AdvRepairItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.type);
        parcel.writeParcelable(this.info, i2);
    }

    protected AdvRepairItem(Parcel parcel) {
        this.type = parcel.readInt();
        this.info = (AdvRepairInfoItem) parcel.readParcelable(AdvRepairInfoItem.class.getClassLoader());
    }
}
