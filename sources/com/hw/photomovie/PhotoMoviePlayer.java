package com.hw.photomovie;

import android.content.Context;
import android.os.Handler;
import com.hw.photomovie.b.d;
import com.hw.photomovie.e.a;
import com.hw.photomovie.render.a;
import com.hw.photomovie.render.d;
import com.hw.photomovie.segment.e;
import com.hw.photomovie.util.AppResources;
import java.util.List;
/* loaded from: classes2.dex */
public class PhotoMoviePlayer implements a.InterfaceC0200a {
    private com.hw.photomovie.a b;
    private com.hw.photomovie.render.d c;

    /* renamed from: d  reason: collision with root package name */
    private com.hw.photomovie.e.a f5142d;

    /* renamed from: e  reason: collision with root package name */
    private a.InterfaceC0200a f5143e;

    /* renamed from: g  reason: collision with root package name */
    private f f5145g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5146h;
    private int a = 0;

    /* renamed from: f  reason: collision with root package name */
    private com.hw.photomovie.c.a f5144f = new com.hw.photomovie.c.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements d.a {
        a() {
        }

        @Override // com.hw.photomovie.b.d.a
        public void a(com.hw.photomovie.b.d dVar, float f2) {
            if (PhotoMoviePlayer.this.f5145g != null) {
                PhotoMoviePlayer.this.f5145g.onPreparing(PhotoMoviePlayer.this, f2 * 0.95f);
            }
        }

        @Override // com.hw.photomovie.b.d.a
        public void b(com.hw.photomovie.b.d dVar, int i2, List<com.hw.photomovie.b.b> list) {
            if (list == null || list.size() == 0) {
                PhotoMoviePlayer.this.m(i2, dVar.k());
            } else if (dVar.k() > 0) {
                PhotoMoviePlayer.this.b.h();
                PhotoMoviePlayer.this.m(i2, dVar.k() + list.size());
            } else {
                if (PhotoMoviePlayer.this.f5145g != null) {
                    PhotoMoviePlayer.this.f5145g.onError(PhotoMoviePlayer.this);
                }
                PhotoMoviePlayer.this.v(-1);
                com.hw.photomovie.util.b.a("PhotoMoviePlayer", "数据加载失败");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements e.a {
        final /* synthetic */ com.hw.photomovie.segment.e a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        b(com.hw.photomovie.segment.e eVar, int i2, int i3) {
            this.a = eVar;
            this.b = i2;
            this.c = i3;
        }

        @Override // com.hw.photomovie.segment.e.a
        public void a(boolean z) {
            this.a.u(null);
            PhotoMoviePlayer.this.v(2);
            if (PhotoMoviePlayer.this.f5145g != null) {
                PhotoMoviePlayer.this.f5145g.onPreparing(PhotoMoviePlayer.this, 1.0f);
                PhotoMoviePlayer.this.i(this.b, this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements d.a {
        final /* synthetic */ Handler a;

        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PhotoMoviePlayer.this.o();
            }
        }

        c(Handler handler) {
            this.a = handler;
        }

        @Override // com.hw.photomovie.render.d.a
        public void a() {
            PhotoMoviePlayer.this.c.h(null);
            this.a.post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements e.a {
        final /* synthetic */ com.hw.photomovie.segment.e a;

        d(com.hw.photomovie.segment.e eVar) {
            this.a = eVar;
        }

        @Override // com.hw.photomovie.segment.e.a
        public void a(boolean z) {
            this.a.u(null);
            PhotoMoviePlayer.this.v(2);
            PhotoMoviePlayer.this.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements a.b {
        final /* synthetic */ int a;
        final /* synthetic */ int b;

        e(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        @Override // com.hw.photomovie.render.a.b
        public void a() {
            PhotoMoviePlayer.this.f5145g.onPrepared(PhotoMoviePlayer.this, this.a, this.b);
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
        void onError(PhotoMoviePlayer photoMoviePlayer);

        void onPrepared(PhotoMoviePlayer photoMoviePlayer, int i2, int i3);

        void onPreparing(PhotoMoviePlayer photoMoviePlayer, float f2);
    }

    public PhotoMoviePlayer(Context context) {
        AppResources.getInstance().b(context.getResources());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i2, int i3) {
        com.hw.photomovie.render.d dVar = this.c;
        if (dVar instanceof com.hw.photomovie.render.a) {
            ((com.hw.photomovie.render.a) dVar).k(new e(i2, i3));
        } else {
            this.f5145g.onPrepared(this, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i2, int i3) {
        List e2 = this.b.e();
        if (e2 != null && e2.size() >= 1) {
            com.hw.photomovie.segment.e eVar = (com.hw.photomovie.segment.e) e2.get(0);
            eVar.u(new b(eVar, i2, i3));
            eVar.r();
            return;
        }
        v(2);
        if (this.f5145g != null) {
            i(i2, i3);
        }
    }

    private void n() {
        com.hw.photomovie.render.d dVar = this.c;
        if ((dVar instanceof com.hw.photomovie.render.b) && !((com.hw.photomovie.render.b) dVar).r()) {
            o();
            return;
        }
        this.c.h(new c(new Handler()));
        this.c.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        List e2 = this.b.e();
        if (e2 == null || e2.size() == 0) {
            return;
        }
        v(1);
        com.hw.photomovie.segment.e eVar = (com.hw.photomovie.segment.e) e2.get(0);
        eVar.u(new d(eVar));
        eVar.r();
    }

    public com.hw.photomovie.c.a g() {
        return this.f5144f;
    }

    public boolean h() {
        int i2 = this.a;
        return i2 == 2 || i2 == 4 || i2 == 5;
    }

    public void j() {
        com.hw.photomovie.e.a aVar = this.f5142d;
        if (aVar != null) {
            aVar.pause();
        }
    }

    public void k() {
        com.hw.photomovie.a aVar = this.b;
        if (aVar != null && aVar.f() != null) {
            l(this.b.f().k());
            return;
        }
        throw new NullPointerException("PhotoSource is null!");
    }

    public void l(int i2) {
        com.hw.photomovie.a aVar = this.b;
        if (aVar != null && aVar.f() != null) {
            v(1);
            this.b.f().j(new a());
            this.b.f().i(i2);
            return;
        }
        throw new NullPointerException("PhotoSource is null!");
    }

    @Override // com.hw.photomovie.e.a.InterfaceC0200a
    public void onMovieEnd() {
        com.hw.photomovie.util.b.c("PhotoMoviePlayer", "onMovieEnd");
        a.InterfaceC0200a interfaceC0200a = this.f5143e;
        if (interfaceC0200a != null) {
            interfaceC0200a.onMovieEnd();
        }
        this.f5144f.stop();
        v(5);
        if (this.f5146h) {
            n();
        } else {
            this.c.e();
        }
    }

    @Override // com.hw.photomovie.e.a.InterfaceC0200a
    public void onMovieResumed() {
        com.hw.photomovie.util.b.c("PhotoMoviePlayer", "onMovieResumed");
        a.InterfaceC0200a interfaceC0200a = this.f5143e;
        if (interfaceC0200a != null) {
            interfaceC0200a.onMovieResumed();
        }
        this.f5144f.start();
        v(3);
    }

    @Override // com.hw.photomovie.e.a.InterfaceC0200a
    public void onMovieStarted() {
        com.hw.photomovie.util.b.c("PhotoMoviePlayer", "onMovieStarted");
        a.InterfaceC0200a interfaceC0200a = this.f5143e;
        if (interfaceC0200a != null) {
            interfaceC0200a.onMovieStarted();
        }
        this.f5144f.start();
        v(3);
    }

    @Override // com.hw.photomovie.e.a.InterfaceC0200a
    public void onMovieUpdate(int i2) {
        a.InterfaceC0200a interfaceC0200a = this.f5143e;
        if (interfaceC0200a != null) {
            interfaceC0200a.onMovieUpdate(i2);
        }
        com.hw.photomovie.a aVar = this.b;
        if (aVar != null) {
            aVar.j(i2);
        }
    }

    @Override // com.hw.photomovie.e.a.InterfaceC0200a
    public void onMoviedPaused() {
        com.hw.photomovie.util.b.c("PhotoMoviePlayer", "onMoviedPaused");
        a.InterfaceC0200a interfaceC0200a = this.f5143e;
        if (interfaceC0200a != null) {
            interfaceC0200a.onMoviedPaused();
        }
        this.f5144f.pause();
        v(4);
    }

    public void p(int i2) {
        onMovieUpdate(i2);
    }

    public void q(com.hw.photomovie.a aVar) {
        com.hw.photomovie.a aVar2;
        v(0);
        this.b = aVar;
        com.hw.photomovie.e.b bVar = new com.hw.photomovie.e.b(aVar);
        this.f5142d = bVar;
        bVar.a(this);
        com.hw.photomovie.render.d dVar = this.c;
        if (dVar != null && (aVar2 = this.b) != null) {
            aVar2.i(dVar);
            this.c.j(this.b);
        }
        r(this.f5146h);
    }

    public void r(boolean z) {
        this.f5146h = z;
    }

    public void s(a.InterfaceC0200a interfaceC0200a) {
        this.f5143e = interfaceC0200a;
    }

    public void t(com.hw.photomovie.render.d dVar) {
        com.hw.photomovie.a aVar;
        this.c = dVar;
        if (dVar == null || (aVar = this.b) == null) {
            return;
        }
        aVar.i(dVar);
        this.c.j(this.b);
    }

    public void u(f fVar) {
        this.f5145g = fVar;
    }

    public void v(int i2) {
        this.a = i2;
        com.hw.photomovie.render.d dVar = this.c;
        if (dVar != null) {
            if (i2 == -1 || i2 == 0) {
                dVar.c(false);
            } else if (i2 == 1) {
                dVar.c(false);
            } else if (i2 != 2) {
            } else {
                dVar.c(true);
            }
        }
    }

    public void w() {
        if (!h()) {
            com.hw.photomovie.util.b.a("PhotoMoviePlayer", "start error!not prepared!");
            return;
        }
        if (this.a != 4) {
            this.b.c();
        }
        this.f5142d.start();
    }

    public void x() {
        if (this.a < 2) {
            return;
        }
        j();
        p(0);
    }
}
