package com.hw.photomovie.e;
/* compiled from: IMovieTimer.java */
/* loaded from: classes2.dex */
public interface a {

    /* compiled from: IMovieTimer.java */
    /* renamed from: com.hw.photomovie.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0200a {
        void onMovieEnd();

        void onMovieResumed();

        void onMovieStarted();

        void onMovieUpdate(int i2);

        void onMoviedPaused();
    }

    void a(InterfaceC0200a interfaceC0200a);

    void pause();

    void start();
}
