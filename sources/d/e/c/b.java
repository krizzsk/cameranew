package d.e.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: ConnectivityUtils.java */
/* loaded from: classes2.dex */
public class b {
    @SuppressLint({"MissingPermission"})
    public static Network a(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT < 23 || connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetwork();
    }

    public static String b(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return c(a(context), context);
        }
        return d(context);
    }

    @SuppressLint({"MissingPermission"})
    public static String c(Network network, Context context) {
        String d2;
        if (context == null) {
            return PortalFollowFeeds.TYPE_NONE;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (network == null || connectivityManager == null) {
            return PortalFollowFeeds.TYPE_NONE;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities == null) {
                    return d(context);
                }
                if (networkCapabilities.hasTransport(1)) {
                    d2 = "wifi";
                } else {
                    d2 = networkCapabilities.hasTransport(0) ? "3g" : d(context);
                }
                return d2;
            }
            return d(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            return PortalFollowFeeds.TYPE_NONE;
        }
    }

    private static String d(Context context) {
        String a = a.a(context);
        return TextUtils.isEmpty(a) ? PortalFollowFeeds.TYPE_NONE : a;
    }

    @SuppressLint({"MissingPermission"})
    public static JSONObject e(Context context, Network network) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (Build.VERSION.SDK_INT >= 23 && network != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) != null) {
                    jSONObject.put("networkCapabilities", networkCapabilities.toString());
                    jSONObject.put("downloadSpeed", networkCapabilities.getLinkDownstreamBandwidthKbps());
                    jSONObject.put("uploadSpeed", networkCapabilities.getLinkUpstreamBandwidthKbps());
                    jSONObject.put("hasVPN", g(context));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    @SuppressLint({"MissingPermission"})
    private static String f(Context context, Network network) {
        NetworkCapabilities networkCapabilities;
        if (Build.VERSION.SDK_INT >= 23 && network != null && context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) == null) {
                    return "";
                }
                if (networkCapabilities.hasTransport(1)) {
                    return "wifi";
                }
                if (networkCapabilities.hasTransport(0)) {
                    return "cellular";
                }
                if (networkCapabilities.hasTransport(4)) {
                    return "vpn";
                }
                if (networkCapabilities.hasTransport(3)) {
                    return "ethernet";
                }
                if (networkCapabilities.hasTransport(5)) {
                    return "wifiAware";
                }
                if (networkCapabilities.hasTransport(6)) {
                    return "lowpan";
                }
                if (networkCapabilities.hasTransport(2)) {
                    return "bluetooth";
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static boolean g(Context context) {
        return f(context, a(context)).equals("vpn");
    }
}
