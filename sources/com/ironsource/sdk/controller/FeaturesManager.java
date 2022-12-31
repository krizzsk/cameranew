package com.ironsource.sdk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class FeaturesManager {
    private static volatile FeaturesManager c;
    private Map<String, ?> a;
    private ArrayList<String> b = new ArrayList<String>() { // from class: com.ironsource.sdk.controller.FeaturesManager.1
        {
            add("webviewperad-v1");
            add("noPackagesInstallationPolling");
            add("lastUpdateTimeRemoval");
            add("isnFileSystemAPI");
            add("controlActivityLifecycle");
        }
    };

    private FeaturesManager() {
        if (c == null) {
            this.a = new HashMap();
            return;
        }
        throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
    }

    public static FeaturesManager getInstance() {
        if (c == null) {
            synchronized (FeaturesManager.class) {
                if (c == null) {
                    c = new FeaturesManager();
                }
            }
        }
        return c;
    }

    public int a() {
        Integer num = 0;
        try {
            if (this.a.containsKey("debugMode")) {
                num = (Integer) this.a.get("debugMode");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> b() {
        return new ArrayList<>(this.b);
    }
}
