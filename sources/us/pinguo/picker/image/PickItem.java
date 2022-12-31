package us.pinguo.picker.image;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import us.pinguo.foundation.utils.y;
/* loaded from: classes5.dex */
public class PickItem implements Parcelable {
    public static final Parcelable.Creator<PickItem> CREATOR = new a();
    public final int ori;
    public final String path;

    /* loaded from: classes5.dex */
    class a implements Parcelable.Creator<PickItem> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @Nullable
        /* renamed from: a */
        public PickItem createFromParcel(Parcel parcel) {
            return new PickItem(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PickItem[] newArray(int i2) {
            return new PickItem[i2];
        }
    }

    /* synthetic */ PickItem(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PickItem) {
            PickItem pickItem = (PickItem) obj;
            return this.ori == pickItem.ori && y.a(this.path, pickItem.path);
        }
        return false;
    }

    public int hashCode() {
        return y.b(Integer.valueOf(this.ori), this.path);
    }

    public String toString() {
        return this.path + "/" + this.ori;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.ori);
        parcel.writeString(this.path);
    }

    public PickItem(int i2, String str) {
        this.ori = i2;
        this.path = str;
    }

    private PickItem(Parcel parcel) {
        this.ori = parcel.readInt();
        this.path = parcel.readString();
    }
}
