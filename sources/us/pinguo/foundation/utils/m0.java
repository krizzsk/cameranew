package us.pinguo.foundation.utils;

import android.text.TextUtils;
import java.io.File;
/* compiled from: UnzipUtils.java */
/* loaded from: classes4.dex */
public class m0 {
    private static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String[] split = str2.split(File.separator);
        File file = new File(str);
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

    private static boolean b(String str, String str2) {
        File file = new File(str + str2);
        if (file.isDirectory() && file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c7, code lost:
        throw new java.io.IOException("Rename file failed, path=" + r3.getAbsolutePath());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(java.lang.String r6, java.lang.String r7) throws java.io.IOException {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            r1 = 0
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> Le1
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Le1
            r3.<init>(r6)     // Catch: java.lang.Throwable -> Le1
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Le1
        L10:
            java.util.zip.ZipEntry r6 = r2.getNextEntry()     // Catch: java.lang.Throwable -> Lde
            if (r6 == 0) goto Ld2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lde
            r3.<init>()     // Catch: java.lang.Throwable -> Lde
            java.lang.String r4 = "Unzipping "
            r3.append(r4)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r4 = r6.getName()     // Catch: java.lang.Throwable -> Lde
            r3.append(r4)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lde
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Lde
            us.pinguo.common.log.a.c(r3, r4)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r3 = r6.getName()     // Catch: java.lang.Throwable -> Lde
            java.lang.String r4 = "../"
            boolean r3 = r3.contains(r4)     // Catch: java.lang.Throwable -> Lde
            if (r3 == 0) goto L49
            r2.closeEntry()     // Catch: java.lang.Exception -> L44
            r2.close()     // Catch: java.lang.Exception -> L44
            goto L48
        L44:
            r6 = move-exception
            us.pinguo.common.log.a.f(r6)
        L48:
            return
        L49:
            boolean r3 = r6.isDirectory()     // Catch: java.lang.Throwable -> Lde
            if (r3 == 0) goto L78
            java.lang.String r3 = r6.getName()     // Catch: java.lang.Throwable -> Lde
            boolean r3 = b(r7, r3)     // Catch: java.lang.Throwable -> Lde
            if (r3 == 0) goto L5a
            goto L10
        L5a:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> Lde
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lde
            r1.<init>()     // Catch: java.lang.Throwable -> Lde
            java.lang.String r3 = "create folder failed,path="
            r1.append(r3)     // Catch: java.lang.Throwable -> Lde
            r1.append(r7)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> Lde
            r1.append(r6)     // Catch: java.lang.Throwable -> Lde
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> Lde
            r0.<init>(r6)     // Catch: java.lang.Throwable -> Lde
            throw r0     // Catch: java.lang.Throwable -> Lde
        L78:
            java.lang.String r3 = "decomp"
            java.lang.String r4 = ".tmp"
            java.io.File r3 = java.io.File.createTempFile(r3, r4, r0)     // Catch: java.lang.Throwable -> Lcb
            us.pinguo.util.k.j(r3, r2)     // Catch: java.lang.Throwable -> Lc8
            r2.closeEntry()     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r4 = r6.getName()     // Catch: java.lang.Throwable -> Lc8
            a(r7, r4)     // Catch: java.lang.Throwable -> Lc8
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc8
            r5.<init>()     // Catch: java.lang.Throwable -> Lc8
            r5.append(r7)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r6 = r6.getName()     // Catch: java.lang.Throwable -> Lc8
            r5.append(r6)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r6 = r5.toString()     // Catch: java.lang.Throwable -> Lc8
            r4.<init>(r6)     // Catch: java.lang.Throwable -> Lc8
            boolean r6 = r3.renameTo(r4)     // Catch: java.lang.Throwable -> Lc8
            if (r6 == 0) goto Lad
            goto L10
        Lad:
            java.io.IOException r6 = new java.io.IOException     // Catch: java.lang.Throwable -> Lc8
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc8
            r7.<init>()     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r0 = "Rename file failed, path="
            r7.append(r0)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r0 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> Lc8
            r7.append(r0)     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lc8
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lc8
            throw r6     // Catch: java.lang.Throwable -> Lc8
        Lc8:
            r6 = move-exception
            r1 = r3
            goto Lcc
        Lcb:
            r6 = move-exception
        Lcc:
            if (r1 == 0) goto Ld1
            r1.delete()     // Catch: java.lang.Throwable -> Lde
        Ld1:
            throw r6     // Catch: java.lang.Throwable -> Lde
        Ld2:
            r2.closeEntry()     // Catch: java.lang.Exception -> Ld9
            r2.close()     // Catch: java.lang.Exception -> Ld9
            goto Ldd
        Ld9:
            r6 = move-exception
            us.pinguo.common.log.a.f(r6)
        Ldd:
            return
        Lde:
            r6 = move-exception
            r1 = r2
            goto Le2
        Le1:
            r6 = move-exception
        Le2:
            if (r1 == 0) goto Lef
            r1.closeEntry()     // Catch: java.lang.Exception -> Leb
            r1.close()     // Catch: java.lang.Exception -> Leb
            goto Lef
        Leb:
            r7 = move-exception
            us.pinguo.common.log.a.f(r7)
        Lef:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.foundation.utils.m0.c(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00cc, code lost:
        throw new java.io.IOException("Rename file failed, path=" + r3.getAbsolutePath());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(java.lang.String r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r8)
            r1 = 0
            java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> Le6
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Le6
            r3.<init>(r7)     // Catch: java.lang.Throwable -> Le6
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Le6
        L10:
            java.util.zip.ZipEntry r7 = r2.getNextEntry()     // Catch: java.lang.Throwable -> Le3
            if (r7 == 0) goto Ld7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le3
            r3.<init>()     // Catch: java.lang.Throwable -> Le3
            java.lang.String r4 = "Unzipping "
            r3.append(r4)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r4 = r7.getName()     // Catch: java.lang.Throwable -> Le3
            r3.append(r4)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Le3
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> Le3
            us.pinguo.common.log.a.c(r3, r4)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r3 = r7.getName()     // Catch: java.lang.Throwable -> Le3
            java.lang.String r4 = "../"
            boolean r3 = r3.contains(r4)     // Catch: java.lang.Throwable -> Le3
            if (r3 == 0) goto L49
            r2.closeEntry()     // Catch: java.lang.Exception -> L44
            r2.close()     // Catch: java.lang.Exception -> L44
            goto L48
        L44:
            r7 = move-exception
            us.pinguo.common.log.a.f(r7)
        L48:
            return
        L49:
            boolean r3 = r7.isDirectory()     // Catch: java.lang.Throwable -> Le3
            if (r3 == 0) goto L78
            java.lang.String r3 = r7.getName()     // Catch: java.lang.Throwable -> Le3
            boolean r3 = b(r8, r3)     // Catch: java.lang.Throwable -> Le3
            if (r3 == 0) goto L5a
            goto L10
        L5a:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> Le3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le3
            r1.<init>()     // Catch: java.lang.Throwable -> Le3
            java.lang.String r3 = "create folder failed,path="
            r1.append(r3)     // Catch: java.lang.Throwable -> Le3
            r1.append(r8)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> Le3
            r1.append(r7)     // Catch: java.lang.Throwable -> Le3
            java.lang.String r7 = r1.toString()     // Catch: java.lang.Throwable -> Le3
            r0.<init>(r7)     // Catch: java.lang.Throwable -> Le3
            throw r0     // Catch: java.lang.Throwable -> Le3
        L78:
            java.lang.String r3 = "decomp"
            java.lang.String r4 = ".tmp"
            java.io.File r3 = java.io.File.createTempFile(r3, r4, r0)     // Catch: java.lang.Throwable -> Ld0
            us.pinguo.util.k.j(r3, r2)     // Catch: java.lang.Throwable -> Lcd
            r2.closeEntry()     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r4 = r7.getName()     // Catch: java.lang.Throwable -> Lcd
            a(r8, r4)     // Catch: java.lang.Throwable -> Lcd
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> Lcd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcd
            r5.<init>()     // Catch: java.lang.Throwable -> Lcd
            r5.append(r8)     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r6 = java.io.File.separator     // Catch: java.lang.Throwable -> Lcd
            r5.append(r6)     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r7 = r7.getName()     // Catch: java.lang.Throwable -> Lcd
            r5.append(r7)     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> Lcd
            r4.<init>(r7)     // Catch: java.lang.Throwable -> Lcd
            boolean r7 = r3.renameTo(r4)     // Catch: java.lang.Throwable -> Lcd
            if (r7 == 0) goto Lb2
            goto L10
        Lb2:
            java.io.IOException r7 = new java.io.IOException     // Catch: java.lang.Throwable -> Lcd
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcd
            r8.<init>()     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r0 = "Rename file failed, path="
            r8.append(r0)     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r0 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> Lcd
            r8.append(r0)     // Catch: java.lang.Throwable -> Lcd
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Lcd
            r7.<init>(r8)     // Catch: java.lang.Throwable -> Lcd
            throw r7     // Catch: java.lang.Throwable -> Lcd
        Lcd:
            r7 = move-exception
            r1 = r3
            goto Ld1
        Ld0:
            r7 = move-exception
        Ld1:
            if (r1 == 0) goto Ld6
            r1.delete()     // Catch: java.lang.Throwable -> Le3
        Ld6:
            throw r7     // Catch: java.lang.Throwable -> Le3
        Ld7:
            r2.closeEntry()     // Catch: java.lang.Exception -> Lde
            r2.close()     // Catch: java.lang.Exception -> Lde
            goto Le2
        Lde:
            r7 = move-exception
            us.pinguo.common.log.a.f(r7)
        Le2:
            return
        Le3:
            r7 = move-exception
            r1 = r2
            goto Le7
        Le6:
            r7 = move-exception
        Le7:
            if (r1 == 0) goto Lf4
            r1.closeEntry()     // Catch: java.lang.Exception -> Lf0
            r1.close()     // Catch: java.lang.Exception -> Lf0
            goto Lf4
        Lf0:
            r8 = move-exception
            us.pinguo.common.log.a.f(r8)
        Lf4:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.foundation.utils.m0.d(java.lang.String, java.lang.String):void");
    }
}
