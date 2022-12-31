package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbck implements zzhg, zzil, zzmz, zzpd<zzon>, zzqk {
    private static int zzeom;
    private static int zzeon;
    private int bytesTransferred;
    private final Context context;
    private int zzbls;
    private final String zzbvs;
    private final int zzbvt;
    private final zzbbl zzenf;
    private final zzbch zzeoo;
    private final zzhy zzeop;
    private final zzhy zzeoq;
    private final zzob zzeor;
    private zzhh zzeos;
    private ByteBuffer zzeot;
    private boolean zzeou;
    private final WeakReference<zzbbo> zzeov;
    private zzbcu zzeow;
    private long zzeox;
    private final ArrayList<zzot> zzeoy;
    private volatile zzbcg zzeoz;
    private Set<WeakReference<zzbce>> zzepa = new HashSet();

    public zzbck(Context context, zzbbl zzbblVar, zzbbo zzbboVar) {
        this.context = context;
        this.zzenf = zzbblVar;
        this.zzeov = new WeakReference<>(zzbboVar);
        zzbch zzbchVar = new zzbch();
        this.zzeoo = zzbchVar;
        zzlx zzlxVar = zzlx.zzbcu;
        zzdvl zzdvlVar = com.google.android.gms.ads.internal.util.zzj.zzeen;
        zzqe zzqeVar = new zzqe(context, zzlxVar, 0L, zzdvlVar, this, -1);
        this.zzeop = zzqeVar;
        zzjc zzjcVar = new zzjc(zzlxVar, zzdvlVar, this);
        this.zzeoq = zzjcVar;
        zzoa zzoaVar = new zzoa();
        this.zzeor = zzoaVar;
        if (com.google.android.gms.ads.internal.util.zzd.zzyg()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
        }
        zzeom++;
        zzhh zza = zzhl.zza(new zzhy[]{zzjcVar, zzqeVar}, zzoaVar, zzbchVar);
        this.zzeos = zza;
        zza.zza(this);
        this.bytesTransferred = 0;
        this.zzeox = 0L;
        this.zzbls = 0;
        this.zzeoy = new ArrayList<>();
        this.zzeoz = null;
        this.zzbvs = (zzbboVar == null || zzbboVar.zzabg() == null) ? "" : zzbboVar.zzabg();
        this.zzbvt = zzbboVar != null ? zzbboVar.zzabh() : 0;
    }

    private final boolean zzace() {
        return this.zzeoz != null && this.zzeoz.zzace();
    }

    public static int zzacj() {
        return zzeom;
    }

    public static int zzack() {
        return zzeon;
    }

    private static long zzk(Map<String, List<String>> map) {
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        if (entry.getKey() != null && zzdvr.zza("content-length", entry.getKey()) && entry.getValue() != null && entry.getValue().get(0) != null) {
                            return Long.parseLong(entry.getValue().get(0));
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return 0L;
        }
        return 0L;
    }

    public final void finalize() throws Throwable {
        zzeom--;
        if (com.google.android.gms.ads.internal.util.zzd.zzyg()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
        }
    }

    public final long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public final long getTotalBytes() {
        if (!zzace()) {
            while (!this.zzeoy.isEmpty()) {
                this.zzeox += zzk(this.zzeoy.remove(0).getResponseHeaders());
            }
            return this.zzeox;
        }
        return this.zzeoz.getContentLength();
    }

    public final void release() {
        zzhh zzhhVar = this.zzeos;
        if (zzhhVar != null) {
            zzhhVar.zzb(this);
            this.zzeos.release();
            this.zzeos = null;
            zzeon--;
        }
    }

    public final void zza(zzbcu zzbcuVar) {
        this.zzeow = zzbcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(zzhz zzhzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(zzid zzidVar, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(zznu zznuVar, zzoi zzoiVar) {
    }

    public final long zzaah() {
        if (zzace()) {
            return 0L;
        }
        return this.bytesTransferred;
    }

    public final int zzaai() {
        return this.zzbls;
    }

    public final zzhh zzaci() {
        return this.zzeos;
    }

    public final zzbch zzacl() {
        return this.zzeoo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzax(boolean z) {
        if (this.zzeos == null) {
            return;
        }
        for (int i2 = 0; i2 < this.zzeos.zzem(); i2++) {
            this.zzeor.zzf(i2, !z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzb(int i2, long j2, long j3) {
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzb(Surface surface) {
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzb(IOException iOException) {
        zzbcu zzbcuVar = this.zzeow;
        if (zzbcuVar != null) {
            zzbcuVar.zza("onLoadError", iOException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzb(String str, long j2, long j3) {
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzc(zzht zzhtVar) {
        zzbbo zzbboVar = this.zzeov.get();
        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcrm)).booleanValue() || zzbboVar == null || zzhtVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("audioMime", zzhtVar.zzahd);
        hashMap.put("audioSampleMime", zzhtVar.zzahe);
        hashMap.put("audioCodec", zzhtVar.zzahb);
        zzbboVar.zza("onMetadataEvent", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzc(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzd(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzd(String str, long j2, long j3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(boolean z, long j2) {
        zzbcu zzbcuVar = this.zzeow;
        if (zzbcuVar != null) {
            zzbcuVar.zzb(z, j2);
        }
    }

    public final void zzdo(int i2) {
        for (WeakReference<zzbce> weakReference : this.zzepa) {
            zzbce zzbceVar = weakReference.get();
            if (zzbceVar != null) {
                zzbceVar.setReceiveBufferSize(i2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zze(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* bridge */ /* synthetic */ void zze(zzon zzonVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zzek() {
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzf(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zzf(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzon zzfe(String str) {
        zzbbl zzbblVar = this.zzenf;
        return new zzou(str, null, zzbblVar.zzelo ? null : this, zzbblVar.zzeli, zzbblVar.zzelk, true, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzon zzff(String str) {
        zzbbl zzbblVar = this.zzenf;
        zzbce zzbceVar = new zzbce(str, zzbblVar.zzelo ? null : this, zzbblVar.zzeli, zzbblVar.zzelk, zzbblVar.zzeln);
        this.zzepa.add(new WeakReference<>(zzbceVar));
        return zzbceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzg(int i2, long j2) {
        this.zzbls += i2;
    }

    public final long zznb() {
        if (zzace() && this.zzeoz.zznc()) {
            return Math.min(this.bytesTransferred, this.zzeoz.zznb());
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzx(int i2) {
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzne zznfVar;
        if (this.zzeos == null) {
            return;
        }
        this.zzeot = byteBuffer;
        this.zzeou = z;
        if (uriArr.length == 1) {
            zznfVar = zzb(uriArr[0], str);
        } else {
            zzne[] zzneVarArr = new zzne[uriArr.length];
            for (int i2 = 0; i2 < uriArr.length; i2++) {
                zzneVarArr[i2] = zzb(uriArr[i2], str);
            }
            zznfVar = new zznf(zzneVarArr);
        }
        this.zzeos.zza(zznfVar);
        zzeon++;
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzb(int i2, int i3, int i4, float f2) {
        zzbcu zzbcuVar = this.zzeow;
        if (zzbcuVar != null) {
            zzbcuVar.zzn(i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(float f2, boolean z) {
        if (this.zzeos == null) {
            return;
        }
        zzhi zzhiVar = new zzhi(this.zzeoq, 2, Float.valueOf(f2));
        if (z) {
            this.zzeos.zzb(zzhiVar);
        } else {
            this.zzeos.zza(zzhiVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzk(zzht zzhtVar) {
        zzbbo zzbboVar = this.zzeov.get();
        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcrm)).booleanValue() || zzbboVar == null || zzhtVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("frameRate", String.valueOf(zzhtVar.zzahi));
        hashMap.put("bitRate", String.valueOf(zzhtVar.zzaha));
        int i2 = zzhtVar.width;
        int i3 = zzhtVar.height;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i2);
        sb.append("x");
        sb.append(i3);
        hashMap.put("resolution", sb.toString());
        hashMap.put("videoMime", zzhtVar.zzahd);
        hashMap.put("videoSampleMime", zzhtVar.zzahe);
        hashMap.put("videoCodec", zzhtVar.zzahb);
        zzbboVar.zza("onMetadataEvent", hashMap);
    }

    private final zzne zzb(Uri uri, final String str) {
        final zzoq zzoqVar;
        zzkb zzkbVar;
        if (this.zzeou && this.zzeot.limit() > 0) {
            final byte[] bArr = new byte[this.zzeot.limit()];
            this.zzeot.get(bArr);
            zzoqVar = new zzoq(bArr) { // from class: com.google.android.gms.internal.ads.zzbcm
                private final byte[] zzehv;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzehv = bArr;
                }

                @Override // com.google.android.gms.internal.ads.zzoq
                public final zzon zzip() {
                    return new zzoo(this.zzehv);
                }
            };
        } else {
            if (this.zzenf.zzeln > 0) {
                zzoqVar = new zzoq(this, str) { // from class: com.google.android.gms.internal.ads.zzbcl
                    private final String zzdjf;
                    private final zzbck zzepb;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzepb = this;
                        this.zzdjf = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzoq
                    public final zzon zzip() {
                        return this.zzepb.zzff(this.zzdjf);
                    }
                };
            } else {
                zzoqVar = new zzoq(this, str) { // from class: com.google.android.gms.internal.ads.zzbco
                    private final String zzdjf;
                    private final zzbck zzepb;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzepb = this;
                        this.zzdjf = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzoq
                    public final zzon zzip() {
                        return this.zzepb.zzfe(this.zzdjf);
                    }
                };
            }
            if (this.zzenf.zzelo) {
                zzoqVar = new zzoq(this, zzoqVar) { // from class: com.google.android.gms.internal.ads.zzbcn
                    private final zzbck zzepb;
                    private final zzoq zzepc;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzepb = this;
                        this.zzepc = zzoqVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzoq
                    public final zzon zzip() {
                        return this.zzepb.zza(this.zzepc);
                    }
                };
            }
            if (this.zzeot.limit() > 0) {
                final byte[] bArr2 = new byte[this.zzeot.limit()];
                this.zzeot.get(bArr2);
                zzoqVar = new zzoq(zzoqVar, bArr2) { // from class: com.google.android.gms.internal.ads.zzbcq
                    private final byte[] zzdxe;
                    private final zzoq zzepe;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzepe = zzoqVar;
                        this.zzdxe = bArr2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzoq
                    public final zzon zzip() {
                        zzoq zzoqVar2 = this.zzepe;
                        byte[] bArr3 = this.zzdxe;
                        return new zzbct(new zzoo(bArr3), bArr3.length, zzoqVar2.zzip());
                    }
                };
            }
        }
        zzoq zzoqVar2 = zzoqVar;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcmw)).booleanValue()) {
            zzkbVar = zzbcp.zzepd;
        } else {
            zzkbVar = zzbcs.zzepd;
        }
        zzkb zzkbVar2 = zzkbVar;
        zzbbl zzbblVar = this.zzenf;
        return new zzna(uri, zzoqVar2, zzkbVar2, zzbblVar.zzelp, com.google.android.gms.ads.internal.util.zzj.zzeen, this, null, zzbblVar.zzell);
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* synthetic */ void zzc(zzon zzonVar, int i2) {
        this.bytesTransferred += i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(boolean z, int i2) {
        zzbcu zzbcuVar = this.zzeow;
        if (zzbcuVar != null) {
            zzbcuVar.zzdq(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(zzhe zzheVar) {
        zzbcu zzbcuVar = this.zzeow;
        if (zzbcuVar != null) {
            zzbcuVar.zza("onPlayerError", zzheVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Surface surface, boolean z) {
        if (this.zzeos == null) {
            return;
        }
        zzhi zzhiVar = new zzhi(this.zzeop, 1, surface);
        if (z) {
            this.zzeos.zzb(zzhiVar);
        } else {
            this.zzeos.zza(zzhiVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* synthetic */ void zza(zzon zzonVar, zzos zzosVar) {
        zzon zzonVar2 = zzonVar;
        if (zzonVar2 instanceof zzot) {
            this.zzeoy.add((zzot) zzonVar2);
        } else if (zzonVar2 instanceof zzbcg) {
            this.zzeoz = (zzbcg) zzonVar2;
            final zzbbo zzbboVar = this.zzeov.get();
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcrm)).booleanValue() && zzbboVar != null && this.zzeoz.zzmz()) {
                final HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzeoz.zznc()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzeoz.zzacf()));
                com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(zzbboVar, hashMap) { // from class: com.google.android.gms.internal.ads.zzbcj
                    private final Map zzehx;
                    private final zzbbo zzeol;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzeol = zzbboVar;
                        this.zzehx = hashMap;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzeol.zza("onGcacheInfoEvent", this.zzehx);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzon zza(zzoq zzoqVar) {
        return new zzbcg(this.context, zzoqVar.zzip(), this.zzbvs, this.zzbvt, this, new zzbci(this) { // from class: com.google.android.gms.internal.ads.zzbcr
            private final zzbck zzepb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzepb = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbci
            public final void zzb(boolean z, long j2) {
                this.zzepb.zzd(z, j2);
            }
        });
    }
}
