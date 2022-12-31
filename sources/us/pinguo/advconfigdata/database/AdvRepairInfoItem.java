package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes3.dex */
public class AdvRepairInfoItem implements Parcelable {
    public static final Parcelable.Creator<AdvRepairInfoItem> CREATOR = new a();
    public int procInterval;
    public int procSeq;
    public String taskId;
    public List<String> urls;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AdvRepairInfoItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdvRepairInfoItem createFromParcel(Parcel parcel) {
            return new AdvRepairInfoItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AdvRepairInfoItem[] newArray(int i2) {
            return new AdvRepairInfoItem[i2];
        }
    }

    public AdvRepairInfoItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.taskId);
        parcel.writeInt(this.procSeq);
        parcel.writeInt(this.procInterval);
        parcel.writeStringList(this.urls);
    }

    protected AdvRepairInfoItem(Parcel parcel) {
        this.taskId = parcel.readString();
        this.procSeq = parcel.readInt();
        this.procInterval = parcel.readInt();
        this.urls = parcel.createStringArrayList();
    }
}
