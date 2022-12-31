package us.pinguo.paylibcenter.n;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* compiled from: NetworkUtils.java */
/* loaded from: classes5.dex */
public final class d {
    private static final String a = "d";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NetworkUtils.java */
    /* loaded from: classes5.dex */
    public static class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    public static String a(List<String> list) {
        if (list != null && list.size() != 0) {
            Collections.sort(list, new a());
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : list) {
                stringBuffer.append(str);
            }
            try {
                String c = e.c(stringBuffer.toString());
                String str2 = a;
                us.pinguo.common.log.a.d(str2, "Get signature for : " + stringBuffer.toString() + " and sig is : " + c, new Object[0]);
                return c;
            } catch (UnsupportedEncodingException e2) {
                us.pinguo.common.log.a.f(e2);
            }
        }
        return "";
    }

    public static String b(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(entry.getKey() + "=" + entry.getValue());
        }
        return a(arrayList);
    }
}
