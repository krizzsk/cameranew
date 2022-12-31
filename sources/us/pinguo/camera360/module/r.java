package us.pinguo.camera360.module;

import android.content.Context;
import android.util.Pair;
import com.pinguo.camera360.member.C360MemberRepository;
import com.pinguo.camera360.vip.VipManager;
import us.pinguo.admobvista.AdvPGManager;
import us.pinguo.librouter.module.camera.InteractionInterface;
import us.pinguo.repository2020.ServiceControlRepository;
import us.pinguo.repository2020.database.EffectDbManager;
import us.pinguo.repository2020.database.sticker.StickerManager;
import us.pinguo.svideo.manager.VideoRecorderAdapter;
/* compiled from: CameraInterfaceImpl.java */
/* loaded from: classes3.dex */
public class r implements us.pinguo.librouter.module.camera.c {
    private us.pinguo.librouter.module.inspire.b a;
    private C360MemberRepository b;
    private ServiceControlRepository c;

    /* renamed from: d  reason: collision with root package name */
    private us.pinguo.librouter.module.camera.g f9540d;

    /* renamed from: e  reason: collision with root package name */
    private us.pinguo.librouter.module.camera.f f9541e;

    @Override // us.pinguo.librouter.module.camera.c
    public InteractionInterface a() {
        return InteractionInterfaceImpl.getInstance();
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void b(Context context) {
        if (this.c == null) {
            this.c = new ServiceControlRepository();
        }
        this.c.c(context);
    }

    @Override // us.pinguo.librouter.module.camera.c
    public boolean c(String str) {
        return true;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public us.pinguo.librouter.module.camera.e d() {
        return new u();
    }

    @Override // us.pinguo.librouter.module.camera.c
    public int e(String str, String str2) {
        return j.a.d.a.f(str, str2);
    }

    @Override // us.pinguo.librouter.module.camera.c
    public int f(String str) {
        return j.a.d.a.c(str);
    }

    @Override // us.pinguo.librouter.module.camera.c
    public us.pinguo.librouter.module.camera.f g() {
        if (this.f9541e == null) {
            this.f9541e = new v();
        }
        return this.f9541e;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void h(String str, us.pinguo.foundation.proxy.a aVar) {
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void i(boolean z) {
        if (z || VipManager.a.g(true)) {
            com.pinguo.camera360.adv.c.h();
        }
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void j() {
        com.pinguo.camera360.f.c.a.d.f();
    }

    @Override // us.pinguo.librouter.module.camera.c
    public boolean k() {
        return VideoRecorderAdapter.f();
    }

    @Override // us.pinguo.librouter.module.camera.c
    public boolean l(String str, String str2) {
        if (str == null || str.isEmpty() || "sticker_null".equals(str)) {
            return true;
        }
        EffectDbManager.a.a();
        return StickerManager.a.H(str) != null;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public Pair<Integer, Integer> m(int i2, int i3) {
        return j.a.d.a.b(i2, i3);
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void n(Context context, String str) {
        AdvPGManager.getInstance().huaweiReportRegister(context, str);
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void o(Context context, String str) {
        if (this.b == null) {
            this.b = new C360MemberRepository(context);
        }
        this.b.o(context, str);
        this.b.h(context);
    }

    @Override // us.pinguo.librouter.module.camera.c
    public us.pinguo.librouter.module.camera.g p() {
        if (this.f9540d == null) {
            this.f9540d = new x();
        }
        return this.f9540d;
    }

    @Override // us.pinguo.librouter.module.camera.c
    public void q(Context context) {
        if (this.b == null) {
            this.b = new C360MemberRepository(context);
        }
        boolean i2 = this.b.i();
        d.f.a.b.d.d("needSync = " + i2, new Object[0]);
        if (i2) {
            this.b.r(context, false);
            this.b.h(context);
        }
    }

    @Override // us.pinguo.librouter.module.camera.c
    public us.pinguo.librouter.module.inspire.b r() {
        if (this.a == null) {
            this.a = new w();
        }
        return this.a;
    }
}
