package us.pinguo.camera360.module;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import com.mob.tools.log.MobUncaughtExceptionHandler;
import com.tencent.bugly.crashreport.BuglyLog;
import com.tencent.bugly.crashreport.CrashReport;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
import us.pinguo.camera360.App.PgCameraApplication;
import us.pinguo.camera360.module.CameraModuleInit;
import us.pinguo.cameramanger.CameraPreferencesManager;
import us.pinguo.foundation.utils.a0;
import us.pinguo.push.PushPreference;
import vStudio.Android.Camera360.Conditions;
/* loaded from: classes3.dex */
public class CameraModuleInit implements us.pinguo.librouter.c.c {
    private static boolean initedBigData = false;
    private static final byte[] lock = new byte[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends CrashReport.CrashHandleCallback {
        final /* synthetic */ boolean a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;

        a(boolean z, Context context, int i2) {
            this.a = z;
            this.b = context;
            this.c = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void a(Map map, String str, String str2) {
            BuglyLog.e(str, str2);
            map.put(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean b(int i2, ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
            return processErrorStateInfo.pid == i2;
        }

        @Override // com.tencent.bugly.BuglyStrategy.a
        public synchronized Map<String, String> onCrashHandleStart(int i2, String str, String str2, String str3) {
            final Map<String, String> a;
            a = us.pinguo.foundation.c.a();
            if (this.a) {
                String valueOf = String.valueOf(new vStudio.Android.Camera360.a().g());
                BuglyLog.e("UserType", valueOf);
                a.put("UserType", valueOf);
                BuglyLog.e("EditPictureSize", us.pinguo.util.d.b());
                a.put("EditPictureSize", us.pinguo.util.d.b());
                BuglyLog.e("MemoryTestResultInEdit", String.valueOf(us.pinguo.util.d.a()));
                a.put("MemoryTestResultInEdit", String.valueOf(us.pinguo.util.d.a()));
                StringBuilder sb = new StringBuilder();
                for (String str4 : us.pinguo.util.d.c()) {
                    sb.append(str4);
                    sb.append("—");
                }
                String sb2 = sb.toString();
                BuglyLog.e("UnityInvokeHistory", sb2);
                a.put("UnityInvokeHistory", sb2);
                a.put("sha1", us.pinguo.util.d.f12479d);
                a.put("sha256", us.pinguo.util.d.f12480e);
                ActivityManager activityManager = (ActivityManager) this.b.getSystemService("activity");
                activityManager.getProcessMemoryInfo(new int[]{this.c})[0].getMemoryStats().forEach(new BiConsumer() { // from class: us.pinguo.camera360.module.c
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        CameraModuleInit.a.a(a, (String) obj, (String) obj2);
                    }
                });
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                BuglyLog.e("amminfo.threshold", String.valueOf(memoryInfo.threshold));
                a.put("amminfo.threshold", String.valueOf(memoryInfo.threshold));
                BuglyLog.e("amminfo.availMem", String.valueOf(memoryInfo.availMem));
                a.put("amminfo.availMem", String.valueOf(memoryInfo.availMem));
                BuglyLog.e("amminfo.lowMemory", String.valueOf(memoryInfo.lowMemory));
                a.put("amminfo.lowMemory", String.valueOf(memoryInfo.lowMemory));
                BuglyLog.e("amminfo.totalMem", String.valueOf(memoryInfo.totalMem));
                a.put("amminfo.totalMem", String.valueOf(memoryInfo.totalMem));
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null && !processesInErrorState.isEmpty()) {
                    Stream<ActivityManager.ProcessErrorStateInfo> stream = processesInErrorState.stream();
                    final int i3 = this.c;
                    Optional<ActivityManager.ProcessErrorStateInfo> findFirst = stream.filter(new Predicate() { // from class: us.pinguo.camera360.module.b
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj) {
                            return CameraModuleInit.a.b(i3, (ActivityManager.ProcessErrorStateInfo) obj);
                        }
                    }).findFirst();
                    if (findFirst.isPresent()) {
                        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = findFirst.get();
                        BuglyLog.e("errState.tag", processErrorStateInfo.tag);
                        BuglyLog.e("errState.condition", String.valueOf(processErrorStateInfo.condition));
                        BuglyLog.e("errState.longMsg", processErrorStateInfo.longMsg);
                        a.put("errState.tag", processErrorStateInfo.tag);
                        a.put("errState.condition", String.valueOf(processErrorStateInfo.condition));
                        a.put("errState.longMsg", processErrorStateInfo.longMsg);
                    }
                }
            }
            return a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(String str, PushPreference pushPreference) {
        if (Conditions.d() || Conditions.e() || Conditions.c()) {
            try {
                Class<?> cls = Class.forName("com.google.firebase.iid.FirebaseInstanceId");
                Method declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0]);
                Method declaredMethod2 = cls.getDeclaredMethod("getToken", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod2.setAccessible(true);
                String str2 = (String) declaredMethod2.invoke(declaredMethod.invoke(null, new Object[0]), new Object[0]);
                if (str2 != null && !str2.equals(str)) {
                    pushPreference.h("clientId", str2);
                    pushPreference.a();
                }
                if (us.pinguo.foundation.d.f10987f) {
                    Log.e("Frisky", "push token:" + str2);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void initBigData(android.content.Context r17) {
        /*
            byte[] r1 = us.pinguo.camera360.module.CameraModuleInit.lock
            monitor-enter(r1)
            boolean r0 = us.pinguo.camera360.module.CameraModuleInit.initedBigData     // Catch: java.lang.Throwable -> L9a
            if (r0 == 0) goto L9
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L9a
            return
        L9:
            r2 = 1
            us.pinguo.camera360.module.CameraModuleInit.initedBigData = r2     // Catch: java.lang.Throwable -> L9a
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r0 = ""
            java.lang.String r1 = ""
            com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel r3 = com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel.v()
            java.lang.String r3 = r3.h()
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L2e
            java.lang.String r4 = ","
            java.lang.String[] r3 = r3.split(r4)
            int r4 = r3.length
            r6 = 2
            if (r4 != r6) goto L2e
            r0 = r3[r5]
            r1 = r3[r2]
        L2e:
            r10 = r0
            r11 = r1
            us.pinguo.foundation.j r0 = us.pinguo.foundation.j.e()
            java.lang.String r1 = "0"
            if (r0 == 0) goto L4c
            java.lang.String r3 = "pref_key_new_user_time"
            java.lang.String r4 = "0"
            java.lang.String r0 = r0.k(r3, r4)     // Catch: java.io.UnsupportedEncodingException -> L48
            java.lang.String r3 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r3)     // Catch: java.io.UnsupportedEncodingException -> L48
            r12 = r0
            goto L4d
        L48:
            r0 = move-exception
            r0.printStackTrace()
        L4c:
            r12 = r1
        L4d:
            us.pinguo.push.PushPreference r0 = new us.pinguo.push.PushPreference
            r1 = r17
            r0.<init>(r1)
            java.lang.String r3 = "clientId"
            java.lang.String r4 = "_"
            java.lang.String r3 = r0.d(r3, r4)
            java.lang.String r8 = us.pinguo.user.User.l()
            com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel r4 = com.pinguo.camera360.camera.businessPrefSetting.CameraBusinessSettingModel.v()
            boolean r4 = r4.x()
            if (r4 != 0) goto L71
            boolean r4 = com.pinguo.camera360.d.a
            if (r4 == 0) goto L6f
            goto L71
        L6f:
            r4 = 0
            goto L72
        L71:
            r4 = 1
        L72:
            if (r4 == 0) goto L77
            us.pinguo.bigdata.a.m(r5)
        L77:
            boolean r6 = us.pinguo.foundation.d.f10985d
            java.lang.String r7 = us.pinguo.foundation.utils.i.a()
            java.lang.String r13 = "0"
            java.lang.String r14 = "0"
            r16 = r4 ^ 1
            r9 = r3
            r15 = r17
            j.a.f.e.b(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            us.pinguo.bigdata.a.n()
            us.pinguo.bigdata.a.o()
            java.util.concurrent.Executor r1 = us.pinguo.foundation.utils.AsyncTask.THREAD_POOL_EXECUTOR
            us.pinguo.camera360.module.d r2 = new us.pinguo.camera360.module.d
            r2.<init>()
            r1.execute(r2)
            return
        L9a:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L9a
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera360.module.CameraModuleInit.initBigData(android.content.Context):void");
    }

    public static void initCrashHandler(boolean z, Context context) {
        MobUncaughtExceptionHandler.disable();
        Thread.setDefaultUncaughtExceptionHandler(new com.pinguo.camera360.c(context, Thread.getDefaultUncaughtExceptionHandler()));
        CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(context);
        userStrategy.setUploadProcess(z);
        userStrategy.setCrashHandleCallback((CrashReport.CrashHandleCallback) new a(z, context, z ? Process.myPid() : -1));
        CrashReport.setAppChannel(context, us.pinguo.foundation.utils.i.a());
        CrashReport.setAppVersion(context, us.pinguo.util.s.f(context));
        CrashReport.setUserId(context, j.a.f.e.a(context));
        CrashReport.initCrashReport(context, "b0899266f4", false, userStrategy);
    }

    private static void initInFirstDex(PgCameraApplication pgCameraApplication, boolean z) {
        if (z) {
            pgCameraApplication.registerActivityLifecycleCallbacks(new b(null));
            CameraPreferencesManager.a.c(pgCameraApplication);
        }
    }

    public static void initInMainProcess(Application application) {
    }

    public static void initPushSDK(Context context) {
        try {
            a0.c(Class.forName("us.pinguo.camera360.module.PushInit"), "initPushSDK", new Class[]{Context.class}, context);
        } catch (Exception unused) {
        }
    }

    @Override // us.pinguo.librouter.c.c
    public void initInOnCreate(Application application, boolean z) {
        initInFirstDex((PgCameraApplication) application, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
        private boolean a;

        private b() {
            this.a = false;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            "us.pinguo.camera2020.activity.Camera2020Activity".equals(activity.getClass().getName());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            com.pinguo.camera360.k.b.a.g(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            String simpleName = activity.getClass().getSimpleName();
            if ("CameraActivity".equals(simpleName)) {
                return;
            }
            if ((com.pinguo.camera360.k.b.a.h(activity) || !this.a) && !com.pinguo.camera360.d.a) {
                if (us.pinguo.bigdata.a.a == null) {
                    CrashReport.postCatchedException(new IllegalArgumentException("BDStatistics used before initialized, activity =" + simpleName));
                    return;
                }
                us.pinguo.bigdata.a.l();
            }
            this.a = true;
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

        /* synthetic */ b(a aVar) {
            this();
        }
    }
}
