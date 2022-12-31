package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
final class m0 implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ n0 b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(n0 n0Var, c cVar) {
        this.b = n0Var;
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k0 k0Var;
        List f2;
        k0Var = this.b.b;
        List<String> b = this.a.b();
        f2 = n0.f(this.a.a());
        Bundle bundle = new Bundle();
        bundle.putInt(TapjoyConstants.TJC_SESSION_ID, 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!b.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList<>(b));
        }
        if (!f2.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList<>(f2));
        }
        bundle.putLong("total_bytes_to_download", 0L);
        bundle.putLong("bytes_downloaded", 0L);
        k0Var.c(d.a(bundle));
    }
}
