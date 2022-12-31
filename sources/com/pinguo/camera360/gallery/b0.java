package com.pinguo.camera360.gallery;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.os.Handler;
import android.os.Message;
import com.pinguo.album.a;
import com.pinguo.camera360.gallery.c0;
import com.pinguo.camera360.gallery.data.Path;
import com.pinguo.camera360.gallery.ui.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import vStudio.Android.Camera360.R;
/* compiled from: PhotoDataAdapter.java */
@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class b0 implements c0.f {
    private static g[] z;
    private final com.pinguo.album.opengles.r a;
    private final com.pinguo.album.h.a b;
    private final com.pinguo.camera360.gallery.data.w[] c;

    /* renamed from: d  reason: collision with root package name */
    private int f6310d;

    /* renamed from: e  reason: collision with root package name */
    private int f6311e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<Path, f> f6312f;

    /* renamed from: g  reason: collision with root package name */
    private int f6313g;

    /* renamed from: h  reason: collision with root package name */
    private int f6314h;

    /* renamed from: i  reason: collision with root package name */
    private int f6315i;

    /* renamed from: j  reason: collision with root package name */
    private final long[] f6316j;

    /* renamed from: k  reason: collision with root package name */
    private final Path[] f6317k;

    /* renamed from: l  reason: collision with root package name */
    private final Handler f6318l;
    private final com.pinguo.album.a m;
    private final com.pinguo.camera360.gallery.ui.u n;
    private final com.pinguo.camera360.gallery.data.y o;
    private h p;
    private long q;
    private int r;
    private boolean s;
    private boolean t;
    private int u;
    private b v;
    private final k w;
    private int x;
    private com.pinguo.album.opengles.b y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    public class a extends com.pinguo.album.g {
        a(com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                if (b0.this.v != null) {
                    b0.this.v.d();
                }
            } else if (i2 == 2) {
                if (b0.this.v != null) {
                    b0.this.v.c();
                }
            } else if (i2 == 3) {
                ((Runnable) message.obj).run();
            } else if (i2 == 4) {
                b0.this.g0();
            } else {
                throw new AssertionError();
            }
        }
    }

    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    public interface b extends x {
        void a(int i2, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    public class c implements a.b<BitmapRegionDecoder> {
        private com.pinguo.camera360.gallery.data.w a;

        public c(com.pinguo.camera360.gallery.data.w wVar) {
            this.a = wVar;
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public BitmapRegionDecoder a(a.c cVar) {
            if (b0.this.Z(this.a)) {
                return null;
            }
            us.pinguo.common.log.a.k(" FullImageJob:" + this.a, new Object[0]);
            return this.a.B().a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    public class d implements Runnable, com.pinguo.album.d<BitmapRegionDecoder> {
        private final Path a;
        private com.pinguo.album.c<BitmapRegionDecoder> b;

        public d(com.pinguo.camera360.gallery.data.w wVar) {
            this.a = wVar.g();
        }

        @Override // com.pinguo.album.d
        public void b(com.pinguo.album.c<BitmapRegionDecoder> cVar) {
            this.b = cVar;
            b0.this.f6318l.sendMessage(b0.this.f6318l.obtainMessage(3, this));
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.e0(this.a, this.b);
        }
    }

    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    private class e implements Callable<m> {
        private e() {
        }

        private boolean b() {
            int i2 = b0.this.f6311e;
            for (int i3 = b0.this.f6310d; i3 < i2; i3++) {
                if (b0.this.c[i3 % 32] == null) {
                    return true;
                }
            }
            return b0.this.c[b0.this.f6315i % 32] == null;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public m call() throws Exception {
            m mVar = new m(null);
            mVar.a = b0.this.q;
            mVar.b = b();
            mVar.c = b0.this.f6315i;
            mVar.f6324d = b0.this.f6310d;
            mVar.f6325e = b0.this.f6311e;
            mVar.f6326f = b0.this.r;
            return mVar;
        }

        /* synthetic */ e(b0 b0Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    public static class g {
        int a;
        int b;

        public g(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    public class i implements a.b<com.pinguo.album.opengles.s> {
        private com.pinguo.camera360.gallery.data.w a;

        public i(com.pinguo.camera360.gallery.data.w wVar) {
            this.a = wVar;
        }

        @Override // com.pinguo.album.a.b
        /* renamed from: b */
        public com.pinguo.album.opengles.s a(a.c cVar) {
            com.pinguo.album.opengles.s u = this.a.u();
            if (u != null) {
                return u;
            }
            if (b0.this.Z(this.a)) {
                return b0.this.a0(this.a);
            }
            Bitmap a = this.a.A(1).a(cVar);
            if (cVar.isCancelled()) {
                return null;
            }
            if (a != null) {
                a = com.pinguo.album.data.utils.b.l(a, this.a.t() - this.a.p(), true);
            }
            if (a == null) {
                return null;
            }
            return new com.pinguo.album.opengles.b(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    public class j implements Runnable, com.pinguo.album.d<com.pinguo.album.opengles.s> {
        private final Path a;
        private com.pinguo.album.c<com.pinguo.album.opengles.s> b;

        public j(com.pinguo.camera360.gallery.data.w wVar) {
            this.a = wVar.g();
        }

        @Override // com.pinguo.album.d
        public void b(com.pinguo.album.c<com.pinguo.album.opengles.s> cVar) {
            this.b = cVar;
            b0.this.f6318l.sendMessage(b0.this.f6318l.obtainMessage(3, this));
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.i0(this.a, this.b);
        }
    }

    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    private class k implements com.pinguo.camera360.gallery.data.n {
        private k() {
        }

        @Override // com.pinguo.camera360.gallery.data.n
        public void a() {
            if (b0.this.p != null) {
                b0.this.p.a();
            }
        }

        /* synthetic */ k(b0 b0Var, a aVar) {
            this();
        }
    }

    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    private class l implements Callable<Void> {
        m a;

        public l(m mVar) {
            this.a = mVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Void call() throws Exception {
            m mVar = this.a;
            b0.this.q = mVar.a;
            if (mVar.f6326f != b0.this.r) {
                b0.this.r = mVar.f6326f;
                if (b0.this.f6311e > b0.this.r) {
                    b0 b0Var = b0.this;
                    b0Var.f6311e = b0Var.r;
                }
                if (b0.this.f6314h > b0.this.r) {
                    b0 b0Var2 = b0.this;
                    b0Var2.f6314h = b0Var2.r;
                }
            }
            b0.this.f6315i = mVar.c;
            b0.this.j0();
            if (mVar.f6327g != null) {
                int max = Math.max(mVar.f6324d, b0.this.f6310d);
                int min = Math.min(mVar.f6324d + mVar.f6327g.size(), b0.this.f6311e);
                int i2 = max % 32;
                while (max < min) {
                    b0.this.c[i2] = mVar.f6327g.get(max - mVar.f6324d);
                    i2++;
                    if (i2 == 32) {
                        i2 = 0;
                    }
                    max++;
                }
            }
            b0.this.f0();
            b0.this.k0();
            b0.this.g0();
            b0.this.S();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    public static class m {
        public long a;
        public boolean b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f6324d;

        /* renamed from: e  reason: collision with root package name */
        public int f6325e;

        /* renamed from: f  reason: collision with root package name */
        public int f6326f;

        /* renamed from: g  reason: collision with root package name */
        public ArrayList<com.pinguo.camera360.gallery.data.w> f6327g;

        private m() {
        }

        /* synthetic */ m(a aVar) {
            this();
        }
    }

    static {
        g[] gVarArr = new g[12];
        z = gVarArr;
        gVarArr[0] = new g(0, 1);
        int i2 = 1;
        for (int i3 = 1; i3 < 5; i3++) {
            g[] gVarArr2 = z;
            int i4 = i2 + 1;
            gVarArr2[i2] = new g(i3, 1);
            i2 = i4 + 1;
            gVarArr2[i4] = new g(-i3, 1);
        }
        g[] gVarArr3 = z;
        int i5 = i2 + 1;
        gVarArr3[i2] = new g(0, 2);
        gVarArr3[i5] = new g(1, 2);
        gVarArr3[i5 + 1] = new g(-1, 2);
    }

    public b0(com.pinguo.camera360.gallery.l lVar, com.pinguo.camera360.gallery.ui.u uVar, com.pinguo.camera360.gallery.data.y yVar, int i2, int i3) {
        this.b = new com.pinguo.album.h.a();
        this.c = new com.pinguo.camera360.gallery.data.w[32];
        this.f6310d = 0;
        this.f6311e = 0;
        this.f6312f = new HashMap<>();
        this.f6313g = 0;
        this.f6314h = 0;
        long[] jArr = new long[5];
        this.f6316j = jArr;
        this.f6317k = new Path[5];
        this.q = -1L;
        this.r = 0;
        this.u = 0;
        this.w = new k(this, null);
        com.pinguo.album.j.a.c(yVar);
        com.pinguo.camera360.gallery.data.y yVar2 = yVar;
        this.o = yVar2;
        com.pinguo.album.j.a.c(uVar);
        com.pinguo.camera360.gallery.ui.u uVar2 = uVar;
        this.n = uVar2;
        this.f6315i = i2;
        this.m = lVar.G();
        us.pinguo.common.log.a.m("PhotoDataAdapter", "PhotoDataAdapterPhotoDataAdapter mSource = " + yVar2 + "mPhotoView = " + uVar2 + "mCurrentIndex =" + this.f6315i, new Object[0]);
        this.t = true;
        Arrays.fill(jArr, -1L);
        this.f6318l = new a(lVar.E());
        j0();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inJustDecodeBounds = false;
        options.inSampleSize = 2;
        this.a = new com.pinguo.album.opengles.r(lVar.a(), R.drawable.gg_album_photo_default);
        if (com.pinguo.camera360.gallery.i0.a.c().d() || !(yVar2 instanceof com.pinguo.camera360.gallery.data.z)) {
            return;
        }
        yVar2.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> T R(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        Handler handler = this.f6318l;
        handler.sendMessage(handler.obtainMessage(3, futureTask));
        try {
            return (T) futureTask.get();
        } catch (InterruptedException unused) {
            return null;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        boolean z2 = false;
        for (int i2 = -2; i2 <= 2; i2++) {
            long Y = Y(this.f6315i + i2);
            long[] jArr = this.f6316j;
            int i3 = i2 + 2;
            if (jArr[i3] != Y) {
                jArr[i3] = Y;
                z2 = true;
            }
        }
        if (z2) {
            int[] iArr = new int[5];
            Path[] pathArr = new Path[5];
            System.arraycopy(this.f6317k, 0, pathArr, 0, 5);
            for (int i4 = 0; i4 < 5; i4++) {
                this.f6317k[i4] = X((this.f6315i + i4) - 2);
            }
            for (int i5 = 0; i5 < 5; i5++) {
                Path path = this.f6317k[i5];
                if (path == null) {
                    iArr[i5] = Integer.MAX_VALUE;
                } else {
                    int i6 = 0;
                    while (i6 < 5 && pathArr[i6] != path) {
                        i6++;
                    }
                    iArr[i5] = i6 < 5 ? i6 - 2 : Integer.MAX_VALUE;
                }
            }
            com.pinguo.camera360.gallery.ui.u uVar = this.n;
            int i7 = this.f6315i;
            uVar.J0(iArr, -i7, (this.r - 1) - i7);
        }
    }

    private void T(int i2, u.h hVar) {
        com.pinguo.album.opengles.b bVar;
        if (i2 == this.x && (bVar = this.y) != null) {
            hVar.a = bVar.getWidth();
            hVar.b = this.y.getHeight();
            return;
        }
        hVar.a = 0;
        hVar.b = 0;
    }

    private com.pinguo.album.opengles.s U(int i2, com.pinguo.album.opengles.s sVar) {
        com.pinguo.album.opengles.b bVar;
        if (sVar == null && i2 == this.x && (bVar = this.y) != null) {
            return bVar;
        }
        return null;
    }

    private com.pinguo.camera360.gallery.data.w V(int i2) {
        if (i2 >= 0 && i2 < this.r && this.s) {
            com.pinguo.album.j.a.a(i2 >= this.f6313g && i2 < this.f6314h);
            if (i2 >= this.f6310d && i2 < this.f6311e) {
                return this.c[i2 % 32];
            }
        }
        return null;
    }

    private com.pinguo.camera360.gallery.data.w W(int i2) {
        if (i2 < 0 || i2 >= this.r || i2 < this.f6310d || i2 >= this.f6311e) {
            return null;
        }
        return this.c[i2 % 32];
    }

    private Path X(int i2) {
        com.pinguo.camera360.gallery.data.w W = W(i2);
        if (W == null) {
            return null;
        }
        return W.g();
    }

    private long Y(int i2) {
        com.pinguo.camera360.gallery.data.w W = W(i2);
        if (W == null) {
            return -1L;
        }
        return W.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z(com.pinguo.camera360.gallery.data.w wVar) {
        if (wVar instanceof com.pinguo.camera360.gallery.data.t) {
            com.pinguo.camera360.gallery.data.t tVar = (com.pinguo.camera360.gallery.data.t) wVar;
            return tVar.D() == 1 && tVar.E() == 0 && tVar.w() != 0 && tVar.q() != 0 && tVar.n() - System.currentTimeMillis() <= 10000;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.pinguo.album.opengles.s a0(com.pinguo.camera360.gallery.data.w wVar) {
        return new com.pinguo.album.opengles.b(wVar.w(), wVar.q(), this.a);
    }

    private com.pinguo.album.c<?> c0(int i2, int i3) {
        f fVar;
        com.pinguo.album.c<BitmapRegionDecoder> cVar;
        com.pinguo.album.c<com.pinguo.album.opengles.s> cVar2;
        if (i2 < this.f6313g || i2 >= this.f6314h || (fVar = this.f6312f.get(X(i2))) == null) {
            return null;
        }
        com.pinguo.camera360.gallery.data.w wVar = this.c[i2 % 32];
        com.pinguo.album.j.a.a(wVar != null);
        long d2 = wVar.d();
        if (i3 == 1 && (cVar2 = fVar.c) != null && fVar.f6320e == d2) {
            return cVar2;
        }
        if (i3 == 2 && (cVar = fVar.f6319d) != null && fVar.f6321f == d2) {
            return cVar;
        }
        if (i3 == 1 && fVar.f6320e != d2) {
            fVar.f6320e = d2;
            com.pinguo.album.c<com.pinguo.album.opengles.s> b2 = this.m.b(new i(wVar), new j(wVar));
            fVar.c = b2;
            return b2;
        }
        if (i3 == 2 && fVar.f6321f != d2 && (wVar.h() & 64) != 0) {
            fVar.f6321f = d2;
            us.pinguo.common.log.a.k(" requestedFullImage", new Object[0]);
            com.pinguo.album.c<BitmapRegionDecoder> b3 = this.m.b(new c(wVar), new d(wVar));
            fVar.f6319d = b3;
            return b3;
        }
        return null;
    }

    private void d0(int i2) {
        if (this.f6315i < 0) {
            return;
        }
        this.f6315i = i2;
        j0();
        f0();
        g0();
        k0();
        b bVar = this.v;
        if (bVar != null) {
            bVar.a(i2, "");
        }
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(Path path, com.pinguo.album.c<BitmapRegionDecoder> cVar) {
        f fVar = this.f6312f.get(path);
        if (fVar != null && fVar.f6319d == cVar) {
            fVar.f6319d = null;
            BitmapRegionDecoder bitmapRegionDecoder = cVar.get();
            fVar.a = bitmapRegionDecoder;
            if (bitmapRegionDecoder != null && path == X(this.f6315i)) {
                l0(fVar);
                this.n.K0(0);
            }
            g0();
            return;
        }
        BitmapRegionDecoder bitmapRegionDecoder2 = cVar.get();
        if (bitmapRegionDecoder2 != null) {
            bitmapRegionDecoder2.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        HashSet hashSet = new HashSet(this.f6312f.keySet());
        for (int i2 = this.f6313g; i2 < this.f6314h; i2++) {
            com.pinguo.camera360.gallery.data.w wVar = this.c[i2 % 32];
            if (wVar != null) {
                Path g2 = wVar.g();
                f fVar = this.f6312f.get(g2);
                hashSet.remove(g2);
                if (fVar != null) {
                    if (Math.abs(i2 - this.f6315i) > 1) {
                        com.pinguo.album.c<BitmapRegionDecoder> cVar = fVar.f6319d;
                        if (cVar != null) {
                            cVar.cancel();
                            fVar.f6319d = null;
                        }
                        fVar.a = null;
                        fVar.f6321f = -1L;
                    }
                    if (fVar.f6320e != wVar.d()) {
                        com.pinguo.album.opengles.s sVar = fVar.b;
                        if (sVar instanceof com.pinguo.album.opengles.b) {
                            ((com.pinguo.album.opengles.b) sVar).k(wVar.w(), wVar.q());
                        }
                    }
                } else {
                    this.f6312f.put(g2, new f(null));
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            f remove = this.f6312f.remove((Path) it.next());
            com.pinguo.album.c<BitmapRegionDecoder> cVar2 = remove.f6319d;
            if (cVar2 != null) {
                cVar2.cancel();
            }
            com.pinguo.album.c<com.pinguo.album.opengles.s> cVar3 = remove.c;
            if (cVar3 != null) {
                cVar3.cancel();
            }
            com.pinguo.album.opengles.s sVar2 = remove.b;
            if (sVar2 != null) {
                sVar2.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0() {
        if (this.s) {
            int i2 = this.f6315i;
            com.pinguo.camera360.gallery.data.w wVar = this.c[i2 % 32];
            int i3 = 0;
            us.pinguo.common.log.a.m("PhotoDataAdapter", "PhotoDataAdapterupdateImageRequests item = " + wVar, new Object[0]);
            if (wVar == null) {
                return;
            }
            com.pinguo.album.c<?> cVar = null;
            while (true) {
                g[] gVarArr = z;
                if (i3 >= gVarArr.length) {
                    break;
                }
                int i4 = gVarArr[i3].a;
                int i5 = gVarArr[i3].b;
                if ((i5 != 2 || this.t) && (cVar = c0(i4 + i2, i5)) != null) {
                    break;
                }
                i3++;
            }
            for (f fVar : this.f6312f.values()) {
                com.pinguo.album.c<com.pinguo.album.opengles.s> cVar2 = fVar.c;
                if (cVar2 != null && cVar2 != cVar) {
                    cVar2.cancel();
                    fVar.c = null;
                    fVar.f6320e = -1L;
                }
                com.pinguo.album.c<BitmapRegionDecoder> cVar3 = fVar.f6319d;
                if (cVar3 != null && cVar3 != cVar) {
                    cVar3.cancel();
                    fVar.f6319d = null;
                    fVar.f6321f = -1L;
                }
            }
        }
    }

    private void h0(int i2) {
        com.pinguo.album.opengles.b bVar;
        if (i2 == this.x && (bVar = this.y) != null) {
            this.b.u(this.y, bVar.getWidth(), this.y.getHeight());
        } else {
            this.b.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0(Path path, com.pinguo.album.c<com.pinguo.album.opengles.s> cVar) {
        f fVar = this.f6312f.get(path);
        com.pinguo.album.opengles.s sVar = cVar.get();
        if (fVar == null || fVar.c != cVar) {
            if (sVar != null) {
                sVar.recycle();
                return;
            }
            return;
        }
        fVar.c = null;
        com.pinguo.album.opengles.s sVar2 = fVar.b;
        if (sVar2 instanceof com.pinguo.album.opengles.b) {
            sVar = ((com.pinguo.album.opengles.b) sVar2).d(sVar);
        }
        if (sVar == null) {
            fVar.f6322g = true;
        } else {
            fVar.f6322g = false;
            fVar.b = sVar;
        }
        int i2 = -2;
        while (true) {
            if (i2 > 2) {
                break;
            } else if (path == X(this.f6315i + i2)) {
                if (i2 == 0) {
                    l0(fVar);
                }
                this.n.K0(i2);
            } else {
                i2++;
            }
        }
        g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j0() {
        int e2 = com.pinguo.album.j.a.e(this.f6315i - 2, 0, Math.max(0, this.r - 5));
        int min = Math.min(this.r, e2 + 5);
        if (this.f6313g == e2 && this.f6314h == min) {
            return;
        }
        this.f6313g = e2;
        this.f6314h = min;
        int e3 = com.pinguo.album.j.a.e(this.f6315i - 16, 0, Math.max(0, this.r - 32));
        int min2 = Math.min(this.r, e3 + 32);
        int i2 = this.f6310d;
        if (i2 > this.f6313g || this.f6311e < this.f6314h || Math.abs(e3 - i2) > 8) {
            for (int i3 = this.f6310d; i3 < this.f6311e; i3++) {
                if (i3 < e3 || i3 >= min2) {
                    this.c[i3 % 32] = null;
                }
            }
            this.f6310d = e3;
            this.f6311e = min2;
            h hVar = this.p;
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        f fVar = this.f6312f.get(X(this.f6315i));
        if (fVar == null) {
            h0(this.f6315i);
        } else {
            l0(fVar);
        }
    }

    private void l0(f fVar) {
        com.pinguo.album.opengles.s sVar = fVar.b;
        BitmapRegionDecoder bitmapRegionDecoder = fVar.a;
        if (sVar == null) {
            this.b.r();
        } else if (bitmapRegionDecoder != null) {
            this.b.u(sVar, bitmapRegionDecoder.getWidth(), bitmapRegionDecoder.getHeight());
            this.b.t(bitmapRegionDecoder);
        } else {
            this.b.u(sVar, sVar.getWidth(), sVar.getHeight());
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public boolean a(int i2) {
        com.pinguo.camera360.gallery.data.w V = V(this.f6315i + i2);
        return V != null && V.y();
    }

    @Override // com.pinguo.album.views.c.e
    public int b() {
        return this.b.b();
    }

    public void b0(b bVar) {
        this.v = bVar;
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public com.pinguo.album.opengles.s c(int i2) {
        int i3 = this.f6315i + i2;
        if (i3 >= 0 && i3 < this.r && this.s) {
            com.pinguo.album.j.a.a(i3 >= this.f6313g && i3 < this.f6314h);
            com.pinguo.camera360.gallery.data.w V = V(i3);
            if (V == null) {
                return U(i3, null);
            }
            f fVar = this.f6312f.get(V.g());
            if (fVar == null) {
                return U(i3, null);
            }
            if (fVar.b == null) {
                com.pinguo.album.opengles.s U = U(i3, null);
                fVar.b = U;
                if (U == null) {
                    fVar.b = a0(V);
                }
                if (i2 == 0) {
                    l0(fVar);
                }
            }
            return fVar.b;
        }
        return U(i3, null);
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public int d() {
        return this.f6315i;
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public int e(int i2) {
        com.pinguo.camera360.gallery.data.w V = V(this.f6315i + i2);
        if (V == null) {
            return 0;
        }
        return V.p();
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public void f(int i2) {
        this.u = i2;
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public com.pinguo.camera360.gallery.data.w g(int i2) {
        int i3 = this.f6315i + i2;
        if (i3 < this.f6310d || i3 >= this.f6311e) {
            return null;
        }
        return this.c[i3 % 32];
    }

    @Override // com.pinguo.album.views.c.e
    public int h() {
        com.pinguo.album.opengles.b bVar;
        if (this.b.k() == 0 && this.b.h() == 0 && this.f6315i == this.x && (bVar = this.y) != null) {
            return bVar.getHeight();
        }
        return this.b.h();
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public int i(int i2) {
        f fVar = this.f6312f.get(X(this.f6315i + i2));
        if (fVar == null) {
            return 0;
        }
        if (fVar.f6322g) {
            return 2;
        }
        return fVar.b != null ? 1 : 0;
    }

    @Override // com.pinguo.camera360.gallery.c0.f
    public boolean isEmpty() {
        return this.r == 0;
    }

    @Override // com.pinguo.album.views.c.e
    public com.pinguo.album.opengles.s j() {
        return c(0);
    }

    @Override // com.pinguo.album.views.c.e
    public int k() {
        com.pinguo.album.opengles.b bVar;
        if (this.b.k() == 0 && this.b.h() == 0 && this.f6315i == this.x && (bVar = this.y) != null) {
            return bVar.getWidth();
        }
        return this.b.k();
    }

    @Override // com.pinguo.album.views.c.e
    public Bitmap l(int i2, int i3, int i4, int i5) {
        return this.b.l(i2, i3, i4, i5);
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public void m(int i2) {
        if (i2 >= 0) {
            d0(i2);
        }
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public void n(int i2, u.h hVar) {
        com.pinguo.camera360.gallery.data.w V = V(this.f6315i + i2);
        if (V == null) {
            T(i2, hVar);
            return;
        }
        hVar.a = V.w();
        hVar.b = V.q();
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public boolean o(int i2) {
        com.pinguo.camera360.gallery.data.w V = V(this.f6315i + i2);
        return (V == null || (V.h() & 1) == 0) ? false : true;
    }

    @Override // com.pinguo.camera360.gallery.ui.u.c
    public void p(boolean z2) {
        this.t = z2;
        this.f6318l.sendEmptyMessage(4);
    }

    @Override // com.pinguo.camera360.gallery.c0.f
    public void pause() {
        this.s = false;
        this.p.b();
        this.p = null;
        this.o.y(this.w);
        for (f fVar : this.f6312f.values()) {
            com.pinguo.album.c<BitmapRegionDecoder> cVar = fVar.f6319d;
            if (cVar != null) {
                cVar.cancel();
            }
            com.pinguo.album.c<com.pinguo.album.opengles.s> cVar2 = fVar.c;
            if (cVar2 != null) {
                cVar2.cancel();
            }
            com.pinguo.album.opengles.s sVar = fVar.b;
            if (sVar != null) {
                sVar.recycle();
            }
        }
        com.pinguo.album.opengles.b bVar = this.y;
        if (bVar != null) {
            bVar.recycle();
            this.y = null;
        }
        this.f6312f.clear();
        this.b.r();
    }

    @Override // com.pinguo.camera360.gallery.c0.f
    public void resume() {
        this.s = true;
        this.o.k(this.w);
        f0();
        g0();
        h hVar = new h(this, null);
        this.p = hVar;
        hVar.start();
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    public static class f {
        public BitmapRegionDecoder a;
        public com.pinguo.album.opengles.s b;
        public com.pinguo.album.c<com.pinguo.album.opengles.s> c;

        /* renamed from: d  reason: collision with root package name */
        public com.pinguo.album.c<BitmapRegionDecoder> f6319d;

        /* renamed from: e  reason: collision with root package name */
        public long f6320e;

        /* renamed from: f  reason: collision with root package name */
        public long f6321f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f6322g;

        private f() {
            this.f6320e = -1L;
            this.f6321f = -1L;
            this.f6322g = false;
        }

        /* synthetic */ f(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PhotoDataAdapter.java */
    /* loaded from: classes3.dex */
    public class h extends Thread {
        private volatile boolean a;
        private volatile boolean b;
        private boolean c;

        private h() {
            this.a = true;
            this.b = true;
            this.c = false;
        }

        private void c(boolean z) {
            if (this.c == z) {
                return;
            }
            this.c = z;
            b0.this.f6318l.sendEmptyMessage(z ? 1 : 2);
        }

        public synchronized void a() {
            this.b = true;
            notifyAll();
        }

        public synchronized void b() {
            this.a = false;
            notifyAll();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.a) {
                synchronized (this) {
                    if (!this.b && this.a) {
                        c(false);
                        com.pinguo.album.j.a.r(this);
                    } else {
                        this.b = false;
                        b0 b0Var = b0.this;
                        m mVar = (m) b0Var.R(new e(b0Var, null));
                        synchronized (com.pinguo.camera360.gallery.data.o.f6371d) {
                            c(true);
                            if (mVar.a != b0.this.o.x()) {
                                mVar.b = true;
                                mVar.f6326f = b0.this.o.r();
                            }
                            if (mVar.b) {
                                mVar.f6327g = b0.this.o.q(mVar.f6324d, mVar.f6325e);
                                int i2 = mVar.c;
                                if (b0.this.u == 1 && i2 > 0) {
                                    i2--;
                                }
                                int i3 = mVar.f6326f;
                                if (i3 > 0) {
                                    if (i2 >= i3) {
                                        i2 = i3 - 1;
                                    }
                                    mVar.c = i2;
                                }
                                b0 b0Var2 = b0.this;
                                b0Var2.R(new l(mVar));
                            }
                        }
                    }
                }
            }
        }

        /* synthetic */ h(b0 b0Var, a aVar) {
            this();
        }
    }

    public b0(com.pinguo.camera360.gallery.l lVar, com.pinguo.camera360.gallery.ui.u uVar, com.pinguo.camera360.gallery.data.y yVar, int i2, com.pinguo.album.opengles.c cVar, int i3) {
        this(lVar, uVar, yVar, i2, i3);
        this.x = i2;
        if (i2 < 0 || cVar == null) {
            return;
        }
        com.pinguo.album.opengles.b bVar = new com.pinguo.album.opengles.b(cVar);
        this.y = bVar;
        bVar.j(true);
    }
}
