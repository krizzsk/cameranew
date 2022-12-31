package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0923Il;
import com.facebook.ads.redexgen.X.EI;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class PrivFrame extends Id3Frame {
    public static byte[] A02;
    public static final Parcelable.Creator<PrivFrame> CREATOR;
    public final String A00;
    public final byte[] A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 67);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{61, 39, 104, 112, 105, 98, 117, 58, 114, 112, 107, 116};
    }

    static {
        A01();
        CREATOR = new EI();
    }

    public PrivFrame(Parcel parcel) {
        super(A00(8, 4, 97));
        this.A00 = parcel.readString();
        this.A01 = parcel.createByteArray();
    }

    public PrivFrame(String str, byte[] bArr) {
        super(A00(8, 4, 97));
        this.A00 = str;
        this.A01 = bArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        return C0923Il.A0g(this.A00, privFrame.A00) && Arrays.equals(this.A01, privFrame.A01);
    }

    public final int hashCode() {
        int i2 = 17 * 31;
        String str = this.A00;
        int hashCode = str != null ? str.hashCode() : 0;
        int result = Arrays.hashCode(this.A01);
        return ((i2 + hashCode) * 31) + result;
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(0, 8, 68) + this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.A00);
        parcel.writeByteArray(this.A01);
    }
}
