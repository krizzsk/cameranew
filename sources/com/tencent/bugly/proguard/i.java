package com.tencent.bugly.proguard;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class i {
    private ByteBuffer a;
    private String b = "GBK";

    /* compiled from: BUGLY */
    /* loaded from: classes3.dex */
    public static class a {
        public byte a;
        public int b;
    }

    public i() {
    }

    private boolean[] d(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.a);
        if (aVar.a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                boolean[] zArr = new boolean[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    zArr[i3] = a((byte) 0, 0, true) != 0;
                }
                return zArr;
            }
            throw new g("size invalid: " + a2);
        }
        throw new g("type mismatch.");
    }

    private short[] e(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.a);
        if (aVar.a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                short[] sArr = new short[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    sArr[i3] = a(sArr[0], 0, true);
                }
                return sArr;
            }
            throw new g("size invalid: " + a2);
        }
        throw new g("type mismatch.");
    }

    private int[] f(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.a);
        if (aVar.a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                int[] iArr = new int[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    iArr[i3] = a(iArr[0], 0, true);
                }
                return iArr;
            }
            throw new g("size invalid: " + a2);
        }
        throw new g("type mismatch.");
    }

    private long[] g(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.a);
        if (aVar.a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                long[] jArr = new long[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    jArr[i3] = a(jArr[0], 0, true);
                }
                return jArr;
            }
            throw new g("size invalid: " + a2);
        }
        throw new g("type mismatch.");
    }

    private float[] h(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.a);
        if (aVar.a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                float[] fArr = new float[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    fArr[i3] = a(fArr[0], 0, true);
                }
                return fArr;
            }
            throw new g("size invalid: " + a2);
        }
        throw new g("type mismatch.");
    }

    private double[] i(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.a);
        if (aVar.a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                double[] dArr = new double[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    dArr[i3] = a(dArr[0], 0, true);
                }
                return dArr;
            }
            throw new g("size invalid: " + a2);
        }
        throw new g("type mismatch.");
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.a = ByteBuffer.wrap(bArr);
    }

    public final String b(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.a);
        byte b = aVar.a;
        if (b == 6) {
            int i3 = this.a.get();
            if (i3 < 0) {
                i3 += 256;
            }
            byte[] bArr = new byte[i3];
            this.a.get(bArr);
            try {
                return new String(bArr, this.b);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        } else if (b == 7) {
            int i4 = this.a.getInt();
            if (i4 <= 104857600 && i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                this.a.get(bArr2);
                try {
                    return new String(bArr2, this.b);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new g("String too long: " + i4);
        } else {
            throw new g("type mismatch.");
        }
    }

    public final byte[] c(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.a);
        byte b = aVar.a;
        if (b == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                byte[] bArr = new byte[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    bArr[i3] = a(bArr[0], 0, true);
                }
                return bArr;
            }
            throw new g("size invalid: " + a2);
        } else if (b == 13) {
            a aVar2 = new a();
            a(aVar2, this.a);
            if (aVar2.a == 0) {
                int a3 = a(0, 0, true);
                if (a3 >= 0) {
                    byte[] bArr2 = new byte[a3];
                    this.a.get(bArr2);
                    return bArr2;
                }
                throw new g("invalid size, tag: " + i2 + ", type: " + ((int) aVar.a) + ", " + ((int) aVar2.a) + ", size: " + a3);
            }
            throw new g("type mismatch, tag: " + i2 + ", type: " + ((int) aVar.a) + ", " + ((int) aVar2.a));
        } else {
            throw new g("type mismatch.");
        }
    }

    public i(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.a = (byte) (b & 15);
        int i2 = (b & 240) >> 4;
        aVar.b = i2;
        if (i2 == 15) {
            aVar.b = byteBuffer.get();
            return 2;
        }
        return 1;
    }

    public i(byte[] bArr, int i2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.a = wrap;
        wrap.position(4);
    }

    private boolean a(int i2) {
        int i3;
        try {
            a aVar = new a();
            while (true) {
                int a2 = a(aVar, this.a.duplicate());
                i3 = aVar.b;
                if (i2 <= i3 || aVar.a == 11) {
                    break;
                }
                ByteBuffer byteBuffer = this.a;
                byteBuffer.position(byteBuffer.position() + a2);
                a(aVar.a);
            }
        } catch (g | BufferUnderflowException unused) {
        }
        return i2 == i3;
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar, this.a);
            a(aVar.a);
        } while (aVar.a != 11);
    }

    private void a(byte b) {
        int i2 = 0;
        switch (b) {
            case 0:
                ByteBuffer byteBuffer = this.a;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                ByteBuffer byteBuffer2 = this.a;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                ByteBuffer byteBuffer3 = this.a;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                ByteBuffer byteBuffer4 = this.a;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                ByteBuffer byteBuffer5 = this.a;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                ByteBuffer byteBuffer6 = this.a;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                int i3 = this.a.get();
                if (i3 < 0) {
                    i3 += 256;
                }
                ByteBuffer byteBuffer7 = this.a;
                byteBuffer7.position(byteBuffer7.position() + i3);
                return;
            case 7:
                int i4 = this.a.getInt();
                ByteBuffer byteBuffer8 = this.a;
                byteBuffer8.position(byteBuffer8.position() + i4);
                return;
            case 8:
                int a2 = a(0, 0, true);
                while (i2 < (a2 << 1)) {
                    a aVar = new a();
                    a(aVar, this.a);
                    a(aVar.a);
                    i2++;
                }
                return;
            case 9:
                int a3 = a(0, 0, true);
                while (i2 < a3) {
                    a aVar2 = new a();
                    a(aVar2, this.a);
                    a(aVar2.a);
                    i2++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar3 = new a();
                a(aVar3, this.a);
                if (aVar3.a == 0) {
                    int a4 = a(0, 0, true);
                    ByteBuffer byteBuffer9 = this.a;
                    byteBuffer9.position(byteBuffer9.position() + a4);
                    return;
                }
                throw new g("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) aVar3.a));
            default:
                throw new g("invalid type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.a);
        if (aVar.a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
                for (int i3 = 0; i3 < a2; i3++) {
                    tArr[i3] = a((i) t, 0, true);
                }
                return tArr;
            }
            throw new g("size invalid: " + a2);
        }
        throw new g("type mismatch.");
    }

    public final boolean a(int i2, boolean z) {
        return a((byte) 0, i2, z) != 0;
    }

    public final byte a(byte b, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return b;
        }
        a aVar = new a();
        a(aVar, this.a);
        byte b2 = aVar.a;
        if (b2 != 0) {
            if (b2 == 12) {
                return (byte) 0;
            }
            throw new g("type mismatch.");
        }
        return this.a.get();
    }

    public final short a(short s, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        a(aVar, this.a);
        byte b = aVar.a;
        if (b != 0) {
            if (b != 1) {
                if (b == 12) {
                    return (short) 0;
                }
                throw new g("type mismatch.");
            }
            return this.a.getShort();
        }
        return this.a.get();
    }

    public final int a(int i2, int i3, boolean z) {
        if (!a(i3)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return i2;
        }
        a aVar = new a();
        a(aVar, this.a);
        byte b = aVar.a;
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b == 12) {
                        return 0;
                    }
                    throw new g("type mismatch.");
                }
                return this.a.getInt();
            }
            return this.a.getShort();
        }
        return this.a.get();
    }

    public final long a(long j2, int i2, boolean z) {
        int i3;
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return j2;
        }
        a aVar = new a();
        a(aVar, this.a);
        byte b = aVar.a;
        if (b == 0) {
            i3 = this.a.get();
        } else if (b == 1) {
            i3 = this.a.getShort();
        } else if (b != 2) {
            if (b != 3) {
                if (b == 12) {
                    return 0L;
                }
                throw new g("type mismatch.");
            }
            return this.a.getLong();
        } else {
            i3 = this.a.getInt();
        }
        return i3;
    }

    private float a(float f2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return f2;
        }
        a aVar = new a();
        a(aVar, this.a);
        byte b = aVar.a;
        if (b != 4) {
            if (b == 12) {
                return 0.0f;
            }
            throw new g("type mismatch.");
        }
        return this.a.getFloat();
    }

    private double a(double d2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return d2;
        }
        a aVar = new a();
        a(aVar, this.a);
        byte b = aVar.a;
        if (b != 4) {
            if (b != 5) {
                if (b == 12) {
                    return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                }
                throw new g("type mismatch.");
            }
            return this.a.getDouble();
        }
        return this.a.getFloat();
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i2, boolean z) {
        return (HashMap) a(new HashMap(), map, i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i2, boolean z) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (a(i2)) {
                a aVar = new a();
                a(aVar, this.a);
                if (aVar.a == 8) {
                    int a2 = a(0, 0, true);
                    if (a2 < 0) {
                        throw new g("size invalid: " + a2);
                    }
                    for (int i3 = 0; i3 < a2; i3++) {
                        map.put(a((i) key, 0, true), a((i) value, 1, true));
                    }
                } else {
                    throw new g("type mismatch.");
                }
            } else if (z) {
                throw new g("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    private <T> T[] a(T[] tArr, int i2, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i2, z);
        }
        throw new g("unable to get type of key and value.");
    }

    public final k a(k kVar, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new g("require field not exist.");
            }
            return null;
        }
        try {
            k kVar2 = (k) kVar.getClass().newInstance();
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a == 10) {
                kVar2.a(this);
                a();
                return kVar2;
            }
            throw new g("type mismatch.");
        } catch (Exception e2) {
            throw new g(e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t, int i2, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i2, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a((byte) 0, i2, z) != 0);
        } else if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i2, z));
        } else {
            if (t instanceof Integer) {
                return Integer.valueOf(a(0, i2, z));
            }
            if (t instanceof Long) {
                return Long.valueOf(a(0L, i2, z));
            }
            if (t instanceof Float) {
                return Float.valueOf(a(0.0f, i2, z));
            }
            if (t instanceof Double) {
                return Double.valueOf(a((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, i2, z));
            }
            if (t instanceof String) {
                return String.valueOf(b(i2, z));
            }
            if (t instanceof Map) {
                return (HashMap) a(new HashMap(), (Map) t, i2, z);
            } else if (t instanceof List) {
                List list = (List) t;
                if (list == null || list.isEmpty()) {
                    return new ArrayList();
                }
                Object[] b = b(list.get(0), i2, z);
                if (b == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : b) {
                    arrayList.add(obj);
                }
                return arrayList;
            } else if (t instanceof k) {
                return a((k) t, i2, z);
            } else {
                if (t.getClass().isArray()) {
                    if (!(t instanceof byte[]) && !(t instanceof Byte[])) {
                        if (t instanceof boolean[]) {
                            return d(i2, z);
                        }
                        if (t instanceof short[]) {
                            return e(i2, z);
                        }
                        if (t instanceof int[]) {
                            return f(i2, z);
                        }
                        if (t instanceof long[]) {
                            return g(i2, z);
                        }
                        if (t instanceof float[]) {
                            return h(i2, z);
                        }
                        if (t instanceof double[]) {
                            return i(i2, z);
                        }
                        return a((Object[]) t, i2, z);
                    }
                    return c(i2, z);
                }
                throw new g("read object error: unsupport type.");
            }
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
