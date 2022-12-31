package us.pinguo.foundation.utils;

import android.app.Activity;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import rx.Subscription;
/* compiled from: CellSubscriptions.java */
/* loaded from: classes4.dex */
public class h {
    private static Map<String, s0> a = new ConcurrentHashMap();
    private static List<String> b = new LinkedList();

    public static void a(Subscription subscription) {
        if (b.size() == 0) {
            return;
        }
        List<String> list = b;
        String str = list.get(list.size() - 1);
        s0 s0Var = a.get(str);
        if (s0Var != null) {
            s0Var.a(subscription);
            if (str != null) {
                us.pinguo.common.log.a.k("add subscription in activity:" + str, new Object[0]);
            }
        }
    }

    public static void b(Activity activity) {
        s0 s0Var = new s0();
        String obj = activity.toString();
        a.put(obj, s0Var);
        b.add(obj);
    }

    public static void c(Activity activity) {
        String obj = activity.toString();
        b.remove(obj);
        s0 remove = a.remove(obj);
        if (remove != null) {
            remove.unsubscribe();
        }
    }
}
