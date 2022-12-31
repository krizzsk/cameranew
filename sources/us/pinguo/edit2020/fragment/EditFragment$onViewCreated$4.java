package us.pinguo.edit2020.fragment;

import android.os.Handler;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.MagnifierLayout;
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
final class EditFragment$onViewCreated$4 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$onViewCreated$4(EditFragment editFragment) {
        super(1);
        this.this$0 = editFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m97invoke$lambda2(EditFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        final MagnifierLayout magnifierLayout = (MagnifierLayout) this$0._$_findCachedViewById(R.id.flMagnifier);
        if (magnifierLayout.getVisibility() != 0) {
            magnifierLayout.setAlpha(0.0f);
            magnifierLayout.animate().alpha(1.0f).setDuration(200L).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.fragment.h0
                @Override // java.lang.Runnable
                public final void run() {
                    EditFragment$onViewCreated$4.m98invoke$lambda2$lambda1$lambda0(MagnifierLayout.this);
                }
            }).start();
            magnifierLayout.setVisibility(0);
            VdsAgent.onSetViewVisibility(magnifierLayout, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final void m98invoke$lambda2$lambda1$lambda0(MagnifierLayout magnifierLayout) {
        magnifierLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(magnifierLayout, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-5  reason: not valid java name */
    public static final void m99invoke$lambda5(EditFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        final MagnifierLayout magnifierLayout = (MagnifierLayout) this$0._$_findCachedViewById(R.id.flMagnifier);
        if (magnifierLayout.getVisibility() == 0) {
            magnifierLayout.animate().alpha(0.0f).setDuration(200L).withEndAction(new Runnable() { // from class: us.pinguo.edit2020.fragment.i0
                @Override // java.lang.Runnable
                public final void run() {
                    EditFragment$onViewCreated$4.m100invoke$lambda5$lambda4$lambda3(MagnifierLayout.this);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-5$lambda-4$lambda-3  reason: not valid java name */
    public static final void m100invoke$lambda5$lambda4$lambda3(MagnifierLayout magnifierLayout) {
        magnifierLayout.setVisibility(4);
        VdsAgent.onSetViewVisibility(magnifierLayout, 4);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        Handler handler;
        Handler handler2;
        if (!z || !((MagnifierLayout) this.this$0._$_findCachedViewById(R.id.flMagnifier)).b()) {
            handler = this.this$0.m;
            final EditFragment editFragment = this.this$0;
            handler.post(new Runnable() { // from class: us.pinguo.edit2020.fragment.j0
                @Override // java.lang.Runnable
                public final void run() {
                    EditFragment$onViewCreated$4.m99invoke$lambda5(EditFragment.this);
                }
            });
            return;
        }
        handler2 = this.this$0.m;
        final EditFragment editFragment2 = this.this$0;
        handler2.post(new Runnable() { // from class: us.pinguo.edit2020.fragment.g0
            @Override // java.lang.Runnable
            public final void run() {
                EditFragment$onViewCreated$4.m97invoke$lambda2(EditFragment.this);
            }
        });
    }
}
