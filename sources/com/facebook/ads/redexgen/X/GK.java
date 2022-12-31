package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.text.Layout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
/* loaded from: assets/audience_network.dex */
public class GK {
    public final float A00;
    public final float A01;
    public final float A02;
    public final float A03;
    public final float A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    @Nullable
    public final Bitmap A0A;
    @Nullable
    public final Layout.Alignment A0B;
    @Nullable
    public final CharSequence A0C;
    public final boolean A0D;

    public GK(Bitmap bitmap, float f2, int i2, float f3, int i3, float f4, float f5) {
        this(null, null, bitmap, f3, 0, i3, f2, i2, Integer.MIN_VALUE, Float.MIN_VALUE, f4, f5, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public GK(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public GK(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, f2, i2, i3, f3, i4, f4, false, (int) ViewCompat.MEASURED_STATE_MASK);
    }

    public GK(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, int i5, float f5) {
        this(charSequence, alignment, null, f2, i2, i3, f3, i4, i5, f5, f4, Float.MIN_VALUE, false, ViewCompat.MEASURED_STATE_MASK);
    }

    public GK(CharSequence charSequence, @Nullable Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z, int i5) {
        this(charSequence, alignment, null, f2, i2, i3, f3, i4, Integer.MIN_VALUE, Float.MIN_VALUE, f4, Float.MIN_VALUE, z, i5);
    }

    public GK(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Bitmap bitmap, float f2, int i2, int i3, float f3, int i4, int i5, float f4, float f5, float f6, boolean z, int i6) {
        this.A0C = charSequence;
        this.A0B = alignment;
        this.A0A = bitmap;
        this.A01 = f2;
        this.A06 = i2;
        this.A05 = i3;
        this.A02 = f3;
        this.A07 = i4;
        this.A03 = f5;
        this.A00 = f6;
        this.A0D = z;
        this.A09 = i6;
        this.A08 = i5;
        this.A04 = f4;
    }
}
