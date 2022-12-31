package com.growingio.android.sdk.autoburry.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.growingio.android.sdk.autoburry.SuperViewPager;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.ViewHelper;
/* loaded from: classes2.dex */
public final class FragmentUtil {
    private FragmentUtil() {
    }

    public static boolean isAndroidXVisible(Fragment fragment) {
        while (fragment != null) {
            if (!fragment.isVisible() || !ViewHelper.viewVisibilityInParents(fragment.getView())) {
                return false;
            }
            ViewParent parent = fragment.getView().getParent();
            if (ClassExistHelper.instanceOfAndroidXViewPager(parent) && new SuperViewPager.AndroidXViewPager((ViewPager) parent).getCurrentItemObj() != fragment) {
                return false;
            }
            fragment = fragment.getParentFragment();
        }
        return true;
    }

    @TargetApi(17)
    public static boolean isParent(@NonNull android.app.Fragment fragment, @NonNull android.app.Fragment fragment2) {
        for (android.app.Fragment parentFragment = fragment2.getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment == fragment) {
                return true;
            }
        }
        return false;
    }

    public static boolean isParentX(@NonNull Fragment fragment, @NonNull Fragment fragment2) {
        for (Fragment parentFragment = fragment2.getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment == fragment) {
                return true;
            }
        }
        return false;
    }

    @TargetApi(11)
    public static boolean isVisible(@NonNull android.app.Fragment fragment) {
        if (Build.VERSION.SDK_INT < 17) {
            return fragment.isVisible();
        }
        while (fragment != null) {
            View view = fragment.getView();
            if (!fragment.isVisible() || !ViewHelper.viewVisibilityInParents(view)) {
                return false;
            }
            fragment = fragment.getParentFragment();
        }
        return true;
    }

    public static boolean isParent(@NonNull Fragment fragment, @NonNull Fragment fragment2) {
        for (Fragment parentFragment = fragment2.getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment == fragment) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(api = 11)
    public static boolean isVisible(@NonNull Fragment fragment) {
        while (fragment != null) {
            if (!fragment.isVisible() || !ViewHelper.viewVisibilityInParents(fragment.getView())) {
                return false;
            }
            ViewParent parent = fragment.getView().getParent();
            if (ClassExistHelper.instanceOfSupportViewPager(parent) && new SuperViewPager.V4ViewPager((ViewPager) parent).getCurrentItemObj() != fragment) {
                return false;
            }
            fragment = fragment.getParentFragment();
        }
        return true;
    }
}
