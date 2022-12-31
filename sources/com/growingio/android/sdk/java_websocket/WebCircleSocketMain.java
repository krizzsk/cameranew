package com.growingio.android.sdk.java_websocket;
/* loaded from: classes2.dex */
public class WebCircleSocketMain extends SocketMain {
    @Override // com.growingio.android.sdk.java_websocket.SocketMain, com.growingio.android.sdk.interfaces.SocketInterface
    public /* bridge */ /* synthetic */ boolean isReady() {
        return super.isReady();
    }

    @Override // com.growingio.android.sdk.java_websocket.SocketMain, com.growingio.android.sdk.java_websocket.server.WebSocketServer
    public /* bridge */ /* synthetic */ void onError(WebSocket webSocket, Exception exc) {
        super.onError(webSocket, exc);
    }

    @Override // com.growingio.android.sdk.java_websocket.SocketMain, com.growingio.android.sdk.java_websocket.server.WebSocketServer
    public /* bridge */ /* synthetic */ void onMessage(WebSocket webSocket, String str) {
        super.onMessage(webSocket, str);
    }

    @Override // com.growingio.android.sdk.java_websocket.SocketMain, com.growingio.android.sdk.java_websocket.GioWsServer
    protected void onRemoteConnect(WebSocket webSocket) {
        System.out.println("onRemoteConnect");
        this.gioProtocol.sendAndroidInitMessage(webSocket);
    }

    @Override // com.growingio.android.sdk.java_websocket.SocketMain, com.growingio.android.sdk.java_websocket.server.WebSocketServer
    public /* bridge */ /* synthetic */ void onServerStarted() {
        super.onServerStarted();
    }

    @Override // com.growingio.android.sdk.java_websocket.SocketMain, com.growingio.android.sdk.java_websocket.server.WebSocketServer, com.growingio.android.sdk.interfaces.SocketInterface
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.growingio.android.sdk.java_websocket.SocketMain, com.growingio.android.sdk.interfaces.SocketInterface
    public /* bridge */ /* synthetic */ void stopAsync() {
        super.stopAsync();
    }
}
