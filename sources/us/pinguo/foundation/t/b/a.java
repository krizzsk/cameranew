package us.pinguo.foundation.t.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.Method;
import us.pinguo.foundation.e;
import us.pinguo.foundation.j;
import us.pinguo.util.v;
/* compiled from: DisplayUtil.java */
/* loaded from: classes4.dex */
public class a {
    private static volatile int a = -1;
    private static volatile int b = -1;

    public static int a(Context context, float f2) {
        return (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
    }

    public static int b(Resources resources, float f2) {
        return (int) ((resources.getDisplayMetrics().density * f2) + 0.5f);
    }

    public static float c(Context context, float f2) {
        return (context.getResources().getDisplayMetrics().density * f2) + 0.5f;
    }

    public static int d(Activity activity) {
        return activity.findViewById(16908290).getHeight();
    }

    public static int e() {
        if (b != -1) {
            return b;
        }
        Resources resources = v.a().getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : -1;
        b = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static Point f() {
        int width;
        int height;
        int intValue;
        int i2;
        Display defaultDisplay = ((WindowManager) v.a().getSystemService("window")).getDefaultDisplay();
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 17) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            intValue = displayMetrics.heightPixels;
        } else {
            if (i3 >= 14) {
                try {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    int intValue2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    intValue = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                    i2 = intValue2;
                } catch (Exception unused) {
                    width = defaultDisplay.getWidth();
                    height = defaultDisplay.getHeight();
                }
            } else {
                width = defaultDisplay.getWidth();
                height = defaultDisplay.getHeight();
            }
            int i4 = width;
            intValue = height;
            i2 = i4;
        }
        return new Point(i2, intValue);
    }

    public static float g(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int h(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int i() {
        return f().y - e();
    }

    public static int j(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int k() {
        if (a != -1) {
            return a;
        }
        Resources resources = v.a().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : -1;
        a = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static boolean l() {
        WindowManager windowManager = (WindowManager) e.b().getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return (displayMetrics.heightPixels + displayMetrics.widthPixels) + j.e().i("hairCut", 0) != point.y + point.x;
    }

    public static boolean m(Context context) {
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public static int n(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int o(Context context, int i2) {
        return (int) ((context.getResources().getDisplayMetrics().density * i2) + 0.5f);
    }

    public static int p(Resources resources, float f2) {
        return (int) ((resources.getDisplayMetrics().density * f2) + 0.5f);
    }

    public static float q(Context context, float f2) {
        return (context.getResources().getDisplayMetrics().density * f2) + 0.5f;
    }
}
