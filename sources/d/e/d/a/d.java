package d.e.d.a;

import android.util.Log;
import d.e.d.a.f;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ISNEventsTracker.java */
/* loaded from: classes2.dex */
public class d {
    private static d b;
    private d.e.a.b a;

    private d() {
    }

    private static d a() {
        if (b == null) {
            b = new d();
        }
        return b;
    }

    public static void b(d.e.a.a aVar, b bVar) {
        if (aVar != null) {
            try {
                a().a = new d.e.a.b(aVar, bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(f.a aVar) {
        d(aVar, new HashMap());
    }

    public static void d(f.a aVar, Map<String, Object> map) {
        d.e.a.b bVar = a().a;
        if (bVar == null) {
            Log.d("sdk5Events", "logEvent failed eventsTracker doesn't exist");
            return;
        }
        if (map != null) {
            map.put("eventid", Integer.valueOf(aVar.b));
        }
        bVar.d(aVar.a, map);
    }
}
