package com.bytedance.sdk.openadsdk.core.video.a.a;

import android.content.Context;
import java.io.File;
import java.io.IOException;
/* compiled from: VideoFilesUtils.java */
/* loaded from: classes.dex */
public class c {
    private static void a(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " is not directory!");
        } else if (!file.mkdirs()) {
            throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
        }
    }

    public static File b(Context context, String str) {
        File file = new File(context.getFilesDir() + File.separator + "ttvideo", str + ".pre");
        try {
            a(file.getParentFile());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return file;
    }

    public static File a(Context context, String str) {
        File file = new File(context.getFilesDir() + File.separator + "ttvideo", str);
        try {
            a(file.getParentFile());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (file.exists()) {
            return file;
        }
        File parentFile = file.getParentFile();
        return new File(parentFile, file.getName() + ".download");
    }
}
