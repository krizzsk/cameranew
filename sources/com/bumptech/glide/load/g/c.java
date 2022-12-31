package com.bumptech.glide.load.g;

import com.bumptech.glide.Priority;
/* compiled from: DataFetcher.java */
/* loaded from: classes.dex */
public interface c<T> {
    void a();

    T b(Priority priority) throws Exception;

    void cancel();

    String getId();
}
