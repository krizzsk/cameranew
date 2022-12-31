package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();
    public static final String NUMBER_FORMAT = "%d";
    public static final String ZERO_LEADING_NUMBER_FORMAT = "%02d";
    final int a;
    int b;
    int c;

    /* renamed from: d  reason: collision with root package name */
    int f4665d;

    /* renamed from: e  reason: collision with root package name */
    int f4666e;
    private final b hourInputValidator;
    private final b minuteInputValidator;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<TimeModel> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public TimeModel[] newArray(int i2) {
            return new TimeModel[i2];
        }
    }

    public TimeModel() {
        this(0);
    }

    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, ZERO_LEADING_NUMBER_FORMAT);
    }

    public static String b(Resources resources, CharSequence charSequence, String str) {
        return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    private static int h(int i2) {
        return i2 >= 12 ? 1 : 0;
    }

    public int c() {
        if (this.a == 1) {
            return this.b % 24;
        }
        int i2 = this.b;
        if (i2 % 12 == 0) {
            return 12;
        }
        return this.f4666e == 1 ? i2 - 12 : i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimeModel) {
            TimeModel timeModel = (TimeModel) obj;
            return this.b == timeModel.b && this.c == timeModel.c && this.a == timeModel.a && this.f4665d == timeModel.f4665d;
        }
        return false;
    }

    public b f() {
        return this.hourInputValidator;
    }

    public b g() {
        return this.minuteInputValidator;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.f4665d)});
    }

    public void j(int i2) {
        if (this.a == 1) {
            this.b = i2;
        } else {
            this.b = (i2 % 12) + (this.f4666e != 1 ? 0 : 12);
        }
    }

    public void k(@IntRange(from = 0, to = 60) int i2) {
        this.c = i2 % 60;
    }

    public void l(int i2) {
        if (i2 != this.f4666e) {
            this.f4666e = i2;
            int i3 = this.b;
            if (i3 < 12 && i2 == 1) {
                this.b = i3 + 12;
            } else if (i3 < 12 || i2 != 0) {
            } else {
                this.b = i3 - 12;
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.f4665d);
        parcel.writeInt(this.a);
    }

    public TimeModel(int i2) {
        this(0, 0, 10, i2);
    }

    public TimeModel(int i2, int i3, int i4, int i5) {
        this.b = i2;
        this.c = i3;
        this.f4665d = i4;
        this.a = i5;
        this.f4666e = h(i2);
        this.minuteInputValidator = new b(59);
        this.hourInputValidator = new b(i5 == 1 ? 24 : 12);
    }

    protected TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }
}
