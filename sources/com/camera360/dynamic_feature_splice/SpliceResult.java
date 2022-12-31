package com.camera360.dynamic_feature_splice;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
/* loaded from: classes8.dex */
public class SpliceResult implements Parcelable {
    public static final Parcelable.Creator<SpliceResult> CREATOR = new a();
    public final int ori;
    public final String path;
    public final long time;

    /* loaded from: classes8.dex */
    class a implements Parcelable.Creator<SpliceResult> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @Nullable
        /* renamed from: a */
        public SpliceResult createFromParcel(Parcel parcel) {
            return new SpliceResult(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SpliceResult[] newArray(int i2) {
            return new SpliceResult[i2];
        }
    }

    /* synthetic */ SpliceResult(Parcel parcel, a aVar) {
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
        if (obj instanceof SpliceResult) {
            SpliceResult spliceResult = (SpliceResult) obj;
            return this.ori == spliceResult.ori && us.pinguo.foundation.utils.y.a(this.path, spliceResult.path) && this.time == spliceResult.time;
        }
        return false;
    }

    public int hashCode() {
        return us.pinguo.foundation.utils.y.b(Integer.valueOf(this.ori), Long.valueOf(this.time), this.path);
    }

    public String toString() {
        return this.path + "/" + this.time + "/" + this.ori;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.ori);
        parcel.writeLong(this.time);
        parcel.writeString(this.path);
    }

    public SpliceResult(int i2, String str, long j2) {
        this.ori = i2;
        this.time = j2;
        this.path = str;
    }

    private SpliceResult(Parcel parcel) {
        this.ori = parcel.readInt();
        this.time = parcel.readLong();
        this.path = parcel.readString();
    }
}
