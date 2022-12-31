package androidx.constraintlayout.core.state;
/* compiled from: lambda */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Interpolator {
    public static final /* synthetic */ d a = new d();

    private /* synthetic */ d() {
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public final float getInterpolation(float f2) {
        return Transition.c(f2);
    }
}
