package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.RequiresApi;
@RequiresApi(21)
/* renamed from: com.facebook.ads.redexgen.X.0a  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C04720a extends C04750d {
    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final C3I A08(View view, C3I c3i) {
        WindowInsets windowInsets = (WindowInsets) C3I.A01(c3i);
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
        if (dispatchApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(dispatchApplyWindowInsets);
        }
        return C3I.A00(windowInsets);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final C3I A09(View view, C3I c3i) {
        WindowInsets windowInsets = (WindowInsets) C3I.A01(c3i);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
        if (onApplyWindowInsets != windowInsets) {
            windowInsets = new WindowInsets(onApplyWindowInsets);
        }
        return C3I.A00(windowInsets);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final void A0B(View view) {
        view.stopNestedScroll();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass30
    public final void A0F(View view, final InterfaceC05332l interfaceC05332l) {
        if (interfaceC05332l == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.facebook.ads.redexgen.X.2z
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                    return (WindowInsets) C3I.A01(interfaceC05332l.A9o(view2, C3I.A00(windowInsets)));
                }
            });
        }
    }
}
