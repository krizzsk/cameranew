package com.iab.omid.library.ironsrc.adsession;

import android.view.View;
import com.iab.omid.library.ironsrc.publisher.AdSessionStatePublisher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class g extends b {
    private final d a;
    private final c b;

    /* renamed from: d  reason: collision with root package name */
    private d.d.a.a.a.h.a f5307d;

    /* renamed from: e  reason: collision with root package name */
    private AdSessionStatePublisher f5308e;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5312i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5313j;
    private final List<d.d.a.a.a.d.c> c = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private boolean f5309f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5310g = false;

    /* renamed from: h  reason: collision with root package name */
    private String f5311h = UUID.randomUUID().toString();

    static {
        Pattern.compile("^[a-zA-Z0-9 ]+$");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, d dVar) {
        this.b = cVar;
        this.a = dVar;
        h(null);
        this.f5308e = (dVar.b() == AdSessionContextType.HTML || dVar.b() == AdSessionContextType.JAVASCRIPT) ? new com.iab.omid.library.ironsrc.publisher.a(dVar.i()) : new com.iab.omid.library.ironsrc.publisher.b(dVar.e(), dVar.f());
        this.f5308e.a();
        d.d.a.a.a.d.a.a().b(this);
        this.f5308e.e(cVar);
    }

    private void h(View view) {
        this.f5307d = new d.d.a.a.a.h.a(view);
    }

    private void j(View view) {
        Collection<g> c = d.d.a.a.a.d.a.a().c();
        if (c == null || c.size() <= 0) {
            return;
        }
        for (g gVar : c) {
            if (gVar != this && gVar.i() == view) {
                gVar.f5307d.clear();
            }
        }
    }

    private void q() {
        if (this.f5312i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    private void r() {
        if (this.f5313j) {
            throw new IllegalStateException("Loaded event can only be sent once");
        }
    }

    @Override // com.iab.omid.library.ironsrc.adsession.b
    public void b() {
        if (this.f5310g) {
            return;
        }
        this.f5307d.clear();
        s();
        this.f5310g = true;
        o().n();
        d.d.a.a.a.d.a.a().f(this);
        o().j();
        this.f5308e = null;
    }

    @Override // com.iab.omid.library.ironsrc.adsession.b
    public void c(View view) {
        if (this.f5310g) {
            return;
        }
        d.d.a.a.a.g.e.c(view, "AdView is null");
        if (i() == view) {
            return;
        }
        h(view);
        o().r();
        j(view);
    }

    @Override // com.iab.omid.library.ironsrc.adsession.b
    public void d() {
        if (this.f5309f) {
            return;
        }
        this.f5309f = true;
        d.d.a.a.a.d.a.a().d(this);
        this.f5308e.b(d.d.a.a.a.d.f.a().e());
        this.f5308e.f(this, this.a);
    }

    public List<d.d.a.a.a.d.c> e() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        q();
        o().o();
        this.f5312i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        r();
        o().q();
        this.f5313j = true;
    }

    public View i() {
        return this.f5307d.get();
    }

    public boolean k() {
        return this.f5309f && !this.f5310g;
    }

    public boolean l() {
        return this.f5309f;
    }

    public boolean m() {
        return this.f5310g;
    }

    public String n() {
        return this.f5311h;
    }

    public AdSessionStatePublisher o() {
        return this.f5308e;
    }

    public boolean p() {
        return this.b.b();
    }

    public void s() {
        if (this.f5310g) {
            return;
        }
        this.c.clear();
    }
}
