package com.wenyu7980.basic.config.log;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * 分支响应wrapper
 * @author wenyu
 * @date 2020-01-29 
 */
public class BodyDuplicateResponseWrapper extends HttpServletResponseWrapper {
    private final OutputStream outputStream;

    /**
     *
     * @param response response
     * @param duplicate 分支OutputStream
     */
    public BodyDuplicateResponseWrapper(HttpServletResponse response,
            OutputStream duplicate) {
        super(response);
        this.outputStream = duplicate;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(this.getOutputStream());
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream() {
            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setWriteListener(WriteListener listener) {
            }

            @Override
            public void write(int b) throws IOException {
                // 写入到原有response的OutputStream中
                BodyDuplicateResponseWrapper.this.getResponse()
                        .getOutputStream().write(b);
                // 写入到分支OutputStream中
                outputStream.write(b);
            }
        };
    }

}
