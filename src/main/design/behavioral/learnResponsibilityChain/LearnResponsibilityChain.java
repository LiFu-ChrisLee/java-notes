package behavioral.learnResponsibilityChain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiFu
 * @date 2020/5/27 下午5:28
 * @description learn Chain of Responsibility
 */
public class LearnResponsibilityChain {
    public static void main(String[] args) {
        // 使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。

        // 构造责任链:
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());
        // 处理请求:
        chain.process(new Request("Bob", new BigDecimal("123.45")));
        chain.process(new Request("Alice", new BigDecimal("1234.56")));
        chain.process(new Request("Bill", new BigDecimal("12345.67")));
        chain.process(new Request("John", new BigDecimal("123456.78")));
    }
}

// 抽象出请求对象，它将在责任链上传递
class Request {
    private final String name;
    private final BigDecimal amount;

    public Request(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

// 抽象出处理器
interface Handler {
    // 返回Boolean.TRUE = 成功
    // 返回Boolean.FALSE = 拒绝
    // 返回null = 交下一个处理
    Boolean process(Request request);
}

// 依次编写ManagerHandler、DirectorHandler和CEOHandler
class ManagerHandler implements Handler {
    public Boolean process(Request request) {
        // 如果超过1000元，处理不了，交下一个处理:
        if (request.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
            return null;
        }
        // 对Bob有偏见:
        return !request.getName().equalsIgnoreCase("bob");
    }
}

class DirectorHandler implements Handler {
    public Boolean process(Request request) {
        // 如果超过10000元，处理不了，交下一个处理:
        if (request.getAmount().compareTo(BigDecimal.valueOf(10000)) > 0) {
            return null;
        }
        // 对Alice有偏见:
        return !request.getName().equalsIgnoreCase("alice");
    }
}

class CEOHandler implements Handler {
    public Boolean process(Request request) {
        // 对Chris有偏见:
        return !request.getName().equalsIgnoreCase("chris");
    }
}

// 把这些Handler组合起来，变成一个链，并通过一个统一入口处理
class HandlerChain {
    // 持有所有Handler:
    private final List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        this.handlers.add(handler);
    }

    public boolean process(Request request) {
        // 依次调用每个Handler:
        for (Handler handler : this.handlers) {
            Boolean r = handler.process(request);
            if (r != null) {
                // 如果返回TRUE或FALSE，处理结束:
                System.out.println(request + " " + (r ? "Approved by " : "Denied by ") + handler.getClass().getSimpleName());
                return r;
            }
        }
        throw new RuntimeException("Could not handle request: " + request);
    }
}

// 通过某个Handler手动调用下一个Handler来传递Request
// class AHandler implements Handler {
//     private Handler next;
//     public void process(Request request) {
//         if (!canProcess(request)) {
//             // 手动交给下一个Handler处理:
//             next.process(request);
//         } else {
//             ...
//         }
//     }
// }

// 一些责任链模式，每个Handler都有机会处理Request，通常这种责任链被称为拦截器（Interceptor）或者过滤器（Filter）
// class AuditFilter implements Filter {
//     public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
//         log(req);
//         if (check(req)) {
//             // 放行:
//             chain.doFilter(req, resp);
//         } else {
//             // 拒绝:
//             sendError(resp);
//         }
//     }
// }
