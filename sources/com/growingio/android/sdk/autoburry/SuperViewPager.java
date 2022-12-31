package com.growingio.android.sdk.autoburry;

import android.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.growingio.android.sdk.utils.ClassExistHelper;
import com.growingio.android.sdk.utils.CollectionsUtil;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.ReflectUtil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class SuperViewPager<T extends ViewGroup> {
    private static final String TAG = "GIO.ViewPager";
    protected T viewPager;

    /* loaded from: classes2.dex */
    public static class AndroidXViewPager extends SuperViewPager<ViewPager> {
        private static Field s_itemObj;
        private static Field s_itemPosition;
        private static Field s_mItems;
        private static boolean s_proguardFine;

        static {
            if (ClassExistHelper.sHasAndroidXViewPager) {
                s_mItems = SuperViewPager.initItemsField(ViewPager.class, "AndroidX");
                Class initItemInfoClass = SuperViewPager.initItemInfoClass(ViewPager.class, "AndroidX");
                if (initItemInfoClass != null) {
                    s_itemPosition = ReflectUtil.findFieldObj(initItemInfoClass, "position");
                    Field findFieldObj = ReflectUtil.findFieldObj(initItemInfoClass, "object");
                    s_itemObj = findFieldObj;
                    if (s_itemPosition != null && findFieldObj != null) {
                        s_proguardFine = true;
                    } else {
                        LogUtil.e(SuperViewPager.TAG, "请参考GrowingIO官网混淆文件进行配置");
                    }
                }
            }
        }

        public AndroidXViewPager(ViewPager viewPager) {
            super(viewPager);
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        public int getCurrentItem() {
            return ((ViewPager) this.viewPager).getCurrentItem();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        protected Object getItemObject(Object obj) throws Exception {
            return s_itemObj.get(obj);
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        protected int getItemPosition(Object obj) throws Exception {
            return ((Integer) s_itemPosition.get(obj)).intValue();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        public Object getPageAdapter() {
            return ((ViewPager) this.viewPager).getAdapter();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        protected ArrayList getViewPagerMItem() {
            return (ArrayList) ReflectUtil.getFiledValue(s_mItems, this.viewPager);
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        protected boolean isProguardFine() {
            return s_proguardFine;
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        public boolean isViewFromObject(Object obj, View view, Object obj2) {
            if (obj != null) {
                return ((PagerAdapter) obj).isViewFromObject(view, obj2);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static class V4ViewPager extends SuperViewPager<ViewPager> {
        private static Field s_itemObj;
        private static Field s_itemPosition;
        private static Field s_mItems;
        private static boolean s_proguardFine;

        static {
            if (ClassExistHelper.sHasSupportViewPager) {
                s_mItems = SuperViewPager.initItemsField(ViewPager.class, "V4");
                Class initItemInfoClass = SuperViewPager.initItemInfoClass(ViewPager.class, "V4");
                if (initItemInfoClass != null) {
                    s_itemPosition = ReflectUtil.findFieldObj(initItemInfoClass, "position");
                    Field findFieldObj = ReflectUtil.findFieldObj(initItemInfoClass, "object");
                    s_itemObj = findFieldObj;
                    if (s_itemPosition != null && findFieldObj != null) {
                        s_proguardFine = true;
                    } else {
                        LogUtil.e(SuperViewPager.TAG, "请参考GrowingIO官网混淆文件进行配置");
                    }
                }
            }
        }

        public V4ViewPager(ViewPager viewPager) {
            super(viewPager);
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        public int getCurrentItem() {
            return ((ViewPager) this.viewPager).getCurrentItem();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        protected Object getItemObject(Object obj) throws Exception {
            return s_itemObj.get(obj);
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        protected int getItemPosition(Object obj) throws Exception {
            return ((Integer) s_itemPosition.get(obj)).intValue();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        public Object getPageAdapter() {
            return ((ViewPager) this.viewPager).getAdapter();
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        protected ArrayList getViewPagerMItem() {
            return (ArrayList) ReflectUtil.getFiledValue(s_mItems, this.viewPager);
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        protected boolean isProguardFine() {
            return s_proguardFine;
        }

        @Override // com.growingio.android.sdk.autoburry.SuperViewPager
        public boolean isViewFromObject(Object obj, View view, Object obj2) {
            if (obj != null) {
                return ((PagerAdapter) obj).isViewFromObject(view, obj2);
            }
            return false;
        }
    }

    protected SuperViewPager(T t) {
        this.viewPager = t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class initItemInfoClass(Class cls, String str) {
        try {
            return Class.forName(cls.getName() + "$ItemInfo");
        } catch (ClassNotFoundException unused) {
            LogUtil.e(TAG, "Not found " + str + " ViewPager$ItemInfo, 请参考GrowingIO官网的混淆文件进行配置");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field initItemsField(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField("mItems");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            LogUtil.e(TAG, "Not found " + str + " ViewPager's mItem Field, 请参考GrowingIO官网的混淆文件进行配置");
            return null;
        }
    }

    public abstract int getCurrentItem();

    public Object getCurrentItemObj() {
        if (isProguardFine()) {
            List nonEmptyList = CollectionsUtil.nonEmptyList(getViewPagerMItem());
            int currentItem = getCurrentItem();
            try {
                for (Object obj : nonEmptyList) {
                    if (getItemPosition(obj) == currentItem) {
                        return getItemObject(obj);
                    }
                }
            } catch (Throwable th) {
                LogUtil.d(TAG, th);
            }
            return null;
        }
        return null;
    }

    public View getCurrentView() {
        if (isProguardFine()) {
            Object currentItemObj = getCurrentItemObj();
            int childCount = this.viewPager.getChildCount();
            Object pageAdapter = getPageAdapter();
            if (pageAdapter != null && currentItemObj != null) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.viewPager.getChildAt(i2);
                    if (isViewFromObject(pageAdapter, childAt, currentItemObj)) {
                        return childAt;
                    }
                }
            }
            return null;
        }
        return null;
    }

    protected abstract Object getItemObject(Object obj) throws Exception;

    protected abstract int getItemPosition(Object obj) throws Exception;

    public abstract Object getPageAdapter();

    public T getViewPager() {
        return this.viewPager;
    }

    protected abstract ArrayList getViewPagerMItem();

    public boolean isFragmentViewPager() {
        if (isProguardFine()) {
            ArrayList viewPagerMItem = getViewPagerMItem();
            if (CollectionsUtil.isEmpty(viewPagerMItem)) {
                return false;
            }
            Object obj = viewPagerMItem.get(0);
            return (obj instanceof Fragment) || ClassExistHelper.instanceOfAndroidXFragment(obj) || ClassExistHelper.instanceOfSupportFragment(obj);
        }
        return false;
    }

    protected abstract boolean isProguardFine();

    public abstract boolean isViewFromObject(Object obj, View view, Object obj2);
}
