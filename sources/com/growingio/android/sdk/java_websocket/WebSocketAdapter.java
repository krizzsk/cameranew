package com.growingio.android.sdk.java_websocket;

import com.growingio.android.sdk.java_websocket.drafts.Draft;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidHandshakeException;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import com.growingio.android.sdk.java_websocket.framing.FramedataImpl1;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshake;
import com.growingio.android.sdk.java_websocket.handshake.HandshakeImpl1Server;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshake;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshakeBuilder;
import java.net.InetSocketAddress;
/* loaded from: classes2.dex */
public abstract class WebSocketAdapter implements WebSocketListener {
    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public String getFlashPolicy(WebSocket webSocket) throws InvalidDataException {
        InetSocketAddress localSocketAddress = webSocket.getLocalSocketAddress();
        if (localSocketAddress != null) {
            StringBuffer stringBuffer = new StringBuffer(90);
            stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
            stringBuffer.append(localSocketAddress.getPort());
            stringBuffer.append("\" /></cross-domain-policy>\u0000");
            return stringBuffer.toString();
        }
        throw new InvalidHandshakeException("socket not bound");
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public void onWebsocketHandshakeReceivedAsClient(WebSocket webSocket, ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidDataException {
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public ServerHandshakeBuilder onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) throws InvalidDataException {
        return new HandshakeImpl1Server();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public void onWebsocketHandshakeSentAsClient(WebSocket webSocket, ClientHandshake clientHandshake) throws InvalidDataException {
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public void onWebsocketPing(WebSocket webSocket, Framedata framedata) {
        FramedataImpl1 framedataImpl1 = new FramedataImpl1(framedata);
        framedataImpl1.setOptcode(Framedata.Opcode.PONG);
        webSocket.sendFrame(framedataImpl1);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public void onWebsocketPong(WebSocket webSocket, Framedata framedata) {
    }
}
