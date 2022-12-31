package com.growingio.android.sdk.java_websocket;

import com.growingio.android.sdk.base.event.SocketStatusEvent;
import com.growingio.android.sdk.interfaces.SocketInterface;
import com.growingio.android.sdk.java_websocket.client.WebSocketClient;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshake;
import com.growingio.android.sdk.utils.LogUtil;
import com.growingio.eventcenter.EventCenter;
import com.tapjoy.TJAdUnitConstants;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes2.dex */
public class GioNonMainProcessSocketClient extends WebSocketClient implements SocketInterface {
    private static final String TAG = "GIO.NonMainSocket";
    private GioProtocol gioProtocol;

    public GioNonMainProcessSocketClient(String str) throws URISyntaxException {
        super(new URI(str));
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public int getPort() {
        return 0;
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public boolean isReady() {
        return this.gioProtocol.isReady();
    }

    @Override // com.growingio.android.sdk.java_websocket.client.WebSocketClient
    public void onClose(int i2, String str, boolean z) {
        LogUtil.d(TAG, "onClose, code=", Integer.valueOf(i2), ", reason=", str, ", remote=", Boolean.valueOf(z));
    }

    @Override // com.growingio.android.sdk.java_websocket.client.WebSocketClient
    public void onError(Exception exc) {
        LogUtil.e(TAG, "onError", exc);
        EventCenter.getInstance().post(SocketStatusEvent.ofStatusAndObj(SocketStatusEvent.SocketStatus.ERROR, exc));
    }

    @Override // com.growingio.android.sdk.java_websocket.client.WebSocketClient
    public void onMessage(String str) {
        this.gioProtocol.onMessage(str);
    }

    @Override // com.growingio.android.sdk.java_websocket.client.WebSocketClient
    public void onOpen(ServerHandshake serverHandshake) {
        LogUtil.d(TAG, TJAdUnitConstants.String.ANIMATION_EVENT_ON_OPEN);
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public boolean sendMessage(String str) {
        try {
            send(this.gioProtocol.dealWithOldVersionSDK(str));
            return true;
        } catch (Exception e2) {
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
            connect();
            return;
        }
        throw new IllegalStateException("must call setGioProtocol before start");
    }

    @Override // com.growingio.android.sdk.interfaces.SocketInterface
    public void stopAsync() {
        if (isReady()) {
            this.gioProtocol.sendQuitMessage(this);
        }
        close();
    }
}
