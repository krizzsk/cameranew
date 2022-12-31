package us.pinguo.foundation.utils;

import android.app.Activity;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* compiled from: UilCancelHelper.java */
/* loaded from: classes4.dex */
public class l0 {
    private static final Map<String, List<WeakReference<com.nostra13.universalimageloader.core.j.a>>> a = new HashMap();
    private static String b;
    private static String c;

    public static void a(com.nostra13.universalimageloader.core.j.a aVar) {
        Map<String, List<WeakReference<com.nostra13.universalimageloader.core.j.a>>> map = a;
        String str = c;
        if (str == null) {
            str = b;
        }
        List<WeakReference<com.nostra13.universalimageloader.core.j.a>> list = map.get(str);
        if (list == null) {
            return;
        }
        list.add(new WeakReference<>(aVar));
    }

    public static void b(Activity activity) {
        String obj = activity.toString();
        List<WeakReference<com.nostra13.universalimageloader.core.j.a>> list = a.get(obj);
        if (list == null) {
            return;
        }
        for (WeakReference<com.nostra13.universalimageloader.core.j.a> weakReference : list) {
            if (weakReference != null && weakReference.get() != null) {
                ImageLoader.getInstance().b(weakReference.get());
                us.pinguo.common.log.a.k("cancelTask:" + weakReference.toString(), new Object[0]);
            }
        }
        a.remove(obj);
    }

    public static void c(Activity activity) {
        String obj = activity.toString();
        b = obj;
        a.put(obj, new LinkedList());
    }

    public static void d(Activity activity) {
        c = activity.toString();
    }
}
