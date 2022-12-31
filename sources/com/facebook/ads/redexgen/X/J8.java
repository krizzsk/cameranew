package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
/* loaded from: assets/audience_network.dex */
public final class J8 {
    @Nullable
    public final Handler A00;
    @Nullable
    public final J9 A01;

    public J8(@Nullable Handler handler, @Nullable J9 j9) {
        this.A00 = j9 != null ? (Handler) I6.A01(handler) : null;
        this.A01 = j9;
    }

    public final void A01(int i2, int i3, int i4, float f2) {
        if (this.A01 != null) {
            this.A00.post(new J5(this, i2, i3, i4, f2));
        }
    }

    public final void A02(int i2, long j2) {
        if (this.A01 != null) {
            this.A00.post(new J4(this, i2, j2));
        }
    }

    public final void A03(Surface surface) {
        if (this.A01 != null) {
            this.A00.post(new J6(this, surface));
        }
    }

    public final void A04(Format format) {
        if (this.A01 != null) {
            this.A00.post(new J3(this, format));
        }
    }

    public final void A05(C0754Bj c0754Bj) {
        if (this.A01 != null) {
            this.A00.post(new J7(this, c0754Bj));
        }
    }

    public final void A06(C0754Bj c0754Bj) {
        if (this.A01 != null) {
            this.A00.post(new J1(this, c0754Bj));
        }
    }

    public final void A07(String str, long j2, long j3) {
        if (this.A01 != null) {
            this.A00.post(new J2(this, str, j2, j3));
        }
    }
}
