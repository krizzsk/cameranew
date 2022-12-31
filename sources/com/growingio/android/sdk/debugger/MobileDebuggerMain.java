package com.growingio.android.sdk.debugger;

import android.content.Context;
import android.net.Uri;
import com.growingio.android.sdk.base.event.CircleEvent;
import com.growingio.android.sdk.base.event.SocketEvent;
import com.growingio.android.sdk.base.event.SocketStatusEvent;
import com.growingio.android.sdk.base.event.net.NetWorkChangedEvent;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.NetworkConfig;
import com.growingio.android.sdk.debugger.view.DebuggerCircleTipView;
import com.growingio.android.sdk.interfaces.SocketInterface;
import com.growingio.android.sdk.java_websocket.DebuggerSocketMain;
import com.growingio.android.sdk.java_websocket.GioProtocol;
import com.growingio.android.sdk.pending.PendingStatus;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
/* loaded from: classes2.dex */
public class MobileDebuggerMain extends AbstractSocketAdapter implements Subscriber {
    private static final String TAG = "GIO.MobileDebuggerMain";
    private String wsUrl;

    public MobileDebuggerMain(DebuggerManager debuggerManager) {
        super(debuggerManager);
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    public void addTipView(Context context) {
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
        String projectId = this.coreAppState.getProjectId();
        if (PendingStatus.isDataCheckEnable()) {
            this.wsUrl = NetworkConfig.getInstance().getWsDataCheckUrl(uri.getQueryParameter("wsHost"), projectId, uri.getQueryParameter("dataCheckRoomNumber"));
        } else {
            this.wsUrl = String.format(NetworkConfig.getInstance().getWSEndPointFormatter(), projectId, uri.getQueryParameter("circleRoomNumber"));
        }
        this.mCircleTipView.setContent("正在准备MobileDebugger(初始化)....");
        EventCenter.getInstance().post(new CircleEvent("defaultListener"));
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    protected void onFirstMessage() {
        super.onFirstMessage();
        SocketInterface socketInterface = this.socketInterface;
        if (socketInterface != null) {
            socketInterface.sendMessage(GioProtocol.sendDebuggerInit());
        }
    }

    @Override // com.growingio.android.sdk.debugger.AbstractSocketAdapter
    public void onPluginReady() {
        super.onPluginReady();
        onConnecting();
        try {
            DebuggerSocketMain debuggerSocketMain = new DebuggerSocketMain(this.wsUrl, CoreInitialize.config().isMultiProcessEnabled());
            this.socketInterface = debuggerSocketMain;
            debuggerSocketMain.setGioProtocol(new GioProtocol());
            this.socketInterface.start();
        } catch (Exception e2) {
            LogUtil.e(TAG, e2.getMessage(), e2);
            onLoadFailed();
        }
    }
}
