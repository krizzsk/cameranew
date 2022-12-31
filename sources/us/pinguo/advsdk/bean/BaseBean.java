package us.pinguo.advsdk.bean;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes3.dex */
public class BaseBean implements Parcelable {
    public static final Parcelable.Creator<BaseBean> CREATOR = new a();

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<BaseBean> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BaseBean createFromParcel(Parcel parcel) {
            return new BaseBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public BaseBean[] newArray(int i2) {
            return new BaseBean[i2];
        }
    }

    public BaseBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseBean(Parcel parcel) {
    }
}
