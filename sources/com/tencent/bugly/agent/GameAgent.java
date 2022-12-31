package com.tencent.bugly.agent;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.common.callercontext.ContextChain;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* loaded from: classes3.dex */
public class GameAgent {
    private static final String CLASS_COCOS_ACTIVITY = "org.cocos2dx.lib.Cocos2dxActivity";
    private static final String CLASS_UNITY_PLAYER = "com.unity3d.player.UnityPlayer";
    private static final String CRASH_REPORT_CLASS_SUFFIX = "crashreport.CrashReport";
    public static final int GAME_TYPE_COCOS = 1;
    public static final int GAME_TYPE_UNITY = 2;
    public static final int GAME_TYPE_UNKNOWN = 0;
    private static final int LOG_LEVEL_DEBUG = 1;
    private static final int LOG_LEVEL_ERROR = 4;
    private static final int LOG_LEVEL_INFO = 2;
    private static final int LOG_LEVEL_VERBOSE = 0;
    private static final int LOG_LEVEL_WARN = 3;
    private static final String LOG_TAG = "CrashReport-GameAgent";
    private static final String OLD_STRATEGY_CLASS_SUFFIX = "crashreport.CrashReport$UserStrategy";
    private static final String STRATEGY_CLASS_SUFFIX = "BuglyStrategy";
    private static final int TYPE_COCOS2DX_JS_CRASH = 5;
    private static final int TYPE_COCOS2DX_LUA_CRASH = 6;
    private static final int TYPE_U3D_CRASH = 4;
    private static final String VERSION = "3.2";
    private static boolean hasGuessed = false;
    private static WeakReference<Activity> sActivity = null;
    private static String sAppChannel = null;
    private static String sAppVersion = null;
    private static WeakReference<Context> sContext = null;
    private static int sGameType = 0;
    private static Handler sHandler = null;
    private static boolean sIsDebug = false;
    private static String sUserId = null;
    private static String sdkPackageName = "com.tencent.bugly";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        a(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(GameAgent.convertToCanonicalName("crashreport.BuglyLog"), this.a, new Object[]{this.b, this.c}, String.class, String.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f7790d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f7791e;

        b(int i2, String str, String str2, String str3, boolean z) {
            this.a = i2;
            this.b = str;
            this.c = str2;
            this.f7790d = str3;
            this.f7791e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(GameAgent.convertToCanonicalName("crashreport.inner.InnerApi"), "postCocos2dxCrashAsync", new Object[]{Integer.valueOf(this.a), this.b, this.c, this.f7790d}, Integer.TYPE, String.class, String.class, String.class);
            if (this.f7791e) {
                GameAgent.delayExit(3000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f7792d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f7793e;

        c(int i2, String str, String str2, String str3, boolean z) {
            this.a = i2;
            this.b = str;
            this.c = str2;
            this.f7792d = str3;
            this.f7793e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(GameAgent.convertToCanonicalName("crashreport.inner.InnerApi"), "postCocos2dxCrashAsync", new Object[]{Integer.valueOf(this.a), this.b, this.c, this.f7792d}, Integer.TYPE, String.class, String.class, String.class);
            if (this.f7793e) {
                GameAgent.delayExit(3000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f7794d;

        d(String str, String str2, String str3, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.f7794d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(GameAgent.convertToCanonicalName("crashreport.inner.InnerApi"), "postU3dCrashAsync", new Object[]{this.a, this.b, this.c}, String.class, String.class, String.class);
            if (this.f7794d) {
                GameAgent.delayExit(3000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GameAgent.exitApplication();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class f implements Runnable {
        final /* synthetic */ Object a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f7795d;

        f(Object obj, Context context, String str, String str2) {
            this.a = obj;
            this.b = context;
            this.c = str;
            this.f7795d = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r13 = this;
                java.lang.Class<java.lang.String> r0 = java.lang.String.class
                boolean r1 = com.tencent.bugly.agent.GameAgent.access$400()
                java.lang.Object r2 = r13.a
                java.lang.String r3 = "initCrashReport"
                java.lang.String r4 = "crashreport.CrashReport"
                r5 = 2
                r6 = 3
                r7 = 1
                r8 = 0
                if (r2 == 0) goto L55
                r2 = 0
                java.lang.String r9 = "crashreport.CrashReport$UserStrategy"
                java.lang.String r9 = com.tencent.bugly.agent.GameAgent.access$500(r9)     // Catch: java.lang.Exception -> L1e java.lang.ClassNotFoundException -> L23
                java.lang.Class r2 = java.lang.Class.forName(r9)     // Catch: java.lang.Exception -> L1e java.lang.ClassNotFoundException -> L23
                goto L27
            L1e:
                r9 = move-exception
                r9.printStackTrace()
                goto L27
            L23:
                r9 = move-exception
                r9.printStackTrace()
            L27:
                if (r2 == 0) goto L55
                java.lang.String r9 = com.tencent.bugly.agent.GameAgent.access$500(r4)
                r10 = 4
                java.lang.Object[] r11 = new java.lang.Object[r10]
                android.content.Context r12 = r13.b
                r11[r8] = r12
                java.lang.String r12 = r13.c
                r11[r7] = r12
                java.lang.Boolean r12 = java.lang.Boolean.valueOf(r1)
                r11[r5] = r12
                java.lang.Object r12 = r13.a
                r11[r6] = r12
                java.lang.Class[] r10 = new java.lang.Class[r10]
                java.lang.Class<android.content.Context> r12 = android.content.Context.class
                r10[r8] = r12
                r10[r7] = r0
                java.lang.Class r12 = java.lang.Boolean.TYPE
                r10[r5] = r12
                r10[r6] = r2
                com.tencent.bugly.agent.GameAgent.n.b(r9, r3, r11, r10)
                r2 = 1
                goto L56
            L55:
                r2 = 0
            L56:
                if (r2 != 0) goto L7b
                java.lang.String r2 = com.tencent.bugly.agent.GameAgent.access$500(r4)
                java.lang.Object[] r4 = new java.lang.Object[r6]
                android.content.Context r9 = r13.b
                r4[r8] = r9
                java.lang.String r9 = r13.c
                r4[r7] = r9
                java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                r4[r5] = r1
                java.lang.Class[] r1 = new java.lang.Class[r6]
                java.lang.Class<android.content.Context> r6 = android.content.Context.class
                r1[r8] = r6
                r1[r7] = r0
                java.lang.Class r0 = java.lang.Boolean.TYPE
                r1[r5] = r0
                com.tencent.bugly.agent.GameAgent.n.b(r2, r3, r4, r1)
            L7b:
                java.lang.String r0 = r13.f7795d
                com.tencent.bugly.agent.GameAgent.setUserId(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.agent.GameAgent.f.run():void");
        }
    }

    /* loaded from: classes3.dex */
    static class g implements Runnable {
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(GameAgent.convertToCanonicalName(GameAgent.CRASH_REPORT_CLASS_SUFFIX), "setAppVersion", new Object[]{GameAgent.getApplicationContext(), this.a}, Context.class, String.class);
        }
    }

    /* loaded from: classes3.dex */
    static class h implements Runnable {
        final /* synthetic */ String a;

        h(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(GameAgent.convertToCanonicalName(GameAgent.CRASH_REPORT_CLASS_SUFFIX), "setAppChannel", new Object[]{GameAgent.getApplicationContext(), this.a}, Context.class, String.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class i implements Runnable {
        final /* synthetic */ String a;

        i(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(GameAgent.convertToCanonicalName(GameAgent.CRASH_REPORT_CLASS_SUFFIX), "setUserId", new Object[]{GameAgent.getApplicationContext(), this.a}, Context.class, String.class);
        }
    }

    /* loaded from: classes3.dex */
    static class j implements Runnable {
        final /* synthetic */ int a;

        j(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(GameAgent.convertToCanonicalName(GameAgent.CRASH_REPORT_CLASS_SUFFIX), "setUserSceneTag", new Object[]{GameAgent.getApplicationContext(), Integer.valueOf(this.a)}, Context.class, Integer.TYPE);
        }
    }

    /* loaded from: classes3.dex */
    static class k implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        k(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(GameAgent.convertToCanonicalName(GameAgent.CRASH_REPORT_CLASS_SUFFIX), "putUserData", new Object[]{GameAgent.getApplicationContext(), this.a, this.b}, Context.class, String.class, String.class);
        }
    }

    /* loaded from: classes3.dex */
    static class l implements Runnable {
        final /* synthetic */ String a;

        l(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            n.e(GameAgent.convertToCanonicalName(GameAgent.CRASH_REPORT_CLASS_SUFFIX), "removeUserData", new Object[]{GameAgent.getApplicationContext(), this.a}, Context.class, String.class);
        }
    }

    /* loaded from: classes3.dex */
    static class m implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        m(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String convertToCanonicalName = GameAgent.convertToCanonicalName(GameAgent.CRASH_REPORT_CLASS_SUFFIX);
            n.e(convertToCanonicalName, "putSdkData", new Object[]{GameAgent.getApplicationContext(), "SDK_" + this.a, this.b}, Context.class, String.class, String.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class n {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object d(String str, String str2, Object obj) {
            try {
                Field declaredField = Class.forName(str).getDeclaredField(str2);
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return null;
            } catch (NoSuchFieldException e4) {
                e4.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object e(String str, String str2, Object[] objArr, Class<?>... clsArr) {
            try {
                Method declaredMethod = Class.forName(str).getDeclaredMethod(str2, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(null, objArr);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return null;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                return null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return null;
            } catch (Exception e6) {
                e6.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object f(String str, Object[] objArr, Class<?>... clsArr) {
            try {
                Class<?> cls = Class.forName(str);
                if (objArr == null) {
                    return cls.newInstance();
                }
                return cls.getConstructor(clsArr).newInstance(objArr);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return null;
            } catch (InstantiationException e4) {
                e4.printStackTrace();
                return null;
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
                return null;
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
                return null;
            } catch (Exception e7) {
                e7.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String convertToCanonicalName(String str) {
        StringBuilder sb = new StringBuilder();
        if (sdkPackageName == null) {
            sdkPackageName = "com.tencent.bugly";
        }
        sb.append(sdkPackageName);
        sb.append(".");
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void delayExit(long j2) {
        long max = Math.max(0L, j2);
        Handler handler = sHandler;
        if (handler != null) {
            handler.postDelayed(new e(), max);
            return;
        }
        try {
            Thread.sleep(max);
            exitApplication();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void exitApplication() {
        int myPid = Process.myPid();
        printLog(3, String.format(Locale.US, "Exit application by kill process[%d]", Integer.valueOf(myPid)));
        Process.killProcess(myPid);
    }

    private static Activity getActivity() {
        Activity cocosActivity;
        WeakReference<Activity> weakReference = sActivity;
        if (weakReference == null || weakReference.get() == null) {
            int i2 = sGameType;
            if (i2 == 1) {
                cocosActivity = getCocosActivity();
            } else if (i2 != 2) {
                Log.w(LOG_TAG, "Game type has not been set.");
                cocosActivity = guessActivity();
            } else {
                cocosActivity = getUnityActivity();
            }
            if (cocosActivity != null) {
                sActivity = new WeakReference<>(cocosActivity);
            }
        }
        WeakReference<Activity> weakReference2 = sActivity;
        if (weakReference2 != null) {
            return weakReference2.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getApplicationContext() {
        Activity activity;
        WeakReference<Context> weakReference = sContext;
        if ((weakReference == null || weakReference.get() == null) && (activity = getActivity()) != null) {
            sContext = new WeakReference<>(activity.getApplicationContext());
        }
        WeakReference<Context> weakReference2 = sContext;
        if (weakReference2 != null) {
            return weakReference2.get();
        }
        return null;
    }

    public static Activity getCocosActivity() {
        try {
            Object e2 = n.e(CLASS_COCOS_ACTIVITY, "getContext", null, new Class[0]);
            if (e2 != null && (e2 instanceof Activity)) {
                return (Activity) e2;
            }
        } catch (Exception unused) {
            Log.w(LOG_TAG, "Failed to get activity of Cocos.");
        }
        return null;
    }

    public static Activity getUnityActivity() {
        try {
            Object d2 = n.d(CLASS_UNITY_PLAYER, "currentActivity", null);
            if (d2 != null && (d2 instanceof Activity)) {
                return (Activity) d2;
            }
        } catch (Exception unused) {
            Log.w(LOG_TAG, "Failed to get activity of Unity.");
        }
        return null;
    }

    public static String getVersion() {
        return VERSION;
    }

    private static Activity guessActivity() {
        if (hasGuessed) {
            return null;
        }
        hasGuessed = true;
        Activity activity = sGameType != 0 ? getActivity() : null;
        if (activity == null) {
            sGameType = 1;
            activity = getActivity();
        }
        if (activity == null) {
            sGameType = 2;
            activity = getActivity();
        }
        if (activity == null) {
            sGameType = 0;
        }
        return activity;
    }

    public static void initCrashReport(String str, boolean z) {
        setLogEnable(z);
        initCrashReport(str, sAppChannel, sAppVersion, sUserId, 0L);
    }

    private static Object newStrategy(Context context, String str, String str2, long j2) {
        Object f2;
        if (context != null && ((!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) && (f2 = n.f(convertToCanonicalName(OLD_STRATEGY_CLASS_SUFFIX), new Object[]{context}, Context.class)) != null)) {
            try {
                Class<?> cls = Class.forName(convertToCanonicalName(STRATEGY_CLASS_SUFFIX));
                cls.getDeclaredMethod("setAppChannel", String.class).invoke(f2, str);
                cls.getDeclaredMethod("setAppVersion", String.class).invoke(f2, str2);
                cls.getDeclaredMethod("setAppReportDelay", Long.TYPE).invoke(f2, Long.valueOf(j2));
                return f2;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }

    private static void postCocosJsException(int i2, String str, String str2, String str3, boolean z) {
        runTaskInUiThread(new c(i2, str, str2, str3, z));
    }

    private static void postCocosLuaException(int i2, String str, String str2, String str3, boolean z) {
        String str4;
        try {
            if (str3.startsWith("stack traceback")) {
                str3 = str3.substring(str3.indexOf("\n") + 1, str3.length()).trim();
            }
            int indexOf = str3.indexOf("\n");
            if (indexOf > 0) {
                str3 = str3.substring(indexOf + 1, str3.length());
            }
            int indexOf2 = str3.indexOf("\n");
            String substring = indexOf2 > 0 ? str3.substring(0, indexOf2) : str3;
            int indexOf3 = substring.indexOf("]:");
            if (str == null || str.length() == 0) {
                str = indexOf3 != -1 ? substring.substring(0, indexOf3 + 1) : str2;
            }
        } catch (Throwable unused) {
            if (str == null || str.length() == 0) {
                str4 = str2;
            }
        }
        str4 = str;
        runTaskInUiThread(new b(i2, str4, str2, str3, z));
    }

    public static void postException(int i2, String str, String str2, String str3, boolean z) {
        if (i2 == 4) {
            postUnityException(str, str2, str3, z);
        } else if (i2 == 5) {
            postCocosJsException(i2, str, str2, str3, z);
        } else if (i2 != 6) {
            printLog(4, "The category of exception posted is unknown: " + String.valueOf(i2));
        } else {
            postCocosLuaException(i2, str, str2, str3, z);
        }
    }

    private static void postUnityException(String str, String str2, String str3, boolean z) {
        runTaskInUiThread(new d(str, str2, str3, z));
    }

    public static void printLog(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.startsWith("<Log>")) {
            printLog(2, str);
        } else if (str.startsWith("<LogDebug>")) {
            printLog(1, str);
        } else if (str.startsWith("<LogInfo>")) {
            printLog(2, str);
        } else if (str.startsWith("<LogWarning>")) {
            printLog(3, str);
        } else if (str.startsWith("<LogAssert>")) {
            printLog(3, str);
        } else if (str.startsWith("<LogError>")) {
            printLog(4, str);
        } else if (str.startsWith("<LogException>")) {
            printLog(4, str);
        } else {
            printLog(0, str);
        }
    }

    public static void putUserData(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        runTaskInUiThread(new k(str, str2));
    }

    public static void removeUserData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        runTaskInUiThread(new l(str));
    }

    private static void runTaskInUiThread(Runnable runnable) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(runnable);
        } else {
            new Thread(runnable).start();
        }
    }

    public static void setAppChannel(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sAppChannel = str;
        runTaskInUiThread(new h(str));
    }

    public static void setAppVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sAppVersion = str;
        runTaskInUiThread(new g(str));
    }

    public static void setGameType(int i2) {
        sGameType = i2;
    }

    public static void setLog(int i2, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : "e" : PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W : ContextChain.TAG_INFRA : "d" : "v";
        if (str3 != null) {
            runTaskInUiThread(new a(str3, str, str2));
        }
    }

    public static void setLogEnable(boolean z) {
        sIsDebug = z;
    }

    public static void setSdkConfig(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        runTaskInUiThread(new m(str, str2));
    }

    public static void setSdkPackageName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sdkPackageName = str;
    }

    public static void setUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sUserId = str;
        runTaskInUiThread(new i(str));
    }

    public static void setUserSceneTag(int i2) {
        runTaskInUiThread(new j(i2));
    }

    private static void initCrashReport(String str, String str2, String str3, String str4, long j2) {
        Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            printLog(4, "Context is null. bugly initialize terminated.");
        } else if (TextUtils.isEmpty(str)) {
            printLog(4, "Please input appid when initCrashReport.");
        } else {
            sHandler = new Handler(Looper.getMainLooper());
            runTaskInUiThread(new f(newStrategy(applicationContext, str2, str3, j2), applicationContext, str, str4));
        }
    }

    private static void printLog(int i2, String str) {
        setLog(i2, LOG_TAG, str);
    }
}
