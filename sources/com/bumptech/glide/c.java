package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.l.h;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.manager.g;
import com.bumptech.glide.manager.l;
import com.bumptech.glide.request.GenericRequest;
import com.bumptech.glide.request.g.j;
import java.util.Objects;
/* compiled from: GenericRequestBuilder.java */
/* loaded from: classes.dex */
public class c<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private Drawable A;
    private int B;
    protected final Context a;
    protected final e b;
    protected final Class<TranscodeType> c;

    /* renamed from: d  reason: collision with root package name */
    protected final l f615d;

    /* renamed from: e  reason: collision with root package name */
    protected final g f616e;

    /* renamed from: f  reason: collision with root package name */
    private com.bumptech.glide.j.a<ModelType, DataType, ResourceType, TranscodeType> f617f;

    /* renamed from: g  reason: collision with root package name */
    private ModelType f618g;

    /* renamed from: i  reason: collision with root package name */
    private boolean f620i;

    /* renamed from: j  reason: collision with root package name */
    private int f621j;

    /* renamed from: k  reason: collision with root package name */
    private int f622k;

    /* renamed from: l  reason: collision with root package name */
    private com.bumptech.glide.request.c<? super ModelType, TranscodeType> f623l;
    private Float m;
    private c<?, ?, ?, TranscodeType> n;
    private Drawable p;
    private Drawable q;
    private boolean y;
    private boolean z;

    /* renamed from: h  reason: collision with root package name */
    private com.bumptech.glide.load.b f619h = com.bumptech.glide.k.a.b();
    private Float o = Float.valueOf(1.0f);
    private Priority r = null;
    private boolean s = true;
    private com.bumptech.glide.request.f.d<TranscodeType> t = com.bumptech.glide.request.f.e.d();
    private int u = -1;
    private int v = -1;
    private DiskCacheStrategy w = DiskCacheStrategy.RESULT;
    private com.bumptech.glide.load.f<ResourceType> x = com.bumptech.glide.load.h.d.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GenericRequestBuilder.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, Class<ModelType> cls, com.bumptech.glide.j.f<ModelType, DataType, ResourceType, TranscodeType> fVar, Class<TranscodeType> cls2, e eVar, l lVar, g gVar) {
        this.a = context;
        this.c = cls2;
        this.b = eVar;
        this.f615d = lVar;
        this.f616e = gVar;
        this.f617f = fVar != null ? new com.bumptech.glide.j.a<>(fVar) : null;
        Objects.requireNonNull(context, "Context can't be null");
        if (cls != null) {
            Objects.requireNonNull(fVar, "LoadProvider must not be null");
        }
    }

    private com.bumptech.glide.request.a d(j<TranscodeType> jVar) {
        if (this.r == null) {
            this.r = Priority.NORMAL;
        }
        return e(jVar, null);
    }

    private com.bumptech.glide.request.a e(j<TranscodeType> jVar, com.bumptech.glide.request.e eVar) {
        c<?, ?, ?, TranscodeType> cVar = this.n;
        if (cVar != null) {
            if (!this.z) {
                if (cVar.t.equals(com.bumptech.glide.request.f.e.d())) {
                    this.n.t = this.t;
                }
                c<?, ?, ?, TranscodeType> cVar2 = this.n;
                if (cVar2.r == null) {
                    cVar2.r = i();
                }
                if (h.k(this.v, this.u)) {
                    c<?, ?, ?, TranscodeType> cVar3 = this.n;
                    if (!h.k(cVar3.v, cVar3.u)) {
                        this.n.o(this.v, this.u);
                    }
                }
                com.bumptech.glide.request.e eVar2 = new com.bumptech.glide.request.e(eVar);
                com.bumptech.glide.request.a n = n(jVar, this.o.floatValue(), this.r, eVar2);
                this.z = true;
                com.bumptech.glide.request.a e2 = this.n.e(jVar, eVar2);
                this.z = false;
                eVar2.k(n, e2);
                return eVar2;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.m != null) {
            com.bumptech.glide.request.e eVar3 = new com.bumptech.glide.request.e(eVar);
            eVar3.k(n(jVar, this.o.floatValue(), this.r, eVar3), n(jVar, this.m.floatValue(), i(), eVar3));
            return eVar3;
        } else {
            return n(jVar, this.o.floatValue(), this.r, eVar);
        }
    }

    private Priority i() {
        Priority priority = this.r;
        if (priority == Priority.LOW) {
            return Priority.NORMAL;
        }
        if (priority == Priority.NORMAL) {
            return Priority.HIGH;
        }
        return Priority.IMMEDIATE;
    }

    private com.bumptech.glide.request.a n(j<TranscodeType> jVar, float f2, Priority priority, com.bumptech.glide.request.b bVar) {
        return GenericRequest.s(this.f617f, this.f618g, this.f619h, this.a, priority, jVar, f2, this.p, this.f621j, this.q, this.f622k, this.A, this.B, this.f623l, bVar, this.b.m(), this.x, this.c, this.s, this.t, this.v, this.u, this.w);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c<ModelType, DataType, ResourceType, TranscodeType> a(com.bumptech.glide.request.f.d<TranscodeType> dVar) {
        Objects.requireNonNull(dVar, "Animation factory must not be null!");
        this.t = dVar;
        return this;
    }

    void b() {
    }

    void c() {
    }

    @Override // 
    /* renamed from: f */
    public c<ModelType, DataType, ResourceType, TranscodeType> clone() {
        try {
            c<ModelType, DataType, ResourceType, TranscodeType> cVar = (c) super.clone();
            com.bumptech.glide.j.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.f617f;
            cVar.f617f = aVar != null ? aVar.clone() : null;
            return cVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> g(com.bumptech.glide.load.d<DataType, ResourceType> dVar) {
        com.bumptech.glide.j.a<ModelType, DataType, ResourceType, TranscodeType> aVar = this.f617f;
        if (aVar != null) {
            aVar.i(dVar);
        }
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> h(DiskCacheStrategy diskCacheStrategy) {
        this.w = diskCacheStrategy;
        return this;
    }

    public j<TranscodeType> j(ImageView imageView) {
        h.a();
        if (imageView != null) {
            if (!this.y && imageView.getScaleType() != null) {
                int i2 = a.a[imageView.getScaleType().ordinal()];
                if (i2 == 1) {
                    b();
                } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                    c();
                }
            }
            j<TranscodeType> c = this.b.c(imageView, this.c);
            k(c);
            return c;
        }
        throw new IllegalArgumentException("You must pass in a non null View");
    }

    public <Y extends j<TranscodeType>> Y k(Y y) {
        h.a();
        if (y != null) {
            if (this.f620i) {
                com.bumptech.glide.request.a e2 = y.e();
                if (e2 != null) {
                    e2.clear();
                    this.f615d.c(e2);
                    e2.recycle();
                }
                com.bumptech.glide.request.a d2 = d(y);
                y.g(d2);
                this.f616e.a(y);
                this.f615d.f(d2);
                return y;
            }
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
        throw new IllegalArgumentException("You must pass in a non null Target");
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> l(com.bumptech.glide.request.c<? super ModelType, TranscodeType> cVar) {
        this.f623l = cVar;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> m(ModelType modeltype) {
        this.f618g = modeltype;
        this.f620i = true;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> o(int i2, int i3) {
        if (h.k(i2, i3)) {
            this.v = i2;
            this.u = i3;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> p(com.bumptech.glide.load.b bVar) {
        Objects.requireNonNull(bVar, "Signature must not be null");
        this.f619h = bVar;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> q(boolean z) {
        this.s = !z;
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> r(com.bumptech.glide.load.a<DataType> aVar) {
        com.bumptech.glide.j.a<ModelType, DataType, ResourceType, TranscodeType> aVar2 = this.f617f;
        if (aVar2 != null) {
            aVar2.j(aVar);
        }
        return this;
    }

    public c<ModelType, DataType, ResourceType, TranscodeType> s(com.bumptech.glide.load.f<ResourceType>... fVarArr) {
        this.y = true;
        if (fVarArr.length == 1) {
            this.x = fVarArr[0];
        } else {
            this.x = new com.bumptech.glide.load.c(fVarArr);
        }
        return this;
    }
}
