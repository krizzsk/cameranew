package com.bytedance.sdk.adnet.d;

import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.i;
import com.bytedance.sdk.adnet.core.o;
import com.bytedance.sdk.adnet.face.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import us.pinguo.common.network.HttpRequest;
/* compiled from: HttpHeaderParser.java */
/* loaded from: classes.dex */
public class b {
    public static a.C0044a a(i iVar) {
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = iVar.c;
        String str = map.get(HttpRequest.HEADER_DATE);
        long a = str != null ? a(str) : 0L;
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
        long a2 = str3 != null ? a(str3) : 0L;
        String str4 = map.get(HttpRequest.HEADER_LAST_MODIFIED);
        long a3 = str4 != null ? a(str4) : 0L;
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
            if (a <= 0 || a2 < a) {
                j5 = 0;
            } else {
                j5 = currentTimeMillis + (a2 - a);
                j4 = j5;
            }
        }
        a.C0044a c0044a = new a.C0044a();
        c0044a.a = iVar.a;
        c0044a.b = iVar.b;
        c0044a.c = str5;
        c0044a.f1264g = j5;
        c0044a.f1263f = j4;
        c0044a.f1261d = a;
        c0044a.f1262e = a3;
        c0044a.f1265h = map;
        c0044a.f1266i = iVar.f1243d;
        return c0044a;
    }

    public static List<Header> b(Map<String, String> map) {
        if (map == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static long a(String str) {
        try {
            return a().parse(str).getTime();
        } catch (Throwable th) {
            o.a(th, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static String a(long j2) {
        return a().format(new Date(j2));
    }

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get(HttpRequest.HEADER_CONTENT_TYPE);
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

    public static String a(Map<String, String> map) {
        return a(map, "UTF-8");
    }

    public static Map<String, String> a(List<Header> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        if (list != null) {
            for (Header header : list) {
                treeMap.put(header.getName(), header.getValue());
            }
        }
        return treeMap;
    }
}
