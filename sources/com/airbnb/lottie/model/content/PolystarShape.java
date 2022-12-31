package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.model.h.m;
import com.airbnb.lottie.t.b.n;
/* loaded from: classes.dex */
public class PolystarShape implements b {
    private final String a;
    private final Type b;
    private final com.airbnb.lottie.model.h.b c;

    /* renamed from: d  reason: collision with root package name */
    private final m<PointF, PointF> f383d;

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f384e;

    /* renamed from: f  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f385f;

    /* renamed from: g  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f386g;

    /* renamed from: h  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f387h;

    /* renamed from: i  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f388i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f389j;

    /* loaded from: classes.dex */
    public enum Type {
        STAR(1),
        POLYGON(2);
        
        private final int value;

        Type(int i2) {
            this.value = i2;
        }

        public static Type forValue(int i2) {
            Type[] values;
            for (Type type : values()) {
                if (type.value == i2) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, com.airbnb.lottie.model.h.b bVar, m<PointF, PointF> mVar, com.airbnb.lottie.model.h.b bVar2, com.airbnb.lottie.model.h.b bVar3, com.airbnb.lottie.model.h.b bVar4, com.airbnb.lottie.model.h.b bVar5, com.airbnb.lottie.model.h.b bVar6, boolean z) {
        this.a = str;
        this.b = type;
        this.c = bVar;
        this.f383d = mVar;
        this.f384e = bVar2;
        this.f385f = bVar3;
        this.f386g = bVar4;
        this.f387h = bVar5;
        this.f388i = bVar6;
        this.f389j = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public com.airbnb.lottie.model.h.b b() {
        return this.f385f;
    }

    public com.airbnb.lottie.model.h.b c() {
        return this.f387h;
    }

    public String d() {
        return this.a;
    }

    public com.airbnb.lottie.model.h.b e() {
        return this.f386g;
    }

    public com.airbnb.lottie.model.h.b f() {
        return this.f388i;
    }

    public com.airbnb.lottie.model.h.b g() {
        return this.c;
    }

    public m<PointF, PointF> h() {
        return this.f383d;
    }

    public com.airbnb.lottie.model.h.b i() {
        return this.f384e;
    }

    public Type j() {
        return this.b;
    }

    public boolean k() {
        return this.f389j;
    }
}
