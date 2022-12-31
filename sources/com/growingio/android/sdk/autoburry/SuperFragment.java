package com.growingio.android.sdk.autoburry;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.growingio.android.sdk.autoburry.util.FragmentUtil;
import com.growingio.android.sdk.utils.ActivityUtil;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.ObjectUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class SuperFragment<T> {
    private final WeakReference<T> fragmentRef;

    /* loaded from: classes2.dex */
    public static class AndroidXFragment extends SuperFragment<Fragment> {
        protected AndroidXFragment(Fragment fragment) {
            super(fragment);
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        @Nullable
        public Activity getActivity() {
            Fragment fragment = getFragment();
            if (fragment == null) {
                return null;
            }
            return fragment.getActivity();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        public boolean isBelongActivity(@Nullable Activity activity) {
            return getActivity() == activity;
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        public boolean isVisible() {
            Fragment fragment = getFragment();
            return fragment != null && FragmentUtil.isAndroidXVisible(fragment);
        }
    }

    /* loaded from: classes2.dex */
    public static class SystemFragment extends SuperFragment<android.app.Fragment> {
        private static List<android.app.Fragment> getChildFragments(android.app.Fragment fragment) {
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 26) {
                return childFragmentManager.getFragments();
            }
            if (i2 >= 17) {
                try {
                    Field declaredField = childFragmentManager.getClass().getDeclaredField("mActive");
                    declaredField.setAccessible(true);
                    return (List) declaredField.get(childFragmentManager);
                } catch (Exception e2) {
                    Log.w("SuperFragment", "getChildFragments failed. " + e2.getMessage());
                }
            }
            return Collections.emptyList();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        @Nullable
        public Activity getActivity() {
            android.app.Fragment fragment = getFragment();
            if (fragment == null) {
                return null;
            }
            return fragment.getActivity();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        public List<SuperFragment> getChildren() {
            android.app.Fragment fragment = getFragment();
            if (fragment == null) {
                return super.getChildren();
            }
            List<android.app.Fragment> childFragments = getChildFragments(fragment);
            ArrayList arrayList = new ArrayList();
            for (android.app.Fragment fragment2 : childFragments) {
                arrayList.add(SuperFragment.createSuperFragment(fragment2));
            }
            return arrayList;
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        @Nullable
        public View getView() {
            android.app.Fragment fragment = getFragment();
            if (fragment == null) {
                return null;
            }
            return fragment.getView();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        public boolean isBelongActivity(Activity activity) {
            android.app.Fragment fragment = getFragment();
            return fragment != null && fragment.getActivity() == activity;
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        public boolean isVisible() {
            android.app.Fragment fragment = getFragment();
            return fragment != null && FragmentUtil.isVisible(fragment);
        }

        private SystemFragment(android.app.Fragment fragment) {
            super(fragment);
        }
    }

    /* loaded from: classes2.dex */
    public static class V4Fragment extends SuperFragment<Fragment> {
        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        @Nullable
        public Activity getActivity() {
            Fragment fragment = getFragment();
            if (fragment == null) {
                return null;
            }
            return fragment.getActivity();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        public List<SuperFragment> getChildren() {
            Fragment fragment = getFragment();
            if (fragment == null) {
                return super.getChildren();
            }
            List<Fragment> fragments = fragment.getChildFragmentManager().getFragments();
            ArrayList arrayList = new ArrayList();
            for (Fragment fragment2 : fragments) {
                arrayList.add(SuperFragment.createSuperFragment(fragment2));
            }
            return arrayList;
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        @Nullable
        public View getView() {
            Fragment fragment = getFragment();
            if (fragment == null) {
                return null;
            }
            return fragment.getView();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        public boolean isBelongActivity(Activity activity) {
            Fragment fragment = getFragment();
            return fragment != null && fragment.getActivity() == activity;
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        public boolean isVisible() {
            Fragment fragment = getFragment();
            return fragment != null && FragmentUtil.isVisible(fragment);
        }

        private V4Fragment(Fragment fragment) {
            super(fragment);
        }
    }

    /* loaded from: classes2.dex */
    public static class ViewFragment extends SuperFragment<View> {
        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        @Nullable
        public Activity getActivity() {
            View view = getView();
            if (view == null) {
                return null;
            }
            return ActivityUtil.findActivity(view.getContext());
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        @Nullable
        public View getView() {
            return getFragment();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        public boolean isBelongActivity(Activity activity) {
            View fragment = getFragment();
            return fragment != null && ActivityUtil.findActivity(fragment.getContext()) == activity;
        }

        @Override // com.growingio.android.sdk.autoburry.SuperFragment
        public boolean isVisible() {
            View fragment = getFragment();
            return fragment != null && fragment.isShown();
        }

        private ViewFragment(View view) {
            super(view);
        }
    }

    protected SuperFragment(T t) {
        this.fragmentRef = new WeakReference<>(t);
    }

    public static SuperFragment createSuperFragment(Object obj) {
        if (obj instanceof android.app.Fragment) {
            return new SystemFragment((android.app.Fragment) obj);
        }
        if (ClassExistHelper.instanceOfAndroidXFragment(obj)) {
            return new AndroidXFragment((Fragment) obj);
        }
        if (ClassExistHelper.instanceOfSupportFragment(obj)) {
            return new V4Fragment((Fragment) obj);
        }
        if (obj instanceof View) {
            return new ViewFragment((View) obj);
        }
        throw new IllegalArgumentException("fragment only support Fragment, V4Fragment and View");
    }

    @Nullable
    public static Activity getActivityFromFragment(Object obj) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (obj instanceof android.app.Fragment) {
                return ((android.app.Fragment) obj).getActivity();
            }
            if (ClassExistHelper.instanceOfAndroidXFragment(obj)) {
                return ((Fragment) obj).getActivity();
            }
            if (ClassExistHelper.instanceOfSupportFragment(obj)) {
                return ((Fragment) obj).getActivity();
            }
            return null;
        }
        return null;
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SuperFragment) && ObjectUtils.equals(this.fragmentRef, ((SuperFragment) obj).fragmentRef));
    }

    @Nullable
    public Activity getActivity() {
        return null;
    }

    public List<SuperFragment> getChildren() {
        return Collections.emptyList();
    }

    public T getFragment() {
        return this.fragmentRef.get();
    }

    @Nullable
    public View getView() {
        return null;
    }

    public int hashCode() {
        return ObjectUtils.hashCode(this.fragmentRef.get());
    }

    public boolean isBelongActivity(@Nullable Activity activity) {
        return false;
    }

    public abstract boolean isVisible();

    public String toString() {
        return ObjectUtils.toString(getFragment());
    }
}
