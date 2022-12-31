package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MonthAdapter.java */
/* loaded from: classes2.dex */
public class g extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    static final int f4246f = l.q().getMaximum(4);
    final Month a;
    final DateSelector<?> b;
    private Collection<Long> c;

    /* renamed from: d  reason: collision with root package name */
    b f4247d;

    /* renamed from: e  reason: collision with root package name */
    final CalendarConstraints f4248e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.a = month;
        this.b = dateSelector;
        this.f4248e = calendarConstraints;
        this.c = dateSelector.A();
    }

    private void e(Context context) {
        if (this.f4247d == null) {
            this.f4247d = new b(context);
        }
    }

    private boolean h(long j2) {
        Iterator<Long> it = this.b.A().iterator();
        while (it.hasNext()) {
            if (l.a(j2) == l.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private void k(@Nullable TextView textView, long j2) {
        a aVar;
        if (textView == null) {
            return;
        }
        if (this.f4248e.h().i(j2)) {
            textView.setEnabled(true);
            if (h(j2)) {
                aVar = this.f4247d.b;
            } else if (l.o().getTimeInMillis() == j2) {
                aVar = this.f4247d.c;
            } else {
                aVar = this.f4247d.a;
            }
        } else {
            textView.setEnabled(false);
            aVar = this.f4247d.f4240g;
        }
        aVar.d(textView);
    }

    private void l(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (Month.c(j2).equals(this.a)) {
            k((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter2().a(this.a.j(j2)) - materialCalendarGridView.getFirstVisiblePosition()), j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i2) {
        return b() + (i2 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.a.g();
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: c */
    public Long getItem(int i2) {
        if (i2 < this.a.g() || i2 > i()) {
            return null;
        }
        return Long.valueOf(this.a.h(j(i2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008a  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, @androidx.annotation.Nullable android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L78
            com.google.android.material.datepicker.Month r8 = r5.a
            int r2 = r8.f4222d
            if (r7 < r2) goto L2d
            goto L78
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            com.google.android.material.datepicker.Month r8 = r5.a
            long r7 = r8.h(r7)
            com.google.android.material.datepicker.Month r3 = r5.a
            int r3 = r3.b
            com.google.android.material.datepicker.Month r4 = com.google.android.material.datepicker.Month.f()
            int r4 = r4.b
            if (r3 != r4) goto L67
            java.lang.String r7 = com.google.android.material.datepicker.d.g(r7)
            r0.setContentDescription(r7)
            goto L6e
        L67:
            java.lang.String r7 = com.google.android.material.datepicker.d.l(r7)
            r0.setContentDescription(r7)
        L6e:
            r0.setVisibility(r1)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r0, r1)
            r0.setEnabled(r2)
            goto L83
        L78:
            r7 = 8
            r0.setVisibility(r7)
            com.growingio.android.sdk.autoburry.VdsAgent.onSetViewVisibility(r0, r7)
            r0.setEnabled(r1)
        L83:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L8a
            return r0
        L8a:
            long r6 = r6.longValue()
            r5.k(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.g.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(int i2) {
        return i2 % this.a.c == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i2) {
        return (i2 + 1) % this.a.c == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.a.f4222d + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2 / this.a.c;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return (this.a.g() + this.a.f4222d) - 1;
    }

    int j(int i2) {
        return (i2 - this.a.g()) + 1;
    }

    public void m(MaterialCalendarGridView materialCalendarGridView) {
        for (Long l2 : this.c) {
            l(materialCalendarGridView, l2.longValue());
        }
        DateSelector<?> dateSelector = this.b;
        if (dateSelector != null) {
            for (Long l3 : dateSelector.A()) {
                l(materialCalendarGridView, l3.longValue());
            }
            this.c = this.b.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(int i2) {
        return i2 >= b() && i2 <= i();
    }
}
