package com.google.firebase.abt.component;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class AbtComponent {
    @GuardedBy("this")
    private final Map<String, FirebaseABTesting> abtOriginInstances = new HashMap();
    private final AnalyticsConnector analyticsConnector;
    private final Context appContext;

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting(otherwise = 3)
    public AbtComponent(Context context, AnalyticsConnector analyticsConnector) {
        this.appContext = context;
        this.analyticsConnector = analyticsConnector;
    }

    @VisibleForTesting
    protected FirebaseABTesting createAbtInstance(String str) {
        return new FirebaseABTesting(this.appContext, this.analyticsConnector, str);
    }

    public synchronized FirebaseABTesting get(String str) {
        if (!this.abtOriginInstances.containsKey(str)) {
            this.abtOriginInstances.put(str, createAbtInstance(str));
        }
        return this.abtOriginInstances.get(str);
    }
}
