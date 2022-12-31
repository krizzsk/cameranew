package us.pinguo.common.pgdownloader.util;

import com.adjust.sdk.Constants;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.n;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.x;
/* compiled from: FileDownloadUtils.kt */
/* loaded from: classes4.dex */
public final class FileDownloadUtils {
    public static final FileDownloadUtils INSTANCE = new FileDownloadUtils();
    private static final Pattern CONTENT_DISPOSITION_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static final Pattern CONTENT_DISPOSITION_NON_QUOTED_PATTERN = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");

    private FileDownloadUtils() {
    }

    public static final void closeIO(Closeable... closeables) {
        List<Closeable> n;
        s.h(closeables, "closeables");
        n = n.n(closeables);
        for (Closeable closeable : n) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final boolean createOrExistsDir(String str) {
        return createOrExistsDir(getFileByPath(str));
    }

    public static final boolean createOrExistsFile(String filePath) {
        s.h(filePath, "filePath");
        return createOrExistsFile(getFileByPath(filePath));
    }

    public static final boolean deleteFile(String str) {
        return deleteFile(getFileByPath(str));
    }

    private static final String formatString(String str, Object... objArr) {
        x xVar = x.a;
        Locale locale = Locale.ENGLISH;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        s.g(format, "format(locale, format, *args)");
        return format;
    }

    public static final String generateFileName(String url) {
        s.h(url, "url");
        return md5(url);
    }

    private static final String generateFilePath(String str, String str2) {
        if (str2 != null) {
            if (str != null) {
                String separator = File.separator;
                s.g(separator, "separator");
                return formatString("%s%s%s", str, separator, str2);
            }
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
        throw new IllegalStateException("can't generate real path, the file name is null");
    }

    public static final int generateId(String url, String path) {
        s.h(url, "url");
        s.h(path, "path");
        return generateId(url, path, false);
    }

    public static final File getFileByPath(String str) {
        if (INSTANCE.isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    public static final String getTargetFilePath(String str, boolean z, String str2) {
        if (str == null) {
            return null;
        }
        if (z) {
            if (str2 == null) {
                return null;
            }
            return generateFilePath(str, str2);
        }
        return str;
    }

    private final boolean isSpace(String str) {
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

    private static final String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            Charset forName = Charset.forName("UTF-8");
            s.g(forName, "forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            s.g(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] digest = messageDigest.digest(bytes);
            s.g(digest, "getInstance(\"MD5\").diges…eArray(charset(\"UTF-8\")))");
            StringBuilder sb = new StringBuilder(digest.length * 2);
            int i2 = 0;
            int length = digest.length;
            while (i2 < length) {
                byte b = digest[i2];
                i2++;
                int i3 = b & Draft_75.END_OF_FRAME;
                if (i3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i3));
            }
            String sb2 = sb.toString();
            s.g(sb2, "hex.toString()");
            return sb2;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new RuntimeException("Huh, MD5 should be supported?", e3);
        }
    }

    public final String parseContentDisposition(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            matcher = CONTENT_DISPOSITION_QUOTED_PATTERN.matcher(str);
        } catch (IllegalStateException unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        Matcher matcher2 = CONTENT_DISPOSITION_NON_QUOTED_PATTERN.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static final boolean createOrExistsDir(File file) {
        if (file != null) {
            if (file.exists() ? file.isDirectory() : file.mkdirs()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (createOrExistsDir(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static final boolean deleteFile(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            deleteFile(file.listFiles());
            return file.delete();
        }
        return file.delete();
    }

    public static final int generateId(String url, String path, boolean z) {
        s.h(url, "url");
        s.h(path, "path");
        if (z) {
            return md5(formatString("%sp%s@dir", url, path)).hashCode();
        }
        return md5(formatString("%sp%s", url, path)).hashCode();
    }

    public static final boolean deleteFile(File[] fileArr) {
        boolean z;
        if (fileArr != null) {
            if (!(fileArr.length == 0)) {
                Iterator a = h.a(fileArr);
                while (true) {
                    while (a.hasNext()) {
                        z = z && deleteFile((File) a.next());
                    }
                    return z;
                }
            }
        }
        return false;
    }
}
