package kotlinx.coroutines.flow;
/* compiled from: SharingStarted.kt */
/* loaded from: classes3.dex */
public interface e1 {
    public static final a a = a.a;

    /* compiled from: SharingStarted.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();
        private static final e1 b = new f1();
        private static final e1 c = new StartedLazily();

        private a() {
        }

        public final e1 a() {
            return b;
        }

        public final e1 b() {
            return c;
        }
    }

    c<SharingCommand> a(h1<Integer> h1Var);
}
