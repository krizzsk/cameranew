package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Calendar;
import java.util.Iterator;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    static final Object f4203l = "MONTHS_VIEW_GROUP_TAG";
    @VisibleForTesting
    static final Object m = "NAVIGATION_PREV_TAG";
    @VisibleForTesting
    static final Object n = "NAVIGATION_NEXT_TAG";
    @VisibleForTesting
    static final Object o = "SELECTOR_TOGGLE_TAG";
    @StyleRes
    private int b;
    @Nullable
    private DateSelector<S> c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private CalendarConstraints f4204d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Month f4205e;

    /* renamed from: f  reason: collision with root package name */
    private CalendarSelector f4206f;

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.material.datepicker.b f4207g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f4208h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f4209i;

    /* renamed from: j  reason: collision with root package name */
    private View f4210j;

    /* renamed from: k  reason: collision with root package name */
    private View f4211k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.this.f4209i.smoothScrollToPosition(this.a);
        }
    }

    /* loaded from: classes2.dex */
    class b extends AccessibilityDelegateCompat {
        b(MaterialCalendar materialCalendar) {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    /* loaded from: classes2.dex */
    class c extends com.google.android.material.datepicker.j {
        final /* synthetic */ int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i2, boolean z, int i3) {
            super(context, i2, z);
            this.a = i3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            if (this.a == 0) {
                iArr[0] = MaterialCalendar.this.f4209i.getWidth();
                iArr[1] = MaterialCalendar.this.f4209i.getWidth();
                return;
            }
            iArr[0] = MaterialCalendar.this.f4209i.getHeight();
            iArr[1] = MaterialCalendar.this.f4209i.getHeight();
        }
    }

    /* loaded from: classes2.dex */
    class d implements k {
        d() {
        }

        @Override // com.google.android.material.datepicker.MaterialCalendar.k
        public void a(long j2) {
            if (MaterialCalendar.this.f4204d.h().i(j2)) {
                MaterialCalendar.this.c.O(j2);
                Iterator<com.google.android.material.datepicker.i<S>> it = MaterialCalendar.this.a.iterator();
                while (it.hasNext()) {
                    it.next().b((S) MaterialCalendar.this.c.N());
                }
                MaterialCalendar.this.f4209i.getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.this.f4208h != null) {
                    MaterialCalendar.this.f4208h.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends RecyclerView.ItemDecoration {
        private final Calendar a = l.q();
        private final Calendar b = l.q();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            int width;
            if ((recyclerView.getAdapter() instanceof m) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                m mVar = (m) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (Pair<Long, Long> pair : MaterialCalendar.this.c.v()) {
                    Long l2 = pair.first;
                    if (l2 != null && pair.second != null) {
                        this.a.setTimeInMillis(l2.longValue());
                        this.b.setTimeInMillis(pair.second.longValue());
                        int g2 = mVar.g(this.a.get(1));
                        int g3 = mVar.g(this.b.get(1));
                        View findViewByPosition = gridLayoutManager.findViewByPosition(g2);
                        View findViewByPosition2 = gridLayoutManager.findViewByPosition(g3);
                        int spanCount = g2 / gridLayoutManager.getSpanCount();
                        int spanCount2 = g3 / gridLayoutManager.getSpanCount();
                        int i2 = spanCount;
                        while (i2 <= spanCount2) {
                            View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i2);
                            if (findViewByPosition3 != null) {
                                int top = findViewByPosition3.getTop() + MaterialCalendar.this.f4207g.f4237d.c();
                                int bottom = findViewByPosition3.getBottom() - MaterialCalendar.this.f4207g.f4237d.b();
                                int left = i2 == spanCount ? findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2) : 0;
                                if (i2 == spanCount2) {
                                    width = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                } else {
                                    width = recyclerView.getWidth();
                                }
                                canvas.drawRect(left, top, width, bottom, MaterialCalendar.this.f4207g.f4241h);
                            }
                            i2++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f extends AccessibilityDelegateCompat {
        f() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String string;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (MaterialCalendar.this.f4211k.getVisibility() == 0) {
                string = MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_year_selection);
            } else {
                string = MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_day_selection);
            }
            accessibilityNodeInfoCompat.setHintText(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g extends RecyclerView.OnScrollListener {
        final /* synthetic */ com.google.android.material.datepicker.h a;
        final /* synthetic */ MaterialButton b;

        g(com.google.android.material.datepicker.h hVar, MaterialButton materialButton) {
            this.a = hVar;
            this.b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                CharSequence text = this.b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(2048);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
            int findLastVisibleItemPosition;
            if (i2 < 0) {
                findLastVisibleItemPosition = MaterialCalendar.this.q0().findFirstVisibleItemPosition();
            } else {
                findLastVisibleItemPosition = MaterialCalendar.this.q0().findLastVisibleItemPosition();
            }
            MaterialCalendar.this.f4205e = this.a.f(findLastVisibleItemPosition);
            this.b.setText(this.a.g(findLastVisibleItemPosition));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            MaterialCalendar.this.v0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {
        final /* synthetic */ com.google.android.material.datepicker.h a;

        i(com.google.android.material.datepicker.h hVar) {
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            int findFirstVisibleItemPosition = MaterialCalendar.this.q0().findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < MaterialCalendar.this.f4209i.getAdapter().getItemCount()) {
                MaterialCalendar.this.t0(this.a.f(findFirstVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        final /* synthetic */ com.google.android.material.datepicker.h a;

        j(com.google.android.material.datepicker.h hVar) {
            this.a = hVar;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            int findLastVisibleItemPosition = MaterialCalendar.this.q0().findLastVisibleItemPosition() - 1;
            if (findLastVisibleItemPosition >= 0) {
                MaterialCalendar.this.t0(this.a.f(findLastVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface k {
        void a(long j2);
    }

    private void j0(@NonNull View view, @NonNull com.google.android.material.datepicker.h hVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        materialButton.setTag(o);
        ViewCompat.setAccessibilityDelegate(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.month_navigation_previous);
        materialButton2.setTag(m);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.month_navigation_next);
        materialButton3.setTag(n);
        this.f4210j = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f4211k = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        u0(CalendarSelector.DAY);
        materialButton.setText(this.f4205e.k(view.getContext()));
        this.f4209i.addOnScrollListener(new g(hVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(hVar));
        materialButton2.setOnClickListener(new j(hVar));
    }

    @NonNull
    private RecyclerView.ItemDecoration k0() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Px
    public static int p0(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    @NonNull
    public static <T> MaterialCalendar<T> r0(@NonNull DateSelector<T> dateSelector, @StyleRes int i2, @NonNull CalendarConstraints calendarConstraints) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.l());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void s0(int i2) {
        this.f4209i.post(new a(i2));
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean a0(@NonNull com.google.android.material.datepicker.i<S> iVar) {
        return super.a0(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CalendarConstraints l0() {
        return this.f4204d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.b m0() {
        return this.f4207g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Month n0() {
        return this.f4205e;
    }

    @Nullable
    public DateSelector<S> o0() {
        return this.c;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.b = bundle.getInt("THEME_RES_ID_KEY");
        this.c = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f4204d = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f4205e = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.b);
        this.f4207g = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month m2 = this.f4204d.m();
        if (MaterialDatePicker.p0(contextThemeWrapper)) {
            i2 = R.layout.mtrl_calendar_vertical;
            i3 = 1;
        } else {
            i2 = R.layout.mtrl_calendar_horizontal;
            i3 = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.e());
        gridView.setNumColumns(m2.c);
        gridView.setEnabled(false);
        this.f4209i = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.f4209i.setLayoutManager(new c(getContext(), i3, false, i3));
        this.f4209i.setTag(f4203l);
        com.google.android.material.datepicker.h hVar = new com.google.android.material.datepicker.h(contextThemeWrapper, this.c, this.f4204d, new d());
        this.f4209i.setAdapter(hVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f4208h = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f4208h.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f4208h.setAdapter(new m(this));
            this.f4208h.addItemDecoration(k0());
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            j0(inflate, hVar);
        }
        if (!MaterialDatePicker.p0(contextThemeWrapper)) {
            new PagerSnapHelper().attachToRecyclerView(this.f4209i);
        }
        this.f4209i.scrollToPosition(hVar.h(this.f4205e));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.b);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f4204d);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f4205e);
    }

    @NonNull
    LinearLayoutManager q0() {
        return (LinearLayoutManager) this.f4209i.getLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t0(Month month) {
        com.google.android.material.datepicker.h hVar = (com.google.android.material.datepicker.h) this.f4209i.getAdapter();
        int h2 = hVar.h(month);
        int h3 = h2 - hVar.h(this.f4205e);
        boolean z = Math.abs(h3) > 3;
        boolean z2 = h3 > 0;
        this.f4205e = month;
        if (z && z2) {
            this.f4209i.scrollToPosition(h2 - 3);
            s0(h2);
        } else if (z) {
            this.f4209i.scrollToPosition(h2 + 3);
            s0(h2);
        } else {
            s0(h2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u0(CalendarSelector calendarSelector) {
        this.f4206f = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f4208h.getLayoutManager().scrollToPosition(((m) this.f4208h.getAdapter()).g(this.f4205e.b));
            View view = this.f4210j;
            view.setVisibility(0);
            VdsAgent.onSetViewVisibility(view, 0);
            View view2 = this.f4211k;
            view2.setVisibility(8);
            VdsAgent.onSetViewVisibility(view2, 8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            View view3 = this.f4210j;
            view3.setVisibility(8);
            VdsAgent.onSetViewVisibility(view3, 8);
            View view4 = this.f4211k;
            view4.setVisibility(0);
            VdsAgent.onSetViewVisibility(view4, 0);
            t0(this.f4205e);
        }
    }

    void v0() {
        CalendarSelector calendarSelector = this.f4206f;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            u0(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            u0(calendarSelector2);
        }
    }
}
