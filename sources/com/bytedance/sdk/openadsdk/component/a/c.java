package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.x;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TTFeedAdImpl.java */
/* loaded from: classes.dex */
public class c extends com.bytedance.sdk.openadsdk.core.e.a implements TTFeedAd, c.b, c.InterfaceC0056c, a.InterfaceC0065a {
    com.bytedance.sdk.openadsdk.multipro.b.a a;
    boolean b;
    boolean c;

    /* renamed from: d  reason: collision with root package name */
    int f1423d;

    /* renamed from: e  reason: collision with root package name */
    AdSlot f1424e;

    /* renamed from: f  reason: collision with root package name */
    int f1425f;
    private TTFeedAd.VideoAdListener m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@NonNull Context context, @NonNull h hVar, int i2) {
        super(context, hVar, i2);
        this.b = false;
        this.c = true;
        this.f1425f = i2;
        this.a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        int d2 = ab.d(this.f1626h.M());
        this.f1423d = d2;
        a(d2);
        a("embeded_ad");
    }

    public void c() {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdContinuePlay(this);
        }
    }

    public void d() {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdPaused(this);
        }
    }

    public void d_() {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdComplete(this);
        }
    }

    public void e() {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdStartPlay(this);
        }
    }

    public void f() {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoLoad(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeVideoTsView nativeVideoTsView;
        h hVar = this.f1626h;
        if (hVar != null && this.f1627i != null) {
            if (x.a(hVar)) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.f1627i, this.f1626h);
                    if (x.b(this.f1626h)) {
                        nativeVideoTsView.setVideoAdClickListener(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.component.a.c.1
                            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                            public void a(View view, int i2) {
                                if (((com.bytedance.sdk.openadsdk.core.e.a) c.this).f1625g != null) {
                                    ((com.bytedance.sdk.openadsdk.core.e.a) c.this).f1625g.a(view, i2);
                                }
                            }
                        });
                    }
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.component.a.c.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j2, long j3, long j4, boolean z2) {
                            com.bytedance.sdk.openadsdk.multipro.b.a aVar = c.this.a;
                            aVar.a = z;
                            aVar.f2094e = j2;
                            aVar.f2095f = j3;
                            aVar.f2096g = j4;
                            aVar.f2093d = z2;
                        }
                    });
                    nativeVideoTsView.setVideoAdLoadListener(this);
                    nativeVideoTsView.setVideoAdInteractionListener(this);
                    if (5 == this.f1425f) {
                        nativeVideoTsView.setIsAutoPlay(this.b ? this.f1424e.isAutoPlay() : this.c);
                    } else {
                        nativeVideoTsView.setIsAutoPlay(this.c);
                    }
                    nativeVideoTsView.setIsQuiet(o.h().a(this.f1423d));
                } catch (Exception unused) {
                }
                if (!x.a(this.f1626h) && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
                    return nativeVideoTsView;
                }
            }
            nativeVideoTsView = null;
            if (!x.a(this.f1626h)) {
            }
        }
        return null;
    }

    public double getVideoDuration() {
        h hVar = this.f1626h;
        return (hVar == null || hVar.v() == null) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : this.f1626h.v().e();
    }

    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        this.m = videoAdListener;
    }

    private void a(int i2) {
        int c = o.h().c(i2);
        if (3 == c) {
            this.b = false;
            this.c = false;
        } else if (1 == c && q.d(this.f1627i)) {
            this.b = false;
            this.c = true;
        } else if (2 != c) {
            if (4 == c) {
                this.b = true;
            }
        } else if (q.e(this.f1627i) || q.d(this.f1627i)) {
            this.b = false;
            this.c = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@NonNull Context context, @NonNull h hVar, int i2, AdSlot adSlot) {
        super(context, hVar, i2);
        this.b = false;
        this.c = true;
        this.f1425f = i2;
        this.f1424e = adSlot;
        this.a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        int d2 = ab.d(this.f1626h.M());
        this.f1423d = d2;
        a(d2);
        a("embeded_ad");
    }

    public void a(int i2, int i3) {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoError(i2, i3);
        }
    }

    public void a(long j2, long j3) {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onProgressUpdate(j2, j3);
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.e.a
    public void a(String str) {
        super.a(str);
    }
}
