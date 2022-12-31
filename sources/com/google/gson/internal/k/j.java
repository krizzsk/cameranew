package com.google.gson.internal.k;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes2.dex */
public final class j extends q<Date> {
    public static final r FACTORY = new a();
    private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* loaded from: classes2.dex */
    class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new j();
            }
            return null;
        }
    }

    @Override // com.google.gson.q
    public synchronized Date read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.c0() == JsonToken.NULL) {
            aVar.Y();
            return null;
        }
        try {
            return new Date(this.format.parse(aVar.a0()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.q
    public synchronized void write(com.google.gson.stream.b bVar, Date date) throws IOException {
        bVar.f0(date == null ? null : this.format.format((java.util.Date) date));
    }
}
