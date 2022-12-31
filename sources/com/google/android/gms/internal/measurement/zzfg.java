package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class zzfg<T> {
    public static final /* synthetic */ int zzc = 0;
    @Nullable
    private static volatile zzff zze = null;
    private static volatile boolean zzf = false;
    final zzfe zza;
    final String zzb;
    private final T zzi;
    private volatile int zzk = -1;
    private volatile T zzl;
    private final boolean zzm;
    private static final Object zzd = new Object();
    private static final AtomicReference<Collection<zzfg<?>>> zzg = new AtomicReference<>();
    private static final zzfi zzh = new zzfi(zzez.zza);
    private static final AtomicInteger zzj = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ zzfg(zzfe zzfeVar, String str, Object obj, boolean z, zzfa zzfaVar) {
        if (zzfeVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zza = zzfeVar;
        this.zzb = str;
        this.zzi = obj;
        this.zzm = true;
    }

    @Deprecated
    public static void zzb(final Context context) {
        synchronized (zzd) {
            zzff zzffVar = zze;
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            if (zzffVar == null || zzffVar.zza() != context) {
                zzen.zzd();
                zzfh.zzb();
                zzeu.zzc();
                zze = new zzek(context, zzfs.zza(new zzfo(context) { // from class: com.google.android.gms.internal.measurement.zzey
                    private final Context zza;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zza = context;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzfo
                    public final Object zza() {
                        zzfm zzc2;
                        Context context2 = this.zza;
                        int i2 = zzfg.zzc;
                        String str = Build.TYPE;
                        String str2 = Build.TAGS;
                        if ((!str.equals("eng") && !str.equals("userdebug")) || (!str2.contains("dev-keys") && !str2.contains("test-keys"))) {
                            return zzfm.zzc();
                        }
                        if (zzej.zza() && !context2.isDeviceProtectedStorage()) {
                            context2 = context2.createDeviceProtectedStorageContext();
                        }
                        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            StrictMode.allowThreadDiskWrites();
                            try {
                                File file = new File(context2.getDir("phenotype_hermetic", 0), "overrides.txt");
                                zzc2 = file.exists() ? zzfm.zzd(file) : zzfm.zzc();
                            } catch (RuntimeException e2) {
                                Log.e("HermeticFileOverrides", "no data dir", e2);
                                zzc2 = zzfm.zzc();
                            }
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            if (zzc2.zza()) {
                                File file2 = (File) zzc2.zzb();
                                try {
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                    HashMap hashMap = new HashMap();
                                    HashMap hashMap2 = new HashMap();
                                    while (true) {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine != null) {
                                            String[] split = readLine.split(" ", 3);
                                            if (split.length != 3) {
                                                Log.e("HermeticFileOverrides", readLine.length() != 0 ? "Invalid: ".concat(readLine) : new String("Invalid: "));
                                            } else {
                                                String str3 = new String(split[0]);
                                                String decode = Uri.decode(new String(split[1]));
                                                String str4 = (String) hashMap2.get(split[2]);
                                                if (str4 == null) {
                                                    String str5 = new String(split[2]);
                                                    str4 = Uri.decode(str5);
                                                    if (str4.length() < 1024 || str4 == str5) {
                                                        hashMap2.put(str5, str4);
                                                    }
                                                }
                                                if (!hashMap.containsKey(str3)) {
                                                    hashMap.put(str3, new HashMap());
                                                }
                                                ((Map) hashMap.get(str3)).put(decode, str4);
                                            }
                                        } else {
                                            String valueOf = String.valueOf(file2);
                                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
                                            sb.append("Parsed ");
                                            sb.append(valueOf);
                                            Log.i("HermeticFileOverrides", sb.toString());
                                            zzev zzevVar = new zzev(hashMap);
                                            bufferedReader.close();
                                            return zzfm.zzd(zzevVar);
                                        }
                                    }
                                } catch (IOException e3) {
                                    throw new RuntimeException(e3);
                                }
                            } else {
                                return zzfm.zzc();
                            }
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            throw th;
                        }
                    }
                }));
                zzj.incrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc() {
        zzj.incrementAndGet();
    }

    abstract T zza(Object obj);

    public final String zzd() {
        String str = this.zza.zzd;
        return this.zzb;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8 A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:8:0x0016, B:10:0x001a, B:12:0x0020, B:14:0x0037, B:16:0x0043, B:18:0x004c, B:20:0x005e, B:22:0x0069, B:21:0x0063, B:43:0x00de, B:45:0x00ee, B:47:0x0104, B:48:0x0107, B:49:0x010b, B:37:0x00b8, B:39:0x00d4, B:42:0x00dc, B:24:0x006e, B:26:0x0074, B:28:0x0082, B:32:0x00a7, B:34:0x00b1, B:30:0x0099, B:50:0x0110, B:51:0x0115, B:52:0x0116), top: B:59:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:8:0x0016, B:10:0x001a, B:12:0x0020, B:14:0x0037, B:16:0x0043, B:18:0x004c, B:20:0x005e, B:22:0x0069, B:21:0x0063, B:43:0x00de, B:45:0x00ee, B:47:0x0104, B:48:0x0107, B:49:0x010b, B:37:0x00b8, B:39:0x00d4, B:42:0x00dc, B:24:0x006e, B:26:0x0074, B:28:0x0082, B:32:0x00a7, B:34:0x00b1, B:30:0x0099, B:50:0x0110, B:51:0x0115, B:52:0x0116), top: B:59:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T zze() {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfg.zze():java.lang.Object");
    }
}
