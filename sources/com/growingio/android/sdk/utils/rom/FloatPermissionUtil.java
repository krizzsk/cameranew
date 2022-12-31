package com.growingio.android.sdk.utils.rom;

import android.app.Activity;
import android.os.Build;
/* loaded from: classes2.dex */
public class FloatPermissionUtil {
    public static RomPermissionChecker getPermissionChecker(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            if (RomChecker.isMiuiRom()) {
                return new MiUiChecker(activity);
            }
            if (RomChecker.isMeizuRom()) {
                return new MeizuChecker(activity);
            }
            if (RomChecker.isHuaweiRom()) {
                return new HuaweiChecker(activity);
            }
            if (RomChecker.is360Rom()) {
                return new QikuChecker(activity);
            }
        } else if (RomChecker.isMeizuRom()) {
            return new MeizuChecker(activity);
        }
        return new CommonRomChecker(activity);
    }
}
