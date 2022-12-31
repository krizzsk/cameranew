package us.pinguo.camera2020.widget.bubbleSeekbar;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
/* compiled from: BubbleConfigBuilder.java */
/* loaded from: classes3.dex */
public class a {
    boolean A;
    C0366a B;
    private BubbleSeekBar D;
    float a;
    float b;
    float c;

    /* renamed from: d  reason: collision with root package name */
    boolean f9525d;

    /* renamed from: e  reason: collision with root package name */
    int f9526e;

    /* renamed from: f  reason: collision with root package name */
    int f9527f;

    /* renamed from: g  reason: collision with root package name */
    int f9528g;

    /* renamed from: h  reason: collision with root package name */
    int f9529h;

    /* renamed from: i  reason: collision with root package name */
    int f9530i;

    /* renamed from: j  reason: collision with root package name */
    int f9531j;

    /* renamed from: k  reason: collision with root package name */
    int f9532k;

    /* renamed from: l  reason: collision with root package name */
    int f9533l;
    int m;
    boolean n;
    boolean o;
    boolean p;
    b q;
    boolean r;
    int s;
    int t;
    boolean u;
    boolean v;
    int x;
    int y;
    int z;
    int w = us.pinguo.camera2020.widget.bubbleSeekbar.b.a(14.0f);
    boolean C = true;

    /* compiled from: BubbleConfigBuilder.java */
    /* renamed from: us.pinguo.camera2020.widget.bubbleSeekbar.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0366a {
        public c a;
        @DrawableRes
        public int b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public int f9534d;
        @ColorInt

        /* renamed from: e  reason: collision with root package name */
        public int f9535e;

        /* renamed from: f  reason: collision with root package name */
        public int f9536f;

        public C0366a(int i2, c cVar, String str, int i3, int i4, int i5) {
            this.a = cVar;
            this.b = i2;
            this.c = str;
            this.f9534d = i3;
            this.f9535e = i4;
            this.f9536f = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(BubbleSeekBar bubbleSeekBar) {
        this.D = bubbleSeekBar;
    }

    private void k() {
        if (this.a == this.b) {
            this.a = 0.0f;
            this.b = 100.0f;
        }
        float f2 = this.a;
        float f3 = this.b;
        if (f2 > f3) {
            this.b = f2;
            this.a = f3;
        }
        float f4 = this.c;
        float f5 = this.a;
        if (f4 < f5) {
            this.c = f5;
        }
        float f6 = this.c;
        float f7 = this.b;
        if (f6 > f7) {
            this.c = f7;
        }
        int i2 = this.f9527f;
        int i3 = this.f9526e;
        if (i2 < i3) {
            this.f9527f = i3 + us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f);
        }
        int i4 = this.f9530i * 2;
        int i5 = this.f9527f;
        if (i4 <= i5) {
            this.f9530i = (i5 / 2) + us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f);
        }
        int i6 = this.f9528g;
        int i7 = this.f9530i;
        if (i6 <= i7) {
            this.f9528g = i7 + us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f);
        }
        int i8 = this.f9529h;
        int i9 = this.f9528g;
        if (i8 <= i9) {
            this.f9529h = i9 + us.pinguo.camera2020.widget.bubbleSeekbar.b.a(2.0f);
        }
        if (this.m < 0) {
            this.m = 0;
        }
        if (this.m == 0) {
            this.v = false;
            this.o = false;
        }
        if (this.p && this.q == null) {
            this.p = false;
        }
        if (this.o) {
            this.r = false;
        }
    }

    public a A(int i2) {
        this.f9528g = i2;
        return this;
    }

    public a B(int i2) {
        this.f9529h = i2;
        return this;
    }

    public a C(int i2) {
        this.s = i2;
        return this;
    }

    public a D() {
        this.u = true;
        return this;
    }

    public a E(@ColorInt int i2) {
        this.f9531j = i2;
        this.f9532k = i2;
        return this;
    }

    public a F(int i2) {
        this.f9526e = i2;
        return this;
    }

    public a a() {
        this.o = true;
        return this;
    }

    public a b(@ColorInt int i2) {
        this.x = i2;
        return this;
    }

    public a c(@ColorInt int i2) {
        this.z = i2;
        return this;
    }

    public a d(int i2) {
        this.y = i2;
        return this;
    }

    public void e() {
        k();
        this.D.k(this);
    }

    public a f(C0366a c0366a) {
        this.B = c0366a;
        return this;
    }

    public float g() {
        return this.b;
    }

    public int h() {
        return this.m;
    }

    public int i() {
        return this.f9531j;
    }

    public int j() {
        return this.f9526e;
    }

    public boolean l() {
        return this.f9525d;
    }

    public boolean m() {
        return this.r;
    }

    public a n(float f2) {
        this.b = f2;
        return this;
    }

    public a o(float f2) {
        this.a = f2;
        this.c = f2;
        return this;
    }

    public a p(float f2) {
        this.c = f2;
        return this;
    }

    public a q(@ColorInt int i2) {
        this.f9532k = i2;
        this.f9533l = i2;
        this.t = i2;
        this.x = i2;
        return this;
    }

    public a r(int i2) {
        this.f9527f = i2;
        return this;
    }

    public a s(b bVar) {
        this.q = bVar;
        return this;
    }

    public a t(@IntRange(from = 1) int i2) {
        this.m = i2;
        return this;
    }

    public a u(int i2) {
        this.f9530i = i2;
        return this;
    }

    public a v() {
        this.v = true;
        return this;
    }

    public a w() {
        this.n = true;
        return this;
    }

    public a x() {
        this.p = true;
        return this;
    }

    public a y(boolean z) {
        this.C = z;
        return this;
    }

    public a z(@ColorInt int i2) {
        this.f9533l = i2;
        return this;
    }

    /* compiled from: BubbleConfigBuilder.java */
    /* loaded from: classes3.dex */
    public interface b {
        @ColorInt
        int a();

        c b();

        int c();

        C0367a d(int i2);

        /* compiled from: BubbleConfigBuilder.java */
        /* renamed from: us.pinguo.camera2020.widget.bubbleSeekbar.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0367a {
            @DrawableRes
            int a;
            String b;

            public C0367a(int i2, String str) {
                this.a = i2;
                this.b = str;
            }

            public boolean equals(Object obj) {
                String str;
                if (obj == null && (obj instanceof C0367a)) {
                    C0367a c0367a = (C0367a) obj;
                    if (c0367a.a != this.a) {
                        return false;
                    }
                    String str2 = this.b;
                    if (str2 == null || (str = c0367a.b) != null) {
                        return str2 == c0367a.b;
                    }
                    return str2.equals(str);
                }
                return false;
            }

            public C0367a() {
            }
        }
    }
}
