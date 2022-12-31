package com.growingio.android.sdk.utils.rom;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import com.growingio.android.sdk.utils.LogUtil;
/* loaded from: classes2.dex */
public abstract class RomPermissionChecker {
    public static String TAG;
    protected Activity mContext;

    public RomPermissionChecker(Activity activity) {
        TAG = getClass().getSimpleName();
        this.mContext = activity;
    }

    public abstract boolean check();

    /* JADX INFO: Access modifiers changed from: protected */
    @TargetApi(19)
    public boolean checkOp(int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i2), Integer.valueOf(Binder.getCallingUid()), this.mContext.getPackageName())).intValue() == 0;
            } catch (Exception e2) {
                LogUtil.i(TAG, Log.getStackTraceString(e2));
            }
        } else {
            LogUtil.i(TAG, "Below API 19 cannot invoke!");
        }
        return false;
    }

    public abstract Intent getApplyPermissionIntent();

    /* JADX INFO: Access modifiers changed from: protected */
    public Intent getValidIntent() {
        Intent applyPermissionIntent = getApplyPermissionIntent();
        if (applyPermissionIntent.resolveActivityInfo(this.mContext.getPackageManager(), 65536) != null) {
            return applyPermissionIntent;
        }
        return null;
    }
}
