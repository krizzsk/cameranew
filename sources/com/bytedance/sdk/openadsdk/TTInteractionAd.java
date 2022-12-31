package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import androidx.annotation.MainThread;
import java.util.Map;
/* loaded from: classes.dex */
public interface TTInteractionAd {

    /* loaded from: classes.dex */
    public interface AdInteractionListener {
        void onAdClicked();

        void onAdDismiss();

        void onAdShow();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    @MainThread
    void showInteractionAd(Activity activity);
}
