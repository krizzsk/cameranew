package com.facebook.ads.redexgen.X;

import android.view.Surface;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;
import java.io.IOException;
/* renamed from: com.facebook.ads.redexgen.X.At  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public interface InterfaceC0738At {
    void onAudioSessionId(C0737As c0737As, int i2);

    void onAudioUnderrun(C0737As c0737As, int i2, long j2, long j3);

    void onDecoderDisabled(C0737As c0737As, int i2, C0754Bj c0754Bj);

    void onDecoderEnabled(C0737As c0737As, int i2, C0754Bj c0754Bj);

    void onDecoderInitialized(C0737As c0737As, int i2, String str, long j2);

    void onDecoderInputFormatChanged(C0737As c0737As, int i2, Format format);

    void onDownstreamFormatChanged(C0737As c0737As, C0836Fa c0836Fa);

    void onDrmKeysLoaded(C0737As c0737As);

    void onDrmKeysRemoved(C0737As c0737As);

    void onDrmKeysRestored(C0737As c0737As);

    void onDrmSessionManagerError(C0737As c0737As, Exception exc);

    void onDroppedVideoFrames(C0737As c0737As, int i2, long j2);

    void onLoadError(C0737As c0737As, FZ fz, C0836Fa c0836Fa, IOException iOException, boolean z);

    void onLoadingChanged(C0737As c0737As, boolean z);

    void onMediaPeriodCreated(C0737As c0737As);

    void onMediaPeriodReleased(C0737As c0737As);

    void onMetadata(C0737As c0737As, Metadata metadata);

    void onPlaybackParametersChanged(C0737As c0737As, AU au);

    void onPlayerError(C0737As c0737As, A9 a9);

    void onPlayerStateChanged(C0737As c0737As, boolean z, int i2);

    void onPositionDiscontinuity(C0737As c0737As, int i2);

    void onReadingStarted(C0737As c0737As);

    void onRenderedFirstFrame(C0737As c0737As, Surface surface);

    void onSeekProcessed(C0737As c0737As);

    void onSeekStarted(C0737As c0737As);

    void onTimelineChanged(C0737As c0737As, int i2);

    void onTracksChanged(C0737As c0737As, TrackGroupArray trackGroupArray, HE he);

    void onVideoSizeChanged(C0737As c0737As, int i2, int i3, int i4, float f2);
}
