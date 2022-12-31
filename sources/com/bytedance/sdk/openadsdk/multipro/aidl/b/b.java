package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IRewardAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
/* compiled from: RewardVideoListenerImpl.java */
/* loaded from: classes.dex */
public class b extends IRewardAdInteractionListener.Stub {
    private TTRewardVideoAd.RewardAdInteractionListener a;
    private Handler b = new Handler(Looper.getMainLooper());

    public b(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.a = rewardAdInteractionListener;
    }

    private Handler b() {
        Handler handler = this.b;
        if (handler == null) {
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.b = handler2;
            return handler2;
        }
        return handler;
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a != null) {
                    b.this.a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.1
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a != null) {
                    b.this.a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a != null) {
                    b.this.a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onRewardVerify(final boolean z, final int i2, final String str) throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.7
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a != null) {
                    b.this.a.onRewardVerify(z, i2, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.6
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a != null) {
                    b.this.a.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.4
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a != null) {
                    b.this.a.onVideoComplete();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
    public void onVideoError() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a != null) {
                    b.this.a.onVideoError();
                }
            }
        });
    }

    private void a() {
        this.a = null;
        this.b = null;
    }
}
