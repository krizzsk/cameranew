package com.google.gson;

import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* compiled from: DefaultDateTypeAdapter.java */
/* loaded from: classes2.dex */
final class a extends q<Date> {
    private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
    private final List<DateFormat> dateFormats;
    private final Class<? extends Date> dateType;

    a(Class<? extends Date> cls) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = verifyDateType(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.d.e()) {
            arrayList.add(com.google.gson.internal.g.e(2, 2));
        }
    }

    private Date deserializeToDate(String str) {
        synchronized (this.dateFormats) {
            for (DateFormat dateFormat : this.dateFormats) {
                try {
                    return dateFormat.parse(str);
                } catch (ParseException unused) {
                }
            }
            try {
                return com.google.gson.internal.k.o.a.c(str, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new JsonSyntaxException(str, e2);
            }
        }
    }

    private static Class<? extends Date> verifyDateType(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    public String toString() {
        DateFormat dateFormat = this.dateFormats.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    @Override // com.google.gson.q
    public Date read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.c0() == JsonToken.NULL) {
            aVar.Y();
            return null;
        }
        Date deserializeToDate = deserializeToDate(aVar.a0());
        Class<? extends Date> cls = this.dateType;
        if (cls == Date.class) {
            return deserializeToDate;
        }
        if (cls == Timestamp.class) {
            return new Timestamp(deserializeToDate.getTime());
        }
        if (cls == java.sql.Date.class) {
            return new java.sql.Date(deserializeToDate.getTime());
        }
        throw new AssertionError();
    }

    @Override // com.google.gson.q
    public void write(com.google.gson.stream.b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.S();
            return;
        }
        synchronized (this.dateFormats) {
            bVar.f0(this.dateFormats.get(0).format(date));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Class<? extends Date> cls, String str) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = verifyDateType(cls);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    a(Class<? extends Date> cls, int i2) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = verifyDateType(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateInstance(i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateInstance(i2));
        }
        if (com.google.gson.internal.d.e()) {
            arrayList.add(com.google.gson.internal.g.d(i2));
        }
    }

    public a(int i2, int i3) {
        this(Date.class, i2, i3);
    }

    public a(Class<? extends Date> cls, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        this.dateType = verifyDateType(cls);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i2, i3, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i2, i3));
        }
        if (com.google.gson.internal.d.e()) {
            arrayList.add(com.google.gson.internal.g.e(i2, i3));
        }
    }
}
