package kotlinx.coroutines.flow;
/* compiled from: SharingStarted.kt */
/* loaded from: classes3.dex */
final class StartedLazily implements e1 {
    @Override // kotlinx.coroutines.flow.e1
    public c<SharingCommand> a(h1<Integer> h1Var) {
        return e.s(new StartedLazily$command$1(h1Var, null));
    }

    public String toString() {
        return "SharingStarted.Lazily";
    }
}
