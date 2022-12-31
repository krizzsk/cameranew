package com.growingio.android.sdk.collection;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.growingio.android.sdk.base.event.BgInitializeSDKEvent;
import com.growingio.android.sdk.base.event.InitializeSDKEvent;
import com.growingio.android.sdk.base.event.RefreshPageEvent;
import com.growingio.android.sdk.collection.GrowingIO;
import com.growingio.android.sdk.deeplink.DeepLinkEvent;
import com.growingio.android.sdk.deeplink.DeeplinkCallback;
import com.growingio.android.sdk.deeplink.DeeplinkManager;
import com.growingio.android.sdk.message.MessageHandler;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.utils.ArgumentChecker;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.PermissionUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.EventBus;
import com.growingio.eventcenter.bus.EventCenterException;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AbstractGrowingIO<T> {
    public static final int GROWING_ALREADY_SET_INTERFACE = 84159256;
    public static final int GROWING_BANNER_KEY = 84159247;
    public static final int GROWING_CONTENT_KEY = 84159244;
    public static final int GROWING_HEAT_MAP_KEY = 84159249;
    public static final int GROWING_HOOK_LISTENTER = 84159250;
    public static final int GROWING_IGNORE_VIEW_IMP_KEY = 84159253;
    public static final int GROWING_IGNORE_VIEW_KEY = 84159248;
    public static final int GROWING_IMP_TAG_MARKED = 84159255;
    public static final int GROWING_INHERIT_INFO_KEY = 84159243;
    public static final int GROWING_MONITORING_FOCUS_KEY = 84159246;
    public static final int GROWING_MONITORING_VIEWTREE_KEY = 84159245;
    public static final int GROWING_RN_PAGE_KEY = 84159252;
    public static final int GROWING_TAG_KEY = 84159238;
    public static final int GROWING_TRACK_TEXT = 84159251;
    public static final int GROWING_TRACK_WEB_VIEW = 84159257;
    public static final int GROWING_VIEW_ID_KEY = 84159242;
    public static final int GROWING_VIEW_NAME_KEY = 84159241;
    public static final int GROWING_WEB_BRIDGE_KEY = 84159240;
    public static final int GROWING_WEB_CLIENT_KEY = 84159239;
    public static final int GROWING_WEB_VIEW_URL = 84159254;
    static final String TAG = "GrowingIO";
    private static GrowingIO sInstance;
    public static final Object sInstanceLock = new Object();
    static String sProjectId;
    ArgumentChecker mArgumentChecker;
    protected GConfig mGConfig;

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(14)
    public AbstractGrowingIO(Configuration configuration) {
        GConfig config = CoreInitialize.config();
        this.mGConfig = config;
        this.mArgumentChecker = new ArgumentChecker(config);
        GConfig.sCanHook = true;
        GInternal.getInstance().addFeaturesVersion("av", GConfig.GROWING_VERSION);
        Log.i(TAG, "!!! Thank you very much for using GrowingIO. We will do our best to provide you with the best service. !!!");
        Log.i(TAG, "!!! GrowingIO version: autotrack-2.9.4_cc04ab80 !!!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GrowingIO customStart(Configuration configuration) {
        GConfig config = CoreInitialize.config();
        if (config.getSampling() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            configuration.sampling = config.getSampling();
        }
        if (!Util.isInSampling(CoreInitialize.deviceUUIDFactory().getDeviceId(), configuration.sampling)) {
            configuration.disableDataCollect();
            config.setGDPREnabled(false);
            Log.w(TAG, "改设备不在采集范围之内， 不在收集信息");
        }
        synchronized (sInstanceLock) {
            if (sInstance == null) {
                sInstance = new GrowingIO(configuration);
                CoreInitialize.messageProcessor().saveVisit(true);
                CoreInitialize.growingIOIPC().setSessionId(UUID.randomUUID().toString());
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CoreAppState getAPPState() {
        return CoreInitialize.coreAppState();
    }

    public static GrowingIO getInstance() {
        synchronized (sInstanceLock) {
            GrowingIO growingIO = sInstance;
            if (growingIO == null) {
                Log.i(TAG, "GrowingIO 还未初始化");
                return new GrowingIO.EmptyGrowingIO();
            }
            return growingIO;
        }
    }

    public static String getVersion() {
        return "autotrack-2.9.4";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void runOnUIThread(Runnable runnable) {
        if (ThreadUtils.runningOnUiThread()) {
            runnable.run();
            return;
        }
        Log.d(TAG, "[!提示!] GrowingIO API要求在主线程调用, 该方法将自动post到主线程执行");
        ThreadUtils.postOnUiThread(runnable);
    }

    public static void setAdHost(String str) {
        NetworkConfig.getInstance().setAdHost(str);
    }

    public static void setAssetsHost(String str) {
        NetworkConfig.getInstance().setAssetsHost(str);
    }

    public static void setDataHost(String str) {
        NetworkConfig.getInstance().setDataHost(str);
    }

    public static void setGtaHost(String str) {
        NetworkConfig.getInstance().setGtaHost(str);
    }

    public static void setHybridJSSDKUrlPrefix(String str) {
        NetworkConfig.getInstance().setDEFAULT_HybridJSSDKUrlPrefix(str);
    }

    @Deprecated
    public static void setJavaCirclePluginHost(String str) {
        NetworkConfig.getInstance().setJavaCirclePluginHost(str);
    }

    public static void setReportHost(String str) {
        NetworkConfig.getInstance().setReportHost(str);
    }

    @Deprecated
    public static void setScheme(String str) {
        GConfig.sGrowingScheme = str;
    }

    public static void setTagsHost(String str) {
        NetworkConfig.getInstance().setTagsHost(str);
    }

    public static void setTrackerHost(String str) {
        NetworkConfig.getInstance().setApiHost(str);
    }

    public static void setViewID(final View view, final String str) {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.4
            @Override // java.lang.Runnable
            public void run() {
                view.setTag(AbstractGrowingIO.GROWING_VIEW_ID_KEY, str);
            }
        });
    }

    public static void setWsHost(String str) {
        NetworkConfig.getInstance().setWsHost(str);
    }

    @Deprecated
    public static void setZone(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NetworkConfig.getInstance().setZone(str.trim());
    }

    public static GrowingIO startWithConfiguration(Application application, final Configuration configuration) {
        int identifier;
        if (sInstance != null) {
            Log.e(TAG, "GrowingIO 已经初始化");
            return sInstance;
        } else if (Build.VERSION.SDK_INT < 17) {
            Log.e(TAG, "GrowingIO 暂不支持Android 4.2以下版本");
            return new GrowingIO.EmptyGrowingIO();
        } else if (ThreadUtils.runningOnUiThread()) {
            boolean z = configuration.rnMode;
            Resources resources = application.getResources();
            try {
                if (!Boolean.valueOf(resources.getString(resources.getIdentifier("growingio_enable", TypedValues.Custom.S_STRING, application.getPackageName()))).booleanValue()) {
                    Log.e(TAG, "GrowingIO 提醒您: gradle.properties 中配置 gioenable为 false，GIO SDK 各项功能已被关闭，请在正式发版时打开！");
                    return new GrowingIO.EmptyGrowingIO();
                }
            } catch (Exception unused) {
                LogUtil.d(TAG, "GrowingIO SDK 开关 gioenable 未配置，使用默认值，即 SDK 各项功能开启");
            }
            configuration.context = application;
            if (TextUtils.isEmpty(configuration.projectId)) {
                String projectId = GConfig.getProjectId();
                configuration.projectId = projectId;
                if (TextUtils.isEmpty(projectId)) {
                    String string = resources.getString(resources.getIdentifier("growingio_project_id", TypedValues.Custom.S_STRING, application.getPackageName()));
                    configuration.projectId = string;
                    if (TextUtils.isEmpty(string)) {
                        throw new IllegalStateException("未检测到有效的项目ID, 请参考帮助文档 https://docs.growingio.com/v3/developer-manual/sdkintegrated/android-sdk/auto-android-sdk");
                    }
                }
            }
            if (TextUtils.isEmpty(configuration.urlScheme)) {
                String urlScheme = GConfig.getUrlScheme();
                configuration.urlScheme = urlScheme;
                if (TextUtils.isEmpty(urlScheme)) {
                    String string2 = resources.getString(resources.getIdentifier("growingio_url_scheme", TypedValues.Custom.S_STRING, application.getPackageName()));
                    configuration.urlScheme = string2;
                    if (TextUtils.isEmpty(string2)) {
                        throw new IllegalStateException("未检测到有效的URL Scheme, 请参考帮助文档 https://docs.growingio.com/v3/developer-manual/sdkintegrated/android-sdk/auto-android-sdk");
                    }
                }
            }
            if (TextUtils.isEmpty(configuration.channel) && (identifier = resources.getIdentifier("growingio_channel", TypedValues.Custom.S_STRING, application.getPackageName())) > 0) {
                try {
                    configuration.channel = resources.getString(identifier);
                } catch (Exception unused2) {
                }
            }
            PermissionUtil.init(configuration.context);
            if (!PermissionUtil.hasInternetPermission() || !PermissionUtil.hasAccessNetworkStatePermission()) {
                if (!configuration.debugMode) {
                    Log.e(TAG, "您的App没有网络权限, 非Debug模式, 将会影响数据采集, 请获悉");
                } else {
                    throw new IllegalStateException("您的App没有网络权限, 请添加 INTERNET 和 ACCESS_NETWORK_STATE 权限");
                }
            }
            GConfig.isRnMode = configuration.rnMode;
            if (GConfig.isInstrumented()) {
                if (configuration.debugMode) {
                    LogUtil.add(LogUtil.DebugUtil.getInstance());
                } else {
                    LogUtil.add(LogUtil.ReleaseUitl.getInstance());
                }
                setTrackerHost(configuration.trackerHost);
                setReportHost(configuration.reportHost);
                setDataHost(configuration.dataHost);
                setTagsHost(configuration.tagsHost);
                setGtaHost(configuration.gtaHost);
                setWsHost(configuration.wsHost);
                setAssetsHost(configuration.assetsHost);
                setAdHost(configuration.adHost);
                setZone(configuration.zone);
                sProjectId = configuration.projectId;
                try {
                    EventCenter.getInstance().init(configuration.context);
                } catch (EventCenterException unused3) {
                }
                try {
                    EventCenter.getInstance().post(new InitializeSDKEvent(configuration.context, configuration));
                    EventBus.getDefault().getExecutorService().submit(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.1
                        @Override // java.lang.Runnable
                        public void run() {
                            EventCenter eventCenter = EventCenter.getInstance();
                            Configuration configuration2 = Configuration.this;
                            eventCenter.post(new BgInitializeSDKEvent(configuration2.context, configuration2));
                            CoreAppState coreAppState = CoreInitialize.coreAppState();
                            if (coreAppState != null) {
                                coreAppState.completeBgInit();
                            }
                        }
                    });
                    return GrowingIO.customStart(configuration);
                } catch (Throwable th) {
                    Log.e(TAG, "GIO 初始化失败");
                    LogUtil.e(TAG, th.getMessage(), th);
                    GConfig.sCanHook = false;
                    return new GrowingIO.EmptyGrowingIO();
                }
            }
            throw new IllegalStateException("GrowingIO无法正常启动, 请检查:\n1. 首次集成时请先Clean项目再重新编译.\n2. (Gradle环境) 确保已经启用了GrowingIO插件(在build.gradle > buildscript > dependencies 中添加 classpath: 'com.growingio.android:vds-gradle-plugin:autotrack-2.9.4' 然后在app目录下的build.gradle中添加apply plugin: 'com.growingio.android'.\n3. (Ant环境) 将vds-class-rewriter.jar的路径添加到环境变量ANT_OPTS中.\n有疑问请参考帮助文档 https://docs.growingio.com/v3/developer-manual/sdkintegrated/android-sdk/auto-android-sdk , 或者联系在线客服 https://www.growingio.com/");
        } else {
            throw new IllegalStateException("GrowingIO.startWithConfiguration必须在主线程中调用。");
        }
    }

    private GrowingIO track(final CustomEvent customEvent) {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.32
            @Override // java.lang.Runnable
            public void run() {
                CoreInitialize.coreAppState().waitUntilInitComplete();
                CoreInitialize.messageProcessor().saveCustomEvent(customEvent);
            }
        });
        return (GrowingIO) this;
    }

    public GrowingIO clearGeoLocation() {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.11
            @Override // java.lang.Runnable
            public void run() {
                AbstractGrowingIO.getAPPState().clearLocation();
            }
        });
        return (GrowingIO) this;
    }

    public GrowingIO clearUserId() {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.13
            @Override // java.lang.Runnable
            public void run() {
                AbstractGrowingIO.getAPPState().clearUserId();
            }
        });
        return (GrowingIO) this;
    }

    @Deprecated
    public GrowingIO disable() {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.6
            @Override // java.lang.Runnable
            public void run() {
                AbstractGrowingIO.this.mGConfig.disableAll();
            }
        });
        return (GrowingIO) this;
    }

    public void disableDataCollect() {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.2
            @Override // java.lang.Runnable
            public void run() {
                AbstractGrowingIO.this.mGConfig.setGDPREnabled(false);
            }
        });
    }

    @Deprecated
    public GrowingIO disableImpression() {
        if (this.mGConfig != null) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.30
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.this.mGConfig.disableImpression();
                }
            });
        }
        return (GrowingIO) this;
    }

    public boolean doDeeplinkByUrl(@Nullable String str, @Nullable DeeplinkCallback deeplinkCallback) {
        return CoreInitialize.deeplinkManager().doDeeplinkByUrl(str, deeplinkCallback);
    }

    public void enableDataCollect() {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.3
            @Override // java.lang.Runnable
            public void run() {
                AbstractGrowingIO.this.mGConfig.setGDPREnabled(true);
                CoreInitialize.messageProcessor().saveVisit(true);
                EventCenter.getInstance().post(new DeepLinkEvent(1));
            }
        });
    }

    public String getDeviceId() {
        return CoreInitialize.deviceUUIDFactory().getDeviceId();
    }

    public String getSessionId() {
        return CoreInitialize.sessionManager().getSessionIdInner();
    }

    @Deprecated
    public String getUserId() {
        return CoreInitialize.config().getAppUserId();
    }

    public String getVisitUserId() {
        return getDeviceId();
    }

    public boolean isDeepLinkUrl(@Nullable String str) {
        return DeeplinkManager.isDeepLinkUrl(str, null);
    }

    public GrowingIO onNewIntent(final Activity activity, final Intent intent) {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.14
            @Override // java.lang.Runnable
            public void run() {
                CoreInitialize.coreAppState().waitUntilInitComplete();
                CoreInitialize.deeplinkManager().handleIntent(intent, activity);
            }
        });
        return (GrowingIO) this;
    }

    public GrowingIO resume() {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.7
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractGrowingIO.this.mGConfig.isEnabled()) {
                    return;
                }
                LogUtil.d(AbstractGrowingIO.TAG, "resume: GrowingIO 恢复采集");
                AbstractGrowingIO.this.mGConfig.enableAll();
                EventCenter.getInstance().post(new RefreshPageEvent(true, true));
            }
        });
        return (GrowingIO) this;
    }

    @Deprecated
    public void saveVisit(String str) {
        if (this.mArgumentChecker.isIllegalEventName(str)) {
        }
    }

    public GrowingIO setAndroidIdEnable(final boolean z) {
        final DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
        final MessageProcessor messageProcessor = CoreInitialize.messageProcessor();
        if (deviceUUIDFactory.androidIdEnable != z && deviceUUIDFactory != null && messageProcessor != null) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.38
                @Override // java.lang.Runnable
                public void run() {
                    deviceUUIDFactory.setAndroidIdEnable(z);
                    if (z) {
                        messageProcessor.saveVisit(false);
                    }
                }
            });
            return (GrowingIO) this;
        }
        return (GrowingIO) this;
    }

    public GrowingIO setAppVariable(JSONObject jSONObject) {
        final JSONObject validJSONObject = this.mArgumentChecker.validJSONObject(jSONObject);
        if (validJSONObject != null) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.25
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setAppVariable(validJSONObject);
                }
            });
        }
        return (GrowingIO) this;
    }

    public GrowingIO setChannel(final String str) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        if (this.mGConfig == null) {
            Log.e(TAG, "Pls invoke GrowingIO.startTracking() first");
            return (GrowingIO) this;
        }
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.29
            @Override // java.lang.Runnable
            public void run() {
                AbstractGrowingIO.this.mGConfig.setChannel(str);
                CoreInitialize.messageProcessor().saveVisit(false);
            }
        });
        return (GrowingIO) this;
    }

    public GrowingIO setEvar(JSONObject jSONObject) {
        final JSONObject validJSONObject = this.mArgumentChecker.validJSONObject(jSONObject);
        if (validJSONObject != null) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.19
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setConversionVariable(validJSONObject);
                }
            });
        }
        return (GrowingIO) this;
    }

    public GrowingIO setGeoLocation(final double d2, final double d3) {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.10
            @Override // java.lang.Runnable
            public void run() {
                AbstractGrowingIO.getAPPState().setLocation(d2, d3);
            }
        });
        return (GrowingIO) this;
    }

    public GrowingIO setGoogleAdIdEnable(final boolean z) {
        final DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
        final MessageProcessor messageProcessor = CoreInitialize.messageProcessor();
        if (deviceUUIDFactory.googleIdEnable != z && deviceUUIDFactory != null && messageProcessor != null) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.37
                @Override // java.lang.Runnable
                public void run() {
                    deviceUUIDFactory.setGoogleIdEnable(z);
                    if (z) {
                        messageProcessor.saveVisit(false);
                    }
                }
            });
            return (GrowingIO) this;
        }
        return (GrowingIO) this;
    }

    public GrowingIO setImeiEnable(final boolean z) {
        final DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
        final MessageProcessor messageProcessor = CoreInitialize.messageProcessor();
        if (deviceUUIDFactory.imeiEnable != z && deviceUUIDFactory != null && messageProcessor != null) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.36
                @Override // java.lang.Runnable
                public void run() {
                    deviceUUIDFactory.setImeiEnable(z);
                    if (z) {
                        messageProcessor.saveVisit(false);
                    }
                }
            });
            return (GrowingIO) this;
        }
        return (GrowingIO) this;
    }

    public GrowingIO setImp(final boolean z) {
        if (this.mGConfig != null) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.31
                @Override // java.lang.Runnable
                public void run() {
                    if (!z) {
                        AbstractGrowingIO.this.mGConfig.disableImpression();
                    } else {
                        AbstractGrowingIO.this.mGConfig.enableImpression();
                    }
                }
            });
        }
        return (GrowingIO) this;
    }

    public GrowingIO setOAIDEnable(final boolean z) {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.39
            @Override // java.lang.Runnable
            public void run() {
                DeviceUUIDFactory deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
                if (deviceUUIDFactory != null) {
                    deviceUUIDFactory.oaidEnable = z;
                }
            }
        });
        return (GrowingIO) this;
    }

    @Deprecated
    public GrowingIO setPageVariable(final String str, JSONObject jSONObject) {
        final JSONObject validJSONObject;
        if (!this.mArgumentChecker.isIllegalEventName(str) && (validJSONObject = this.mArgumentChecker.validJSONObject(jSONObject)) != null) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.35
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setPageVariable(str, validJSONObject);
                }
            });
            return (GrowingIO) this;
        }
        return (GrowingIO) this;
    }

    public GrowingIO setPeopleVariable(JSONObject jSONObject) {
        final JSONObject validJSONObject = this.mArgumentChecker.validJSONObject(jSONObject);
        if (validJSONObject != null) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.15
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setPeopleVariable(validJSONObject);
                }
            });
        }
        return (GrowingIO) this;
    }

    public GrowingIO setTestHandler(final Handler handler) {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.9
            @Override // java.lang.Runnable
            public void run() {
                MessageHandler.addCallBack(new MessageHandler.TestMessageCallBack(handler));
            }
        });
        return (GrowingIO) this;
    }

    @Deprecated
    public GrowingIO setThrottle(final boolean z) {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.5
            @Override // java.lang.Runnable
            public void run() {
                AbstractGrowingIO.this.mGConfig.setThrottle(z);
            }
        });
        return (GrowingIO) this;
    }

    public GrowingIO setUserId(final String str) {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.12
            @Override // java.lang.Runnable
            public void run() {
                AbstractGrowingIO.getAPPState().setUserId(str);
            }
        });
        return (GrowingIO) this;
    }

    public GrowingIO setVisitor(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            final JSONObject validJSONObject = this.mArgumentChecker.validJSONObject(jSONObject);
            if (validJSONObject != null) {
                runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.24
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractGrowingIO.getAPPState().setVisitorVariable(validJSONObject);
                    }
                });
            }
        } else {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.23
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setVisitorVariable(null);
                }
            });
        }
        return (GrowingIO) this;
    }

    public GrowingIO stop() {
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.8
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractGrowingIO.this.mGConfig.isEnabled()) {
                    LogUtil.d(AbstractGrowingIO.TAG, "stop: GrowingIO 停止采集");
                    AbstractGrowingIO.this.mGConfig.disableAll();
                }
            }
        });
        return (GrowingIO) this;
    }

    @Deprecated
    public void trackPage(final String str, final String str2, final long j2) {
        if (!this.mArgumentChecker.isIllegalEventName(str) && j2 >= 0 && j2 <= System.currentTimeMillis()) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.33
                @Override // java.lang.Runnable
                public void run() {
                    CoreInitialize.messageProcessor().savePage(new PageEvent(str, str2, j2), str);
                }
            });
        }
    }

    public GrowingIO track(String str) {
        if (this.mArgumentChecker.isIllegalEventName(str)) {
            return (GrowingIO) this;
        }
        return track(new CustomEvent(str));
    }

    public GrowingIO setAppVariable(final String str, final Number number) {
        if (!this.mArgumentChecker.isIllegalEventName(str) && !this.mArgumentChecker.isIllegalValue(number)) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.26
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setAppVariable(str, number);
                }
            });
        }
        return (GrowingIO) this;
    }

    public GrowingIO setEvar(final String str, final Number number) {
        if (!this.mArgumentChecker.isIllegalEventName(str) && !this.mArgumentChecker.isIllegalValue(number)) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.20
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setConversionVariable(str, number);
                }
            });
        }
        return (GrowingIO) this;
    }

    public GrowingIO setPeopleVariable(final String str, final Number number) {
        if (!this.mArgumentChecker.isIllegalEventName(str) && !this.mArgumentChecker.isIllegalValue(number)) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.16
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setPeopleVariable(str, number);
                }
            });
            return (GrowingIO) this;
        }
        return (GrowingIO) this;
    }

    @Deprecated
    public void trackPage(final String str) {
        if (this.mArgumentChecker.isIllegalEventName(str)) {
            return;
        }
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.34
            @Override // java.lang.Runnable
            public void run() {
                CoreInitialize.messageProcessor().savePage(str);
            }
        });
    }

    @Deprecated
    public GrowingIO track(String str, Number number) {
        if (!this.mArgumentChecker.isIllegalEventName(str) && !this.mArgumentChecker.isIllegalValue(number)) {
            return track(new CustomEvent(str, number));
        }
        return (GrowingIO) this;
    }

    public GrowingIO setAppVariable(final String str, final String str2) {
        if (!this.mArgumentChecker.isIllegalEventName(str) && !this.mArgumentChecker.isIllegalValue(str2)) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.27
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setAppVariable(str, str2);
                }
            });
        }
        return (GrowingIO) this;
    }

    public GrowingIO setEvar(final String str, final String str2) {
        if (!this.mArgumentChecker.isIllegalEventName(str) && !this.mArgumentChecker.isIllegalValue(str2)) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.21
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setConversionVariable(str, str2);
                }
            });
        }
        return (GrowingIO) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractGrowingIO() {
    }

    public GrowingIO setPeopleVariable(final String str, final String str2) {
        if (!this.mArgumentChecker.isIllegalEventName(str) && !this.mArgumentChecker.isIllegalValue(str2)) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.17
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setPeopleVariable(str, str2);
                }
            });
            return (GrowingIO) this;
        }
        return (GrowingIO) this;
    }

    @TargetApi(14)
    @Deprecated
    private AbstractGrowingIO(Application application, String str, double d2) {
        this(new AbstractConfiguration(str).setProjectId(str).setSampling(d2).setContext(application));
    }

    public GrowingIO track(String str, JSONObject jSONObject) {
        JSONObject validJSONObject;
        if (!this.mArgumentChecker.isIllegalEventName(str) && (validJSONObject = this.mArgumentChecker.validJSONObject(jSONObject)) != null) {
            return track(new CustomEvent(str, validJSONObject));
        }
        return (GrowingIO) this;
    }

    public GrowingIO setAppVariable(final String str, final boolean z) {
        if (!this.mArgumentChecker.isIllegalEventName(str)) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.28
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setAppVariable(str, Boolean.valueOf(z));
                }
            });
        }
        return (GrowingIO) this;
    }

    public GrowingIO setEvar(final String str, final boolean z) {
        if (!this.mArgumentChecker.isIllegalEventName(str)) {
            runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.22
                @Override // java.lang.Runnable
                public void run() {
                    AbstractGrowingIO.getAPPState().setConversionVariable(str, Boolean.valueOf(z));
                }
            });
        }
        return (GrowingIO) this;
    }

    public GrowingIO setPeopleVariable(final String str, final boolean z) {
        if (this.mArgumentChecker.isIllegalEventName(str)) {
            return (GrowingIO) this;
        }
        runOnUIThread(new Runnable() { // from class: com.growingio.android.sdk.collection.AbstractGrowingIO.18
            @Override // java.lang.Runnable
            public void run() {
                AbstractGrowingIO.getAPPState().setPeopleVariable(str, Boolean.valueOf(z));
            }
        });
        return (GrowingIO) this;
    }

    @Deprecated
    public GrowingIO track(String str, Number number, JSONObject jSONObject) {
        JSONObject validJSONObject;
        if (!this.mArgumentChecker.isIllegalEventName(str) && !this.mArgumentChecker.isIllegalValue(number) && (validJSONObject = this.mArgumentChecker.validJSONObject(jSONObject)) != null) {
            return track(new CustomEvent(str, number, validJSONObject));
        }
        return (GrowingIO) this;
    }
}
