package us.pinguo.inspire.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
/* compiled from: InspireCompareUtils.java */
/* loaded from: classes9.dex */
public class o {
    public static void a(List<?> list) {
        if (list != null) {
            HashMap hashMap = new HashMap();
            for (Object obj : list) {
                if (hashMap.get(Integer.valueOf(obj.hashCode())) == null) {
                    hashMap.put(Integer.valueOf(obj.hashCode()), obj);
                }
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                Object obj2 = list.get(size);
                if (!hashMap.containsValue(obj2)) {
                    list.remove(obj2);
                }
            }
        }
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            com.google.gson.e eVar = new com.google.gson.e();
            String s = eVar.s(obj);
            String s2 = eVar.s(obj2);
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s2)) {
                return s.equals(s2);
            }
        }
        return false;
    }
}
