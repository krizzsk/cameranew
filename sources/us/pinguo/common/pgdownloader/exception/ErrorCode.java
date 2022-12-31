package us.pinguo.common.pgdownloader.exception;
/* compiled from: ErrorCode.kt */
/* loaded from: classes4.dex */
public final class ErrorCode {
    public static final int BLOCK_COUNT_ERROR = 800004;
    public static final int FILE_IO_ERROR = 800003;
    public static final ErrorCode INSTANCE = new ErrorCode();
    public static final int NETWORK_ERROR = 800002;
    public static final int REPEAT_SUBMIT_ERROR = 800001;
    public static final int TASK_STATUS_ERROR = 800005;
    public static final int UNKNOWN_ERROR = 800000;

    private ErrorCode() {
    }

    public static final String codeToString(int i2) {
        return i2 == 800001 ? "REPEAT_SUBMIT_ERROR" : i2 == 800002 ? "NETWORK_ERROR" : i2 == 800003 ? "FILE_IO_ERROR" : i2 == 800004 ? "BLOCK_COUNT_ERROR" : i2 == 800005 ? "TASK_STATUS_ERROR" : "UNKNOWN_ERROR";
    }
}
