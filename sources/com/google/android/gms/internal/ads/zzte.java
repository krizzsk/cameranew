package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.util.b;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzte extends com.google.android.gms.ads.internal.zzc<zzti> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzte(Context context, Looper looper, c.a aVar, c.b bVar) {
        super(zzaul.zzx(context), looper, 123, aVar, bVar, null);
    }

    @Override // com.google.android.gms.common.internal.c
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
        if (queryLocalInterface instanceof zzti) {
            return (zzti) queryLocalInterface;
        }
        return new zztl(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.ads.zzb.zzadj;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    public final zzti zznd() throws DeadObjectException {
        return (zzti) super.getService();
    }

    public final boolean zzne() {
        return ((Boolean) zzwr.zzqr().zzd(zzabp.zzcrm)).booleanValue() && b.b(getAvailableFeatures(), com.google.android.gms.ads.zzb.zzadi);
    }
}
