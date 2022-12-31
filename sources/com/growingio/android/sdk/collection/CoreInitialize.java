package com.growingio.android.sdk.collection;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.growingio.android.sdk.base.event.BgInitializeSDKEvent;
import com.growingio.android.sdk.base.event.InitializeSDKEvent;
import com.growingio.android.sdk.crash.CrashManager;
import com.growingio.android.sdk.deeplink.DeeplinkManager;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import com.growingio.android.sdk.utils.PersistUtil;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
/* loaded from: classes2.dex */
public class CoreInitialize {
    @SuppressLint({"StaticFieldLeak"})
    private static CoreAppState coreAppState;
    private static DeeplinkManager deeplinkManager;
    private static DeviceUUIDFactory deviceUUIDFactory;
    private static GConfig gConfig;
    private static GrowingIOIPC growingIOIPC;
    private static MessageProcessor messageProcessor;
    private static SessionManager sessionManager;

    @NonNull
    public static GConfig config() {
        return gConfig;
    }

    @NonNull
    public static CoreAppState coreAppState() {
        return coreAppState;
    }

    @NonNull
    public static DeeplinkManager deeplinkManager() {
        return deeplinkManager;
    }

    @NonNull
    public static DeviceUUIDFactory deviceUUIDFactory() {
        return deviceUUIDFactory;
    }

    @NonNull
    public static GrowingIOIPC growingIOIPC() {
        return growingIOIPC;
    }

    @Subscribe(priority = 2000)
    public static void initialize(InitializeSDKEvent initializeSDKEvent) {
        Configuration configuration = initializeSDKEvent.getConfiguration();
        Application application = initializeSDKEvent.getApplication();
        deviceUUIDFactory = new DeviceUUIDFactory(application, configuration);
        gConfig = new GConfig(configuration);
        GrowingIOIPC growingIOIPC2 = new GrowingIOIPC();
        growingIOIPC = growingIOIPC2;
        growingIOIPC2.init(initializeSDKEvent.getApplication(), gConfig);
        CoreAppState coreAppState2 = new CoreAppState(gConfig, initializeSDKEvent.getApplication());
        coreAppState = coreAppState2;
        coreAppState2.setSPN(TextUtils.isEmpty(configuration.packageName) ? initializeSDKEvent.getApplication().getPackageName() : configuration.packageName);
        coreAppState.setGrowingIOIPC(growingIOIPC);
        deviceUUIDFactory.setCoreAppState(coreAppState);
        MessageProcessor messageProcessor2 = new MessageProcessor(gConfig, coreAppState);
        messageProcessor = messageProcessor2;
        coreAppState.setMsgProcessor(messageProcessor2);
        SessionManager sessionManager2 = new SessionManager(messageProcessor, growingIOIPC, gConfig);
        sessionManager = sessionManager2;
        coreAppState.setSessionManager(sessionManager2);
        if (configuration.uploadExceptionEnable) {
            CrashManager.register(application);
        }
    }

    @NonNull
    public static MessageProcessor messageProcessor() {
        return messageProcessor;
    }

    @Subscribe
    public static void onBgInit(BgInitializeSDKEvent bgInitializeSDKEvent) {
        deeplinkManager = new DeeplinkManager(gConfig, bgInitializeSDKEvent.application);
        gConfig.onBgInit(deviceUUIDFactory);
        PersistUtil.init(coreAppState.getGlobalContext());
        EventCenter.getInstance().register(coreAppState);
        EventCenter.getInstance().register(messageProcessor);
        EventCenter.getInstance().register(deeplinkManager);
        EventCenter.getInstance().register(sessionManager);
    }

    @NonNull
    public static SessionManager sessionManager() {
        return sessionManager;
    }
}
