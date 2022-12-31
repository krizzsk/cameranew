package com.facebook.ads.internal.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.redexgen.X.C0852Fq;
import com.facebook.ads.redexgen.X.I6;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class TrackGroup implements Parcelable {
    public static String[] A03 = {"uF1MaBjHqfaou024Qot33eYqIFU5JpvL", "e11WN2XHHVFyFb3tGbHyOnuTBXVrxID3", "sRFhiACxeNyk2ofGCUEzfsyXhtnOr6n1", "WOmDa", "B4eB5pbJ0Ea0X4wV3enRun3SeiDmty6A", "wkOrnjHBm7RpnZhD1xCNjmxcOEtiASyA", "Mmr4xD9J4DRMn7KtjO4WF7k", "AppkpJNXRVMekBVT0dKI7wy"};
    public static final Parcelable.Creator<TrackGroup> CREATOR = new C0852Fq();
    public int A00;
    public final int A01;
    public final Format[] A02;

    public TrackGroup(Parcel parcel) {
        this.A01 = parcel.readInt();
        this.A02 = new Format[this.A01];
        for (int i2 = 0; i2 < this.A01; i2++) {
            this.A02[i2] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }

    public TrackGroup(Format... formatArr) {
        I6.A04(formatArr.length > 0);
        this.A02 = formatArr;
        this.A01 = formatArr.length;
    }

    public final int A00(Format format) {
        int i2 = 0;
        while (true) {
            Format[] formatArr = this.A02;
            if (i2 < formatArr.length) {
                Format format2 = formatArr[i2];
                String[] strArr = A03;
                if (strArr[7].length() != strArr[6].length()) {
                    throw new RuntimeException();
                }
                A03[3] = "gOIjn";
                if (format == format2) {
                    return i2;
                }
                i2++;
            } else {
                return -1;
            }
        }
    }

    public final Format A01(int i2) {
        return this.A02[i2];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.A01 == trackGroup.A01 && Arrays.equals(this.A02, trackGroup.A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = (17 * 31) + Arrays.hashCode(this.A02);
        }
        int result = this.A00;
        return result;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.A01);
        for (int i3 = 0; i3 < this.A01; i3++) {
            parcel.writeParcelable(this.A02[i3], 0);
        }
    }
}
