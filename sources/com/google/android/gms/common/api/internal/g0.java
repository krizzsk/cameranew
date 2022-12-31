package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class g0<T> extends s0 {
    protected final com.google.android.gms.tasks.h<T> b;

    public g0(int i2, com.google.android.gms.tasks.h<T> hVar) {
        super(i2);
        this.b = hVar;
    }

    @Override // com.google.android.gms.common.api.internal.v
    public void b(@NonNull Status status) {
        this.b.d(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.v
    public final void c(f.a<?> aVar) throws DeadObjectException {
        Status a;
        Status a2;
        try {
            i(aVar);
        } catch (DeadObjectException e2) {
            a2 = v.a(e2);
            b(a2);
            throw e2;
        } catch (RemoteException e3) {
            a = v.a(e3);
            b(a);
        } catch (RuntimeException e4) {
            e(e4);
        }
    }

    @Override // com.google.android.gms.common.api.internal.v
    public void e(@NonNull Exception exc) {
        this.b.d(exc);
    }

    protected abstract void i(f.a<?> aVar) throws RemoteException;
}
