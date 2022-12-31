package com.growingio.android.sdk.monitor;

import com.growingio.android.sdk.monitor.connection.Connection;
import com.growingio.android.sdk.monitor.connection.HttpConnection;
import com.growingio.android.sdk.monitor.context.ContextManager;
import com.growingio.android.sdk.monitor.context.ThreadLocalContextManager;
import com.growingio.android.sdk.monitor.dsn.Dsn;
import com.growingio.android.sdk.monitor.event.helper.ContextBuilderHelper;
import com.growingio.android.sdk.monitor.event.interfaces.ExceptionInterface;
import com.growingio.android.sdk.monitor.event.interfaces.MessageInterface;
import com.growingio.android.sdk.monitor.event.interfaces.StackTraceInterface;
import com.growingio.android.sdk.monitor.event.interfaces.UserInterface;
import com.growingio.android.sdk.monitor.jvmti.FrameCache;
import com.growingio.android.sdk.monitor.marshaller.json.ExceptionInterfaceBinding;
import com.growingio.android.sdk.monitor.marshaller.json.JsonMarshaller;
import com.growingio.android.sdk.monitor.marshaller.json.MessageInterfaceBinding;
import com.growingio.android.sdk.monitor.marshaller.json.StackTraceInterfaceBinding;
import com.growingio.android.sdk.monitor.marshaller.json.UserInterfaceBinding;
import java.util.Collection;
import java.util.Collections;
/* loaded from: classes2.dex */
public class DefaultMonitorClientFactory extends MonitorClientFactory {
    protected MonitorClient configureMonitorClient(MonitorClient monitorClient, Dsn dsn) {
        for (String str : getInAppFrames(dsn)) {
            FrameCache.addAppPackage(str);
        }
        return monitorClient;
    }

    protected Connection createConnection(String str, Dsn dsn) {
        return createHttpConnection(str, dsn);
    }

    protected Connection createHttpConnection(String str, Dsn dsn) {
        JsonMarshaller jsonMarshaller = new JsonMarshaller();
        StackTraceInterfaceBinding stackTraceInterfaceBinding = new StackTraceInterfaceBinding();
        stackTraceInterfaceBinding.setInAppFrames(getInAppFrames(dsn));
        jsonMarshaller.addInterfaceBinding(StackTraceInterface.class, stackTraceInterfaceBinding);
        jsonMarshaller.addInterfaceBinding(ExceptionInterface.class, new ExceptionInterfaceBinding(stackTraceInterfaceBinding));
        jsonMarshaller.addInterfaceBinding(MessageInterface.class, new MessageInterfaceBinding());
        jsonMarshaller.addInterfaceBinding(UserInterface.class, new UserInterfaceBinding());
        return new HttpConnection(str, dsn, jsonMarshaller);
    }

    @Override // com.growingio.android.sdk.monitor.MonitorClientFactory
    public MonitorClient createMonitorClient(String str, Dsn dsn) {
        MonitorClient monitorClient = new MonitorClient(str, createConnection(str, dsn), getContextManager(dsn));
        monitorClient.addBuilderHelper(new ContextBuilderHelper(monitorClient));
        return configureMonitorClient(monitorClient, dsn);
    }

    protected ContextManager getContextManager(Dsn dsn) {
        return new ThreadLocalContextManager();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<String> getInAppFrames(Dsn dsn) {
        return Collections.emptyList();
    }
}
