package us.pinguo.foundation.m;

import android.net.Uri;
import java.util.Map;
import us.pinguo.util.o;
/* compiled from: PgHttpParamSig.java */
/* loaded from: classes4.dex */
public class d {
    public static String a(Map<String, String> map) {
        return o.e(map, "*jNb29>,1*)4`:\\Bo)023&3MnvQ14Lk@");
    }

    public static void b(Map<String, String> map) {
        map.put("sig", a(map));
    }

    public static void c(Map<String, String> map, String str) {
        map.put("sig", o.e(map, str));
    }

    public static void d(String str, int i2, Map<String, String> map, String str2) {
        try {
            Uri parse = Uri.parse(str);
            for (String str3 : parse.getQueryParameterNames()) {
                map.put(str3, parse.getQueryParameter(str3));
            }
            str = parse.getPath();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        map.put("PG-Sign", o.b(str, i2 == 1 ? "POST" : i2 == 0 ? "GET" : "", map, str2));
    }
}
