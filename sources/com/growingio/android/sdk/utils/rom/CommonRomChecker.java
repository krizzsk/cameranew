package com.growingio.android.sdk.utils.rom;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.growingio.android.sdk.utils.LogUtil;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes2.dex */
public class CommonRomChecker extends RomPermissionChecker {
    public CommonRomChecker(Activity activity) {
        super(activity);
    }

    @Override // com.growingio.android.sdk.utils.rom.RomPermissionChecker
    public boolean check() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                return Settings.canDrawOverlays(this.mContext);
            } catch (Exception e2) {
                LogUtil.i(RomPermissionChecker.TAG, Log.getStackTraceString(e2));
                return true;
            }
        }
        return true;
    }

    @Override // com.growingio.android.sdk.utils.rom.RomPermissionChecker
    @TargetApi(23)
    public Intent getApplyPermissionIntent() {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
        intent.setData(Uri.parse("package:" + this.mContext.getPackageName()));
        return intent;
    }
}
