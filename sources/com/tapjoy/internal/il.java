package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import java.util.Map;
/* loaded from: classes3.dex */
public final class il extends ii {
    private final fa c;

    /* renamed from: d  reason: collision with root package name */
    private final eu f7710d;

    /* renamed from: e  reason: collision with root package name */
    private final fh f7711e;

    /* renamed from: f  reason: collision with root package name */
    private final String f7712f;

    private il(fa faVar, eu euVar, fh fhVar, String str) {
        this.c = faVar;
        this.f7710d = euVar;
        this.f7711e = fhVar;
        this.f7712f = str;
    }

    @Override // com.tapjoy.internal.ca
    public final String c() {
        return "api/v1/tokens";
    }

    @Override // com.tapjoy.internal.ii, com.tapjoy.internal.ca
    public final Map e() {
        Map e2 = super.e();
        e2.put(TJAdUnitConstants.String.VIDEO_INFO, new bm(hp.a(this.c)));
        e2.put("app", new bm(hp.a(this.f7710d)));
        e2.put("user", new bm(hp.a(this.f7711e)));
        if (!al.a(this.f7712f)) {
            e2.put("push_token", this.f7712f);
        }
        return e2;
    }

    public il(fb fbVar, String str) {
        this(fbVar.f7483d, fbVar.f7484e, fbVar.f7485f, str);
    }
}
