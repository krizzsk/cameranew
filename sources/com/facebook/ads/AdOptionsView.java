package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.AdComponentFrameLayout;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
@Keep
/* loaded from: classes.dex */
public class AdOptionsView extends AdComponentFrameLayout {
    private final AdOptionsViewApi mAdOptionsViewApi;

    @Keep
    /* loaded from: classes.dex */
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    public AdOptionsView(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout) {
        super(context);
        AdOptionsViewApi createAdOptionsView = DynamicLoaderFactory.makeLoader(context).createAdOptionsView(context, nativeAdBase, nativeAdLayout, this);
        this.mAdOptionsViewApi = createAdOptionsView;
        attachAdComponentViewApi(createAdOptionsView);
    }

    public void setIconColor(int i2) {
        this.mAdOptionsViewApi.setIconColor(i2);
    }

    public void setIconSizeDp(int i2) {
        this.mAdOptionsViewApi.setIconSizeDp(i2);
    }

    public void setSingleIcon(boolean z) {
        this.mAdOptionsViewApi.setSingleIcon(z);
    }

    public AdOptionsView(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, Orientation orientation, int i2) {
        super(context);
        AdOptionsViewApi createAdOptionsView = DynamicLoaderFactory.makeLoader(context).createAdOptionsView(context, nativeAdBase, nativeAdLayout, orientation, i2, this);
        this.mAdOptionsViewApi = createAdOptionsView;
        attachAdComponentViewApi(createAdOptionsView);
    }
}
