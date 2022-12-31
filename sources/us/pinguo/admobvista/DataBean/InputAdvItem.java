package us.pinguo.admobvista.DataBean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class InputAdvItem implements Parcelable, IAdvItem {
    public static final Parcelable.Creator<InputAdvItem> CREATOR = new a();
    public InputContentAdvData advData;
    public String advId;
    public String advType;
    public int forceInnerBrowser;
    public String guid;
    public float priority;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<InputAdvItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InputAdvItem createFromParcel(Parcel parcel) {
            return new InputAdvItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InputAdvItem[] newArray(int i2) {
            return new InputAdvItem[i2];
        }
    }

    public InputAdvItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InputAdvItem) {
            InputAdvItem inputAdvItem = (InputAdvItem) obj;
            if (Float.compare(inputAdvItem.priority, this.priority) != 0) {
                return false;
            }
            String str = this.advType;
            if (str == null ? inputAdvItem.advType == null : str.equals(inputAdvItem.advType)) {
                String str2 = this.guid;
                if (str2 == null ? inputAdvItem.guid == null : str2.equals(inputAdvItem.guid)) {
                    String str3 = this.advId;
                    String str4 = inputAdvItem.advId;
                    return str3 != null ? str3.equals(str4) : str4 == null;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // us.pinguo.admobvista.DataBean.IAdvItem
    public String getAdvId() {
        return this.advId;
    }

    public int hashCode() {
        String str = this.advType;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        float f2 = this.priority;
        int floatToIntBits = (hashCode + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        String str2 = this.guid;
        int hashCode2 = (floatToIntBits + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.advId;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.advType);
        parcel.writeFloat(this.priority);
        parcel.writeString(this.guid);
        parcel.writeString(this.advId);
        parcel.writeInt(this.forceInnerBrowser);
        parcel.writeParcelable(this.advData, i2);
    }

    protected InputAdvItem(Parcel parcel) {
        this.advType = parcel.readString();
        this.priority = parcel.readFloat();
        this.guid = parcel.readString();
        this.advId = parcel.readString();
        this.forceInnerBrowser = parcel.readInt();
        this.advData = (InputContentAdvData) parcel.readParcelable(InputContentAdvData.class.getClassLoader());
    }
}
