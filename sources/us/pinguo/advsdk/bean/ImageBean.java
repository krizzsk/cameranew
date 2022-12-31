package us.pinguo.advsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class ImageBean extends BaseBean {
    public static final Parcelable.Creator<ImageBean> CREATOR = new a();
    public int height;
    public String url;
    public int width;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ImageBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ImageBean createFromParcel(Parcel parcel) {
            return new ImageBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ImageBean[] newArray(int i2) {
            return new ImageBean[i2];
        }
    }

    public ImageBean() {
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.url);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    protected ImageBean(Parcel parcel) {
        super(parcel);
        this.url = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
