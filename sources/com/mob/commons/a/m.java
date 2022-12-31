package com.mob.commons.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.mob.MobSDK;
import com.mob.commons.FBListener;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ActivityTracker;
import com.mob.tools.utils.DeviceHelper;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: FBManager.java */
/* loaded from: classes2.dex */
public class m {
    private static m a;
    private final HashSet<FBListener> b = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    private String f5865d = null;

    /* renamed from: e  reason: collision with root package name */
    private long f5866e = 0;
    private volatile Handler c = MobHandlerThread.newHandler(new Handler.Callback() { // from class: com.mob.commons.a.m.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                if (DeviceHelper.getInstance(MobSDK.getContext()).amIOnForeground()) {
                    m.this.f5866e = SystemClock.elapsedRealtime();
                    m.this.a(false);
                } else {
                    m.this.a(0L, false);
                }
                m.this.b();
            } else if (i2 == 1) {
                m.this.a(true);
            } else if (i2 == 2) {
                m.this.a(((Long) message.obj).longValue(), true);
            } else if (i2 == 3) {
                try {
                    FBListener fBListener = (FBListener) message.obj;
                    if (fBListener != null) {
                        m.this.b.add(fBListener);
                        fBListener.onFBChanged(m.this.f5866e > 0, true, 0L);
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
            return false;
        }
    });

    private m() {
    }

    public void b(FBListener fBListener) {
        if (fBListener == null) {
            return;
        }
        synchronized (this.b) {
            this.b.remove(fBListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ActivityTracker.getInstance(MobSDK.getContext()).addTracker(new ActivityTracker.Tracker() { // from class: com.mob.commons.a.m.2
            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onCreated(Activity activity, Bundle bundle) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onDestroyed(Activity activity) {
                if (m.this.f5866e > 0) {
                    onStopped(activity);
                }
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onPaused(Activity activity) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onResumed(Activity activity) {
                if (m.this.f5866e == 0) {
                    m.this.f5866e = SystemClock.elapsedRealtime();
                    if (m.this.c != null) {
                        m.this.c.sendEmptyMessage(1);
                    }
                }
                m.this.f5865d = activity.toString();
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onSaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onStarted(Activity activity) {
            }

            @Override // com.mob.tools.utils.ActivityTracker.Tracker
            public void onStopped(Activity activity) {
                if (m.this.f5865d == null || activity.toString().equals(m.this.f5865d.toString())) {
                    if (m.this.c != null) {
                        long elapsedRealtime = m.this.f5866e > 0 ? SystemClock.elapsedRealtime() - m.this.f5866e : 0L;
                        Message message = new Message();
                        message.what = 2;
                        message.obj = Long.valueOf(elapsedRealtime);
                        m.this.c.sendMessage(message);
                    }
                    m.this.f5866e = 0L;
                    m.this.f5865d = null;
                }
            }
        });
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (a == null) {
                m mVar2 = new m();
                a = mVar2;
                if (mVar2.c != null) {
                    a.c.sendEmptyMessage(0);
                }
            }
            mVar = a;
        }
        return mVar;
    }

    public void a(FBListener fBListener) {
        if (fBListener == null) {
            return;
        }
        synchronized (this.b) {
            if (this.b.contains(fBListener)) {
                return;
            }
            if (this.c != null) {
                Message message = new Message();
                message.what = 3;
                message.obj = fBListener;
                this.c.sendMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        com.mob.commons.b.a(0L, true);
        if (z) {
            a(true, false, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j2, boolean z) {
        com.mob.commons.b.a(SystemClock.elapsedRealtime(), true);
        if (z) {
            a(false, false, j2);
        }
    }

    private void a(boolean z, boolean z2, long j2) {
        synchronized (this.b) {
            Iterator<FBListener> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().onFBChanged(z, z2, j2);
            }
        }
    }
}
