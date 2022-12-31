package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzbbr extends zzbav implements TextureView.SurfaceTextureListener, zzbcu {
    private Surface zzblm;
    private final zzbbo zzeix;
    private final zzbbn zzeiy;
    private final boolean zzeiz;
    private int zzeje;
    private int zzejf;
    private int zzejh;
    private int zzeji;
    private zzbbm zzejj;
    private final boolean zzejk;
    private zzbaw zzejm;
    private String[] zzeki;
    private final zzbbl zzenf;
    private zzbck zzeng;
    private String zzenh;
    private boolean zzeni;
    private int zzenj;
    private boolean zzenk;
    private boolean zzenl;
    private float zzenm;

    public zzbbr(Context context, zzbbn zzbbnVar, zzbbo zzbboVar, boolean z, boolean z2, zzbbl zzbblVar) {
        super(context);
        this.zzenj = 1;
        this.zzeiz = z2;
        this.zzeix = zzbboVar;
        this.zzeiy = zzbbnVar;
        this.zzejk = z;
        this.zzenf = zzbblVar;
        setSurfaceTextureListener(this);
        zzbbnVar.zzb(this);
    }

    private final void zza(Surface surface, boolean z) {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            zzbckVar.zza(surface, z);
        } else {
            zzazk.zzex("Trying to set surface before player is initalized.");
        }
    }

    private final zzbck zzabp() {
        return new zzbck(this.zzeix.getContext(), this.zzenf, this.zzeix);
    }

    private final String zzabq() {
        return com.google.android.gms.ads.internal.zzr.zzkr().zzq(this.zzeix.getContext(), this.zzeix.zzabj().zzbrp);
    }

    private final boolean zzabr() {
        zzbck zzbckVar = this.zzeng;
        return (zzbckVar == null || zzbckVar.zzaci() == null || this.zzeni) ? false : true;
    }

    private final boolean zzabs() {
        return zzabr() && this.zzenj != 1;
    }

    private final void zzabt() {
        String str;
        if (this.zzeng != null || (str = this.zzenh) == null || this.zzblm == null) {
            return;
        }
        if (str.startsWith("cache:")) {
            zzbdd zzfc = this.zzeix.zzfc(this.zzenh);
            if (zzfc instanceof zzbds) {
                zzbck zzaco = ((zzbds) zzfc).zzaco();
                this.zzeng = zzaco;
                if (zzaco.zzaci() == null) {
                    zzazk.zzex("Precached video player has been released.");
                    return;
                }
            } else if (zzfc instanceof zzbdp) {
                zzbdp zzbdpVar = (zzbdp) zzfc;
                String zzabq = zzabq();
                ByteBuffer byteBuffer = zzbdpVar.getByteBuffer();
                boolean zzacm = zzbdpVar.zzacm();
                String url = zzbdpVar.getUrl();
                if (url == null) {
                    zzazk.zzex("Stream cache URL is null.");
                    return;
                }
                zzbck zzabp = zzabp();
                this.zzeng = zzabp;
                zzabp.zza(new Uri[]{Uri.parse(url)}, zzabq, byteBuffer, zzacm);
            } else {
                String valueOf = String.valueOf(this.zzenh);
                zzazk.zzex(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                return;
            }
        } else {
            this.zzeng = zzabp();
            String zzabq2 = zzabq();
            Uri[] uriArr = new Uri[this.zzeki.length];
            int i2 = 0;
            while (true) {
                String[] strArr = this.zzeki;
                if (i2 >= strArr.length) {
                    break;
                }
                uriArr[i2] = Uri.parse(strArr[i2]);
                i2++;
            }
            this.zzeng.zza(uriArr, zzabq2);
        }
        this.zzeng.zza(this);
        zza(this.zzblm, false);
        if (this.zzeng.zzaci() != null) {
            int playbackState = this.zzeng.zzaci().getPlaybackState();
            this.zzenj = playbackState;
            if (playbackState == 3) {
                zzabu();
            }
        }
    }

    private final void zzabu() {
        if (this.zzenk) {
            return;
        }
        this.zzenk = true;
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbu
            private final zzbbr zzenn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzenn = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzenn.zzacd();
            }
        });
        zzaaj();
        this.zzeiy.zzfb();
        if (this.zzenl) {
            play();
        }
    }

    private final void zzabv() {
        zzo(this.zzeje, this.zzejf);
    }

    private final void zzabw() {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            zzbckVar.zzax(true);
        }
    }

    private final void zzabx() {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            zzbckVar.zzax(false);
        }
    }

    private final void zzo(int i2, int i3) {
        float f2 = i3 > 0 ? i2 / i3 : 1.0f;
        if (this.zzenm != f2) {
            this.zzenm = f2;
            requestLayout();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final int getCurrentPosition() {
        if (zzabs()) {
            return (int) this.zzeng.zzaci().zzen();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final int getDuration() {
        if (zzabs()) {
            return (int) this.zzeng.zzaci().getDuration();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final long getTotalBytes() {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            return zzbckVar.getTotalBytes();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final int getVideoHeight() {
        return this.zzejf;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final int getVideoWidth() {
        return this.zzeje;
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = this.zzenm;
        if (f2 != 0.0f && this.zzejj == null) {
            float f3 = measuredWidth;
            float f4 = f3 / measuredHeight;
            if (f2 > f4) {
                measuredHeight = (int) (f3 / f2);
            }
            if (f2 < f4) {
                measuredWidth = (int) (measuredHeight * f2);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzbbm zzbbmVar = this.zzejj;
        if (zzbbmVar != null) {
            zzbbmVar.zzm(measuredWidth, measuredHeight);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i5 = this.zzejh;
            if (((i5 > 0 && i5 != measuredWidth) || ((i4 = this.zzeji) > 0 && i4 != measuredHeight)) && this.zzeiz && zzabr()) {
                zzhh zzaci = this.zzeng.zzaci();
                if (zzaci.zzen() > 0 && !zzaci.zzel()) {
                    zza(0.0f, true);
                    zzaci.zzg(true);
                    long zzen = zzaci.zzen();
                    long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis();
                    while (zzabr() && zzaci.zzen() == zzen && com.google.android.gms.ads.internal.zzr.zzky().currentTimeMillis() - currentTimeMillis <= 250) {
                    }
                    zzaci.zzg(false);
                    zzaaj();
                }
            }
            this.zzejh = measuredWidth;
            this.zzeji = measuredHeight;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        if (this.zzejk) {
            zzbbm zzbbmVar = new zzbbm(getContext());
            this.zzejj = zzbbmVar;
            zzbbmVar.zza(surfaceTexture, i2, i3);
            this.zzejj.start();
            SurfaceTexture zzaax = this.zzejj.zzaax();
            if (zzaax != null) {
                surfaceTexture = zzaax;
            } else {
                this.zzejj.zzaaw();
                this.zzejj = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzblm = surface;
        if (this.zzeng == null) {
            zzabt();
        } else {
            zza(surface, true);
            if (!this.zzenf.zzelf) {
                zzabw();
            }
        }
        if (this.zzeje != 0 && this.zzejf != 0) {
            zzabv();
        } else {
            zzo(i2, i3);
        }
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbx
            private final zzbbr zzenn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzenn = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzenn.zzabz();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbbm zzbbmVar = this.zzejj;
        if (zzbbmVar != null) {
            zzbbmVar.zzaaw();
            this.zzejj = null;
        }
        if (this.zzeng != null) {
            zzabx();
            Surface surface = this.zzblm;
            if (surface != null) {
                surface.release();
            }
            this.zzblm = null;
            zza((Surface) null, true);
        }
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbz
            private final zzbbr zzenn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzenn = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzenn.zzaby();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i2, final int i3) {
        zzbbm zzbbmVar = this.zzejj;
        if (zzbbmVar != null) {
            zzbbmVar.zzm(i2, i3);
        }
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this, i2, i3) { // from class: com.google.android.gms.internal.ads.zzbca
            private final int zzefe;
            private final int zzeff;
            private final zzbbr zzenn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzenn = this;
                this.zzefe = i2;
                this.zzeff = i3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzenn.zzp(this.zzefe, this.zzeff);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeiy.zzc(this);
        this.zzeju.zza(surfaceTexture, this.zzejm);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i2);
        com.google.android.gms.ads.internal.util.zzd.zzeb(sb.toString());
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this, i2) { // from class: com.google.android.gms.internal.ads.zzbcc
            private final int zzefe;
            private final zzbbr zzenn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzenn = this;
                this.zzefe = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzenn.zzdr(this.zzefe);
            }
        });
        super.onWindowVisibilityChanged(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void pause() {
        if (zzabs()) {
            if (this.zzenf.zzelf) {
                zzabx();
            }
            this.zzeng.zzaci().zzg(false);
            this.zzeiy.zzaba();
            this.zzejv.zzaba();
            com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbby
                private final zzbbr zzenn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzenn = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzenn.zzaca();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void play() {
        if (zzabs()) {
            if (this.zzenf.zzelf) {
                zzabw();
            }
            this.zzeng.zzaci().zzg(true);
            this.zzeiy.zzaaz();
            this.zzejv.zzaaz();
            this.zzeju.zzaal();
            com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbv
                private final zzbbr zzenn;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzenn = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzenn.zzacb();
                }
            });
            return;
        }
        this.zzenl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void seekTo(int i2) {
        if (zzabs()) {
            this.zzeng.zzaci().seekTo(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzenh = str;
            this.zzeki = new String[]{str};
            zzabt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void stop() {
        if (zzabr()) {
            this.zzeng.zzaci().stop();
            if (this.zzeng != null) {
                zza((Surface) null, true);
                zzbck zzbckVar = this.zzeng;
                if (zzbckVar != null) {
                    zzbckVar.zza((zzbcu) null);
                    this.zzeng.release();
                    this.zzeng = null;
                }
                this.zzenj = 1;
                this.zzeni = false;
                this.zzenk = false;
                this.zzenl = false;
            }
        }
        this.zzeiy.zzaba();
        this.zzejv.zzaba();
        this.zzeiy.onStop();
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final String zzaad() {
        String str = this.zzejk ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final long zzaah() {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            return zzbckVar.zzaah();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final int zzaai() {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            return zzbckVar.zzaai();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbav, com.google.android.gms.internal.ads.zzbbs
    public final void zzaaj() {
        zza(this.zzejv.getVolume(), false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaby() {
        zzbaw zzbawVar = this.zzejm;
        if (zzbawVar != null) {
            zzbawVar.zzaan();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzabz() {
        zzbaw zzbawVar = this.zzejm;
        if (zzbawVar != null) {
            zzbawVar.zzaak();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzaca() {
        zzbaw zzbawVar = this.zzejm;
        if (zzbawVar != null) {
            zzbawVar.onPaused();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacb() {
        zzbaw zzbawVar = this.zzejm;
        if (zzbawVar != null) {
            zzbawVar.zzaal();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacc() {
        zzbaw zzbawVar = this.zzejm;
        if (zzbawVar != null) {
            zzbawVar.zzaam();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzacd() {
        zzbaw zzbawVar = this.zzejm;
        if (zzbawVar != null) {
            zzbawVar.zzfb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzenh = str;
            this.zzeki = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzabt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(boolean z, long j2) {
        this.zzeix.zza(z, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void zzdk(int i2) {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            zzbckVar.zzacl().zzds(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void zzdl(int i2) {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            zzbckVar.zzacl().zzdt(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void zzdm(int i2) {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            zzbckVar.zzacl().zzdm(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void zzdn(int i2) {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            zzbckVar.zzacl().zzdn(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void zzdo(int i2) {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            zzbckVar.zzdo(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final void zzdq(int i2) {
        if (this.zzenj != i2) {
            this.zzenj = i2;
            if (i2 == 3) {
                zzabu();
            } else if (i2 != 4) {
            } else {
                if (this.zzenf.zzelf) {
                    zzabx();
                }
                this.zzeiy.zzaba();
                this.zzejv.zzaba();
                com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbbt
                    private final zzbbr zzenn;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzenn = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzenn.zzacc();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzdr(int i2) {
        zzbaw zzbawVar = this.zzejm;
        if (zzbawVar != null) {
            zzbawVar.onWindowVisibilityChanged(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzfd(String str) {
        zzbaw zzbawVar = this.zzejm;
        if (zzbawVar != null) {
            zzbawVar.zzl("ExoPlayerAdapter error", str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final void zzn(int i2, int i3) {
        this.zzeje = i2;
        this.zzejf = i3;
        zzabv();
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final long zznb() {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            return zzbckVar.zznb();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(int i2, int i3) {
        zzbaw zzbawVar = this.zzejm;
        if (zzbawVar != null) {
            zzbawVar.zzk(i2, i3);
        }
    }

    private final void zza(float f2, boolean z) {
        zzbck zzbckVar = this.zzeng;
        if (zzbckVar != null) {
            zzbckVar.zzb(f2, z);
        } else {
            zzazk.zzex("Trying to set volume before player is initalized.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final void zzb(final boolean z, final long j2) {
        if (this.zzeix != null) {
            zzazp.zzeig.execute(new Runnable(this, z, j2) { // from class: com.google.android.gms.internal.ads.zzbcb
                private final boolean zzekn;
                private final zzbbr zzenn;
                private final long zzeno;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzenn = this;
                    this.zzekn = z;
                    this.zzeno = j2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzenn.zzc(this.zzekn, this.zzeno);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void zza(zzbaw zzbawVar) {
        this.zzejm = zzbawVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbav
    public final void zza(float f2, float f3) {
        zzbbm zzbbmVar = this.zzejj;
        if (zzbbmVar != null) {
            zzbbmVar.zzb(f2, f3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcu
    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        final String sb2 = sb.toString();
        String valueOf = String.valueOf(sb2);
        zzazk.zzex(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzeni = true;
        if (this.zzenf.zzelf) {
            zzabx();
        }
        com.google.android.gms.ads.internal.util.zzj.zzeen.post(new Runnable(this, sb2) { // from class: com.google.android.gms.internal.ads.zzbbw
            private final String zzdjf;
            private final zzbbr zzenn;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzenn = this;
                this.zzdjf = sb2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzenn.zzfd(this.zzdjf);
            }
        });
    }
}
