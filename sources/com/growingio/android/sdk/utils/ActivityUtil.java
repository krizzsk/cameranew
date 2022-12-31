package com.growingio.android.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes2.dex */
public final class ActivityUtil {
    private ActivityUtil() {
    }

    @Nullable
    public static Activity findActivity(@NonNull Context context) {
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        while (true) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper instanceof Activity) {
                return (Activity) contextWrapper;
            }
            context = contextWrapper.getBaseContext();
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
        }
    }

    public static boolean isDestroy(Context context) {
        Activity findActivity = findActivity(context);
        if (findActivity == null || Build.VERSION.SDK_INT < 17) {
            return false;
        }
        return findActivity.isDestroyed();
    }
}
