package com.bytedance.sdk.openadsdk.core.video.e;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
/* compiled from: IMediaPlayer.java */
/* loaded from: classes.dex */
public interface c {

    /* compiled from: IMediaPlayer.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(c cVar, int i2);
    }

    /* compiled from: IMediaPlayer.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar);
    }

    /* compiled from: IMediaPlayer.java */
    /* renamed from: com.bytedance.sdk.openadsdk.core.video.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0054c {
        boolean a(c cVar, int i2, int i3);
    }

    /* compiled from: IMediaPlayer.java */
    /* loaded from: classes.dex */
    public interface d {
        boolean b(c cVar, int i2, int i3);
    }

    /* compiled from: IMediaPlayer.java */
    /* loaded from: classes.dex */
    public interface e {
        void b(c cVar);
    }

    /* compiled from: IMediaPlayer.java */
    /* loaded from: classes.dex */
    public interface f {
        void c(c cVar);
    }

    /* compiled from: IMediaPlayer.java */
    /* loaded from: classes.dex */
    public interface g {
        void a(c cVar, int i2, int i3, int i4, int i5);
    }

    void a(float f2, float f3) throws Throwable;

    void a(long j2) throws Throwable;

    @Deprecated
    void a(Context context, int i2) throws Throwable;

    void a(Surface surface) throws Throwable;

    void a(SurfaceHolder surfaceHolder) throws Throwable;

    void a(a aVar);

    void a(b bVar);

    void a(InterfaceC0054c interfaceC0054c);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void a(g gVar);

    void a(FileDescriptor fileDescriptor) throws Throwable;

    void a(String str) throws Throwable;

    void a(String str, String str2);

    void a(boolean z) throws Throwable;

    void b(boolean z) throws Throwable;

    void f() throws Throwable;

    void g() throws Throwable;

    void h() throws Throwable;

    long i() throws Throwable;

    long j() throws Throwable;

    void k() throws Throwable;

    void l() throws Throwable;
}
