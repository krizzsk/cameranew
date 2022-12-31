package com.bytedance.sdk.open.aweme.share;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes.dex */
public class ShareImpl {
    private List<IDataHandler> handlers = new ArrayList();
    private WeakReference<Context> mAct;
    private String mClientKey;

    public ShareImpl(Context context, String str) {
        this.mAct = new WeakReference<>(context);
        this.mClientKey = str;
        this.handlers.add(new ShareDataHandler());
    }

    private String buildComponentClassName(String str, String str2) {
        return "com.ss.android.ugc.aweme." + str2;
    }

    public boolean share(String str, String str2, String str3, Share.Request request, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str2) || request == null || this.mAct.get() == null || !request.checkArgs()) {
            return false;
        }
        Bundle bundle = new Bundle();
        if (AppUtil.getPlatformSDKVersion(this.mAct.get(), str2, str4) >= 3) {
            request.toBundle(bundle);
        }
        bundle.putString(ParamKeyConstants.ShareParams.CLIENT_KEY, this.mClientKey);
        bundle.putString(ParamKeyConstants.ShareParams.CALLER_PKG, this.mAct.get().getPackageName());
        bundle.putString(ParamKeyConstants.ShareParams.CALLER_SDK_VERSION, "1");
        if (TextUtils.isEmpty(request.callerLocalEntry)) {
            bundle.putString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY, this.mAct.get().getPackageName() + "." + str);
        }
        Bundle bundle2 = request.extras;
        if (bundle2 != null) {
            bundle.putBundle(ParamKeyConstants.BaseParams.EXTRA, bundle2);
        }
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, str5);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, str6);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str2, buildComponentClassName(str2, str3)));
        intent.putExtras(bundle);
        if (!(this.mAct.get() instanceof Activity)) {
            intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        }
        intent.addFlags(32768);
        try {
            this.mAct.get().startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
