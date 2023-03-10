package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.b;
import com.google.ads.mediation.e;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzanf extends zzanh {
    private static final zzapq zzdnj = new zzapq();
    private Map<Class<? extends NetworkExtras>, NetworkExtras> zzdni;

    private final <NetworkExtrasT extends e, ServerParametersT extends MediationServerParameters> zzanj zzdg(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, zzanf.class.getClassLoader());
            if (b.class.isAssignableFrom(cls)) {
                b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                return new zzaoi(bVar, (e) this.zzdni.get(bVar.getAdditionalParametersType()));
            } else if (MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzaoa((MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } else {
                if (Adapter.class.isAssignableFrom(cls)) {
                    return new zzaoa((Adapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
                sb.append("Could not instantiate mediation adapter: ");
                sb.append(str);
                sb.append(" (not a valid adapter).");
                zzazk.zzex(sb.toString());
                throw new RemoteException();
            }
        } catch (Throwable unused) {
            return zzdh(str);
        }
    }

    private final zzanj zzdh(String str) throws RemoteException {
        try {
            zzazk.zzdy("Reflection failed, retrying using direct instantiation");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 43);
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(". ");
            zzazk.zzd(sb.toString(), th);
        }
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
            return new zzaoa(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new zzaoa(new AdUrlAdapter());
        }
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            return new zzaoa(new CustomEventAdapter());
        }
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
            return new zzaoi(customEventAdapter, (CustomEventExtras) this.zzdni.get(customEventAdapter.getAdditionalParametersType()));
        }
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzane
    public final zzanj zzdd(String str) throws RemoteException {
        return zzdg(str);
    }

    @Override // com.google.android.gms.internal.ads.zzane
    public final boolean zzde(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzanf.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80);
            sb.append("Could not load custom event implementation class: ");
            sb.append(str);
            sb.append(", assuming old implementation.");
            zzazk.zzex(sb.toString());
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzane
    public final zzapk zzdf(String str) throws RemoteException {
        return zzapq.zzdo(str);
    }

    public final void zzf(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.zzdni = map;
    }
}
