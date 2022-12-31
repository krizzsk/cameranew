package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AreaListItem implements Parcelable {
    public static final Parcelable.Creator<AreaListItem> CREATOR = new a();
    public ArrayList<AdvItemSingle> advList;
    public String guid;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AreaListItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AreaListItem createFromParcel(Parcel parcel) {
            return new AreaListItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AreaListItem[] newArray(int i2) {
            return new AreaListItem[i2];
        }
    }

    public AreaListItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.guid);
        parcel.writeTypedList(this.advList);
    }

    protected AreaListItem(Parcel parcel) {
        this.guid = parcel.readString();
        this.advList = parcel.createTypedArrayList(AdvItemSingle.CREATOR);
    }
}
