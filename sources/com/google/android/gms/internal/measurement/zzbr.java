package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.h;
import com.google.android.gms.common.wrappers.b;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.measurement.api.a;
import com.google.android.gms.measurement.internal.h4;
import com.google.android.gms.measurement.internal.p5;
import com.google.android.gms.measurement.internal.q5;
import com.google.android.gms.measurement.internal.x6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzbr {
    private static volatile zzbr zzc;
    private static Boolean zzh;
    protected final Clock zza;
    protected final ExecutorService zzb;
    private final String zzd;
    private final a zze;
    @GuardedBy("listenerList")
    private final List<Pair<q5, zzbi>> zzf;
    private int zzg;
    private boolean zzi;
    private final String zzj;
    private volatile zzp zzk;

    protected zzbr(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str != null && zzX(str2, str3)) {
            this.zzd = str;
        } else {
            this.zzd = "FA";
        }
        this.zza = h.getInstance();
        this.zzb = zzk.zza().zzb(new zzav(this), 1);
        this.zze = new a(this);
        this.zzf = new ArrayList();
        try {
            if (x6.b(context, "google_app_id", h4.a(context)) != null && !zzT()) {
                this.zzj = null;
                this.zzi = true;
                Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (zzX(str2, str3)) {
            this.zzj = str2;
        } else {
            this.zzj = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.zzd, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzd, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        }
        zzU(new zzak(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new zzbq(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzO(Context context) {
        Bundle bundle;
        synchronized (zzbr.class) {
            try {
            } catch (Exception e2) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e2);
                zzh = Boolean.TRUE;
            }
            if (zzh != null) {
                return;
            }
            q.f("app_measurement_internal_disable_startup_flags");
            try {
                ApplicationInfo c = b.a(context).c(context.getPackageName(), 128);
                if (c != null && (bundle = c.metaData) != null) {
                    if (bundle.getBoolean("app_measurement_internal_disable_startup_flags")) {
                        zzh = Boolean.TRUE;
                        return;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
            zzh = Boolean.valueOf(sharedPreferences.getBoolean("allow_remote_dynamite", true));
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove("allow_remote_dynamite");
            edit.apply();
        }
    }

    protected static final boolean zzT() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzU(zzbg zzbgVar) {
        this.zzb.execute(zzbgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzV(Exception exc, boolean z, boolean z2) {
        this.zzi |= z;
        if (z) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzC(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(this.zzd, "Error with data collection. Data lost.", exc);
    }

    private final void zzW(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l2) {
        zzU(new zzbe(this, l2, str, str2, bundle, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzX(String str, String str2) {
        return (str2 == null || str == null || zzT()) ? false : true;
    }

    public static zzbr zza(Context context, String str, String str2, String str3, Bundle bundle) {
        q.j(context);
        if (zzc == null) {
            synchronized (zzbr.class) {
                if (zzc == null) {
                    zzc = new zzbr(context, str, str2, str3, bundle);
                }
            }
        }
        return zzc;
    }

    public final String zzA() {
        zzm zzmVar = new zzm();
        zzU(new zzar(this, zzmVar));
        return zzmVar.zzc(500L);
    }

    public final Map<String, Object> zzB(String str, String str2, boolean z) {
        zzm zzmVar = new zzm();
        zzU(new zzas(this, str, str2, z, zzmVar));
        Bundle zzd = zzmVar.zzd(5000L);
        if (zzd != null && zzd.size() != 0) {
            HashMap hashMap = new HashMap(zzd.size());
            for (String str3 : zzd.keySet()) {
                Object obj = zzd.get(str3);
                if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                    hashMap.put(str3, obj);
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    public final void zzC(int i2, String str, Object obj, Object obj2, Object obj3) {
        zzU(new zzat(this, false, 5, str, obj, null, null));
    }

    public final Bundle zzD(Bundle bundle, boolean z) {
        zzm zzmVar = new zzm();
        zzU(new zzau(this, bundle, zzmVar));
        if (z) {
            return zzmVar.zzd(5000L);
        }
        return null;
    }

    public final int zzE(String str) {
        zzm zzmVar = new zzm();
        zzU(new zzaw(this, str, zzmVar));
        Integer num = (Integer) zzm.zze(zzmVar.zzd(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @WorkerThread
    public final String zzF() {
        zzm zzmVar = new zzm();
        zzU(new zzax(this, zzmVar));
        return zzmVar.zzc(120000L);
    }

    public final String zzG() {
        return this.zzj;
    }

    public final Object zzH(int i2) {
        zzm zzmVar = new zzm();
        zzU(new zzay(this, zzmVar, i2));
        return zzm.zze(zzmVar.zzd(15000L), Object.class);
    }

    public final void zzI(boolean z) {
        zzU(new zzaz(this, z));
    }

    public final void zzJ(Bundle bundle) {
        zzU(new zzba(this, bundle));
    }

    public final a zzb() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzp zzc(Context context, boolean z) {
        DynamiteModule.a aVar;
        try {
            if (z) {
                aVar = DynamiteModule.f3710l;
            } else {
                aVar = DynamiteModule.f3708j;
            }
            return zzo.asInterface(DynamiteModule.e(context, aVar, ModuleDescriptor.MODULE_ID).d("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.LoadingException e2) {
            zzV(e2, true, false);
            return null;
        }
    }

    public final void zzd(p5 p5Var) {
        zzbh zzbhVar = new zzbh(p5Var);
        if (this.zzk != null) {
            try {
                this.zzk.setEventInterceptor(zzbhVar);
                return;
            } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zzU(new zzbb(this, zzbhVar));
    }

    public final void zze(q5 q5Var) {
        q.j(q5Var);
        synchronized (this.zzf) {
            for (int i2 = 0; i2 < this.zzf.size(); i2++) {
                if (q5Var.equals(this.zzf.get(i2).first)) {
                    Log.w(this.zzd, "OnEventListener already registered.");
                    return;
                }
            }
            zzbi zzbiVar = new zzbi(q5Var);
            this.zzf.add(new Pair<>(q5Var, zzbiVar));
            if (this.zzk != null) {
                try {
                    this.zzk.registerOnMeasurementEventListener(zzbiVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zzU(new zzbc(this, zzbiVar));
        }
    }

    public final void zzf(q5 q5Var) {
        Pair<q5, zzbi> pair;
        q.j(q5Var);
        synchronized (this.zzf) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.zzf.size()) {
                    pair = null;
                    break;
                } else if (q5Var.equals(this.zzf.get(i2).first)) {
                    pair = this.zzf.get(i2);
                    break;
                } else {
                    i2++;
                }
            }
            if (pair == null) {
                Log.w(this.zzd, "OnEventListener had not been registered.");
                return;
            }
            this.zzf.remove(pair);
            zzbi zzbiVar = (zzbi) pair.second;
            if (this.zzk != null) {
                try {
                    this.zzk.unregisterOnMeasurementEventListener(zzbiVar);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zzU(new zzbd(this, zzbiVar));
        }
    }

    public final void zzg(@NonNull String str, Bundle bundle) {
        zzW(null, str, bundle, false, true, null);
    }

    public final void zzh(String str, String str2, Bundle bundle) {
        zzW(str, str2, bundle, true, true, null);
    }

    public final void zzi(String str, String str2, Bundle bundle, long j2) {
        zzW(str, str2, bundle, true, false, Long.valueOf(j2));
    }

    public final void zzj(String str, String str2, Object obj, boolean z) {
        zzU(new zzbf(this, str, str2, obj, z));
    }

    public final void zzk(Bundle bundle) {
        zzU(new zzaa(this, bundle));
    }

    public final void zzl(String str, String str2, Bundle bundle) {
        zzU(new zzab(this, str, str2, bundle));
    }

    public final List<Bundle> zzm(String str, String str2) {
        zzm zzmVar = new zzm();
        zzU(new zzac(this, str, str2, zzmVar));
        List<Bundle> list = (List) zzm.zze(zzmVar.zzd(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final void zzn(String str) {
        zzU(new zzad(this, str));
    }

    public final void zzo(Activity activity, String str, String str2) {
        zzU(new zzae(this, activity, str, str2));
    }

    public final void zzp(Boolean bool) {
        zzU(new zzaf(this, bool));
    }

    public final void zzq(Bundle bundle) {
        zzU(new zzag(this, bundle));
    }

    public final void zzr(Bundle bundle) {
        zzU(new zzah(this, bundle));
    }

    public final void zzs() {
        zzU(new zzai(this));
    }

    public final void zzt(long j2) {
        zzU(new zzaj(this, j2));
    }

    public final void zzu(String str) {
        zzU(new zzal(this, str));
    }

    public final void zzv(String str) {
        zzU(new zzam(this, str));
    }

    public final String zzw() {
        zzm zzmVar = new zzm();
        zzU(new zzan(this, zzmVar));
        return zzmVar.zzc(500L);
    }

    public final String zzx() {
        zzm zzmVar = new zzm();
        zzU(new zzao(this, zzmVar));
        return zzmVar.zzc(50L);
    }

    public final long zzy() {
        zzm zzmVar = new zzm();
        zzU(new zzap(this, zzmVar));
        Long l2 = (Long) zzm.zze(zzmVar.zzd(500L), Long.class);
        if (l2 == null) {
            long nextLong = new Random(System.nanoTime() ^ this.zza.currentTimeMillis()).nextLong();
            int i2 = this.zzg + 1;
            this.zzg = i2;
            return nextLong + i2;
        }
        return l2.longValue();
    }

    public final String zzz() {
        zzm zzmVar = new zzm();
        zzU(new zzaq(this, zzmVar));
        return zzmVar.zzc(500L);
    }
}
