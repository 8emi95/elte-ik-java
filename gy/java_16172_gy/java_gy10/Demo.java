public class Demo {
    public static void main(String[] args) {
        List<Integer> ns = new ArrayList<>();
        ns.add(0);
        ns.add(9);
        ns.add(4);
        System.out.println(GenericMax.max(ns));
        
        List<String> ss = new ArrayList<>();
        ss.add("alma");
        ss.add("körte");
        ss.add("almafa");
        System.out.println(GenericMax.max(ss));

        UniqueList<String> uints = new ArrayList<>();
        try {
            uints.uniqueAdd(2);
            uints.uniqueAdd(4);
            uints.uniqueAdd(2);
        } catch (AlreadyContainsException e) { // első: legspecifikusabb kivétel
            System.out.println("Oops. " + e.getMessage());
        } catch (Exception e) { // majd: általánosabb kivétel
            System.out.println("Nagy baj van.");            
        }
    }
}