package com.bytedance.sdk.openadsdk.core;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* compiled from: SingleAppData.java */
/* loaded from: classes.dex */
public class s {
    private static s a;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.c b;

    /* renamed from: d  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.d.h f1754d;

    /* renamed from: e  reason: collision with root package name */
    private TTRewardVideoAd.RewardAdInteractionListener f1755e;

    /* renamed from: f  reason: collision with root package name */
    private d.a.a.a.a.a.b f1756f;

    /* renamed from: g  reason: collision with root package name */
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f1757g;
    private boolean c = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1758h = false;

    private s() {
    }

    @MainThread
    public static s a() {
        if (a == null) {
            a = new s();
        }
        return a;
    }

    public boolean b() {
        return this.c;
    }

    @NonNull
    public com.bytedance.sdk.openadsdk.core.d.h c() {
        return this.f1754d;
    }

    public TTRewardVideoAd.RewardAdInteractionListener d() {
        return this.f1755e;
    }

    public TTFullScreenVideoAd.FullScreenVideoAdInteractionListener e() {
        return this.f1757g;
    }

    public d.a.a.a.a.a.b f() {
        return this.f1756f;
    }

    public void g() {
        this.b = null;
        this.f1754d = null;
        this.f1755e = null;
        this.f1757g = null;
        this.f1756f = null;
        this.f1758h = false;
        this.c = true;
    }

    public void b(boolean z) {
        this.f1758h = z;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.h hVar) {
        this.f1754d = hVar;
    }

    public void a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f1757g = fullScreenVideoAdInteractionListener;
    }

    public void a(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f1755e = rewardAdInteractionListener;
    }

    public void a(d.a.a.a.a.a.b bVar) {
        this.f1756f = bVar;
    }
}
