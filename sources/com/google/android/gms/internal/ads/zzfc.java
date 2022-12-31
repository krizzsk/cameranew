package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzcf;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzfc {
    private static final String TAG = "zzfc";
    protected Context context;
    private zzfa zzyp;
    private ExecutorService zzyy;
    private DexClassLoader zzyz;
    private zzek zzza;
    private byte[] zzzb;
    private boolean zzze;
    private zzdw zzzh;
    private Map<Pair<String, String>, zzgl> zzzk;
    private volatile AdvertisingIdClient zzzc = null;
    private volatile boolean zzxf = false;
    private Future zzzd = null;
    private volatile zzcf.zza zzzf = null;
    private Future zzzg = null;
    private boolean zzzi = false;
    private boolean zzzj = false;
    private boolean zzzl = false;

    private zzfc(Context context) {
        Context applicationContext = context.getApplicationContext();
        boolean z = applicationContext != null;
        this.zzze = z;
        this.context = z ? applicationContext : context;
        this.zzzk = new HashMap();
        if (this.zzyp == null) {
            this.zzyp = new zzfa(this.context);
        }
    }

    public static zzfc zza(Context context, String str, String str2, boolean z) {
        zzek zzekVar;
        zzfc zzfcVar = new zzfc(context);
        try {
            zzfcVar.zzyy = Executors.newCachedThreadPool(new zzfb());
            zzfcVar.zzxf = z;
            if (z) {
                zzfcVar.zzzd = zzfcVar.zzyy.submit(new zzfe(zzfcVar));
            }
            zzfcVar.zzyy.execute(new zzfg(zzfcVar));
            try {
                GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
                zzfcVar.zzzi = googleApiAvailabilityLight.a(zzfcVar.context) > 0;
                zzfcVar.zzzj = googleApiAvailabilityLight.f(zzfcVar.context) == 0;
            } catch (Throwable unused) {
            }
            zzfcVar.zza(0, true);
            if (zzfh.isMainThread() && ((Boolean) zzwr.zzqr().zzd(zzabp.zzcsi)).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            zzekVar = new zzek(null);
            zzfcVar.zzza = zzekVar;
        } catch (zzev unused2) {
        }
        try {
            zzfcVar.zzzb = zzekVar.zzao(str);
            try {
                try {
                    File cacheDir = zzfcVar.context.getCacheDir();
                    if (cacheDir == null && (cacheDir = zzfcVar.context.getDir("dex", 0)) == null) {
                        throw new zzev();
                    }
                    File file = new File(String.format("%s/%s.jar", cacheDir, "1608138930680"));
                    if (!file.exists()) {
                        byte[] zza = zzfcVar.zzza.zza(zzfcVar.zzzb, str2);
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(zza, 0, zza.length);
                        fileOutputStream.close();
                    }
                    zzfcVar.zzb(cacheDir, "1608138930680");
                    try {
                        zzfcVar.zzyz = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzfcVar.context.getClassLoader());
                        zzc(file);
                        zzfcVar.zza(cacheDir, "1608138930680");
                        zzap(String.format("%s/%s.dex", cacheDir, "1608138930680"));
                        zzfcVar.zzzh = new zzdw(zzfcVar);
                        zzfcVar.zzzl = true;
                        return zzfcVar;
                    } catch (Throwable th) {
                        zzc(file);
                        zzfcVar.zza(cacheDir, "1608138930680");
                        zzap(String.format("%s/%s.dex", cacheDir, "1608138930680"));
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    throw new zzev(e2);
                } catch (IOException e3) {
                    throw new zzev(e3);
                }
            } catch (zzej e4) {
                throw new zzev(e4);
            } catch (NullPointerException e5) {
                throw new zzev(e5);
            }
        } catch (zzej e6) {
            throw new zzev(e6);
        }
    }

    private static void zzap(String str) {
        zzc(new File(str));
    }

    private final boolean zzb(File file, String str) {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (file3.exists()) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            long length = file2.length();
            if (length <= 0) {
                zzc(file2);
                return false;
            }
            byte[] bArr = new byte[(int) length];
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            try {
                try {
                    if (fileInputStream2.read(bArr) <= 0) {
                        Log.d(TAG, "Cannot read the cache data.");
                        zzc(file2);
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        return false;
                    }
                    try {
                        try {
                            zzcf.zzc zzb = zzcf.zzc.zzb(bArr, zzeko.zzbhw());
                            if (str.equals(new String(zzb.zzbc().toByteArray())) && Arrays.equals(zzb.zzbb().toByteArray(), zzda.zzb(zzb.zzba().toByteArray())) && Arrays.equals(zzb.zzbd().toByteArray(), Build.VERSION.SDK.getBytes())) {
                                byte[] zza = this.zzza.zza(this.zzzb, new String(zzb.zzba().toByteArray()));
                                file3.createNewFile();
                                fileOutputStream = new FileOutputStream(file3);
                                try {
                                    fileOutputStream.write(zza, 0, zza.length);
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException unused2) {
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                    return true;
                                } catch (zzej | IOException | NoSuchAlgorithmException unused4) {
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException unused5) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException unused6) {
                                        }
                                    }
                                    return false;
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException unused7) {
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException unused8) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                            zzc(file2);
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused9) {
                            }
                            return false;
                        } catch (NullPointerException unused10) {
                            fileInputStream2.close();
                            return false;
                        }
                    } catch (IOException unused11) {
                        return false;
                    }
                } catch (zzej | IOException | NoSuchAlgorithmException unused12) {
                    fileOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (zzej | IOException | NoSuchAlgorithmException unused13) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static void zzc(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        } else {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzcq() {
        try {
            if (this.zzzc == null && this.zzze) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.context);
                advertisingIdClient.start();
                this.zzzc = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzzc = null;
        }
    }

    @VisibleForTesting
    private final zzcf.zza zzcr() {
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            Context context = this.context;
            return zzdti.zzj(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean isInitialized() {
        return this.zzzl;
    }

    public final int zzbu() {
        if (this.zzzh != null) {
            return zzdw.zzbu();
        }
        return Integer.MIN_VALUE;
    }

    public final boolean zzcf() {
        return this.zzyp.zzcf();
    }

    public final ExecutorService zzcg() {
        return this.zzyy;
    }

    public final DexClassLoader zzch() {
        return this.zzyz;
    }

    public final zzek zzci() {
        return this.zzza;
    }

    public final byte[] zzcj() {
        return this.zzzb;
    }

    public final boolean zzck() {
        return this.zzzi;
    }

    public final zzdw zzcl() {
        return this.zzzh;
    }

    public final boolean zzcm() {
        return this.zzzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfa zzcn() {
        return this.zzyp;
    }

    public final zzcf.zza zzco() {
        return this.zzzf;
    }

    public final Future zzcp() {
        return this.zzzg;
    }

    public final AdvertisingIdClient zzcs() {
        if (this.zzxf) {
            if (this.zzzc != null) {
                return this.zzzc;
            }
            Future future = this.zzzd;
            if (future != null) {
                try {
                    future.get(2000L, TimeUnit.MILLISECONDS);
                    this.zzzd = null;
                } catch (InterruptedException | ExecutionException unused) {
                } catch (TimeoutException unused2) {
                    this.zzzd.cancel(true);
                }
            }
            return this.zzzc;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzcf.zza zzb(int i2, boolean z) {
        if (i2 > 0 && z) {
            try {
                Thread.sleep(i2 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        return zzcr();
    }

    private final void zza(File file, String str) {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file3);
            try {
                if (fileInputStream2.read(bArr) <= 0) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    zzc(file3);
                    return;
                }
                System.out.print("test");
                System.out.print("test");
                System.out.print("test");
                zzcf.zzc.zza zzg = zzcf.zzc.zzbe().zzh(zzejr.zzt(Build.VERSION.SDK.getBytes())).zzg(zzejr.zzt(str.getBytes()));
                byte[] bytes = this.zzza.zzb(this.zzzb, bArr).getBytes();
                zzg.zze(zzejr.zzt(bytes)).zzf(zzejr.zzt(zzda.zzb(bytes)));
                file2.createNewFile();
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] byteArray = ((zzcf.zzc) ((zzelb) zzg.zzbiw())).toByteArray();
                    fileOutputStream.write(byteArray, 0, byteArray.length);
                    fileOutputStream.close();
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    zzc(file3);
                } catch (zzej | IOException | NoSuchAlgorithmException unused4) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    zzc(file3);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                    zzc(file3);
                    throw th;
                }
            } catch (zzej | IOException | NoSuchAlgorithmException unused9) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (zzej | IOException | NoSuchAlgorithmException unused10) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzzk.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzzk.put(new Pair<>(str, str2), new zzgl(this, str, str2, clsArr));
        return true;
    }

    public final Method zza(String str, String str2) {
        zzgl zzglVar = this.zzzk.get(new Pair(str, str2));
        if (zzglVar == null) {
            return null;
        }
        return zzglVar.zzdb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(int i2, boolean z) {
        if (this.zzzj) {
            Future<?> submit = this.zzyy.submit(new zzfd(this, i2, z));
            if (i2 == 0) {
                this.zzzg = submit;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zza(int i2, zzcf.zza zzaVar) {
        if (i2 < 4) {
            return zzaVar == null || !zzaVar.zzai() || zzaVar.zzaf().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zzaVar.zzan() || !zzaVar.zzao().zzbg() || zzaVar.zzao().zzbh() == -2;
        }
        return false;
    }
}
