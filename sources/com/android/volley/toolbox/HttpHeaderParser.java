package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import us.pinguo.common.network.HttpRequest;
/* loaded from: classes.dex */
public class HttpHeaderParser {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String RFC1123_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String formatEpochAsRfc1123(long j2) {
        return newRfc1123Formatter().format(new Date(j2));
    }

    private static SimpleDateFormat newRfc1123Formatter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RFC1123_FORMAT, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static Cache.Entry parseCacheHeaders(NetworkResponse networkResponse) {
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = networkResponse.headers;
        String str = map.get(HttpRequest.HEADER_DATE);
        long parseDateAsEpoch = str != null ? parseDateAsEpoch(str) : 0L;
        String str2 = map.get(HttpRequest.HEADER_CACHE_CONTROL);
        int i2 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            int i3 = 0;
            j2 = 0;
            j3 = 0;
            while (i2 < split.length) {
                String trim = split[i2].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i3 = 1;
                }
                i2++;
            }
            i2 = i3;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j3 = 0;
        }
        String str3 = map.get(HttpRequest.HEADER_EXPIRES);
        long parseDateAsEpoch2 = str3 != null ? parseDateAsEpoch(str3) : 0L;
        String str4 = map.get(HttpRequest.HEADER_LAST_MODIFIED);
        long parseDateAsEpoch3 = str4 != null ? parseDateAsEpoch(str4) : 0L;
        String str5 = map.get(HttpRequest.HEADER_ETAG);
        if (z) {
            j5 = currentTimeMillis + (j2 * 1000);
            if (i2 != 0) {
                j6 = j5;
            } else {
                Long.signum(j3);
                j6 = (j3 * 1000) + j5;
            }
            j4 = j6;
        } else {
            j4 = 0;
            if (parseDateAsEpoch <= 0 || parseDateAsEpoch2 < parseDateAsEpoch) {
                j5 = 0;
            } else {
                j5 = currentTimeMillis + (parseDateAsEpoch2 - parseDateAsEpoch);
                j4 = j5;
            }
        }
        Cache.Entry entry = new Cache.Entry();
        entry.data = networkResponse.data;
        entry.etag = str5;
        entry.softTtl = j5;
        entry.ttl = j4;
        entry.serverDate = parseDateAsEpoch;
        entry.lastModified = parseDateAsEpoch3;
        entry.responseHeaders = map;
        entry.allResponseHeaders = networkResponse.allHeaders;
        return entry;
    }

    public static String parseCharset(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";", 0);
            for (int i2 = 1; i2 < split.length; i2++) {
                String[] split2 = split[i2].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals(HttpRequest.PARAM_CHARSET)) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static long parseDateAsEpoch(String str) {
        try {
            return newRfc1123Formatter().parse(str).getTime();
        } catch (ParseException e2) {
            VolleyLog.e(e2, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Header> toAllHeaderList(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> toHeaderMap(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header header : list) {
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }

    public static String parseCharset(Map<String, String> map) {
        return parseCharset(map, DEFAULT_CONTENT_CHARSET);
    }
}
