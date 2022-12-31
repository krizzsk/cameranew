package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class c0<O extends a.d> extends t {
    private final com.google.android.gms.common.api.c<O> a;

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends a.b, R extends com.google.android.gms.common.api.g, T extends c<R, A>> T a(@NonNull T t) {
        this.a.c(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends a.b, T extends c<? extends com.google.android.gms.common.api.g, A>> T b(@NonNull T t) {
        this.a.d(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper d() {
        return this.a.f();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void e(o0 o0Var) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void f(o0 o0Var) {
    }
}
