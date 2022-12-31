package com.tencent.matrix.trace.util;

import android.os.Looper;
import com.tencent.matrix.util.DeviceUtil;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class Utils {
    public static String calculateCpuUsage(long j2, long j3) {
        if (j2 <= 0) {
            return j3 > 1000 ? "0%" : "100%";
        } else if (j2 >= j3) {
            return "100%";
        } else {
            return String.format("%.2f", Float.valueOf(((((float) j2) * 1.0f) / ((float) j3)) * 100.0f)) + PercentLayoutHelper.PercentLayoutInfo.BASEMODE.PERCENT;
        }
    }

    public static String formatTime(long j2) {
        return new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new Date(j2));
    }

    public static String getMainThreadJavaStackTrace() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static int[] getProcessPriority(int i2) {
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        try {
            String[] split = DeviceUtil.getStringFromFile(String.format("/proc/%s/stat", Integer.valueOf(i2))).trim().split(" ");
            if (split.length >= 19) {
                i3 = Integer.parseInt(split[17].trim());
                i4 = Integer.parseInt(split[18].trim());
            }
            return new int[]{i3, i4};
        } catch (Exception unused) {
            return new int[]{i3, Integer.MAX_VALUE};
        }
    }

    public static String getStack() {
        return getStack(new Throwable().getStackTrace());
    }

    public static String getWholeStack(StackTraceElement[] stackTraceElementArr, String str) {
        if (stackTraceElementArr == null || stackTraceElementArr.length < 3) {
            return "";
        }
        StringBuilder sb = new StringBuilder(" \n");
        for (int i2 = 0; i2 < stackTraceElementArr.length; i2++) {
            sb.append(str);
            sb.append("at ");
            sb.append(stackTraceElementArr[i2].getClassName());
            sb.append(":");
            sb.append(stackTraceElementArr[i2].getMethodName());
            sb.append("(" + stackTraceElementArr[i2].getLineNumber() + ")");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    public static String getStack(StackTraceElement[] stackTraceElementArr) {
        return getStack(stackTraceElementArr, "", -1);
    }

    public static String getStack(StackTraceElement[] stackTraceElementArr, String str, int i2) {
        if (stackTraceElementArr == null || stackTraceElementArr.length < 3) {
            return "";
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        StringBuilder sb = new StringBuilder(" \n");
        for (int i3 = 3; i3 < stackTraceElementArr.length - 3 && i3 < i2; i3++) {
            sb.append(str);
            sb.append("at ");
            sb.append(stackTraceElementArr[i3].getClassName());
            sb.append(":");
            sb.append(stackTraceElementArr[i3].getMethodName());
            sb.append("(" + stackTraceElementArr[i3].getLineNumber() + ")");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String getWholeStack(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
