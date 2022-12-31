package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public class zzbqx {
    private final Context context;
    private final zzdnp zzfwy;
    private Bundle zzfyw;
    @Nullable
    private final String zzfyx;
    @Nullable
    private final zzdnk zzfyy;

    /* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
    /* loaded from: classes2.dex */
    public static class zza {
        private Context context;
        private zzdnp zzfwy;
        private Bundle zzfyw;
        @Nullable
        private String zzfyx;
        @Nullable
        private zzdnk zzfyy;

        public final zza zza(zzdnp zzdnpVar) {
            this.zzfwy = zzdnpVar;
            return this;
        }

        public final zzbqx zzalo() {
            return new zzbqx(this);
        }

        public final zza zzcf(Context context) {
            this.context = context;
            return this;
        }

        public final zza zze(Bundle bundle) {
            this.zzfyw = bundle;
            return this;
        }

        public final zza zzfs(String str) {
            this.zzfyx = str;
            return this;
        }

        public final zza zza(zzdnk zzdnkVar) {
            this.zzfyy = zzdnkVar;
            return this;
        }
    }

    private zzbqx(zza zzaVar) {
        this.context = zzaVar.context;
        this.zzfwy = zzaVar.zzfwy;
        this.zzfyw = zzaVar.zzfyw;
        this.zzfyx = zzaVar.zzfyx;
        this.zzfyy = zzaVar.zzfyy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zza zzalk() {
        return new zza().zzcf(this.context).zza(this.zzfwy).zzfs(this.zzfyx).zze(this.zzfyw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdnp zzall() {
        return this.zzfwy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final zzdnk zzalm() {
        return this.zzfyy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final Bundle zzaln() {
        return this.zzfyw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context zzce(Context context) {
        return this.zzfyx != null ? context : this.context;
    }
}
