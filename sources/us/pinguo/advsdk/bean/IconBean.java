package us.pinguo.advsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class IconBean extends BaseBean {
    public static final Parcelable.Creator<IconBean> CREATOR = new a();
    public int height;
    public String url;
    public int width;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<IconBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IconBean createFromParcel(Parcel parcel) {
            return new IconBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public IconBean[] newArray(int i2) {
            return new IconBean[i2];
        }
    }

    public IconBean() {
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

    protected IconBean(Parcel parcel) {
        super(parcel);
        this.url = parcel.readString();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
