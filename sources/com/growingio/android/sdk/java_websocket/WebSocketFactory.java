package com.growingio.android.sdk.java_websocket;

import com.growingio.android.sdk.java_websocket.drafts.Draft;
import java.net.Socket;
import java.util.List;
/* loaded from: classes2.dex */
public interface WebSocketFactory {
    WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft, Socket socket);

    WebSocket createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list, Socket socket);
}
