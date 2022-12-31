package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import com.tapjoy.TapjoyConstants;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public class b {
    private static final String[] a = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};
    private static final String[] b = {"com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};
    private static final String[] c = {"/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/qemud", "/dev/qemu_pipe", "/dev/socket/baseband_genyd", "/dev/socket/genyd"};

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (x.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String b(Context context) {
        Log.e("b", "com/tencent/bugly/crashreport/common/info/b->b:  is returned");
        return "";
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (x.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static long d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long f() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e2) {
                            if (!x.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                            return -1L;
                        } catch (IOException e3) {
                            if (x.a(e3)) {
                                return -1L;
                            }
                            e3.printStackTrace();
                            return -1L;
                        }
                    }
                    long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                        if (!x.a(e4)) {
                            e4.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e5) {
                        if (!x.a(e5)) {
                            e5.printStackTrace();
                        }
                    }
                    return parseLong;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                                if (!x.a(e6)) {
                                    e6.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                                return -2L;
                            } catch (IOException e7) {
                                if (x.a(e7)) {
                                    return -2L;
                                }
                                e7.printStackTrace();
                                return -2L;
                            }
                        }
                        return -2L;
                    } catch (Throwable th3) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e8) {
                                if (!x.a(e8)) {
                                    e8.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e9) {
                                if (!x.a(e9)) {
                                    e9.printStackTrace();
                                }
                            }
                        }
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            fileReader = null;
            th = th5;
            bufferedReader = null;
        }
    }

    public static long g() {
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader2.readLine();
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e2) {
                            if (!x.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e3) {
                            if (!x.a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10) + 0;
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            if (!x.a(e4)) {
                                e4.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e5) {
                            if (!x.a(e5)) {
                                e5.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong2 = parseLong + (Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                    String readLine3 = bufferedReader2.readLine();
                    if (readLine3 == null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e6) {
                            if (!x.a(e6)) {
                                e6.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e7) {
                            if (!x.a(e7)) {
                                e7.printStackTrace();
                            }
                        }
                        return -1L;
                    }
                    long parseLong3 = parseLong2 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
                    try {
                        bufferedReader2.close();
                    } catch (IOException e8) {
                        if (!x.a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (IOException e9) {
                        if (!x.a(e9)) {
                            e9.printStackTrace();
                        }
                    }
                    return parseLong3;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        if (!x.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                if (!x.a(e10)) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                                return -2L;
                            } catch (IOException e11) {
                                if (x.a(e11)) {
                                    return -2L;
                                }
                                e11.printStackTrace();
                                return -2L;
                            }
                        }
                        return -2L;
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e12) {
                                if (!x.a(e12)) {
                                    e12.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException e13) {
                                if (!x.a(e13)) {
                                    e13.printStackTrace();
                                }
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
        }
    }

    public static long h() {
        if (n()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (x.a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    public static long i() {
        if (n()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (x.a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    public static String j() {
        return "";
    }

    public static String k() {
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static boolean l() {
        boolean z;
        String[] strArr = a;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (new File(strArr[i2]).exists()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }

    public static boolean m() {
        float maxMemory = (float) (Runtime.getRuntime().maxMemory() / 1048576.0d);
        float f2 = (float) (Runtime.getRuntime().totalMemory() / 1048576.0d);
        float f3 = maxMemory - f2;
        x.c("maxMemory : %f", Float.valueOf(maxMemory));
        x.c("totalMemory : %f", Float.valueOf(f2));
        x.c("freeMemory : %f", Float.valueOf(f3));
        return f3 < 10.0f;
    }

    private static boolean n() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (x.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    private static int o() {
        try {
            Method method = Class.forName("android.app.ActivityManagerNative").getMethod("getDefault", new Class[0]);
            method.setAccessible(true);
            return method.invoke(null, new Object[0]).getClass().getName().startsWith("$Proxy") ? 256 : 0;
        } catch (Exception unused) {
            return 256;
        }
    }

    private static int p() {
        StackTraceElement[] stackTrace;
        try {
            throw new Exception("detect hook");
        } catch (Exception e2) {
            int i2 = 0;
            int i3 = 0;
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("main")) {
                    i2 |= 4;
                }
                if (stackTraceElement.getClassName().equals("de.robv.android.xposed.XposedBridge") && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    i2 |= 8;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    i2 |= 16;
                }
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i3 = i3 + 1) == 2) {
                    i2 |= 32;
                }
            }
            return i2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b7: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:51:0x00b7 */
    private static int q() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        IOException e2;
        UnsupportedEncodingException e3;
        FileNotFoundException e4;
        int i2 = 0;
        BufferedReader bufferedReader3 = null;
        try {
        } catch (Throwable th) {
            th = th;
            bufferedReader3 = bufferedReader;
        }
        try {
            try {
                HashSet hashSet = new HashSet();
                bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/maps"), "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                            hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                        }
                    } catch (FileNotFoundException e5) {
                        e4 = e5;
                        e4.printStackTrace();
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return i2;
                    } catch (UnsupportedEncodingException e6) {
                        e3 = e6;
                        e3.printStackTrace();
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return i2;
                    } catch (IOException e7) {
                        e2 = e7;
                        e2.printStackTrace();
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        return i2;
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (((String) next).toLowerCase().contains("xposed")) {
                        i2 |= 64;
                    }
                    if (((String) next).contains("com.saurik.substrate")) {
                        i2 |= 128;
                    }
                }
                bufferedReader2.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        } catch (FileNotFoundException e9) {
            bufferedReader2 = null;
            e4 = e9;
        } catch (UnsupportedEncodingException e10) {
            bufferedReader2 = null;
            e3 = e10;
        } catch (IOException e11) {
            bufferedReader2 = null;
            e2 = e11;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            throw th;
        }
        return i2;
    }

    public static String a(Context context) {
        String str = "fail";
        if (context == null) {
            return "fail";
        }
        try {
            str = Settings.Secure.getString(context.getContentResolver(), TapjoyConstants.TJC_ANDROID_ID);
            return str == null ? "null" : str.toLowerCase();
        } catch (Throwable th) {
            if (!x.a(th)) {
                x.a("Failed to get Android ID.", new Object[0]);
            }
            return str;
        }
    }

    public static String c(Context context) {
        String a2 = z.a(context, "ro.miui.ui.version.name");
        if (!z.a(a2) && !a2.equals("fail")) {
            return "XiaoMi/MIUI/" + a2;
        }
        String a3 = z.a(context, "ro.build.version.emui");
        if (!z.a(a3) && !a3.equals("fail")) {
            return "HuaWei/EMOTION/" + a3;
        }
        String a4 = z.a(context, "ro.lenovo.series");
        if (!z.a(a4) && !a4.equals("fail")) {
            String a5 = z.a(context, "ro.build.version.incremental");
            return "Lenovo/VIBE/" + a5;
        }
        String a6 = z.a(context, "ro.build.nubia.rom.name");
        if (!z.a(a6) && !a6.equals("fail")) {
            return "Zte/NUBIA/" + a6 + "_" + z.a(context, "ro.build.nubia.rom.code");
        }
        String a7 = z.a(context, "ro.meizu.product.model");
        if (!z.a(a7) && !a7.equals("fail")) {
            return "Meizu/FLYME/" + z.a(context, "ro.build.display.id");
        }
        String a8 = z.a(context, "ro.build.version.opporom");
        if (!z.a(a8) && !a8.equals("fail")) {
            return "Oppo/COLOROS/" + a8;
        }
        String a9 = z.a(context, "ro.vivo.os.build.display.id");
        if (!z.a(a9) && !a9.equals("fail")) {
            return "vivo/FUNTOUCH/" + a9;
        }
        String a10 = z.a(context, "ro.aa.romver");
        if (!z.a(a10) && !a10.equals("fail")) {
            return "htc/" + a10 + "/" + z.a(context, "ro.build.description");
        }
        String a11 = z.a(context, "ro.lewa.version");
        if (!z.a(a11) && !a11.equals("fail")) {
            return "tcl/" + a11 + "/" + z.a(context, "ro.build.display.id");
        }
        String a12 = z.a(context, "ro.gn.gnromvernumber");
        if (!z.a(a12) && !a12.equals("fail")) {
            return "amigo/" + a12 + "/" + z.a(context, "ro.build.display.id");
        }
        String a13 = z.a(context, "ro.build.tyd.kbstyle_version");
        if (!z.a(a13) && !a13.equals("fail")) {
            return "dido/" + a13;
        }
        return z.a(context, "ro.build.fingerprint") + "/" + z.a(context, "ro.build.rom.id");
    }

    public static String d(Context context) {
        return z.a(context, "ro.board.platform");
    }

    public static boolean e(Context context) {
        int i2;
        if (g(context) == null) {
            ArrayList arrayList = new ArrayList();
            while (true) {
                String[] strArr = c;
                if (i2 >= strArr.length) {
                    break;
                } else if (i2 == 0) {
                    i2 = new File(strArr[i2]).exists() ? i2 + 1 : 0;
                    arrayList.add(Integer.valueOf(i2));
                } else {
                    if (!new File(strArr[i2]).exists()) {
                    }
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            return (arrayList.isEmpty() ? null : arrayList.toString()) != null;
        }
        return true;
    }

    private static int h(Context context) {
        int i2;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getInstallerPackageName("de.robv.android.xposed.installer");
            i2 = 1;
        } catch (Exception unused) {
            i2 = 0;
        }
        try {
            packageManager.getInstallerPackageName("com.saurik.substrate");
            return i2 | 2;
        } catch (Exception unused2) {
            return i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        r0 = java.lang.System.getProperty("os.arch");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r4, boolean r5) {
        /*
            r0 = 0
            java.lang.String r1 = "fail"
            if (r5 == 0) goto L4b
            java.lang.String r5 = "ro.product.cpu.abilist"
            java.lang.String r5 = com.tencent.bugly.proguard.z.a(r4, r5)     // Catch: java.lang.Throwable -> L49
            boolean r2 = com.tencent.bugly.proguard.z.a(r5)     // Catch: java.lang.Throwable -> L49
            if (r2 != 0) goto L17
            boolean r2 = r5.equals(r1)     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L1d
        L17:
            java.lang.String r5 = "ro.product.cpu.abi"
            java.lang.String r5 = com.tencent.bugly.proguard.z.a(r4, r5)     // Catch: java.lang.Throwable -> L49
        L1d:
            boolean r4 = com.tencent.bugly.proguard.z.a(r5)     // Catch: java.lang.Throwable -> L49
            if (r4 != 0) goto L4b
            boolean r4 = r5.equals(r1)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L2a
            goto L4b
        L2a:
            java.lang.Class<com.tencent.bugly.crashreport.common.info.b> r4 = com.tencent.bugly.crashreport.common.info.b.class
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = "ABI list: "
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L49
            r0.append(r5)     // Catch: java.lang.Throwable -> L49
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L49
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L49
            com.tencent.bugly.proguard.x.b(r4, r0, r3)     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = ","
            java.lang.String[] r4 = r5.split(r4)     // Catch: java.lang.Throwable -> L49
            r0 = r4[r2]     // Catch: java.lang.Throwable -> L49
            goto L4b
        L49:
            r4 = move-exception
            goto L60
        L4b:
            if (r0 != 0) goto L53
            java.lang.String r4 = "os.arch"
            java.lang.String r0 = java.lang.System.getProperty(r4)     // Catch: java.lang.Throwable -> L49
        L53:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r4.<init>()     // Catch: java.lang.Throwable -> L49
            r4.append(r0)     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L49
            return r4
        L60:
            boolean r5 = com.tencent.bugly.proguard.x.a(r4)
            if (r5 != 0) goto L69
            r4.printStackTrace()
        L69:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.a(android.content.Context, boolean):java.lang.String");
    }

    public static boolean f(Context context) {
        return (((h(context) | p()) | q()) | o()) > 0;
    }

    private static String g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String[] strArr = b;
            if (i2 >= strArr.length) {
                break;
            }
            try {
                packageManager.getPackageInfo(strArr[i2], 1);
                arrayList.add(Integer.valueOf(i2));
            } catch (PackageManager.NameNotFoundException unused) {
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.toString();
    }
}
