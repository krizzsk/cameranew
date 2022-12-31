package d.d.a.a.a.g;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes2.dex */
public final class c {
    public static void a(String str) {
        if (!d.d.a.a.a.c.a.booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("OMIDLIB", str);
    }

    public static void b(String str, Exception exc) {
        if ((!d.d.a.a.a.c.a.booleanValue() || TextUtils.isEmpty(str)) && exc == null) {
            return;
        }
        Log.e("OMIDLIB", str, exc);
    }
}
