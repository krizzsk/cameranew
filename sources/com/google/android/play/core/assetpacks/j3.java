package com.google.android.play.core.assetpacks;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class j3 implements com.google.android.play.core.tasks.b {
    static final com.google.android.play.core.tasks.b a = new j3();

    private j3() {
    }

    @Override // com.google.android.play.core.tasks.b
    public final void onFailure(Exception exc) {
        k3.f4755k.g(String.format("Could not sync active asset packs. %s", exc), new Object[0]);
    }
}
