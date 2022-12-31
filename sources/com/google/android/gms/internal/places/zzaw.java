package com.google.android.gms.internal.places;

import java.lang.reflect.Type;
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzfn uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class zzaw {
    private static final zzaw zzfn;
    private static final zzaw zzfo;
    private static final zzaw zzfp;
    private static final zzaw zzfq;
    private static final zzaw zzfr;
    private static final zzaw zzfs;
    private static final zzaw zzft;
    private static final zzaw zzfu;
    private static final zzaw zzfv;
    private static final zzaw zzfw;
    private static final zzaw zzfx;
    private static final zzaw zzfy;
    private static final zzaw zzfz;
    private static final zzaw zzga;
    private static final zzaw zzgb;
    private static final zzaw zzgc;
    private static final zzaw zzgd;
    private static final zzaw zzge;
    private static final zzaw zzgf;
    private static final zzaw zzgg;
    private static final zzaw zzgh;
    private static final zzaw zzgi;
    private static final zzaw zzgj;
    private static final zzaw zzgk;
    private static final zzaw zzgl;
    private static final zzaw zzgm;
    private static final zzaw zzgn;
    private static final zzaw zzgo;
    private static final zzaw zzgp;
    private static final zzaw zzgq;
    private static final zzaw zzgr;
    private static final zzaw zzgs;
    private static final zzaw zzgt;
    private static final zzaw zzgu;
    private static final zzaw zzgv;
    public static final zzaw zzgw;
    private static final zzaw zzgx;
    private static final zzaw zzgy;
    private static final zzaw zzgz;
    private static final zzaw zzha;
    private static final zzaw zzhb;
    private static final zzaw zzhc;
    private static final zzaw zzhd;
    private static final zzaw zzhe;
    private static final zzaw zzhf;
    private static final zzaw zzhg;
    private static final zzaw zzhh;
    private static final zzaw zzhi;
    public static final zzaw zzhj;
    private static final zzaw zzhk;
    private static final zzaw zzhl;
    private static final zzaw[] zzhq;
    private static final Type[] zzhr;
    private static final /* synthetic */ zzaw[] zzhs;
    private final int id;
    private final zzbm zzhm;
    private final zzay zzhn;
    private final Class<?> zzho;
    private final boolean zzhp;

    static {
        zzay zzayVar = zzay.SCALAR;
        zzbm zzbmVar = zzbm.zzjj;
        zzfn = new zzaw("DOUBLE", 0, 0, zzayVar, zzbmVar);
        zzbm zzbmVar2 = zzbm.zzji;
        zzfo = new zzaw("FLOAT", 1, 1, zzayVar, zzbmVar2);
        zzbm zzbmVar3 = zzbm.zzjh;
        zzfp = new zzaw("INT64", 2, 2, zzayVar, zzbmVar3);
        zzfq = new zzaw("UINT64", 3, 3, zzayVar, zzbmVar3);
        zzbm zzbmVar4 = zzbm.zzjg;
        zzfr = new zzaw("INT32", 4, 4, zzayVar, zzbmVar4);
        zzfs = new zzaw("FIXED64", 5, 5, zzayVar, zzbmVar3);
        zzft = new zzaw("FIXED32", 6, 6, zzayVar, zzbmVar4);
        zzbm zzbmVar5 = zzbm.zzjk;
        zzfu = new zzaw("BOOL", 7, 7, zzayVar, zzbmVar5);
        zzbm zzbmVar6 = zzbm.zzjl;
        zzfv = new zzaw("STRING", 8, 8, zzayVar, zzbmVar6);
        zzbm zzbmVar7 = zzbm.zzjo;
        zzfw = new zzaw("MESSAGE", 9, 9, zzayVar, zzbmVar7);
        zzbm zzbmVar8 = zzbm.zzjm;
        zzfx = new zzaw("BYTES", 10, 10, zzayVar, zzbmVar8);
        zzfy = new zzaw("UINT32", 11, 11, zzayVar, zzbmVar4);
        zzbm zzbmVar9 = zzbm.zzjn;
        zzfz = new zzaw("ENUM", 12, 12, zzayVar, zzbmVar9);
        zzga = new zzaw("SFIXED32", 13, 13, zzayVar, zzbmVar4);
        zzgb = new zzaw("SFIXED64", 14, 14, zzayVar, zzbmVar3);
        zzgc = new zzaw("SINT32", 15, 15, zzayVar, zzbmVar4);
        zzgd = new zzaw("SINT64", 16, 16, zzayVar, zzbmVar3);
        zzge = new zzaw("GROUP", 17, 17, zzayVar, zzbmVar7);
        zzay zzayVar2 = zzay.VECTOR;
        zzgf = new zzaw("DOUBLE_LIST", 18, 18, zzayVar2, zzbmVar);
        zzgg = new zzaw("FLOAT_LIST", 19, 19, zzayVar2, zzbmVar2);
        zzgh = new zzaw("INT64_LIST", 20, 20, zzayVar2, zzbmVar3);
        zzgi = new zzaw("UINT64_LIST", 21, 21, zzayVar2, zzbmVar3);
        zzgj = new zzaw("INT32_LIST", 22, 22, zzayVar2, zzbmVar4);
        zzgk = new zzaw("FIXED64_LIST", 23, 23, zzayVar2, zzbmVar3);
        zzgl = new zzaw("FIXED32_LIST", 24, 24, zzayVar2, zzbmVar4);
        zzgm = new zzaw("BOOL_LIST", 25, 25, zzayVar2, zzbmVar5);
        zzgn = new zzaw("STRING_LIST", 26, 26, zzayVar2, zzbmVar6);
        zzgo = new zzaw("MESSAGE_LIST", 27, 27, zzayVar2, zzbmVar7);
        zzgp = new zzaw("BYTES_LIST", 28, 28, zzayVar2, zzbmVar8);
        zzgq = new zzaw("UINT32_LIST", 29, 29, zzayVar2, zzbmVar4);
        zzgr = new zzaw("ENUM_LIST", 30, 30, zzayVar2, zzbmVar9);
        zzgs = new zzaw("SFIXED32_LIST", 31, 31, zzayVar2, zzbmVar4);
        zzgt = new zzaw("SFIXED64_LIST", 32, 32, zzayVar2, zzbmVar3);
        zzgu = new zzaw("SINT32_LIST", 33, 33, zzayVar2, zzbmVar4);
        zzgv = new zzaw("SINT64_LIST", 34, 34, zzayVar2, zzbmVar3);
        zzay zzayVar3 = zzay.PACKED_VECTOR;
        zzgw = new zzaw("DOUBLE_LIST_PACKED", 35, 35, zzayVar3, zzbmVar);
        zzgx = new zzaw("FLOAT_LIST_PACKED", 36, 36, zzayVar3, zzbmVar2);
        zzgy = new zzaw("INT64_LIST_PACKED", 37, 37, zzayVar3, zzbmVar3);
        zzgz = new zzaw("UINT64_LIST_PACKED", 38, 38, zzayVar3, zzbmVar3);
        zzha = new zzaw("INT32_LIST_PACKED", 39, 39, zzayVar3, zzbmVar4);
        zzhb = new zzaw("FIXED64_LIST_PACKED", 40, 40, zzayVar3, zzbmVar3);
        zzhc = new zzaw("FIXED32_LIST_PACKED", 41, 41, zzayVar3, zzbmVar4);
        zzhd = new zzaw("BOOL_LIST_PACKED", 42, 42, zzayVar3, zzbmVar5);
        zzhe = new zzaw("UINT32_LIST_PACKED", 43, 43, zzayVar3, zzbmVar4);
        zzhf = new zzaw("ENUM_LIST_PACKED", 44, 44, zzayVar3, zzbmVar9);
        zzhg = new zzaw("SFIXED32_LIST_PACKED", 45, 45, zzayVar3, zzbmVar4);
        zzbm zzbmVar10 = zzbm.zzjh;
        zzhh = new zzaw("SFIXED64_LIST_PACKED", 46, 46, zzayVar3, zzbmVar10);
        zzhi = new zzaw("SINT32_LIST_PACKED", 47, 47, zzayVar3, zzbm.zzjg);
        zzhj = new zzaw("SINT64_LIST_PACKED", 48, 48, zzayVar3, zzbmVar10);
        zzhk = new zzaw("GROUP_LIST", 49, 49, zzayVar2, zzbmVar7);
        zzhl = new zzaw("MAP", 50, 50, zzay.MAP, zzbm.zzjf);
        zzhs = new zzaw[]{zzfn, zzfo, zzfp, zzfq, zzfr, zzfs, zzft, zzfu, zzfv, zzfw, zzfx, zzfy, zzfz, zzga, zzgb, zzgc, zzgd, zzge, zzgf, zzgg, zzgh, zzgi, zzgj, zzgk, zzgl, zzgm, zzgn, zzgo, zzgp, zzgq, zzgr, zzgs, zzgt, zzgu, zzgv, zzgw, zzgx, zzgy, zzgz, zzha, zzhb, zzhc, zzhd, zzhe, zzhf, zzhg, zzhh, zzhi, zzhj, zzhk, zzhl};
        zzhr = new Type[0];
        zzaw[] values = values();
        zzhq = new zzaw[values.length];
        for (zzaw zzawVar : values) {
            zzhq[zzawVar.id] = zzawVar;
        }
    }

    private zzaw(String str, int i2, int i3, zzay zzayVar, zzbm zzbmVar) {
        int i4;
        this.id = i3;
        this.zzhn = zzayVar;
        this.zzhm = zzbmVar;
        int i5 = zzaz.zzhz[zzayVar.ordinal()];
        boolean z = true;
        if (i5 == 1) {
            this.zzho = zzbmVar.zzbw();
        } else if (i5 != 2) {
            this.zzho = null;
        } else {
            this.zzho = zzbmVar.zzbw();
        }
        this.zzhp = (zzayVar != zzay.SCALAR || (i4 = zzaz.zzia[zzbmVar.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : false;
    }

    public static zzaw[] values() {
        return (zzaw[]) zzhs.clone();
    }

    public final int id() {
        return this.id;
    }
}
