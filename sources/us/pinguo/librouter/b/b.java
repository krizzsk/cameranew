package us.pinguo.librouter.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import us.pinguo.librouter.b.c.d;
/* compiled from: LibManager.java */
/* loaded from: classes5.dex */
public class b {
    private static Map<String, a> a = new HashMap();

    private static a a(String str, Class<? extends a> cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a aVar = a.get(str);
        if (aVar != null) {
            return aVar;
        }
        synchronized (str.intern()) {
            a aVar2 = a.get(str);
            if (aVar2 != null) {
                return aVar2;
            }
            a aVar3 = (a) Class.forName(str).newInstance();
            if (aVar3 != null) {
                a.put(str, aVar3);
            }
            return aVar3;
        }
    }

    public static us.pinguo.librouter.b.c.a b() {
        return (us.pinguo.librouter.b.c.a) a("us.pinguo.location.LocationLib", d.class);
    }
}
