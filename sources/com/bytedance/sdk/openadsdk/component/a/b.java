package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.x;
/* compiled from: TTDrawFeedAdImpl.java */
/* loaded from: classes.dex */
public class b extends c implements TTDrawFeedAd {
    private boolean m;
    private Bitmap n;
    private int o;
    private TTDrawFeedAd.DrawVideoListener p;

    public b(@NonNull Context context, @NonNull h hVar, int i2) {
        super(context, hVar, i2);
        a("embeded_ad");
    }

    private void g() {
        int i2 = this.o;
        if (i2 >= 200) {
            this.o = 200;
        } else if (i2 <= 20) {
            this.o = 20;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.multipro.b.a.InterfaceC0065a
    public /* bridge */ /* synthetic */ com.bytedance.sdk.openadsdk.multipro.b.a a() {
        return super.a();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void d_() {
        super.d_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0056c
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeDrawVideoTsView nativeDrawVideoTsView;
        h hVar = this.f1626h;
        if (hVar != null && this.f1627i != null) {
            if (x.a(hVar)) {
                try {
                    nativeDrawVideoTsView = new NativeDrawVideoTsView(this.f1627i, this.f1626h);
                    nativeDrawVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.component.a.b.1
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j2, long j3, long j4, boolean z2) {
                            com.bytedance.sdk.openadsdk.multipro.b.a aVar = ((c) b.this).a;
                            aVar.a = z;
                            aVar.f2094e = j2;
                            aVar.f2095f = j3;
                            aVar.f2096g = j4;
                            aVar.f2093d = z2;
                        }
                    });
                    nativeDrawVideoTsView.setVideoAdLoadListener(this);
                    nativeDrawVideoTsView.setVideoAdInteractionListener(this);
                    int d2 = ab.d(this.f1626h.M());
                    nativeDrawVideoTsView.setIsAutoPlay(a(d2));
                    nativeDrawVideoTsView.setIsQuiet(o.h().a(d2));
                    nativeDrawVideoTsView.setCanInterruptVideoPlay(this.m);
                    Bitmap bitmap = this.n;
                    if (bitmap != null) {
                        nativeDrawVideoTsView.a(bitmap, this.o);
                    }
                    nativeDrawVideoTsView.setDrawVideoListener(this.p);
                } catch (Exception unused) {
                }
                if (!x.a(this.f1626h) && nativeDrawVideoTsView != null && nativeDrawVideoTsView.a(0L, true, false)) {
                    return nativeDrawVideoTsView;
                }
            }
            nativeDrawVideoTsView = null;
            if (!x.a(this.f1626h)) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ double getVideoDuration() {
        return super.getVideoDuration();
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setCanInterruptVideoPlay(boolean z) {
        this.m = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.p = drawVideoListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setPauseIcon(Bitmap bitmap, int i2) {
        this.n = bitmap;
        this.o = i2;
        g();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        super.setVideoAdListener(videoAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0056c
    public /* bridge */ /* synthetic */ void a(int i2, int i3) {
        super.a(i2, i3);
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void a(long j2, long j3) {
        super.a(j2, j3);
    }

    private boolean a(int i2) {
        int c = o.h().c(i2);
        if (3 == c) {
            return false;
        }
        if (1 != c || !q.d(this.f1627i)) {
            if (2 != c) {
                return false;
            }
            if (!q.e(this.f1627i) && !q.d(this.f1627i)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.e.a
    protected void a(String str) {
        super.a(str);
    }
}
