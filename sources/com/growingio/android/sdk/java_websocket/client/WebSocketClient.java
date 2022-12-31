package com.growingio.android.sdk.java_websocket.client;

import com.growingio.android.sdk.java_websocket.WebSocket;
import com.growingio.android.sdk.java_websocket.WebSocketAdapter;
import com.growingio.android.sdk.java_websocket.WebSocketImpl;
import com.growingio.android.sdk.java_websocket.drafts.Draft;
import com.growingio.android.sdk.java_websocket.drafts.Draft_17;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidHandshakeException;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import com.growingio.android.sdk.java_websocket.handshake.HandshakeImpl1Client;
import com.growingio.android.sdk.java_websocket.handshake.Handshakedata;
import com.growingio.android.sdk.java_websocket.handshake.ServerHandshake;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes2.dex */
public abstract class WebSocketClient extends WebSocketAdapter implements Runnable, WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private int connectTimeout;
    private Draft draft;
    private WebSocketImpl engine;
    private Map<String, String> headers;
    private InputStream istream;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    protected URI uri;
    private Thread writeThread;

    /* loaded from: classes2.dex */
    private class WebsocketWriteThread implements Runnable {
        private WebsocketWriteThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = WebSocketClient.this.engine.outQueue.take();
                    WebSocketClient.this.ostream.write(take.array(), 0, take.limit());
                    WebSocketClient.this.ostream.flush();
                } catch (IOException unused) {
                    WebSocketClient.this.engine.eot();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public WebSocketClient(URI uri) {
        this(uri, new Draft_17());
    }

    private int getPort() {
        int port = this.uri.getPort();
        if (port == -1) {
            String scheme = this.uri.getScheme();
            if (scheme.equals("wss")) {
                return WebSocket.DEFAULT_WSS_PORT;
            }
            if (scheme.equals("ws")) {
                return 80;
            }
            throw new RuntimeException("unkonow scheme" + scheme);
        }
        return port;
    }

    private void sendHandshake() throws InvalidHandshakeException {
        String path = this.uri.getPath();
        String query = this.uri.getQuery();
        path = (path == null || path.length() == 0) ? "/" : "/";
        if (query != null) {
            path = path + "?" + query;
        }
        int port = getPort();
        StringBuilder sb = new StringBuilder();
        sb.append(this.uri.getHost());
        sb.append(port != 80 ? ":" + port : "");
        String sb2 = sb.toString();
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.setResourceDescriptor(path);
        handshakeImpl1Client.put("Host", sb2);
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                handshakeImpl1Client.put(entry.getKey(), entry.getValue());
            }
        }
        this.engine.startHandshake(handshakeImpl1Client);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void close() {
        if (this.writeThread != null) {
            this.engine.close(1000);
        }
    }

    public void closeBlocking() throws InterruptedException {
        close();
        this.closeLatch.await();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void closeConnection(int i2, String str) {
        this.engine.closeConnection(i2, str);
    }

    public void connect() {
        if (this.writeThread == null) {
            Thread thread = new Thread(this);
            this.writeThread = thread;
            thread.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public boolean connectBlocking() throws InterruptedException {
        connect();
        this.connectLatch.await();
        return this.engine.isOpen();
    }

    public WebSocket getConnection() {
        return this.engine;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public Draft getDraft() {
        return this.draft;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public WebSocket.READYSTATE getReadyState() {
        return this.engine.getReadyState();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        Socket socket = this.socket;
        if (socket != null) {
            return (InetSocketAddress) socket.getRemoteSocketAddress();
        }
        return null;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public String getResourceDescriptor() {
        return this.uri.getPath();
    }

    public URI getURI() {
        return this.uri;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean hasBufferedData() {
        return this.engine.hasBufferedData();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean isClosed() {
        return this.engine.isClosed();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean isClosing() {
        return this.engine.isClosing();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean isConnecting() {
        return this.engine.isConnecting();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean isFlushAndClose() {
        return this.engine.isFlushAndClose();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean isOpen() {
        return this.engine.isOpen();
    }

    public abstract void onClose(int i2, String str, boolean z);

    public void onCloseInitiated(int i2, String str) {
    }

    public void onClosing(int i2, String str, boolean z) {
    }

    public abstract void onError(Exception exc);

    public void onFragment(Framedata framedata) {
    }

    public abstract void onMessage(String str);

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(ServerHandshake serverHandshake);

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i2, String str, boolean z) {
        this.connectLatch.countDown();
        this.closeLatch.countDown();
        Thread thread = this.writeThread;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            Socket socket = this.socket;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e2) {
            onWebsocketError(this, e2);
        }
        onClose(i2, str, z);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i2, String str) {
        onCloseInitiated(i2, str);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i2, String str, boolean z) {
        onClosing(i2, str, z);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(exc);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(str);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketAdapter, com.growingio.android.sdk.java_websocket.WebSocketListener
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
        onFragment(framedata);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        this.connectLatch.countDown();
        onOpen((ServerHandshake) handshakedata);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            Socket socket = this.socket;
            if (socket == null) {
                this.socket = new Socket(this.proxy);
            } else if (socket.isClosed()) {
                throw new IOException();
            }
            if (!this.socket.isBound()) {
                this.socket.connect(new InetSocketAddress(this.uri.getHost(), getPort()), this.connectTimeout);
            }
            this.istream = this.socket.getInputStream();
            this.ostream = this.socket.getOutputStream();
            sendHandshake();
            Thread thread = new Thread(new WebsocketWriteThread());
            this.writeThread = thread;
            thread.start();
            byte[] bArr = new byte[WebSocketImpl.RCVBUF];
            while (!isClosed() && (read = this.istream.read(bArr)) != -1) {
                try {
                    this.engine.decode(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException unused) {
                    this.engine.eot();
                    return;
                } catch (RuntimeException e2) {
                    onError(e2);
                    this.engine.closeConnection(1006, e2.getMessage());
                    return;
                }
            }
            this.engine.eot();
        } catch (Exception e3) {
            onWebsocketError(this.engine, e3);
            this.engine.closeConnection(-1, e3.getMessage());
        }
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void send(String str) throws NotYetConnectedException {
        this.engine.send(str);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        this.engine.sendFragmentedFrame(opcode, byteBuffer, z);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        this.engine.sendFrame(framedata);
    }

    public void setProxy(Proxy proxy) {
        if (proxy != null) {
            this.proxy = proxy;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setSocket(Socket socket) {
        if (this.socket == null) {
            this.socket = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    public WebSocketClient(URI uri, Draft draft) {
        this(uri, draft, null, 0);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void send(byte[] bArr) throws NotYetConnectedException {
        this.engine.send(bArr);
    }

    public WebSocketClient(URI uri, Draft draft, Map<String, String> map, int i2) {
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.proxy = Proxy.NO_PROXY;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.connectTimeout = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (draft != null) {
            this.uri = uri;
            this.draft = draft;
            this.headers = map;
            this.connectTimeout = i2;
            this.engine = new WebSocketImpl(this, draft);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void close(int i2) {
        this.engine.close();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.engine.getLocalSocketAddress();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.engine.getRemoteSocketAddress();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, NotYetConnectedException {
        this.engine.send(byteBuffer);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void close(int i2, String str) {
        this.engine.close(i2, str);
    }
}
