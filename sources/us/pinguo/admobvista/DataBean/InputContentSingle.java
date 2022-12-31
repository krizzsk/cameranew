package us.pinguo.admobvista.DataBean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes3.dex */
public class InputContentSingle implements Parcelable {
    public static final Parcelable.Creator<InputContentSingle> CREATOR = new a();
    List<InputAdvItem> data;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<InputContentSingle> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public InputContentSingle createFromParcel(Parcel parcel) {
            return new InputContentSingle(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public InputContentSingle[] newArray(int i2) {
            return new InputContentSingle[i2];
        }
    }

    public InputContentSingle() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.data);
    }

    protected InputContentSingle(Parcel parcel) {
        this.data = parcel.createTypedArrayList(InputAdvItem.CREATOR);
    }
}
