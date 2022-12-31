package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import java.util.List;
/* loaded from: classes2.dex */
final class u extends s<List<String>> {
    final /* synthetic */ z c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(z zVar, com.google.android.play.core.tasks.p<List<String>> pVar) {
        super(zVar, pVar);
        this.c = zVar;
    }

    @Override // com.google.android.play.core.assetpacks.s, com.google.android.play.core.internal.x1
    public final void a(List<Bundle> list) {
        super.a(list);
        this.a.e(z.g(this.c, list));
    }
}
