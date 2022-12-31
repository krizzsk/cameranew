package com.bytedance.sdk.openadsdk;

import android.content.Context;
/* loaded from: classes.dex */
public interface TTAdManager {
    TTAdNative createAdNative(Context context);

    String getBiddingToken();

    int getGdpr();

    String getSDKVersion();

    boolean isExpressAd(String str, String str2);

    boolean isFullScreenVideoAd(String str, String str2);

    @Deprecated
    TTAdManager isUseTextureView(boolean z);

    boolean onlyVerityPlayable(String str, int i2, String str2, String str3, String str4);

    @Deprecated
    TTAdManager openDebugMode();

    @Deprecated
    void requestPermissionIfNecessary(Context context);

    @Deprecated
    TTAdManager setAllowLandingPageShowWhenScreenLock(boolean z);

    @Deprecated
    TTAdManager setAllowShowNotifiFromSDK(boolean z);

    @Deprecated
    TTAdManager setAppId(String str);

    @Deprecated
    TTAdManager setCoppa(int i2);

    @Deprecated
    TTAdManager setData(String str);

    TTAdManager setGdpr(int i2);

    @Deprecated
    TTAdManager setKeywords(String str);

    @Deprecated
    TTAdManager setName(String str);

    @Deprecated
    TTAdManager setNeedClearTaskReset(String[] strArr);

    @Deprecated
    TTAdManager setPaid(boolean z);

    @Deprecated
    TTAdManager setTitleBarTheme(int i2);

    void showPrivacyProtection();
}
