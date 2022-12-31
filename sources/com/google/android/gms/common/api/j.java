package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.g;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class j<R extends g, S extends g> {
    @NonNull
    public abstract Status a(@NonNull Status status);

    @Nullable
    @WorkerThread
    public abstract e<S> b(@NonNull R r);
}
