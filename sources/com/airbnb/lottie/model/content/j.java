package com.airbnb.lottie.model.content;

import java.util.Arrays;
import java.util.List;
/* compiled from: ShapeGroup.java */
/* loaded from: classes.dex */
public class j implements b {
    private final String a;
    private final List<b> b;
    private final boolean c;

    public j(String str, List<b> list, boolean z) {
        this.a = str;
        this.b = list;
        this.c = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.t.b.c a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.t.b.d(gVar, aVar, this);
    }

    public List<b> b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
    }
}
