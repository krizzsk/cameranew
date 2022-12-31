package us.pinguo.edit2020.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
final class EditFragment$onViewCreated$3$4 extends Lambda implements kotlin.jvm.b.l<Bitmap, kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$onViewCreated$3$4(EditFragment editFragment) {
        super(1);
        this.this$0 = editFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m93invoke$lambda0(EditFragment this$0, Bitmap it) {
        us.pinguo.edit2020.view.c0 c0Var;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "$it");
        us.pinguo.common.log.a.c("exitEditMode", new Object[0]);
        ImageView imageView = (ImageView) this$0._$_findCachedViewById(R.id.imageMask);
        if (imageView != null) {
            imageView.setImageBitmap(it);
        }
        this$0.i1();
        c0Var = this$0.f10516l;
        if (c0Var != null) {
            c0Var.k();
        } else {
            kotlin.jvm.internal.s.z("operationController");
            throw null;
        }
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final Bitmap it) {
        Handler handler;
        kotlin.jvm.internal.s.h(it, "it");
        handler = this.this$0.m;
        final EditFragment editFragment = this.this$0;
        handler.post(new Runnable() { // from class: us.pinguo.edit2020.fragment.c0
            @Override // java.lang.Runnable
            public final void run() {
                EditFragment$onViewCreated$3$4.m93invoke$lambda0(EditFragment.this, it);
            }
        });
    }
}
