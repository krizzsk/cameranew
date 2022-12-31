package com.google.android.play.core.assetpacks;

import java.util.List;
/* loaded from: classes2.dex */
final /* synthetic */ class i3 implements com.google.android.play.core.tasks.c {
    private final k0 a;

    private i3(k0 k0Var) {
        this.a = k0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.android.play.core.tasks.c a(k0 k0Var) {
        return new i3(k0Var);
    }

    @Override // com.google.android.play.core.tasks.c
    public final void onSuccess(Object obj) {
        this.a.g((List) obj);
    }
}
