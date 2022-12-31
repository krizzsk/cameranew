package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes3.dex */
public final class e implements kotlin.sequences.e<kotlin.z.d> {
    private final CharSequence a;
    private final int b;
    private final int c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.jvm.b.p<CharSequence, Integer, Pair<Integer, Integer>> f8683d;

    /* compiled from: Strings.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<kotlin.z.d>, kotlin.jvm.internal.z.a {
        private int a = -1;
        private int b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private kotlin.z.d f8684d;

        /* renamed from: e  reason: collision with root package name */
        private int f8685e;

        a() {
            int e2;
            e2 = kotlin.z.j.e(e.this.b, 0, e.this.a.length());
            this.b = e2;
            this.c = e2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r0 < r6.f8686f.c) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.a = r1
                r0 = 0
                r6.f8684d = r0
                goto L9e
            Lc:
                kotlin.text.e r0 = kotlin.text.e.this
                int r0 = kotlin.text.e.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f8685e
                int r0 = r0 + r3
                r6.f8685e = r0
                kotlin.text.e r4 = kotlin.text.e.this
                int r4 = kotlin.text.e.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.c
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                kotlin.z.d r0 = new kotlin.z.d
                int r1 = r6.b
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.J(r4)
                r0.<init>(r1, r4)
                r6.f8684d = r0
                r6.c = r2
                goto L9c
            L47:
                kotlin.text.e r0 = kotlin.text.e.this
                kotlin.jvm.b.p r0 = kotlin.text.e.a(r0)
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r5 = r6.c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L77
                kotlin.z.d r0 = new kotlin.z.d
                int r1 = r6.b
                kotlin.text.e r4 = kotlin.text.e.this
                java.lang.CharSequence r4 = kotlin.text.e.b(r4)
                int r4 = kotlin.text.StringsKt__StringsKt.J(r4)
                r0.<init>(r1, r4)
                r6.f8684d = r0
                r6.c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.component2()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.b
                kotlin.z.d r4 = kotlin.z.h.h(r4, r2)
                r6.f8684d = r4
                int r2 = r2 + r0
                r6.b = r2
                if (r0 != 0) goto L99
                r1 = 1
            L99:
                int r2 = r2 + r1
                r6.c = r2
            L9c:
                r6.a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.e.a.a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public kotlin.z.d next() {
            if (this.a == -1) {
                a();
            }
            if (this.a != 0) {
                kotlin.z.d dVar = this.f8684d;
                kotlin.jvm.internal.s.f(dVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f8684d = null;
                this.a = -1;
                return dVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.a == -1) {
                a();
            }
            return this.a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(CharSequence input, int i2, int i3, kotlin.jvm.b.p<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        kotlin.jvm.internal.s.h(input, "input");
        kotlin.jvm.internal.s.h(getNextMatch, "getNextMatch");
        this.a = input;
        this.b = i2;
        this.c = i3;
        this.f8683d = getNextMatch;
    }

    @Override // kotlin.sequences.e
    public Iterator<kotlin.z.d> iterator() {
        return new a();
    }
}
