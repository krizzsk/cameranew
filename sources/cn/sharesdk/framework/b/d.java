package cn.sharesdk.framework.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.b.b.e;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.f;
import com.mob.MobSDK;
import com.mob.commons.SHARESDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import java.io.File;
import java.util.Calendar;
/* compiled from: StatisticsLogger.java */
/* loaded from: classes.dex */
public class d extends f {
    private static d b;

    /* renamed from: e  reason: collision with root package name */
    private Handler f109e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f110f;

    /* renamed from: g  reason: collision with root package name */
    private long f111g;

    /* renamed from: h  reason: collision with root package name */
    private File f112h;
    private DeviceHelper c = DeviceHelper.getInstance(MobSDK.getContext());

    /* renamed from: d  reason: collision with root package name */
    private a f108d = a.a();

    /* renamed from: i  reason: collision with root package name */
    private FileLocker f113i = new FileLocker();

    private d() {
        File file = new File(MobSDK.getContext().getFilesDir(), ".statistics");
        this.f112h = file;
        if (file.exists()) {
            return;
        }
        try {
            this.f112h.createNewFile();
        } catch (Exception e2) {
            SSDKLog.b().d(e2);
        }
    }

    private void d(cn.sharesdk.framework.b.b.c cVar) {
        try {
            this.f108d.a(cVar);
            cVar.h();
        } catch (Throwable th) {
            SSDKLog.b().d(th);
            SSDKLog.b().d(cVar.toString(), new Object[0]);
        }
    }

    public void b(cn.sharesdk.framework.b.b.c cVar) {
        try {
            if (MobSDK.isMob()) {
                if (this.f110f) {
                    c(cVar);
                    if (cVar.g()) {
                        Message message = new Message();
                        message.what = 3;
                        message.obj = cVar;
                        this.a.sendMessage(message);
                    } else {
                        NLog b2 = SSDKLog.b();
                        b2.d("Drop event: " + cVar.toString(), new Object[0]);
                    }
                }
            }
        } catch (Throwable th) {
            NLog b3 = SSDKLog.b();
            b3.d("logStart " + th, new Object[0]);
        }
    }

    @Override // cn.sharesdk.framework.utils.f
    protected void c(Message message) {
        if (this.f110f) {
            e eVar = new e();
            eVar.a = System.currentTimeMillis() - this.f111g;
            a(eVar);
            this.f110f = false;
            try {
                this.f109e.sendEmptyMessage(1);
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
            b = null;
            this.a.getLooper().quit();
        }
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (b == null) {
                b = new d();
            }
            dVar = b;
        }
        return dVar;
    }

    public void a(Handler handler) {
        this.f109e = handler;
    }

    @Override // cn.sharesdk.framework.utils.f
    protected void a(Message message) {
        if (this.f110f) {
            return;
        }
        this.f110f = true;
        try {
            this.f113i.setLockFile(this.f112h.getAbsolutePath());
            if (this.f113i.lock(false)) {
                new Thread(new Runnable() { // from class: cn.sharesdk.framework.b.d.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.f108d.a(DeviceAuthorizer.authorize(new SHARESDK()));
                        } catch (Exception e2) {
                            SSDKLog.b().d(e2);
                        }
                    }
                }).start();
                this.f108d.b();
                this.f108d.c();
                ShareSDK.setEnableAuthTag(true);
                b();
                this.a.sendEmptyMessageDelayed(4, 3600000L);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }

    private void c(cn.sharesdk.framework.b.b.c cVar) {
        cVar.f89f = this.c.getDeviceKey();
        cVar.f90g = this.c.getPackageName();
        cVar.f91h = this.c.getAppVersion();
        cVar.f92i = String.valueOf(ShareSDK.SDK_VERSION_CODE);
        cVar.f93j = this.c.getPlatformCode();
        cVar.f94k = this.c.getDetailNetworkTypeForStatic();
        if (TextUtils.isEmpty(MobSDK.getAppkey())) {
            SSDKLog.b().w("ShareSDKCore", "Your appKey of ShareSDK is null , this will cause its data won't be count!");
        } else if (!"cn.sharesdk.demo".equals(cVar.f90g) && ("api20".equals(MobSDK.getAppkey()) || "androidv1101".equals(MobSDK.getAppkey()))) {
            SSDKLog.b().w("ShareSDKCore", "Your app is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
        }
        cVar.f95l = this.c.getDeviceData();
    }

    @Override // cn.sharesdk.framework.utils.f
    protected void b(Message message) {
        int i2 = message.what;
        if (i2 == 2) {
            try {
                this.f108d.d();
            } catch (Throwable th) {
                SSDKLog.b().d(th);
            }
        } else if (i2 == 3) {
            Object obj = message.obj;
            if (obj != null) {
                d((cn.sharesdk.framework.b.b.c) obj);
                this.a.removeMessages(2);
                this.a.sendEmptyMessageDelayed(2, 2000L);
            }
        } else if (i2 != 4) {
        } else {
            long longValue = cn.sharesdk.framework.b.a.e.a().j().longValue();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(longValue);
            int i3 = calendar.get(1);
            int i4 = calendar.get(2);
            int i5 = calendar.get(5);
            calendar.setTimeInMillis(System.currentTimeMillis());
            int i6 = calendar.get(1);
            int i7 = calendar.get(2);
            int i8 = calendar.get(5);
            if (i3 != i6 || i4 != i7 || i5 != i8) {
                this.f108d.c();
            }
            this.a.sendEmptyMessageDelayed(4, 3600000L);
        }
    }

    public void a(final cn.sharesdk.framework.b.b.c cVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() { // from class: cn.sharesdk.framework.b.d.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    d.this.b(cVar);
                }
            }.start();
        } else {
            b(cVar);
        }
    }

    private void b() {
        new Thread(new Runnable() { // from class: cn.sharesdk.framework.b.d.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cn.sharesdk.framework.authorize.f.c().d();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }).start();
    }
}
