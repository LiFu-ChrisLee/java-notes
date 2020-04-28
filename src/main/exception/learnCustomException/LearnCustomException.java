package learnCustomException;

/**
 * @author LiFu
 * @date 2020/4/28 下午3:27
 * @description learn custom exception
 */
public class LearnCustomException {
    public static void main(String[] args) {

    }
}

//自定义异常体系时，推荐从RuntimeException派生“根异常”，再派生出业务异常
class BaseException extends RuntimeException {
    // 自定义异常时，应该提供多种构造方法
    public BaseException() {
        super();
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}

class UserNotFoundException extends BaseException {
}
