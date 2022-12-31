package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import cn.sharesdk.framework.loopshare.LoopSharePasswordListener;
import cn.sharesdk.framework.loopshare.LoopShareResultListener;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.framework.loopshare.watermark.ReadQrImageListener;
import cn.sharesdk.framework.loopshare.watermark.WaterMarkListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.mob.MobSDK;
import com.mob.commons.ForbThrowable;
import com.mob.commons.dialog.PolicyThrowable;
import com.mob.tools.log.NLog;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ShareSDK {
    public static final String SDK_TAG = "SHARESDK";
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME = "3.9.4";
    public static final String SHARESDK_MOBLINK_RESTORE = "sharesdk_moblink_restore";
    private static i a = null;
    private static boolean b = true;
    private static String c;

    /* renamed from: d  reason: collision with root package name */
    private static HashMap<String, Object> f70d;

    /* renamed from: e  reason: collision with root package name */
    private static List<HashMap<String, Object>> f71e;

    /* renamed from: f  reason: collision with root package name */
    private static int f72f;

    /* renamed from: g  reason: collision with root package name */
    private static LoopShareResultListener f73g;

    static {
        int i2 = 0;
        for (String str : SDK_VERSION_NAME.split("\\.")) {
            i2 = (i2 * 100) + Integer.parseInt(str);
        }
        SDK_VERSION_CODE = i2;
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK static main catch ", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(str, str2);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK copyDevinfo ", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() throws Throwable {
        k();
        i iVar = a;
        if (iVar != null) {
            return iVar.i();
        }
        return false;
    }

    public static void closeDebug() {
        b = false;
    }

    public static void deleteCache() {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.j();
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK deleteCache catch ", new Object[0]);
        }
    }

    public static Activity getAuthActivity() {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK getAuthActivity catch ", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.a();
        }
        return null;
    }

    public static HashMap<String, Object> getCustomDataFromLoopShare() {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK getCustomDataFromLoopShare catch ", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.d();
        }
        return new HashMap<>();
    }

    public static String getDevinfo(String str, String str2) {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK getDevinfo catch ", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.b(str, str2);
        }
        return null;
    }

    public static boolean getEnableAuthTag() {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK getEnableAuthTag catch", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.c();
        }
        return false;
    }

    public static void getFirstQrImage(Context context, ReadQrImageListener readQrImageListener) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(context, readQrImageListener);
            }
        } catch (Throwable th) {
            if (readQrImageListener != null) {
                readQrImageListener.onFailed(th, -1);
            }
        }
    }

    public static Platform getPlatform(String str) {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK ensureInit getPlatform catch", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.a(str);
        }
        return null;
    }

    public static Platform[] getPlatformList() {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK getPlatformList catch ", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.f();
        }
        return null;
    }

    public static Bitmap getQRCodeBitmap(String str, int i2, int i3) throws Throwable {
        k();
        i iVar = a;
        if (iVar != null) {
            return iVar.a(str, i2, i3);
        }
        return null;
    }

    public static <T extends Service> T getService(Class<T> cls) throws Throwable {
        k();
        i iVar = a;
        if (iVar != null) {
            return (T) iVar.c(cls);
        }
        return null;
    }

    static /* synthetic */ int h() {
        int i2 = f72f;
        f72f = i2 + 1;
        return i2;
    }

    public static boolean isDebug() {
        return b;
    }

    public static boolean isFBInstagram() {
        try {
            k();
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.d("ShareSDK isFBInstagram catch: " + th, new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.b();
        }
        return false;
    }

    public static boolean isRemoveCookieOnAuthorize() {
        try {
            k();
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.d("ShareSDK isRemoveCookieOnAuthorize catch: " + th, new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.g();
        }
        return false;
    }

    private static boolean j() throws Throwable {
        if (!MobSDK.isForb()) {
            int isAuth = MobSDK.isAuth();
            if (isAuth == 1 || isAuth == 2) {
                return true;
            }
            throw new PolicyThrowable();
        }
        throw new ForbThrowable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void k() throws Throwable {
        synchronized (ShareSDK.class) {
            j();
            if (a == null) {
                i iVar = new i();
                iVar.e();
                a = iVar;
                LoopShareResultListener loopShareResultListener = f73g;
                if (loopShareResultListener != null) {
                    prepareLoopShare(loopShareResultListener);
                    f73g = null;
                }
            }
        }
    }

    private static void l() {
        new Thread(new Runnable() { // from class: cn.sharesdk.framework.ShareSDK.1
            @Override // java.lang.Runnable
            public void run() {
                Looper.prepare();
                final Handler handler = new Handler(Looper.myLooper()) { // from class: cn.sharesdk.framework.ShareSDK.1.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        super.handleMessage(message);
                        if (message == null || message.what != 3) {
                            return;
                        }
                        try {
                            ShareSDK.k();
                            if (ShareSDK.a != null) {
                                if (ShareSDK.f70d == null || ShareSDK.f70d.size() <= 0) {
                                    ShareSDK.a.a(ShareSDK.f71e);
                                } else {
                                    ShareSDK.a.a(ShareSDK.c, ShareSDK.f70d);
                                }
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                };
                handler.post(new Runnable() { // from class: cn.sharesdk.framework.ShareSDK.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int isAuth = MobSDK.isAuth();
                        if (isAuth == 0) {
                            ShareSDK.h();
                            if (ShareSDK.f72f == 90) {
                                handler.removeCallbacks(this);
                                return;
                            }
                            Log.e(OnekeyShare.SHARESDK_TAG, "Privacy Agreement is not agree, Please agree to the privacy agreement first ");
                            handler.postDelayed(this, 500L);
                        } else if (isAuth != 1 && isAuth != 2) {
                            handler.removeCallbacks(this);
                        } else if (MobSDK.isForb()) {
                        } else {
                            handler.removeCallbacks(this);
                            Message obtain = Message.obtain();
                            obtain.what = 3;
                            handler.sendMessage(obtain);
                        }
                    }
                });
                Looper.loop();
            }
        }).start();
    }

    public static void logApiEvent(String str, int i2) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(str, i2);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK logApiEvent catch ", new Object[0]);
        }
    }

    public static void logDemoEvent(int i2, Platform platform) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(i2, platform);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK logDemoEvent catch ", new Object[0]);
        }
    }

    public static void makeVideoWaterMark(String str, String str2, String str3, String str4, WaterMarkListener waterMarkListener) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(str, str2, str3, str4, waterMarkListener);
            }
        } catch (Throwable th) {
            if (waterMarkListener != null) {
                waterMarkListener.onFailed(th.getMessage(), -1);
            }
        }
    }

    public static void mobLinkGetMobID(HashMap<String, Object> hashMap, MoblinkActionListener moblinkActionListener) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(hashMap, moblinkActionListener);
            }
        } catch (Throwable th) {
            if (moblinkActionListener != null) {
                moblinkActionListener.onError(th);
            }
        }
    }

    public static String platformIdToName(int i2) {
        try {
            k();
        } catch (Throwable th) {
            NLog b2 = SSDKLog.b();
            b2.d("ShareSDK platformIdToName catch: " + th, new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.c(i2);
        }
        return null;
    }

    public static int platformNameToId(String str) {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK platformNameToId catch ", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.b(str);
        }
        return -1;
    }

    public static void prepareLoopShare(LoopShareResultListener loopShareResultListener) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(loopShareResultListener);
            }
        } catch (Throwable th) {
            if (loopShareResultListener != null) {
                loopShareResultListener.onError(th);
            }
            f73g = loopShareResultListener;
        }
    }

    public static void preparePassWord(HashMap<String, Object> hashMap, String str, LoopSharePasswordListener loopSharePasswordListener) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(hashMap, str, loopSharePasswordListener);
            }
        } catch (Throwable th) {
            if (loopSharePasswordListener != null) {
                loopSharePasswordListener.onError(th);
            }
        }
    }

    public static void readPassWord(boolean z, LoopSharePasswordListener loopSharePasswordListener) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(z, loopSharePasswordListener);
            }
        } catch (Throwable th) {
            if (loopSharePasswordListener != null) {
                loopSharePasswordListener.onError(th);
            }
        }
    }

    public static void registerPlatform(Class<? extends CustomPlatform> cls) throws Throwable {
        k();
        i iVar = a;
        if (iVar != null) {
            iVar.d(cls);
        }
    }

    public static void registerService(Class<? extends Service> cls) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(cls);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK  registerService catch ", new Object[0]);
        }
    }

    public static void removeCookieOnAuthorize(boolean z) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.c(z);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK removeCookieOnAuthorize catch ", new Object[0]);
        }
    }

    public static void setActivity(Activity activity) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(activity);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK setActivity is catch ", new Object[0]);
        }
    }

    public static void setCloseGppService(boolean z) {
        try {
            cn.sharesdk.framework.b.a.e.a().b(z);
        } catch (Throwable th) {
            SSDKLog.b().d(th);
        }
    }

    public static void setConnTimeout(int i2) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(i2);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK setConnTimeout catch", new Object[0]);
        }
    }

    public static void setEnableAuthTag(boolean z) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.b(z);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK setEnableAuthTag catch", new Object[0]);
        }
    }

    public static void setFBInstagram(boolean z) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(z);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK setFBInstagram catch ", new Object[0]);
        }
    }

    public static void setPlatformDevInfo(String str, HashMap<String, Object> hashMap) {
        try {
            c = str;
            f70d = hashMap;
            if (!MobSDK.isForb() && MobSDK.isAuth() == 1) {
                k();
                i iVar = a;
                if (iVar != null) {
                    iVar.a(str, hashMap);
                }
            } else {
                l();
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK setPlatformDevInfo catch ", new Object[0]);
        }
    }

    public static void setPlatformDevInfos(List<HashMap<String, Object>> list) {
        try {
            f71e = list;
            if (!MobSDK.isForb() && MobSDK.isAuth() == 1) {
                k();
                i iVar = a;
                if (iVar != null) {
                    iVar.a(f71e);
                }
            } else {
                l();
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK setPlatformDevInfo catch ", new Object[0]);
        }
    }

    public static void setReadTimeout(int i2) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.b(i2);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK setReadTimeout catch", new Object[0]);
        }
    }

    public static void unregisterPlatform(Class<? extends CustomPlatform> cls) throws Throwable {
        k();
        i iVar = a;
        if (iVar != null) {
            iVar.e(cls);
        }
    }

    public static void unregisterService(Class<? extends Service> cls) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.b(cls);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK  unregisterService catch ", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i2, int i3) {
        try {
            k();
            i iVar = a;
            if (iVar != null) {
                iVar.a(i2, i3);
            }
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK copyNetworkDevinfo catch ", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i2, String str) {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK getNetworkDevinfo catch ", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.a(i2, str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK isNetworkDevinfoRequested is catch ", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.h();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, boolean z, int i2, String str2) {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK getShortLink catch ", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.a(str, z, i2, str2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK uploadImageToFileServer catch: ", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.c(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Bitmap bitmap) {
        try {
            k();
        } catch (Throwable th) {
            SSDKLog.b().d(th, "ShareSDK uploadImageToFileServer catch ", new Object[0]);
        }
        i iVar = a;
        if (iVar != null) {
            return iVar.a(bitmap);
        }
        return null;
    }
}
