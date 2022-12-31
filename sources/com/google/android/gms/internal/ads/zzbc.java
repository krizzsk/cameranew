package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import us.pinguo.common.network.HttpRequest;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbc {
    @Nullable
    public static zzn zzb(zzz zzzVar) {
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzzVar.zzaj;
        if (map == null) {
            return null;
        }
        String str = map.get(HttpRequest.HEADER_DATE);
        long zzg = str != null ? zzg(str) : 0L;
        String str2 = map.get(HttpRequest.HEADER_CACHE_CONTROL);
        int i2 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            int i3 = 0;
            j2 = 0;
            j3 = 0;
            while (i2 < split.length) {
                String trim = split[i2].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j3 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i3 = 1;
                }
                i2++;
            }
            i2 = i3;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j3 = 0;
        }
        String str3 = map.get(HttpRequest.HEADER_EXPIRES);
        long zzg2 = str3 != null ? zzg(str3) : 0L;
        String str4 = map.get(HttpRequest.HEADER_LAST_MODIFIED);
        long zzg3 = str4 != null ? zzg(str4) : 0L;
        String str5 = map.get(HttpRequest.HEADER_ETAG);
        if (z) {
            j5 = currentTimeMillis + (j2 * 1000);
            if (i2 != 0) {
                j6 = j5;
            } else {
                Long.signum(j3);
                j6 = (j3 * 1000) + j5;
            }
            j4 = j6;
        } else {
            j4 = 0;
            if (zzg <= 0 || zzg2 < zzg) {
                j5 = 0;
            } else {
                j5 = currentTimeMillis + (zzg2 - zzg);
                j4 = j5;
            }
        }
        zzn zznVar = new zzn();
        zznVar.data = zzzVar.data;
        zznVar.zzr = str5;
        zznVar.zzv = j5;
        zznVar.zzu = j4;
        zznVar.zzs = zzg;
        zznVar.zzt = zzg3;
        zznVar.zzw = map;
        zznVar.zzx = zzzVar.allHeaders;
        return zznVar;
    }

    private static long zzg(String str) {
        try {
            return zzh("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e2) {
            if (!"0".equals(str) && !TaskDetailBasePresenter.SCENE_LIST.equals(str)) {
                zzao.zza(e2, "Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzao.v("Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    private static SimpleDateFormat zzh(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzb(long j2) {
        return zzh("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j2));
    }
}
