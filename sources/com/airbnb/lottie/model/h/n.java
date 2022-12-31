package com.airbnb.lottie.model.h;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes.dex */
public abstract class n<V, O> implements m<V, O> {
    final List<com.airbnb.lottie.x.a<V>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(V v) {
        this(Collections.singletonList(new com.airbnb.lottie.x.a(v)));
    }

    @Override // com.airbnb.lottie.model.h.m
    public List<com.airbnb.lottie.x.a<V>> b() {
        return this.a;
    }

    @Override // com.airbnb.lottie.model.h.m
    public boolean isStatic() {
        return this.a.isEmpty() || (this.a.size() == 1 && this.a.get(0).h());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List<com.airbnb.lottie.x.a<V>> list) {
        this.a = list;
    }
}
