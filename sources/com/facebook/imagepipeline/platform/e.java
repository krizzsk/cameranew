package com.facebook.imagepipeline.platform;

import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.core.l;
import com.facebook.imagepipeline.memory.b0;
import com.facebook.imagepipeline.memory.p;
import java.lang.reflect.InvocationTargetException;
/* compiled from: PlatformDecoderFactory.java */
/* loaded from: classes.dex */
public class e {
    public static d a(b0 b0Var, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            int e2 = b0Var.e();
            return new c(b0Var.b(), e2, new Pools.SynchronizedPool(e2));
        } else if (i2 < 21 && l.a()) {
            try {
                return (!z || i2 >= 19) ? (d) Class.forName("com.facebook.imagepipeline.platform.KitKatPurgeableDecoder").getConstructor(p.class).newInstance(b0Var.d()) : (d) Class.forName("com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException("Wrong Native code setup, reflection failed.", e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Wrong Native code setup, reflection failed.", e4);
            } catch (InstantiationException e5) {
                throw new RuntimeException("Wrong Native code setup, reflection failed.", e5);
            } catch (NoSuchMethodException e6) {
                throw new RuntimeException("Wrong Native code setup, reflection failed.", e6);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Wrong Native code setup, reflection failed.", e7);
            }
        } else {
            int e8 = b0Var.e();
            return new a(b0Var.b(), e8, new Pools.SynchronizedPool(e8));
        }
    }
}
