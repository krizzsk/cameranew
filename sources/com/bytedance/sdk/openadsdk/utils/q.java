package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.growingio.android.sdk.collection.Constants;
import com.tapjoy.TapjoyConstants;
/* compiled from: NetworkUtils.java */
/* loaded from: classes.dex */
public class q {
    public static boolean a(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int b(Context context) {
        int c = c(context);
        if (c != 1) {
            if (c != 4) {
                if (c != 5) {
                    return c;
                }
                return 4;
            }
            return 1;
        }
        return 0;
    }

    public static int c(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        return 5;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (!TextUtils.isEmpty(subtypeName)) {
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                                if (subtypeName.equalsIgnoreCase("CDMA2000")) {
                                }
                            }
                            return 3;
                        }
                        return 1;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static boolean d(Context context) {
        return c(context) == 4;
    }

    public static boolean e(Context context) {
        return c(context) == 5;
    }

    public static String f(Context context) {
        int c = c(context);
        return c != 2 ? c != 3 ? c != 4 ? c != 5 ? TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE : "4g" : "wifi" : "3g" : "2g";
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith(Constants.HTTP_PROTOCOL_PREFIX) || str.startsWith(Constants.HTTPS_PROTOCOL_PREFIX));
    }
}
