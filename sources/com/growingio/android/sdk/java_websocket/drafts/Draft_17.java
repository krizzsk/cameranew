package com.growingio.android.sdk.java_websocket.drafts;

import com.growingio.android.sdk.java_websocket.drafts.Draft;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidHandshakeException;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshake;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshakeBuilder;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class Draft_17 extends Draft_10 {
    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_10, com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft.HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        if (Draft_10.readVersion(clientHandshake) == 13) {
            return Draft.HandshakeState.MATCHED;
        }
        return Draft.HandshakeState.NOT_MATCHED;
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_10, com.growingio.android.sdk.java_websocket.drafts.Draft
    public Draft copyInstance() {
        return new Draft_17();
    }

    @Override // com.growingio.android.sdk.java_websocket.drafts.Draft_10, com.growingio.android.sdk.java_websocket.drafts.Draft
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        super.postProcessHandshakeRequestAsClient(clientHandshakeBuilder);
        clientHandshakeBuilder.put("Sec-WebSocket-Version", Constants.VIA_REPORT_TYPE_JOININ_GROUP);
        return clientHandshakeBuilder;
    }
}
