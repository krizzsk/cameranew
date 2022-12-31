package com.mob.tools.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Proxy;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import cn.sharesdk.onekeyshare.OnekeyShare;
import com.coremedia.iso.boxes.FreeBox;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ReflectHelper;
import com.pinguo.camera360.effect.model.entity.Effect;
import com.tapjoy.TapjoyConstants;
import com.tencent.matrix.plugin.PluginShareConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import us.pinguo.androidsdk.PGImageSDK;
import us.pinguo.inspire.cell.recycler.a;
import us.pinguo.inspire.module.MissionDetail.TaskDetailBasePresenter;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* loaded from: classes3.dex */
public class DeviceHelper {
    private static DeviceHelper deviceHelper;
    private String advertiseID;
    private String advertisingID;
    private String bufModel;
    private String bufUiVersion;
    private Context context;
    private Boolean isSmlt;
    private String tempDeviceKey;
    private String cacheDeviceKey = null;
    private volatile boolean hasSdcardWritePermission = false;
    private HashMap<String, String> bufMacs = new HashMap<>();
    private BVS bvs = new BVS();

    /* loaded from: classes3.dex */
    public interface BtScanCallback {
        void onScan(ArrayList<HashMap<String, Object>> arrayList);
    }

    /* loaded from: classes3.dex */
    public static class BtWatcher {
        protected void onBtConnectionChanged(boolean z, HashMap<String, Object> hashMap) {
        }

        protected void onBtDisabled() {
        }

        protected void onBtEnabled() {
        }

        protected void onDeviceConnected(HashMap<String, Object> hashMap) {
        }

        protected void onDeviceDisconnected(HashMap<String, Object> hashMap) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class GSConnection implements ServiceConnection {
        boolean got;
        private final BlockingQueue<IBinder> iBinders;

        private GSConnection() {
            this.got = false;
            this.iBinders = new LinkedBlockingQueue();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.iBinders.put(iBinder);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        public IBinder takeBinder() throws InterruptedException {
            if (!this.got) {
                this.got = true;
                return this.iBinders.poll(1500L, TimeUnit.MILLISECONDS);
            }
            throw new IllegalStateException();
        }
    }

    private DeviceHelper(Context context) {
        this.context = context.getApplicationContext();
    }

    private String byteToHex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.format("%02x:", Byte.valueOf(bArr[i2])));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private boolean checkRootApp() {
        String[] strArr = {"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su", "com.topjohnwu.magisk", "com.koushikdutta.rommanager", "com.koushikdutta.rommanager.license", "com.dimonvideo.luckypatcher", "com.chelpus.lackypatch", "com.ramdroid.appquarantine", "com.ramdroid.appquarantinepro", "com.android.vending.billing.InAppBillingService.COIN", "com.chelpus.luckypatcher"};
        for (int i2 = 0; i2 < 15; i2++) {
            try {
                if (deviceHelper.isPackageInstalled(strArr[i2])) {
                    return true;
                }
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
        }
        return false;
    }

    private boolean checkRootFile() {
        try {
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        if (new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        String[] strArr = {"/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/system/sbin/", "/vendor/bin/", "/cache", "/data", "/dev"};
        for (int i2 = 0; i2 < 16; i2++) {
            if (new File(strArr[i2], "su").exists()) {
                return true;
            }
        }
        for (int i3 = 0; i3 < 16; i3++) {
            if (new File(strArr[i3], "busybox").exists()) {
                return true;
            }
        }
        for (int i4 = 0; i4 < 16; i4++) {
            if (new File(strArr[i4], "magisk").exists()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRootProp() {
        String[] split;
        try {
            InputStream invokeRuntimeExec = invokeRuntimeExec(new String[]{"getprop"});
            if (invokeRuntimeExec != null && (split = new Scanner(invokeRuntimeExec).useDelimiter("\\A").next().split("\n")) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("ro.debuggable", "1");
                hashMap.put("ro.secure", "0");
                for (String str : split) {
                    for (String str2 : hashMap.keySet()) {
                        if (str != null && str.contains(str2)) {
                            if (str.contains("[" + hashMap.get(str2) + "]")) {
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return false;
    }

    private boolean checkRootRw() {
        String[] split;
        String[] split2;
        try {
            InputStream invokeRuntimeExec = invokeRuntimeExec(new String[]{"mount"});
            if (invokeRuntimeExec != null && (split = new Scanner(invokeRuntimeExec).useDelimiter("\\A").next().split("\n")) != null) {
                String[] strArr = {"/system", "/system/bin", "/system/sbin", "/system/xbin", "/vendor/bin", "/sbin", "/etc"};
                for (String str : split) {
                    String[] split3 = str.split(" ");
                    if (split3.length >= 4) {
                        String str2 = split3[1];
                        String str3 = split3[3];
                        for (int i2 = 0; i2 < 7; i2++) {
                            String str4 = strArr[i2];
                            if (str2 != null && str2.equalsIgnoreCase(str4)) {
                                for (String str5 : str3.split(",")) {
                                    if (str5 != null && str5.equalsIgnoreCase("rw")) {
                                        return true;
                                    }
                                }
                                continue;
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:2|3)|(2:5|(6:7|8|9|(2:11|(2:13|(1:18)(1:16)))|21|(1:18)(1:19)))|24|8|9|(0)|21|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #0 {all -> 0x0041, blocks: (B:9:0x0023, B:11:0x002f), top: B:22:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean checkRootSu() {
        /*
            r6 = this;
            java.lang.String r0 = "su"
            r1 = 1
            r2 = 0
            java.lang.String r3 = "which"
            java.lang.String[] r3 = new java.lang.String[]{r3, r0}     // Catch: java.lang.Throwable -> L22
            java.io.InputStream r3 = r6.invokeRuntimeExec(r3)     // Catch: java.lang.Throwable -> L22
            if (r3 == 0) goto L22
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L22
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L22
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L22
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L22
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L22
            if (r3 == 0) goto L22
            r3 = 1
            goto L23
        L22:
            r3 = 0
        L23:
            java.lang.String r4 = "/system/xbin/which"
            java.lang.String[] r0 = new java.lang.String[]{r4, r0}     // Catch: java.lang.Throwable -> L41
            java.io.InputStream r0 = r6.invokeRuntimeExec(r0)     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L41
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L41
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L41
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L41
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L41
            java.lang.String r0 = r4.readLine()     // Catch: java.lang.Throwable -> L41
            if (r0 == 0) goto L41
            r0 = 1
            goto L42
        L41:
            r0 = 0
        L42:
            if (r3 != 0) goto L48
            if (r0 == 0) goto L47
            goto L48
        L47:
            r1 = 0
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.DeviceHelper.checkRootSu():boolean");
    }

    public static Object currentActivityThread() {
        final ReflectHelper.ReflectRunnable<Void, Object> reflectRunnable = new ReflectHelper.ReflectRunnable<Void, Object>() { // from class: com.mob.tools.utils.DeviceHelper.3
            @Override // com.mob.tools.utils.ReflectHelper.ReflectRunnable
            public Object run(Void r3) {
                try {
                    return ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(Strings.getString(31)), Strings.getString(32), new Object[0]);
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                    return null;
                }
            }
        };
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            return reflectRunnable.run(null);
        }
        final Object obj = new Object();
        final Object[] objArr = new Object[1];
        synchronized (obj) {
            UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.utils.DeviceHelper.4
                /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                    jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x001a
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
                    */
                @Override // android.os.Handler.Callback
                public boolean handleMessage(android.os.Message r5) {
                    /*
                        r4 = this;
                        java.lang.Object r5 = r1
                        monitor-enter(r5)
                        r0 = 0
                        java.lang.Object[] r1 = r2     // Catch: java.lang.Throwable -> L20
                        com.mob.tools.utils.ReflectHelper$ReflectRunnable r2 = r3     // Catch: java.lang.Throwable -> L20
                        r3 = 0
                        java.lang.Object r2 = r2.run(r3)     // Catch: java.lang.Throwable -> L20
                        r1[r0] = r2     // Catch: java.lang.Throwable -> L20
                        java.lang.Object r1 = r1     // Catch: java.lang.Throwable -> L15
                        r1.notify()     // Catch: java.lang.Throwable -> L15
                        goto L34
                    L15:
                        r1 = move-exception
                        com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L1e
                    L1a:
                        r2.w(r1)     // Catch: java.lang.Throwable -> L1e
                        goto L34
                    L1e:
                        r0 = move-exception
                        goto L46
                    L20:
                        r1 = move-exception
                        com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L36
                        r2.w(r1)     // Catch: java.lang.Throwable -> L36
                        java.lang.Object r1 = r1     // Catch: java.lang.Throwable -> L2e
                        r1.notify()     // Catch: java.lang.Throwable -> L2e
                        goto L34
                    L2e:
                        r1 = move-exception
                        com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L1e
                        goto L1a
                    L34:
                        monitor-exit(r5)     // Catch: java.lang.Throwable -> L1e
                        return r0
                    L36:
                        r0 = move-exception
                        java.lang.Object r1 = r1     // Catch: java.lang.Throwable -> L3d
                        r1.notify()     // Catch: java.lang.Throwable -> L3d
                        goto L45
                    L3d:
                        r1 = move-exception
                        com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L1e
                        r2.w(r1)     // Catch: java.lang.Throwable -> L1e
                    L45:
                        throw r0     // Catch: java.lang.Throwable -> L1e
                    L46:
                        monitor-exit(r5)     // Catch: java.lang.Throwable -> L1e
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.DeviceHelper.AnonymousClass4.handleMessage(android.os.Message):boolean");
                }
            });
            obj.wait();
        }
        return objArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String genDeviceKeyByAdid() throws Throwable {
        String advertisingID = getAdvertisingID();
        if (TextUtils.isEmpty(advertisingID)) {
            return null;
        }
        return Data.byteToHex(Data.SHA1(advertisingID));
    }

    public static Context getApplication() {
        try {
            Object currentActivityThread = currentActivityThread();
            if (currentActivityThread != null) {
                return (Context) ReflectHelper.invokeInstanceMethod(currentActivityThread, Strings.getString(33), new Object[0]);
            }
            return null;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static synchronized DeviceHelper getInstance(Context context) {
        DeviceHelper deviceHelper2;
        synchronized (DeviceHelper.class) {
            if (deviceHelper == null && context != null) {
                deviceHelper = new DeviceHelper(context);
            }
            deviceHelper2 = deviceHelper;
        }
        return deviceHelper2;
    }

    private static List<String> getLauncherPackageNames(Context context) throws Throwable {
        return new ArrayList();
    }

    private String getLocalDeviceKey() throws Throwable {
        File cacheRootFile;
        String str = null;
        if (getSdcardState()) {
            File file = new File(getSdcardPath(), OnekeyShare.SHARESDK_TAG);
            if (file.exists()) {
                File file2 = new File(file, ".dk");
                if (file2.exists() && (cacheRootFile = ResHelper.getCacheRootFile(this.context, ".dk")) != null && file2.renameTo(cacheRootFile)) {
                    file2.delete();
                }
            }
            File cacheRootFile2 = ResHelper.getCacheRootFile(this.context, ".dk");
            if (cacheRootFile2 == null || cacheRootFile2.exists()) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(cacheRootFile2));
                Object readObject = objectInputStream.readObject();
                if (readObject != null && (readObject instanceof char[])) {
                    str = String.valueOf((char[]) readObject);
                }
                objectInputStream.close();
                return str;
            }
            return null;
        }
        return null;
    }

    private HashMap<String, Object> getMapFromOtherPlace(String str) {
        try {
            String AES128Decode = Data.AES128Decode(Strings.getString(76), (byte[]) ResHelper.readObjectFromFile(str));
            if (TextUtils.isEmpty(AES128Decode)) {
                return null;
            }
            HashMap<String, Object> fromJson = new Hashon().fromJson(AES128Decode);
            String str2 = (String) fromJson.remove(Strings.getString(78));
            String sortWabcd = getSortWabcd(fromJson);
            String MD5 = Data.MD5(sortWabcd + Strings.getString(77));
            if (str2 != null) {
                if (!str2.equals(MD5)) {
                    return null;
                }
            }
            return fromJson;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    private String getSortWabcd(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str = (String) hashMap.get("0");
        if (str != null) {
            sb.append(str);
        }
        String str2 = (String) hashMap.get("1");
        if (str2 != null) {
            sb.append(str2);
        }
        String str3 = (String) hashMap.get("2");
        if (str3 != null) {
            sb.append(str3);
        }
        String str4 = (String) hashMap.get("3");
        if (str4 != null) {
            sb.append(str4);
        }
        return sb.toString();
    }

    private String getSystemProperties(String str) {
        try {
            Object invokeStaticMethod = ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(Strings.getString(9)), Strings.getString(10), str);
            return invokeStaticMethod != null ? String.valueOf(invokeStaticMethod) : "";
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return "";
        }
    }

    public static String getTopApp(Context context) throws Throwable {
        if (Build.VERSION.SDK_INT >= 21) {
            UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService("usagestats");
            if (usageStatsManager != null) {
                long currentTimeMillis = System.currentTimeMillis();
                List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(4, currentTimeMillis - 3600000, currentTimeMillis);
                if (queryUsageStats == null || queryUsageStats.isEmpty()) {
                    return "";
                }
                int i2 = 0;
                for (int i3 = 0; i3 < queryUsageStats.size(); i3++) {
                    if (queryUsageStats.get(i3).getLastTimeUsed() > queryUsageStats.get(i2).getLastTimeUsed()) {
                        i2 = i3;
                    }
                }
                return queryUsageStats.get(i2).getPackageName();
            }
            return null;
        }
        return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName();
    }

    private void getTrafficBytes(String str, String str2, long[] jArr) {
        try {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                Matcher matcher = Pattern.compile(" \\d+ ").matcher(str.substring(indexOf));
                int i2 = 0;
                while (matcher.find()) {
                    if (i2 == 0) {
                        jArr[0] = Long.parseLong(matcher.group().trim());
                    } else if (i2 == 8) {
                        jArr[1] = Long.parseLong(matcher.group().trim());
                        return;
                    }
                    i2++;
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    private InputStream invokeRuntimeExec(String[] strArr) {
        try {
            return (InputStream) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(Strings.getString(42)), Strings.getString(43), new Object[0]), Strings.getString(44), strArr), Strings.getString(45), new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean isBackground(Context context) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                String packageName = context.getPackageName();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(packageName)) {
                        return runningAppProcessInfo.importance == 400;
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return false;
    }

    private void saveLocalDeviceKey(String str) throws Throwable {
        if (getSdcardState()) {
            File cacheRootFile = ResHelper.getCacheRootFile(this.context, ".dk");
            if (cacheRootFile != null && cacheRootFile.exists()) {
                cacheRootFile.delete();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(cacheRootFile));
            objectOutputStream.writeObject(str.toCharArray());
            objectOutputStream.flush();
            objectOutputStream.close();
        }
    }

    public String Base64AES(String str, String str2) {
        try {
            String encodeToString = Base64.encodeToString(Data.AES128Encode(str2, str), 0);
            return encodeToString.contains("\n") ? encodeToString.replace("\n", "") : encodeToString;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public boolean amIOnForeground() {
        try {
            if (Build.VERSION.SDK_INT > 27) {
                return !isBackground(this.context);
            }
            for (Object obj : ((Map) ReflectHelper.getInstanceField(currentActivityThread(), Strings.getString(23))).values()) {
                if (!((Boolean) ReflectHelper.getInstanceField(obj, Strings.getString(24))).booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return false;
        }
    }

    public int bs(final Context context, Intent intent) throws Throwable {
        final boolean[] zArr = {false};
        try {
            if (context.bindService(intent, new ServiceConnection() { // from class: com.mob.tools.utils.DeviceHelper.5
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        synchronized (zArr) {
                            boolean[] zArr2 = zArr;
                            zArr2[0] = true;
                            zArr2.notifyAll();
                            context.unbindService(this);
                        }
                    } catch (Throwable th) {
                        MobLog.getInstance().d(th);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    try {
                        synchronized (zArr) {
                            zArr.notifyAll();
                        }
                    } catch (Throwable th) {
                        MobLog.getInstance().d(th);
                    }
                }
            }, 1)) {
                long j2 = 200;
                while (!zArr[0] && j2 > 0) {
                    synchronized (zArr) {
                        j2 -= 20;
                        zArr.wait(20L);
                    }
                }
                return zArr[0] ? 1 : 2;
            }
            return 0;
        } catch (SecurityException e2) {
            MobLog.getInstance().d(e2);
            return 3;
        }
    }

    public int ca(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                return cs(context, launchIntentForPackage);
            }
            return 0;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return 3;
        }
    }

    public int cb(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("", str));
                return 1;
            }
            ((ClipboardManager) context.getSystemService("clipboard")).setText(str);
            return 1;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return 2;
        }
    }

    public boolean checkADBModel(int i2) {
        if (i2 != 1) {
            if (i2 == 273) {
                return usbEnable() && devEnable();
            } else if (i2 != 16) {
                if (i2 != 17) {
                    return false;
                }
                return usbEnable() || devEnable();
            } else {
                return devEnable();
            }
        }
        return usbEnable();
    }

    public boolean checkPad() {
        return (this.context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public boolean checkPermission(String str) throws Throwable {
        int i2 = -1;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ReflectHelper.importClass("android.content.Context");
                Integer num = (Integer) ReflectHelper.invokeInstanceMethod(this.context, Strings.getString(22), str);
                if (num != null) {
                    i2 = num.intValue();
                }
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        } else {
            i2 = this.context.getPackageManager().checkPermission(str, getPackageName());
        }
        return i2 == 0;
    }

    public boolean checkUA() {
        try {
            return ((Intent) ReflectHelper.invokeInstanceMethod(this.context, "registerReceiver", new Object[]{null, new IntentFilter("android.intent.action.BATTERY_CHANGED")}, new Class[]{BroadcastReceiver.class, IntentFilter.class})).getIntExtra("plugged", -1) == 2;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return false;
        }
    }

    public int cs(Context context, Intent intent) {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT < 26) {
            try {
                ComponentName component = intent.getComponent();
                String packageName = component.getPackageName();
                String className = component.getClassName();
                List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(1000);
                if (runningServices != null && !runningServices.isEmpty()) {
                    Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
                    z2 = false;
                    while (true) {
                        if (!it.hasNext()) {
                            z = false;
                            break;
                        }
                        ActivityManager.RunningServiceInfo next = it.next();
                        String packageName2 = next.service.getPackageName();
                        String className2 = next.service.getClassName();
                        if (packageName2.equals(packageName)) {
                            if (className2.equals(className)) {
                                z = true;
                                z2 = true;
                                break;
                            }
                            z2 = true;
                        }
                    }
                } else {
                    z = false;
                    z2 = false;
                }
                if (z2) {
                    return z ? 1 : 2;
                }
                return 0;
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return 3;
            }
        }
        return 4;
    }

    public int cscreen() {
        if (((PowerManager) this.context.getSystemService("power")).isScreenOn()) {
            return ((KeyguardManager) this.context.getSystemService("keyguard")).inKeyguardRestrictedInputMode() ? 2 : 1;
        }
        return 0;
    }

    public boolean cx() {
        BufferedReader bufferedReader;
        Throwable th;
        try {
            if (this.context.getPackageManager().getPackageInfo("de.robv.android.xposed.installer", 0) != null) {
                return true;
            }
        } catch (Throwable unused) {
        }
        try {
            throw new Exception("test");
        } catch (Throwable th2) {
            for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                if (stackTraceElement.getClassName().contains("de.robv.android.xposed.XposedBridge")) {
                    return true;
                }
            }
            try {
                try {
                    ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedHelpers").newInstance();
                    try {
                        ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedBridge").newInstance();
                    } catch (IllegalAccessException | InstantiationException unused2) {
                    }
                    return true;
                } catch (IllegalAccessException | InstantiationException unused3) {
                    return true;
                }
            } catch (Throwable th3) {
                MobLog.getInstance().d(th3);
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
                    boolean z = false;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null && !z) {
                                z = readLine.toLowerCase().contains("xposed");
                            } else {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    MobLog.getInstance().d(e2);
                                }
                                return z;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            try {
                                MobLog.getInstance().d(th);
                                return false;
                            } finally {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                        MobLog.getInstance().d(e3);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th5) {
                    bufferedReader = null;
                    th = th5;
                }
            }
        }
    }

    public boolean debugable() {
        try {
            return (this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 1).applicationInfo.flags & 2) != 0;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return false;
        }
    }

    public boolean devEnable() {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT < 17 ? Settings.Secure.getInt(this.context.getContentResolver(), "development_settings_enabled", 0) > 0 : Settings.Secure.getInt(this.context.getContentResolver(), "development_settings_enabled", 0) > 0) {
                z = true;
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public String gb(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                ClipData primaryClip = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
                if (primaryClip == null || primaryClip.getItemCount() <= 0) {
                    return null;
                }
                return primaryClip.getItemAt(0).getText().toString();
            }
            return (String) ((ClipboardManager) context.getSystemService("clipboard")).getText();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public ArrayList<HashMap<String, String>> getAA() {
        return getAL(false, true);
    }

    public synchronized ArrayList<HashMap<String, String>> getAL(boolean z, boolean z2) {
        return getAL(z, z2, true);
    }

    public String getAdvertisingID() throws Throwable {
        String str;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (!TextUtils.isEmpty(this.advertiseID)) {
                return this.advertiseID;
            }
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            GSConnection gSConnection = new GSConnection();
            try {
                this.context.bindService(intent, gSConnection, 1);
                IBinder takeBinder = gSConnection.takeBinder();
                if (takeBinder == null) {
                    str = this.advertiseID;
                } else {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    takeBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    this.advertiseID = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    str = this.advertiseID;
                }
            } finally {
                try {
                    return str;
                } finally {
                }
            }
            return str;
        }
        throw new Throwable("Do not call this function from the main thread !");
    }

    public String getAdvertisingIDByGms() throws Throwable {
        AdvertisingIdClient.Info advertisingIdInfo;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (!TextUtils.isEmpty(this.advertisingID)) {
                return this.advertisingID;
            }
            try {
                if (isGooglePlayServicesAvailable() && (advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context)) != null) {
                    this.advertisingID = advertisingIdInfo.getId();
                }
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
            return this.advertisingID;
        }
        throw new Throwable("Do not call this function from the main thread !");
    }

    public int getAlbumCount() {
        Cursor query;
        int i2 = 0;
        try {
            if (!checkPermission("android.permission.READ_EXTERNAL_STORAGE") || (query = this.context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "bucket_display_name like ? or bucket_display_name like ? or bucket_display_name like ?", new String[]{"%Camera%", "%相机%", "%DCIM%"}, "datetaken")) == null) {
                return 0;
            }
            i2 = query.getCount();
            query.close();
            return i2;
        } catch (Throwable unused) {
            return i2;
        }
    }

    public String getAndroidID() {
        try {
            String string = Settings.Secure.getString(this.context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
            NLog mobLog = MobLog.getInstance();
            mobLog.i("getAndroidID === " + string, new Object[0]);
            return string;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return "";
        }
    }

    public String getAppLanguage() {
        return this.context.getResources().getConfiguration().locale.getLanguage();
    }

    public String getAppName() {
        try {
            ApplicationInfo applicationInfo = this.context.getApplicationInfo();
            String str = applicationInfo.name;
            if (str != null) {
                if (Build.VERSION.SDK_INT < 25 || str.endsWith(".*")) {
                    return str;
                }
                try {
                    ReflectHelper.importClass(str);
                } catch (Throwable unused) {
                }
            }
            int i2 = applicationInfo.labelRes;
            if (i2 > 0) {
                return this.context.getString(i2);
            }
            return String.valueOf(applicationInfo.nonLocalizedLabel);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return "";
        }
    }

    public int getAppVersion() {
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            if (Build.VERSION.SDK_INT >= 28) {
                return (int) packageInfo.getLongVersionCode();
            }
            return packageInfo.versionCode;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return 0;
        }
    }

    public String getAppVersionName() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return "1.0";
        }
    }

    public ArrayList<HashMap<String, Object>> getArpList() {
        return null;
    }

    public ArrayList<HashMap<String, Object>> getAvailableWifiList() {
        return null;
    }

    public String getBTMac() {
        return null;
    }

    public String getBTMacFromProvider() {
        return null;
    }

    public String getBaseband() {
        try {
            return getSystemProperties(Strings.getString(116));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public void getBatteryState(final ReflectHelper.ReflectRunnable<HashMap<String, Object>, Void> reflectRunnable) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            ReflectHelper.invokeInstanceMethod(this.context, "registerReceiver", new Object[]{new BroadcastReceiver() { // from class: com.mob.tools.utils.DeviceHelper.6
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    VdsAgent.onBroadcastReceiver(this, context, intent);
                    HashMap hashMap = new HashMap();
                    for (String str : intent.getExtras().keySet()) {
                        hashMap.put(str, intent.getExtras().get(str));
                    }
                    ReflectHelper.ReflectRunnable reflectRunnable2 = reflectRunnable;
                    if (reflectRunnable2 != null) {
                        reflectRunnable2.run(hashMap);
                    }
                    try {
                        ReflectHelper.invokeInstanceMethod(context, "unregisterReceiver", new Object[]{this}, new Class[]{BroadcastReceiver.class});
                    } catch (Throwable unused) {
                    }
                }
            }, intentFilter}, new Class[]{BroadcastReceiver.class, IntentFilter.class});
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            if (reflectRunnable != null) {
                reflectRunnable.run(null);
            }
        }
    }

    public String getBluetoothName() {
        return null;
    }

    public String getBoardFromSysProperty() {
        try {
            return getSystemProperties(Strings.getString(117));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public String getBoardPlatform() {
        try {
            return getSystemProperties(Strings.getString(118));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public ArrayList<HashMap<String, Object>> getBondedBluetooth() {
        return new ArrayList<>();
    }

    public String getBrand() {
        return Build.BRAND;
    }

    public String getBssid() {
        return null;
    }

    public HashMap<String, String> getCPUFreq() {
        HashMap<String, String> hashMap = new HashMap<>();
        String readFile = readFile("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
        if (!TextUtils.isEmpty(readFile)) {
            hashMap.put("currentCpuHz", readFile);
        }
        String readFile2 = readFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
        if (!TextUtils.isEmpty(readFile2)) {
            hashMap.put("minCpuHz", readFile2);
        }
        String readFile3 = readFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
        if (!TextUtils.isEmpty(readFile3)) {
            hashMap.put("maxCpuHz", readFile3);
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
        r3.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (r5 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.HashMap<java.lang.String, java.lang.Object> getCPUInfo() {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L7f
            r2 = 41
            java.lang.String r2 = com.mob.tools.utils.Strings.getString(r2)     // Catch: java.lang.Throwable -> L7f
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7f
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L7f
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L7f
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L7f
            r3.<init>()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = "processors"
            r0.put(r4, r3)     // Catch: java.lang.Throwable -> L7f
            r4 = 0
        L20:
            r5 = r4
        L21:
            java.lang.String r6 = r2.readLine()     // Catch: java.lang.Throwable -> L7f
            if (r6 == 0) goto L78
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L7f
            if (r7 == 0) goto L33
            if (r5 == 0) goto L20
            r3.add(r5)     // Catch: java.lang.Throwable -> L7f
            goto L20
        L33:
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L7f
            java.lang.String r7 = "processor"
            boolean r7 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> L7f
            if (r7 == 0) goto L49
            if (r5 == 0) goto L44
            r3.add(r5)     // Catch: java.lang.Throwable -> L7f
        L44:
            java.util.HashMap r5 = new java.util.HashMap     // Catch: java.lang.Throwable -> L7f
            r5.<init>()     // Catch: java.lang.Throwable -> L7f
        L49:
            java.lang.String r7 = ":"
            java.lang.String[] r6 = r6.split(r7)     // Catch: java.lang.Throwable -> L7f
            if (r6 == 0) goto L21
            int r7 = r6.length     // Catch: java.lang.Throwable -> L7f
            r8 = 1
            if (r7 <= r8) goto L21
            r7 = 0
            if (r5 != 0) goto L68
            r7 = r6[r7]     // Catch: java.lang.Throwable -> L7f
            java.lang.String r7 = r7.trim()     // Catch: java.lang.Throwable -> L7f
            r6 = r6[r8]     // Catch: java.lang.Throwable -> L7f
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L7f
            r0.put(r7, r6)     // Catch: java.lang.Throwable -> L7f
            goto L21
        L68:
            r7 = r6[r7]     // Catch: java.lang.Throwable -> L7f
            java.lang.String r7 = r7.trim()     // Catch: java.lang.Throwable -> L7f
            r6 = r6[r8]     // Catch: java.lang.Throwable -> L7f
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L7f
            r5.put(r7, r6)     // Catch: java.lang.Throwable -> L7f
            goto L21
        L78:
            r2.close()     // Catch: java.lang.Throwable -> L7f
            r1.close()     // Catch: java.lang.Throwable -> L7f
            goto L87
        L7f:
            r1 = move-exception
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            r2.d(r1)
        L87:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.DeviceHelper.getCPUInfo():java.util.HashMap");
    }

    public String getCPUType() {
        try {
            return Build.VERSION.SDK_INT < 21 ? Build.CPU_ABI : Build.SUPPORTED_ABIS[0];
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public ArrayList<HashMap<String, String>> getCamResolution() {
        return null;
    }

    public String getCarrier() {
        try {
            Object systemServiceSafe = getSystemServiceSafe("phone");
            if (systemServiceSafe == null) {
                return TaskDetailBasePresenter.SCENE_LIST;
            }
            String str = (String) ReflectHelper.invokeInstanceMethod(systemServiceSafe, Strings.getString(12), new Object[0]);
            return TextUtils.isEmpty(str) ? TaskDetailBasePresenter.SCENE_LIST : str;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return TaskDetailBasePresenter.SCENE_LIST;
        }
    }

    public String getCarrierName() {
        Object systemServiceSafe = getSystemServiceSafe("phone");
        if (systemServiceSafe == null) {
            return null;
        }
        try {
            if (checkPermission("android.permission.READ_PHONE_STATE")) {
                String str = (String) ReflectHelper.invokeInstanceMethod(systemServiceSafe, Strings.getString(13), new Object[0]);
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return str;
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return null;
    }

    public int getCdmaBid() {
        return -1;
    }

    public int getCdmaLat() {
        return -1;
    }

    public int getCdmaLon() {
        return -1;
    }

    public int getCdmaNid() {
        return -1;
    }

    public int getCdmaSid() {
        return -1;
    }

    public int getCellId() {
        return -1;
    }

    public int getCellLac() {
        return -1;
    }

    public String getCharAndNumr(int i2) {
        long currentTimeMillis = System.currentTimeMillis() ^ SystemClock.elapsedRealtime();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(currentTimeMillis);
        Random random = new Random();
        for (int i3 = 0; i3 < i2; i3++) {
            if ("char".equalsIgnoreCase(random.nextInt(2) % 2 == 0 ? "char" : "num")) {
                stringBuffer.insert(i3 + 1, (char) (random.nextInt(26) + 97));
            } else {
                stringBuffer.insert(stringBuffer.length(), random.nextInt(10));
            }
        }
        return stringBuffer.toString().substring(0, 40);
    }

    public HashMap<String, Object> getCurrentWifiInfo() {
        return null;
    }

    public int getDataNtType() {
        return NtFetcher.getInstance(this.context).getDtNtType();
    }

    public HashMap<String, Object> getDefaultIM() {
        HashMap<String, Object> hashMap;
        Throwable th;
        try {
            String defaultIMPkg = getDefaultIMPkg();
            String appName = getAppName(defaultIMPkg);
            hashMap = new HashMap<>();
            try {
                hashMap.put("name", appName);
                hashMap.put("pkg", defaultIMPkg);
            } catch (Throwable th2) {
                th = th2;
                MobLog.getInstance().d(th);
                return hashMap;
            }
        } catch (Throwable th3) {
            hashMap = null;
            th = th3;
        }
        return hashMap;
    }

    public String getDefaultIMPkg() {
        try {
            String string = Settings.Secure.getString(this.context.getContentResolver(), "default_input_method");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string.split("/")[0];
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public String getDefaultResolvePkg(String str) {
        return null;
    }

    public String getDetailNetworkTypeForStatic() {
        try {
            String lowerCase = getNetworkType().toLowerCase();
            if (!TextUtils.isEmpty(lowerCase) && !PortalFollowFeeds.TYPE_NONE.equals(lowerCase)) {
                return lowerCase.startsWith("wifi") ? "wifi" : lowerCase.startsWith("5g") ? "5g" : lowerCase.startsWith("4g") ? "4g" : lowerCase.startsWith("3g") ? "3g" : lowerCase.startsWith("2g") ? "2g" : lowerCase.startsWith("bluetooth") ? "bluetooth" : lowerCase;
            }
            return PortalFollowFeeds.TYPE_NONE;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return PortalFollowFeeds.TYPE_NONE;
        }
    }

    public String getDeviceData() {
        try {
            String str = getModel() + Effect.DIVIDER + getOSVersionInt() + Effect.DIVIDER + getManufacturer() + Effect.DIVIDER + getCarrier() + Effect.DIVIDER + getScreenSize();
            String deviceKey = getDeviceKey();
            if (deviceKey == null) {
                deviceKey = "";
            } else if (deviceKey.length() > 16) {
                deviceKey = deviceKey.substring(0, 16);
            }
            return Base64AES(str, deviceKey);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return "";
        }
    }

    public String getDeviceDataNotAES() {
        return getModel() + Effect.DIVIDER + getOSVersionInt() + Effect.DIVIDER + getManufacturer() + Effect.DIVIDER + getCarrier() + Effect.DIVIDER + getScreenSize();
    }

    public String getDeviceId() {
        String imei = getIMEI();
        return (!TextUtils.isEmpty(imei) || Build.VERSION.SDK_INT < 9) ? imei : getSerialno();
    }

    public synchronized String getDeviceKey() {
        String genDeviceKeyByAdid;
        if (!TextUtils.isEmpty(this.cacheDeviceKey)) {
            return this.cacheDeviceKey;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!TextUtils.isEmpty(this.tempDeviceKey)) {
                genDeviceKeyByAdid = this.tempDeviceKey;
            } else {
                genDeviceKeyByAdid = getCharAndNumr(40);
                this.tempDeviceKey = genDeviceKeyByAdid;
                new Thread(new Runnable() { // from class: com.mob.tools.utils.DeviceHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            DeviceHelper deviceHelper2 = DeviceHelper.this;
                            deviceHelper2.cacheDeviceKey = deviceHelper2.genDeviceKeyByAdid();
                        } catch (Throwable th) {
                            MobLog.getInstance().d(th);
                        }
                    }
                }).start();
            }
        } else {
            genDeviceKeyByAdid = genDeviceKeyByAdid();
            if (TextUtils.isEmpty(genDeviceKeyByAdid)) {
                genDeviceKeyByAdid = getCharAndNumr(40);
            }
            this.cacheDeviceKey = genDeviceKeyByAdid;
        }
        return genDeviceKeyByAdid;
    }

    public HashMap<String, Object> getDeviceMemUsage() {
        HashMap<String, Object> hashMap = new HashMap<>();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(Strings.getString(125)));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.split("\\s+");
                        if (split != null && split.length > 1) {
                            String str = split[0];
                            long parseLong = Long.parseLong(split[1]) * 1024;
                            if ("MemTotal:".equals(str)) {
                                hashMap.put("totalMemorySize", Long.valueOf(parseLong));
                            } else if ("MemFree:".equals(str)) {
                                hashMap.put("freeMemorySize", Long.valueOf(parseLong));
                            } else if ("MemAvailable:".equals(str)) {
                                hashMap.put("availableMemorySize", Long.valueOf(parseLong));
                            } else if ("Active:".equals(str)) {
                                hashMap.put("activeMemorySize", Long.valueOf(parseLong));
                            } else if ("Inactive:".equals(str)) {
                                hashMap.put("inactiveMemorySize", Long.valueOf(parseLong));
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        try {
                            MobLog.getInstance().d(th);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return hashMap;
                        } catch (Throwable th2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th3) {
                                    MobLog.getInstance().d(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                }
                bufferedReader2.close();
            } catch (Throwable th4) {
                MobLog.getInstance().d(th4);
            }
        } catch (Throwable th5) {
            th = th5;
        }
        return hashMap;
    }

    public String getDeviceType() {
        try {
            UiModeManager uiModeManager = (UiModeManager) getSystemServiceSafe("uimode");
            if (uiModeManager != null) {
                switch (uiModeManager.getCurrentModeType()) {
                    case 1:
                        return "NO_UI";
                    case 2:
                        return "DESK";
                    case 3:
                        return "CAR";
                    case 4:
                        return "TELEVISION";
                    case 5:
                        return "APPLIANCE";
                    case 6:
                        return "WATCH";
                    case 7:
                        return "VRHEADSET";
                    default:
                        return "UNDEFINED";
                }
            }
            return "UNDEFINED";
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return "UNDEFINED";
        }
    }

    public long getElapsedTime() {
        try {
            return SystemClock.elapsedRealtime();
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return 0L;
        }
    }

    public String getFlavor() {
        try {
            return getSystemProperties(Strings.getString(119));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public ArrayList<HashMap<String, String>> getIA(boolean z) {
        return getIA(z, true);
    }

    public HashMap<String, Object> getIInfo() {
        return getIInfo(false);
    }

    public HashMap<String, Object> getIInfo(boolean z) {
        return null;
    }

    public String getIMEI() {
        return null;
    }

    public ArrayList<HashMap<String, Object>> getIMList() {
        ArrayList<HashMap<String, Object>> arrayList;
        Throwable th;
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) getSystemServiceSafe("input_method")).getInputMethodList();
            arrayList = new ArrayList<>();
            try {
                for (InputMethodInfo inputMethodInfo : inputMethodList) {
                    if (inputMethodInfo != null) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("name", inputMethodInfo.loadLabel(this.context.getPackageManager()));
                        hashMap.put("pkg", inputMethodInfo.getPackageName());
                        arrayList.add(hashMap);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                MobLog.getInstance().d(th);
                return arrayList;
            }
        } catch (Throwable th3) {
            arrayList = null;
            th = th3;
        }
        return arrayList;
    }

    public String getIMSI() {
        return null;
    }

    public String getIPAddress() {
        try {
            if (checkPermission("android.permission.INTERNET")) {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
                return "0.0.0.0";
            }
            return "0.0.0.0";
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return "0.0.0.0";
        }
    }

    public List<Object[]> getIntent(String str) throws Throwable {
        return null;
    }

    public List<Object[]> getIntentA(String str) {
        return null;
    }

    public List<Object[]> getIntentSP(String str) {
        return null;
    }

    public String getLN() {
        return TaskDetailBasePresenter.SCENE_LIST;
    }

    public ArrayList<HashMap<String, Object>> getLocalIpInfo() {
        return null;
    }

    public Location getLocation(int i2, int i3, boolean z) {
        return null;
    }

    public String getMCC() {
        String imsi = getIMSI();
        if (imsi == null || imsi.length() < 3) {
            return null;
        }
        return imsi.substring(0, 3);
    }

    public String getMIUIVersion() {
        if (!TextUtils.isEmpty(this.bufUiVersion)) {
            return this.bufUiVersion;
        }
        String systemProperties = getSystemProperties(Strings.getString(65));
        if (TextUtils.isEmpty(systemProperties)) {
            systemProperties = getSystemProperties(Strings.getString(66));
        }
        if (TextUtils.isEmpty(systemProperties)) {
            systemProperties = getSystemProperties(Strings.getString(67));
        }
        if (TextUtils.isEmpty(systemProperties)) {
            systemProperties = getSystemProperties(Strings.getString(135));
        }
        if (TextUtils.isEmpty(systemProperties)) {
            systemProperties = getSystemProperties(Strings.getString(136));
        }
        if (TextUtils.isEmpty(systemProperties)) {
            systemProperties = getSystemProperties(Strings.getString(69));
        }
        this.bufUiVersion = systemProperties;
        return systemProperties;
    }

    public String getMNC() {
        String imsi = getIMSI();
        if (imsi == null || imsi.length() < 5) {
            return null;
        }
        return imsi.substring(3, 5);
    }

    public String getMacAddress() {
        return null;
    }

    public String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public HashMap<String, Long> getMemoryInfo() {
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put(PluginShareConstants.MemoryCanaryShareKeys.AVAILABLE, -1L);
        hashMap.put("total", -1L);
        hashMap.put("isLow", -1L);
        hashMap.put("threshold", -1L);
        try {
            Object systemServiceSafe = getSystemServiceSafe(Strings.getString(30));
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ReflectHelper.invokeInstanceMethod(systemServiceSafe, Strings.getString(64), memoryInfo);
            hashMap.put(PluginShareConstants.MemoryCanaryShareKeys.AVAILABLE, Long.valueOf(memoryInfo.availMem));
            hashMap.put("total", Long.valueOf(memoryInfo.totalMem));
            hashMap.put("isLow", Long.valueOf(memoryInfo.lowMemory ? 1L : 0L));
            hashMap.put("threshold", Long.valueOf(memoryInfo.threshold));
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public String getModel() {
        if (!TextUtils.isEmpty(this.bufModel)) {
            return this.bufModel;
        }
        String str = Build.MODEL;
        if (!TextUtils.isEmpty(str)) {
            str = str.trim();
        }
        this.bufModel = str;
        return str;
    }

    public ArrayList<HashMap<String, Object>> getNeighboringCellInfo() {
        return null;
    }

    public String getNetworkOperator() {
        Object systemServiceSafe = getSystemServiceSafe("phone");
        if (systemServiceSafe == null) {
            return null;
        }
        try {
            return (String) ReflectHelper.invokeInstanceMethod(systemServiceSafe, Strings.getString(21), new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public String getNetworkType() {
        return NtFetcher.getInstance(this.context).getNtType();
    }

    public String getNetworkTypeForStatic() {
        String lowerCase = getNetworkType().toLowerCase();
        return (TextUtils.isEmpty(lowerCase) || PortalFollowFeeds.TYPE_NONE.equals(lowerCase)) ? PortalFollowFeeds.TYPE_NONE : (lowerCase.startsWith("5g") || lowerCase.startsWith("4g") || lowerCase.startsWith("3g") || lowerCase.startsWith("2g")) ? "cell" : lowerCase.startsWith("wifi") ? "wifi" : a.PAGE_TYPE_OTHER;
    }

    public String getOSCountry() {
        return Locale.getDefault().getCountry();
    }

    public String getOSLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public int getOSVersionInt() {
        return Build.VERSION.SDK_INT;
    }

    public String getOSVersionName() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public int getPlatformCode() {
        return 1;
    }

    public String getProcessor() {
        String str;
        BufferedReader bufferedReader = null;
        r0 = null;
        String str2 = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(Strings.getString(41)));
            try {
                Pattern compile = Pattern.compile("Processor\\s*:\\s*(.*)");
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        Matcher matcher = compile.matcher(readLine);
                        if (matcher.matches()) {
                            str2 = matcher.group(1);
                        }
                    } else {
                        try {
                            bufferedReader2.close();
                            return str2;
                        } catch (IOException e2) {
                            MobLog.getInstance().d(e2);
                            return str2;
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                str = str2;
                bufferedReader = bufferedReader2;
                try {
                    MobLog.getInstance().d(th);
                    return str;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            MobLog.getInstance().d(e3);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    public int getPsc() {
        return -1;
    }

    public String getQemuKernel() {
        try {
            return (String) ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(Strings.getString(9)), Strings.getString(10), Strings.getString(53), "0");
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return "0";
        }
    }

    public List<String> getResolvePkgs(String str) {
        return null;
    }

    public ArrayList<HashMap<String, String>> getSA() {
        return getAL(true, true);
    }

    public String getSSID() {
        return null;
    }

    public int getScreenBrightness() {
        try {
            return Settings.System.getInt(this.context.getContentResolver(), "screen_brightness");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return -1;
        }
    }

    public int getScreenBrightnessMode() {
        try {
            return Settings.System.getInt(this.context.getContentResolver(), "screen_brightness_mode");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return -1;
        }
    }

    public String getScreenSize() {
        int[] screenSize = ResHelper.getScreenSize(this.context);
        if (this.context.getResources().getConfiguration().orientation == 1) {
            return screenSize[0] + "x" + screenSize[1];
        }
        return screenSize[1] + "x" + screenSize[0];
    }

    public String getSdcardPath() {
        try {
            if (!TextUtils.isEmpty(this.bvs.sdp)) {
                return this.bvs.sdp;
            }
            this.bvs.sdp = this.context.getExternalFilesDir(null).getAbsolutePath();
            return this.bvs.sdp;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean getSdcardState() {
        if (!this.hasSdcardWritePermission) {
            try {
                this.hasSdcardWritePermission = checkPermission("android.permission.WRITE_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState());
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
        }
        return this.hasSdcardWritePermission;
    }

    public String getSerialno() {
        return null;
    }

    public String getSignMD5() {
        try {
            return Data.MD5(this.context.getPackageManager().getPackageInfo(getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e2) {
            MobLog.getInstance().w(e2);
            return null;
        }
    }

    public String getSimSerialNumber() {
        return TaskDetailBasePresenter.SCENE_LIST;
    }

    public HashMap<String, HashMap<String, Long>> getSizeInfo() {
        long availableBlocksLong;
        long freeBlocksLong;
        long blockCountLong;
        long blockSizeLong;
        HashMap<String, HashMap<String, Long>> hashMap = new HashMap<>();
        String[] strArr = {"sdcard", "data"};
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            HashMap<String, Long> hashMap2 = new HashMap<>();
            hashMap2.put(PluginShareConstants.MemoryCanaryShareKeys.AVAILABLE, -1L);
            hashMap2.put(FreeBox.TYPE, -1L);
            hashMap2.put("total", -1L);
            hashMap.put(str, hashMap2);
        }
        HashMap hashMap3 = new HashMap();
        try {
            String sdcardPath = getSdcardPath();
            if (sdcardPath != null) {
                hashMap3.put("sdcard", new StatFs(sdcardPath));
            }
        } catch (Throwable unused) {
        }
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory != null) {
                hashMap3.put("data", new StatFs(dataDirectory.getPath()));
            }
        } catch (Throwable unused2) {
        }
        for (Map.Entry entry : hashMap3.entrySet()) {
            StatFs statFs = (StatFs) entry.getValue();
            if (Build.VERSION.SDK_INT <= 18) {
                availableBlocksLong = statFs.getAvailableBlocks() * statFs.getBlockSize();
                freeBlocksLong = statFs.getFreeBlocks() * statFs.getBlockSize();
                blockCountLong = statFs.getBlockCount();
                blockSizeLong = statFs.getBlockSize();
            } else {
                availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
                freeBlocksLong = statFs.getFreeBlocksLong() * statFs.getBlockSizeLong();
                blockCountLong = statFs.getBlockCountLong();
                blockSizeLong = statFs.getBlockSizeLong();
            }
            HashMap<String, Long> hashMap4 = hashMap.get(entry.getKey());
            hashMap4.put(PluginShareConstants.MemoryCanaryShareKeys.AVAILABLE, Long.valueOf(availableBlocksLong));
            hashMap4.put(FreeBox.TYPE, Long.valueOf(freeBlocksLong));
            hashMap4.put("total", Long.valueOf(blockCountLong * blockSizeLong));
        }
        return hashMap;
    }

    public int getStatusBarHeight() {
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return this.context.getResources().getDimensionPixelSize(((Integer) ReflectHelper.getStaticField(ReflectHelper.importClass("com.android.internal.R$dimen"), "status_bar_height")).intValue());
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return -1;
            }
        }
        return -1;
    }

    public HashMap<String, Object> getSupport() {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            PackageManager packageManager = this.context.getPackageManager();
            if (packageManager != null) {
                try {
                    hashMap.put(TapjoyConstants.TJC_CONNECTION_TYPE_MOBILE, Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.telephony")));
                } catch (Throwable unused) {
                }
                try {
                    hashMap.put("wifi", Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.wifi")));
                } catch (Throwable unused2) {
                }
                try {
                    hashMap.put("gps", Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.location.gps")));
                } catch (Throwable unused3) {
                }
                TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
                hashMap.put("telephone", Boolean.valueOf((telephonyManager == null || telephonyManager.getPhoneType() == 0) ? false : true));
                try {
                    hashMap.put("nfc", Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.nfc")));
                } catch (Throwable unused4) {
                }
                try {
                    hashMap.put("bluetooth", Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.bluetooth")));
                } catch (Throwable unused5) {
                }
                hashMap.put("otg", Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.usb.host")));
            }
        } catch (Throwable unused6) {
        }
        return hashMap;
    }

    public Object getSystemServiceSafe(String str) {
        try {
            return this.context.getSystemService(str);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public ArrayList<ArrayList<String>> getTTYDriversInfo() {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT < 28) {
            try {
                FileReader fileReader = new FileReader(Strings.getString(52));
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!TextUtils.isEmpty(readLine)) {
                        String[] split = readLine.trim().split(" ");
                        if (split.length > 1) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            for (String str : split) {
                                if (!TextUtils.isEmpty(str)) {
                                    arrayList2.add(str.trim());
                                }
                            }
                            arrayList.add(arrayList2);
                        }
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th) {
                MobLog.getInstance().d(th.getMessage(), new Object[0]);
            }
        }
        return arrayList;
    }

    public String getTimezone() {
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(this.context.getContentResolver(), configuration);
            Locale locale = configuration.locale;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            Calendar calendar = Calendar.getInstance(locale);
            if (calendar != null) {
                return calendar.getTimeZone().getID();
            }
            return null;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public Activity getTopActivity() {
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        Map map = (Map) ReflectHelper.getInstanceField(currentActivityThread(), Strings.getString(23));
        for (Object obj : map.values()) {
            if (!((Boolean) ReflectHelper.getInstanceField(obj, Strings.getString(29))).booleanValue()) {
                return (Activity) ReflectHelper.getInstanceField(obj, Strings.getString(30));
            }
        }
        for (Object obj2 : map.values()) {
            if (!((Boolean) ReflectHelper.getInstanceField(obj2, Strings.getString(24))).booleanValue()) {
                return (Activity) ReflectHelper.getInstanceField(obj2, Strings.getString(30));
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00af A[Catch: all -> 0x00d6, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x00df, blocks: (B:32:0x00a3, B:35:0x00af), top: B:54:0x00a3 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008b -> B:51:0x00a3). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.HashMap<java.lang.String, java.lang.Object> getTraffic() {
        /*
            r11 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 1
            r3 = 29
            if (r1 >= r3) goto La3
            r1 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L79
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L79
            r5 = 120(0x78, float:1.68E-43)
            java.lang.String r5 = com.mob.tools.utils.Strings.getString(r5)     // Catch: java.lang.Throwable -> L79
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L79
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L79
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r1.<init>()     // Catch: java.lang.Throwable -> L77
        L22:
            java.lang.String r4 = r3.readLine()     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto L31
            r1.append(r4)     // Catch: java.lang.Throwable -> L77
            java.lang.String r4 = "\n"
            r1.append(r4)     // Catch: java.lang.Throwable -> L77
            goto L22
        L31:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L73
            r4 = 2
            long[] r5 = new long[r4]     // Catch: java.lang.Throwable -> L77
            java.lang.String r6 = "wlan0:"
            r11.getTrafficBytes(r1, r6, r5)     // Catch: java.lang.Throwable -> L77
            java.lang.String r6 = "downFlowWifi"
            r7 = 0
            r8 = r5[r7]     // Catch: java.lang.Throwable -> L77
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L77
            r0.put(r6, r8)     // Catch: java.lang.Throwable -> L77
            java.lang.String r6 = "upwardFlowWifi"
            r8 = r5[r2]     // Catch: java.lang.Throwable -> L77
            java.lang.Long r5 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L77
            r0.put(r6, r5)     // Catch: java.lang.Throwable -> L77
            long[] r4 = new long[r4]     // Catch: java.lang.Throwable -> L77
            java.lang.String r5 = "rmnet0:"
            r11.getTrafficBytes(r1, r5, r4)     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "downFlowCellular"
            r5 = r4[r7]     // Catch: java.lang.Throwable -> L77
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L77
            r0.put(r1, r5)     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "upwardFlowCellular"
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L77
            java.lang.Long r4 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L77
            r0.put(r1, r4)     // Catch: java.lang.Throwable -> L77
        L73:
            r3.close()     // Catch: java.lang.Throwable -> L8a
            goto La3
        L77:
            r1 = move-exception
            goto L7d
        L79:
            r3 = move-exception
            r10 = r3
            r3 = r1
            r1 = r10
        L7d:
            com.mob.tools.log.NLog r4 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L93
            r4.d(r1)     // Catch: java.lang.Throwable -> L93
            if (r3 == 0) goto La3
            r3.close()     // Catch: java.lang.Throwable -> L8a
            goto La3
        L8a:
            r1 = move-exception
            com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()
            r3.d(r1)
            goto La3
        L93:
            r0 = move-exception
            if (r3 == 0) goto La2
            r3.close()     // Catch: java.lang.Throwable -> L9a
            goto La2
        L9a:
            r1 = move-exception
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            r2.d(r1)
        La2:
            throw r0
        La3:
            android.content.Context r1 = r11.context     // Catch: java.lang.Throwable -> Ldf
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Throwable -> Ldf
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Ldf
            r4 = 24
            if (r3 < r4) goto Le7
            android.content.Context r3 = r11.context     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Throwable -> Ld6
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r3, r2)     // Catch: java.lang.Throwable -> Ld6
            int r1 = r1.uid     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r2 = "upwardFlowApp"
            long r3 = android.net.TrafficStats.getUidTxBytes(r1)     // Catch: java.lang.Throwable -> Ld6
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> Ld6
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r2 = "downFlowApp"
            long r3 = android.net.TrafficStats.getUidRxBytes(r1)     // Catch: java.lang.Throwable -> Ld6
            java.lang.Long r1 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> Ld6
            r0.put(r2, r1)     // Catch: java.lang.Throwable -> Ld6
            goto Le7
        Ld6:
            r1 = move-exception
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> Ldf
            r2.w(r1)     // Catch: java.lang.Throwable -> Ldf
            goto Le7
        Ldf:
            r1 = move-exception
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            r2.d(r1)
        Le7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.DeviceHelper.getTraffic():java.util.HashMap");
    }

    public String getWAbcd(int i2) {
        String[] split;
        HashMap<String, Object> mapFromOtherPlace;
        try {
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        if (getSdcardState()) {
            String sdcardPath = getSdcardPath();
            if (!TextUtils.isEmpty(sdcardPath) && (split = Strings.getString(75).split(",")) != null && split.length > 0) {
                for (String str : split) {
                    if (str != null) {
                        String trim = str.trim();
                        if (TextUtils.isEmpty(trim)) {
                            continue;
                        } else {
                            File file = new File(sdcardPath + trim, ".mn_" + Strings.getString(137));
                            if (file.exists() && file.isFile() && (mapFromOtherPlace = getMapFromOtherPlace(file.getPath())) != null) {
                                String str2 = (String) mapFromOtherPlace.get(String.valueOf(i2));
                                if (!TextUtils.isEmpty(str2)) {
                                    return str2.trim();
                                }
                            }
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }

    public Bitmap getWallPaper() {
        int i2;
        try {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(this.context);
            Drawable peekDrawable = wallpaperManager.peekDrawable();
            if (peekDrawable == null && (peekDrawable = wallpaperManager.getWallpaperInfo().loadThumbnail(this.context.getPackageManager())) == null) {
                return null;
            }
            if (peekDrawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) peekDrawable).getBitmap();
            }
            int i3 = 1;
            if (peekDrawable.getIntrinsicWidth() <= 0 || peekDrawable.getIntrinsicHeight() <= 0) {
                i2 = 1;
            } else {
                i3 = peekDrawable.getIntrinsicWidth();
                i2 = peekDrawable.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            peekDrawable.setBounds(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
            peekDrawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public void hideSoftInput(View view) {
        Object systemServiceSafe = getSystemServiceSafe("input_method");
        if (systemServiceSafe == null) {
            return;
        }
        ((InputMethodManager) systemServiceSafe).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public int ih(Context context) throws Throwable {
        String topApp = getTopApp(context);
        return (topApp == null || !getLauncherPackageNames(context).contains(topApp)) ? 0 : 1;
    }

    public <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) ReflectHelper.invokeInstanceMethod(obj, str, objArr);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x014a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int ir(android.content.Context r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.DeviceHelper.ir(android.content.Context, java.lang.String):int");
    }

    public boolean isBT() {
        return false;
    }

    public boolean isFakePass(String str) {
        try {
            String importClass = ReflectHelper.importClass(Strings.getString(132));
            return ((Integer) ReflectHelper.invokeStaticMethod(importClass, Strings.getString(134), this.context, (String) ReflectHelper.invokeStaticMethod(importClass, Strings.getString(133), str), getPackageName())).intValue() == 1;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return false;
        }
    }

    public boolean isFreeMeOS() {
        try {
            String systemProperties = getSystemProperties("ro.build.freeme.label");
            if (TextUtils.isEmpty(systemProperties)) {
                return false;
            }
            return systemProperties.equalsIgnoreCase("FREEMEOS");
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isGooglePlayServicesAvailable() {
        try {
            return GoogleApiAvailabilityLight.getInstance().f(this.context) == 0;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return false;
        }
    }

    public boolean isPackageInstalled(String str) {
        try {
            return this.context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isRooted() {
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || checkRootFile() || checkRootApp() || checkRootSu() || checkRootRw() || checkRootProp();
    }

    public boolean isSSUIOS() {
        try {
            String systemProperties = getSystemProperties("ro.ssui.product");
            if (TextUtils.isEmpty(systemProperties)) {
                return false;
            }
            return !systemProperties.equalsIgnoreCase("unknown");
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isScopedStorage() {
        return (Build.VERSION.SDK_INT >= 29) && (this.context.getApplicationInfo().targetSdkVersion >= 29);
    }

    public boolean isSensitiveDevice() {
        try {
            String manufacturer = getManufacturer();
            String mIUIVersion = getMIUIVersion();
            return "xiaomi".equalsIgnoreCase(manufacturer) && (!TextUtils.isEmpty(mIUIVersion) && mIUIVersion.length() >= 3 && Integer.parseInt(mIUIVersion.substring(1)) >= 12);
        } catch (Throwable th) {
            String message = th.getMessage();
            MobLog.getInstance().d(message != null ? message : "", new Object[0]);
            return false;
        }
    }

    public boolean isSmlt() {
        Boolean bool;
        try {
            bool = this.isSmlt;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        SmltHelper smltHelper = new SmltHelper();
        int i2 = smltHelper.checkBaseband(this.context) == 1 ? 1 : 0;
        if (smltHelper.checkBoard(this.context) == 1) {
            i2++;
        }
        if (i2 >= 2) {
            this.isSmlt = Boolean.TRUE;
            return true;
        }
        if (smltHelper.checkPlatform(this.context) == 1) {
            i2++;
        }
        if (i2 >= 2) {
            this.isSmlt = Boolean.TRUE;
            return true;
        }
        if (smltHelper.checkFlavor(this.context) == 1) {
            i2++;
        }
        if (i2 >= 2) {
            this.isSmlt = Boolean.TRUE;
            return true;
        }
        if (smltHelper.checkCgroup() == 1) {
            i2++;
        }
        if (i2 >= 2) {
            this.isSmlt = Boolean.TRUE;
            return true;
        }
        if (smltHelper.checkBluetooth(this.context) == 1) {
            i2++;
        }
        if (i2 >= 2) {
            this.isSmlt = Boolean.TRUE;
            return true;
        }
        if (smltHelper.checkImei(this.context) == 1) {
            i2++;
        }
        if (i2 >= 2) {
            this.isSmlt = Boolean.TRUE;
            return true;
        }
        if (smltHelper.checkCommonApp(this.context) == 1) {
            i2++;
        }
        if (i2 >= 2) {
            this.isSmlt = Boolean.TRUE;
            return true;
        }
        if (smltHelper.checkCpuInfo() == 1) {
            i2++;
        }
        if (i2 >= 2) {
            this.isSmlt = Boolean.TRUE;
            return true;
        }
        if (smltHelper.checkSensor(this.context) == 1) {
            i2++;
        }
        if (i2 >= 2) {
            this.isSmlt = Boolean.TRUE;
            return true;
        }
        this.isSmlt = Boolean.FALSE;
        return false;
    }

    public boolean isWifiProxy() {
        String host;
        int port;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                host = System.getProperty("http.proxyHost");
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    property = TaskDetailBasePresenter.SCENE_LIST;
                }
                try {
                    port = Integer.parseInt(property);
                } catch (Throwable unused) {
                    port = -1;
                }
            } else {
                host = Proxy.getHost(this.context);
                port = Proxy.getPort(this.context);
            }
            return (TextUtils.isEmpty(host) || port == -1) ? false : true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public HashMap<String, String> listNetworkHardware() throws Throwable {
        return null;
    }

    public HashMap<String, String> ping(String str, int i2, int i3) {
        float f2;
        float f3;
        ArrayList arrayList = new ArrayList();
        try {
            int i4 = i3 + 8;
            Process process = (Process) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(Strings.getString(42)), Strings.getString(43), new Object[0]), Strings.getString(44), "ping -c " + i2 + " -s " + i3 + " " + str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream) ReflectHelper.invokeInstanceMethod(process, Strings.getString(45), new Object[0])));
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                if (readLine.startsWith(i4 + " bytes from")) {
                    if (readLine.endsWith("ms")) {
                        readLine = readLine.substring(0, readLine.length() - 2).trim();
                    } else if (readLine.endsWith("s")) {
                        readLine = readLine.substring(0, readLine.length() - 1).trim() + "000";
                    }
                    int indexOf = readLine.indexOf("time=");
                    if (indexOf > 0) {
                        arrayList.add(Float.valueOf(Float.parseFloat(readLine.substring(indexOf + 5).trim())));
                    }
                }
                readLine = bufferedReader.readLine();
            }
            process.waitFor();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        int size = arrayList.size();
        int size2 = i2 - arrayList.size();
        float f4 = 0.0f;
        if (size > 0) {
            float f5 = Float.MAX_VALUE;
            f3 = 0.0f;
            for (int i5 = 0; i5 < size; i5++) {
                float floatValue = ((Float) arrayList.get(i5)).floatValue();
                if (floatValue < f5) {
                    f5 = floatValue;
                }
                if (floatValue > f3) {
                    f3 = floatValue;
                }
                f4 += floatValue;
            }
            f2 = f4 / size;
            f4 = f5;
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("address", str);
        hashMap.put("transmitted", String.valueOf(i2));
        hashMap.put("received", String.valueOf(size));
        hashMap.put("loss", String.valueOf(size2));
        hashMap.put("min", String.valueOf(f4));
        hashMap.put("max", String.valueOf(f3));
        hashMap.put("avg", String.valueOf(f2));
        return hashMap;
    }

    public String[] queryIMEI() {
        return null;
    }

    public String[] queryIMSI() {
        return null;
    }

    public String readFile(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(str);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String trim = readLine.trim();
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(trim);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return sb.toString();
    }

    public void registerBtWatcher(String str, BtWatcher btWatcher) {
    }

    public void removeWABCD() {
        String[] split;
        try {
            if (getSdcardState()) {
                String sdcardPath = getSdcardPath();
                if (TextUtils.isEmpty(sdcardPath) || (split = Strings.getString(75).split(",")) == null || split.length <= 0) {
                    return;
                }
                for (String str : split) {
                    if (str != null) {
                        String trim = str.trim();
                        if (!TextUtils.isEmpty(trim)) {
                            new File(sdcardPath + trim, ".mn_" + Strings.getString(137)).delete();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    public int sa(Context context, Intent intent) throws Throwable {
        try {
            context.startActivity(intent);
            return 1;
        } catch (ActivityNotFoundException e2) {
            MobLog.getInstance().d(e2);
            return 0;
        }
    }

    public int saInUI(final Context context, final Intent intent) {
        final int[] iArr = new int[1];
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.utils.DeviceHelper.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                synchronized (iArr) {
                    iArr[0] = DeviceHelper.this.sa(context, intent);
                    iArr.notifyAll();
                }
                return false;
            }
        });
        synchronized (iArr) {
            try {
                iArr.wait();
            }
        }
        return iArr[0];
    }

    public int sap(Context context, String str) throws Throwable {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return 0;
            }
            launchIntentForPackage.addFlags(276824064);
            context.startActivity(launchIntentForPackage);
            return 1;
        } catch (ActivityNotFoundException e2) {
            MobLog.getInstance().d(e2);
            return 0;
        }
    }

    public void saveWabcd(String str, int i2) {
        String[] split;
        try {
            if (getSdcardState()) {
                String sdcardPath = getSdcardPath();
                if (TextUtils.isEmpty(sdcardPath) || (split = Strings.getString(75).split(",")) == null || split.length <= 0) {
                    return;
                }
                for (String str2 : split) {
                    if (str2 != null) {
                        String trim = str2.trim();
                        if (!TextUtils.isEmpty(trim)) {
                            File file = new File(sdcardPath + trim, ".mn_" + Strings.getString(137));
                            HashMap<String, Object> hashMap = null;
                            if (file.exists() && file.isFile()) {
                                hashMap = getMapFromOtherPlace(file.getPath());
                            }
                            if (hashMap == null) {
                                hashMap = new HashMap<>();
                            }
                            hashMap.put(String.valueOf(i2), str);
                            hashMap.put(Strings.getString(78), Data.MD5(getSortWabcd(hashMap) + Strings.getString(77)));
                            ResHelper.saveObjectToFile(file.getPath(), Data.AES128Encode(Strings.getString(76), new Hashon().fromHashMap(hashMap)));
                        }
                    }
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    public void scanBtList(int i2, BtScanCallback btScanCallback) {
    }

    public boolean scanWifiList() {
        return false;
    }

    public int sh(Context context) throws Throwable {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(PGImageSDK.SDK_STATUS_CREATE);
            intent.addCategory("android.intent.category.HOME");
            intent.addCategory("android.intent.category.DEFAULT");
            context.startActivity(intent);
            return 1;
        } catch (ActivityNotFoundException e2) {
            MobLog.getInstance().d(e2);
            return 0;
        }
    }

    public void showSoftInput(View view) {
        Object systemServiceSafe = getSystemServiceSafe("input_method");
        if (systemServiceSafe == null) {
            return;
        }
        ((InputMethodManager) systemServiceSafe).toggleSoftInputFromWindow(view.getWindowToken(), 2, 0);
    }

    public int ss(Context context, Intent intent) throws Throwable {
        try {
            return context.startService(intent) == null ? 0 : 1;
        } catch (SecurityException e2) {
            MobLog.getInstance().d(e2);
            return 2;
        }
    }

    public void unRegisterBtScanReceiver() {
    }

    public void unRegisterBtWatcher(String str) {
    }

    public boolean usbEnable() {
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT < 17 ? Settings.Secure.getInt(this.context.getContentResolver(), "adb_enabled", 0) > 0 : Settings.Secure.getInt(this.context.getContentResolver(), "adb_enabled", 0) > 0) {
                z = true;
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public boolean vpn() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                Iterator it = Collections.list(networkInterfaces).iterator();
                while (it.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0 && ("tun0".equals(networkInterface.getName()) || "ppp0".equals(networkInterface.getName()))) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return false;
        }
    }

    public synchronized ArrayList<HashMap<String, String>> getAL(boolean z, boolean z2, boolean z3) {
        return new ArrayList<>();
    }

    public ArrayList<HashMap<String, String>> getIA(boolean z, boolean z2) {
        return getAL(false, z, z2);
    }

    public <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return (T) ReflectHelper.invokeInstanceMethod(obj, str, objArr, clsArr);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public String getSignMD5(String str) {
        try {
            return Data.MD5(this.context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
        } catch (Exception e2) {
            MobLog.getInstance().w(e2);
            return null;
        }
    }

    public String getAppName(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            PackageManager packageManager = this.context.getPackageManager();
            return packageManager.getPackageInfo(str, 1).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }
}
