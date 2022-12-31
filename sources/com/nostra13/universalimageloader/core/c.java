package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
/* compiled from: DisplayImageOptions.java */
/* loaded from: classes3.dex */
public final class c {
    private final int a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final Drawable f5933d;

    /* renamed from: e  reason: collision with root package name */
    private final Drawable f5934e;

    /* renamed from: f  reason: collision with root package name */
    private final Drawable f5935f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f5936g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f5937h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f5938i;

    /* renamed from: j  reason: collision with root package name */
    private final ImageScaleType f5939j;

    /* renamed from: k  reason: collision with root package name */
    private final BitmapFactory.Options f5940k;

    /* renamed from: l  reason: collision with root package name */
    private final int f5941l;
    private final boolean m;
    private final Object n;
    private final com.nostra13.universalimageloader.core.l.a o;
    private final com.nostra13.universalimageloader.core.l.a p;
    private final com.nostra13.universalimageloader.core.i.a q;
    private final Handler r;
    private final boolean s;

    /* compiled from: DisplayImageOptions.java */
    /* loaded from: classes3.dex */
    public static class b {
        private int a = 0;
        private int b = 0;
        private int c = 0;

        /* renamed from: d  reason: collision with root package name */
        private Drawable f5942d = null;

        /* renamed from: e  reason: collision with root package name */
        private Drawable f5943e = null;

        /* renamed from: f  reason: collision with root package name */
        private Drawable f5944f = null;

        /* renamed from: g  reason: collision with root package name */
        private boolean f5945g = false;

        /* renamed from: h  reason: collision with root package name */
        private boolean f5946h = false;

        /* renamed from: i  reason: collision with root package name */
        private boolean f5947i = false;

        /* renamed from: j  reason: collision with root package name */
        private ImageScaleType f5948j = ImageScaleType.IN_SAMPLE_POWER_OF_2;

        /* renamed from: k  reason: collision with root package name */
        private BitmapFactory.Options f5949k = new BitmapFactory.Options();

        /* renamed from: l  reason: collision with root package name */
        private int f5950l = 0;
        private boolean m = false;
        private Object n = null;
        private com.nostra13.universalimageloader.core.l.a o = null;
        private com.nostra13.universalimageloader.core.l.a p = null;
        private com.nostra13.universalimageloader.core.i.a q = com.nostra13.universalimageloader.core.a.a();
        private Handler r = null;
        private boolean s = false;

        public b() {
            BitmapFactory.Options options = this.f5949k;
            options.inPurgeable = true;
            options.inInputShareable = true;
        }

        public b A(ImageScaleType imageScaleType) {
            this.f5948j = imageScaleType;
            return this;
        }

        public b B(com.nostra13.universalimageloader.core.l.a aVar) {
            this.p = aVar;
            return this;
        }

        public b C(com.nostra13.universalimageloader.core.l.a aVar) {
            this.o = aVar;
            return this;
        }

        public b D(boolean z) {
            this.f5945g = z;
            return this;
        }

        public b E(int i2) {
            this.b = i2;
            return this;
        }

        public b F(Drawable drawable) {
            this.f5943e = drawable;
            return this;
        }

        public b G(int i2) {
            this.c = i2;
            return this;
        }

        public b H(Drawable drawable) {
            this.f5944f = drawable;
            return this;
        }

        public b I(int i2) {
            this.a = i2;
            return this;
        }

        public b J(Drawable drawable) {
            this.f5942d = drawable;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b K(boolean z) {
            this.s = z;
            return this;
        }

        public c t() {
            return new c(this);
        }

        public b u(boolean z) {
            this.f5946h = z;
            return this;
        }

        public b v(boolean z) {
            this.f5947i = z;
            return this;
        }

        public b w(c cVar) {
            this.a = cVar.a;
            this.b = cVar.b;
            this.c = cVar.c;
            this.f5942d = cVar.f5933d;
            this.f5943e = cVar.f5934e;
            this.f5944f = cVar.f5935f;
            this.f5945g = cVar.f5936g;
            this.f5946h = cVar.f5937h;
            this.f5947i = cVar.f5938i;
            this.f5948j = cVar.f5939j;
            this.f5949k = cVar.f5940k;
            this.f5950l = cVar.f5941l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.q = cVar.q;
            this.r = cVar.r;
            this.s = cVar.s;
            return this;
        }

        public b x(boolean z) {
            this.m = z;
            return this;
        }

        public b y(com.nostra13.universalimageloader.core.i.a aVar) {
            if (aVar != null) {
                this.q = aVar;
                return this;
            }
            throw new IllegalArgumentException("displayer can't be null");
        }

        public b z(Object obj) {
            this.n = obj;
            return this;
        }
    }

    public static c t() {
        return new b().t();
    }

    public Drawable A(Resources resources) {
        int i2 = this.c;
        return i2 != 0 ? resources.getDrawable(i2) : this.f5935f;
    }

    public Drawable B(Resources resources) {
        int i2 = this.a;
        return i2 != 0 ? resources.getDrawable(i2) : this.f5933d;
    }

    public ImageScaleType C() {
        return this.f5939j;
    }

    public com.nostra13.universalimageloader.core.l.a D() {
        return this.p;
    }

    public com.nostra13.universalimageloader.core.l.a E() {
        return this.o;
    }

    public boolean F() {
        return this.f5937h;
    }

    public boolean G() {
        return this.f5938i;
    }

    public boolean H() {
        return this.m;
    }

    public boolean I() {
        return this.f5936g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J() {
        return this.s;
    }

    public boolean K() {
        return this.f5941l > 0;
    }

    public boolean L() {
        return this.p != null;
    }

    public boolean M() {
        return this.o != null;
    }

    public boolean N() {
        return (this.f5934e == null && this.b == 0) ? false : true;
    }

    public boolean O() {
        return (this.f5935f == null && this.c == 0) ? false : true;
    }

    public boolean P() {
        return (this.f5933d == null && this.a == 0) ? false : true;
    }

    public BitmapFactory.Options u() {
        return this.f5940k;
    }

    public int v() {
        return this.f5941l;
    }

    public com.nostra13.universalimageloader.core.i.a w() {
        return this.q;
    }

    public Object x() {
        return this.n;
    }

    public Handler y() {
        return this.r;
    }

    public Drawable z(Resources resources) {
        int i2 = this.b;
        return i2 != 0 ? resources.getDrawable(i2) : this.f5934e;
    }

    private c(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f5933d = bVar.f5942d;
        this.f5934e = bVar.f5943e;
        this.f5935f = bVar.f5944f;
        this.f5936g = bVar.f5945g;
        this.f5937h = bVar.f5946h;
        this.f5938i = bVar.f5947i;
        this.f5939j = bVar.f5948j;
        this.f5940k = bVar.f5949k;
        this.f5941l = bVar.f5950l;
        this.m = bVar.m;
        this.n = bVar.n;
        this.o = bVar.o;
        this.p = bVar.p;
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
    }
}
