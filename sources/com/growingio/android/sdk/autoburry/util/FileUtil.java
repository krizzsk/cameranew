package com.growingio.android.sdk.autoburry.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
/* loaded from: classes2.dex */
public class FileUtil {
    public static String readFromFile(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            byte[] bArr = new byte[2048];
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                int read = fileInputStream2.read(bArr);
                if (read >= 0 && read < 2048) {
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return str;
                }
                PrintStream printStream = System.err;
                printStream.println("readFromFile, but size is " + read + ", please check");
                try {
                    fileInputStream2.close();
                } catch (IOException unused2) {
                }
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void writeToFile(File file, String str) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(str.getBytes());
                try {
                    fileOutputStream2.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
