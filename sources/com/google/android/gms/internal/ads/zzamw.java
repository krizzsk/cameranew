package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.measurement.api.a;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzamw extends zzbfw {
    private final a zzdll;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamw(a aVar) {
        this.zzdll = aVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void beginAdUnitExposure(String str) throws RemoteException {
        this.zzdll.a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdll.b(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void endAdUnitExposure(String str) throws RemoteException {
        this.zzdll.c(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final long generateEventId() throws RemoteException {
        return this.zzdll.d();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final String getAppIdOrigin() throws RemoteException {
        return this.zzdll.e();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final String getAppInstanceId() throws RemoteException {
        return this.zzdll.f();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final List getConditionalUserProperties(String str, String str2) throws RemoteException {
        return this.zzdll.g(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final String getCurrentScreenClass() throws RemoteException {
        return this.zzdll.h();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final String getCurrentScreenName() throws RemoteException {
        return this.zzdll.i();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final String getGmpAppId() throws RemoteException {
        return this.zzdll.j();
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final int getMaxUserProperties(String str) throws RemoteException {
        return this.zzdll.l(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final Map getUserProperties(String str, String str2, boolean z) throws RemoteException {
        return this.zzdll.m(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void logEvent(String str, String str2, Bundle bundle) throws RemoteException {
        this.zzdll.n(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void performAction(Bundle bundle) throws RemoteException {
        this.zzdll.o(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final Bundle performActionWithResponse(Bundle bundle) throws RemoteException {
        return this.zzdll.p(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void setConditionalUserProperty(Bundle bundle) throws RemoteException {
        this.zzdll.r(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void setConsent(Bundle bundle) throws RemoteException {
        this.zzdll.s(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void zza(String str, String str2, b bVar) throws RemoteException {
        this.zzdll.u(str, str2, bVar != null ? d.y0(bVar) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzbfu
    public final void zzb(b bVar, String str, String str2) throws RemoteException {
        this.zzdll.t(bVar != null ? (Activity) d.y0(bVar) : null, str, str2);
    }
}
