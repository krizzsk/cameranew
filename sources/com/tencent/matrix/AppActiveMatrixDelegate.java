package com.tencent.matrix;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.matrix.listeners.IAppForeground;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
/* loaded from: classes3.dex */
public enum AppActiveMatrixDelegate {
    INSTANCE;
    
    private static final String TAG = "Matrix.AppActiveDelegate";
    private String currentFragmentName;
    private Handler handler;
    private final Set<IAppForeground> listeners = new HashSet();
    private boolean isAppForeground = false;
    private String visibleScene = IADStatisticBase.VARCHAR_DEFALUT_VALUE;
    private c controller = new c(this, null);
    private boolean isInit = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppActiveMatrixDelegate.this.isAppForeground = true;
            synchronized (AppActiveMatrixDelegate.this.listeners) {
                for (IAppForeground iAppForeground : AppActiveMatrixDelegate.this.listeners) {
                    iAppForeground.onForeground(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppActiveMatrixDelegate.this.isAppForeground = false;
            synchronized (AppActiveMatrixDelegate.this.listeners) {
                for (IAppForeground iAppForeground : AppActiveMatrixDelegate.this.listeners) {
                    iAppForeground.onForeground(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
        private c() {
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
            AppActiveMatrixDelegate.this.updateScene(activity);
            AppActiveMatrixDelegate appActiveMatrixDelegate = AppActiveMatrixDelegate.this;
            appActiveMatrixDelegate.onDispatchForeground(appActiveMatrixDelegate.getVisibleScene());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (AppActiveMatrixDelegate.getTopActivityName() == null) {
                AppActiveMatrixDelegate appActiveMatrixDelegate = AppActiveMatrixDelegate.this;
                appActiveMatrixDelegate.onDispatchBackground(appActiveMatrixDelegate.getVisibleScene());
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
            MatrixLog.i(AppActiveMatrixDelegate.TAG, "[onTrimMemory] level:%s", Integer.valueOf(i2));
            if (i2 == 20 && AppActiveMatrixDelegate.this.isAppForeground) {
                AppActiveMatrixDelegate appActiveMatrixDelegate = AppActiveMatrixDelegate.this;
                appActiveMatrixDelegate.onDispatchBackground(appActiveMatrixDelegate.visibleScene);
            }
        }

        /* synthetic */ c(AppActiveMatrixDelegate appActiveMatrixDelegate, a aVar) {
            this();
        }
    }

    AppActiveMatrixDelegate() {
    }

    public static String getTopActivityName() {
        Map map;
        long currentTimeMillis = System.currentTimeMillis();
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
                MatrixLog.d(TAG, "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            if (map.size() < 1) {
                MatrixLog.d(TAG, "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return null;
            }
            for (Object obj : map.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField(TJAdUnitConstants.String.VIDEO_PAUSED);
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    String name = ((Activity) declaredField3.get(obj)).getClass().getName();
                    MatrixLog.d(TAG, "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return name;
                }
            }
            MatrixLog.d(TAG, "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return null;
        } catch (Throwable th) {
            MatrixLog.d(TAG, "[getTopActivityName] Cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDispatchBackground(String str) {
        if (this.isAppForeground && this.isInit) {
            MatrixLog.i(TAG, "onBackground... visibleScene[%s]", str);
            this.handler.post(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDispatchForeground(String str) {
        if (this.isAppForeground || !this.isInit) {
            return;
        }
        MatrixLog.i(TAG, "onForeground... visibleScene[%s]", str);
        this.handler.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateScene(Activity activity) {
        this.visibleScene = activity.getClass().getName();
    }

    public void addListener(IAppForeground iAppForeground) {
        synchronized (this.listeners) {
            this.listeners.add(iAppForeground);
        }
    }

    public String getCurrentFragmentName() {
        return this.currentFragmentName;
    }

    public String getVisibleScene() {
        return this.visibleScene;
    }

    public void init(Application application) {
        if (this.isInit) {
            MatrixLog.e(TAG, "has inited!", new Object[0]);
            return;
        }
        this.isInit = true;
        if (MatrixHandlerThread.getDefaultHandlerThread() != null) {
            this.handler = new Handler(MatrixHandlerThread.getDefaultHandlerThread().getLooper());
        }
        application.registerComponentCallbacks(this.controller);
        application.registerActivityLifecycleCallbacks(this.controller);
    }

    public boolean isAppForeground() {
        return this.isAppForeground;
    }

    public void removeListener(IAppForeground iAppForeground) {
        synchronized (this.listeners) {
            this.listeners.remove(iAppForeground);
        }
    }

    public void setCurrentFragmentName(String str) {
        MatrixLog.i(TAG, "[setCurrentFragmentName] fragmentName:%s", str);
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
