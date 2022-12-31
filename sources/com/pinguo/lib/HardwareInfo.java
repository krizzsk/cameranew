package com.pinguo.lib;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.util.Locale;
import us.pinguo.util.r;
/* loaded from: classes3.dex */
public class HardwareInfo {
    public static final int LEVEL_HIGH = 5;
    public static final int LEVEL_LOW = 1;
    public static final int LEVEL_MIDDEL = 3;
    public static final int LEVEL_MIDDEL_HIGH = 4;
    public static final int LEVEL_MIDDLE_LOW = 2;
    private static HardwareInfo instance = new HardwareInfo();
    private final boolean mIsAarch64;
    private volatile String mMTName;
    private final float mPixelDensity;
    private Integer mScore;
    private final r mScreenSize;
    private final SharedPreferences mSharedPreferences;
    private volatile Long mMemSize = null;
    private volatile Integer mCpuCount = null;
    private volatile Long mMaxCpuFreq = null;
    private volatile String mHardware = null;

    private HardwareInfo() {
        this.mMTName = null;
        this.mScore = null;
        Context context = AppContextProvider.context;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.mPixelDensity = displayMetrics.density;
        this.mScreenSize = new r(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.mIsAarch64 = isAarch64();
        this.mSharedPreferences = context.getSharedPreferences("hardware_info", 32768);
        this.mMTName = getMtName();
        this.mScore = Integer.valueOf(initHardwareScore());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(File file, String str) {
        return str.startsWith("cpu") && isNum(str.substring(3));
    }

    private void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static HardwareInfo get() {
        return instance;
    }

    private long getCpuFreq(int i2) {
        BufferedReader bufferedReader;
        long j2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Closeable closeable = null;
            try {
                bufferedReader = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu" + i4 + "/cpufreq/cpuinfo_max_freq"));
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                j2 += Long.parseLong(bufferedReader.readLine().trim()) / 1000;
                i3++;
                close(bufferedReader);
            } catch (Exception unused2) {
                closeable = bufferedReader;
                close(closeable);
            } catch (Throwable th2) {
                th = th2;
                closeable = bufferedReader;
                close(closeable);
                throw th;
            }
        }
        if (i3 == 0) {
            return 0L;
        }
        return j2 / i3;
    }

    private String getCpuHardware() {
        BufferedReader bufferedReader;
        Throwable th;
        int indexOf;
        Closeable closeable = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            String trim = readLine.trim();
                            if (!trim.isEmpty() && (indexOf = trim.indexOf(58)) != -1) {
                                String trim2 = trim.substring(0, indexOf).trim();
                                String trim3 = trim.substring(indexOf + 1).trim();
                                if ("Hardware".equals(trim2)) {
                                    close(bufferedReader);
                                    return trim3;
                                }
                            }
                        } else {
                            String str = Build.HARDWARE;
                            close(bufferedReader);
                            return str;
                        }
                    } catch (Exception unused) {
                        closeable = bufferedReader;
                        String str2 = Build.HARDWARE;
                        close(closeable);
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        close(bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Exception unused2) {
        }
    }

    private String getMtName() {
        String str = Build.HARDWARE;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (lowerCase.startsWith("mt") && lowerCase.length() >= 6 && isNum(lowerCase.substring(2, 6))) {
            return lowerCase.substring(0, 6);
        }
        return null;
    }

    public static int getNumberOfCPUCores() {
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            return new File("/sys/devices/system/cpu/").listFiles(a.a).length;
        } catch (Exception unused) {
            return 0;
        }
    }

    private synchronized void init() {
        boolean z = false;
        long j2 = this.mSharedPreferences.getLong("mem_size", -1L);
        boolean z2 = true;
        if (j2 == -1) {
            j2 = readMemSize();
            z = true;
        }
        this.mMemSize = Long.valueOf(j2);
        int i2 = this.mSharedPreferences.getInt("cpu_count", -1);
        if (i2 == -1) {
            i2 = getNumberOfCPUCores();
            z = true;
        }
        this.mCpuCount = Integer.valueOf(i2);
        long j3 = this.mSharedPreferences.getLong("cpu_freq", -1L);
        if (j3 == -1) {
            j3 = getCpuFreq(i2);
            z = true;
        }
        this.mMaxCpuFreq = Long.valueOf(j3);
        String string = this.mSharedPreferences.getString("hardware", null);
        if (string == null) {
            string = getCpuHardware();
        } else {
            z2 = z;
        }
        this.mHardware = string;
        if (z2) {
            SharedPreferences.Editor edit = this.mSharedPreferences.edit();
            edit.putLong("mem_size", j2);
            edit.putInt("cpu_count", i2);
            edit.putLong("cpu_freq", j3);
            edit.putString("hardware", string);
            edit.commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x019c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int initHardwareScore() {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pinguo.lib.HardwareInfo.initHardwareScore():int");
    }

    private boolean isAarch64() {
        String[] strArr;
        return us.pinguo.util.c.f12472f && (strArr = Build.SUPPORTED_64_BIT_ABIS) != null && strArr.length > 0;
    }

    private static boolean isNum(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    private long readMemSize() {
        BufferedReader bufferedReader;
        Throwable th;
        int indexOf;
        if (us.pinguo.util.c.c) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) AppContextProvider.context.getSystemService("activity");
            if (activityManager == null) {
                return 0L;
            }
            activityManager.getMemoryInfo(memoryInfo);
            return (memoryInfo.totalMem / 1000) / 1000;
        }
        Closeable closeable = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        close(bufferedReader);
                        return 0L;
                    }
                    String trim = readLine.trim();
                    if (!trim.isEmpty() && (indexOf = trim.indexOf(58)) != -1) {
                        String trim2 = trim.substring(0, indexOf).trim();
                        String trim3 = trim.substring(indexOf + 1).trim();
                        if ("MemTotal".equals(trim2)) {
                            long parseLong = ((Long.parseLong(trim3.split(" ")[0]) * 1024) / 1000) / 1000;
                            close(bufferedReader);
                            return parseLong;
                        }
                    }
                } catch (Exception unused) {
                    closeable = bufferedReader;
                    close(closeable);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    close(bufferedReader);
                    throw th;
                }
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public void cacheOfFirstLaunch() {
        init();
    }

    public Integer getCpuCount() {
        return this.mCpuCount;
    }

    public String getHardware() {
        return this.mHardware;
    }

    public String getInfoString() {
        return "MemSize:" + this.mMemSize + "\nCpuCount:" + this.mCpuCount + "\nMaxCpuFreq:" + this.mMaxCpuFreq + "\nHardware:" + this.mHardware + "\nMT Name:" + this.mMTName + "\nScreenSize:" + this.mScreenSize + "\nPixelDensity:" + this.mPixelDensity + "\nAarch64:" + this.mIsAarch64;
    }

    public synchronized int getLevel() {
        if (this.mScore.intValue() <= 1) {
            return 2;
        }
        if (this.mScore.intValue() <= 400) {
            return 1;
        }
        if (this.mScore.intValue() <= 1200) {
            return 2;
        }
        if (this.mScore.intValue() <= 2000) {
            return 3;
        }
        return this.mScore.intValue() <= 2400 ? 4 : 5;
    }

    public Long getMaxCpuFreq() {
        return this.mMaxCpuFreq;
    }

    public Long getMemSize() {
        return this.mMemSize;
    }

    public String getPixelDensity() {
        float f2 = this.mPixelDensity;
        return f2 < 0.9f ? "l" : f2 < 1.1f ? "m" : f2 < 1.7f ? PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H : f2 < 2.3f ? "xh" : f2 < 3.3f ? "xxh" : f2 < 4.3f ? "xxxh" : "xxxxh";
    }

    public synchronized int getScore() {
        return this.mScore.intValue();
    }

    public r getScreenSize() {
        return this.mScreenSize;
    }

    public boolean isMTK() {
        return !TextUtils.isEmpty(this.mMTName);
    }

    public boolean support2KPreview() {
        r rVar;
        return this.mIsAarch64 && this.mMemSize.longValue() > 2800 && (rVar = this.mScreenSize) != null && rVar.c() >= 1000 && getLevel() == 5;
    }
}
