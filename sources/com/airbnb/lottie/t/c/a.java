package com.airbnb.lottie.t.c;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes.dex */
public abstract class a<K, A> {
    private final d<K> c;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    protected com.airbnb.lottie.x.c<A> f539e;
    final List<b> a = new ArrayList(1);
    private boolean b = false;

    /* renamed from: d  reason: collision with root package name */
    protected float f538d = 0.0f;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private A f540f = null;

    /* renamed from: g  reason: collision with root package name */
    private float f541g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f542h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public static final class c<T> implements d<T> {
        private c() {
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public boolean a(float f2) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public com.airbnb.lottie.x.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public boolean c(float f2) {
            return false;
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public float d() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public float e() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public interface d<T> {
        boolean a(float f2);

        com.airbnb.lottie.x.a<T> b();

        boolean c(float f2);

        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
        float d();

        @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public static final class e<T> implements d<T> {
        private final List<? extends com.airbnb.lottie.x.a<T>> a;
        private com.airbnb.lottie.x.a<T> c = null;

        /* renamed from: d  reason: collision with root package name */
        private float f543d = -1.0f;
        @NonNull
        private com.airbnb.lottie.x.a<T> b = f(0.0f);

        e(List<? extends com.airbnb.lottie.x.a<T>> list) {
            this.a = list;
        }

        private com.airbnb.lottie.x.a<T> f(float f2) {
            List<? extends com.airbnb.lottie.x.a<T>> list = this.a;
            com.airbnb.lottie.x.a<T> aVar = list.get(list.size() - 1);
            if (f2 >= aVar.e()) {
                return aVar;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                com.airbnb.lottie.x.a<T> aVar2 = this.a.get(size);
                if (this.b != aVar2 && aVar2.a(f2)) {
                    return aVar2;
                }
            }
            return this.a.get(0);
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public boolean a(float f2) {
            com.airbnb.lottie.x.a<T> aVar = this.c;
            com.airbnb.lottie.x.a<T> aVar2 = this.b;
            if (aVar == aVar2 && this.f543d == f2) {
                return true;
            }
            this.c = aVar2;
            this.f543d = f2;
            return false;
        }

        @Override // com.airbnb.lottie.t.c.a.d
        @NonNull
        public com.airbnb.lottie.x.a<T> b() {
            return this.b;
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public boolean c(float f2) {
            if (this.b.a(f2)) {
                return !this.b.h();
            }
            this.b = f(f2);
            return true;
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public float d() {
            return this.a.get(0).e();
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public float e() {
            List<? extends com.airbnb.lottie.x.a<T>> list = this.a;
            return list.get(list.size() - 1).b();
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* loaded from: classes.dex */
    public static final class f<T> implements d<T> {
        @NonNull
        private final com.airbnb.lottie.x.a<T> a;
        private float b = -1.0f;

        f(List<? extends com.airbnb.lottie.x.a<T>> list) {
            this.a = list.get(0);
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public boolean a(float f2) {
            if (this.b == f2) {
                return true;
            }
            this.b = f2;
            return false;
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public com.airbnb.lottie.x.a<T> b() {
            return this.a;
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public boolean c(float f2) {
            return !this.a.h();
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public float d() {
            return this.a.e();
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public float e() {
            return this.a.b();
        }

        @Override // com.airbnb.lottie.t.c.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<? extends com.airbnb.lottie.x.a<K>> list) {
        this.c = n(list);
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    private float g() {
        if (this.f541g == -1.0f) {
            this.f541g = this.c.d();
        }
        return this.f541g;
    }

    private static <T> d<T> n(List<? extends com.airbnb.lottie.x.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }

    public void a(b bVar) {
        this.a.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.airbnb.lottie.x.a<K> b() {
        com.airbnb.lottie.d.a("BaseKeyframeAnimation#getCurrentKeyframe");
        com.airbnb.lottie.x.a<K> b2 = this.c.b();
        com.airbnb.lottie.d.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b2;
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    float c() {
        if (this.f542h == -1.0f) {
            this.f542h = this.c.e();
        }
        return this.f542h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float d() {
        com.airbnb.lottie.x.a<K> b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return b2.f583d.getInterpolation(e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        if (this.b) {
            return 0.0f;
        }
        com.airbnb.lottie.x.a<K> b2 = b();
        if (b2.h()) {
            return 0.0f;
        }
        return (this.f538d - b2.e()) / (b2.b() - b2.e());
    }

    public float f() {
        return this.f538d;
    }

    public A h() {
        float d2 = d();
        if (this.f539e == null && this.c.a(d2)) {
            return this.f540f;
        }
        A i2 = i(b(), d2);
        this.f540f = i2;
        return i2;
    }

    abstract A i(com.airbnb.lottie.x.a<K> aVar, float f2);

    public void j() {
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            this.a.get(i2).a();
        }
    }

    public void k() {
        this.b = true;
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.c.isEmpty()) {
            return;
        }
        if (f2 < g()) {
            f2 = g();
        } else if (f2 > c()) {
            f2 = c();
        }
        if (f2 == this.f538d) {
            return;
        }
        this.f538d = f2;
        if (this.c.c(f2)) {
            j();
        }
    }

    public void m(@Nullable com.airbnb.lottie.x.c<A> cVar) {
        com.airbnb.lottie.x.c<A> cVar2 = this.f539e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f539e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
