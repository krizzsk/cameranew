package us.pinguo.foundation.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
/* compiled from: UtilStorage.java */
/* loaded from: classes4.dex */
public class o0 {
    private static volatile o0 a;
    private static boolean b;
    private static String c;

    /* renamed from: d  reason: collision with root package name */
    private static String f11111d;

    private HashSet<String> b() {
        String[] split;
        String[] split2;
        HashSet<String> hashSet = new HashSet<>();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Process start = new ProcessBuilder(new String[0]).command("mount").redirectErrorStream(true).start();
            start.waitFor();
            InputStream inputStream = start.getInputStream();
            byte[] bArr = new byte[1024];
            while (inputStream.read(bArr) != -1) {
                stringBuffer.append(new String(bArr, "UTF-8"));
            }
            inputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        for (String str : stringBuffer.toString().split("\n")) {
            if (!str.toLowerCase(Locale.US).contains("asec") && str.matches("(?i).*vold.*(vfat|ntfs|exfat|fat32|ext3|ext4).*rw.*")) {
                for (String str2 : str.split(" ")) {
                    if (str2.startsWith("/") && !str2.toLowerCase(Locale.US).contains("vold")) {
                        hashSet.add(str2);
                    }
                }
            }
        }
        return hashSet;
    }

    public static synchronized o0 d(Context context) {
        o0 o0Var;
        synchronized (o0.class) {
            if (a == null) {
                a = new o0();
                a.e(context);
            }
            o0Var = a;
        }
        return o0Var;
    }

    private void e(Context context) {
        f11111d = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (us.pinguo.util.c.f12471e) {
            if (us.pinguo.util.c.f12476j) {
                b = false;
                c = null;
                return;
            }
            try {
                Method method = StorageManager.class.getMethod("getVolumePaths", new Class[0]);
                method.setAccessible(true);
                String[] strArr = (String[]) method.invoke((StorageManager) context.getSystemService("storage"), new Object[0]);
                if (strArr == null || strArr.length < 2) {
                    return;
                }
                String str = strArr[1];
                if (str.toLowerCase(Locale.ENGLISH).contains("/usb")) {
                    return;
                }
                b = true;
                c = str;
                return;
            } catch (Exception unused) {
                return;
            }
        }
        HashSet<String> b2 = b();
        Iterator<String> it = b2.iterator();
        while (it.hasNext()) {
            if (it.next().equals(f11111d)) {
                it.remove();
            }
        }
        Iterator<String> it2 = b2.iterator();
        if (it2.hasNext()) {
            b = true;
            c = it2.next();
        }
    }

    public long a(String str) {
        try {
            File file = new File(str);
            if (file.isFile()) {
                us.pinguo.common.log.a.s("Picture saveFreePuzzlePic path is a file.", new Object[0]);
                return 0L;
            }
            if (!file.exists() && !file.mkdirs()) {
                us.pinguo.common.log.a.e("Create dir failed!", new Object[0]);
            }
            StatFs statFs = new StatFs(str);
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String c() {
        String str = c;
        if (str != null) {
            return str;
        }
        return null;
    }

    public boolean f() {
        return b;
    }
}
