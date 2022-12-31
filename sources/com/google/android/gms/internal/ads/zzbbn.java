package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.open.SocialConstants;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbbn {
    private final Context context;
    private final zzazn zzdtx;
    private final String zzdun;
    @Nullable
    private final zzacc zzejx;
    private boolean zzekb;
    @Nullable
    private final zzaca zzemp;
    private final long[] zzemr;
    private final String[] zzems;
    private zzbav zzemx;
    private boolean zzemy;
    private boolean zzemz;
    private final com.google.android.gms.ads.internal.util.zzau zzemq = new com.google.android.gms.ads.internal.util.zzav().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzzo();
    private boolean zzemt = false;
    private boolean zzemu = false;
    private boolean zzemv = false;
    private boolean zzemw = false;
    private long zzena = -1;

    public zzbbn(Context context, zzazn zzaznVar, String str, @Nullable zzacc zzaccVar, @Nullable zzaca zzacaVar) {
        this.context = context;
        this.zzdtx = zzaznVar;
        this.zzdun = str;
        this.zzejx = zzaccVar;
        this.zzemp = zzacaVar;
        String str2 = (String) zzwr.zzqr().zzd(zzabp.zzcnd);
        if (str2 == null) {
            this.zzems = new String[0];
            this.zzemr = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzems = new String[split.length];
        this.zzemr = new long[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            try {
                this.zzemr[i2] = Long.parseLong(split[i2]);
            } catch (NumberFormatException e2) {
                zzazk.zzd("Unable to parse frame hash target time number.", e2);
                this.zzemr[i2] = -1;
            }
        }
    }

    public final void onStop() {
        if (!zzadu.zzdez.get().booleanValue() || this.zzemy) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString(SocialConstants.TYPE_REQUEST, this.zzdun);
        bundle.putString("player", this.zzemx.zzaad());
        for (com.google.android.gms.ads.internal.util.zzaw zzawVar : this.zzemq.zzzn()) {
            String valueOf = String.valueOf(zzawVar.name);
            bundle.putString(valueOf.length() != 0 ? "fps_c_".concat(valueOf) : new String("fps_c_"), Integer.toString(zzawVar.count));
            String valueOf2 = String.valueOf(zzawVar.name);
            bundle.putString(valueOf2.length() != 0 ? "fps_p_".concat(valueOf2) : new String("fps_p_"), Double.toString(zzawVar.zzega));
        }
        int i2 = 0;
        while (true) {
            long[] jArr = this.zzemr;
            if (i2 < jArr.length) {
                String str = this.zzems[i2];
                if (str != null) {
                    String valueOf3 = String.valueOf(Long.valueOf(jArr[i2]));
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 3);
                    sb.append("fh_");
                    sb.append(valueOf3);
                    bundle.putString(sb.toString(), str);
                }
                i2++;
            } else {
                com.google.android.gms.ads.internal.zzr.zzkr().zza(this.context, this.zzdtx.zzbrp, "gmob-apps", bundle, true);
                this.zzemy = true;
                return;
            }
        }
    }

    public final void zzaaz() {
        this.zzekb = true;
        if (!this.zzemu || this.zzemv) {
            return;
        }
        zzabx.zza(this.zzejx, this.zzemp, "vfp2");
        this.zzemv = true;
    }

    public final void zzaba() {
        this.zzekb = false;
    }

    public final void zzb(zzbav zzbavVar) {
        zzabx.zza(this.zzejx, this.zzemp, "vpc2");
        this.zzemt = true;
        zzacc zzaccVar = this.zzejx;
        if (zzaccVar != null) {
            zzaccVar.zzg("vpn", zzbavVar.zzaad());
        }
        this.zzemx = zzbavVar;
    }

    public final void zzc(zzbav zzbavVar) {
        if (this.zzemv && !this.zzemw) {
            if (com.google.android.gms.ads.internal.util.zzd.zzyg() && !this.zzemw) {
                com.google.android.gms.ads.internal.util.zzd.zzeb("VideoMetricsMixin first frame");
            }
            zzabx.zza(this.zzejx, this.zzemp, "vff2");
            this.zzemw = true;
        }
        long b = com.google.android.gms.ads.internal.zzr.zzky().b();
        if (this.zzekb && this.zzemz && this.zzena != -1) {
            this.zzemq.zza(TimeUnit.SECONDS.toNanos(1L) / (b - this.zzena));
        }
        this.zzemz = this.zzekb;
        this.zzena = b;
        long longValue = ((Long) zzwr.zzqr().zzd(zzabp.zzcne)).longValue();
        long currentPosition = zzbavVar.getCurrentPosition();
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzems;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] == null && longValue > Math.abs(currentPosition - this.zzemr[i2])) {
                String[] strArr2 = this.zzems;
                int i3 = 8;
                Bitmap bitmap = zzbavVar.getBitmap(8, 8);
                long j2 = 63;
                int i4 = 0;
                long j3 = 0;
                while (i4 < i3) {
                    int i5 = 0;
                    while (i5 < i3) {
                        int pixel = bitmap.getPixel(i5, i4);
                        j3 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j2);
                        i5++;
                        j2--;
                        i3 = 8;
                    }
                    i4++;
                    i3 = 8;
                }
                strArr2[i2] = String.format("%016X", Long.valueOf(j3));
                return;
            }
            i2++;
        }
    }

    public final void zzfb() {
        if (!this.zzemt || this.zzemu) {
            return;
        }
        zzabx.zza(this.zzejx, this.zzemp, "vfr2");
        this.zzemu = true;
    }
}
