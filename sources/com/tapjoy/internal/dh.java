package com.tapjoy.internal;

import com.tapjoy.internal.de;
import java.util.Collections;
/* loaded from: classes3.dex */
public final class dh implements co, de.a {
    private static dh c;
    public float a = 0.0f;
    public cp b;

    /* renamed from: d  reason: collision with root package name */
    private final cq f7366d;

    /* renamed from: e  reason: collision with root package name */
    private final cn f7367e;

    /* renamed from: f  reason: collision with root package name */
    private dd f7368f;

    private dh(cq cqVar, cn cnVar) {
        this.f7366d = cqVar;
        this.f7367e = cnVar;
    }

    public static dh a() {
        if (c == null) {
            c = new dh(new cq(), new cn());
        }
        return c;
    }

    @Override // com.tapjoy.internal.co
    public final void a(float f2) {
        this.a = f2;
        if (this.f7368f == null) {
            this.f7368f = dd.a();
        }
        for (cz czVar : Collections.unmodifiableCollection(this.f7368f.b)) {
            czVar.c.a(f2);
        }
    }

    @Override // com.tapjoy.internal.de.a
    public final void a(boolean z) {
        dv.a();
        if (z) {
            dv.b();
        } else {
            dv.c();
        }
    }
}
