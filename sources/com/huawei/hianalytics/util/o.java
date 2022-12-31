package com.huawei.hianalytics.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        String str2;
        if (cls != null) {
            if (clsArr == null) {
                if (objArr != null) {
                    throw new a("paramsType is null, but params is not null");
                }
            } else if (objArr == null) {
                throw new a("paramsType or params should be same");
            } else {
                if (clsArr.length != objArr.length) {
                    throw new a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
                }
            }
            try {
            } catch (NoSuchMethodException unused) {
                com.huawei.hianalytics.b.b.c("Util", "invokeStaticFun(): NoSuchMethodException");
            }
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException unused2) {
                str2 = "invokeStaticFun(): IllegalAccessException";
                com.huawei.hianalytics.b.b.c("Util", str2);
                return null;
            } catch (IllegalArgumentException unused3) {
                str2 = "invokeStaticFun(): IllegalArgumentException";
                com.huawei.hianalytics.b.b.c("Util", str2);
                return null;
            } catch (InvocationTargetException unused4) {
                str2 = "invokeStaticFun(): InvocationTargetException";
                com.huawei.hianalytics.b.b.c("Util", str2);
                return null;
            }
        }
        throw new a("class is null in invokeStaticFun");
    }

    public static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return a(Class.forName(str), str2, clsArr, objArr);
        } catch (a unused) {
            str3 = "invokeStaticFun(): StaticFuncInvokeException";
            com.huawei.hianalytics.b.b.c("Util", str3);
            return null;
        } catch (ClassNotFoundException unused2) {
            str3 = "invokeStaticFun(): ClassNotFoundException";
            com.huawei.hianalytics.b.b.c("Util", str3);
            return null;
        }
    }

    public static String a() {
        String str;
        String str2 = "";
        try {
            String str3 = (String) Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
            try {
                com.huawei.hianalytics.b.b.b("HiAnalytics", "getUDID success");
                return str3;
            } catch (AndroidRuntimeException unused) {
                str2 = str3;
                str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                com.huawei.hianalytics.b.b.c("HiAnalytics", str);
                return str2;
            } catch (ClassNotFoundException unused2) {
                str2 = str3;
                str = "getUDID method invoke failed";
                com.huawei.hianalytics.b.b.c("HiAnalytics", str);
                return str2;
            } catch (IllegalAccessException unused3) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal AccessException";
                com.huawei.hianalytics.b.b.c("HiAnalytics", str);
                return str2;
            } catch (IllegalArgumentException unused4) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal ArgumentException";
                com.huawei.hianalytics.b.b.c("HiAnalytics", str);
                return str2;
            } catch (NoSuchMethodException unused5) {
                str2 = str3;
                str = "getUDID method invoke failed : NoSuchMethodException";
                com.huawei.hianalytics.b.b.c("HiAnalytics", str);
                return str2;
            } catch (InvocationTargetException unused6) {
                str2 = str3;
                str = "getUDID method invoke failed : InvocationTargetException";
                com.huawei.hianalytics.b.b.c("HiAnalytics", str);
                return str2;
            }
        } catch (AndroidRuntimeException unused7) {
        } catch (ClassNotFoundException unused8) {
        } catch (IllegalAccessException unused9) {
        } catch (IllegalArgumentException unused10) {
        } catch (NoSuchMethodException unused11) {
        } catch (InvocationTargetException unused12) {
        }
    }

    public static String a(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        Object a2 = a("android.os.SystemProperties", "get", new Class[]{String.class, String.class}, new Object[]{str, str2});
        return a2 != null ? (String) a2 : "";
    }

    public static String b() {
        return a("ro.build.version.emui", "");
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            com.huawei.hianalytics.b.b.c("Util", "getVersion(): NameNotFoundException");
            return "";
        }
    }

    public static String c() {
        String str = Build.SERIAL;
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase(NetworkUtil.NETWORK_UNKNOWN)) ? "" : n.a(str);
    }

    public static String c(Context context) {
        return context == null ? "" : Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
    }

    public static String d(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) != 0) {
                com.huawei.hianalytics.b.b.c("Util", "not have read phone permission!");
                return "";
            }
        } else if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            com.huawei.hianalytics.b.b.c("Util", "not have read phone permission!");
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : "";
            return TextUtils.isEmpty(deviceId) ? new i().a(context) : deviceId;
        } catch (SecurityException unused) {
            com.huawei.hianalytics.b.b.d("Util", "getDeviceID failed,SecurityException:");
            return "";
        }
    }

    public static Pair<String, String> e(Context context) {
        TelephonyManager telephonyManager;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && telephonyManager.getSimState() == 5) {
            String networkOperator = telephonyManager.getNetworkOperator();
            return (TextUtils.isEmpty(networkOperator) || TextUtils.equals(networkOperator, "null")) ? new Pair<>("", "") : networkOperator.length() > 3 ? new Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new Pair<>("", "");
        }
        return new Pair<>("", "");
    }
}
