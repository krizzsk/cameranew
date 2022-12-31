package kotlin.jvm.internal;

import kotlin.reflect.j;
import kotlin.reflect.n;
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements kotlin.reflect.j {
    public MutablePropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        v.f(this);
        return this;
    }

    /* JADX WARN: Failed to parse method signature: (TDTE)TV
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: (TDTE)TV at position 2 ('D'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeMethodArgs(SignatureParser.java:318)
    	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:109)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
     */
    public abstract /* synthetic */ Object get(Object obj, Object obj2);

    @Override // kotlin.reflect.n
    public Object getDelegate(Object obj, Object obj2) {
        return ((kotlin.reflect.j) getReflected()).getDelegate(obj, obj2);
    }

    @Override // kotlin.jvm.b.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    /* JADX WARN: Failed to parse method signature: (TDTETV)V
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: (TDTETV)V at position 2 ('D'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeMethodArgs(SignatureParser.java:318)
    	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:109)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
     */
    public abstract /* synthetic */ void set(Object obj, Object obj2, Object obj3);

    public MutablePropertyReference2(Class cls, String str, String str2, int i2) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public n.a getGetter() {
        return ((kotlin.reflect.j) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.reflect.h
    public j.a getSetter() {
        return ((kotlin.reflect.j) getReflected()).getSetter();
    }
}
