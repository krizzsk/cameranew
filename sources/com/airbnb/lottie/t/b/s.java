package com.airbnb.lottie.t.b;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.t.c.a;
import java.util.ArrayList;
import java.util.List;
/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class s implements c, a.b {
    private final boolean a;
    private final List<a.b> b = new ArrayList();
    private final ShapeTrimPath.Type c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, Float> f535d;

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, Float> f536e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.t.c.a<?, Float> f537f;

    public s(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        shapeTrimPath.c();
        this.a = shapeTrimPath.g();
        this.c = shapeTrimPath.f();
        com.airbnb.lottie.t.c.a<Float, Float> a = shapeTrimPath.e().a();
        this.f535d = a;
        com.airbnb.lottie.t.c.a<Float, Float> a2 = shapeTrimPath.b().a();
        this.f536e = a2;
        com.airbnb.lottie.t.c.a<Float, Float> a3 = shapeTrimPath.d().a();
        this.f537f = a3;
        aVar.i(a);
        aVar.i(a2);
        aVar.i(a3);
        a.a(this);
        a2.a(this);
        a3.a(this);
    }

    @Override // com.airbnb.lottie.t.c.a.b
    public void a() {
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            this.b.get(i2).a();
        }
    }

    @Override // com.airbnb.lottie.t.b.c
    public void b(List<c> list, List<c> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a.b bVar) {
        this.b.add(bVar);
    }

    public com.airbnb.lottie.t.c.a<?, Float> d() {
        return this.f536e;
    }

    public com.airbnb.lottie.t.c.a<?, Float> f() {
        return this.f537f;
    }

    public com.airbnb.lottie.t.c.a<?, Float> h() {
        return this.f535d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeTrimPath.Type i() {
        return this.c;
    }

    public boolean j() {
        return this.a;
    }
}
