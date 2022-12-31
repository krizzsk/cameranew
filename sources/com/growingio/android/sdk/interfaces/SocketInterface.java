package com.growingio.android.sdk.interfaces;
/* loaded from: classes2.dex */
public interface SocketInterface {
    int getPort();

    boolean isReady();

    boolean sendMessage(String str);

    void setGioProtocol(Object obj);

    void start();

    void stopAsync();
}
