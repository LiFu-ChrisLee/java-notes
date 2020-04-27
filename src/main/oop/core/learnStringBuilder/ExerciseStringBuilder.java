package core.learnStringBuilder;

/**
 * @author LiFu
 * @date 2020/4/24 上午10:36
 * @description 使用StringBuilder构造一个INSERT语句
 */
public class ExerciseStringBuilder {
    public static void main(String[] args) {
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String insert = buildInsertSql(table, fields);
        System.out.println(insert);
        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");
    }

    static String buildInsertSql(String table, String[] fields) {
        return "INSERT INTO " + table + " (" + String.join(", ", fields) + ") VALUES " + buildInsertFields(fields);
    }

    static String buildInsertFields(String[] fields) {
        StringBuilder sb = new StringBuilder("(");
        String f = "?";
        for (int i = 0; i < fields.length; i++) {
            sb.append(f);
            if (i != fields.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
