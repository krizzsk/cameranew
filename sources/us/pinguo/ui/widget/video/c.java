package us.pinguo.ui.widget.video;
/* compiled from: IVideoPlayer.java */
/* loaded from: classes6.dex */
public interface c {

    /* compiled from: IVideoPlayer.java */
    /* loaded from: classes6.dex */
    public interface a {
        void onBufferingUpdate(int i2);
    }

    /* compiled from: IVideoPlayer.java */
    /* loaded from: classes6.dex */
    public interface b {
        void onComplete();
    }

    /* compiled from: IVideoPlayer.java */
    /* renamed from: us.pinguo.ui.widget.video.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0457c {
        void onPrepared();
    }

    void a();

    void b();

    void c(BaseVideoTextureView baseVideoTextureView);

    void d();

    void f();

    boolean isPlaying();
}
