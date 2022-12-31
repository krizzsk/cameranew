package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.h;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.constants.Constants;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaze {
    @GuardedBy("lock")
    private static boolean enabled = false;
    @GuardedBy("lock")
    private static boolean zzehs = false;
    private final List<String> zzehu;
    private static Object lock = new Object();
    private static Clock zzbqg = h.getInstance();
    private static final Set<String> zzeht = new HashSet(Arrays.asList(new String[0]));

    public zzaze() {
        this(null);
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (lock) {
            z = zzehs && enabled;
        }
        return z;
    }

    public static boolean zzaaa() {
        boolean z;
        synchronized (lock) {
            z = zzehs;
        }
        return z;
    }

    public static void zzas(boolean z) {
        synchronized (lock) {
            zzehs = true;
            enabled = z;
        }
    }

    private final void zzb(final String str, final String str2, @Nullable final Map<String, ?> map, @Nullable final byte[] bArr) {
        zza("onNetworkRequest", new zzazh(str, str2, map, bArr) { // from class: com.google.android.gms.internal.ads.zzazd
            private final String zzdjf;
            private final String zzdlh;
            private final Map zzehq;
            private final byte[] zzehr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = str;
                this.zzdjf = str2;
                this.zzehq = map;
                this.zzehr = bArr;
            }

            @Override // com.google.android.gms.internal.ads.zzazh
            public final void zzb(JsonWriter jsonWriter) {
                zzaze.zza(this.zzdlh, this.zzdjf, this.zzehq, this.zzehr, jsonWriter);
            }
        });
    }

    public static boolean zzbs(Context context) {
        if (Build.VERSION.SDK_INT >= 17 && zzadh.zzddu.get().booleanValue()) {
            try {
                return Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
            } catch (Exception e2) {
                zzazk.zzd("Fail to determine debug setting.", e2);
                return false;
            }
        }
        return false;
    }

    private final void zzet(@Nullable final String str) {
        zza("onNetworkRequestError", new zzazh(str) { // from class: com.google.android.gms.internal.ads.zzazi
            private final String zzdlh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = str;
            }

            @Override // com.google.android.gms.internal.ads.zzazh
            public final void zzb(JsonWriter jsonWriter) {
                zzaze.zza(this.zzdlh, jsonWriter);
            }
        });
    }

    private static synchronized void zzeu(String str) {
        synchronized (zzaze.class) {
            zzazk.zzew("GMA Debug BEGIN");
            int i2 = 0;
            while (i2 < str.length()) {
                int i3 = i2 + Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM;
                String valueOf = String.valueOf(str.substring(i2, Math.min(i3, str.length())));
                zzazk.zzew(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i2 = i3;
            }
            zzazk.zzew("GMA Debug FINISH");
        }
    }

    public static void zzzz() {
        synchronized (lock) {
            zzehs = false;
            enabled = false;
            zzazk.zzex("Ad debug logging enablement is out of date.");
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        if (isEnabled()) {
            zzb(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr);
        }
    }

    public final void zzes(@Nullable String str) {
        if (isEnabled() && str != null) {
            zzi(str.getBytes());
        }
    }

    public final void zzi(final byte[] bArr) {
        zza("onNetworkResponseBody", new zzazh(bArr) { // from class: com.google.android.gms.internal.ads.zzazf
            private final byte[] zzehv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehv = bArr;
            }

            @Override // com.google.android.gms.internal.ads.zzazh
            public final void zzb(JsonWriter jsonWriter) {
                zzaze.zza(this.zzehv, jsonWriter);
            }
        });
    }

    public zzaze(@Nullable String str) {
        List<String> asList;
        if (!isEnabled()) {
            asList = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            asList = Arrays.asList(strArr);
        }
        this.zzehu = asList;
    }

    private final void zzb(@Nullable final Map<String, ?> map, final int i2) {
        zza("onNetworkResponse", new zzazh(i2, map) { // from class: com.google.android.gms.internal.ads.zzazg
            private final int zzehw;
            private final Map zzehx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzehw = i2;
                this.zzehx = map;
            }

            @Override // com.google.android.gms.internal.ads.zzazh
            public final void zzb(JsonWriter jsonWriter) {
                zzaze.zza(this.zzehw, this.zzehx, jsonWriter);
            }
        });
    }

    public final void zza(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        if (isEnabled()) {
            zzb(str, str2, map, bArr);
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, int i2) {
        if (isEnabled()) {
            String str = null;
            zzb(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i2);
            if (i2 < 200 || i2 >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    zzazk.zzex(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                zzet(str);
            }
        }
    }

    public final void zza(@Nullable Map<String, ?> map, int i2) {
        if (isEnabled()) {
            zzb(map, i2);
            if (i2 < 200 || i2 >= 300) {
                zzet(null);
            }
        }
    }

    private static void zza(JsonWriter jsonWriter, @Nullable Map<String, ?> map) throws IOException {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it.next();
            String key = next.getKey();
            if (!zzeht.contains(key)) {
                if (next.getValue() instanceof List) {
                    for (String str : (List) next.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(key);
                        jsonWriter.name(FirebaseAnalytics.Param.VALUE).value(str);
                        jsonWriter.endObject();
                    }
                } else if (next.getValue() instanceof String) {
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(key);
                    jsonWriter.name(FirebaseAnalytics.Param.VALUE).value((String) next.getValue());
                    jsonWriter.endObject();
                } else {
                    zzazk.zzev("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                    break;
                }
            }
        }
        jsonWriter.endArray();
    }

    private final void zza(String str, zzazh zzazhVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zzbqg.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String str2 : this.zzehu) {
                jsonWriter.value(str2);
            }
            jsonWriter.endArray();
            zzazhVar.zzb(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e2) {
            zzazk.zzc("unable to log", e2);
        }
        zzeu(stringWriter.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name("error_description").value(str);
        }
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String a = c.a(bArr);
        if (length < 10000) {
            jsonWriter.name("body").value(a);
        } else {
            String zzeq = zzaza.zzeq(a);
            if (zzeq != null) {
                jsonWriter.name("bodydigest").value(zzeq);
            }
        }
        jsonWriter.name("bodylength").value(length);
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(int i2, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(i2);
        jsonWriter.endObject();
        zza(jsonWriter, map);
        jsonWriter.endObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zza(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name("body").value(c.a(bArr));
        }
        jsonWriter.endObject();
    }
}
