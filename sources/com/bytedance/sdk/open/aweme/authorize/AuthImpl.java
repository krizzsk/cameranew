package com.bytedance.sdk.open.aweme.authorize;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class AuthImpl {
    private WeakReference<Activity> mAct;
    private String mClientKey;

    public AuthImpl(Activity activity, String str) {
        this.mAct = new WeakReference<>(activity);
        this.mClientKey = str;
    }

    public boolean authorizeNative(Authorization.Request request, String str, String str2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str) || request == null || this.mAct.get() == null || !request.checkArgs()) {
            return false;
        }
        Bundle bundle = new Bundle();
        request.toBundle(bundle);
        bundle.putString(ParamKeyConstants.AuthParams.CLIENT_KEY, this.mClientKey);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_PKG, this.mAct.get().getPackageName());
        if (TextUtils.isEmpty(request.callerLocalEntry)) {
            bundle.putString(ParamKeyConstants.BaseParams.FROM_ENTRY, AppUtil.buildComponentClassName(this.mAct.get().getPackageName(), str3));
        }
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, str4);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, str5);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, AppUtil.buildComponentClassName(str, str2)));
        intent.putExtras(bundle);
        try {
            this.mAct.get().startActivityForResult(intent, 100);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean authorizeWeb(Class cls, Authorization.Request request) {
        if (request == null || this.mAct.get() == null || !request.checkArgs()) {
            return false;
        }
        Bundle bundle = new Bundle();
        request.toBundle(bundle);
        bundle.putString(ParamKeyConstants.AuthParams.CLIENT_KEY, this.mClientKey);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_PKG, this.mAct.get().getPackageName());
        Intent intent = new Intent(this.mAct.get(), cls);
        intent.putExtras(bundle);
        intent.addFlags(67108864);
        try {
            this.mAct.get().startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
