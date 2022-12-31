package com.tapjoy.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public final class au extends at implements ax, Closeable, Flushable {
    private final ax a;
    private final LinkedList b = new LinkedList();
    private final LinkedList c = new LinkedList();

    /* renamed from: d  reason: collision with root package name */
    private int f7316d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7317e;

    private au(ax axVar) {
        this.a = axVar;
        int size = axVar.size();
        this.f7316d = size;
        this.f7317e = size == 0;
    }

    public static au a(ax axVar) {
        return new au(axVar);
    }

    @Override // com.tapjoy.internal.ax
    public final void b(int i2) {
        if (i2 > 0 && i2 <= this.f7316d) {
            if (i2 <= this.b.size()) {
                aw.a(this.b, i2);
                this.a.b(i2);
            } else {
                this.b.clear();
                int size = (this.c.size() + i2) - this.f7316d;
                if (size < 0) {
                    this.a.b(i2);
                } else {
                    this.a.clear();
                    this.f7317e = true;
                    if (size > 0) {
                        aw.a(this.c, size);
                    }
                }
            }
            this.f7316d -= i2;
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            flush();
            ax axVar = this.a;
            if (axVar instanceof Closeable) {
                ((Closeable) axVar).close();
            }
        } catch (Throwable th) {
            if (this.a instanceof Closeable) {
                ((Closeable) this.a).close();
            }
            throw th;
        }
    }

    protected final void finalize() {
        close();
        super.finalize();
    }

    @Override // java.io.Flushable
    public final void flush() {
        if (this.c.isEmpty()) {
            return;
        }
        this.a.addAll(this.c);
        if (this.f7317e) {
            this.b.addAll(this.c);
        }
        this.c.clear();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        this.c.add(obj);
        this.f7316d++;
        return true;
    }

    @Override // java.util.Queue
    public final Object peek() {
        if (this.f7316d <= 0) {
            return null;
        }
        if (!this.b.isEmpty()) {
            return this.b.element();
        }
        if (this.f7317e) {
            return this.c.element();
        }
        Object peek = this.a.peek();
        this.b.add(peek);
        if (this.f7316d == this.b.size() + this.c.size()) {
            this.f7317e = true;
        }
        return peek;
    }

    @Override // java.util.Queue
    public final Object poll() {
        Object remove;
        if (this.f7316d <= 0) {
            return null;
        }
        if (!this.b.isEmpty()) {
            remove = this.b.remove();
            this.a.b(1);
        } else if (this.f7317e) {
            remove = this.c.remove();
        } else {
            remove = this.a.remove();
            if (this.f7316d == this.c.size() + 1) {
                this.f7317e = true;
            }
        }
        this.f7316d--;
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f7316d;
    }

    @Override // com.tapjoy.internal.ax
    public final Object a(int i2) {
        if (i2 >= 0 && i2 < this.f7316d) {
            int size = this.b.size();
            if (i2 < size) {
                return this.b.get(i2);
            }
            if (this.f7317e) {
                return this.c.get(i2 - size);
            }
            if (i2 < this.a.size()) {
                Object obj = null;
                while (size <= i2) {
                    obj = this.a.a(size);
                    this.b.add(obj);
                    size++;
                }
                if (i2 + 1 + this.c.size() == this.f7316d) {
                    this.f7317e = true;
                }
                return obj;
            }
            return this.c.get(i2 - this.a.size());
        }
        throw new IndexOutOfBoundsException();
    }
}
