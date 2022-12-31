package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes3.dex */
public class GroupStaticsItem implements Parcelable {
    public static final Parcelable.Creator<GroupStaticsItem> CREATOR = new a();
    public List<StaticsItem> items;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<GroupStaticsItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GroupStaticsItem createFromParcel(Parcel parcel) {
            return new GroupStaticsItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GroupStaticsItem[] newArray(int i2) {
            return new GroupStaticsItem[i2];
        }
    }

    public GroupStaticsItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.items);
    }

    protected GroupStaticsItem(Parcel parcel) {
        this.items = parcel.createTypedArrayList(StaticsItem.CREATOR);
    }
}
