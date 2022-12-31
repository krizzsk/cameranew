package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
/* loaded from: assets/audience_network.dex */
public final class H4 implements Comparable<H4> {
    public static String[] A07 = {"UOhnAWHUvWrKh39blc2", "rJoZ4rjs3", "mwxErCj8CFXQtRdeT7I", "OMBsSVN1m", "xKR0iM7hb", "rY23JmNnbt4", "7JhRM9", "FTdecT"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final DefaultTrackSelector$Parameters A06;

    public H4(Format format, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int i2) {
        this.A06 = defaultTrackSelector$Parameters;
        this.A05 = B6.A0H(i2, false) ? 1 : 0;
        this.A03 = B6.A0K(format, defaultTrackSelector$Parameters.A07) ? 1 : 0;
        this.A02 = (format.A0D & 1) != 0 ? 1 : 0;
        this.A01 = format.A05;
        this.A04 = format.A0C;
        this.A00 = format.A04;
    }

    @Override // java.lang.Comparable
    /* renamed from: A00 */
    public final int compareTo(H4 h4) {
        int A01;
        int A012;
        int A013;
        int A014;
        int A015;
        int A016;
        int A017;
        int i2 = this.A05;
        int i3 = h4.A05;
        if (i2 != i3) {
            A017 = B6.A01(i2, i3);
            return A017;
        }
        int i4 = this.A03;
        int i5 = h4.A03;
        if (i4 != i5) {
            A016 = B6.A01(i4, i5);
            return A016;
        }
        int i6 = this.A02;
        int i7 = h4.A02;
        if (i6 != i7) {
            A015 = B6.A01(i6, i7);
            return A015;
        } else if (this.A06.A0D) {
            A014 = B6.A01(h4.A00, this.A00);
            return A014;
        } else {
            int i8 = this.A05 != 1 ? -1 : 1;
            int i9 = this.A01;
            int i10 = h4.A01;
            String[] strArr = A07;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A07[3] = "q1nzmC2W0";
            if (i9 != i10) {
                A013 = B6.A01(i9, i10);
                return A013 * i8;
            }
            int i11 = this.A04;
            int i12 = h4.A04;
            if (i11 != i12) {
                A012 = B6.A01(i11, i12);
                return A012 * i8;
            }
            A01 = B6.A01(this.A00, h4.A00);
            return A01 * i8;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        H4 h4 = (H4) obj;
        if (this.A05 == h4.A05 && this.A03 == h4.A03 && this.A02 == h4.A02 && this.A01 == h4.A01 && this.A04 == h4.A04) {
            int i2 = this.A00;
            if (A07[5].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[0] = "5gFFNpUtyAKNtlVcilC";
            strArr[2] = "oFDw9vE2Y7jHYxyqfLD";
            if (i2 == h4.A00) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A02;
        int result2 = this.A04;
        return (((((((((this.A05 * 31) + this.A03) * 31) + result) * 31) + this.A01) * 31) + result2) * 31) + this.A00;
    }
}
