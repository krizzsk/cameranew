package com.growingio.eventcenter;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.IntRange;
import com.tencent.connect.common.Constants;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class LogUtils {
    public static final int A = 7;
    private static final String ARGS = "args";
    private static final String BOTTOM_BORDER = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String BOTTOM_CORNER = "└";
    public static final int D = 3;
    public static final int E = 6;
    private static final int FILE = 16;
    public static final int I = 4;
    private static final int JSON = 32;
    private static final String LEFT_BORDER = "│ ";
    private static final int MAX_LEN = 3000;
    private static final String MIDDLE_BORDER = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String MIDDLE_CORNER = "├";
    private static final String MIDDLE_DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
    private static final String NOTHING = "log nothing";
    private static final String NULL = "null";
    private static final String PLACEHOLDER = " ";
    private static final String SIDE_DIVIDER = "────────────────────────────────────────────────────────";
    private static final String TOP_BORDER = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    private static final String TOP_CORNER = "┌";
    public static final int V = 2;
    public static final int W = 5;
    private static final int XML = 48;
    private static ExecutorService sExecutor;
    private static final char[] T = {'V', 'D', 'I', 'W', 'E', 'A'};
    private static final String LINE_SEP = System.getProperty("line.separator");
    @SuppressLint({"SimpleDateFormat"})
    private static final Format FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ");
    private static final Config CONFIG = new Config();

    /* loaded from: classes2.dex */
    public static class Config {
        private String mFilePrefix = "util";
        private boolean mLogSwitch = true;
        private boolean mLog2ConsoleSwitch = true;
        private String mGlobalTag = null;
        private boolean mTagIsSpace = true;
        private boolean mLogHeadSwitch = true;
        private boolean mLog2FileSwitch = false;
        private boolean mLogBorderSwitch = true;
        private boolean mSingleTagSwitch = true;
        private int mConsoleFilter = 2;
        private int mFileFilter = 2;
        private int mStackDeep = 1;
        private int mStackOffset = 0;

        public Config setBorderSwitch(boolean z) {
            this.mLogBorderSwitch = z;
            return this;
        }

        public Config setConsoleFilter(int i2) {
            this.mConsoleFilter = i2;
            return this;
        }

        public Config setConsoleSwitch(boolean z) {
            this.mLog2ConsoleSwitch = z;
            return this;
        }

        public Config setFileFilter(int i2) {
            this.mFileFilter = i2;
            return this;
        }

        public Config setFilePrefix(String str) {
            if (LogUtils.isSpace(str)) {
                this.mFilePrefix = "util";
            } else {
                this.mFilePrefix = str;
            }
            return this;
        }

        public Config setGlobalTag(String str) {
            if (LogUtils.isSpace(str)) {
                this.mGlobalTag = "";
                this.mTagIsSpace = true;
            } else {
                this.mGlobalTag = str;
                this.mTagIsSpace = false;
            }
            return this;
        }

        public Config setLog2FileSwitch(boolean z) {
            this.mLog2FileSwitch = z;
            return this;
        }

        public Config setLogHeadSwitch(boolean z) {
            this.mLogHeadSwitch = z;
            return this;
        }

        public Config setLogSwitch(boolean z) {
            this.mLogSwitch = z;
            return this;
        }

        public Config setSingleTagSwitch(boolean z) {
            this.mSingleTagSwitch = z;
            return this;
        }

        public Config setStackDeep(@IntRange(from = 1) int i2) {
            this.mStackDeep = i2;
            return this;
        }

        public Config setStackOffset(@IntRange(from = 0) int i2) {
            this.mStackOffset = i2;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("switch: ");
            sb.append(this.mLogSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("console: ");
            sb.append(this.mLog2ConsoleSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("tag: ");
            sb.append(this.mTagIsSpace ? LogUtils.NULL : this.mGlobalTag);
            sb.append(LogUtils.LINE_SEP);
            sb.append("head: ");
            sb.append(this.mLogHeadSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("file: ");
            sb.append(this.mLog2FileSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("filePrefix: ");
            sb.append(this.mFilePrefix);
            sb.append(LogUtils.LINE_SEP);
            sb.append("border: ");
            sb.append(this.mLogBorderSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("singleTag: ");
            sb.append(this.mSingleTagSwitch);
            sb.append(LogUtils.LINE_SEP);
            sb.append("consoleFilter: ");
            sb.append(LogUtils.T[this.mConsoleFilter - 2]);
            sb.append(LogUtils.LINE_SEP);
            sb.append("fileFilter: ");
            sb.append(LogUtils.T[this.mFileFilter - 2]);
            sb.append(LogUtils.LINE_SEP);
            sb.append("stackDeep: ");
            sb.append(this.mStackDeep);
            sb.append(LogUtils.LINE_SEP);
            sb.append("mStackOffset: ");
            sb.append(this.mStackOffset);
            return sb.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface TYPE {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class TagHead {
        String[] consoleHead;
        String fileHead;
        String tag;

        TagHead(String str, String[] strArr, String str2) {
            this.tag = str;
            this.consoleHead = strArr;
            this.fileHead = str2;
        }
    }

    private LogUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(Object... objArr) {
        log(7, CONFIG.mGlobalTag, objArr);
    }

    public static void aTag(String str, Object... objArr) {
        log(7, str, objArr);
    }

    private static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static void d(Object... objArr) {
        log(3, CONFIG.mGlobalTag, objArr);
    }

    public static void dTag(String str, Object... objArr) {
        log(3, str, objArr);
    }

    public static void e(Object... objArr) {
        log(6, CONFIG.mGlobalTag, objArr);
    }

    public static void eTag(String str, Object... objArr) {
        log(6, str, objArr);
    }

    public static void file(Object obj) {
        log(19, CONFIG.mGlobalTag, obj);
    }

    private static String formatJson(String str) {
        try {
            if (str.startsWith("{")) {
                str = new JSONObject(str).toString(4);
            } else if (str.startsWith("[")) {
                str = new JSONArray(str).toString(4);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    private static String formatXml(String str) {
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Constants.VIA_TO_TYPE_QZONE);
            newTransformer.transform(streamSource, streamResult);
            String obj = streamResult.getWriter().toString();
            return obj.replaceFirst(">", ">" + LINE_SEP);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static Config getConfig() {
        return CONFIG;
    }

    private static String getFileName(StackTraceElement stackTraceElement) {
        String fileName = stackTraceElement.getFileName();
        if (fileName != null) {
            return fileName;
        }
        String className = stackTraceElement.getClassName();
        String[] split = className.split("\\.");
        if (split.length > 0) {
            className = split[split.length - 1];
        }
        int indexOf = className.indexOf(36);
        if (indexOf != -1) {
            className = className.substring(0, indexOf);
        }
        return className + ".java";
    }

    public static void i(Object... objArr) {
        log(4, CONFIG.mGlobalTag, objArr);
    }

    public static void iTag(String str, Object... objArr) {
        log(4, str, objArr);
    }

    private static void input2File(final String str, final String str2) {
        if (sExecutor == null) {
            sExecutor = Executors.newSingleThreadExecutor();
        }
        try {
            if (((Boolean) sExecutor.submit(new Callable<Boolean>() { // from class: com.growingio.eventcenter.LogUtils.1
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Removed duplicated region for block: B:35:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.util.concurrent.Callable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Boolean call() throws java.lang.Exception {
                    /*
                        r6 = this;
                        r0 = 0
                        java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L25
                        java.io.FileWriter r2 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L25
                        java.lang.String r3 = r1     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L25
                        r4 = 1
                        r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L25
                        r1.<init>(r2)     // Catch: java.lang.Throwable -> L20 java.io.IOException -> L25
                        java.lang.String r0 = r2     // Catch: java.io.IOException -> L1e java.lang.Throwable -> L39
                        r1.write(r0)     // Catch: java.io.IOException -> L1e java.lang.Throwable -> L39
                        java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.io.IOException -> L1e java.lang.Throwable -> L39
                        r1.close()     // Catch: java.io.IOException -> L19
                        goto L1d
                    L19:
                        r1 = move-exception
                        r1.printStackTrace()
                    L1d:
                        return r0
                    L1e:
                        r0 = move-exception
                        goto L29
                    L20:
                        r1 = move-exception
                        r5 = r1
                        r1 = r0
                        r0 = r5
                        goto L3a
                    L25:
                        r1 = move-exception
                        r5 = r1
                        r1 = r0
                        r0 = r5
                    L29:
                        r0.printStackTrace()     // Catch: java.lang.Throwable -> L39
                        java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch: java.lang.Throwable -> L39
                        if (r1 == 0) goto L38
                        r1.close()     // Catch: java.io.IOException -> L34
                        goto L38
                    L34:
                        r1 = move-exception
                        r1.printStackTrace()
                    L38:
                        return r0
                    L39:
                        r0 = move-exception
                    L3a:
                        if (r1 == 0) goto L44
                        r1.close()     // Catch: java.io.IOException -> L40
                        goto L44
                    L40:
                        r1 = move-exception
                        r1.printStackTrace()
                    L44:
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.growingio.eventcenter.LogUtils.AnonymousClass1.call():java.lang.Boolean");
                }
            }).get()).booleanValue()) {
                return;
            }
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        } catch (ExecutionException e3) {
            e3.printStackTrace();
        }
        Log.e("LogUtils", "log to " + str2 + " failed!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static void json(String str) {
        log(35, CONFIG.mGlobalTag, str);
    }

    public static void log(int i2, String str, Object... objArr) {
        Config config = CONFIG;
        if (config.mLogSwitch) {
            if (config.mLog2ConsoleSwitch || config.mLog2FileSwitch) {
                int i3 = i2 & 15;
                int i4 = i2 & 240;
                if (i3 >= config.mConsoleFilter || i3 >= config.mFileFilter) {
                    TagHead processTagAndHead = processTagAndHead(str);
                    String processBody = processBody(i4, objArr);
                    if (!config.mLog2ConsoleSwitch || i3 < config.mConsoleFilter || i4 == 16) {
                        return;
                    }
                    print2Console(i3, processTagAndHead.tag, processTagAndHead.consoleHead, processBody);
                }
            }
        }
    }

    private static void print2Console(int i2, String str, String[] strArr, String str2) {
        Config config = CONFIG;
        int i3 = 0;
        if (config.mSingleTagSwitch) {
            StringBuilder sb = new StringBuilder();
            sb.append(PLACEHOLDER);
            String str3 = LINE_SEP;
            sb.append(str3);
            if (config.mLogBorderSwitch) {
                sb.append(TOP_BORDER);
                sb.append(str3);
                if (strArr != null) {
                    for (String str4 : strArr) {
                        sb.append(LEFT_BORDER);
                        sb.append(str4);
                        sb.append(LINE_SEP);
                    }
                    sb.append(MIDDLE_BORDER);
                    sb.append(LINE_SEP);
                }
                String[] split = str2.split(LINE_SEP);
                int length = split.length;
                while (i3 < length) {
                    String str5 = split[i3];
                    sb.append(LEFT_BORDER);
                    sb.append(str5);
                    sb.append(LINE_SEP);
                    i3++;
                }
                sb.append(BOTTOM_BORDER);
            } else {
                if (strArr != null) {
                    int length2 = strArr.length;
                    while (i3 < length2) {
                        sb.append(strArr[i3]);
                        sb.append(LINE_SEP);
                        i3++;
                    }
                }
                sb.append(str2);
            }
            printMsgSingleTag(i2, str, sb.toString());
            return;
        }
        printBorder(i2, str, true);
        printHead(i2, str, strArr);
        printMsg(i2, str, str2);
        printBorder(i2, str, false);
    }

    private static void printBorder(int i2, String str, boolean z) {
        if (CONFIG.mLogBorderSwitch) {
            Log.println(i2, str, z ? TOP_BORDER : BOTTOM_BORDER);
        }
    }

    private static void printHead(int i2, String str, String[] strArr) {
        if (strArr != null) {
            for (String str2 : strArr) {
                if (CONFIG.mLogBorderSwitch) {
                    str2 = LEFT_BORDER + str2;
                }
                Log.println(i2, str, str2);
            }
            if (CONFIG.mLogBorderSwitch) {
                Log.println(i2, str, MIDDLE_BORDER);
            }
        }
    }

    private static void printMsg(int i2, String str, String str2) {
        int length = str2.length();
        int i3 = length / 3000;
        if (i3 <= 0) {
            printSubMsg(i2, str, str2);
            return;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i5 + 3000;
            printSubMsg(i2, str, str2.substring(i5, i6));
            i4++;
            i5 = i6;
        }
        if (i5 != length) {
            printSubMsg(i2, str, str2.substring(i5, length));
        }
    }

    private static void printMsgSingleTag(int i2, String str, String str2) {
        int length = str2.length();
        int i3 = length / 3000;
        if (i3 > 0) {
            int i4 = 0;
            if (!CONFIG.mLogBorderSwitch) {
                int i5 = 0;
                while (i4 < i3) {
                    int i6 = i5 + 3000;
                    Log.println(i2, str, str2.substring(i5, i6));
                    i4++;
                    i5 = i6;
                }
                if (i5 != length) {
                    Log.println(i2, str, str2.substring(i5, length));
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            int i7 = 3000;
            sb.append(str2.substring(0, 3000));
            sb.append(LINE_SEP);
            sb.append(BOTTOM_BORDER);
            Log.println(i2, str, sb.toString());
            int i8 = 1;
            while (i8 < i3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(PLACEHOLDER);
                String str3 = LINE_SEP;
                sb2.append(str3);
                sb2.append(TOP_BORDER);
                sb2.append(str3);
                sb2.append(LEFT_BORDER);
                int i9 = i7 + 3000;
                sb2.append(str2.substring(i7, i9));
                sb2.append(str3);
                sb2.append(BOTTOM_BORDER);
                Log.println(i2, str, sb2.toString());
                i8++;
                i7 = i9;
            }
            if (i7 != length) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(PLACEHOLDER);
                String str4 = LINE_SEP;
                sb3.append(str4);
                sb3.append(TOP_BORDER);
                sb3.append(str4);
                sb3.append(LEFT_BORDER);
                sb3.append(str2.substring(i7, length));
                Log.println(i2, str, sb3.toString());
                return;
            }
            return;
        }
        Log.println(i2, str, str2);
    }

    private static void printSubMsg(int i2, String str, String str2) {
        String[] split;
        if (!CONFIG.mLogBorderSwitch) {
            Log.println(i2, str, str2);
            return;
        }
        for (String str3 : str2.split(LINE_SEP)) {
            Log.println(i2, str, LEFT_BORDER + str3);
        }
    }

    private static void printSubMsg1(int i2, String str, String str2) {
        String[] split;
        if (CONFIG.mLogBorderSwitch) {
            for (String str3 : str2.split(LINE_SEP)) {
                Log.println(i2, str, LEFT_BORDER + str3);
            }
        }
    }

    private static String processBody(int i2, Object... objArr) {
        String formatXml;
        String str = NULL;
        if (objArr != null) {
            if (objArr.length == 1) {
                Object obj = objArr[0];
                if (obj != null) {
                    str = obj.toString();
                }
                if (i2 == 32) {
                    formatXml = formatJson(str);
                } else if (i2 == 48) {
                    formatXml = formatXml(str);
                }
                str = formatXml;
            } else {
                StringBuilder sb = new StringBuilder();
                int length = objArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj2 = objArr[i3];
                    sb.append(ARGS);
                    sb.append("[");
                    sb.append(i3);
                    sb.append("]");
                    sb.append(" = ");
                    sb.append(obj2 == null ? NULL : obj2.toString());
                    sb.append(LINE_SEP);
                }
                str = sb.toString();
            }
        }
        return str.length() == 0 ? NOTHING : str;
    }

    private static TagHead processTagAndHead(String str) {
        String str2;
        String str3;
        String name;
        String str4;
        Config config = CONFIG;
        if (!config.mTagIsSpace && !config.mLogHeadSwitch) {
            str3 = config.mGlobalTag;
        } else {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            int i2 = config.mStackOffset + 3;
            if (i2 >= stackTrace.length) {
                String fileName = getFileName(stackTrace[3]);
                if (config.mTagIsSpace && isSpace(str)) {
                    int indexOf = fileName.indexOf(46);
                    str4 = indexOf == -1 ? fileName : fileName.substring(0, indexOf);
                } else {
                    str4 = str;
                }
                return new TagHead(str4, null, ": ");
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            String fileName2 = getFileName(stackTraceElement);
            if (config.mTagIsSpace && isSpace(str)) {
                int indexOf2 = fileName2.indexOf(46);
                str2 = indexOf2 == -1 ? fileName2 : fileName2.substring(0, indexOf2);
            } else {
                str2 = str;
            }
            if (config.mLogHeadSwitch) {
                String formatter = new Formatter().format("%s, %s.%s(%s:%d)", Thread.currentThread().getName(), stackTraceElement.getClassName(), stackTraceElement.getMethodName(), fileName2, Integer.valueOf(stackTraceElement.getLineNumber())).toString();
                String str5 = " [" + formatter + "]: ";
                if (config.mStackDeep <= 1) {
                    return new TagHead(str2, new String[]{formatter}, str5);
                }
                int min = Math.min(config.mStackDeep, stackTrace.length - i2);
                String[] strArr = new String[min];
                strArr[0] = formatter;
                String formatter2 = new Formatter().format(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.PERCENT + (name.length() + 2) + "s", "").toString();
                for (int i3 = 1; i3 < min; i3++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i3 + i2];
                    strArr[i3] = new Formatter().format("%s%s.%s(%s:%d)", formatter2, stackTraceElement2.getClassName(), stackTraceElement2.getMethodName(), getFileName(stackTraceElement2), Integer.valueOf(stackTraceElement2.getLineNumber())).toString();
                }
                return new TagHead(str2, strArr, str5);
            }
            str3 = str2;
        }
        return new TagHead(str3, null, ": ");
    }

    public static void v(Object... objArr) {
        log(2, CONFIG.mGlobalTag, objArr);
    }

    public static void vTag(String str, Object... objArr) {
        log(2, str, objArr);
    }

    public static void w(Object... objArr) {
        log(5, CONFIG.mGlobalTag, objArr);
    }

    public static void wTag(String str, Object... objArr) {
        log(5, str, objArr);
    }

    public static void xml(String str) {
        log(51, CONFIG.mGlobalTag, str);
    }

    public static void file(int i2, Object obj) {
        log(i2 | 16, CONFIG.mGlobalTag, obj);
    }

    public static void json(int i2, String str) {
        log(i2 | 32, CONFIG.mGlobalTag, str);
    }

    public static void xml(int i2, String str) {
        log(i2 | 48, CONFIG.mGlobalTag, str);
    }

    public static void file(String str, Object obj) {
        log(19, str, obj);
    }

    public static void json(String str, String str2) {
        log(35, str, str2);
    }

    public static void xml(String str, String str2) {
        log(51, str, str2);
    }

    public static void file(int i2, String str, Object obj) {
        log(i2 | 16, str, obj);
    }

    public static void json(int i2, String str, String str2) {
        log(i2 | 32, str, str2);
    }

    public static void xml(int i2, String str, String str2) {
        log(i2 | 48, str, str2);
    }
}
