package us.pinguo.common.network.common.toolbox;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
/* loaded from: classes4.dex */
public final class NetworkUtils {
    public static final int NETWORK_2G = 2;
    public static final int NETWORK_3G = 4;
    public static final int NETWORK_4G = 8;
    public static final String NETWORK_TYPE_2G = "2G";
    public static final String NETWORK_TYPE_3G = "3G";
    public static final String NETWORK_TYPE_4G = "4G";
    public static final String NETWORK_TYPE_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final int NETWORK_UNKNOWN = 16;
    public static final int NETWORK_WIFI = 1;
    private static final String TAG = "NetworkUtils";

    private NetworkUtils() {
        throw new UnsupportedOperationException();
    }

    public static int currentNetType(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return 16;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        int networkClass = getNetworkClass(((TelephonyManager) context.getSystemService("phone")).getNetworkType());
        return (networkClass == 4 || networkClass == 8) ? 4 : 16;
    }

    private static int getNetworkClass(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
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
                return 4;
            case 13:
                return 8;
            default:
                return 16;
        }
    }

    public static String getNetworkType(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return "unknown";
        }
        int type = networkInfo.getType();
        if (type == 1) {
            return "wifi";
        }
        if (type == 0) {
            switch (networkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
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
                    return "unknown";
            }
        }
        return "unknown";
    }

    public static boolean hasInternet(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean isAvailableNetWork(Context context) {
        return isAvailableNetWork((ConnectivityManager) context.getSystemService("connectivity"));
    }

    public static boolean isAvailableNetWork(ConnectivityManager connectivityManager) {
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo == null || !networkInfo.isConnected()) {
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            return networkInfo2 != null && networkInfo2.isConnected();
        }
        return true;
    }
}
