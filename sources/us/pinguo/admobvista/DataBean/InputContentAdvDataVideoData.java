package us.pinguo.admobvista.DataBean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class InputContentAdvDataVideoData implements Parcelable {
    public static final Parcelable.Creator<InputContentAdvDataVideoData> CREATOR = new a();
    public int height;
    public int rotate;
    public String videoUrl;
    public int width;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<InputContentAdvDataVideoData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InputContentAdvDataVideoData createFromParcel(Parcel parcel) {
            return new InputContentAdvDataVideoData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InputContentAdvDataVideoData[] newArray(int i2) {
            return new InputContentAdvDataVideoData[i2];
        }
    }

    public InputContentAdvDataVideoData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.videoUrl);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    protected InputContentAdvDataVideoData(Parcel parcel) {
        this.videoUrl = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
