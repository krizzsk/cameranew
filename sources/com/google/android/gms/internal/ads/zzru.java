package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzru {
    private final int zzbud;
    private final zzrv zzbuf = new zzry();
    private final int zzbuc = 6;
    private final int zzbue = 0;

    public zzru(int i2) {
        this.zzbud = i2;
    }

    private final String zzbp(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzrw zzrwVar = new zzrw();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbud, new zzrx(this));
        for (String str2 : split) {
            String[] zze = zzrz.zze(str2, false);
            if (zze.length != 0) {
                zzsa.zza(zze, this.zzbud, this.zzbuc, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzrwVar.write(this.zzbuf.zzbq(((zzsd) it.next()).zzbum));
            } catch (IOException e2) {
                zzazk.zzc("Error while writing hash to byteStream", e2);
            }
        }
        return zzrwVar.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            String str = arrayList.get(i2);
            i2++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append('\n');
        }
        return zzbp(sb.toString());
    }
}
