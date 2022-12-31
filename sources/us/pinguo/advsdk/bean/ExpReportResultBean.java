package us.pinguo.advsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class ExpReportResultBean extends BaseBean {
    public static final Parcelable.Creator<ExpReportResultBean> CREATOR = new a();
    public String status;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ExpReportResultBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExpReportResultBean createFromParcel(Parcel parcel) {
            return new ExpReportResultBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ExpReportResultBean[] newArray(int i2) {
            return new ExpReportResultBean[i2];
        }
    }

    public ExpReportResultBean() {
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.status);
    }

    protected ExpReportResultBean(Parcel parcel) {
        super(parcel);
        this.status = parcel.readString();
    }
}
