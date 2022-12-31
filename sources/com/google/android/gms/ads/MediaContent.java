package com.google.android.gms.ads;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public interface MediaContent {
    float getAspectRatio();

    float getCurrentTime();

    float getDuration();

    @Nullable
    Drawable getMainImage();

    VideoController getVideoController();

    boolean hasVideoContent();

    void setMainImage(@Nullable Drawable drawable);
}
