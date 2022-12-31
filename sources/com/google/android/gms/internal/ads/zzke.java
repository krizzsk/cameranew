package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzmh;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzke {
    private static final zzml zzaoy = new zzkd();
    private static final Pattern zzaoz = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzahr = -1;
    public int zzahs = -1;

    public final boolean zzb(zzmh zzmhVar) {
        for (int i2 = 0; i2 < zzmhVar.length(); i2++) {
            zzmh.zza zzay = zzmhVar.zzay(i2);
            if (zzay instanceof zzmj) {
                zzmj zzmjVar = (zzmj) zzay;
                if (zzb(zzmjVar.description, zzmjVar.text)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean zzgt() {
        return (this.zzahr == -1 || this.zzahs == -1) ? false : true;
    }

    private final boolean zzb(String str, String str2) {
        if ("iTunSMPB".equals(str)) {
            Matcher matcher = zzaoz.matcher(str2);
            if (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1), 16);
                    int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                    if (parseInt > 0 || parseInt2 > 0) {
                        this.zzahr = parseInt;
                        this.zzahs = parseInt2;
                        return true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
            return false;
        }
        return false;
    }
}
