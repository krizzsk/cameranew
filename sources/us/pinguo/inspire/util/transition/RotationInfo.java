package us.pinguo.inspire.util.transition;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class RotationInfo implements Parcelable {
    public static final Parcelable.Creator<RotationInfo> CREATOR = new a();
    public Parcelable parcelable;
    public float rotation;

    /* loaded from: classes9.dex */
    class a implements Parcelable.Creator<RotationInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RotationInfo createFromParcel(Parcel parcel) {
            return new RotationInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RotationInfo[] newArray(int i2) {
            return new RotationInfo[i2];
        }
    }

    public RotationInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.parcelable, i2);
        parcel.writeFloat(this.rotation);
    }

    protected RotationInfo(Parcel parcel) {
        this.parcelable = parcel.readParcelable(Bitmap.class.getClassLoader());
        this.rotation = parcel.readFloat();
    }
}
