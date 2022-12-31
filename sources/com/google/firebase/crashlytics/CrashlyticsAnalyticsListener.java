package com.google.firebase.crashlytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import java.util.Locale;
/* loaded from: classes2.dex */
class CrashlyticsAnalyticsListener implements AnalyticsConnector.AnalyticsConnectorListener {
    static final String CRASHLYTICS_ORIGIN = "clx";
    static final String EVENT_NAME_KEY = "name";
    static final String EVENT_ORIGIN_KEY = "_o";
    static final String EVENT_PARAMS_KEY = "params";
    private AnalyticsEventReceiver breadcrumbEventReceiver;
    private AnalyticsEventReceiver crashlyticsOriginEventReceiver;

    private static void notifyEventReceiver(@Nullable AnalyticsEventReceiver analyticsEventReceiver, @NonNull String str, @NonNull Bundle bundle) {
        if (analyticsEventReceiver == null) {
            return;
        }
        analyticsEventReceiver.onEvent(str, bundle);
    }

    private void notifyEventReceivers(@NonNull String str, @NonNull Bundle bundle) {
        AnalyticsEventReceiver analyticsEventReceiver;
        if (CRASHLYTICS_ORIGIN.equals(bundle.getString(EVENT_ORIGIN_KEY))) {
            analyticsEventReceiver = this.crashlyticsOriginEventReceiver;
        } else {
            analyticsEventReceiver = this.breadcrumbEventReceiver;
        }
        notifyEventReceiver(analyticsEventReceiver, str, bundle);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    public void onMessageTriggered(int i2, @Nullable Bundle bundle) {
        String string;
        Logger.getLogger().v(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", Integer.valueOf(i2), bundle));
        if (bundle == null || (string = bundle.getString("name")) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle(EVENT_PARAMS_KEY);
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        notifyEventReceivers(string, bundle2);
    }

    public void setBreadcrumbEventReceiver(@Nullable AnalyticsEventReceiver analyticsEventReceiver) {
        this.breadcrumbEventReceiver = analyticsEventReceiver;
    }

    public void setCrashlyticsOriginEventReceiver(@Nullable AnalyticsEventReceiver analyticsEventReceiver) {
        this.crashlyticsOriginEventReceiver = analyticsEventReceiver;
    }
}
