package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzsf {
    private final int zzbud;
    private final zzrv zzbuf;
    private String zzbun;
    private String zzbuo;
    private final boolean zzbup = false;
    private final int zzbuq;
    private final int zzbur;

    public zzsf(int i2, int i3, int i4) {
        this.zzbud = i2;
        if (i3 <= 64 && i3 >= 0) {
            this.zzbuq = i3;
        } else {
            this.zzbuq = 64;
        }
        if (i4 <= 0) {
            this.zzbur = 1;
        } else {
            this.zzbur = i4;
        }
        this.zzbuf = new zzsc(this.zzbuq);
    }

    public final String zza(ArrayList<String> arrayList, ArrayList<zzrs> arrayList2) {
        boolean z;
        boolean z2;
        int i2;
        Collections.sort(arrayList2, new zzse(this));
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            String[] split = Normalizer.normalize(arrayList.get(arrayList2.get(i3).zzmr()), Normalizer.Form.NFKC).toLowerCase(Locale.US).split("\n");
            if (split.length != 0) {
                for (String str : split) {
                    if (str.indexOf("'") != -1) {
                        StringBuilder sb = new StringBuilder(str);
                        int i4 = 1;
                        boolean z3 = false;
                        while (true) {
                            int i5 = i4 + 2;
                            if (i5 > sb.length()) {
                                break;
                            }
                            if (sb.charAt(i4) == '\'') {
                                if (sb.charAt(i4 - 1) != ' ') {
                                    int i6 = i4 + 1;
                                    if ((sb.charAt(i6) == 's' || sb.charAt(i6) == 'S') && (i5 == sb.length() || sb.charAt(i5) == ' ')) {
                                        sb.insert(i4, ' ');
                                        i4 = i5;
                                        i2 = 1;
                                        z3 = true;
                                    }
                                }
                                sb.setCharAt(i4, ' ');
                                i2 = 1;
                                z3 = true;
                            } else {
                                i2 = 1;
                            }
                            i4 += i2;
                        }
                        String sb2 = z3 ? sb.toString() : null;
                        if (sb2 != null) {
                            this.zzbuo = sb2;
                            str = sb2;
                        }
                    }
                    String[] zze = zzrz.zze(str, true);
                    if (zze.length >= this.zzbur) {
                        for (int i7 = 0; i7 < zze.length; i7++) {
                            String str2 = "";
                            int i8 = 0;
                            while (true) {
                                if (i8 >= this.zzbur) {
                                    z2 = true;
                                    break;
                                }
                                int i9 = i7 + i8;
                                if (i9 >= zze.length) {
                                    z2 = false;
                                    break;
                                }
                                if (i8 > 0) {
                                    str2 = String.valueOf(str2).concat(" ");
                                }
                                String valueOf = String.valueOf(str2);
                                String valueOf2 = String.valueOf(zze[i9]);
                                str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                                i8++;
                            }
                            if (!z2) {
                                break;
                            }
                            hashSet.add(str2);
                            if (hashSet.size() >= this.zzbud) {
                                break;
                            }
                        }
                        if (hashSet.size() >= this.zzbud) {
                            z = false;
                            break;
                        }
                    }
                }
            }
            z = true;
            if (!z) {
                break;
            }
        }
        zzrw zzrwVar = new zzrw();
        this.zzbun = "";
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                zzrwVar.write(this.zzbuf.zzbq((String) it.next()));
            } catch (IOException e2) {
                zzazk.zzc("Error while writing hash to byteStream", e2);
            }
        }
        return zzrwVar.toString();
    }
}
