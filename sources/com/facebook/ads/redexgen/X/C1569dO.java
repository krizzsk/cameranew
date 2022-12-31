package com.facebook.ads.redexgen.X;

import java.io.File;
/* renamed from: com.facebook.ads.redexgen.X.dO  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1569dO implements AnonymousClass03<File> {
    @Override // com.facebook.ads.redexgen.X.AnonymousClass03
    public final AnonymousClass02<File> A39(File file, C0L c0l) {
        if (file.exists()) {
            return new AnonymousClass02<>(true, file);
        }
        return new AnonymousClass02<>(false, null);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass03
    public final void A49(File file, C0L c0l) {
    }
}
