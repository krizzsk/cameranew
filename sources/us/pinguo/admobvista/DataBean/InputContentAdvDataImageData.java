package us.pinguo.admobvista.DataBean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class InputContentAdvDataImageData implements Parcelable {
    public static final Parcelable.Creator<InputContentAdvDataImageData> CREATOR = new a();
    public String height;
    public String imageUrl;
    public String width;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<InputContentAdvDataImageData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InputContentAdvDataImageData createFromParcel(Parcel parcel) {
            return new InputContentAdvDataImageData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InputContentAdvDataImageData[] newArray(int i2) {
            return new InputContentAdvDataImageData[i2];
        }
    }

    public InputContentAdvDataImageData() {
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

    protected InputContentAdvDataImageData(Parcel parcel) {
        this.imageUrl = parcel.readString();
        this.width = parcel.readString();
        this.height = parcel.readString();
    }
}
