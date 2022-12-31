package com.hw.photomovie;

import com.hw.photomovie.b.d;
import com.hw.photomovie.segment.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* compiled from: PhotoMovie.java */
/* loaded from: classes2.dex */
public class a<T> {
    private d a;
    private List<e<T>> b;
    private b<T> c;

    /* renamed from: d  reason: collision with root package name */
    private a<T>.C0198a f5148d;

    /* renamed from: e  reason: collision with root package name */
    private int f5149e;

    /* renamed from: f  reason: collision with root package name */
    private com.hw.photomovie.render.d f5150f;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: PhotoMovie.java */
    /* renamed from: com.hw.photomovie.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0198a {
        protected C0198a() {
        }

        public void a() {
            if (a.this.a == null || a.this.a.k() == 0 || a.this.b.size() == 0) {
                return;
            }
            int i2 = 0;
            for (e eVar : a.this.b) {
                int m = eVar.m();
                LinkedList linkedList = new LinkedList();
                while (m > 0) {
                    if (i2 >= a.this.a.k()) {
                        i2 = 0;
                    }
                    linkedList.add(a.this.a.e(i2));
                    m--;
                    i2++;
                }
                eVar.e(linkedList);
            }
        }
    }

    /* compiled from: PhotoMovie.java */
    /* loaded from: classes2.dex */
    public static class b<T> {
        private e<T> a;
        private e<T> b;
        private List<e<T>> c;

        /* renamed from: d  reason: collision with root package name */
        private a<T> f5151d;

        public b(a<T> aVar) {
            this.c = aVar.e();
            this.f5151d = aVar;
        }

        public e<T> a(int i2) {
            int d2 = this.f5151d.d();
            if (d2 > 0) {
                int size = this.c.size();
                if (i2 >= d2) {
                    return this.c.get(size - 1);
                }
                int i3 = 0;
                for (e<T> eVar : this.c) {
                    int k2 = eVar.k();
                    if (i2 >= i3 && i2 < i3 + k2) {
                        return eVar;
                    }
                    i3 += k2;
                }
                com.hw.photomovie.util.b.a("PhotoMovie", "getCurrentSegment 出错,elapsedTime:" + i2 + " 返回第一个片段");
                return this.c.get(0);
            }
            throw new RuntimeException("Segment duration must >0!");
        }

        public e<T> b() {
            List<e<T>> list = this.c;
            return list.get(list.size() - 1);
        }

        public e<T> c(int i2) {
            int d2 = this.f5151d.d();
            int size = this.c.size();
            if (i2 >= d2) {
                return this.c.get(0);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int k2 = this.c.get(i4).k();
                if (i2 >= i3 && i2 < i3 + k2) {
                    if (i4 < size - 1) {
                        return this.c.get(i4 + 1);
                    }
                    return this.c.get(0);
                }
                i3 += k2;
            }
            com.hw.photomovie.util.b.a("PhotoMovie", "getNextSegment 出错,elapsedTime:" + i2 + " 返回第一个片段");
            return this.c.get(0);
        }

        public float d(e<T> eVar, int i2) {
            float f2;
            Iterator<e<T>> it = this.c.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    f2 = 0.0f;
                    break;
                }
                e<T> next = it.next();
                if (next == eVar) {
                    f2 = (i2 - i3) / next.k();
                    if (f2 > 1.0f) {
                        f2 = 1.0f;
                    }
                } else {
                    i3 += next.k();
                }
            }
            if (f2 < 0.0f || f2 > 1.0f) {
                return 0.0f;
            }
            return f2;
        }

        public e e(int i2) {
            List<e<T>> list = this.c;
            if (list == null || list.size() == 0) {
                return null;
            }
            if (i2 == 0) {
                this.b = null;
                this.a = null;
            }
            e<T> a = a(i2);
            e<T> eVar = this.b;
            if (a != eVar) {
                if (eVar != null) {
                    eVar.q();
                    this.b.s();
                }
                this.b = a;
                com.hw.photomovie.util.b.c("TAG", "pick segment :" + a.toString());
            }
            e<T> c = c(i2);
            if (c != this.a) {
                com.hw.photomovie.util.b.c("TAG", "onPrepare next segment :" + c.toString());
                c.r();
                this.a = c;
            }
            return a;
        }
    }

    public a(d dVar, List<e<T>> list) {
        LinkedList linkedList = new LinkedList();
        this.b = linkedList;
        this.a = dVar;
        linkedList.addAll(list);
        this.f5148d = new C0198a();
        h();
        c();
        this.c = new b<>(this);
    }

    public int c() {
        int i2 = 0;
        for (e<T> eVar : this.b) {
            eVar.v(this);
            i2 += eVar.k();
        }
        this.f5149e = i2;
        return i2;
    }

    public int d() {
        return this.f5149e;
    }

    public List<e<T>> e() {
        return this.b;
    }

    public d f() {
        return this.a;
    }

    public b g() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        this.f5148d.a();
    }

    public void i(com.hw.photomovie.render.d dVar) {
        this.f5150f = dVar;
    }

    public void j(int i2) {
        com.hw.photomovie.render.d dVar = this.f5150f;
        if (dVar != null) {
            dVar.a(i2);
        }
    }
}
