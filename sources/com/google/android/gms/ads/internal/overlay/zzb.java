package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzacr;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzwr;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzb {
    private static boolean a(Context context, Intent intent, zzv zzvVar, zzt zztVar, boolean z) {
        if (z) {
            return b(context, intent.getData(), zzvVar, zztVar);
        }
        try {
            String valueOf = String.valueOf(intent.toURI());
            com.google.android.gms.ads.internal.util.zzd.zzeb(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            com.google.android.gms.ads.internal.zzr.zzkr();
            com.google.android.gms.ads.internal.util.zzj.zza(context, intent);
            if (zzvVar != null) {
                zzvVar.zzwg();
            }
            if (zztVar != null) {
                zztVar.zzab(true);
            }
            return true;
        } catch (ActivityNotFoundException e2) {
            zzazk.zzex(e2.getMessage());
            if (zztVar != null) {
                zztVar.zzab(false);
            }
            return false;
        }
    }

    private static boolean b(Context context, Uri uri, zzv zzvVar, zzt zztVar) {
        zzacr zzacrVar = zzacr.UNKNOWN;
        try {
            try {
                zzacrVar = com.google.android.gms.ads.internal.zzr.zzkr().zza(context, uri);
                if (zzvVar != null) {
                    zzvVar.zzwg();
                }
                if (zztVar != null) {
                    zztVar.zza(zzacrVar);
                }
                return zzacrVar.equals(zzacr.CCT_READY_TO_OPEN);
            } catch (ActivityNotFoundException e2) {
                zzazk.zzex(e2.getMessage());
                zzacr zzacrVar2 = zzacr.ACTIVITY_NOT_FOUND;
                if (zztVar != null) {
                    zztVar.zza(zzacrVar2);
                }
                return zzacrVar2.equals(zzacr.CCT_READY_TO_OPEN);
            }
        } catch (Throwable unused) {
            if (zztVar != null) {
                zztVar.zza(zzacrVar);
            }
            return zzacrVar.equals(zzacr.CCT_READY_TO_OPEN);
        }
    }

    public static boolean zza(Context context, zzd zzdVar, zzv zzvVar, zzt zztVar) {
        int i2 = 0;
        if (zzdVar == null) {
            zzazk.zzex("No intent data for launcher overlay.");
            return false;
        }
        zzabp.initialize(context);
        Intent intent = zzdVar.intent;
        if (intent != null) {
            return a(context, intent, zzvVar, zztVar, zzdVar.zzdsg);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzdVar.url)) {
            zzazk.zzex("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzdVar.mimeType)) {
            intent2.setDataAndType(Uri.parse(zzdVar.url), zzdVar.mimeType);
        } else {
            intent2.setData(Uri.parse(zzdVar.url));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzdVar.packageName)) {
            intent2.setPackage(zzdVar.packageName);
        }
        if (!TextUtils.isEmpty(zzdVar.zzdsd)) {
            String[] split = zzdVar.zzdsd.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzdVar.zzdsd);
                zzazk.zzex(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str = zzdVar.zzdse;
        if (!TextUtils.isEmpty(str)) {
            try {
                i2 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzazk.zzex("Could not parse intent flags.");
            }
            intent2.addFlags(i2);
        }
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcuq)).booleanValue()) {
            intent2.addFlags(PGImageSDK.SDK_STATUS_CREATE);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcup)).booleanValue()) {
                com.google.android.gms.ads.internal.zzr.zzkr();
                com.google.android.gms.ads.internal.util.zzj.zzb(context, intent2);
            }
        }
        return a(context, intent2, zzvVar, zztVar, zzdVar.zzdsg);
    }
}
