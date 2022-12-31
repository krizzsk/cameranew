package com.google.android.play.core.internal;

import android.content.ComponentName;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes2.dex */
public final class t0 {
    public static <T> s0<T> a(Object obj, String str, Class<T> cls) {
        return new s0<>(obj, f(obj, str), cls);
    }

    public static <R, P0> R b(Class cls, Class<R> cls2, Class<P0> cls3, P0 p0) {
        try {
            return cls2.cast(g(cls, "isDexOptNeeded", cls3).invoke(null, p0));
        } catch (Exception e2) {
            throw new br(String.format("Failed to invoke static method %s on type %s", "isDexOptNeeded", cls), e2);
        }
    }

    public static <R, P0, P1> R c(Class cls, Class<R> cls2, Class<P0> cls3, P0 p0, Class<P1> cls4, P1 p1) {
        try {
            return cls2.cast(g(cls, "optimizedPathFor", cls3, cls4).invoke(null, p0, p1));
        } catch (Exception e2) {
            throw new br(String.format("Failed to invoke static method %s on type %s", "optimizedPathFor", cls), e2);
        }
    }

    public static <R, P0> R d(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0) {
        try {
            return cls.cast(h(obj, str, cls2).invoke(obj, p0));
        } catch (Exception e2) {
            throw new br(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e2);
        }
    }

    public static <R, P0, P1, P2> R e(Object obj, String str, Class<R> cls, Class<P0> cls2, P0 p0, Class<P1> cls3, P1 p1, Class<P2> cls4, P2 p2) {
        try {
            return cls.cast(h(obj, str, cls2, cls3, cls4).invoke(obj, p0, p1, p2));
        } catch (Exception e2) {
            throw new br(String.format("Failed to invoke method %s on an object of type %s", str, obj.getClass()), e2);
        }
    }

    private static Field f(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new br(String.format("Failed to find a field named %s on an object of instance %s", str, obj.getClass().getName()));
    }

    private static Method g(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new br(String.format("Could not find a method named %s with parameters %s in type %s", str, Arrays.asList(clsArr), cls));
    }

    private static Method h(Object obj, String str, Class<?>... clsArr) {
        return g(obj.getClass(), str, clsArr);
    }

    public static void i(PackageManager packageManager, ComponentName componentName, int i2) {
        ComponentInfo componentInfo;
        int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
        if (componentEnabledSetting != 1) {
            if (componentEnabledSetting != 2) {
                String packageName = componentName.getPackageName();
                String className = componentName.getClassName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, i2 | 512);
                    ComponentInfo[][] componentInfoArr = {packageInfo.activities, packageInfo.services, packageInfo.providers};
                    int i3 = 0;
                    loop0: while (true) {
                        if (i3 >= 3) {
                            componentInfo = null;
                            break;
                        }
                        ComponentInfo[] componentInfoArr2 = componentInfoArr[i3];
                        if (componentInfoArr2 != null) {
                            int length = componentInfoArr2.length;
                            for (int i4 = 0; i4 < length; i4++) {
                                componentInfo = componentInfoArr2[i4];
                                if (componentInfo.name.equals(className)) {
                                    break loop0;
                                }
                            }
                            continue;
                        }
                        i3++;
                    }
                    if (componentInfo != null) {
                        if (componentInfo.isEnabled()) {
                            return;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    public static void j(b1 b1Var, InputStream inputStream, OutputStream outputStream, long j2) throws IOException {
        byte[] bArr = new byte[16384];
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream, 4096));
        int readInt = dataInputStream.readInt();
        if (readInt != -771763713) {
            String valueOf = String.valueOf(String.format("%x", Integer.valueOf(readInt)));
            throw new bz(valueOf.length() != 0 ? "Unexpected magic=".concat(valueOf) : new String("Unexpected magic="));
        }
        int read = dataInputStream.read();
        if (read != 4) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Unexpected version=");
            sb.append(read);
            throw new bz(sb.toString());
        }
        long j3 = 0;
        while (true) {
            long j4 = j2 - j3;
            try {
                int read2 = dataInputStream.read();
                if (read2 == -1) {
                    throw new IOException("Patch file overrun");
                }
                if (read2 == 0) {
                    return;
                }
                switch (read2) {
                    case 247:
                        read2 = dataInputStream.readUnsignedShort();
                        n(bArr, dataInputStream, outputStream, read2, j4);
                        break;
                    case 248:
                        read2 = dataInputStream.readInt();
                        n(bArr, dataInputStream, outputStream, read2, j4);
                        break;
                    case 249:
                        long readUnsignedShort = dataInputStream.readUnsignedShort();
                        read2 = dataInputStream.read();
                        if (read2 == -1) {
                            throw new IOException("Unexpected end of patch");
                        }
                        m(bArr, b1Var, outputStream, readUnsignedShort, read2, j4);
                        break;
                    case ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                        read2 = dataInputStream.readUnsignedShort();
                        m(bArr, b1Var, outputStream, dataInputStream.readUnsignedShort(), read2, j4);
                        break;
                    case 251:
                        read2 = dataInputStream.readInt();
                        m(bArr, b1Var, outputStream, dataInputStream.readUnsignedShort(), read2, j4);
                        break;
                    case 252:
                        long readInt2 = dataInputStream.readInt();
                        read2 = dataInputStream.read();
                        if (read2 == -1) {
                            throw new IOException("Unexpected end of patch");
                        }
                        m(bArr, b1Var, outputStream, readInt2, read2, j4);
                        break;
                    case 253:
                        read2 = dataInputStream.readUnsignedShort();
                        m(bArr, b1Var, outputStream, dataInputStream.readInt(), read2, j4);
                        break;
                    case 254:
                        read2 = dataInputStream.readInt();
                        m(bArr, b1Var, outputStream, dataInputStream.readInt(), read2, j4);
                        break;
                    case 255:
                        long readLong = dataInputStream.readLong();
                        read2 = dataInputStream.readInt();
                        m(bArr, b1Var, outputStream, readLong, read2, j4);
                        break;
                    default:
                        n(bArr, dataInputStream, outputStream, read2, j4);
                        break;
                }
                j3 += read2;
            } finally {
                outputStream.flush();
            }
        }
    }

    public static <T> void k(T t) {
        Objects.requireNonNull(t);
    }

    public static <T> void l(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }

    private static void m(byte[] bArr, b1 b1Var, OutputStream outputStream, long j2, int i2, long j3) throws IOException {
        int i3 = i2;
        if (i3 < 0) {
            throw new IOException("copyLength negative");
        }
        if (j2 < 0) {
            throw new IOException("inputOffset negative");
        }
        long j4 = i3;
        if (j4 > j3) {
            throw new IOException("Output length overrun");
        }
        try {
            InputStream t = new c1(b1Var, j2, j4).t();
            while (i3 > 0) {
                int min = Math.min(i3, 16384);
                int i4 = 0;
                while (i4 < min) {
                    int read = t.read(bArr, i4, min - i4);
                    if (read == -1) {
                        throw new IOException("truncated input stream");
                    }
                    i4 += read;
                }
                outputStream.write(bArr, 0, min);
                i3 -= min;
            }
            if (t != null) {
                t.close();
            }
        } catch (EOFException e2) {
            throw new IOException("patch underrun", e2);
        }
    }

    private static void n(byte[] bArr, DataInputStream dataInputStream, OutputStream outputStream, int i2, long j2) throws IOException {
        if (i2 < 0) {
            throw new IOException("copyLength negative");
        }
        if (i2 > j2) {
            throw new IOException("Output length overrun");
        }
        while (i2 > 0) {
            try {
                int min = Math.min(i2, 16384);
                dataInputStream.readFully(bArr, 0, min);
                outputStream.write(bArr, 0, min);
                i2 -= min;
            } catch (EOFException unused) {
                throw new IOException("patch underrun");
            }
        }
    }

    public static <T> s0 o(Object obj, String str, Class<T> cls) {
        return new s0(obj, f(obj, str), cls, null);
    }

    public static <T> void p(T t) {
        Objects.requireNonNull(t, "Cannot return null from a non-@Nullable @Provides method");
    }
}
