package com.growingio.android.sdk.java_websocket;

import com.growingio.android.sdk.interfaces.SocketInterface;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidFrameException;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshake;
import com.growingio.android.sdk.java_websocket.server.WebSocketServer;
import com.growingio.android.sdk.java_websocket.util.Charsetfunctions;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public abstract class GioWsServer extends WebSocketServer implements SocketInterface {
    private static final String TAG = "GIO.GioWsServer";
    private Framedata framedata;
    protected GioProtocol gioProtocol;
    protected Set<WebSocket> localSockets;
    protected WebSocket remoteSocket;

    public GioWsServer() {
        super(new InetSocketAddress(0));
        this.localSockets = Collections.synchronizedSet(new HashSet());
        this.remoteSocket = null;
    }

    protected boolean isLocal(InetAddress inetAddress) {
        return inetAddress.isLoopbackAddress();
    }

    protected boolean isLocalSocket(WebSocket webSocket) {
        return this.localSockets.contains(webSocket);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRemoteSocket(WebSocket webSocket) {
        return this.remoteSocket == webSocket;
    }

    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer
    public void onClose(WebSocket webSocket, int i2, String str, boolean z) {
        if (isLocalSocket(webSocket)) {
            this.localSockets.remove(webSocket);
            onLocalClose();
            return;
        }
        this.remoteSocket = null;
        onRemoteClose(webSocket);
    }

    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer
    public void onFragment(WebSocket webSocket, Framedata framedata) {
        Framedata framedata2 = this.framedata;
        if (framedata2 == null) {
            this.framedata = framedata;
        } else {
            try {
                framedata2.append(framedata);
            } catch (InvalidFrameException unused) {
                this.framedata = null;
                return;
            }
        }
        if (framedata.isFin()) {
            try {
                onMessage(webSocket, Charsetfunctions.stringUtf8(this.framedata.getPayloadData()));
            } catch (InvalidDataException e2) {
                e2.printStackTrace();
            }
            this.framedata = null;
        }
    }

    protected void onLocalClose() {
    }

    protected void onLocalConnect(WebSocket webSocket) {
    }

    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        InetSocketAddress remoteSocketAddress = webSocket.getRemoteSocketAddress();
        PrintStream printStream = System.out;
        printStream.println("onOpen: " + remoteSocketAddress);
        if (isLocal(remoteSocketAddress.getAddress())) {
            this.localSockets.add(webSocket);
            onLocalConnect(webSocket);
            return;
        }
        if (this.remoteSocket != null) {
            System.err.println("remoteSocket is not null, something oop..");
        }
        this.remoteSocket = webSocket;
        onRemoteConnect(webSocket);
    }

    protected void onRemoteClose(WebSocket webSocket) {
    }

    protected void onRemoteConnect(WebSocket webSocket) {
    }

    public boolean sendMessage(String str) {
        WebSocket webSocket = this.remoteSocket;
        if (webSocket != null) {
            try {
                webSocket.send(this.gioProtocol.dealWithOldVersionSDK(str));
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public void setGioProtocol(Object obj) {
        this.gioProtocol = (GioProtocol) obj;
    }
}
