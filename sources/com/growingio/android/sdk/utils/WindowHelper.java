package com.growingio.android.sdk.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.ListMenuItemView;
import com.growingio.android.sdk.collection.CoreInitialize;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.WeakHashMap;
import us.pinguo.paylibcenter.bean.PayResult;
/* loaded from: classes2.dex */
public class WindowHelper {
    static boolean sArrayListWindowViews = false;
    private static final String sCustomWindowPrefix = "/CustomWindow";
    private static final String sDialogWindowPrefix = "/DialogWindow";
    public static final String sIgnoredWindowPrefix = "/Ignored";
    private static boolean sIsInitialized = false;
    private static Method sItemViewGetDataMethod = null;
    private static Class<?> sListMenuItemViewClazz = null;
    private static final String sMainWindowPrefix = "/MainWindow";
    static Class sPhoneWindowClazz = null;
    static Class sPopupWindowClazz = null;
    private static final String sPopupWindowPrefix = "/PopupWindow";
    static boolean sViewArrayWindowViews = false;
    static Object sWindowManger;
    static Field viewsField;
    @VisibleForTesting
    static WeakHashMap<View, Long> showingToast = new WeakHashMap<>();
    private static Comparator<View> sViewSizeComparator = new Comparator<View>() { // from class: com.growingio.android.sdk.utils.WindowHelper.1
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            int hashCode = view.hashCode();
            int hashCode2 = view2.hashCode();
            int currentRootWindowsHashCode = CoreInitialize.coreAppState().getCurrentRootWindowsHashCode();
            if (hashCode == currentRootWindowsHashCode) {
                return -1;
            }
            if (hashCode2 == currentRootWindowsHashCode) {
                return 1;
            }
            return (view2.getWidth() * view2.getHeight()) - (view.getWidth() * view.getHeight());
        }
    };

    public static View[] filterNullAndDismissToastView(View[] viewArr) {
        Long l2;
        ArrayList arrayList = new ArrayList(viewArr.length);
        long currentTimeMillis = System.currentTimeMillis();
        for (View view : viewArr) {
            if (view != null && (showingToast.isEmpty() || (l2 = showingToast.get(view)) == null || currentTimeMillis <= l2.longValue())) {
                arrayList.add(view);
            }
        }
        View[] viewArr2 = new View[arrayList.size()];
        arrayList.toArray(viewArr2);
        return viewArr2;
    }

    public static String getMainWindowPrefix() {
        return sMainWindowPrefix;
    }

    @SuppressLint({"RestrictedApi"})
    public static Object getMenuItemData(View view) throws InvocationTargetException, IllegalAccessException {
        if (view.getClass() == sListMenuItemViewClazz) {
            return sItemViewGetDataMethod.invoke(view, new Object[0]);
        }
        if (ClassExistHelper.instanceOfAndroidXListMenuItemView(view)) {
            return ((ListMenuItemView) view).getItemData();
        }
        if (ClassExistHelper.instanceOfSupportListMenuItemView(view)) {
            return ((ListMenuItemView) view).getItemData();
        }
        return null;
    }

    @TargetApi(9)
    public static View[] getSortedWindowViews() {
        View[] windowViews = getWindowViews();
        if (windowViews.length > 1) {
            View[] viewArr = (View[]) Arrays.copyOf(windowViews, windowViews.length);
            Arrays.sort(viewArr, sViewSizeComparator);
            return viewArr;
        }
        return windowViews;
    }

    public static String getSubWindowPrefix(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof WindowManager.LayoutParams)) {
            int i2 = ((WindowManager.LayoutParams) layoutParams).type;
            if (i2 == 1) {
                return sMainWindowPrefix;
            }
            if (i2 < 99 && view.getClass() == sPhoneWindowClazz) {
                return sDialogWindowPrefix;
            }
            if (i2 < 1999 && view.getClass() == sPopupWindowClazz) {
                return sPopupWindowPrefix;
            }
            if (i2 < 2999) {
                return sCustomWindowPrefix;
            }
        }
        Class<?> cls = view.getClass();
        return cls == sPhoneWindowClazz ? sDialogWindowPrefix : cls == sPopupWindowClazz ? sPopupWindowPrefix : sCustomWindowPrefix;
    }

    public static String getWindowPrefix(View view) {
        if (Util.isIgnoredView(view)) {
            return sIgnoredWindowPrefix;
        }
        if (view.hashCode() == CoreInitialize.coreAppState().getCurrentRootWindowsHashCode()) {
            return getMainWindowPrefix();
        }
        return getSubWindowPrefix(view);
    }

    public static View[] getWindowViews() {
        View[] viewArr = new View[0];
        Object obj = sWindowManger;
        if (obj == null) {
            Activity foregroundActivity = CoreInitialize.coreAppState().getForegroundActivity();
            return foregroundActivity != null ? new View[]{foregroundActivity.getWindow().getDecorView()} : viewArr;
        }
        View[] viewArr2 = null;
        try {
            if (sArrayListWindowViews) {
                viewArr2 = (View[]) ((ArrayList) viewsField.get(obj)).toArray(viewArr);
            } else if (sViewArrayWindowViews) {
                viewArr2 = (View[]) viewsField.get(obj);
            }
            if (viewArr2 != null) {
                viewArr = viewArr2;
            }
        } catch (Exception e2) {
            LogUtil.d(e2);
        }
        return filterNullAndDismissToastView(viewArr);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ab -> B:58:0x00ae). Please submit an issue!!! */
    public static void init() {
        if (sIsInitialized) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        try {
            Class<?> cls = Class.forName(i2 >= 17 ? "android.view.WindowManagerGlobal" : "android.view.WindowManagerImpl");
            String str = i2 >= 17 ? "sDefaultWindowManager" : i2 >= 13 ? "sWindowManager" : "mWindowManager";
            viewsField = cls.getDeclaredField("mViews");
            Field declaredField = cls.getDeclaredField(str);
            viewsField.setAccessible(true);
            if (viewsField.getType() == ArrayList.class) {
                sArrayListWindowViews = true;
            } else if (viewsField.getType() == View[].class) {
                sViewArrayWindowViews = true;
            }
            declaredField.setAccessible(true);
            sWindowManger = declaredField.get(null);
        } catch (ClassNotFoundException e2) {
            LogUtil.d(e2);
        } catch (IllegalAccessException e3) {
            LogUtil.d(e3);
        } catch (NoSuchFieldException e4) {
            LogUtil.d(e4);
        }
        try {
            sListMenuItemViewClazz = Class.forName("com.android.internal.view.menu.ListMenuItemView");
            sItemViewGetDataMethod = Class.forName("com.android.internal.view.menu.MenuView$ItemView").getDeclaredMethod("getItemData", new Class[0]);
        } catch (ClassNotFoundException e5) {
            LogUtil.d(e5);
        } catch (NoSuchMethodException e6) {
            LogUtil.d(e6);
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    sPhoneWindowClazz = Class.forName("com.android.internal.policy.PhoneWindow$DecorView");
                } catch (ClassNotFoundException unused) {
                    sPhoneWindowClazz = Class.forName("com.android.internal.policy.DecorView");
                }
            } else {
                sPhoneWindowClazz = Class.forName("com.android.internal.policy.impl.PhoneWindow$DecorView");
            }
        } catch (ClassNotFoundException e7) {
            LogUtil.d(e7);
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                sPopupWindowClazz = Class.forName("android.widget.PopupWindow$PopupDecorView");
            } else {
                sPopupWindowClazz = Class.forName("android.widget.PopupWindow$PopupViewContainer");
            }
        } catch (ClassNotFoundException e8) {
            LogUtil.d(e8);
        }
        sIsInitialized = true;
    }

    public static boolean isDecorView(View view) {
        if (!sIsInitialized) {
            init();
        }
        Class<?> cls = view.getClass();
        return cls == sPhoneWindowClazz || cls == sPopupWindowClazz;
    }

    public static void onToastShow(@NonNull Toast toast) {
        try {
            View view = toast.getView();
            int duration = toast.getDuration();
            if (view == null) {
                return;
            }
            showingToast.put(view, Long.valueOf(Math.max((int) PayResult.PAY_RESULT_ALIPAY_CHECK_IN, duration) + System.currentTimeMillis()));
        } catch (Exception e2) {
            LogUtil.d("GIO.Window", "onToastShow, failed: ", e2);
        }
    }
}
