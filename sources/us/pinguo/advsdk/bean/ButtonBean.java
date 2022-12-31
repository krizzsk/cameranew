package us.pinguo.advsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class ButtonBean extends BaseBean {
    public static final Parcelable.Creator<ButtonBean> CREATOR = new a();
    public String text;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<ButtonBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ButtonBean createFromParcel(Parcel parcel) {
            return new ButtonBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ButtonBean[] newArray(int i2) {
            return new ButtonBean[i2];
        }
    }

    public ButtonBean() {
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // us.pinguo.advsdk.bean.BaseBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.text);
    }

    protected ButtonBean(Parcel parcel) {
        super(parcel);
        this.text = parcel.readString();
    }
}
