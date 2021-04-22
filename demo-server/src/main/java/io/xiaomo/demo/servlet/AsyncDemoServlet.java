package io.xiaomo.demo.servlet;

import io.xiaomo.demo.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.AsyncContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

@WebServlet(name="AsyncDemo",urlPatterns = "/myServlet",loadOnStartup = 1,asyncSupported = true)
public class AsyncDemoServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(AsyncDemoServlet.class);

    @Autowired
    private ConfigService configService;

    private ExecutorService executorService = Executors.newCachedThreadPool(new ThreadFactory(){

        private AtomicLong i = new AtomicLong(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"executor-"+i.getAndIncrement());
        }
    });

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log.info("init");
    }

    @Override
    public void destroy() {
        super.destroy();

        this.executorService.shutdown();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("doGet");

        resp.setContentType("text/json; charset=utf-8");
        resp.setHeader("Cache-Control","private");
        resp.setHeader("Paragma","no-cache");
        //final PrintWriter writer = resp.getWriter();
        //writer.println("老板检查当前需要做的工作");
        //writer.flush();

        final AsyncContext asyncContext = req.startAsync();
        //asyncContext.setTimeout(60000);
        //asyncContext.start(new AsyncDemoTask(asyncContext));

        if(this.configService.isOpen()){
            this.executorService.submit(new AsyncDemoTask(asyncContext));
        }else{

        }
    }
}
