package kotlin.internal.e;

import kotlin.random.Random;
/* compiled from: JDK8PlatformImplementations.kt */
/* loaded from: classes3.dex */
public class a extends kotlin.internal.d.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JDK8PlatformImplementations.kt */
    /* renamed from: kotlin.internal.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0318a {
        public static final Integer a;

        /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
        static {
            /*
                r0 = 0
                java.lang.String r1 = "android.os.Build$VERSION"
                java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L18
                java.lang.String r2 = "SDK_INT"
                java.lang.reflect.Field r1 = r1.getField(r2)     // Catch: java.lang.Throwable -> L18
                java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Throwable -> L18
                boolean r2 = r1 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> L18
                if (r2 == 0) goto L18
                java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L18
                goto L19
            L18:
                r1 = r0
            L19:
                if (r1 == 0) goto L27
                int r2 = r1.intValue()
                if (r2 <= 0) goto L23
                r2 = 1
                goto L24
            L23:
                r2 = 0
            L24:
                if (r2 == 0) goto L27
                r0 = r1
            L27:
                kotlin.internal.e.a.C0318a.a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.e.a.C0318a.<clinit>():void");
        }
    }

    private final boolean c(int i2) {
        Integer num = C0318a.a;
        return num == null || num.intValue() >= i2;
    }

    @Override // kotlin.internal.a
    public Random b() {
        return c(24) ? new kotlin.random.e.a() : super.b();
    }
}
