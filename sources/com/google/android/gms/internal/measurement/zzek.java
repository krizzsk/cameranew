package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Objects;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
final class zzek extends zzff {
    private final Context zza;
    private final zzfo<zzfm<zzev>> zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzek(Context context, @Nullable zzfo<zzfm<zzev>> zzfoVar) {
        Objects.requireNonNull(context, "Null context");
        this.zza = context;
        this.zzb = zzfoVar;
    }

    public final boolean equals(Object obj) {
        zzfo<zzfm<zzev>> zzfoVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzff) {
            zzff zzffVar = (zzff) obj;
            if (this.zza.equals(zzffVar.zza()) && ((zzfoVar = this.zzb) != null ? zzfoVar.equals(zzffVar.zzb()) : zzffVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        zzfo<zzfm<zzev>> zzfoVar = this.zzb;
        return hashCode ^ (zzfoVar == null ? 0 : zzfoVar.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46 + String.valueOf(valueOf2).length());
        sb.append("FlagsContext{context=");
        sb.append(valueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzff
    public final Context zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzff
    @Nullable
    public final zzfo<zzfm<zzev>> zzb() {
        return this.zzb;
    }
}
