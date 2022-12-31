package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
/* loaded from: classes3.dex */
public enum cv {
    HTML(TJAdUnitConstants.String.HTML),
    NATIVE(TapjoyConstants.TJC_PLUGIN_NATIVE);
    
    private final String c;

    cv(String str) {
        this.c = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.c;
    }
}
