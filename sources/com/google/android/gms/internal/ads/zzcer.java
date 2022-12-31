package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tapjoy.TJAdUnitConstants;
import com.tencent.matrix.trace.constants.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.api.QiniuAuthToken;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcer {
    private final Context context;
    private final Executor executor;
    private final zzazn zzbpn;
    private final zzaeh zzdoe;
    private final zztu zzeqv;
    private final zzei zzesm;
    private final ScheduledExecutorService zzfri;
    private final zzcem zzghy;
    private final com.google.android.gms.ads.internal.zzb zzghz;
    private final zzcfi zzgia;

    public zzcer(Context context, zzcem zzcemVar, zzei zzeiVar, zzazn zzaznVar, com.google.android.gms.ads.internal.zzb zzbVar, zztu zztuVar, Executor executor, zzdnp zzdnpVar, zzcfi zzcfiVar, ScheduledExecutorService scheduledExecutorService) {
        this.context = context;
        this.zzghy = zzcemVar;
        this.zzesm = zzeiVar;
        this.zzbpn = zzaznVar;
        this.zzghz = zzbVar;
        this.zzeqv = zztuVar;
        this.executor = executor;
        this.zzdoe = zzdnpVar.zzdoe;
        this.zzgia = zzcfiVar;
        this.zzfri = scheduledExecutorService;
    }

    private final zzdzw<List<zzaed>> zza(@Nullable JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray != null && jSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            int length = z2 ? jSONArray.length() : 1;
            for (int i2 = 0; i2 < length; i2++) {
                arrayList.add(zza(jSONArray.optJSONObject(i2), z));
            }
            return zzdzk.zzb(zzdzk.zzi(arrayList), zzceu.zzeaj, this.executor);
        }
        return zzdzk.zzag(Collections.emptyList());
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<zzzu> zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzdxd.zzazm();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                zzzu zzl = zzl(optJSONArray.optJSONObject(i2));
                if (zzl != null) {
                    arrayList.add(zzl);
                }
            }
            return zzdxd.zzb(arrayList);
        }
        return zzdxd.zzazm();
    }

    @Nullable
    public static zzzu zzk(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzl(optJSONObject);
    }

    @Nullable
    private static zzzu zzl(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzzu(optString, optString2);
    }

    public final zzdzw<zzaed> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzdoe.zzdft);
    }

    public final zzdzw<List<zzaed>> zzd(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        zzaeh zzaehVar = this.zzdoe;
        return zza(optJSONArray, zzaehVar.zzdft, zzaehVar.zzbnu);
    }

    public final zzdzw<zzady> zze(JSONObject jSONObject, String str) {
        final JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzdzk.zzag(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(QiniuAuthToken.TYPE_IMAGE);
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zza(optJSONObject.optBoolean("require"), zzdzk.zzb(zza(optJSONArray, false, true), new zzdvz(this, optJSONObject) { // from class: com.google.android.gms.internal.ads.zzcew
            private final JSONObject zzfst;
            private final zzcer zzgie;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgie = this;
                this.zzfst = optJSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdvz
            public final Object apply(Object obj) {
                return this.zzgie.zza(this.zzfst, (List) obj);
            }
        }, this.executor), (Object) null);
    }

    public final zzdzw<zzbeb> zzm(JSONObject jSONObject) {
        JSONObject zza = com.google.android.gms.ads.internal.util.zzbh.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzdzk.zzag(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzazk.zzex("Required field 'vast_xml' is missing");
                return zzdzk.zzag(null);
            }
            return zza(zzdzk.zza(this.zzgia.zzn(optJSONObject), ((Integer) zzwr.zzqr().zzd(zzabp.zzcta)).intValue(), TimeUnit.SECONDS, this.zzfri), (Object) null);
        }
        final zzdzw<zzbeb> zzo = this.zzgia.zzo(zza.optString("base_url"), zza.optString(TJAdUnitConstants.String.HTML));
        return zzdzk.zzb(zzo, new zzdyu(zzo) { // from class: com.google.android.gms.internal.ads.zzcey
            private final zzdzw zzgig;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgig = zzo;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                zzdzw zzdzwVar = this.zzgig;
                zzbeb zzbebVar = (zzbeb) obj;
                if (zzbebVar == null || zzbebVar.zzabc() == null) {
                    throw new zzcva(zzdom.INTERNAL_ERROR, "Retrieve video view in instream ad response failed.");
                }
                return zzdzwVar;
            }
        }, zzazp.zzeih);
    }

    private final zzdzw<zzaed> zza(@Nullable JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzdzk.zzag(null);
        }
        final String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzdzk.zzag(null);
        }
        final double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        final int optInt = jSONObject.optInt("width", -1);
        final int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzdzk.zzag(new zzaed(null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zza(jSONObject.optBoolean("require"), zzdzk.zzb(this.zzghy.zza(optString, optDouble, optBoolean), new zzdvz(optString, optDouble, optInt, optInt2) { // from class: com.google.android.gms.internal.ads.zzcet
            private final String zzdlh;
            private final int zzeff;
            private final int zzefg;
            private final double zzgid;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdlh = optString;
                this.zzgid = optDouble;
                this.zzeff = optInt;
                this.zzefg = optInt2;
            }

            @Override // com.google.android.gms.internal.ads.zzdvz
            public final Object apply(Object obj) {
                String str = this.zzdlh;
                return new zzaed(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzgid, this.zzeff, this.zzefg);
            }
        }, this.executor), (Object) null);
    }

    private static <T> zzdzw<T> zza(zzdzw<T> zzdzwVar, T t) {
        return zzdzk.zzb(zzdzwVar, Exception.class, new zzdyu(null) { // from class: com.google.android.gms.internal.ads.zzcex
            private final Object zzgif = null;

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                Object obj2 = this.zzgif;
                com.google.android.gms.ads.internal.util.zzd.zza("Error during loading assets.", (Exception) obj);
                return zzdzk.zzag(obj2);
            }
        }, zzazp.zzeih);
    }

    private static <T> zzdzw<T> zza(boolean z, final zzdzw<T> zzdzwVar, T t) {
        if (z) {
            return zzdzk.zzb(zzdzwVar, new zzdyu(zzdzwVar) { // from class: com.google.android.gms.internal.ads.zzcfa
                private final zzdzw zzgig;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgig = zzdzwVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdyu
                public final zzdzw zzf(Object obj) {
                    return obj != null ? this.zzgig : zzdzk.immediateFailedFuture(new zzcva(zzdom.INTERNAL_ERROR, "Retrieve required value in native ad response failed."));
                }
            }, zzazp.zzeih);
        }
        return zza(zzdzwVar, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(String str, Object obj) throws Exception {
        com.google.android.gms.ads.internal.zzr.zzks();
        zzbeb zza = zzbej.zza(this.context, zzbft.zzael(), "native-omid", false, false, this.zzesm, null, this.zzbpn, null, null, this.zzghz, this.zzeqv, null, null);
        final zzazx zzk = zzazx.zzk(zza);
        zza.zzacx().zza(new zzbfq(zzk) { // from class: com.google.android.gms.internal.ads.zzcez
            private final zzazx zzesg;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzesg = zzk;
            }

            @Override // com.google.android.gms.internal.ads.zzbfq
            public final void zzal(boolean z) {
                this.zzesg.zzaac();
            }
        });
        zza.loadData(str, "text/html", "UTF-8");
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzady zza(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzf = zzf(jSONObject, "bg_color");
        Integer zzf2 = zzf(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzady(optString, list, zzf, zzf2, optInt > 0 ? Integer.valueOf(optInt) : null, jSONObject.optInt("presentation_ms", Constants.DEFAULT_STARTUP_THRESHOLD_MS_WARM) + optInt2, this.zzdoe.zzbnv, optBoolean);
    }
}
