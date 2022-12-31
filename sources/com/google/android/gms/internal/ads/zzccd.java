package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tapjoy.TapjoyConstants;
import java.util.Collections;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzccd {
    private Bundle extras;
    private zzaej zzdfv;
    private List<?> zzeuv;
    private double zzeuy;
    private float zzevk;
    @Nullable
    private b zzfvs;
    private int zzgee;
    private zzzc zzgef;
    private View zzgeg;
    private zzzu zzgeh;
    private zzbeb zzgei;
    @Nullable
    private zzbeb zzgej;
    private View zzgek;
    private b zzgel;
    private zzaer zzgem;
    private zzaer zzgen;
    private String zzgeo;
    @Nullable
    private String zzger;
    private SimpleArrayMap<String, zzaed> zzgep = new SimpleArrayMap<>();
    private SimpleArrayMap<String, String> zzgeq = new SimpleArrayMap<>();
    private List<zzzu> zzdgj = Collections.emptyList();

    private final synchronized void setMediaContentAspectRatio(float f2) {
        this.zzevk = f2;
    }

    private static <T> T zzau(@Nullable b bVar) {
        if (bVar == null) {
            return null;
        }
        return (T) d.y0(bVar);
    }

    private final synchronized String zzfz(String str) {
        return this.zzgeq.get(str);
    }

    public final synchronized void destroy() {
        zzbeb zzbebVar = this.zzgei;
        if (zzbebVar != null) {
            zzbebVar.destroy();
            this.zzgei = null;
        }
        zzbeb zzbebVar2 = this.zzgej;
        if (zzbebVar2 != null) {
            zzbebVar2.destroy();
            this.zzgej = null;
        }
        this.zzfvs = null;
        this.zzgep.clear();
        this.zzgeq.clear();
        this.zzgef = null;
        this.zzdfv = null;
        this.zzgeg = null;
        this.zzeuv = null;
        this.extras = null;
        this.zzgek = null;
        this.zzgel = null;
        this.zzgem = null;
        this.zzgen = null;
        this.zzgeo = null;
    }

    public final synchronized String getAdvertiser() {
        return zzfz("advertiser");
    }

    public final synchronized String getBody() {
        return zzfz("body");
    }

    public final synchronized String getCallToAction() {
        return zzfz("call_to_action");
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzgeo;
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getHeadline() {
        return zzfz("headline");
    }

    public final synchronized List<?> getImages() {
        return this.zzeuv;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.zzevk;
    }

    public final synchronized List<zzzu> getMuteThisAdReasons() {
        return this.zzdgj;
    }

    public final synchronized String getPrice() {
        return zzfz(FirebaseAnalytics.Param.PRICE);
    }

    public final synchronized double getStarRating() {
        return this.zzeuy;
    }

    public final synchronized String getStore() {
        return zzfz(TapjoyConstants.TJC_STORE);
    }

    public final synchronized zzzc getVideoController() {
        return this.zzgef;
    }

    public final synchronized void setImages(List<zzaed> list) {
        this.zzeuv = list;
    }

    public final synchronized void setStarRating(double d2) {
        this.zzeuy = d2;
    }

    public final synchronized void zza(zzaej zzaejVar) {
        this.zzdfv = zzaejVar;
    }

    public final synchronized void zzac(View view) {
        this.zzgek = view;
    }

    public final synchronized int zzanu() {
        return this.zzgee;
    }

    public final synchronized View zzanv() {
        return this.zzgeg;
    }

    @Nullable
    public final zzaer zzanw() {
        List<?> list = this.zzeuv;
        if (list != null && list.size() != 0) {
            Object obj = this.zzeuv.get(0);
            if (obj instanceof IBinder) {
                return zzaeq.zzo((IBinder) obj);
            }
        }
        return null;
    }

    @Nullable
    public final synchronized zzzu zzanx() {
        return this.zzgeh;
    }

    public final synchronized View zzany() {
        return this.zzgek;
    }

    public final synchronized zzbeb zzanz() {
        return this.zzgei;
    }

    @Nullable
    public final synchronized zzbeb zzaoa() {
        return this.zzgej;
    }

    @Nullable
    public final synchronized b zzaob() {
        return this.zzfvs;
    }

    public final synchronized SimpleArrayMap<String, zzaed> zzaoc() {
        return this.zzgep;
    }

    @Nullable
    public final synchronized String zzaod() {
        return this.zzger;
    }

    public final synchronized SimpleArrayMap<String, String> zzaoe() {
        return this.zzgeq;
    }

    public final synchronized void zzat(b bVar) {
        this.zzfvs = bVar;
    }

    public final synchronized void zzb(zzzc zzzcVar) {
        this.zzgef = zzzcVar;
    }

    public final synchronized void zzdz(int i2) {
        this.zzgee = i2;
    }

    public final synchronized void zzf(zzbeb zzbebVar) {
        this.zzgei = zzbebVar;
    }

    public final synchronized void zzfx(String str) {
        this.zzgeo = str;
    }

    public final synchronized void zzfy(@Nullable String str) {
        this.zzger = str;
    }

    public final synchronized void zzg(zzbeb zzbebVar) {
        this.zzgej = zzbebVar;
    }

    public final synchronized void zzh(List<zzzu> list) {
        this.zzdgj = list;
    }

    public final synchronized void zzn(String str, String str2) {
        if (str2 == null) {
            this.zzgeq.remove(str);
        } else {
            this.zzgeq.put(str, str2);
        }
    }

    public final synchronized zzaer zztn() {
        return this.zzgem;
    }

    public final synchronized zzaej zzto() {
        return this.zzdfv;
    }

    public final synchronized b zztp() {
        return this.zzgel;
    }

    public final synchronized zzaer zztq() {
        return this.zzgen;
    }

    public final synchronized void zza(@Nullable zzzu zzzuVar) {
        this.zzgeh = zzzuVar;
    }

    public final synchronized void zzb(zzaer zzaerVar) {
        this.zzgen = zzaerVar;
    }

    public static zzccd zzb(zzanx zzanxVar) {
        try {
            return zza(zza(zzanxVar.getVideoController(), zzanxVar), zzanxVar.zzto(), (View) zzau(zzanxVar.zzvg()), zzanxVar.getHeadline(), zzanxVar.getImages(), zzanxVar.getBody(), zzanxVar.getExtras(), zzanxVar.getCallToAction(), (View) zzau(zzanxVar.zzvh()), zzanxVar.zztp(), zzanxVar.getStore(), zzanxVar.getPrice(), zzanxVar.getStarRating(), zzanxVar.zztn(), zzanxVar.getAdvertiser(), zzanxVar.getMediaContentAspectRatio());
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to get native ad assets from unified ad mapper", e2);
            return null;
        }
    }

    public final synchronized void zza(zzaer zzaerVar) {
        this.zzgem = zzaerVar;
    }

    public final synchronized void zza(String str, zzaed zzaedVar) {
        if (zzaedVar == null) {
            this.zzgep.remove(str);
        } else {
            this.zzgep.put(str, zzaedVar);
        }
    }

    public static zzccd zza(zzans zzansVar) {
        try {
            zzcce zza = zza(zzansVar.getVideoController(), (zzanx) null);
            zzaej zzto = zzansVar.zzto();
            String headline = zzansVar.getHeadline();
            List<?> images = zzansVar.getImages();
            String body = zzansVar.getBody();
            Bundle extras = zzansVar.getExtras();
            String callToAction = zzansVar.getCallToAction();
            b zztp = zzansVar.zztp();
            String advertiser = zzansVar.getAdvertiser();
            zzaer zztq = zzansVar.zztq();
            zzccd zzccdVar = new zzccd();
            zzccdVar.zzgee = 1;
            zzccdVar.zzgef = zza;
            zzccdVar.zzdfv = zzto;
            zzccdVar.zzgeg = (View) zzau(zzansVar.zzvg());
            zzccdVar.zzn("headline", headline);
            zzccdVar.zzeuv = images;
            zzccdVar.zzn("body", body);
            zzccdVar.extras = extras;
            zzccdVar.zzn("call_to_action", callToAction);
            zzccdVar.zzgek = (View) zzau(zzansVar.zzvh());
            zzccdVar.zzgel = zztp;
            zzccdVar.zzn("advertiser", advertiser);
            zzccdVar.zzgen = zztq;
            return zzccdVar;
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to get native ad from content ad mapper", e2);
            return null;
        }
    }

    public static zzccd zzb(zzanr zzanrVar) {
        try {
            return zza(zza(zzanrVar.getVideoController(), (zzanx) null), zzanrVar.zzto(), (View) zzau(zzanrVar.zzvg()), zzanrVar.getHeadline(), zzanrVar.getImages(), zzanrVar.getBody(), zzanrVar.getExtras(), zzanrVar.getCallToAction(), (View) zzau(zzanrVar.zzvh()), zzanrVar.zztp(), zzanrVar.getStore(), zzanrVar.getPrice(), zzanrVar.getStarRating(), zzanrVar.zztn(), null, 0.0f);
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to get native ad assets from app install ad mapper", e2);
            return null;
        }
    }

    public static zzccd zza(zzanr zzanrVar) {
        try {
            zzcce zza = zza(zzanrVar.getVideoController(), (zzanx) null);
            zzaej zzto = zzanrVar.zzto();
            String headline = zzanrVar.getHeadline();
            List<?> images = zzanrVar.getImages();
            String body = zzanrVar.getBody();
            Bundle extras = zzanrVar.getExtras();
            String callToAction = zzanrVar.getCallToAction();
            b zztp = zzanrVar.zztp();
            String store = zzanrVar.getStore();
            String price = zzanrVar.getPrice();
            double starRating = zzanrVar.getStarRating();
            zzaer zztn = zzanrVar.zztn();
            zzccd zzccdVar = new zzccd();
            zzccdVar.zzgee = 2;
            zzccdVar.zzgef = zza;
            zzccdVar.zzdfv = zzto;
            zzccdVar.zzgeg = (View) zzau(zzanrVar.zzvg());
            zzccdVar.zzn("headline", headline);
            zzccdVar.zzeuv = images;
            zzccdVar.zzn("body", body);
            zzccdVar.extras = extras;
            zzccdVar.zzn("call_to_action", callToAction);
            zzccdVar.zzgek = (View) zzau(zzanrVar.zzvh());
            zzccdVar.zzgel = zztp;
            zzccdVar.zzn(TapjoyConstants.TJC_STORE, store);
            zzccdVar.zzn(FirebaseAnalytics.Param.PRICE, price);
            zzccdVar.zzeuy = starRating;
            zzccdVar.zzgem = zztn;
            return zzccdVar;
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to get native ad from app install ad mapper", e2);
            return null;
        }
    }

    public static zzccd zzb(zzans zzansVar) {
        try {
            return zza(zza(zzansVar.getVideoController(), (zzanx) null), zzansVar.zzto(), (View) zzau(zzansVar.zzvg()), zzansVar.getHeadline(), zzansVar.getImages(), zzansVar.getBody(), zzansVar.getExtras(), zzansVar.getCallToAction(), (View) zzau(zzansVar.zzvh()), zzansVar.zztp(), null, null, -1.0d, zzansVar.zztq(), zzansVar.getAdvertiser(), 0.0f);
        } catch (RemoteException e2) {
            zzazk.zzd("Failed to get native ad assets from content ad mapper", e2);
            return null;
        }
    }

    private static zzccd zza(zzzc zzzcVar, zzaej zzaejVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, b bVar, String str4, String str5, double d2, zzaer zzaerVar, String str6, float f2) {
        zzccd zzccdVar = new zzccd();
        zzccdVar.zzgee = 6;
        zzccdVar.zzgef = zzzcVar;
        zzccdVar.zzdfv = zzaejVar;
        zzccdVar.zzgeg = view;
        zzccdVar.zzn("headline", str);
        zzccdVar.zzeuv = list;
        zzccdVar.zzn("body", str2);
        zzccdVar.extras = bundle;
        zzccdVar.zzn("call_to_action", str3);
        zzccdVar.zzgek = view2;
        zzccdVar.zzgel = bVar;
        zzccdVar.zzn(TapjoyConstants.TJC_STORE, str4);
        zzccdVar.zzn(FirebaseAnalytics.Param.PRICE, str5);
        zzccdVar.zzeuy = d2;
        zzccdVar.zzgem = zzaerVar;
        zzccdVar.zzn("advertiser", str6);
        zzccdVar.setMediaContentAspectRatio(f2);
        return zzccdVar;
    }

    private static zzcce zza(zzzc zzzcVar, @Nullable zzanx zzanxVar) {
        if (zzzcVar == null) {
            return null;
        }
        return new zzcce(zzzcVar, zzanxVar);
    }
}
