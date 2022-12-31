package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.b;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class CrashReport {
    private static Context a;

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public static class CrashHandleCallback extends BuglyStrategy.a {
    }

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public static class UserStrategy extends BuglyStrategy {
        private CrashHandleCallback c;

        public UserStrategy(Context context) {
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized int getCallBackType() {
            return this.a;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized boolean getCloseErrorCallback() {
            return this.b;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCallBackType(int i2) {
            this.a = i2;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized void setCloseErrorCallback(boolean z) {
            this.b = z;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.c = crashHandleCallback;
        }

        @Override // com.tencent.bugly.BuglyStrategy
        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.c;
        }
    }

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public static class a implements WebViewInterface {
        private /* synthetic */ WebView a;

        a(WebView webView) {
            this.a = webView;
        }

        @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
        public final void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
            this.a.addJavascriptInterface(h5JavaScriptInterface, str);
        }

        @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
        public final CharSequence getContentDescription() {
            return this.a.getContentDescription();
        }

        @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
        public final String getUrl() {
            return this.a.getUrl();
        }

        @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
        public final void loadUrl(String str) {
            WebView webView = this.a;
            webView.loadUrl(str);
            VdsAgent.loadUrl(webView, str);
        }

        @Override // com.tencent.bugly.crashreport.CrashReport.WebViewInterface
        public final void setJavaScriptEnabled(boolean z) {
            WebSettings settings = this.a.getSettings();
            if (settings.getJavaScriptEnabled()) {
                return;
            }
            settings.setJavaScriptEnabled(true);
        }
    }

    public static void closeBugly() {
        if (!b.a) {
            Log.w(x.a, "Can not close bugly because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (a == null) {
        } else {
            BuglyBroadcastReceiver buglyBroadcastReceiver = BuglyBroadcastReceiver.getInstance();
            if (buglyBroadcastReceiver != null) {
                buglyBroadcastReceiver.unregister(a);
            }
            closeCrashReport();
            com.tencent.bugly.crashreport.biz.b.a(a);
            w a2 = w.a();
            if (a2 != null) {
                a2.b();
            }
        }
    }

    public static void closeCrashReport() {
        if (!b.a) {
            Log.w(x.a, "Can not close crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            c.a().d();
        }
    }

    public static void closeNativeReport() {
        if (!b.a) {
            Log.w(x.a, "Can not close native report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            c.a().g();
        }
    }

    public static void enableBugly(boolean z) {
        b.a = z;
    }

    public static void enableObtainId(Context context, boolean z) {
        if (!b.a) {
            Log.w(x.a, "Can not set DB name because bugly is disable.");
        } else if (context == null) {
            Log.w(x.a, "enableObtainId args context should not be null");
        } else {
            String str = x.a;
            Log.i(str, "Enable identification obtaining? " + z);
            com.tencent.bugly.crashreport.common.info.a.a(context).b(z);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!b.a) {
            Log.w(x.a, "Can not get all keys of user data because bugly is disable.");
            return new HashSet();
        } else if (context == null) {
            Log.e(x.a, "getAllUserDataKeys args context should not be null");
            return new HashSet();
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(context).w();
        }
    }

    public static String getAppChannel() {
        if (!b.a) {
            Log.w(x.a, "Can not get App channel because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(a).m;
        }
    }

    public static String getAppID() {
        if (!b.a) {
            Log.w(x.a, "Can not get App ID because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(a).f();
        }
    }

    public static String getAppVer() {
        if (!b.a) {
            Log.w(x.a, "Can not get app version because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(a).f7824k;
        }
    }

    public static String getBuglyVersion(Context context) {
        if (context == null) {
            x.d("Please call with context.", new Object[0]);
            return "unknown";
        }
        return com.tencent.bugly.crashreport.common.info.a.a(context).c();
    }

    public static Proxy getHttpProxy() {
        return com.tencent.bugly.proguard.a.b();
    }

    public static Map<String, String> getSdkExtraData() {
        if (!b.a) {
            Log.w(x.a, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return null;
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(a).C;
        }
    }

    public static String getUserData(Context context, String str) {
        if (!b.a) {
            Log.w(x.a, "Can not get user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(x.a, "getUserDataValue args context should not be null");
            return "unknown";
        } else if (z.a(str)) {
            return null;
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(context).g(str);
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!b.a) {
            Log.w(x.a, "Can not get size of user data because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(x.a, "getUserDatasSize args context should not be null");
            return -1;
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(context).v();
        }
    }

    public static String getUserId() {
        if (!b.a) {
            Log.w(x.a, "Can not get user ID because bugly is disable.");
            return "unknown";
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return "unknown";
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(a).g();
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!b.a) {
            Log.w(x.a, "Can not get user scene tag because bugly is disable.");
            return -1;
        } else if (context == null) {
            Log.e(x.a, "getUserSceneTagId args context should not be null");
            return -1;
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(context).z();
        }
    }

    public static void initCrashReport(Context context) {
        if (context == null) {
            return;
        }
        a = context;
        b.a(CrashModule.getInstance());
        b.a(context);
    }

    public static boolean isLastSessionCrash() {
        if (!b.a) {
            Log.w(x.a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
            return false;
        } else {
            return c.a().b();
        }
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread(), false);
    }

    public static void postException(Thread thread, int i2, String str, String str2, String str3, Map<String, String> map) {
        if (!b.a) {
            Log.w(x.a, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            d.a(thread, i2, str, str2, str3, map);
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (context == null || z.a(str) || z.a(str2)) {
            return;
        }
        String replace = str.replace("[a-zA-Z[0-9]]+", "");
        if (replace.length() > 100) {
            Log.w(x.a, String.format("putSdkData key length over limit %d, will be cutted.", 50));
            replace = replace.substring(0, 50);
        }
        if (str2.length() > 500) {
            Log.w(x.a, String.format("putSdkData value length over limit %d, will be cutted!", 200));
            str2 = str2.substring(0, 200);
        }
        com.tencent.bugly.crashreport.common.info.a.a(context).c(replace, str2);
        x.b(String.format("[param] putSdkData data: %s - %s", replace, str2), new Object[0]);
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!b.a) {
            Log.w(x.a, "Can not put user data because bugly is disable.");
        } else if (context == null) {
            Log.w(x.a, "putUserData args context should not be null");
        } else if (str == null) {
            String str3 = str;
            x.d("putUserData args key should not be null or empty", new Object[0]);
        } else if (str2 == null) {
            String str4 = str2;
            x.d("putUserData args value should not be null", new Object[0]);
        } else {
            if (str2.length() > 200) {
                x.d("user data value length over limit %d, it will be cutted!", 200);
                str2 = str2.substring(0, 200);
            }
            com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
            if (a2.w().contains(str)) {
                NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                if (nativeCrashHandler != null) {
                    nativeCrashHandler.putKeyValueToNative(str, str2);
                }
                com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
                x.c("replace KV %s %s", str, str2);
            } else if (a2.v() >= 50) {
                x.d("user data size is over limit %d, it will be cutted!", 50);
            } else {
                if (str.length() > 50) {
                    x.d("user data key length over limit %d , will drop this new key %s", 50, str);
                    str = str.substring(0, 50);
                }
                NativeCrashHandler nativeCrashHandler2 = NativeCrashHandler.getInstance();
                if (nativeCrashHandler2 != null) {
                    nativeCrashHandler2.putKeyValueToNative(str, str2);
                }
                com.tencent.bugly.crashreport.common.info.a.a(context).b(str, str2);
                x.b("[param] set user data: %s - %s", str, str2);
            }
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!b.a) {
            Log.w(x.a, "Can not remove user data because bugly is disable.");
            return "unknown";
        } else if (context == null) {
            Log.e(x.a, "removeUserData args context should not be null");
            return "unknown";
        } else if (z.a(str)) {
            return null;
        } else {
            x.b("[param] remove user data: %s", str);
            return com.tencent.bugly.crashreport.common.info.a.a(context).f(str);
        }
    }

    public static void setAppChannel(Context context, String str) {
        if (!b.a) {
            Log.w(x.a, "Can not set App channel because Bugly is disable.");
        } else if (context == null) {
            Log.w(x.a, "setAppChannel args context should not be null");
        } else if (str == null) {
            Log.w(x.a, "App channel is null, will not set");
        } else {
            com.tencent.bugly.crashreport.common.info.a.a(context).m = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppChannel(str);
            }
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!b.a) {
            Log.w(x.a, "Can not set App package because bugly is disable.");
        } else if (context == null) {
            Log.w(x.a, "setAppPackage args context should not be null");
        } else if (str == null) {
            Log.w(x.a, "App package is null, will not set");
        } else {
            com.tencent.bugly.crashreport.common.info.a.a(context).c = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppPackage(str);
            }
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!b.a) {
            Log.w(x.a, "Can not set App version because bugly is disable.");
        } else if (context == null) {
            Log.w(x.a, "setAppVersion args context should not be null");
        } else if (str == null) {
            Log.w(x.a, "App version is null, will not set");
        } else {
            com.tencent.bugly.crashreport.common.info.a.a(context).f7824k = str;
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeAppVersion(str);
            }
        }
    }

    public static void setBuglyDbName(String str) {
        if (!b.a) {
            Log.w(x.a, "Can not set DB name because bugly is disable.");
            return;
        }
        String str2 = x.a;
        Log.i(str2, "Set Bugly DB name: " + str);
        q.a = str;
    }

    public static void setContext(Context context) {
        a = context;
    }

    public static void setCrashFilter(String str) {
        if (!b.a) {
            Log.w(x.a, "Can not set App package because bugly is disable.");
            return;
        }
        String str2 = x.a;
        Log.i(str2, "Set crash stack filter: " + str);
        c.n = str;
    }

    public static void setCrashRegularFilter(String str) {
        if (!b.a) {
            Log.w(x.a, "Can not set App package because bugly is disable.");
            return;
        }
        String str2 = x.a;
        Log.i(str2, "Set crash stack filter: " + str);
        c.o = str;
    }

    public static void setHandleNativeCrashInJava(boolean z) {
        if (!b.a) {
            Log.w(x.a, "Can not set App package because bugly is disable.");
            return;
        }
        String str = x.a;
        Log.i(str, "Should handle native crash in Java profile after handled in native profile: " + z);
        NativeCrashHandler.setShouldHandleInJava(z);
    }

    public static void setHttpProxy(String str, int i2) {
        com.tencent.bugly.proguard.a.a(str, i2);
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!b.a) {
            Log.w(x.a, "Can not set 'isAppForeground' because bugly is disable.");
        } else if (context == null) {
            x.d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                x.c("App is in foreground.", new Object[0]);
            } else {
                x.c("App is in background.", new Object[0]);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).a(z);
        }
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!b.a) {
            Log.w(x.a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
        } else if (context == null) {
            x.d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                x.c("This is a development device.", new Object[0]);
            } else {
                x.c("This is not a development device.", new Object[0]);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).A = z;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (!b.a) {
            Log.w(x.a, "Can not put SDK extra data because bugly is disable.");
        } else if (context == null || z.a(str) || z.a(str2)) {
        } else {
            com.tencent.bugly.crashreport.common.info.a.a(context).a(str, str2);
        }
    }

    public static void setServerUrl(String str) {
        if (!z.a(str) && z.c(str)) {
            com.tencent.bugly.crashreport.common.strategy.a.a(str);
            StrategyBean.a = str;
            StrategyBean.b = str;
            return;
        }
        Log.i(x.a, "URL is invalid.");
    }

    public static void setSessionIntervalMills(long j2) {
        if (!b.a) {
            Log.w(x.a, "Can not set 'SessionIntervalMills' because bugly is disable.");
        } else {
            com.tencent.bugly.crashreport.biz.b.a(j2);
        }
    }

    public static void setUserId(String str) {
        if (!b.a) {
            Log.w(x.a, "Can not set user ID because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            setUserId(a, str);
        }
    }

    public static void setUserSceneTag(Context context, int i2) {
        if (!b.a) {
            Log.w(x.a, "Can not set tag caught because bugly is disable.");
        } else if (context == null) {
            Log.e(x.a, "setTag args context should not be null");
        } else {
            if (i2 <= 0) {
                x.d("setTag args tagId should > 0", new Object[0]);
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).a(i2);
            x.b("[param] set user scene tag: %d", Integer.valueOf(i2));
        }
    }

    public static void startCrashReport() {
        if (!b.a) {
            Log.w(x.a, "Can not start crash report because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            c.a().c();
        }
    }

    public static void testANRCrash() {
        if (!b.a) {
            Log.w(x.a, "Can not test ANR crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            x.a("start to create a anr crash for test!", new Object[0]);
            c.a().l();
        }
    }

    public static void testJavaCrash() {
        if (!b.a) {
            Log.w(x.a, "Can not test Java crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
            if (b != null) {
                b.b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        }
    }

    public static void testNativeCrash() {
        testNativeCrash(false, false, false);
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void setHttpProxy(InetAddress inetAddress, int i2) {
        com.tencent.bugly.proguard.a.a(inetAddress, i2);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebView webView, boolean z, boolean z2) {
        if (webView == null) {
            Log.w(x.a, "WebView is null.");
            return false;
        }
        return setJavascriptMonitor(new a(webView), z, z2);
    }

    public static void testNativeCrash(boolean z, boolean z2, boolean z3) {
        if (!b.a) {
            Log.w(x.a, "Can not test native crash because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else {
            x.a("start to create a native crash for test!", new Object[0]);
            c.a().a(z, z2, z3);
        }
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (!b.a) {
            Log.w(x.a, "Can not post crash caught because bugly is disable.");
        } else if (!CrashModule.getInstance().hasInitialized()) {
            Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
        } else if (th == null) {
            x.d("throwable is null, just return", new Object[0]);
        } else {
            if (thread == null) {
                thread = Thread.currentThread();
            }
            c.a().a(thread, th, false, (String) null, (byte[]) null, z);
        }
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        a = context;
        b.a(CrashModule.getInstance());
        b.a(context, userStrategy);
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    public static void postException(int i2, String str, String str2, String str3, Map<String, String> map) {
        postException(Thread.currentThread(), i2, str, str2, str3, map);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            Log.w(x.a, "WebViewInterface is null.");
            return false;
        } else if (!CrashModule.getInstance().hasInitialized()) {
            x.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        } else {
            x.a("Set Javascript exception monitor of webview.", new Object[0]);
            if (!b.a) {
                Log.w(x.a, "Can not set JavaScript monitor because bugly is disable.");
                return false;
            }
            x.c("URL of webview is %s", webViewInterface.getUrl());
            if (!z2 && Build.VERSION.SDK_INT < 19) {
                x.e("This interface is only available for Android 4.4 or later.", new Object[0]);
                return false;
            }
            x.a("Enable the javascript needed by webview monitor.", new Object[0]);
            webViewInterface.setJavaScriptEnabled(true);
            H5JavaScriptInterface h5JavaScriptInterface = H5JavaScriptInterface.getInstance(webViewInterface);
            if (h5JavaScriptInterface != null) {
                x.a("Add a secure javascript interface to the webview.", new Object[0]);
                webViewInterface.addJavascriptInterface(h5JavaScriptInterface, "exceptionUploader");
            }
            if (z) {
                x.a("Inject bugly.js(v%s) to the webview.", com.tencent.bugly.crashreport.crash.h5.b.b());
                String a2 = com.tencent.bugly.crashreport.crash.h5.b.a();
                if (a2 == null) {
                    x.e("Failed to inject Bugly.js.", com.tencent.bugly.crashreport.crash.h5.b.b());
                    return false;
                }
                webViewInterface.loadUrl("javascript:" + a2);
            }
            return true;
        }
    }

    public static void setUserId(Context context, String str) {
        if (!b.a) {
            Log.w(x.a, "Can not set user ID because bugly is disable.");
        } else if (context == null) {
            Log.e(x.a, "Context should not be null when bugly has not been initialed!");
        } else if (TextUtils.isEmpty(str)) {
            x.d("userId should not be null", new Object[0]);
        } else {
            if (str.length() > 100) {
                String substring = str.substring(0, 100);
                x.d("userId %s length is over limit %d substring to %s", str, 100, substring);
                str = substring;
            }
            if (str.equals(com.tencent.bugly.crashreport.common.info.a.a(context).g())) {
                return;
            }
            com.tencent.bugly.crashreport.common.info.a.a(context).b(str);
            x.b("[user] set userId : %s", str);
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setNativeUserId(str);
            }
            if (CrashModule.getInstance().hasInitialized()) {
                com.tencent.bugly.crashreport.biz.b.a();
            }
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!b.a) {
            Log.w(x.a, "Can not get SDK extra data because bugly is disable.");
            return new HashMap();
        } else if (context == null) {
            x.d("Context should not be null.", new Object[0]);
            return null;
        } else {
            return com.tencent.bugly.crashreport.common.info.a.a(context).C;
        }
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        if (context != null) {
            a = context;
            b.a(CrashModule.getInstance());
            b.a(context, str, z, null);
        }
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context == null) {
            return;
        }
        a = context;
        b.a(CrashModule.getInstance());
        b.a(context, str, z, userStrategy);
    }
}
