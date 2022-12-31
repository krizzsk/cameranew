package us.pinguo.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* compiled from: ForJavaFileIOUtils.kt */
/* loaded from: classes6.dex */
public final class k {
    public static final k a = new k();
    private static final String b = System.getProperty("line.separator");

    private k() {
    }

    private final boolean a(String str) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final byte[] b(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        int read;
        if (!l.l(file)) {
            return null;
        }
        try {
            try {
                kotlin.jvm.internal.s.e(file);
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            file = null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                do {
                    read = fileInputStream.read(bArr, 0, 8192);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                        continue;
                    }
                } while (read != -1);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                f.a(fileInputStream, byteArrayOutputStream);
                return byteArray;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                f.a(fileInputStream, byteArrayOutputStream);
                return null;
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            file = null;
            f.a(fileInputStream, file);
            throw th;
        }
    }

    public static final byte[] c(String str) {
        return b(l.n(str));
    }

    public static final String d(File file) {
        kotlin.jvm.internal.s.h(file, "file");
        return e(file, null);
    }

    public static final String e(File file, String str) {
        BufferedReader bufferedReader;
        String readLine;
        BufferedReader bufferedReader2 = null;
        if (!l.l(file)) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            if (a.a(str)) {
                kotlin.jvm.internal.s.e(file);
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } else {
                kotlin.jvm.internal.s.e(file);
                FileInputStream fileInputStream = new FileInputStream(file);
                kotlin.jvm.internal.s.e(str);
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, str));
            }
            try {
                try {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 != null) {
                        sb.append(readLine2);
                        do {
                            readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                sb.append(b);
                                sb.append(readLine);
                                continue;
                            }
                        } while (readLine != null);
                        String sb2 = sb.toString();
                        f.a(bufferedReader);
                        return sb2;
                    }
                    String sb22 = sb.toString();
                    f.a(bufferedReader);
                    return sb22;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    f.a(bufferedReader);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                f.a(bufferedReader2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            f.a(bufferedReader2);
            throw th;
        }
    }

    public static final byte[] f(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        int read;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    byte[] bArr = new byte[8192];
                    do {
                        read = inputStream.read(bArr, 0, 8192);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                            continue;
                        }
                    } while (read != -1);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    f.a(byteArrayOutputStream);
                    return byteArray;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    f.a(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                f.a(byteArrayOutputStream2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            f.a(byteArrayOutputStream2);
            throw th;
        }
    }

    public static final boolean g(File file, byte[] bytes) {
        kotlin.jvm.internal.s.h(file, "file");
        kotlin.jvm.internal.s.h(bytes, "bytes");
        return h(file, bytes, false);
    }

    public static final boolean h(File file, byte[] bArr, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        if (bArr == null || !l.g(file)) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                kotlin.jvm.internal.s.e(file);
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, z));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            bufferedOutputStream.write(bArr);
            f.a(bufferedOutputStream);
            return true;
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            f.a(bufferedOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            f.a(bufferedOutputStream2);
            throw th;
        }
    }

    public static final boolean i(String filePath, byte[] bytes) {
        kotlin.jvm.internal.s.h(filePath, "filePath");
        kotlin.jvm.internal.s.h(bytes, "bytes");
        return h(l.n(filePath), bytes, false);
    }

    public static final boolean j(File file, InputStream inputStream) {
        return k(file, inputStream, false);
    }

    public static final boolean k(File file, InputStream inputStream, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        int read;
        if (!l.g(file) || inputStream == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, z));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            byte[] bArr = new byte[8192];
            do {
                read = inputStream.read(bArr, 0, 8192);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                    continue;
                }
            } while (read != -1);
            f.a(bufferedOutputStream);
            return true;
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            f.a(bufferedOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            f.a(bufferedOutputStream2);
            throw th;
        }
    }

    public static final boolean l(File file, String content) {
        kotlin.jvm.internal.s.h(file, "file");
        kotlin.jvm.internal.s.h(content, "content");
        return m(file, content, false);
    }

    public static final boolean m(File file, String str, boolean z) {
        BufferedWriter bufferedWriter;
        if (file == null || str == null || !l.g(file)) {
            return false;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file, z));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            bufferedWriter.write(str);
            f.a(bufferedWriter);
            return true;
        } catch (IOException e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            f.a(bufferedWriter2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            f.a(bufferedWriter2);
            throw th;
        }
    }

    public static final boolean n(String filePath, String content) {
        kotlin.jvm.internal.s.h(filePath, "filePath");
        kotlin.jvm.internal.s.h(content, "content");
        return m(l.n(filePath), content, false);
    }
}
