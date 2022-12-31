package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.action.UserReturnTracker$UserReturnListener;
import com.facebook.ads.redexgen.X.C04830m;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
/* renamed from: com.facebook.ads.redexgen.X.0m  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C04830m {
    public static byte[] A06;
    public static String[] A07 = {"jY95Z4e8SjES", "FWAQk0vwFzOT3H3ejUps9E7fwyQUHgqv", "R9UUrzGy7cjs1hDg6byYlCYbXfp8nW0w", "dKAdSxu4tDkfYe86wdSSQ2n2Du5", "FgFVZj7d091u9rUO", "kSt0PMlvWs2DEAK3GKEU98UDJan6EgWc", "nGXCIrfUxBd8PJB10o2gs7oQf", "n"};
    @Nullable
    public Application A01;
    @Nullable
    public UserReturnTracker$UserReturnListener A03;
    public final JT A05;
    public long A00 = 0;
    @Nullable
    public String A04 = null;
    @Nullable
    public EnumC04760e A02 = null;

    public static String A02(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A06, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 108);
        }
        return new String(copyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{44, 47, 45, 37, 17, 58, 39, 35, 43, 8, 1, 5, 18, 1, 59, 16, Draft_75.CR, 9, 1, 10, 16, 17, 6, 10, 8, 0};
    }

    static {
        A03();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.facebook.ads.internal.action.UserReturnTracker$UserReturnListener] */
    public C04830m(JT jt, final Activity activity, int i2) {
        this.A05 = jt;
        this.A01 = activity.getApplication();
        this.A03 = new Application.ActivityLifecycleCallbacks(activity, this) { // from class: com.facebook.ads.internal.action.UserReturnTracker$UserReturnListener
            @Nullable
            public C04830m A00;
            public final WeakReference<Activity> A01;

            {
                this.A01 = new WeakReference<>(activity);
                this.A00 = this;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityCreated(Activity activity2, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityDestroyed(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityPaused(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity2) {
                if (this.A00 == null) {
                    return;
                }
                Activity activity3 = this.A01.get();
                if (activity3 == null || activity2.equals(activity3)) {
                    this.A00.A05();
                    this.A00 = null;
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivitySaveInstanceState(Activity activity2, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStarted(Activity activity2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityStopped(Activity activity2) {
            }
        };
    }

    public static C04830m A00(JT jt, Activity activity) {
        return A01(jt, activity, Build.VERSION.SDK_INT);
    }

    @Nullable
    @VisibleForTesting
    public static C04830m A01(JT jt, Activity activity, int i2) {
        if (activity != null && i2 >= 14) {
            return new C04830m(jt, activity, i2);
        }
        return null;
    }

    private void A04(String str, long j2, long j3, @Nullable EnumC04760e enumC04760e) {
        HashMap hashMap = new HashMap();
        hashMap.put(A02(9, 10, 8), Long.toString(j2));
        hashMap.put(A02(0, 9, 34), Long.toString(j3));
        if (enumC04760e != null) {
            hashMap.put(A02(19, 7, 9), enumC04760e.name());
        }
        this.A05.A9F(str, hashMap);
    }

    @TargetApi(14)
    public final void A05() {
        UserReturnTracker$UserReturnListener userReturnTracker$UserReturnListener;
        A04(this.A04, this.A00, System.currentTimeMillis(), this.A02);
        Application application = this.A01;
        if (application != null && (userReturnTracker$UserReturnListener = this.A03) != null) {
            application.unregisterActivityLifecycleCallbacks(userReturnTracker$UserReturnListener);
            this.A03 = null;
            this.A01 = null;
        }
    }

    public final void A06(@Nullable EnumC04760e enumC04760e) {
        this.A02 = enumC04760e;
    }

    @TargetApi(14)
    public final void A07(String str) {
        this.A04 = str;
        if (this.A03 != null && this.A01 != null) {
            this.A00 = System.currentTimeMillis();
            this.A01.registerActivityLifecycleCallbacks(this.A03);
            return;
        }
        EnumC04760e enumC04760e = EnumC04760e.A03;
        if (A07[2].charAt(6) == '9') {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[5] = "8mgXQ8lZ1oxTn8xtWXCDJO1aYxf7Xnbe";
        strArr[1] = "RSHxB9AoZRnm9g8NXStW2wWwzMRvBUbh";
        A04(str, -1L, -1L, enumC04760e);
    }
}
