package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class m<A extends a.b, L> {
    public abstract void a();

    @Nullable
    public abstract Feature[] b();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void c(A a, com.google.android.gms.tasks.h<Void> hVar) throws RemoteException;

    public final boolean d() {
        throw null;
    }
}
