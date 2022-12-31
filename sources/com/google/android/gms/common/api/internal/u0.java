package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.j;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class u0 extends g0<Boolean> {
    private final j.a<?> c;

    public u0(j.a<?> aVar, com.google.android.gms.tasks.h<Boolean> hVar) {
        super(4, hVar);
        this.c = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final /* bridge */ /* synthetic */ void d(@NonNull r rVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.s0
    @Nullable
    public final Feature[] g(f.a<?> aVar) {
        f0 f0Var = aVar.w().get(this.c);
        if (f0Var == null) {
            return null;
        }
        return f0Var.a.b();
    }

    @Override // com.google.android.gms.common.api.internal.s0
    public final boolean h(f.a<?> aVar) {
        f0 f0Var = aVar.w().get(this.c);
        if (f0Var == null) {
            return false;
        }
        f0Var.a.d();
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.g0
    public final void i(f.a<?> aVar) throws RemoteException {
        f0 remove = aVar.w().remove(this.c);
        if (remove != null) {
            remove.b.a(aVar.M(), this.b);
            remove.a.a();
            return;
        }
        this.b.e(Boolean.FALSE);
    }
}
