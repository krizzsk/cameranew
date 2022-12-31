package com.google.android.play.core.assetpacks;
/* loaded from: classes2.dex */
final /* synthetic */ class q2 implements Runnable {
    private final k0 a;

    private q2(k0 k0Var) {
        this.a = k0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(k0 k0Var) {
        return new q2(k0Var);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.q();
    }
}
