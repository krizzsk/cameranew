package com.facebook.ads.internal.api;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
@Keep
/* loaded from: classes.dex */
public abstract class AdNativeComponentView extends RelativeLayout implements AdComponentView {
    @Nullable
    protected AdComponentViewApi mAdComponentViewApi;
    private final AdComponentViewParentApi mAdComponentViewParentApi;

    public AdNativeComponentView(Context context) {
        super(context);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i2, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i2, int i3) {
                AdNativeComponentView.super.onMeasure(i2, i3);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i2) {
                AdNativeComponentView.super.onVisibilityChanged(view, i2);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z) {
                AdNativeComponentView.super.onWindowFocusChanged(z);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i2, int i3) {
                AdNativeComponentView.super.setMeasuredDimension(i2, i3);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i2) {
                AdNativeComponentView.super.addView(view, i2);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i2, int i3) {
                AdNativeComponentView.super.addView(view, i2, i3);
            }
        };
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view);
        } else {
            super.addView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachAdComponentViewApi(AdComponentViewApiProvider adComponentViewApiProvider) {
        if (DynamicLoaderFactory.isFallbackMode()) {
            return;
        }
        if (this.mAdComponentViewApi == null) {
            adComponentViewApiProvider.getAdComponentViewApi().onAttachedToView(this, this.mAdComponentViewParentApi);
            this.mAdComponentViewApi = adComponentViewApiProvider.getAdComponentViewApi();
            return;
        }
        throw new IllegalStateException("AdComponentViewApi can't be attached more then once.");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.bringChildToFront(view);
        } else {
            super.bringChildToFront(view);
        }
    }

    public abstract View getAdContentsView();

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void onAttachedToWindow() {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void onDetachedFromWindow() {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onMeasure(i2, i3);
        } else {
            super.onMeasure(i2, i3);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onVisibilityChanged(view, i2);
        } else {
            super.onVisibilityChanged(view, i2);
        }
    }

    @Override // android.view.View, com.facebook.ads.internal.api.AdComponentView
    public void onWindowFocusChanged(boolean z) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onWindowFocusChanged(z);
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View, com.facebook.ads.internal.api.AdComponentView
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.setLayoutParams(layoutParams);
        } else {
            super.setLayoutParams(layoutParams);
        }
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i2, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i2, int i3) {
                AdNativeComponentView.super.onMeasure(i2, i3);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i2) {
                AdNativeComponentView.super.onVisibilityChanged(view, i2);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z) {
                AdNativeComponentView.super.onWindowFocusChanged(z);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i2, int i3) {
                AdNativeComponentView.super.setMeasuredDimension(i2, i3);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i2) {
                AdNativeComponentView.super.addView(view, i2);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i2, int i3) {
                AdNativeComponentView.super.addView(view, i2, i3);
            }
        };
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i2) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i2);
        } else {
            super.addView(view, i2);
        }
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i22, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i22, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i22, int i3) {
                AdNativeComponentView.super.onMeasure(i22, i3);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i22) {
                AdNativeComponentView.super.onVisibilityChanged(view, i22);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z) {
                AdNativeComponentView.super.onWindowFocusChanged(z);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i22, int i3) {
                AdNativeComponentView.super.setMeasuredDimension(i22, i3);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i22) {
                AdNativeComponentView.super.addView(view, i22);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i22, int i3) {
                AdNativeComponentView.super.addView(view, i22, i3);
            }
        };
    }

    @RequiresApi(api = 21)
    public AdNativeComponentView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i22, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i22, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i22, int i32) {
                AdNativeComponentView.super.onMeasure(i22, i32);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i22) {
                AdNativeComponentView.super.onVisibilityChanged(view, i22);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z) {
                AdNativeComponentView.super.onWindowFocusChanged(z);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i22, int i32) {
                AdNativeComponentView.super.setMeasuredDimension(i22, i32);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i22) {
                AdNativeComponentView.super.addView(view, i22);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i22, int i32) {
                AdNativeComponentView.super.addView(view, i22, i32);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.ViewManager, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, layoutParams);
        } else {
            super.addView(view, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i2, int i3) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i2, i3);
        } else {
            super.addView(view, i2, i3);
        }
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i2, layoutParams);
        } else {
            super.addView(view, i2, layoutParams);
        }
    }
}
