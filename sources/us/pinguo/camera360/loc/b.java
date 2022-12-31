package us.pinguo.camera360.loc;

import android.graphics.Bitmap;
import java.io.File;
import java.io.IOException;
import us.pinguo.camera360.shop.data.install.t;
import us.pinguo.foundation.e;
import us.pinguo.loc.EffectLocManager;
import us.pinguo.loc.m;
import us.pinguo.loc.o;
import us.pinguo.loc.w;
import us.pinguo.repository2020.utils.k;
import us.pinguo.util.v;
import vStudio.Android.Camera360.R;
/* compiled from: CameraLocPreviewInput.java */
/* loaded from: classes3.dex */
public class b extends m {

    /* renamed from: g  reason: collision with root package name */
    byte[] f9537g;

    /* renamed from: h  reason: collision with root package name */
    com.pinguo.camera360.m.b f9538h;

    /* renamed from: i  reason: collision with root package name */
    com.pinguo.camera360.m.c.a f9539i;

    public b(byte[] bArr, com.pinguo.camera360.m.b bVar, com.pinguo.camera360.m.c.a aVar) {
        this.f9537g = bArr;
        this.f9538h = bVar;
        this.f9539i = aVar;
        this.f11543f = bVar.f();
    }

    static File h(com.pinguo.camera360.m.b bVar) {
        File a = w.a(e.b());
        return new File(a, "ori_" + String.valueOf(bVar.j()) + ".jpg");
    }

    static File i(com.pinguo.camera360.m.b bVar) {
        File a = w.a(e.b());
        return new File(a, "preview_" + String.valueOf(bVar.j()) + bVar.e() + ".jpg");
    }

    @Override // us.pinguo.loc.m
    public us.pinguo.facedetector.c a(Bitmap bitmap) {
        return k.a.q(bitmap, 0);
    }

    @Override // us.pinguo.loc.m
    public String b() {
        return this.a;
    }

    @Override // us.pinguo.loc.m
    public String c() {
        return this.c;
    }

    @Override // us.pinguo.loc.m
    public String d() {
        return this.b;
    }

    @Override // us.pinguo.loc.m
    public void e(Throwable th) {
        if (th instanceof EffectLocManager.NoFaceDetectedException) {
            th = new EffectLocManager.NoFaceDetectedException(v.f(R.string.no_face_detect));
        } else if (th instanceof EffectLocManager.TaskCancelException) {
            th = new EffectLocManager.TaskCancelException(v.f(R.string.poker_cancel));
        } else if (!(th instanceof EffectLocManager.EmptyException) && th != null) {
            th = new RuntimeException(v.f(R.string.make_effect_failed));
        }
        this.f9539i.a(this.f9538h, null, null, th);
    }

    @Override // us.pinguo.loc.m
    public void f(Bitmap bitmap, Bitmap bitmap2) {
        this.f9539i.a(this.f9538h, bitmap, bitmap2, null);
    }

    @Override // us.pinguo.loc.m
    public void g() throws IOException {
        File h2 = h(this.f9538h);
        this.a = h2.getAbsolutePath();
        if (!h2.exists()) {
            com.pinguo.camera360.o.a.a.c(this.f9538h, this.f9537g, this.a);
            if (this.f9538h.h() == 4) {
                com.pinguo.camera360.o.a.a.a(this.a);
            }
            LocInputUtil.a(this.a);
        }
        us.pinguo.foundation.r.d.a().b(new o(10));
        this.b = i(this.f9538h).getAbsolutePath();
        this.c = t.b(this.f9538h.g(), this.f9538h.b());
        this.f11541d = null;
        this.f11542e = this.f9538h.j();
    }
}
