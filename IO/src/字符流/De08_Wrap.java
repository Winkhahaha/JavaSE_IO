package 字符流;

public class De08_Wrap {
    public static void main(String args[]) {
            /*
             装饰设计模式
             好处:
             耦合性不强,被装饰的类的变化与装饰类的变化无关
             */
        NBStudent nbStudent = new NBStudent(new Student());
        nbStudent.code();
    }
}

interface Coder {
    public void code();
}

class Student implements Coder {

    @Override
    public void code() {
        System.out.println("javase");
        System.out.println("javaweb");
    }
}

class NBStudent implements Coder {
    // 获取被装饰类的引用
    private Student student;    // 拿到学生对象

    public NBStudent(Student student) {  // 构造方法中传入被装饰类的对象
        this.student = student;
    }

    @Override
    public void code() {
        student.code();
        // 对原有功能进行升级
        System.out.println("数据库");
        System.out.println("SSM");
        System.out.println("...");

    }
}
