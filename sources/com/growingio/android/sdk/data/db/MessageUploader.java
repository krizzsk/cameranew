package com.growingio.android.sdk.data.db;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.growingio.android.sdk.collection.CoreAppState;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.CustomEvent;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.data.DiagnoseLog;
import com.growingio.android.sdk.data.net.HttpService;
import com.growingio.android.sdk.message.MessageHandler;
import com.growingio.android.sdk.models.ActionEvent;
import com.growingio.android.sdk.models.VisitEvent;
import com.growingio.android.sdk.utils.LogUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import us.pinguo.inspire.cell.recycler.a;
/* loaded from: classes2.dex */
public class MessageUploader {
    private static final int CLEAN_STALE_DATA = 2;
    private static final int FLUSH_ALL_EVENT = 3;
    private static final int FLUSH_CELLULAR_EVENT = 1;
    private static final int MAX_RETRY_TIMES = 2;
    private static final long MILLIS_OF_DAY = 86400000;
    static final String TAG = "GIO.MessageUploader";
    private static boolean sIsDebug = false;
    private Map<String, String> fullEventTypeMap;
    private GConfig mGConfig;
    private Handler mHandler;
    private AtomicInteger mCellularDataCount = new AtomicInteger(0);
    private AtomicInteger mImpressDataCount = new AtomicInteger(0);

    /* loaded from: classes2.dex */
    private class MessageUploaderHandler extends Handler {
        MessageUploaderHandler(Looper looper) {
            super(looper);
        }

        private void cleanStaleData() {
            MessageUploader.this.getDBAdapter().cleanupEvents(((System.currentTimeMillis() - 604800000) / 86400000) * 86400000);
        }

        private void uploadAllEvents() {
            if (uploadEventsInTurn(new UPLOAD_TYPE[]{UPLOAD_TYPE.AD, UPLOAD_TYPE.PV, UPLOAD_TYPE.CUSTOM, UPLOAD_TYPE.IMP, UPLOAD_TYPE.OTHER})) {
                MessageUploader.this.mImpressDataCount.set(0);
                MessageUploader.this.mCellularDataCount.set(0);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x00f9 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00fb  */
        @android.annotation.TargetApi(9)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private int uploadData(com.growingio.android.sdk.data.db.MessageUploader.UPLOAD_TYPE r18, java.util.List<java.lang.String> r19) throws org.json.JSONException {
            /*
                Method dump skipped, instructions count: 503
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.data.db.MessageUploader.MessageUploaderHandler.uploadData(com.growingio.android.sdk.data.db.MessageUploader$UPLOAD_TYPE, java.util.List):int");
        }

        @TargetApi(11)
        private Pair<Boolean, Boolean> uploadEvents(UPLOAD_TYPE upload_type) {
            int networkState = MessageUploader.this.getAPPState().networkState();
            DBAdapter dBAdapter = MessageUploader.this.getDBAdapter();
            Pair<String, List<String>> pair = null;
            int i2 = 0;
            boolean z = false;
            while (true) {
                if (i2 >= 2) {
                    break;
                }
                try {
                    try {
                        pair = dBAdapter.generateDataString(upload_type);
                    } catch (JSONException unused) {
                        LogUtil.d(MessageUploader.TAG, "generate data string error");
                        dBAdapter.cleanDataString(upload_type, (String) pair.first);
                    }
                } catch (Throwable th) {
                    if (th instanceof OutOfMemoryError) {
                        DiagnoseLog.saveLogIfEnabled("oomr");
                    } else if (th instanceof SQLiteCantOpenDatabaseException) {
                        DiagnoseLog.saveLogIfEnabled("dbo");
                    } else {
                        DiagnoseLog.saveLogIfEnabled(th.getClass().getSimpleName());
                        if (GConfig.DEBUG) {
                            th.printStackTrace();
                        }
                    }
                    i2++;
                }
                if (pair != null) {
                    int uploadData = uploadData(upload_type, (List) pair.second);
                    if (uploadData > 0) {
                        z = dBAdapter.cleanDataString(upload_type, (String) pair.first) > 0;
                        if (networkState == 1) {
                            MessageUploader.this.mGConfig.increaseCellularDataSize(uploadData);
                        }
                    } else {
                        i2++;
                        if (i2 >= 2) {
                            return Pair.create(Boolean.FALSE, Boolean.TRUE);
                        }
                    }
                } else {
                    Boolean bool = Boolean.FALSE;
                    return Pair.create(bool, bool);
                }
            }
            return Pair.create(Boolean.valueOf(z), Boolean.FALSE);
        }

        private boolean uploadEventsInTurn(UPLOAD_TYPE[] upload_typeArr) {
            int i2;
            boolean z = true;
            boolean z2 = true;
            while (z) {
                int length = upload_typeArr.length;
                boolean z3 = false;
                boolean z4 = true;
                while (i2 < length) {
                    Pair<Boolean, Boolean> uploadEvents = uploadEvents(upload_typeArr[i2]);
                    z3 |= ((Boolean) uploadEvents.first).booleanValue();
                    z4 &= !((Boolean) uploadEvents.second).booleanValue();
                    i2 = (MessageUploader.this.getAPPState().networkState() != 1 || MessageUploader.this.mGConfig.canSendByCellular()) ? i2 + 1 : 0;
                }
                z = z3;
                z2 = z4;
            }
            return z2;
        }

        private boolean uploadInstantEvents() {
            return uploadEventsInTurn(new UPLOAD_TYPE[]{UPLOAD_TYPE.AD, UPLOAD_TYPE.PV, UPLOAD_TYPE.CUSTOM, UPLOAD_TYPE.INSTANT_IMP, UPLOAD_TYPE.OTHER});
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                MessageUploader.this.mHandler.removeMessages(1);
                if (MessageUploader.this.getAPPState().networkState() >= 1 && MessageUploader.this.mGConfig.canSendByCellular() && uploadInstantEvents()) {
                    MessageUploader.this.mCellularDataCount.set(0);
                }
            } else if (i2 == 2) {
                cleanStaleData();
                MessageUploader.this.mHandler.sendEmptyMessageDelayed(2, 86400000L);
            } else if (i2 != 3) {
            } else {
                MessageUploader.this.mHandler.removeMessages(3);
                if (MessageUploader.this.getAPPState().networkState() == 2) {
                    uploadAllEvents();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum UPLOAD_TYPE {
        CUSTOM(CustomEvent.TYPE_NAME),
        PV("pv"),
        IMP(ActionEvent.IMP_TYPE_NAME),
        INSTANT_IMP(ActionEvent.IMP_TYPE_NAME),
        NON_INSTANT_IMP(ActionEvent.IMP_TYPE_NAME),
        OTHER(a.PAGE_TYPE_OTHER),
        AD("ctvt");
        
        private final String apiType;

        UPLOAD_TYPE(String str) {
            this.apiType = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.apiType;
        }
    }

    public MessageUploader(Context context) {
        HashMap hashMap = new HashMap();
        this.fullEventTypeMap = hashMap;
        hashMap.put(VisitEvent.TYPE_NAME, VisitEvent.FULL_TYPE_NAME);
        this.fullEventTypeMap.put(ActionEvent.CLICK_TYPE_NAME, "click");
        HandlerThread handlerThread = new HandlerThread(TAG, 1);
        handlerThread.start();
        this.mHandler = new MessageUploaderHandler(handlerThread.getLooper());
        this.mGConfig = CoreInitialize.config();
    }

    private void flushAllDelayed() {
        if (this.mHandler.hasMessages(3)) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(3, this.mGConfig.getFlushInterval());
    }

    private void flushAllEvent() {
        this.mHandler.removeMessages(3);
        this.mHandler.sendEmptyMessage(3);
    }

    private void flushCellularDataDelayed() {
        if (this.mHandler.hasMessages(1)) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(1, this.mGConfig.getFlushInterval());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CoreAppState getAPPState() {
        return CoreInitialize.coreAppState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFullType(String str) {
        String str2 = this.fullEventTypeMap.get(str);
        return str2 == null ? str : str2;
    }

    private boolean isNeedFlushImmediately(int i2) {
        return i2 > this.mGConfig.getUploadBulkSize() || this.mGConfig.isTestMode();
    }

    public static void setDebug(boolean z) {
        sIsDebug = z;
    }

    public void afterInit() {
        this.mHandler.post(new Runnable() { // from class: com.growingio.android.sdk.data.db.MessageUploader.1
            @Override // java.lang.Runnable
            public void run() {
                HttpService.sSystemDefaultFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
            }
        });
        this.mHandler.obtainMessage(2).sendToTarget();
    }

    public void flushCellularData() {
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
        DiagnoseLog.uploadImmediate();
    }

    DBAdapter getDBAdapter() {
        DBAdapter dBAdapter = DBAdapter.getsInstance();
        if (dBAdapter == null) {
            DBAdapter.initialize(getAPPState().getGlobalContext());
            return DBAdapter.getsInstance();
        }
        return dBAdapter;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void newEventSaved(boolean z, int i2) {
        if (getAPPState().networkState() == 2) {
            if (isNeedFlushImmediately(this.mCellularDataCount.get() + this.mImpressDataCount.addAndGet(i2))) {
                flushAllEvent();
                LogUtil.d(TAG, "non-instant event saved: ", Integer.valueOf(i2), "/", Integer.valueOf(this.mCellularDataCount.get()), "  flush data now");
            } else {
                flushAllDelayed();
                LogUtil.d(TAG, "non-instant event saved: ", Integer.valueOf(i2), "/", Integer.valueOf(this.mCellularDataCount.get()), "  flush data later");
            }
        } else if (getAPPState().networkState() == 1 && this.mGConfig.canSendByCellular() && z) {
            if (isNeedFlushImmediately(this.mCellularDataCount.addAndGet(i2))) {
                flushCellularData();
                LogUtil.d(TAG, "instant event saved: ", Integer.valueOf(i2), "/", Integer.valueOf(this.mCellularDataCount.get()), "  flush data now");
            } else {
                flushCellularDataDelayed();
                LogUtil.d(TAG, "instant event saved: ", Integer.valueOf(i2), "/", Integer.valueOf(this.mCellularDataCount.get()), "  flush data later");
            }
        }
        MessageHandler.handleMessage(4194304, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(this.mCellularDataCount.get()), Integer.valueOf(this.mImpressDataCount.get()));
    }
}
