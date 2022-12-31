package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new b();
    @Nullable
    private Long selectedItem;

    /* loaded from: classes2.dex */
    class a extends c {

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ i f4232g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, i iVar) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.f4232g = iVar;
        }

        @Override // com.google.android.material.datepicker.c
        void e() {
            this.f4232g.a();
        }

        @Override // com.google.android.material.datepicker.c
        void f(@Nullable Long l2) {
            if (l2 == null) {
                SingleDateSelector.this.c();
            } else {
                SingleDateSelector.this.O(l2.longValue());
            }
            this.f4232g.b(SingleDateSelector.this.N());
        }
    }

    /* loaded from: classes2.dex */
    static class b implements Parcelable.Creator<SingleDateSelector> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public SingleDateSelector createFromParcel(@NonNull Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            singleDateSelector.selectedItem = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public SingleDateSelector[] newArray(int i2) {
            return new SingleDateSelector[i2];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.selectedItem = null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Long> A() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.selectedItem;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void O(long j2) {
        this.selectedItem = Long.valueOf(j2);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int d(Context context) {
        return com.google.android.material.f.b.c(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public String e(@NonNull Context context) {
        Resources resources = context.getResources();
        Long l2 = this.selectedItem;
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, d.j(l2.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @Nullable
    /* renamed from: f */
    public Long N() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    @NonNull
    public Collection<Pair<Long, Long>> v() {
        return new ArrayList();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View w(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle, CalendarConstraints calendarConstraints, @NonNull i<Long> iVar) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText L = textInputLayout.L();
        if (com.google.android.material.internal.d.a()) {
            L.setInputType(17);
        }
        SimpleDateFormat k2 = l.k();
        String l2 = l.l(inflate.getResources(), k2);
        textInputLayout.setPlaceholderText(l2);
        Long l3 = this.selectedItem;
        if (l3 != null) {
            L.setText(k2.format(l3));
        }
        L.addTextChangedListener(new a(l2, k2, textInputLayout, calendarConstraints, iVar));
        p.k(L);
        return inflate;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeValue(this.selectedItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean z() {
        return this.selectedItem != null;
    }
}
