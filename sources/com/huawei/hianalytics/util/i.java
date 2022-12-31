package com.huawei.hianalytics.util;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class i {
    private Object a() {
        return a("android.telephony.MSimTelephonyManager", "getDefault", new Class[0], new Object[0]);
    }

    private Object a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method method;
        String str2;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            com.huawei.hianalytics.b.b.c("NormalMutilSim", "invokeFun(): NoSuchMethodException");
            method = null;
        }
        if (method != null) {
            try {
                return method.invoke(obj, objArr);
            } catch (IllegalAccessException unused2) {
                str2 = "invokeFun(): IllegalAccessException";
                com.huawei.hianalytics.b.b.c("NormalMutilSim", str2);
                return null;
            } catch (InvocationTargetException unused3) {
                str2 = "invokeFun(): InvocationTargetException";
                com.huawei.hianalytics.b.b.c("NormalMutilSim", str2);
                return null;
            }
        }
        return null;
    }

    private Object a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls;
        Method method;
        String str3;
        if (clsArr != null && objArr != null && clsArr.length == objArr.length) {
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException unused) {
                com.huawei.hianalytics.b.b.c("NormalMutilSim", "invokeStaticFun(): ClassNotFoundException");
                cls = null;
            }
            if (cls == null) {
                return null;
            }
            try {
                method = cls.getDeclaredMethod(str2, clsArr);
            } catch (NoSuchMethodException unused2) {
                com.huawei.hianalytics.b.b.c("NormalMutilSim", "invokeStaticFun(): NoSuchMethodException");
                method = null;
            }
            if (method != null) {
                try {
                    return method.invoke(cls, objArr);
                } catch (IllegalAccessException unused3) {
                    str3 = "invokeStaticFun(): IllegalAccessException";
                    com.huawei.hianalytics.b.b.c("NormalMutilSim", str3);
                    return null;
                } catch (InvocationTargetException unused4) {
                    str3 = "invokeStaticFun(): InvocationTargetException";
                    com.huawei.hianalytics.b.b.c("NormalMutilSim", str3);
                    return null;
                }
            }
        }
        return null;
    }

    private String a(int i2) {
        return b(i2);
    }

    private String a(TelephonyManager telephonyManager, int i2) {
        if (Build.VERSION.SDK_INT >= 23 && telephonyManager != null && (i2 == 0 || i2 == 1)) {
            return telephonyManager.getDeviceId(i2);
        }
        return null;
    }

    private String b(int i2) {
        String str;
        try {
            str = (String) a(Class.forName("android.telephony.MSimTelephonyManager"), a(), "getDeviceId", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i2)});
        } catch (ClassNotFoundException unused) {
            com.huawei.hianalytics.b.b.c("NormalMutilSim", "getImei(): ClassNotFoundException");
            str = "";
        }
        return str == null ? "" : str;
    }

    public String a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String a = a(telephonyManager, 0);
        if (TextUtils.isEmpty(a)) {
            String a2 = a(telephonyManager, 1);
            if (TextUtils.isEmpty(a2)) {
                String a3 = a(0);
                if (TextUtils.isEmpty(a3)) {
                    String a4 = a(1);
                    return !TextUtils.isEmpty(a4) ? a4 : "";
                }
                return a3;
            }
            return a2;
        }
        return a;
    }
}
