package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import us.pinguo.common.network.common.header.PGTransHeader;
/* compiled from: FileUtils.java */
/* loaded from: classes.dex */
public class i {

    /* compiled from: FileUtils.java */
    /* loaded from: classes.dex */
    private static final class a implements Comparator<File> {
        private a() {
        }

        private int a(long j2, long j3) {
            int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
            if (i2 < 0) {
                return -1;
            }
            return i2 == 0 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }
    }

    public static File a(Context context, boolean z, String str, String str2) {
        String a2 = a(context);
        if (z) {
            str = "/" + s.a(context) + PGTransHeader.CONNECTOR + str;
        }
        String str3 = a2 + str;
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(str3, str2);
    }

    public static void b(File file) throws IOException {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            e(file);
            if (file.lastModified() < currentTimeMillis) {
                o.d("Files", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
            }
        }
    }

    public static void c(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (file.isFile()) {
                file.delete();
            } else {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isDirectory()) {
                            c(file2);
                        } else {
                            try {
                                file2.delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
                file.delete();
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
        if (r2 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] d(java.io.File r7) {
        /*
            r0 = 0
            if (r7 == 0) goto L4d
            boolean r1 = r7.isFile()
            if (r1 == 0) goto L4d
            boolean r1 = r7.exists()
            if (r1 == 0) goto L4d
            boolean r1 = r7.canRead()
            if (r1 == 0) goto L4d
            long r1 = r7.length()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L4d
            long r1 = r7.length()     // Catch: java.lang.Throwable -> L49
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L49
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L49
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L49
            int r7 = r1.intValue()     // Catch: java.lang.Throwable -> L47
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L47
            int r3 = r2.read(r7)     // Catch: java.lang.Throwable -> L47
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L47
            long r5 = r1.longValue()     // Catch: java.lang.Throwable -> L47
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L43
            r2.close()     // Catch: java.lang.Throwable -> L42
        L42:
            return r7
        L43:
            r2.close()     // Catch: java.lang.Throwable -> L4d
            goto L4d
        L47:
            goto L4a
        L49:
            r2 = r0
        L4a:
            if (r2 == 0) goto L4d
            goto L43
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.i.d(java.io.File):byte[]");
    }

    private static void e(File file) throws IOException {
        long length = file.length();
        if (length == 0) {
            f(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
            long j2 = length - 1;
            try {
                randomAccessFile2.seek(j2);
                byte readByte = randomAccessFile2.readByte();
                randomAccessFile2.seek(j2);
                randomAccessFile2.write(readByte);
                randomAccessFile2.close();
            } catch (Throwable unused) {
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private static void f(File file) throws IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }

    private static String a(Context context) {
        File cacheDir;
        if (context == null || (cacheDir = context.getCacheDir()) == null) {
            return null;
        }
        return cacheDir.getPath();
    }

    public static List<File> a(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            List<File> asList = Arrays.asList(listFiles);
            Collections.sort(asList, new a());
            return asList;
        }
        return linkedList;
    }
}
