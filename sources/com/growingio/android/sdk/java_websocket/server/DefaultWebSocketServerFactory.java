package com.growingio.android.sdk.java_websocket.server;

import com.growingio.android.sdk.java_websocket.WebSocket;
import com.growingio.android.sdk.java_websocket.WebSocketAdapter;
import com.growingio.android.sdk.java_websocket.WebSocketImpl;
import com.growingio.android.sdk.java_websocket.drafts.Draft;
import com.growingio.android.sdk.java_websocket.server.WebSocketServer;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
/* loaded from: classes2.dex */
public class DefaultWebSocketServerFactory implements WebSocketServer.WebSocketServerFactory {
    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer.WebSocketServerFactory
    public SocketChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) {
        return socketChannel;
    }

    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer.WebSocketServerFactory, com.growingio.android.sdk.java_websocket.WebSocketFactory
    public /* bridge */ /* synthetic */ WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, List list, Socket socket) {
        return createWebSocket(webSocketAdapter, (List<Draft>) list, socket);
    }

    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer.WebSocketServerFactory, com.growingio.android.sdk.java_websocket.WebSocketFactory
    public WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft, Socket socket) {
        return new WebSocketImpl(webSocketAdapter, draft);
    }

    @Override // com.growingio.android.sdk.java_websocket.server.WebSocketServer.WebSocketServerFactory, com.growingio.android.sdk.java_websocket.WebSocketFactory
    public WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list, Socket socket) {
        return new WebSocketImpl(webSocketAdapter, list);
    }
}
