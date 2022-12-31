package com.google.gson.internal;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.k.n;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
/* compiled from: Streams.java */
/* loaded from: classes2.dex */
public final class i {
    public static k a(com.google.gson.stream.a aVar) throws JsonParseException {
        boolean z;
        try {
            try {
                aVar.c0();
                z = false;
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
            try {
                return n.X.read(aVar);
            } catch (EOFException e3) {
                e = e3;
                if (z) {
                    return l.a;
                }
                throw new JsonSyntaxException(e);
            }
        } catch (MalformedJsonException e4) {
            throw new JsonSyntaxException(e4);
        } catch (IOException e5) {
            throw new JsonIOException(e5);
        } catch (NumberFormatException e6) {
            throw new JsonSyntaxException(e6);
        }
    }

    public static void b(k kVar, com.google.gson.stream.b bVar) throws IOException {
        n.X.write(bVar, kVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Streams.java */
    /* loaded from: classes2.dex */
    public static final class a extends Writer {
        private final Appendable a;
        private final C0188a b = new C0188a();

        /* compiled from: Streams.java */
        /* renamed from: com.google.gson.internal.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static class C0188a implements CharSequence {
            char[] a;

            C0188a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.a[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.a, i2, i3 - i2);
            }
        }

        a(Appendable appendable) {
            this.a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            C0188a c0188a = this.b;
            c0188a.a = cArr;
            this.a.append(c0188a, i2, i3 + i2);
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            this.a.append((char) i2);
        }
    }
}
