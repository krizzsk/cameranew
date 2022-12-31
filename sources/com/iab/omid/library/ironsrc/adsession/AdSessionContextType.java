package com.iab.omid.library.ironsrc.adsession;

import com.tapjoy.TJAdUnitConstants;
import com.tapjoy.TapjoyConstants;
/* loaded from: classes2.dex */
public enum AdSessionContextType {
    HTML(TJAdUnitConstants.String.HTML),
    NATIVE(TapjoyConstants.TJC_PLUGIN_NATIVE),
    JAVASCRIPT("javascript");
    
    private final String typeString;

    AdSessionContextType(String str) {
        this.typeString = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.typeString;
    }
}
