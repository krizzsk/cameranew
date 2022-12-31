package us.pinguo.foundation.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import us.pinguo.common.network.HttpRequest;
/* compiled from: HttpUtils.java */
/* loaded from: classes4.dex */
public final class p {
    public static String a(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static SSLSocketFactory b() {
        try {
            return HttpRequest.getTrustedFactory();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(String str, Map<String, String> map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        if (map != null && map.size() != 0) {
            if (str.contains("?")) {
                if (sb.charAt(sb.length() - 1) != '?' && sb.charAt(sb.length() - 1) != '&') {
                    sb.append('&');
                }
            } else if (sb.charAt(sb.length() - 1) != '?') {
                sb.append('?');
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append('=');
                if (entry.getValue() != null) {
                    sb.append(a(entry.getValue()));
                }
                sb.append('&');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        int i2 = length - 1;
        if (sb.charAt(i2) == '?') {
            sb.deleteCharAt(i2);
        }
        return sb.toString();
    }
}
