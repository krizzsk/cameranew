package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.open.douyin.api.DouYinOpenApi;
/* loaded from: classes.dex */
public class DouYinOpenApiFactory {
    private static DouYinOpenConfig sConfig;

    public static DouYinOpenApi create(Activity activity) {
        DouYinOpenConfig douYinOpenConfig = sConfig;
        if (douYinOpenConfig == null || activity == null) {
            return null;
        }
        return new com.bytedance.sdk.open.douyin.c.b(activity, douYinOpenConfig.clientKey);
    }

    public static DouYinOpenApi create(Activity activity, DouYinOpenConfig douYinOpenConfig) {
        if (douYinOpenConfig == null || activity == null) {
            return null;
        }
        return new com.bytedance.sdk.open.douyin.c.b(activity, douYinOpenConfig.clientKey);
    }

    public static boolean init(DouYinOpenConfig douYinOpenConfig) {
        if (douYinOpenConfig == null || TextUtils.isEmpty(douYinOpenConfig.clientKey)) {
            return false;
        }
        sConfig = douYinOpenConfig;
        return true;
    }
}
