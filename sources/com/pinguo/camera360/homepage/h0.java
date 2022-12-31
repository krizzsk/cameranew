package com.pinguo.camera360.homepage;
/* compiled from: FunctionItemInfo.kt */
/* loaded from: classes3.dex */
public final class h0 {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f6780d;

    /* renamed from: e  reason: collision with root package name */
    private String f6781e;

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (r4 == true) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h0(java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6) {
        /*
            r1 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.s.h(r2, r0)
            r1.<init>()
            r1.a = r2
            r1.b = r3
            r1.c = r4
            r1.f6780d = r5
            r1.f6781e = r6
            r2 = 1
            r3 = 0
            if (r6 != 0) goto L18
        L16:
            r4 = 0
            goto L24
        L18:
            int r4 = r6.length()
            if (r4 <= 0) goto L20
            r4 = 1
            goto L21
        L20:
            r4 = 0
        L21:
            if (r4 != r2) goto L16
            r4 = 1
        L24:
            if (r4 == 0) goto L42
            java.lang.String r4 = r1.f6781e
            if (r4 != 0) goto L2c
        L2a:
            r2 = 0
            goto L36
        L2c:
            r5 = 35
            r6 = 2
            r0 = 0
            boolean r4 = kotlin.text.l.u0(r4, r5, r3, r6, r0)
            if (r4 != r2) goto L2a
        L36:
            if (r2 != 0) goto L42
            java.lang.String r2 = r1.f6781e
            java.lang.String r3 = "#"
            java.lang.String r2 = kotlin.jvm.internal.s.q(r3, r2)
            r1.f6781e = r2
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.camera360.homepage.h0.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final String a() {
        return this.f6780d;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.f6781e;
    }

    public final String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h0) {
            h0 h0Var = (h0) obj;
            return kotlin.jvm.internal.s.c(this.a, h0Var.a) && kotlin.jvm.internal.s.c(this.b, h0Var.b) && kotlin.jvm.internal.s.c(this.c, h0Var.c) && kotlin.jvm.internal.s.c(this.f6780d, h0Var.f6780d) && kotlin.jvm.internal.s.c(this.f6781e, h0Var.f6781e);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f6780d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f6781e;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "BottomButtonInfo(type=" + this.a + ", bgPath=" + ((Object) this.b) + ", iconPath=" + ((Object) this.c) + ", bgColor=" + ((Object) this.f6780d) + ", textColor=" + ((Object) this.f6781e) + ')';
    }

    public /* synthetic */ h0(String str, String str2, String str3, String str4, String str5, int i2, kotlin.jvm.internal.o oVar) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5);
    }
}
