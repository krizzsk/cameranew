package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.timepicker.TimeModel;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.Calendar;
import java.util.Locale;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YearGridAdapter.java */
/* loaded from: classes2.dex */
public class m extends RecyclerView.Adapter<b> {
    private final MaterialCalendar<?> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: YearGridAdapter.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            m.this.a.t0(m.this.a.l0().g(Month.b(this.a, m.this.a.n0().a)));
            m.this.a.u0(MaterialCalendar.CalendarSelector.DAY);
        }
    }

    /* compiled from: YearGridAdapter.java */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        final TextView a;

        b(TextView textView) {
            super(textView);
            this.a = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MaterialCalendar<?> materialCalendar) {
        this.a = materialCalendar;
    }

    @NonNull
    private View.OnClickListener f(int i2) {
        return new a(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(int i2) {
        return i2 - this.a.l0().m().b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.l0().n();
    }

    int h(int i2) {
        return this.a.l0().m().b + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i */
    public void onBindViewHolder(@NonNull b bVar, int i2) {
        int h2 = h(i2);
        String string = bVar.a.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        bVar.a.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(h2)));
        bVar.a.setContentDescription(String.format(string, Integer.valueOf(h2)));
        com.google.android.material.datepicker.b m0 = this.a.m0();
        Calendar o = l.o();
        com.google.android.material.datepicker.a aVar = o.get(1) == h2 ? m0.f4239f : m0.f4237d;
        for (Long l2 : this.a.o0().A()) {
            o.setTimeInMillis(l2.longValue());
            if (o.get(1) == h2) {
                aVar = m0.f4238e;
            }
        }
        aVar.d(bVar.a);
        bVar.a.setOnClickListener(f(h2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: j */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
