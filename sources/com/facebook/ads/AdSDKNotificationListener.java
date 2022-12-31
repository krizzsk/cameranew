package com.facebook.ads;

import android.os.Bundle;
import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Keep
/* loaded from: classes.dex */
public interface AdSDKNotificationListener {
    public static final String ENCRYPTED_CPM_KEY = "encrypted_cpm";
    public static final String IMPRESSION_EVENT = "impression";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SDKEventKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SDKEventType {
    }

    void onAdEvent(String str, Bundle bundle);
}
