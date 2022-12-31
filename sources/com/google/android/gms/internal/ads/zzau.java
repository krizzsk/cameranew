package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import us.pinguo.common.network.HttpRequest;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzau implements zzu {
    @Deprecated
    private final zzbe zzce;
    private final zzar zzcf;
    private final zzat zzcg;

    public zzau(zzar zzarVar) {
        this(zzarVar, new zzat(4096));
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public zzz zza(zzab<?> zzabVar) throws zzap {
        IOException iOException;
        zzbb zzbbVar;
        byte[] bArr;
        Map<String, String> map;
        zzbb zza;
        int statusCode;
        List<zzv> zzq;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            try {
                zzn zzf = zzabVar.zzf();
                if (zzf == null) {
                    map = Collections.emptyMap();
                } else {
                    HashMap hashMap = new HashMap();
                    String str = zzf.zzr;
                    if (str != null) {
                        hashMap.put(HttpRequest.HEADER_IF_NONE_MATCH, str);
                    }
                    long j2 = zzf.zzt;
                    if (j2 > 0) {
                        hashMap.put("If-Modified-Since", zzbc.zzb(j2));
                    }
                    map = hashMap;
                }
                zza = this.zzcf.zza(zzabVar, map);
                try {
                    statusCode = zza.getStatusCode();
                    zzq = zza.zzq();
                    break;
                } catch (IOException e2) {
                    bArr = null;
                    zzbbVar = zza;
                    iOException = e2;
                }
            } catch (IOException e3) {
                iOException = e3;
                zzbbVar = null;
                bArr = null;
            }
            zzbi.zza(zzabVar, iOException, elapsedRealtime, zzbbVar, bArr);
        }
        if (statusCode == 304) {
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            zzn zzf2 = zzabVar.zzf();
            if (zzf2 == null) {
                return new zzz(304, (byte[]) null, true, elapsedRealtime2, zzq);
            }
            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
            if (!zzq.isEmpty()) {
                for (zzv zzvVar : zzq) {
                    treeSet.add(zzvVar.getName());
                }
            }
            ArrayList arrayList = new ArrayList(zzq);
            List<zzv> list = zzf2.zzx;
            if (list != null) {
                if (!list.isEmpty()) {
                    for (zzv zzvVar2 : zzf2.zzx) {
                        if (!treeSet.contains(zzvVar2.getName())) {
                            arrayList.add(zzvVar2);
                        }
                    }
                }
            } else if (!zzf2.zzw.isEmpty()) {
                for (Map.Entry<String, String> entry : zzf2.zzw.entrySet()) {
                    if (!treeSet.contains(entry.getKey())) {
                        arrayList.add(new zzv(entry.getKey(), entry.getValue()));
                    }
                }
            }
            return new zzz(304, zzf2.data, true, elapsedRealtime2, (List<zzv>) arrayList);
        }
        InputStream content = zza.getContent();
        byte[] zza2 = content != null ? zzbi.zza(content, zza.getContentLength(), this.zzcg) : new byte[0];
        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (zzao.DEBUG || elapsedRealtime3 > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = zzabVar;
            objArr[1] = Long.valueOf(elapsedRealtime3);
            objArr[2] = zza2 != null ? Integer.valueOf(zza2.length) : "null";
            objArr[3] = Integer.valueOf(statusCode);
            objArr[4] = Integer.valueOf(zzabVar.zzj().zzc());
            zzao.d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
        if (statusCode >= 200 && statusCode <= 299) {
            return new zzz(statusCode, zza2, false, SystemClock.elapsedRealtime() - elapsedRealtime, zzq);
        }
        throw new IOException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private zzau(zzar zzarVar, zzat zzatVar) {
        this.zzcf = zzarVar;
        this.zzce = zzarVar;
        this.zzcg = zzatVar;
    }
}
