package behavioral.learnState;

import java.util.Scanner;

/**
 * @author LiFu
 * @date 2020/5/28 下午2:17
 * @description learn state
 */
public class LearnState {
    public static void main(String[] args) {
        // 允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类。

        Scanner scanner = new Scanner(System.in);
        BotContext bot = new BotContext();
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equals("-1")) {
                break;
            }
            String output = bot.chat(input);
            System.out.println(output.isEmpty() ? "(no reply)" : "< " + output);
        }
    }
}

// 逻辑给分拆到不同的状态类中，使得将来增加状态比较容易
interface State {
    String init();

    String reply(String input);
}

// 未连线状态，我们收到消息也不回复
class DisconnectedState implements State {
    @Override
    public String init() {
        return "Bye!";
    }

    @Override
    public String reply(String input) {
        return "";
    }
}

// 已连线状态，我们回应收到的消息
class ConnectedState implements State {
    @Override
    public String init() {
        return "Hello, I'm Bob.";
    }

    @Override
    public String reply(String input) {
        if (input.endsWith("?")) {
            return "Yes. " + input.substring(0, input.length() - 1) + "!";
        }
        if (input.endsWith(".")) {
            return input.substring(0, input.length() - 1) + "!";
        }
        return input.substring(0, input.length() - 1) + "?";
    }
}

// 状态模式的关键设计思想在于状态切换，我们引入一个BotContext完成状态切换
class BotContext {
    private State state = new DisconnectedState();

    public String chat(String input) {
        if ("hello".equalsIgnoreCase(input)) {
            // 收到hello切换到在线状态:
            state = new ConnectedState();
            return state.init();
        } else if ("bye".equalsIgnoreCase(input)) {
            // 收到bye切换到离线状态:
            state = new DisconnectedState();
            return state.init();
        }
        return state.reply(input);
    }
}
