package e;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
/* compiled from: HiUtil.java */
/* loaded from: classes3.dex */
public class a {
    public static String a() {
        String b = b("ro.channel.hianalytics.test");
        if (TextUtils.isEmpty(b)) {
            b = "test_1001";
        }
        Log.d("HiAnalytic", "channelID is:" + b);
        return b;
    }

    public static String b(String str) {
        String str2;
        String c = c();
        String str3 = "";
        if (TextUtils.isEmpty(c)) {
            Log.d("HianalyUtil", "it is not EMUI system.");
            return "";
        }
        Log.d("HianalyUtil", "EMUI version:" + c);
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Exception e2) {
            e = e2;
        }
        try {
            Log.d("HianalyUtil", "key is:" + str + " channel is: " + str2);
            return str2;
        } catch (Exception e3) {
            e = e3;
            str3 = str2;
            Log.e("HianalyUtil", "read the content of build.prop exception.", e);
            return str3;
        }
    }

    public static String c() {
        try {
            Object e2 = e("android.os.SystemProperties", "get", new Class[]{String.class, String.class}, new Object[]{"ro.build.version.emui", ""});
            return e2 != null ? (String) e2 : "";
        } catch (Exception e3) {
            Log.w("HianalyUtil", e3.getMessage());
            return "";
        }
    }

    public static Object d(Class cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        if (cls != null) {
            if (clsArr == null) {
                if (objArr != null) {
                    throw new Exception("paramsType is null, but params is not null");
                }
            } else if (objArr != null) {
                if (clsArr.length != objArr.length) {
                    throw new Exception("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
                }
            } else {
                throw new Exception("paramsType or params should be same");
            }
            try {
                try {
                    return cls.getMethod(str, clsArr).invoke(null, objArr);
                } catch (IllegalAccessException e2) {
                    Log.v("HianalyUtil", e2.getMessage(), e2);
                    return null;
                } catch (IllegalArgumentException e3) {
                    Log.v("HianalyUtil", e3.getMessage(), e3);
                    return null;
                } catch (InvocationTargetException e4) {
                    Log.v("HianalyUtil", e4.getMessage(), e4);
                    return null;
                }
            } catch (NoSuchMethodException e5) {
                Log.v("HianalyUtil", e5.getMessage(), e5);
            } catch (Exception e6) {
                Log.e("HianalyUtil", e6.getMessage(), e6);
            }
        } else {
            throw new Exception("class is null in invokeStaticFun");
        }
    }

    public static Object e(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            return d(Class.forName(str), str2, clsArr, objArr);
        } catch (ClassNotFoundException e2) {
            Log.v("HianalyUtil", e2.getMessage(), e2);
            return null;
        } catch (Exception e3) {
            Log.v("HianalyUtil", e3.getMessage(), e3);
            return null;
        } catch (Throwable th) {
            Log.v("HianalyUtil", th.getMessage(), th);
            return null;
        }
    }
}
