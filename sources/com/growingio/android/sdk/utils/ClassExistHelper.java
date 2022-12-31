package com.growingio.android.sdk.utils;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class ClassExistHelper {
    private static final String TAG = "GIO.ClassExist";
    private static Class sCRVClass = null;
    private static Method sCRVGetChildAdapterPositionMethod = null;
    private static boolean sHasAdvertisingIdClient = true;
    private static boolean sHasAndroidXAlertDialog = true;
    private static boolean sHasAndroidXFragment = true;
    private static boolean sHasAndroidXFragmentActivity = true;
    public static boolean sHasAndroidXListMenuItemView = true;
    private static boolean sHasAndroidXRecyclerView = true;
    private static boolean sHasAndroidXSwipeRefreshLayoutView = true;
    public static boolean sHasAndroidXViewPager = true;
    public static boolean sHasCustomRecyclerView = false;
    private static boolean sHasMSA1010 = false;
    private static boolean sHasMSA1013 = true;
    private static boolean sHasMSA1025 = false;
    private static boolean sHasSupportAlertDialog = false;
    private static boolean sHasSupportFragment = false;
    private static boolean sHasSupportFragmentActivity = false;
    public static boolean sHasSupportListMenuItemView = false;
    private static boolean sHasSupportRecyclerView = false;
    private static boolean sHasSupportSwipeRefreshLayoutView = false;
    public static boolean sHasSupportViewPager = false;
    private static boolean sHasTransform = true;
    private static boolean sHasX5WebView = false;

    static {
        if (1 == 0) {
            sHasX5WebView = hasClass("com.tencent.smtt.sdk.WebView");
            sHasSupportRecyclerView = hasClass("androidx.recyclerview.widget.RecyclerView");
            sHasSupportViewPager = hasClass("androidx.viewpager.widget.ViewPager");
            sHasSupportSwipeRefreshLayoutView = hasClass("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
            sHasSupportFragment = hasClass("androidx.fragment.app.Fragment");
            sHasSupportFragmentActivity = hasClass("androidx.fragment.app.FragmentActivity");
            sHasSupportAlertDialog = hasClass("androidx.appcompat.app.AlertDialog");
            sHasSupportListMenuItemView = hasClass("androidx.appcompat.view.menu.ListMenuItemView");
            sHasAndroidXRecyclerView = hasClass("androidx.recyclerview.widget.RecyclerView");
            sHasAndroidXViewPager = hasClass("androidx.viewpager.widget.ViewPager");
            sHasAndroidXSwipeRefreshLayoutView = hasClass("androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
            sHasAndroidXFragment = hasClass("androidx.fragment.app.Fragment");
            sHasAndroidXFragmentActivity = hasClass("androidx.fragment.app.FragmentActivity");
            sHasAndroidXAlertDialog = hasClass("androidx.appcompat.app.AlertDialog");
            sHasAndroidXListMenuItemView = hasClass("androidx.appcompat.view.menu.ListMenuItemView");
            sHasAdvertisingIdClient = hasClass("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            sHasMSA1013 = hasClass("com.bun.supplier.IIdentifierListener");
            sHasMSA1010 = hasClass("com.bun.miitmdid.core.IIdentifierListener");
            sHasMSA1025 = hasClass("com.bun.miitmdid.interfaces.IIdentifierListener");
        }
    }

    @TargetApi(9)
    public static void checkCustomRecyclerView(Class<?> cls, String str) {
        if (sHasAndroidXRecyclerView || sHasSupportRecyclerView || sHasCustomRecyclerView || str == null || !str.contains("RecyclerView")) {
            return;
        }
        try {
            if (findRecyclerInSuper(cls) == null || sCRVGetChildAdapterPositionMethod == null) {
                return;
            }
            sCRVClass = cls;
            sHasCustomRecyclerView = true;
        } catch (Exception e2) {
            LogUtil.d(e2);
        }
    }

    public static void dumpClassInfo() {
        LogUtil.d(TAG, "For Support Class: \nsHasSupportRecyclerView=" + sHasSupportRecyclerView + ", sHasSupportFragmentActivity=" + sHasSupportFragmentActivity + "\nsHasSupportFragment=" + sHasSupportFragment + ", sHasSupportAlertDialog=" + sHasSupportAlertDialog + "\nsHasSupportSwipeRefreshLayoutView=" + sHasSupportSwipeRefreshLayoutView + ", sHasSupportViewPager=" + sHasSupportViewPager + "\nsHasSupportListMenuItemView=" + sHasSupportListMenuItemView + "\nFor AndroidX Class: \nsHasAndroidXRecyclerView=" + sHasAndroidXRecyclerView + ", sHasAndroidXFragmentActivity=" + sHasAndroidXFragmentActivity + "\nsHasAndroidXFragment=" + sHasAndroidXFragment + ", sHasAndroidXAlertDialog=" + sHasAndroidXAlertDialog + "\nsHasAndroidXSwipeRefreshLayoutView=" + sHasAndroidXSwipeRefreshLayoutView + ", sHasAndroidXViewPager=" + sHasAndroidXViewPager + "\nsHasAndroidXListMenuItemView=" + sHasAndroidXListMenuItemView + "\nAnd sHasTransform=" + sHasTransform);
    }

    private static Class<?> findRecyclerInSuper(Class<?> cls) {
        while (cls != null && !cls.equals(ViewGroup.class)) {
            try {
                sCRVGetChildAdapterPositionMethod = cls.getDeclaredMethod("getChildAdapterPosition", View.class);
            } catch (NoSuchMethodException unused) {
            }
            if (sCRVGetChildAdapterPositionMethod == null) {
                try {
                    sCRVGetChildAdapterPositionMethod = cls.getDeclaredMethod("getChildPosition", View.class);
                } catch (NoSuchMethodException unused2) {
                }
            }
            if (sCRVGetChildAdapterPositionMethod != null) {
                return cls;
            }
            cls = cls.getSuperclass();
        }
        return null;
    }

    private static boolean hasClass(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean instanceOfAndroidXAlertDialog(Object obj) {
        return sHasAndroidXAlertDialog && (obj instanceof AlertDialog);
    }

    public static boolean instanceOfAndroidXFragment(Object obj) {
        return sHasAndroidXFragment && (obj instanceof Fragment);
    }

    public static boolean instanceOfAndroidXFragmentActivity(Object obj) {
        return sHasAndroidXFragmentActivity && (obj instanceof FragmentActivity);
    }

    public static boolean instanceOfAndroidXListMenuItemView(Object obj) {
        return sHasAndroidXListMenuItemView && (obj instanceof ListMenuItemView);
    }

    public static boolean instanceOfAndroidXRecyclerView(Object obj) {
        return sHasAndroidXRecyclerView && (obj instanceof RecyclerView);
    }

    public static boolean instanceOfAndroidXViewPager(Object obj) {
        return sHasAndroidXViewPager && (obj instanceof ViewPager);
    }

    public static boolean instanceOfRecyclerView(Object obj) {
        return instanceOfAndroidXRecyclerView(obj) || instanceOfSupportRecyclerView(obj) || (sHasCustomRecyclerView && obj != null && sCRVClass.isAssignableFrom(obj.getClass()));
    }

    public static boolean instanceOfSupportAlertDialog(Object obj) {
        return sHasSupportAlertDialog && (obj instanceof AlertDialog);
    }

    public static boolean instanceOfSupportFragment(Object obj) {
        return sHasSupportFragment && (obj instanceof Fragment);
    }

    public static boolean instanceOfSupportFragmentActivity(Object obj) {
        return sHasSupportFragmentActivity && (obj instanceof FragmentActivity);
    }

    public static boolean instanceOfSupportListMenuItemView(Object obj) {
        return sHasSupportListMenuItemView && (obj instanceof ListMenuItemView);
    }

    public static boolean instanceOfSupportRecyclerView(Object obj) {
        return sHasSupportRecyclerView && (obj instanceof RecyclerView);
    }

    public static boolean instanceOfSupportSwipeRefreshLayout(Object obj) {
        return sHasSupportSwipeRefreshLayoutView && (obj instanceof SwipeRefreshLayout);
    }

    public static boolean instanceOfSupportViewPager(Object obj) {
        return sHasSupportViewPager && (obj instanceof ViewPager);
    }

    public static boolean instanceOfX5ChromeClient(Object obj) {
        return sHasX5WebView && (obj instanceof WebChromeClient);
    }

    public static boolean instanceOfX5WebView(Object obj) {
        return sHasX5WebView && (obj instanceof WebView);
    }

    public static boolean instanceofAndroidXSwipeRefreshLayout(Object obj) {
        return sHasAndroidXSwipeRefreshLayoutView && (obj instanceof SwipeRefreshLayout);
    }

    public static int invokeCRVGetChildAdapterPositionMethod(View view, View view2) {
        try {
            if (view.getClass() == sCRVClass) {
                return ((Integer) sCRVGetChildAdapterPositionMethod.invoke(view, view2)).intValue();
            }
            return -1;
        } catch (IllegalAccessException e2) {
            LogUtil.d(e2);
            return -1;
        } catch (InvocationTargetException e3) {
            LogUtil.d(e3);
            return -1;
        }
    }

    public static boolean isHasMSA1010() {
        return sHasMSA1010;
    }

    public static boolean isHasMSA1013() {
        return sHasMSA1013;
    }

    public static boolean isHasMSA1025() {
        return sHasMSA1025;
    }

    public static boolean issHasAdvertisingIdClient() {
        return sHasAdvertisingIdClient;
    }
}
