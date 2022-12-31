package com.ironsource.sdk.utils;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class IronSourceQaProperties {
    private static IronSourceQaProperties a;
    private static Map<String, String> b = new HashMap();

    private IronSourceQaProperties() {
    }

    public static boolean b() {
        return a != null;
    }

    public static IronSourceQaProperties getInstance() {
        if (a == null) {
            a = new IronSourceQaProperties();
        }
        return a;
    }

    public Map<String, String> a() {
        return b;
    }
}
