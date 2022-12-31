package com.tapjoy.internal;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;
/* loaded from: classes3.dex */
public abstract class eh implements Serializable {
    transient int a = 0;
    protected transient int b = 0;
    private final transient ej c;

    /* renamed from: d  reason: collision with root package name */
    private final transient iu f7399d;

    /* JADX INFO: Access modifiers changed from: protected */
    public eh(ej ejVar, iu iuVar) {
        Objects.requireNonNull(ejVar, "adapter == null");
        Objects.requireNonNull(iuVar, "unknownFields == null");
        this.c = ejVar;
        this.f7399d = iuVar;
    }

    public final iu a() {
        iu iuVar = this.f7399d;
        return iuVar != null ? iuVar : iu.b;
    }

    public String toString() {
        return ej.c(this);
    }

    /* loaded from: classes3.dex */
    public static abstract class a {
        ir a;
        el b;

        public final a a(iu iuVar) {
            if (iuVar.c() > 0) {
                if (this.b == null) {
                    ir irVar = new ir();
                    this.a = irVar;
                    this.b = new el(irVar);
                }
                try {
                    this.b.a(iuVar);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final a a(int i2, eg egVar, Object obj) {
            if (this.b == null) {
                ir irVar = new ir();
                this.a = irVar;
                this.b = new el(irVar);
            }
            try {
                egVar.a().a(this.b, i2, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        public final iu a() {
            ir irVar = this.a;
            if (irVar != null) {
                return new iu(irVar.clone().g());
            }
            return iu.b;
        }
    }
}
