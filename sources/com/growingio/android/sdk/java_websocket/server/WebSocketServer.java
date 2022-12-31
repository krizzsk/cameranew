package com.growingio.android.sdk.java_websocket.server;

import com.growingio.android.sdk.java_websocket.WebSocket;
import com.growingio.android.sdk.java_websocket.WebSocketAdapter;
import com.growingio.android.sdk.java_websocket.WebSocketFactory;
import com.growingio.android.sdk.java_websocket.WebSocketImpl;
import com.growingio.android.sdk.java_websocket.drafts.Draft;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshake;
import com.growingio.android.sdk.java_websocket.handshake.Handshakedata;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshakeBuilder;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.Thread;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public abstract class WebSocketServer extends WebSocketAdapter implements Runnable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static int DECODERS = Runtime.getRuntime().availableProcessors();
    private final InetSocketAddress address;
    private BlockingQueue<ByteBuffer> buffers;
    private final Collection<WebSocket> connections;
    private List<WebSocketWorker> decoders;
    private List<Draft> drafts;
    private List<WebSocketImpl> iqueue;
    private final AtomicBoolean isclosed;
    private int queueinvokes;
    private final AtomicInteger queuesize;
    private Selector selector;
    private Thread selectorthread;
    private ServerSocketChannel server;
    private WebSocketServerFactory wsf;

    /* loaded from: classes2.dex */
    public interface WebSocketServerFactory extends WebSocketFactory {
        @Override // com.growingio.android.sdk.java_websocket.WebSocketFactory
        WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, Draft draft, Socket socket);

        @Override // com.growingio.android.sdk.java_websocket.WebSocketFactory
        WebSocketImpl createWebSocket(WebSocketAdapter webSocketAdapter, List<Draft> list, Socket socket);

        ByteChannel wrapChannel(SocketChannel socketChannel, SelectionKey selectionKey) throws IOException;
    }

    /* loaded from: classes2.dex */
    public class WebSocketWorker extends Thread {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private BlockingQueue<WebSocketImpl> iqueue = new LinkedBlockingQueue();

        public WebSocketWorker() {
            setName("WebSocketWorker-" + getId());
            setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.growingio.android.sdk.java_websocket.server.WebSocketServer.WebSocketWorker.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, th);
                }
            });
        }

        public void put(WebSocketImpl webSocketImpl) throws InterruptedException {
            this.iqueue.put(webSocketImpl);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            WebSocketImpl webSocketImpl;
            RuntimeException e2;
            WebSocketServer webSocketServer;
            WebSocketImpl webSocketImpl2 = null;
            while (true) {
                try {
                    try {
                        webSocketImpl = this.iqueue.take();
                        try {
                            ByteBuffer poll = webSocketImpl.inQueue.poll();
                            try {
                                try {
                                    webSocketImpl.decode(poll);
                                    webSocketServer = WebSocketServer.this;
                                } catch (Exception e3) {
                                    PrintStream printStream = System.err;
                                    printStream.println("Error while reading from remote connection: " + e3);
                                    webSocketServer = WebSocketServer.this;
                                }
                                webSocketServer.pushBuffer(poll);
                                webSocketImpl2 = webSocketImpl;
                            } catch (Throwable th) {
                                WebSocketServer.this.pushBuffer(poll);
                                throw th;
                            }
                        } catch (RuntimeException e4) {
                            e2 = e4;
                            WebSocketServer.this.handleFatal(webSocketImpl, e2);
                            return;
                        }
                    } catch (RuntimeException e5) {
                        webSocketImpl = webSocketImpl2;
                        e2 = e5;
                    }
                } catch (InterruptedException unused) {
                    return;
                }
            }
        }
    }

    public WebSocketServer() throws UnknownHostException {
        this(new InetSocketAddress(80), DECODERS, null);
    }

    private Socket getSocket(WebSocket webSocket) {
        return ((SocketChannel) ((WebSocketImpl) webSocket).key.channel()).socket();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFatal(WebSocket webSocket, Exception exc) {
        onError(webSocket, exc);
        try {
            stop();
        } catch (IOException e2) {
            onError(null, e2);
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            onError(null, e3);
        }
    }

    private void handleIOException(SelectionKey selectionKey, WebSocket webSocket, IOException iOException) {
        SelectableChannel channel;
        if (webSocket != null) {
            webSocket.closeConnection(1006, iOException.getMessage());
        } else if (selectionKey == null || (channel = selectionKey.channel()) == null || !channel.isOpen()) {
        } else {
            try {
                channel.close();
            } catch (IOException unused) {
            }
            if (WebSocketImpl.DEBUG) {
                PrintStream printStream = System.out;
                printStream.println("Connection closed because of" + iOException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushBuffer(ByteBuffer byteBuffer) throws InterruptedException {
        if (this.buffers.size() > this.queuesize.intValue()) {
            return;
        }
        this.buffers.put(byteBuffer);
    }

    private void queue(WebSocketImpl webSocketImpl) throws InterruptedException {
        if (webSocketImpl.workerThread == null) {
            List<WebSocketWorker> list = this.decoders;
            webSocketImpl.workerThread = list.get(this.queueinvokes % list.size());
            this.queueinvokes++;
        }
        webSocketImpl.workerThread.put(webSocketImpl);
    }

    private ByteBuffer takeBuffer() throws InterruptedException {
        return this.buffers.take();
    }

    protected boolean addConnection(WebSocket webSocket) {
        boolean add;
        if (!this.isclosed.get()) {
            synchronized (this.connections) {
                add = this.connections.add(webSocket);
            }
            return add;
        }
        webSocket.close(1001);
        return true;
    }

    protected void allocateBuffers(WebSocket webSocket) throws InterruptedException {
        if (this.queuesize.get() >= (this.decoders.size() * 2) + 1) {
            return;
        }
        this.queuesize.incrementAndGet();
        this.buffers.put(createBuffer());
    }

    public Collection<WebSocket> connections() {
        return this.connections;
    }

    public ByteBuffer createBuffer() {
        return ByteBuffer.allocate(WebSocketImpl.RCVBUF);
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    public List<Draft> getDraft() {
        return Collections.unmodifiableList(this.drafts);
    }

    protected String getFlashSecurityPolicy() {
        return "<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"" + getPort() + "\" /></cross-domain-policy>";
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        return (InetSocketAddress) getSocket(webSocket).getLocalSocketAddress();
    }

    public int getPort() {
        ServerSocketChannel serverSocketChannel;
        int port = getAddress().getPort();
        return (port != 0 || (serverSocketChannel = this.server) == null) ? port : serverSocketChannel.socket().getLocalPort();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        return (InetSocketAddress) getSocket(webSocket).getRemoteSocketAddress();
    }

    public final WebSocketFactory getWebSocketFactory() {
        return this.wsf;
    }

    public abstract void onClose(WebSocket webSocket, int i2, String str, boolean z);

    public void onCloseInitiated(WebSocket webSocket, int i2, String str) {
    }

    public void onClosing(WebSocket webSocket, int i2, String str, boolean z) {
    }

    protected boolean onConnect(SelectionKey selectionKey) {
        return true;
    }

    public abstract void onError(WebSocket webSocket, Exception exc);

    public void onFragment(WebSocket webSocket, Framedata framedata) {
    }

    public abstract void onMessage(WebSocket webSocket, String str);

    public void onMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(WebSocket webSocket, ClientHandshake clientHandshake);

    public void onServerStarted() {
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i2, String str, boolean z) {
        this.selector.wakeup();
        try {
            if (removeConnection(webSocket)) {
                onClose(webSocket, i2, str, z);
            }
            try {
                releaseBuffers(webSocket);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } catch (Throwable th) {
            try {
                releaseBuffers(webSocket);
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i2, String str) {
        onCloseInitiated(webSocket, i2, str);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i2, String str, boolean z) {
        onClosing(webSocket, i2, str, z);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(webSocket, exc);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketAdapter, com.growingio.android.sdk.java_websocket.WebSocketListener
    public ServerHandshakeBuilder onWebsocketHandshakeReceivedAsServer(WebSocket webSocket, Draft draft, ClientHandshake clientHandshake) throws InvalidDataException {
        return super.onWebsocketHandshakeReceivedAsServer(webSocket, draft, clientHandshake);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(webSocket, str);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketAdapter, com.growingio.android.sdk.java_websocket.WebSocketListener
    @Deprecated
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
        onFragment(webSocket, framedata);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        if (addConnection(webSocket)) {
            onOpen(webSocket, (ClientHandshake) handshakedata);
        }
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
        WebSocketImpl webSocketImpl = (WebSocketImpl) webSocket;
        try {
            webSocketImpl.key.interestOps(5);
        } catch (CancelledKeyException unused) {
            webSocketImpl.outQueue.clear();
        }
        this.selector.wakeup();
    }

    protected void releaseBuffers(WebSocket webSocket) throws InterruptedException {
    }

    protected boolean removeConnection(WebSocket webSocket) {
        boolean remove;
        synchronized (this.connections) {
            remove = this.connections.remove(webSocket);
        }
        if (this.isclosed.get() && this.connections.size() == 0) {
            this.selectorthread.interrupt();
        }
        return remove;
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x01a8 A[Catch: all -> 0x01f6, RuntimeException -> 0x01f8, TRY_ENTER, TryCatch #0 {RuntimeException -> 0x01f8, blocks: (B:12:0x005f, B:14:0x0067, B:16:0x0078, B:18:0x007e, B:19:0x0084, B:22:0x008b, B:24:0x0092, B:26:0x0098, B:27:0x009c, B:29:0x00c9, B:31:0x00cf, B:32:0x00d5, B:33:0x00d9, B:35:0x00e1, B:37:0x00e7, B:39:0x00f8, B:41:0x0100, B:42:0x0106, B:43:0x010a, B:46:0x0110, B:47:0x0113, B:96:0x01a8, B:97:0x01ab, B:50:0x0117, B:52:0x011d, B:53:0x0123, B:55:0x012b, B:57:0x0131, B:61:0x013a, B:63:0x0142, B:64:0x014a, B:65:0x0152, B:67:0x0158, B:68:0x015d, B:70:0x0163, B:71:0x016c, B:74:0x0172, B:75:0x0175), top: B:161:0x005f, outer: #11 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.java_websocket.server.WebSocketServer.run():void");
    }

    public final void setWebSocketFactory(WebSocketServerFactory webSocketServerFactory) {
        this.wsf = webSocketServerFactory;
    }

    public void start() {
        if (this.selectorthread == null) {
            new Thread(this).start();
            return;
        }
        throw new IllegalStateException(getClass().getName() + " can only be started once.");
    }

    public void stop(int i2) throws InterruptedException {
        ArrayList<WebSocket> arrayList;
        if (this.isclosed.compareAndSet(false, true)) {
            synchronized (this.connections) {
                arrayList = new ArrayList(this.connections);
            }
            for (WebSocket webSocket : arrayList) {
                webSocket.close(1001);
            }
            synchronized (this) {
                Thread thread = this.selectorthread;
                if (thread != null && thread != Thread.currentThread()) {
                    this.selector.wakeup();
                    this.selectorthread.interrupt();
                    this.selectorthread.join(i2);
                }
            }
        }
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress) {
        this(inetSocketAddress, DECODERS, null);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(webSocket, byteBuffer);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i2) {
        this(inetSocketAddress, i2, null);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, List<Draft> list) {
        this(inetSocketAddress, DECODERS, list);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i2, List<Draft> list) {
        this(inetSocketAddress, i2, list, new HashSet());
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i2, List<Draft> list, Collection<WebSocket> collection) {
        this.isclosed = new AtomicBoolean(false);
        this.queueinvokes = 0;
        this.queuesize = new AtomicInteger(0);
        this.wsf = new DefaultWebSocketServerFactory();
        if (inetSocketAddress != null && i2 >= 1 && collection != null) {
            if (list == null) {
                this.drafts = Collections.emptyList();
            } else {
                this.drafts = list;
            }
            this.address = inetSocketAddress;
            this.connections = collection;
            this.iqueue = new LinkedList();
            this.decoders = new ArrayList(i2);
            this.buffers = new LinkedBlockingQueue();
            for (int i3 = 0; i3 < i2; i3++) {
                WebSocketWorker webSocketWorker = new WebSocketWorker();
                this.decoders.add(webSocketWorker);
                webSocketWorker.start();
            }
            return;
        }
        throw new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
    }

    public void stop() throws IOException, InterruptedException {
        stop(0);
    }
}
