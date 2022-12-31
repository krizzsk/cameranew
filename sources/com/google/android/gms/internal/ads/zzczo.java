package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.internal.ads.zzbqx;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzdab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzczo extends zzayb {
    private static final List<String> zzgzo = new ArrayList(Arrays.asList("/aclk", "/pcs/click"));
    private static final List<String> zzgzp = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    private static final List<String> zzgzq = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion"));
    private static final List<String> zzgzr = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    private Context context;
    private zzazn zzboz;
    private final ScheduledExecutorService zzfri;
    private zzei zzfrl;
    private Point zzgcr = new Point();
    private Point zzgcs = new Point();
    private final zzdzv zzghl;
    private zzdof<zzcgk> zzgup;
    private zzbgc zzgzs;
    @Nullable
    private zzasq zzgzt;

    public zzczo(zzbgc zzbgcVar, Context context, zzei zzeiVar, zzazn zzaznVar, zzdof<zzcgk> zzdofVar, zzdzv zzdzvVar, ScheduledExecutorService scheduledExecutorService) {
        this.zzgzs = zzbgcVar;
        this.context = context;
        this.zzfrl = zzeiVar;
        this.zzboz = zzaznVar;
        this.zzgup = zzdofVar;
        this.zzghl = zzdzvVar;
        this.zzfri = scheduledExecutorService;
    }

    private final boolean zzasu() {
        Map<String, WeakReference<View>> map;
        zzasq zzasqVar = this.zzgzt;
        return (zzasqVar == null || (map = zzasqVar.zzdto) == null || map.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Uri zzc(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zza(uri, "nas", str) : uri;
    }

    private final zzdzw<String> zzgq(final String str) {
        final zzcgk[] zzcgkVarArr = new zzcgk[1];
        zzdzw zzb = zzdzk.zzb(this.zzgup.zzavm(), new zzdyu(this, zzcgkVarArr, str) { // from class: com.google.android.gms.internal.ads.zzczv
            private final String zzdlo;
            private final zzczo zzgzl;
            private final zzcgk[] zzgzu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgzl = this;
                this.zzgzu = zzcgkVarArr;
                this.zzdlo = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdyu
            public final zzdzw zzf(Object obj) {
                return this.zzgzl.zza(this.zzgzu, this.zzdlo, (zzcgk) obj);
            }
        }, this.zzghl);
        zzb.addListener(new Runnable(this, zzcgkVarArr) { // from class: com.google.android.gms.internal.ads.zzczy
            private final zzczo zzgzl;
            private final zzcgk[] zzgzu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgzl = this;
                this.zzgzu = zzcgkVarArr;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgzl.zza(this.zzgzu);
            }
        }, this.zzghl);
        return zzdzf.zzg(zzb).zza(((Integer) zzwr.zzqr().zzd(zzabp.zzczd)).intValue(), TimeUnit.MILLISECONDS, this.zzfri).zza(zzczt.zzeaj, this.zzghl).zza(Exception.class, zzczw.zzeaj, this.zzghl);
    }

    @VisibleForTesting
    private static boolean zzk(@NonNull Uri uri) {
        return zza(uri, zzgzq, zzgzr);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final void zza(b bVar, zzaye zzayeVar, zzaxx zzaxxVar) {
        Context context = (Context) d.y0(bVar);
        this.context = context;
        String str = zzayeVar.zzbut;
        String str2 = zzayeVar.zzbrm;
        zzvs zzvsVar = zzayeVar.zzebq;
        zzvl zzvlVar = zzayeVar.zzebr;
        zzczl zzafr = this.zzgzs.zzafr();
        zzbqx.zza zzcf = new zzbqx.zza().zzcf(context);
        zzdnr zzdnrVar = new zzdnr();
        if (str == null) {
            str = "adUnitId";
        }
        zzdnr zzgs = zzdnrVar.zzgs(str);
        if (zzvlVar == null) {
            zzvlVar = new zzvo().zzqd();
        }
        zzdnr zzh = zzgs.zzh(zzvlVar);
        if (zzvsVar == null) {
            zzvsVar = new zzvs();
        }
        zzdzk.zza(zzafr.zzg(zzcf.zza(zzh.zzg(zzvsVar).zzavh()).zzalo()).zza(new zzdab(new zzdab.zza().zzgr(str2))).zzg(new zzbwg.zza().zzaml()).zzaim().zzail(), new zzczx(this, zzaxxVar), this.zzgzs.zzafa());
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final void zzan(b bVar) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzczc)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) d.y0(bVar);
            zzasq zzasqVar = this.zzgzt;
            this.zzgcr = com.google.android.gms.ads.internal.util.zzbn.zza(motionEvent, zzasqVar == null ? null : zzasqVar.zzaat);
            if (motionEvent.getAction() == 0) {
                this.zzgcs = this.zzgcr;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzgcr;
            obtain.setLocation(point.x, point.y);
            this.zzfrl.zza(obtain);
            obtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final b zzao(b bVar) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final b zzb(b bVar, b bVar2) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final void zzb(List<Uri> list, final b bVar, zzasj zzasjVar) {
        try {
            if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzczc)).booleanValue()) {
                zzasjVar.onError("The updating URL feature is not enabled.");
            } else if (list.size() != 1) {
                zzasjVar.onError("There should be only 1 click URL.");
            } else {
                final Uri uri = list.get(0);
                if (!zza(uri, zzgzo, zzgzp)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzazk.zzex(sb.toString());
                    zzasjVar.onSuccess(list);
                    return;
                }
                zzdzw zze = this.zzghl.zze(new Callable(this, uri, bVar) { // from class: com.google.android.gms.internal.ads.zzczp
                    private final Uri zzgtx;
                    private final zzczo zzgzl;
                    private final b zzgzn;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgzl = this;
                        this.zzgtx = uri;
                        this.zzgzn = bVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zzgzl.zzb(this.zzgtx, this.zzgzn);
                    }
                });
                if (zzasu()) {
                    zze = zzdzk.zzb(zze, new zzdyu(this) { // from class: com.google.android.gms.internal.ads.zzczs
                        private final zzczo zzgzl;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzgzl = this;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdyu
                        public final zzdzw zzf(Object obj) {
                            return this.zzgzl.zzl((Uri) obj);
                        }
                    }, this.zzghl);
                } else {
                    zzazk.zzew("Asset view map is empty.");
                }
                zzdzk.zza(zze, new zzczz(this, zzasjVar), this.zzgzs.zzafa());
            }
        } catch (RemoteException e2) {
            zzazk.zzc("", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zzl(final Uri uri) throws Exception {
        return zzdzk.zzb(zzgq("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzdvz(this, uri) { // from class: com.google.android.gms.internal.ads.zzczu
            private final Uri zzgtx;
            private final zzczo zzgzl;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgzl = this;
                this.zzgtx = uri;
            }

            @Override // com.google.android.gms.internal.ads.zzdvz
            public final Object apply(Object obj) {
                return zzczo.zzc(this.zzgtx, (String) obj);
            }
        }, this.zzghl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zzb(final ArrayList arrayList) throws Exception {
        return zzdzk.zzb(zzgq("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzdvz(this, arrayList) { // from class: com.google.android.gms.internal.ads.zzczr
            private final zzczo zzgzl;
            private final List zzgzm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgzl = this;
                this.zzgzm = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdvz
            public final Object apply(Object obj) {
                return zzczo.zza(this.zzgzm, (String) obj);
            }
        }, this.zzghl);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final void zza(zzasq zzasqVar) {
        this.zzgzt = zzasqVar;
        this.zzgup.ensureSize(1);
    }

    @Override // com.google.android.gms.internal.ads.zzaxy
    public final void zza(final List<Uri> list, final b bVar, zzasj zzasjVar) {
        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzczc)).booleanValue()) {
            try {
                zzasjVar.onError("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e2) {
                zzazk.zzc("", e2);
                return;
            }
        }
        zzdzw zze = this.zzghl.zze(new Callable(this, list, bVar) { // from class: com.google.android.gms.internal.ads.zzczn
            private final zzczo zzgzl;
            private final List zzgzm;
            private final b zzgzn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgzl = this;
                this.zzgzm = list;
                this.zzgzn = bVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgzl.zza(this.zzgzm, this.zzgzn);
            }
        });
        if (zzasu()) {
            zze = zzdzk.zzb(zze, new zzdyu(this) { // from class: com.google.android.gms.internal.ads.zzczq
                private final zzczo zzgzl;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgzl = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdyu
                public final zzdzw zzf(Object obj) {
                    return this.zzgzl.zzb((ArrayList) obj);
                }
            }, this.zzghl);
        } else {
            zzazk.zzew("Asset view map is empty.");
        }
        zzdzk.zza(zze, new zzdaa(this, zzasjVar), this.zzgzs.zzafa());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zza */
    public final Uri zzb(Uri uri, b bVar) throws Exception {
        try {
            uri = this.zzfrl.zza(uri, this.context, (View) d.y0(bVar), null);
        } catch (zzeh e2) {
            zzazk.zzd("", e2);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    private static boolean zza(@NonNull Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            for (String str : list) {
                if (path.contains(str)) {
                    for (String str2 : list2) {
                        if (host.endsWith(str2)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    private static Uri zza(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            return Uri.parse(uri2.substring(0, i2) + str + "=" + str2 + "&" + uri2.substring(i2));
        }
        return uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzcgk[] zzcgkVarArr) {
        if (zzcgkVarArr[0] != null) {
            this.zzgup.zzd(zzdzk.zzag(zzcgkVarArr[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdzw zza(zzcgk[] zzcgkVarArr, String str, zzcgk zzcgkVar) throws Exception {
        zzcgkVarArr[0] = zzcgkVar;
        Context context = this.context;
        zzasq zzasqVar = this.zzgzt;
        Map<String, WeakReference<View>> map = zzasqVar.zzdto;
        JSONObject zza = com.google.android.gms.ads.internal.util.zzbn.zza(context, map, map, zzasqVar.zzaat);
        JSONObject zza2 = com.google.android.gms.ads.internal.util.zzbn.zza(this.context, this.zzgzt.zzaat);
        JSONObject zzt = com.google.android.gms.ads.internal.util.zzbn.zzt(this.zzgzt.zzaat);
        JSONObject zzb = com.google.android.gms.ads.internal.util.zzbn.zzb(this.context, this.zzgzt.zzaat);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zza);
        jSONObject.put("ad_view_signal", zza2);
        jSONObject.put("scroll_view_signal", zzt);
        jSONObject.put("lock_screen_signal", zzb);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", com.google.android.gms.ads.internal.util.zzbn.zza((String) null, this.context, this.zzgcs, this.zzgcr));
        }
        return zzcgkVar.zzc(str, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ArrayList zza(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (zzk(uri) && !TextUtils.isEmpty(str)) {
                arrayList.add(zza(uri, "nas", str));
            } else {
                arrayList.add(uri);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zza(List list, b bVar) throws Exception {
        String zza = this.zzfrl.zzca() != null ? this.zzfrl.zzca().zza(this.context, (View) d.y0(bVar), (Activity) null) : "";
        if (!TextUtils.isEmpty(zza)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzk(uri)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                    sb.append("Not a Google URL: ");
                    sb.append(valueOf);
                    zzazk.zzex(sb.toString());
                    arrayList.add(uri);
                } else {
                    arrayList.add(zza(uri, "ms", zza));
                }
            }
            if (arrayList.isEmpty()) {
                throw new Exception("Empty impression URLs result.");
            }
            return arrayList;
        }
        throw new Exception("Failed to get view signals.");
    }
}
