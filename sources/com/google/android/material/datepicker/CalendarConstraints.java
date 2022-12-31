package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import com.facebook.ads.AdError;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();
    @NonNull
    private final Month end;
    private final int monthSpan;
    @Nullable
    private Month openAt;
    @NonNull
    private final Month start;
    @NonNull
    private final DateValidator validator;
    private final int yearSpan;

    /* loaded from: classes2.dex */
    public interface DateValidator extends Parcelable {
        boolean i(long j2);
    }

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<CalendarConstraints> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public CalendarConstraints[] newArray(int i2) {
            return new CalendarConstraints[i2];
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: e  reason: collision with root package name */
        static final long f4200e = l.a(Month.b(1900, 0).f4223e);

        /* renamed from: f  reason: collision with root package name */
        static final long f4201f = l.a(Month.b(AdError.BROKEN_MEDIA_ERROR_CODE, 11).f4223e);
        private long a;
        private long b;
        private Long c;

        /* renamed from: d  reason: collision with root package name */
        private DateValidator f4202d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(@NonNull CalendarConstraints calendarConstraints) {
            this.a = f4200e;
            this.b = f4201f;
            this.f4202d = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.a = calendarConstraints.start.f4223e;
            this.b = calendarConstraints.end.f4223e;
            this.c = Long.valueOf(calendarConstraints.openAt.f4223e);
            this.f4202d = calendarConstraints.validator;
        }

        @NonNull
        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f4202d);
            Month c = Month.c(this.a);
            Month c2 = Month.c(this.b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l2 = this.c;
            return new CalendarConstraints(c, c2, dateValidator, l2 == null ? null : Month.c(l2.longValue()), null);
        }

        @NonNull
        public b b(long j2) {
            this.c = Long.valueOf(j2);
            return this;
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, a aVar) {
        this(month, month2, dateValidator, month3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CalendarConstraints) {
            CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
            return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && ObjectsCompat.equals(this.openAt, calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month g(Month month) {
        if (month.compareTo(this.start) < 0) {
            return this.start;
        }
        return month.compareTo(this.end) > 0 ? this.end : month;
    }

    public DateValidator h() {
        return this.validator;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month j() {
        return this.end;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.monthSpan;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Month l() {
        return this.openAt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month m() {
        return this.start;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.yearSpan;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(long j2) {
        if (this.start.h(1) <= j2) {
            Month month = this.end;
            if (j2 <= month.h(month.f4222d)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.monthSpan = month.n(month2) + 1;
        this.yearSpan = (month2.b - month.b) + 1;
    }
}
