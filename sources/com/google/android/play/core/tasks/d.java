package com.google.android.play.core.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;
/* loaded from: classes2.dex */
public abstract class d<ResultT> {
    @NonNull
    public abstract d<ResultT> a(@NonNull a<ResultT> aVar);

    @NonNull
    public abstract d<ResultT> b(@NonNull b bVar);

    @NonNull
    public abstract d<ResultT> c(@NonNull Executor executor, @NonNull b bVar);

    @NonNull
    public abstract d<ResultT> d(c<? super ResultT> cVar);

    @NonNull
    public abstract d<ResultT> e(@NonNull Executor executor, @NonNull c<? super ResultT> cVar);

    @Nullable
    public abstract Exception f();

    @NonNull
    public abstract ResultT g();

    public abstract boolean h();

    public abstract boolean i();
}
