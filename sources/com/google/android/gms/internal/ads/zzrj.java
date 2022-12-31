package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzrj {
    private int score;
    private final int zzbsi;
    private final int zzbsj;
    private final int zzbsk;
    private final boolean zzbsl;
    private final zzru zzbsm;
    private final zzsf zzbsn;
    private final Object lock = new Object();
    private ArrayList<String> zzbso = new ArrayList<>();
    private ArrayList<String> zzbsp = new ArrayList<>();
    private ArrayList<zzrs> zzbsq = new ArrayList<>();
    private int zzbsr = 0;
    private int zzbss = 0;
    private int zzbst = 0;
    private String zzbsu = "";
    private String zzbsv = "";
    private String zzbsw = "";

    public zzrj(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.zzbsi = i2;
        this.zzbsj = i3;
        this.zzbsk = i4;
        this.zzbsl = z;
        this.zzbsm = new zzru(i5);
        this.zzbsn = new zzsf(i6, i7, i8);
    }

    private final void zzc(@Nullable String str, boolean z, float f2, float f3, float f4, float f5) {
        if (str == null || str.length() < this.zzbsk) {
            return;
        }
        synchronized (this.lock) {
            this.zzbso.add(str);
            this.zzbsr += str.length();
            if (z) {
                this.zzbsp.add(str);
                this.zzbsq.add(new zzrs(f2, f3, f4, f5, this.zzbsp.size() - 1));
            }
        }
    }

    private final int zzh(int i2, int i3) {
        if (this.zzbsl) {
            return this.zzbsj;
        }
        return (i2 * this.zzbsi) + (i3 * this.zzbsj);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzrj) {
            if (obj == this) {
                return true;
            }
            String str = ((zzrj) obj).zzbsu;
            return str != null && str.equals(this.zzbsu);
        }
        return false;
    }

    public final int getScore() {
        return this.score;
    }

    public final int hashCode() {
        return this.zzbsu.hashCode();
    }

    public final String toString() {
        int i2 = this.zzbss;
        int i3 = this.score;
        int i4 = this.zzbsr;
        String zza = zza(this.zzbso, 100);
        String zza2 = zza(this.zzbsp, 100);
        String str = this.zzbsu;
        String str2 = this.zzbsv;
        String str3 = this.zzbsw;
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 165 + String.valueOf(zza2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i2);
        sb.append(" score:");
        sb.append(i3);
        sb.append(" total_length:");
        sb.append(i4);
        sb.append("\n text: ");
        sb.append(zza);
        sb.append("\n viewableText");
        sb.append(zza2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    public final void zza(String str, boolean z, float f2, float f3, float f4, float f5) {
        zzc(str, z, f2, f3, f4, f5);
        synchronized (this.lock) {
            if (this.zzbst < 0) {
                zzazk.zzdy("ActivityContent: negative number of WebViews.");
            }
            zzmg();
        }
    }

    public final void zzb(String str, boolean z, float f2, float f3, float f4, float f5) {
        zzc(str, z, f2, f3, f4, f5);
    }

    public final void zzbt(int i2) {
        this.zzbss = i2;
    }

    public final boolean zzly() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbst == 0;
        }
        return z;
    }

    public final String zzlz() {
        return this.zzbsu;
    }

    public final String zzma() {
        return this.zzbsv;
    }

    public final String zzmb() {
        return this.zzbsw;
    }

    public final void zzmc() {
        synchronized (this.lock) {
            this.score -= 100;
        }
    }

    public final void zzmd() {
        synchronized (this.lock) {
            this.zzbst--;
        }
    }

    public final void zzme() {
        synchronized (this.lock) {
            this.zzbst++;
        }
    }

    public final void zzmf() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbsr, this.zzbss);
            if (zzh > this.score) {
                this.score = zzh;
            }
        }
    }

    public final void zzmg() {
        synchronized (this.lock) {
            int zzh = zzh(this.zzbsr, this.zzbss);
            if (zzh > this.score) {
                this.score = zzh;
                if (!com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyi()) {
                    this.zzbsu = this.zzbsm.zza(this.zzbso);
                    this.zzbsv = this.zzbsm.zza(this.zzbsp);
                }
                if (!com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyk()) {
                    this.zzbsw = this.zzbsn.zza(this.zzbsp, this.zzbsq);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzmh() {
        return this.zzbsr;
    }

    private static String zza(ArrayList<String> arrayList, int i2) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            String str = arrayList.get(i3);
            i3++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        return sb2.length() < 100 ? sb2 : sb2.substring(0, 100);
    }
}
