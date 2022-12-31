package com.pinguo.camera360.gallery.ui;

import android.graphics.Bitmap;
import android.os.Message;
import com.pinguo.camera360.gallery.data.y;
import com.pinguo.camera360.gallery.ui.i;
import com.pinguo.camera360.gallery.ui.j;
import com.tencent.bugly.crashreport.CrashReport;
import java.util.ArrayList;
/* compiled from: AlbumTagManager.java */
/* loaded from: classes3.dex */
public class l {
    public static int o = 7;
    public static int p = 8;
    private k b;
    private ArrayList<y.c> c;

    /* renamed from: i  reason: collision with root package name */
    private final com.pinguo.album.g f6606i;

    /* renamed from: j  reason: collision with root package name */
    private final com.pinguo.album.opengles.v f6607j;

    /* renamed from: k  reason: collision with root package name */
    private i f6608k;

    /* renamed from: l  reason: collision with root package name */
    private final com.pinguo.album.common.b f6609l;
    private i.c m;
    private int n;

    /* renamed from: d  reason: collision with root package name */
    private int f6601d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f6602e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f6603f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f6604g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f6605h = 0;
    private b[] a = new b[12];

    /* compiled from: AlbumTagManager.java */
    /* loaded from: classes3.dex */
    class a extends com.pinguo.album.g {
        a(l lVar, com.pinguo.album.views.b bVar) {
            super(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                ((c) message.obj).a();
            }
        }
    }

    /* compiled from: AlbumTagManager.java */
    /* loaded from: classes3.dex */
    public static class b {
        public com.pinguo.album.opengles.c a;
        public com.pinguo.album.opengles.u b;
        public com.pinguo.album.data.utils.c c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AlbumTagManager.java */
    /* loaded from: classes3.dex */
    public class c extends com.pinguo.album.data.utils.c {

        /* renamed from: d  reason: collision with root package name */
        private final int f6610d;

        /* renamed from: e  reason: collision with root package name */
        private final String f6611e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f6612f;

        public c(String str, boolean z, int i2) {
            this.f6610d = i2;
            this.f6611e = str;
            this.f6612f = z;
        }

        public void a() {
            Bitmap d2 = d();
            if (d2 == null) {
                return;
            }
            b bVar = l.this.a[this.f6610d % l.this.a.length];
            com.pinguo.album.opengles.c cVar = new com.pinguo.album.opengles.c(d2);
            cVar.E(false);
            bVar.a = cVar;
            bVar.b = cVar;
            if (l.this.p(this.f6610d)) {
                l.this.f6607j.d(bVar.a);
                l.h(l.this);
                if (l.this.f6605h == 0) {
                    l.this.u();
                }
                if (l.this.m != null) {
                    l.this.m.onContentChanged();
                    return;
                }
                return;
            }
            l.this.f6607j.c(bVar.a);
        }

        @Override // com.pinguo.album.data.utils.c
        protected void f(Bitmap bitmap) {
            l.this.f6606i.obtainMessage(1, this).sendToTarget();
        }

        @Override // com.pinguo.album.data.utils.c
        protected com.pinguo.album.c<Bitmap> j(com.pinguo.album.d<Bitmap> dVar) {
            return l.this.f6609l.a(l.this.b.g(this.f6611e, this.f6612f), dVar);
        }
    }

    public l(com.pinguo.camera360.gallery.l lVar, i iVar, com.pinguo.album.opengles.v vVar, j.d dVar, int i2, int i3, int i4) {
        this.n = o;
        this.f6609l = new com.pinguo.album.common.b(lVar.G(), 2);
        this.f6608k = iVar;
        this.f6607j = vVar;
        this.b = new k(us.pinguo.foundation.e.b(), dVar, i2, i3);
        this.f6606i = new a(this, lVar.E());
        this.n = i4;
    }

    private void B() {
        this.f6605h = 0;
        int i2 = this.f6604g;
        for (int i3 = this.f6603f; i3 < i2; i3++) {
            if (v(i3)) {
                this.f6605h++;
            }
        }
        if (this.f6605h == 0) {
            u();
        } else {
            k();
        }
    }

    private void C() {
        if (this.f6608k.r()) {
            this.f6607j.e();
            int i2 = this.f6604g;
            for (int i3 = this.f6603f; i3 < i2; i3++) {
                b[] bVarArr = this.a;
                com.pinguo.album.opengles.c cVar = bVarArr[i3 % bVarArr.length].a;
                if (cVar != null) {
                    this.f6607j.d(cVar);
                }
            }
            int max = Math.max(this.f6602e - this.f6604g, this.f6603f - this.f6601d);
            for (int i4 = 0; i4 < max; i4++) {
                D(this.f6604g + i4);
                D((this.f6603f - i4) - 1);
            }
        }
    }

    private void D(int i2) {
        if (i2 >= this.f6602e || i2 < this.f6601d) {
            return;
        }
        b[] bVarArr = this.a;
        com.pinguo.album.opengles.c cVar = bVarArr[i2 % bVarArr.length].a;
        if (cVar != null) {
            this.f6607j.c(cVar);
        }
    }

    static /* synthetic */ int h(l lVar) {
        int i2 = lVar.f6605h - 1;
        lVar.f6605h = i2;
        return i2;
    }

    private void k() {
        int max = Math.max(this.f6602e - this.f6604g, this.f6603f - this.f6601d);
        for (int i2 = 0; i2 < max; i2++) {
            l(this.f6604g + i2);
            l((this.f6603f - 1) - i2);
        }
    }

    private void l(int i2) {
        if (i2 < this.f6601d || i2 >= this.f6602e) {
            return;
        }
        b[] bVarArr = this.a;
        com.pinguo.album.data.utils.c cVar = bVarArr[i2 % bVarArr.length].c;
        if (cVar != null) {
            cVar.c();
        }
    }

    private void m(int i2) {
        b[] bVarArr = this.a;
        int length = i2 % bVarArr.length;
        b bVar = bVarArr[length];
        if (bVar == null) {
            return;
        }
        com.pinguo.album.data.utils.c cVar = bVar.c;
        if (cVar != null) {
            cVar.g();
        }
        com.pinguo.album.opengles.c cVar2 = bVar.a;
        if (cVar2 != null) {
            cVar2.o();
        }
        bVarArr[length] = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(int i2) {
        return i2 >= this.f6603f && i2 < this.f6604g;
    }

    private void r(int i2) {
        if (i2 < this.f6601d || i2 >= this.f6602e || !this.f6608k.r()) {
            return;
        }
        m(i2);
        t(i2);
        B();
        v(i2);
        if (this.m == null || !p(i2)) {
            return;
        }
        this.m.onContentChanged();
    }

    private void t(int i2) {
        b bVar = new b();
        y.c cVar = this.c.get(i2);
        bVar.c = new c(cVar.c, cVar.f6394f, i2);
        b[] bVarArr = this.a;
        bVarArr[i2 % bVarArr.length] = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        int max = Math.max(this.f6602e - this.f6604g, this.f6603f - this.f6601d);
        for (int i2 = 0; i2 < max; i2++) {
            v(this.f6604g + i2);
            v((this.f6603f - 1) - i2);
        }
    }

    private boolean v(int i2) {
        if (i2 < this.f6601d || i2 >= this.f6602e) {
            return false;
        }
        b[] bVarArr = this.a;
        b bVar = bVarArr[i2 % bVarArr.length];
        if (bVar.b != null) {
            return false;
        }
        bVar.c.i();
        return bVar.c.e();
    }

    private void z(int i2, int i3) {
        int i4;
        if (i2 == this.f6601d && i3 == this.f6602e) {
            return;
        }
        if (!this.f6608k.r()) {
            this.f6601d = i2;
            this.f6602e = i3;
            return;
        }
        int i5 = this.f6602e;
        if (i2 < i5 && (i4 = this.f6601d) < i3) {
            for (i4 = this.f6601d; i4 < i2; i4++) {
                m(i4);
            }
            int i6 = this.f6602e;
            for (int i7 = i3; i7 < i6; i7++) {
                m(i7);
            }
            int i8 = this.f6601d;
            for (int i9 = i2; i9 < i8; i9++) {
                t(i9);
            }
            for (int i10 = this.f6602e; i10 < i3; i10++) {
                t(i10);
            }
        } else {
            for (int i11 = this.f6601d; i11 < i5; i11++) {
                m(i11);
            }
            for (int i12 = i2; i12 < i3; i12++) {
                t(i12);
            }
        }
        this.f6601d = i2;
        this.f6602e = i3;
    }

    public void A(ArrayList<y.c> arrayList) {
        this.c = arrayList;
    }

    public y.c n(int i2) {
        return this.c.get(i2);
    }

    public b o(int i2) {
        if (!p(i2)) {
            if (us.pinguo.foundation.d.f10985d) {
                com.pinguo.album.j.a.k("invalid tag: %s outsides (%s, %s)", Integer.valueOf(i2), Integer.valueOf(this.f6603f), Integer.valueOf(this.f6604g));
                throw null;
            }
            return null;
        }
        b[] bVarArr = this.a;
        return bVarArr[i2 % bVarArr.length];
    }

    public void q(int i2, ArrayList<y.c> arrayList, ArrayList<y.c> arrayList2, ArrayList<y.b> arrayList3) {
        this.c = arrayList;
        int size = arrayList.size();
        if (this.f6602e > size) {
            this.f6602e = size;
        }
        i.c cVar = this.m;
        if (cVar != null) {
            if (this.n == o) {
                cVar.a(i2, arrayList, arrayList2, arrayList3);
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (i3 >= this.f6601d && i3 < this.f6602e) {
                    r(i3);
                }
            }
        }
    }

    public void s() {
        int i2 = this.f6602e;
        for (int i3 = this.f6601d; i3 < i2; i3++) {
            m(i3);
        }
    }

    public void w() {
        int i2 = this.f6602e;
        for (int i3 = this.f6601d; i3 < i2; i3++) {
            t(i3);
        }
        B();
    }

    public void x(int i2, int i3) {
        if (i2 > i3 || i3 - i2 > this.a.length || i3 > this.c.size()) {
            if (us.pinguo.foundation.d.f10985d) {
                com.pinguo.album.j.a.k("%s, %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.a.length), Integer.valueOf(this.c.size()));
                throw null;
            }
            CrashReport.postCatchedException(new IllegalArgumentException(String.format("%s, %s, %s, %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.a.length), Integer.valueOf(this.c.size()))));
        }
        b[] bVarArr = this.a;
        this.f6603f = i2;
        this.f6604g = i3;
        int e2 = com.pinguo.album.j.a.e(((i2 + i3) / 2) - (bVarArr.length / 2), 0, Math.max(0, this.c.size() - bVarArr.length));
        z(e2, Math.min(bVarArr.length + e2, this.c.size()));
        C();
        if (this.f6608k.r()) {
            B();
        }
    }

    public void y(i.c cVar) {
        this.m = cVar;
    }
}
