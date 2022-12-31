package com.bytedance.sdk.open.aweme.base;
/* loaded from: classes.dex */
public interface IAPPCheckHelper {
    String getPackageName();

    String getRemoteAuthEntryActivity();

    boolean isAppInstalled();

    boolean isAppSupportAuthorization();

    boolean isAppSupportShare();
}
