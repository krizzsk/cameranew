package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
/* loaded from: assets/audience_network.dex */
public final class BF {
    @Nullable
    public final Handler A00;
    @Nullable
    public final BG A01;

    public BF(@Nullable Handler handler, @Nullable BG bg) {
        this.A00 = bg != null ? (Handler) I6.A01(handler) : null;
        this.A01 = bg;
    }

    public final void A01(int i2) {
        if (this.A01 != null) {
            this.A00.post(new BE(this, i2));
        }
    }

    public final void A02(int i2, long j2, long j3) {
        if (this.A01 != null) {
            this.A00.post(new BC(this, i2, j2, j3));
        }
    }

    public final void A03(Format format) {
        if (this.A01 != null) {
            this.A00.post(new BB(this, format));
        }
    }

    public final void A04(C0754Bj c0754Bj) {
        if (this.A01 != null) {
            this.A00.post(new BD(this, c0754Bj));
        }
    }

    public final void A05(C0754Bj c0754Bj) {
        if (this.A01 != null) {
            this.A00.post(new B9(this, c0754Bj));
        }
    }

    public final void A06(String str, long j2, long j3) {
        if (this.A01 != null) {
            this.A00.post(new BA(this, str, j2, j3));
        }
    }
}
