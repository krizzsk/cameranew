package com.bytedance.sdk.open.douyin.c;

import android.content.Context;
import com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl;
import com.bytedance.sdk.open.aweme.utils.SignatureUtils;
/* loaded from: classes.dex */
public class a extends BaseCheckHelperImpl {
    public a(Context context) {
        super(context);
    }

    public int a() {
        return 6;
    }

    public boolean b() {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), "openshare.ShareToContactsActivity", 1);
    }

    public boolean c() {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), "opensdk.OpenCameraActivity", 1);
    }

    public boolean d() {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), 8);
    }

    public boolean e() {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), 7);
    }

    public boolean f() {
        return isAppInstalled() && isAppSupportAPI(getPackageName(), getRemoteAuthEntryActivity(), a()) && SignatureUtils.validateSign(this.mContext, getPackageName(), getSignature());
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    protected int getAuthRequestApi() {
        return 1;
    }

    @Override // com.bytedance.sdk.open.aweme.base.IAPPCheckHelper
    public String getPackageName() {
        return "com.ss.android.ugc.aweme";
    }

    @Override // com.bytedance.sdk.open.aweme.base.BaseCheckHelperImpl
    public String getSignature() {
        return "aea615ab910015038f73c47e45d21466";
    }
}
