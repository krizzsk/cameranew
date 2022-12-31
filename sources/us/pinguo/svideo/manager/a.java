package us.pinguo.svideo.manager;

import android.media.MediaPlayer;
/* compiled from: MediaPlayerManager.java */
/* loaded from: classes6.dex */
public class a {
    private MediaPlayer a;

    public static a b() {
        return new a();
    }

    public void a() {
        this.a = new MediaPlayer();
    }

    public void c() {
        this.a.release();
        this.a = null;
    }

    public void d() {
        if (this.a.isPlaying()) {
            this.a.stop();
        }
    }
}
