package com.unity3d.splash;

import android.app.Activity;
/* loaded from: classes3.dex */
public final class UnityAds {
    private static boolean a = false;

    /* loaded from: classes3.dex */
    public enum FinishState {
        ERROR,
        SKIPPED,
        COMPLETED
    }

    /* loaded from: classes3.dex */
    public enum PlacementState {
        READY,
        NOT_AVAILABLE,
        DISABLED,
        WAITING,
        NO_FILL
    }

    /* loaded from: classes3.dex */
    public enum UnityAdsError {
        NOT_INITIALIZED,
        INITIALIZE_FAILED,
        INVALID_ARGUMENT,
        VIDEO_PLAYER_ERROR,
        INIT_SANITY_CHECK_FAIL,
        AD_BLOCKER_DETECTED,
        FILE_IO_ERROR,
        DEVICE_ID_ERROR,
        SHOW_ERROR,
        INTERNAL_ERROR
    }

    public static void a(Activity activity, String str, a aVar) {
        com.unity3d.splash.services.b.a.b(activity, str, aVar, false, false);
    }

    public static boolean b() {
        return a;
    }

    public static void c(boolean z) {
        a = z;
    }
}
