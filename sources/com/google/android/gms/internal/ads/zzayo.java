package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.o;
import com.google.android.gms.common.wrappers.b;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzayo {
    private Context context;
    private final Object lock = new Object();
    private zzazn zzbpn;
    private final zzayy zzebw;
    private final com.google.android.gms.ads.internal.util.zzi zzece;
    @Nullable
    private zzabs zzecf;
    @Nullable
    private Boolean zzecg;
    private final AtomicInteger zzech;
    private final zzayt zzeci;
    private final Object zzecj;
    @GuardedBy("grantedPermissionLock")
    private zzdzw<ArrayList<String>> zzeck;
    private boolean zzzl;

    public zzayo() {
        com.google.android.gms.ads.internal.util.zzi zziVar = new com.google.android.gms.ads.internal.util.zzi();
        this.zzece = zziVar;
        this.zzebw = new zzayy(zzwr.zzqs(), zziVar);
        this.zzzl = false;
        this.zzecf = null;
        this.zzecg = null;
        this.zzech = new AtomicInteger(0);
        this.zzeci = new zzayt(null);
        this.zzecj = new Object();
    }

    @TargetApi(16)
    private static ArrayList<String> zzah(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo e2 = b.a(context).e(context.getApplicationInfo().packageName, 4096);
            if (e2.requestedPermissions != null && e2.requestedPermissionsFlags != null) {
                int i2 = 0;
                while (true) {
                    String[] strArr = e2.requestedPermissions;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    if ((e2.requestedPermissionsFlags[i2] & 2) != 0) {
                        arrayList.add(strArr[i2]);
                    }
                    i2++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    @Nullable
    public final Context getApplicationContext() {
        return this.context;
    }

    @Nullable
    public final Resources getResources() {
        if (this.zzbpn.zzeia) {
            return this.context.getResources();
        }
        try {
            zzazj.zzbt(this.context).getResources();
            return null;
        } catch (zzazl e2) {
            zzazk.zzd("Cannot load resource from dynamite apk or local jar", e2);
            return null;
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzecg = bool;
        }
    }

    public final void zzb(Throwable th, String str) {
        zzass.zzc(this.context, this.zzbpn).zza(th, str, zzadr.zzdew.get().floatValue());
    }

    @TargetApi(23)
    public final void zzd(Context context, zzazn zzaznVar) {
        zzabs zzabsVar;
        synchronized (this.lock) {
            if (!this.zzzl) {
                this.context = context.getApplicationContext();
                this.zzbpn = zzaznVar;
                com.google.android.gms.ads.internal.zzr.zzku().zza(this.zzebw);
                this.zzece.initialize(this.context);
                zzass.zzc(this.context, this.zzbpn);
                com.google.android.gms.ads.internal.zzr.zzla();
                if (!zzadf.zzddi.get().booleanValue()) {
                    com.google.android.gms.ads.internal.util.zzd.zzeb("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzabsVar = null;
                } else {
                    zzabsVar = new zzabs();
                }
                this.zzecf = zzabsVar;
                if (zzabsVar != null) {
                    zzazw.zza(new zzayq(this).zzye(), "AppState.registerCsiReporter");
                }
                this.zzzl = true;
                zzxt();
            }
        }
        com.google.android.gms.ads.internal.zzr.zzkr().zzq(context, zzaznVar.zzbrp);
    }

    @Nullable
    public final zzabs zzxm() {
        zzabs zzabsVar;
        synchronized (this.lock) {
            zzabsVar = this.zzecf;
        }
        return zzabsVar;
    }

    public final Boolean zzxn() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzecg;
        }
        return bool;
    }

    public final void zzxo() {
        this.zzeci.zzxo();
    }

    public final void zzxp() {
        this.zzech.incrementAndGet();
    }

    public final void zzxq() {
        this.zzech.decrementAndGet();
    }

    public final int zzxr() {
        return this.zzech.get();
    }

    public final com.google.android.gms.ads.internal.util.zzf zzxs() {
        com.google.android.gms.ads.internal.util.zzi zziVar;
        synchronized (this.lock) {
            zziVar = this.zzece;
        }
        return zziVar;
    }

    public final zzdzw<ArrayList<String>> zzxt() {
        if (o.c() && this.context != null) {
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcse)).booleanValue()) {
                synchronized (this.zzecj) {
                    zzdzw<ArrayList<String>> zzdzwVar = this.zzeck;
                    if (zzdzwVar != null) {
                        return zzdzwVar;
                    }
                    zzdzw<ArrayList<String>> zze = zzazp.zzeic.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzayr
                        private final zzayo zzect;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzect = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zzect.zzxv();
                        }
                    });
                    this.zzeck = zze;
                    return zze;
                }
            }
        }
        return zzdzk.zzag(new ArrayList());
    }

    public final zzayy zzxu() {
        return this.zzebw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzxv() throws Exception {
        return zzah(zzaul.zzx(this.context));
    }

    public final void zza(Throwable th, String str) {
        zzass.zzc(this.context, this.zzbpn).zza(th, str);
    }
}
