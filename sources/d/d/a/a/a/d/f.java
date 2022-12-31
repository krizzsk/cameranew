package d.d.a.a.a.d;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.ironsrc.adsession.g;
import com.iab.omid.library.ironsrc.walking.TreeWalker;
import d.d.a.a.a.d.b;
/* loaded from: classes2.dex */
public class f implements d.d.a.a.a.b.c, b.a {

    /* renamed from: f  reason: collision with root package name */
    private static f f8515f;
    private float a = 0.0f;
    private final d.d.a.a.a.b.e b;
    private final d.d.a.a.a.b.b c;

    /* renamed from: d  reason: collision with root package name */
    private d.d.a.a.a.b.d f8516d;

    /* renamed from: e  reason: collision with root package name */
    private a f8517e;

    public f(d.d.a.a.a.b.e eVar, d.d.a.a.a.b.b bVar) {
        this.b = eVar;
        this.c = bVar;
    }

    public static f a() {
        if (f8515f == null) {
            f8515f = new f(new d.d.a.a.a.b.e(), new d.d.a.a.a.b.b());
        }
        return f8515f;
    }

    private a f() {
        if (this.f8517e == null) {
            this.f8517e = a.a();
        }
        return this.f8517e;
    }

    @Override // d.d.a.a.a.b.c
    public void a(float f2) {
        this.a = f2;
        for (g gVar : f().e()) {
            gVar.o().b(f2);
        }
    }

    public void b(Context context) {
        this.f8516d = this.b.a(new Handler(), context, this.c.a(), this);
    }

    public void c() {
        b.a().c(this);
        b.a().d();
        if (b.a().f()) {
            TreeWalker.getInstance().c();
        }
        this.f8516d.a();
    }

    public void d() {
        TreeWalker.getInstance().h();
        b.a().e();
        this.f8516d.c();
    }

    public float e() {
        return this.a;
    }
}
