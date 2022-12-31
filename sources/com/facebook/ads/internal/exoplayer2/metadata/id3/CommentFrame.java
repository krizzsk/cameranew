package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.C0923Il;
import com.facebook.ads.redexgen.X.ED;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class CommentFrame extends Id3Frame {
    public static byte[] A03;
    public static final Parcelable.Creator<CommentFrame> CREATOR;
    public final String A00;
    public final String A01;
    public final String A02;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 18);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{30, 18, 86, 87, 65, 81, 64, 91, 66, 70, 91, 93, 92, 15, 15, 21, 89, 84, 91, 82, 64, 84, 82, 80, 8, 118, 122, 120, 120};
    }

    static {
        A01();
        CREATOR = new ED();
    }

    public CommentFrame(Parcel parcel) {
        super(A00(25, 4, 39));
        this.A01 = parcel.readString();
        this.A00 = parcel.readString();
        this.A02 = parcel.readString();
    }

    public CommentFrame(String str, String str2, String str3) {
        super(A00(25, 4, 39));
        this.A01 = str;
        this.A00 = str2;
        this.A02 = str3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        if (C0923Il.A0g(this.A00, commentFrame.A00) && C0923Il.A0g(this.A01, commentFrame.A01) && C0923Il.A0g(this.A02, commentFrame.A02)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = 17 * 31;
        String str = this.A01;
        int result = str != null ? str.hashCode() : 0;
        int i3 = (i2 + result) * 31;
        String str2 = this.A00;
        int result2 = str2 != null ? str2.hashCode() : 0;
        int i4 = (i3 + result2) * 31;
        String str3 = this.A02;
        return i4 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(14, 11, 39) + this.A01 + A00(0, 14, 32) + this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(super.A00);
        parcel.writeString(this.A01);
        parcel.writeString(this.A02);
    }
}
