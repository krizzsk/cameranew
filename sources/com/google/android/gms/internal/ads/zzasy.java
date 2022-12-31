package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.c;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzasy extends com.google.android.gms.ads.internal.zzc<zzath> {
    public zzasy(Context context, Looper looper, c.a aVar, c.b bVar) {
        super(zzaul.zzx(context), looper, 8, aVar, bVar, null);
    }

    @Override // com.google.android.gms.common.internal.c
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (queryLocalInterface instanceof zzath) {
            return (zzath) queryLocalInterface;
        }
        return new zzatj(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.START";
    }

    public final zzath zzwi() throws DeadObjectException {
        return (zzath) super.getService();
    }
}
