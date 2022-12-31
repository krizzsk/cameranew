package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzcj;
import com.google.android.gms.internal.measurement.zzck;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class aa {
    final String a;
    final int b;
    Boolean c;

    /* renamed from: d  reason: collision with root package name */
    Boolean f3750d;

    /* renamed from: e  reason: collision with root package name */
    Long f3751e;

    /* renamed from: f  reason: collision with root package name */
    Long f3752f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    private static Boolean d(String str, zzcj zzcjVar, boolean z, String str2, List<String> list, String str3, k3 k3Var) {
        if (zzcjVar == zzcj.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzcjVar != zzcj.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        zzcc zzccVar = zzcc.UNKNOWN_COMPARISON_TYPE;
        switch (zzcjVar.ordinal()) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, true != z ? 66 : 0).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (k3Var != null) {
                        k3Var.p().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean e(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean f(String str, zzck zzckVar, k3 k3Var) {
        String zzd;
        List<String> list;
        com.google.android.gms.common.internal.q.j(zzckVar);
        if (str == null || !zzckVar.zza() || zzckVar.zzb() == zzcj.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        zzcj zzb = zzckVar.zzb();
        zzcj zzcjVar = zzcj.IN_LIST;
        if (zzb == zzcjVar) {
            if (zzckVar.zzh() == 0) {
                return null;
            }
        } else if (!zzckVar.zzc()) {
            return null;
        }
        zzcj zzb2 = zzckVar.zzb();
        boolean zzf = zzckVar.zzf();
        if (!zzf && zzb2 != zzcj.REGEXP && zzb2 != zzcjVar) {
            zzd = zzckVar.zzd().toUpperCase(Locale.ENGLISH);
        } else {
            zzd = zzckVar.zzd();
        }
        String str2 = zzd;
        if (zzckVar.zzh() == 0) {
            list = null;
        } else {
            List<String> zzg = zzckVar.zzg();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(zzg.size());
                for (String str3 : zzg) {
                    arrayList.add(str3.toUpperCase(Locale.ENGLISH));
                }
                zzg = Collections.unmodifiableList(arrayList);
            }
            list = zzg;
        }
        return d(str, zzb2, zzf, str2, list, zzb2 == zzcj.REGEXP ? str2 : null, k3Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean g(long j2, zzcd zzcdVar) {
        try {
            return j(new BigDecimal(j2), zzcdVar, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean h(double d2, zzcd zzcdVar) {
        try {
            return j(new BigDecimal(d2), zzcdVar, Math.ulp(d2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean i(String str, zzcd zzcdVar) {
        if (j9.z(str)) {
            try {
                return j(new BigDecimal(str), zzcdVar, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    static Boolean j(BigDecimal bigDecimal, zzcd zzcdVar, double d2) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        com.google.android.gms.common.internal.q.j(zzcdVar);
        if (zzcdVar.zza() && zzcdVar.zzb() != zzcc.UNKNOWN_COMPARISON_TYPE) {
            zzcc zzb = zzcdVar.zzb();
            zzcc zzccVar = zzcc.BETWEEN;
            if (zzb == zzccVar) {
                if (!zzcdVar.zzg() || !zzcdVar.zzi()) {
                    return null;
                }
            } else if (!zzcdVar.zze()) {
                return null;
            }
            zzcc zzb2 = zzcdVar.zzb();
            if (zzcdVar.zzb() == zzccVar) {
                if (j9.z(zzcdVar.zzh()) && j9.z(zzcdVar.zzj())) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzcdVar.zzh());
                        bigDecimal4 = new BigDecimal(zzcdVar.zzj());
                        bigDecimal3 = bigDecimal5;
                        bigDecimal2 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            } else if (!j9.z(zzcdVar.zzf())) {
                return null;
            } else {
                try {
                    bigDecimal2 = new BigDecimal(zzcdVar.zzf());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
            }
            if (zzb2 == zzccVar) {
                if (bigDecimal3 == null) {
                    return null;
                }
            } else if (bigDecimal2 == null) {
                return null;
            }
            zzcj zzcjVar = zzcj.UNKNOWN_MATCH_TYPE;
            int ordinal = zzb2.ordinal();
            if (ordinal == 1) {
                if (bigDecimal2 == null) {
                    return null;
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == -1);
            } else if (ordinal == 2) {
                if (bigDecimal2 == null) {
                    return null;
                }
                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 1);
            } else if (ordinal != 3) {
                if (ordinal == 4 && bigDecimal3 != null) {
                    if (bigDecimal.compareTo(bigDecimal3) != -1 && bigDecimal.compareTo(bigDecimal4) != 1) {
                        r5 = true;
                    }
                    return Boolean.valueOf(r5);
                }
                return null;
            } else if (bigDecimal2 == null) {
                return null;
            } else {
                if (d2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                }
                if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d2).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d2).multiply(new BigDecimal(2)))) == -1) {
                    r5 = true;
                }
                return Boolean.valueOf(r5);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean c();
}
