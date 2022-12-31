package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.o0;
/* compiled from: ArrayChannel.kt */
/* loaded from: classes3.dex */
public class c<E> extends AbstractChannel<E> {

    /* renamed from: d  reason: collision with root package name */
    private final int f8720d;

    /* renamed from: e  reason: collision with root package name */
    private final BufferOverflow f8721e;

    /* renamed from: f  reason: collision with root package name */
    private final ReentrantLock f8722f;

    /* renamed from: g  reason: collision with root package name */
    private Object[] f8723g;

    /* renamed from: h  reason: collision with root package name */
    private int f8724h;
    private volatile /* synthetic */ int size;

    /* compiled from: ArrayChannel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            a = iArr;
        }
    }

    public c(int i2, BufferOverflow bufferOverflow, kotlin.jvm.b.l<? super E, kotlin.u> lVar) {
        super(lVar);
        this.f8720d = i2;
        this.f8721e = bufferOverflow;
        if (i2 >= 1) {
            this.f8722f = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i2, 8)];
            kotlin.collections.m.j(objArr, kotlinx.coroutines.channels.a.a, 0, 0, 6, null);
            kotlin.u uVar = kotlin.u.a;
            this.f8723g = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i2 + " was specified").toString());
    }

    private final void e0(int i2, E e2) {
        if (i2 < this.f8720d) {
            f0(i2);
            Object[] objArr = this.f8723g;
            objArr[(this.f8724h + i2) % objArr.length] = e2;
            return;
        }
        if (o0.a()) {
            if (!(this.f8721e == BufferOverflow.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.f8723g;
        int i3 = this.f8724h;
        objArr2[i3 % objArr2.length] = null;
        objArr2[(i2 + i3) % objArr2.length] = e2;
        this.f8724h = (i3 + 1) % objArr2.length;
    }

    private final void f0(int i2) {
        Object[] objArr = this.f8723g;
        if (i2 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f8720d);
            Object[] objArr2 = new Object[min];
            if (i2 > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    Object[] objArr3 = this.f8723g;
                    objArr2[i3] = objArr3[(this.f8724h + i3) % objArr3.length];
                    if (i4 >= i2) {
                        break;
                    }
                    i3 = i4;
                }
            }
            kotlin.collections.m.i(objArr2, kotlinx.coroutines.channels.a.a, i2, min);
            this.f8723g = objArr2;
            this.f8724h = 0;
        }
    }

    private final c0 g0(int i2) {
        if (i2 < this.f8720d) {
            this.size = i2 + 1;
            return null;
        }
        int i3 = a.a[this.f8721e.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return kotlinx.coroutines.channels.a.b;
        }
        return kotlinx.coroutines.channels.a.c;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected boolean O(o<? super E> oVar) {
        ReentrantLock reentrantLock = this.f8722f;
        reentrantLock.lock();
        try {
            return super.O(oVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean Q() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean R() {
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean S() {
        ReentrantLock reentrantLock = this.f8722f;
        reentrantLock.lock();
        try {
            return super.S();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected void U(boolean z) {
        kotlin.jvm.b.l<E, kotlin.u> lVar = this.a;
        ReentrantLock reentrantLock = this.f8722f;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = this.f8723g[this.f8724h];
                if (lVar != null && obj != kotlinx.coroutines.channels.a.a) {
                    undeliveredElementException = OnUndeliveredElementKt.c(lVar, obj, undeliveredElementException);
                }
                Object[] objArr = this.f8723g;
                int i4 = this.f8724h;
                objArr[i4] = kotlinx.coroutines.channels.a.a;
                this.f8724h = (i4 + 1) % objArr.length;
            }
            this.size = 0;
            kotlin.u uVar = kotlin.u.a;
            reentrantLock.unlock();
            super.U(z);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object Y() {
        ReentrantLock reentrantLock = this.f8722f;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                Object i3 = i();
                if (i3 == null) {
                    i3 = kotlinx.coroutines.channels.a.f8715d;
                }
                return i3;
            }
            Object[] objArr = this.f8723g;
            int i4 = this.f8724h;
            Object obj = objArr[i4];
            r rVar = null;
            objArr[i4] = null;
            this.size = i2 - 1;
            Object obj2 = kotlinx.coroutines.channels.a.f8715d;
            if (i2 == this.f8720d) {
                r rVar2 = null;
                while (true) {
                    r H = H();
                    if (H == null) {
                        rVar = rVar2;
                        break;
                    }
                    c0 T = H.T(null);
                    if (T != null) {
                        if (o0.a()) {
                            if (!(T == kotlinx.coroutines.r.a)) {
                                throw new AssertionError();
                            }
                        }
                        obj2 = H.R();
                        rVar = H;
                        r6 = true;
                    } else {
                        H.U();
                        rVar2 = H;
                    }
                }
            }
            if (obj2 != kotlinx.coroutines.channels.a.f8715d && !(obj2 instanceof j)) {
                this.size = i2;
                Object[] objArr2 = this.f8723g;
                objArr2[(this.f8724h + i2) % objArr2.length] = obj2;
            }
            this.f8724h = (this.f8724h + 1) % this.f8723g.length;
            kotlin.u uVar = kotlin.u.a;
            if (r6) {
                kotlin.jvm.internal.s.e(rVar);
                rVar.Q();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0091 A[Catch: all -> 0x00ba, TRY_LEAVE, TryCatch #0 {all -> 0x00ba, blocks: (B:3:0x0005, B:5:0x0009, B:7:0x000f, B:10:0x0015, B:12:0x0029, B:14:0x0033, B:33:0x0077, B:35:0x007b, B:37:0x007f, B:43:0x00a1, B:38:0x008b, B:40:0x0091, B:16:0x0043, B:19:0x0048, B:22:0x004d, B:24:0x0053, B:27:0x005f, B:30:0x0066, B:31:0x0075), top: B:51:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b1  */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object Z(kotlinx.coroutines.selects.f<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.f8722f
            r0.lock()
            int r1 = r8.size     // Catch: java.lang.Throwable -> Lba
            if (r1 != 0) goto L15
            kotlinx.coroutines.channels.j r9 = r8.i()     // Catch: java.lang.Throwable -> Lba
            if (r9 != 0) goto L11
            kotlinx.coroutines.internal.c0 r9 = kotlinx.coroutines.channels.a.f8715d     // Catch: java.lang.Throwable -> Lba
        L11:
            r0.unlock()
            return r9
        L15:
            java.lang.Object[] r2 = r8.f8723g     // Catch: java.lang.Throwable -> Lba
            int r3 = r8.f8724h     // Catch: java.lang.Throwable -> Lba
            r4 = r2[r3]     // Catch: java.lang.Throwable -> Lba
            r5 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> Lba
            int r2 = r1 + (-1)
            r8.size = r2     // Catch: java.lang.Throwable -> Lba
            kotlinx.coroutines.internal.c0 r2 = kotlinx.coroutines.channels.a.f8715d     // Catch: java.lang.Throwable -> Lba
            int r3 = r8.f8720d     // Catch: java.lang.Throwable -> Lba
            r6 = 1
            if (r1 != r3) goto L76
        L29:
            kotlinx.coroutines.channels.AbstractChannel$g r3 = r8.M()     // Catch: java.lang.Throwable -> Lba
            java.lang.Object r7 = r9.q(r3)     // Catch: java.lang.Throwable -> Lba
            if (r7 != 0) goto L43
            java.lang.Object r5 = r3.o()     // Catch: java.lang.Throwable -> Lba
            kotlin.jvm.internal.s.e(r5)     // Catch: java.lang.Throwable -> Lba
            r2 = r5
            kotlinx.coroutines.channels.r r2 = (kotlinx.coroutines.channels.r) r2     // Catch: java.lang.Throwable -> Lba
            java.lang.Object r2 = r2.R()     // Catch: java.lang.Throwable -> Lba
        L41:
            r3 = 1
            goto L77
        L43:
            kotlinx.coroutines.internal.c0 r3 = kotlinx.coroutines.channels.a.f8715d     // Catch: java.lang.Throwable -> Lba
            if (r7 != r3) goto L48
            goto L76
        L48:
            java.lang.Object r3 = kotlinx.coroutines.internal.c.b     // Catch: java.lang.Throwable -> Lba
            if (r7 != r3) goto L4d
            goto L29
        L4d:
            java.lang.Object r2 = kotlinx.coroutines.selects.g.d()     // Catch: java.lang.Throwable -> Lba
            if (r7 != r2) goto L5f
            r8.size = r1     // Catch: java.lang.Throwable -> Lba
            java.lang.Object[] r9 = r8.f8723g     // Catch: java.lang.Throwable -> Lba
            int r1 = r8.f8724h     // Catch: java.lang.Throwable -> Lba
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lba
            r0.unlock()
            return r7
        L5f:
            boolean r2 = r7 instanceof kotlinx.coroutines.channels.j     // Catch: java.lang.Throwable -> Lba
            if (r2 == 0) goto L66
            r2 = r7
            r5 = r2
            goto L41
        L66:
            java.lang.String r9 = "performAtomicTrySelect(describeTryOffer) returned "
            java.lang.String r9 = kotlin.jvm.internal.s.q(r9, r7)     // Catch: java.lang.Throwable -> Lba
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lba
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lba
            r1.<init>(r9)     // Catch: java.lang.Throwable -> Lba
            throw r1     // Catch: java.lang.Throwable -> Lba
        L76:
            r3 = 0
        L77:
            kotlinx.coroutines.internal.c0 r7 = kotlinx.coroutines.channels.a.f8715d     // Catch: java.lang.Throwable -> Lba
            if (r2 == r7) goto L8b
            boolean r7 = r2 instanceof kotlinx.coroutines.channels.j     // Catch: java.lang.Throwable -> Lba
            if (r7 != 0) goto L8b
            r8.size = r1     // Catch: java.lang.Throwable -> Lba
            java.lang.Object[] r9 = r8.f8723g     // Catch: java.lang.Throwable -> Lba
            int r7 = r8.f8724h     // Catch: java.lang.Throwable -> Lba
            int r7 = r7 + r1
            int r1 = r9.length     // Catch: java.lang.Throwable -> Lba
            int r7 = r7 % r1
            r9[r7] = r2     // Catch: java.lang.Throwable -> Lba
            goto La1
        L8b:
            boolean r9 = r9.n()     // Catch: java.lang.Throwable -> Lba
            if (r9 != 0) goto La1
            r8.size = r1     // Catch: java.lang.Throwable -> Lba
            java.lang.Object[] r9 = r8.f8723g     // Catch: java.lang.Throwable -> Lba
            int r1 = r8.f8724h     // Catch: java.lang.Throwable -> Lba
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lba
            java.lang.Object r9 = kotlinx.coroutines.selects.g.d()     // Catch: java.lang.Throwable -> Lba
            r0.unlock()
            return r9
        La1:
            int r9 = r8.f8724h     // Catch: java.lang.Throwable -> Lba
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.f8723g     // Catch: java.lang.Throwable -> Lba
            int r1 = r1.length     // Catch: java.lang.Throwable -> Lba
            int r9 = r9 % r1
            r8.f8724h = r9     // Catch: java.lang.Throwable -> Lba
            kotlin.u r9 = kotlin.u.a     // Catch: java.lang.Throwable -> Lba
            r0.unlock()
            if (r3 == 0) goto Lb9
            kotlin.jvm.internal.s.e(r5)
            kotlinx.coroutines.channels.r r5 = (kotlinx.coroutines.channels.r) r5
            r5.Q()
        Lb9:
            return r4
        Lba:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.c.Z(kotlinx.coroutines.selects.f):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.b
    protected Object e(r rVar) {
        ReentrantLock reentrantLock = this.f8722f;
        reentrantLock.lock();
        try {
            return super.e(rVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.b
    protected String g() {
        return "(buffer:capacity=" + this.f8720d + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean t() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.b
    protected final boolean u() {
        return this.size == this.f8720d && this.f8721e == BufferOverflow.SUSPEND;
    }

    @Override // kotlinx.coroutines.channels.b
    protected Object x(E e2) {
        p<E> G;
        c0 r;
        ReentrantLock reentrantLock = this.f8722f;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            j<?> i3 = i();
            if (i3 == null) {
                c0 g0 = g0(i2);
                if (g0 == null) {
                    if (i2 == 0) {
                        do {
                            G = G();
                            if (G != null) {
                                if (G instanceof j) {
                                    this.size = i2;
                                    return G;
                                }
                                r = G.r(e2, null);
                            }
                        } while (r == null);
                        if (o0.a()) {
                            if (!(r == kotlinx.coroutines.r.a)) {
                                throw new AssertionError();
                            }
                        }
                        this.size = i2;
                        kotlin.u uVar = kotlin.u.a;
                        reentrantLock.unlock();
                        G.i(e2);
                        return G.a();
                    }
                    e0(i2, e2);
                    return kotlinx.coroutines.channels.a.b;
                }
                return g0;
            }
            return i3;
        } finally {
            reentrantLock.unlock();
        }
    }
}
