package com.bytedance.sdk.open.douyin;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.utils.AppUtil;
import com.bytedance.sdk.open.douyin.model.OpenRecord;
import java.lang.ref.WeakReference;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes.dex */
public class b {
    private String a;
    private WeakReference<Activity> b;

    public b(Activity activity, String str) {
        this.b = new WeakReference<>(activity);
        this.a = str;
    }

    public void a(String str, String str2, String str3, OpenRecord.Request request, String str4, String str5) {
        if (TextUtils.isEmpty(str2) || request == null || this.b.get() == null) {
            return;
        }
        Bundle bundle = new Bundle();
        request.toBundle(bundle);
        bundle.putString(ParamKeyConstants.ShareParams.CLIENT_KEY, this.a);
        bundle.putString(ParamKeyConstants.ShareParams.CALLER_PKG, this.b.get().getPackageName());
        if (TextUtils.isEmpty(request.callerLocalEntry)) {
            bundle.putString(ParamKeyConstants.ShareParams.CALLER_LOCAL_ENTRY, this.b.get().getPackageName() + "." + str);
        }
        Bundle bundle2 = request.extras;
        if (bundle2 != null) {
            bundle.putBundle(ParamKeyConstants.BaseParams.EXTRA, bundle2);
        }
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_NAME, str4);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_VERSION, str5);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str2, AppUtil.buildComponentClassName(str2, str3)));
        intent.putExtras(bundle);
        intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
        intent.addFlags(32768);
        this.b.get().startActivityForResult(intent, 102);
    }
}
