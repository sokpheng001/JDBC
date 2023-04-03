package model;
public record Istad_Teacher(String teacher_name, Integer teacher_age, Integer teacher_id){ };

//public class Istad_Teacher{
//    private final String teacher_name;
//    private final String teacher_age;
//    private final String teacher_id;
//
//    public Istad_Teacher(String teacher_name, String teacher_age, String teacher_id) {
//        this.teacher_name = teacher_name;
//        this.teacher_age = teacher_age;
//        this.teacher_id = teacher_id;
//    }
//
//    public String getTeacher_name() {
//        return teacher_name;
//    }
//
//    public String getTeacher_age() {
//        return teacher_age;
//    }
//
//    public String getTeacher_id() {
//        return teacher_id;
//    }
//
//    @Override
//    public String toString() {
//        return "Istad_Teacher{" +
//                "teacher_name='" + teacher_name + '\'' +
//                ", teacher_age='" + teacher_age + '\'' +
//                ", teacher_id='" + teacher_id + '\'' +
//                '}';
//    }
//}