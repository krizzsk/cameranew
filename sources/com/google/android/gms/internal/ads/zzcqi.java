package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.internal.ads.zzug;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcqi {
    private static final SparseArray<zzug.zzo.zzc> zzgri;
    private final Context context;
    private final zzbqu zzfxf;
    private final zzcqb zzgoh;
    private final TelephonyManager zzgrf;
    private final zzcpv zzgrg;
    private zzuq zzgrh;

    static {
        SparseArray<zzug.zzo.zzc> sparseArray = new SparseArray<>();
        zzgri = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzug.zzo.zzc.CONNECTED);
        int ordinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzug.zzo.zzc zzcVar = zzug.zzo.zzc.CONNECTING;
        sparseArray.put(ordinal, zzcVar);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzcVar);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzcVar);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzug.zzo.zzc.DISCONNECTING);
        int ordinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzug.zzo.zzc zzcVar2 = zzug.zzo.zzc.DISCONNECTED;
        sparseArray.put(ordinal2, zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzug.zzo.zzc.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzcVar);
        }
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzcVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcqi(Context context, zzbqu zzbquVar, zzcqb zzcqbVar, zzcpv zzcpvVar) {
        this.context = context;
        this.zzfxf = zzbquVar;
        this.zzgoh = zzcqbVar;
        this.zzgrg = zzcpvVar;
        this.zzgrf = (TelephonyManager) context.getSystemService("phone");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] zza(boolean z, ArrayList<zzug.zzc.zza> arrayList, zzug.zzm zzmVar, zzug.zzo.zzc zzcVar) {
        return ((zzug.zzo.zza) ((zzelb) zzug.zzo.zza.zzpg().zzf(arrayList).zzh(zzbk(com.google.android.gms.ads.internal.zzr.zzkt().zzb(this.context.getContentResolver()) != 0)).zzi(com.google.android.gms.ads.internal.zzr.zzkt().zza(this.context, this.zzgrf)).zzev(this.zzgoh.zzow()).zzew(this.zzgoh.zzox()).zzcl(this.zzgoh.getResponseCode()).zzb(zzcVar).zzb(zzmVar).zzj(this.zzgrh).zzf(zzbk(z)).zzeu(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis()).zzg(zzbk(com.google.android.gms.ads.internal.zzr.zzkt().zza(this.context.getContentResolver()) != 0)).zzbiw())).toByteArray();
    }

    private static zzuq zzbk(boolean z) {
        return z ? zzuq.ENUM_TRUE : zzuq.ENUM_FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzug.zzm zzj(Bundle bundle) {
        zzug.zzm.zza zzaVar;
        zzug.zzm.zzb zzop = zzug.zzm.zzop();
        int i2 = bundle.getInt("cnt", -2);
        int i3 = bundle.getInt("gnt", 0);
        if (i2 == -1) {
            this.zzgrh = zzuq.ENUM_TRUE;
        } else {
            this.zzgrh = zzuq.ENUM_FALSE;
            if (i2 == 0) {
                zzop.zzb(zzug.zzm.zzc.CELL);
            } else if (i2 != 1) {
                zzop.zzb(zzug.zzm.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzop.zzb(zzug.zzm.zzc.WIFI);
            }
            switch (i3) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzaVar = zzug.zzm.zza.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzaVar = zzug.zzm.zza.THREE_G;
                    break;
                case 13:
                    zzaVar = zzug.zzm.zza.LTE;
                    break;
                default:
                    zzaVar = zzug.zzm.zza.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzop.zzb(zzaVar);
        }
        return (zzug.zzm) ((zzelb) zzop.zzbiw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzug.zzo.zzc zzk(Bundle bundle) {
        return zzgri.get(zzdnz.zza(zzdnz.zza(bundle, TapjoyConstants.TJC_NOTIFICATION_DEVICE_PREFIX), "network").getInt("active_network_state", -1), zzug.zzo.zzc.UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzug.zzc.zza> zzl(android.os.Bundle r4) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r4 = r4.get(r0)
            boolean r0 = r4 instanceof java.util.List
            if (r0 == 0) goto Ld
            java.util.List r4 = (java.util.List) r4
            goto L17
        Ld:
            boolean r0 = r4 instanceof java.lang.String[]
            if (r0 == 0) goto L3d
            java.lang.String[] r4 = (java.lang.String[]) r4
            java.util.List r4 = java.util.Arrays.asList(r4)
        L17:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r4.size()
            r0.<init>(r1)
            java.util.Iterator r4 = r4.iterator()
        L24:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L38
            java.lang.Object r1 = r4.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L24
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L24
        L38:
            java.util.List r4 = java.util.Collections.unmodifiableList(r0)
            goto L41
        L3d:
            java.util.List r4 = java.util.Collections.emptyList()
        L41:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r4 = r4.iterator()
        L4a:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto La2
            java.lang.Object r1 = r4.next()
            java.lang.String r1 = (java.lang.String) r1
            r1.hashCode()
            r2 = -1
            int r3 = r1.hashCode()
            switch(r3) {
                case -1396342996: goto L83;
                case -1052618729: goto L78;
                case -239580146: goto L6d;
                case 604727084: goto L62;
                default: goto L61;
            }
        L61:
            goto L8d
        L62:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L6b
            goto L8d
        L6b:
            r2 = 3
            goto L8d
        L6d:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L76
            goto L8d
        L76:
            r2 = 2
            goto L8d
        L78:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L81
            goto L8d
        L81:
            r2 = 1
            goto L8d
        L83:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L8c
            goto L8d
        L8c:
            r2 = 0
        L8d:
            switch(r2) {
                case 0: goto L9c;
                case 1: goto L99;
                case 2: goto L96;
                case 3: goto L93;
                default: goto L90;
            }
        L90:
            com.google.android.gms.internal.ads.zzug$zzc$zza r1 = com.google.android.gms.internal.ads.zzug.zzc.zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto L9e
        L93:
            com.google.android.gms.internal.ads.zzug$zzc$zza r1 = com.google.android.gms.internal.ads.zzug.zzc.zza.INTERSTITIAL
            goto L9e
        L96:
            com.google.android.gms.internal.ads.zzug$zzc$zza r1 = com.google.android.gms.internal.ads.zzug.zzc.zza.REWARD_BASED_VIDEO_AD
            goto L9e
        L99:
            com.google.android.gms.internal.ads.zzug$zzc$zza r1 = com.google.android.gms.internal.ads.zzug.zzc.zza.NATIVE_APP_INSTALL
            goto L9e
        L9c:
            com.google.android.gms.internal.ads.zzug$zzc$zza r1 = com.google.android.gms.internal.ads.zzug.zzc.zza.BANNER
        L9e:
            r0.add(r1)
            goto L4a
        La2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqi.zzl(android.os.Bundle):java.util.ArrayList");
    }

    public final void zzbj(boolean z) {
        zzdzk.zza(this.zzfxf.zzali(), new zzcqh(this, z), zzazp.zzeih);
    }
}
