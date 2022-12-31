package us.pinguo.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.tapjoy.TapjoyConstants;
import java.util.Objects;
/* compiled from: DisplayUtils.kt */
/* loaded from: classes6.dex */
public final class h {
    public static final void a(WindowManager.LayoutParams layoutParams) {
        kotlin.jvm.internal.s.h(layoutParams, "layoutParams");
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
    }

    public static final int b(View decorView) {
        kotlin.jvm.internal.s.h(decorView, "decorView");
        if (Build.VERSION.SDK_INT >= 28) {
            WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
            DisplayCutout displayCutout = rootWindowInsets == null ? null : rootWindowInsets.getDisplayCutout();
            if (displayCutout == null) {
                return 0;
            }
            return displayCutout.getSafeInsetTop();
        }
        Context context = decorView.getContext();
        kotlin.jvm.internal.s.g(context, "context");
        if (k(context)) {
            return d(context)[1];
        }
        if (n(context)) {
            return g.a(context, 27.0f);
        }
        if (m(context)) {
            return 80;
        }
        if (l(context)) {
            Resources resources = context.getResources();
            kotlin.jvm.internal.s.g(resources, "context.resources");
            return j(resources);
        }
        return 0;
    }

    public static final int c() {
        return 5894;
    }

    public static final int[] d(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        int[] iArr = {0, 0};
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                Object invoke = loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
                if (invoke != null) {
                    return (int[]) invoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.IntArray");
            } catch (Exception e2) {
                e2.printStackTrace();
                return iArr;
            }
        } catch (Throwable unused) {
            return iArr;
        }
    }

    public static final float e(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static final int f(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    public static final int g(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static final float h(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.scaledDensity;
    }

    public static final int i(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static final int j(Resources resources) {
        kotlin.jvm.internal.s.h(resources, "resources");
        int identifier = resources.getIdentifier("status_bar_height", "dimen", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final boolean k(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                Object invoke = loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0]);
                if (invoke != null) {
                    return ((Boolean) invoke).booleanValue();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final boolean l(Context contxt) {
        kotlin.jvm.internal.s.h(contxt, "contxt");
        try {
            try {
                Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke("", "ro.miui.notch");
                if (invoke != null) {
                    return ((Integer) invoke).intValue() == 1;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final boolean m(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static final boolean n(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                Class<?> cls = Integer.TYPE;
                kotlin.jvm.internal.s.e(cls);
                Object invoke = loadClass.getMethod("isFeatureSupport", cls).invoke(loadClass, 32);
                if (invoke != null) {
                    return ((Boolean) invoke).booleanValue();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final void o(Activity act) {
        kotlin.jvm.internal.s.h(act, "act");
        act.getWindow().setFlags(1024, 1024);
        act.getWindow().getDecorView().setSystemUiVisibility(c());
    }
}
