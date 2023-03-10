package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.tencent.tauth.AuthActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes2.dex */
public final class zzabs {
    private Context context;
    private File file;
    private String zzbrp;
    private String zzdat;
    private AtomicBoolean zzdav;
    private BlockingQueue<zzacc> zzdaq = new ArrayBlockingQueue(100);
    private LinkedHashMap<String, String> zzdar = new LinkedHashMap<>();
    private Map<String, zzabw> zzdas = new HashMap();
    private final HashSet<String> zzdau = new HashSet<>(Arrays.asList("noop", "activeViewPingSent", "viewabilityChanged", "visibilityChanged"));

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.context = context;
        this.zzbrp = str;
        this.zzdat = str2;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.zzdav = atomicBoolean;
        atomicBoolean.set(zzade.zzddf.get().booleanValue());
        if (this.zzdav.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.file = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzdar.put(entry.getKey(), entry.getValue());
        }
        zzazp.zzeic.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzabv
            private final zzabs zzdax;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdax = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdax.zzsi();
            }
        });
        Map<String, zzabw> map2 = this.zzdas;
        zzabw zzabwVar = zzabw.zzdaz;
        map2.put(AuthActivity.ACTION_KEY, zzabwVar);
        this.zzdas.put(FirebaseAnalytics.Param.AD_FORMAT, zzabwVar);
        this.zzdas.put("e", zzabw.zzdba);
    }

    public final zzabw zzcq(String str) {
        zzabw zzabwVar = this.zzdas.get(str);
        return zzabwVar != null ? zzabwVar : zzabw.zzday;
    }

    public final void zzcr(String str) {
        if (this.zzdau.contains(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, this.zzbrp);
        linkedHashMap.put("ue", str);
        zza(zza(this.zzdar, linkedHashMap), (zzacf) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzsi() {
        while (true) {
            try {
                zzacc take = this.zzdaq.take();
                zzacf zzsn = take.zzsn();
                if (zzsn != null && !TextUtils.isEmpty(zzsn.zzsr())) {
                    zza(zza(this.zzdar, take.zzso()), zzsn);
                }
            } catch (InterruptedException e2) {
                zzazk.zzd("CsiReporter:reporter interrupted", e2);
                return;
            }
        }
    }

    public final boolean zza(zzacc zzaccVar) {
        return this.zzdaq.offer(zzaccVar);
    }

    private final void zza(Map<String, String> map, zzacf zzacfVar) {
        FileOutputStream fileOutputStream;
        Uri.Builder buildUpon = Uri.parse(this.zzdat).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String uri = buildUpon.build().toString();
        if (zzacfVar != null) {
            StringBuilder sb = new StringBuilder(uri);
            if (!TextUtils.isEmpty(zzacfVar.zzsr())) {
                sb.append("&it=");
                sb.append(zzacfVar.zzsr());
            }
            if (!TextUtils.isEmpty(zzacfVar.zzss())) {
                sb.append("&blat=");
                sb.append(zzacfVar.zzss());
            }
            uri = sb.toString();
        }
        if (this.zzdav.get()) {
            File file = this.file;
            if (file != null) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file, true);
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(uri.getBytes());
                    fileOutputStream.write(10);
                    try {
                        fileOutputStream.close();
                        return;
                    } catch (IOException e3) {
                        zzazk.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
                        return;
                    }
                } catch (IOException e4) {
                    e = e4;
                    fileOutputStream2 = fileOutputStream;
                    zzazk.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            return;
                        } catch (IOException e5) {
                            zzazk.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                            zzazk.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e6);
                        }
                    }
                    throw th;
                }
            }
            zzazk.zzex("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
            return;
        }
        com.google.android.gms.ads.internal.zzr.zzkr();
        com.google.android.gms.ads.internal.util.zzj.zzb(this.context, this.zzbrp, uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String str = (String) linkedHashMap.get(key);
            linkedHashMap.put(key, zzcq(key).zzf(str, entry.getValue()));
        }
        return linkedHashMap;
    }
}
