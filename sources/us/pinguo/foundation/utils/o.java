package us.pinguo.foundation.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.WindowInsets;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import us.pinguo.foundation.utils.entity.Clazz;
import us.pinguo.foundation.utils.entity.FullDisplayPhone;
import us.pinguo.foundation.utils.entity.MobileModel;
/* compiled from: FullDisplayPhoneUtils.java */
/* loaded from: classes4.dex */
public class o {
    private static Boolean a;

    public static List<MobileModel> a() {
        FullDisplayPhone fullDisplayPhone = FullDisplayPhone.getInstance();
        if (fullDisplayPhone == null || fullDisplayPhone.a() == null) {
            return null;
        }
        List<MobileModel> a2 = fullDisplayPhone.a();
        us.pinguo.common.log.a.k("NotchPhoneList:", new Object[0]);
        for (MobileModel mobileModel : a2) {
            us.pinguo.common.log.a.k("   brand:" + mobileModel.a() + ",model:" + mobileModel.f(), new Object[0]);
        }
        return a2;
    }

    public static boolean b(Context context) {
        try {
            if (Class.forName("com.huawei.android.util.HwNotchSizeUtil") != null && Build.VERSION.SDK_INT >= 17) {
                if (Settings.Secure.getInt(context.getContentResolver(), "display_notch_status", 0) == 1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean c(Context context) {
        MobileModel next;
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = true;
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 28) {
            if (context instanceof Activity) {
                WindowInsets rootWindowInsets = ((Activity) context).getWindow().getDecorView().getRootWindowInsets();
                if ((rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) == null) {
                    z = false;
                }
                z2 = z;
            }
            a = Boolean.valueOf(z2);
            return z2;
        }
        List<MobileModel> a2 = a();
        String c = h0.c();
        if (a2 != null && a2.size() > 0) {
            Iterator<MobileModel> it = a2.iterator();
            loop0: do {
                boolean z3 = false;
                while (it.hasNext()) {
                    next = it.next();
                    Clazz b = next.b();
                    if (b != null && !TextUtils.isEmpty(b.b())) {
                        try {
                            Class<?> cls = Class.forName(next.b().b());
                            if (cls != null) {
                                String c2 = b.c();
                                if (!TextUtils.isEmpty(c2)) {
                                    Object[] a3 = b.a();
                                    if (a3 != null && a3.length > 0) {
                                        Class<?>[] clsArr = new Class[a3.length];
                                        for (int i2 = 0; i2 < a3.length; i2++) {
                                            clsArr[i2] = a3[i2].getClass();
                                        }
                                        Method method = cls.getMethod(c2, clsArr);
                                        if (b.b().equals("android.os.SystemProperties")) {
                                            if (Integer.valueOf((String) method.invoke(cls.newInstance(), a3)).intValue() == 1) {
                                                z3 = true;
                                            }
                                        } else {
                                            z3 = ((Boolean) method.invoke(cls.newInstance(), a3)).booleanValue();
                                        }
                                    } else {
                                        z3 = ((Boolean) cls.getMethod(c2, new Class[0]).invoke(cls.newInstance(), new Object[0])).booleanValue();
                                    }
                                }
                                z3 = false;
                            }
                            if (z3) {
                                break loop0;
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (!TextUtils.isEmpty(next.c()) && context.getPackageManager().hasSystemFeature(next.c())) {
                        break loop0;
                    }
                    if (!TextUtils.isEmpty(next.a()) && "SAMSUNG".equals(next.a())) {
                        try {
                            Resources resources = context.getResources();
                            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", TypedValues.Custom.S_STRING, TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
                            String string = identifier > 0 ? resources.getString(identifier) : null;
                            z3 = (string == null || TextUtils.isEmpty(string)) ? false : true;
                            if (z3) {
                                break loop0;
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        if (!TextUtils.isEmpty(next.f())) {
                            break;
                        }
                    }
                    z3 = false;
                    if (!TextUtils.isEmpty(next.f())) {
                        break;
                    }
                }
                z = z3;
                break loop0;
            } while (!next.f().equals(c));
            z2 = z;
        }
        a = Boolean.valueOf(z2);
        return z2;
    }
}
