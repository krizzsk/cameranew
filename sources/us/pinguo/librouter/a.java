package us.pinguo.librouter;

import android.app.Application;
import android.util.Log;
import us.pinguo.librouter.c.b;
import us.pinguo.librouter.c.c;
import us.pinguo.librouter.c.d;
/* compiled from: ModuleInitManager.java */
/* loaded from: classes5.dex */
public class a {
    public static b[] a;
    private static String[] b = {"us.pinguo.camera360.module.CameraModuleInit"};

    public static void a(Application application, boolean z) {
        String[] strArr = b;
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            try {
                ((c) Class.forName(str).newInstance()).initInOnCreate(application, z);
            } catch (Exception e2) {
                Log.e("ModuleInitManager", "Exception", e2);
            }
        }
    }

    public static void b(Application application) {
        d();
        for (b bVar : a) {
            bVar.initInAllProcess(application);
        }
    }

    public static void c(Application application) {
        d();
        for (b bVar : a) {
            bVar.initInMainProcess(application);
        }
    }

    private static synchronized void d() {
        synchronized (a.class) {
            if (a != null) {
                return;
            }
            a = new b[]{d.b(), d.c()};
        }
    }
}
