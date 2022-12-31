package com.google.gson.internal.k;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* compiled from: DateTypeAdapter.java */
/* loaded from: classes2.dex */
public final class c extends q<Date> {
    public static final r FACTORY = new a();
    private final List<DateFormat> dateFormats;

    /* compiled from: DateTypeAdapter.java */
    /* loaded from: classes2.dex */
    class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new c();
            }
            return null;
        }
    }

    public c() {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (com.google.gson.internal.d.e()) {
            arrayList.add(com.google.gson.internal.g.e(2, 2));
        }
    }

    private synchronized Date deserializeToDate(String str) {
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

    @Override // com.google.gson.q
    public Date read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.c0() == JsonToken.NULL) {
            aVar.Y();
            return null;
        }
        return deserializeToDate(aVar.a0());
    }

    @Override // com.google.gson.q
    public synchronized void write(com.google.gson.stream.b bVar, Date date) throws IOException {
        if (date == null) {
            bVar.S();
        } else {
            bVar.f0(this.dateFormats.get(0).format(date));
        }
    }
}
