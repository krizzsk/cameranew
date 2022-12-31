package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.c;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzduh extends com.google.android.gms.ads.internal.zzc<zzduo> {
    private final int zzhty;

    public zzduh(Context context, Looper looper, c.a aVar, c.b bVar, int i2) {
        super(context, looper, 116, aVar, bVar, null);
        this.zzhty = i2;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        if (queryLocalInterface instanceof zzduo) {
            return (zzduo) queryLocalInterface;
        }
        return new zzdun(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c, com.google.android.gms.common.api.a.f
    public final int getMinApkVersion() {
        return this.zzhty;
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    @Override // com.google.android.gms.common.internal.c
    protected final String getStartServiceAction() {
        return "com.google.android.gms.gass.START";
    }

    public final zzduo zzayh() throws DeadObjectException {
        return (zzduo) super.getService();
    }
}
