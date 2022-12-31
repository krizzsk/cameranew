package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.StringResourceValueReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public final class x6 {
    @Deprecated
    public static String a(Context context, String str) {
        try {
            return new StringResourceValueReader(context).a("google_app_id");
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static String b(Context context, String str, String str2) {
        com.google.android.gms.common.internal.q.j(context);
        Resources resources = context.getResources();
        if (TextUtils.isEmpty(str2)) {
            str2 = h4.a(context);
        }
        return h4.b("google_app_id", resources, str2);
    }

    public static Object c(Object obj) {
        Throwable th;
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;
        try {
            if (obj != null) {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream.writeObject(obj);
                        objectOutputStream.flush();
                        objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                        try {
                            Object readObject = objectInputStream.readObject();
                            objectOutputStream.close();
                            objectInputStream.close();
                            return readObject;
                        } catch (Throwable th2) {
                            th = th2;
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            if (objectInputStream != null) {
                                objectInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        objectInputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    objectInputStream = null;
                    objectOutputStream = null;
                }
            }
        } catch (IOException | ClassNotFoundException unused) {
        }
        return null;
    }

    public static String d(String str, String[] strArr, String[] strArr2) {
        com.google.android.gms.common.internal.q.j(strArr);
        com.google.android.gms.common.internal.q.j(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i2 = 0; i2 < min; i2++) {
            String str2 = strArr[i2];
            if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
                return strArr2[i2];
            }
        }
        return null;
    }
}
