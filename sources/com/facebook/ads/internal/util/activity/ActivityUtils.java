package com.facebook.ads.internal.util.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.util.common.ANActivityLifecycleCallbacksListener;
import com.facebook.ads.redexgen.X.C06808m;
import com.facebook.ads.redexgen.X.C06818n;
import com.facebook.ads.redexgen.X.JD;
import com.facebook.ads.redexgen.X.L8;
import com.facebook.ads.redexgen.X.LA;
import com.facebook.ads.redexgen.X.LB;
import com.facebook.ads.redexgen.X.LF;
import com.facebook.ads.redexgen.X.M1;
import com.facebook.ads.redexgen.X.XS;
import com.facebook.ads.redexgen.X.XT;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: assets/audience_network.dex */
public final class ActivityUtils implements Application.ActivityLifecycleCallbacks {
    public static Context A01;
    public static XS A02;
    public static byte[] A03;
    public static String[] A04 = {"ouMPsLdF8VOzsynXqmRiTnVq9sCULlEK", "RDluICFSUJyOT3sC2lXOFgStPQc7gg7Y", "UmtUlnThENixw5hdz8sG1KFdsGmJDk97", "fTn296Ch3TXxkAVBDyGQxp9TrJ", "IUqXVRs0X8uhoFuXuWrDHC", "AqSoSQ8lTXl56yd6tw1FPxb5AEpw6", "5ylHfIThOZnGyEtaFkstDkkPbeVs18fd", "i0x"};
    public static final LF A05;
    public static final List<LB> A06;
    public static final List<Runnable> A07;
    public static final Map<Activity, Integer> A08;
    public final Class<? extends Activity> A00;

    public static String A01(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        int i5 = 0;
        while (true) {
            int length = copyOfRange.length;
            String[] strArr = A04;
            if (strArr[4].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[4] = "4AKSMNDzmxTAf23dNNcZP8";
            strArr2[7] = "cH1";
            if (i5 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 12);
            i5++;
        }
    }

    public static void A02() {
        A03 = new byte[]{54, 58, 91, 121, 110, 115, 108, 115, 110, 99, 32, 58, 92, 80, 2, 21, 22, 74, 80, 115, 81, 70, 91, 68, 91, 70, 75, 18, 86, 91, 65, 81, 64, 87, 66, 83, 92, 81, 91, 87, 65, 28, 55, 6, 6, 53, 25, 24, 2, 19, 14, 2, 86, 31, 5, 86, 24, 25, 2, 86, 55, 6, 6, 26, 31, 21, 23, 2, 31, 25, 24, 88, 40, 4, 5, 8, 30, 25, 25, 14, 5, 31, 75, 6, 4, 15, 2, Draft_75.CR, 2, 8, 10, 31, 2, 4, 5, 75, 14, 19, 8, 14, 27, 31, 2, 4, 5, 75, 31, 3, 25, 4, 28, 5, 15, 30, 25, 2, 5, 12, 75, 25, 14, 12, 2, 24, 31, 14, 25, 42, 8, 31, 2, 29, 2, 31, 18, 40, 10, 7, 7, 9, 10, 8, 0, 24, 39, 2, 24, 31, 14, 5, 14, 25, 10, 41, 33, 101, 36, 38, 49, 44, 51, 44, 49, 60, 101, 54, 49, 36, 49, 32, Byte.MAX_VALUE, 101, 115, 66, 86, 80, 70, 71, 3, 66, 64, 87, 74, 85, 74, 87, 90, 3, 74, 80, 3, 77, 76, 87, 3, 81, 70, 80, 86, 78, 70, 71, Draft_75.CR, 74, 125, 107, 34, 56, 31, 29, 10, 33, 11, 10, 23, 18, 4, 21, 12};
    }

    static {
        A02();
        A08 = Collections.synchronizedMap(new WeakHashMap());
        A06 = Collections.synchronizedList(new ArrayList());
        A07 = new ArrayList();
        A05 = LF.A00();
    }

    public ActivityUtils(Class<? extends Activity> adsActivityClass) {
        this.A00 = adsActivityClass;
    }

    @Nullable
    public static synchronized Activity A00() {
        synchronized (ActivityUtils.class) {
            Activity lastResumedActivity = null;
            Iterator<Map.Entry<Activity, Integer>> it = A08.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Activity, Integer> next = it.next();
                if (next.getValue().intValue() == 3) {
                    Activity lastResumedActivity2 = next.getKey();
                    lastResumedActivity = lastResumedActivity2;
                    break;
                }
            }
            Activity activity = null;
            boolean z = lastResumedActivity == null || Build.VERSION.SDK_INT < 28;
            if (z) {
                activity = L8.A00();
            }
            if (A02 != null && z && lastResumedActivity != activity) {
                String A012 = A01(19, 23, 62);
                C06818n c06818n = new C06818n(A012, A01(203, 5, 20) + lastResumedActivity + A01(12, 7, 124) + activity);
                c06818n.A03(1);
                A02.A06().A8q(A01(208, 8, 114), C06808m.A01, c06818n);
            }
            return lastResumedActivity != null ? lastResumedActivity : activity;
        }
    }

    public static void A03(@NonNull XT xt) {
        if (!JD.A16(xt) || Build.VERSION.SDK_INT >= 29) {
            return;
        }
        LA la = new LA(xt);
        synchronized (A07) {
            A07.add(la);
        }
        M1.A01.A01().postDelayed(la, 2000L);
    }

    public static synchronized void A04(XS xs, Class<? extends Activity> cls) {
        synchronized (ActivityUtils.class) {
            A02 = xs;
            A01 = xs.getApplicationContext();
            if (A01 instanceof Application) {
                ANActivityLifecycleCallbacksListener aNActivityLifecycleCallbacksListener = ANActivityLifecycleCallbacksListener.getANActivityLifecycleCallbacksListener();
                if (aNActivityLifecycleCallbacksListener != null) {
                    Map<Activity, Integer> activityStateMap = aNActivityLifecycleCallbacksListener.getActivityStateMap();
                    synchronized (activityStateMap) {
                        try {
                            A08.putAll(activityStateMap);
                        } catch (ConcurrentModificationException unused) {
                            xs.A06().A8q(A01(208, 8, 114), C06808m.A00, new C06818n(A01(72, 80, 103)));
                        }
                    }
                    ANActivityLifecycleCallbacksListener.unregisterActivityCallbacks(xs);
                }
                ((Application) A01).registerActivityLifecycleCallbacks(new ActivityUtils(cls));
            } else {
                xs.A06().A8q(A01(216, 3, 105), C06808m.A0V, new C06818n(A01(42, 30, 122)));
            }
        }
    }

    public static void A05(LB lb) {
        A06.add(lb);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        A08.put(activity, 1);
        for (LB lb : A06) {
            lb.onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        A08.put(activity, 6);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        ArrayList arrayList;
        Integer num = A08.get(activity);
        if (num == null || num.intValue() != 3) {
            C06818n c06818n = new C06818n(A01(172, 31, 47), A01(152, 20, 73) + num + A01(0, 12, 22) + activity);
            c06818n.A03(0);
            A02.A06().A8q(A01(208, 8, 114), C06808m.A01, c06818n);
        }
        A08.put(activity, 4);
        if (activity.getClass() != this.A00) {
            synchronized (A07) {
                arrayList = new ArrayList(A07);
                A07.clear();
            }
            Iterator it = arrayList.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                if (A04[0].charAt(23) == 's') {
                    throw new RuntimeException();
                }
                String[] strArr = A04;
                strArr[4] = "UBshke7O6W3uGW5erxsbv0";
                strArr[7] = "uKB";
                if (!hasNext) {
                    break;
                }
                M1.A01.A01().removeCallbacks((Runnable) it.next());
            }
        }
        A05.A01();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        A08.put(activity, 3);
        A05.A02();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        A08.put(activity, 2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        A08.put(activity, 5);
    }
}
