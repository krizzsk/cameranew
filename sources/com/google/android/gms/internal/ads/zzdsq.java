package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdsq {
    private final Context context;
    private final Clock zzbqg;
    private final String zzbrp;
    private final String zzcjn;
    private final String zzdug;
    private final zzei zzfrl;
    private final zzdnk zzfyy;
    private final zzcuw zzgat;

    public zzdsq(zzcuw zzcuwVar, zzazn zzaznVar, String str, String str2, Context context, @Nullable zzdnk zzdnkVar, Clock clock, zzei zzeiVar) {
        this.zzgat = zzcuwVar;
        this.zzbrp = zzaznVar.zzbrp;
        this.zzdug = str;
        this.zzcjn = str2;
        this.context = context;
        this.zzfyy = zzdnkVar;
        this.zzbqg = clock;
        this.zzfrl = zzeiVar;
    }

    private static String zzc(String str, String str2, @Nullable String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    @Nullable
    private static String zzhb(@Nullable String str) {
        return (TextUtils.isEmpty(str) || !zzaze.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    public final List<String> zza(zzdnl zzdnlVar, zzdmw zzdmwVar, List<String> list) {
        return zza(zzdnlVar, zzdmwVar, false, "", "", list);
    }

    public static List<String> zza(int i2, int i3, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            StringBuilder sb = new StringBuilder(23);
            sb.append(2);
            sb.append(".");
            sb.append(i3);
            arrayList.add(zzc(str, "@gw_mpe@", sb.toString()));
        }
        return arrayList;
    }

    public final List<String> zza(zzdnl zzdnlVar, @Nullable zzdmw zzdmwVar, boolean z, String str, @Nullable String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = z ? "1" : "0";
        for (String str4 : list) {
            String zzc = zzc(zzc(zzc(str4, "@gw_adlocid@", zzdnlVar.zzhkr.zzfwy.zzhkx), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzbrp);
            if (zzdmwVar != null) {
                zzc = zzaxu.zzc(zzc(zzc(zzc(zzc, "@gw_qdata@", zzdmwVar.zzdmv), "@gw_adnetid@", zzdmwVar.id), "@gw_allocid@", zzdmwVar.zzdlu), this.context, zzdmwVar.zzdwz);
            }
            String zzc2 = zzc(zzc(zzc(zzc, "@gw_adnetstatus@", this.zzgat.zzasc()), "@gw_seqnum@", this.zzdug), "@gw_sessid@", this.zzcjn);
            boolean z2 = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcsq)).booleanValue() && !TextUtils.isEmpty(str);
            boolean isEmpty = true ^ TextUtils.isEmpty(str2);
            if (z2 || isEmpty) {
                if (this.zzfrl.zzb(Uri.parse(zzc2))) {
                    Uri.Builder buildUpon = Uri.parse(zzc2).buildUpon();
                    if (z2) {
                        buildUpon = buildUpon.appendQueryParameter("ms", str);
                    }
                    if (isEmpty) {
                        buildUpon = buildUpon.appendQueryParameter("attok", str2);
                    }
                    zzc2 = buildUpon.build().toString();
                }
            }
            arrayList.add(zzc2);
        }
        return arrayList;
    }

    public final List<String> zza(zzdmw zzdmwVar, List<String> list, zzauk zzaukVar) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = this.zzbqg.currentTimeMillis();
        try {
            String type = zzaukVar.getType();
            String num = Integer.toString(zzaukVar.getAmount());
            zzdnk zzdnkVar = this.zzfyy;
            String zzhb = zzdnkVar == null ? "" : zzhb(zzdnkVar.zzdzh);
            zzdnk zzdnkVar2 = this.zzfyy;
            String zzhb2 = zzdnkVar2 != null ? zzhb(zzdnkVar2.zzdzi) : "";
            for (String str : list) {
                arrayList.add(zzaxu.zzc(zzc(zzc(zzc(zzc(zzc(zzc(str, "@gw_rwd_userid@", Uri.encode(zzhb)), "@gw_rwd_custom_data@", Uri.encode(zzhb2)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.zzbrp), this.context, zzdmwVar.zzdwz));
            }
            return arrayList;
        } catch (RemoteException e2) {
            zzazk.zzc("Unable to determine award type and amount.", e2);
            return arrayList;
        }
    }
}
