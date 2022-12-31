package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;
/* renamed from: com.facebook.ads.redexgen.X.b7  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1437b7 extends AnonymousClass57 implements NativeAdLayoutApi {
    @Nullable
    public View A02;
    public NativeAdLayout A03;
    public int A01 = 0;
    public int A00 = 0;

    public final void A02() {
        M5.A0T(this.A03);
        this.A03.removeView(this.A02);
        this.A02 = null;
    }

    public final void A03(N1 n1) {
        this.A02 = n1;
        n1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        M5.A0T(this.A03);
        this.A03.addView(this.A02);
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void initialize(NativeAdLayout nativeAdLayout) {
        this.A03 = nativeAdLayout;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass57, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.A00 > 0) {
            int measuredWidth = this.A03.getMeasuredWidth();
            int i4 = this.A00;
            if (measuredWidth > i4) {
                setMeasuredDimension(i4, this.A03.getMeasuredHeight());
                return;
            }
        }
        int measuredWidth2 = this.A03.getMeasuredWidth();
        int i5 = this.A01;
        if (measuredWidth2 >= i5) {
            return;
        }
        setMeasuredDimension(i5, this.A03.getMeasuredHeight());
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void setMaxWidth(int i2) {
        this.A00 = i2;
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void setMinWidth(int i2) {
        this.A01 = i2;
    }
}
