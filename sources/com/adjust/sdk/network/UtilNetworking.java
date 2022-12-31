package com.adjust.sdk.network;

import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes.dex */
public class UtilNetworking {
    private static String userAgent;

    /* loaded from: classes.dex */
    public interface IConnectionOptions {
        void applyConnectionOptions(HttpsURLConnection httpsURLConnection, String str);
    }

    /* loaded from: classes.dex */
    public interface IHttpsURLConnectionProvider {
        HttpsURLConnection generateHttpsURLConnection(URL url) throws IOException;
    }

    public static IConnectionOptions createDefaultConnectionOptions() {
        return new IConnectionOptions() { // from class: com.adjust.sdk.network.UtilNetworking.1
            @Override // com.adjust.sdk.network.UtilNetworking.IConnectionOptions
            public void applyConnectionOptions(HttpsURLConnection httpsURLConnection, String str) {
                httpsURLConnection.setRequestProperty("Client-SDK", str);
                httpsURLConnection.setConnectTimeout(60000);
                httpsURLConnection.setReadTimeout(60000);
                if (UtilNetworking.userAgent != null) {
                    httpsURLConnection.setRequestProperty(HttpRequest.HEADER_USER_AGENT, UtilNetworking.userAgent);
                }
            }
        };
    }

    public static IHttpsURLConnectionProvider createDefaultHttpsURLConnectionProvider() {
        return new IHttpsURLConnectionProvider() { // from class: com.adjust.sdk.network.UtilNetworking.2
            @Override // com.adjust.sdk.network.UtilNetworking.IHttpsURLConnectionProvider
            public HttpsURLConnection generateHttpsURLConnection(URL url) throws IOException {
                return (HttpsURLConnection) url.openConnection();
            }
        };
    }

    public static Long extractJsonLong(JSONObject jSONObject, String str) {
        Object opt = jSONObject.opt(str);
        if (opt instanceof Long) {
            return (Long) opt;
        }
        if (opt instanceof Number) {
            return Long.valueOf(((Number) opt).longValue());
        }
        if (opt instanceof String) {
            try {
                return Long.valueOf((long) Double.parseDouble((String) opt));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    public static String extractJsonString(JSONObject jSONObject, String str) {
        Object opt = jSONObject.opt(str);
        if (opt instanceof String) {
            return (String) opt;
        }
        if (opt != null) {
            return opt.toString();
        }
        return null;
    }

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    public static void setUserAgent(String str) {
        userAgent = str;
    }
}
