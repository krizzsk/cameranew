package com.facebook.imagepipeline.a;

import com.facebook.imagepipeline.producers.n0;
import com.facebook.imagepipeline.producers.u0;
import javax.annotation.concurrent.ThreadSafe;
/* compiled from: ProducerToDataSourceAdapter.java */
@ThreadSafe
/* loaded from: classes.dex */
public class d<T> extends a<T> {
    private d(n0<T> n0Var, u0 u0Var, com.facebook.imagepipeline.e.d dVar) {
        super(n0Var, u0Var, dVar);
    }

    public static <T> com.facebook.datasource.b<T> F(n0<T> n0Var, u0 u0Var, com.facebook.imagepipeline.e.d dVar) {
        return new d(n0Var, u0Var, dVar);
    }
}
