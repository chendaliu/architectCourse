package pers.czl.architect.designpattern.chainOfResponsibility;

/**
 * 责任链模式 <br/>
 * 应用场景：一个请求需要多个对象协作处理。 <br/>
 * 优点: <br/>
 *  1.请求的发送者和接受者解耦 <br/>
 *  2.可以控制执行顺序 <br/>
 *  3.符合开闭原则和单一职责原则 <br/>
 */
public class ChainOfResponsibility {
    /**
     * 场景：用户登录系统需要经过请求频率、登录认证、访问权限的过滤
     * 责任链：
     * 请求频率 -> 登录认证 -> 访问权限
     * @param args
     */
    public static void main(String[] args) {
        //可更改true/false测试
        Request request = new Request.RequestBuilder().frequencyOk(true).loggedOn(false).accessPermission(true).build();
        RequestFrequencyHandler requestFrequencyHandler = new RequestFrequencyHandler(new LoggingHandler(new AccessPermissionHandler(null)));
        requestFrequencyHandler.process(request);

    }
}

class Request {
    private boolean frequencyOk;
    private boolean loggedOn;
    private boolean accessPermission;

    public Request(boolean frequencyOk, boolean loggedOn, boolean accessPermission) {
        this.frequencyOk = frequencyOk;
        this.loggedOn = loggedOn;
        this.accessPermission = accessPermission;
    }

    public boolean isFrequencyOk() {
        return frequencyOk;
    }

    public void setFrequencyOk(boolean frequencyOk) {
        this.frequencyOk = frequencyOk;
    }

    public boolean isLoggedOn() {
        return loggedOn;
    }

    public void setLoggedOn(boolean loggedOn) {
        this.loggedOn = loggedOn;
    }

    public boolean isAccessPermission() {
        return accessPermission;
    }

    public void setAccessPermission(boolean accessPermission) {
        this.accessPermission = accessPermission;
    }

    static class RequestBuilder {
        private boolean frequencyOk;
        private boolean loggedOn;
        private boolean accessPermission;

        RequestBuilder frequencyOk(boolean frequencyOk) {
            this.frequencyOk = frequencyOk;
            return this;
        }
        RequestBuilder loggedOn(boolean loggedOn) {
            this.loggedOn = loggedOn;
            return this;
        }
        RequestBuilder accessPermission(boolean accessPermission) {
            this.accessPermission = accessPermission;
            return this;
        }
        public Request build() {
            Request request = new Request(frequencyOk, loggedOn, accessPermission);
            return request;
        }
    }
}

abstract class Handler {
    Handler next;

    public Handler(Handler next) {
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract boolean process(Request request);
}

/**
 * 频率控制
 */
class RequestFrequencyHandler extends Handler {

    public RequestFrequencyHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        if (request.isFrequencyOk()) {
            System.out.println("访问频率控制通过");
            Handler next = getNext();
            if (null == next) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        System.out.println("访问频率控制不通过");
        return false;
    }
}

class LoggingHandler extends Handler {

    public LoggingHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        if (request.isLoggedOn()) {
            System.out.println("登录认证控制通过");
            Handler next = getNext();
            if (null == next) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        System.out.println("登录认证控制不通过");
        return false;
    }
}

class AccessPermissionHandler extends Handler {

    public AccessPermissionHandler(Handler next) {
        super(next);
    }

    @Override
    boolean process(Request request) {
        if (request.isAccessPermission()) {
            System.out.println("访问权限控制通过");
            Handler next = getNext();
            if (null == next) {
                return true;
            }
            if (!next.process(request)) {
                return false;
            } else {
                return true;
            }
        }
        System.out.println("访问权限控制不通过");
        return false;
    }
}