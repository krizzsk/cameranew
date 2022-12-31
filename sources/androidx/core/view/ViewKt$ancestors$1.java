package androidx.core.view;

import android.view.ViewParent;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.s;
/* compiled from: View.kt */
/* loaded from: classes.dex */
/* synthetic */ class ViewKt$ancestors$1 extends FunctionReferenceImpl implements l<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // kotlin.jvm.b.l
    public final ViewParent invoke(ViewParent p0) {
        s.h(p0, "p0");
        return p0.getParent();
    }
}
