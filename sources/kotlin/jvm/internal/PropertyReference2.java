package kotlin.jvm.internal;

import kotlin.reflect.n;
/* loaded from: classes3.dex */
public abstract class PropertyReference2 extends PropertyReference implements kotlin.reflect.n {
    public PropertyReference2() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        v.i(this);
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
        return ((kotlin.reflect.n) getReflected()).getDelegate(obj, obj2);
    }

    @Override // kotlin.jvm.b.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public PropertyReference2(Class cls, String str, String str2, int i2) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public n.a getGetter() {
        return ((kotlin.reflect.n) getReflected()).getGetter();
    }
}
