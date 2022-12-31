package kotlin.jvm.internal;

import kotlin.reflect.l;
/* loaded from: classes3.dex */
public abstract class PropertyReference0 extends PropertyReference implements kotlin.reflect.l {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        v.g(this);
        return this;
    }

    /* JADX WARN: Failed to parse method signature: ()TV
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: ()TV at position 3 ('V'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:110)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
     */
    public abstract /* synthetic */ Object get();

    @Override // kotlin.reflect.l
    public Object getDelegate() {
        return ((kotlin.reflect.l) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.b.a
    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public l.a getGetter() {
        return ((kotlin.reflect.l) getReflected()).getGetter();
    }

    public PropertyReference0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
