package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes3.dex */
public final class bt implements Closeable {
    final Writer a;
    private final List b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f7343d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7344e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tapjoy.internal.bt$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[bq.values().length];
            a = iArr;
            try {
                iArr[bq.EMPTY_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bq.EMPTY_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[bq.NONEMPTY_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[bq.DANGLING_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[bq.NONEMPTY_DOCUMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public bt(Writer writer) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(bq.EMPTY_DOCUMENT);
        this.f7343d = ":";
        Objects.requireNonNull(writer, "out == null");
        this.a = writer;
    }

    private bq e() {
        List list = this.b;
        return (bq) list.get(list.size() - 1);
    }

    private bt f() {
        a(false);
        this.a.write("null");
        return this;
    }

    private void g() {
        if (this.c == null) {
            return;
        }
        this.a.write("\n");
        for (int i2 = 1; i2 < this.b.size(); i2++) {
            this.a.write(this.c);
        }
    }

    public final bt a() {
        return a(bq.EMPTY_ARRAY, "[");
    }

    public final bt b() {
        return a(bq.EMPTY_ARRAY, bq.NONEMPTY_ARRAY, "]");
    }

    public final bt c() {
        return a(bq.EMPTY_OBJECT, "{");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
        if (e() != bq.NONEMPTY_DOCUMENT) {
            throw new IOException("Incomplete document");
        }
    }

    public final bt d() {
        return a(bq.EMPTY_OBJECT, bq.NONEMPTY_OBJECT, "}");
    }

    private bt a(bq bqVar, String str) {
        a(true);
        this.b.add(bqVar);
        this.a.write(str);
        return this;
    }

    private void c(String str) {
        this.a.write("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\f') {
                this.a.write("\\f");
            } else if (charAt != '\r') {
                if (charAt == '\"' || charAt == '\\') {
                    this.a.write(92);
                } else if (charAt != 8232 && charAt != 8233) {
                    switch (charAt) {
                        case '\b':
                            this.a.write("\\b");
                            break;
                        case '\t':
                            this.a.write("\\t");
                            break;
                        case '\n':
                            this.a.write("\\n");
                            break;
                        default:
                            if (charAt <= 31) {
                                this.a.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                                break;
                            }
                            break;
                    }
                } else {
                    this.a.write(String.format("\\u%04x", Integer.valueOf(charAt)));
                }
                this.a.write(charAt);
            } else {
                this.a.write("\\r");
            }
        }
        this.a.write("\"");
    }

    public final bt b(String str) {
        if (str == null) {
            return f();
        }
        a(false);
        c(str);
        return this;
    }

    private bt a(bq bqVar, bq bqVar2, String str) {
        bq e2 = e();
        if (e2 != bqVar2 && e2 != bqVar) {
            throw new IllegalStateException("Nesting problem: " + this.b);
        }
        List list = this.b;
        list.remove(list.size() - 1);
        if (e2 == bqVar2) {
            g();
        }
        this.a.write(str);
        return this;
    }

    private void a(bq bqVar) {
        List list = this.b;
        list.set(list.size() - 1, bqVar);
    }

    public final bt a(String str) {
        Objects.requireNonNull(str, "name == null");
        bq e2 = e();
        if (e2 == bq.NONEMPTY_OBJECT) {
            this.a.write(44);
        } else if (e2 != bq.EMPTY_OBJECT) {
            throw new IllegalStateException("Nesting problem: " + this.b);
        }
        g();
        a(bq.DANGLING_NAME);
        c(str);
        return this;
    }

    public final bt a(long j2) {
        a(false);
        this.a.write(Long.toString(j2));
        return this;
    }

    public final bt a(Number number) {
        if (number == null) {
            return f();
        }
        String obj = number.toString();
        if (!this.f7344e && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        a(false);
        this.a.append((CharSequence) obj);
        return this;
    }

    private void a(boolean z) {
        int i2 = AnonymousClass1.a[e().ordinal()];
        if (i2 == 1) {
            if (!this.f7344e && !z) {
                throw new IllegalStateException("JSON must start with an array or an object.");
            }
            a(bq.NONEMPTY_DOCUMENT);
        } else if (i2 == 2) {
            a(bq.NONEMPTY_ARRAY);
            g();
        } else if (i2 == 3) {
            this.a.append(',');
            g();
        } else if (i2 == 4) {
            this.a.append((CharSequence) this.f7343d);
            a(bq.NONEMPTY_OBJECT);
        } else if (i2 != 5) {
            throw new IllegalStateException("Nesting problem: " + this.b);
        } else {
            throw new IllegalStateException("JSON must have only one top-level value.");
        }
    }

    public final bt a(Object obj) {
        if (obj == null) {
            return f();
        }
        if (obj instanceof br) {
            if (this.b.size() == this.b.size()) {
                return this;
            }
            throw new IllegalStateException(obj.getClass().getName() + ".writeToJson(JsonWriter) wrote incomplete value");
        } else if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            a(false);
            this.a.write(booleanValue ? "true" : "false");
            return this;
        } else if (obj instanceof Number) {
            if (obj instanceof Long) {
                return a(((Number) obj).longValue());
            }
            if (obj instanceof Double) {
                double doubleValue = ((Number) obj).doubleValue();
                if (!this.f7344e && (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue))) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was " + doubleValue);
                }
                a(false);
                this.a.append((CharSequence) Double.toString(doubleValue));
                return this;
            }
            return a((Number) obj);
        } else if (obj instanceof String) {
            return b((String) obj);
        } else {
            if (obj instanceof bl) {
                return a((bl) obj);
            }
            if (obj instanceof Collection) {
                return a((Collection) obj);
            }
            if (obj instanceof Map) {
                return a((Map) obj);
            }
            if (obj instanceof Date) {
                Date date = (Date) obj;
                if (date == null) {
                    return f();
                }
                return b(w.a(date));
            } else if (obj instanceof Object[]) {
                return a((Object[]) obj);
            } else {
                throw new IllegalArgumentException("Unknown type: " + obj.getClass().getName());
            }
        }
    }

    private bt a(Object[] objArr) {
        if (objArr == null) {
            return f();
        }
        a();
        for (Object obj : objArr) {
            a(obj);
        }
        b();
        return this;
    }

    public final bt a(bl blVar) {
        a(false);
        blVar.a(this.a);
        return this;
    }

    public final bt a(Collection collection) {
        if (collection == null) {
            return f();
        }
        a();
        for (Object obj : collection) {
            a(obj);
        }
        b();
        return this;
    }

    public final bt a(Map map) {
        if (map == null) {
            return f();
        }
        c();
        for (Map.Entry entry : map.entrySet()) {
            a(String.valueOf(entry.getKey()));
            a(entry.getValue());
        }
        d();
        return this;
    }
}
