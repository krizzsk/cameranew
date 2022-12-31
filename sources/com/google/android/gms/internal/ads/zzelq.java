package com.google.android.gms.internal.ads;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzirh uses external variables
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
public final class zzelq {
    public static final zzelq zzirg;
    public static final zzelq zzirh;
    public static final zzelq zziri;
    public static final zzelq zzirj;
    public static final zzelq zzirk;
    public static final zzelq zzirl;
    public static final zzelq zzirm;
    public static final zzelq zzirn;
    public static final zzelq zziro;
    public static final zzelq zzirp;
    private static final /* synthetic */ zzelq[] zzirt;
    private final Class<?> zzirq;
    private final Class<?> zzirr;
    private final Object zzirs;

    static {
        zzelq zzelqVar = new zzelq("VOID", 0, Void.class, Void.class, null);
        zzirg = zzelqVar;
        Class cls = Integer.TYPE;
        zzelq zzelqVar2 = new zzelq("INT", 1, cls, Integer.class, 0);
        zzirh = zzelqVar2;
        zzelq zzelqVar3 = new zzelq("LONG", 2, Long.TYPE, Long.class, 0L);
        zziri = zzelqVar3;
        zzelq zzelqVar4 = new zzelq("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzirj = zzelqVar4;
        zzelq zzelqVar5 = new zzelq("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        zzirk = zzelqVar5;
        zzelq zzelqVar6 = new zzelq("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzirl = zzelqVar6;
        zzelq zzelqVar7 = new zzelq("STRING", 6, String.class, String.class, "");
        zzirm = zzelqVar7;
        zzelq zzelqVar8 = new zzelq("BYTE_STRING", 7, zzejr.class, zzejr.class, zzejr.zzilz);
        zzirn = zzelqVar8;
        zzelq zzelqVar9 = new zzelq("ENUM", 8, cls, Integer.class, null);
        zziro = zzelqVar9;
        zzelq zzelqVar10 = new zzelq("MESSAGE", 9, Object.class, Object.class, null);
        zzirp = zzelqVar10;
        zzirt = new zzelq[]{zzelqVar, zzelqVar2, zzelqVar3, zzelqVar4, zzelqVar5, zzelqVar6, zzelqVar7, zzelqVar8, zzelqVar9, zzelqVar10};
    }

    private zzelq(String str, int i2, Class cls, Class cls2, Object obj) {
        this.zzirq = cls;
        this.zzirr = cls2;
        this.zzirs = obj;
    }

    public static zzelq[] values() {
        return (zzelq[]) zzirt.clone();
    }

    public final Class<?> zzbjk() {
        return this.zzirr;
    }
}
