package com.adjust.sdk;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class AdjustThirdPartySharing {
    Map<String, Map<String, String>> granularOptions = new HashMap();
    Boolean isEnabled;

    public AdjustThirdPartySharing(Boolean bool) {
        this.isEnabled = bool;
    }

    public void addGranularOption(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            Map<String, String> map = this.granularOptions.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.granularOptions.put(str, map);
            }
            map.put(str2, str3);
            return;
        }
        AdjustFactory.getLogger().error("Cannot add granular option with any null value", new Object[0]);
    }
}
