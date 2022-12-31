package com.tapjoy;
/* loaded from: classes3.dex */
public interface TJActionRequest {
    void cancelled();

    void completed();

    String getRequestId();

    String getToken();
}
