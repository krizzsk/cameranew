package com.growingio.android.sdk.java_websocket;

import com.growingio.android.sdk.base.event.SocketStatusEvent;
import com.growingio.android.sdk.interfaces.SocketInterface;
import com.growingio.android.sdk.java_websocket.client.WebSocketClient;
import com.growingio.android.sdk.java_websocket.exceptions.WebsocketNotConnectedException;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshake;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.eventcenter.EventCenter;
import com.tapjoy.TJAdUnitConstants;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.channels.NotYetConnectedException;
import javax.net.ssl.SSLContext;
/* loaded from: classes2.dex */
public class DebuggerSocketMain extends WebSocketClient implements SocketInterface {
    private static final String TAG = "GrowingIO.WebCircleSocket";
    private DebuggerServer debuggerServer;
    private GioProtocol gioProtocol;

    /* loaded from: classes2.dex */
    private static class DebuggerServer extends SocketMain {
        private final boolean fakeServer;

        @Override // com.growingio.android.sdk.java_websocket.GioWsServer, com.growingio.android.sdk.interfaces.SocketInterface
        public boolean sendMessage(String str) {
            return !this.fakeServer && super.sendMessage(str);
        }

        public void setRemoteSocket(WebSocket webSocket) {
            this.remoteSocket = webSocket;
        }

        @Override // com.growingio.android.sdk.java_websocket.SocketMain, com.growingio.android.sdk.java_websocket.server.WebSocketServer, com.growingio.android.sdk.interfaces.SocketInterface
        public void start() {
            if (this.fakeServer) {
                return;
            }
            super.start();
        }

        @Override // com.growingio.android.sdk.java_websocket.SocketMain, com.growingio.android.sdk.interfaces.SocketInterface
        public void stopAsync() {
            if (!this.fakeServer) {
                super.stopAsync();
            } else {
                this.gioProtocol.setReady(false);
            }
        }

        private DebuggerServer(boolean z) {
            this.fakeServer = z;
        }
    }

    public DebuggerSocketMain(String str, boolean z) throws URISyntaxException {
        super(new URI(str));
        if (str.startsWith("wss")) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                setSocket(sSLContext.getSocketFactory().createSocket());
            } catch (Exception e2) {
                LogUtil.e(TAG, "start ssl failed: ", e2);
                EventCenter.getInstance().post(SocketStatusEvent.ofStatusAndObj(SocketStatusEvent.SocketStatus.ERROR, e2));
            }
        }
        this.debuggerServer = new DebuggerServer(!z);
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public int getPort() {
        return this.debuggerServer.getPort();
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public boolean isReady() {
        return this.gioProtocol.isReady();
    }

    @Override // com.growingio.android.sdk.java_websocket.client.WebSocketClient
    public void onClose(int i2, String str, boolean z) {
        LogUtil.d(TAG, "onClose, code=", Integer.valueOf(i2), ", reason=", str, ", remote=", Boolean.valueOf(z));
        this.gioProtocol.stopSendHeartbeat();
    }

    @Override // com.growingio.android.sdk.java_websocket.client.WebSocketClient
    public void onError(Exception exc) {
        PrintStream printStream = System.err;
        printStream.println("onError: " + exc);
        this.gioProtocol.stopSendHeartbeat();
        this.debuggerServer.onError(this, exc);
    }

    @Override // com.growingio.android.sdk.java_websocket.client.WebSocketClient
    public void onMessage(String str) {
        this.debuggerServer.onMessage(this, str);
    }

    @Override // com.growingio.android.sdk.java_websocket.client.WebSocketClient
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println(TJAdUnitConstants.String.ANIMATION_EVENT_ON_OPEN);
        this.debuggerServer.setRemoteSocket(this);
        this.gioProtocol.sendAndroidInitMessage(this);
        this.gioProtocol.startSendHeartbeat(this);
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public boolean sendMessage(String str) {
        try {
            send(str);
            return true;
        } catch (WebsocketNotConnectedException | NotYetConnectedException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public void setGioProtocol(Object obj) {
        this.gioProtocol = (GioProtocol) obj;
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public void start() {
        if (this.gioProtocol != null) {
            PrintStream printStream = System.out;
            printStream.println("start: uri=" + getURI());
            connect();
            this.debuggerServer.setGioProtocol(this.gioProtocol);
            this.debuggerServer.start();
            return;
        }
        throw new IllegalStateException("must called setCallback and setGioProtocol first");
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public void stopAsync() {
        if (isReady()) {
            this.gioProtocol.sendQuitMessage(this);
        }
        this.debuggerServer.stopAsync();
        close();
    }
}
