package d.d.a.a.a;

import android.content.Context;
import d.d.a.a.a.d.b;
import d.d.a.a.a.d.d;
import d.d.a.a.a.d.f;
/* loaded from: classes2.dex */
public class e {
    private boolean a;

    private void d(Context context) {
        d.d.a.a.a.g.e.c(context, "Application Context cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return "1.3.12-Ironsrc";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Context context) {
        d(context);
        if (e()) {
            return;
        }
        c(true);
        f.a().b(context);
        b.a().b(context);
        d.d.a.a.a.g.b.c(context);
        d.a().b(context);
    }

    void c(boolean z) {
        this.a = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.a;
    }
}
