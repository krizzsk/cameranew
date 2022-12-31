package us.pinguo.advconfigdata.database;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class ImageData implements Parcelable {
    public static final Parcelable.Creator<ImageData> CREATOR = new a();
    public int height;
    public String imageUrl;
    public String quality;
    public String ratio;
    public int width;
    public String zoom;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ImageData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ImageData createFromParcel(Parcel parcel) {
            return new ImageData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ImageData[] newArray(int i2) {
            return new ImageData[i2];
        }
    }

    public ImageData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.imageUrl);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.ratio);
        parcel.writeString(this.zoom);
        parcel.writeString(this.quality);
    }

    protected ImageData(Parcel parcel) {
        this.imageUrl = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.ratio = parcel.readString();
        this.zoom = parcel.readString();
        this.quality = parcel.readString();
    }
}
