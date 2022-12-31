package us.pinguo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
/* compiled from: NetworkUtils.kt */
/* loaded from: classes6.dex */
public final class q {
    public static final q a = new q();

    private q() {
    }

    private final NetworkType a(NetworkInfo networkInfo) {
        boolean n;
        boolean n2;
        boolean n3;
        switch (networkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NetworkType.NETWORK_2G;
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
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
            case 19:
                return NetworkType.NETWORK_4G;
            case 16:
            default:
                String subtypeName = networkInfo.getSubtypeName();
                if (subtypeName == null) {
                    return NetworkType.NETWORK_UNKNOWN;
                }
                n = kotlin.text.t.n(subtypeName, "TD-SCDMA", true);
                if (!n) {
                    n2 = kotlin.text.t.n(subtypeName, "WCDMA", true);
                    if (!n2) {
                        n3 = kotlin.text.t.n(subtypeName, "CDMA2000", true);
                        if (!n3) {
                            return NetworkType.NETWORK_UNKNOWN;
                        }
                    }
                }
                return NetworkType.NETWORK_3G;
            case 20:
                return NetworkType.NETWORK_5G;
        }
    }

    public static final NetworkType b(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        return c((ConnectivityManager) context.getSystemService("connectivity"));
    }

    public static final NetworkType c(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        if (!activeNetworkInfo.isAvailable()) {
            return NetworkType.NETWORK_NO;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return NetworkType.NETWORK_UNKNOWN;
            }
            if (networkCapabilities.hasTransport(1)) {
                return NetworkType.NETWORK_WIFI;
            }
            if (networkCapabilities.hasTransport(0)) {
                return NetworkType.NETWORK_4G;
            }
        } else {
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return NetworkType.NETWORK_WIFI;
            }
            if (type == 0) {
                return a.a(activeNetworkInfo);
            }
        }
        return NetworkType.NETWORK_UNKNOWN;
    }

    public static final String d(Context context) {
        NetworkInfo activeNetworkInfo;
        kotlin.jvm.internal.s.h(context, "context");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return null;
        }
        return activeNetworkInfo.getTypeName();
    }

    public static final boolean e(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) (context == null ? null : context.getSystemService("connectivity"));
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static final boolean f(Context context) {
        return g((ConnectivityManager) (context == null ? null : context.getSystemService("connectivity")));
    }

    public static final boolean g(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo;
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    public static final boolean h(Context context) {
        kotlin.jvm.internal.s.h(context, "context");
        return b(context) == NetworkType.NETWORK_WIFI;
    }
}
