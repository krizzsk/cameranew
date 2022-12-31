package us.pinguo.memorytest;
/* loaded from: classes5.dex */
public class MemoryTest {
    static {
        System.loadLibrary("MemoryTest");
    }

    public static native boolean kgslAlloc(int i2);

    public static native boolean kgslAlloc2(int i2);

    public static native boolean mallocTest(int i2);

    public static native boolean mmapTest(int i2);
}
