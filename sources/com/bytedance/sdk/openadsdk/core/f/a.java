package com.bytedance.sdk.openadsdk.core.f;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.utils.o;
/* compiled from: MIUIPermissionUtils.java */
/* loaded from: classes.dex */
public class a {
    private static final String a = "a";

    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 19) {
            return b(context, str);
        }
        return c(context, str);
    }

    @RequiresApi(api = 19)
    private static boolean b(Context context, String str) {
        String str2 = a;
        o.e(str2, "checkPermissinKITKATNew，permission：" + str);
        boolean z = true;
        try {
            str.hashCode();
            String lowerCase = str.replaceFirst("android.permission.", "android:").toLowerCase();
            int checkOp = ((AppOpsManager) context.getSystemService("appops")).checkOp(lowerCase, Binder.getCallingUid(), context.getPackageName());
            o.e(str2, "checkPermissinKITKATNew，locationOp,permission：" + checkOp + "," + lowerCase);
            if (checkOp != 0) {
                z = false;
                o.e(str2, "checkPermissinKITKATNew，false,permission：" + lowerCase);
                return false;
            }
            return true;
        } catch (Exception e2) {
            String str3 = a;
            o.e(str3, "权限检查出错时默认返回有权限，异常代码：" + e2);
            return z;
        }
    }

    private static boolean c(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
