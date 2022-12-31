package com.growingio.android.sdk.monitor.dsn;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class Dsn {
    private String host;
    private Map<String, String> options;
    private String path;
    private int port;
    private String projectId;
    private String protocol;
    private Set<String> protocolSettings;
    private String publicKey;
    private String secretKey;
    private URI uri;

    public Dsn(String str) throws InvalidDsnException {
        this(URI.create(str));
    }

    private void extractHostInfo(URI uri) {
        this.host = uri.getHost();
        this.port = uri.getPort();
    }

    private void extractOptions(URI uri) {
        String[] split;
        String query = uri.getQuery();
        if (query == null || query.isEmpty()) {
            return;
        }
        for (String str : query.split("&")) {
            try {
                String[] split2 = str.split("=");
                this.options.put(URLDecoder.decode(split2[0], "UTF-8"), split2.length > 1 ? URLDecoder.decode(split2[1], "UTF-8") : null);
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException("Impossible to decode the query parameter '" + str + "'", e2);
            }
        }
    }

    private void extractPathInfo(URI uri) {
        String path = uri.getPath();
        if (path == null) {
            return;
        }
        int lastIndexOf = path.lastIndexOf("/") + 1;
        this.path = path.substring(0, lastIndexOf);
        this.projectId = path.substring(lastIndexOf);
    }

    private void extractProtocolInfo(URI uri) {
        String scheme = uri.getScheme();
        if (scheme == null) {
            return;
        }
        String[] split = scheme.split("\\+");
        this.protocolSettings.addAll(Arrays.asList(split).subList(0, split.length - 1));
        this.protocol = split[split.length - 1];
    }

    private void extractUserKeys(URI uri) {
        String userInfo = uri.getUserInfo();
        if (userInfo == null) {
            return;
        }
        String[] split = userInfo.split(":");
        this.publicKey = split[0];
        if (split.length > 1) {
            this.secretKey = split[1];
        }
    }

    private void makeOptionsImmutable() {
        this.options = Collections.unmodifiableMap(this.options);
        this.protocolSettings = Collections.unmodifiableSet(this.protocolSettings);
    }

    private void validate() {
        LinkedList linkedList = new LinkedList();
        if (this.host == null) {
            linkedList.add("host");
        }
        String str = this.protocol;
        if (str != null && !str.equalsIgnoreCase("noop") && !this.protocol.equalsIgnoreCase("out")) {
            if (this.publicKey == null) {
                linkedList.add("public key");
            }
            String str2 = this.projectId;
            if (str2 == null || str2.isEmpty()) {
                linkedList.add("project ID");
            }
        }
        if (linkedList.isEmpty()) {
            return;
        }
        throw new InvalidDsnException("Invalid DSN, the following properties aren't set '" + linkedList + "'");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Dsn dsn = (Dsn) obj;
        if (this.port == dsn.port && this.host.equals(dsn.host) && this.options.equals(dsn.options) && this.path.equals(dsn.path) && this.projectId.equals(dsn.projectId)) {
            String str = this.protocol;
            if (str == null ? dsn.protocol == null : str.equals(dsn.protocol)) {
                return this.protocolSettings.equals(dsn.protocolSettings) && this.publicKey.equals(dsn.publicKey) && this.secretKey.equals(dsn.secretKey);
            }
            return false;
        }
        return false;
    }

    public String getHost() {
        return this.host;
    }

    public Map<String, String> getOptions() {
        return this.options;
    }

    public String getPath() {
        return this.path;
    }

    public int getPort() {
        return this.port;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public Set<String> getProtocolSettings() {
        return this.protocolSettings;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public URI getUri() {
        return this.uri;
    }

    public int hashCode() {
        return (((((((this.publicKey.hashCode() * 31) + this.projectId.hashCode()) * 31) + this.host.hashCode()) * 31) + this.port) * 31) + this.path.hashCode();
    }

    public String toString() {
        return "Dsn{uri=" + this.uri + '}';
    }

    public Dsn(URI uri) throws InvalidDsnException {
        if (uri != null) {
            this.options = new HashMap();
            this.protocolSettings = new HashSet();
            extractProtocolInfo(uri);
            extractUserKeys(uri);
            extractHostInfo(uri);
            extractPathInfo(uri);
            extractOptions(uri);
            makeOptionsImmutable();
            validate();
            try {
                this.uri = new URI(this.protocol, null, this.host, this.port, this.path, null, null);
                return;
            } catch (URISyntaxException e2) {
                throw new InvalidDsnException("Impossible to determine Monitor's URI from the DSN '" + uri + "'", e2);
            }
        }
        throw new InvalidDsnException("DSN constructed with null value!");
    }
}
