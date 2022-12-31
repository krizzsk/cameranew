package us.pinguo.location;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.content.ContextCompat;
import us.pinguo.librouter.b.c.f;
import us.pinguo.librouter.b.c.g;
/* compiled from: PGLocationManager.java */
/* loaded from: classes5.dex */
public class d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    private static d f11556g = new d();
    private Context a;
    private us.pinguo.librouter.b.c.b b;
    private boolean c = false;

    /* renamed from: d  reason: collision with root package name */
    private volatile f f11557d = null;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.location.a f11558e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11559f = false;

    /* compiled from: PGLocationManager.java */
    /* loaded from: classes5.dex */
    class a implements g {
        final /* synthetic */ g a;

        a(g gVar) {
            this.a = gVar;
        }

        @Override // us.pinguo.librouter.b.c.g
        public void locationError(String str) {
            g gVar = this.a;
            if (gVar != null) {
                gVar.locationError(str);
            }
        }

        @Override // us.pinguo.librouter.b.c.g
        public void locationReceived(f fVar) {
            d.this.f11557d = fVar;
            d.this.b.a(fVar);
            g gVar = this.a;
            if (gVar != null) {
                gVar.locationReceived(fVar);
            }
        }
    }

    public static d c() {
        return f11556g;
    }

    private us.pinguo.location.a f() {
        if (this.c) {
            return new c();
        }
        try {
            return (us.pinguo.location.a) Class.forName("us.pinguo.location.PGGaoDeLocation").newInstance();
        } catch (Exception unused) {
            return new c();
        }
    }

    public Context d() {
        return this.a;
    }

    public f e() {
        if (this.f11557d == null) {
            return this.b.b();
        }
        return this.f11557d;
    }

    public void g(Context context, boolean z, us.pinguo.librouter.b.c.b bVar) {
        this.c = z;
        this.a = context;
        this.b = bVar;
    }

    public void h(g gVar) {
        Context context = this.a;
        if (context != null && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            synchronized (this) {
                if (this.f11558e == null) {
                    this.f11558e = f();
                }
                if (this.f11559f) {
                    return;
                }
                this.f11559f = true;
                this.f11558e.a(new a(gVar));
            }
        }
    }

    public void i() {
        synchronized (this) {
            us.pinguo.location.a aVar = this.f11558e;
            if (aVar != null) {
                aVar.b();
            }
            this.f11559f = false;
        }
    }
}
