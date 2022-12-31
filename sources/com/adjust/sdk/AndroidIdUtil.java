package com.adjust.sdk;

import android.content.Context;
import android.provider.Settings;
import com.tapjoy.TapjoyConstants;
/* loaded from: classes.dex */
public class AndroidIdUtil {
    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
    }
}
