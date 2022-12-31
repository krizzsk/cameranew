package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.appevents.InternalAppEventsLogger;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.tapjoy.TJAdUnitConstants;
import us.pinguo.common.network.common.header.PGTransHeader;
/* loaded from: classes.dex */
public class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static BoltsMeasurementEventListener b;
    private Context a;

    private BoltsMeasurementEventListener(Context context) {
        this.a = context.getApplicationContext();
    }

    private void a() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            LocalBroadcastManager.getInstance(this.a).unregisterReceiver(this);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    public static BoltsMeasurementEventListener b(Context context) {
        if (com.facebook.internal.instrument.e.a.c(BoltsMeasurementEventListener.class)) {
            return null;
        }
        try {
            BoltsMeasurementEventListener boltsMeasurementEventListener = b;
            if (boltsMeasurementEventListener != null) {
                return boltsMeasurementEventListener;
            }
            BoltsMeasurementEventListener boltsMeasurementEventListener2 = new BoltsMeasurementEventListener(context);
            b = boltsMeasurementEventListener2;
            boltsMeasurementEventListener2.c();
            return b;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, BoltsMeasurementEventListener.class);
            return null;
        }
    }

    private void c() {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            LocalBroadcastManager.getInstance(this.a).registerReceiver(this, new IntentFilter("com.parse.bolts.measurement_event"));
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    protected void finalize() throws Throwable {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            a();
            super.finalize();
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        VdsAgent.onBroadcastReceiver(this, context, intent);
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
            String str = "bf_" + intent.getStringExtra(TJAdUnitConstants.PARAM_PLACEMENT_NAME);
            Bundle bundleExtra = intent.getBundleExtra("event_args");
            Bundle bundle = new Bundle();
            for (String str2 : bundleExtra.keySet()) {
                bundle.putString(str2.replaceAll("[^0-9a-zA-Z _-]", PGTransHeader.CONNECTOR).replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str2));
            }
            internalAppEventsLogger.g(str, bundle);
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }
}
