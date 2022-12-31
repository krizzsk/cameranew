package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzint uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzekv {
    private static final zzekv zzint;
    private static final zzekv zzinu;
    private static final zzekv zzinv;
    private static final zzekv zzinw;
    private static final zzekv zzinx;
    private static final zzekv zziny;
    private static final zzekv zzinz;
    private static final zzekv zzioa;
    private static final zzekv zziob;
    private static final zzekv zzioc;
    private static final zzekv zziod;
    private static final zzekv zzioe;
    private static final zzekv zziof;
    private static final zzekv zziog;
    private static final zzekv zzioh;
    private static final zzekv zzioi;
    private static final zzekv zzioj;
    private static final zzekv zziok;
    private static final zzekv zziol;
    private static final zzekv zziom;
    private static final zzekv zzion;
    private static final zzekv zzioo;
    private static final zzekv zziop;
    private static final zzekv zzioq;
    private static final zzekv zzior;
    private static final zzekv zzios;
    private static final zzekv zziot;
    private static final zzekv zziou;
    private static final zzekv zziov;
    private static final zzekv zziow;
    private static final zzekv zziox;
    private static final zzekv zzioy;
    private static final zzekv zzioz;
    private static final zzekv zzipa;
    private static final zzekv zzipb;
    public static final zzekv zzipc;
    private static final zzekv zzipd;
    private static final zzekv zzipe;
    private static final zzekv zzipf;
    private static final zzekv zzipg;
    private static final zzekv zziph;
    private static final zzekv zzipi;
    private static final zzekv zzipj;
    private static final zzekv zzipk;
    private static final zzekv zzipl;
    private static final zzekv zzipm;
    private static final zzekv zzipn;
    private static final zzekv zzipo;
    public static final zzekv zzipp;
    private static final zzekv zzipq;
    private static final zzekv zzipr;
    private static final zzekv[] zzipw;
    private static final Type[] zzipx;
    private static final /* synthetic */ zzekv[] zzipy;
    private final int id;
    private final zzelq zzips;
    private final zzekx zzipt;
    private final Class<?> zzipu;
    private final boolean zzipv;

    static {
        zzekx zzekxVar = zzekx.SCALAR;
        zzelq zzelqVar = zzelq.zzirk;
        zzint = new zzekv("DOUBLE", 0, 0, zzekxVar, zzelqVar);
        zzelq zzelqVar2 = zzelq.zzirj;
        zzinu = new zzekv("FLOAT", 1, 1, zzekxVar, zzelqVar2);
        zzelq zzelqVar3 = zzelq.zziri;
        zzinv = new zzekv("INT64", 2, 2, zzekxVar, zzelqVar3);
        zzinw = new zzekv("UINT64", 3, 3, zzekxVar, zzelqVar3);
        zzelq zzelqVar4 = zzelq.zzirh;
        zzinx = new zzekv("INT32", 4, 4, zzekxVar, zzelqVar4);
        zziny = new zzekv("FIXED64", 5, 5, zzekxVar, zzelqVar3);
        zzinz = new zzekv("FIXED32", 6, 6, zzekxVar, zzelqVar4);
        zzelq zzelqVar5 = zzelq.zzirl;
        zzioa = new zzekv("BOOL", 7, 7, zzekxVar, zzelqVar5);
        zzelq zzelqVar6 = zzelq.zzirm;
        zziob = new zzekv("STRING", 8, 8, zzekxVar, zzelqVar6);
        zzelq zzelqVar7 = zzelq.zzirp;
        zzioc = new zzekv("MESSAGE", 9, 9, zzekxVar, zzelqVar7);
        zzelq zzelqVar8 = zzelq.zzirn;
        zziod = new zzekv("BYTES", 10, 10, zzekxVar, zzelqVar8);
        zzioe = new zzekv("UINT32", 11, 11, zzekxVar, zzelqVar4);
        zzelq zzelqVar9 = zzelq.zziro;
        zziof = new zzekv("ENUM", 12, 12, zzekxVar, zzelqVar9);
        zziog = new zzekv("SFIXED32", 13, 13, zzekxVar, zzelqVar4);
        zzioh = new zzekv("SFIXED64", 14, 14, zzekxVar, zzelqVar3);
        zzioi = new zzekv("SINT32", 15, 15, zzekxVar, zzelqVar4);
        zzioj = new zzekv("SINT64", 16, 16, zzekxVar, zzelqVar3);
        zziok = new zzekv("GROUP", 17, 17, zzekxVar, zzelqVar7);
        zzekx zzekxVar2 = zzekx.VECTOR;
        zziol = new zzekv("DOUBLE_LIST", 18, 18, zzekxVar2, zzelqVar);
        zziom = new zzekv("FLOAT_LIST", 19, 19, zzekxVar2, zzelqVar2);
        zzion = new zzekv("INT64_LIST", 20, 20, zzekxVar2, zzelqVar3);
        zzioo = new zzekv("UINT64_LIST", 21, 21, zzekxVar2, zzelqVar3);
        zziop = new zzekv("INT32_LIST", 22, 22, zzekxVar2, zzelqVar4);
        zzioq = new zzekv("FIXED64_LIST", 23, 23, zzekxVar2, zzelqVar3);
        zzior = new zzekv("FIXED32_LIST", 24, 24, zzekxVar2, zzelqVar4);
        zzios = new zzekv("BOOL_LIST", 25, 25, zzekxVar2, zzelqVar5);
        zziot = new zzekv("STRING_LIST", 26, 26, zzekxVar2, zzelqVar6);
        zziou = new zzekv("MESSAGE_LIST", 27, 27, zzekxVar2, zzelqVar7);
        zziov = new zzekv("BYTES_LIST", 28, 28, zzekxVar2, zzelqVar8);
        zziow = new zzekv("UINT32_LIST", 29, 29, zzekxVar2, zzelqVar4);
        zziox = new zzekv("ENUM_LIST", 30, 30, zzekxVar2, zzelqVar9);
        zzioy = new zzekv("SFIXED32_LIST", 31, 31, zzekxVar2, zzelqVar4);
        zzioz = new zzekv("SFIXED64_LIST", 32, 32, zzekxVar2, zzelqVar3);
        zzipa = new zzekv("SINT32_LIST", 33, 33, zzekxVar2, zzelqVar4);
        zzipb = new zzekv("SINT64_LIST", 34, 34, zzekxVar2, zzelqVar3);
        zzekx zzekxVar3 = zzekx.PACKED_VECTOR;
        zzipc = new zzekv("DOUBLE_LIST_PACKED", 35, 35, zzekxVar3, zzelqVar);
        zzipd = new zzekv("FLOAT_LIST_PACKED", 36, 36, zzekxVar3, zzelqVar2);
        zzipe = new zzekv("INT64_LIST_PACKED", 37, 37, zzekxVar3, zzelqVar3);
        zzipf = new zzekv("UINT64_LIST_PACKED", 38, 38, zzekxVar3, zzelqVar3);
        zzipg = new zzekv("INT32_LIST_PACKED", 39, 39, zzekxVar3, zzelqVar4);
        zziph = new zzekv("FIXED64_LIST_PACKED", 40, 40, zzekxVar3, zzelqVar3);
        zzipi = new zzekv("FIXED32_LIST_PACKED", 41, 41, zzekxVar3, zzelqVar4);
        zzipj = new zzekv("BOOL_LIST_PACKED", 42, 42, zzekxVar3, zzelqVar5);
        zzipk = new zzekv("UINT32_LIST_PACKED", 43, 43, zzekxVar3, zzelqVar4);
        zzipl = new zzekv("ENUM_LIST_PACKED", 44, 44, zzekxVar3, zzelqVar9);
        zzipm = new zzekv("SFIXED32_LIST_PACKED", 45, 45, zzekxVar3, zzelqVar4);
        zzelq zzelqVar10 = zzelq.zziri;
        zzipn = new zzekv("SFIXED64_LIST_PACKED", 46, 46, zzekxVar3, zzelqVar10);
        zzipo = new zzekv("SINT32_LIST_PACKED", 47, 47, zzekxVar3, zzelq.zzirh);
        zzipp = new zzekv("SINT64_LIST_PACKED", 48, 48, zzekxVar3, zzelqVar10);
        zzipq = new zzekv("GROUP_LIST", 49, 49, zzekxVar2, zzelqVar7);
        zzipr = new zzekv("MAP", 50, 50, zzekx.MAP, zzelq.zzirg);
        zzipy = new zzekv[]{zzint, zzinu, zzinv, zzinw, zzinx, zziny, zzinz, zzioa, zziob, zzioc, zziod, zzioe, zziof, zziog, zzioh, zzioi, zzioj, zziok, zziol, zziom, zzion, zzioo, zziop, zzioq, zzior, zzios, zziot, zziou, zziov, zziow, zziox, zzioy, zzioz, zzipa, zzipb, zzipc, zzipd, zzipe, zzipf, zzipg, zziph, zzipi, zzipj, zzipk, zzipl, zzipm, zzipn, zzipo, zzipp, zzipq, zzipr};
        zzipx = new Type[0];
        zzekv[] values = values();
        zzipw = new zzekv[values.length];
        for (zzekv zzekvVar : values) {
            zzipw[zzekvVar.id] = zzekvVar;
        }
    }

    private zzekv(String str, int i2, int i3, zzekx zzekxVar, zzelq zzelqVar) {
        int i4;
        this.id = i3;
        this.zzipt = zzekxVar;
        this.zzips = zzelqVar;
        int i5 = zzeky.zziqf[zzekxVar.ordinal()];
        boolean z = true;
        if (i5 == 1) {
            this.zzipu = zzelqVar.zzbjk();
        } else if (i5 != 2) {
            this.zzipu = null;
        } else {
            this.zzipu = zzelqVar.zzbjk();
        }
        this.zzipv = (zzekxVar != zzekx.SCALAR || (i4 = zzeky.zziqg[zzelqVar.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : false;
    }

    public static zzekv[] values() {
        return (zzekv[]) zzipy.clone();
    }

    public final int id() {
        return this.id;
    }
}
