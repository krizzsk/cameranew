package us.pinguo.common.filter.guide;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.common.EventType;
import us.pinguo.common.g;
/* compiled from: FilterGuideControl.kt */
/* loaded from: classes4.dex */
public final class c implements g {
    private final Activity a;
    private boolean b;
    private FilterGuideView c;

    /* renamed from: d  reason: collision with root package name */
    private kotlin.jvm.b.a<u> f9874d;

    public c(Activity activity) {
        s.h(activity, "activity");
        this.a = activity;
    }

    private final void e(View view, f fVar) {
        if (this.a.isFinishing()) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) this.a.getWindow().getDecorView();
        FilterGuideView filterGuideView = new FilterGuideView(this.a, null, 0, 6, null);
        filterGuideView.f(viewGroup, view, fVar);
        filterGuideView.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.filter.guide.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.f(c.this, view2);
            }
        });
        viewGroup.addView(filterGuideView, new ViewGroup.LayoutParams(-1, -1));
        filterGuideView.setAlpha(0.0f);
        filterGuideView.setVisibility(0);
        VdsAgent.onSetViewVisibility(filterGuideView, 0);
        filterGuideView.animate().alpha(1.0f).setDuration(250L).start();
        this.c = filterGuideView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        kotlin.jvm.b.a<u> aVar = this$0.f9874d;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    @Override // us.pinguo.common.g
    public boolean E(us.pinguo.common.d event) {
        s.h(event, "event");
        if (this.b && EventType.BACK_PRESS == event.c()) {
            a();
            return true;
        }
        return false;
    }

    public final void a() {
        FilterGuideView filterGuideView = this.c;
        if (filterGuideView == null) {
            return;
        }
        ViewParent parent = filterGuideView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(filterGuideView);
        }
        this.b = false;
    }

    public final boolean b() {
        return this.b;
    }

    public final void d(kotlin.jvm.b.a<u> aVar) {
        this.f9874d = aVar;
    }

    public final void g(View guideView, f fVar) {
        s.h(guideView, "guideView");
        if (this.b) {
            return;
        }
        e(guideView, fVar);
        this.b = true;
    }
}
