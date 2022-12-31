package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzeu implements zzer {
    @GuardedBy("GservicesLoader.class")
    private static zzeu zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    private zzeu() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzeu(Context context) {
        this.zzb = context;
        zzet zzetVar = new zzet(this, null);
        this.zzc = zzetVar;
        context.getContentResolver().registerContentObserver(zzei.zza, true, zzetVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeu zza(Context context) {
        zzeu zzeuVar;
        zzeu zzeuVar2;
        synchronized (zzeu.class) {
            if (zza == null) {
                if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                    zzeuVar2 = new zzeu(context);
                } else {
                    zzeuVar2 = new zzeu();
                }
                zza = zzeuVar2;
            }
            zzeuVar = zza;
        }
        return zzeuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zzc() {
        Context context;
        synchronized (zzeu.class) {
            zzeu zzeuVar = zza;
            if (zzeuVar != null && (context = zzeuVar.zzb) != null && zzeuVar.zzc != null) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    /* renamed from: zzb */
    public final String zze(final String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzep.zza(new zzeq(this, str) { // from class: com.google.android.gms.internal.measurement.zzes
                private final zzeu zza;
                private final String zzb;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zza = this;
                    this.zzb = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzeq
                public final Object zza() {
                    return this.zza.zzd(this.zzb);
                }
            });
        } catch (IllegalStateException | SecurityException e2) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzei.zza(this.zzb.getContentResolver(), str, null);
    }
}
