package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import androidx.annotation.NonNull;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class ResolvableApiException extends ApiException {
    public ResolvableApiException(@NonNull Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        return getStatus().Q();
    }

    public void startResolutionForResult(Activity activity, int i2) throws IntentSender.SendIntentException {
        getStatus().V(activity, i2);
    }
}
