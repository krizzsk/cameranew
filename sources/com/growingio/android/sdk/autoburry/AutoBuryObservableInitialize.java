package com.growingio.android.sdk.autoburry;

import androidx.annotation.NonNull;
import com.growingio.android.sdk.autoburry.page.PageObserver;
import com.growingio.android.sdk.base.event.BgInitializeSDKEvent;
import com.growingio.android.sdk.base.event.InitializeSDKEvent;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
/* loaded from: classes2.dex */
public class AutoBuryObservableInitialize {
    private static volatile AutoBuryAppState autoBuryAppState;
    private static volatile AutoBuryMessageProcessor autoBuryMessageProcessor;
    private static volatile ImpObserver impObserver;
    private static volatile NotificationProcessor notificationProcessor;

    @NonNull
    public static AutoBuryAppState autoBuryAppState() {
        return autoBuryAppState;
    }

    @NonNull
    public static AutoBuryMessageProcessor autoBuryMessageProcessor() {
        return autoBuryMessageProcessor;
    }

    public static ImpObserver impObserver() {
        return impObserver;
    }

    @NonNull
    public static NotificationProcessor notificationProcessor() {
        return notificationProcessor;
    }

    @Subscribe
    public static void onBgInitialize(BgInitializeSDKEvent bgInitializeSDKEvent) {
        PageObserver pageObserver = new PageObserver(CoreInitialize.coreAppState(), autoBuryAppState);
        EventCenter.getInstance().register(autoBuryMessageProcessor);
        EventCenter.getInstance().register(autoBuryAppState);
        EventCenter.getInstance().register(pageObserver);
        if (notificationProcessor.isEnable()) {
            EventCenter.getInstance().register(notificationProcessor);
        }
    }

    @Subscribe(priority = 1000)
    public static void onSDKInitialize(InitializeSDKEvent initializeSDKEvent) {
        GConfig config = CoreInitialize.config();
        autoBuryAppState = new AutoBuryAppState(CoreInitialize.coreAppState(), config);
        autoBuryMessageProcessor = new AutoBuryMessageProcessor(config, CoreInitialize.coreAppState(), autoBuryAppState, CoreInitialize.messageProcessor());
        autoBuryAppState.autoBuryMessageProcessor = autoBuryMessageProcessor;
        notificationProcessor = new NotificationProcessor(initializeSDKEvent.getApplication(), CoreInitialize.coreAppState());
        if (!initializeSDKEvent.getConfiguration().isEnableNotificationTrack()) {
            notificationProcessor.enable = false;
        }
        impObserver = new ImpObserver(CoreInitialize.coreAppState());
    }
}
