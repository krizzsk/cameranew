package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbam extends zzbav implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzeiw;
    private final zzbbo zzeix;
    private final zzbbn zzeiy;
    private final boolean zzeiz;
    private int zzeja;
    private int zzejb;
    private MediaPlayer zzejc;
    private Uri zzejd;
    private int zzeje;
    private int zzejf;
    private int zzejg;
    private int zzejh;
    private int zzeji;
    private zzbbm zzejj;
    private boolean zzejk;
    private int zzejl;
    private zzbaw zzejm;
    private Integer zzejn;

    static {
        HashMap hashMap = new HashMap();
        zzeiw = hashMap;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            hashMap.put(Integer.valueOf((int) IMediaPlayer.MEDIA_ERROR_IO), "MEDIA_ERROR_IO");
            hashMap.put(Integer.valueOf((int) IMediaPlayer.MEDIA_ERROR_MALFORMED), "MEDIA_ERROR_MALFORMED");
            hashMap.put(Integer.valueOf((int) IMediaPlayer.MEDIA_ERROR_UNSUPPORTED), "MEDIA_ERROR_UNSUPPORTED");
            hashMap.put(Integer.valueOf((int) IMediaPlayer.MEDIA_ERROR_TIMED_OUT), "MEDIA_ERROR_TIMED_OUT");
            hashMap.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        hashMap.put(100, "MEDIA_ERROR_SERVER_DIED");
        hashMap.put(1, "MEDIA_ERROR_UNKNOWN");
        hashMap.put(1, "MEDIA_INFO_UNKNOWN");
        hashMap.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        hashMap.put(701, "MEDIA_INFO_BUFFERING_START");
        hashMap.put(702, "MEDIA_INFO_BUFFERING_END");
        hashMap.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        hashMap.put(Integer.valueOf((int) IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE), "MEDIA_INFO_NOT_SEEKABLE");
        hashMap.put(Integer.valueOf((int) IMediaPlayer.MEDIA_INFO_METADATA_UPDATE), "MEDIA_INFO_METADATA_UPDATE");
        if (i2 >= 19) {
            hashMap.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            hashMap.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzbam(Context context, zzbbo zzbboVar, boolean z, boolean z2, zzbbl zzbblVar, zzbbn zzbbnVar) {
        super(context);
        this.zzeja = 0;
        this.zzejb = 0;
        this.zzejn = null;
        setSurfaceTextureListener(this);
        this.zzeix = zzbboVar;
        this.zzeiy = zzbbnVar;
        this.zzejk = z;
        this.zzeiz = z2;
        zzbbnVar.zzb(this);
    }

    private final void zzaae() {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzejd == null || surfaceTexture == null) {
            return;
        }
        zzau(false);
        try {
            com.google.android.gms.ads.internal.zzr.zzlh();
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.zzejc = mediaPlayer;
            mediaPlayer.setOnBufferingUpdateListener(this);
            this.zzejc.setOnCompletionListener(this);
            this.zzejc.setOnErrorListener(this);
            this.zzejc.setOnInfoListener(this);
            this.zzejc.setOnPreparedListener(this);
            this.zzejc.setOnVideoSizeChangedListener(this);
            this.zzejg = 0;
            if (this.zzejk) {
                zzbbm zzbbmVar = new zzbbm(getContext());
                this.zzejj = zzbbmVar;
                zzbbmVar.zza(surfaceTexture, getWidth(), getHeight());
                this.zzejj.start();
                SurfaceTexture zzaax = this.zzejj.zzaax();
                if (zzaax != null) {
                    surfaceTexture = zzaax;
                } else {
                    this.zzejj.zzaaw();
                    this.zzejj = null;
                }
            }
            this.zzejc.setDataSource(getContext(), this.zzejd);
            com.google.android.gms.ads.internal.zzr.zzli();
            this.zzejc.setSurface(new Surface(surfaceTexture));
            this.zzejc.setAudioStreamType(3);
            this.zzejc.setScreenOnWhilePlaying(true);
            this.zzejc.prepareAsync();
            zzdi(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e2) {
            String valueOf = String.valueOf(this.zzejd);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36);
            sb.append("Failed to initialize MediaPlayer at ");
            sb.append(valueOf);
            zzazk.zzd(sb.toString(), e2);
            onError(this.zzejc, 1, 0);
        }
    }

    private final void zzaaf() {
        if (this.zzeiz && zzaag() && this.zzejc.getCurrentPosition() > 0 && this.zzejb != 3) {
            com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView nudging MediaPlayer");
            zzd(0.0f);
            this.zzejc.start();
            int currentPosition = this.zzejc.getCurrentPosition();
            long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis();
            while (zzaag() && this.zzejc.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis() - currentTimeMillis <= 250) {
            }
            this.zzejc.pause();
            zzaaj();
        }
    }

    private final boolean zzaag() {
        int i2;
        return (this.zzejc == null || (i2 = this.zzeja) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    private final void zzau(boolean z) {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView release");
        zzbbm zzbbmVar = this.zzejj;
        if (zzbbmVar != null) {
            zzbbmVar.zzaaw();
            this.zzejj = null;
        }
        MediaPlayer mediaPlayer = this.zzejc;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzejc.release();
            this.zzejc = null;
            zzdi(0);
            if (z) {
                this.zzejb = 0;
                this.zzejb = 0;
            }
        }
    }

    private final void zzd(float f2) {
        MediaPlayer mediaPlayer = this.zzejc;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f2, f2);
                return;
            } catch (IllegalStateException unused) {
                return;
            }
        }
        zzazk.zzex("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
    }

    private final void zzdi(int i2) {
        if (i2 == 3) {
            this.zzeiy.zzaaz();
            this.zzejv.zzaaz();
        } else if (this.zzeja == 3) {
            this.zzeiy.zzaba();
            this.zzejv.zzaba();
        }
        this.zzeja = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final int getCurrentPosition() {
        if (zzaag()) {
            return this.zzejc.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final int getDuration() {
        if (zzaag()) {
            return this.zzejc.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final long getTotalBytes() {
        if (this.zzejn != null) {
            return getDuration() * this.zzejn.intValue();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzejc;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzejc;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        this.zzejg = i2;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView completion");
        zzdi(5);
        this.zzejb = 5;
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new zzban(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        Map<Integer, String> map = zzeiw;
        String str = map.get(Integer.valueOf(i2));
        String str2 = map.get(Integer.valueOf(i3));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzazk.zzex(sb.toString());
        zzdi(-1);
        this.zzejb = -1;
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new zzbaq(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        Map<Integer, String> map = zzeiw;
        String str = map.get(Integer.valueOf(i2));
        String str2 = map.get(Integer.valueOf(i3));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (r1 > r6) goto L18;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzeje
            int r0 = android.view.TextureView.getDefaultSize(r0, r6)
            int r1 = r5.zzejf
            int r1 = android.view.TextureView.getDefaultSize(r1, r7)
            int r2 = r5.zzeje
            if (r2 <= 0) goto L83
            int r2 = r5.zzejf
            if (r2 <= 0) goto L83
            com.google.android.gms.internal.ads.zzbbm r2 = r5.zzejj
            if (r2 != 0) goto L83
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L47
            if (r1 != r2) goto L47
            int r0 = r5.zzeje
            int r1 = r0 * r7
            int r2 = r5.zzejf
            int r3 = r6 * r2
            if (r1 >= r3) goto L3c
            int r0 = r0 * r7
            int r0 = r0 / r2
            goto L6a
        L3c:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L67
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L58
        L47:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L5a
            int r0 = r5.zzejf
            int r0 = r0 * r6
            int r2 = r5.zzeje
            int r0 = r0 / r2
            if (r1 != r3) goto L57
            if (r0 <= r7) goto L57
            goto L67
        L57:
            r1 = r0
        L58:
            r0 = r6
            goto L83
        L5a:
            if (r1 != r2) goto L6c
            int r1 = r5.zzeje
            int r1 = r1 * r7
            int r2 = r5.zzejf
            int r1 = r1 / r2
            if (r0 != r3) goto L69
            if (r1 <= r6) goto L69
        L67:
            r0 = r6
            goto L6a
        L69:
            r0 = r1
        L6a:
            r1 = r7
            goto L83
        L6c:
            int r2 = r5.zzeje
            int r4 = r5.zzejf
            if (r1 != r3) goto L78
            if (r4 <= r7) goto L78
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L7a
        L78:
            r1 = r2
            r7 = r4
        L7a:
            if (r0 != r3) goto L69
            if (r1 <= r6) goto L69
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L58
        L83:
            r5.setMeasuredDimension(r0, r1)
            com.google.android.gms.internal.ads.zzbbm r6 = r5.zzejj
            if (r6 == 0) goto L8d
            r6.zzm(r0, r1)
        L8d:
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 16
            if (r6 != r7) goto La6
            int r6 = r5.zzejh
            if (r6 <= 0) goto L99
            if (r6 != r0) goto L9f
        L99:
            int r6 = r5.zzeji
            if (r6 <= 0) goto La2
            if (r6 == r1) goto La2
        L9f:
            r5.zzaaf()
        La2:
            r5.zzejh = r0
            r5.zzeji = r1
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbam.onMeasure(int, int):void");
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView prepared");
        zzdi(2);
        this.zzeiy.zzfb();
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new zzbao(this, mediaPlayer));
        this.zzeje = mediaPlayer.getVideoWidth();
        this.zzejf = mediaPlayer.getVideoHeight();
        int i2 = this.zzejl;
        if (i2 != 0) {
            seekTo(i2);
        }
        zzaaf();
        int i3 = this.zzeje;
        int i4 = this.zzejf;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i3);
        sb.append(" x ");
        sb.append(i4);
        zzazk.zzew(sb.toString());
        if (this.zzejb == 3) {
            play();
        }
        zzaaj();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView surface created");
        zzaae();
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new zzbap(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzejc;
        if (mediaPlayer != null && this.zzejl == 0) {
            this.zzejl = mediaPlayer.getCurrentPosition();
        }
        zzbbm zzbbmVar = this.zzejj;
        if (zzbbmVar != null) {
            zzbbmVar.zzaaw();
        }
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new zzbar(this));
        zzau(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.zzejb == 3;
        z = (this.zzeje == i2 && this.zzejf == i3) ? false : false;
        if (this.zzejc != null && z2 && z) {
            int i4 = this.zzejl;
            if (i4 != 0) {
                seekTo(i4);
            }
            play();
        }
        zzbbm zzbbmVar = this.zzejj;
        if (zzbbmVar != null) {
            zzbbmVar.zzm(i2, i3);
        }
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new zzbas(this, i2, i3));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeiy.zzc(this);
        this.zzeju.zza(surfaceTexture, this.zzejm);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
        this.zzeje = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzejf = videoHeight;
        if (this.zzeje == 0 || videoHeight == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i2) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this, i2) { // from class: com.google.android.gms.internal.ads.zzbal
            private final int zzefe;
            private final zzbam zzeiv;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzeiv = this;
                this.zzefe = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeiv.zzdj(this.zzefe);
            }
        });
        super.onWindowVisibilityChanged(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void pause() {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView pause");
        if (zzaag() && this.zzejc.isPlaying()) {
            this.zzejc.pause();
            zzdi(4);
            com.google.android.gms.ads.internal.util.zzj.zzeen.post(new zzbat(this));
        }
        this.zzejb = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void play() {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView play");
        if (zzaag()) {
            this.zzejc.start();
            zzdi(3);
            this.zzeju.zzaal();
            com.google.android.gms.ads.internal.util.zzj.zzeen.post(new zzbau(this));
        }
        this.zzejb = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void seekTo(int i2) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
        if (zzaag()) {
            this.zzejc.seekTo(i2);
            this.zzejl = 0;
            return;
        }
        this.zzejl = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzth zzd = zzth.zzd(parse);
        if (zzd == null || zzd.url != null) {
            if (zzd != null) {
                parse = Uri.parse(zzd.url);
            }
            this.zzejd = parse;
            this.zzejl = 0;
            zzaae();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void stop() {
        com.google.android.gms.ads.internal.util.zzd.zzeb("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzejc;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzejc.release();
            this.zzejc = null;
            zzdi(0);
            this.zzejb = 0;
        }
        this.zzeiy.onStop();
    }

    @Override // android.view.View
    public final String toString() {
        String name = zzbam.class.getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void zza(zzbaw zzbawVar) {
        this.zzejm = zzbawVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final String zzaad() {
        String str = this.zzejk ? " spherical" : "";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final long zzaah() {
        if (this.zzejn != null) {
            return (getTotalBytes() * this.zzejg) / 100;
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final int zzaai() {
        if (Build.VERSION.SDK_INT < 26 || !zzaag()) {
            return -1;
        }
        return this.zzejc.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    @Override // com.google.android.gms.internal.ads.zzbav, com.google.android.gms.internal.ads.zzbbs
    public final void zzaaj() {
        zzd(this.zzejv.getVolume());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzdj(int i2) {
        zzbaw zzbawVar = this.zzejm;
        if (zzbawVar != null) {
            zzbawVar.onWindowVisibilityChanged(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final long zznb() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void zza(float f2, float f3) {
        zzbbm zzbbmVar = this.zzejj;
        if (zzbbmVar != null) {
            zzbbmVar.zzb(f2, f3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(MediaPlayer mediaPlayer) {
        MediaPlayer.TrackInfo[] trackInfo;
        MediaFormat format;
        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcrm)).booleanValue() || this.zzeix == null || mediaPlayer == null || Build.VERSION.SDK_INT < 19 || (trackInfo = mediaPlayer.getTrackInfo()) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
            if (trackInfo2 != null) {
                int trackType = trackInfo2.getTrackType();
                if (trackType == 1) {
                    MediaFormat format2 = trackInfo2.getFormat();
                    if (format2 != null) {
                        if (format2.containsKey("frame-rate")) {
                            try {
                                hashMap.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                            } catch (ClassCastException unused) {
                                hashMap.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                            }
                        }
                        if (format2.containsKey(IjkMediaMeta.IJKM_KEY_BITRATE)) {
                            Integer valueOf = Integer.valueOf(format2.getInteger(IjkMediaMeta.IJKM_KEY_BITRATE));
                            this.zzejn = valueOf;
                            hashMap.put("bitRate", String.valueOf(valueOf));
                        }
                        if (format2.containsKey("width") && format2.containsKey("height")) {
                            int integer = format2.getInteger("width");
                            int integer2 = format2.getInteger("height");
                            StringBuilder sb = new StringBuilder(23);
                            sb.append(integer);
                            sb.append("x");
                            sb.append(integer2);
                            hashMap.put("resolution", sb.toString());
                        }
                        if (format2.containsKey(IMediaFormat.KEY_MIME)) {
                            hashMap.put("videoMime", format2.getString(IMediaFormat.KEY_MIME));
                        }
                        if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                            hashMap.put("videoCodec", format2.getString("codecs-string"));
                        }
                    }
                } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                    if (format.containsKey(IMediaFormat.KEY_MIME)) {
                        hashMap.put("audioMime", format.getString(IMediaFormat.KEY_MIME));
                    }
                    if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                        hashMap.put("audioCodec", format.getString("codecs-string"));
                    }
                }
            }
        }
        if (hashMap.isEmpty()) {
            return;
        }
        this.zzeix.zza("onMetadataEvent", hashMap);
    }
}
