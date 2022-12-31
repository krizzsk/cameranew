package com.airbnb.lottie.model.layer;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.h.j;
import com.airbnb.lottie.model.h.k;
import com.airbnb.lottie.model.h.l;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class Layer {
    private final List<com.airbnb.lottie.model.content.b> a;
    private final com.airbnb.lottie.e b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final long f432d;

    /* renamed from: e  reason: collision with root package name */
    private final LayerType f433e;

    /* renamed from: f  reason: collision with root package name */
    private final long f434f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final String f435g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Mask> f436h;

    /* renamed from: i  reason: collision with root package name */
    private final l f437i;

    /* renamed from: j  reason: collision with root package name */
    private final int f438j;

    /* renamed from: k  reason: collision with root package name */
    private final int f439k;

    /* renamed from: l  reason: collision with root package name */
    private final int f440l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    @Nullable
    private final j q;
    @Nullable
    private final k r;
    @Nullable
    private final com.airbnb.lottie.model.h.b s;
    private final List<com.airbnb.lottie.x.a<Float>> t;
    private final MatteType u;
    private final boolean v;

    /* loaded from: classes.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public Layer(List<com.airbnb.lottie.model.content.b> list, com.airbnb.lottie.e eVar, String str, long j2, LayerType layerType, long j3, @Nullable String str2, List<Mask> list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, @Nullable j jVar, @Nullable k kVar, List<com.airbnb.lottie.x.a<Float>> list3, MatteType matteType, @Nullable com.airbnb.lottie.model.h.b bVar, boolean z) {
        this.a = list;
        this.b = eVar;
        this.c = str;
        this.f432d = j2;
        this.f433e = layerType;
        this.f434f = j3;
        this.f435g = str2;
        this.f436h = list2;
        this.f437i = lVar;
        this.f438j = i2;
        this.f439k = i3;
        this.f440l = i4;
        this.m = f2;
        this.n = f3;
        this.o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = matteType;
        this.s = bVar;
        this.v = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.airbnb.lottie.e a() {
        return this.b;
    }

    public long b() {
        return this.f432d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.x.a<Float>> c() {
        return this.t;
    }

    public LayerType d() {
        return this.f433e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Mask> e() {
        return this.f436h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatteType f() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h() {
        return this.f434f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String k() {
        return this.f435g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.airbnb.lottie.model.content.b> l() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f440l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f439k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o() {
        return this.f438j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float p() {
        return this.n / this.b.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public j q() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public k r() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.airbnb.lottie.model.h.b s() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float t() {
        return this.m;
    }

    public String toString() {
        return w("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l u() {
        return this.f437i;
    }

    public boolean v() {
        return this.v;
    }

    public String w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        Layer s = this.b.s(h());
        if (s != null) {
            sb.append("\t\tParents: ");
            sb.append(s.g());
            Layer s2 = this.b.s(s.h());
            while (s2 != null) {
                sb.append("->");
                sb.append(s2.g());
                s2 = this.b.s(s2.h());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.airbnb.lottie.model.content.b bVar : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
