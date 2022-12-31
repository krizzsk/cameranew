package us.pinguo.common.widget.tab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.h0;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.s;
import us.pinguo.common.widget.R;
import us.pinguo.common.widget.tab.PGEditTabLayout;
import us.pinguo.widget.common.widget.AutofitTextView;
import us.pinguo.widget.common.widget.a;
/* compiled from: PGAIEditBottomTabLayout.kt */
/* loaded from: classes4.dex */
public final class PGAIEditBottomTabLayout extends FrameLayout {
    public Map<Integer, View> a;
    private b b;
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10018d;

    /* compiled from: PGAIEditBottomTabLayout.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void J(PGEditTabLayout.f fVar);
    }

    /* compiled from: PGAIEditBottomTabLayout.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void c();
    }

    /* compiled from: PGAIEditBottomTabLayout.kt */
    /* loaded from: classes4.dex */
    public static final class c implements PGEditTabLayout.d {
        c() {
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public /* synthetic */ void a(PGEditTabLayout.f fVar) {
            l.c(this, fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void h(PGEditTabLayout.f fVar) {
            PGAIEditBottomTabLayout.this.l(fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void i(PGEditTabLayout.f fVar) {
            boolean z = false;
            if (fVar != null && fVar.i() == 0) {
                z = true;
            }
            if (z) {
                PGAIEditBottomTabLayout.this.l(fVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGAIEditBottomTabLayout(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.ai_edit_bottom_tab, this);
        Integer[] numArr = {Integer.valueOf(R.id.pg_ai_edit_first_menu_restoration)};
        String string = getResources().getString(R.string.ai_edit_menu_restoration);
        s.g(string, "resources.getString(R.st…ai_edit_menu_restoration)");
        e(new String[]{string}, numArr);
    }

    public static /* synthetic */ void d(PGAIEditBottomTabLayout pGAIEditBottomTabLayout, View[] viewArr, boolean z, m mVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            mVar = null;
        }
        pGAIEditBottomTabLayout.c(viewArr, z, mVar);
    }

    private final void e(String[] strArr, Integer[] numArr) {
        ((PGEditTabLayout) a(R.id.tab_ai_edit)).M();
        final ArrayList arrayList = new ArrayList();
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.element = -1.0f;
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            i2++;
            AutofitTextView autofitTextView = new AutofitTextView(getContext());
            arrayList.add(autofitTextView);
            autofitTextView.setGravity(17);
            autofitTextView.setMaxLines(1);
            autofitTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            autofitTextView.setPadding(12, 0, 12, 0);
            autofitTextView.setTextColor(getResources().getColorStateList(R.color.selector_edit_sec_tab_text));
            autofitTextView.setText(str);
            autofitTextView.setTextSize(1, 14.0f);
            autofitTextView.getPaint().setFakeBoldText(true);
            autofitTextView.setMinTextSize(1, 10.0f);
            autofitTextView.setSizeToFit(true);
            autofitTextView.b().b(new a.d() { // from class: us.pinguo.common.widget.tab.c
                @Override // us.pinguo.widget.common.widget.a.d
                public final void a(float f2, float f3) {
                    PGAIEditBottomTabLayout.f(Ref$FloatRef.this, arrayList, f2, f3);
                }
            });
            int i4 = R.id.tab_ai_edit;
            PGEditTabLayout.f J = ((PGEditTabLayout) a(i4)).J();
            J.q(autofitTextView);
            s.g(J, "tab_ai_edit.newTab().setCustomView(workFlowName)");
            J.s(numArr[i3].intValue());
            ((PGEditTabLayout) a(i4)).g(J);
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Ref$FloatRef minTextSize, ArrayList tabViewArr, float f2, float f3) {
        s.h(minTextSize, "$minTextSize");
        s.h(tabViewArr, "$tabViewArr");
        float f4 = minTextSize.element;
        if (!(f4 == -1.0f)) {
            f2 = Math.min(f2, f4);
        }
        minTextSize.element = f2;
        Iterator it = tabViewArr.iterator();
        while (it.hasNext()) {
            AutofitTextView autofitTextView = (AutofitTextView) it.next();
            float textSize = autofitTextView.getTextSize();
            float f5 = minTextSize.element;
            if (textSize > f5) {
                autofitTextView.setTextSize(0, f5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(PGEditTabLayout.f fVar) {
        a aVar;
        Integer valueOf = fVar == null ? null : Integer.valueOf(fVar.i());
        if (valueOf == null || valueOf.intValue() != 0 || (aVar = this.c) == null) {
            return;
        }
        aVar.J(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(PGAIEditBottomTabLayout this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        b bVar = this$0.b;
        if (bVar == null) {
            return;
        }
        bVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(PGAIEditBottomTabLayout this$0, View view) {
        b bVar;
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        if (this$0.f10018d || k.b(k.a, 0, 1, null) || (bVar = this$0.b) == null) {
            return;
        }
        bVar.a();
    }

    public View a(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final void c(View[] views, boolean z, m mVar) {
        s.h(views, "views");
        int i2 = R.id.tab_ai_edit_workflow_name;
        ((PGEditTabLayout) a(i2)).q();
        ((PGEditTabLayout) a(i2)).M();
        if (views.length <= 3) {
            ((PGEditTabLayout) a(i2)).setTabMode(1);
        } else {
            ((PGEditTabLayout) a(i2)).setTabMode(0);
        }
        ((PGEditTabLayout) a(i2)).setShowTabIndicator(z);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{16843868});
        s.g(obtainStyledAttributes, "context.theme.obtainStyl…temBackgroundBorderless))");
        int length = views.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            View view = views[i3];
            i3++;
            int i5 = i4 + 1;
            view.setBackground(obtainStyledAttributes.getDrawable(0));
            int i6 = R.id.tab_ai_edit_workflow_name;
            PGEditTabLayout.f J = ((PGEditTabLayout) a(i6)).J();
            J.q(view);
            s.g(J, "tab_ai_edit_workflow_nam…ewTab().setCustomView(it)");
            J.f10052i.setPadding(0, 0, 0, 0);
            if (mVar != null && i4 == mVar.b()) {
                J.t(mVar.a());
            }
            View f2 = J.f();
            View view2 = (View) (f2 == null ? null : f2.getParent());
            if (view2 != null) {
                view2.setBackground(null);
            }
            ((PGEditTabLayout) a(i6)).g(J);
            i4 = i5;
        }
        obtainStyledAttributes.recycle();
    }

    public final boolean g() {
        return false;
    }

    public final void n() {
        int i2 = R.id.rl_ai_edit_workflow;
        ConstraintLayout rl_ai_edit_workflow = (ConstraintLayout) a(i2);
        s.g(rl_ai_edit_workflow, "rl_ai_edit_workflow");
        if (!(rl_ai_edit_workflow.getVisibility() == 0)) {
            ConstraintLayout rl_ai_edit_workflow2 = (ConstraintLayout) a(i2);
            s.g(rl_ai_edit_workflow2, "rl_ai_edit_workflow");
            rl_ai_edit_workflow2.setVisibility(0);
            VdsAgent.onSetViewVisibility(rl_ai_edit_workflow2, 0);
        }
        ((ImageView) a(R.id.iv_ai_edit_workflow_exit)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.widget.tab.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PGAIEditBottomTabLayout.o(PGAIEditBottomTabLayout.this, view);
            }
        });
        ((TextView) a(R.id.iv_ai_edit_workflow_complete)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.widget.tab.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PGAIEditBottomTabLayout.p(PGAIEditBottomTabLayout.this, view);
            }
        });
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i2 = R.id.tab_ai_edit;
        ((PGEditTabLayout) a(i2)).f(new c());
        ((PGEditTabLayout) a(i2)).setSelectedTabIndicator((Drawable) null);
        ((PGEditTabLayout) a(i2)).setShowTabIndicator(true);
        ((PGEditTabLayout) a(R.id.tab_ai_edit_workflow_name)).setSelectedTabIndicator((Drawable) null);
        a(R.id.vInterceptor).setOnClickListener(d.a);
    }

    public final void q() {
        b bVar = this.b;
        if (bVar == null) {
            return;
        }
        bVar.c();
    }

    public final void setOnBottomClickListener(b bVar) {
        this.b = bVar;
    }

    public final void setOnBottomTabListener(a aVar) {
        this.c = aVar;
    }

    public final void setOnlyCancelBtCanClick(boolean z) {
        kotlin.z.d h2;
        kotlin.z.d h3;
        View f2;
        View f3;
        this.f10018d = z;
        h2 = kotlin.z.j.h(0, ((PGEditTabLayout) a(R.id.tab_ai_edit_workflow_name)).E());
        Iterator<Integer> it = h2.iterator();
        while (true) {
            ViewParent viewParent = null;
            if (!it.hasNext()) {
                break;
            }
            PGEditTabLayout.f D = ((PGEditTabLayout) a(R.id.tab_ai_edit_workflow_name)).D(((h0) it).nextInt());
            if (D != null && (f3 = D.f()) != null) {
                viewParent = f3.getParent();
            }
            View view = (View) viewParent;
            if (view != null) {
                view.setClickable(!z);
            }
        }
        h3 = kotlin.z.j.h(0, ((PGEditTabLayout) a(R.id.tab_ai_edit)).E());
        Iterator<Integer> it2 = h3.iterator();
        while (it2.hasNext()) {
            PGEditTabLayout.f D2 = ((PGEditTabLayout) a(R.id.tab_ai_edit)).D(((h0) it2).nextInt());
            View view2 = (View) ((D2 == null || (f2 = D2.f()) == null) ? null : f2.getParent());
            if (view2 != null) {
                view2.setClickable(!z);
            }
        }
    }

    public final void setTabLayoutAndCompleteButtonEnabled(boolean z) {
        if (z) {
            View vInterceptor = a(R.id.vInterceptor);
            s.g(vInterceptor, "vInterceptor");
            vInterceptor.setVisibility(4);
            VdsAgent.onSetViewVisibility(vInterceptor, 4);
            return;
        }
        View vInterceptor2 = a(R.id.vInterceptor);
        s.g(vInterceptor2, "vInterceptor");
        vInterceptor2.setVisibility(0);
        VdsAgent.onSetViewVisibility(vInterceptor2, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGAIEditBottomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.ai_edit_bottom_tab, this);
        Integer[] numArr = {Integer.valueOf(R.id.pg_ai_edit_first_menu_restoration)};
        String string = getResources().getString(R.string.ai_edit_menu_restoration);
        s.g(string, "resources.getString(R.st…ai_edit_menu_restoration)");
        e(new String[]{string}, numArr);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGAIEditBottomTabLayout(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.ai_edit_bottom_tab, this);
        Integer[] numArr = {Integer.valueOf(R.id.pg_ai_edit_first_menu_restoration)};
        String string = getResources().getString(R.string.ai_edit_menu_restoration);
        s.g(string, "resources.getString(R.st…ai_edit_menu_restoration)");
        e(new String[]{string}, numArr);
    }
}
