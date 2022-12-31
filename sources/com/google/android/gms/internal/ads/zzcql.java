package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.internal.ads.zztw;
import com.google.android.gms.internal.ads.zzug;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcql {
    private Context context;
    private final zzdrz zzdic;
    private zzazn zzdtx;
    private final com.google.android.gms.ads.internal.util.zzf zzeaw = com.google.android.gms.ads.internal.zzr.zzkv().zzxs();
    private zzcpv zzgrg;
    private zztu zzgro;
    private final String zzgrp;

    public zzcql(Context context, zzazn zzaznVar, zztu zztuVar, zzcpv zzcpvVar, String str, zzdrz zzdrzVar) {
        this.context = context;
        this.zzdtx = zzaznVar;
        this.zzgro = zztuVar;
        this.zzgrg = zzcpvVar;
        this.zzgrp = str;
        this.zzdic = zzdrzVar;
    }

    private static void zza(SQLiteDatabase sQLiteDatabase, ArrayList<zzug.zzo.zza> arrayList) {
        int size = arrayList.size();
        int i2 = 0;
        long j2 = 0;
        while (i2 < size) {
            zzug.zzo.zza zzaVar = arrayList.get(i2);
            i2++;
            zzug.zzo.zza zzaVar2 = zzaVar;
            if (zzaVar2.zzov() == zzuq.ENUM_TRUE && zzaVar2.getTimestamp() > j2) {
                j2 = zzaVar2.getTimestamp();
            }
        }
        if (j2 != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(FirebaseAnalytics.Param.VALUE, Long.valueOf(j2));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
    }

    public final void zzarx() {
        try {
            this.zzgrg.zza(new zzdqu(this) { // from class: com.google.android.gms.internal.ads.zzcqo
                private final zzcql zzgrr;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgrr = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdqu
                public final Object apply(Object obj) {
                    return this.zzgrr.zza((SQLiteDatabase) obj);
                }
            });
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            zzazk.zzev(valueOf.length() != 0 ? "Error in offline signals database startup: ".concat(valueOf) : new String("Error in offline signals database startup: "));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void zza(SQLiteDatabase sQLiteDatabase) throws Exception {
        int i2 = 0;
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzdal)).booleanValue()) {
            this.zzdic.zzb(zzdsa.zzgx("oa_upload").zzu("oa_failed_reqs", String.valueOf(zzcqm.zza(sQLiteDatabase, 0))).zzu("oa_total_reqs", String.valueOf(zzcqm.zza(sQLiteDatabase, 1))).zzu("oa_upload_time", String.valueOf(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis())).zzu("oa_last_successful_time", String.valueOf(zzcqm.zzb(sQLiteDatabase, 2))).zzu("oa_session_id", this.zzeaw.zzyu() ? "" : this.zzgrp));
            ArrayList<zzug.zzo.zza> zzb = zzcqm.zzb(sQLiteDatabase);
            zza(sQLiteDatabase, zzb);
            int size = zzb.size();
            while (i2 < size) {
                zzug.zzo.zza zzaVar = zzb.get(i2);
                i2++;
                zzug.zzo.zza zzaVar2 = zzaVar;
                zzdsa zzu = zzdsa.zzgx("oa_signals").zzu("oa_session_id", this.zzeaw.zzyu() ? "" : this.zzgrp);
                zzug.zzm zzoz = zzaVar2.zzoz();
                zzu.zzu("oa_sig_ts", String.valueOf(zzaVar2.getTimestamp())).zzu("oa_sig_status", String.valueOf(zzaVar2.zzov().zzv())).zzu("oa_sig_resp_lat", String.valueOf(zzaVar2.zzow())).zzu("oa_sig_render_lat", String.valueOf(zzaVar2.zzox())).zzu("oa_sig_formats", zzdxl.zza(zzaVar2.zzoy(), zzcqp.zzeaj).toString()).zzu("oa_sig_nw_type", zzoz.zzol() ? String.valueOf(zzoz.zzom().zzv()) : TaskDetailBasePresenter.SCENE_LIST).zzu("oa_sig_wifi", String.valueOf(zzaVar2.zzpa().zzv())).zzu("oa_sig_airplane", String.valueOf(zzaVar2.zzpb().zzv())).zzu("oa_sig_data", String.valueOf(zzaVar2.zzpc().zzv())).zzu("oa_sig_nw_resp", String.valueOf(zzaVar2.zzpd())).zzu("oa_sig_offline", String.valueOf(zzaVar2.zzpe().zzv())).zzu("oa_sig_nw_state", String.valueOf(zzaVar2.zzpf().zzv()));
                if (zzoz.zzon() && zzoz.zzol() && zzoz.zzom().equals(zzug.zzm.zzc.CELL)) {
                    zzu.zzu("oa_sig_cell_type", String.valueOf(zzoz.zzoo().zzv()));
                }
                this.zzdic.zzb(zzu);
            }
        } else {
            ArrayList<zzug.zzo.zza> zzb2 = zzcqm.zzb(sQLiteDatabase);
            final zzug.zzo zzoVar = (zzug.zzo) ((zzelb) zzug.zzo.zzot().zzca(this.context.getPackageName()).zzcb(Build.MODEL).zzcj(zzcqm.zza(sQLiteDatabase, 0)).zze(zzb2).zzck(zzcqm.zza(sQLiteDatabase, 1)).zzes(com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis()).zzet(zzcqm.zzb(sQLiteDatabase, 2)).zzbiw());
            zza(sQLiteDatabase, zzb2);
            this.zzgro.zza(new zztx(zzoVar) { // from class: com.google.android.gms.internal.ads.zzcqn
                private final zzug.zzo zzgrq;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgrq = zzoVar;
                }

                @Override // com.google.android.gms.internal.ads.zztx
                public final void zza(zzug.zzi.zza zzaVar3) {
                    zzaVar3.zzb(this.zzgrq);
                }
            });
            final zzug.zzu zzuVar = (zzug.zzu) ((zzelb) zzug.zzu.zzpn().zzcq(this.zzdtx.zzehy).zzcr(this.zzdtx.zzehz).zzcs(this.zzdtx.zzeia ? 0 : 2).zzbiw());
            this.zzgro.zza(new zztx(zzuVar) { // from class: com.google.android.gms.internal.ads.zzcqq
                private final zzug.zzu zzgrs;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgrs = zzuVar;
                }

                @Override // com.google.android.gms.internal.ads.zztx
                public final void zza(zzug.zzi.zza zzaVar3) {
                    zzaVar3.zza(zzaVar3.zzod().zzbij().zzb(this.zzgrs));
                }
            });
            this.zzgro.zza(zztw.zza.EnumC0159zza.OFFLINE_UPLOAD);
        }
        sQLiteDatabase.delete("offline_signal_contents", null, null);
        ContentValues contentValues = new ContentValues();
        contentValues.put(FirebaseAnalytics.Param.VALUE, (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = ?", new String[]{"failed_requests"});
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(FirebaseAnalytics.Param.VALUE, (Integer) 0);
        sQLiteDatabase.update("offline_signal_statistics", contentValues2, "statistic_name = ?", new String[]{"total_requests"});
        return null;
    }
}
