package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
@KeepName
/* loaded from: classes2.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    private int a = 0;

    public static PendingIntent a(Context context, PendingIntent pendingIntent, int i2) {
        Intent b = b(context, pendingIntent, i2, true);
        VdsAgent.onPendingIntentGetActivityShortBefore(context, 0, b, 134217728);
        PendingIntent activity = PendingIntent.getActivity(context, 0, b, 134217728);
        VdsAgent.onPendingIntentGetActivityShortAfter(context, 0, b, 134217728, activity);
        return activity;
    }

    public static Intent b(Context context, PendingIntent pendingIntent, int i2, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.a = 0;
            setResult(i3, intent);
            if (booleanExtra) {
                com.google.android.gms.common.api.internal.f f2 = com.google.android.gms.common.api.internal.f.f(this);
                if (i3 == -1) {
                    f2.t();
                } else if (i3 == 0) {
                    f2.b(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i2 == 2) {
            this.a = 0;
            setResult(i3, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.a = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.a = bundle.getInt("resolution");
        }
        if (this.a != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                Log.e("GoogleApiActivity", "Activity started without resolution");
                finish();
            } else if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.a = 1;
                } catch (IntentSender.SendIntentException e2) {
                    Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e2);
                    finish();
                }
            } else {
                GoogleApiAvailability.getInstance().n(this, num.intValue(), 2, this);
                this.a = 1;
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("resolution", this.a);
        super.onSaveInstanceState(bundle);
    }
}
