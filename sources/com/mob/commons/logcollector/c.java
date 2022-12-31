package com.mob.commons.logcollector;

import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.commons.MobProductCollector;
import com.mob.commons.i;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import com.tapjoy.TapjoyConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import us.pinguo.bigalbum.db.BigAlbumStore;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: LogsManager.java */
/* loaded from: classes2.dex */
public class c {
    private static c b;
    private static String c = i.b("api-exc.dutils.com");

    /* renamed from: f  reason: collision with root package name */
    private File f5889f;

    /* renamed from: e  reason: collision with root package name */
    private NetworkHelper f5888e = new NetworkHelper();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, Integer> f5887d = new HashMap<>();
    protected final Handler a = MobHandlerThread.newHandler("l", new Handler.Callback() { // from class: com.mob.commons.logcollector.c.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            com.mob.commons.a.b();
            if (com.mob.commons.b.F()) {
                return false;
            }
            c.this.a(message);
            return false;
        }
    });

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        this.a.sendMessageDelayed(message, 1000L);
    }

    private void c(Message message) {
        try {
            int i2 = message.arg1;
            String str = (String) message.obj;
            boolean I = com.mob.commons.b.I();
            boolean J = com.mob.commons.b.J();
            if (I) {
                a(i2, str, new String[]{String.valueOf(1)});
            } else if (J) {
                a(i2, str, new String[]{String.valueOf(2)});
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    private void d(final Message message) {
        try {
            int i2 = message.arg1;
            Object[] objArr = (Object[]) message.obj;
            String str = (String) objArr[0];
            final String str2 = (String) objArr[1];
            int i3 = message.arg2 == 3 ? 2 : 1;
            boolean I = com.mob.commons.b.I();
            boolean J = com.mob.commons.b.J();
            if (1 != i3 || I) {
                if (2 != i3 || J) {
                    final String MD5 = Data.MD5(str2);
                    b();
                    final int i4 = i3;
                    if (com.mob.commons.d.a(this.f5889f, new LockAction() { // from class: com.mob.commons.logcollector.c.2
                        @Override // com.mob.commons.LockAction
                        public boolean run(FileLocker fileLocker) {
                            try {
                                e.a(com.mob.commons.b.a(), str2, i4, MD5);
                            } catch (Throwable th) {
                                int intValue = (c.this.f5887d.containsKey(MD5) ? ((Integer) c.this.f5887d.get(MD5)).intValue() : 0) + 1;
                                c.this.f5887d.put(MD5, Integer.valueOf(intValue));
                                if (intValue >= 3) {
                                    c.this.f5887d.remove(MD5);
                                    MobLog.getInstance().w(th);
                                } else {
                                    c.this.b(message);
                                }
                            }
                            return false;
                        }
                    })) {
                        this.f5887d.remove(MD5);
                        if (1 == i3 && I) {
                            a(i2, str, new String[]{String.valueOf(1)});
                        } else if (2 == i3 && J) {
                            a(i2, str, new String[]{String.valueOf(2)});
                        }
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public void b(int i2, int i3, String str, String str2) {
        a(i2, i3, str, str2);
        try {
            this.a.wait();
        } catch (Throwable unused) {
        }
    }

    private void b() {
        if (this.f5889f == null) {
            this.f5889f = new File(MobSDK.getContext().getFilesDir(), ".lock");
        }
        if (this.f5889f.exists()) {
            return;
        }
        try {
            this.f5889f.createNewFile();
        } catch (Exception e2) {
            MobLog.getInstance().w(e2);
        }
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (b == null) {
                b = new c();
            }
            cVar = b;
        }
        return cVar;
    }

    private String c() {
        return c + "/errlog";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> b(int i2, String str) throws Throwable {
        HashMap<String, Object> hashMap = new HashMap<>();
        DeviceHelper deviceHelper = DeviceHelper.getInstance(MobSDK.getContext());
        hashMap.put("key", MobSDK.getAppkey());
        hashMap.put("plat", Integer.valueOf(deviceHelper.getPlatformCode()));
        hashMap.put("sdk", str);
        hashMap.put("sdkver", Integer.valueOf(i2));
        hashMap.put("appname", deviceHelper.getAppName());
        hashMap.put("apppkg", deviceHelper.getPackageName());
        hashMap.put("appver", String.valueOf(deviceHelper.getAppVersion()));
        hashMap.put(BigAlbumStore.PhotoTagColumns.MODEL, deviceHelper.getModel());
        if (com.mob.commons.b.b()) {
            hashMap.put("deviceid", deviceHelper.getDeviceKey());
            hashMap.put("mac", deviceHelper.getMacAddress());
            hashMap.put(TapjoyConstants.TJC_DEVICE_ID_NAME, deviceHelper.getDeviceId());
        }
        hashMap.put("sysver", String.valueOf(deviceHelper.getOSVersionInt()));
        hashMap.put("networktype", deviceHelper.getDetailNetworkTypeForStatic());
        return hashMap;
    }

    public void a(int i2, String str) {
        Message message = new Message();
        message.what = 100;
        message.arg1 = i2;
        message.obj = str;
        this.a.sendMessage(message);
    }

    public void a(int i2, int i3, String str, String str2) {
        Message message = new Message();
        message.what = 101;
        message.arg1 = i2;
        message.arg2 = i3;
        message.obj = new Object[]{str, str2};
        this.a.sendMessage(message);
    }

    protected void a(Message message) {
        int i2 = message.what;
        if (i2 == 100) {
            c(message);
        } else if (i2 != 101) {
        } else {
            d(message);
        }
    }

    private void a(final int i2, final String str, final String[] strArr) {
        try {
            if (!PortalFollowFeeds.TYPE_NONE.equals(DeviceHelper.getInstance(MobSDK.getContext()).getDetailNetworkTypeForStatic())) {
                b();
                com.mob.commons.d.a(this.f5889f, new LockAction() { // from class: com.mob.commons.logcollector.c.3
                    @Override // com.mob.commons.LockAction
                    public boolean run(FileLocker fileLocker) {
                        try {
                            ArrayList<d> a = e.a(strArr);
                            for (int i3 = 0; i3 < a.size(); i3++) {
                                d dVar = a.get(i3);
                                HashMap b2 = c.this.b(i2, str);
                                b2.put("errmsg", dVar.a);
                                c cVar = c.this;
                                if (cVar.a(cVar.a(new Hashon().fromHashMap(b2)), true)) {
                                    e.a(dVar.b);
                                }
                            }
                        } catch (Throwable th) {
                            MobLog.getInstance().i(th);
                        }
                        return false;
                    }
                });
                return;
            }
            throw new IllegalStateException("network is disconnected!");
        } catch (Throwable th) {
            MobLog.getInstance().i(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = byteArrayInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                try {
                    break;
                } catch (Throwable unused) {
                }
            }
        }
        gZIPOutputStream.flush();
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return Base64.encodeToString(byteArray, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, boolean z) throws Throwable {
        if (com.mob.commons.b.t()) {
            return false;
        }
        try {
            if (!PortalFollowFeeds.TYPE_NONE.equals(DeviceHelper.getInstance(MobSDK.getContext()).getDetailNetworkTypeForStatic())) {
                ArrayList<KVPair<String>> arrayList = new ArrayList<>();
                arrayList.add(new KVPair<>("m", str));
                ArrayList<KVPair<String>> arrayList2 = new ArrayList<>();
                arrayList2.add(new KVPair<>("User-Identity", MobProductCollector.getUserIdentity()));
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = 10000;
                networkTimeOut.connectionTimeout = 10000;
                this.f5888e.httpPost(c(), arrayList, (KVPair<String>) null, arrayList2, networkTimeOut);
                return true;
            }
            throw new IllegalStateException("network is disconnected!");
        } catch (Throwable th) {
            MobLog.getInstance().i(th);
            return false;
        }
    }
}
