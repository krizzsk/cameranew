package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.w;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;
/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public interface j0<FETCH_STATE extends w> {

    /* compiled from: NetworkFetcher.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b(InputStream inputStream, int i2) throws IOException;

        void onFailure(Throwable th);
    }

    void a(FETCH_STATE fetch_state, a aVar);

    void b(FETCH_STATE fetch_state, int i2);

    boolean c(FETCH_STATE fetch_state);

    @Nullable
    Map<String, String> d(FETCH_STATE fetch_state, int i2);

    FETCH_STATE e(l<com.facebook.imagepipeline.image.e> lVar, o0 o0Var);
}
