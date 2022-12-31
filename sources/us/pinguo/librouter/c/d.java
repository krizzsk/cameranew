package us.pinguo.librouter.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ModuleManager.java */
/* loaded from: classes5.dex */
public class d {
    private static Map<String, b> a = new HashMap();

    private static b a(String str, Class<? extends b> cls) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        b bVar = a.get(str);
        if (bVar != null) {
            return bVar;
        }
        synchronized (str.intern()) {
            b bVar2 = a.get(str);
            if (bVar2 != null) {
                return bVar2;
            }
            try {
                bVar2 = (b) Class.forName(str).newInstance();
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    bVar2 = cls.newInstance();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (bVar2 != null) {
                a.put(str, bVar2);
            }
            return bVar2;
        }
    }

    public static us.pinguo.librouter.module.camera.d b() {
        return (us.pinguo.librouter.module.camera.d) a("us.pinguo.camera360.module.CameraModule", us.pinguo.librouter.module.camera.b.class);
    }

    public static us.pinguo.librouter.module.inspire.a c() {
        try {
            return (us.pinguo.librouter.module.inspire.a) a("us.pinguo.inspire.router.InspireModule", Class.forName("us.pinguo.inspire_proxy.b.a.b"));
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
