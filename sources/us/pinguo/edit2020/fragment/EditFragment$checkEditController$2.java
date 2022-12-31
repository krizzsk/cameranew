package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public /* synthetic */ class EditFragment$checkEditController$2 extends FunctionReferenceImpl implements kotlin.jvm.b.p<Float, Float, kotlin.u> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EditFragment$checkEditController$2(Object obj) {
        super(2, obj, EditFragment.class, "enterEditMode", "enterEditMode(Ljava/lang/Float;Ljava/lang/Float;)V", 0);
    }

    @Override // kotlin.jvm.b.p
    public /* bridge */ /* synthetic */ kotlin.u invoke(Float f2, Float f3) {
        invoke2(f2, f3);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Float f2, Float f3) {
        ((EditFragment) this.receiver).f1(f2, f3);
    }
}
