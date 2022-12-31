package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public /* synthetic */ class EditFragment$initFilter$1 extends FunctionReferenceImpl implements kotlin.jvm.b.l<String, kotlin.u> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EditFragment$initFilter$1(Object obj) {
        super(1, obj, EditFragment.class, "onStoreMoreClick", "onStoreMoreClick(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str) {
        invoke2(str);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        ((EditFragment) this.receiver).n2(str);
    }
}
