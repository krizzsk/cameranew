package us.pinguo.camera360.shop.data.share;

import android.app.Activity;
import us.pinguo.camera360.shop.data.show.ShowPkg;
import us.pinguo.share.core.PGShareListener;
import us.pinguo.share.core.ShareSite;
import us.pinguo.share.util.p;
/* compiled from: ShopShareUtil.java */
/* loaded from: classes3.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShopShareUtil.java */
    /* loaded from: classes3.dex */
    public class a implements PGShareListener {
        final /* synthetic */ Activity a;
        final /* synthetic */ d b;
        final /* synthetic */ ShowPkg c;

        /* compiled from: ShopShareUtil.java */
        /* renamed from: us.pinguo.camera360.shop.data.share.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class RunnableC0371a implements Runnable {
            RunnableC0371a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.b.a(aVar.c);
            }
        }

        /* compiled from: ShopShareUtil.java */
        /* loaded from: classes3.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.b.b(aVar.c);
            }
        }

        a(Activity activity, d dVar, ShowPkg showPkg) {
            this.a = activity;
            this.b = dVar;
            this.c = showPkg;
        }

        @Override // us.pinguo.share.core.PGShareListener
        public void onShareCancel(ShareSite shareSite) {
            this.b.b(this.c);
        }

        @Override // us.pinguo.share.core.PGShareListener
        public void onShareComplete(ShareSite shareSite, boolean z) {
            this.a.runOnUiThread(new RunnableC0371a());
        }

        @Override // us.pinguo.share.core.PGShareListener
        public void onShareError(ShareSite shareSite, Throwable th) {
            this.a.runOnUiThread(new b());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.app.Activity r17, us.pinguo.camera360.shop.data.show.ShowPkg r18, us.pinguo.camera360.shop.data.share.f r19, us.pinguo.camera360.shop.data.share.d r20) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.camera360.shop.data.share.e.a(android.app.Activity, us.pinguo.camera360.shop.data.show.ShowPkg, us.pinguo.camera360.shop.data.share.f, us.pinguo.camera360.shop.data.share.d):void");
    }

    public static p b(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new p(fVar.i(), fVar.k(), fVar.f(), fVar.g(), fVar.e(), fVar.d(), fVar.b(), fVar.j(), fVar.a());
    }
}
