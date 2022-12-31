package us.pinguo.edit2020.utils;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: ViewState.kt */
/* loaded from: classes4.dex */
public abstract class k<ResultType> {
    public static final a a = new a(null);

    /* compiled from: ViewState.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }

        public final <ResultType> k<ResultType> a(Exception errorEntity) {
            s.h(errorEntity, "errorEntity");
            return new b(errorEntity);
        }

        public final <ResultType> k<ResultType> b() {
            return new c();
        }

        public final <ResultType> k<ResultType> c(ResultType resulttype) {
            return new d(resulttype);
        }
    }

    /* compiled from: ViewState.kt */
    /* loaded from: classes4.dex */
    public static final class b<ResultType> extends k<ResultType> {
        private final Exception b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Exception error) {
            super(null);
            s.h(error, "error");
            this.b = error;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && s.c(this.b, ((b) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.b + ')';
        }
    }

    /* compiled from: ViewState.kt */
    /* loaded from: classes4.dex */
    public static final class c<ResultType> extends k<ResultType> {
        public c() {
            super(null);
        }
    }

    /* compiled from: ViewState.kt */
    /* loaded from: classes4.dex */
    public static final class d<ResultType> extends k<ResultType> {
        private final ResultType b;

        public d(ResultType resulttype) {
            super(null);
            this.b = resulttype;
        }

        public final ResultType a() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && s.c(this.b, ((d) obj).b);
        }

        public int hashCode() {
            ResultType resulttype = this.b;
            if (resulttype == null) {
                return 0;
            }
            return resulttype.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.b + ')';
        }
    }

    private k() {
    }

    public /* synthetic */ k(o oVar) {
        this();
    }
}
