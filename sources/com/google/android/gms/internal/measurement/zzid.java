package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzb uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzid {
    public static final zzid zza;
    public static final zzid zzb;
    public static final zzid zzc;
    public static final zzid zzd;
    public static final zzid zze;
    public static final zzid zzf;
    public static final zzid zzg;
    public static final zzid zzh;
    public static final zzid zzi;
    public static final zzid zzj;
    private static final /* synthetic */ zzid[] zzn;
    private final Class<?> zzk;
    private final Class<?> zzl;
    private final Object zzm;

    static {
        zzid zzidVar = new zzid("VOID", 0, Void.class, Void.class, null);
        zza = zzidVar;
        Class cls = Integer.TYPE;
        zzid zzidVar2 = new zzid("INT", 1, cls, Integer.class, 0);
        zzb = zzidVar2;
        zzid zzidVar3 = new zzid("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzidVar3;
        zzid zzidVar4 = new zzid("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzidVar4;
        zzid zzidVar5 = new zzid("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zze = zzidVar5;
        zzid zzidVar6 = new zzid("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzidVar6;
        zzid zzidVar7 = new zzid("STRING", 6, String.class, String.class, "");
        zzg = zzidVar7;
        zzid zzidVar8 = new zzid("BYTE_STRING", 7, zzgs.class, zzgs.class, zzgs.zzb);
        zzh = zzidVar8;
        zzid zzidVar9 = new zzid("ENUM", 8, cls, Integer.class, null);
        zzi = zzidVar9;
        zzid zzidVar10 = new zzid("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzidVar10;
        zzn = new zzid[]{zzidVar, zzidVar2, zzidVar3, zzidVar4, zzidVar5, zzidVar6, zzidVar7, zzidVar8, zzidVar9, zzidVar10};
    }

    private zzid(String str, int i2, Class cls, Class cls2, Object obj) {
        this.zzk = cls;
        this.zzl = cls2;
        this.zzm = obj;
    }

    public static zzid[] values() {
        return (zzid[]) zzn.clone();
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
