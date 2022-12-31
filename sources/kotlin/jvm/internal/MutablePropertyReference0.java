package kotlin.jvm.internal;

import kotlin.reflect.h;
import kotlin.reflect.l;
/* loaded from: classes3.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements kotlin.reflect.h {
    public MutablePropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        v.d(this);
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
        return ((kotlin.reflect.h) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.b.a
    public Object invoke() {
        return get();
    }

    /* JADX WARN: Failed to parse method signature: (TV)V
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: (TV)V at position 2 ('V'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeMethodArgs(SignatureParser.java:318)
    	at jadx.core.dex.visitors.SignatureProcessor.parseMethodSignature(SignatureProcessor.java:109)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:36)
     */
    public abstract /* synthetic */ void set(Object obj);

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.jvm.internal.PropertyReference
    public l.a getGetter() {
        return ((kotlin.reflect.h) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference, kotlin.reflect.h
    public h.a getSetter() {
        return ((kotlin.reflect.h) getReflected()).getSetter();
    }

    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
