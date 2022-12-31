package us.pinguo.advsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes3.dex */
public class SingleAdConfigData extends BaseBean {
    public static final Parcelable.Creator<SingleAdConfigData> CREATOR = new a();
    public List<AdsItem> ads;
    public long pullTimeout;
    public String request;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<SingleAdConfigData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SingleAdConfigData createFromParcel(Parcel parcel) {
            return new SingleAdConfigData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SingleAdConfigData[] newArray(int i2) {
            return new SingleAdConfigData[i2];
        }
    }

    public SingleAdConfigData() {
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeTypedList(this.ads);
        parcel.writeLong(this.pullTimeout);
        parcel.writeString(this.request);
    }

    protected SingleAdConfigData(Parcel parcel) {
        super(parcel);
        this.ads = parcel.createTypedArrayList(AdsItem.CREATOR);
        this.pullTimeout = parcel.readLong();
        this.request = parcel.readString();
    }
}
