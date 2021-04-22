package io.xiaomo.demo.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class AsyncDemoTask implements  Runnable{

    private static final Logger log = LoggerFactory.getLogger(AsyncDemoTask.class);

    private final AsyncContext asyncContext;

    public AsyncDemoTask(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {

        HttpServletRequest httpServletRequest = (HttpServletRequest)this.asyncContext.getRequest();
        HttpServletResponse httpServletResponse = (HttpServletResponse)this.asyncContext.getResponse();
        try {
            PrintWriter pw = httpServletResponse.getWriter();
            for(int i = 0;i<10;i++){

                try {
                    TimeUnit.SECONDS.sleep(1);
                    log.debug(""+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            pw.println("{id:1,name:'weiguangyue'}");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.asyncContext.complete();
    }
}
