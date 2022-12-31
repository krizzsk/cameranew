package us.pinguo.inspire.module.comment;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class TransCache {
    private static final int MAX = 10000;
    private static final Map<String, String> cacheMap = new HashMap();

    public static void cache(String str, String str2, String str3) {
        if (str == null || str2 == null) {
            return;
        }
        Map<String, String> map = cacheMap;
        if (map.size() > 10000) {
            map.clear();
        }
        map.put(str + str2, str3);
    }

    public static String get(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        Map<String, String> map = cacheMap;
        return map.get(str + str2);
    }
}
