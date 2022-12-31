package com.growingio.android.sdk.debugger;

import android.content.Context;
import android.net.Uri;
import com.growingio.android.sdk.base.event.CircleEvent;
import com.growingio.android.sdk.base.event.SocketEvent;
import com.growingio.android.sdk.base.event.SocketStatusEvent;
import com.growingio.android.sdk.base.event.net.NetWorkChangedEvent;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.debugger.view.DebuggerCircleTipView;
import com.growingio.android.sdk.java_websocket.GioNonMainProcessSocketClient;
import com.growingio.android.sdk.java_websocket.GioProtocol;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
/* loaded from: classes2.dex */
public class MobileDebuggerNonMain extends AbstractSocketAdapter implements Subscriber {
    private static final String TAG = "GIO.MobileDebuggerNonMain";

    public MobileDebuggerNonMain(DebuggerManager debuggerManager) {
        super(debuggerManager);
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    public void addTipView(Context context) {
        LogUtil.d(TAG, "addTipView");
        this.mCircleTipView = new DebuggerCircleTipView(context);
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter, com.growingio.eventcenter.bus.meta.Subscriber
    public void do$Action(String str, Object obj) {
        if (str.equals("#onSocketEvent(com.growingio.android.sdk.base.event.SocketEvent")) {
            onSocketEvent((SocketEvent) obj);
        } else if (str.equals("#onNetChanged(com.growingio.android.sdk.base.event.net.NetWorkChangedEvent")) {
            onNetChanged((NetWorkChangedEvent) obj);
        } else if (str.equals("#onSocketStatusEvent(com.growingio.android.sdk.base.event.SocketStatusEvent")) {
            onSocketStatusEvent((SocketStatusEvent) obj);
        } else {
            System.out.println("No such method to delegate");
        }
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter, com.growingio.eventcenter.bus.meta.Subscriber
    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.MAIN;
        return new SubscriberMethod[]{new SubscriberMethod("onSocketEvent", SocketEvent.class, "#onSocketEvent(com.growingio.android.sdk.base.event.SocketEvent", ThreadMode.BACKGROUND, 0, false), new SubscriberMethod("onNetChanged", NetWorkChangedEvent.class, "#onNetChanged(com.growingio.android.sdk.base.event.net.NetWorkChangedEvent", threadMode, 0, false), new SubscriberMethod("onSocketStatusEvent", SocketStatusEvent.class, "#onSocketStatusEvent(com.growingio.android.sdk.base.event.SocketStatusEvent", threadMode, 0, false)};
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    protected void onConnected() {
        super.onConnected();
        this.mCircleTipView.doing();
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter, com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onFirstLaunch(Uri uri) {
        super.onFirstLaunch(uri);
        EventCenter.getInstance().post(new CircleEvent("defaultListener"));
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    public void onPluginReady() {
        super.onPluginReady();
        String wsServerUrl = CoreInitialize.growingIOIPC().getWsServerUrl();
        LogUtil.d(TAG, "onPluginReady, and wsUrl is ", wsServerUrl);
        try {
            onConnecting();
            GioNonMainProcessSocketClient gioNonMainProcessSocketClient = new GioNonMainProcessSocketClient(wsServerUrl);
            this.socketInterface = gioNonMainProcessSocketClient;
            gioNonMainProcessSocketClient.setGioProtocol(new GioProtocol());
            this.socketInterface.start();
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
            onLoadFailed();
        }
    }
}
