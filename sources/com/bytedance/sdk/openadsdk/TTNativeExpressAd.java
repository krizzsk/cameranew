package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.view.View;
import androidx.annotation.MainThread;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public interface TTNativeExpressAd {

    /* loaded from: classes.dex */
    public interface AdInteractionListener extends ExpressAdInteractionListener {
        void onAdDismiss();
    }

    /* loaded from: classes.dex */
    public interface ExpressAdInteractionListener {
        void onAdClicked(View view, int i2);

        void onAdShow(View view, int i2);

        void onRenderFail(View view, String str, int i2);

        void onRenderSuccess(View view, float f2, float f3);
    }

    /* loaded from: classes.dex */
    public interface ExpressVideoAdListener {
        void onClickRetry();

        void onProgressUpdate(long j2, long j3);

        void onVideoAdComplete();

        void onVideoAdContinuePlay();

        void onVideoAdPaused();

        void onVideoAdStartPlay();

        void onVideoError(int i2, int i3);

        void onVideoLoad();
    }

    void destroy();

    View getExpressAdView();

    List<FilterWord> getFilterWords();

    int getImageMode();

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    a getVideoModel();

    void render();

    void setCanInterruptVideoPlay(boolean z);

    void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback);

    void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract);

    void setExpressInteractionListener(AdInteractionListener adInteractionListener);

    void setExpressInteractionListener(ExpressAdInteractionListener expressAdInteractionListener);

    void setSlideIntervalTime(int i2);

    void setVideoAdListener(ExpressVideoAdListener expressVideoAdListener);

    @MainThread
    void showInteractionExpressAd(Activity activity);
}
