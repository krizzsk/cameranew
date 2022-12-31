package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.work.WorkRequest;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import com.tencent.matrix.report.Issue;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class AdvertisingIdClient {
    @GuardedBy("this")
    private final Context mContext;
    @Nullable
    @GuardedBy("this")
    private com.google.android.gms.common.a zze;
    @Nullable
    @GuardedBy("this")
    private zze zzf;
    @GuardedBy("this")
    private boolean zzg;
    private final Object zzh;
    @Nullable
    @GuardedBy("mAutoDisconnectTaskLock")
    private zza zzi;
    private final boolean zzj;
    private final long zzk;

    /* loaded from: classes2.dex */
    public static final class Info {
        private final String zzq;
        private final boolean zzr;

        public Info(String str, boolean z) {
            this.zzq = str;
            this.zzr = z;
        }

        public final String getId() {
            return this.zzq;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzr;
        }

        public final String toString() {
            String str = this.zzq;
            boolean z = this.zzr;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzm;
        private long zzn;
        CountDownLatch zzo = new CountDownLatch(1);
        boolean zzp = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j2) {
            this.zzm = new WeakReference<>(advertisingIdClient);
            this.zzn = j2;
            start();
        }

        private final void disconnect() {
            AdvertisingIdClient advertisingIdClient = this.zzm.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzp = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                if (this.zzo.await(this.zzn, TimeUnit.MILLISECONDS)) {
                    return;
                }
                disconnect();
            } catch (InterruptedException unused) {
                disconnect();
            }
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, false, false);
    }

    private AdvertisingIdClient(Context context, long j2, boolean z, boolean z2) {
        Context applicationContext;
        this.zzh = new Object();
        q.j(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.mContext = context;
        this.zzg = false;
        this.zzk = j2;
        this.zzj = z2;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb zzbVar = new zzb(context);
        boolean z = zzbVar.getBoolean("gads:ad_id_app_context:enabled", false);
        float a = zzbVar.a("gads:ad_id_app_context:ping_ratio", 0.0f);
        String b = zzbVar.b("gads:ad_id_use_shared_preference:experiment_id", "");
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, z, zzbVar.getBoolean("gads:ad_id_use_persistent_service:enabled", false));
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zza(false);
            Info info = advertisingIdClient.getInfo();
            advertisingIdClient.zza(info, z, a, SystemClock.elapsedRealtime() - elapsedRealtime, b, null);
            return info;
        } finally {
        }
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb zzbVar = new zzb(context);
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L, zzbVar.getBoolean("gads:ad_id_app_context:enabled", false), zzbVar.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
        try {
            advertisingIdClient.zza(false);
            return advertisingIdClient.zzb();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private static com.google.android.gms.common.a zza(Context context, boolean z) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int g2 = GoogleApiAvailabilityLight.getInstance().g(context, c.a);
            if (g2 == 0 || g2 == 2) {
                String str = z ? "com.google.android.gms.ads.identifier.service.PERSISTENT_START" : "com.google.android.gms.ads.identifier.service.START";
                com.google.android.gms.common.a aVar = new com.google.android.gms.common.a();
                Intent intent = new Intent(str);
                intent.setPackage("com.google.android.gms");
                try {
                    if (ConnectionTracker.getInstance().a(context, intent, aVar, 1)) {
                        return aVar;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            }
            throw new IOException("Google Play services not available");
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    private static zze zza(Context context, com.google.android.gms.common.a aVar) throws IOException {
        try {
            return zzf.zza(aVar.a(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private final void zza() {
        synchronized (this.zzh) {
            zza zzaVar = this.zzi;
            if (zzaVar != null) {
                zzaVar.zzo.countDown();
                try {
                    this.zzi.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.zzk > 0) {
                this.zzi = new zza(this, this.zzk);
            }
        }
    }

    private final void zza(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        q.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzg) {
                finish();
            }
            com.google.android.gms.common.a zza2 = zza(this.mContext, this.zzj);
            this.zze = zza2;
            this.zzf = zza(this.mContext, zza2);
            this.zzg = true;
            if (z) {
                zza();
            }
        }
    }

    private final boolean zza(Info info, boolean z, float f2, long j2, String str, Throwable th) {
        if (Math.random() > f2) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("app_context", z ? "1" : "0");
        if (info != null) {
            hashMap.put("limit_ad_tracking", info.isLimitAdTrackingEnabled() ? "1" : "0");
        }
        if (info != null && info.getId() != null) {
            hashMap.put("ad_id_size", Integer.toString(info.getId().length()));
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("experiment_id", str);
        }
        hashMap.put(Issue.ISSUE_REPORT_TAG, "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j2));
        new a(this, hashMap).start();
        return true;
    }

    private final boolean zzb() throws IOException {
        boolean zzc;
        q.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzg) {
                synchronized (this.zzh) {
                    zza zzaVar = this.zzi;
                    if (zzaVar == null || !zzaVar.zzp) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            q.j(this.zze);
            q.j(this.zzf);
            try {
                zzc = this.zzf.zzc();
            } catch (RemoteException e3) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                throw new IOException("Remote exception");
            }
        }
        zza();
        return zzc;
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public final void finish() {
        q.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.zze == null) {
                return;
            }
            if (this.zzg) {
                ConnectionTracker.getInstance().b(this.mContext, this.zze);
            }
            this.zzg = false;
            this.zzf = null;
            this.zze = null;
        }
    }

    public Info getInfo() throws IOException {
        Info info;
        q.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzg) {
                synchronized (this.zzh) {
                    zza zzaVar = this.zzi;
                    if (zzaVar == null || !zzaVar.zzp) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zza(false);
                    if (!this.zzg) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            q.j(this.zze);
            q.j(this.zzf);
            try {
                info = new Info(this.zzf.getId(), this.zzf.zzb(true));
            } catch (RemoteException e3) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e3);
                throw new IOException("Remote exception");
            }
        }
        zza();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zza(true);
    }
}
