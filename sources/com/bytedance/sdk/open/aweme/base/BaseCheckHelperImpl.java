package com.bytedance.sdk.open.aweme.base;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.aweme.utils.SignatureUtils;
/* loaded from: classes.dex */
public abstract class BaseCheckHelperImpl implements IAPPCheckHelper {
    protected Context mContext;

    public BaseCheckHelperImpl(Context context) {
        this.mContext = context;
    }

    private boolean isAppSupportAuthApi() {
        return isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), getAuthRequestApi());
    }

    private boolean isAppSupportShareApi(String str, String str2, int i2) {
        return isAppSupportAPI(str, str2, i2);
    }

    protected abstract int getAuthRequestApi();

    public int getPlatformSDKVersion(String str, String str2) {
        Bundle bundle;
        if (this.mContext == null || TextUtils.isEmpty(str) || !AppUtil.isAppInstalled(this.mContext, getPackageName())) {
            return -1;
        }
        try {
            ActivityInfo activityInfo = this.mContext.getPackageManager().getActivityInfo(new ComponentName(str, AppUtil.buildComponentClassName(str, str2)), 128);
            if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                return bundle.getInt(ParamKeyConstants.META_PLATFORM_SDK_VERSION, -1);
            }
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return -1;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getRemoteAuthEntryActivity() {
        return "openauthorize.AwemeAuthorizedActivity";
    }

    public abstract String getSignature();

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppInstalled() {
        return AppUtil.isAppInstalled(this.mContext, getPackageName());
    }

    public boolean isAppSupportAPI(String str, String str2, int i2) {
        if (this.mContext == null || TextUtils.isEmpty(str) || !isAppInstalled()) {
            return false;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, AppUtil.buildComponentClassName(str, str2)));
        ActivityInfo resolveActivityInfo = intent.resolveActivityInfo(this.mContext.getPackageManager(), 65536);
        return resolveActivityInfo != null && resolveActivityInfo.exported && getPlatformSDKVersion(str, str2) >= i2;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppSupportAuthorization() {
        return isAppInstalled() && isAppSupportAuthApi() && SignatureUtils.validateSign(this.mContext, getPackageName(), getSignature());
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public boolean isAppSupportShare() {
        return isAppInstalled() && isAppSupportShareApi(getPackageName(), getRemoteAuthEntryActivity(), 3);
    }
}
