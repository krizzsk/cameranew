package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* compiled from: com.android.billingclient:billing@@3.0.0 */
/* loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {
    @Nullable
    private ResultReceiver zza;

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 100) {
            int zza = com.google.android.gms.internal.play_billing.zzb.zza(intent, "ProxyBillingActivity");
            if (i3 != -1 || zza != 0) {
                StringBuilder sb = new StringBuilder(85);
                sb.append("Activity finished with resultCode ");
                sb.append(i3);
                sb.append(" and billing's responseCode: ");
                sb.append(zza);
                com.google.android.gms.internal.play_billing.zzb.zzb("ProxyBillingActivity", sb.toString());
            }
            this.zza.send(zza, intent == null ? null : intent.getExtras());
        } else {
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("Got onActivityResult with wrong requestCode: ");
            sb2.append(i2);
            sb2.append("; skipping...");
            com.google.android.gms.internal.play_billing.zzb.zzb("ProxyBillingActivity", sb2.toString());
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.zzb.zza("ProxyBillingActivity", "Launching Play Store billing flow");
            this.zza = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            } else {
                pendingIntent = getIntent().hasExtra("SUBS_MANAGEMENT_INTENT") ? (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT") : null;
            }
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 100, new Intent(), 0, 0, 0);
                return;
            } catch (IntentSender.SendIntentException e2) {
                String valueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 53);
                sb.append("Got exception while trying to start a purchase flow: ");
                sb.append(valueOf);
                com.google.android.gms.internal.play_billing.zzb.zzb("ProxyBillingActivity", sb.toString());
                this.zza.send(6, null);
                finish();
                return;
            }
        }
        com.google.android.gms.internal.play_billing.zzb.zza("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
        this.zza = (ResultReceiver) bundle.getParcelable("result_receiver");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putParcelable("result_receiver", this.zza);
    }
}
