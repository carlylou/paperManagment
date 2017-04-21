package com.paper.management.filter;

/**
 * Created by liumengyao on 17/4/21.
 */
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import javax.servlet.ReadListener;
import org.apache.commons.io.IOUtils;

public class ResettableRequestWrapper extends HttpServletRequestWrapper {
    private byte[] bytes;
    Map<String, String[]> parameterMap = super.getParameterMap();

    public ResettableRequestWrapper(HttpServletRequest request) {
        super(request);

        try {
            this.bytes = IOUtils.toByteArray(request.getInputStream());
        } catch (IOException var3) {
            ;
        }

    }

    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.bytes);
        ServletInputStream servletInputStream = new ServletInputStream() {
            public boolean isFinished() {
                return byteArrayInputStream.available() > 0;
            }

            public boolean isReady() {
                return false;
            }

            public void setReadListener(ReadListener readListener) {
            }

            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
        return servletInputStream;
    }

    public String[] getParameterValues(String name) {
        return this.parameterMap != null?(String[])this.parameterMap.get(name):null;
    }

    public String getBody() {
        return new String(this.bytes, Charset.forName("utf-8"));
    }
}

