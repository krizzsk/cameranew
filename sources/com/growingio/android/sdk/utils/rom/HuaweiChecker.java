package com.growingio.android.sdk.utils.rom;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.growingio.android.sdk.utils.LogUtil;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes2.dex */
public class HuaweiChecker extends RomPermissionChecker {
    public HuaweiChecker(Activity activity) {
        super(activity);
    }

    @Override // com.growingio.android.sdk.utils.rom.RomPermissionChecker
    public boolean check() {
        if (Build.VERSION.SDK_INT >= 19) {
            return checkOp(24);
        }
        return true;
    }

    @Override // com.growingio.android.sdk.utils.rom.RomPermissionChecker
    public Intent getApplyPermissionIntent() {
        Intent intent = new Intent();
        try {
            intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (RomChecker.getEmuiVersion() != 3.1d) {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                return intent;
            }
            return intent;
        } catch (ActivityNotFoundException unused) {
            intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            intent.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            return intent;
        } catch (SecurityException unused2) {
            intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            return intent;
        } catch (Exception e2) {
            LogUtil.i(RomPermissionChecker.TAG, Log.getStackTraceString(e2));
            return null;
        }
    }
}
