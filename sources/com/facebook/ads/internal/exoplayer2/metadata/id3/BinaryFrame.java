package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.EA;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class BinaryFrame extends Id3Frame {
    public static String[] A01 = {"7I8ByvYIxSCthXwQgZUxBbO6MrgPm3a2", "Aotrd2iEMgveLl8vQA6aCYWsKDDhtlXe", "Qu4A80he5UvBCJt6sY5OPydeiYt4T3DJ", "h563m8r7YKrZnjInan8U4LFDYfkXwskw", "M16axV3J", "BUyqEEJsV2YgLKNMo1K7EsNVHhkUuDnI", "eEBATBFYUp70gHXme0z6ms43UYUPOoJj", "UvzuR6baVszWBvzDMt3B0F14O1ipohwY"};
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new EA();
    public final byte[] A00;

    public BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        this.A00 = parcel.createByteArray();
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.A00 = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        if (super.A00.equals(((Id3Frame) binaryFrame).A00)) {
            byte[] bArr = this.A00;
            if (A01[3].charAt(0) == 'X') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "4v8hvUTZL3so7eNuHQHoz0JRLr1Gn80z";
            strArr[6] = "8p7NFpdJ3Ru5gkWuUhdagWmcX99TdvPx";
            if (Arrays.equals(bArr, binaryFrame.A00)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = Arrays.hashCode(this.A00);
        return (((17 * 31) + super.A00.hashCode()) * 31) + result;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(super.A00);
        parcel.writeByteArray(this.A00);
    }
}
