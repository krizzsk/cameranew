package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcin {
    private final zzcim zzgkk;
    private final AtomicReference<zzane> zzgkl = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcin(zzcim zzcimVar) {
        this.zzgkk = zzcimVar;
    }

    private final zzane zzapu() throws RemoteException {
        zzane zzaneVar = this.zzgkl.get();
        if (zzaneVar != null) {
            return zzaneVar;
        }
        zzazk.zzex("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    private final zzanj zze(String str, JSONObject jSONObject) throws RemoteException {
        zzane zzapu = zzapu();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                if (zzapu.zzde(jSONObject.getString("class_name"))) {
                    return zzapu.zzdd("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                return zzapu.zzdd("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e2) {
                zzazk.zzc("Invalid custom event.", e2);
            }
        }
        return zzapu.zzdd(str);
    }

    public final boolean zzapt() {
        return this.zzgkl.get() != null;
    }

    public final void zzb(zzane zzaneVar) {
        this.zzgkl.compareAndSet(null, zzaneVar);
    }

    public final zzdog zzd(String str, JSONObject jSONObject) throws zzdnt {
        zzanj zze;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zze = new zzaoa(new AdMobAdapter());
            } else if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                zze = new zzaoa(new AdUrlAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zze = new zzaoa(new zzaqa());
            } else {
                zze = zze(str, jSONObject);
            }
            zzdog zzdogVar = new zzdog(zze);
            this.zzgkk.zza(str, zzdogVar);
            return zzdogVar;
        } catch (Throwable th) {
            throw new zzdnt(th);
        }
    }

    public final zzapk zzdf(String str) throws RemoteException {
        zzapk zzdf = zzapu().zzdf(str);
        this.zzgkk.zza(str, zzdf);
        return zzdf;
    }
}
