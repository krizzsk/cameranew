package kotlin.jvm.internal;

import kotlin.reflect.i;
import kotlin.reflect.m;
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements kotlin.reflect.i {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        v.e(this);
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
        return ((kotlin.reflect.i) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.b.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    /* JADX WARN: Failed to parse method signature: (TTTV)V
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: (TTTV)V at position 2 ('T'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeMethodArgs(SignatureParser.java:318)
    	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:109)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
     */
    public abstract /* synthetic */ void set(Object obj, Object obj2);

    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public m.a getGetter() {
        return ((kotlin.reflect.i) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.reflect.h
    public i.a getSetter() {
        return ((kotlin.reflect.i) getReflected()).getSetter();
    }

    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
