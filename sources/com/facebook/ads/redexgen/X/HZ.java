package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.MediaController;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Arrays;
@TargetApi(14)
/* loaded from: assets/audience_network.dex */
public final class HZ extends TextureView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnSeekCompleteListener, TextureView.SurfaceTextureListener, QU {
    public static byte[] A0N;
    public static String[] A0O = {"w6W1Pn4pGSy1veXw7fNic4Q20vJelJ2", "acNB2lhq8cVPZLtYghlcj8euurSBcqdx", "I2BPPFoGG3lXsTKKPy2FKKasdsM", "uMMu8699SI696vicAGdUyhB1Kjcnsg5D", "S7aPtd9QGtmzyQ9VrNW20IwmaDF5p1Ml", "zS648UlhjTBJXulz7NmFsyAIwaw2iCpI", "ZyXsHo9oibpczWLkt42IpHWLTZevRgPI", "euMEykkwaXnS"};
    public static final String A0P;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    @Nullable
    public MediaPlayer A06;
    public Uri A07;
    public Surface A08;
    public View A09;
    @Nullable
    public MediaController A0A;
    public EnumC1094Pj A0B;
    public QW A0C;
    public QW A0D;
    @Nullable
    public QX A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public final long A0K;
    public final MediaController.MediaPlayerControl A0L;
    public final XT A0M;

    public static String A03(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0N, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 114);
        }
        return new String(copyOfRange);
    }

    public static void A04() {
        A0N = new byte[]{89, 87, 91, 89, 30, 3, 15, 9, 26, 89, 91, 65, 91, 89, 57, 102, 105, 75, 68, 68, 69, 94, 10, 90, 88, 79, 90, 75, 88, 79, 10, 71, 79, 78, 67, 75, 10, 90, 70, 75, 83, 79, 88, 10, 93, 67, 94, 66, 10, 121, 95, 88, 76, 75, 73, 79, 126, 79, 82, 94, 95, 88, 79, 16, 10, 45, 1, 27, 2, 10, 0, 73, 26, 78, 28, 11, 26, 28, 7, 11, 24, 11, 78, 24, 7, 10, 11, 1, 78, 7, 0, 8, 1, 28, 3, 15, 26, 7, 1, 0, 93, 122, 114, 119, 126, Byte.MAX_VALUE, 59, 111, 116, 59, 116, 107, 126, 117, 59, 122, 104, 104, 126, 111, 104, 59, 15, 39, 39, 47, 36, 45, 104, 41, 36, 63, 41, 49, 59, 104, 60, 32, 58, 39, 63, 104, 41, 38, 104, 45, 48, 43, 45, 56, 60, 33, 39, 38, 104, 63, 33, 60, 32, 104, 59, 45, 60, 10, 41, 43, 35, 47, 58, 39, 61, 38, 44, 12, 58, 41, 63, 41, 42, 36, 45, 104, 39, 38, 104, 6, 39, 61, 47, 41, 60, 104, 41, 42, 39, 62, 45, 102, 104, 59, 39, 104, 63, 45, 104, 59, 33, 36, 45, 38, 60, 36, 49, 104, 33, 47, 38, 39, 58, 45, 104, 33, 60, 102, 50, 26, 26, 18, 25, 16, 85, 20, 25, 2, 20, 12, 6, 85, 1, 29, 7, 26, 2, 85, 20, 27, 85, 16, Draft_75.CR, 22, 16, 5, 1, 28, 26, 27, 85, 2, 28, 1, 29, 85, 6, 16, 1, 51, 26, 7, 16, 18, 7, 26, 0, 27, 17, 85, 26, 27, 85, 59, 26, 0, 18, 20, 1, 85, 20, 23, 26, 3, 16, 91, 85, 6, 26, 85, 2, 16, 85, 6, 28, 25, 16, 27, 1, 25, 12, 85, 28, 18, 27, 26, 7, 16, 85, 28, 1, 91, 31, 54, 37, 51, 32, 54, 37, 50, 119, 54, 52, 52, 50, 59, 50, 37, 54, 35, 62, 56, 57, 119, 34, 57, 54, 33, 54, 62, 59, 54, 53, 59, 50, 22, 45, 34, 33, 47, 38, 99, 55, 44, 99, 32, 47, 44, 48, 38, 53, 10, 7, 6, 12, 67, 16, 23, 2, 23, 6, 67, 0, 11, 2, Draft_75.CR, 4, 6, 7, 67, 23, 12, 67, 97, 115, 115, 101, 116, 83, 79, 66, 90, 70, 81, 115, 108, 97, 96, 106, 94, 7, 82, 77, 68, 81, 7, 5, 31, 5, 7};
    }

    static {
        A04();
        A0P = HZ.class.getSimpleName();
    }

    public HZ(XT xt) {
        super(xt);
        this.A0C = QW.A04;
        this.A0D = QW.A04;
        this.A0I = false;
        this.A03 = 0;
        this.A05 = 0;
        this.A04 = 0;
        this.A00 = 1.0f;
        this.A0H = false;
        this.A01 = 3;
        this.A0F = false;
        this.A0J = false;
        this.A02 = 0;
        this.A0G = false;
        this.A0B = EnumC1094Pj.A04;
        this.A0L = new QR(this);
        this.A0M = xt;
    }

    public HZ(XT xt, AttributeSet attributeSet) {
        super(xt, attributeSet);
        this.A0C = QW.A04;
        this.A0D = QW.A04;
        this.A0I = false;
        this.A03 = 0;
        this.A05 = 0;
        this.A04 = 0;
        this.A00 = 1.0f;
        this.A0H = false;
        this.A01 = 3;
        this.A0F = false;
        this.A0J = false;
        this.A02 = 0;
        this.A0G = false;
        this.A0B = EnumC1094Pj.A04;
        this.A0L = new QR(this);
        this.A0M = xt;
    }

    public HZ(XT xt, AttributeSet attributeSet, int i2) {
        super(xt, attributeSet, i2);
        this.A0C = QW.A04;
        this.A0D = QW.A04;
        this.A0I = false;
        this.A03 = 0;
        this.A05 = 0;
        this.A04 = 0;
        this.A00 = 1.0f;
        this.A0H = false;
        this.A01 = 3;
        this.A0F = false;
        this.A0J = false;
        this.A02 = 0;
        this.A0G = false;
        this.A0B = EnumC1094Pj.A04;
        this.A0L = new QR(this);
        this.A0M = xt;
    }

    private boolean A05() {
        return (this.A0C == QW.A08 || this.A0C == QW.A07) ? false : true;
    }

    private boolean A06() {
        return this.A0C == QW.A07 || this.A0C == QW.A0A || this.A0C == QW.A05 || this.A0C == QW.A06;
    }

    private boolean A07() {
        return (this.A0C == QW.A08 || this.A0C == QW.A07) ? false : true;
    }

    private boolean A08() {
        MediaPlayer mediaPlayer = this.A06;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.reset();
            return true;
        } catch (IllegalStateException e2) {
            this.A0M.A06().A8q(A03(394, 6, 81), C06808m.A23, new C06818n(e2));
            return false;
        }
    }

    private boolean A09(@Nullable Surface surface) {
        MediaPlayer mediaPlayer = this.A06;
        if (mediaPlayer == null) {
            return false;
        }
        try {
            mediaPlayer.setSurface(surface);
            return true;
        } catch (IllegalStateException e2) {
            this.A0M.A06().A8q(A03(394, 6, 81), C06808m.A24, new C06818n(e2));
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public final void A7l() {
        if (!this.A0F) {
            ACn(false, 3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QU
    @SuppressLint({"NewApi"})
    public final boolean A7x() {
        if (this.A06 == null || Build.VERSION.SDK_INT < 16) {
            return false;
        }
        try {
            for (MediaPlayer.TrackInfo trackInfo : this.A06.getTrackInfo()) {
                int trackType = trackInfo.getTrackType();
                String[] strArr = A0O;
                if (strArr[3].charAt(29) != strArr[6].charAt(29)) {
                    throw new RuntimeException();
                }
                A0O[5] = "iSqF26gJBktCMb0RObgKl91oEThpz7Z0";
                if (trackType == 2) {
                    return true;
                }
            }
            return false;
        } catch (RuntimeException e2) {
            Log.e(A0P, A03(65, 35, 28), e2);
            return true;
        }
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public final boolean A7y() {
        return this.A0J;
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public final boolean A8T() {
        return this.A0I;
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public final void ACn(boolean z, int i2) {
        this.A0M.A0D().A2q(i2);
        this.A0D = QW.A05;
        if (this.A06 != null) {
            if (!A05()) {
                return;
            }
            this.A0I = z;
            this.A06.pause();
            if (this.A0C != QW.A06) {
                setVideoState(QW.A05);
                return;
            }
            return;
        }
        setVideoState(QW.A04);
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public final void AEf(int i2) {
        this.A0M.A0D().A9S(i2);
        setVideoState(QW.A09);
        AEr(5);
        this.A03 = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (r5.A0C != com.facebook.ads.redexgen.X.QW.A06) goto L13;
     */
    @Override // com.facebook.ads.redexgen.X.QU
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AEk(com.facebook.ads.redexgen.X.EnumC1094Pj r6, int r7) {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.XT r0 = r5.A0M
            com.facebook.ads.redexgen.X.0R r0 = r0.A0D()
            r0.A31(r7)
            r3 = 0
            r5.A0I = r3
            com.facebook.ads.redexgen.X.QW r0 = com.facebook.ads.redexgen.X.QW.A0A
            r5.A0D = r0
            r5.A0B = r6
            com.facebook.ads.redexgen.X.QW r1 = r5.A0C
            com.facebook.ads.redexgen.X.QW r0 = com.facebook.ads.redexgen.X.QW.A0A
            if (r1 == r0) goto L43
            com.facebook.ads.redexgen.X.QW r1 = r5.A0C
            com.facebook.ads.redexgen.X.QW r0 = com.facebook.ads.redexgen.X.QW.A07
            if (r1 == r0) goto L43
            com.facebook.ads.redexgen.X.QW r4 = r5.A0C
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.HZ.A0O
            r0 = 7
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 4
            if (r1 == r0) goto L96
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.HZ.A0O
            java.lang.String r1 = "NTKGPTGyq7PSuZ6pDxSrkOD3BAS3oRMw"
            r0 = 4
            r2[r0] = r1
            com.facebook.ads.redexgen.X.QW r0 = com.facebook.ads.redexgen.X.QW.A04
            if (r4 == r0) goto L43
            com.facebook.ads.redexgen.X.QW r1 = r5.A0C
            com.facebook.ads.redexgen.X.QW r0 = com.facebook.ads.redexgen.X.QW.A05
            if (r1 == r0) goto L43
            com.facebook.ads.redexgen.X.QW r1 = r5.A0C
            com.facebook.ads.redexgen.X.QW r0 = com.facebook.ads.redexgen.X.QW.A06
            if (r1 != r0) goto L4c
        L43:
            android.media.MediaPlayer r1 = r5.A06
            if (r1 != 0) goto L7a
            android.net.Uri r0 = r5.A07
            r5.setup(r0)
        L4c:
            boolean r0 = r5.isAvailable()
            if (r0 == 0) goto L6e
            android.graphics.SurfaceTexture r4 = r5.getSurfaceTexture()
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.HZ.A0O
            r0 = 1
            r1 = r1[r0]
            r0 = 7
            char r1 = r1.charAt(r0)
            r0 = 113(0x71, float:1.58E-43)
            if (r1 == r0) goto L6f
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.HZ.A0O
            java.lang.String r1 = "Wn6W9Nu3dNfA4pP49CdphRQGwehyl3Rd"
            r0 = 4
            r2[r0] = r1
            r5.onSurfaceTextureAvailable(r4, r3, r3)
        L6e:
            return
        L6f:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.HZ.A0O
            java.lang.String r1 = "pXleF17jKjib"
            r0 = 7
            r2[r0] = r1
            r5.onSurfaceTextureAvailable(r4, r3, r3)
            goto L6e
        L7a:
            int r0 = r5.A03
            if (r0 <= 0) goto L81
            r1.seekTo(r0)
        L81:
            android.media.MediaPlayer r0 = r5.A06
            r0.start()
            com.facebook.ads.redexgen.X.QW r1 = r5.A0C
            com.facebook.ads.redexgen.X.QW r0 = com.facebook.ads.redexgen.X.QW.A07
            if (r1 != r0) goto L90
            boolean r0 = r5.A0J
            if (r0 == 0) goto L4c
        L90:
            com.facebook.ads.redexgen.X.QW r0 = com.facebook.ads.redexgen.X.QW.A0A
            r5.setVideoState(r0)
            goto L4c
        L96:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HZ.AEk(com.facebook.ads.redexgen.X.Pj, int):void");
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public final void AEr(int i2) {
        this.A0M.A0D().A33(i2);
        this.A0D = QW.A04;
        MediaPlayer mediaPlayer = this.A06;
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            if (currentPosition > 0) {
                this.A03 = currentPosition;
            }
            this.A06.stop();
            if (A0O[4].charAt(14) == '3') {
                throw new RuntimeException();
            }
            A0O[5] = "KulxFUFqA4xnUTvaQLfyg7cstmOjzycv";
            A08();
            this.A06.release();
            this.A06 = null;
            MediaController mediaController = this.A0A;
            if (mediaController != null) {
                mediaController.hide();
                this.A0A.setEnabled(false);
            }
        }
        setVideoState(QW.A04);
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public final void destroy() {
        if (this.A06 != null) {
            A09(null);
            this.A06.setOnBufferingUpdateListener(null);
            this.A06.setOnCompletionListener(null);
            this.A06.setOnErrorListener(null);
            this.A06.setOnInfoListener(null);
            this.A06.setOnPreparedListener(null);
            this.A06.setOnVideoSizeChangedListener(null);
            this.A06.setOnSeekCompleteListener(null);
            A08();
            this.A06 = null;
            setVideoState(QW.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public int getCurrentPosition() {
        if (this.A06 == null || !A06()) {
            return 0;
        }
        return this.A06.getCurrentPosition();
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public int getDuration() {
        if (this.A06 != null) {
            boolean A06 = A06();
            String[] strArr = A0O;
            if (strArr[3].charAt(29) != strArr[6].charAt(29)) {
                throw new RuntimeException();
            }
            A0O[1] = "tqb6wmVqQGZxPylUtz2fkCIx7Bf2WilJ";
            if (!A06) {
                return 0;
            }
            return this.A06.getDuration();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public long getInitialBufferTime() {
        return this.A0K;
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public EnumC1094Pj getStartReason() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public QW getState() {
        return this.A0C;
    }

    public QW getTargetState() {
        return this.A0D;
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public int getVideoHeight() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public int getVideoWidth() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public float getVolume() {
        return this.A00;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            setVideoState(QW.A03);
            this.A0M.A0D().A2u(5);
            AEr(8);
            this.A0M.A06().A8q(A03(400, 5, 119), C06808m.A2L, new C06818n(A03(TypedValues.AttributesType.TYPE_PIVOT_TARGET, 33, 37)));
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2 = this.A06;
        if (mediaPlayer2 != null) {
            mediaPlayer2.pause();
        }
        setVideoState(QW.A06);
        seekTo(0);
        this.A03 = 0;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        this.A0M.A0D().A9R(A03(405, 11, 87) + i2 + A03(0, 14, 9) + i3 + A03(14, 2, 105));
        if (this.A01 > 0 && getState() == QW.A0A) {
            this.A01--;
            AEr(6);
            AEk(this.A0B, 10);
        } else {
            setVideoState(QW.A03);
            this.A0M.A0D().A2u(1);
            AEr(7);
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        if (i2 == 3) {
            this.A0J = true;
            if (this.A0D == QW.A0A) {
                setVideoState(QW.A0A);
            }
            return true;
        }
        if (i2 != 701) {
            if (i2 == 702 && A07()) {
                setVideoState(QW.A0A);
            }
        } else {
            QW qw = QW.A02;
            if (A0O[4].charAt(14) != '3') {
                String[] strArr = A0O;
                strArr[3] = "iL0L5EQxu2M5tvy2sZDjl5tOkB9wsg4Q";
                strArr[6] = "qEr4cYtmjtQdjlZthk5xBRgssZbq5gW6";
                setVideoState(qw);
            } else {
                setVideoState(qw);
            }
        }
        String[] strArr2 = A0O;
        if (strArr2[3].charAt(29) != strArr2[6].charAt(29)) {
            throw new RuntimeException();
        }
        String[] strArr3 = A0O;
        strArr3[3] = "BctcOQJYgBcKf8RdBMRoW9O8jkER1gO3";
        strArr3[6] = "NFF5b4NOHp1wMQpQtAU8ibXMpYWuxgZg";
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        setVideoState(QW.A07);
        if (this.A0H && !this.A0G) {
            Activity A0C = this.A0M.A0C();
            if (A0C != null) {
                this.A0A = new MediaController(A0C);
                MediaController mediaController = this.A0A;
                View view = this.A09;
                if (view == null) {
                    view = this;
                }
                mediaController.setAnchorView(view);
                MediaController mediaController2 = this.A0A;
                MediaController.MediaPlayerControl mediaPlayerControl = this.A0L;
                if (A0O[1].charAt(7) != 'q') {
                    throw new RuntimeException();
                }
                String[] strArr = A0O;
                strArr[3] = "fPjFRSSzuUrY85KdwEQXHAUI7gq3zgJX";
                strArr[6] = "QlnNj2Zi0n3XZkktRetea07zoE6PUgNL";
                mediaController2.setMediaPlayer(mediaPlayerControl);
                this.A0A.setEnabled(true);
            } else {
                this.A0A = null;
            }
        }
        setRequestedVolume(this.A00);
        this.A05 = mediaPlayer.getVideoWidth();
        this.A04 = mediaPlayer.getVideoHeight();
        int i2 = this.A03;
        if (i2 > 0) {
            if (i2 >= this.A06.getDuration()) {
                this.A03 = 0;
            }
            this.A06.seekTo(this.A03);
            this.A03 = 0;
        }
        QW qw = this.A0D;
        QW qw2 = QW.A0A;
        String[] strArr2 = A0O;
        if (strArr2[2].length() == strArr2[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr3 = A0O;
        strArr3[3] = "i4HMjCzdRtS7Zf5jyUfqsJgJBFC3Hgk3";
        strArr3[6] = "nPyigXhxANl12gOwrMulZJ84NGYQcgH1";
        if (qw == qw2) {
            AEk(this.A0B, 8);
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        QX qx = this.A0E;
        if (qx == null) {
            return;
        }
        qx.AC1(this.A02, this.A03);
        this.A03 = 0;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (this.A08 == null) {
            this.A08 = new Surface(surfaceTexture);
        }
        if (!A09(this.A08)) {
            setVideoState(QW.A03);
            this.A0M.A0D().A2u(4);
            destroy();
        } else if (this.A0C == QW.A05 && !this.A0I) {
            AEk(this.A0B, 7);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        A09(null);
        Surface surface = this.A08;
        if (surface != null) {
            surface.release();
            this.A08 = null;
        }
        if (this.A0C != QW.A05) {
            ACn(false, 5);
        }
        if (A0O[1].charAt(7) != 'q') {
            throw new RuntimeException();
        }
        A0O[5] = "wJEag4Up5dB02EoPbWjrYUJlPYnnpJPt";
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        this.A05 = mediaPlayer.getVideoWidth();
        this.A04 = mediaPlayer.getVideoHeight();
        if (this.A05 != 0 && this.A04 != 0) {
            requestLayout();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.A06 == null) {
            return;
        }
        MediaController mediaController = this.A0A;
        if (mediaController != null && mediaController.isShowing()) {
            return;
        }
        if (!z) {
            if (this.A0C != QW.A05) {
                A7l();
            }
        } else if (this.A0C != QW.A05 || this.A0I) {
        } else {
            AEk(this.A0B, 9);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public final void seekTo(int i2) {
        if (this.A06 != null && A06()) {
            if (i2 < getDuration() && i2 > 0) {
                this.A02 = getCurrentPosition();
                this.A03 = i2;
                this.A06.seekTo(i2);
                return;
            }
            return;
        }
        this.A03 = i2;
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setBackgroundDrawable(drawable);
        } else if (!AdInternalSettings.isDebugBuild()) {
        } else {
            Log.w(A0P, A03(122, 102, 58));
        }
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public void setBackgroundPlaybackEnabled(boolean z) {
        this.A0F = z;
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public void setControlsAnchorView(View view) {
        this.A09 = view;
        view.setOnTouchListener(new QT(this));
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 24) {
            super.setForeground(drawable);
        } else if (!AdInternalSettings.isDebugBuild()) {
        } else {
            Log.w(A0P, A03(224, 94, 7));
        }
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public void setFullScreen(boolean z) {
        this.A0H = z;
        if (this.A0H && !this.A0G) {
            setOnTouchListener(new QS(this));
        }
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public void setRequestedVolume(float f2) {
        this.A00 = f2;
        if (this.A06 != null && this.A0C != QW.A08 && this.A0C != QW.A04) {
            this.A06.setVolume(f2, f2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public void setVideoMPD(@Nullable String str) {
    }

    private void setVideoState(QW qw) {
        if (qw != this.A0C) {
            if (BuildConfigApi.isDebug()) {
                String str = A03(366, 23, 17) + qw;
            }
            this.A0C = qw;
            QX qx = this.A0E;
            if (qx != null) {
                qx.ACb(qw);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.QU
    public void setVideoStateChangeListener(@Nullable QX qx) {
        this.A0E = qx;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @Override // com.facebook.ads.redexgen.X.QU
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setup(android.net.Uri r16) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.HZ.setup(android.net.Uri):void");
    }
}
