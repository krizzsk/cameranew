package us.pinguo.inspire_proxy.media;

import android.view.View;
import androidx.annotation.NonNull;
import tv.danmaku.ijk.media.player.IMediaPlayer;
/* compiled from: IRenderView.java */
/* loaded from: classes4.dex */
public interface g {

    /* compiled from: IRenderView.java */
    /* loaded from: classes4.dex */
    public interface a {
        void a(@NonNull b bVar);

        void b(@NonNull b bVar, int i2, int i3);

        void c(@NonNull b bVar, int i2, int i3, int i4);
    }

    /* compiled from: IRenderView.java */
    /* loaded from: classes4.dex */
    public interface b {
        @NonNull
        g a();

        void b(IMediaPlayer iMediaPlayer);
    }

    void a(@NonNull a aVar);

    boolean b();

    void c(@NonNull a aVar);

    View getView();

    void setAspectRatio(int i2);

    void setVideoRotation(int i2);

    void setVideoSampleAspectRatio(int i2, int i3);

    void setVideoSize(int i2, int i3);
}
