package us.pinguo.foundation.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
/* compiled from: SDCardUtils.java */
/* loaded from: classes4.dex */
public final class c0 {
    public static final File a = Environment.getExternalStorageDirectory();
    @SuppressLint({"SdCardPath"})
    private static final String[] b = {"/emmc", "/sdcard/ext_sd", "/sdcard-ext", "/sdcard/sd", "/sdcard/sdcard"};

    private static File a(Context context, File file, String str) {
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        sb.append("/Android/data/");
        sb.append(context.getPackageName());
        sb.append("/files/");
        sb.append(str);
        return new File(file, sb.toString());
    }

    public static File b(Context context, String str) {
        File a2;
        int i2 = 0;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            try {
                a2 = (File) Context.class.getMethod("getExternalFilesDir", String.class).invoke(context, str);
            } catch (IllegalAccessException unused) {
                a2 = a(context, Environment.getExternalStorageDirectory(), str);
            } catch (IllegalArgumentException unused2) {
                a2 = a(context, Environment.getExternalStorageDirectory(), str);
            } catch (NoSuchMethodException unused3) {
                a2 = a(context, Environment.getExternalStorageDirectory(), str);
            } catch (InvocationTargetException unused4) {
                a2 = a(context, Environment.getExternalStorageDirectory(), str);
            }
        } else {
            a2 = null;
        }
        if (a2 == null) {
            while (true) {
                String[] strArr = b;
                if (i2 >= strArr.length) {
                    break;
                }
                File file = new File(strArr[i2]);
                if (file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
                    a2 = a(context, file, str);
                    break;
                }
                i2++;
            }
        }
        if (a2 == null || a2.exists() || a2.mkdirs()) {
            return a2;
        }
        return null;
    }

    public static String c() {
        File file;
        if (!d() || (file = a) == null) {
            return null;
        }
        return file.getPath();
    }

    public static boolean d() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
