package com.growingio.eventcenter.bus.meta;

import com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize;
import com.growingio.android.sdk.base.event.BgInitializeSDKEvent;
import com.growingio.android.sdk.base.event.DiagnoseEvent;
import com.growingio.android.sdk.base.event.InitializeSDKEvent;
import com.growingio.android.sdk.circle.CircleSubscriberInitialize;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.data.DataSubscriberInitialize;
import com.growingio.android.sdk.data.DiagnoseLog;
import com.growingio.android.sdk.debugger.DebuggerInitialize;
import com.growingio.android.sdk.heatmap.HeatMapSubscriberInitialize;
import com.growingio.android.sdk.status.StatusObservableInitialize;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
/* loaded from: classes2.dex */
public class StaticSubscriberCenter implements Subscriber {
    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if ("#com.growingio.android.sdk.data.DataSubscriberInitialize#onSDKInitialize(com.growingio.android.sdk.base.event.BgInitializeSDKEvent".equals(str)) {
            DataSubscriberInitialize.onSDKInitialize((BgInitializeSDKEvent) obj);
        } else if ("#com.growingio.android.sdk.data.DiagnoseLog#onDiagnoseEvent(com.growingio.android.sdk.base.event.DiagnoseEvent".equals(str)) {
            DiagnoseLog.onDiagnoseEvent((DiagnoseEvent) obj);
        } else if ("#com.growingio.android.sdk.status.StatusObservableInitialize#onSDKInitialize(com.growingio.android.sdk.base.event.InitializeSDKEvent".equals(str)) {
            StatusObservableInitialize.onSDKInitialize((InitializeSDKEvent) obj);
        } else if ("#com.growingio.android.sdk.collection.CoreInitialize#initialize(com.growingio.android.sdk.base.event.InitializeSDKEvent".equals(str)) {
            CoreInitialize.initialize((InitializeSDKEvent) obj);
        } else if ("#com.growingio.android.sdk.collection.CoreInitialize#onBgInit(com.growingio.android.sdk.base.event.BgInitializeSDKEvent".equals(str)) {
            CoreInitialize.onBgInit((BgInitializeSDKEvent) obj);
        } else if ("#com.growingio.android.sdk.debugger.DebuggerInitialize#onSDKInit(com.growingio.android.sdk.base.event.BgInitializeSDKEvent".equals(str)) {
            DebuggerInitialize.onSDKInit((BgInitializeSDKEvent) obj);
        } else if ("#com.growingio.android.sdk.heatmap.HeatMapSubscriberInitialize#onSDKInitialize(com.growingio.android.sdk.base.event.BgInitializeSDKEvent".equals(str)) {
            HeatMapSubscriberInitialize.onSDKInitialize((BgInitializeSDKEvent) obj);
        } else if ("#com.growingio.android.sdk.circle.CircleSubscriberInitialize#onSDKInitialize(com.growingio.android.sdk.base.event.BgInitializeSDKEvent".equals(str)) {
            CircleSubscriberInitialize.onSDKInitialize((BgInitializeSDKEvent) obj);
        } else if ("#com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize#onSDKInitialize(com.growingio.android.sdk.base.event.InitializeSDKEvent".equals(str)) {
            AutoBuryObservableInitialize.onSDKInitialize((InitializeSDKEvent) obj);
        } else if ("#com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize#onBgInitialize(com.growingio.android.sdk.base.event.BgInitializeSDKEvent".equals(str)) {
            AutoBuryObservableInitialize.onBgInitialize((BgInitializeSDKEvent) obj);
        }
    }

    @Override // com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.POSTING;
        return new SubscriberMethod[]{new SubscriberMethod("onSDKInitialize", BgInitializeSDKEvent.class, "#com.growingio.android.sdk.data.DataSubscriberInitialize#onSDKInitialize(com.growingio.android.sdk.base.event.BgInitializeSDKEvent", threadMode, 0, false), new SubscriberMethod("onDiagnoseEvent", DiagnoseEvent.class, "#com.growingio.android.sdk.data.DiagnoseLog#onDiagnoseEvent(com.growingio.android.sdk.base.event.DiagnoseEvent", threadMode, 0, false), new SubscriberMethod("onSDKInitialize", InitializeSDKEvent.class, "#com.growingio.android.sdk.status.StatusObservableInitialize#onSDKInitialize(com.growingio.android.sdk.base.event.InitializeSDKEvent", ThreadMode.MAIN, 0, false), new SubscriberMethod("initialize", InitializeSDKEvent.class, "#com.growingio.android.sdk.collection.CoreInitialize#initialize(com.growingio.android.sdk.base.event.InitializeSDKEvent", threadMode, 2000, false), new SubscriberMethod("onBgInit", BgInitializeSDKEvent.class, "#com.growingio.android.sdk.collection.CoreInitialize#onBgInit(com.growingio.android.sdk.base.event.BgInitializeSDKEvent", threadMode, 0, false), new SubscriberMethod("onSDKInit", BgInitializeSDKEvent.class, "#com.growingio.android.sdk.debugger.DebuggerInitialize#onSDKInit(com.growingio.android.sdk.base.event.BgInitializeSDKEvent", threadMode, 500, false), new SubscriberMethod("onSDKInitialize", BgInitializeSDKEvent.class, "#com.growingio.android.sdk.heatmap.HeatMapSubscriberInitialize#onSDKInitialize(com.growingio.android.sdk.base.event.BgInitializeSDKEvent", threadMode, 0, false), new SubscriberMethod("onSDKInitialize", BgInitializeSDKEvent.class, "#com.growingio.android.sdk.circle.CircleSubscriberInitialize#onSDKInitialize(com.growingio.android.sdk.base.event.BgInitializeSDKEvent", threadMode, 100, false), new SubscriberMethod("onSDKInitialize", InitializeSDKEvent.class, "#com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize#onSDKInitialize(com.growingio.android.sdk.base.event.InitializeSDKEvent", threadMode, 1000, false), new SubscriberMethod("onBgInitialize", BgInitializeSDKEvent.class, "#com.growingio.android.sdk.autoburry.AutoBuryObservableInitialize#onBgInitialize(com.growingio.android.sdk.base.event.BgInitializeSDKEvent", threadMode, 0, false)};
    }
}
