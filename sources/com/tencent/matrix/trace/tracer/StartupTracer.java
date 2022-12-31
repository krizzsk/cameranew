package com.tencent.matrix.trace.tracer;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import androidx.work.WorkRequest;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.config.SharePluginInfo;
import com.tencent.matrix.trace.config.TraceConfig;
import com.tencent.matrix.trace.constants.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.hacker.ActivityThreadHacker;
import com.tencent.matrix.trace.items.MethodItem;
import com.tencent.matrix.trace.listeners.IAppMethodBeatListener;
import com.tencent.matrix.trace.util.TraceDataUtils;
import com.tencent.matrix.util.DeviceUtil;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class StartupTracer extends Tracer implements IAppMethodBeatListener, ActivityThreadHacker.IApplicationCreateListener, Application.ActivityLifecycleCallbacks {
    private static final String TAG = "Matrix.StartupTracer";
    private int activeActivityCount;
    private long coldStartupThresholdMs;
    private final TraceConfig config;
    private boolean hasShowSplashActivity;
    private boolean isHasActivity;
    private boolean isStartupEnable;
    private boolean isWarmStartUp;
    private Set<String> splashActivities;
    private long warmStartupThresholdMs;
    private long firstScreenCost = 0;
    private long coldCost = 0;
    private long lastCreateActivity = 0;
    private HashMap<String, Long> createdTimeMap = new HashMap<>();
    private boolean isShouldRecordCreateTime = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        long[] a;
        long b;
        long c;

        /* renamed from: d  reason: collision with root package name */
        long f8108d;

        /* renamed from: e  reason: collision with root package name */
        boolean f8109e;

        /* renamed from: f  reason: collision with root package name */
        int f8110f;

        /* renamed from: com.tencent.matrix.trace.tracer.StartupTracer$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0274a implements TraceDataUtils.IStructuredDataFilter {
            C0274a(a aVar) {
            }

            @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
            public void fallback(List<MethodItem> list, int i2) {
                MatrixLog.w(StartupTracer.TAG, "[fallback] size:%s targetSize:%s stack:%s", Integer.valueOf(i2), 30, list);
                ListIterator<MethodItem> listIterator = list.listIterator(Math.min(i2, 30));
                while (listIterator.hasNext()) {
                    listIterator.next();
                    listIterator.remove();
                }
            }

            @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
            public int getFilterMaxCount() {
                return 60;
            }

            @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
            public boolean isFilter(long j2, int i2) {
                return j2 < ((long) (i2 * 5));
            }
        }

        a(long[] jArr, long j2, long j3, long j4, boolean z, int i2) {
            this.a = jArr;
            this.f8110f = i2;
            this.b = j2;
            this.c = j3;
            this.f8108d = j4;
            this.f8109e = z;
        }

        private void a(long j2, long j3, StringBuilder sb, String str, long j4, boolean z, int i2) {
            TracePlugin tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class);
            if (tracePlugin == null) {
                return;
            }
            try {
                JSONObject deviceInfo = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo.put(SharePluginInfo.STAGE_APPLICATION_CREATE, j2);
                deviceInfo.put(SharePluginInfo.STAGE_APPLICATION_CREATE_SCENE, i2);
                deviceInfo.put(SharePluginInfo.STAGE_FIRST_ACTIVITY_CREATE, j3);
                deviceInfo.put(SharePluginInfo.STAGE_STARTUP_DURATION, j4);
                deviceInfo.put(SharePluginInfo.ISSUE_IS_WARM_START_UP, z);
                Issue issue = new Issue();
                issue.setTag(SharePluginInfo.TAG_PLUGIN_STARTUP);
                issue.setContent(deviceInfo);
                tracePlugin.onDetectIssue(issue);
            } catch (JSONException e2) {
                MatrixLog.e(StartupTracer.TAG, "[JSONException for StartUpReportTask error: %s", e2);
            }
            if ((j4 <= StartupTracer.this.coldStartupThresholdMs || z) && (j4 <= StartupTracer.this.warmStartupThresholdMs || !z)) {
                return;
            }
            try {
                JSONObject deviceInfo2 = DeviceUtil.getDeviceInfo(new JSONObject(), Matrix.with().getApplication());
                deviceInfo2.put(SharePluginInfo.ISSUE_STACK_TYPE, Constants.Type.STARTUP);
                deviceInfo2.put(SharePluginInfo.ISSUE_COST, j4);
                deviceInfo2.put(SharePluginInfo.ISSUE_TRACE_STACK, sb.toString());
                deviceInfo2.put(SharePluginInfo.ISSUE_STACK_KEY, str);
                deviceInfo2.put(SharePluginInfo.ISSUE_SUB_TYPE, z ? 2 : 1);
                Issue issue2 = new Issue();
                issue2.setTag(SharePluginInfo.TAG_PLUGIN_EVIL_METHOD);
                issue2.setContent(deviceInfo2);
                tracePlugin.onDetectIssue(issue2);
            } catch (JSONException e3) {
                MatrixLog.e(StartupTracer.TAG, "[JSONException error: %s", e3);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList linkedList = new LinkedList();
            long[] jArr = this.a;
            if (jArr.length > 0) {
                TraceDataUtils.structuredDataToStack(jArr, linkedList, false, -1L);
                TraceDataUtils.trimStack(linkedList, 30, new C0274a(this));
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            long max = Math.max(this.f8108d, TraceDataUtils.stackToString(linkedList, sb, sb2));
            String treeKey = TraceDataUtils.getTreeKey(linkedList, max);
            if ((this.f8108d > StartupTracer.this.coldStartupThresholdMs && !this.f8109e) || (this.f8108d > StartupTracer.this.warmStartupThresholdMs && this.f8109e)) {
                MatrixLog.w(StartupTracer.TAG, "stackKey:%s \n%s", treeKey, sb2.toString());
            }
            a(this.b, this.c, sb, treeKey, max, this.f8109e, this.f8110f);
        }
    }

    public StartupTracer(TraceConfig traceConfig) {
        this.config = traceConfig;
        this.isStartupEnable = traceConfig.isStartupEnable();
        this.splashActivities = traceConfig.getSplashActivities();
        this.coldStartupThresholdMs = traceConfig.getColdStartupThresholdMs();
        this.warmStartupThresholdMs = traceConfig.getWarmStartupThresholdMs();
        this.isHasActivity = traceConfig.isHasActivity();
        ActivityThreadHacker.addListener(this);
    }

    private void analyse(long j2, long j3, long j4, boolean z) {
        MatrixLog.i(TAG, "[report] applicationCost:%s firstScreenCost:%s allCost:%s isWarmStartUp:%s, createScene:%d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), Integer.valueOf(ActivityThreadHacker.sApplicationCreateScene));
        long[] jArr = new long[0];
        if (!z && j4 >= this.coldStartupThresholdMs) {
            jArr = AppMethodBeat.getInstance().copyData(ActivityThreadHacker.sApplicationCreateBeginMethodIndex);
            ActivityThreadHacker.sApplicationCreateBeginMethodIndex.release();
        } else if (z && j4 >= this.warmStartupThresholdMs) {
            jArr = AppMethodBeat.getInstance().copyData(ActivityThreadHacker.sLastLaunchActivityMethodIndex);
            ActivityThreadHacker.sLastLaunchActivityMethodIndex.release();
        }
        MatrixHandlerThread.getDefaultHandler().post(new a(jArr, j2, j3, j4, z, ActivityThreadHacker.sApplicationCreateScene));
    }

    private static void checkActivityThread_mCallback() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mH");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getSuperclass().getDeclaredField("mCallback");
            declaredField3.setAccessible(true);
            MatrixLog.i(TAG, "callback %s", (Handler.Callback) declaredField3.get(obj2));
        } catch (Exception unused) {
        }
    }

    private boolean isColdStartup() {
        return this.coldCost == 0;
    }

    private boolean isWarmStartUp() {
        return this.isWarmStartUp;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        MatrixLog.i(TAG, "activeActivityCount:%d, coldCost:%d", Integer.valueOf(this.activeActivityCount), Long.valueOf(this.coldCost));
        if (this.activeActivityCount == 0 && this.coldCost > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.lastCreateActivity = uptimeMillis;
            MatrixLog.i(TAG, "lastCreateActivity:%d, activity:%s", Long.valueOf(uptimeMillis), activity.getClass().getName());
            this.isWarmStartUp = true;
        }
        this.activeActivityCount++;
        if (this.isShouldRecordCreateTime) {
            this.createdTimeMap.put(activity.getClass().getName() + "@" + activity.hashCode(), Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        MatrixLog.i(TAG, "activeActivityCount:%d", Integer.valueOf(this.activeActivityCount));
        this.activeActivityCount--;
    }

    @Override // com.tencent.matrix.trace.listeners.IAppMethodBeatListener
    public void onActivityFocused(Activity activity) {
        if (ActivityThreadHacker.sApplicationCreateScene == Integer.MIN_VALUE) {
            Log.w(TAG, "start up from unknown scene");
            return;
        }
        String name = activity.getClass().getName();
        if (isColdStartup()) {
            boolean isCreatedByLaunchActivity = ActivityThreadHacker.isCreatedByLaunchActivity();
            Set<String> set = this.splashActivities;
            MatrixLog.i(TAG, "#ColdStartup# activity:%s, splashActivities:%s, empty:%b, isCreatedByLaunchActivity:%b, hasShowSplashActivity:%b, firstScreenCost:%d, now:%d, application_create_begin_time:%d, app_cost:%d", name, set, Boolean.valueOf(set.isEmpty()), Boolean.valueOf(isCreatedByLaunchActivity), Boolean.valueOf(this.hasShowSplashActivity), Long.valueOf(this.firstScreenCost), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(ActivityThreadHacker.getEggBrokenTime()), Long.valueOf(ActivityThreadHacker.getApplicationCost()));
            String str = name + "@" + activity.hashCode();
            Long l2 = this.createdTimeMap.get(str);
            if (l2 == null) {
                l2 = 0L;
            }
            this.createdTimeMap.put(str, Long.valueOf(SystemClock.uptimeMillis() - l2.longValue()));
            if (this.firstScreenCost == 0) {
                this.firstScreenCost = SystemClock.uptimeMillis() - ActivityThreadHacker.getEggBrokenTime();
            }
            if (this.hasShowSplashActivity) {
                this.coldCost = SystemClock.uptimeMillis() - ActivityThreadHacker.getEggBrokenTime();
            } else if (this.splashActivities.contains(name)) {
                this.hasShowSplashActivity = true;
            } else if (this.splashActivities.isEmpty()) {
                if (isCreatedByLaunchActivity) {
                    this.coldCost = this.firstScreenCost;
                } else {
                    this.firstScreenCost = 0L;
                    this.coldCost = ActivityThreadHacker.getApplicationCost();
                }
            } else if (isCreatedByLaunchActivity) {
                this.coldCost = this.firstScreenCost;
            } else {
                this.firstScreenCost = 0L;
                this.coldCost = ActivityThreadHacker.getApplicationCost();
            }
            if (this.coldCost > 0) {
                Long l3 = this.createdTimeMap.get(str);
                if (l3 != null && l3.longValue() >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                    MatrixLog.e(TAG, "%s cost too much time[%s] between activity create and onActivityFocused, just throw it.(createTime:%s) ", str, Long.valueOf(SystemClock.uptimeMillis() - l2.longValue()), l2);
                } else {
                    analyse(ActivityThreadHacker.getApplicationCost(), this.firstScreenCost, this.coldCost, false);
                }
            }
        } else if (isWarmStartUp()) {
            this.isWarmStartUp = false;
            long uptimeMillis = SystemClock.uptimeMillis() - this.lastCreateActivity;
            MatrixLog.i(TAG, "#WarmStartup# activity:%s, warmCost:%d, now:%d, lastCreateActivity:%d", name, Long.valueOf(uptimeMillis), Long.valueOf(SystemClock.uptimeMillis()), Long.valueOf(this.lastCreateActivity));
            if (uptimeMillis > 0) {
                analyse(0L, 0L, uptimeMillis, true);
            }
        }
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
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onAlive() {
        super.onAlive();
        MatrixLog.i(TAG, "[onAlive] isStartupEnable:%s", Boolean.valueOf(this.isStartupEnable));
        if (this.isStartupEnable) {
            AppMethodBeat.getInstance().addListener(this);
            Matrix.with().getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.tencent.matrix.trace.hacker.ActivityThreadHacker.IApplicationCreateListener
    public void onApplicationCreateEnd() {
        if (this.isHasActivity) {
            return;
        }
        long applicationCost = ActivityThreadHacker.getApplicationCost();
        MatrixLog.i(TAG, "onApplicationCreateEnd, applicationCost:%d", Long.valueOf(applicationCost));
        analyse(applicationCost, 0L, applicationCost, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.trace.tracer.Tracer
    public void onDead() {
        super.onDead();
        if (this.isStartupEnable) {
            AppMethodBeat.getInstance().removeListener(this);
            Matrix.with().getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // com.tencent.matrix.trace.tracer.Tracer, com.tencent.matrix.listeners.IAppForeground
    public void onForeground(boolean z) {
        super.onForeground(z);
        if (z) {
            return;
        }
        checkActivityThread_mCallback();
    }
}
