package us.pinguo.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import kotlin.text.StringsKt__StringsKt;
/* compiled from: ForJavaFileUtils.kt */
/* loaded from: classes6.dex */
public final class l {
    public static final l a = new l();

    private l() {
    }

    public static final boolean a(File file, File file2) {
        boolean C;
        int i2 = 0;
        if (file == null || file2 == null) {
            return false;
        }
        String path = file.getPath();
        String str = File.separator;
        C = StringsKt__StringsKt.C(kotlin.jvm.internal.s.q(file2.getPath(), str), kotlin.jvm.internal.s.q(path, str), false, 2, null);
        if (!C && file.exists() && e(file2)) {
            if (file.isDirectory()) {
                e(file2);
                String[] files = file.list();
                kotlin.jvm.internal.s.g(files, "files");
                int length = files.length;
                while (i2 < length) {
                    String str2 = files[i2];
                    i2++;
                    a(new File(file, str2), new File(file2, str2));
                }
                return true;
            }
            return c(file, file2);
        }
        return false;
    }

    public static final boolean b(String str, String str2) {
        return a(n(str), n(str2));
    }

    public static final boolean c(File file, File file2) {
        if (file == null || file2 == null || kotlin.jvm.internal.s.c(file, file2) || !file.exists() || !file.isFile()) {
            return false;
        }
        if ((!file2.exists() || file2.delete()) && e(file2.getParentFile())) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                boolean j2 = k.j(file2, bufferedInputStream);
                f.a(bufferedInputStream);
                return j2;
            } catch (Throwable th) {
                f.a(bufferedInputStream);
                throw th;
            }
        }
        return false;
    }

    public static final boolean d(String str, String str2) {
        return c(n(str), n(str2));
    }

    public static final boolean e(File file) {
        if (file != null) {
            if (file.exists() ? file.isDirectory() : file.mkdirs()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean f(String str) {
        return e(n(str));
    }

    public static final boolean g(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (e(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static final boolean h(String filePath) {
        kotlin.jvm.internal.s.h(filePath, "filePath");
        return g(n(filePath));
    }

    public static final boolean i(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            k(file.listFiles());
            return file.delete();
        }
        return file.delete();
    }

    public static final boolean j(String str) {
        return i(n(str));
    }

    public static final boolean k(File[] fileArr) {
        boolean z;
        if (fileArr != null) {
            if (!(fileArr.length == 0)) {
                Iterator a2 = kotlin.jvm.internal.h.a(fileArr);
                while (true) {
                    while (a2.hasNext()) {
                        z = z && i((File) a2.next());
                    }
                    return z;
                }
            }
        }
        return false;
    }

    public static final boolean l(File file) {
        if (file != null && file.exists()) {
            return file.isFile();
        }
        return false;
    }

    public static final boolean m(String filePath) {
        kotlin.jvm.internal.s.h(filePath, "filePath");
        return l(n(filePath));
    }

    public static final File n(String str) {
        if (a.o(str)) {
            return null;
        }
        return new File(str);
    }

    private final boolean o(String str) {
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
}
