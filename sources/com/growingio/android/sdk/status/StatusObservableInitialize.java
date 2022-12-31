package com.growingio.android.sdk.status;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.IntentFilter;
import com.growingio.android.sdk.base.event.InitializeSDKEvent;
import com.growingio.android.sdk.utils.ContextUtil;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.bus.ThreadMode;
/* loaded from: classes2.dex */
public class StatusObservableInitialize {
    private static void broadcastRegister(Application application) {
        BroadcastObservable broadcastObservable = new BroadcastObservable();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        ContextUtil.registerReceiver(application, broadcastObservable, intentFilter);
    }

    @Subscribe(priority = 0, sticky = false, threadMode = ThreadMode.MAIN)
    @TargetApi(14)
    public static void onSDKInitialize(InitializeSDKEvent initializeSDKEvent) {
        Application application = initializeSDKEvent.getApplication();
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleObservable());
        broadcastRegister(application);
        application.registerComponentCallbacks(new LowMemoryObservable());
    }
}
