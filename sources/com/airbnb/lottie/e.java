package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
/* compiled from: LottieComposition.java */
/* loaded from: classes.dex */
public class e {
    private Map<String, List<Layer>> c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, h> f341d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, com.airbnb.lottie.model.b> f342e;

    /* renamed from: f  reason: collision with root package name */
    private List<com.airbnb.lottie.model.f> f343f;

    /* renamed from: g  reason: collision with root package name */
    private SparseArrayCompat<com.airbnb.lottie.model.c> f344g;

    /* renamed from: h  reason: collision with root package name */
    private LongSparseArray<Layer> f345h;

    /* renamed from: i  reason: collision with root package name */
    private List<Layer> f346i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f347j;

    /* renamed from: k  reason: collision with root package name */
    private float f348k;

    /* renamed from: l  reason: collision with root package name */
    private float f349l;
    private float m;
    private boolean n;
    private final p a = new p();
    private final HashSet<String> b = new HashSet<>();
    private int o = 0;

    /* compiled from: LottieComposition.java */
    @Deprecated
    /* loaded from: classes.dex */
    public static class b {

        /* compiled from: LottieComposition.java */
        /* loaded from: classes.dex */
        private static final class a implements i<e>, com.airbnb.lottie.a {
            private final o a;
            private boolean b;

            @Override // com.airbnb.lottie.i
            /* renamed from: a */
            public void onResult(e eVar) {
                if (this.b) {
                    return;
                }
                this.a.a(eVar);
            }

            private a(o oVar) {
                this.b = false;
                this.a = oVar;
            }
        }

        @Deprecated
        public static com.airbnb.lottie.a a(Context context, String str, o oVar) {
            a aVar = new a(oVar);
            f.d(context, str).f(aVar);
            return aVar;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        com.airbnb.lottie.w.d.c(str);
        this.b.add(str);
    }

    public Rect b() {
        return this.f347j;
    }

    public SparseArrayCompat<com.airbnb.lottie.model.c> c() {
        return this.f344g;
    }

    public float d() {
        return (e() / this.m) * 1000.0f;
    }

    public float e() {
        return this.f349l - this.f348k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float f() {
        return this.f349l;
    }

    public Map<String, com.airbnb.lottie.model.b> g() {
        return this.f342e;
    }

    public float h() {
        return this.m;
    }

    public Map<String, h> i() {
        return this.f341d;
    }

    public List<Layer> j() {
        return this.f346i;
    }

    @Nullable
    public com.airbnb.lottie.model.f k(String str) {
        this.f343f.size();
        for (int i2 = 0; i2 < this.f343f.size(); i2++) {
            com.airbnb.lottie.model.f fVar = this.f343f.get(i2);
            if (fVar.a(str)) {
                return fVar;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int l() {
        return this.o;
    }

    public p m() {
        return this.a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> n(String str) {
        return this.c.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float o() {
        return this.f348k;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean p() {
        return this.n;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void q(int i2) {
        this.o += i2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void r(Rect rect, float f2, float f3, float f4, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, h> map2, SparseArrayCompat<com.airbnb.lottie.model.c> sparseArrayCompat, Map<String, com.airbnb.lottie.model.b> map3, List<com.airbnb.lottie.model.f> list2) {
        this.f347j = rect;
        this.f348k = f2;
        this.f349l = f3;
        this.m = f4;
        this.f346i = list;
        this.f345h = longSparseArray;
        this.c = map;
        this.f341d = map2;
        this.f344g = sparseArrayCompat;
        this.f342e = map3;
        this.f343f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer s(long j2) {
        return this.f345h.get(j2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void t(boolean z) {
        this.n = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.f346i) {
            sb.append(layer.w("\t"));
        }
        return sb.toString();
    }

    public void u(boolean z) {
        this.a.b(z);
    }
}
