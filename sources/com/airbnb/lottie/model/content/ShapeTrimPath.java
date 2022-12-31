package com.airbnb.lottie.model.content;

import com.airbnb.lottie.t.b.s;
/* loaded from: classes.dex */
public class ShapeTrimPath implements b {
    private final String a;
    private final Type b;
    private final com.airbnb.lottie.model.h.b c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f397d;

    /* renamed from: e  reason: collision with root package name */
    private final com.airbnb.lottie.model.h.b f398e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f399f;

    /* loaded from: classes.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i2);
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, com.airbnb.lottie.model.h.b bVar, com.airbnb.lottie.model.h.b bVar2, com.airbnb.lottie.model.h.b bVar3, boolean z) {
        this.a = str;
        this.b = type;
        this.c = bVar;
        this.f397d = bVar2;
        this.f398e = bVar3;
        this.f399f = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new s(aVar, this);
    }

    public com.airbnb.lottie.model.h.b b() {
        return this.f397d;
    }

    public String c() {
        return this.a;
    }

    public com.airbnb.lottie.model.h.b d() {
        return this.f398e;
    }

    public com.airbnb.lottie.model.h.b e() {
        return this.c;
    }

    public Type f() {
        return this.b;
    }

    public boolean g() {
        return this.f399f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.f397d + ", offset: " + this.f398e + "}";
    }
}
