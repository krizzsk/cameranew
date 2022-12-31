package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.o;
import com.google.android.gms.common.wrappers.b;
import com.google.android.gms.internal.ads.zzepa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.advconfigdata.Utils.AdvPrefUtil;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzawm implements zzawz {
    private static List<Future<Void>> zzdzv = Collections.synchronizedList(new ArrayList());
    private final Context context;
    private final zzawu zzdwr;
    @GuardedBy("lock")
    private final zzepa.zzb.C0152zzb zzdzw;
    @GuardedBy("lock")
    private final LinkedHashMap<String, zzepa.zzb.zzh.C0158zzb> zzdzx;
    private final zzaxb zzeaa;
    @VisibleForTesting
    private boolean zzeab;
    @GuardedBy("lock")
    private final List<String> zzdzy = new ArrayList();
    @GuardedBy("lock")
    private final List<String> zzdzz = new ArrayList();
    private final Object lock = new Object();
    private HashSet<String> zzeac = new HashSet<>();
    private boolean zzead = false;
    private boolean zzeae = false;
    private boolean zzeaf = false;

    public zzawm(Context context, zzazn zzaznVar, zzawu zzawuVar, String str, zzaxb zzaxbVar) {
        q.k(zzawuVar, "SafeBrowsing config is not present.");
        this.context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdzx = new LinkedHashMap<>();
        this.zzeaa = zzaxbVar;
        this.zzdwr = zzawuVar;
        for (String str2 : zzawuVar.zzeaq) {
            this.zzeac.add(str2.toLowerCase(Locale.ENGLISH));
        }
        this.zzeac.remove(AdvPrefUtil.COOKIE.toLowerCase(Locale.ENGLISH));
        zzepa.zzb.C0152zzb zzblp = zzepa.zzb.zzblp();
        zzblp.zzb(zzepa.zzb.zzg.OCTAGON_AD);
        zzblp.zzie(str);
        zzblp.zzif(str);
        zzepa.zzb.zza.C0151zza zzblr = zzepa.zzb.zza.zzblr();
        String str3 = this.zzdwr.zzeam;
        if (str3 != null) {
            zzblr.zzih(str3);
        }
        zzblp.zzb((zzepa.zzb.zza) ((zzelb) zzblr.zzbiw()));
        zzepa.zzb.zzi.zza zzbv = zzepa.zzb.zzi.zzbmg().zzbv(b.a(this.context).f());
        String str4 = zzaznVar.zzbrp;
        if (str4 != null) {
            zzbv.zzim(str4);
        }
        long a = GoogleApiAvailabilityLight.getInstance().a(this.context);
        if (a > 0) {
            zzbv.zzfs(a);
        }
        zzblp.zzb((zzepa.zzb.zzi) ((zzelb) zzbv.zzbiw()));
        this.zzdzw = zzblp;
    }

    @Nullable
    private final zzepa.zzb.zzh.C0158zzb zzdw(String str) {
        zzepa.zzb.zzh.C0158zzb c0158zzb;
        synchronized (this.lock) {
            c0158zzb = this.zzdzx.get(str);
        }
        return c0158zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Void zzdx(String str) {
        return null;
    }

    @VisibleForTesting
    private final zzdzw<Void> zzwz() {
        zzdzw<Void> zzb;
        boolean z = this.zzeab;
        if (!((z && this.zzdwr.zzeas) || (this.zzeaf && this.zzdwr.zzear) || (!z && this.zzdwr.zzeap))) {
            return zzdzk.zzag(null);
        }
        synchronized (this.lock) {
            for (zzepa.zzb.zzh.C0158zzb c0158zzb : this.zzdzx.values()) {
                this.zzdzw.zzb((zzepa.zzb.zzh) ((zzelb) c0158zzb.zzbiw()));
            }
            this.zzdzw.zzo(this.zzdzy);
            this.zzdzw.zzp(this.zzdzz);
            if (zzaww.isEnabled()) {
                String url = this.zzdzw.getUrl();
                String zzbln = this.zzdzw.zzbln();
                StringBuilder sb = new StringBuilder(String.valueOf(url).length() + 53 + String.valueOf(zzbln).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(url);
                sb.append("\n  clickUrl: ");
                sb.append(zzbln);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzepa.zzb.zzh zzhVar : this.zzdzw.zzblm()) {
                    sb2.append("    [");
                    sb2.append(zzhVar.zzbmd());
                    sb2.append("] ");
                    sb2.append(zzhVar.getUrl());
                }
                zzaww.zzdy(sb2.toString());
            }
            zzdzw<String> zza = new com.google.android.gms.ads.internal.util.zzay(this.context).zza(1, this.zzdwr.zzean, null, ((zzepa.zzb) ((zzelb) this.zzdzw.zzbiw())).toByteArray());
            if (zzaww.isEnabled()) {
                zza.addListener(zzawr.zzeak, zzazp.zzeic);
            }
            zzb = zzdzk.zzb(zza, zzawq.zzeaj, zzazp.zzeih);
        }
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzawz
    public final void zza(String str, Map<String, String> map, int i2) {
        synchronized (this.lock) {
            if (i2 == 3) {
                this.zzeaf = true;
            }
            if (this.zzdzx.containsKey(str)) {
                if (i2 == 3) {
                    this.zzdzx.get(str).zzb(zzepa.zzb.zzh.zza.zzib(i2));
                }
                return;
            }
            zzepa.zzb.zzh.C0158zzb zzbme = zzepa.zzb.zzh.zzbme();
            zzepa.zzb.zzh.zza zzib = zzepa.zzb.zzh.zza.zzib(i2);
            if (zzib != null) {
                zzbme.zzb(zzib);
            }
            zzbme.zzic(this.zzdzx.size());
            zzbme.zzik(str);
            zzepa.zzb.zzd.C0154zzb zzblw = zzepa.zzb.zzd.zzblw();
            if (this.zzeac.size() > 0 && map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey() != null ? entry.getKey() : "";
                    String value = entry.getValue() != null ? entry.getValue() : "";
                    if (this.zzeac.contains(key.toLowerCase(Locale.ENGLISH))) {
                        zzblw.zzb((zzepa.zzb.zzc) ((zzelb) zzepa.zzb.zzc.zzblu().zzap(zzejr.zzhy(key)).zzaq(zzejr.zzhy(value)).zzbiw()));
                    }
                }
            }
            zzbme.zzb((zzepa.zzb.zzd) ((zzelb) zzblw.zzbiw()));
            this.zzdzx.put(str, zzbme);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawz
    public final void zzdv(String str) {
        synchronized (this.lock) {
            if (str == null) {
                this.zzdzw.zzblt();
            } else {
                this.zzdzw.zzig(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zzi(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.lock) {
                            int length = optJSONArray.length();
                            zzepa.zzb.zzh.C0158zzb zzdw = zzdw(str);
                            if (zzdw == null) {
                                String valueOf = String.valueOf(str);
                                zzaww.zzdy(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                for (int i2 = 0; i2 < length; i2++) {
                                    zzdw.zzil(optJSONArray.getJSONObject(i2).getString("threat_type"));
                                }
                                this.zzeab = (length > 0) | this.zzeab;
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                if (zzado.zzdek.get().booleanValue()) {
                    zzazk.zzb("Failed to get SafeBrowsing metadata", e2);
                }
                return zzdzk.immediateFailedFuture(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzeab) {
            synchronized (this.lock) {
                this.zzdzw.zzb(zzepa.zzb.zzg.OCTAGON_AD_SB_MATCH);
            }
        }
        return zzwz();
    }

    @Override // com.google.android.gms.internal.ads.zzawz
    public final void zzl(View view) {
        if (this.zzdwr.zzeao && !this.zzeae) {
            com.google.android.gms.ads.internal.zzr.zzkr();
            final Bitmap zzn = com.google.android.gms.ads.internal.util.zzj.zzn(view);
            if (zzn == null) {
                zzaww.zzdy("Failed to capture the webview bitmap.");
                return;
            }
            this.zzeae = true;
            com.google.android.gms.ads.internal.util.zzj.zzc(new Runnable(this, zzn) { // from class: com.google.android.gms.internal.ads.zzawp
                private final zzawm zzeah;
                private final Bitmap zzeai;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeah = this;
                    this.zzeai = zzn;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeah.zza(this.zzeai);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzawz
    public final zzawu zzwv() {
        return this.zzdwr;
    }

    @Override // com.google.android.gms.internal.ads.zzawz
    public final boolean zzww() {
        return o.f() && this.zzdwr.zzeao && !this.zzeae;
    }

    @Override // com.google.android.gms.internal.ads.zzawz
    public final void zzwx() {
        this.zzead = true;
    }

    @Override // com.google.android.gms.internal.ads.zzawz
    public final void zzwy() {
        synchronized (this.lock) {
            zzdzw<Map<String, String>> zza = this.zzeaa.zza(this.context, this.zzdzx.keySet());
            zzdyu zzdyuVar = new zzdyu(this) { // from class: com.google.android.gms.internal.ads.zzawo
                private final zzawm zzeah;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeah = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdyu
                public final zzdzw zzf(Object obj) {
                    return this.zzeah.zzi((Map) obj);
                }
            };
            zzdzv zzdzvVar = zzazp.zzeih;
            zzdzw zzb = zzdzk.zzb(zza, zzdyuVar, zzdzvVar);
            zzdzw zza2 = zzdzk.zza(zzb, 10L, TimeUnit.SECONDS, zzazp.zzeif);
            zzdzk.zza(zzb, new zzawt(this, zza2), zzdzvVar);
            zzdzv.add(zza2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bitmap bitmap) {
        zzeka zzbgl = zzejr.zzbgl();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzbgl);
        synchronized (this.lock) {
            this.zzdzw.zzb((zzepa.zzb.zzf) ((zzelb) zzepa.zzb.zzf.zzbmb().zzas(zzbgl.zzbfz()).zzii("image/png").zzb(zzepa.zzb.zzf.zza.TYPE_CREATIVE).zzbiw()));
        }
    }
}
