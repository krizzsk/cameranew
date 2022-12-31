package us.pinguo.smaato;

import android.content.Context;
import android.text.TextUtils;
import us.pinguo.advsdk.PgAdvConstants$CountMode;
import us.pinguo.advsdk.a.d;
import us.pinguo.advsdk.bean.AdsItem;
import us.pinguo.advsdk.network.e;
import us.pinguo.advsdk.network.f;
import us.pinguo.smaatoapi.b;
import us.pinguo.smaatoapi.network.NativeLoader;
/* compiled from: PGSmaatoRequest.java */
/* loaded from: classes6.dex */
public class c extends d<b> implements b.d {

    /* renamed from: j  reason: collision with root package name */
    private String f11973j;

    /* compiled from: PGSmaatoRequest.java */
    /* loaded from: classes6.dex */
    class a implements b.c {
        final /* synthetic */ us.pinguo.smaatoapi.b a;

        a(us.pinguo.smaatoapi.b bVar) {
            this.a = bVar;
        }

        @Override // us.pinguo.smaatoapi.b.c
        public void a() {
            b bVar = new b(((us.pinguo.advsdk.a.a) c.this).f9034e, this.a, ((d) c.this).f9040h);
            new us.pinguo.advsdk.network.c((Context) ((us.pinguo.advsdk.a.a) c.this).f9033d.get(), ((us.pinguo.advsdk.a.a) c.this).f9034e, bVar, PgAdvConstants$CountMode.NORMAL).execute();
            c.this.s(bVar);
        }

        @Override // us.pinguo.smaatoapi.b.c
        public void b() {
            new e((Context) ((us.pinguo.advsdk.a.a) c.this).f9033d.get(), ((us.pinguo.advsdk.a.a) c.this).f9034e, new b(((us.pinguo.advsdk.a.a) c.this).f9034e, this.a, ((d) c.this).f9040h)).execute();
        }
    }

    public c(AdsItem adsItem, String str) {
        super(adsItem);
        this.f11973j = str;
    }

    @Override // us.pinguo.smaatoapi.b.d
    public void c(us.pinguo.smaatoapi.b bVar) {
        us.pinguo.advsdk.utils.b.a("Smaato 加载成功");
        bVar.r(new a(bVar));
        z(false);
        l(new b(this.f9034e, bVar, this.f9040h));
        x(o());
    }

    @Override // us.pinguo.smaatoapi.b.d
    public void e(String str) {
        z(false);
        us.pinguo.advsdk.utils.b.a("Smaato 加载失败 " + str);
        us.pinguo.advsdk.utils.b.a(q() + "smaato error:" + str);
        t(str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f fVar = new f(this.f9033d.get(), this.f9034e, this.f9040h);
        fVar.e("0", str);
        fVar.execute();
    }

    @Override // us.pinguo.advsdk.a.d, us.pinguo.advsdk.a.a
    public boolean i() {
        if (super.i()) {
            return true;
        }
        NativeLoader.b(this.f9033d.get()).c(this, this.f11973j, this.f9034e.placementId);
        return false;
    }

    @Override // us.pinguo.advsdk.a.d
    public int m() {
        return 35;
    }
}
