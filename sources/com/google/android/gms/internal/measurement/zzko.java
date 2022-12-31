package com.google.android.gms.internal.measurement;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzc uses external variables
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
public final class zzko {
    public static final zzko zza;
    public static final zzko zzb;
    public static final zzko zzc;
    public static final zzko zzd;
    public static final zzko zze;
    public static final zzko zzf;
    public static final zzko zzg;
    public static final zzko zzh;
    public static final zzko zzi;
    public static final zzko zzj;
    public static final zzko zzk;
    public static final zzko zzl;
    public static final zzko zzm;
    public static final zzko zzn;
    public static final zzko zzo;
    public static final zzko zzp;
    public static final zzko zzq;
    public static final zzko zzr;
    private static final /* synthetic */ zzko[] zzt;
    private final zzkp zzs;

    static {
        zzko zzkoVar = new zzko("DOUBLE", 0, zzkp.DOUBLE, 1);
        zza = zzkoVar;
        zzko zzkoVar2 = new zzko("FLOAT", 1, zzkp.FLOAT, 5);
        zzb = zzkoVar2;
        zzkp zzkpVar = zzkp.LONG;
        zzko zzkoVar3 = new zzko("INT64", 2, zzkpVar, 0);
        zzc = zzkoVar3;
        zzko zzkoVar4 = new zzko("UINT64", 3, zzkpVar, 0);
        zzd = zzkoVar4;
        zzkp zzkpVar2 = zzkp.INT;
        zzko zzkoVar5 = new zzko("INT32", 4, zzkpVar2, 0);
        zze = zzkoVar5;
        zzko zzkoVar6 = new zzko("FIXED64", 5, zzkpVar, 1);
        zzf = zzkoVar6;
        zzko zzkoVar7 = new zzko("FIXED32", 6, zzkpVar2, 5);
        zzg = zzkoVar7;
        zzko zzkoVar8 = new zzko("BOOL", 7, zzkp.BOOLEAN, 0);
        zzh = zzkoVar8;
        zzko zzkoVar9 = new zzko("STRING", 8, zzkp.STRING, 2);
        zzi = zzkoVar9;
        zzkp zzkpVar3 = zzkp.MESSAGE;
        zzko zzkoVar10 = new zzko("GROUP", 9, zzkpVar3, 3);
        zzj = zzkoVar10;
        zzko zzkoVar11 = new zzko("MESSAGE", 10, zzkpVar3, 2);
        zzk = zzkoVar11;
        zzko zzkoVar12 = new zzko("BYTES", 11, zzkp.BYTE_STRING, 2);
        zzl = zzkoVar12;
        zzko zzkoVar13 = new zzko("UINT32", 12, zzkpVar2, 0);
        zzm = zzkoVar13;
        zzko zzkoVar14 = new zzko("ENUM", 13, zzkp.ENUM, 0);
        zzn = zzkoVar14;
        zzko zzkoVar15 = new zzko("SFIXED32", 14, zzkpVar2, 5);
        zzo = zzkoVar15;
        zzko zzkoVar16 = new zzko("SFIXED64", 15, zzkpVar, 1);
        zzp = zzkoVar16;
        zzko zzkoVar17 = new zzko("SINT32", 16, zzkpVar2, 0);
        zzq = zzkoVar17;
        zzko zzkoVar18 = new zzko("SINT64", 17, zzkpVar, 0);
        zzr = zzkoVar18;
        zzt = new zzko[]{zzkoVar, zzkoVar2, zzkoVar3, zzkoVar4, zzkoVar5, zzkoVar6, zzkoVar7, zzkoVar8, zzkoVar9, zzkoVar10, zzkoVar11, zzkoVar12, zzkoVar13, zzkoVar14, zzkoVar15, zzkoVar16, zzkoVar17, zzkoVar18};
    }

    private zzko(String str, int i2, zzkp zzkpVar, int i3) {
        this.zzs = zzkpVar;
    }

    public static zzko[] values() {
        return (zzko[]) zzt.clone();
    }

    public final zzkp zza() {
        return this.zzs;
    }
}
