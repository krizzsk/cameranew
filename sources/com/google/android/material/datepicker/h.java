package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: MonthsPagerAdapter.java */
/* loaded from: classes2.dex */
class h extends RecyclerView.Adapter<b> {
    private final Context a;
    @NonNull
    private final CalendarConstraints b;
    private final DateSelector<?> c;

    /* renamed from: d  reason: collision with root package name */
    private final MaterialCalendar.k f4249d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4250e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MonthsPagerAdapter.java */
    /* loaded from: classes2.dex */
    public class a implements AdapterView.OnItemClickListener {
        final /* synthetic */ MaterialCalendarGridView a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        @Instrumented
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            VdsAgent.onItemClick(this, adapterView, view, i2, j2);
            if (this.a.getAdapter2().n(i2)) {
                h.this.f4249d.a(this.a.getAdapter2().getItem(i2).longValue());
            }
        }
    }

    /* compiled from: MonthsPagerAdapter.java */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        final TextView a;
        final MaterialCalendarGridView b;

        b(@NonNull LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.a = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z) {
                return;
            }
            textView.setVisibility(8);
            VdsAgent.onSetViewVisibility(textView, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, MaterialCalendar.k kVar) {
        Month m = calendarConstraints.m();
        Month j2 = calendarConstraints.j();
        Month l2 = calendarConstraints.l();
        if (m.compareTo(l2) <= 0) {
            if (l2.compareTo(j2) <= 0) {
                int p0 = g.f4246f * MaterialCalendar.p0(context);
                int p02 = MaterialDatePicker.p0(context) ? MaterialCalendar.p0(context) : 0;
                this.a = context;
                this.f4250e = p0 + p02;
                this.b = calendarConstraints;
                this.c = dateSelector;
                this.f4249d = kVar;
                setHasStableIds(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month f(int i2) {
        return this.b.m().m(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CharSequence g(int i2) {
        return f(i2).k(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.b.k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i2) {
        return this.b.m().m(i2).l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(@NonNull Month month) {
        return this.b.m().n(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        Month m = this.b.m().m(i2);
        bVar.a.setText(m.k(bVar.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter2() != null && m.equals(materialCalendarGridView.getAdapter2().a)) {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter2().m(materialCalendarGridView);
        } else {
            g gVar = new g(m, this.c, this.b);
            materialCalendarGridView.setNumColumns(m.c);
            materialCalendarGridView.setAdapter((ListAdapter) gVar);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (MaterialDatePicker.p0(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f4250e));
            return new b(linearLayout, true);
        }
        return new b(linearLayout, false);
    }
}
