package com.growingio.android.sdk.utils.rom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.growingio.android.sdk.utils.LogUtil;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes2.dex */
public class MiUiChecker extends RomPermissionChecker {
    public MiUiChecker(Activity activity) {
        super(activity);
    }

    private static boolean isIntentAvailable(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
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
        int miuiVersion = RomChecker.getMiuiVersion();
        if (miuiVersion == 5) {
            String packageName = this.mContext.getPackageName();
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", packageName, null));
            intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            return intent;
        } else if (miuiVersion == 6 || miuiVersion == 7) {
            Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent2.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent2.putExtra("extra_pkgname", this.mContext.getPackageName());
            intent2.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            return intent2;
        } else if (miuiVersion == 8) {
            Intent intent3 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent3.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent3.putExtra("extra_pkgname", this.mContext.getPackageName());
            intent3.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            if (isIntentAvailable(intent3, this.mContext)) {
                this.mContext.startActivity(intent3);
                return intent3;
            }
            Intent intent4 = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent4.setPackage("com.miui.securitycenter");
            intent4.putExtra("extra_pkgname", this.mContext.getPackageName());
            intent4.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            return intent4;
        } else {
            String str = RomPermissionChecker.TAG;
            LogUtil.i(str, "this is a special MIUI rom version, its version code " + miuiVersion);
            return null;
        }
    }
}
