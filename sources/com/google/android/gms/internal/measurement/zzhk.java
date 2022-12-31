package com.google.android.gms.internal.measurement;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zza uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class zzhk {
    public static final zzhk zzA;
    public static final zzhk zzB;
    public static final zzhk zzC;
    public static final zzhk zzD;
    public static final zzhk zzE;
    public static final zzhk zzF;
    public static final zzhk zzG;
    public static final zzhk zzH;
    public static final zzhk zzI;
    public static final zzhk zzJ;
    public static final zzhk zzK;
    public static final zzhk zzL;
    public static final zzhk zzM;
    public static final zzhk zzN;
    public static final zzhk zzO;
    public static final zzhk zzP;
    public static final zzhk zzQ;
    public static final zzhk zzR;
    public static final zzhk zzS;
    public static final zzhk zzT;
    public static final zzhk zzU;
    public static final zzhk zzV;
    public static final zzhk zzW;
    public static final zzhk zzX;
    public static final zzhk zzY;
    public static final zzhk zza;
    private static final zzhk[] zzac;
    private static final /* synthetic */ zzhk[] zzad;
    public static final zzhk zzb;
    public static final zzhk zzc;
    public static final zzhk zzd;
    public static final zzhk zze;
    public static final zzhk zzf;
    public static final zzhk zzg;
    public static final zzhk zzh;
    public static final zzhk zzi;
    public static final zzhk zzj;
    public static final zzhk zzk;
    public static final zzhk zzl;
    public static final zzhk zzm;
    public static final zzhk zzn;
    public static final zzhk zzo;
    public static final zzhk zzp;
    public static final zzhk zzq;
    public static final zzhk zzr;
    public static final zzhk zzs;
    public static final zzhk zzt;
    public static final zzhk zzu;
    public static final zzhk zzv;
    public static final zzhk zzw;
    public static final zzhk zzx;
    public static final zzhk zzy;
    public static final zzhk zzz;
    private final zzid zzZ;
    private final int zzaa;
    private final Class<?> zzab;

    static {
        zzid zzidVar = zzid.zze;
        zza = new zzhk("DOUBLE", 0, 0, 1, zzidVar);
        zzid zzidVar2 = zzid.zzd;
        zzb = new zzhk("FLOAT", 1, 1, 1, zzidVar2);
        zzid zzidVar3 = zzid.zzc;
        zzc = new zzhk("INT64", 2, 2, 1, zzidVar3);
        zzd = new zzhk("UINT64", 3, 3, 1, zzidVar3);
        zzid zzidVar4 = zzid.zzb;
        zze = new zzhk("INT32", 4, 4, 1, zzidVar4);
        zzf = new zzhk("FIXED64", 5, 5, 1, zzidVar3);
        zzg = new zzhk("FIXED32", 6, 6, 1, zzidVar4);
        zzid zzidVar5 = zzid.zzf;
        zzh = new zzhk("BOOL", 7, 7, 1, zzidVar5);
        zzid zzidVar6 = zzid.zzg;
        zzi = new zzhk("STRING", 8, 8, 1, zzidVar6);
        zzid zzidVar7 = zzid.zzj;
        zzj = new zzhk("MESSAGE", 9, 9, 1, zzidVar7);
        zzid zzidVar8 = zzid.zzh;
        zzk = new zzhk("BYTES", 10, 10, 1, zzidVar8);
        zzl = new zzhk("UINT32", 11, 11, 1, zzidVar4);
        zzid zzidVar9 = zzid.zzi;
        zzm = new zzhk("ENUM", 12, 12, 1, zzidVar9);
        zzn = new zzhk("SFIXED32", 13, 13, 1, zzidVar4);
        zzo = new zzhk("SFIXED64", 14, 14, 1, zzidVar3);
        zzp = new zzhk("SINT32", 15, 15, 1, zzidVar4);
        zzq = new zzhk("SINT64", 16, 16, 1, zzidVar3);
        zzr = new zzhk("GROUP", 17, 17, 1, zzidVar7);
        zzs = new zzhk("DOUBLE_LIST", 18, 18, 2, zzidVar);
        zzt = new zzhk("FLOAT_LIST", 19, 19, 2, zzidVar2);
        zzu = new zzhk("INT64_LIST", 20, 20, 2, zzidVar3);
        zzv = new zzhk("UINT64_LIST", 21, 21, 2, zzidVar3);
        zzw = new zzhk("INT32_LIST", 22, 22, 2, zzidVar4);
        zzx = new zzhk("FIXED64_LIST", 23, 23, 2, zzidVar3);
        zzy = new zzhk("FIXED32_LIST", 24, 24, 2, zzidVar4);
        zzz = new zzhk("BOOL_LIST", 25, 25, 2, zzidVar5);
        zzA = new zzhk("STRING_LIST", 26, 26, 2, zzidVar6);
        zzB = new zzhk("MESSAGE_LIST", 27, 27, 2, zzidVar7);
        zzC = new zzhk("BYTES_LIST", 28, 28, 2, zzidVar8);
        zzD = new zzhk("UINT32_LIST", 29, 29, 2, zzidVar4);
        zzE = new zzhk("ENUM_LIST", 30, 30, 2, zzidVar9);
        zzF = new zzhk("SFIXED32_LIST", 31, 31, 2, zzidVar4);
        zzG = new zzhk("SFIXED64_LIST", 32, 32, 2, zzidVar3);
        zzH = new zzhk("SINT32_LIST", 33, 33, 2, zzidVar4);
        zzI = new zzhk("SINT64_LIST", 34, 34, 2, zzidVar3);
        zzJ = new zzhk("DOUBLE_LIST_PACKED", 35, 35, 3, zzidVar);
        zzK = new zzhk("FLOAT_LIST_PACKED", 36, 36, 3, zzidVar2);
        zzL = new zzhk("INT64_LIST_PACKED", 37, 37, 3, zzidVar3);
        zzM = new zzhk("UINT64_LIST_PACKED", 38, 38, 3, zzidVar3);
        zzN = new zzhk("INT32_LIST_PACKED", 39, 39, 3, zzidVar4);
        zzO = new zzhk("FIXED64_LIST_PACKED", 40, 40, 3, zzidVar3);
        zzP = new zzhk("FIXED32_LIST_PACKED", 41, 41, 3, zzidVar4);
        zzQ = new zzhk("BOOL_LIST_PACKED", 42, 42, 3, zzidVar5);
        zzR = new zzhk("UINT32_LIST_PACKED", 43, 43, 3, zzidVar4);
        zzS = new zzhk("ENUM_LIST_PACKED", 44, 44, 3, zzidVar9);
        zzT = new zzhk("SFIXED32_LIST_PACKED", 45, 45, 3, zzidVar4);
        zzid zzidVar10 = zzid.zzc;
        zzU = new zzhk("SFIXED64_LIST_PACKED", 46, 46, 3, zzidVar10);
        zzV = new zzhk("SINT32_LIST_PACKED", 47, 47, 3, zzidVar4);
        zzW = new zzhk("SINT64_LIST_PACKED", 48, 48, 3, zzidVar10);
        zzX = new zzhk("GROUP_LIST", 49, 49, 2, zzidVar7);
        zzY = new zzhk("MAP", 50, 50, 4, zzid.zza);
        zzad = new zzhk[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzr, zzs, zzt, zzu, zzv, zzw, zzx, zzy, zzz, zzA, zzB, zzC, zzD, zzE, zzF, zzG, zzH, zzI, zzJ, zzK, zzL, zzM, zzN, zzO, zzP, zzQ, zzR, zzS, zzT, zzU, zzV, zzW, zzX, zzY};
        zzhk[] values = values();
        zzac = new zzhk[values.length];
        for (zzhk zzhkVar : values) {
            zzac[zzhkVar.zzaa] = zzhkVar;
        }
    }

    private zzhk(String str, int i2, int i3, int i4, zzid zzidVar) {
        this.zzaa = i3;
        this.zzZ = zzidVar;
        zzid zzidVar2 = zzid.zza;
        int i5 = i4 - 1;
        if (i5 == 1) {
            this.zzab = zzidVar.zza();
        } else if (i5 != 3) {
            this.zzab = null;
        } else {
            this.zzab = zzidVar.zza();
        }
        if (i4 == 1) {
            zzidVar.ordinal();
        }
    }

    public static zzhk[] values() {
        return (zzhk[]) zzad.clone();
    }

    public final int zza() {
        return this.zzaa;
    }
}
