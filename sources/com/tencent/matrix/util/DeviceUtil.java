package com.tencent.matrix.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import androidx.core.location.LocationRequestCompat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes3.dex */
public class DeviceUtil {
    private static final String CPU_FILE_PATH_0 = "/sys/devices/system/cpu/";
    private static final String CPU_FILE_PATH_1 = "/sys/devices/system/cpu/possible";
    private static final String CPU_FILE_PATH_2 = "/sys/devices/system/cpu/present";
    private static final FileFilter CPU_FILTER = new a();
    private static final String DEVICE_CPU = "cpu_app";
    public static final String DEVICE_MACHINE = "machine";
    private static final String DEVICE_MEMORY = "mem";
    private static final String DEVICE_MEMORY_FREE = "mem_free";
    private static final int INVALID = 0;
    private static final long MB = 1048576;
    private static final String MEMORY_FILE_PATH = "/proc/meminfo";
    private static final String TAG = "Matrix.DeviceUtil";
    private static LEVEL sLevelCache;
    private static long sLowMemoryThresold;
    private static int sMemoryClass;
    private static long sTotalMemory;

    /* loaded from: classes3.dex */
    public enum LEVEL {
        BEST(5),
        HIGH(4),
        MIDDLE(3),
        LOW(2),
        BAD(1),
        UN_KNOW(-1);
        
        int value;

        LEVEL(int i2) {
            this.value = i2;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes3.dex */
    static class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    public static String convertStreamToString(InputStream inputStream) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        bufferedReader2.close();
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static double getAppCpuRate() {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.util.DeviceUtil.getAppCpuRate():double");
    }

    private static int getAppId() {
        return Process.myPid();
    }

    public static Debug.MemoryInfo getAppMemory(Context context) {
        try {
            Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{getAppId()});
            if (processMemoryInfo.length > 0) {
                return processMemoryInfo[0];
            }
            return null;
        } catch (Exception e2) {
            MatrixLog.i(TAG, "getProcessMemoryInfo fail, error: %s", e2.toString());
            return null;
        }
    }

    public static long getAvailMemory(Context context) {
        return Runtime.getRuntime().freeMemory() / 1024;
    }

    private static int getCoresFromCPUFiles(String str) {
        File[] listFiles = new File(str).listFiles(CPU_FILTER);
        if (listFiles == null) {
            return 0;
        }
        return listFiles.length;
    }

    private static int getCoresFromFile(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            if (readLine != null && readLine.matches("0-[\\d]+$")) {
                int parseInt = Integer.parseInt(readLine.substring(2)) + 1;
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    MatrixLog.i(TAG, "[getCoresFromFile] error! %s", e3.toString());
                }
                return parseInt;
            }
            try {
                fileInputStream.close();
            } catch (IOException e4) {
                MatrixLog.i(TAG, "[getCoresFromFile] error! %s", e4.toString());
            }
            return 0;
        } catch (IOException e5) {
            e = e5;
            fileInputStream2 = fileInputStream;
            MatrixLog.i(TAG, "[getCoresFromFile] error! %s", e.toString());
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e6) {
                    MatrixLog.i(TAG, "[getCoresFromFile] error! %s", e6.toString());
                }
            }
            return 0;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e7) {
                    MatrixLog.i(TAG, "[getCoresFromFile] error! %s", e7.toString());
                }
            }
            throw th;
        }
    }

    public static long getDalvikHeap() {
        Runtime runtime = Runtime.getRuntime();
        return (runtime.totalMemory() - runtime.freeMemory()) / 1024;
    }

    public static JSONObject getDeviceInfo(JSONObject jSONObject, Application application) {
        try {
            jSONObject.put(DEVICE_MACHINE, getLevel(application));
            jSONObject.put(DEVICE_CPU, getAppCpuRate());
            jSONObject.put(DEVICE_MEMORY, getTotalMemory(application));
            jSONObject.put(DEVICE_MEMORY_FREE, getMemFree(application));
        } catch (JSONException e2) {
            MatrixLog.e(TAG, "[JSONException for stack, error: %s", e2);
        }
        return jSONObject;
    }

    public static LEVEL getLevel(Context context) {
        LEVEL level = sLevelCache;
        if (level != null) {
            return level;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long totalMemory = getTotalMemory(context);
        int numOfCores = getNumOfCores();
        MatrixLog.i(TAG, "[getLevel] totalMemory:%s coresNum:%s", Long.valueOf(totalMemory), Integer.valueOf(numOfCores));
        if (totalMemory >= IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) {
            sLevelCache = LEVEL.BEST;
        } else if (totalMemory >= 6442450944L) {
            sLevelCache = LEVEL.HIGH;
        } else if (totalMemory >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            sLevelCache = LEVEL.MIDDLE;
        } else if (totalMemory >= IjkMediaMeta.AV_CH_WIDE_LEFT) {
            if (numOfCores >= 4) {
                sLevelCache = LEVEL.MIDDLE;
            } else if (numOfCores > 0) {
                sLevelCache = LEVEL.LOW;
            }
        } else if (totalMemory >= 0) {
            sLevelCache = LEVEL.BAD;
        } else {
            sLevelCache = LEVEL.UN_KNOW;
        }
        MatrixLog.i(TAG, "getLevel, cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", level:" + sLevelCache, new Object[0]);
        return sLevelCache;
    }

    public static long getLowMemoryThresold(Context context) {
        long j2 = sLowMemoryThresold;
        if (0 != j2) {
            return j2;
        }
        getTotalMemory(context);
        return sLowMemoryThresold;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long getMemFree(android.content.Context r13) {
        /*
            java.lang.String r0 = "close reader %s"
            java.lang.String r1 = "Matrix.DeviceUtil"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 1024(0x400, double:5.06E-321)
            r5 = 16
            if (r2 < r5) goto L20
            android.app.ActivityManager$MemoryInfo r0 = new android.app.ActivityManager$MemoryInfo
            r0.<init>()
            java.lang.String r1 = "activity"
            java.lang.Object r13 = r13.getSystemService(r1)
            android.app.ActivityManager r13 = (android.app.ActivityManager) r13
            r13.getMemoryInfo(r0)
            long r0 = r0.availMem
            long r0 = r0 / r3
            return r0
        L20:
            r5 = 0
            r13 = 0
            r2 = 0
            r7 = 1
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L74
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L74
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L74
            java.lang.String r11 = "/proc/meminfo"
            r10.<init>(r11)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L74
            java.lang.String r11 = "UTF-8"
            r9.<init>(r10, r11)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L74
            r8.<init>(r9)     // Catch: java.lang.Throwable -> L70 java.lang.Exception -> L74
            java.lang.String r13 = r8.readLine()     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L99
        L3c:
            if (r13 == 0) goto L5d
            java.lang.String r9 = "\\s+"
            java.lang.String[] r13 = r13.split(r9)     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L99
            java.lang.String r9 = "MemAvailable:"
            r10 = r13[r2]     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L99
            boolean r9 = r9.equals(r10)     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L99
            if (r9 == 0) goto L58
            r13 = r13[r7]     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L99
            int r13 = java.lang.Integer.parseInt(r13)     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L99
            long r5 = (long) r13     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L99
            long r5 = r5 * r3
            goto L5d
        L58:
            java.lang.String r13 = r8.readLine()     // Catch: java.lang.Exception -> L6e java.lang.Throwable -> L99
            goto L3c
        L5d:
            r8.close()     // Catch: java.lang.Exception -> L61
            goto L97
        L61:
            r13 = move-exception
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r13 = r13.toString()
            r7[r2] = r13
            com.tencent.matrix.util.MatrixLog.i(r1, r0, r7)
            goto L97
        L6e:
            r13 = move-exception
            goto L78
        L70:
            r3 = move-exception
            r8 = r13
            r13 = r3
            goto L9a
        L74:
            r8 = move-exception
            r12 = r8
            r8 = r13
            r13 = r12
        L78:
            java.lang.String r9 = "[getAvailMemory] error! %s"
            java.lang.Object[] r10 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L99
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L99
            r10[r2] = r13     // Catch: java.lang.Throwable -> L99
            com.tencent.matrix.util.MatrixLog.i(r1, r9, r10)     // Catch: java.lang.Throwable -> L99
            if (r8 == 0) goto L97
            r8.close()     // Catch: java.lang.Exception -> L8b
            goto L97
        L8b:
            r13 = move-exception
            java.lang.Object[] r7 = new java.lang.Object[r7]
            java.lang.String r13 = r13.toString()
            r7[r2] = r13
            com.tencent.matrix.util.MatrixLog.i(r1, r0, r7)
        L97:
            long r5 = r5 / r3
            return r5
        L99:
            r13 = move-exception
        L9a:
            if (r8 == 0) goto Lac
            r8.close()     // Catch: java.lang.Exception -> La0
            goto Lac
        La0:
            r3 = move-exception
            java.lang.Object[] r4 = new java.lang.Object[r7]
            java.lang.String r3 = r3.toString()
            r4[r2] = r3
            com.tencent.matrix.util.MatrixLog.i(r1, r0, r4)
        Lac:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.util.DeviceUtil.getMemFree(android.content.Context):long");
    }

    public static int getMemoryClass(Context context) {
        int i2 = sMemoryClass;
        if (i2 != 0) {
            return i2 * 1024;
        }
        getTotalMemory(context);
        return sMemoryClass * 1024;
    }

    public static long getNativeHeap() {
        return Debug.getNativeHeapAllocatedSize() / 1024;
    }

    private static int getNumOfCores() {
        int i2;
        if (Build.VERSION.SDK_INT <= 10) {
            return 1;
        }
        try {
            i2 = getCoresFromFile(CPU_FILE_PATH_1);
            if (i2 == 0) {
                i2 = getCoresFromFile(CPU_FILE_PATH_2);
            }
            if (i2 == 0) {
                i2 = getCoresFromCPUFiles(CPU_FILE_PATH_0);
            }
        } catch (Exception unused) {
            i2 = 0;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public static String getStringFromFile(String str) throws Exception {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                String convertStreamToString = convertStreamToString(fileInputStream);
                fileInputStream.close();
                return convertStreamToString;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static long getTotalMemory(Context context) {
        long j2 = sTotalMemory;
        if (0 != j2) {
            return j2;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            activityManager.getMemoryInfo(memoryInfo);
            sTotalMemory = memoryInfo.totalMem;
            sLowMemoryThresold = memoryInfo.threshold;
            long maxMemory = Runtime.getRuntime().maxMemory();
            if (maxMemory == LocationRequestCompat.PASSIVE_INTERVAL) {
                sMemoryClass = activityManager.getMemoryClass();
            } else {
                sMemoryClass = (int) (maxMemory / 1048576);
            }
            MatrixLog.i(TAG, "getTotalMemory cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", total_mem:" + sTotalMemory + ", LowMemoryThresold:" + sLowMemoryThresold + ", Memory Class:" + sMemoryClass, new Object[0]);
            return sTotalMemory;
        }
        return 0L;
    }

    public static long getVmSize() {
        try {
            String[] split = getStringFromFile(String.format("/proc/%s/status", Integer.valueOf(getAppId()))).trim().split("\n");
            for (String str : split) {
                if (str.startsWith("VmSize")) {
                    Matcher matcher = Pattern.compile("\\d+").matcher(str);
                    if (matcher.find()) {
                        return Long.parseLong(matcher.group());
                    }
                }
            }
            if (split.length > 12) {
                Matcher matcher2 = Pattern.compile("\\d+").matcher(split[12]);
                if (matcher2.find()) {
                    return Long.parseLong(matcher2.group());
                }
            }
        } catch (Exception unused) {
        }
        return -1L;
    }

    public static boolean is64BitRuntime() {
        String str = Build.CPU_ABI;
        return "arm64-v8a".equalsIgnoreCase(str) || "x86_64".equalsIgnoreCase(str) || "mips64".equalsIgnoreCase(str);
    }

    public static boolean isLowMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }
}
