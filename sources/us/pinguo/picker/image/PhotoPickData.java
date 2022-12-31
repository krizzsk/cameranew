package us.pinguo.picker.image;

import java.util.ArrayList;
import kotlin.jvm.internal.s;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.picker.image.e;
import us.pinguo.picker.image.gallery.Path;
import us.pinguo.picker.image.gallery.m;
import us.pinguo.picker.image.gallery.o;
/* compiled from: PhotoPickData.kt */
/* loaded from: classes5.dex */
public final class PhotoPickData implements us.pinguo.picker.image.gallery.h, e.b {
    private Integer a;

    /* renamed from: d  reason: collision with root package name */
    private Integer f11638d;

    /* renamed from: f  reason: collision with root package name */
    private d f11640f;
    private boolean c = true;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<c> f11639e = new ArrayList<>();
    private final e b = new e(us.pinguo.picker.image.gallery.f.b(BaseApplication.e()).d(new Path(1011, "path-set"), ""));

    private final c o(int i2) {
        int h2;
        m v;
        o w = this.b.w(i2);
        if (w == null || (h2 = w.h()) == 0 || (v = this.b.v(i2)) == null) {
            return null;
        }
        return new c(w, v, this.b.u(i2), h2);
    }

    private final void p(c cVar) {
        int c = cVar.c();
        o d2 = cVar.d();
        this.a = Integer.valueOf(c);
        d dVar = this.f11640f;
        if (dVar != null) {
            dVar.T();
        }
        PuzzleTask.a.a(new PhotoPickData$loadMediaItemData$1(d2, c), new PhotoPickData$loadMediaItemData$2(this, c));
    }

    @Override // us.pinguo.picker.image.e.b
    public void a(int i2) {
        c o;
        if (this.c || (o = o(i2)) == null) {
            return;
        }
        this.f11639e.add(o);
        this.f11638d = Integer.valueOf(this.f11639e.size());
        d dVar = this.f11640f;
        if (dVar != null) {
            dVar.u(o, i2, this.b.B());
        }
        o d2 = o.d();
        Integer num = this.a;
        if (num == null) {
            if (s.c("Camera", d2.i())) {
                p(o);
            }
            if (i2 <= 5 || !(!this.f11639e.isEmpty())) {
                return;
            }
            c cVar = this.f11639e.get(0);
            s.g(cVar, "mediaSetList[0]");
            p(cVar);
        } else if (num.intValue() == o.c()) {
            p(o);
        }
    }

    @Override // us.pinguo.picker.image.e.b
    public void b(int i2) {
        d dVar;
        if (this.c) {
            return;
        }
        this.f11639e.clear();
        d dVar2 = this.f11640f;
        if (dVar2 != null) {
            dVar2.p(this.f11639e);
        }
        if (i2 != 0 || (dVar = this.f11640f) == null) {
            return;
        }
        dVar.w();
    }

    @Override // us.pinguo.picker.image.gallery.h
    public void c() {
        if (this.c) {
            return;
        }
        ArrayList<c> arrayList = this.f11639e;
        if (this.a == null) {
            if (!arrayList.isEmpty()) {
                c cVar = arrayList.get(0);
                s.g(cVar, "list[0]");
                p(cVar);
            } else {
                d dVar = this.f11640f;
                if (dVar != null) {
                    dVar.w();
                }
            }
        }
        this.f11638d = null;
    }

    @Override // us.pinguo.picker.image.gallery.h
    public void d() {
        if (this.c) {
            return;
        }
        this.f11638d = -1;
    }

    public final void i(Integer num) {
        if (s.c(num, this.a)) {
            return;
        }
        d dVar = this.f11640f;
        if (dVar != null) {
            dVar.T();
        }
        PuzzleTask.a.a(new PhotoPickData$changeMediaSet$1(this, num), new PhotoPickData$changeMediaSet$2(this));
    }

    public final void j() {
        this.b.z(this);
        this.b.A(this);
        this.b.r();
        this.c = false;
    }

    public final void k() {
        this.c = true;
        this.b.s();
        this.b.z(null);
        this.b.A(null);
    }

    public final void l(String str) {
        if (str == null) {
            return;
        }
        d dVar = this.f11640f;
        if (dVar != null) {
            dVar.T();
        }
        PuzzleTask.a.a(new PhotoPickData$findInMediaSet$1(this, str), new PhotoPickData$findInMediaSet$2(this));
    }

    public final Integer m() {
        return this.a;
    }

    public final d n() {
        return this.f11640f;
    }

    public final void q() {
        this.b.x();
    }

    public final void r() {
        this.b.y();
    }

    public final void s(d dVar) {
        this.f11640f = dVar;
    }
}
