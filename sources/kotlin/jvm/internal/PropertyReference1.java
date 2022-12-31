package kotlin.jvm.internal;

import kotlin.reflect.m;
/* loaded from: classes3.dex */
public abstract class PropertyReference1 extends PropertyReference implements kotlin.reflect.m {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        v.h(this);
        return this;
    }

    /* JADX WARN: Failed to parse method signature: (TT)TV
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: (TT)TV at position 2 ('T'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeMethodArgs(SignatureParser.java:318)
    	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:109)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
     */
    public abstract /* synthetic */ Object get(Object obj);

    @Override // kotlin.reflect.m
    public Object getDelegate(Object obj) {
        return ((kotlin.reflect.m) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.b.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.PropertyReference
    public m.a getGetter() {
        return ((kotlin.reflect.m) getReflected()).getGetter();
    }

    public PropertyReference1(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
