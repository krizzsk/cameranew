package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.internal.api.AdComponentView;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdComponentViewParentApi;
/* renamed from: com.facebook.ads.redexgen.X.57  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class AnonymousClass57 implements AdComponentViewApi {
    public static String[] A04 = {"", "DtktONWnXEY5FzVbssK3HUcX82Hc8dPM", "VYSkBw2", "Sk9LBYg", "zsSx1Kr51XMvStaGQs4t", "dpmwV6mETINkPbyFQBJp66qCpa0Du", "", "XIAhU79E3TcXoEefCY9V"};
    public AdComponentView A00;
    public AdComponentViewParentApi A01;
    public AdComponentViewParentApi A02;
    public boolean A03;

    public final void A00(AdComponentViewApi adComponentViewApi) {
        this.A02 = adComponentViewApi;
        ((AdComponentViewApi) this.A02).onAttachedToView(this.A00, this.A01);
    }

    public final void A01(boolean z) {
        this.A03 = z;
    }

    @Override // com.facebook.ads.internal.api.AdComponentView
    public final void addView(View view) {
        if (!this.A03) {
            this.A02.addView(view);
        }
    }

    @Override // com.facebook.ads.internal.api.AdComponentView
    public final void addView(View view, int i2) {
        if (!this.A03) {
            AdComponentViewParentApi adComponentViewParentApi = this.A02;
            if (A04[5].length() == 17) {
                throw new RuntimeException();
            }
            A04[1] = "2ikQI8hSZFFed3t7z6895TIzQQBAwMh9";
            adComponentViewParentApi.addView(view, i2);
        }
    }

    @Override // com.facebook.ads.internal.api.AdComponentView
    public final void addView(View view, int i2, int i3) {
        if (!this.A03) {
            this.A02.addView(view, i2, i3);
        }
    }

    @Override // com.facebook.ads.internal.api.AdComponentView
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        this.A02.addView(view, i2, layoutParams);
    }

    @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (!this.A03) {
            this.A02.addView(view, layoutParams);
        }
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
    public void bringChildToFront(View view) {
        this.A02.bringChildToFront(view);
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApi
    public void onAttachedToView(AdComponentView adComponentView, AdComponentViewParentApi adComponentViewParentApi) {
        this.A01 = adComponentViewParentApi;
        this.A00 = adComponentView;
        this.A02 = adComponentViewParentApi;
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
    public void onAttachedToWindow() {
        this.A02.onAttachedToWindow();
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
    public void onDetachedFromWindow() {
        this.A02.onDetachedFromWindow();
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
    public void onMeasure(int i2, int i3) {
        this.A02.onMeasure(i2, i3);
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
    public void onVisibilityChanged(View view, int i2) {
        this.A02.onVisibilityChanged(view, i2);
    }

    @Override // com.facebook.ads.internal.api.AdComponentView
    public void onWindowFocusChanged(boolean z) {
        this.A02.onWindowFocusChanged(z);
    }

    @Override // com.facebook.ads.internal.api.AdComponentView
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.A02.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void setMeasuredDimension(int i2, int i3) {
        this.A02.setMeasuredDimension(i2, i3);
    }
}
