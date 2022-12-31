package com.pinguo.camera360.effect.model.entity.layer;

import com.google.gson.e;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.pinguo.lib.GsonUtilKt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import us.pinguo.common.log.a;
/* loaded from: classes3.dex */
public class LayerEffectUtil {
    private static final String TAG = "LayerEffectUtil";

    public static String combineJsonArray(List<String> list) {
        e cachedGson = GsonUtilKt.getCachedGson();
        String str = TAG;
        a.m(str, "convert2JsonArray1--->" + cachedGson.s(list), new Object[0]);
        return cachedGson.s(list);
    }

    public static Map<Integer, String> convert2Params(String str) {
        HashMap hashMap = new HashMap();
        List list = (List) GsonUtilKt.getCachedGson().k(str, new com.google.gson.t.a<List<HashMap<String, HashMap<String, String>>>>() { // from class: com.pinguo.camera360.effect.model.entity.layer.LayerEffectUtil.2
        }.getType());
        for (int i2 = 0; i2 < list.size(); i2++) {
            for (Map.Entry entry : ((HashMap) list.get(i2)).entrySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append((String) entry.getKey());
                sb.append(";");
                int i3 = 0;
                for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                    if (((String) entry2.getKey()).equals("abc_order_cba")) {
                        i3 = Integer.parseInt((String) entry2.getValue());
                    } else {
                        sb.append((String) entry2.getKey());
                        sb.append("=");
                        sb.append((String) entry2.getValue());
                        sb.append(";");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
                if (hashMap.get(Integer.valueOf(i3)) != null) {
                    hashMap.put(Integer.valueOf(i3), ((String) hashMap.get(Integer.valueOf(i3))) + Effect.DIVIDER + sb.toString());
                } else {
                    hashMap.put(Integer.valueOf(i3), sb.toString());
                }
            }
        }
        return hashMap;
    }

    public static List<String> separateJsonArray(String str) {
        List<String> list = (List) GsonUtilKt.getCachedGson().k(str, new com.google.gson.t.a<List<String>>() { // from class: com.pinguo.camera360.effect.model.entity.layer.LayerEffectUtil.1
        }.getType());
        String str2 = TAG;
        a.m(str2, "convert2StringList1--->" + list, new Object[0]);
        return list;
    }
}
