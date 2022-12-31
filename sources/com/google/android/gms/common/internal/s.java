package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.a;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class s<T extends IInterface> extends g<T> {
    private final a.h<T> a;

    public a.h<T> c() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.c
    protected T createServiceInterface(IBinder iBinder) {
        return this.a.createServiceInterface(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    protected String getServiceDescriptor() {
        return this.a.getServiceDescriptor();
    }

    @Override // com.google.android.gms.common.internal.c
    protected String getStartServiceAction() {
        return this.a.getStartServiceAction();
    }

    @Override // com.google.android.gms.common.internal.c
    protected void onSetConnectState(int i2, T t) {
        this.a.b(i2, t);
    }
}
