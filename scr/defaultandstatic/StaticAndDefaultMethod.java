package scr.defaultandstatic;

import java.util.ArrayList;
import java.util.List;

public class StaticAndDefaultMethod {

    public static void main(String[] args) {
        List<String> listEvent = DSC.showEventList();
        //1. Demo static method
        System.out.println("List of events: ");
        listEvent.forEach(System.out::println);

        //2. Demo default method, open 2 comment below <- nhớ xóa "open 2 comment below"
        //3. Chạy xong 2, thì xuống class BackendBranch mở cái Override ra, chạy lại main
        //4. Xuống class interface để test override static method.
        BackEndBranch manager = new BackEndBranch();
//        System.out.println("List of member: ");
//        manager.showMemberList();
    }
}

@FunctionalInterface
interface DSC{
    abstract List<Member> getMember();

    //Need to have body, because of non-overriding
    static List<String> showEventList(){
        return EventData.getListEvent();
    };

    default void showMemberList(){
        MemberData.getListMember().forEach(System.out::println);
    };

}

class BackEndBranch implements DSC{
    @Override
    public List<Member> getMember() {
        return null;
    }

//    @Override
//    public void showMemberList() {
//        List<Member> list = MemberData.getListMember();
//        list.forEach(e -> System.out.println("Tên thành viên: " +  e.getName()));
//    }

    //4. Thử nghiệm với việc override static method
    
}
class EventData{
    static List<String> listEvent;

    private static List<String> prepareListEvent(){
        if(listEvent == null)
            listEvent = new ArrayList<>();

        listEvent.add("Stream API part 1");
        listEvent.add("Docker");
        listEvent.add("Object Detection");
        listEvent.add("Introduction to Competitive programming");

        return listEvent;
    }
    public static List<String> getListEvent(){
        return prepareListEvent();
    }
}
class MemberData{
    static List<Member> listMember;

    private static List<Member> prepareListMember(){
        if(listMember == null)
            listMember = new ArrayList<>();

        listMember.add(new Member("Nguyễn M", 2002));
        listMember.add(new Member("Trần A", 2002));
        listMember.add(new Member("Bùi K", 2000));
        listMember.add(new Member("Trần T", 2000));
        listMember.add(new Member("Huỳnh B", 2000));
        listMember.add(new Member("Lê P", 2001));
        listMember.add(new Member("Phạm D", 2001));
        listMember.add(new Member("Nguyễn D", 2000));
        listMember.add(new Member("Nguyễn T", 2000));
        return listMember;
    }
    public static List<Member> getListMember(){
        return prepareListMember();
    }
}
class Member{
    private String name;
    private int yOb;

    public Member() {
    }

    public Member(String name, int yOb) {
        this.name = name;
        this.yOb = yOb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getyOb() {
        return yOb;
    }

    public void setyOb(int yOb) {
        this.yOb = yOb;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", yOb: " + yOb ;
    }
}