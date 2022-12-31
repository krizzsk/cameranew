package com.tencent.matrix.trace.util;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tapjoy.TJAdUnitConstants;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* loaded from: classes3.dex */
public enum AppForegroundUtil {
    INSTANCE;
    
    private static final String TAG = "Matrix.AppActiveDelegate";
    private String currentFragmentName;
    private Handler handler;
    private boolean isAppForeground = false;
    private String visibleScene = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    private b controller = new b();
    private boolean isInit = false;

    /* loaded from: classes3.dex */
    private final class b implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
        private b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            AppForegroundUtil.this.updateScene(activity);
            AppForegroundUtil appForegroundUtil = AppForegroundUtil.this;
            appForegroundUtil.onDispatchForeground(appForegroundUtil.getVisibleScene());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (AppForegroundUtil.getTopActivityName() == null) {
                AppForegroundUtil appForegroundUtil = AppForegroundUtil.this;
                appForegroundUtil.onDispatchBackground(appForegroundUtil.getVisibleScene());
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i2) {
            if (i2 == 20 && AppForegroundUtil.this.isAppForeground) {
                AppForegroundUtil appForegroundUtil = AppForegroundUtil.this;
                appForegroundUtil.onDispatchBackground(appForegroundUtil.visibleScene);
            }
        }
    }

    AppForegroundUtil() {
    }

    public static String getTopActivityName() {
        Map map;
        System.currentTimeMillis();
        try {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                if (Build.VERSION.SDK_INT < 19) {
                    map = (HashMap) declaredField.get(invoke);
                } else {
                    map = (ArrayMap) declaredField.get(invoke);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (map.size() < 1) {
                return null;
            }
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField(TJAdUnitConstants.String.VIDEO_PAUSED);
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    return ((Activity) declaredField3.get(obj)).getClass().getName();
                }
            }
            return null;
        } finally {
            System.currentTimeMillis();
        }
    }

    private static boolean isActivityInterestingToUser() {
        Map map;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            if (Build.VERSION.SDK_INT < 19) {
                map = (HashMap) declaredField.get(invoke);
            } else {
                map = (ArrayMap) declaredField.get(invoke);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (map.size() < 1) {
            return false;
        }
        for (Object obj : map.values()) {
            Field declaredField2 = obj.getClass().getDeclaredField(TJAdUnitConstants.String.VIDEO_PAUSED);
            declaredField2.setAccessible(true);
            if (!declaredField2.getBoolean(obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInterestingToUser() {
        return isActivityInterestingToUser();
    }

    private static boolean isServiceInterestingToUser() {
        Map map;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mServices");
            declaredField.setAccessible(true);
            if (Build.VERSION.SDK_INT < 19) {
                map = (HashMap) declaredField.get(invoke);
            } else {
                map = (ArrayMap) declaredField.get(invoke);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (map.size() < 1) {
            return false;
        }
        for (Object obj : map.values()) {
            obj.getClass();
            Service service = (Service) obj;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDispatchBackground(String str) {
        this.isAppForeground = false;
        if (0 == 0 || !this.isInit) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDispatchForeground(String str) {
        this.isAppForeground = true;
        if (1 != 0 || !this.isInit) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScene(Activity activity) {
        this.visibleScene = activity.getClass().getName();
    }

    public String getCurrentFragmentName() {
        return this.currentFragmentName;
    }

    public String getVisibleScene() {
        return this.visibleScene;
    }

    public void init() {
        if (this.isInit) {
            return;
        }
        this.isInit = true;
    }

    public boolean isAppForeground() {
        return this.isAppForeground;
    }

    public void setCurrentFragmentName(String str) {
        this.currentFragmentName = str;
        updateScene(str);
    }

    private void updateScene(String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = "?";
        }
        sb.append(str);
        this.visibleScene = sb.toString();
    }
}
