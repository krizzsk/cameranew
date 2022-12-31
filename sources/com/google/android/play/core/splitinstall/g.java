package com.google.android.play.core.splitinstall;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.n1;
import java.io.File;
/* loaded from: classes2.dex */
public final class g implements n1<File> {
    private final n1<Context> a;

    public g(n1<Context> n1Var) {
        this.a = n1Var;
    }

    @Override // com.google.android.play.core.internal.n1
    @Nullable
    public final /* bridge */ /* synthetic */ File a() {
        return p0.b(((q0) this.a).a());
    }
}
