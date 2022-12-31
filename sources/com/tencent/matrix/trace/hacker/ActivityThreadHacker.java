package com.tencent.matrix.trace.hacker;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.RequiresApi;
import com.tencent.matrix.trace.config.IssueFixConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.util.MatrixLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class ActivityThreadHacker {
    private static final String TAG = "Matrix.ActivityThreadHacker";
    private static long sApplicationCreateBeginTime;
    private static long sApplicationCreateEndTime;
    public static AppMethodBeat.IndexRecord sLastLaunchActivityMethodIndex = new AppMethodBeat.IndexRecord();
    public static AppMethodBeat.IndexRecord sApplicationCreateBeginMethodIndex = new AppMethodBeat.IndexRecord();
    public static int sApplicationCreateScene = Integer.MIN_VALUE;
    private static final HashSet<IApplicationCreateListener> listeners = new HashSet<>();
    private static boolean sIsCreatedByLaunchActivity = false;

    /* loaded from: classes3.dex */
    public interface IApplicationCreateListener {
        void onApplicationCreateEnd();
    }

    /* loaded from: classes3.dex */
    private static final class a implements Handler.Callback {
        private static boolean c = false;

        /* renamed from: d  reason: collision with root package name */
        private static int f8091d = Integer.MAX_VALUE;
        private final Handler.Callback a;
        private Method b = null;

        a(Handler.Callback callback) {
            this.a = callback;
        }

        @RequiresApi(api = 21)
        private void a() {
            try {
                Field declaredField = Class.forName("android.app.QueuedWork").getDeclaredField("sPendingWorkFinishers");
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    ((ConcurrentLinkedQueue) declaredField.get(null)).clear();
                    MatrixLog.i(ActivityThreadHacker.TAG, "Fix SP ANR sPendingWorkFinishers.clear successful", new Object[0]);
                }
            } catch (ClassNotFoundException e2) {
                MatrixLog.e(ActivityThreadHacker.TAG, "Fix SP ANR ClassNotFoundException = " + e2.getMessage(), new Object[0]);
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                MatrixLog.e(ActivityThreadHacker.TAG, "Fix SP ANR IllegalAccessException =" + e3.getMessage(), new Object[0]);
                e3.printStackTrace();
            } catch (NoSuchFieldException e4) {
                MatrixLog.e(ActivityThreadHacker.TAG, "Fix SP ANR NoSuchFieldException = " + e4.getMessage(), new Object[0]);
                e4.printStackTrace();
            } catch (Exception e5) {
                MatrixLog.e(ActivityThreadHacker.TAG, "Fix SP ANR Exception = " + e5.getMessage(), new Object[0]);
                e5.printStackTrace();
            }
        }

        private boolean b(Message message) {
            if (Build.VERSION.SDK_INT > 27) {
                if (message.what == 159 && message.obj != null) {
                    try {
                        if (this.b == null) {
                            Method declaredMethod = Class.forName("android.app.servertransaction.ClientTransaction").getDeclaredMethod("getCallbacks", new Class[0]);
                            this.b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        }
                        List list = (List) this.b.invoke(message.obj, new Object[0]);
                        if (!list.isEmpty()) {
                            return list.get(0).getClass().getName().endsWith(".LaunchActivityItem");
                        }
                    } catch (Exception e2) {
                        MatrixLog.e(ActivityThreadHacker.TAG, "[isLaunchActivity] %s", e2);
                    }
                }
                return message.what == 100;
            }
            int i2 = message.what;
            return i2 == 100 || i2 == 126;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2;
            int i3;
            int i4;
            if (IssueFixConfig.getsInstance().isEnableFixSpApply() && (i3 = Build.VERSION.SDK_INT) >= 21 && i3 <= 25 && ((i4 = message.what) == 115 || i4 == 116 || i4 == 103 || i4 == 104 || i4 == 137)) {
                MatrixLog.i(ActivityThreadHacker.TAG, "Fix SP ANR is enabled", new Object[0]);
                a();
            }
            if (!AppMethodBeat.isRealTrace()) {
                Handler.Callback callback = this.a;
                return callback != null && callback.handleMessage(message);
            }
            boolean b = b(message);
            if (f8091d > 0) {
                MatrixLog.i(ActivityThreadHacker.TAG, "[handleMessage] msg.what:%s begin:%s isLaunchActivity:%s SDK_INT=%s", Integer.valueOf(message.what), Long.valueOf(SystemClock.uptimeMillis()), Boolean.valueOf(b), Integer.valueOf(Build.VERSION.SDK_INT));
                f8091d--;
            }
            if (!c && (b || (i2 = message.what) == 114 || i2 == 113)) {
                long unused = ActivityThreadHacker.sApplicationCreateEndTime = SystemClock.uptimeMillis();
                ActivityThreadHacker.sApplicationCreateScene = message.what;
                c = true;
                boolean unused2 = ActivityThreadHacker.sIsCreatedByLaunchActivity = b;
                MatrixLog.i(ActivityThreadHacker.TAG, "application create end, sApplicationCreateScene:%d, isLaunchActivity:%s", Integer.valueOf(message.what), Boolean.valueOf(b));
                synchronized (ActivityThreadHacker.listeners) {
                    Iterator it = ActivityThreadHacker.listeners.iterator();
                    while (it.hasNext()) {
                        ((IApplicationCreateListener) it.next()).onApplicationCreateEnd();
                    }
                }
            }
            Handler.Callback callback2 = this.a;
            return callback2 != null && callback2.handleMessage(message);
        }
    }

    public static void addListener(IApplicationCreateListener iApplicationCreateListener) {
        HashSet<IApplicationCreateListener> hashSet = listeners;
        synchronized (hashSet) {
            hashSet.add(iApplicationCreateListener);
        }
    }

    public static long getApplicationCost() {
        return sApplicationCreateEndTime - sApplicationCreateBeginTime;
    }

    public static long getEggBrokenTime() {
        return sApplicationCreateBeginTime;
    }

    public static void hackSysHandlerCallback() {
        try {
            sApplicationCreateBeginTime = SystemClock.uptimeMillis();
            sApplicationCreateBeginMethodIndex = AppMethodBeat.getInstance().maskIndex("ApplicationCreateBeginMethodIndex");
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mH");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Class<? super Object> superclass = obj2.getClass().getSuperclass();
            if (superclass != null) {
                Field declaredField3 = superclass.getDeclaredField("mCallback");
                declaredField3.setAccessible(true);
                declaredField3.set(obj2, new a((Handler.Callback) declaredField3.get(obj2)));
            }
            MatrixLog.i(TAG, "hook system handler completed. start:%s SDK_INT:%s", Long.valueOf(sApplicationCreateBeginTime), Integer.valueOf(Build.VERSION.SDK_INT));
        } catch (Exception e2) {
            MatrixLog.e(TAG, "hook system handler err! %s", e2.getCause().toString());
        }
    }

    public static boolean isCreatedByLaunchActivity() {
        return sIsCreatedByLaunchActivity;
    }

    public static void removeListener(IApplicationCreateListener iApplicationCreateListener) {
        HashSet<IApplicationCreateListener> hashSet = listeners;
        synchronized (hashSet) {
            hashSet.remove(iApplicationCreateListener);
        }
    }
}
