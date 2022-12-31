package d.d.a.a.a.d;

import android.annotation.SuppressLint;
import android.content.Context;
/* loaded from: classes2.dex */
public class d {
    @SuppressLint({"StaticFieldLeak"})
    private static d b = new d();
    private Context a;

    private d() {
    }

    public static d a() {
        return b;
    }

    public void b(Context context) {
        this.a = context != null ? context.getApplicationContext() : null;
    }

    public Context c() {
        return this.a;
    }
}
