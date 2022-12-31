package us.pinguo.advsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes3.dex */
public class DetectDataBean extends BaseBean {
    public static final Parcelable.Creator<DetectDataBean> CREATOR = new a();
    public List<AdsItem> ads;
    public String usage;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<DetectDataBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DetectDataBean createFromParcel(Parcel parcel) {
            return new DetectDataBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public DetectDataBean[] newArray(int i2) {
            return new DetectDataBean[i2];
        }
    }

    public DetectDataBean() {
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.usage);
        parcel.writeTypedList(this.ads);
    }

    protected DetectDataBean(Parcel parcel) {
        super(parcel);
        this.usage = parcel.readString();
        this.ads = parcel.createTypedArrayList(AdsItem.CREATOR);
    }
}
