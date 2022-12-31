package com.unity3d.splash.services.core.cache;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.unity3d.splash.services.core.log.DeviceLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/* loaded from: classes3.dex */
public class a {
    private String a;
    private boolean b = false;
    private File c = null;

    public a(String str) {
        this.a = str;
    }

    private void b(File file) {
        try {
            if (new File(file, ".nomedia").createNewFile()) {
                DeviceLog.c("Successfully created .nomedia file");
            } else {
                DeviceLog.c("Using existing .nomedia file");
            }
        } catch (Exception e2) {
            DeviceLog.g("Failed to create .nomedia file", e2);
        }
    }

    public File a(File file, String str) {
        if (file == null) {
            return null;
        }
        File file2 = new File(file, str);
        file2.mkdirs();
        if (file2.isDirectory()) {
            return file2;
        }
        return null;
    }

    public File c(Context context) {
        String str;
        File file;
        if (this.b) {
            return this.c;
        }
        this.b = true;
        if (Build.VERSION.SDK_INT > 18) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                try {
                    file = a(context.getExternalCacheDir(), this.a);
                } catch (Exception e2) {
                    DeviceLog.g("Creating external cache directory failed", e2);
                    file = null;
                }
                if (d(file)) {
                    b(file);
                    this.c = file;
                    CacheDirectoryType cacheDirectoryType = CacheDirectoryType.EXTERNAL;
                    str = "Unity Ads is using external cache directory: " + file.getAbsolutePath();
                    DeviceLog.c(str);
                    return this.c;
                }
            } else {
                DeviceLog.c("External media not mounted");
            }
        }
        File filesDir = context.getFilesDir();
        if (!d(filesDir)) {
            DeviceLog.f("Unity Ads failed to initialize cache directory");
            return null;
        }
        this.c = filesDir;
        CacheDirectoryType cacheDirectoryType2 = CacheDirectoryType.INTERNAL;
        str = "Unity Ads is using internal cache directory: " + filesDir.getAbsolutePath();
        DeviceLog.c(str);
        return this.c;
    }

    public boolean d(File file) {
        if (file != null && file.isDirectory()) {
            try {
                byte[] bytes = "test".getBytes("UTF-8");
                int length = bytes.length;
                byte[] bArr = new byte[length];
                File file2 = new File(file, "UnityAdsTest.txt");
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                fileOutputStream.close();
                FileInputStream fileInputStream = new FileInputStream(file2);
                int read = fileInputStream.read(bArr, 0, length);
                fileInputStream.close();
                if (!file2.delete()) {
                    DeviceLog.c("Failed to delete testfile " + file2.getAbsoluteFile());
                    return false;
                } else if (read != length) {
                    DeviceLog.c("Read buffer size mismatch");
                    return false;
                } else if (new String(bArr, "UTF-8").equals("test")) {
                    return true;
                } else {
                    DeviceLog.c("Read buffer content mismatch");
                    return false;
                }
            } catch (Exception e2) {
                DeviceLog.c("Unity Ads exception while testing cache directory " + file.getAbsolutePath() + ": " + e2.getMessage());
            }
        }
        return false;
    }
}
