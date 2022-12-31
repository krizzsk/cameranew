package com.facebook.ads.internal.api;

import android.content.res.Configuration;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;
@Keep
@UiThread
/* loaded from: classes.dex */
public interface AdViewParentApi {
    void onConfigurationChanged(Configuration configuration);
}
