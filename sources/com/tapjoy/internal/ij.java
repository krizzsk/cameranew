package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJAdUnitConstants;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public final class ij extends ii {
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f7703d = false;

    /* renamed from: e  reason: collision with root package name */
    private final gz f7704e;

    /* renamed from: f  reason: collision with root package name */
    private final fa f7705f;

    /* renamed from: g  reason: collision with root package name */
    private final eu f7706g;

    /* renamed from: h  reason: collision with root package name */
    private final fh f7707h;

    /* renamed from: i  reason: collision with root package name */
    private Context f7708i;

    /* loaded from: classes3.dex */
    public static class a {
        public hg a;
        public final List b;

        public a(hg hgVar, List list) {
            this.a = hgVar;
            this.b = list;
        }
    }

    public ij(gz gzVar, fa faVar, eu euVar, fh fhVar, String str, Context context) {
        this.f7704e = gzVar;
        this.f7705f = faVar;
        this.f7706g = euVar;
        this.f7707h = fhVar;
        this.c = str;
        this.f7708i = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.ii, com.tapjoy.internal.bz
    public final /* synthetic */ Object a(bn bnVar) {
        bnVar.h();
        hu huVar = null;
        hr hrVar = null;
        List list = null;
        while (bnVar.j()) {
            String l2 = bnVar.l();
            if ("interstitial".equals(l2)) {
                huVar = (hu) bnVar.a(hu.n);
            } else if ("contextual_button".equals(l2)) {
                hrVar = (hr) bnVar.a(hr.f7632d);
            } else if ("enabled_placements".equals(l2)) {
                list = bnVar.c();
            } else {
                bnVar.s();
            }
        }
        bnVar.i();
        if (huVar == null || !(huVar.a() || huVar.b())) {
            if (hrVar != null) {
                return new a(new gv(this.f7704e, this.c, hrVar, this.f7708i), list);
            }
            return new a(new hf(), list);
        }
        return new a(new he(this.f7704e, this.c, huVar, this.f7708i), list);
    }

    @Override // com.tapjoy.internal.ca
    public final String c() {
        return "placement";
    }

    @Override // com.tapjoy.internal.ii, com.tapjoy.internal.ca
    public final Map e() {
        Map e2 = super.e();
        e2.put(TJAdUnitConstants.String.VIDEO_INFO, new bm(hp.a(this.f7705f)));
        e2.put("app", new bm(hp.a(this.f7706g)));
        e2.put("user", new bm(hp.a(this.f7707h)));
        e2.put("placement", this.c);
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tapjoy.internal.ii, com.tapjoy.internal.ca
    public final /* synthetic */ Object f() {
        a aVar = (a) super.f();
        hg hgVar = aVar.a;
        if (!(hgVar instanceof hf)) {
            hgVar.b();
            if (!aVar.a.c()) {
                aVar.a = new hf();
            }
        }
        return aVar;
    }
}
