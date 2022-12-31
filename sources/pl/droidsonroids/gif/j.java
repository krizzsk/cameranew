package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* compiled from: ReLinker.java */
/* loaded from: classes3.dex */
class j {
    private static final String a = System.mapLibraryName("pl_droidsonroids_gif");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReLinker.java */
    /* loaded from: classes3.dex */
    public static class a implements FilenameFilter {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(j.a) || str.startsWith(this.a);
        }
    }

    private j() {
    }

    private static void b(File file, FilenameFilter filenameFilter) {
        File[] listFiles = file.getParentFile().listFiles(filenameFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static void d(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    private static ZipEntry e(ZipFile zipFile) {
        for (String str : g()) {
            ZipEntry f2 = f(zipFile, str);
            if (f2 != null) {
                return f2;
            }
        }
        return null;
    }

    private static ZipEntry f(ZipFile zipFile, String str) {
        return zipFile.getEntry("lib/" + str + "/" + a);
    }

    private static String[] g() {
        return Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"UnsafeDynamicallyLoadedCode"})
    public static void h(Context context) {
        synchronized (j.class) {
            System.load(k(context).getAbsolutePath());
        }
    }

    private static ZipFile i(File file) {
        ZipFile zipFile;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 >= 5) {
                zipFile = null;
                break;
            }
            try {
                zipFile = new ZipFile(file, 1);
                break;
            } catch (IOException unused) {
                i2 = i3;
            }
        }
        if (zipFile != null) {
            return zipFile;
        }
        throw new IllegalStateException("Could not open APK file: " + file.getAbsolutePath());
    }

    @SuppressLint({"SetWorldReadable"})
    private static void j(File file) {
        file.setReadable(true, false);
        file.setExecutable(true, false);
        file.setWritable(true);
    }

    private static File k(Context context) {
        ZipFile zipFile;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Throwable th2;
        String str = a + "1.2.7";
        int i2 = 0;
        File file = new File(context.getDir("lib", 0), str);
        if (file.isFile()) {
            return file;
        }
        File file2 = new File(context.getCacheDir(), str);
        if (file2.isFile()) {
            return file2;
        }
        a aVar = new a(System.mapLibraryName("pl_droidsonroids_gif_surface"));
        b(file, aVar);
        b(file2, aVar);
        try {
            zipFile = i(new File(context.getApplicationInfo().sourceDir));
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    break;
                }
                try {
                    ZipEntry e2 = e(zipFile);
                    if (e2 != null) {
                        try {
                            inputStream = zipFile.getInputStream(e2);
                        } catch (IOException unused) {
                            inputStream = null;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                            fileOutputStream = null;
                        }
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                d(inputStream, fileOutputStream);
                                c(inputStream);
                                c(fileOutputStream);
                                j(file);
                                break;
                            } catch (IOException unused2) {
                                if (i3 > 2) {
                                    file = file2;
                                }
                                c(inputStream);
                                c(fileOutputStream);
                                i2 = i3;
                            } catch (Throwable th4) {
                                th2 = th4;
                                c(inputStream);
                                c(fileOutputStream);
                                throw th2;
                            }
                        } catch (IOException unused3) {
                            fileOutputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = null;
                            th2 = th;
                            c(inputStream);
                            c(fileOutputStream);
                            throw th2;
                        }
                    } else {
                        throw new IllegalStateException("Library " + a + " for supported ABIs not found in APK file");
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
                c(inputStream);
                c(fileOutputStream);
                i2 = i3;
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException unused5) {
                }
            }
            return file;
        } catch (Throwable th7) {
            zipFile = null;
            th = th7;
        }
    }
}
