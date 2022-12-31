package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import com.google.android.gms.common.util.i;
import com.google.android.gms.common.wrappers.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzdfo implements zzdfi<zzdfp> {
    private final Context context;
    private final zzdzv zzghl;

    public zzdfo(zzdzv zzdzvVar, Context context) {
        this.zzghl = zzdzvVar;
        this.context = context;
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo e2 = b.a(context).e(activityInfo.packageName, 0);
            if (e2 != null) {
                int i2 = e2.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i2);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static String zzu(Context context) {
        try {
            PackageInfo e2 = b.a(context).e("com.android.vending", 128);
            if (e2 != null) {
                int i2 = e2.versionCode;
                String str = e2.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i2);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdfp> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdfr
            private final zzdfo zzhdt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhdt = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhdt.zzatr();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdfp zzatr() throws Exception {
        boolean z;
        PackageManager packageManager = this.context.getPackageManager();
        Locale locale = Locale.getDefault();
        boolean z2 = zza(packageManager, "geo:0,0?q=donuts") != null;
        boolean z3 = zza(packageManager, "http://www.google.com") != null;
        String country = locale.getCountry();
        boolean startsWith = Build.DEVICE.startsWith("generic");
        boolean a = i.a(this.context);
        boolean b = i.b(this.context);
        String language = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = LocaleList.getDefault();
            for (int i2 = 0; i2 < localeList.size(); i2++) {
                arrayList.add(localeList.get(i2).getLanguage());
            }
        }
        String zza = zza(this.context, packageManager);
        String zzu = zzu(this.context);
        String str = Build.FINGERPRINT;
        Context context = this.context;
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                for (int i3 = 0; i3 < queryIntentActivities.size(); i3++) {
                    if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i3).activityInfo.name)) {
                        z = resolveActivity.activityInfo.packageName.equals(zzeqn.zzcl(context));
                        break;
                    }
                }
            }
        }
        z = false;
        return new zzdfp(z2, z3, country, startsWith, a, b, language, arrayList, zza, zzu, str, z, Build.MODEL, com.google.android.gms.ads.internal.zzr.zzkt().zzzg());
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }
}
