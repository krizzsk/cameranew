package com.ironsource.environment;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: ApplicationContext.java */
/* loaded from: classes2.dex */
public class c {
    static PackageInfo a(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(f(context), 0);
    }

    public static String b(Context context) {
        try {
            return a(context).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static long c(Context context) {
        try {
            return a(context).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static String d(Context context) {
        String str;
        try {
            str = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        } catch (Throwable unused) {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static long e(Context context) {
        try {
            return a(context).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1L;
        }
    }

    public static String f(Context context) {
        return context.getPackageName();
    }

    public static JSONObject g(Context context, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                int i2 = 0;
                if (jSONArray.length() == 0) {
                    while (true) {
                        String[] strArr = packageInfo.requestedPermissions;
                        if (i2 >= strArr.length) {
                            break;
                        }
                        jSONObject.put(strArr[i2], (packageInfo.requestedPermissionsFlags[i2] & 2) != 0 ? "Granted" : "Rejected");
                        i2++;
                    }
                } else {
                    List asList = Arrays.asList(packageInfo.requestedPermissions);
                    while (i2 < jSONArray.length()) {
                        String string = jSONArray.getString(i2);
                        int indexOf = asList.indexOf(string);
                        if (indexOf != -1) {
                            jSONObject.put(string, (packageInfo.requestedPermissionsFlags[indexOf] & 2) != 0 ? "Granted" : "Rejected");
                        } else {
                            jSONObject.put(string, "notFoundInManifest");
                        }
                        i2++;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static String h(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean i(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean j(Context context, String str) {
        boolean z = false;
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo.requestedPermissions != null) {
                boolean z2 = false;
                while (true) {
                    try {
                        String[] strArr = packageInfo.requestedPermissions;
                        if (i2 >= strArr.length || z2) {
                            break;
                        }
                        z2 = str.equals(strArr[i2]);
                        i2++;
                    } catch (Exception e2) {
                        e = e2;
                        z = z2;
                        e.printStackTrace();
                        return z;
                    }
                }
                return z2;
            }
            return false;
        } catch (Exception e3) {
            e = e3;
        }
    }
}
