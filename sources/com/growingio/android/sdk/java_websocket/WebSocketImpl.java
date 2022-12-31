package com.growingio.android.sdk.java_websocket;

import com.growingio.android.sdk.base.event.SocketStatusEvent;
import com.growingio.android.sdk.java_websocket.WebSocket;
import com.growingio.android.sdk.java_websocket.drafts.Draft;
import com.growingio.android.sdk.java_websocket.drafts.Draft_10;
import com.growingio.android.sdk.java_websocket.drafts.Draft_17;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.growingio.android.sdk.java_websocket.drafts.Draft_76;
import com.growingio.android.sdk.java_websocket.exceptions.IncompleteHandshakeException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidDataException;
import com.growingio.android.sdk.java_websocket.exceptions.InvalidHandshakeException;
import com.growingio.android.sdk.java_websocket.exceptions.WebsocketNotConnectedException;
import com.growingio.android.sdk.java_websocket.framing.CloseFrame;
import com.growingio.android.sdk.java_websocket.framing.CloseFrameBuilder;
import com.growingio.android.sdk.java_websocket.framing.Framedata;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshake;
import com.growingio.android.sdk.java_websocket.handshake.ClientHandshakeBuilder;
import com.growingio.android.sdk.java_websocket.handshake.Handshakedata;
import com.growingio.android.sdk.java_websocket.server.WebSocketServer;
import com.growingio.android.sdk.java_websocket.util.Charsetfunctions;
import com.growingio.eventcenter.EventCenter;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class WebSocketImpl implements WebSocket {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static boolean DEBUG = false;
    public static int RCVBUF = 16384;
    public static final List<Draft> defaultdraftlist;
    public ByteChannel channel;
    private Integer closecode;
    private Boolean closedremotely;
    private String closemessage;
    private Framedata.Opcode current_continuous_frame_opcode;
    private Draft draft;
    private volatile boolean flushandclosestate;
    private ClientHandshake handshakerequest;
    public final BlockingQueue<ByteBuffer> inQueue;
    public SelectionKey key;
    private List<Draft> knownDrafts;
    public final BlockingQueue<ByteBuffer> outQueue;
    private WebSocket.READYSTATE readystate;
    private String resourceDescriptor;
    private WebSocket.Role role;
    private ByteBuffer tmpHandshakeBytes;
    public volatile WebSocketServer.WebSocketWorker workerThread;
    private final WebSocketListener wsl;

    static {
        ArrayList arrayList = new ArrayList(4);
        defaultdraftlist = arrayList;
        arrayList.add(new Draft_17());
        arrayList.add(new Draft_10());
        arrayList.add(new Draft_76());
        arrayList.add(new Draft_75());
    }

    public WebSocketImpl(WebSocketListener webSocketListener, List<Draft> list) {
        this(webSocketListener, (Draft) null);
        this.role = WebSocket.Role.SERVER;
        if (list != null && !list.isEmpty()) {
            this.knownDrafts = list;
        } else {
            this.knownDrafts = defaultdraftlist;
        }
    }

    private void close(int i2, String str, boolean z) {
        WebSocket.READYSTATE readystate = this.readystate;
        WebSocket.READYSTATE readystate2 = WebSocket.READYSTATE.CLOSING;
        if (readystate == readystate2 || readystate == WebSocket.READYSTATE.CLOSED) {
            return;
        }
        if (readystate == WebSocket.READYSTATE.OPEN) {
            if (i2 == 1006) {
                this.readystate = readystate2;
                flushAndClose(i2, str, false);
                return;
            }
            if (this.draft.getCloseHandshakeType() != Draft.CloseHandshakeType.NONE) {
                try {
                    if (!z) {
                        try {
                            this.wsl.onWebsocketCloseInitiated(this, i2, str);
                        } catch (RuntimeException e2) {
                            this.wsl.onWebsocketError(this, e2);
                        }
                    }
                    sendFrame(new CloseFrameBuilder(i2, str));
                } catch (InvalidDataException e3) {
                    this.wsl.onWebsocketError(this, e3);
                    flushAndClose(1006, "generated frame is invalid", false);
                }
            }
            flushAndClose(i2, str, z);
        } else if (i2 == -3) {
            flushAndClose(-3, str, true);
        } else {
            flushAndClose(-1, str, false);
        }
        if (i2 == 1002) {
            flushAndClose(i2, str, z);
        }
        this.readystate = WebSocket.READYSTATE.CLOSING;
        this.tmpHandshakeBytes = null;
    }

    private void decodeFrames(ByteBuffer byteBuffer) {
        try {
        } catch (InvalidDataException e2) {
            this.wsl.onWebsocketError(this, e2);
            close(e2);
            return;
        }
        for (Framedata framedata : this.draft.translateFrame(byteBuffer)) {
            if (DEBUG) {
                PrintStream printStream = System.out;
                printStream.println("matched frame: " + framedata);
            }
            Framedata.Opcode opcode = framedata.getOpcode();
            boolean isFin = framedata.isFin();
            if (opcode == Framedata.Opcode.CLOSING) {
                int i2 = CloseFrame.NOCODE;
                String str = "";
                if (framedata instanceof CloseFrame) {
                    CloseFrame closeFrame = (CloseFrame) framedata;
                    i2 = closeFrame.getCloseCode();
                    str = closeFrame.getMessage();
                }
                if (this.readystate == WebSocket.READYSTATE.CLOSING) {
                    closeConnection(i2, str, true);
                } else if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.TWOWAY) {
                    close(i2, str, true);
                } else {
                    flushAndClose(i2, str, false);
                }
            } else if (opcode == Framedata.Opcode.PING) {
                this.wsl.onWebsocketPing(this, framedata);
            } else if (opcode == Framedata.Opcode.PONG) {
                this.wsl.onWebsocketPong(this, framedata);
            } else {
                if (isFin && opcode != Framedata.Opcode.CONTINUOUS) {
                    if (this.current_continuous_frame_opcode == null) {
                        if (opcode == Framedata.Opcode.TEXT) {
                            try {
                                this.wsl.onWebsocketMessage(this, Charsetfunctions.stringUtf8(framedata.getPayloadData()));
                            } catch (RuntimeException e3) {
                                this.wsl.onWebsocketError(this, e3);
                            }
                        } else if (opcode == Framedata.Opcode.BINARY) {
                            try {
                                this.wsl.onWebsocketMessage(this, framedata.getPayloadData());
                            } catch (RuntimeException e4) {
                                this.wsl.onWebsocketError(this, e4);
                            }
                        } else {
                            throw new InvalidDataException(1002, "non control or continious frame expected");
                        }
                        this.wsl.onWebsocketError(this, e2);
                        close(e2);
                        return;
                    }
                    throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
                }
                if (opcode != Framedata.Opcode.CONTINUOUS) {
                    if (this.current_continuous_frame_opcode == null) {
                        this.current_continuous_frame_opcode = opcode;
                    } else {
                        throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                    }
                } else if (isFin) {
                    if (this.current_continuous_frame_opcode != null) {
                        this.current_continuous_frame_opcode = null;
                    } else {
                        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                    }
                } else if (this.current_continuous_frame_opcode == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                try {
                    this.wsl.onWebsocketMessageFragment(this, framedata);
                } catch (RuntimeException e5) {
                    this.wsl.onWebsocketError(this, e5);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean decodeHandshake(java.nio.ByteBuffer r12) {
        /*
            Method dump skipped, instructions count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.growingio.android.sdk.java_websocket.WebSocketImpl.decodeHandshake(java.nio.ByteBuffer):boolean");
    }

    private Draft.HandshakeState isFlashEdgeCase(ByteBuffer byteBuffer) throws IncompleteHandshakeException {
        byteBuffer.mark();
        int limit = byteBuffer.limit();
        byte[] bArr = Draft.FLASH_POLICY_REQUEST;
        if (limit > bArr.length) {
            return Draft.HandshakeState.NOT_MATCHED;
        }
        if (byteBuffer.limit() >= bArr.length) {
            int i2 = 0;
            while (byteBuffer.hasRemaining()) {
                if (Draft.FLASH_POLICY_REQUEST[i2] != byteBuffer.get()) {
                    byteBuffer.reset();
                    return Draft.HandshakeState.NOT_MATCHED;
                }
                i2++;
            }
            return Draft.HandshakeState.MATCHED;
        }
        throw new IncompleteHandshakeException(bArr.length);
    }

    private void open(Handshakedata handshakedata) {
        if (DEBUG) {
            PrintStream printStream = System.out;
            printStream.println("open using draft: " + this.draft.getClass().getSimpleName());
        }
        this.readystate = WebSocket.READYSTATE.OPEN;
        try {
            this.wsl.onWebsocketOpen(this, handshakedata);
        } catch (RuntimeException e2) {
            this.wsl.onWebsocketError(this, e2);
        }
    }

    private void write(ByteBuffer byteBuffer) {
        if (DEBUG) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("write(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
            sb.append("}");
            printStream.println(sb.toString());
        }
        this.outQueue.add(byteBuffer);
        this.wsl.onWriteDemand(this);
    }

    protected synchronized void closeConnection(int i2, String str, boolean z) {
        if (this.readystate == WebSocket.READYSTATE.CLOSED) {
            return;
        }
        SelectionKey selectionKey = this.key;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        ByteChannel byteChannel = this.channel;
        if (byteChannel != null) {
            try {
                byteChannel.close();
            } catch (IOException e2) {
                this.wsl.onWebsocketError(this, e2);
            }
        }
        try {
            this.wsl.onWebsocketClose(this, i2, str, z);
        } catch (RuntimeException e3) {
            this.wsl.onWebsocketError(this, e3);
        }
        Draft draft = this.draft;
        if (draft != null) {
            draft.reset();
        }
        this.handshakerequest = null;
        this.readystate = WebSocket.READYSTATE.CLOSED;
        this.outQueue.clear();
    }

    public void decode(ByteBuffer byteBuffer) {
        if (DEBUG) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("process(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
            sb.append("}");
            printStream.println(sb.toString());
        }
        if (this.readystate != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            decodeFrames(byteBuffer);
        } else if (decodeHandshake(byteBuffer)) {
            if (byteBuffer.hasRemaining()) {
                decodeFrames(byteBuffer);
            } else if (this.tmpHandshakeBytes.hasRemaining()) {
                decodeFrames(this.tmpHandshakeBytes);
            }
        }
    }

    public void eot() {
        if (getReadyState() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            closeConnection(-1, true);
        } else if (this.flushandclosestate) {
            closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
        } else if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.NONE) {
            closeConnection(1000, true);
        } else if (this.draft.getCloseHandshakeType() == Draft.CloseHandshakeType.ONEWAY) {
            if (this.role == WebSocket.Role.SERVER) {
                closeConnection(1006, true);
            } else {
                closeConnection(1000, true);
            }
        } else {
            closeConnection(1006, true);
        }
    }

    protected synchronized void flushAndClose(int i2, String str, boolean z) {
        if (this.flushandclosestate) {
            return;
        }
        this.closecode = Integer.valueOf(i2);
        this.closemessage = str;
        this.closedremotely = Boolean.valueOf(z);
        this.flushandclosestate = true;
        this.wsl.onWriteDemand(this);
        try {
            this.wsl.onWebsocketClosing(this, i2, str, z);
        } catch (RuntimeException e2) {
            this.wsl.onWebsocketError(this, e2);
        }
        Draft draft = this.draft;
        if (draft != null) {
            draft.reset();
        }
        this.handshakerequest = null;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public Draft getDraft() {
        return this.draft;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.wsl.getLocalSocketAddress(this);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public WebSocket.READYSTATE getReadyState() {
        return this.readystate;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.wsl.getRemoteSocketAddress(this);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public String getResourceDescriptor() {
        return this.resourceDescriptor;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean hasBufferedData() {
        return !this.outQueue.isEmpty();
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean isClosed() {
        return this.readystate == WebSocket.READYSTATE.CLOSED;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean isClosing() {
        return this.readystate == WebSocket.READYSTATE.CLOSING;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean isConnecting() {
        return this.readystate == WebSocket.READYSTATE.CONNECTING;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean isFlushAndClose() {
        return this.flushandclosestate;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public boolean isOpen() {
        return this.readystate == WebSocket.READYSTATE.OPEN;
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void send(String str) throws WebsocketNotConnectedException {
        if (str == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        send(this.draft.createFrames(str, this.role == WebSocket.Role.CLIENT));
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        send(this.draft.continuousFrame(opcode, byteBuffer, z));
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        if (DEBUG) {
            PrintStream printStream = System.out;
            printStream.println("send frame: " + framedata);
        }
        write(this.draft.createBinaryFrame(framedata));
    }

    public void startHandshake(ClientHandshakeBuilder clientHandshakeBuilder) throws InvalidHandshakeException {
        this.handshakerequest = this.draft.postProcessHandshakeRequestAsClient(clientHandshakeBuilder);
        this.resourceDescriptor = clientHandshakeBuilder.getResourceDescriptor();
        try {
            this.wsl.onWebsocketHandshakeSentAsClient(this, this.handshakerequest);
            write(this.draft.createHandshake(this.handshakerequest, this.role));
        } catch (InvalidDataException unused) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        } catch (RuntimeException e2) {
            this.wsl.onWebsocketError(this, e2);
            throw new InvalidHandshakeException("rejected because of" + e2);
        }
    }

    public String toString() {
        return super.toString();
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        send(this.draft.createFrames(byteBuffer, this.role == WebSocket.Role.CLIENT));
    }

    private void write(List<ByteBuffer> list) {
        for (ByteBuffer byteBuffer : list) {
            write(byteBuffer);
        }
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void send(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        send(ByteBuffer.wrap(bArr));
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft) {
        this.flushandclosestate = false;
        this.readystate = WebSocket.READYSTATE.NOT_YET_CONNECTED;
        this.draft = null;
        this.current_continuous_frame_opcode = null;
        this.tmpHandshakeBytes = ByteBuffer.allocate(0);
        this.handshakerequest = null;
        this.closemessage = null;
        this.closecode = null;
        this.closedremotely = null;
        this.resourceDescriptor = null;
        if (webSocketListener != null && (draft != null || this.role != WebSocket.Role.SERVER)) {
            this.outQueue = new LinkedBlockingQueue();
            this.inQueue = new LinkedBlockingQueue();
            this.wsl = webSocketListener;
            this.role = WebSocket.Role.CLIENT;
            if (draft != null) {
                this.draft = draft.copyInstance();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    private void send(Collection<Framedata> collection) {
        if (!isOpen()) {
            EventCenter.getInstance().post(SocketStatusEvent.ofStatus(SocketStatusEvent.SocketStatus.ERROR));
        }
        for (Framedata framedata : collection) {
            sendFrame(framedata);
        }
    }

    protected void closeConnection(int i2, boolean z) {
        closeConnection(i2, "", z);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void close(int i2, String str) {
        close(i2, str, false);
    }

    public void closeConnection() {
        if (this.closedremotely != null) {
            closeConnection(this.closecode.intValue(), this.closemessage, this.closedremotely.booleanValue());
            return;
        }
        throw new IllegalStateException("this method must be used in conjuction with flushAndClose");
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void close(int i2) {
        close(i2, "", false);
    }

    public void close(InvalidDataException invalidDataException) {
        close(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void close() {
        close(1000);
    }

    @Override // com.growingio.android.sdk.java_websocket.WebSocket
    public void closeConnection(int i2, String str) {
        closeConnection(i2, str, false);
    }

    @Deprecated
    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft, Socket socket) {
        this(webSocketListener, draft);
    }

    @Deprecated
    public WebSocketImpl(WebSocketListener webSocketListener, List<Draft> list, Socket socket) {
        this(webSocketListener, list);
    }
}
