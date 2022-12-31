package com.google.gson.internal.k;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeTypeAdapter.java */
/* loaded from: classes2.dex */
public final class k extends q<Time> {
    public static final r FACTORY = new a();
    private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter.java */
    /* loaded from: classes2.dex */
    class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> create(com.google.gson.e eVar, com.google.gson.t.a<T> aVar) {
            if (aVar.getRawType() == Time.class) {
                return new k();
            }
            return null;
        }
    }

    @Override // com.google.gson.q
    public synchronized Time read(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.c0() == JsonToken.NULL) {
            aVar.Y();
            return null;
        }
        try {
            return new Time(this.format.parse(aVar.a0()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.q
    public synchronized void write(com.google.gson.stream.b bVar, Time time) throws IOException {
        bVar.f0(time == null ? null : this.format.format((Date) time));
    }
}
