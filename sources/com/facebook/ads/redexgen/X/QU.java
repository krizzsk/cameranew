package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.view.View;
import androidx.annotation.Nullable;
/* loaded from: assets/audience_network.dex */
public interface QU {
    void A7l();

    boolean A7x();

    boolean A7y();

    boolean A8T();

    void ACn(boolean z, int i2);

    void AEf(int i2);

    void AEk(EnumC1094Pj enumC1094Pj, int i2);

    void AEr(int i2);

    void destroy();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    EnumC1094Pj getStartReason();

    QW getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void seekTo(int i2);

    void setBackgroundPlaybackEnabled(boolean z);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z);

    void setRequestedVolume(float f2);

    void setVideoMPD(@Nullable String str);

    void setVideoStateChangeListener(@Nullable QX qx);

    void setup(Uri uri);
}
