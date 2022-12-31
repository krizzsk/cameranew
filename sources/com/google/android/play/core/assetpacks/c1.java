package com.google.android.play.core.assetpacks;

import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c1 {

    /* renamed from: j  reason: collision with root package name */
    private static final com.google.android.play.core.internal.j f4702j = new com.google.android.play.core.internal.j("ExtractorLooper");
    private final w1 a;
    private final a1 b;
    private final d3 c;

    /* renamed from: d  reason: collision with root package name */
    private final n2 f4703d;

    /* renamed from: e  reason: collision with root package name */
    private final r2 f4704e;

    /* renamed from: f  reason: collision with root package name */
    private final w2 f4705f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.play.core.internal.k1<x3> f4706g;

    /* renamed from: h  reason: collision with root package name */
    private final z1 f4707h;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f4708i = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1(w1 w1Var, com.google.android.play.core.internal.k1<x3> k1Var, a1 a1Var, d3 d3Var, n2 n2Var, r2 r2Var, w2 w2Var, z1 z1Var) {
        this.a = w1Var;
        this.f4706g = k1Var;
        this.b = a1Var;
        this.c = d3Var;
        this.f4703d = n2Var;
        this.f4704e = r2Var;
        this.f4705f = w2Var;
        this.f4707h = z1Var;
    }

    private final void b(int i2, Exception exc) {
        try {
            this.a.r(i2);
            this.a.d(i2);
        } catch (bv unused) {
            f4702j.e("Error during error handling: %s", exc.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        com.google.android.play.core.internal.j jVar = f4702j;
        jVar.c("Run extractor loop", new Object[0]);
        if (!this.f4708i.compareAndSet(false, true)) {
            jVar.g("runLoop already looping; return", new Object[0]);
            return;
        }
        while (true) {
            y1 y1Var = null;
            try {
                y1Var = this.f4707h.a();
            } catch (bv e2) {
                f4702j.e("Error while getting next extraction task: %s", e2.getMessage());
                if (e2.a >= 0) {
                    this.f4706g.a().a(e2.a);
                    b(e2.a, e2);
                }
            }
            if (y1Var == null) {
                this.f4708i.set(false);
                return;
            }
            try {
                if (y1Var instanceof z0) {
                    this.b.a((z0) y1Var);
                } else if (y1Var instanceof c3) {
                    this.c.a((c3) y1Var);
                } else if (y1Var instanceof m2) {
                    this.f4703d.a((m2) y1Var);
                } else if (y1Var instanceof p2) {
                    this.f4704e.a((p2) y1Var);
                } else if (y1Var instanceof v2) {
                    this.f4705f.a((v2) y1Var);
                } else {
                    f4702j.e("Unknown task type: %s", y1Var.getClass().getName());
                }
            } catch (Exception e3) {
                f4702j.e("Error during extraction task: %s", e3.getMessage());
                this.f4706g.a().a(y1Var.a);
                b(y1Var.a, e3);
            }
        }
    }
}
