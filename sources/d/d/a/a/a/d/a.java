package d.d.a.a.a.d;

import com.iab.omid.library.ironsrc.adsession.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
/* loaded from: classes2.dex */
public class a {
    private static a c = new a();
    private final ArrayList<g> a = new ArrayList<>();
    private final ArrayList<g> b = new ArrayList<>();

    private a() {
    }

    public static a a() {
        return c;
    }

    public void b(g gVar) {
        this.a.add(gVar);
    }

    public Collection<g> c() {
        return Collections.unmodifiableCollection(this.a);
    }

    public void d(g gVar) {
        boolean g2 = g();
        this.b.add(gVar);
        if (g2) {
            return;
        }
        f.a().c();
    }

    public Collection<g> e() {
        return Collections.unmodifiableCollection(this.b);
    }

    public void f(g gVar) {
        boolean g2 = g();
        this.a.remove(gVar);
        this.b.remove(gVar);
        if (!g2 || g()) {
            return;
        }
        f.a().d();
    }

    public boolean g() {
        return this.b.size() > 0;
    }
}
