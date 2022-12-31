package com.growingio.android.sdk.debugger;

import com.growingio.android.sdk.base.event.BgInitializeSDKEvent;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
/* loaded from: classes2.dex */
public class DebuggerInitialize {
    private static final String TAG = "GIO.DebuggerIni";
    private static DebuggerManager debuggerManager;

    public static DebuggerManager debuggerManager() {
        return debuggerManager;
    }

    @Subscribe(priority = 500)
    public static void onSDKInit(BgInitializeSDKEvent bgInitializeSDKEvent) {
        debuggerManager = new DebuggerManager(CoreInitialize.coreAppState());
        EventCenter.getInstance().register(debuggerManager);
        debuggerManager.registerDebuggerEventListener("mobile-debugger-main", new MobileDebuggerMain(debuggerManager));
        debuggerManager.registerDebuggerEventListener("mobile-debugger-non-main", new MobileDebuggerNonMain(debuggerManager));
    }
}
