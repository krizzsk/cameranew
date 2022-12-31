package com.pinguo.camera360.save.processer;

import android.os.Handler;
import android.os.Looper;
import us.pinguo.foundation.base.ActivityRecorder;
import us.pinguo.foundation.utils.j0;
import us.pinguo.loc.EffectLocManager;
import us.pinguo.loc.LocLoadingState;
import us.pinguo.loc.o;
import us.pinguo.loc.t;
import us.pinguo.poker.m;
import us.pinguo.poker.n;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoProcesserExtra.java */
/* loaded from: classes3.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhotoProcesserExtra.java */
    /* loaded from: classes3.dex */
    public class a implements t.a {
        final /* synthetic */ us.pinguo.camera360.loc.b a;

        a(us.pinguo.camera360.loc.b bVar) {
            this.a = bVar;
        }

        @Override // us.pinguo.loc.t.a
        public void a(int i2) {
            if (i2 == 100) {
                i2 = 99;
            }
            us.pinguo.foundation.r.d.a().b(new o(i2, LocLoadingState.DOWN_LOADING));
        }

        @Override // us.pinguo.loc.t.a
        public void b() {
            this.a.e(new EffectLocManager.EmptyException());
        }

        @Override // us.pinguo.loc.t.a
        public void c(boolean z) {
            if (!z) {
                j0.d(us.pinguo.foundation.e.b().getString(R.string.download_not_network));
                us.pinguo.foundation.r.d.a().b(new o(-1, LocLoadingState.DOWN_LOADING));
                return;
            }
            us.pinguo.foundation.r.d.a().b(new o(99, LocLoadingState.DOWN_LOADING));
            EffectLocManager.getInstance().g(this.a);
        }
    }

    private static void a(us.pinguo.camera360.loc.b bVar) {
        if (!us.pinguo.camera360.loc.d.a()) {
            EffectLocManager.getInstance().g(bVar);
            return;
        }
        final a aVar = new a(bVar);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.pinguo.camera360.save.processer.a
            @Override // java.lang.Runnable
            public final void run() {
                us.pinguo.camera360.loc.d.c(ActivityRecorder.getInstance().d(), t.a.this);
            }
        });
    }

    public static void c(byte[] bArr, com.pinguo.camera360.m.b bVar, com.pinguo.camera360.m.c.a aVar) {
        a(new us.pinguo.camera360.loc.b(bArr, bVar, aVar));
    }

    public static void d(byte[] bArr, com.pinguo.camera360.m.b bVar, n nVar) {
        m mVar = new m(String.valueOf(bVar.j()), bArr, bVar.f(), bVar.i());
        mVar.f(bVar.h() == 4);
        mVar.g(bVar.k());
        us.pinguo.poker.o.e().c(new us.pinguo.poker.t(mVar), nVar);
    }
}
