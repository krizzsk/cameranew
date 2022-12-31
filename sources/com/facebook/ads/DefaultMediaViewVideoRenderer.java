package com.facebook.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
@Keep
/* loaded from: classes.dex */
public final class DefaultMediaViewVideoRenderer extends MediaViewVideoRenderer {
    private DefaultMediaViewVideoRendererApi mDefaultMediaViewVideoRendererApi;

    public DefaultMediaViewVideoRenderer(Context context) {
        super(context);
        initializeSelf(context);
    }

    private void initializeSelf(Context context) {
        DefaultMediaViewVideoRendererApi createDefaultMediaViewVideoRendererApi = DynamicLoaderFactory.makeLoader(context).createDefaultMediaViewVideoRendererApi();
        this.mDefaultMediaViewVideoRendererApi = createDefaultMediaViewVideoRendererApi;
        createDefaultMediaViewVideoRendererApi.initialize(context, this, getMediaViewVideoRendererApi(), 0);
    }

    @Override // com.facebook.ads.MediaViewVideoRenderer
    public void onPrepared() {
        super.onPrepared();
        this.mDefaultMediaViewVideoRendererApi.onPrepared();
    }

    public DefaultMediaViewVideoRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initializeSelf(context);
    }

    public DefaultMediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initializeSelf(context);
    }

    @TargetApi(21)
    public DefaultMediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        initializeSelf(context);
    }
}
