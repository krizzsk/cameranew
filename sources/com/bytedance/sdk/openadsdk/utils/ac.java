package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.InvocationTargetException;
/* compiled from: UIUtils.java */
/* loaded from: classes.dex */
public class ac {
    private static float a = -1.0f;
    private static int b = -1;
    private static float c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private static int f2103d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static int f2104e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static WindowManager f2105f;

    static {
        a(com.bytedance.sdk.openadsdk.core.o.a());
    }

    public static void a(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, WebView webView) {
    }

    private static boolean a() {
        return a < 0.0f || b < 0 || c < 0.0f || f2103d < 0 || f2104e < 0;
    }

    private static boolean a(int i2) {
        return i2 == 0 || i2 == 8 || i2 == 4;
    }

    public static int b(Context context, float f2) {
        a(context);
        float e2 = e(context);
        if (e2 <= 0.0f) {
            e2 = 1.0f;
        }
        return (int) ((f2 / e2) + 0.5f);
    }

    public static int c(Context context) {
        a(context);
        return f2103d;
    }

    public static int d(Context context) {
        a(context);
        return f2104e;
    }

    public static float e(Context context) {
        a(context);
        return a;
    }

    public static int f(Context context) {
        a(context);
        return b;
    }

    public static void g(View view) {
        if (view == null) {
            return;
        }
        a(view, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.ac.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public static int h(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static float i(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        int identifier = context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
        if (identifier > 0) {
            return context.getApplicationContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0.0f;
    }

    public static boolean j(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean k(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean l(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static void a(Context context) {
        Context a2 = context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
        f2105f = (WindowManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("window");
        if (a2 == null) {
            return;
        }
        if (a()) {
            DisplayMetrics displayMetrics = a2.getResources().getDisplayMetrics();
            a = displayMetrics.density;
            b = displayMetrics.densityDpi;
            c = displayMetrics.scaledDensity;
            f2103d = displayMetrics.widthPixels;
            f2104e = displayMetrics.heightPixels;
        }
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i2 = f2103d;
            int i3 = f2104e;
            if (i2 > i3) {
                f2103d = i3;
                f2104e = i2;
                return;
            }
            return;
        }
        int i4 = f2103d;
        int i5 = f2104e;
        if (i4 < i5) {
            f2103d = i5;
            f2104e = i4;
        }
    }

    public static int[] b(Context context) {
        if (context == null) {
            return null;
        }
        if (f2105f == null) {
            f2105f = (WindowManager) com.bytedance.sdk.openadsdk.core.o.a().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = f2105f;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 14 && i4 < 17) {
                try {
                    i2 = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    i3 = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception unused) {
                }
            }
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    Point point = new Point();
                    Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                    i2 = point.x;
                    i3 = point.y;
                } catch (Exception unused2) {
                }
            }
            iArr[0] = i2;
            iArr[1] = i3;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    @Nullable
    public static int[] c(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static boolean d(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static boolean e(View view) {
        return view != null && view.getVisibility() == 0 && view.getAlpha() == 1.0f;
    }

    public static void f(final View view) {
        if (view == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.ac.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ac.a(view, 8);
                ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(0L).start();
            }
        });
        ofFloat.setDuration(800L);
        ofFloat.start();
    }

    public static int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Class<?> cls = Class.forName("android.view.WindowInsets");
                return cls.getMethod("getDisplayCutout", new Class[0]).invoke(cls, new Object[0]) != null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static int g(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.o.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static float a(Context context, float f2) {
        a(context);
        return (f2 * e(context)) + 0.5f;
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i2;
        rect.bottom += i3;
        rect.left -= i4;
        rect.right += i5;
        ((View) view.getParent()).setTouchDelegate(new j(rect, view));
    }

    public static int[] b(View view) {
        if (view != null) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return iArr;
        }
        return null;
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        a(view, (ViewGroup.MarginLayoutParams) layoutParams, i2, i3, i4, i5);
    }

    public static boolean b(Activity activity) {
        return a("ro.miui.notch", activity) == 1 || j(activity) || l(activity) || k(activity) || c(activity);
    }

    @Nullable
    public static int[] a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static void a(View view, int i2) {
        if (view == null || view.getVisibility() == i2 || !a(i2)) {
            return;
        }
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    private static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i2 && marginLayoutParams.topMargin == i3 && marginLayoutParams.rightMargin == i4 && marginLayoutParams.bottomMargin == i5) {
            return;
        }
        if (i2 != -3) {
            marginLayoutParams.leftMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.topMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.rightMargin = i4;
        }
        if (i5 != -3) {
            marginLayoutParams.bottomMargin = i5;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 11 && i2 < 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8);
            } else if (i2 >= 19) {
                activity.getWindow().getDecorView().setSystemUiVisibility(3842);
                activity.getWindow().addFlags(134217728);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static int a(String str, Activity activity) {
        if (u.e()) {
            try {
                Class<?> loadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), new Integer(0))).intValue();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return 0;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return 0;
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
                return 0;
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
                return 0;
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static void a(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            o.e("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void a(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            o.e("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void a(View view, float f2) {
        if (view == null) {
            return;
        }
        view.setAlpha(f2);
    }
}
