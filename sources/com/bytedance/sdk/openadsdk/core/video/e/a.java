package com.bytedance.sdk.openadsdk.core.video.e;

import com.bytedance.sdk.openadsdk.core.video.e.c;
import com.bytedance.sdk.openadsdk.utils.o;
/* compiled from: AbstractMediaPlayer.java */
/* loaded from: classes.dex */
public abstract class a implements c {
    private c.e a;
    private c.b b;
    private c.a c;

    /* renamed from: d  reason: collision with root package name */
    private c.f f1802d;

    /* renamed from: e  reason: collision with root package name */
    private c.g f1803e;

    /* renamed from: f  reason: collision with root package name */
    private c.InterfaceC0054c f1804f;

    /* renamed from: g  reason: collision with root package name */
    private c.d f1805g;

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.e eVar) {
        this.a = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        try {
            c.e eVar = this.a;
            if (eVar != null) {
                eVar.b(this);
            }
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        try {
            c.b bVar = this.b;
            if (bVar != null) {
                bVar.a(this);
            }
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        try {
            c.f fVar = this.f1802d;
            if (fVar != null) {
                fVar.c(this);
            }
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.b bVar) {
        this.b = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.a aVar) {
        this.c = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.f fVar) {
        this.f1802d = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(int i2, int i3) {
        try {
            c.d dVar = this.f1805g;
            if (dVar != null) {
                return dVar.b(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.InterfaceC0054c interfaceC0054c) {
        this.f1804f = interfaceC0054c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.d dVar) {
        this.f1805g = dVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c
    public final void a(c.g gVar) {
        this.f1803e = gVar;
    }

    public void a() {
        this.a = null;
        this.c = null;
        this.b = null;
        this.f1802d = null;
        this.f1803e = null;
        this.f1804f = null;
        this.f1805g = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i2) {
        try {
            c.a aVar = this.c;
            if (aVar != null) {
                aVar.a(this, i2);
            }
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i2, int i3, int i4, int i5) {
        try {
            c.g gVar = this.f1803e;
            if (gVar != null) {
                gVar.a(this, i2, i3, i4, i5);
            }
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(int i2, int i3) {
        try {
            c.InterfaceC0054c interfaceC0054c = this.f1804f;
            if (interfaceC0054c != null) {
                return interfaceC0054c.a(this, i2, i3);
            }
            return false;
        } catch (Throwable th) {
            o.c("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }
}
