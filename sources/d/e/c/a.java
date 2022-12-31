package d.e.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
/* compiled from: ConnectivityService.java */
/* loaded from: classes2.dex */
public class a {
    public static String a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        StringBuilder sb = new StringBuilder();
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                sb.append("3g");
            } else if (type == 1) {
                sb.append("wifi");
            } else {
                sb.append(typeName);
            }
        }
        return sb.toString();
    }

    public static int b(Context context) {
        if (context != null) {
            try {
                return context.getResources().getConfiguration().mcc;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public static int c(Context context) {
        if (context != null) {
            try {
                return context.getResources().getConfiguration().mnc;
            } catch (Exception e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public static int d(Context context) {
        if (context != null) {
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return -1;
    }

    public static String e(Context context) {
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                return telephonyManager != null ? telephonyManager.getSimOperator() : "";
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return "";
    }

    public static boolean f(Context context) {
        NetworkInfo activeNetworkInfo;
        return (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }
}
