package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.UiThread;
@Keep
@UiThread
/* loaded from: classes.dex */
public interface AdOptionsViewApi extends AdComponentViewApiProvider {
    void setIconColor(int i2);

    void setIconSizeDp(int i2);

    void setSingleIcon(boolean z);
}
