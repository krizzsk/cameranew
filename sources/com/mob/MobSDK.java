package com.mob;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.mob.MobUser;
import com.mob.PrivacyPolicy;
import com.mob.commons.InternationalDomain;
import com.mob.commons.MobProduct;
import com.mob.commons.MobProductCollector;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.b;
import com.mob.commons.dialog.PolicyThrowable;
import com.mob.commons.dialog.a;
import com.mob.commons.dialog.entity.InternalPolicyUi;
import com.mob.commons.dialog.entity.MobPolicyUi;
import com.mob.commons.e;
import com.mob.commons.g;
import com.mob.commons.h;
import com.mob.commons.i;
import com.mob.commons.logcollector.DefaultLogsCollector;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import java.util.HashMap;
import java.util.Locale;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes2.dex */
public class MobSDK implements PublicMemberKeeper {
    public static final int CHANNEL_APICLOUD = 5;
    public static final int CHANNEL_COCOS = 1;
    public static final int CHANNEL_FLUTTER = 4;
    public static final int CHANNEL_JS = 3;
    public static final int CHANNEL_NATIVE = 0;
    public static final int CHANNEL_QUICKSDK = 6;
    public static final int CHANNEL_UNIAPP = 7;
    public static final int CHANNEL_UNITY = 2;
    public static final int POLICY_TYPE_TXT = 2;
    public static final int POLICY_TYPE_URL = 1;
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME;
    private static Context a = null;
    private static String b = null;
    private static String c = null;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f5839d = false;

    /* renamed from: e  reason: collision with root package name */
    private static InternationalDomain f5840e = null;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f5841f = false;

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f5842g = false;

    /* renamed from: h  reason: collision with root package name */
    private static volatile boolean f5843h = false;

    static {
        int i2;
        String str = "1.0.0";
        try {
            str = "2021-12-30".replace(PGTransHeader.CONNECTOR, ".");
            i2 = Integer.parseInt("2021-12-30".replace(PGTransHeader.CONNECTOR, ""));
        } catch (Throwable unused) {
            i2 = 1;
        }
        SDK_VERSION_CODE = i2;
        SDK_VERSION_NAME = str;
    }

    public static synchronized void addUserWatcher(MobUser.UserWatcher userWatcher) {
        synchronized (MobSDK.class) {
            if (userWatcher != null) {
                MobUser.a(userWatcher);
            }
        }
    }

    private static void c() {
        int i2 = SDK_VERSION_CODE;
        ((DefaultLogsCollector) NLog.setDefaultCollector(DefaultLogsCollector.get())).addSDK("MOBSDK", i2);
        try {
            NLog nLog = NLog.getInstance("MOBSDK");
            nLog.d("===============================", new Object[0]);
            nLog.d("MobCommons name: " + SDK_VERSION_NAME + ", code: " + i2, new Object[0]);
            nLog.d("===============================", new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public static void canIContinueBusiness(final MobProduct mobProduct, final InternalPolicyUi internalPolicyUi, final OperationCallback<Boolean> operationCallback) {
        if (operationCallback != null) {
            new Thread(new Runnable() { // from class: com.mob.MobSDK.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (MobProduct.this == null) {
                            operationCallback.onFailure(new PolicyThrowable("MobProduct can not be null"));
                        }
                        a.a().a(MobProduct.this, internalPolicyUi, operationCallback);
                    } catch (Throwable th) {
                        MobLog.getInstance().e(th);
                        operationCallback.onFailure(th);
                    }
                }
            }).start();
            return;
        }
        throw new IllegalArgumentException("callback can not be null");
    }

    public static boolean checkForceHttps() {
        f5841f = true;
        return f5841f;
    }

    public static boolean checkPpNecessary() {
        e();
        return f5842g;
    }

    public static String checkRequestUrl(String str) {
        return i.a(str);
    }

    public static boolean checkV6() {
        e();
        return f5843h;
    }

    public static synchronized void clearUser() {
        synchronized (MobSDK.class) {
            MobUser.a();
        }
    }

    private static boolean d() {
        boolean z = false;
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    if ("android.app.Instrumentation".equals(className)) {
                        if ("callApplicationOnCreate".equals(stackTraceElement.getMethodName())) {
                            z = true;
                            break;
                        }
                    } else {
                        if ("android.app.ActivityThread".equals(className) && "handleBindApplication".equals(stackTraceElement.getMethodName())) {
                            z = true;
                            break;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (!z) {
            Log.e("MobSDK", "Please invoke MobSDK.init(context) method in your application onCreate()");
        }
        return z;
    }

    public static String dynamicModifyUrl(String str) {
        return i.b(str);
    }

    private static void e() {
        Bundle bundle;
        if (a == null) {
            Log.e("MobSDK", "Please invoke MobSDK.init(context) method firstly.");
        } else if (f5839d) {
        } else {
            f5839d = true;
            String str = null;
            try {
                bundle = a.getPackageManager().getPackageInfo(a.getPackageName(), 128).applicationInfo.metaData;
            } catch (Throwable unused) {
                bundle = null;
            }
            if (f5840e == null) {
                if (bundle != null) {
                    try {
                        f5840e = InternationalDomain.domainOf(bundle.getString("Domain"));
                    } catch (Throwable unused2) {
                        f5840e = InternationalDomain.DEFAULT;
                    }
                } else {
                    f5840e = InternationalDomain.DEFAULT;
                }
            }
            if (bundle != null) {
                try {
                    str = bundle.getString("Mob-Https");
                } catch (Throwable unused3) {
                }
                if (str == null) {
                    try {
                        f5841f = bundle.getBoolean("Mob-Https");
                    } catch (Throwable unused4) {
                    }
                } else {
                    f5841f = "yes".equalsIgnoreCase(str);
                }
            }
            if (bundle != null) {
                try {
                    f5842g = bundle.getBoolean("Mob-PpNecessary", true);
                } catch (Throwable unused5) {
                }
            }
            if (bundle != null) {
                try {
                    f5843h = bundle.getBoolean("Mob-V6", false);
                } catch (Throwable unused6) {
                }
            }
            h.r();
        }
    }

    public static HashMap<String, String> exchangeIds(String[] strArr) {
        return MobUser.a(strArr);
    }

    private static boolean f() {
        return b.F();
    }

    private static boolean g() {
        return b.b();
    }

    public static String getAppSecret() {
        return c;
    }

    public static String getAppkey() {
        return b;
    }

    public static Context getContext() {
        Context context;
        if (a == null) {
            try {
                Object currentActivityThread = DeviceHelper.currentActivityThread();
                if (currentActivityThread != null && (context = (Context) ReflectHelper.invokeInstanceMethod(currentActivityThread, "getApplication", new Object[0])) != null) {
                    init(context);
                }
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
        }
        return a;
    }

    public static InternationalDomain getDomain() {
        if (f5840e == null) {
            e();
        }
        InternationalDomain internationalDomain = f5840e;
        return internationalDomain == null ? InternationalDomain.DEFAULT : internationalDomain;
    }

    public static PrivacyPolicy getPrivacyPolicy(int i2) {
        return getPrivacyPolicy(i2, null);
    }

    public static void getPrivacyPolicyAsync(int i2, PrivacyPolicy.OnPolicyListener onPolicyListener) {
        getPrivacyPolicyAsync(i2, null, onPolicyListener);
    }

    public static synchronized void getUser(final MobUser.OnUserGotListener onUserGotListener) {
        synchronized (MobSDK.class) {
            MobUser.a(new MobUser.OnUserGotListener() { // from class: com.mob.MobSDK.6
                @Override // com.mob.MobUser.OnUserGotListener
                public void onUserGot(MobUser mobUser) {
                    MobUser.OnUserGotListener onUserGotListener2 = MobUser.OnUserGotListener.this;
                    if (onUserGotListener2 != null) {
                        if (mobUser.getMobUserId() == null) {
                            mobUser = null;
                        }
                        onUserGotListener2.onUserGot(mobUser);
                    }
                }
            });
        }
    }

    private static void h() {
        MobProductCollector.syncInit();
        try {
            new Thread() { // from class: com.mob.MobSDK.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        if (com.mob.commons.a.d()) {
                            MobProductCollector.collect();
                        }
                        com.mob.commons.authorize.a.a(MobSDK.a);
                        DeviceAuthorizer.authorize(null);
                        MobSDK.i();
                    } catch (Throwable th) {
                        MobLog.getInstance().w(th);
                    }
                }
            }.start();
            if (com.mob.commons.a.d()) {
                com.mob.commons.a.a();
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
        if (h.q() == 0) {
            h.c(System.currentTimeMillis());
        }
    }

    public static synchronized void init(Context context) {
        synchronized (MobSDK.class) {
            init(context, null, null);
        }
    }

    public static final int isAuth() {
        int i2;
        boolean c2 = com.mob.commons.a.c();
        NLog mobLog = MobLog.getInstance();
        mobLog.d("isAuth(). ppNece: " + c2, new Object[0]);
        if (c2) {
            Boolean k2 = com.mob.commons.a.k();
            NLog mobLog2 = MobLog.getInstance();
            mobLog2.d("isAuth(). isAgreePp: " + k2, new Object[0]);
            if (k2 == null) {
                i2 = 0;
            } else {
                i2 = k2.booleanValue() ? 1 : -1;
            }
        } else {
            i2 = 2;
        }
        NLog mobLog3 = MobLog.getInstance();
        mobLog3.d("isAuth(). isAuth: " + i2 + "[2:ppms-off，1:agr，0:unkwn，-1:disagr]", new Object[0]);
        return i2;
    }

    public static final boolean isForb() {
        Boolean isGpAvailable = isGpAvailable();
        boolean z = true;
        if (isGpAvailable != null && isGpAvailable.booleanValue()) {
            boolean c2 = com.mob.commons.a.c();
            NLog mobLog = MobLog.getInstance();
            mobLog.d("isForb(). ppNece: " + c2, new Object[0]);
            if (c2) {
                boolean d2 = com.mob.commons.a.d();
                NLog mobLog2 = MobLog.getInstance();
                mobLog2.d("isForb(). isAgrPp: " + d2, new Object[0]);
                if (d2) {
                    z = f();
                } else {
                    boolean i2 = com.mob.commons.a.i();
                    NLog mobLog3 = MobLog.getInstance();
                    mobLog3.d("isForb(). funcStch: " + i2, new Object[0]);
                    if (i2) {
                        z = f();
                    }
                }
            } else {
                z = f();
            }
            NLog mobLog4 = MobLog.getInstance();
            mobLog4.d("isForb(). isForb: " + z, new Object[0]);
            return z;
        }
        MobLog.getInstance().w("Service unavailable due to Google Play Services is unavailable!");
        return true;
    }

    public static final Boolean isGpAvailable() {
        Boolean bool;
        try {
            if (DeviceHelper.getInstance(a).isGooglePlayServicesAvailable()) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            return bool;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public static final boolean isGppVer() {
        return true;
    }

    public static final boolean isMob() {
        boolean g2;
        boolean c2 = com.mob.commons.a.c();
        NLog mobLog = MobLog.getInstance();
        mobLog.d("isMob(). ppNece: " + c2, new Object[0]);
        if (c2) {
            boolean d2 = com.mob.commons.a.d();
            NLog mobLog2 = MobLog.getInstance();
            mobLog2.d("isMob(). isAgrPp: " + d2, new Object[0]);
            if (d2) {
                g2 = g();
            } else {
                boolean j2 = com.mob.commons.a.j();
                NLog mobLog3 = MobLog.getInstance();
                mobLog3.d("isMob(). cltSch: " + j2, new Object[0]);
                g2 = j2 ? g() : false;
            }
        } else {
            g2 = g();
        }
        NLog mobLog4 = MobLog.getInstance();
        mobLog4.d("isMob(). isMob: " + g2, new Object[0]);
        return g2;
    }

    public static synchronized void removeUserWatcher(MobUser.UserWatcher userWatcher) {
        synchronized (MobSDK.class) {
            if (userWatcher != null) {
                MobUser.b(userWatcher);
            }
        }
    }

    @Deprecated
    public static void setAllowDialog(boolean z) {
    }

    public static void setChannel(MobProduct mobProduct, int i2) {
        e.a().a(mobProduct, i2);
    }

    @Deprecated
    public static void setDomain(InternationalDomain internationalDomain) {
        f5840e = internationalDomain;
    }

    @Deprecated
    public static void setPolicyUi(MobPolicyUi mobPolicyUi) {
    }

    public static synchronized void setUser(String str, String str2, String str3, HashMap<String, Object> hashMap) {
        synchronized (MobSDK.class) {
            setUser(str, str2, str3, hashMap, null);
        }
    }

    @Deprecated
    public static void submitPermissionGrantResult(boolean z, MobProduct mobProduct, final OperationCallback<Void> operationCallback) {
        if (operationCallback != null) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.MobSDK.4
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    OperationCallback.this.onComplete(null);
                    return false;
                }
            });
        }
    }

    public static void submitPolicyGrantResult(final boolean z, final OperationCallback<Void> operationCallback) {
        new Thread(new Runnable() { // from class: com.mob.MobSDK.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.mob.commons.a.a(z, operationCallback);
                } catch (Throwable th) {
                    MobLog.getInstance().e(th);
                    if (operationCallback != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.MobSDK.3.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                operationCallback.onFailure(th);
                                return false;
                            }
                        });
                    }
                }
            }
        }).start();
    }

    private static void a(String str, String str2) {
        if (str == null || str2 == null) {
            Bundle bundle = null;
            try {
                bundle = a.getPackageManager().getPackageInfo(a.getPackageName(), 128).applicationInfo.metaData;
            } catch (Throwable unused) {
            }
            if (str == null && bundle != null) {
                str = bundle.getString("Mob-AppKey");
            }
            if (str2 == null && bundle != null) {
                str2 = bundle.getString("Mob-AppSecret");
            }
            if (str2 == null && bundle != null) {
                str2 = bundle.getString("Mob-AppSeret");
            }
        }
        b = str;
        c = str2;
    }

    public static PrivacyPolicy getPrivacyPolicy(int i2, Locale locale) {
        try {
            return new g().a(i2 == 1 ? 1 : 2, locale);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public static void getPrivacyPolicyAsync(final int i2, final Locale locale, final PrivacyPolicy.OnPolicyListener onPolicyListener) {
        if (onPolicyListener != null) {
            new Thread(new Runnable() { // from class: com.mob.MobSDK.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        final PrivacyPolicy a2 = new g().a(i2 == 1 ? 1 : 2, locale);
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.MobSDK.2.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                onPolicyListener.onComplete(a2);
                                return false;
                            }
                        });
                    } catch (Throwable th) {
                        try {
                            MobLog.getInstance().d(th);
                            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.MobSDK.2.2
                                @Override // android.os.Handler.Callback
                                public boolean handleMessage(Message message) {
                                    onPolicyListener.onFailure(th);
                                    return false;
                                }
                            });
                        } catch (Throwable th2) {
                            MobLog.getInstance().d(th2);
                            onPolicyListener.onFailure(th);
                        }
                    }
                }
            }).start();
        }
    }

    public static synchronized void init(Context context, String str) {
        synchronized (MobSDK.class) {
            init(context, str, null);
        }
    }

    public static synchronized void setUser(String str, String str2, String str3, HashMap<String, Object> hashMap, String str4) {
        synchronized (MobSDK.class) {
            MobUser.a(str, str2, str3, hashMap, str4);
        }
    }

    public static synchronized void init(Context context, String str, String str2) {
        synchronized (MobSDK.class) {
            if (a == null) {
                a = context.getApplicationContext();
                a(str, str2);
                e();
                c();
                d();
                h();
            } else if (!TextUtils.isEmpty(str)) {
                boolean isEmpty = TextUtils.isEmpty(b);
                b = str;
                c = str2;
                if (isEmpty) {
                    b.Q();
                }
            }
        }
    }
}
