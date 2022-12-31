package com.tapjoy.internal;
/* loaded from: classes3.dex */
public final class ap {

    /* loaded from: classes3.dex */
    public static final class a implements as {
        private final aq a;

        public a(aq aqVar) {
            this.a = aqVar;
        }

        @Override // com.tapjoy.internal.an
        public final Object a(Object obj) {
            ao a;
            Object a2;
            synchronized (this.a) {
                a = this.a.a(obj, false);
            }
            if (a != null) {
                synchronized (a) {
                    a2 = a.a();
                }
                return a2;
            }
            return null;
        }

        @Override // com.tapjoy.internal.an
        public final void a(Object obj, Object obj2) {
            ao a;
            synchronized (this.a) {
                a = this.a.a(obj, true);
            }
            synchronized (a) {
                a.a(obj2);
            }
        }
    }
}
