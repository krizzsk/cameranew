package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
/* renamed from: com.facebook.ads.redexgen.X.La  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0986La implements InvocationHandler {
    public static byte[] A03;
    public final /* synthetic */ int A00;
    public final /* synthetic */ C8J A01;
    public final /* synthetic */ LinkedBlockingQueue A02;

    static {
        A01();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A03, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] - i4) - 63);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{16, 14, 23, 14, 27, 18, 12, 21, 19, 34, 1, 30, 26, 23, 34, -4, 15, 27, 19, 29, 27, 42, 10, 47, 38, 27, -75, -77, -62, -92, -81, -70, -61, -77, 40, 39, -4, 33, 30, 28, 36, 44, 46, 38, 44, 11, 30, 26, 29, 50};
    }

    public C0986La(int i2, LinkedBlockingQueue linkedBlockingQueue, C8J c8j) {
        this.A00 = i2;
        this.A02 = linkedBlockingQueue;
        this.A01 = c8j;
    }

    @Override // java.lang.reflect.InvocationHandler
    @Nullable
    @SuppressLint({"CatchGeneralException"})
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            if (method.getName().equals(A00(34, 16, 122)) && objArr.length == 1 && (objArr[0] instanceof List)) {
                for (Object obj2 : (List) objArr[0]) {
                    String str = (String) obj2.getClass().getMethod(A00(7, 12, 111), new Class[0]).invoke(obj2, new Object[0]);
                    Method getTypeMethod = obj2.getClass().getMethod(A00(19, 7, 119), new Class[0]);
                    int intValue = ((Integer) getTypeMethod.invoke(obj2, new Object[0])).intValue();
                    if (str == null) {
                        int type = this.A00;
                        if (intValue == type) {
                            Method getTypeMethod2 = obj2.getClass().getMethod(A00(26, 8, 15), new Class[0]);
                            this.A02.put((byte[]) getTypeMethod2.invoke(obj2, new Object[0]));
                            return null;
                        }
                    }
                }
                this.A02.put(null);
            }
        } catch (Throwable th) {
            this.A01.A06().A8q(A00(0, 7, 106), C06808m.A15, new C06818n(th));
        }
        return null;
    }
}
