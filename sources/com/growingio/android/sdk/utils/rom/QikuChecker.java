package com.growingio.android.sdk.utils.rom;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import us.pinguo.androidsdk.PGImageSDK;
/* loaded from: classes2.dex */
public class QikuChecker extends RomPermissionChecker {
    public QikuChecker(Activity activity) {
        super(activity);
    }

    private boolean isIntentAvailable(Intent intent) {
        return intent != null && this.mContext.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
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
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
        if (isIntentAvailable(intent)) {
            return intent;
        }
        intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
        if (isIntentAvailable(intent)) {
            return intent;
        }
        return null;
    }
}
