package com.facebook.imagepipeline.nativecode;

import java.lang.reflect.InvocationTargetException;
/* compiled from: NativeImageTranscoderFactory.java */
/* loaded from: classes.dex */
public final class c {
    public static com.facebook.imagepipeline.g.d a(int i2, boolean z, boolean z2) {
        try {
            Class<?> cls = Class.forName("com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory");
            Class<?> cls2 = Boolean.TYPE;
            return (com.facebook.imagepipeline.g.d) cls.getConstructor(Integer.TYPE, cls2, cls2).newInstance(Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e2);
        }
    }
}
