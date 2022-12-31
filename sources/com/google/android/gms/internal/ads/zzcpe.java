package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.k;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import us.pinguo.common.network.HttpRequest;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcpe implements zzdqu<zzcpd, zzcpg> {
    private final Context context;
    private final String zzdux;
    private final zzauh zzgpl;
    private final String zzgqb;
    private final int zzgqc;

    public zzcpe(Context context, String str, zzauh zzauhVar, String str2, int i2) {
        this.context = context;
        this.zzgqb = str;
        this.zzgpl = zzauhVar;
        this.zzdux = str2;
        this.zzgqc = i2;
    }

    private final zzcpg zza(String str, zzatw zzatwVar, JSONObject jSONObject, String str2) throws zzcmb {
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        int responseCode;
        InputStreamReader inputStreamReader;
        BufferedOutputStream bufferedOutputStream;
        JSONObject jSONObject2 = jSONObject;
        try {
            int optInt = jSONObject2.optInt("http_timeout_millis", 60000);
            if (zzatwVar.getErrorCode() != -2) {
                if (zzatwVar.getErrorCode() == 1) {
                    if (zzatwVar.zzwl() != null) {
                        zzazk.zzev(TextUtils.join(", ", zzatwVar.zzwl()));
                    }
                    throw new zzcmb(zzdom.INVALID_REQUEST, "Error building request URL.");
                }
                throw new zzcmb(zzdom.INTERNAL_ERROR);
            }
            zzcpg zzcpgVar = new zzcpg();
            String valueOf = String.valueOf(this.zzgqb);
            zzazk.zzew(valueOf.length() != 0 ? "SDK version: ".concat(valueOf) : new String("SDK version: "));
            String valueOf2 = String.valueOf(str);
            zzazk.zzdy(valueOf2.length() != 0 ? "AdRequestServiceImpl: Sending request: ".concat(valueOf2) : new String("AdRequestServiceImpl: Sending request: "));
            URL url = new URL(str);
            HashMap hashMap = new HashMap();
            long a = com.google.android.gms.ads.internal.zzr.zzky().a();
            int i2 = 0;
            while (true) {
                this.zzgpl.zzdc(this.zzgqc);
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection = httpURLConnection2;
                    try {
                        try {
                            com.google.android.gms.ads.internal.zzr.zzkr().zza(this.context, this.zzgqb, false, httpURLConnection2, false, optInt);
                            if (zzatwVar.zzwp() && !TextUtils.isEmpty(str2)) {
                                httpURLConnection.addRequestProperty("Cookie", str2);
                            }
                            if (zzatwVar.zzwo()) {
                                JSONObject optJSONObject = jSONObject2.optJSONObject("pii");
                                if (optJSONObject != null) {
                                    if (!TextUtils.isEmpty(optJSONObject.optString("doritos", ""))) {
                                        httpURLConnection.addRequestProperty("x-afma-drt-cookie", optJSONObject.optString("doritos", ""));
                                    }
                                    if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", ""))) {
                                        httpURLConnection.addRequestProperty("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", ""));
                                    }
                                } else {
                                    com.google.android.gms.ads.internal.util.zzd.zzeb("DSID signal does not exist.");
                                }
                            }
                            if (zzatwVar == null || TextUtils.isEmpty(zzatwVar.zzwn())) {
                                bArr = null;
                            } else {
                                httpURLConnection.setDoOutput(true);
                                bArr = zzatwVar.zzwn().getBytes();
                                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                                try {
                                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                                    try {
                                        bufferedOutputStream2.write(bArr);
                                        k.a(bufferedOutputStream2);
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        k.a(bufferedOutputStream);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedOutputStream = null;
                                }
                            }
                            zzaze zzazeVar = new zzaze();
                            zzazeVar.zza(httpURLConnection, bArr);
                            responseCode = httpURLConnection.getResponseCode();
                            for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                                String key = entry.getKey();
                                List<String> value = entry.getValue();
                                if (hashMap.containsKey(key)) {
                                    ((List) hashMap.get(key)).addAll(value);
                                } else {
                                    hashMap.put(key, new ArrayList(value));
                                }
                            }
                            zzazeVar.zza(httpURLConnection, responseCode);
                            zzcpgVar.zzgqd = responseCode;
                            zzcpgVar.zzaj = hashMap;
                            zzcpgVar.zzdvw = "";
                            if (responseCode >= 200 && responseCode < 300) {
                                try {
                                    InputStreamReader inputStreamReader2 = new InputStreamReader(httpURLConnection.getInputStream());
                                    try {
                                        com.google.android.gms.ads.internal.zzr.zzkr();
                                        String zza = com.google.android.gms.ads.internal.util.zzj.zza(inputStreamReader2);
                                        k.a(inputStreamReader2);
                                        zzazeVar.zzes(zza);
                                        zzcpgVar.zzdvw = zza;
                                        if (TextUtils.isEmpty(zza)) {
                                            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcwk)).booleanValue()) {
                                                throw new zzcmb(zzdom.NO_FILL);
                                            }
                                        }
                                        zzcpgVar.zzgqe = com.google.android.gms.ads.internal.zzr.zzky().a() - a;
                                        httpURLConnection.disconnect();
                                        this.zzgpl.zzwu();
                                        return zzcpgVar;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        inputStreamReader = inputStreamReader2;
                                        k.a(inputStreamReader);
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    inputStreamReader = null;
                                }
                            } else if (responseCode < 300 || responseCode >= 400) {
                                break;
                            } else {
                                String headerField = httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION);
                                if (!TextUtils.isEmpty(headerField)) {
                                    url = new URL(headerField);
                                    int i3 = i2 + 1;
                                    if (i3 <= ((Integer) zzwr.zzqr().zzd(zzabp.zzcvl)).intValue()) {
                                        httpURLConnection.disconnect();
                                        this.zzgpl.zzwu();
                                        jSONObject2 = jSONObject;
                                        i2 = i3;
                                    } else {
                                        zzazk.zzex("Too many redirects.");
                                        throw new zzcmb(zzdom.INTERNAL_ERROR, "Too many redirects");
                                    }
                                } else {
                                    zzazk.zzex("No location header to follow redirect.");
                                    throw new zzcmb(zzdom.INTERNAL_ERROR, "No location header to follow redirect");
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            httpURLConnection.disconnect();
                            this.zzgpl.zzwu();
                            throw th;
                        }
                    } catch (zzcmb e2) {
                        e = e2;
                        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdaa)).booleanValue()) {
                            zzcpgVar.zzgqe = com.google.android.gms.ads.internal.zzr.zzky().a() - a;
                            httpURLConnection.disconnect();
                            this.zzgpl.zzwu();
                            return zzcpgVar;
                        }
                        throw e;
                    }
                } catch (zzcmb e3) {
                    e = e3;
                    httpURLConnection = httpURLConnection2;
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection = httpURLConnection2;
                }
            }
            StringBuilder sb = new StringBuilder(46);
            sb.append("Received error HTTP response code: ");
            sb.append(responseCode);
            zzazk.zzex(sb.toString());
            zzdom zzdomVar = zzdom.INTERNAL_ERROR;
            StringBuilder sb2 = new StringBuilder(46);
            sb2.append("Received error HTTP response code: ");
            sb2.append(responseCode);
            throw new zzcmb(zzdomVar, sb2.toString());
        } catch (IOException e4) {
            String valueOf3 = String.valueOf(e4.getMessage());
            String concat = valueOf3.length() != 0 ? "Error while connecting to ad server: ".concat(valueOf3) : new String("Error while connecting to ad server: ");
            zzazk.zzex(concat);
            throw new zzcmb(zzdom.INTERNAL_ERROR, concat, e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdqu
    public final /* synthetic */ zzcpg apply(zzcpd zzcpdVar) throws Exception {
        zzatw zzatwVar;
        zzatw zzatwVar2;
        JSONObject jSONObject;
        zzcpd zzcpdVar2 = zzcpdVar;
        zzatwVar = zzcpdVar2.zzgpv;
        String url = zzatwVar.getUrl();
        zzatwVar2 = zzcpdVar2.zzgpv;
        jSONObject = zzcpdVar2.zzgpu;
        return zza(url, zzatwVar2, jSONObject, this.zzdux);
    }
}
