package com.facebook.datasource;

import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* compiled from: DataSource.java */
/* loaded from: classes.dex */
public interface b<T> {
    boolean a();

    boolean b();

    @Nullable
    Throwable c();

    boolean close();

    void d(d<T> dVar, Executor executor);

    boolean e();

    @Nullable
    Map<String, Object> getExtras();

    float getProgress();

    @Nullable
    T getResult();
}
