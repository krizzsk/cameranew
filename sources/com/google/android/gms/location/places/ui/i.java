package com.google.android.gms.location.places.ui;

import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* loaded from: classes2.dex */
final class i implements View.OnClickListener {
    private final /* synthetic */ SupportPlaceAutocompleteFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SupportPlaceAutocompleteFragment supportPlaceAutocompleteFragment) {
        this.a = supportPlaceAutocompleteFragment;
    }

    @Override // android.view.View.OnClickListener
    @Instrumented
    public final void onClick(View view) {
        boolean z;
        VdsAgent.onClick(this, view);
        z = this.a.f3716d;
        if (z) {
            return;
        }
        this.a.e0();
    }
}
