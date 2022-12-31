package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0923Il;
import com.facebook.ads.redexgen.X.EJ;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class TextInformationFrame extends Id3Frame {
    public static byte[] A02;
    public static String[] A03 = {"MWTcxeBG8bsFouaAzduEAAsFnNrCbH4S", "TMvfMv7bLasDA2p", "2F4JtsaJlxza1f1R5FT2E7jLDARFY2", "kZ1nXe", "K0", "Nhv", "FupI2YzCY2CNTP", "xd9z0ZjxleShvjlpQTWKxehcTRh34hYU"};
    public static final Parcelable.Creator<TextInformationFrame> CREATOR;
    @Nullable
    public final String A00;
    public final String A01;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 37);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-66, -92, -6, -27, -16, -7, -23, -63};
    }

    static {
        A01();
        CREATOR = new EJ();
    }

    public TextInformationFrame(Parcel parcel) {
        super(parcel.readString());
        this.A00 = parcel.readString();
        this.A01 = parcel.readString();
    }

    public TextInformationFrame(String str, @Nullable String str2, String str3) {
        super(str);
        this.A00 = str2;
        this.A01 = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        if (super.A00.equals(((Id3Frame) textInformationFrame).A00)) {
            boolean A0g = C0923Il.A0g(this.A00, textInformationFrame.A00);
            String[] strArr = A03;
            if (strArr[6].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[0] = "NUyLGY6c98DzuB2hwNhLwgueoQfkovra";
            strArr2[7] = "68BFtnvNUVid3aPwudNpvIsh4Gz74lHo";
            if (A0g && C0923Il.A0g(this.A01, textInformationFrame.A01)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((17 * 31) + super.A00.hashCode()) * 31;
        String str = this.A00;
        int result = str != null ? str.hashCode() : 0;
        int i2 = (hashCode + result) * 31;
        String str2 = this.A01;
        return i2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(0, 8, 95) + this.A01;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(super.A00);
        parcel.writeString(this.A00);
        parcel.writeString(this.A01);
    }
}
