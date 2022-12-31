package com.growingio.android.sdk.debugger;

import android.content.Context;
import android.net.Uri;
import com.growingio.android.sdk.base.event.SocketEvent;
import com.growingio.android.sdk.base.event.SocketStatusEvent;
import com.growingio.android.sdk.base.event.net.NetWorkChangedEvent;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.DeviceUUIDFactory;
import com.growingio.android.sdk.debugger.event.ExitAndKillAppEvent;
import com.growingio.android.sdk.debugger.view.CircleTipView;
import com.growingio.android.sdk.interfaces.SocketInterface;
import com.growingio.android.sdk.ipc.GrowingIOIPC;
import com.growingio.android.sdk.java_websocket.GioProtocol;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.android.sdk.utils.NetworkUtil;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.cp_annotation.Subscribe;
import com.growingio.eventcenter.EventCenter;
import com.growingio.eventcenter.bus.EventBus;
import com.growingio.eventcenter.bus.SubscriberMethod;
import com.growingio.eventcenter.bus.ThreadMode;
import com.growingio.eventcenter.bus.meta.Subscriber;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AbstractSocketAdapter implements DebuggerEventListener, Subscriber {
    private static final String TAG = "GIO.AbstractSocketAdapter";
    private DebuggerEventListener circleManager;
    protected CoreAppState coreAppState;
    protected DebuggerManager debuggerManager;
    protected DeviceUUIDFactory deviceUUIDFactory;
    protected GrowingIOIPC growingIOIPC;
    protected CircleTipView mCircleTipView;
    protected SocketInterface socketInterface;
    private volatile boolean isConnected = false;
    private Queue<String> collectionMessage = new ConcurrentLinkedQueue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.growingio.android.sdk.debugger.AbstractSocketAdapter$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$growingio$android$sdk$base$event$SocketStatusEvent$SocketStatus;

        static {
            int[] iArr = new int[SocketStatusEvent.SocketStatus.values().length];
            $SwitchMap$com$growingio$android$sdk$base$event$SocketStatusEvent$SocketStatus = iArr;
            try {
                iArr[SocketStatusEvent.SocketStatus.EDITOR_READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$SocketStatusEvent$SocketStatus[SocketStatusEvent.SocketStatus.EDITOR_QUIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$SocketStatusEvent$SocketStatus[SocketStatusEvent.SocketStatus.REMOTE_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$SocketStatusEvent$SocketStatus[SocketStatusEvent.SocketStatus.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$SocketStatusEvent$SocketStatus[SocketStatusEvent.SocketStatus.SERVER_STARTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$SocketStatusEvent$SocketStatus[SocketStatusEvent.SocketStatus.CLIENT_QUIT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$growingio$android$sdk$base$event$SocketStatusEvent$SocketStatus[SocketStatusEvent.SocketStatus.HYBRID_MESSAGE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public AbstractSocketAdapter(DebuggerManager debuggerManager) {
        this.debuggerManager = debuggerManager;
        inject();
    }

    private void onServerStarted() {
        int serverPort = getServerPort();
        String str = "ws://" + NetworkUtil.getWifiIp(this.coreAppState.getGlobalContext()) + ":" + serverPort;
        LogUtil.d(TAG, "server started, and wsUrl: " + str);
        CoreInitialize.growingIOIPC().setWsServerUrl("ws://127.0.0.1:" + serverPort);
        onServerStarted(str);
    }

    private void onSocketDisconnectCallback() {
        this.debuggerManager.exit();
    }

    private void onSocketErrorCallback() {
        LogUtil.e(TAG, "设备已断开连接，something wrong,重扫");
        CircleTipView circleTipView = this.mCircleTipView;
        if (circleTipView != null) {
            circleTipView.setError(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessageInternal(String str) {
        synchronized (this.collectionMessage) {
            sendMessageLock(str);
        }
    }

    public void addTipView(Context context) {
    }

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

    public SubscriberMethod[] get$SubscriberMethods() {
        ThreadMode threadMode = ThreadMode.MAIN;
        return new SubscriberMethod[]{new SubscriberMethod("onSocketEvent", SocketEvent.class, "#onSocketEvent(com.growingio.android.sdk.base.event.SocketEvent", ThreadMode.BACKGROUND, 0, false), new SubscriberMethod("onNetChanged", NetWorkChangedEvent.class, "#onNetChanged(com.growingio.android.sdk.base.event.net.NetWorkChangedEvent", threadMode, 0, false), new SubscriberMethod("onSocketStatusEvent", SocketStatusEvent.class, "#onSocketStatusEvent(com.growingio.android.sdk.base.event.SocketStatusEvent", threadMode, 0, false)};
    }

    protected int getServerPort() {
        return this.socketInterface.getPort();
    }

    void inject() {
        this.coreAppState = CoreInitialize.coreAppState();
        this.deviceUUIDFactory = CoreInitialize.deviceUUIDFactory();
        this.growingIOIPC = CoreInitialize.growingIOIPC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnectFailed() {
        LogUtil.d(TAG, "onConnectFailed");
        CircleTipView circleTipView = this.mCircleTipView;
        if (circleTipView != null) {
            circleTipView.setError(true);
            this.mCircleTipView.setContent("ERROR: 建立连接失败");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnected() {
        LogUtil.d(TAG, "onConnected");
        CircleTipView circleTipView = this.mCircleTipView;
        if (circleTipView != null) {
            circleTipView.setError(false);
        }
        new Thread() { // from class: com.growingio.android.sdk.debugger.AbstractSocketAdapter.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (AbstractSocketAdapter.this.collectionMessage) {
                    AbstractSocketAdapter.this.isConnected = true;
                    AbstractSocketAdapter.this.onFirstMessage();
                    for (String str : AbstractSocketAdapter.this.collectionMessage) {
                        AbstractSocketAdapter.this.sendMessageInternal(str);
                    }
                    AbstractSocketAdapter.this.collectionMessage.clear();
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onConnecting() {
    }

    @Override // com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onExit() {
        EventBus.getDefault().unregister(this);
        CircleTipView circleTipView = this.mCircleTipView;
        if (circleTipView != null) {
            if (circleTipView.isShown()) {
                this.mCircleTipView.remove();
            }
            this.mCircleTipView = null;
        }
        SocketInterface socketInterface = this.socketInterface;
        if (socketInterface != null) {
            socketInterface.stopAsync();
            this.socketInterface = null;
        }
        if (this.circleManager != null) {
            EventBus.getDefault().unregister(this.circleManager);
            this.circleManager = null;
        }
    }

    @Override // com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onFirstLaunch(Uri uri) {
        EventCenter.getInstance().register(this);
        DebuggerEventListener debuggerEventListenerByType = this.debuggerManager.getDebuggerEventListenerByType("app");
        this.circleManager = debuggerEventListenerByType;
        if (debuggerEventListenerByType != null) {
            EventCenter.getInstance().register(this.circleManager);
        }
        addTipView(this.coreAppState.getGlobalContext());
        if (this.coreAppState.getResumedActivity() != null) {
            this.mCircleTipView.show();
        }
        ThreadUtils.postOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.debugger.AbstractSocketAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                AbstractSocketAdapter.this.onPluginReady();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFirstMessage() {
        LogUtil.d(TAG, "onFirstMessage");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onHybridMessageFromWeb(JSONObject jSONObject) {
        LogUtil.d(TAG, "onHybridMessageFromWeb: ", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLoadFailed() {
        LogUtil.d(TAG, "onLoadFailed");
        onConnectFailed();
    }

    @Override // com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onLoginSuccess() {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNetChanged(NetWorkChangedEvent netWorkChangedEvent) {
        if (!netWorkChangedEvent.isConnected()) {
            LogUtil.e(TAG, "network disconnected");
            onSocketErrorCallback();
        } else if (NetworkUtil.getWifiIp(this.coreAppState.getGlobalContext()) != null || (this instanceof MobileDebuggerMain)) {
        } else {
            LogUtil.e(TAG, "not wifi connected");
            onSocketErrorCallback();
        }
    }

    @Override // com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onPagePause() {
        CircleTipView circleTipView = this.mCircleTipView;
        if (circleTipView != null) {
            circleTipView.remove();
        }
    }

    @Override // com.growingio.android.sdk.debugger.DebuggerEventListener
    public void onPageResume() {
        CircleTipView circleTipView = this.mCircleTipView;
        if (circleTipView != null) {
            circleTipView.show();
        }
    }

    public void onPluginReady() {
        CircleTipView circleTipView = this.mCircleTipView;
        if (circleTipView != null) {
            circleTipView.setContent("正在建立连接....");
        }
        LogUtil.d(TAG, "onPluginReady");
    }

    protected void onServerStarted(String str) {
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSocketEvent(SocketEvent socketEvent) {
        if (this.socketInterface == null) {
            LogUtil.d(TAG, "onSocketEvent, but not ready, return");
            return;
        }
        SocketEvent.EVENT_TYPE event_type = socketEvent.type;
        if (event_type == SocketEvent.EVENT_TYPE.SEND_DEBUGGER) {
            sendMessage(GioProtocol.sendDebuggerStr(socketEvent.debuggerJson));
        } else if (event_type == SocketEvent.EVENT_TYPE.SEND) {
            sendMessage(socketEvent.message);
        } else if (event_type == SocketEvent.EVENT_TYPE.SCREEN_UPDATE) {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.debugger.AbstractSocketAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    AbstractSocketAdapter.this.sendMessage(GioProtocol.sendScreenUpdate());
                }
            });
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSocketStatusEvent(SocketStatusEvent socketStatusEvent) {
        switch (AnonymousClass4.$SwitchMap$com$growingio$android$sdk$base$event$SocketStatusEvent$SocketStatus[socketStatusEvent.event_type.ordinal()]) {
            case 1:
                onConnected();
                return;
            case 2:
                this.debuggerManager.exit();
                return;
            case 3:
            case 4:
                onSocketErrorCallback();
                return;
            case 5:
                onServerStarted();
                return;
            case 6:
                EventCenter.getInstance().post(new ExitAndKillAppEvent());
                return;
            case 7:
                onHybridMessageFromWeb((JSONObject) socketStatusEvent.obj);
                return;
            default:
                return;
        }
    }

    public final void sendMessage(String str) {
        if (this.isConnected) {
            sendMessageInternal(str);
            return;
        }
        LogUtil.d(TAG, "not connected, and collection: ", str);
        this.collectionMessage.add(str);
    }

    protected void sendMessageLock(String str) {
        SocketInterface socketInterface = this.socketInterface;
        if (socketInterface == null || !socketInterface.isReady()) {
            return;
        }
        this.socketInterface.sendMessage(str);
    }
}
