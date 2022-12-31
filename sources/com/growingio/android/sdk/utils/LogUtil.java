package com.growingio.android.sdk.utils;

import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LogUtil {
    private static final String TAG = "GIO.LogUtil";
    private static final Util[] UTILS_ARRAY_EMPTY;
    static volatile Util[] utilsArray;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final List<Util> UTILS_LIST = new ArrayList();
    private static final Util UTILS = new Util() { // from class: com.growingio.android.sdk.utils.LogUtil.1
        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void custom(int i2, String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.custom(i2, str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void d(String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.d(str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void e(String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.e(str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void i(String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.i(str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        protected void log(int i2, @Nullable String str, @NonNull String str2, @Nullable Throwable th) {
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void v(String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.v(str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void w(String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.w(str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void wtf(String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.wtf(str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void custom(int i2, String str, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.custom(i2, str, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void d(String str, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.d(str, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void e(String str, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.e(str, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void i(String str, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.i(str, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void v(String str, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.v(str, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void w(String str, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.w(str, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void wtf(String str, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.wtf(str, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void custom(int i2, Throwable th, String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.custom(i2, th, str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void d(Throwable th, String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.d(th, str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void e(Throwable th, String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.e(th, str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void i(Throwable th, String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.i(th, str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void v(Throwable th, String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.v(th, str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void w(Throwable th, String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.w(th, str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void wtf(Throwable th, String str, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.wtf(th, str, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void custom(int i2, String str, Throwable th, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.custom(i2, str, th, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void d(String str, Throwable th, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.d(str, th, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void e(String str, Throwable th, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.e(str, th, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void i(String str, Throwable th, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.i(str, th, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void v(String str, Throwable th, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.v(str, th, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void w(String str, Throwable th, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.w(str, th, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void wtf(String str, Throwable th, String str2, Object... objArr) {
            for (Util util : LogUtil.utilsArray) {
                util.wtf(str, th, str2, objArr);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void custom(int i2, Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.custom(i2, th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void d(Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.d(th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void e(Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.e(th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void i(Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.i(th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void v(Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.v(th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void w(Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.w(th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void wtf(Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.wtf(th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void custom(int i2, String str, Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.custom(i2, str, th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void d(String str, Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.d(str, th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void e(String str, Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.e(str, th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void i(String str, Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.i(str, th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void v(String str, Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.v(str, th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void w(String str, Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.w(str, th);
            }
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        public void wtf(String str, Throwable th) {
            for (Util util : LogUtil.utilsArray) {
                util.wtf(th);
            }
        }
    };

    /* loaded from: classes2.dex */
    public static class DebugUtil extends Util {
        private static final int MAX_LOG_LENGTH = 4000;

        /* loaded from: classes2.dex */
        private static class SingleInstance {
            private static final DebugUtil INSTANCE = new DebugUtil();

            private SingleInstance() {
            }
        }

        public static DebugUtil getInstance() {
            return SingleInstance.INSTANCE;
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.Util
        protected void log(int i2, String str, @NonNull String str2, Throwable th) {
            int min;
            if (i2 > 7) {
                return;
            }
            if (str2.length() < 4000) {
                if (i2 == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i2, str, str2);
                    return;
                }
            }
            int i3 = 0;
            int length = str2.length();
            while (i3 < length) {
                int indexOf = str2.indexOf(10, i3);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i3 + 4000);
                    String substring = str2.substring(i3, min);
                    if (i2 == 7) {
                        Log.wtf(str, substring);
                    } else {
                        Log.println(i2, str, substring);
                    }
                    if (min >= indexOf) {
                        break;
                    }
                    i3 = min;
                }
                i3 = min + 1;
            }
        }

        private DebugUtil() {
        }
    }

    /* loaded from: classes2.dex */
    public static class ReleaseUitl extends DebugUtil {

        /* loaded from: classes2.dex */
        private static class SingleInstance {
            private static final ReleaseUitl INSTANCE = new ReleaseUitl();

            private SingleInstance() {
            }
        }

        public static ReleaseUitl getInstance() {
            return SingleInstance.INSTANCE;
        }

        @Override // com.growingio.android.sdk.utils.LogUtil.DebugUtil, com.growingio.android.sdk.utils.LogUtil.Util
        protected void log(int i2, String str, @NonNull String str2, Throwable th) {
            if (i2 < 6) {
                return;
            }
            super.log(i2, str, str2, th);
        }

        private ReleaseUitl() {
            super();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Util {
        private String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private void prepareLog(int i2, Throwable th, String str, Object... objArr) {
            prepareLog(i2, LogUtil.TAG, th, str, objArr);
        }

        public void custom(int i2, String str, Object... objArr) {
            prepareLog(i2, null, str, objArr);
        }

        public void d(String str, Object... objArr) {
            prepareLog(3, null, str, objArr);
        }

        public void e(String str, Object... objArr) {
            prepareLog(6, null, str, objArr);
        }

        protected String formatMessage(@NonNull String str, @NonNull Object[] objArr) {
            try {
                return String.format(str, objArr);
            } catch (Exception unused) {
                return str;
            }
        }

        public void i(String str, Object... objArr) {
            prepareLog(4, null, str, objArr);
        }

        protected abstract void log(int i2, @Nullable String str, @NonNull String str2, @Nullable Throwable th);

        public void v(String str, Object... objArr) {
            prepareLog(2, null, str, objArr);
        }

        public void w(String str, Object... objArr) {
            prepareLog(5, null, str, objArr);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, null, str, objArr);
        }

        private void prepareLog(int i2, String str, Throwable th, String str2, Object... objArr) {
            if (str2 != null && str2.length() == 0) {
                str2 = null;
            }
            if (str2 != null) {
                if (objArr != null && objArr.length > 0) {
                    str2 = formatMessage(str2, objArr);
                }
                if (th != null) {
                    str2 = str2 + "\n" + getStackTraceString(th);
                }
            } else if (th == null) {
                return;
            } else {
                str2 = getStackTraceString(th);
            }
            log(i2, str, str2, th);
        }

        public void custom(int i2, String str, String str2, Object... objArr) {
            prepareLog(i2, str, null, str2, objArr);
        }

        public void d(String str, String str2, Object... objArr) {
            prepareLog(3, str, null, str2, objArr);
        }

        public void e(String str, String str2, Object... objArr) {
            prepareLog(6, str, null, str2, objArr);
        }

        public void i(String str, String str2, Object... objArr) {
            prepareLog(4, str, null, str2, objArr);
        }

        public void v(String str, String str2, Object... objArr) {
            prepareLog(2, str, null, str2, objArr);
        }

        public void w(String str, String str2, Object... objArr) {
            prepareLog(5, str, null, str2, objArr);
        }

        public void wtf(String str, String str2, Object... objArr) {
            prepareLog(7, str, null, str2, objArr);
        }

        public void custom(int i2, Throwable th, String str, Object... objArr) {
            prepareLog(i2, th, str, objArr);
        }

        public void d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        public void e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        public void i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        public void v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        public void w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }

        public void custom(int i2, String str, Throwable th, String str2, Object... objArr) {
            prepareLog(i2, str, th, str2, objArr);
        }

        public void d(String str, Throwable th, String str2, Object... objArr) {
            prepareLog(3, str, th, str2, objArr);
        }

        public void e(String str, Throwable th, String str2, Object... objArr) {
            prepareLog(6, str, th, str2, objArr);
        }

        public void i(String str, Throwable th, String str2, Object... objArr) {
            prepareLog(4, str, th, str2, objArr);
        }

        public void v(String str, Throwable th, String str2, Object... objArr) {
            prepareLog(2, str, th, str2, objArr);
        }

        public void w(String str, Throwable th, String str2, Object... objArr) {
            prepareLog(5, str, th, str2, objArr);
        }

        public void wtf(String str, Throwable th, String str2, Object... objArr) {
            prepareLog(7, str, th, str2, objArr);
        }

        public void custom(int i2, Throwable th) {
            prepareLog(i2, th, null, new Object[0]);
        }

        public void d(Throwable th) {
            prepareLog(3, th, null, new Object[0]);
        }

        public void e(Throwable th) {
            prepareLog(6, th, null, new Object[0]);
        }

        public void i(Throwable th) {
            prepareLog(4, th, null, new Object[0]);
        }

        public void v(Throwable th) {
            prepareLog(2, th, null, new Object[0]);
        }

        public void w(Throwable th) {
            prepareLog(5, th, null, new Object[0]);
        }

        public void wtf(Throwable th) {
            prepareLog(7, th, null, new Object[0]);
        }

        public void custom(int i2, String str, Throwable th) {
            prepareLog(i2, str, th, null, new Object[0]);
        }

        public void d(String str, Throwable th) {
            prepareLog(3, str, th, null, new Object[0]);
        }

        public void e(String str, Throwable th) {
            prepareLog(6, str, th, null, new Object[0]);
        }

        public void i(String str, Throwable th) {
            prepareLog(4, str, th, null, new Object[0]);
        }

        public void v(String str, Throwable th) {
            prepareLog(2, str, th, null, new Object[0]);
        }

        public void w(String str, Throwable th) {
            prepareLog(5, str, th, null, new Object[0]);
        }

        public void wtf(String str, Throwable th) {
            prepareLog(7, str, th, null, new Object[0]);
        }
    }

    static {
        Util[] utilArr = new Util[0];
        UTILS_ARRAY_EMPTY = utilArr;
        utilsArray = utilArr;
    }

    private LogUtil() {
        throw new AssertionError("No instances.");
    }

    @AnyThread
    public static void add(@NonNull Util util) {
        if (util == null || util == UTILS) {
            return;
        }
        List<Util> list = UTILS_LIST;
        synchronized (list) {
            if (!list.contains(util)) {
                list.add(util);
                utilsArray = (Util[]) list.toArray(new Util[list.size()]);
            }
        }
    }

    public static void d(String str, Object... objArr) {
        String str2 = "";
        for (Object obj : objArr) {
            str2 = str2 + obj;
        }
        UTILS.d(str, str2, new Object[0]);
    }

    public static void e(String str, String str2) {
        Util util = UTILS;
        util.e(str, "" + str2, new Object[0]);
    }

    public static void i(String str, String str2) {
        Util util = UTILS;
        util.i(str, "" + str2, new Object[0]);
    }

    public static void printJson(String str, String str2, String str3) {
        String[] split;
        try {
            if (str3.startsWith("{")) {
                str3 = new JSONObject(str3).toString(2);
            } else if (str3.startsWith("[")) {
                str3 = new JSONArray(str3).toString(2);
            }
        } catch (JSONException unused) {
        }
        printLine(str, true);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        String str4 = LINE_SEPARATOR;
        sb.append(str4);
        sb.append(str3);
        for (String str5 : sb.toString().split(str4)) {
            Log.d(str, "║ " + str5);
        }
        printLine(str, false);
    }

    private static void printLine(String str, boolean z) {
        if (z) {
            Log.d(str, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.d(str, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }

    @AnyThread
    public static void remove(@NonNull Util util) {
        if (util == null || util == UTILS) {
            return;
        }
        List<Util> list = UTILS_LIST;
        synchronized (list) {
            if (list.remove(util)) {
                utilsArray = (Util[]) list.toArray(new Util[list.size()]);
            }
        }
    }

    @AnyThread
    public static void removeAll() {
        List<Util> list = UTILS_LIST;
        synchronized (list) {
            list.clear();
            utilsArray = UTILS_ARRAY_EMPTY;
        }
    }

    @AnyThread
    public static int utilCount() {
        int size;
        List<Util> list = UTILS_LIST;
        synchronized (list) {
            size = list.size();
        }
        return size;
    }

    public static void v(String str, String str2) {
        Util util = UTILS;
        util.v(str, "" + str2, new Object[0]);
    }

    public static void e(String str, String str2, Throwable th) {
        Util util = UTILS;
        util.e(str, "" + str2, th);
    }

    public static void d(String str, String str2, Throwable th) {
        Util util = UTILS;
        util.d(str, "" + str2, th);
    }

    public static void d(Throwable th) {
        UTILS.e(TAG, th);
    }

    @AnyThread
    public static void add(@NonNull Util... utilArr) {
        if (utilArr == null) {
            return;
        }
        for (Util util : utilArr) {
            if (util == null || util == UTILS) {
                return;
            }
        }
        synchronized (UTILS_LIST) {
            for (Util util2 : utilArr) {
                List<Util> list = UTILS_LIST;
                if (!list.contains(util2)) {
                    list.add(util2);
                }
            }
            List<Util> list2 = UTILS_LIST;
            utilsArray = (Util[]) list2.toArray(new Util[list2.size()]);
        }
    }
}
