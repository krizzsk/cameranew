package d.d.a.a.a.d;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.iab.omid.library.ironsrc.adsession.g;
/* loaded from: classes2.dex */
public class b {
    @SuppressLint({"StaticFieldLeak"})
    private static b c = new b();
    private Context a;
    private boolean b;

    /* loaded from: classes2.dex */
    public interface a {
    }

    private b() {
    }

    public static b a() {
        return c;
    }

    private void g() {
        boolean z = !this.b;
        for (g gVar : d.d.a.a.a.d.a.a().c()) {
            gVar.o().i(z);
        }
    }

    public void b(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    public void c(a aVar) {
    }

    public void d() {
        g();
    }

    public void e() {
        this.b = false;
    }

    public boolean f() {
        return !this.b;
    }
}
