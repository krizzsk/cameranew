package com.tapjoy.internal;

import com.tapjoy.internal.ej;
/* loaded from: classes3.dex */
public abstract class ef extends ej {
    /* JADX INFO: Access modifiers changed from: protected */
    public ef(Class cls) {
        super(eg.VARINT, cls);
    }

    @Override // com.tapjoy.internal.ej
    public final /* bridge */ /* synthetic */ int a(Object obj) {
        return el.a(((em) obj).a());
    }

    public abstract em a(int i2);

    @Override // com.tapjoy.internal.ej
    public final /* synthetic */ void a(el elVar, Object obj) {
        elVar.c(((em) obj).a());
    }

    @Override // com.tapjoy.internal.ej
    public final /* synthetic */ Object a(ek ekVar) {
        int d2 = ekVar.d();
        em a = a(d2);
        if (a != null) {
            return a;
        }
        throw new ej.a(d2, this.a);
    }
}
