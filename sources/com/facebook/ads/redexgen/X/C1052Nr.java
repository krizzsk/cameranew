package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.Nr  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1052Nr extends FrameLayout {
    public int A00;
    public int A01;
    public final ImageView A02;
    public final ImageView A03;

    public C1052Nr(XT xt) {
        super(xt);
        this.A03 = new ImageView(xt);
        this.A02 = new ImageView(xt);
        A00();
    }

    public C1052Nr(XT xt, AttributeSet attributeSet) {
        super(xt, attributeSet);
        this.A03 = new ImageView(xt, attributeSet);
        this.A02 = new ImageView(xt, attributeSet);
        A00();
    }

    public C1052Nr(XT xt, AttributeSet attributeSet, int i2) {
        super(xt, attributeSet, i2);
        this.A03 = new ImageView(xt, attributeSet, i2);
        this.A02 = new ImageView(xt, attributeSet, i2);
        A00();
    }

    @TargetApi(21)
    public C1052Nr(XT xt, AttributeSet attributeSet, int i2, int i3) {
        super(xt, attributeSet, i2, i3);
        this.A03 = new ImageView(xt, attributeSet, i2, i3);
        this.A02 = new ImageView(xt, attributeSet, i2, i3);
        A00();
    }

    private void A00() {
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
        addView(this.A03, new FrameLayout.LayoutParams(-2, -2));
        Ld.A04(this.A03, Ld.A0A);
        setId(M5.A00());
    }

    public ImageView getBodyImageView() {
        return this.A03;
    }

    public int getImageHeight() {
        return this.A00;
    }

    public int getImageWidth() {
        return this.A01;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int blurBorderViewWidth, int blurBorderViewHeight, int expectedImageHeight, int i2) {
        int i3;
        int i4 = this.A01;
        if (i4 <= 0 || (i3 = this.A00) <= 0) {
            super.onLayout(z, blurBorderViewWidth, blurBorderViewHeight, expectedImageHeight, i2);
            return;
        }
        int i5 = expectedImageHeight - blurBorderViewWidth;
        int i6 = i2 - blurBorderViewHeight;
        float min = Math.min(i5 / i4, i6 / i3);
        int i7 = (int) (this.A01 * min);
        int i8 = (int) (this.A00 * min);
        this.A02.layout(blurBorderViewWidth, blurBorderViewHeight, expectedImageHeight, i2);
        int i9 = (i5 / 2) + blurBorderViewWidth;
        int i10 = (i6 / 2) + blurBorderViewHeight;
        int centerY = i7 / 2;
        int i11 = i9 - centerY;
        int centerY2 = i8 / 2;
        int centerY3 = i8 / 2;
        this.A03.layout(i11, i10 - centerY2, (i7 / 2) + i9, i10 + centerY3);
        this.A02.setVisibility(0);
    }

    public void setImage(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2) {
        if (bitmap2 != null) {
            M5.A0S(this.A02, new BitmapDrawable(getContext().getResources(), bitmap2));
        } else {
            M5.A0M(this.A02, 0);
        }
        if (bitmap != null) {
            this.A01 = bitmap.getWidth();
            this.A00 = bitmap.getHeight();
            this.A03.setImageBitmap(Bitmap.createBitmap(bitmap));
            return;
        }
        this.A03.setImageDrawable(null);
    }
}
