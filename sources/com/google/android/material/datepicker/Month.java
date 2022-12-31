package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();
    final int a;
    final int b;
    final int c;

    /* renamed from: d  reason: collision with root package name */
    final int f4222d;

    /* renamed from: e  reason: collision with root package name */
    final long f4223e;
    @NonNull
    private final Calendar firstOfMonth;
    @Nullable
    private String longName;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<Month> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.b(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public Month[] newArray(int i2) {
            return new Month[i2];
        }
    }

    private Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar f2 = l.f(calendar);
        this.firstOfMonth = f2;
        this.a = f2.get(2);
        this.b = f2.get(1);
        this.c = f2.getMaximum(7);
        this.f4222d = f2.getActualMaximum(5);
        this.f4223e = f2.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month b(int i2, int i3) {
        Calendar q = l.q();
        q.set(1, i2);
        q.set(2, i3);
        return new Month(q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month c(long j2) {
        Calendar q = l.q();
        q.setTimeInMillis(j2);
        return new Month(q);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Month f() {
        return new Month(l.o());
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NonNull Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Month) {
            Month month = (Month) obj;
            return this.a == month.a && this.b == month.b;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.c : firstDayOfWeek;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h(int i2) {
        Calendar f2 = l.f(this.firstOfMonth);
        f2.set(5, i2);
        return f2.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(long j2) {
        Calendar f2 = l.f(this.firstOfMonth);
        f2.setTimeInMillis(j2);
        return f2.get(5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String k(Context context) {
        if (this.longName == null) {
            this.longName = d.i(context, this.firstOfMonth.getTimeInMillis());
        }
        return this.longName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long l() {
        return this.firstOfMonth.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month m(int i2) {
        Calendar f2 = l.f(this.firstOfMonth);
        f2.add(2, i2);
        return new Month(f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n(@NonNull Month month) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return ((month.b - this.b) * 12) + (month.a - this.a);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.a);
    }
}
