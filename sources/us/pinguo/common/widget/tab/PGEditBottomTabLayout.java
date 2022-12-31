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
import androidx.annotation.ColorInt;
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
/* compiled from: PGEditBottomTabLayout.kt */
/* loaded from: classes4.dex */
public final class PGEditBottomTabLayout extends FrameLayout {
    public Map<Integer, View> a;
    private a b;
    private b c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10019d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10020e;

    /* compiled from: PGEditBottomTabLayout.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a();

        void c();
    }

    /* compiled from: PGEditBottomTabLayout.kt */
    /* loaded from: classes4.dex */
    public interface b {
        void I(PGEditTabLayout.f fVar);

        void Y(PGEditTabLayout.f fVar);

        void Z(PGEditTabLayout.f fVar);

        void q(PGEditTabLayout.f fVar);

        void x(PGEditTabLayout.f fVar);
    }

    /* compiled from: PGEditBottomTabLayout.kt */
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
            PGEditBottomTabLayout.this.w(fVar);
        }

        @Override // us.pinguo.common.widget.tab.PGEditTabLayout.c
        public void i(PGEditTabLayout.f fVar) {
            if (PGEditBottomTabLayout.this.f10020e) {
                if (!(fVar != null && fVar.i() == 1)) {
                    if (!(fVar != null && fVar.i() == 2)) {
                        if (!(fVar != null && fVar.i() == 3)) {
                            return;
                        }
                    }
                }
                PGEditBottomTabLayout.this.w(fVar);
                return;
            }
            if (!(fVar != null && fVar.i() == 1)) {
                if (!(fVar != null && fVar.i() == 2)) {
                    return;
                }
            }
            PGEditBottomTabLayout.this.w(fVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGEditBottomTabLayout(Context context) {
        super(context);
        s.h(context, "context");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.edit_bottom_tab, this);
    }

    public static /* synthetic */ void A(PGEditBottomTabLayout pGEditBottomTabLayout, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = true;
        }
        pGEditBottomTabLayout.z(i2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(PGEditBottomTabLayout this$0, View view) {
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        a aVar = this$0.b;
        if (aVar == null) {
            return;
        }
        aVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(PGEditBottomTabLayout this$0, View view) {
        a aVar;
        VdsAgent.lambdaOnClick(view);
        s.h(this$0, "this$0");
        if (this$0.f10019d || k.b(k.a, 0, 1, null) || (aVar = this$0.b) == null) {
            return;
        }
        aVar.a();
    }

    public static /* synthetic */ void g(PGEditBottomTabLayout pGEditBottomTabLayout, View[] viewArr, boolean z, m mVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            mVar = null;
        }
        pGEditBottomTabLayout.e(viewArr, z, mVar);
    }

    public static /* synthetic */ void h(PGEditBottomTabLayout pGEditBottomTabLayout, String[] strArr, boolean z, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        pGEditBottomTabLayout.f(strArr, z, num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Ref$FloatRef minTextSize, ArrayList tabViewArr, float f2, float f3) {
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

    private final int k(int i2) {
        if (i2 == 1) {
            return us.pinguo.common.widget.i.a.a(132);
        }
        return -2;
    }

    private final void o(String[] strArr, Integer[] numArr) {
        ((PGEditTabLayout) a(R.id.tab_edit)).M();
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
            autofitTextView.b().b(new a.d() { // from class: us.pinguo.common.widget.tab.i
                @Override // us.pinguo.widget.common.widget.a.d
                public final void a(float f2, float f3) {
                    PGEditBottomTabLayout.p(Ref$FloatRef.this, arrayList, f2, f3);
                }
            });
            int i4 = R.id.tab_edit;
            PGEditTabLayout.f J = ((PGEditTabLayout) a(i4)).J();
            J.q(autofitTextView);
            s.g(J, "tab_edit.newTab().setCustomView(workFlowName)");
            J.s(numArr[i3].intValue());
            ((PGEditTabLayout) a(i4)).g(J);
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Ref$FloatRef minTextSize, ArrayList tabViewArr, float f2, float f3) {
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
    public final void w(PGEditTabLayout.f fVar) {
        Integer valueOf;
        b bVar;
        b bVar2;
        if (this.f10020e) {
            valueOf = fVar != null ? Integer.valueOf(fVar.i()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                b bVar3 = this.c;
                if (bVar3 == null) {
                    return;
                }
                bVar3.q(fVar);
                return;
            } else if (valueOf != null && valueOf.intValue() == 1) {
                b bVar4 = this.c;
                if (bVar4 == null) {
                    return;
                }
                bVar4.I(fVar);
                return;
            } else if (valueOf != null && valueOf.intValue() == 2) {
                b bVar5 = this.c;
                if (bVar5 == null) {
                    return;
                }
                bVar5.Y(fVar);
                return;
            } else if (valueOf != null && valueOf.intValue() == 3) {
                b bVar6 = this.c;
                if (bVar6 == null) {
                    return;
                }
                bVar6.Z(fVar);
                return;
            } else if (valueOf == null || valueOf.intValue() != 4 || (bVar2 = this.c) == null) {
                return;
            } else {
                bVar2.x(fVar);
                return;
            }
        }
        valueOf = fVar != null ? Integer.valueOf(fVar.i()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            b bVar7 = this.c;
            if (bVar7 == null) {
                return;
            }
            bVar7.q(fVar);
        } else if (valueOf != null && valueOf.intValue() == 1) {
            b bVar8 = this.c;
            if (bVar8 == null) {
                return;
            }
            bVar8.Y(fVar);
        } else if (valueOf != null && valueOf.intValue() == 2) {
            b bVar9 = this.c;
            if (bVar9 == null) {
                return;
            }
            bVar9.Z(fVar);
        } else if (valueOf == null || valueOf.intValue() != 3 || (bVar = this.c) == null) {
        } else {
            bVar.x(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(View view) {
        VdsAgent.lambdaOnClick(view);
    }

    public final void B() {
        int i2 = R.id.rl_edit_workflow;
        ConstraintLayout rl_edit_workflow = (ConstraintLayout) a(i2);
        s.g(rl_edit_workflow, "rl_edit_workflow");
        if (!(rl_edit_workflow.getVisibility() == 0)) {
            ConstraintLayout rl_edit_workflow2 = (ConstraintLayout) a(i2);
            s.g(rl_edit_workflow2, "rl_edit_workflow");
            rl_edit_workflow2.setVisibility(0);
            VdsAgent.onSetViewVisibility(rl_edit_workflow2, 0);
        }
        ((ImageView) a(R.id.iv_edit_workflow_exit)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.widget.tab.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PGEditBottomTabLayout.C(PGEditBottomTabLayout.this, view);
            }
        });
        ((ImageView) a(R.id.iv_edit_workflow_complete)).setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.common.widget.tab.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PGEditBottomTabLayout.D(PGEditBottomTabLayout.this, view);
            }
        });
    }

    public final void E(boolean z) {
        PGEditTabLayout tab_edit_workflow_name = (PGEditTabLayout) a(R.id.tab_edit_workflow_name);
        s.g(tab_edit_workflow_name, "tab_edit_workflow_name");
        int i2 = z ? 0 : 8;
        tab_edit_workflow_name.setVisibility(i2);
        VdsAgent.onSetViewVisibility(tab_edit_workflow_name, i2);
    }

    public final void F(@ColorInt int i2, @ColorInt int i3) {
        ((ConstraintLayout) a(R.id.rl_edit_workflow)).setBackgroundColor(i2);
        Drawable drawable = ((ImageView) a(R.id.iv_edit_workflow_exit)).getDrawable();
        if (drawable != null) {
            drawable.setTint(i3);
        }
        Drawable drawable2 = ((ImageView) a(R.id.iv_edit_workflow_complete)).getDrawable();
        if (drawable2 == null) {
            return;
        }
        drawable2.setTint(i3);
    }

    public final void G() {
        a aVar = this.b;
        if (aVar == null) {
            return;
        }
        aVar.c();
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

    public final void d(PGEditTabLayout.d onSecondaryTabSelectedListener) {
        s.h(onSecondaryTabSelectedListener, "onSecondaryTabSelectedListener");
        int i2 = R.id.tab_edit_workflow_name;
        ((PGEditTabLayout) a(i2)).q();
        ((PGEditTabLayout) a(i2)).f(onSecondaryTabSelectedListener);
    }

    public final void e(View[] views, boolean z, m mVar) {
        s.h(views, "views");
        int i2 = R.id.tab_edit_workflow_name;
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
            int i6 = R.id.tab_edit_workflow_name;
            PGEditTabLayout.f J = ((PGEditTabLayout) a(i6)).J();
            J.q(view);
            s.g(J, "tab_edit_workflow_name.newTab().setCustomView(it)");
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

    public final void f(String[] tabNames, boolean z, @ColorInt Integer num) {
        boolean z2;
        s.h(tabNames, "tabNames");
        int i2 = R.id.tab_edit_workflow_name;
        ((PGEditTabLayout) a(i2)).q();
        ((PGEditTabLayout) a(i2)).M();
        if (tabNames.length <= 4) {
            ((PGEditTabLayout) a(i2)).setTabMode(1);
        } else {
            ((PGEditTabLayout) a(i2)).setTabMode(0);
        }
        ((PGEditTabLayout) a(i2)).setShowTabIndicator(z);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(new int[]{16843868});
        s.g(obtainStyledAttributes, "context.theme.obtainStyl…temBackgroundBorderless))");
        int k2 = k(tabNames.length);
        final ArrayList arrayList = new ArrayList();
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.element = -1.0f;
        int length = tabNames.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            String str = tabNames[i3];
            i3++;
            int i5 = i4 + 1;
            AutofitTextView autofitTextView = new AutofitTextView(getContext());
            arrayList.add(autofitTextView);
            autofitTextView.setGravity(17);
            autofitTextView.setMaxLines(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(k2, -1);
            if (num == null) {
                autofitTextView.setTextColor(getResources().getColorStateList(R.color.selector_edit_sec_tab_text));
            } else {
                autofitTextView.setTextColor(num.intValue());
            }
            autofitTextView.setLayoutParams(layoutParams);
            autofitTextView.setText(str);
            autofitTextView.setTextSize(1, 14.0f);
            autofitTextView.getPaint().setFakeBoldText(true);
            autofitTextView.setMinTextSize(1, 10.0f);
            autofitTextView.setBackground(obtainStyledAttributes.getDrawable(0));
            int i6 = R.id.tab_edit_workflow_name;
            PGEditTabLayout.f J = ((PGEditTabLayout) a(i6)).J();
            J.q(autofitTextView);
            s.g(J, "tab_edit_workflow_name.n…tCustomView(workFlowName)");
            if (((PGEditTabLayout) a(i6)).H() == 0) {
                int dimension = (int) us.pinguo.foundation.e.b().getResources().getDimension(R.dimen.scroll_common_edit_tab_padding);
                if (i4 == 0) {
                    z2 = false;
                    J.f10052i.setPadding(dimension, 0, dimension, 0);
                } else {
                    z2 = false;
                    J.f10052i.setPadding(dimension, 0, dimension, 0);
                }
                autofitTextView.setSizeToFit(z2);
            } else {
                autofitTextView.setSizeToFit(true);
                autofitTextView.b().b(new a.d() { // from class: us.pinguo.common.widget.tab.f
                    @Override // us.pinguo.widget.common.widget.a.d
                    public final void a(float f2, float f3) {
                        PGEditBottomTabLayout.i(Ref$FloatRef.this, arrayList, f2, f3);
                    }
                });
                J.f10052i.setPadding(0, 0, 0, 0);
            }
            View f2 = J.f();
            View view = (View) (f2 == null ? null : f2.getParent());
            if (view != null) {
                view.setBackground(null);
            }
            ((PGEditTabLayout) a(i6)).g(J);
            i4 = i5;
        }
        obtainStyledAttributes.recycle();
    }

    public final void j() {
        PGEditTabLayout pGEditTabLayout = (PGEditTabLayout) a(R.id.tab_edit);
        pGEditTabLayout.setVisibility(0);
        VdsAgent.onSetViewVisibility(pGEditTabLayout, 0);
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.rl_edit_workflow);
        constraintLayout.setVisibility(8);
        VdsAgent.onSetViewVisibility(constraintLayout, 8);
    }

    public final void l() {
        ((PGEditTabLayout) a(R.id.tab_edit_workflow_name)).q();
    }

    public final a m() {
        return this.b;
    }

    public final PGEditTabLayout n() {
        return (PGEditTabLayout) a(R.id.tab_edit_workflow_name);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i2 = R.id.tab_edit;
        ((PGEditTabLayout) a(i2)).f(new c());
        ((PGEditTabLayout) a(i2)).setSelectedTabIndicator((Drawable) null);
        ((PGEditTabLayout) a(i2)).setShowTabIndicator(true);
        ((PGEditTabLayout) a(R.id.tab_edit_workflow_name)).setSelectedTabIndicator((Drawable) null);
        a(R.id.vInterceptor).setOnClickListener(g.a);
    }

    public final boolean q() {
        ConstraintLayout rl_edit_workflow = (ConstraintLayout) a(R.id.rl_edit_workflow);
        s.g(rl_edit_workflow, "rl_edit_workflow");
        return rl_edit_workflow.getVisibility() == 0;
    }

    public final void setOnBottomClickListener(a aVar) {
        this.b = aVar;
    }

    public final void setOnBottomTabListener(b bVar) {
        this.c = bVar;
    }

    public final void setOnlyCancelBtCanClick(boolean z) {
        kotlin.z.d h2;
        kotlin.z.d h3;
        View f2;
        View f3;
        this.f10019d = z;
        h2 = kotlin.z.j.h(0, ((PGEditTabLayout) a(R.id.tab_edit_workflow_name)).E());
        Iterator<Integer> it = h2.iterator();
        while (true) {
            ViewParent viewParent = null;
            if (!it.hasNext()) {
                break;
            }
            PGEditTabLayout.f D = ((PGEditTabLayout) a(R.id.tab_edit_workflow_name)).D(((h0) it).nextInt());
            if (D != null && (f3 = D.f()) != null) {
                viewParent = f3.getParent();
            }
            View view = (View) viewParent;
            if (view != null) {
                view.setClickable(!z);
            }
        }
        h3 = kotlin.z.j.h(0, ((PGEditTabLayout) a(R.id.tab_edit)).E());
        Iterator<Integer> it2 = h3.iterator();
        while (it2.hasNext()) {
            PGEditTabLayout.f D2 = ((PGEditTabLayout) a(R.id.tab_edit)).D(((h0) it2).nextInt());
            View view2 = (View) ((D2 == null || (f2 = D2.f()) == null) ? null : f2.getParent());
            if (view2 != null) {
                view2.setClickable(!z);
            }
        }
    }

    public final void setPlan(boolean z) {
        this.f10020e = z;
        if (z) {
            us.pinguo.foundation.statistics.h.b.m0("edit_panel_makeup", null, "show");
            Integer[] numArr = {Integer.valueOf(R.id.pg_edit_first_menu_beauty), Integer.valueOf(R.id.pg_edit_first_menu_makeup), Integer.valueOf(R.id.pg_edit_first_menu_effect), Integer.valueOf(R.id.pg_edit_first_menu_lightzone), Integer.valueOf(R.id.pg_edit_first_menu_edit)};
            String string = getResources().getString(R.string.beauty_beauty_face);
            s.g(string, "resources.getString(R.string.beauty_beauty_face)");
            String string2 = getResources().getString(R.string.main_menu_beauty_makeup);
            s.g(string2, "resources.getString(R.st….main_menu_beauty_makeup)");
            String string3 = getResources().getString(R.string.filter);
            s.g(string3, "resources.getString(R.string.filter)");
            String string4 = getResources().getString(R.string.pg_sdk_edit_lightzone_class);
            s.g(string4, "resources.getString(R.st…sdk_edit_lightzone_class)");
            String string5 = getResources().getString(R.string.pg_sdk_edit);
            s.g(string5, "resources.getString(R.string.pg_sdk_edit)");
            o(new String[]{string, string2, string3, string4, string5}, numArr);
            return;
        }
        Integer[] numArr2 = {Integer.valueOf(R.id.pg_edit_first_menu_beauty), Integer.valueOf(R.id.pg_edit_first_menu_effect), Integer.valueOf(R.id.pg_edit_first_menu_lightzone), Integer.valueOf(R.id.pg_edit_first_menu_edit)};
        String string6 = getResources().getString(R.string.beauty_beauty_face);
        s.g(string6, "resources.getString(R.string.beauty_beauty_face)");
        String string7 = getResources().getString(R.string.filter);
        s.g(string7, "resources.getString(R.string.filter)");
        String string8 = getResources().getString(R.string.pg_sdk_edit_lightzone_class);
        s.g(string8, "resources.getString(R.st…sdk_edit_lightzone_class)");
        String string9 = getResources().getString(R.string.pg_sdk_edit);
        s.g(string9, "resources.getString(R.string.pg_sdk_edit)");
        o(new String[]{string6, string7, string8, string9}, numArr2);
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

    public final void y(int i2) {
        int i3 = R.id.tab_edit_workflow_name;
        ((PGEditTabLayout) a(i3)).P(((PGEditTabLayout) a(i3)).D(i2));
    }

    public final void z(int i2, boolean z) {
        int E = ((PGEditTabLayout) a(R.id.tab_edit)).E();
        if (E < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3 + 1;
            int i5 = R.id.tab_edit;
            PGEditTabLayout.f D = ((PGEditTabLayout) a(i5)).D(i3);
            if (D != null && i2 == D.h()) {
                PGEditTabLayout.f D2 = ((PGEditTabLayout) a(i5)).D(i3);
                if (D2 != null) {
                    D2.v(Boolean.valueOf(z));
                }
                ((PGEditTabLayout) a(i5)).P(D2);
                return;
            } else if (i3 == E) {
                return;
            } else {
                i3 = i4;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGEditBottomTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.edit_bottom_tab, this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGEditBottomTabLayout(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        this.a = new LinkedHashMap();
        View.inflate(getContext(), R.layout.edit_bottom_tab, this);
    }
}
