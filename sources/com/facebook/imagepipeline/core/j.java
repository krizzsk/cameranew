package com.facebook.imagepipeline.core;

import android.content.Context;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.cache.i;
import com.facebook.imagepipeline.cache.r;
import com.facebook.imagepipeline.cache.s;
import com.facebook.imagepipeline.memory.b0;
import com.facebook.imagepipeline.producers.j0;
import java.util.Set;
import javax.annotation.Nullable;
/* compiled from: ImagePipelineConfigInterface.java */
/* loaded from: classes.dex */
public interface j {
    com.facebook.imagepipeline.cache.n A();

    com.facebook.common.memory.c B();

    @Nullable
    com.facebook.callercontext.a C();

    k D();

    f E();

    Set<com.facebook.imagepipeline.e.d> a();

    com.facebook.common.internal.k<Boolean> b();

    j0 c();

    @Nullable
    r<com.facebook.cache.common.b, PooledByteBuffer> d();

    com.facebook.cache.disk.b e();

    Set<com.facebook.imagepipeline.e.e> f();

    r.a g();

    Context getContext();

    com.facebook.imagepipeline.decoder.d h();

    com.facebook.cache.disk.b i();

    @Nullable
    i.b<com.facebook.cache.common.b> j();

    boolean k();

    @Nullable
    com.facebook.common.executors.e l();

    @Nullable
    Integer m();

    @Nullable
    com.facebook.imagepipeline.g.d n();

    @Nullable
    com.facebook.imagepipeline.decoder.c o();

    boolean p();

    com.facebook.common.internal.k<s> q();

    @Nullable
    com.facebook.imagepipeline.decoder.b r();

    com.facebook.common.internal.k<s> s();

    b0 t();

    int u();

    g v();

    com.facebook.imagepipeline.b.a w();

    com.facebook.imagepipeline.cache.a x();

    com.facebook.imagepipeline.cache.f y();

    boolean z();
}
