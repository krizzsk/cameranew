package com.growingio.android.sdk.java_websocket;

import com.growingio.android.sdk.base.event.SocketStatusEvent;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.eventcenter.EventCenter;
import java.io.PrintStream;
/* loaded from: classes2.dex */
abstract class SocketMain extends GioWsServer {
    private static final String TAG = "GIO.SocketMain";

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public boolean isReady() {
        return this.gioProtocol.isReady();
    }

    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer
    public void onError(WebSocket webSocket, Exception exc) {
        if (isRemoteSocket(webSocket)) {
            this.gioProtocol.setReady(false);
            EventCenter.getInstance().post(SocketStatusEvent.ofStatusAndObj(SocketStatusEvent.SocketStatus.ERROR, exc));
            return;
        }
        exc.printStackTrace();
    }

    @Override // com.growingio.android.sdk.java_websocket.GioWsServer
    protected void onLocalConnect(WebSocket webSocket) {
        if (this.gioProtocol.isReady()) {
            LogUtil.d(TAG, "onLocalConnect, and fake Ready Message");
            this.gioProtocol.fakeEditorReadyMessage(webSocket);
        }
    }

    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer
    public void onMessage(WebSocket webSocket, String str) {
        if (isRemoteSocket(webSocket)) {
            this.gioProtocol.onMessage(str);
            return;
        }
        WebSocket webSocket2 = this.remoteSocket;
        boolean z = webSocket2 != null && webSocket2.isOpen();
        PrintStream printStream = System.out;
        printStream.println("多进程消息(" + z + "): " + str);
        if (z) {
            this.remoteSocket.send(str);
        }
        if (this.gioProtocol.isClientQuit(this.gioProtocol.parseMsgId(str))) {
            for (WebSocket webSocket3 : this.localSockets) {
                if (webSocket3 != webSocket && !webSocket3.isClosed()) {
                    webSocket3.send(str);
                }
            }
            EventCenter.getInstance().post(SocketStatusEvent.ofStatus(SocketStatusEvent.SocketStatus.CLIENT_QUIT));
        }
    }

    @Override // com.growingio.android.sdk.java_websocket.GioWsServer
    protected void onRemoteClose(WebSocket webSocket) {
        EventCenter.getInstance().post(SocketStatusEvent.ofStatus(SocketStatusEvent.SocketStatus.REMOTE_CLOSE));
    }

    @Override // com.growingio.android.sdk.java_websocket.GioWsServer
    protected void onRemoteConnect(WebSocket webSocket) {
        throw new IllegalStateException("should not have remote connect");
    }

    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer
    public void onServerStarted() {
        EventCenter.getInstance().post(SocketStatusEvent.ofStatus(SocketStatusEvent.SocketStatus.SERVER_STARTED));
    }

    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer, com.growingio.android.sdk.interfaces.SocketInterface
    public void start() {
        if (this.gioProtocol != null) {
            super.start();
            return;
        }
        throw new IllegalStateException("you must init all properties");
    }

    public void stopAsync() {
        new Thread() { // from class: com.growingio.android.sdk.java_websocket.SocketMain.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                SocketMain socketMain;
                WebSocket webSocket;
                try {
                    if (SocketMain.this.isReady() && (webSocket = (socketMain = SocketMain.this).remoteSocket) != null) {
                        socketMain.gioProtocol.sendQuitMessage(webSocket);
                    }
                    SocketMain.this.stop();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }.start();
    }
}
