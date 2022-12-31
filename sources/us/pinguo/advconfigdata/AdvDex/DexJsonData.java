package us.pinguo.advconfigdata.AdvDex;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import us.pinguo.advconfigdata.database.GroupStaticsItem;
/* loaded from: classes3.dex */
public class DexJsonData implements Parcelable {
    public static final Parcelable.Creator<DexJsonData> CREATOR = new a();
    public List<GroupStaticsItem> data;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<DexJsonData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DexJsonData createFromParcel(Parcel parcel) {
            return new DexJsonData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DexJsonData[] newArray(int i2) {
            return new DexJsonData[i2];
        }
    }

    public DexJsonData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.data);
    }

    protected DexJsonData(Parcel parcel) {
        this.data = parcel.createTypedArrayList(GroupStaticsItem.CREATOR);
    }
}
