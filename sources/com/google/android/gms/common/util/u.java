package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class u {
    private static final Method a;
    private static final Method b;
    private static final Method c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f3697d;

    static {
        Process.myUid();
        a = g();
        b = i();
        c = j();
        k();
        f3697d = l();
        m();
        n();
    }

    @Nullable
    public static WorkSource a(Context context, @Nullable String str) {
        if (context != null && context.getPackageManager() != null && str != null) {
            try {
                ApplicationInfo c2 = com.google.android.gms.common.wrappers.b.a(context).c(str, 0);
                if (c2 == null) {
                    String valueOf = String.valueOf(str);
                    Log.e("WorkSourceUtil", valueOf.length() != 0 ? "Could not get applicationInfo from package: ".concat(valueOf) : new String("Could not get applicationInfo from package: "));
                    return null;
                }
                return e(c2.uid, str);
            } catch (PackageManager.NameNotFoundException unused) {
                String valueOf2 = String.valueOf(str);
                Log.e("WorkSourceUtil", valueOf2.length() != 0 ? "Could not find package: ".concat(valueOf2) : new String("Could not find package: "));
            }
        }
        return null;
    }

    public static List<String> b(@Nullable WorkSource workSource) {
        int d2 = workSource == null ? 0 : d(workSource);
        if (d2 == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < d2; i2++) {
            String f2 = f(workSource, i2);
            if (!s.a(f2)) {
                arrayList.add(f2);
            }
        }
        return arrayList;
    }

    public static boolean c(Context context) {
        return (context == null || context.getPackageManager() == null || com.google.android.gms.common.wrappers.b.a(context).b("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) ? false : true;
    }

    private static int d(WorkSource workSource) {
        Method method = c;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    private static WorkSource e(int i2, String str) {
        WorkSource workSource = new WorkSource();
        h(workSource, i2, str);
        return workSource;
    }

    @Nullable
    private static String f(WorkSource workSource, int i2) {
        Method method = f3697d;
        if (method != null) {
            try {
                return (String) method.invoke(workSource, Integer.valueOf(i2));
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return null;
            }
        }
        return null;
    }

    private static Method g() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void h(WorkSource workSource, int i2, @Nullable String str) {
        Method method = b;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i2), str);
                return;
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                return;
            }
        }
        Method method2 = a;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i2));
            } catch (Exception e3) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
            }
        }
    }

    private static Method i() {
        if (o.e()) {
            try {
                return WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static Method j() {
        try {
            return WorkSource.class.getMethod(BigAlbumStore.PhotoColumns.SIZE, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method k() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Method l() {
        if (o.e()) {
            try {
                return WorkSource.class.getMethod("getName", Integer.TYPE);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static final Method m() {
        if (o.l()) {
            try {
                return WorkSource.class.getMethod("createWorkChain", new Class[0]);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e2);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static final Method n() {
        if (o.l()) {
            try {
                return Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
            } catch (Exception e2) {
                Log.w("WorkSourceUtil", "Missing WorkChain class", e2);
            }
        }
        return null;
    }
}
