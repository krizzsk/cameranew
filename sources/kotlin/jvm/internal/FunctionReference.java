package kotlin.jvm.internal;
/* loaded from: classes3.dex */
public class FunctionReference extends CallableReference implements q, kotlin.reflect.f {
    private final int arity;
    private final int flags;

    public FunctionReference(int i2) {
        this(i2, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        v.a(this);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && s.c(getBoundReceiver(), functionReference.getBoundReceiver()) && s.c(getOwner(), functionReference.getOwner());
        } else if (obj instanceof kotlin.reflect.f) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    @Override // kotlin.jvm.internal.q
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.reflect.f
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.f
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.reflect.f
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.f
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        kotlin.reflect.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public FunctionReference(int i2, Object obj) {
        this(i2, obj, null, null, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.f getReflected() {
        return (kotlin.reflect.f) super.getReflected();
    }

    public FunctionReference(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.arity = i2;
        this.flags = i3 >> 1;
    }
}
