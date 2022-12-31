package us.pinguo.edit2020.model.editgoto;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: GotoType.kt */
/* loaded from: classes4.dex */
public final class b {
    private final EditGotoType a;
    private final String b;
    private final String c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10567d;

    public b(EditGotoType editGotoType, String str, String str2, String str3) {
        s.h(editGotoType, "editGotoType");
        this.a = editGotoType;
        this.b = str;
        this.c = str2;
        this.f10567d = str3;
    }

    public final EditGotoType a() {
        return this.a;
    }

    public final String b() {
        return this.f10567d;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public /* synthetic */ b(EditGotoType editGotoType, String str, String str2, String str3, int i2, o oVar) {
        this(editGotoType, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3);
    }
}
