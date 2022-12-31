package com.growingio.android.sdk.utils.rom;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes2.dex */
public class MeizuChecker extends RomPermissionChecker {
    public MeizuChecker(Activity activity) {
        super(activity);
    }

    @Override // com.growingio.android.sdk.utils.rom.RomPermissionChecker
    public boolean check() {
        if (Build.VERSION.SDK_INT >= 19) {
            return checkOp(24);
        }
        return false;
    }

    @Override // com.growingio.android.sdk.utils.rom.RomPermissionChecker
    public Intent getApplyPermissionIntent() {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", this.mContext.getPackageName());
        intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
        return intent;
    }
}
