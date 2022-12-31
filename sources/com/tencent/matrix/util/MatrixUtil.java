package com.tencent.matrix.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public final class MatrixUtil {
    private static final String TAG = "Matrix.MatrixUtil";
    private static String processName;
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final ThreadLocal<MessageDigest> MD5_DIGEST = new a();
    private static final ThreadLocal<MessageDigest> SHA256_DIGEST = new b();

    /* loaded from: classes3.dex */
    static class a extends ThreadLocal<MessageDigest> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(Constants.MD5);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException("Initialize MD5 failed.", e2);
            }
        }
    }

    /* loaded from: classes3.dex */
    static class b extends ThreadLocal<MessageDigest> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(Constants.SHA256);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException("Initialize SHA256-DIGEST failed.", e2);
            }
        }
    }

    private MatrixUtil() {
    }

    private static void appendHexPair(byte b2, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c = cArr[(b2 & 240) >> 4];
        char c2 = cArr[b2 & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    private static String bufferToHex(byte[] bArr) {
        return bufferToHex(bArr, 0, bArr.length);
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                Log.w(TAG, "Failed to close resource", e2);
            }
        }
    }

    public static String convertStreamToString(InputStream inputStream) throws IOException {
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

    public static String formatTime(String str, long j2) {
        return new SimpleDateFormat(str).format(new Date(j2));
    }

    public static String getLatestStack(String str, int i2) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String[] split = str.split("\n");
        if (split.length <= i2) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(split[i3]);
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    public static String getMD5String(String str) {
        return getMD5String(str.getBytes());
    }

    public static String getProcessName(Context context) {
        String str = processName;
        if (str != null) {
            return str;
        }
        String processNameInternal = getProcessNameInternal(context);
        processName = processNameInternal;
        return processNameInternal;
    }

    private static String getProcessNameInternal(Context context) {
        FileInputStream fileInputStream;
        int read;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        FileInputStream fileInputStream2 = null;
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            try {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    runningAppProcessInfo = it.next();
                    if (runningAppProcessInfo.pid == myPid) {
                        break;
                    }
                }
            } catch (Exception e2) {
                Log.e(TAG, "getProcessNameInternal exception:" + e2.getMessage());
            }
            runningAppProcessInfo = null;
            if (runningAppProcessInfo != null) {
                return runningAppProcessInfo.processName;
            }
        }
        byte[] bArr = new byte[128];
        try {
            try {
                try {
                    fileInputStream = new FileInputStream("/proc/" + myPid + "/cmdline");
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e4) {
            Log.e(TAG, e4.getMessage());
        }
        try {
            read = fileInputStream.read(bArr);
        } catch (Exception e5) {
            e = e5;
            fileInputStream2 = fileInputStream;
            Log.e(TAG, "getProcessNameInternal exception:" + e.getMessage());
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e6) {
                    Log.e(TAG, e6.getMessage());
                }
            }
            throw th;
        }
        if (read > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= read) {
                    break;
                } else if (bArr[i2] <= 0) {
                    read = i2;
                    break;
                } else {
                    i2++;
                }
            }
            String str = new String(bArr, 0, read, Charset.forName("UTF-8"));
            try {
                fileInputStream.close();
            } catch (Exception e7) {
                Log.e(TAG, e7.getMessage());
            }
            return str;
        }
        fileInputStream.close();
        return "";
    }

    private static byte[] getSHA(String str) throws NoSuchAlgorithmException {
        return SHA256_DIGEST.get().digest(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String getSHA256String(String str) throws NoSuchAlgorithmException {
        return toHexString(getSHA(str));
    }

    public static String getStringFromFile(String str) throws IOException {
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

    public static boolean isInMainProcess(Context context) {
        String packageName = context.getPackageName();
        String processName2 = getProcessName(context);
        return packageName.equals((processName2 == null || processName2.length() == 0) ? "" : "");
    }

    public static boolean isInMainThread(long j2) {
        return Looper.getMainLooper().getThread().getId() == j2;
    }

    public static long parseLong(String str, long j2) {
        if (str != null) {
            try {
                return str.length() <= 0 ? j2 : Long.decode(str).longValue();
            } catch (NumberFormatException e2) {
                MatrixLog.w(TAG, "parseLong error: " + e2.getMessage(), new Object[0]);
                return j2;
            }
        }
        return j2;
    }

    public static String printException(Exception exc) {
        StackTraceElement[] stackTrace = exc.getStackTrace();
        if (stackTrace == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(exc.toString());
        for (int i2 = 2; i2 < stackTrace.length; i2++) {
            sb.append('[');
            sb.append(stackTrace[i2].getClassName());
            sb.append(':');
            sb.append(stackTrace[i2].getMethodName());
            sb.append("(" + stackTrace[i2].getLineNumber() + ")]");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void printFileByLine(String str, String str2) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(str2)), "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        MatrixLog.i(str, readLine, new Object[0]);
                    } else {
                        bufferedReader2.close();
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        MatrixLog.e(str, "printFileByLine failed e : " + th.getMessage(), new Object[0]);
                        if (bufferedReader != null) {
                            return;
                        }
                        return;
                    } finally {
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(new BigInteger(1, bArr).toString(16));
        while (sb.length() < 32) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    private static String bufferToHex(byte[] bArr, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer(i3 * 2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            appendHexPair(bArr[i2], stringBuffer);
            i2++;
        }
        return stringBuffer.toString();
    }

    public static String getMD5String(byte[] bArr) {
        return bufferToHex(MD5_DIGEST.get().digest(bArr));
    }
}
