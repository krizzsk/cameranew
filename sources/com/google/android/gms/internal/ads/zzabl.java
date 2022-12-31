package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.c;
import com.google.android.gms.common.wrappers.b;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzabl implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzcmf;
    private final Object lock = new Object();
    private final ConditionVariable zzcmd = new ConditionVariable();
    private volatile boolean zzzl = false;
    private volatile boolean zzckv = false;
    @Nullable
    private SharedPreferences zzcme = null;
    private Bundle metaData = new Bundle();
    private JSONObject zzcmg = new JSONObject();

    private final void zzse() {
        if (this.zzcme == null) {
            return;
        }
        try {
            this.zzcmg = new JSONObject((String) com.google.android.gms.ads.internal.util.zzbr.zza(new zzdws(this) { // from class: com.google.android.gms.internal.ads.zzabn
                private final zzabl zzcmb;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcmb = this;
                }

                @Override // com.google.android.gms.internal.ads.zzdws
                public final Object get() {
                    return this.zzcmb.zzsf();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    public final void initialize(Context context) {
        if (this.zzzl) {
            return;
        }
        synchronized (this.lock) {
            if (this.zzzl) {
                return;
            }
            if (!this.zzckv) {
                this.zzckv = true;
            }
            Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
            this.zzcmf = applicationContext;
            try {
                this.metaData = b.a(applicationContext).c(this.zzcmf.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            Context d2 = c.d(context);
            if (d2 == null && context != null) {
                Context applicationContext2 = context.getApplicationContext();
                if (applicationContext2 != null) {
                    context = applicationContext2;
                }
                d2 = context;
            }
            if (d2 == null) {
                this.zzckv = false;
                this.zzcmd.open();
                return;
            }
            zzwr.zzqp();
            SharedPreferences sharedPreferences = d2.getSharedPreferences("google_ads_flags", 0);
            this.zzcme = sharedPreferences;
            if (sharedPreferences != null) {
                sharedPreferences.registerOnSharedPreferenceChangeListener(this);
            }
            zzadw.zza(new zzabm(this));
            zzse();
            this.zzzl = true;
            this.zzckv = false;
            this.zzcmd.open();
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzse();
        }
    }

    public final <T> T zzd(final zzaba<T> zzabaVar) {
        if (!this.zzcmd.block(5000L)) {
            synchronized (this.lock) {
                if (!this.zzckv) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzzl || this.zzcme == null) {
            synchronized (this.lock) {
                if (this.zzzl && this.zzcme != null) {
                }
                return zzabaVar.zzsb();
            }
        }
        if (zzabaVar.getSource() == 2) {
            Bundle bundle = this.metaData;
            if (bundle == null) {
                return zzabaVar.zzsb();
            }
            return zzabaVar.zza(bundle);
        } else if (zzabaVar.getSource() == 1 && this.zzcmg.has(zzabaVar.getKey())) {
            return zzabaVar.zzb(this.zzcmg);
        } else {
            return (T) com.google.android.gms.ads.internal.util.zzbr.zza(new zzdws(this, zzabaVar) { // from class: com.google.android.gms.internal.ads.zzabk
                private final zzabl zzcmb;
                private final zzaba zzcmc;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzcmb = this;
                    this.zzcmc = zzabaVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdws
                public final Object get() {
                    return this.zzcmb.zze(this.zzcmc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object zze(zzaba zzabaVar) {
        return zzabaVar.zza(this.zzcme);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String zzsf() {
        return this.zzcme.getString("flag_configuration", "{}");
    }
}
