package com.qiniu.android.dns;
/* loaded from: classes3.dex */
public final class NetworkInfo {
    public static final NetworkInfo a = new NetworkInfo(NetSatus.NO_NETWORK, 0);

    /* loaded from: classes3.dex */
    public enum NetSatus {
        NO_NETWORK,
        WIFI,
        MOBILE
    }

    static {
        NetSatus netSatus = NetSatus.WIFI;
    }

    public NetworkInfo(NetSatus netSatus, int i2) {
    }
}
