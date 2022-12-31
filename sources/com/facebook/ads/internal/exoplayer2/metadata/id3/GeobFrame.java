package com.facebook.ads.internal.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.EE;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public final class GeobFrame extends Id3Frame {
    public static byte[] A04;
    public static String[] A05 = {"p5UgAckTjmiGwIEIp83kIoPYrYx51Hw3", "97Kf", "57iypjQefLkAX1Pf2WMG90QuGpxdZgI9", "MH86n39kjy3It9ArXMcOY1qRtEydqyVj", "czNdDpNwjYz3LUV8hemm9Bag6a1DUht2", "5z2r5SqfWorFCf0GfnerHo5X3AOsS9gQ", "7Yq0Z", "aSTQxqZrOCwJPjy2PBAUJaSPZ7cz8UJW"};
    public static final Parcelable.Creator<GeobFrame> CREATOR;
    public final String A00;
    public final String A01;
    public final String A02;
    public final byte[] A03;

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A04, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A05;
            if (strArr[3].charAt(14) == strArr[4].charAt(14)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[3] = "S35uTAl8blKCIA6RDoKwUWKuPnlgGmXm";
            strArr2[4] = "SsAAbyTQ3GSJA95JV1WqS3o9zGFFtLED";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 18);
            i5++;
        }
    }

    public static void A01() {
        A04 = new byte[]{111, 99, 39, 38, 48, 32, 49, 42, 51, 55, 42, 44, 45, 126, 118, 122, 60, 51, 54, 63, 52, 59, 55, 63, 103, 41, 51, 126, 122, 126, 118, 71, 106, 99, 118, 46, 104, 106, 96, 109};
    }

    static {
        A01();
        CREATOR = new EE();
    }

    public GeobFrame(Parcel parcel) {
        super(A00(36, 4, 61));
        this.A02 = parcel.readString();
        this.A01 = parcel.readString();
        this.A00 = parcel.readString();
        this.A03 = parcel.createByteArray();
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(A00(36, 4, 61));
        this.A02 = str;
        this.A01 = str2;
        this.A00 = str3;
        this.A03 = bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (com.facebook.ads.redexgen.X.C0923Il.A0g(r5.A02, r6.A02) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
        if (com.facebook.ads.redexgen.X.C0923Il.A0g(r5.A01, r6.A01) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
        if (com.facebook.ads.redexgen.X.C0923Il.A0g(r5.A00, r6.A00) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007a, code lost:
        if (java.util.Arrays.equals(r5.A03, r6.A03) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0085, code lost:
        if (com.facebook.ads.redexgen.X.C0923Il.A0g(r5.A02, r6.A02) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0088, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(@androidx.annotation.Nullable java.lang.Object r6) {
        /*
            r5 = this;
            r4 = 1
            if (r5 != r6) goto L4
            return r4
        L4:
            r3 = 0
            java.lang.String[] r2 = com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame.A05
            r0 = 0
            r1 = r2[r0]
            r0 = 5
            r2 = r2[r0]
            r0 = 21
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L1f
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1f:
            java.lang.String[] r2 = com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame.A05
            java.lang.String r1 = "qpy6"
            r0 = 1
            r2[r0] = r1
            if (r6 == 0) goto L32
            java.lang.Class r1 = r5.getClass()
            java.lang.Class r0 = r6.getClass()
            if (r1 == r0) goto L33
        L32:
            return r3
        L33:
            com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame r6 = (com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame) r6
            java.lang.String[] r2 = com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame.A05
            r0 = 2
            r1 = r2[r0]
            r0 = 7
            r2 = r2[r0]
            r0 = 2
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L7d
            java.lang.String[] r2 = com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame.A05
            java.lang.String r1 = "ZxNtpKl8Qog9k8N9AfFsAobqqZJconha"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "CevArDyiRACDVeaxwdL6do5tdD551HHN"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = r5.A02
            java.lang.String r0 = r6.A02
            boolean r0 = com.facebook.ads.redexgen.X.C0923Il.A0g(r1, r0)
            if (r0 == 0) goto L88
        L5e:
            java.lang.String r1 = r5.A01
            java.lang.String r0 = r6.A01
            boolean r0 = com.facebook.ads.redexgen.X.C0923Il.A0g(r1, r0)
            if (r0 == 0) goto L88
            java.lang.String r1 = r5.A00
            java.lang.String r0 = r6.A00
            boolean r0 = com.facebook.ads.redexgen.X.C0923Il.A0g(r1, r0)
            if (r0 == 0) goto L88
            byte[] r1 = r5.A03
            byte[] r0 = r6.A03
            boolean r0 = java.util.Arrays.equals(r1, r0)
            if (r0 == 0) goto L88
        L7c:
            return r4
        L7d:
            java.lang.String r1 = r5.A02
            java.lang.String r0 = r6.A02
            boolean r0 = com.facebook.ads.redexgen.X.C0923Il.A0g(r1, r0)
            if (r0 == 0) goto L88
            goto L5e
        L88:
            r4 = 0
            goto L7c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.exoplayer2.metadata.id3.GeobFrame.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 17 * 31;
        String str = this.A02;
        int result = str != null ? str.hashCode() : 0;
        int i3 = (i2 + result) * 31;
        String str2 = this.A01;
        int result2 = str2 != null ? str2.hashCode() : 0;
        int i4 = i3 + result2;
        if (A05[1].length() != 4) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[3] = "5eDn8afHXDuGLumtwhVuBGsgGShhwGUa";
        strArr[4] = "hfSsrwL4qnCDd3h6Kdz3LdbJUMkhTjAD";
        int i5 = i4 * 31;
        String str3 = this.A00;
        int hashCode = str3 != null ? str3.hashCode() : 0;
        int result3 = Arrays.hashCode(this.A03);
        return ((i5 + hashCode) * 31) + result3;
    }

    @Override // com.facebook.ads.internal.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        return super.A00 + A00(25, 11, 1) + this.A02 + A00(14, 11, 72) + this.A01 + A00(0, 14, 81) + this.A00;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.A02);
        parcel.writeString(this.A01);
        parcel.writeString(this.A00);
        parcel.writeByteArray(this.A03);
    }
}
