package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.ads.zzaav;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzzc;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object a = new Object();
    @Nullable
    @GuardedBy("lock")
    private zzzc b;
    @Nullable
    @GuardedBy("lock")
    private VideoLifecycleCallbacks c;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    @Deprecated
    public final float getAspectRatio() {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return 0.0f;
            }
            try {
                return zzzcVar.getAspectRatio();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call getAspectRatio on video controller.", e2);
                return 0.0f;
            }
        }
    }

    public final int getPlaybackState() {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return 0;
            }
            try {
                return zzzcVar.getPlaybackState();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call getPlaybackState on video controller.", e2);
                return 0;
            }
        }
    }

    public final float getVideoCurrentTime() {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return 0.0f;
            }
            try {
                return zzzcVar.getCurrentTime();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call getCurrentTime on video controller.", e2);
                return 0.0f;
            }
        }
    }

    public final float getVideoDuration() {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return 0.0f;
            }
            try {
                return zzzcVar.getDuration();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call getDuration on video controller.", e2);
                return 0.0f;
            }
        }
    }

    @Nullable
    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.a) {
            videoLifecycleCallbacks = this.c;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.a) {
            z = this.b != null;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return false;
            }
            try {
                return zzzcVar.isClickToExpandEnabled();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call isClickToExpandEnabled.", e2);
                return false;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return false;
            }
            try {
                return zzzcVar.isCustomControlsEnabled();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call isUsingCustomPlayerControls.", e2);
                return false;
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return true;
            }
            try {
                return zzzcVar.isMuted();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call isMuted on video controller.", e2);
                return true;
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return;
            }
            try {
                zzzcVar.mute(z);
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call mute on video controller.", e2);
            }
        }
    }

    public final void pause() {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return;
            }
            try {
                zzzcVar.pause();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call pause on video controller.", e2);
            }
        }
    }

    public final void play() {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return;
            }
            try {
                zzzcVar.play();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call play on video controller.", e2);
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        q.k(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.a) {
            this.c = videoLifecycleCallbacks;
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return;
            }
            try {
                zzzcVar.zza(new zzaav(videoLifecycleCallbacks));
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e2);
            }
        }
    }

    public final void stop() {
        synchronized (this.a) {
            zzzc zzzcVar = this.b;
            if (zzzcVar == null) {
                return;
            }
            try {
                zzzcVar.stop();
            } catch (RemoteException e2) {
                zzazk.zzc("Unable to call stop on video controller.", e2);
            }
        }
    }

    public final void zza(zzzc zzzcVar) {
        synchronized (this.a) {
            this.b = zzzcVar;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.c;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    public final zzzc zzdw() {
        zzzc zzzcVar;
        synchronized (this.a) {
            zzzcVar = this.b;
        }
        return zzzcVar;
    }
}
