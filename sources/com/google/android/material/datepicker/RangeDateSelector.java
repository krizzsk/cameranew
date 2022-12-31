package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.internal.p;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new c();
    private String invalidRangeStartError;
    private final String invalidRangeEndError = " ";
    @Nullable
    private Long selectedStartItem = null;
    @Nullable
    private Long selectedEndItem = null;
    @Nullable
    private Long proposedTextStart = null;
    @Nullable
    private Long proposedTextEnd = null;

    /* loaded from: classes2.dex */
    class a extends com.google.android.material.datepicker.c {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f4224g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f4225h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ i f4226i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, i iVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f4224g = textInputLayout2;
            this.f4225h = textInputLayout3;
            this.f4226i = iVar;
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            RangeDateSelector.this.proposedTextStart = null;
            RangeDateSelector.this.m(this.f4224g, this.f4225h, this.f4226i);
        }

        @Override // com.google.android.material.datepicker.c
        void f(@Nullable Long l2) {
            RangeDateSelector.this.proposedTextStart = l2;
            RangeDateSelector.this.m(this.f4224g, this.f4225h, this.f4226i);
        }
    }

    /* loaded from: classes2.dex */
    class b extends com.google.android.material.datepicker.c {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f4228g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ TextInputLayout f4229h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ i f4230i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, i iVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f4228g = textInputLayout2;
            this.f4229h = textInputLayout3;
            this.f4230i = iVar;
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            RangeDateSelector.this.proposedTextEnd = null;
            RangeDateSelector.this.m(this.f4228g, this.f4229h, this.f4230i);
        }

        @Override // com.google.android.material.datepicker.c
        void f(@Nullable Long l2) {
            RangeDateSelector.this.proposedTextEnd = l2;
            RangeDateSelector.this.m(this.f4228g, this.f4229h, this.f4230i);
        }
    }

    /* loaded from: classes2.dex */
    static class c implements Parcelable.Creator<RangeDateSelector> {
        c() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public RangeDateSelector createFromParcel(@NonNull Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            rangeDateSelector.selectedStartItem = (Long) parcel.readValue(Long.class.getClassLoader());
            rangeDateSelector.selectedEndItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public RangeDateSelector[] newArray(int i2) {
            return new RangeDateSelector[i2];
        }
    }

    private void h(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        if (textInputLayout.R() != null && this.invalidRangeStartError.contentEquals(textInputLayout.R())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.R() == null || !" ".contentEquals(textInputLayout2.R())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean k(long j2, long j3) {
        return j2 <= j3;
    }

    private void l(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@NonNull TextInputLayout textInputLayout, @NonNull TextInputLayout textInputLayout2, @NonNull i<Pair<Long, Long>> iVar) {
        Long l2 = this.proposedTextStart;
        if (l2 != null && this.proposedTextEnd != null) {
            if (k(l2.longValue(), this.proposedTextEnd.longValue())) {
                this.selectedStartItem = this.proposedTextStart;
                this.selectedEndItem = this.proposedTextEnd;
                iVar.b(N());
                return;
            }
            l(textInputLayout, textInputLayout2);
            iVar.a();
            return;
        }
        h(textInputLayout, textInputLayout2);
        iVar.a();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> A() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.selectedStartItem;
        if (l2 != null) {
            arrayList.add(l2);
        }
        Long l3 = this.selectedEndItem;
        if (l3 != null) {
            arrayList.add(l3);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void O(long j2) {
        Long l2 = this.selectedStartItem;
        if (l2 == null) {
            this.selectedStartItem = Long.valueOf(j2);
        } else if (this.selectedEndItem == null && k(l2.longValue(), j2)) {
            this.selectedEndItem = Long.valueOf(j2);
        } else {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j2);
        }
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int d(@NonNull Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return com.google.android.material.f.b.c(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String e(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l2 = this.selectedStartItem;
        if (l2 == null && this.selectedEndItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l3 = this.selectedEndItem;
        if (l3 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, d.c(l2.longValue()));
        }
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, d.c(l3.longValue()));
        }
        Pair<String, String> a2 = d.a(l2, l3);
        return resources.getString(R.string.mtrl_picker_range_header_selected, a2.first, a2.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    /* renamed from: j */
    public Pair<Long, Long> N() {
        return new Pair<>(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> v() {
        if (this.selectedStartItem != null && this.selectedEndItem != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View w(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull i<Pair<Long, Long>> iVar) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText L = textInputLayout.L();
        EditText L2 = textInputLayout2.L();
        if (com.google.android.material.internal.d.a()) {
            L.setInputType(17);
            L2.setInputType(17);
        }
        this.invalidRangeStartError = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat k2 = l.k();
        Long l2 = this.selectedStartItem;
        if (l2 != null) {
            L.setText(k2.format(l2));
            this.proposedTextStart = this.selectedStartItem;
        }
        Long l3 = this.selectedEndItem;
        if (l3 != null) {
            L2.setText(k2.format(l3));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String l4 = l.l(inflate.getResources(), k2);
        textInputLayout.setPlaceholderText(l4);
        textInputLayout2.setPlaceholderText(l4);
        L.addTextChangedListener(new a(l4, k2, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, iVar));
        L2.addTextChangedListener(new b(l4, k2, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, iVar));
        p.k(L);
        return inflate;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean z() {
        Long l2 = this.selectedStartItem;
        return (l2 == null || this.selectedEndItem == null || !k(l2.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }
}
