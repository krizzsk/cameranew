package us.pinguo.advsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class VideoBean extends BaseBean {
    public static final Parcelable.Creator<VideoBean> CREATOR = new a();
    public int duration;
    public int height;
    public String url;
    public int width;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<VideoBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public VideoBean createFromParcel(Parcel parcel) {
            return new VideoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public VideoBean[] newArray(int i2) {
            return new VideoBean[i2];
        }
    }

    public VideoBean() {
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
        parcel.writeInt(this.duration);
    }

    protected VideoBean(Parcel parcel) {
        super(parcel);
        this.url = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.duration = parcel.readInt();
    }
}
