package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.f;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class t0<A extends c<? extends com.google.android.gms.common.api.g, a.b>> extends v {
    private final A b;

    public t0(int i2, A a) {
        super(i2);
        this.b = a;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void b(@NonNull Status status) {
        this.b.setFailedResult(status);
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void c(f.a<?> aVar) throws DeadObjectException {
        try {
            this.b.run(aVar.M());
        } catch (RuntimeException e2) {
            e(e2);
        }
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void d(@NonNull r rVar, boolean z) {
        rVar.b(this.b, z);
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void e(@NonNull Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.b.setFailedResult(new Status(10, sb.toString()));
    }
}
