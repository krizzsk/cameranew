package com.growingio.android.sdk.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
/* loaded from: classes2.dex */
public class NetworkUtil {
    public static final String NETWORK_2G = "2G";
    public static final String NETWORK_3G = "3G";
    public static final String NETWORK_4G = "4G";
    public static final String NETWORK_UNKNOWN = "UNKNOWN";
    public static final String NETWORK_WIFI = "WIFI";

    public static String decode(@Nullable String str) {
        if (str != null) {
            try {
                return URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                LogUtil.d("NetWorkUtil", e2);
                return "";
            }
        }
        return "";
    }

    public static String encode(@Nullable String str) {
        if (str != null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                LogUtil.d("NetWorkUtil", e2);
                return "";
            }
        }
        return "";
    }

    public static String getMobileNetworkTypeName(int i2, String str) {
        switch (i2) {
            case 1:
            case 2:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return TextUtils.isEmpty(str) ? NETWORK_UNKNOWN : (str.equalsIgnoreCase("TD-SCDMA") || str.equalsIgnoreCase("WCDMA") || str.equalsIgnoreCase("CDMA2000")) ? "3G" : NETWORK_UNKNOWN;
        }
    }

    public static String getWifiIp(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null && !TextUtils.isEmpty(connectionInfo.getSSID())) {
            InetAddress inetAddress = (InetAddress) ReflectUtil.findFieldRecur(connectionInfo, "mIpAddress");
            if (inetAddress instanceof Inet4Address) {
                return inetAddress.getHostAddress();
            }
            if (inetAddress instanceof Inet6Address) {
                return inetAddress.getHostAddress();
            }
        }
        return null;
    }
}
