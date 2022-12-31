package com.facebook.ads.redexgen.X;

import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.MediaViewVideoRenderer;
/* renamed from: com.facebook.ads.redexgen.X.b9  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1439b9 implements InterfaceC1012Mc {
    public final /* synthetic */ MediaViewListener A00;
    public final /* synthetic */ C1438b8 A01;

    public C1439b9(C1438b8 c1438b8, MediaViewListener mediaViewListener) {
        this.A01 = c1438b8;
        this.A00 = mediaViewListener;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1012Mc
    public final void AA9() {
        MediaView mediaView;
        MediaViewListener mediaViewListener = this.A00;
        mediaView = this.A01.A03;
        mediaViewListener.onComplete(mediaView);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1012Mc
    public final void AAT() {
        MediaView mediaView;
        MediaViewListener mediaViewListener = this.A00;
        mediaView = this.A01.A03;
        mediaViewListener.onEnterFullscreen(mediaView);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1012Mc
    public final void AAZ() {
        MediaView mediaView;
        MediaViewListener mediaViewListener = this.A00;
        mediaView = this.A01.A03;
        mediaViewListener.onExitFullscreen(mediaView);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1012Mc
    public final void AAd() {
        MediaView mediaView;
        MediaViewListener mediaViewListener = this.A00;
        mediaView = this.A01.A03;
        mediaViewListener.onFullscreenBackground(mediaView);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1012Mc
    public final void AAe() {
        MediaView mediaView;
        MediaViewListener mediaViewListener = this.A00;
        mediaView = this.A01.A03;
        mediaViewListener.onFullscreenForeground(mediaView);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1012Mc
    public final void ABW() {
        MediaView mediaView;
        MediaViewListener mediaViewListener = this.A00;
        mediaView = this.A01.A03;
        mediaViewListener.onPlay(mediaView);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1012Mc
    public final void ACc() {
        MediaView mediaView;
        MediaViewVideoRenderer mediaViewVideoRenderer;
        MediaViewListener mediaViewListener = this.A00;
        mediaView = this.A01.A03;
        mediaViewVideoRenderer = this.A01.A05;
        mediaViewListener.onVolumeChange(mediaView, mediaViewVideoRenderer.getVolume());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1012Mc
    public final void onPause() {
        MediaView mediaView;
        MediaViewListener mediaViewListener = this.A00;
        mediaView = this.A01.A03;
        mediaViewListener.onPause(mediaView);
    }
}
