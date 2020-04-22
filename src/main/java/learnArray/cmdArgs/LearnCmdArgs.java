package learnArray.cmdArgs;

/**
 * @author LiFu
 * @date 2020/4/22 下午2:13
 * @description learn command arguments
 */
public class LearnCmdArgs {
    public static void main(String[] args) {
        // 命令行参数类型是String[]数组
        // 如何解析命令行参数需要由程序自己实现
        if (args != null) {
            for (String arg : args) {
                System.out.println(arg);
            }
        }
    }
}
