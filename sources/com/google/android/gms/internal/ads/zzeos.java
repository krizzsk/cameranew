package com.google.android.gms.internal.ads;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zziwe uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public class zzeos {
    public static final zzeos zziwc;
    public static final zzeos zziwd;
    public static final zzeos zziwe;
    public static final zzeos zziwf;
    public static final zzeos zziwg;
    public static final zzeos zziwh;
    public static final zzeos zziwi;
    public static final zzeos zziwj;
    public static final zzeos zziwk;
    public static final zzeos zziwl;
    public static final zzeos zziwm;
    public static final zzeos zziwn;
    public static final zzeos zziwo;
    public static final zzeos zziwp;
    public static final zzeos zziwq;
    public static final zzeos zziwr;
    public static final zzeos zziws;
    public static final zzeos zziwt;
    private static final /* synthetic */ zzeos[] zziww;
    private final zzeov zziwu;
    private final int zziwv;

    static {
        zzeos zzeosVar = new zzeos("DOUBLE", 0, zzeov.DOUBLE, 1);
        zziwc = zzeosVar;
        zzeos zzeosVar2 = new zzeos("FLOAT", 1, zzeov.FLOAT, 5);
        zziwd = zzeosVar2;
        zzeov zzeovVar = zzeov.LONG;
        zzeos zzeosVar3 = new zzeos("INT64", 2, zzeovVar, 0);
        zziwe = zzeosVar3;
        zzeos zzeosVar4 = new zzeos("UINT64", 3, zzeovVar, 0);
        zziwf = zzeosVar4;
        zzeov zzeovVar2 = zzeov.INT;
        zzeos zzeosVar5 = new zzeos("INT32", 4, zzeovVar2, 0);
        zziwg = zzeosVar5;
        zzeos zzeosVar6 = new zzeos("FIXED64", 5, zzeovVar, 1);
        zziwh = zzeosVar6;
        zzeos zzeosVar7 = new zzeos("FIXED32", 6, zzeovVar2, 5);
        zziwi = zzeosVar7;
        zzeos zzeosVar8 = new zzeos("BOOL", 7, zzeov.BOOLEAN, 0);
        zziwj = zzeosVar8;
        final zzeov zzeovVar3 = zzeov.STRING;
        zzeos zzeosVar9 = new zzeos("STRING", 8, zzeovVar3, 2) { // from class: com.google.android.gms.internal.ads.zzeor
        };
        zziwk = zzeosVar9;
        final zzeov zzeovVar4 = zzeov.MESSAGE;
        zzeos zzeosVar10 = new zzeos("GROUP", 9, zzeovVar4, 3) { // from class: com.google.android.gms.internal.ads.zzeou
        };
        zziwl = zzeosVar10;
        zzeos zzeosVar11 = new zzeos("MESSAGE", 10, zzeovVar4, 2) { // from class: com.google.android.gms.internal.ads.zzeot
        };
        zziwm = zzeosVar11;
        final zzeov zzeovVar5 = zzeov.BYTE_STRING;
        zzeos zzeosVar12 = new zzeos("BYTES", 11, zzeovVar5, 2) { // from class: com.google.android.gms.internal.ads.zzeow
        };
        zziwn = zzeosVar12;
        zzeos zzeosVar13 = new zzeos("UINT32", 12, zzeovVar2, 0);
        zziwo = zzeosVar13;
        zzeos zzeosVar14 = new zzeos("ENUM", 13, zzeov.ENUM, 0);
        zziwp = zzeosVar14;
        zzeos zzeosVar15 = new zzeos("SFIXED32", 14, zzeovVar2, 5);
        zziwq = zzeosVar15;
        zzeos zzeosVar16 = new zzeos("SFIXED64", 15, zzeovVar, 1);
        zziwr = zzeosVar16;
        zzeos zzeosVar17 = new zzeos("SINT32", 16, zzeovVar2, 0);
        zziws = zzeosVar17;
        zzeos zzeosVar18 = new zzeos("SINT64", 17, zzeovVar, 0);
        zziwt = zzeosVar18;
        zziww = new zzeos[]{zzeosVar, zzeosVar2, zzeosVar3, zzeosVar4, zzeosVar5, zzeosVar6, zzeosVar7, zzeosVar8, zzeosVar9, zzeosVar10, zzeosVar11, zzeosVar12, zzeosVar13, zzeosVar14, zzeosVar15, zzeosVar16, zzeosVar17, zzeosVar18};
    }

    private zzeos(String str, int i2, zzeov zzeovVar, int i3) {
        this.zziwu = zzeovVar;
        this.zziwv = i3;
    }

    public static zzeos[] values() {
        return (zzeos[]) zziww.clone();
    }

    public final zzeov zzbli() {
        return this.zziwu;
    }

    public final int zzblj() {
        return this.zziwv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeos(String str, int i2, zzeov zzeovVar, int i3, zzeop zzeopVar) {
        this(str, i2, zzeovVar, i3);
    }
}
