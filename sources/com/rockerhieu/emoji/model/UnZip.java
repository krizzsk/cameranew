package com.rockerhieu.emoji.model;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
/* loaded from: classes9.dex */
public class UnZip {
    private static final int BUFFER_SIZE = 8192;

    private static void copyStream(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    private static void createDirsByEntryName(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split(File.separator);
        if (split.length > 1) {
            int i2 = 0;
            while (i2 < split.length - 1) {
                File file2 = new File(file, split[i2]);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                i2++;
                file = file2;
            }
        }
    }

    private static boolean dirChecker(File file, String str) {
        File file2 = new File(file, str);
        if (file2.isDirectory() && file2.exists()) {
            return true;
        }
        return file2.mkdirs();
    }

    private static File getRealFileName(String str, String str2) {
        String[] split = str2.split("/");
        File file = new File(str);
        if (split.length > 1) {
            int i2 = 0;
            while (i2 < split.length - 1) {
                String str3 = split[i2];
                try {
                    str3 = new String(str3.getBytes("8859_1"), "GB2312");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                File file2 = new File(file, str3);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                i2++;
                file = file2;
            }
            String str4 = split[split.length - 1];
            try {
                str4 = new String(str4.getBytes("8859_1"), "GB2312");
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
            return new File(file, str4);
        }
        return file;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b1, code lost:
        throw new java.io.IOException("Rename file failed, path=" + r6.getAbsolutePath());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void unZip(android.content.Context r5, java.lang.String r6, java.io.File r7) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rockerhieu.emoji.model.UnZip.unZip(android.content.Context, java.lang.String, java.io.File):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ae, code lost:
        throw new java.io.IOException("Rename file failed, path=" + r3.getAbsolutePath());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void unZipFile(java.io.File r6, java.io.File r7) throws java.io.IOException {
        /*
            r0 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> Ld6
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Ld6
            r3.<init>(r6)     // Catch: java.lang.Throwable -> Ld6
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Ld6
        Lf:
            java.util.zip.ZipEntry r6 = r2.getNextEntry()     // Catch: java.lang.Throwable -> Ld3
            if (r6 == 0) goto Lc7
            java.lang.String r3 = r6.getName()     // Catch: java.lang.Throwable -> Ld3
            java.lang.String r4 = "../"
            boolean r3 = r3.contains(r4)     // Catch: java.lang.Throwable -> Ld3
            if (r3 == 0) goto L2d
            r2.closeEntry()     // Catch: java.lang.Exception -> L28
            r2.close()     // Catch: java.lang.Exception -> L28
            goto L2c
        L28:
            r6 = move-exception
            r6.printStackTrace()
        L2c:
            return
        L2d:
            boolean r3 = r6.isDirectory()     // Catch: java.lang.Throwable -> Ld3
            if (r3 == 0) goto L5c
            java.lang.String r3 = r6.getName()     // Catch: java.lang.Throwable -> Ld3
            boolean r3 = dirChecker(r7, r3)     // Catch: java.lang.Throwable -> Ld3
            if (r3 == 0) goto L3e
            goto Lf
        L3e:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> Ld3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld3
            r1.<init>()     // Catch: java.lang.Throwable -> Ld3
            java.lang.String r3 = "create folder failed,path="
            r1.append(r3)     // Catch: java.lang.Throwable -> Ld3
            r1.append(r7)     // Catch: java.lang.Throwable -> Ld3
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> Ld3
            r1.append(r6)     // Catch: java.lang.Throwable -> Ld3
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> Ld3
            r0.<init>(r6)     // Catch: java.lang.Throwable -> Ld3
            throw r0     // Catch: java.lang.Throwable -> Ld3
        L5c:
            java.lang.String r3 = "decomp"
            java.lang.String r4 = ".tmp"
            java.io.File r3 = java.io.File.createTempFile(r3, r4, r7)     // Catch: java.lang.Throwable -> Lb5
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> Lb1
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> Lb1
            r5.<init>(r3)     // Catch: java.lang.Throwable -> Lb1
            r4.<init>(r5)     // Catch: java.lang.Throwable -> Lb1
            copyStream(r2, r4, r0)     // Catch: java.lang.Throwable -> Laf
            r2.closeEntry()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r5 = r6.getName()     // Catch: java.lang.Throwable -> Laf
            createDirsByEntryName(r7, r5)     // Catch: java.lang.Throwable -> Laf
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> Laf
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> Laf
            r5.<init>(r7, r6)     // Catch: java.lang.Throwable -> Laf
            boolean r6 = r3.renameTo(r5)     // Catch: java.lang.Throwable -> Laf
            if (r6 == 0) goto L94
            r4.close()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> Ld3
            goto Lf
        L8e:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> Ld3
            goto Lf
        L94:
            java.io.IOException r6 = new java.io.IOException     // Catch: java.lang.Throwable -> Laf
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Laf
            r7.<init>()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r0 = "Rename file failed, path="
            r7.append(r0)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r0 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> Laf
            r7.append(r0)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Laf
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Laf
            throw r6     // Catch: java.lang.Throwable -> Laf
        Laf:
            r6 = move-exception
            goto Lb3
        Lb1:
            r6 = move-exception
            r4 = r1
        Lb3:
            r1 = r3
            goto Lb7
        Lb5:
            r6 = move-exception
            r4 = r1
        Lb7:
            if (r1 == 0) goto Lbc
            r1.delete()     // Catch: java.lang.Throwable -> Ld3
        Lbc:
            if (r4 == 0) goto Lc6
            r4.close()     // Catch: java.lang.Exception -> Lc2 java.lang.Throwable -> Ld3
            goto Lc6
        Lc2:
            r7 = move-exception
            r7.printStackTrace()     // Catch: java.lang.Throwable -> Ld3
        Lc6:
            throw r6     // Catch: java.lang.Throwable -> Ld3
        Lc7:
            r2.closeEntry()     // Catch: java.lang.Exception -> Lce
            r2.close()     // Catch: java.lang.Exception -> Lce
            goto Ld2
        Lce:
            r6 = move-exception
            r6.printStackTrace()
        Ld2:
            return
        Ld3:
            r6 = move-exception
            r1 = r2
            goto Ld7
        Ld6:
            r6 = move-exception
        Ld7:
            if (r1 == 0) goto Le4
            r1.closeEntry()     // Catch: java.lang.Exception -> Le0
            r1.close()     // Catch: java.lang.Exception -> Le0
            goto Le4
        Le0:
            r7 = move-exception
            r7.printStackTrace()
        Le4:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rockerhieu.emoji.model.UnZip.unZipFile(java.io.File, java.io.File):void");
    }
}
