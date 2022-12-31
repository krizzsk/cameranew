package com.bytedance.sdk.openadsdk.multipro.aidl.b;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
/* compiled from: FullScreenVideoListenerImpl.java */
/* loaded from: classes.dex */
public class a extends IFullScreenVideoAdInteractionListener.Stub {
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener a;
    private Handler b = new Handler(Looper.getMainLooper());

    public a(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.a = fullScreenVideoAdInteractionListener;
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

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdClose() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a != null) {
                    a.this.a.onAdClose();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdShow() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a != null) {
                    a.this.a.onAdShow();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a != null) {
                    a.this.a.onAdVideoBarClick();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onDestroy() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onSkippedVideo() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a != null) {
                    a.this.a.onSkippedVideo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
    public void onVideoComplete() throws RemoteException {
        b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.b.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.a != null) {
                    a.this.a.onVideoComplete();
                }
            }
        });
    }

    private void a() {
        this.a = null;
        this.b = null;
    }
}
