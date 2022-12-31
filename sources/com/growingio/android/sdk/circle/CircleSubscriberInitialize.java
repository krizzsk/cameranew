package com.growingio.android.sdk.circle;

import com.growingio.android.sdk.base.event.BgInitializeSDKEvent;
import com.growingio.android.sdk.circle.webcircle.WebCircleMain;
import com.growingio.android.sdk.circle.webcircle.WebCircleNonMain;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.debugger.DebuggerInitialize;
import com.growingio.android.sdk.debugger.DebuggerManager;
import com.growingio.cp_annotation.Subscribe;
/* loaded from: classes2.dex */
public class CircleSubscriberInitialize {
    @Subscribe(priority = 100)
    public static void onSDKInitialize(BgInitializeSDKEvent bgInitializeSDKEvent) {
        DebuggerManager debuggerManager = DebuggerInitialize.debuggerManager();
        CircleSubscriber circleSubscriber = new CircleSubscriber(debuggerManager, true);
        debuggerManager.registerDebuggerEventListener("app", circleSubscriber);
        debuggerManager.registerDebuggerEventListener("app-circle-main", circleSubscriber);
        debuggerManager.registerDebuggerEventListener("web-circle-main", new WebCircleMain(debuggerManager));
        if (CoreInitialize.config().isMultiProcessEnabled()) {
            debuggerManager.registerDebuggerEventListener("app-circle-non-main", new CircleSubscriber(debuggerManager, false));
            debuggerManager.registerDebuggerEventListener("web-circle-non-main", new WebCircleNonMain(debuggerManager));
        }
    }
}
