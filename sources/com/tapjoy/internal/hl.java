package com.tapjoy.internal;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class hl implements Flushable {
    final Object a = this;
    ax b;
    private final File c;

    public hl(File file) {
        this.c = file;
        try {
            this.b = au.a(new g(file, new bd() { // from class: com.tapjoy.internal.hl.1
                @Override // com.tapjoy.internal.bf
                public final /* bridge */ /* synthetic */ void a(OutputStream outputStream, Object obj) {
                    ev.c.a(outputStream, (ev) obj);
                }

                @Override // com.tapjoy.internal.be
                public final /* synthetic */ Object b(InputStream inputStream) {
                    return (ev) ev.c.a(inputStream);
                }
            }));
        } catch (Exception unused) {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.c.delete();
        ax axVar = this.b;
        if (axVar instanceof Closeable) {
            try {
                ((Closeable) axVar).close();
            } catch (Exception unused) {
            }
        }
        this.b = new av(new LinkedList());
    }

    public final int b() {
        int size;
        synchronized (this.a) {
            try {
                try {
                    size = this.b.size();
                } catch (Exception unused) {
                    a();
                    return 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return size;
    }

    public final boolean c() {
        boolean isEmpty;
        synchronized (this.a) {
            try {
                try {
                    isEmpty = this.b.isEmpty();
                } catch (Exception unused) {
                    a();
                    return true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return isEmpty;
    }

    @Override // java.io.Flushable
    public final void flush() {
        synchronized (this.a) {
            ax axVar = this.b;
            if (axVar instanceof Flushable) {
                try {
                    ((Flushable) axVar).flush();
                } catch (Exception unused) {
                    a();
                }
            }
        }
    }

    public final void a(int i2) {
        synchronized (this.a) {
            try {
                this.b.b(i2);
            } catch (Exception unused) {
                a();
            }
        }
    }

    @Nullable
    public final ev b(int i2) {
        ev evVar;
        synchronized (this.a) {
            try {
                try {
                    evVar = (ev) this.b.a(i2);
                } catch (Exception unused) {
                    a();
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return evVar;
    }
}
