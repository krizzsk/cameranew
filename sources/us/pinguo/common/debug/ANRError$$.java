package us.pinguo.common.debug;

import java.io.Serializable;
import us.pinguo.common.debug.ANRError;
/* JADX INFO: Access modifiers changed from: private */
/* loaded from: classes4.dex */
public class ANRError$$ implements Serializable {
    private final String _name;
    private final StackTraceElement[] _stackTrace;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class _Thread extends Throwable {
        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ _Thread(ANRError$$ aNRError$$, _Thread _thread, ANRError.a aVar) {
            this(_thread);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            setStackTrace(ANRError$$.this._stackTrace);
            return this;
        }

        private _Thread(_Thread _thread) {
            super(ANRError$$.this._name, _thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ANRError$$(String str, StackTraceElement[] stackTraceElementArr, ANRError.a aVar) {
        this(str, stackTraceElementArr);
    }

    private ANRError$$(String str, StackTraceElement[] stackTraceElementArr) {
        this._name = str;
        this._stackTrace = stackTraceElementArr;
    }
}
