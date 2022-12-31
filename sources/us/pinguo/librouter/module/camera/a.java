package us.pinguo.librouter.module.camera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import us.pinguo.librouter.module.camera.f;
/* compiled from: CameraDefaultInterface.java */
/* loaded from: classes5.dex */
public class a implements c {
    private h a;
    private us.pinguo.librouter.module.inspire.b b;
    private g c;

    /* renamed from: d  reason: collision with root package name */
    private f f11538d;

    /* compiled from: CameraDefaultInterface.java */
    /* renamed from: us.pinguo.librouter.module.camera.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0419a implements f {
        C0419a(a aVar) {
        }

        @Override // us.pinguo.librouter.module.camera.f
        public boolean a() {
            return false;
        }

        @Override // us.pinguo.librouter.module.camera.f
        public void b(int i2, int i3, Intent intent) {
        }

        @Override // us.pinguo.librouter.module.camera.f
        public String c() {
            return "";
        }

        @Override // us.pinguo.librouter.module.camera.f
        public void d(Activity activity) {
        }

        @Override // us.pinguo.librouter.module.camera.f
        public void e() {
        }

        @Override // us.pinguo.librouter.module.camera.f
        public void f(Activity activity, f.a aVar) {
        }
    }

    @Override // us.pinguo.librouter.module.camera.c
    public InteractionInterface a() {
        if (this.a == null) {
            this.a = new h();
        }
        return this.a;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void b(Context context) {
    }

    @Override // us.pinguo.librouter.module.camera.c
    public boolean c(String str) {
        return false;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public e d() {
        return new i();
    }

    @Override // us.pinguo.librouter.module.camera.c
    public int e(String str, String str2) {
        return 0;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public int f(String str) {
        return 0;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public f g() {
        if (this.f11538d == null) {
            this.f11538d = new C0419a(this);
        }
        return this.f11538d;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void h(String str, us.pinguo.foundation.proxy.a aVar) {
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void i(boolean z) {
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void j() {
    }

    @Override // us.pinguo.librouter.module.camera.c
    public boolean k() {
        return false;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public boolean l(String str, String str2) {
        return false;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public Pair<Integer, Integer> m(int i2, int i3) {
        return null;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void n(Context context, String str) {
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void o(Context context, String str) {
    }

    @Override // us.pinguo.librouter.module.camera.c
    public g p() {
        if (this.b == null) {
            this.c = new j();
        }
        return this.c;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void q(Context context) {
    }

    @Override // us.pinguo.librouter.module.camera.c
    public us.pinguo.librouter.module.inspire.b r() {
        if (this.b == null) {
            this.b = new us.pinguo.librouter.module.inspire.e();
        }
        return this.b;
    }
}
