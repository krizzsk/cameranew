package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Ul  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1226Ul implements HD {
    public static String[] A06 = {"pUEZtwC879kNTB0j2TOCFjJulbgJhqUC", "LPVOHHlL8UGYMHe0OEH9XWTZwVKfE88", "jCWSEziDhw1FUDawrAH0", "ULlgao2XS9ulxIggOdCWnHLutHCveOYX", "OfpsRfCrHKp957e6", "lRTa0LPDu3nTDFLS", "m8d4mf9eDgFJFgmjbUCxubxaGITUd7Ju", "HrUOWAYLXAxBFn4TYCBDJo12hDa"};
    public int A00;
    public final long[] A01;
    public final Format[] A02;
    public final int A03;
    public final TrackGroup A04;
    public final int[] A05;

    public AbstractC1226Ul(TrackGroup trackGroup, int... iArr) {
        I6.A04(iArr.length > 0);
        this.A04 = (TrackGroup) I6.A01(trackGroup);
        this.A03 = iArr.length;
        this.A02 = new Format[this.A03];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.A02[i2] = trackGroup.A01(iArr[i2]);
        }
        Arrays.sort(this.A02, new H1());
        this.A05 = new int[this.A03];
        int i3 = 0;
        while (true) {
            int i4 = this.A03;
            if (i3 < i4) {
                this.A05[i3] = trackGroup.A00(this.A02[i3]);
                i3++;
            } else {
                this.A01 = new long[i4];
                return;
            }
        }
    }

    public final boolean A00(int i2, long j2) {
        return this.A01[i2] > j2;
    }

    @Override // com.facebook.ads.redexgen.X.HD
    public void A56() {
    }

    @Override // com.facebook.ads.redexgen.X.HD
    public final Format A6d(int i2) {
        return this.A02[i2];
    }

    @Override // com.facebook.ads.redexgen.X.HD
    public final int A6j(int i2) {
        return this.A05[i2];
    }

    @Override // com.facebook.ads.redexgen.X.HD
    public final Format A7J() {
        return this.A02[A7K()];
    }

    @Override // com.facebook.ads.redexgen.X.HD
    public final TrackGroup A7Z() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.HD
    public void ABa(float f2) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (A06[5].length() != 16) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[4] = "LRd3kE9IkICWfxuz";
        strArr[7] = "u7g1WhIErEGO9Vcw68pTGYuY7C3";
        AbstractC1226Ul abstractC1226Ul = (AbstractC1226Ul) obj;
        return this.A04 == abstractC1226Ul.A04 && Arrays.equals(this.A05, abstractC1226Ul.A05);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int identityHashCode = System.identityHashCode(this.A04);
            if (A06[6].charAt(23) != 'a') {
                throw new RuntimeException();
            }
            A06[6] = "LdgR80foYK7ntQpYvL7rAZHaf8ikiVBs";
            this.A00 = (identityHashCode * 31) + Arrays.hashCode(this.A05);
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.HD
    public final int length() {
        return this.A05.length;
    }
}
