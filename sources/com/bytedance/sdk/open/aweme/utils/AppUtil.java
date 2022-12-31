package com.bytedance.sdk.open.aweme.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
/* loaded from: classes.dex */
public class AppUtil {
    public static String buildComponentClassName(String str, String str2) {
        return str + "." + str2;
    }

    public static int getPlatformSDKVersion(Context context, String str, String str2) {
        Bundle bundle;
        if (context == null || TextUtils.isEmpty(str) || !isAppInstalled(context, str)) {
            return -1;
        }
        try {
            ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new ComponentName(str, buildComponentClassName(str, str2)), 128);
            if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                return bundle.getInt(ParamKeyConstants.META_PLATFORM_SDK_VERSION, -1);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return -1;
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 16384) != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
