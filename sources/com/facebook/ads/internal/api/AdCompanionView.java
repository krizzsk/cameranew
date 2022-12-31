package com.facebook.ads.internal.api;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
/* loaded from: classes.dex */
public class AdCompanionView extends AdComponentFrameLayout {
    private AdCompanionViewApi mAdCompanionViewApi;

    public AdCompanionView(Context context) {
        super(context);
        initializeSelf(context);
    }

    private void initializeSelf(Context context) {
        AdCompanionViewApi createAdCompanionViewApi = DynamicLoaderFactory.makeLoader(context).createAdCompanionViewApi();
        this.mAdCompanionViewApi = createAdCompanionViewApi;
        attachAdComponentViewApi(createAdCompanionViewApi);
        this.mAdCompanionViewApi.initialize(this);
    }

    public AdCompanionViewApi getAdCompanionViewApi() {
        return this.mAdCompanionViewApi;
    }

    public AdCompanionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initializeSelf(context);
    }

    public AdCompanionView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initializeSelf(context);
    }
}
