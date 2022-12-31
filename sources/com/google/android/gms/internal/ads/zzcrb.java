package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.AdService;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.common.util.o;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.tapjoy.TapjoyConstants;
import com.tencent.tauth.AuthActivity;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcrb extends zzare {
    private final Context context;
    private final zzckn zzdib;
    private final zzdrz zzdic;
    private final zzazo zzdid;
    private final zzcqr zzdie;

    public zzcrb(Context context, zzcqr zzcqrVar, zzazo zzazoVar, zzckn zzcknVar, zzdrz zzdrzVar) {
        this.context = context;
        this.zzdib = zzcknVar;
        this.zzdid = zzazoVar;
        this.zzdie = zzcqrVar;
        this.zzdic = zzdrzVar;
    }

    public static void zza(final Activity activity, @Nullable final com.google.android.gms.ads.internal.overlay.zzc zzcVar, final com.google.android.gms.ads.internal.util.zzbg zzbgVar, final zzcqr zzcqrVar, final zzckn zzcknVar, final zzdrz zzdrzVar, final String str, final String str2) {
        com.google.android.gms.ads.internal.zzr.zzkr();
        AlertDialog.Builder zzc = com.google.android.gms.ads.internal.util.zzj.zzc(activity, com.google.android.gms.ads.internal.zzr.zzkt().zzzf());
        final Resources resources = com.google.android.gms.ads.internal.zzr.zzkv().getResources();
        zzc.setTitle(resources == null ? "Open ad when you're back online." : resources.getString(R.string.offline_opt_in_title)).setMessage(resources == null ? "We'll send you a notification with a link to the advertiser site." : resources.getString(R.string.offline_opt_in_message)).setPositiveButton(resources == null ? "OK" : resources.getString(R.string.offline_opt_in_confirm), new DialogInterface.OnClickListener(zzcknVar, activity, zzdrzVar, zzcqrVar, str, zzbgVar, str2, resources, zzcVar) { // from class: com.google.android.gms.internal.ads.zzcre
            private final Activity zzeey;
            private final String zzesf;
            private final zzckn zzgsg;
            private final zzdrz zzgsh;
            private final zzcqr zzgsi;
            private final com.google.android.gms.ads.internal.util.zzbg zzgsj;
            private final String zzgsk;
            private final Resources zzgsl;
            private final com.google.android.gms.ads.internal.overlay.zzc zzgsm;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgsg = zzcknVar;
                this.zzeey = activity;
                this.zzgsh = zzdrzVar;
                this.zzgsi = zzcqrVar;
                this.zzesf = str;
                this.zzgsj = zzbgVar;
                this.zzgsk = str2;
                this.zzgsl = resources;
                this.zzgsm = zzcVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public final void onClick(DialogInterface dialogInterface, int i2) {
                final com.google.android.gms.ads.internal.overlay.zzc zzcVar2;
                VdsAgent.onClick(this, dialogInterface, i2);
                zzckn zzcknVar2 = this.zzgsg;
                Activity activity2 = this.zzeey;
                zzdrz zzdrzVar2 = this.zzgsh;
                zzcqr zzcqrVar2 = this.zzgsi;
                String str3 = this.zzesf;
                com.google.android.gms.ads.internal.util.zzbg zzbgVar2 = this.zzgsj;
                String str4 = this.zzgsk;
                Resources resources2 = this.zzgsl;
                com.google.android.gms.ads.internal.overlay.zzc zzcVar3 = this.zzgsm;
                if (zzcknVar2 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("dialog_action", "confirm");
                    zzcVar2 = zzcVar3;
                    zzcrb.zza(activity2, zzcknVar2, zzdrzVar2, zzcqrVar2, str3, "dialog_click", hashMap);
                } else {
                    zzcVar2 = zzcVar3;
                }
                boolean z = false;
                try {
                    z = zzbgVar2.zzd(d.z0(activity2), str4, str3);
                } catch (RemoteException e2) {
                    zzazk.zzc("Failed to schedule offline notification poster.", e2);
                }
                if (!z) {
                    zzcqrVar2.zzgm(str3);
                    if (zzcknVar2 != null) {
                        zzcrb.zza(activity2, zzcknVar2, zzdrzVar2, zzcqrVar2, str3, "offline_notification_worker_not_scheduled");
                    }
                }
                com.google.android.gms.ads.internal.zzr.zzkr();
                AlertDialog.Builder zzc2 = com.google.android.gms.ads.internal.util.zzj.zzc(activity2, com.google.android.gms.ads.internal.zzr.zzkt().zzzf());
                zzc2.setMessage(resources2 == null ? "You'll get a notification with the link when you're back online" : resources2.getString(R.string.offline_opt_in_confirmation)).setOnCancelListener(new DialogInterface.OnCancelListener(zzcVar2) { // from class: com.google.android.gms.internal.ads.zzcrf
                    private final com.google.android.gms.ads.internal.overlay.zzc zzdsh;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdsh = zzcVar2;
                    }

                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface2) {
                        com.google.android.gms.ads.internal.overlay.zzc zzcVar4 = this.zzdsh;
                        if (zzcVar4 != null) {
                            zzcVar4.close();
                        }
                    }
                });
                AlertDialog create = zzc2.create();
                create.show();
                VdsAgent.showDialog(create);
                Timer timer = new Timer();
                timer.schedule(new zzcri(create, timer, zzcVar2), 3000L);
            }
        }).setNegativeButton(resources == null ? "No thanks" : resources.getString(R.string.offline_opt_in_decline), new DialogInterface.OnClickListener(zzcqrVar, str, zzcknVar, activity, zzdrzVar, zzcVar) { // from class: com.google.android.gms.internal.ads.zzcrd
            private final String zzdjf;
            private final zzcqr zzgrw;
            private final zzckn zzgsc;
            private final Activity zzgsd;
            private final zzdrz zzgse;
            private final com.google.android.gms.ads.internal.overlay.zzc zzgsf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrw = zzcqrVar;
                this.zzdjf = str;
                this.zzgsc = zzcknVar;
                this.zzgsd = activity;
                this.zzgse = zzdrzVar;
                this.zzgsf = zzcVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            @Instrumented
            public final void onClick(DialogInterface dialogInterface, int i2) {
                VdsAgent.onClick(this, dialogInterface, i2);
                zzcqr zzcqrVar2 = this.zzgrw;
                String str3 = this.zzdjf;
                zzckn zzcknVar2 = this.zzgsc;
                Activity activity2 = this.zzgsd;
                zzdrz zzdrzVar2 = this.zzgse;
                com.google.android.gms.ads.internal.overlay.zzc zzcVar2 = this.zzgsf;
                zzcqrVar2.zzgm(str3);
                if (zzcknVar2 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("dialog_action", TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL);
                    zzcrb.zza(activity2, zzcknVar2, zzdrzVar2, zzcqrVar2, str3, "dialog_click", hashMap);
                }
                if (zzcVar2 != null) {
                    zzcVar2.close();
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener(zzcqrVar, str, zzcknVar, activity, zzdrzVar, zzcVar) { // from class: com.google.android.gms.internal.ads.zzcrg
            private final String zzdjf;
            private final zzcqr zzgrw;
            private final zzckn zzgsc;
            private final Activity zzgsd;
            private final zzdrz zzgse;
            private final com.google.android.gms.ads.internal.overlay.zzc zzgsf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgrw = zzcqrVar;
                this.zzdjf = str;
                this.zzgsc = zzcknVar;
                this.zzgsd = activity;
                this.zzgse = zzdrzVar;
                this.zzgsf = zzcVar;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                zzcqr zzcqrVar2 = this.zzgrw;
                String str3 = this.zzdjf;
                zzckn zzcknVar2 = this.zzgsc;
                Activity activity2 = this.zzgsd;
                zzdrz zzdrzVar2 = this.zzgse;
                com.google.android.gms.ads.internal.overlay.zzc zzcVar2 = this.zzgsf;
                zzcqrVar2.zzgm(str3);
                if (zzcknVar2 != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("dialog_action", TapjoyConstants.TJC_FULLSCREEN_AD_DISMISS_URL);
                    zzcrb.zza(activity2, zzcknVar2, zzdrzVar2, zzcqrVar2, str3, "dialog_click", hashMap);
                }
                if (zzcVar2 != null) {
                    zzcVar2.close();
                }
            }
        });
        AlertDialog create = zzc.create();
        create.show();
        VdsAgent.showDialog(create);
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final void zzc(Intent intent) {
        String stringExtra = intent.getStringExtra("offline_notification_action");
        if (stringExtra.equals("offline_notification_clicked") || stringExtra.equals("offline_notification_dismissed")) {
            String stringExtra2 = intent.getStringExtra("gws_query_id");
            String stringExtra3 = intent.getStringExtra("uri");
            com.google.android.gms.ads.internal.zzr.zzkr();
            boolean zzba = com.google.android.gms.ads.internal.util.zzj.zzba(this.context);
            int i2 = zzcrh.zzgso;
            HashMap hashMap = new HashMap();
            if (stringExtra.equals("offline_notification_clicked")) {
                hashMap.put("offline_notification_action", "offline_notification_clicked");
                if (zzba) {
                    i2 = zzcrh.zzgsn;
                }
                hashMap.put("obvs", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("olaih", String.valueOf(stringExtra3.startsWith("http")));
                try {
                    Context context = this.context;
                    Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(stringExtra3);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                        launchIntentForPackage.setData(Uri.parse(stringExtra3));
                    }
                    launchIntentForPackage.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                    context.startActivity(launchIntentForPackage);
                    hashMap.put("olaa", "olas");
                } catch (ActivityNotFoundException unused) {
                    hashMap.put("olaa", "olaf");
                }
            } else {
                hashMap.put("offline_notification_action", "offline_notification_dismissed");
            }
            zza(stringExtra2, "offline_notification_action", hashMap);
            try {
                SQLiteDatabase writableDatabase = this.zzdie.getWritableDatabase();
                if (i2 == zzcrh.zzgsn) {
                    this.zzdie.zza(writableDatabase, this.zzdid, stringExtra2);
                } else {
                    zzcqr.zza(writableDatabase, stringExtra2);
                }
            } catch (SQLiteException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51);
                sb.append("Failed to get writable offline buffering database: ");
                sb.append(valueOf);
                zzazk.zzev(sb.toString());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final void zzvt() {
        this.zzdie.zza(this.zzdid);
    }

    public static void zza(Context context, zzckn zzcknVar, zzdrz zzdrzVar, zzcqr zzcqrVar, String str, String str2) {
        zza(context, zzcknVar, zzdrzVar, zzcqrVar, str, str2, new HashMap());
    }

    public static void zza(Context context, zzckn zzcknVar, zzdrz zzdrzVar, zzcqr zzcqrVar, String str, String str2, Map<String, String> map) {
        String zzaqu;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
            zzdsa zzu = zzdsa.zzgx(str2).zzu("gqi", str);
            com.google.android.gms.ads.internal.zzr.zzkr();
            zzdsa zzu2 = zzu.zzu("device_connectivity", com.google.android.gms.ads.internal.util.zzj.zzba(context) ? "online" : "offline").zzu("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis()));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                zzu2.zzu(entry.getKey(), entry.getValue());
            }
            zzaqu = zzdrzVar.zzc(zzu2);
        } else {
            zzckq zzaqr = zzcknVar.zzaqr();
            zzaqr.zzr("gqi", str);
            zzaqr.zzr(AuthActivity.ACTION_KEY, str2);
            com.google.android.gms.ads.internal.zzr.zzkr();
            zzaqr.zzr("device_connectivity", com.google.android.gms.ads.internal.util.zzj.zzba(context) ? "online" : "offline");
            zzaqr.zzr("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis()));
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                zzaqr.zzr(entry2.getKey(), entry2.getValue());
            }
            zzaqu = zzaqr.zzaqu();
        }
        zzcqrVar.zza(new zzcrc(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis(), str, zzaqu, zzcqs.zzgru));
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final void zzc(b bVar, String str, String str2) {
        Context context = (Context) d.y0(bVar);
        int i2 = o.i() ? 1140850688 : 1073741824;
        Intent intent = new Intent();
        intent.setClass(context, AdService.class);
        intent.setAction("offline_notification_clicked");
        intent.putExtra("offline_notification_action", "offline_notification_clicked");
        intent.putExtra("gws_query_id", str2);
        intent.putExtra("uri", str);
        PendingIntent service = zzdvn.getService(context, 0, intent, i2);
        Intent intent2 = new Intent();
        intent2.setClass(context, AdService.class);
        intent2.setAction("offline_notification_dismissed");
        intent2.putExtra("offline_notification_action", "offline_notification_dismissed");
        intent2.putExtra("gws_query_id", str2);
        PendingIntent service2 = zzdvn.getService(context, 0, intent2, i2);
        Resources resources = com.google.android.gms.ads.internal.zzr.zzkv().getResources();
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(context, "offline_notification_channel").setContentTitle(resources == null ? "View the ad you saved when you were offline" : resources.getString(R.string.offline_notification_title)).setContentText(resources == null ? "Tap to open ad" : resources.getString(R.string.offline_notification_text)).setAutoCancel(true).setDeleteIntent(service2).setContentIntent(service).setSmallIcon(context.getApplicationInfo().icon);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Notification build = smallIcon.build();
        notificationManager.notify(str2, 54321, build);
        VdsAgent.onNotify(notificationManager, str2, 54321, build);
        zza(str2, "offline_notification_impression", new HashMap());
    }

    private final void zza(String str, String str2, Map<String, String> map) {
        zza(this.context, this.zzdib, this.zzdic, this.zzdie, str, str2, map);
    }
}
