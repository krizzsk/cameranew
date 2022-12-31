package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
/* loaded from: classes3.dex */
public abstract class CallableReference implements kotlin.reflect.b, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.INSTANCE;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient kotlin.reflect.b reflected;
    private final String signature;

    /* loaded from: classes3.dex */
    private static class NoReceiver implements Serializable {
        private static final NoReceiver INSTANCE = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // kotlin.reflect.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // kotlin.reflect.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public kotlin.reflect.b compute() {
        kotlin.reflect.b bVar = this.reflected;
        if (bVar == null) {
            kotlin.reflect.b computeReflected = computeReflected();
            this.reflected = computeReflected;
            return computeReflected;
        }
        return bVar;
    }

    protected abstract kotlin.reflect.b computeReflected();

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public kotlin.reflect.e getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? v.c(cls) : v.b(cls);
    }

    @Override // kotlin.reflect.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public kotlin.reflect.b getReflected() {
        kotlin.reflect.b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.b
    public kotlin.reflect.o getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // kotlin.reflect.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.b
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }
}
