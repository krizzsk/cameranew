package us.pinguo.util;

import com.growingio.android.sdk.utils.NetworkUtil;
/* compiled from: NetworkUtils.kt */
/* loaded from: classes6.dex */
public enum NetworkType {
    NETWORK_UNKNOWN(-1, "unknown"),
    NETWORK_NO(0, "no"),
    NETWORK_2G(1, "2G"),
    NETWORK_3G(2, "3G"),
    NETWORK_4G(3, "4G"),
    NETWORK_5G(4, "5G"),
    NETWORK_6G(6, "6G"),
    NETWORK_WIFI(4, NetworkUtil.NETWORK_WIFI);
    
    private final String networkName;
    private final int networkType;

    NetworkType(int i2, String str) {
        this.networkType = i2;
        this.networkName = str;
    }

    public final String getNetworkName() {
        return this.networkName;
    }

    public final int getNetworkType() {
        return this.networkType;
    }
}
