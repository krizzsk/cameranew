package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdur {
    public static File zza(String str, String str2, @NonNull File file) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return new File(zza(str, file), str2);
    }

    public static boolean zze(@NonNull File file) {
        boolean z;
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                z = true;
                for (int i2 = 0; i2 < length; i2++) {
                    File file2 = listFiles[i2];
                    z = file2 != null && zze(file2) && z;
                }
            } else {
                z = true;
            }
            return file.delete() && z;
        }
        return true;
    }

    public static byte[] zzf(@NonNull File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (IOException unused) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] byteArray = zzejr.zzf(fileInputStream).toByteArray();
            k.a(fileInputStream);
            return byteArray;
        } catch (IOException unused2) {
            k.a(fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            k.a(fileInputStream2);
            throw th;
        }
    }

    public static boolean zza(@NonNull File file, @NonNull byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                k.a(fileOutputStream2);
                return true;
            } catch (IOException unused) {
                fileOutputStream = fileOutputStream2;
                k.a(fileOutputStream);
                return false;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                k.a(fileOutputStream);
                throw th;
            }
        } catch (IOException unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static File zza(String str, @NonNull File file) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return zza(new File(file, str), false);
    }

    public static File zza(@NonNull File file, boolean z) {
        if (z && file.exists() && !file.isDirectory()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
