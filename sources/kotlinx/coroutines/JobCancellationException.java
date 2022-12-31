package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public final class JobCancellationException extends CancellationException implements g0<JobCancellationException> {
    public final v1 job;

    public JobCancellationException(String str, Throwable th, v1 v1Var) {
        super(str);
        this.job = v1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!kotlin.jvm.internal.s.c(jobCancellationException.getMessage(), getMessage()) || !kotlin.jvm.internal.s.c(jobCancellationException.job, this.job) || !kotlin.jvm.internal.s.c(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        if (o0.c()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.s.e(message);
        int hashCode = ((message.hashCode() * 31) + this.job.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause == null ? 0 : cause.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }

    @Override // kotlinx.coroutines.g0
    public JobCancellationException createCopy() {
        if (o0.c()) {
            String message = getMessage();
            kotlin.jvm.internal.s.e(message);
            return new JobCancellationException(message, this, this.job);
        }
        return null;
    }
}
