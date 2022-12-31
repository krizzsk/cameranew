package com.google.android.gms.measurement.internal;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class j5 extends i5 {
    private boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j5(o4 o4Var) {
        super(o4Var);
        this.a.m();
    }

    protected abstract boolean g();

    protected void h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        if (!i()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void k() {
        if (!this.b) {
            if (g()) {
                return;
            }
            this.a.n();
            this.b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void l() {
        if (!this.b) {
            h();
            this.a.n();
            this.b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
