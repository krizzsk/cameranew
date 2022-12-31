package us.pinguo.admobvista.DataBean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class InputContentAdvDataIconData implements Parcelable {
    public static final Parcelable.Creator<InputContentAdvDataIconData> CREATOR = new a();
    public String height;
    public String imageUrl;
    public String width;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<InputContentAdvDataIconData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InputContentAdvDataIconData createFromParcel(Parcel parcel) {
            return new InputContentAdvDataIconData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InputContentAdvDataIconData[] newArray(int i2) {
            return new InputContentAdvDataIconData[i2];
        }
    }

    public InputContentAdvDataIconData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.width);
        parcel.writeString(this.height);
    }

    protected InputContentAdvDataIconData(Parcel parcel) {
        this.imageUrl = parcel.readString();
        this.width = parcel.readString();
        this.height = parcel.readString();
    }
}
