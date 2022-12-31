package d.f.a.b;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;
/* compiled from: L.java */
/* loaded from: classes3.dex */
public final class d {
    private static volatile boolean a = false;
    private static volatile boolean b = true;

    public static void a(String str, Object... objArr) {
        if (a) {
            e(3, null, str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        e(6, null, str, objArr);
    }

    public static void c(Throwable th) {
        e(6, th, null, new Object[0]);
    }

    public static void d(String str, Object... objArr) {
        e(4, null, str, objArr);
    }

    private static void e(int i2, Throwable th, String str, Object... objArr) {
        if (b) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format("%1$s\n%2$s", str, Log.getStackTraceString(th));
            }
            Log.println(i2, ImageLoader.f5894d, str);
        }
    }

    public static void f(String str, Object... objArr) {
        e(5, null, str, objArr);
    }

    public static void g(boolean z) {
        a = z;
    }
}
