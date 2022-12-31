package us.pinguo.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/* compiled from: FileUtils.java */
/* loaded from: classes4.dex */
public final class e {
    private static final String a = "e";
    private static final String b = System.getProperty("line.separator");

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static boolean b(String str) {
        if (str == null) {
            return false;
        }
        return a(new File(str));
    }

    public static void c(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public static void d(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    public static void e(File file, File file2) throws IOException {
        File parentFile = file2.getParentFile();
        ?? a2 = a(parentFile);
        if (a2 != 0) {
            InputStream inputStream = null;
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read != -1) {
                                    bufferedOutputStream2.write(bArr, 0, read);
                                } else {
                                    bufferedOutputStream2.flush();
                                    d(bufferedOutputStream2);
                                    c(bufferedInputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream = bufferedOutputStream2;
                            d(bufferedOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = a2;
                    c(inputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                c(inputStream);
                throw th;
            }
        } else {
            throw new IOException("Create Folder(" + parentFile.getAbsolutePath() + ") Failed!");
        }
    }

    public static void f(String str, String str2) throws IOException {
        if (str != null && str2 != null) {
            e(new File(str), new File(str2));
            return;
        }
        throw new IOException("path is Null, srcPath=" + str + ",destPath=" + str2);
    }

    public static void g(File file) {
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                i(file.listFiles());
            }
            if (file.delete()) {
                return;
            }
            String str = a;
            us.pinguo.common.log.a.k(str, "delete (" + file.getPath() + ") failed!");
            return;
        }
        us.pinguo.common.log.a.e(a, "File is null or not exist, delete file fail!");
    }

    public static void h(String str) {
        if (str != null && !"".equals(str)) {
            g(new File(str));
        } else {
            us.pinguo.common.log.a.e(a, "File path is null or not exist, delete file fail!");
        }
    }

    public static void i(File[] fileArr) {
        if (fileArr != null && fileArr.length != 0) {
            for (File file : fileArr) {
                g(file);
            }
            return;
        }
        us.pinguo.common.log.a.e(a, "Files is null or empty, delete fail!");
    }

    public static String j(File file) throws IOException {
        long length = file.length();
        if (length > 32767) {
            length = 32767;
        }
        StringBuilder sb = new StringBuilder((int) length);
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            try {
                String readLine = bufferedReader2.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    while (true) {
                        String readLine2 = bufferedReader2.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        sb.append(b);
                        sb.append(readLine2);
                    }
                }
                bufferedReader2.close();
                return sb.toString();
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] k(File file) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] l2 = l(bufferedInputStream2);
                c(bufferedInputStream2);
                return l2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                c(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] l(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream2.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream2.flush();
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        d(byteArrayOutputStream2);
                        return byteArray;
                    }
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                d(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void m(byte[] bArr, String str) throws IOException {
        if (bArr == null) {
            throw new IOException("data is null");
        }
        if (str != null) {
            File parentFile = new File(str).getParentFile();
            if (a(parentFile)) {
                BufferedOutputStream bufferedOutputStream = null;
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
                    try {
                        bufferedOutputStream2.write(bArr);
                        d(bufferedOutputStream2);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        d(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                throw new IOException("Create Folder(" + parentFile.getAbsolutePath() + ") Failed!");
            }
        } else {
            throw new IOException("path is null");
        }
    }

    public static void n(File file, String str) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(str.getBytes("utf-8"));
            fileOutputStream.flush();
        } finally {
            d(fileOutputStream);
        }
    }
}
